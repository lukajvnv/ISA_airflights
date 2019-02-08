package com.airFlights.repository.avio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.avio.Airline;

public interface AirlineRepository extends JpaRepository<Airline,Integer>{

	List<Airline> findAllByOrderByName();
}
