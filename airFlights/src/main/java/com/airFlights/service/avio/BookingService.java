package com.airFlights.service.avio;

import java.util.Date;
import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		Flight flight = flightRepository.findById(seat.getFlight().getFlightId()).get();
		
		FlightSeat seatExist = seatRepository.findBySeatNumberAndFlight(seat.getSeatNumber(), flight);
		
		//dodavanje sedista sa brojem koji vec postoji
		if(seatExist != null) {
			throw new Exception();
		}
		
		FlightSeat newSeat = new FlightSeat(false, false, seat.getSeatNumber(), flight);
		
		seatRepository.saveAndFlush(newSeat);
		
		
		return getSeatsByFlight(flight.getFlightId());
	}
	
	public List<FlightSeat> removeSeat(FlightSeatDTO seat) throws Exception{
		FlightSeat s = seatRepository.findById(seat.getId()).get();
		if(s.isReserved()) {
			throw new Exception("Nije moguce obrisati zelljeno sediste, jer je rezervisaano");
		}
		
		seatRepository.deleteById(seat.getId());
		
		Flight flight = flightRepository.findById(seat.getFlight().getFlightId()).get();
		
		
		
		return getSeatsByFlight(flight.getFlightId());
	}
	
	public List<FlightSeat> quickTicket(AirlineTicketDTO ticket) throws Exception{
		
		Flight flight = flightRepository.findById(ticket.getFlight().getFlightId()).get();
		Airline airline = flight.getAirline();
		
		FlightSeat seat = seatRepository.findById(ticket.getSeat().getId()).get();
		
		//u slucaju da sediste ne postoji vise
		if(seat == null) {
			throw new Exception("Nije moguce rezervisati zelljeno sediste");
		}
		
		// u slucaju da je neko rezervisao mesto u medjuvremenu
		if(seat.isReserved()) {
			throw new Exception("Nije moguce rezervisati zelljeno sediste");
		}
		
		
		seat.setReserved(true);
		seat.setDiscountTicket(true);
		
		AirlineTicket newTicket = new AirlineTicket(ticket.getTicketClass(), ticket.getTicketStatus(), ticket.getBasePrice(), ticket.getDiscount(), ticket.getSellingPrice(), false);
		newTicket.setSeat(seat);
		newTicket.setAirline(airline);
		newTicket.setFlight(flight);
		
		airlineTicketRepository.saveAndFlush(newTicket);
		
		return getSeatsByFlight(flight.getFlightId());
	}
	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = OptimisticLockException.class)
	public Reservation makeReservation(ReservationDTO reservationFront) throws OptimisticLockException , Exception {
		
		String userUsername = reservationFront.getUser().getUsername();
		User user = userRepository.findByUsername(userUsername);
		
		AirlineTicketDTO ticketFront = reservationFront.getTicket();
		AirlineTicket ticket = new AirlineTicket(ticketFront.getTicketClass(), ticketFront.getTicketStatus(), ticketFront.getBasePrice(), ticketFront.getDiscount(),
				ticketFront.getSellingPrice(), ticketFront.getMarkedFlight());
		ticket.setSellingDate(new Date());
		
		FlightSeat seat = seatRepository.findById(ticketFront.getSeat().getId()).get();
		
		//u slucaju da sediste ne postoji vise
		if(seat == null) {
			throw new Exception("Nije moguce rezervisati zelljeno sediste");
		}
		
		// u slucaju da je neko rezervisao mesto u medjuvremenu
		if(seat.isReserved()) {
			throw new Exception("Nije moguce rezervisati zelljeno sediste");
		}
		
		
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
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = OptimisticLockException.class)
	public Reservation makeQuickReservation(ReservationDTO reservationFront) throws OptimisticLockException{
		
		String userUsername = reservationFront.getUser().getUsername();
		User user = userRepository.findByUsername(userUsername);
		
		AirlineTicketDTO ticketFront = reservationFront.getTicket();
		AirlineTicket persistTicket = airlineTicketRepository.findById(ticketFront.getTicketId()).get();
		persistTicket.setSellingDate(new Date());
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
		reservation.setPassportNum(res.getPassportNum());
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
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
