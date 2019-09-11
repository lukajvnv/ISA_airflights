package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.hotel.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
}
