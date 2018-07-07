package com.imooc.miaosha.redis;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月18日 下午11:45:54
*类说明：
*/
public abstract class BasePrefix implements KeyPrefix{

	private int expireSeconds;
	
	private String prefix;
	
	public BasePrefix(String prefix) {//0代表用不过期
		this(0, prefix);
	}
	
	public BasePrefix(int expireSeconds,String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}
	
	@Override
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className+":" + prefix;
	}

	
	
}
