package com.nycab.dao;

import java.util.List;

import com.nycab.model.User;

public interface UserDao {
	public Boolean add(User user);
	public List<User> getUsers();
	public User getModelFromConsole();
}
