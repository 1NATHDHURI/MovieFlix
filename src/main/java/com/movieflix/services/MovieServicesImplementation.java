package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;

@Service
public class MovieServicesImplementation implements MovieServices{

	@Autowired
	MovieRepository movrepo;
	
	@Override
	public String addMovie(Movie mov) {
		movrepo.save(mov);
		return "Movie is added";
	}

	@Override
	public List<Movie> viewMovie() {
		List<Movie> movieList = movrepo.findAll();
		return movieList;
	}

	@Override
	public String addMovie() {
		// TODO Auto-generated method stub
		return null;
	} 

} 
