package com.airFlights.service.rentacar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.dto.rentacar.RentaBranchDTO;
import com.airFlights.dto.rentacar.RentacarDTO;
import com.airFlights.model.rentacar.Car;
import com.airFlights.model.rentacar.RentaBranch;
import com.airFlights.model.rentacar.Rentacar;
import com.airFlights.repository.rentacar.CarRepository;
import com.airFlights.repository.rentacar.RentaBranchRepository;
import com.airFlights.repository.rentacar.RentacarRepository;

@Service
public class RentacarService implements RentacarServ{

	@Autowired
	private RentacarRepository rentacarRepository;
	
	@Autowired
	private RentaBranchRepository rentaBranchRepository;
	
	@Autowired
	private CarRepository carRepository;
	
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
		
		Set<RentaBranch> rentaBranches = new HashSet<RentaBranch>();
		for(RentaBranchDTO rbDTO : rentacarDTO.getBranches()) {
			rentaBranches.add(rentaBranchRepository.findById(rbDTO.getBranchId()).get());
		}	
		List<RentaBranch> rbs = rentaBranchRepository.findAll();
		
		for(RentaBranch rb : rbs) {
			if(rb.getRentacar() != null) {
				if(rb.getRentacar().getRentacarId() == rentacarDTO.getRentacarId())
				{
					if(!rentaBranches.contains(rb)) {
						rb.setRentacar(null);
						rentaBranchRepository.save(rb);
					}
				}
			}	
		}
		
		//dodaj i kola
		
		rentacar.setBranches(rentaBranches);
		
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

	@Override
	public List<Rentacar> findAll() {
		return rentacarRepository.findAll();
	}

	@Override
	public Rentacar save(Rentacar rentacar) {
		return rentacarRepository.save(rentacar);
	}
	
	public void addNewCar(Car car) {
		carRepository.save(car);
	}
	
	public void addNewBranch(RentaBranch branch) {
		rentaBranchRepository.save(branch);
	}
}
