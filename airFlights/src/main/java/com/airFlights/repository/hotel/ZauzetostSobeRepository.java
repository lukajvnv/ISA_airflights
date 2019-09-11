package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airFlights.model.hotel.ZauzetostSobe;

import java.time.LocalDate;
import java.util.List;

public interface ZauzetostSobeRepository extends JpaRepository<ZauzetostSobe, Long> {

    @Query(value = "SELECT * from zauzetost_soba z WHERE z.soba_id=:idSobe AND z.do_datuma >=:odDatuma", nativeQuery = true)
    public List<ZauzetostSobe> findZauzetostSobeOdDatuma(@Param("idSobe") Long id, @Param("odDatuma")LocalDate odDatuma);
}
