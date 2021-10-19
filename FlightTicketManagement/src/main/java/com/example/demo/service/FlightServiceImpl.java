package com.example.demo.service;


import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.FlightDao;
import com.example.demo.model.Flight;



@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;

	/*
	 * add a flight
	 */
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		
		if (!findById.isPresent()) {
			flightDao.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		}
		else
			return null;
		
	}

	/*
	 * view all flights
	 */
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	/*
	 * search a flight
	 */
	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else 
			return null;
	}
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}*/

	/*
	 * modify a flight
	 */
	@Override
	public Flight modifyFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightDao.save(flight);
		} 
		return flight;
	}

	/*
	 * remove a flight
	 */
	public String removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			flightDao.deleteById(flightNumber);
			return "Flight removed!!";
		} 
		else 
			return null;

	}
}

