package com.airFlights.repository.avio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.avio.Destination;

public interface  DestinationRepository extends JpaRepository<Destination, Integer> {
	List<Destination> findAllByOrderByDestinationCode();

}
