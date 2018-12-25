package com.airFlights.model.avio;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.airFlights.model.Pricelist;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightId;
	
	@Column(name = "departure_date", nullable = false)
	private LocalDate departureDate;
	
	@Column(name = "arrival_date", nullable = false)
	private LocalDate arrivalDate;
	
	@Column(name = "departure_time", nullable = false)
	private LocalTime departureTime;
	
	@Column(name = "arrival_time", nullable = false)
	private LocalTime arrivalTime;
	
	@Column(name = "duration", scale=2)
	private Float flightDuration;
	
	@Column(name = "distance", scale=2)
	private Float flightDistance;
	
	
	//@JsonIgnore
	@ColumnDefault(value = "0")
	private Integer ratingNum;
	
	//@JsonIgnore
	@ColumnDefault(value = "0")
	private Integer ratingSum;
	
	private Integer numberOfSeats;
	
	@Column(name = "airplane")
	private String airplaneName;
	
	@JsonIgnore
	@ColumnDefault(value = "0")
	@Column(name = "profit", scale=2)
	private Float flightProfit;

//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "departure_dest")
//	private Destination departureDestination;
//	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "arrival_dest")
//	private Destination arrivalDestination;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departure_dest")
	private Destination departureDestination;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "arrival_dest")
	private Destination arrivalDestination;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="flight_stops", joinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "flightId"), 
	inverseJoinColumns = @JoinColumn(name="stop_id", referencedColumnName = "destinationId"))
	private Set<Destination> stops = new HashSet<Destination>();
	
	
	//@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id")
	@JsonIgnoreProperties("airlineFlights")		/*allow getters?setters?*/
	private Airline airline;
	
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<AirlineTicket> tickets;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pricelist_id")
	private Pricelist pricelist;
	
	
	public Flight() {
		super();
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration() {
		Period period = Period.between(departureDate, arrivalDate);
		Duration duration = Duration.between(departureTime, arrivalTime);
		
		int daysH = period.getDays() * 24;
		float hours = duration.abs().toMinutes()*1f / 60;
		
		this.flightDuration = daysH + hours;
	}

	public int getRatingNum() {
		return ratingNum;
	}

	public int getRatingSum() {
		return ratingSum;
	}

	public void setRatingNum(Integer ratingNum) {
		this.ratingNum = ratingNum;
	}

	public void setRatingSum(Integer ratingSum) {
		this.ratingSum = ratingSum;
	}
	
	public double getFlightProfit() {
		return flightProfit;
	}

	public void setFlightProfit(float flightProfit) {
		this.flightProfit = flightProfit;
	}

	public Destination getDepartureDestination() {
		return departureDestination;
	}

	public void setDepartureDestination(Destination departureDestination) {
		this.departureDestination = departureDestination;
	}

	public Destination getArrivalDestination() {
		return arrivalDestination;
	}

	public void setArrivalDestination(Destination arrivalDestination) {
		this.arrivalDestination = arrivalDestination;
	}

	public Set<Destination> getStops() {
		return stops;
	}

	public void setStops(Set<Destination> stops) {
		this.stops = stops;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Set<AirlineTicket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<AirlineTicket> tickets) {
		this.tickets = tickets;
	}

	public void setFlightDuration(Float flightDuration) {
		this.flightDuration = flightDuration;
	}


	public void setFlightProfit(Float flightProfit) {
		this.flightProfit = flightProfit;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getAirplaneName() {
		return airplaneName;
	}

	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Float getFlightDistance() {
		return flightDistance;
	}

	public void setFlightDistance(Float flightDistance) {
		this.flightDistance = flightDistance;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}
	
	
}
