package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.User;

public interface UserDao {
	public User selectById(String id);
	
	public List<User> selectAll();
	
	public void insert(User user);
	
	public void delete(String id);
}
