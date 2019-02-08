package com.airFlights.dto;

import java.time.LocalDate;

public class SearchCarDTO {

	private Integer id;
	
	private LocalDate pickupDate;
	
	private String pickupLocation;
	
	private LocalDate dropofDate;
	
	private String dropofLocation;
	
	private Integer fromPrice;
	
	private Integer toPrice;
	
	private Integer numberOfSeats;
	
	private String type;
	
	private Integer carId;
	
	public SearchCarDTO() {
	}
	
	public SearchCarDTO(Integer id, LocalDate pickupDate, String pickupLocation, LocalDate dropofDate, String dropofLocation,
			Integer fromPrice, Integer toPrice, Integer numberOfSeats, String type, Integer carId) {
		super();
		this.id = id;
		this.pickupDate = pickupDate;
		this.pickupLocation = pickupLocation;
		this.dropofDate = dropofDate;
		this.dropofLocation = dropofLocation;
		this.fromPrice = fromPrice;
		this.toPrice = toPrice;
		this.numberOfSeats = numberOfSeats;
		this.type = type;
		this.carId = carId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public LocalDate getDropofDate() {
		return dropofDate;
	}

	public void setDropofDate(LocalDate dropofDate) {
		this.dropofDate = dropofDate;
	}

	public String getDropofLocation() {
		return dropofLocation;
	}

	public void setDropofLocation(String dropofLocation) {
		this.dropofLocation = dropofLocation;
	}

	public Integer getFromPrice() {
		return fromPrice;
	}

	public void setFromPrice(Integer fromPrice) {
		this.fromPrice = fromPrice;
	}

	public Integer getToPrice() {
		return toPrice;
	}

	public void setToPrice(Integer toPrice) {
		this.toPrice = toPrice;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

}
