package com.airFlights.controller.avio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.ReservationDTO;
import com.airFlights.dto.avio.FlightSeatDTO;
import com.airFlights.model.avio.FlightSeat;
import com.airFlights.service.avio.BookingService;
import com.airFlights.service.avio.MailService;

@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(path = "/seats/flight/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<List<FlightSeatDTO>> getFlights(@PathVariable("flightId") Integer flightId){
		List<FlightSeat> flightSeats = bookingService.getSeatsByFlight(flightId);
		
		List<FlightSeatDTO> answer = new ArrayList<FlightSeatDTO>();
		for(FlightSeat f: flightSeats) {
			answer.add(new FlightSeatDTO(f));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/testUser", method = RequestMethod.GET)
	public ResponseEntity<List<FlightSeatDTO>> getFlights(){
		// bookingService.makeReservation();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/newReservation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewFlight(@RequestBody ReservationDTO newReservation){
		try {
			bookingService.makeReservation(newReservation);
			mailService.sendFinishedReservationNotification(newReservation);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
