package com.Movie.dao;

public interface SeatDao {

	    boolean[][] getSeats();
	    boolean isValidSeat(int row, int column);
	    boolean isBooked(int row, int column);
	    boolean bookSeat(int row, int column);
	    boolean cancelSeat(int row, int column);
	    int countAvailableSeats();

}
