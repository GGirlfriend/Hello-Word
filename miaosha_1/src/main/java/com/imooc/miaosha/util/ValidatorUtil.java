package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月21日 下午8:05:55
*类说明： 验证手机号是否是以一开头并且是10位数的
*/
public class ValidatorUtil {

	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
	
	public static boolean isMobile(String src) {
		if(StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher m = mobile_pattern.matcher(src);
		return m.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isMobile("18647347381"));
		System.out.println(isMobile("1864734738"));
	}
	
}
