package com.airFlights.service.avio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.avio.Airline;
import com.airFlights.model.avio.AirlineAnalyticsOneValue;
import com.airFlights.model.avio.AirlineAnalyticsQuery;
import com.airFlights.model.avio.Flight;
import com.airFlights.repository.avio.AirlineRatingRepository;
import com.airFlights.repository.avio.AirlineRepository;
import com.airFlights.repository.avio.AirlineTicketRepository;
import com.airFlights.repository.avio.FlightRatingRepository;
import com.airFlights.repository.avio.FlightRepository;

import helper.HelperClass;

@Service
public class RatingService {
	
	@Autowired
	private AirlineRatingRepository airlineRatingRepository;
	
	@Autowired
	private FlightRatingRepository flightRatingRepository;

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AirlineTicketRepository airlineTicketRepository;
	
	public String getAirlineRating(Integer airlineId) {
		Airline airline = airlineRepository.findById(airlineId).get();
		Float rating = airlineRatingRepository.getAirlineRating(airline);
		
		String answer = "";
		if(rating == null) {
			answer = "Niko nije ocenio aviokompaniju";
		}else {
			answer = rating.toString();
		}
		
		return answer;
	}
	
	public String getFlightRating(Integer flightId) {
		Flight flight = flightRepository.findById(flightId).get();
		Float rating = flightRatingRepository.getFlightRating(flight);
		
		String answer = "";
		if(rating == null) {
			answer = "Niko nije ocenio let";
		}else {
			answer = rating.toString();
		}
		
		return answer;
	}
	
	public String getAirlineProfit(Integer id, AirlineAnalyticsQuery query) {
		Airline airline = airlineRepository.findById(id).get();
		Float profit = airlineTicketRepository.getAirlineProfitBetween(airline, query.getFrom(), query.getTo());
		
		String answer = "";
		if(profit == null) {
			answer = "Ne postoji prihod";
		}else {
			answer = profit.toString();
		}
		
		return answer;
	}
	
	public List<AirlineAnalyticsOneValue> getAirlineReport(Integer id, AirlineAnalyticsQuery query) throws Exception{
		Airline airline = airlineRepository.findById(id).get();
		
		List<AirlineAnalyticsOneValue> values = new ArrayList<AirlineAnalyticsOneValue>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		
		switch (query.getReportType()) {
			case DAILY:
				List<Date> dates = HelperClass.getDatesBetweenUsingJava(query.getFrom(), query.getTo());
				for(Date d: dates) {
					Integer num = airlineTicketRepository.getAirlineDailyReportBetween(airline, d);
					String label = formatter.format(d);
					values.add(new AirlineAnalyticsOneValue(label, num));
				}			
				break;
			case WEEKLY:
				List<Date> datesW = HelperClass.getDatesByWeekBetweenUsingJava(query.getFrom(), query.getTo());
				for(int i = 0; i < datesW.size() - 1; i++) {
					Date from = datesW.get(i);
					Date to = datesW.get(i + 1);
					
					Integer num = airlineTicketRepository.getAirlineWeeklyReportBetween(airline, from, to);
					String label = formatter.format(from);
					values.add(new AirlineAnalyticsOneValue(label, num));
				}
			
				break;
			case MONTHLY:
				List<Date> datesM = HelperClass.getDatesByMonthBetweenUsingJava(query.getFrom(), query.getTo());
				for(int i = 0; i < datesM.size() - 1; i++) {
					Date from = datesM.get(i);
					Date to = datesM.get(i + 1);
					
					Integer num = airlineTicketRepository.getAirlineWeeklyReportBetween(airline, from, to);
					String label = formatter.format(from);
					values.add(new AirlineAnalyticsOneValue(label, num));
				}
			
				break;

			default:
				throw new Exception();
		}
		
		
		//Integer profit = airlineTicketRepository.getAirlineReportBetween(airline, query.getFrom(), query.getTo());
		return values;
	}
}
