package com.airFlights.service.avio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.SearchFlightParams;
import com.airFlights.repository.avio.AirlineRepository;
import com.airFlights.repository.avio.DestinationRepository;
import com.airFlights.repository.avio.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired 
	private DestinationRepository destinationRepository;
	
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Flight getFlight(Integer flightId) {
		return flightRepository.findById(flightId).get();
	}
	
	public void updateFlight(Flight flight) {
		flightRepository.save(flight);
	}
	
	public void saveNewFlight(Flight flight, int airlineId) {
		try {
			Airline airline = airlineRepository.findById(airlineId).get();
			if(airline == null) {
				return ;
			}
			flight.setAirline(airline);
			
			flight.setFlightDuration();
			flightRepository.save(flight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFlight(Integer flightId) {
		flightRepository.deleteById(flightId);
	}
	
	public List<Flight> searchFlights(int dep_dest,  int ari_dest, String depDate){
		LocalDate d = LocalDate.parse(depDate);

		
		Destination departureDestination = destinationRepository.findById(dep_dest).get();
		Destination arrivalDestination = destinationRepository.findById(ari_dest).get();
		
		List<Flight> f = flightRepository.searchFlights(d, departureDestination, arrivalDestination);
		//List<Flight> flights = flightRepository.findAllByDepartureDateAndDepartureDestinationAndArrivalDestination(d, departureDestination, arrivalDestination);		
				
		return f;
	}
	
	public List<Flight> searchFlights(SearchFlightParams filterParams){
		
		List<Flight> flights = flightRepository.findByAirline(filterParams.getAirlineFilter());
		
		switch(filterParams.getFlightType()) {
		case ONE_WAY:
			break;
		case ROUND_TRIP:
			break;
		case MULTI_CITY:
			break;
		}
		
		return flights;
	}
}
