package com.airFlights.repository.avio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.Destination;
import com.airFlights.model.avio.Flight;
import com.airFlights.model.avio.FlightReturn;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findAllByDepartureDateAndDepartureDestinationAndArrivalDestination(LocalDate departureDate
			,Destination departureDestination, Destination arrivalDestination);
	
	@Query("select f from Flight f where f.departureDate = ?1 and f.departureDestination = ?2 and f.arrivalDestination = ?3")
	List<Flight> searchFlightsOneWay(LocalDate departureDate, Destination departureDestination, Destination arrivalDestination);
	
	@Query("select f from Flight f where f.departureDate = ?1 and f.departureDestination = ?2 and f.arrivalDestination = ?3 and f.numberOfEconomyAvailableSeats >= ?4 "
			+ "and (?5 is null or f.airline = ?5)")
	List<Flight> searchFlightsOneWayEconomy(LocalDate departureDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum, Airline airline);
	
	@Query("select f from Flight f where f.departureDate = ?1 and f.departureDestination = ?2 and f.arrivalDestination = ?3 and f.numberOfEconomyAvailableSeats >= ?4 "
			+ "and (?5 is null or f.airline = ?5) and (?6 is null or f.departureTime >= ?6 and f.departureTime < ?7)"
			+ "and (?8 is null or f.arrivalTime >= ?8 and f.arrivalTime < ?9)")
	List<Flight> searchFlightsOneWayEconomy(LocalDate departureDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum, Airline airline, LocalTime depL, LocalTime depU, LocalTime arrL, LocalTime arrU);
	
	@Query("select f from Flight f where f.departureDate = ?1 and f.departureDestination = ?2 and f.arrivalDestination = ?3 and f.numberOfBusinessAvailableSeats >= ?4 and f.airline = ?5")
	List<Flight> searchFlightsOneWayBusiness(LocalDate departureDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum, Airline airline);
	
	@Query("select f from Flight f where f.departureDate = ?1 and f.departureDestination = ?2 and f.arrivalDestination = ?3 and f.numberOfFirstAvailableSeats >= ?4 and f.airline = ?5")
	List<Flight> searchFlightsOneWayFirst(LocalDate departureDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum, Airline airline);
	
//	@Query("select f1 from Flight f1, Flight f2 "
//			+ "where f1.departureDestination = f2.arrivalDestination and f1.arrivalDestination = f2.departureDestination"
//			+ "and f1.departureDestination = ?3 and f1.arrivalDestination = ?4"
//			+ "and f1.departureDate = ?1 and f2.departureDate = ?2")
//	List<FlightReturn> searchFlightsRoundTrip(LocalDate departureDate, LocalDate arrivalDate, Destination departureDestination, Destination arrivalDestination);
	
	@Query("select new com.airFlights.model.avio.FlightReturn(f1, f2) from Flight f1, Flight f2 "
			+ "where f1.departureDestination = f2.arrivalDestination and f1.arrivalDestination = f2.departureDestination "
			+ "and f1.departureDestination = ?3 and f1.arrivalDestination = ?4 "
			+ "and f1.departureDate = ?1 and f2.departureDate = ?2  and f1.numberOfEconomyAvailableSeats >= ?5"
    )
	List<FlightReturn> searchFlightsRoundTripEconomy(LocalDate departureDate, LocalDate arrivalDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum);

	@Query("select new com.airFlights.model.avio.FlightReturn(f1, f2) from Flight f1, Flight f2 "
			+ "where f1.departureDestination = f2.arrivalDestination and f1.arrivalDestination = f2.departureDestination "
			+ "and f1.departureDestination = ?3 and f1.arrivalDestination = ?4 "
			+ "and f1.departureDate = ?1 and f2.departureDate = ?2 and f1.numberOfBusinessAvailableSeats >= ?5"
    )
	List<FlightReturn> searchFlightsRoundTripBusiness(LocalDate departureDate, LocalDate arrivalDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum);

	@Query("select new com.airFlights.model.avio.FlightReturn(f1, f2) from Flight f1, Flight f2 "
			+ "where f1.departureDestination = f2.arrivalDestination and f1.arrivalDestination = f2.departureDestination "
			+ "and f1.departureDestination = ?3 and f1.arrivalDestination = ?4 "
			+ "and f1.departureDate = ?1 and f2.departureDate = ?2 and f1.numberOfFirstAvailableSeats >= ?5"
    )
	List<FlightReturn> searchFlightsRoundTripFirst(LocalDate departureDate, LocalDate arrivalDate, Destination departureDestination, Destination arrivalDestination, Integer seatNum);

	
	
	
	List<Flight> findByAirline(Airline airline);
	List<Flight> findByDepartureDestination(Destination departureDestination);
	List<Flight> findByArrivalDestination(Destination arrivalDestination);
	List<Flight> findByDepartureTimeBetween(LocalTime lower, LocalTime upper);
	List<Flight> findByArrivalTimeBetween(LocalTime lower, LocalTime upper);

	
}
