package com.airFlights.controller.avio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.SearchFlightParams;
import com.airFlights.service.avio.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> getFlight(){
		List<Flight> flights = flightService.getAllFlights();
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<Flight> getFlight(@PathVariable("flightId") int flightId){
		Flight flight = flightService.getFlight(flightId);
		return new ResponseEntity<>(flight, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewFlight(@RequestParam int  airlineId, @RequestBody Flight flight){
		flightService.saveNewFlight(flight, airlineId);
		return new ResponseEntity<>("Uspesno dodat", HttpStatus.OK);
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateFlight(@RequestParam int  airlineId, @RequestBody Flight flight){
		flightService.saveNewFlight(flight, airlineId);
		return new ResponseEntity<>("Uspesno dodat", HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{flightId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeFlight(@PathVariable("flightId") int flightId){
		flightService.deleteFlight(flightId);
		return new ResponseEntity<>("Uspesno dodat", HttpStatus.OK);
	}
	
	/*@RequestMapping(path = "/{DEP}-{ARI}/{depDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> searchFlights(@PathVariable("DEP") String dep_dest, @PathVariable("ARI") String ari_dest, 
			@PathVariable("depDate") String depDate){
		List<Flight> flights = flightService.searchFlights(dep_dest, ari_dest, depDate);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}*/
	
	@RequestMapping(path = "/{DEP}-{ARI}/{depDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> searchFlights(@PathVariable("DEP") int dep_dest, @PathVariable("ARI") int ari_dest, 
			@PathVariable("depDate") String depDate){
		List<Flight> flights = flightService.searchFlights(dep_dest, ari_dest, depDate);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> searchFlights(@RequestBody SearchFlightParams flightParams){
		List<Flight> flights = flightService.searchFlights(flightParams);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/getAllDestinations", method = RequestMethod.GET)
	public ResponseEntity<List<Destination>> searchFlights(){
		List<Destination> destinations = flightService.getAllDestinations();
		return new ResponseEntity<>(destinations, HttpStatus.OK);
	}
	
}
