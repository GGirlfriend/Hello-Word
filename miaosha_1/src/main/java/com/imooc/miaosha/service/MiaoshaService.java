package com.imooc.miaosha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.miaosha.dao.GoodsDao;
import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.Goods;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.OrderInfo;
import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.vo.GoodsVo;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月16日 下午2:09:20
*类说明：
*/
@Service
public class MiaoshaService {

	@Autowired
	GoodsService goodsService;

	@Autowired
	OrderService orderService;
	
	@Transactional
	public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
		//减库存 下订单 写入秒杀订单(使用事务)
		goodsService.reduceStock(goods);
		//order_info miaosha_order
		return orderService.createOrder(user, goods);
		
		/*Goods g = new Goods();
		g.setId(goods.getId());
		g.setGoodsStock(goods.getStockCount()-1);
		goodsDao.reduceStock(g);*/
		
		
	}
	
	
}
