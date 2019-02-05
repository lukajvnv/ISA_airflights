package com.airFlights.controller.avio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.avio.FlightSeatDTO;
import com.airFlights.model.avio.FlightSeat;
import com.airFlights.service.avio.FlightSeatService;

@RestController
@RequestMapping("/seats")
public class FlightSeatController {
	
	@Autowired
	private FlightSeatService seatService;
	
	@RequestMapping(path = "/flight/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<List<FlightSeatDTO>> getFlights(@PathVariable("flightId") Integer flightId){
		List<FlightSeat> flightSeats = seatService.getSeatsByFlight(flightId);
		
		List<FlightSeatDTO> answer = new ArrayList<FlightSeatDTO>();
		for(FlightSeat f: flightSeats) {
			answer.add(new FlightSeatDTO(f));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

}
