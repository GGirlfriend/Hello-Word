package com.imooc.miaosha.util;

import java.util.UUID;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月22日 上午10:18:26
*类说明：
*/
public class UUIDUtil {

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
