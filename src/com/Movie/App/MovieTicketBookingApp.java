package com.Movie.App;

import java.util.Scanner;

import com.Movie.Service.BookingService;
import com.Movie.Service.PricingService;
import com.Movie.dao.BookingDao;
import com.Movie.dao.MovieDao;
import com.Movie.dao.SeatDao;
import com.Movie.daoImplementation.BookingDaoImpl;
import com.Movie.daoImplementation.MovieDaoImpl;
import com.Movie.daoImplementation.SeatDaoImpl;
import com.Movie.model.Booking;
import com.Movie.model.Coupon;
import com.Movie.model.Movie;

	public class MovieTicketBookingApp {
	    static final int ROWS = 5;
	    static final int COLUMNS = 6;
	    static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        Movie movie = new Movie("The Java Adventure", 8.4);
	        SeatDao seatDao = new SeatDaoImpl(ROWS, COLUMNS);
	        BookingDao bookingDao = new BookingDaoImpl(ROWS * COLUMNS);
	        MovieDao movieDao = new MovieDaoImpl(5);
	        movieDao.addMovie(movie);
	        PricingService pricingService = new PricingService();
	        BookingService bookingService = new BookingService(seatDao, bookingDao, pricingService);
	        boolean isWeekend = readInt("Weekend show? 1.Yes  2.No: ") == 1;

	        int choice;
	        do {
	            System.out.println("\n1. Show seats\n2. Book ticket\n3. Cancel ticket\n4. Movie details\n5. Exit");
	            choice = readInt("Choose: ");
	            if (choice == 1) {
	                showSeats(seatDao);
	            } else if (choice == 2) {
	                bookTicket(bookingService, seatDao, isWeekend);
	            } else if (choice == 3) {
	                cancelTicket(bookingService);
	            } else if (choice == 4) {
	                showMovies(movieDao);
	                System.out.println("Base price: Rs. " + bookingService.getBasePrice(isWeekend));
	            } else if (choice != 5) {
	                System.out.println("Invalid option.");
	            }
	        } while (choice != 5);
	    }

	    static void showSeats(SeatDao seatDao) {
	        boolean[][] seats = seatDao.getSeats();
	        System.out.println("O = available, X = booked");
	        for (int row = 0; row < seats.length; row++) {
	            System.out.print("Row " + (row + 1) + ": ");
	            for (int column = 0; column < seats[row].length; column++) {
	                System.out.print(seats[row][column] ? "X " : "O ");
	            }
	            System.out.println();
	        }
	        System.out.println("Available: " + seatDao.countAvailableSeats());
	    }

	    static void bookTicket(BookingService service, SeatDao seatDao, boolean isWeekend) {
	        showSeats(seatDao);
	        int row = readInt("Row: ") - 1;
	        int seat = readInt("Seat: ") - 1;
	        System.out.print("Apply MOVIE15 coupon? (yes/no): ");
	        boolean hasCoupon = scanner.next().equalsIgnoreCase("yes");
	        Coupon coupon = hasCoupon ? new Coupon("MOVIE15", 15, true, "31-12-2026") : null;
	        Booking booking = service.bookTicket(row, seat, isWeekend, coupon);
	        if (booking == null) {
	            System.out.println("Unable to book: seat is invalid or already booked.");
	        } else {
	            System.out.printf("Booked Row %d, Seat %d. Amount: Rs. %.2f%n",
	                    booking.getRow() + 1, booking.getSeat() + 1, booking.getAmount());
	        }
	    }

	    static void cancelTicket(BookingService service) {
	        int row = readInt("Row to cancel: ") - 1;
	        int seat = readInt("Seat to cancel: ") - 1;
	        if (service.cancelTicket(row, seat)) {
	            System.out.println("Ticket cancelled.");
	        } else {
	            System.out.println("Unable to cancel: seat is invalid or not booked.");
	        }
	    }

	    static void showMovies(MovieDao movieDao) {
	        Movie[] movies = movieDao.getAllMovies();
	        System.out.println("Movies and ratings:");

	        // Loop only through the movies that have been added.
	        for (int index = 0; index < movieDao.getMovieCount(); index++) {
	            System.out.println(movies[index].getName() + " | Rating: "
	                    + movies[index].getRating() + "/10");
	        }
	    }

	    static int readInt(String message) {
	        while (true) {
	            System.out.print(message);
	            if (scanner.hasNextInt()) {
	                return scanner.nextInt();
	            }
	            System.out.println("Enter a whole number.");
	            scanner.next();
	        }
	    }
	}

