package com.airFlights.controller.avio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.model.avio.Airline;
import com.airFlights.service.avio.AirlineService;


@RestController
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Airline>> getAllAirlines() {
		
		List<Airline> airlines = airlineService.findAllAirlines();
		return new ResponseEntity<>(airlines, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Airline> getAirlineById(@PathVariable("id") int index){
		
		Airline airline = airlineService.findAirlineById(index);
		if(airline == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		airlineService.getAverageMark(index);
		return new ResponseEntity<>(airline, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAirline(@PathVariable("id") int index){
		try {
			airlineService.removeAirline(index);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Obrisan", HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateAirline() {
		
	}*/
	
}
