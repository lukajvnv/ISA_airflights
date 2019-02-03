package com.airFlights.controller.avio;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.PricelistDTO;
import com.airFlights.dto.avio.DestinationDTO;
import com.airFlights.dto.avio.FlightDTO;
import com.airFlights.model.Pricelist;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightReturn;
import com.airFlights.model.avio.SearchFlightParams;
import com.airFlights.model.user.User;
import com.airFlights.service.avio.FlightService;
import com.airFlights.service.avio.MailService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<FlightDTO>> getFlights(){
		List<Flight> flights = flightService.getAllFlights();
		
		List<FlightDTO> answer = new ArrayList<FlightDTO>();
		for(Flight f: flights) {
			answer.add(new FlightDTO(f));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<FlightDTO> getFlight(@PathVariable("flightId") Integer flightId){
		Flight flight = flightService.getFlight(flightId);
		return new ResponseEntity<>(new FlightDTO(flight), HttpStatus.OK);
	}
	
	/*@RequestMapping(path = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewFlight(@RequestParam int  airlineId, @RequestBody Flight flight){
		flightService.saveNewFlight(flight, airlineId);
		return new ResponseEntity<>("Uspesno dodat", HttpStatus.OK);
	}*/
	
	@RequestMapping(path = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewFlight(/*@RequestParam int  airlineId, */@RequestBody Flight flight){
		flightService.saveNewFlight(flight);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateFlight(@RequestBody FlightDTO flight){
		flightService.updateFlight(flight);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@RequestMapping(path = "/{flightId}", method = RequestMethod.DELETE)
//	public ResponseEntity<String> removeFlight(@PathVariable("flightId") Integer flightId){
//		flightService.deleteFlight(flightId);
//		return new ResponseEntity<>("Uspesno dodat", HttpStatus.OK);
//	}
	
	/*@RequestMapping(path = "/{DEP}-{ARI}/{depDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> searchFlights(@PathVariable("DEP") String dep_dest, @PathVariable("ARI") String ari_dest, 
			@PathVariable("depDate") String depDate){
		List<Flight> flights = flightService.searchFlights(dep_dest, ari_dest, depDate);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}*/
	
	/*@RequestMapping(path = "/{DEP}-{ARI}/{depDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> searchFlights(@PathVariable("DEP") int dep_dest, @PathVariable("ARI") int ari_dest, 
			@PathVariable("depDate") String depDate){
		List<Flight> flights = flightService.searchFlights(dep_dest, ari_dest, depDate);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}*/
	
	@RequestMapping(path = "/search/oneWay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightDTO>> searchFlightsOneWay(@RequestBody SearchFlightParams flightParams){
		List<Flight> flights = flightService.searchFlightsOneWayBasic(flightParams);
				
		List<FlightDTO> answer = new ArrayList<FlightDTO>();
		for(Flight f: flights) {
			answer.add(new FlightDTO(f));
		}
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/search/roundTrip", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightReturn>> searchFlightsRoundTrip(@RequestBody SearchFlightParams flightParams){
		List<FlightReturn> flights = flightService.searchFlightsRoundTripBasic(flightParams);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/search/multiCity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> searchFlightsMultiCity(@RequestBody SearchFlightParams flightParams){
		//List<Flight> flights = flightService.searchFlights(flightParams);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/getAllDestinations", method = RequestMethod.GET)
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<DestinationDTO>> getAllDestinations(){
		List<Destination> destinations = flightService.getAllDestinations();
		
		List<DestinationDTO> answer = new ArrayList<DestinationDTO>();
		for(Destination f: destinations) {
			answer.add(new DestinationDTO(f));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/pricelist/all", method = RequestMethod.GET)
	public ResponseEntity<List<PricelistDTO>> getAllPricelist(){
		List<Pricelist> pricelist = flightService.getAllPricelist();
		
		List<PricelistDTO> answer = new ArrayList<PricelistDTO>();
		for(Pricelist f: pricelist) {
			answer.add(new PricelistDTO(f));
		}
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/pricelist/new", method = RequestMethod.POST)
	public ResponseEntity<List<Pricelist>> addNewPricelist(@RequestBody Pricelist newPricelist){
		flightService.addNewPricelist(newPricelist);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/sendMail", method = RequestMethod.GET)
	public ResponseEntity<List<Destination>> sendMail(){
		try {
			mailService.sendNotification(new User(), "Potvrda rezervacije", "Proba");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (MessagingException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
