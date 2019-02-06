package com.airFlights.dto.rentacar;

import java.util.HashSet;
import java.util.Set;

import com.airFlights.model.rentacar.Car;
import com.airFlights.model.rentacar.RentaBranch;
import com.airFlights.model.rentacar.RentaService;

public class RentacarDTO {
	
	private Integer rentacarId;
	
	private String name;
	
	private String adress;
	
	private String promoDescription;
	
	private Float avgRating;
	
	private Integer ratingNumber;
	
	private Float income;
	
	private Set<CarDTO> cars = new HashSet<CarDTO>();

	private Set<RentaBranchDTO> branches = new HashSet<RentaBranchDTO>();
	
	private Set<RentaServiceDTO> services = new HashSet<RentaServiceDTO>();

	public RentacarDTO() {
	}

	public RentacarDTO(Integer rentacarId, String name, String adress, String promoDescription, Float avgRating,
			Integer ratingNumber, Float income, Set<CarDTO> cars, Set<RentaBranchDTO> branches, Set<RentaServiceDTO> services) {
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

	public Integer getRentacarId() {
		return rentacarId;
	}

	public void setRentacarId(Integer rentacarId) {
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

	public Set<CarDTO> getCars() {
		return cars;
	}

	public void setCars(Set<CarDTO> cars) {
		this.cars = cars;
	}

	public Set<RentaBranchDTO> getBranches() {
		return branches;
	}

	public void setBranches(Set<RentaBranchDTO> branches) {
		this.branches = branches;
	}

	public Set<RentaServiceDTO> getServices() {
		return services;
	}

	public void setServices(Set<RentaServiceDTO> services) {
		this.services = services;
	}

}
