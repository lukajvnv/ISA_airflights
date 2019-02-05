package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airFlights.dto.rentacar.RentacarDTO;
import com.airFlights.model.rentacar.Rentacar;
import com.airFlights.repository.rentacar.RentacarRepository;

public class RentacarService {

	@Autowired
	private RentacarRepository rentacarRepository;
	
	
	public List<Rentacar> findAllRentacars() {
		return rentacarRepository.findAllByOrderByName();
	}

	public Rentacar findRentacarById(Integer id) {
		return rentacarRepository.findById(id).get();
	}
	
	public void removeRentacar(Integer id) {
		rentacarRepository.deleteById(id);
	}
	
	public void updateRentacar(Rentacar rentacar, RentacarDTO rentacarDTO) {
		rentacar.setName(rentacarDTO.getName());
		rentacar.setAdress(rentacarDTO.getAdress());
		rentacar.setPromoDescription(rentacarDTO.getPromoDescription());
		
		//filijale, kola i cene
		
		rentacarRepository.save(rentacar);
	}
	
	public String getAverageRating(Integer id) {
		Rentacar rentacar = findRentacarById(id);
		float ratingSum;
		int ratingNumber;
		
		String text = "Prosecna ocena servisa:";
		
		try {
			ratingSum = rentacar.getAvgRating();
			ratingNumber = rentacar.getRatingNumber();
			if(ratingNumber == 0) {
				throw new NullPointerException();
			}
			text += ratingSum/ratingNumber;
		} catch (NullPointerException e) {
			text += "Nije moguce dobiti prosecnu ocenu";
			return text;
		}
		return text;
	}
	
	//dodaj novo vozilo
}
