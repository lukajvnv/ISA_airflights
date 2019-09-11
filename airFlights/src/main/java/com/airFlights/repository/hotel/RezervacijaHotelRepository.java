package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airFlights.model.hotel.RezervacijaHotela;

import java.time.LocalDate;
import java.util.List;

public interface RezervacijaHotelRepository extends JpaRepository<RezervacijaHotela, Long> {

    @Query(value = "SELECT * FROM rezervacije_hotela r WHERE r.id_hotela=:idHotela AND r.od_datuma>=:odDatuma AND r.od_datuma<=:doDatuma", nativeQuery = true)
    public List<RezervacijaHotela> findAllRezervacijeZaHotelIDatum(@Param("idHotela") Long id, @Param("odDatuma") LocalDate odDatuma, @Param("doDatuma") LocalDate doDatuma);
    @Query(value = "SELECT * FROM rezervacije_hotela r WHERE r.id_hotela=:idHotela AND (r.od_datuma>=:odDatuma AND r.od_datuma<=:doDatuma) OR (r.do_datuma>=:odDatuma AND r.do_datuma<=:doDatuma) OR (r.do_datuma>=:doDatuma AND r.od_datuma<=:odDatuma)", nativeQuery = true)
    public List<RezervacijaHotela> findAllForHotel (@Param("idHotela") Long id, @Param("odDatuma") LocalDate odDatuma, @Param("doDatuma") LocalDate doDatuma);
}
