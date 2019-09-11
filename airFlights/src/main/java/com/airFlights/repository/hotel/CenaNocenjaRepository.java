package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airFlights.model.hotel.CenaNocenja;

import java.time.LocalDate;
import java.util.List;

public interface CenaNocenjaRepository  extends JpaRepository<CenaNocenja, Long> {

    @Query(value = "SELECT * FROM cene_nocenja c WHERE c.soba_id = :idSobe AND c.od_datuma<=:datum AND c.do_datuma>=:datum", nativeQuery = true)
    public CenaNocenja getCenaZaDatum(@Param("idSobe") Long idSobe, @Param("datum")LocalDate datum);
   /* @Query(value = "SELECT c FROM cene_nocenja c WHERE c.soba_id = :idSobe")
    public List<CenaNocenja> getCeneZaSobu(@Param("idSobe") Long idSobe);*/
}
