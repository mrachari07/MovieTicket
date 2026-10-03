package com.Movie.daoImplementation;

import com.Movie.dao.BookingDao;
import com.Movie.model.Booking;

public class BookingDaoImpl implements BookingDao {
	    private Booking[] bookings;
	    private int bookingCount;

	    public BookingDaoImpl(int maximumBookings) {
	        bookings = new Booking[maximumBookings];
	    }

	    public boolean saveBooking(Booking booking) {
	        if (bookingCount == bookings.length) return false;
	        bookings[bookingCount++] = booking;
	        return true;
	    }

	    public Booking findBookingById(int bookingId) {
	        for (int index = 0; index < bookingCount; index++) {
	            if (bookings[index].getBookingId() == bookingId) return bookings[index];
	        }
	        return null;
	    }

	    public boolean cancelBooking(int bookingId) {
	        Booking booking = findBookingById(bookingId);
	        if (booking == null || booking.getBookingStatus().equals("CANCELLED")) return false;
	        booking.setBookingStatus("CANCELLED");
	        return true;
	    }

	    public Booking[] getBookingHistory() { return bookings; }
	    public int getBookingCount() { return bookingCount; }
	}
