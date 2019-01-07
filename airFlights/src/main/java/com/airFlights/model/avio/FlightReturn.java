package com.airFlights.model.avio;

public class FlightReturn {

	private Flight flightAway;
	private Flight flightReturn;
	
	public FlightReturn(Flight flightAway, Flight flightReturn) {
		super();
		this.flightAway = flightAway;
		this.flightReturn = flightReturn;
	}

	public Flight getFlightAway() {
		return flightAway;
	}

	public void setFlightAway(Flight flightAway) {
		this.flightAway = flightAway;
	}

	public Flight getFlightReturn() {
		return flightReturn;
	}

	public void setFlightReturn(Flight flightReturn) {
		this.flightReturn = flightReturn;
	}
}
