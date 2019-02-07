package com.airFlights.repository.avio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightRating;

public interface FlightRatingRepository extends JpaRepository<FlightRating, Integer> {
	
	@Query("select AVG(r.rating) from FlightRating r where r.flight = ?1")
	Float getFlightRating(Flight flight);

}
