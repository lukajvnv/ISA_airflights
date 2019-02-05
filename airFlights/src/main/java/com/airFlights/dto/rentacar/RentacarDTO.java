package com.airFlights.dto.rentacar;

import java.util.HashSet;
import java.util.Set;

import com.airFlights.model.rentacar.Car;
import com.airFlights.model.rentacar.RentaBranch;
import com.airFlights.model.rentacar.RentaService;

public class RentacarDTO {
	
	private Long rentacarId;
	
	private String name;
	
	private String adress;
	
	private String promoDescription;
	
	private Float avgRating;
	
	private Integer ratingNumber;
	
	private Float income;
	
	private Set<Car> cars = new HashSet<Car>();

	private Set<RentaBranch> branches = new HashSet<RentaBranch>();
	
	private Set<RentaService> services = new HashSet<RentaService>();

	public RentacarDTO() {
	}

	public RentacarDTO(Long rentacarId, String name, String adress, String promoDescription, Float avgRating,
			Integer ratingNumber, Float income, Set<Car> cars, Set<RentaBranch> branches, Set<RentaService> services) {
		super();
		this.rentacarId = rentacarId;
		this.name = name;
		this.adress = adress;
		this.promoDescription = promoDescription;
		this.avgRating = avgRating;
		this.ratingNumber = ratingNumber;
		this.income = income;
		this.cars = cars;
		this.branches = branches;
		this.services = services;
	}

	public Long getRentacarId() {
		return rentacarId;
	}

	public void setRentacarId(Long rentacarId) {
		this.rentacarId = rentacarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPromoDescription() {
		return promoDescription;
	}

	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}

	public Float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}
	
	public Integer getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(Integer ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	public Float getIncome() {
		return income;
	}

	public void setIncome(Float income) {
		this.income = income;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Set<RentaBranch> getBranches() {
		return branches;
	}

	public void setBranches(Set<RentaBranch> branches) {
		this.branches = branches;
	}

	public Set<RentaService> getServices() {
		return services;
	}

	public void setServices(Set<RentaService> services) {
		this.services = services;
	}

}
