package com.airFlights.repository.avio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airFlights.model.Pricelist;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Integer> {

}
