package com.airFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
