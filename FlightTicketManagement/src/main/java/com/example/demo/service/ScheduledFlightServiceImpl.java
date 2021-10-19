package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ScheduleDao;
import com.example.demo.dao.ScheduledFlightDao;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleFlight;


@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	ScheduledFlightDao dao;

	@Autowired
	ScheduleDao scheduleDao;

	@Autowired
	BookingService bookingService;

	/*
	 * Service method to add new Scheduled flight to database
	 */
	@Override
	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight) {
		return dao.save(scheduledFlight);
	}

	/*
	 * Service method to modify existing Scheduled flight in database
	 */
	@Override
	public ScheduleFlight modifyScheduledFlight(ScheduleFlight scheduleFlight) {
		ScheduleFlight updateScheduleFlight = dao.findById(scheduleFlight.getScheduleFlightId()).get();
		Schedule updateSchedule = scheduleDao.findById(scheduleFlight.getSchedule().getScheduleId()).get();
		updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
		
		updateSchedule.setArrivalDateTime(scheduleFlight.getSchedule().getArrivalDateTime());
		updateSchedule.setDepartureDateTime(scheduleFlight.getSchedule().getDepartureDateTime());
		dao.save(updateScheduleFlight);
		return scheduleFlight;
	}

	/*
	 * Service method to remove existing Scheduled flight from database
	 */
	@Override
	public String removeScheduledFlight(BigInteger flightId) {
		
		Optional<ScheduleFlight> scheduleFlight = dao.findById(flightId);
	
			dao.deleteById(flightId);
		
		return "Scheduled flight with ID " + flightId + " is not found";
	}

	// @Override
	// public boolean cancelBookings(BigInteger flightId) throws
	// RecordNotFoundException {
	// Iterable<Booking> bookingList = bookingService.displayAllBooking();
	// for (Booking booking : bookingList) {
	// if (booking.getScheduleFlight().getScheduleFlightId().equals(flightId)) {
	// bookingService.deleteBooking(booking.getBookingId());
	// }
	// }
	// return true;
	// }

	/*
	 * Service method to view all Scheduled flights in database
	 */
	@Override
	public Iterable<ScheduleFlight> viewAllScheduledFlights() {
		return dao.findAll();
	}

	/*
	 * Service method to view a Scheduled flight by ID from database
	 */
	@Override
	public ScheduleFlight viewScheduledFlight(BigInteger flightId) {
		
		Optional<ScheduleFlight> scheduleFlight = dao.findById(flightId);
		
			return scheduleFlight.get();
	}

}






