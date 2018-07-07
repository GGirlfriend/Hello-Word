package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月18日 下午7:38:16
*类说明：
*/
@Service
public class RedisPoolFactory {

	@Autowired
	RedisConfig redisConfig;
	
	/**
	 * 有了这个方法以后我们就把jedispool加载到spring容器里面了
	 * @return
	 */
	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
		JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout()*1000, redisConfig.getPassword() ,0);
		return jp;
	}
	
}
