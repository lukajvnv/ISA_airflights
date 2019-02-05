package com.airFlights.service.avio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightSeat;
import com.airFlights.repository.avio.FlightRepository;
import com.airFlights.repository.avio.FlightSeatRepository;

@Service
public class FlightSeatService {

	@Autowired
	private FlightSeatRepository seatRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<FlightSeat> getSeatsByFlight(Integer flightId){
		Flight flight = flightRepository.findById(flightId).get();
		return seatRepository.findByFlightOrderBySeatNumber(flight);
	}
}
