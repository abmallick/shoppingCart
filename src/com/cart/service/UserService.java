package com.cart.service;

import com.cart.DAO.UserDAO;
import com.cart.entity.UserCredentials;

public class UserService {

	public static boolean authorize(UserCredentials user)
	{
		UserDAO ud = new UserDAO();
		return ud.authenticate(user);
	}
	
	public static boolean create(UserCredentials user)
	{
		UserDAO ud = new UserDAO();
		return ud.create(user);
	}
}
