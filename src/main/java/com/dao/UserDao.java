package com.dao;

import java.util.List;
import java.util.Map;

import com.model.User;

public interface UserDao {

	public User getUserById(int id);
	
	public void add(User user);
	
	public void update(User user);
	
	public void delete(int id);
	
	public List<User> listAll();
	
	public List<User> pageUser(int page,int pageSize);
	
}
