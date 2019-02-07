package com.airFlights.service.avio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.dto.ReservationDTO;
import com.airFlights.dto.UserDTO;
import com.airFlights.dto.avio.AirlineTicketDTO;
import com.airFlights.dto.avio.FlightSeatDTO;
import com.airFlights.model.Reservation;
import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.avio.AirlineTicket.TicketStatus;
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
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<FlightSeat> getSeatsByFlight(Integer flightId){
		Flight flight = flightRepository.findById(flightId).get();
		return seatRepository.findByFlightOrderBySeatNumber(flight);
	}
	
	public List<FlightSeat> addNewSeat(FlightSeatDTO seat) throws Exception{
		FlightSeat seatExist = seatRepository.findBySeatNumber(seat.getSeatNumber());
		if(seatExist != null) {
			throw new Exception();
		}
		
		Flight flight = flightRepository.findById(seat.getFlight().getFlightId()).get();
		FlightSeat newSeat = new FlightSeat(false, false, seat.getSeatNumber(), flight);
		
		seatRepository.saveAndFlush(newSeat);
		
		
		return getSeatsByFlight(flight.getFlightId());
	}
	
	public List<FlightSeat> removeSeat(FlightSeatDTO seat){
		
		//seatRepository.deleteById(seat.getId());
		seatRepository.deleteById(seat.getId());
		
		Flight flight = flightRepository.findById(seat.getFlight().getFlightId()).get();
		
		
		
		return getSeatsByFlight(flight.getFlightId());
	}
	
	public List<FlightSeat> quickTicket(AirlineTicketDTO ticket){
		
		Flight flight = flightRepository.findById(ticket.getFlight().getFlightId()).get();
		Airline airline = flight.getAirline();
		FlightSeat seat = seatRepository.findById(ticket.getSeat().getId()).get();
		seat.setReserved(true);
		seat.setDiscountTicket(true);
		
		AirlineTicket newTicket = new AirlineTicket(ticket.getTicketClass(), ticket.getTicketStatus(), ticket.getBasePrice(), ticket.getDiscount(), ticket.getSellingPrice(), false);
		newTicket.setSeat(seat);
		newTicket.setAirline(airline);
		newTicket.setFlight(flight);
		
		airlineTicketRepository.saveAndFlush(newTicket);
		
		return getSeatsByFlight(flight.getFlightId());
	}
	
	
	
	public Reservation makeReservation(ReservationDTO reservationFront) {
		
		String userUsername = reservationFront.getUser().getUsername();
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

		//reservationRepository.saveAndFlush(reservation);
		Reservation save = reservationRepository.save(reservation);
		
		return save;
	}
	
	public Reservation makeQuickReservation(ReservationDTO reservationFront) {
		
		String userUsername = reservationFront.getUser().getUsername();
		User user = userRepository.findByUsername(userUsername);
		
		AirlineTicketDTO ticketFront = reservationFront.getTicket();
		AirlineTicket persistTicket = airlineTicketRepository.findById(ticketFront.getTicketId()).get();
		persistTicket.setAirline(null);
				
		airlineTicketRepository.saveAndFlush(persistTicket);
		Reservation reservation = new Reservation(persistTicket, user, reservationFront.getPassportNum());

		Reservation save = reservationRepository.save(reservation);
		
		return save;
	}
	
	public Reservation getReservationById(Integer id) {
		return reservationRepository.findById(id).get();
	}
	
	public List<Reservation> getReservations(UserDTO userFront){
		User user = userRepository.findByUsername(userFront.getUsername());
		return reservationRepository.getUserReservations(user, TicketStatus.RESERVED);	
	}
	
	public List<Reservation> getFlightInvitation(UserDTO userFront){
		User user = userRepository.findByUsername(userFront.getUsername());
		return reservationRepository.getUserReservations(user, TicketStatus.INVITED);	
	}
	
	public List<Reservation> acceptFlight(ReservationDTO res){
		Reservation reservation = reservationRepository.findById(res.getReservationId()).get();
		AirlineTicket ticket = reservation.getTicket();
		ticket.setTicketStatus(TicketStatus.RESERVED);
		
		reservationRepository.saveAndFlush(reservation);

		return getFlightInvitation(res.getUser());
	}
	
	public List<Reservation> declineFlight(ReservationDTO res){
		Reservation reservation = reservationRepository.findById(res.getReservationId()).get();

		AirlineTicket ticket = reservation.getTicket();
		FlightSeat seat = ticket.getSeat();
		seat.setReserved(false);
		//seatRepository.save(seat);
		
		reservationRepository.deleteById(res.getReservationId());

		return getFlightInvitation(res.getUser());
	}
	
}
