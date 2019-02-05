package com.airFlights.service.avio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.dto.ReservationDTO;
import com.airFlights.dto.avio.AirlineTicketDTO;
import com.airFlights.model.Reservation;
import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightSeat;
import com.airFlights.model.user.User;
import com.airFlights.repository.ReservationRepository;
import com.airFlights.repository.UserRepository;
import com.airFlights.repository.avio.AirlineTicketRepository;
import com.airFlights.repository.avio.FlightRepository;
import com.airFlights.repository.avio.FlightSeatRepository;

@Service
public class BookingService {

	@Autowired
	private FlightSeatRepository seatRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired 
	private AirlineTicketRepository airlineTicketRepository;
	
	public List<FlightSeat> getSeatsByFlight(Integer flightId){
		Flight flight = flightRepository.findById(flightId).get();
		return seatRepository.findByFlightOrderBySeatNumber(flight);
	}
	
	public void makeReservation(ReservationDTO reservationFront) {
		
		String userUsername = reservationFront.getUser().getUsername();
//		User user = userRepository.findByUsername("pass1");
		User user = userRepository.findByUsername(userUsername);
		
		AirlineTicketDTO ticketFront = reservationFront.getTicket();
		AirlineTicket ticket = new AirlineTicket(ticketFront.getTicketClass(), ticketFront.getTicketStatus(), ticketFront.getBasePrice(), ticketFront.getDiscount(),
				ticketFront.getSellingPrice(), ticketFront.getMarkedFlight());
		
		FlightSeat seat = seatRepository.findById(ticketFront.getSeat().getId()).get();
		Flight flight = flightRepository.findById(ticketFront.getFlight().getFlightId()).get();
		seat.setReserved(true);
		//seatRepository.saveAndFlush(seat);
		
		ticket.setFlight(flight);
		ticket.setSeat(seat);
		
		//flightRepository.saveAndFlush(flight);
		
		airlineTicketRepository.saveAndFlush(ticket);
		Reservation reservation = new Reservation(ticket, user, reservationFront.getPassportNum());

		reservationRepository.saveAndFlush(reservation);
		
	}
}
