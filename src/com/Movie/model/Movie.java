package com.Movie.model;

public class Movie {
	    private int movieId;
	    private String name;
	    private String genre;
	    private int durationMinutes;
	    private double rating;
	    private String language;

	    public Movie(int movieId, String name, String genre, int durationMinutes,
	                 double rating, String language) {
	        this.movieId = movieId;
	        this.name = name;
	        this.genre = genre;
	        this.durationMinutes = durationMinutes;
	        this.rating = rating;
	        this.language = language;
	    }

	    
	    public Movie(String name, double rating) {
	        this(0, name, "Not specified", 0, rating, "Not specified");
	    }

	    public int getMovieId() {
	        return movieId;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getRating() {
	        return rating;
	    }

	    public String getGenre() {
	        return genre;
	    }

	    public int getDurationMinutes() {
	        return durationMinutes;
	    }

	    public String getLanguage() {
	        return language;
	    }
	}
