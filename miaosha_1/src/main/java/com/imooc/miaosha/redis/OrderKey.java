package com.imooc.miaosha.redis;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月19日 下午3:31:36
*类说明：
*/
public class OrderKey extends BasePrefix{

	public OrderKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	
	
}
