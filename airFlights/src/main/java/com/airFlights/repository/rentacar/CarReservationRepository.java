package com.airFlights.repository.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.CarReservation;

public interface CarReservationRepository extends JpaRepository<CarReservation, Integer>{
}
