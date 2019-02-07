package com.airFlights.repository.avio;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.AirlineTicket;

public interface AirlineTicketRepository extends JpaRepository<AirlineTicket, Integer> {

	// List<AirlineTicket> getAirlineTicket
	
	@Query("select SUM(t.sellingPrice) from AirlineTicket t where t.flight.airline = ?1 and t.sellingDate >= ?2 and t.sellingDate < ?3")
	Float getAirlineProfitBetween(Airline airline, Date from, Date to);
	
//	@Query("select COUNT(t) from AirlineTicket t where t.flight.airline = ?1 and t.sellingDate > ?2 and t.sellingDate < ?3")
//	Integer getAirlineDailyReportBetween(Airline airline, Date from, Date to);
	
	
	@Query("select COUNT(t) from AirlineTicket t where t.flight.airline = ?1 and t.sellingDate = ?2")
	Integer getAirlineDailyReportBetween(Airline airline, Date date);
	
	@Query("select COUNT(t) from AirlineTicket t where t.flight.airline = ?1 and t.sellingDate >= ?2 and t.sellingDate < ?3")
	Integer getAirlineWeeklyReportBetween(Airline airline, Date from, Date to);
	
}
