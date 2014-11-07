package com.dao.impl;

import java.util.List;
import java.util.Map;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUserById(int id) {
		return super.getObjectById(1,new User());
	}

	@Override
	public void add(User user) {
		super.add(user);
	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public void delete(int id) {
		super.delete(id, new User());		
	}

	@Override
	public List<User> listAll() {
		return super.listAll(new User());
	}

	@Override
	public List<User> pageUser(int page,int pageSize) {
		return super.pager(new User(), page, pageSize);
	}

	

}
