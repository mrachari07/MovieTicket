package com.Movie.daoImplementation;

import com.Movie.dao.SeatDao;

	public class SeatDaoImpl implements SeatDao {
	    private boolean[][] seats;

	    public SeatDaoImpl(int rows, int columns) {
	        seats = new boolean[rows][columns];

	        // Nested loops prepare every seat available.
	        for (int row = 0; row < rows; row++) {
	            for (int column = 0; column < columns; column++) {
	                seats[row][column] = false;
	            }
	        }
	    }

	    public boolean[][] getSeats() { return seats; }

	    public boolean isValidSeat(int row, int column) {
	        return row >= 0 && row < seats.length && column >= 0 && column < seats[0].length;
	    }

	    public boolean isBooked(int row, int column) {
	        return isValidSeat(row, column) && seats[row][column];
	    }

	    public boolean bookSeat(int row, int column) {
	        if (!isValidSeat(row, column) || seats[row][column]) return false;
	        seats[row][column] = true;
	        return true;
	    }

	    public boolean cancelSeat(int row, int column) {
	        if (!isValidSeat(row, column) || !seats[row][column]) return false;
	        seats[row][column] = false;
	        return true;
	    }

	    public int countAvailableSeats() {
	        int available = 0;
	        for (int row = 0; row < seats.length; row++) {
	            for (int column = 0; column < seats[row].length; column++) {
	                if (!seats[row][column]) available++;
	            }
	        }
	        return available;
	    }
	}
