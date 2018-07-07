package com.imooc.miaosha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月22日 下午8:41:22
*类说明：
*/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Autowired
	UserArgumentResolver userArgumentResolver; 
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	} 
	
}
