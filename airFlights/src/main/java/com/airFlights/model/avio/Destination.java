package com.airFlights.model.avio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer destinationId;
	
	@Column(name="code", length=3, nullable=false)
	private String destinationCode;
	
	@Column(name="name", nullable=false)
	private String destinationName;
	
	@Column(name="airport")
	private String destinationAirport;
	
	@Column(name="description")
	private String destinationDescription;

	@ManyToMany(mappedBy="flightDestinations", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Airline> airlines;
	
	@ManyToMany(mappedBy = "stops")
	@JsonIgnore
	private Set<Flight> flights;
	
	public Destination() {
		super();
	}
	
	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDestinationDescription() {
		return destinationDescription;
	}

	public void setDestinationDescription(String destinationDescription) {
		this.destinationDescription = destinationDescription;
	}

	public Set<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(Set<Airline> airlines) {
		this.airlines = airlines;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	
}
