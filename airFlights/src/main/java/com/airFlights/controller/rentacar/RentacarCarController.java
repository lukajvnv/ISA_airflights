package com.airFlights.controller.rentacar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.SearchCarDTO;
import com.airFlights.dto.rentacar.CarDTO;
import com.airFlights.model.rentacar.Car;
import com.airFlights.model.rentacar.Rentacar;
import com.airFlights.service.rentacar.CarService;
import com.airFlights.service.rentacar.RentacarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RestController
@RequestMapping("/car")
public class RentacarCarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private RentacarService rentacarService;

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(path = "/getAllCars", method = RequestMethod.GET)
	public ResponseEntity<List<CarDTO>> getAllCars(){
		List<Car> cars = carService.findAll();
		
		List<CarDTO> answer = new ArrayList<CarDTO>();
		for(Car car: cars) {
			answer.add(new CarDTO(car));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/getReservationCars", method = RequestMethod.GET)
	public ResponseEntity<List<CarDTO>> getReservetaionCars(@RequestParam String parameters) {
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate pDate = LocalDate.parse(pickupDate, formatter);
		//LocalDate dDate = LocalDate.parse(dropofDate, formatter);
		
		SearchCarDTO searchCarDTO = new SearchCarDTO();
		
		try {
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectMapper.registerModule(new JavaTimeModule());
			searchCarDTO = objectMapper.readValue(parameters, SearchCarDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Rentacar rentacar = rentacarService.findRentacarById(searchCarDTO.getId());
		
		Set<Car> cars = new HashSet<>();
		if(!rentacar.getCars().isEmpty()) {
			cars = rentacar.getCars();
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<CarDTO> answer = new ArrayList<CarDTO>();
		
		//provera za datum preuzimanja
		List<CarDTO> tempCars = new ArrayList<>();
		for(Car car: cars) {
			if(!(searchCarDTO.getPickupDate().isAfter(car.getPickupDate()) && searchCarDTO.getPickupDate().isBefore(car.getDropofDate()))) {
				tempCars.add(new CarDTO(car));			
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		//provera za datum vracanja
		List<CarDTO> tempCars2 = new ArrayList<>();
		if(!tempCars.isEmpty()) {
			for(CarDTO car: tempCars) {
				if(!(searchCarDTO.getDropofDate().isAfter(car.getPickupDate()) && searchCarDTO.getDropofDate().isBefore(car.getDropofDate()))) {
					tempCars2.add(car);			
				}
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<CarDTO> tempCars3 = new ArrayList<>();
		if(!tempCars2.isEmpty()) {
			for(CarDTO car: tempCars2) {
				if(car.getPrice() < searchCarDTO.getToPrice() && car.getPrice() > searchCarDTO.getFromPrice()) {
					tempCars3.add(car);
				}
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		if(!tempCars3.isEmpty()) {
			for(CarDTO car: tempCars3) {
				if(searchCarDTO.getPickupLocation().equals(car.getPickupLocation()) && searchCarDTO.getDropofLocation().equals(car.getDropofLocation())
						&& searchCarDTO.getType().equals(car.getTip()) && searchCarDTO.getNumberOfSeats() <= car.getNumberOfSeats()) {
					
					answer.add(car);
				}
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

}
