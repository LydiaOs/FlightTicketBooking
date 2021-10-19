package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Airline;
import com.example.demo.service.AirlineService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/airport")
public class AirlineController {
	@Autowired(required = true)
	AirlineService airportService;

	@GetMapping("/viewAirline/{id}")
	
	public Airline viewAirline(@PathVariable("id") String AirlineId) {
		return airportService.viewAirport(AirlineId);
	}

	@GetMapping("/allAirline")
	public Iterable<Airline> viewAllAirline() {
		return airportService.viewAllAirport();
	}

	@PostMapping("/addAirline")
	
	public void addAirline(@RequestBody Airline airline) {
		airportService.addAirport(airline);
	}

	@PutMapping("/updateAirline")
	
	public void modifyAirline(@RequestBody Airline airport) {
		airportService.modifyAirport(airport);
	}

	@DeleteMapping("/deleteAirline/{id}")
	
	public void removeAirline(@PathVariable("id") String AirlineId) {
		airportService.removeAirport(AirlineId);
	}
}

