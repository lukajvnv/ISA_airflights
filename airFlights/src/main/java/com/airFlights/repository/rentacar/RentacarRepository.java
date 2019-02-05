package com.airFlights.repository.rentacar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.rentacar.Rentacar;

public interface RentacarRepository extends JpaRepository<Rentacar, Integer>{

	List<Rentacar> findAllByOrderByName();
}
