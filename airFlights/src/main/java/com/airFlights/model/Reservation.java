package com.airFlights.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.user.User;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;
	
	@OneToOne
	@JoinColumn(name="ticket_id")
	private AirlineTicket ticket;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String passportNum;
	
	/*@Column(name = "booking_date", nullable = false)
	private LocalDate departureDate;
	
	@Column(name = "arrival_date", nullable = false)
	private LocalDate arrivalDate;
	DATE?
	*/
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(AirlineTicket ticket, User user, String passportNum) {
		super();
		this.ticket = ticket;
		this.user = user;
		this.passportNum = passportNum;
		
		
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public AirlineTicket getTicket() {
		return ticket;
	}

	public void setTicket(AirlineTicket ticket) {
		this.ticket = ticket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	
}
