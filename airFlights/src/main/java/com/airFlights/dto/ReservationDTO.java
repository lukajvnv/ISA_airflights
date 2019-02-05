package com.airFlights.dto;

import com.airFlights.dto.avio.AirlineTicketDTO;
import com.airFlights.model.Reservation;

public class ReservationDTO {

	private Integer reservationId;
	
	private AirlineTicketDTO ticket;	
	private UserDTO user;
	
	private String passportNum;
	
	public ReservationDTO() {
		super();
	}

	public ReservationDTO(Reservation reservation) {
		super();
		this.reservationId = reservation.getReservationId();
		this.passportNum = reservation.getPassportNum();
		
		this.ticket = new AirlineTicketDTO(reservation.getTicket());
		this.user = new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity(), user.getPhone_number());	
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public AirlineTicketDTO getTicket() {
		return ticket;
	}

	public void setTicket(AirlineTicketDTO ticket) {
		this.ticket = ticket;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

}
