package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
	@Id
	private int AirlineId;
	private String AirlineName;
	private int ContactNumber;
	private String ContactAddress;
	

}
