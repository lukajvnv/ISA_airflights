package com.airFlights.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.rentacar.CarDTO;
import com.airFlights.model.rentacar.Car;
import com.airFlights.service.rentacar.CarService;

@RestController
@RequestMapping("/car")
public class RentacarCarController {

	@Autowired
	private CarService carService;

	@RequestMapping(path = "/getAllCars", method = RequestMethod.GET)
	public ResponseEntity<List<CarDTO>> getAllCars(){
		List<Car> cars = carService.findAll();
		
		List<CarDTO> answer = new ArrayList<CarDTO>();
		for(Car car: cars) {
			answer.add(new CarDTO(car));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

}
