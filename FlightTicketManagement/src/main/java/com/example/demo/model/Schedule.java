package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private BigInteger scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private Airline Airline;

	

	@Column(name = "departure_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String DepartureDateTime;

	@Column(name = "arrival_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String ArrivalDateTime;
}