package com.airFlights.repository.avio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightSeat;


public interface FlightSeatRepository extends JpaRepository<FlightSeat, Integer> {

	List<FlightSeat> findByFlightOrderBySeatNumber(Flight flight);
	
	FlightSeat findBySeatNumber(Integer seatNum);
	
}
