package com.airFlights.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.user.User;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Integer reservationId;
	
	@OneToOne
	@JoinColumn(name="ticket_id")
	private AirlineTicket ticket;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
