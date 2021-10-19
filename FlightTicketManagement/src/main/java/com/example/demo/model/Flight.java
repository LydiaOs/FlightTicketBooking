package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Flight {

	@Id
	private BigInteger flightNo;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
	private String Source;
	private String Destination;
}
