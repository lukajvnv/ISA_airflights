package com.airFlights.dto;

import com.airFlights.model.Pricelist;

public class PricelistDTO {
	
	
	private Integer pricelistId;
	
	private Float economyPrice;
	
	private Float businessPrice;
	
	private Float firstPrice;
	
	public PricelistDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PricelistDTO(Pricelist pricelist) {
		super();
		this.pricelistId = pricelist.getPricelistId();
		this.economyPrice = pricelist.getEconomyPrice();
		this.businessPrice = pricelist.getBusinessPrice();
		this.firstPrice = pricelist.getFirstPrice();
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
