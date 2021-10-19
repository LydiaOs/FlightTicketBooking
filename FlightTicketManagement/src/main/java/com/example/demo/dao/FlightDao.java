package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Flight;


@Repository
public interface FlightDao extends CrudRepository<Flight,BigInteger>{

}
