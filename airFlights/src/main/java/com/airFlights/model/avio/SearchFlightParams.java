package com.airFlights.model.avio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.airFlights.model.avio.AirlineTicket.FlightType;
import com.airFlights.model.avio.AirlineTicket.TicketClass;

public class SearchFlightParams {

	
	private LocalDate departureDate;
	private LocalDate arrivalDate;

	private TicketClass ticketClass;
	private int personNum;
	private FlightType flightType;
	private float luggage;
	
	private Airline airlineFilter;
	private float flightDurationFilter;
	private LocalTime arrivalTimeFilterLower;
	private LocalTime arrivalTimeFilterUpper;
	private LocalTime departureTimeFilterLower;
	private LocalTime departureTimeFilterUpper;
	
	private List<Destination> departureDestinations;
	private List<Destination> arrivalDestinations;
	
	private float priceFilter;
	
	public SearchFlightParams() {
		super();
	}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	public TicketClass getTicketClass() {
		return ticketClass;
	}
	public void setTicketClass(TicketClass ticketClass) {
		this.ticketClass = ticketClass;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public FlightType getFlightType() {
		return flightType;
	}
	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}
	public float getLuggage() {
		return luggage;
	}
	public void setLuggage(float luggage) {
		this.luggage = luggage;
	}
	public Airline getAirlineFilter() {
		return airlineFilter;
	}
	public void setAirlineFilter(Airline airlineFilter) {
		this.airlineFilter = airlineFilter;
	}
	public float getFlightDurationFilter() {
		return flightDurationFilter;
	}
	public void setFlightDurationFilter(float flightDurationFilter) {
		this.flightDurationFilter = flightDurationFilter;
	}
	
	public List<Destination> getDepartureDestinations() {
		return departureDestinations;
	}
	public void setDepartureDestinations(List<Destination> departureDestinations) {
		this.departureDestinations = departureDestinations;
	}
	public List<Destination> getArrivalDestinations() {
		return arrivalDestinations;
	}
	public void setArrivalDestinations(List<Destination> arrivalDestinations) {
		this.arrivalDestinations = arrivalDestinations;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalTime getArrivalTimeFilterLower() {
		if(arrivalTimeFilterLower == null) {
			arrivalTimeFilterLower =  LocalTime.of(0, 0);
		}
		return arrivalTimeFilterLower;
	}

	public void setArrivalTimeFilterLower(LocalTime arrivalTimeFilterLower) {
		this.arrivalTimeFilterLower = arrivalTimeFilterLower;
	}

	public LocalTime getArrivalTimeFilterUpper() {
		if(arrivalTimeFilterUpper == null) {
			arrivalTimeFilterUpper =  LocalTime.of(23, 59);
		}
		return arrivalTimeFilterUpper;
	}

	public void setArrivalTimeFilterUpper(LocalTime arrivalTimeFilterUpper) {
		this.arrivalTimeFilterUpper = arrivalTimeFilterUpper;
	}

	public LocalTime getDepartureTimeFilterLower() {
		if(departureTimeFilterLower == null) {
			departureTimeFilterLower =  LocalTime.of(0, 0);
		}
		return departureTimeFilterLower;
	}

	public void setDepartureTimeFilterLower(LocalTime departureTimeFilterLower) {
		this.departureTimeFilterLower = departureTimeFilterLower;
	}

	public LocalTime getDepartureTimeFilterUpper() {
		if(departureTimeFilterUpper == null) {
			departureTimeFilterUpper =  LocalTime.of(23, 59);
		}
		return departureTimeFilterUpper;
	}

	public void setDepartureTimeFilterUpper(LocalTime departureTimeFilterUpper) {
		this.departureTimeFilterUpper = departureTimeFilterUpper;
	}

	public float getPriceFilter() {
		return priceFilter;
	}

	public void setPriceFilter(float priceFliiter) {
		this.priceFilter = priceFliiter;
	}	
}
