package com.airFlights.dto.avio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import com.airFlights.dto.PricelistDTO;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;

public class FlightDTO {

	private Integer flightId;
	
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	
	private LocalTime departureTime;	
	private LocalTime arrivalTime;
	
	private Float flightDuration;	
	private Float flightDistance;
		
	private Integer ratingNum;
	private Integer ratingSum;
	
	private Integer numberOfSeats;
	private Integer numberOfEconomyAvailableSeats;
	
	private Integer numberOfBusinessAvailableSeats;	
	private Integer numberOfFirstAvailableSeats;
	
	private String airplaneName;	
	private Float flightProfit;
	private String additionalService;	
	private Float luggage;
	
	private DestinationDTO departureDestination;
	private DestinationDTO arrivalDestination;
	private Set<DestinationDTO> stops = new HashSet<DestinationDTO>();
	
	private AirlineDTO airline;
	private Set<AirlineTicketDTO> tickets;
	
	private PricelistDTO pricelist;
	
	
	public FlightDTO() {
		// TODO Auto-generated constructor stub
	}


	public FlightDTO(Flight flight) {
		super();
		this.flightId = flight.getFlightId();
		this.departureDate = flight.getDepartureDate();
		this.arrivalDate = flight.getArrivalDate();
		this.departureTime = flight.getDepartureTime();
		this.arrivalTime = flight.getArrivalTime();
		this.flightDuration = flight.getFlightDuration();
		this.flightDistance = flight.getFlightDistance();
		this.ratingNum = flight.getRatingNum();
		this.ratingSum = flight.getRatingSum();
		this.numberOfSeats = flight.getNumberOfSeats();
		this.numberOfEconomyAvailableSeats = flight.getNumberOfEconomyAvailableSeats();
		this.numberOfBusinessAvailableSeats = flight.getNumberOfBusinessAvailableSeats();
		this.numberOfFirstAvailableSeats = flight.getNumberOfFirstAvailableSeats();
		this.airplaneName = flight.getAirplaneName();
		this.flightProfit = flight.getFlightProfit();
		this.additionalService = flight.getAdditionalService();
		this.luggage = flight.getLuggage();
		
		this.departureDestination = new DestinationDTO(flight.getDepartureDestination());
		this.arrivalDestination = new DestinationDTO(flight.getArrivalDestination());
		
		Set<DestinationDTO> stops = new HashSet<DestinationDTO>();
		for(Destination stop: flight.getStops()) {
			stops.add(new DestinationDTO(stop));
		}
		this.stops = stops;
		
		
		this.pricelist = new PricelistDTO(flight.getPricelist());
		this.airline = new AirlineDTO(flight.getAirline());
		
		//this.tickets = tickets;  !!!!!!!!!!!!!!!!
	}


	public Integer getFlightId() {
		return flightId;
	}


	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
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


	public Float getFlightDuration() {
		return flightDuration;
	}


	public void setFlightDuration(Float flightDuration) {
		this.flightDuration = flightDuration;
	}


	public Float getFlightDistance() {
		return flightDistance;
	}


	public void setFlightDistance(Float flightDistance) {
		this.flightDistance = flightDistance;
	}


	public Integer getRatingNum() {
		return ratingNum;
	}


	public void setRatingNum(Integer ratingNum) {
		this.ratingNum = ratingNum;
	}


	public Integer getRatingSum() {
		return ratingSum;
	}


	public void setRatingSum(Integer ratingSum) {
		this.ratingSum = ratingSum;
	}


	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


	public Integer getNumberOfEconomyAvailableSeats() {
		return numberOfEconomyAvailableSeats;
	}


	public void setNumberOfEconomyAvailableSeats(Integer numberOfEconomyAvailableSeats) {
		this.numberOfEconomyAvailableSeats = numberOfEconomyAvailableSeats;
	}


	public Integer getNumberOfBusinessAvailableSeats() {
		return numberOfBusinessAvailableSeats;
	}


	public void setNumberOfBusinessAvailableSeats(Integer numberOfBusinessAvailableSeats) {
		this.numberOfBusinessAvailableSeats = numberOfBusinessAvailableSeats;
	}


	public Integer getNumberOfFirstAvailableSeats() {
		return numberOfFirstAvailableSeats;
	}


	public void setNumberOfFirstAvailableSeats(Integer numberOfFirstAvailableSeats) {
		this.numberOfFirstAvailableSeats = numberOfFirstAvailableSeats;
	}


	public String getAirplaneName() {
		return airplaneName;
	}


	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}


	public Float getFlightProfit() {
		return flightProfit;
	}


	public void setFlightProfit(Float flightProfit) {
		this.flightProfit = flightProfit;
	}


	public String getAdditionalService() {
		return additionalService;
	}


	public void setAdditionalService(String additionalService) {
		this.additionalService = additionalService;
	}


	public Float getLuggage() {
		return luggage;
	}


	public void setLuggage(Float luggage) {
		this.luggage = luggage;
	}


	public DestinationDTO getDepartureDestination() {
		return departureDestination;
	}


	public void setDepartureDestination(DestinationDTO departureDestination) {
		this.departureDestination = departureDestination;
	}


	public DestinationDTO getArrivalDestination() {
		return arrivalDestination;
	}


	public void setArrivalDestination(DestinationDTO arrivalDestination) {
		this.arrivalDestination = arrivalDestination;
	}


	public Set<DestinationDTO> getStops() {
		return stops;
	}


	public void setStops(Set<DestinationDTO> stops) {
		this.stops = stops;
	}


	public AirlineDTO getAirline() {
		return airline;
	}


	public void setAirline(AirlineDTO airline) {
		this.airline = airline;
	}


	public Set<AirlineTicketDTO> getTickets() {
		return tickets;
	}


	public void setTickets(Set<AirlineTicketDTO> tickets) {
		this.tickets = tickets;
	}


	public PricelistDTO getPricelist() {
		return pricelist;
	}


	public void setPricelist(PricelistDTO pricelist) {
		this.pricelist = pricelist;
	}
}
