package com.airFlights.model.avio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Destination {

	@Id
	@GeneratedValue
	private Long destinationId;
	
	@Column(name="code", length=3, nullable=false)
	private String destinationCode;
	
	@Column(name="name", nullable=false)
	private String destinationName;
	
	@Column(name="airport")
	private String destinationAirport;
	
	@Column(name="description")
	private String destinationDescription;

	@ManyToMany(mappedBy="flightDestination")
	private Set<Airline> airlines;
	
	@ManyToMany(mappedBy = "stops")
	private Set<Flight> flights;
	
	public Destination() {
		super();
	}
	
	public Long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Long destinationId) {
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
