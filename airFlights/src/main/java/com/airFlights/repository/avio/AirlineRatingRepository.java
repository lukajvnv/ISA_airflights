package com.airFlights.repository.avio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.AirlineRating;

public interface AirlineRatingRepository extends JpaRepository<AirlineRating, Integer> {

	List<AirlineRating> getByAirline(Airline airline);
	
	@Query("select AVG(r.rating) from AirlineRating r where r.airline = ?1")
	Float getAirlineRating(Airline airline);
}
