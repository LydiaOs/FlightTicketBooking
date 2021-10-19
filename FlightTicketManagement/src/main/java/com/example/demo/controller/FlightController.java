package com.example.demo.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/addFlight")
	
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
	}

	@GetMapping("/allFlight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/viewFlight/{id}")
	
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/updateFlight")
	
	public void modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
	}

	@DeleteMapping("/deleteFlight/{id}")
	
	public void removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
	}
}
