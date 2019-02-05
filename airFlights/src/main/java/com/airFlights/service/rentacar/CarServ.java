package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airFlights.model.rentacar.Car;

@Service
public interface CarServ {
	Car findById(Long id);
    List<Car> findAll();
	Car save(Car car);
}
