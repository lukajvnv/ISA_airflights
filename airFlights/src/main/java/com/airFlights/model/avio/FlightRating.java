package com.airFlights.model.avio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.airFlights.model.user.User;

@Entity
public class FlightRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer airlineRatingId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	private Float rating;

	public FlightRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAirlineRatingId() {
		return airlineRatingId;
	}

	public void setAirlineRatingId(Integer airlineRatingId) {
		this.airlineRatingId = airlineRatingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getAirline() {
		return flight;
	}

	public void setAirline(Flight flight) {
		this.flight = flight;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}
}
