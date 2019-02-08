package com.airFlights.controller.avio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.ReservationDTO;
import com.airFlights.dto.UserDTO;
import com.airFlights.dto.avio.AirlineTicketDTO;
import com.airFlights.dto.avio.FlightSeatDTO;
import com.airFlights.model.Reservation;
import com.airFlights.model.avio.FlightSeat;
import com.airFlights.model.user.User;
import com.airFlights.service.avio.BookingService;
import com.airFlights.service.avio.FriendShipService;
import com.airFlights.service.avio.MailService;

@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private FriendShipService friendshipService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(path = "/seats/flight/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<List<FlightSeatDTO>> getFlights(@PathVariable("flightId") Integer flightId){
		List<FlightSeat> flightSeats = bookingService.getSeatsByFlight(flightId);
		
		List<FlightSeatDTO> answer = new ArrayList<FlightSeatDTO>();
		for(FlightSeat f: flightSeats) {
			answer.add(new FlightSeatDTO(f));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/newReservation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> makeReservation(@RequestBody ReservationDTO newReservation){
		try {
			bookingService.makeReservation(newReservation);
			mailService.sendFinishedReservationNotification(newReservation);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (OptimisticLockException o) {
			return new ResponseEntity<>("Nije moguce rezervisati zeljeno mesto", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(path = "/buy/quickTicket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> quickTicketReservation(@RequestBody ReservationDTO newReservation){
		try {
			bookingService.makeQuickReservation(newReservation);
			mailService.sendFinishedReservationNotification(newReservation);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (OptimisticLockException o) {
			return new ResponseEntity<>("Nije moguce rezervisati zeljeno mesto", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@RequestMapping(path = "/getReservation/{reservationId}", method = RequestMethod.GET)
	public ResponseEntity<ReservationDTO> getReservation(@PathVariable("reservationId") Integer reservationId){
		try {
			Reservation reservation = bookingService.getReservationById(reservationId);
			ReservationDTO answer = new ReservationDTO(reservation);
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@RequestMapping(path = "/friends", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getFriends(@RequestBody UserDTO user){
		List<User> friendships =  friendshipService.getAllFriendsByUser(user.getUsername());
	
		List<UserDTO> answer = new ArrayList<UserDTO>();
		for(User u: friendships) {
			answer.add(new UserDTO(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCity(), u.getPhone_number()));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/friend/request", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getFriendRequests(@RequestBody UserDTO user){
		List<User> friendships =  friendshipService.getAllFriendsRequestByUser(user.getUsername());
	
		List<UserDTO> answer = new ArrayList<UserDTO>();
		for(User u: friendships) {
			answer.add(new UserDTO(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCity(), u.getPhone_number()));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<User> users =  bookingService.getAllUsers();
	
		List<UserDTO> answer = new ArrayList<UserDTO>();
		for(User u: users) {
			answer.add(new UserDTO(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCity(), u.getPhone_number()));
		}
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/friend/add/{currentUser}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> addFriend(@RequestBody UserDTO user, @PathVariable("currentUser") String username){
		try {
			friendshipService.addFriend(username, user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
	}
	
	@RequestMapping(path = "/friend/remove/{currentUser}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> removeFriend(@RequestBody UserDTO user, @PathVariable("currentUser") String username){
		try {
			List<User> friendships =  friendshipService.removeFriend(username, user);

			List<UserDTO> answer = new ArrayList<UserDTO>();
			for(User u: friendships) {
				answer.add(new UserDTO(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCity(), u.getPhone_number()));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/friend/refuse/{currentUser}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> refuseFriend(@RequestBody UserDTO user, @PathVariable("currentUser") String username){
		try {
			List<User> friendships =  friendshipService.refuseFriend(username, user);

			List<UserDTO> answer = new ArrayList<UserDTO>();
			for(User u: friendships) {
				answer.add(new UserDTO(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCity(), u.getPhone_number()));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/friend/accept/{currentUser}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> acceptFriend(@RequestBody UserDTO user, @PathVariable("currentUser") String username){
		try {
			List<User> friendships =  friendshipService.acceptFriend(username, user);

			List<UserDTO> answer = new ArrayList<UserDTO>();
			for(User u: friendships) {
				answer.add(new UserDTO(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCity(), u.getPhone_number()));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/friend/flight/invite/{currentUser}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> inviteFriends(@RequestBody Collection<ReservationDTO> reservations, @PathVariable("currentUser") String username){
		try {
			if(reservations == null || reservations.size() == 0) throw new Exception();
			User inviter = friendshipService.getUserWhoInviteToFlight(username);
			for(ReservationDTO r : reservations) {
				Reservation savedReservation =  bookingService.makeReservation(r);
				mailService.sendFriendFlightInvitationNotification(inviter, savedReservation);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (OptimisticLockException o) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/user/reservations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationDTO>> getReservations(@RequestBody UserDTO user){
		try {
			List<Reservation> reservations =  bookingService.getReservations(user);

			List<ReservationDTO> answer = new ArrayList<ReservationDTO>();
			for(Reservation r: reservations) {
				answer.add(new ReservationDTO(r));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/user/flightInvitations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationDTO>> getFlightInvitation(@RequestBody UserDTO user){
		try {
			List<Reservation> reservations =  bookingService.getFlightInvitation(user);

			List<ReservationDTO> answer = new ArrayList<ReservationDTO>();
			for(Reservation r: reservations) {
				answer.add(new ReservationDTO(r));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/user/accept", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationDTO>> accept(@RequestBody ReservationDTO res){
		try {
			List<Reservation> reservations =  bookingService.acceptFlight(res);

			List<ReservationDTO> answer = new ArrayList<ReservationDTO>();
			for(Reservation r: reservations) {
				answer.add(new ReservationDTO(r));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/user/refuse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationDTO>> decline(@RequestBody ReservationDTO res){
		try {
			List<Reservation> reservations =  bookingService.declineFlight(res);

			List<ReservationDTO> answer = new ArrayList<ReservationDTO>();
			for(Reservation r: reservations) {
				answer.add(new ReservationDTO(r));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/newSeat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightSeatDTO>> addSeat(@RequestBody FlightSeatDTO seat){
		try {
			List<FlightSeat> flightSeats =  bookingService.addNewSeat(seat);

			List<FlightSeatDTO> answer = new ArrayList<FlightSeatDTO>();
			for(FlightSeat f: flightSeats) {
				answer.add(new FlightSeatDTO(f));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/removeSeat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightSeatDTO>> removeSeat(@RequestBody FlightSeatDTO seat){
		try {
			List<FlightSeat> flightSeats =  bookingService.removeSeat(seat);

			List<FlightSeatDTO> answer = new ArrayList<FlightSeatDTO>();
			for(FlightSeat f: flightSeats) {
				answer.add(new FlightSeatDTO(f));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/quickTicket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightSeatDTO>> quickTicket(@RequestBody AirlineTicketDTO ticket){
		try {
			List<FlightSeat> flightSeats =  bookingService.quickTicket(ticket);

			List<FlightSeatDTO> answer = new ArrayList<FlightSeatDTO>();
			for(FlightSeat f: flightSeats) {
				answer.add(new FlightSeatDTO(f));
			}
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getFlights(@PathVariable("username") String username){
		User user = bookingService.getUserByUsername(username);
		
		UserDTO u = new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity(), user.getPhone_number());
		
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

}
