package com.airFlights.service.avio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.avio.Airline;
import com.airFlights.repository.avio.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	
	public List<Airline> findAllAirlines() {
		return airlineRepository.findAll();
	}
	
	public Airline findAirlineById(Integer index) {
		return airlineRepository.findById(index).get(); 
	}
	
	public void removeAirline(Integer index) {
		airlineRepository.deleteById(index);
	}
	
	public String getAverageMark(Integer index) {
		Airline airline = findAirlineById(index);
		
		int ratingSum, ratingNum;
		String text = "Prosecna ocena kompanije:";
		
		try {
			ratingSum = airline.getRatingSum();
			ratingNum = airline.getRatingNumber();
			if(ratingNum == 0) {
				throw new NullPointerException();
			}
			text += ratingSum/ratingNum;
		} catch (NullPointerException e) {
			text += "Nije moguce dobiti prosecnu ocenu";
			return text;
		} 
		return text;
			
	}
}
