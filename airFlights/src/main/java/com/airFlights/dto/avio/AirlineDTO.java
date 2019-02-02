package com.airFlights.dto.avio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.Destination;

public class AirlineDTO {

	private Integer airlineId;
	private String name;
	private String address;
	private String city;
	private String promoDescription;
	private String luggageInfo;
	private Integer ratingSum;
	private Integer ratingNumber;
	
	
	private Set<DestinationDTO> flightDestinations = new HashSet<DestinationDTO>();
	
	private Set<FlightDTO> airlineFlights = new HashSet<FlightDTO>();
	
	private Set<AirlineTicketDTO> discountTickets = new HashSet<AirlineTicketDTO>();
	
	public AirlineDTO () {
		super();
	}
	
	

	public AirlineDTO(Airline airline) {
		this.airlineId = airline.getAirlineId();
		this.name = airline.getName();
		this.address = airline.getAddress();
		this.city = airline.getCity();
		this.promoDescription = airline.getPromoDescription();
		this.luggageInfo = airline.getLuggageInfo();
		this.ratingSum = airline.getRatingSum();
		this.ratingNumber = airline.getRatingNumber();

		Set<DestinationDTO> flightDest = new HashSet<DestinationDTO>();
		for(Destination dest : airline.getFlightDestinations()) {
			flightDest.add(new DestinationDTO(dest));
		}
		this.flightDestinations = flightDest;
		
		// this.airlineFlights = airlineFlights;       //!!!!!!!!!!!!!!!!!
		// this.discountTickets = discountTickets;
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

	public String getLuggageInfo() {
		return luggageInfo;
	}

	public void setLuggageInfo(String luggageInfo) {
		this.luggageInfo = luggageInfo;
	}

	public Integer getRatingSum() {
		return ratingSum;
	}

	public void setRatingSum(Integer ratingSum) {
		this.ratingSum = ratingSum;
	}

	public Integer getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(Integer ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	public Set<DestinationDTO> getFlightDestinations() {
		return flightDestinations;
	}

	public void setFlightDestinations(Set<DestinationDTO> flightDestinations) {
		this.flightDestinations = flightDestinations;
	}

	public Set<FlightDTO> getAirlineFlights() {
		return airlineFlights;
	}

	public void setAirlineFlights(Set<FlightDTO> airlineFlights) {
		this.airlineFlights = airlineFlights;
	}

	public Set<AirlineTicketDTO> getDiscountTickets() {
		return discountTickets;
	}

	public void setDiscountTickets(Set<AirlineTicketDTO> discountTickets) {
		this.discountTickets = discountTickets;
	}
}
