package com.airFlights.model.avio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.airFlights.model.Pricelist;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer airlineId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="description", nullable=false)
	private String promoDescription;
	
	@JsonIgnore
	private String luggageInfo;
	
	@JsonIgnore
	@Column(name="ratingSum", nullable=true)
	private Integer ratingSum;
	
	@JsonIgnore
	@Column(name="ratingNumber", nullable=true)
	private Integer ratingNumber;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="flight_destinations", joinColumns = @JoinColumn(name = "airline_id", referencedColumnName = "airlineId"), inverseJoinColumns = @JoinColumn(name="destination_id", referencedColumnName = "destinationId"))
	private Set<Destination> flightDestinations = new HashSet<Destination>();
	
	@OneToMany(mappedBy = "airline", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Flight> airlineFlights = new HashSet<Flight>();
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AirlineTicket> discountTickets = new HashSet<AirlineTicket>();
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pricelist_id")
	private Pricelist pricelist;
	
	
	public Airline() {
		super();
	}

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
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

	public String getLuggageInfo() {
		return luggageInfo;
	}

	public void setLuggageInfo(String luggageInfo) {
		this.luggageInfo = luggageInfo;
	}

	public Set<Destination> getFlightDestination() {
		return flightDestinations;
	}

	public void setFlightDestination(Set<Destination> flightDestination) {
		this.flightDestinations = flightDestination;
	}

	public Set<Flight> getAirlineFlights() {
		return airlineFlights;
	}

	public void setAirlineFlights(Set<Flight> airlineFlights) {
		this.airlineFlights = airlineFlights;
	}

	public Set<AirlineTicket> getDiscountTicket() {
		return discountTickets;
	}

	public void setDiscountTicket(Set<AirlineTicket> discountTicket) {
		this.discountTickets = discountTicket;
	}

	public void setRatingSum(Integer ratingSum) {
		this.ratingSum = ratingSum;
	}

	public void setRatingNumber(Integer ratingNumber) {
		this.ratingNumber = ratingNumber;
	}
	
	
	
}
