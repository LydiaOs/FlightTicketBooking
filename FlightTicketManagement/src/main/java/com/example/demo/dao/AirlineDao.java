package com.example.demo.dao;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Airline;


@Repository
public interface AirlineDao extends CrudRepository<Airline, String> {



}
