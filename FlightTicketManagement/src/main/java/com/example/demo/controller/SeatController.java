package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Airline;
import com.example.demo.model.Booking;
import com.example.demo.model.Seat;
import com.example.demo.service.BookingService;
import com.example.demo.service.SeatService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/seat")
public class SeatController {
	@Autowired(required= true)
	SeatService seatService;

	@PostMapping("/addSeat")
	
	public void addSeats(@RequestBody Seat seat) {

		seatService.addSeat(seat);
	} 
	@GetMapping("/allAirline")
	public Iterable<Seat> viewAllSeats() {
		return seatService.viewAllSeats();
	}

}
