package com.Movie.dao;

import com.Movie.model.Movie;

public interface MovieDao {
	
	 boolean addMovie(Movie movie);
	    Movie findMovieById(int movieId);
	    Movie[] getAllMovies();
	    int getMovieCount();
}
