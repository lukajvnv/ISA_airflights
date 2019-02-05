package com.airFlights.repository.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.rentacar.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	
}
