package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.User;
import com.movieflix.repositories.UserRepository;
@Service
public class UserServicesImplementation  implements UserServices{

	@Autowired
	UserRepository urepo;
	@Override
	public String addUsers(User usr) {
		urepo.save(usr);
		return "User is created";
	}
	public boolean emailExits(String email) {
		//checking whether the user exits with entered email
		if(urepo.findByEmail(email)==null) {
			//if user does't exits,  return false
			return false;
		} else {
			//otherwise return true
			return true;
		}
	}

	@Override
	public boolean checkUser(String email, String password) {
		//checking email and getting user details from Db
		User usr = urepo.findByEmail(email);
		//getting DB password of user using email
		String db_password = usr.getPassword();
		//ckecking whether user entered password DB password same
		if(db_password.equals(password)) {
			//same returning true
			return true;
		} else {
			//not same returning false
			return false;
		}
	}

	@Override
	public List<User> viewUser() {
		List<User>userList = urepo.findAll();
		return userList;
	}
	@Override
	public User getUser(String email) {
		User user = urepo.findByEmail(email);
		return user;
	}
	@Override
	public String updateUser(User user) {
		urepo.save(user);
		return "User Update";
	}
	

}
