package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Movie;

public interface MovieServices {
	
	public String addMovie();
	
	public List<Movie> viewMovie();

	String addMovie(Movie mov);

}
