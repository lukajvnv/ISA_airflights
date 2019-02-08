package com.airFlights.dto.rentacar;

import java.time.LocalDate;

import com.airFlights.model.CarReservation;

public class CarReservationDTO {

	private Integer carReservationId;
	
	private String username;
	
	private Integer carId;
	
	private LocalDate pickupDate;
	
	private LocalDate dropofDate;

	public CarReservationDTO(Integer carReservationId, String username, Integer carId, LocalDate pickupDate,
			LocalDate dropofDate) {
		super();
		this.carReservationId = carReservationId;
		this.username = username;
		this.carId = carId;
		this.pickupDate = pickupDate;
		this.dropofDate = dropofDate;
	}
	
	public CarReservationDTO(CarReservation carReservation) {
		this.carReservationId = carReservation.getCarReservationId();
		this.username = carReservation.getUsername();
		this.carId = carReservation.getCarId();
		this.pickupDate = carReservation.getPickupDate();
		this.dropofDate = carReservation.getDropofDate();
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
