package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.User;

public interface UserServices {
	
	public String addUsers(User usr);
	
	public boolean emailExits(String email);
	
	public boolean checkUser(String email, String password);
	
	public List<User> viewUser();
	
	public User getUser(String email);
	
	public String updateUser(User user);

}
