package com.imooc.miaosha.redis;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月19日 下午3:30:32
*类说明：
*/
public class GoodsKey extends BasePrefix{

	
	public GoodsKey(int expireSeconds, String prefix) {
		super(expireSeconds,prefix);
	}

	public static GoodsKey getGoodsList = new GoodsKey(60,"gl");
	public static GoodsKey getGoodsDetail = new GoodsKey(60,"gd");
}
