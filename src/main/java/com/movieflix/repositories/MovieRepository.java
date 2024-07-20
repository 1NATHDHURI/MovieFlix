package com.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findAll();


}
