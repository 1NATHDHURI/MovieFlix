package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.Movie;
import com.movieflix.entities.User;
import com.movieflix.services.MovieServices;
import com.movieflix.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServices userv;
	
	@Autowired
	MovieServices movserv;
	
	@PostMapping("register")
	public String addUsers(@ModelAttribute User usr) {
		boolean status = userv.emailExits(usr.getEmail());
		if(status == true) {
			return "registerfail";
		} else {
			userv.addUsers(usr);
			return "registersuccess";
		}
	}
	
	@PostMapping("login")
	public String validateUser(@RequestParam String email,@RequestParam String password,
			HttpSession session) {
		boolean loginStatus = userv.checkUser(email, password);
		if(loginStatus == true) {
			session.setAttribute("email", email);
		if(email.equals("admin@gmail.com")) {
			return "adminhome";
		} else {
			return "home";
		}
	} else {
		return "login";
	}
  }
	
	@GetMapping("viewuser")
	public String viewUser(Model model) {
		List<User> userList = userv.viewUser();
		model.addAttribute("user",userList);
		return "viewuser";
	}
	
	@GetMapping("exploremovies")
	public String exploreMovies(Model model, HttpSession session) {
		//getting email from session
		String email = (String)session.getAttribute("email");
		//getting the user details for email 
		User usr = userv.getUser(email);
		//checking user is premium 
		if(usr.isPremium() == true) {
			//Getting the list of movies
			List<Movie> movieList = movserv.viewMovie();
			//Adding the movie details in the model
			model.addAttribute("movie",movieList);
			//if premium , show movies
			return "viewmovieuser";
		} else {
			//if not premium , make payment
			return "payment";
		}
	}
	
	@GetMapping("logout")
	public String logOut(HttpSession session) {
	session.invalidate();
	return "login";
	}
}
