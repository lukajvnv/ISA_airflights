package com.airFlights.service.avio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightReturn;
import com.airFlights.model.avio.SearchFlightParams;
import com.airFlights.repository.avio.AirlineRepository;
import com.airFlights.repository.avio.DestinationRepository;
import com.airFlights.repository.avio.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Flight getFlight(Integer flightId) {
		return flightRepository.findById(flightId).get();
	}
	
	public void updateFlight(Flight flight) {
		flightRepository.save(flight);
	}
	
	public void saveNewFlight(Flight flight, int airlineId) {
		try {
			Airline airline = airlineRepository.findById(airlineId).get();
			if(airline == null) {
				return ;
			}
			flight.setAirline(airline);
			
			flight.setFlightDuration();
			flightRepository.save(flight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFlight(Integer flightId) {
		flightRepository.deleteById(flightId);
	}
	
	/*public List<Flight> searchFlights(int dep_dest,  int ari_dest, String depDate){
		LocalDate d = LocalDate.parse(depDate);

		
		Destination departureDestination = destinationRepository.findById(dep_dest).get();
		Destination arrivalDestination = destinationRepository.findById(ari_dest).get();
		
		List<Flight> f = flightRepository.searchFlightsOneWay(d, departureDestination, arrivalDestination);
		//List<Flight> flights = flightRepository.findAllByDepartureDateAndDepartureDestinationAndArrivalDestination(d, departureDestination, arrivalDestination);		
				
		return f;
	}*/
	
	public List<Flight> searchFlightsOneWayBasic(SearchFlightParams filterParams){
		List<Flight> flights = new ArrayList<>();
		
		LocalDate departureDate = filterParams.getDepartureDate();		
		Destination departureDestination = filterParams.getDepartureDestinations().get(0);
		Destination arrivalDestination = filterParams.getArrivalDestinations().get(0);
		int seatNum = filterParams.getPersonNum();
		
		Airline airline = filterParams.getAirlineFilter();
		LocalTime depFilterLower = filterParams.getDepartureTimeFilterLower();
		LocalTime depFilterUpper = filterParams.getDepartureTimeFilterUpper();
		LocalTime arrFilterLower = filterParams.getArrivalTimeFilterLower();
		LocalTime arrFilterUpper = filterParams.getArrivalTimeFilterUpper();
		
		switch (filterParams.getTicketClass()) {
			case ECONOMY:
				flights = flightRepository.searchFlightsOneWayEconomy(departureDate, departureDestination, arrivalDestination, seatNum, airline, depFilterLower, depFilterUpper, arrFilterLower, arrFilterUpper);
				break;
			case BUSINESS:
				flights = flightRepository.searchFlightsOneWayBusiness(departureDate, departureDestination, arrivalDestination,seatNum, airline);
				break;
			case FIRST:
				flights = flightRepository.searchFlightsOneWayEconomy(departureDate, departureDestination, arrivalDestination, seatNum, airline);
				break;
	
			default:
				return flights;
			}
		
		return flights;
	}
	
	public List<FlightReturn> searchFlightsRoundTripBasic(SearchFlightParams filterParams){
		List<FlightReturn> flights = new ArrayList<>();
		
		LocalDate departureDate = filterParams.getDepartureDate();
		LocalDate arrivalDate = filterParams.getArrivalDate();
		Destination departureDestination = filterParams.getDepartureDestinations().get(0);
		Destination arrivalDestination = filterParams.getArrivalDestinations().get(0);
		int seatNum = filterParams.getPersonNum();
		
		switch (filterParams.getTicketClass()) {
			case ECONOMY:
				flights = flightRepository.searchFlightsRoundTripEconomy(departureDate, arrivalDate, departureDestination, arrivalDestination, seatNum);
				break;
			case BUSINESS:
				flights = flightRepository.searchFlightsRoundTripBusiness(departureDate, arrivalDate, departureDestination, arrivalDestination,seatNum);
				break;
			case FIRST:
				flights = flightRepository.searchFlightsRoundTripFirst(departureDate, arrivalDate, departureDestination, arrivalDestination, seatNum);
				break;
			default:
				return flights;
			}
		
		return flights;
	}
	
	public List<Flight> searchFlightsMultiCityBasic(SearchFlightParams filterParams){
		List<Flight> flights = new ArrayList<>();
		
		//LocalDate departureDate = filterParams.getDepartureDate();		
		//Destination departureDestination = filterParams.getDepartureDestinations().get(0);
		//Destination arrivalDestination = filterParams.getArrivalDestinations().get(0);
		//int seatNum = filterParams.getPersonNum();
		
		switch (filterParams.getTicketClass()) {
			case ECONOMY:
				//flights = flightRepository.searchFlightsOneWayEconomy(departureDate, departureDestination, arrivalDestination, seatNum);
				break;
			case BUSINESS:
				//flights = flightRepository.searchFlightsOneWayBusiness(departureDate, departureDestination, arrivalDestination,seatNum);
				break;
			case FIRST:
				//flights = flightRepository.searchFlightsOneWayEconomy(departureDate, departureDestination, arrivalDestination, seatNum);
				break;
	
			default:
				return flights;
			}
		
		return flights;
	}
	
	
//	public List<Flight> searchFlights(SearchFlightParams filterParams){
//		
//		//List<Flight> flights = flightRepository.findByAirline(filterParams.getAirlineFilter());
//		
//		 //LocalTime arrivalTimeFilterLower = filterParams.getArrivalTimeFilterLower();
//		 //LocalTime arrivalTimeFilterUpper = filterParams.getArrivalTimeFilterUpper();
//		 //LocalTime departureTimeFilterLower = filterParams.getDepartureTimeFilterLower();
//		 //LocalTime departureTimeFilterUpper = filterParams.getDepartureTimeFilterUpper();
//		
//		//List<Flight> flights2 = flightRepository.findByDepartureTimeBetween(departureTimeFilterLower, departureTimeFilterUpper);
//		//List<Flight> flights3 = flightRepository.findByArrivalTimeBetween(arrivalTimeFilterLower, arrivalTimeFilterUpper);
//		
//		List<Flight> flights = new ArrayList<>();
//
//		
//		
//		LocalDate departureDate = filterParams.getDepartureDate();
//		LocalDate arrivalDate = filterParams.getArrivalDate();
//		switch(filterParams.getFlightType()) {
//		case ONE_WAY:
//			Destination departureDestination = filterParams.getDepartureDestinations().get(0);
//			Destination arrivalDestination = filterParams.getArrivalDestinations().get(0);
//		
//			int seatNum = filterParams.getPersonNum();
//			switch (filterParams.getTicketClass()) {
//			case ECONOMY:
//				List<Flight> flightsOneWaye = flightRepository.searchFlightsOneWayEconomy(departureDate, departureDestination, arrivalDestination, seatNum);
//				break;
//			case BUSINESS:
//				List<Flight> flightsOneWayb = flightRepository.searchFlightsOneWayBusiness(departureDate, departureDestination, arrivalDestination,seatNum);
//				break;
//			case FIRST:
//				List<Flight> flightsOneWayf = flightRepository.searchFlightsOneWayEconomy(departureDate, departureDestination, arrivalDestination, seatNum);
//				break;
//
//			default:
//				break;
//			}
//			
//			break;
//		case ROUND_TRIP:
//			Destination departureDestination1 = filterParams.getDepartureDestinations().get(0);
//			Destination arrivalDestination1 = filterParams.getArrivalDestinations().get(0);
//			
//			List<FlightReturn> flightsRoundTrip = flightRepository.searchFlightsRoundTrip(departureDate, arrivalDate, departureDestination1, arrivalDestination1);
//
//			break;
//		case MULTI_CITY:
//			break;
//		}
//		
//		return flights;
//	}
//	
	public List<Destination> getAllDestinations(){
		List<Destination> destinations = destinationRepository.findAllByOrderByDestinationCode();
		//Collections.sort(des);
		return destinations;
	}
	
}
