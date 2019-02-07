package com.airFlights.dto.rentacar;

import java.time.LocalDate;

import com.airFlights.model.rentacar.Car;

public class CarDTO {

	private Integer carId;

	private Boolean reserved;
	
	private LocalDate pickupDate;
	
	private LocalDate dropofDate;
	
	private String pickupLocation;
	
	private String dropofLocation;
	
	private String carName;
	
	private String carBrand;
	
	private String carModel;
	
	private Integer carYear;
	
	private Integer numberOfSeats;
	
	private Float price;
	
	public CarDTO() {
		
	}

	public CarDTO(Integer carId, Boolean reserved, LocalDate pickupDate, LocalDate dropofDate, String pickupLocation,
			String dropofLocation, String carName, String carBrand, String carModel, Integer carYear,
			Integer numberOfSeats, Float price) {
		super();
		this.carId = carId;
		this.reserved = reserved;
		this.pickupDate = pickupDate;
		this.dropofDate = dropofDate;
		this.pickupLocation = pickupLocation;
		this.dropofLocation = dropofLocation;
		this.carName = carName;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carYear = carYear;
		this.numberOfSeats = numberOfSeats;
		this.price = price;
	}
	
	public CarDTO(Car car) {
		this.carId = car.getCarId();
		this.reserved = car.getReserved();
		this.pickupDate = car.getPickupDate();
		this.dropofDate = car.getDropofDate();
		this.pickupLocation = car.getPickupLocation();
		this.dropofLocation = car.getDropofLocation();
		this.carName = car.getCarName();
		this.carBrand = car.getCarBrand();
		this.carModel = car.getCarModel();
		this.carYear = car.getCarYear();
		this.numberOfSeats = car.getNumberOfSeats();
		this.price = car.getPrice();
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
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

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropofLocation() {
		return dropofLocation;
	}

	public void setDropofLocation(String dropofLocation) {
		this.dropofLocation = dropofLocation;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getCarYear() {
		return carYear;
	}

	public void setCarYear(Integer carYear) {
		this.carYear = carYear;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
