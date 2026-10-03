package com.Movie.model;

public class Show {
	
	 private int showId;
	    private Movie movie;
	    private Theatre theatre;
	    private String showDate;
	    private String showTime;
	    private boolean weekend;

	    public Show(int showId, Movie movie, Theatre theatre, String showDate,
	                String showTime, boolean weekend) {
	        this.showId = showId;
	        this.movie = movie;
	        this.theatre = theatre;
	        this.showDate = showDate;
	        this.showTime = showTime;
	        this.weekend = weekend;
	    }

	    public int getShowId() { return showId; }
	    public Movie getMovie() { return movie; }
	    public Theatre getTheatre() { return theatre; }
	    public String getShowDate() { return showDate; }
	    public String getShowTime() { return showTime; }
	    public boolean isWeekend() { return weekend; }
}
