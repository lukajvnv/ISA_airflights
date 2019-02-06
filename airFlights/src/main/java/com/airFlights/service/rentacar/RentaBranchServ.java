package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airFlights.model.rentacar.RentaBranch;

@Service
public interface RentaBranchServ {
	List<RentaBranch> findAll();
	RentaBranch save(RentaBranch rentaBranch);
	void removeRentaBranch(Integer id);
}
