package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Data
@Entity
public class Booking {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId;
	private String bookingDate;
	private String From;
	private String To;
	@Enumerated(EnumType.STRING)
	
	private MealType MealType;
	private String DiscountCode;
	@OneToOne
	private Seat seat;
	@OneToOne
	private Passenger passenger;
	
	
}
