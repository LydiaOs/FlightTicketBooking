package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AirlineDao;
import com.example.demo.dao.SeatDao;
import com.example.demo.model.Airline;
import com.example.demo.model.Seat;
@Service
public class SeatServiceImpl implements SeatService {
	@Autowired
	SeatDao seatDao;
	@Override
	public void addSeat(Seat seat) {
	
		seatDao.save(seat);
	
	}
	@Override
	public Iterable<Seat> viewAllSeats() {
		return seatDao.findAll();
	}

}
