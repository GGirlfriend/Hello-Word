package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月21日 上午10:13:59
*类说明：对明文字符串进行一个MD5的处理 实现两次的MD5
*/
public class MD5Util {

	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}
	
	private static final String salt = "1a2b3c4d";
	
	public static String inputPassToFromPass(String inputPass) {
		String str = ""+ salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) +salt.charAt(4);
		return md5(str);
	}
	//第二次加密后现在的密码是一个字符串，之后随机生成一个salt
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+ salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) +salt.charAt(4);
		return md5(str);
	}
	
	//把明文密码转化为数据库密码
	public static String inputPassToDbpass(String input, String saltDB) {
		String formPass = inputPassToFromPass(input);
		String dbpass = formPassToDBPass(formPass, saltDB);
		return dbpass;
	}
	//	测试加密后的密码值
	public static void main(String[] args) {

		System.out.println(inputPassToFromPass("123456"));
//		System.out.println(formPassToDBPass(inputPassToFromPass("123456"), "1a2b3c4d"));
//		System.out.println(inputPassToDbpass("123456", "1a2b3c4d"));
	}
	
}
