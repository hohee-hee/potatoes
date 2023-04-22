package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getById(String id) {
		return userDao.selectById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.selectAll();
	}

	@Transactional
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
}
