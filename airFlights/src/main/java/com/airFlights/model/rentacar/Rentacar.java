package com.airFlights.model.rentacar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rentacar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer rentacarId;
	
	@Column(name = "rentacarName", nullable = false)
	private String name;
	
	@Column(name = "rentacarAdress", nullable = false)
	private String adress;
	
	@Column(name = "rentacarDescription", nullable = false)
	private String promoDescription;
	
	@JsonIgnore
	@ColumnDefault(value = "0")
	@Column(name = "rentacarAvgRating", nullable = true)
	private Float avgRating;
	
	@JsonIgnore
	@ColumnDefault(value = "0")
	@Column(name = "rentacarRatingNumber", nullable = true)
	private Integer ratingNumber;
	
	@Column(name = "rentacarIncome", nullable = true)
	private Float income;
	
	@OneToMany(mappedBy = "rentacar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Car> cars = new HashSet<Car>();
	
	@OneToMany(mappedBy = "rentacar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RentaBranch> branches = new HashSet<RentaBranch>();
	
	@OneToMany(mappedBy = "rentacar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RentaService> services = new HashSet<RentaService>();
	
	public Rentacar() {
		super();
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
