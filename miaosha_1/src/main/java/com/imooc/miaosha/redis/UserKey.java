package com.imooc.miaosha.redis;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月19日 下午3:30:32
*类说明：
*/
public class UserKey extends BasePrefix{

	
	public UserKey(String prefix) {
		super(prefix);
	}

	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
	
}
