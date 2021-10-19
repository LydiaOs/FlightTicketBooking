package com.example.demo.service;

import java.math.BigInteger;

import com.example.demo.model.ScheduleFlight;




public interface ScheduledFlightService {
	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight);

	public ScheduleFlight modifyScheduledFlight(ScheduleFlight scheduledFlight);

	public String removeScheduledFlight(BigInteger id);

	public Iterable<ScheduleFlight> viewAllScheduledFlights();

	public ScheduleFlight viewScheduledFlight(BigInteger id);
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}
