package com.airFlights.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.SearchCarDTO;
import com.airFlights.model.user.User;
import com.airFlights.service.rentacar.CarReservationService;
import com.airFlights.userService.UserService;

@RestController
@RequestMapping(value = "/reservation")
public class CarReservationController {

	@Autowired
	private CarReservationService carReservationService;
	
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

}
