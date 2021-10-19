package com.example.demo.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleFlight;
import com.example.demo.service.AirlineService;
import com.example.demo.service.FlightService;
import com.example.demo.service.ScheduledFlightService;

@RestController
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {
	
	 // Creating Service object
	 
	@Autowired
	ScheduledFlightService scheduleFlightService;
@Autowired
AirlineService airlineservice;
	

	@Autowired
	FlightService flightService;

	
	 //Controller for adding Scheduled Flights
	 
	@PostMapping("/add")
	public ResponseEntity<ScheduleFlight> addSF(@ModelAttribute ScheduleFlight scheduledFlight,
			@RequestParam(name = "sourceAirport") String source, @RequestParam(name = "destinationAirport") String destination,
			@RequestParam(name = "DepartureDateTime") String departureTime, @RequestParam(name = "ArrivalDateTime") String arrivalTime) {
		Flight flight =new Flight();
		flight.setSource(source);
		flight.setDestination(destination);
		
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
	
		schedule.setDepartureDateTime(departureTime);
		schedule.setArrivalDateTime(arrivalTime);
		
		scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
		
		
		scheduledFlight.setSchedule(schedule);
		scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
			return new ResponseEntity<ScheduleFlight>(scheduleFlightService.addScheduledFlight(scheduledFlight),
					HttpStatus.OK);
		
	}

	
	 //Controller for modifying existing Scheduled Flights
	 
	@PutMapping("/modify")
	public ResponseEntity<ScheduleFlight> modifyScheduleFlight(@ModelAttribute ScheduleFlight scheduleFlight) {
		ScheduleFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		if (modifySFlight == null) {
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ScheduleFlight>(modifySFlight, HttpStatus.OK);
		}

	}

	
	 // Controller for deleting existing Scheduled Flights
	 
	@DeleteMapping("/delete")
	public String deleteSF(@RequestParam BigInteger flightId)  {
		return scheduleFlightService.removeScheduledFlight(flightId);
	}

	
	 // Controller for viewing a Scheduled Flight by ID
	 
	@GetMapping("/search")
	
	public ResponseEntity<ScheduleFlight> viewSF(@RequestParam BigInteger flightId)  {
		ScheduleFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
		if (searchSFlight == null) {
			return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ScheduleFlight>(searchSFlight, HttpStatus.OK);
		}
	}

	
	 //Controller for viewing all Scheduled Flights
	 
	@GetMapping("/viewAll")
	public Iterable<ScheduleFlight> viewAllSF() {
		return scheduleFlightService.viewAllScheduledFlights();
	}
	

}

