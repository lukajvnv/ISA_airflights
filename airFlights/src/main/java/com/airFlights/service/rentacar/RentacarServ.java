package com.airFlights.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airFlights.model.rentacar.Rentacar;

@Service
public interface RentacarServ {
	List<Rentacar> findAll();
	Rentacar save(Rentacar rentacar);
	void removeRentacar(Integer id);
}
