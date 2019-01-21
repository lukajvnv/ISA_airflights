package com.airFlights.repository.avio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.avio.Airline;

public interface AirlineRepository extends JpaRepository<Airline,Integer>{

	/*@Autowired
	public EntityManager manager;
	
	
	boolean addDestinationToAirline(int airlineId, int destinationId) {
		
		return true;
	}*/
	
	List<Airline> findAllByOrderByName();
}
