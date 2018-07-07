package com.imooc.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月16日 下午2:09:20
*类说明：
*/
@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Transactional
	public boolean tx() {
		User u1 = new User();
		u1.setId(2);
		u1.setName("2222");
		userDao.insert(u1);

		
		User u2 = new User();
		u2.setId(1);
		u2.setName("1111");
		userDao.insert(u2);
		
		return true;
	}
	
}
