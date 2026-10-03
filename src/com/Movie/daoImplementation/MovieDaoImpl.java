package com.Movie.daoImplementation;

import com.Movie.dao.MovieDao;
import com.Movie.model.Movie;

public class MovieDaoImpl implements MovieDao {
    private Movie[] movies;
    private int movieCount;

    public MovieDaoImpl(int maximumMovies) {
        movies = new Movie[maximumMovies];
    }

    public boolean addMovie(Movie movie) {
        if (movieCount == movies.length) return false;
        movies[movieCount++] = movie;
        return true;
    }

    public Movie findMovieById(int movieId) {
        for (int index = 0; index < movieCount; index++) {
            if (movies[index].getMovieId() == movieId) return movies[index];
        }
        return null;
    }

    public Movie[] getAllMovies() { return movies; }
    public int getMovieCount() { return movieCount; }
}

