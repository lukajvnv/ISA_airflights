package com.airFlights.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.SearchCarDTO;
import com.airFlights.dto.rentacar.CarReservationDTO;
import com.airFlights.model.CarReservation;
import com.airFlights.model.user.User;
import com.airFlights.repository.rentacar.CarReservationRepository;
import com.airFlights.service.rentacar.CarReservationService;
import com.airFlights.userService.UserService;

@RestController
@RequestMapping(value = "/reservation")
public class CarReservationController {

	@Autowired
	private CarReservationService carReservationService;
	
	@Autowired
	private CarReservationRepository carReservationRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = POST, value = "/car/{user}", consumes = "application/json")
	public ResponseEntity<Integer> reserveCar(@RequestBody SearchCarDTO searchCarDTO, @PathVariable("user") String username) throws InterruptedException {
		
		//User user = userService.getCurrentUser();
		User user = userService.findByUsername(username);
		SearchCarDTO scDTO = searchCarDTO;
		
		try {
			carReservationService.reserve(scDTO, user);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/*@RequestMapping(method = GET, value = "/getCarReservations", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarReservationDTO>> getAllCarReservations() {
		List<CarReservation> carReservations = carReservationRepository.findAll();
		
		List<CarReservationDTO> answer = new ArrayList<>();
		//User u = userService.findByUsername(user);
		
		for(CarReservation carReservation : carReservations) {
			//if(carReservation.getUsername().equals(u.getUsername())) {
				answer.add(new CarReservationDTO(carReservation));
			//}
		}
		
		
		return new ResponseEntity<List<CarReservationDTO>>(answer, HttpStatus.FOUND);
	}*/

}
