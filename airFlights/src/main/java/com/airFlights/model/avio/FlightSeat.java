package com.airFlights.model.avio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class FlightSeat {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column
		private boolean reserved;
		
		@Column
		private boolean discountTicket;
		
		@Column
		private int seatNumber;
		
//		@Column
//		private int roww;
//		
//		@Column
//		private String columnn;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "flight_id")
		private Flight flight;

		public FlightSeat(boolean reserved, boolean discountTicket, int seatNumber, Flight flight) {
			super();
			this.reserved = reserved;
			this.discountTicket = discountTicket;
			this.seatNumber = seatNumber;
			
			this.flight = flight;
		}

		public FlightSeat() {
			super();
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

		public int getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(int seatNumber) {
			this.seatNumber = seatNumber;
		}

		public Flight getFlight() {
			return flight;
		}

		public void setFlight(Flight flight) {
			this.flight = flight;
		}

		public boolean isDiscountTicket() {
			return discountTicket;
		}

		public void setDiscountTicket(boolean discountTicket) {
			this.discountTicket = discountTicket;
		}
		

}
