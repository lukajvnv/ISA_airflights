package com.airFlights.dto.rentacar;

public class CarDTO {

	private Long carId;

	private Boolean reserved;
	
	private String pickupDate;
	
	private String dropofDate;
	
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

	public CarDTO(Long carId, Boolean reserved, String pickupDate, String dropofDate, String pickupLocation,
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

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getDropofDate() {
		return dropofDate;
	}

	public void setDropofDate(String dropofDate) {
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
