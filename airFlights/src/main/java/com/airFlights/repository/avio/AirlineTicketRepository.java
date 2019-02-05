package com.airFlights.repository.avio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.avio.AirlineTicket;

public interface AirlineTicketRepository extends JpaRepository<AirlineTicket, Integer> {

}
