package com.Movie.Service;

import com.Movie.dao.BookingDao;
import com.Movie.dao.SeatDao;
import com.Movie.model.Booking;
import com.Movie.model.Coupon;

	/**  weekday/weekend pricing and coupons */
	public class BookingService {
	    private SeatDao seatDao;
	    private BookingDao bookingDao;
	    private PricingService pricingService;
	    private int nextBookingId = 1;

	    public BookingService(SeatDao seatDao, BookingDao bookingDao, PricingService pricingService) {
	        this.seatDao = seatDao;
	        this.bookingDao = bookingDao;
	        this.pricingService = pricingService;
	    }

	    public Booking bookTicket(int row, int seat, boolean isWeekend, Coupon coupon) {
	        if (!seatDao.bookSeat(row, seat)) {
	            return null;
	        }
	        double price = pricingService.calculateFinalPrice(isWeekend, coupon);
	        Booking booking = new Booking(nextBookingId++, null, null, row, seat, price, "CONFIRMED");
	        if (!bookingDao.saveBooking(booking)) {
	            seatDao.cancelSeat(row, seat);
	            return null;
	        }
	        return booking;
	    }

	    public boolean cancelTicket(int row, int seat) {
	        Booking[] bookings = bookingDao.getBookingHistory();

	        //saved bookings for matching active ticket
	        for (int index = 0; index < bookingDao.getBookingCount(); index++) {
	            Booking booking = bookings[index];
	            if (booking.getRow() == row && booking.getSeat() == seat
	                    && booking.getBookingStatus().equals("CONFIRMED")) {
	                bookingDao.cancelBooking(booking.getBookingId());
	                return seatDao.cancelSeat(row, seat);
	            }
	        }
	        return false;
	    }

	    public double getBasePrice(boolean isWeekend) {
	        return pricingService.getBasePrice(isWeekend);
	    }
	}
