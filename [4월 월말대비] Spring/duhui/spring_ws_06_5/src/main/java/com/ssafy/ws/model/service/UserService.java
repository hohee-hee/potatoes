package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.User;

public interface UserService {
	public User getById(String id);
	
	public List<User> getAll();
	
	public void insert(User user);
}
