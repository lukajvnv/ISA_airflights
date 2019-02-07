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
public class AirlineRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer airlineRatingId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "airline_id")
	private Airline airline;
	
	private Float rating;

	public AirlineRating() {
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

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

}
