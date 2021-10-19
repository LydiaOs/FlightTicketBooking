package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AirlineDao;
import com.example.demo.model.Airline;

@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	AirlineDao airportDao;

	/*
	 * view all Airports
	 */
	@Override
	public Iterable<Airline> viewAllAirport() {
		return airportDao.findAll();
	}

	/*
	 * view airport by airportCode
	 */
	@Override
	public Airline viewAirport(String AirlineId) {
		Optional<Airline> findById = airportDao.findById(AirlineId);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			return null;}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
	

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<?> addAirport(Airline airport) {
		Optional<Airline> findById = airportDao.findById(airport.getAirlineId());
		
		if (!findById.isPresent()) {
			airportDao.save(airport);
			return new ResponseEntity<Airline>(airport,HttpStatus.OK);
		} 
		else
		return null;
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Airline modifyAirport(Airline airport) {
		Optional<Airline> findById = airportDao.findById(airport.getAirlineId());
		if (findById.isPresent()) {
			airportDao.save(airport);
		} 
		
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(String AirlineId) {
		Optional<Airline> findById = airportDao.findById(AirlineId);
		if (findById.isPresent()) {
			airportDao.deleteById(AirlineId);
			return "Airport removed";
		} else
			return null;

	}
}

