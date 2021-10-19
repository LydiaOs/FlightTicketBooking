package com.example.demo.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDao;
import com.example.demo.model.Booking;


@Service
public class BookingServiceImpl implements BookingService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	BookingDao bookingDao;

	/*
	 * making new Booking
	 */
	@Override
	public ResponseEntity<Booking> createBooking(Booking newBooking) {

		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		 
			if (!findBookingById.isPresent()) {
				bookingDao.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} 
			else return null;
	}

	/*
	 * update booking made
	 */
	@Override
	public Booking updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingDao.save(changedBooking);
		} 
		return changedBooking;
	}

	/*
	 * deleteing the booking
	 */

	@Override
	public String deleteBooking(int bookingId) {

		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.service.BookingService#displayAllBooking() show all booking
	 */
	@Override
	public Iterable<Booking> displayAllBooking() {

		return bookingDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.service.BookingService#findBookingById(java.math.BigInteger)
	 * find booking by ID
	 */
	@Override
	public ResponseEntity<?> findBookingById(int bookingId) {
		Optional<Booking> findById = bookingDao.findById(bookingId);
		
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				return null;
				
	}
}

