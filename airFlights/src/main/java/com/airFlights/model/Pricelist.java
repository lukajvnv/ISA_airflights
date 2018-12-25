package com.airFlights.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pricelist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pricelistId;
	
	@Column(name = "economy", scale=2)
	private Float economyPrice;
	
	@Column(name = "business", scale=2)
	private Float businessPrice;
	
	@Column(name = "first", scale=2)
	private Float firstPrice;
	
	public Pricelist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPricelistId() {
		return pricelistId;
	}

	public void setPricelistId(Integer pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Float getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(Float economyPrice) {
		this.economyPrice = economyPrice;
	}

	public Float getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(Float businessPrice) {
		this.businessPrice = businessPrice;
	}

	public Float getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(Float firstPrice) {
		this.firstPrice = firstPrice;
	}


}
