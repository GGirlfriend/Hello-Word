package com.imooc.miaosha.redis;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月19日 下午3:30:32
*类说明：
*/
public class MiaoshaUserKey extends BasePrefix{
	
	public static final int TOKEN_EXPIRE = 3600*24*2;
	
	public MiaoshaUserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
	public static MiaoshaUserKey getById = new MiaoshaUserKey(0, "id");
	
}
