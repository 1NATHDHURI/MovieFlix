package com.movieflix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String MovieName;
	
	@Column(length = 50000)
	String MovieLink;
	String MovieGenre;
	String MovieCast;
	String MovieDirector;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int id, String movieName, String movieLink, String movieGenre, String movieCast,
			String movieDirector) {
		super();
		this.id = id;
		this.MovieName = movieName;
		this.MovieLink = movieLink;
		this.MovieGenre = movieGenre;
		this.MovieCast = movieCast;
		this.MovieDirector = movieDirector;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", MovieName=" + MovieName + ", MovieLink=" + MovieLink + ", MovieGenre="
				+ MovieGenre + ", MovieCast=" + MovieCast + ", MovieDirector=" + MovieDirector + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getMovieLink() {
		return MovieLink;
	}
	public void setMovieLink(String movieLink) {
		MovieLink = movieLink;
	}
	public String getMovieGenre() {
		return MovieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		MovieGenre = movieGenre;
	}
	public String getMovieCast() {
		return MovieCast;
	}
	public void setMovieCast(String movieCast) {
		MovieCast = movieCast;
	}
	public String getMovieDirector() {
		return MovieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		MovieDirector = movieDirector;
	}
	
	

}
