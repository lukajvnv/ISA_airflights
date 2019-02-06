package com.airFlights.service.avio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.dto.avio.DestinationDTO;
import com.airFlights.dto.avio.FlightDTO;
import com.airFlights.model.Pricelist;
import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightReturn;
import com.airFlights.model.avio.FlightSeat;
import com.airFlights.model.avio.SearchFlightParams;
import com.airFlights.repository.avio.AirlineRepository;
import com.airFlights.repository.avio.DestinationRepository;
import com.airFlights.repository.avio.FlightRepository;
import com.airFlights.repository.avio.PricelistRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private PricelistRepository pricelistRepository;
	
	
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Flight getFlight(Integer flightId) {
		return flightRepository.findById(flightId).get();
	}
	
	public void updateFlight(FlightDTO flight) {
		Airline airline = airlineRepository.findById(flight.getAirline().getAirlineId()).get();
		Flight persistFlight = flightRepository.findById(flight.getFlightId()).get();
		
		if(airline == null || persistFlight == null) {
			return ;
		}
		
		
		Set<Destination> stops = new HashSet<Destination>();
		for(DestinationDTO stop: flight.getStops()) {
			Destination destination = destinationRepository.findById(stop.getDestinationId()).get();
			stops.add(destination);
		}	
		Destination depDest = destinationRepository.findById(flight.getDepartureDestination().getDestinationId()).get();
		Destination arrDest = destinationRepository.findById(flight.getArrivalDestination().getDestinationId()).get();
		
		Pricelist pricelist = pricelistRepository.findById(flight.getPricelist().getPricelistId()).get();
		
		
		persistFlight.setDepartureDestination(depDest);
		persistFlight.setArrivalDestination(arrDest);
		persistFlight.setAirline(airline);
		persistFlight.setStops(stops);
		persistFlight.setPricelist(pricelist);
		
		persistFlight.setSimpleData(flight);
		flightRepository.save(persistFlight);
	}
	
	public void saveNewFlight(Flight flight/*, int airlineId*/) {
		try {
			Airline airline = airlineRepository.findById(flight.getAirline().getAirlineId()).get();
			if(airline == null) {
				return ;
			}
			
			Set<Destination> stops = new HashSet<Destination>();
			for(Destination stop: flight.getStops()) {
				Destination destination = destinationRepository.findById(stop.getDestinationId()).get();
				stops.add(destination);
			}
			
			Destination depDest = destinationRepository.findById(flight.getDepartureDestination().getDestinationId()).get();
			Destination arrDest = destinationRepository.findById(flight.getArrivalDestination().getDestinationId()).get();
			
			Pricelist pricelist = pricelistRepository.findById(flight.getPricelist().getPricelistId()).get();
			
			flight.setArrivalDestination(depDest);
			flight.setArrivalDestination(arrDest);
			flight.setPricelist(pricelist);
			flight.setStops(stops);
			flight.setAirline(airline);
			
			flight.setFlightDuration();
			
			Set<FlightSeat> flightSeats = new HashSet<FlightSeat>();
			for(int i = 0; i < flight.getNumberOfSeats(); i++) {
				flightSeats.add(new FlightSeat(false, false, i + 1, flight));
			}
			flight.setSeats(flightSeats);
			
			
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
		Float luggage = filterParams.getLuggage() == 0 ? 100 : filterParams.getLuggage();
//		LocalTime depFilterLower = filterParams.getDepartureTimeFilterLower();
//		LocalTime depFilterUpper = filterParams.getDepartureTimeFilterUpper();
//		LocalTime arrFilterLower = filterParams.getArrivalTimeFilterLower();
//		LocalTime arrFilterUpper = filterParams.getArrivalTimeFilterUpper();
		
		switch (filterParams.getTicketClass()) {
			case ECONOMY:
				flights = flightRepository.searchFlightsOneWayEconomyBasic(departureDate, departureDestination, arrivalDestination, seatNum, luggage, airline);
				break;
			case BUSINESS:
				flights = flightRepository.searchFlightsOneWayBusinessBasic(departureDate, departureDestination, arrivalDestination,seatNum, luggage, airline);
				break;
			case FIRST:
				flights = flightRepository.searchFlightsOneWayFirstBasic(departureDate, departureDestination, arrivalDestination, seatNum, luggage, airline);
				break;
	
			default:
				return flights;
			}
		
		return flights;
	}
	
	public List<Flight> searchFlightsOneWayComplex(SearchFlightParams filterParams){
		List<Flight> flights = new ArrayList<>();
		
		LocalDate departureDate = filterParams.getDepartureDate();		
		Destination departureDestination = filterParams.getDepartureDestinations().get(0);
		Destination arrivalDestination = filterParams.getArrivalDestinations().get(0);
		int seatNum = filterParams.getPersonNum();
		Float luggage = filterParams.getLuggage() == 0 ? 100 : filterParams.getLuggage();
		
		Airline airline = filterParams.getAirlineFilter();
		LocalTime depFilterLower = filterParams.getDepartureTimeFilterLower();
		LocalTime depFilterUpper = filterParams.getDepartureTimeFilterUpper();
		LocalTime arrFilterLower = filterParams.getArrivalTimeFilterLower();
		LocalTime arrFilterUpper = filterParams.getArrivalTimeFilterUpper();
		
		Float priceFilter = filterParams.getPriceFilter();
		Float duration = filterParams.getFlightDurationFilter();
		
		switch (filterParams.getTicketClass()) {
			case ECONOMY:
				flights = flightRepository.searchFlightsOneWayEconomyComplex(departureDate, departureDestination, arrivalDestination, seatNum, luggage, airline, depFilterLower, depFilterUpper, arrFilterLower, arrFilterUpper, priceFilter, duration);
				break;
			case BUSINESS:
				flights = flightRepository.searchFlightsOneWayBusinessComplex(departureDate, departureDestination, arrivalDestination, seatNum, luggage, airline, depFilterLower, depFilterUpper, arrFilterLower, arrFilterUpper, priceFilter, duration);
				break;
			case FIRST:
				flights = flightRepository.searchFlightsOneWayFirstComplex(departureDate, departureDestination, arrivalDestination, seatNum, luggage, airline, depFilterLower, depFilterUpper, arrFilterLower, arrFilterUpper, priceFilter, duration);
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
		
		Airline airline = filterParams.getAirlineFilter();

		
		switch (filterParams.getTicketClass()) {
			case ECONOMY:
				flights = flightRepository.searchFlightsRoundTripEconomy(departureDate, arrivalDate, departureDestination, arrivalDestination, seatNum, airline);
				break;
			case BUSINESS:
				flights = flightRepository.searchFlightsRoundTripBusiness(departureDate, arrivalDate, departureDestination, arrivalDestination,seatNum, airline);
				break;
			case FIRST:
				flights = flightRepository.searchFlightsRoundTripFirst(departureDate, arrivalDate, departureDestination, arrivalDestination, seatNum, airline);
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
	
	public List<Pricelist> getAllPricelist(){
		return pricelistRepository.findAll();
	}
	
	public void addNewPricelist(Pricelist pricelist) {
		pricelistRepository.saveAndFlush(pricelist);
	}
	
}
