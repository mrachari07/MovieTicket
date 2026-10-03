package com.Movie.model;

public class Seat {
	
    private int rowNumber;
    private int seatNumber;
    private String seatType;
    private boolean booked;

    public Seat(int rowNumber, int seatNumber, String seatType, boolean booked) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.booked = booked;
    }

    public int getRowNumber() { return rowNumber; }
    public int getSeatNumber() { return seatNumber; }
    public String getSeatType() { return seatType; }
    public boolean isBooked() { return booked; }

    public void setBooked(boolean booked) { this.booked = booked; }

}
