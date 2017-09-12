package com.smart.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smart.SpringTest;
import com.smart.domain.User;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月12日 上午9:56:31
* 类说明
*/
public class UserDaoTest extends SpringTest{
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testFindUserByUserName(){
		String userName = "lys";
		User user = userDao.findUserByUserName(userName);
		System.out.println(user);
	}
	
	@Test
	public void testUpdateLoginInfo(){
		String userName = "lys";
		User user = userDao.findUserByUserName(userName);
		user.setLastVisit(new Date());
		userDao.updateLoginInfo(user);
	}
}
