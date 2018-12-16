package com.airFlights.model.avio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Airline {

	@Id
	@GeneratedValue
	private Long airlineId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="description", nullable=false)
	private String promoDescription;
	
	@Column(name="ratingSum", nullable=true)
	private Integer ratingSum;
	
	@Column(name="ratingNumber", nullable=true)
	private Integer ratingNumber;
	
	@ManyToMany
	@JoinTable(name="flight_destinations", joinColumns = @JoinColumn(name = "airline_id", referencedColumnName = "airlineId"), inverseJoinColumns = @JoinColumn(name="destination_id", referencedColumnName = "destinationId"))
	private Set<Destination> flightDestination = new HashSet<Destination>();
	
	@OneToMany(mappedBy = "airline", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> airlineFlights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AirlineTicket> discountTicket = new HashSet<AirlineTicket>();
	
	public Airline() {
		super();
	}

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPromoDescription() {
		return promoDescription;
	}

	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}

	public int getRatingSum() {
		return ratingSum;
	}

	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}

	public int getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(int ratingNumber) {
		this.ratingNumber = ratingNumber;
	}
	
	
	
}
