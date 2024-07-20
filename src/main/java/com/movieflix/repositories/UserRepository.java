package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	//method to find user using email
	public User findByEmail(String email);
}
