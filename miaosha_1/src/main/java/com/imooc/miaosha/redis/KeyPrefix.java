package com.imooc.miaosha.redis;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月18日 下午11:43:13
*类说明：
*/
public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
