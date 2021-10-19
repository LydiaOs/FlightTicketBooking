package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Airline;
import com.example.demo.model.Seat;



public interface SeatService {
	public void addSeat(Seat seat);
	public Iterable<Seat> viewAllSeats();

}
