package com.airFlights.model.avio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "ticket")
public class AirlineTicket {

	public enum TicketStatus{
		FREE, INVITED, RESERVED, CANCELLED, REDUCED_PRICE, FINISHED_FLIGHT
	}
	
	public enum TicketClass{
		ECONOMY, BUSINESS, FIRST
	}
	
	public enum FlightType{
		ROUND_TRIP, ONE_WAY, MULTI_CITY
	}
	
	@Enumerated
	@Column(name="class", nullable=false, columnDefinition = "tinyint")
	private TicketClass ticketClass;
	
	@Enumerated
	@Column(name="status", nullable=false, columnDefinition = "tinyint")
	private TicketStatus ticketStatus;
	
	@Id
	@GeneratedValue
	private Integer ticketId;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "airline_id")
	private Airline airline;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "seat_id")
	private FlightSeat seat;
	
	private Float basePrice;
	// private Integer seatNumber;
	private Float discount;
	private Float sellingPrice;
	
	private Boolean markedFlight;
	 	
	public AirlineTicket() {
		super();
	}

	 
	public AirlineTicket(TicketClass ticketClass, TicketStatus ticketStatus, Float basePrice, Float discount,
			Float sellingPrice, Boolean markedFlight) {
		super();
		this.ticketClass = ticketClass;
		this.ticketStatus = ticketStatus;
		this.basePrice = basePrice;
		this.discount = discount;
		this.sellingPrice = sellingPrice;
		this.markedFlight = markedFlight;
	}


	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}

//	public Integer getSeatNumber() {
//		return seatNumber;
//	}
//
//	public void setSeatNumber(Integer seatNumber) {
//		this.seatNumber = seatNumber;
//	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Boolean getMarkedFlight() {
		return markedFlight;
	}

	public void setMarkedFlight(Boolean markedFlight) {
		this.markedFlight = markedFlight;
	}

	public TicketClass getTicketClass() {
		return ticketClass;
	}


	public void setTicketClass(TicketClass ticketClass) {
		this.ticketClass = ticketClass;
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public Airline getAirline() {
		return airline;
	}


	public void setAirline(Airline airline) {
		this.airline = airline;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public FlightSeat getSeat() {
		return seat;
	}


	public void setSeat(FlightSeat seat) {
		this.seat = seat;
	}


}
