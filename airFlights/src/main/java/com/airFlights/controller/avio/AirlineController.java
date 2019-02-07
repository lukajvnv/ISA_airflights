package com.airFlights.controller.avio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.avio.AirlineDTO;
import com.airFlights.dto.avio.AirlineTicketDTO;
import com.airFlights.dto.avio.FlightDTO;
import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.service.avio.AirlineService;




@RestController
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AirlineDTO>> getAllAirlines() {
		List<Airline> airlines = airlineService.findAllAirlines();
		
		List<AirlineDTO> answer = new ArrayList<AirlineDTO>();
		for(Airline airline : airlines) {
			answer.add(new AirlineDTO(airline));
		}
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable("id") Integer index){
		
		Airline airline = airlineService.findAirlineById(index);
		if(airline == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		//airlineService.getAverageMark(index);
		return new ResponseEntity<>(new AirlineDTO(airline), HttpStatus.OK);
	}
	
	@RequestMapping(value="/tickets/{airlineId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AirlineTicketDTO>> getQuicktickets(@PathVariable("airlineId") Integer index){
		
		Set<AirlineTicket> tickets = airlineService.getQuickTickets(index);
		List<AirlineTicketDTO> answer = new ArrayList<AirlineTicketDTO>();
		for(AirlineTicket t: tickets) {
			answer.add(new AirlineTicketDTO(t));
		}
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAirline(@RequestBody AirlineDTO airline){
		Airline persistAirline = airlineService.findAirlineById(airline.getAirlineId()); 
			
		if (persistAirline == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		airlineService.updateAirline(persistAirline, airline);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/flights/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightDTO>> getAirlineFlights(@PathVariable("id") Integer index){
		
		Airline airline = airlineService.findAirlineById(index);
		if(airline == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<Flight> airlineFlights = airline.getAirlineFlights();
		
		List<FlightDTO> fligths = new ArrayList<FlightDTO>();
		for(Flight f: airlineFlights) {
			fligths.add(new FlightDTO(f));
		}
		
		return new ResponseEntity<>(fligths, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/newDestination", method = RequestMethod.POST)
	public ResponseEntity<String> addDestinationToAirline(@RequestBody Destination newDestination){
		airlineService.addNewDestination(newDestination);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
