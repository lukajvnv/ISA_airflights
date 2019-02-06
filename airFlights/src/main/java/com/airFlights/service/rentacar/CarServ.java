package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airFlights.dto.rentacar.CarDTO;
import com.airFlights.model.rentacar.Car;

@Service
public interface CarServ {
    List<Car> findAll();
	Car save(Car car);
	void removeCar(Integer id);
	//void updateCar(Car car, CarDTO carDTO);
}
