package com.airFlights.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pricelist {

	@Id
	@GeneratedValue
	private Integer pricelistId;
	
	private String economy;
	private String business;
	private String first;
	
	public Pricelist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEconomy() {
		return economy;
	}

	public void setEconomy(String economy) {
		this.economy = economy;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
	
}
