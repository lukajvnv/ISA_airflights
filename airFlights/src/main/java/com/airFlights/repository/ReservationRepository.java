package com.airFlights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airFlights.model.Reservation;
import com.airFlights.model.avio.AirlineTicket.TicketStatus;
import com.airFlights.model.user.User;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	@Query("select r from Reservation r where r.user = ?1 and r.ticket.ticketStatus = ?2")
	List<Reservation> getUserReservations(User user, TicketStatus ticketStatus);

}
