package com.Movie.dao;

import com.Movie.model.Booking;

public interface BookingDao {
	
	 boolean saveBooking(Booking booking);
	    Booking findBookingById(int bookingId);
	    boolean cancelBooking(int bookingId);
	    Booking[] getBookingHistory();
	    int getBookingCount();
}
