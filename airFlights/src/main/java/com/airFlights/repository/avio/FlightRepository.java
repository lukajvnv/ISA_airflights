package com.airFlights.repository.avio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findAllByDepartureDateAndDepartureDestinationAndArrivalDestination(LocalDate departureDate
			,Destination departureDestination, Destination arrivalDestination);
	
	@Query("select f from Flight f where f.departureDate = ?1 and f.departureDestination = ?2 and f.arrivalDestination = ?3")
	List<Flight> searchFlights(LocalDate departureDate, Destination departureDestination, Destination arrivalDestination);
	
	List<Flight> findByAirline(Airline airline);
	List<Flight> findByDepartureDestination(Destination departureDestination);
	List<Flight> findByArrivalDestiantion(Destination arrivalDestination);

	
}
