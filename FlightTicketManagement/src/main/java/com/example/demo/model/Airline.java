package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Airline {
	@Id
	private String AirlineId;
	private String AirlineName;
	private int ContactNumber;
	private String ContactAddress;
	

}
