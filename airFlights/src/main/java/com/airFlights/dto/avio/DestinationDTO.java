package com.airFlights.dto.avio;

import com.airFlights.model.avio.Destination;

public class DestinationDTO {

	private Integer destinationId;
	
	private String destinationCode;
	
	private String destinationName;
	
	private String destinationAirport;
	
	private String destinationDescription;
	
	public DestinationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DestinationDTO(Destination destination) {
		super();
		this.destinationId = destination.getDestinationId();
		this.destinationCode = destination.getDestinationCode();
		this.destinationName = destination.getDestinationName();
		this.destinationAirport = destination.getDestinationAirport();
		this.destinationDescription = destination.getDestinationDescription();
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
}
