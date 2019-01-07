package com.airFlights.service.avio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.avio.Airline;
import com.airFlights.repository.avio.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private EntityManager manager;
	
	public List<Airline> findAllAirlines() {
		return airlineRepository.findAll();
	}
	
	public Airline findAirlineById(Integer index) {
		return airlineRepository.findById(index).get(); 
	}
	
	public void removeAirline(Integer index) {
		airlineRepository.deleteById(index);
	}
	
	public void updateAirline(Airline airline) {
		airlineRepository.save(airline);
	}
	
	@Transactional
	public void addDestinationToAirline(int airlineId, int destinationId) {
		Query query = manager.createNativeQuery("INSERT INTO flight_destinations (airline_id, destination_id) VALUES (?, ?)");
		//Query query2 = manager.createQuery("");
		
		query.setParameter(1, airlineId);
		query.setParameter(2, destinationId);
		try {
			//manager.getTransaction().begin();
			query.executeUpdate();
			//manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Transactional
	public void removeDestinationFromAirline(int airlineId, int destinationId) {
		Query query = manager.createNativeQuery("DELETE FROM flight_destinations WHERE airline_id=? and destination_id=?");
		/*List<Tuple> l =  manager.createNativeQuery("DELETE FROM flight_destinations WHERE airline_id=? and destination_id=?").getResultList();
		Tuple lo =  (Tuple) manager.createNativeQuery("DELETE FROM flight_destinations WHERE airline_id=? and destination_id=?").getSingleResult();
		lo.get(0);*/
		
		//Query query2 = manager.createQuery("");
		
		query.setParameter(1, airlineId);
		query.setParameter(2, destinationId);
		try {
			//manager.getTransaction().begin();
			query.executeUpdate();
			//manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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
