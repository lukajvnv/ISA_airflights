package com.airFlights.model.rentacar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue
	private Long carId;
	
	@Column(name = "reserved", nullable = false)
	private Boolean reserved;
	
	@Column(name = "pickupDate", nullable = false)
	private String pickupDate;
	
	@Column(name = "dropofDate", nullable = false)
	private String dropofDate;
	
	@Column(name = "pickupLocation", nullable = false)
	private String pickupLocation;
	
	@Column(name = "dropofLocation", nullable = false)
	private String dropofLocation;
	
	@Column(name = "carName", nullable = false)
	private String carName;
	
	@Column(name = "carBrand", nullable = false)
	private String carBrand;
	
	@Column(name = "carModel", nullable = false)
	private String carModel;
	
	@Column(name = "carYear", nullable = true)
	private Integer carYear;
	
	@Column(name = "numberOfSeats", nullable = true)
	private Integer numberOfSeats;
	
	@Column(name = "price", nullable = false)
	private Float price;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Rentacar rentacar;

	public Car() {
		super();
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

	public Rentacar getRentacar() {
		return rentacar;
	}

	public void setRentacar(Rentacar rentacar) {
		this.rentacar = rentacar;
	}
}
