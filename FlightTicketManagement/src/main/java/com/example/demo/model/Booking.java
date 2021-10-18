package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger bookingId;
	private String bookingDate;
	private String From;
	private String To;
	@Enumerated(EnumType.STRING)
	
	private MealType MealType;
	private String DiscountCode;
	private int SeatNoOnward;
	private int SeatNoReturn;
	private Seat SeatType;
}
