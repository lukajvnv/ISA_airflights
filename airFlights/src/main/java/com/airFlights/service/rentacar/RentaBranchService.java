package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.rentacar.RentaBranch;
import com.airFlights.repository.rentacar.RentaBranchRepository;

@Service
public class RentaBranchService implements RentaBranchServ {

	@Autowired
	private RentaBranchRepository rentaBranchRepository;
	
	@Override
	public List<RentaBranch> findAll() {
		return rentaBranchRepository.findAll();
	}

	@Override
	public RentaBranch save(RentaBranch rentaBranch) {
		return rentaBranchRepository.save(rentaBranch);
	}

	@Override
	public void removeRentaBranch(Integer id) {
		rentaBranchRepository.deleteById(id);
	}

}
