package com.imooc.miaosha.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring4.context.SpringWebContext;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.alibaba.druid.util.StringUtils;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.GoodsKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.service.UserService;
import com.imooc.miaosha.util.ValidatorUtil;
import com.imooc.miaosha.vo.GoodsVo;
import com.imooc.miaosha.vo.LoginVo;



/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月21日 上午11:23:01
*类说明：登录时的参数校验
*/
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	MiaoshaUserService userService;
	@Autowired
	RedisService redisService;
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	ThymeleafViewResolver thymeleafViewResolver;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@RequestMapping(value="/to_list",produces="text/html")
	@ResponseBody
	public String list(HttpServletRequest request,HttpServletResponse response,Model mode,MiaoshaUser user){
		mode.addAttribute("user", user);

		//取缓存
		String html = redisService.get(GoodsKey.getGoodsList, "", String.class);
		if(!StringUtils.isEmpty(html)) {
				return html;
				}
		
		//查询商品列表
		List<GoodsVo> goodsList = goodsService.listGoodsVo();
		mode.addAttribute("goodsList", goodsList);
		//return "goods_list";
		SpringWebContext ctx = new SpringWebContext(request, response, request.getServletContext(), request.getLocale(), mode.asMap(), applicationContext);
		
		//手动渲染
		html = thymeleafViewResolver.getTemplateEngine().process("goods_list", ctx);
		if(!StringUtils.isEmpty(html)) {
			redisService.set(GoodsKey.getGoodsList, "", html);
		}
		return html;
	}
	
	@RequestMapping(value="/to_detail/{goodsId}",produces="text/html")
	@ResponseBody
	public String detail(HttpServletRequest request,HttpServletResponse response,Model mode,MiaoshaUser user,
			@PathVariable("goodsId")long goodsId){//url级别的缓存用ID来区别
		//snowflake一个id的算法	
		mode.addAttribute("user", user);
		
		//取缓存
		String html = redisService.get(GoodsKey.getGoodsDetail, "", String.class);
		if(!StringUtils.isEmpty(html)) {
				 return html;
		}
		
		//手动渲染
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		mode.addAttribute("goodsId", goodsId);
		
		//取一个秒杀的开始时间，和一个结束时间
		long startAt = goods.getStartDate().getTime();
		long endAt = goods.getEndDate().getTime();
		long now = System.currentTimeMillis();
		
		int miaoshaStatus = 0;
		int remaimSeconds = 0;
		
		if(now < startAt) {//秒杀还没有开始，倒计时
			miaoshaStatus = 0;
			remaimSeconds = (int)(startAt-now)/1000;
		}else if(now > endAt) {//秒杀已经结束了
			miaoshaStatus = 2;
			remaimSeconds = -1;
		}else {//秒杀正在进行中
			miaoshaStatus = 1;
			remaimSeconds = 0;
		}
		mode.addAttribute("miaoshaStatus", miaoshaStatus);
		mode.addAttribute("remaimSeconds", remaimSeconds);
		mode.addAttribute("goods", goods);
		//return "goods_detail";
		//手动渲染
		SpringWebContext ctx = new SpringWebContext(request, response, request.getServletContext(), request.getLocale(), mode.asMap(), applicationContext);
		html = thymeleafViewResolver.getTemplateEngine().process("goods_detail", ctx);
		if(!StringUtils.isEmpty(html)) {
			redisService.set(GoodsKey.getGoodsDetail, ""+goodsId, html);
		}
		return html;
	}
	
}
