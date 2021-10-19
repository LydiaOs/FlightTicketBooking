package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Airline;



public interface AirlineService {
	public Iterable<Airline> viewAllAirport();

	public Airline viewAirport(String AirlineId);

	public ResponseEntity<?> addAirport(Airline airport);

	public Airline modifyAirport(Airline airport);

	public String removeAirport(String AirlineId);
}
