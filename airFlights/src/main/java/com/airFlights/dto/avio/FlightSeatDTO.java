package com.airFlights.dto.avio;

import com.airFlights.model.avio.FlightSeat;

public class FlightSeatDTO {
	
	
	private Integer id;
	private boolean reserved;
	private boolean discountTicket;
	private int seatNumber;
	
//	@Column
//	private int roww;
//	
//	@Column
//	private String columnn;
	
	private FlightDTO flight;

	public FlightSeatDTO() {
		super();
	}

	public FlightSeatDTO(Integer id, boolean reserved, boolean dicountTicket, int seatNumber) {
		super();
		this.id = id;
		this.reserved = reserved;
		this.discountTicket = dicountTicket;
		this.seatNumber = seatNumber;
	}
	
	public FlightSeatDTO(FlightSeat seat) {
		this(seat.getId(), seat.isReserved(), seat.isDiscountTicket(), seat.getSeatNumber());
		
		this.flight = new FlightDTO(seat.getFlight());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public boolean isDiscountTicket() {
		return discountTicket;
	}

	public void setDicountTicket(boolean discountTicket) {
		this.discountTicket = discountTicket;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

}
