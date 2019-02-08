package com.airFlights.service.avio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.dto.avio.AirlineDTO;
import com.airFlights.dto.avio.DestinationDTO;
import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.avio.Destination;
import com.airFlights.repository.avio.AirlineRepository;
import com.airFlights.repository.avio.DestinationRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	public List<Airline> findAllAirlines() {
		return airlineRepository.findAllByOrderByName();
	}
	
	public Airline findAirlineById(Integer index) {
		return airlineRepository.findById(index).get(); 
	}
	
	public Set<AirlineTicket> getQuickTickets(Integer id) {
		Airline airline = airlineRepository.findById(id).get();
		return airline.getDiscountTickets();
	}
	
	public void updateAirline(Airline persistAirline, AirlineDTO airline) {
		persistAirline.setName(airline.getName());
		persistAirline.setAddress(airline.getAddress());
		persistAirline.setCity(airline.getCity());
		persistAirline.setPromoDescription(airline.getPromoDescription());
		persistAirline.setLuggageInfo(airline.getLuggageInfo());
		
		Set<Destination> flightDestination = new HashSet<Destination>();
		for(DestinationDTO d : airline.getFlightDestinations()) {
			flightDestination.add(destinationRepository.findById(d.getDestinationId()).get());
		}
		persistAirline.setFlightDestinations(flightDestination);
		
		airlineRepository.save(persistAirline);
	}
		
	public void addNewDestination(Destination destination) {
		destinationRepository.saveAndFlush(destination);
	}
	
}
