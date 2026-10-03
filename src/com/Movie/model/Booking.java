package com.Movie.model;

public class Booking {

	    private int bookingId;
	    private Customer customer;
	    private Show show;
	    private int row;
	    private int seat;
	    private double amount;
	    private String bookingStatus;

	    public Booking(int bookingId, Customer customer, Show show, int row, int seat,
	                   double amount, String bookingStatus) {
	        this.bookingId = bookingId;
	        this.customer = customer;
	        this.show = show;
	        this.row = row;
	        this.seat = seat;
	        this.amount = amount;
	        this.bookingStatus = bookingStatus;
	    }

	    // Simple constructor retained for the console application.
	    public Booking(int row, int seat, double amount) {
	        this(0, null, null, row, seat, amount, "CONFIRMED");
	    }

	    public int getBookingId() {
	        return bookingId;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public Show getShow() {
	        return show;
	    }

	    public int getRow() {
	        return row;
	    }

	    public int getSeat() {
	        return seat;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public String getBookingStatus() {
	        return bookingStatus;
	    }

	    public void setBookingStatus(String bookingStatus) {
	        this.bookingStatus = bookingStatus;
	    }
	}
