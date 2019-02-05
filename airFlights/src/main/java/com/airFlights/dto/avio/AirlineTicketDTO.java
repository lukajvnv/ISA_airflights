package com.airFlights.dto.avio;

import com.airFlights.model.avio.AirlineTicket;
import com.airFlights.model.avio.AirlineTicket.TicketClass;
import com.airFlights.model.avio.AirlineTicket.TicketStatus;

public class AirlineTicketDTO {

	private Integer ticketId;

	
	private TicketClass ticketClass;
	private TicketStatus ticketStatus;
	
	
	//private Airline airline;
	private FlightDTO flight;
	private FlightSeatDTO seat;
	
	private Float basePrice;
	// private Integer seatNumber;
	private Float discount;
	private Float sellingPrice;
	
	
	private Boolean markedFlight;
	 	
	public AirlineTicketDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public AirlineTicketDTO(Integer ticketId, TicketClass ticketClass, TicketStatus ticketStatus, Float basePrice,
			Float discount, Float sellingPrice, Boolean markedFlight) {
		super();
		this.ticketId = ticketId;
		this.ticketClass = ticketClass;
		this.ticketStatus = ticketStatus;
		this.basePrice = basePrice;
		this.discount = discount;
		this.sellingPrice = sellingPrice;
		this.markedFlight = markedFlight;
	}
	
	public AirlineTicketDTO(AirlineTicket ticket) {
		this(ticket.getTicketId(), ticket.getTicketClass(), ticket.getTicketStatus(), ticket.getBasePrice(), ticket.getDiscount(), ticket.getSellingPrice(), ticket.getMarkedFlight());
		this.seat = new FlightSeatDTO(ticket.getSeat());
		this.flight = new FlightDTO(ticket.getFlight());	
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public TicketClass getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(TicketClass ticketClass) {
		this.ticketClass = ticketClass;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public FlightSeatDTO getSeat() {
		return seat;
	}

	public void setSeat(FlightSeatDTO seat) {
		this.seat = seat;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}

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
}
