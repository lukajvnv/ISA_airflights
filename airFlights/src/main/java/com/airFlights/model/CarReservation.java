package com.airFlights.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer carReservationId;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "car_id", nullable = false)
	private Integer carId;
	
	@Column(name = "pickup_date", nullable = false)
	private LocalDate pickupDate;
	
	@Column(name = "dropof_date", nullable = false)
	private LocalDate dropofDate;

	public CarReservation() {
		super();
	}

	public Integer getCarReservationId() {
		return carReservationId;
	}

	public void setCarReservationId(Integer carReservationId) {
		this.carReservationId = carReservationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getDropofDate() {
		return dropofDate;
	}

	public void setDropofDate(LocalDate dropofDate) {
		this.dropofDate = dropofDate;
	}

}
