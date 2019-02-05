package com.airFlights.controller.rentacar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.rentacar.CarDTO;
import com.airFlights.model.rentacar.Car;
import com.airFlights.service.rentacar.CarServ;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/rentacar", produces = MediaType.APPLICATION_JSON_VALUE)
public class RentacarController {
	
	@Autowired
	private CarServ carServ;

	@RequestMapping(method = POST, value = "/addCar", consumes = "application/json")
	public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO) throws InterruptedException {
		
		Car car = new Car();
		
		car.setCarId(carDTO.getCarId());
		car.setReserved(false);
		car.setPickupDate("");
		car.setDropofDate("");
		car.setPickupLocation("");
		car.setDropofLocation("");
		car.setCarName(carDTO.getCarName());
		car.setCarBrand(carDTO.getCarBrand());
		car.setCarModel(carDTO.getCarModel());
		car.setCarYear(carDTO.getCarYear());
		car.setNumberOfSeats(carDTO.getNumberOfSeats());
		car.setPrice(carDTO.getPrice());
		
		car = carServ.save(car);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
