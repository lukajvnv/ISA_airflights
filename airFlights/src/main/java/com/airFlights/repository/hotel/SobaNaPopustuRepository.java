package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airFlights.model.hotel.SobaNaPopustu;

import java.time.LocalDate;
import java.util.List;

public interface SobaNaPopustuRepository extends JpaRepository<SobaNaPopustu, Long> {

    @Query(value = "SELECT * FROM sobe_na_popustu s WHERE s.hotel_id = :idHotela", nativeQuery = true)
    public List<SobaNaPopustu> findSveSobeZaHotel(@Param("idHotela") Long idHotela);
    @Query(value = "SELECT * FROM sobe_na_popustu s WHERE s.soba_id = :idSobe", nativeQuery = true)
    public List<SobaNaPopustu> findSvePopusteZaSobu(@Param("idSobe") Long idSobe);
    @Query(value = "SELECT * FROM sobe_na_popustu s WHERE s.hotel_id = :idHotel AND s.od_datuma<= :datumOd AND s.do_datuma>= :datumOd", nativeQuery = true)
    public List<SobaNaPopustu> findSvePopusteZaDatum(@Param("idHotel") Long idHotel, @Param("datumOd")LocalDate datumOd);
    @Query(value = "SELECT * FROM sobe_na_popustu s WHERE s.hotel_id = :idHotel AND s.od_datuma<= :datumOd AND s.do_datuma>= :datumOd AND s.do_datuma>= :datumDo", nativeQuery = true)
    public List<SobaNaPopustu> findSvePopusteZaDatume(@Param("idHotel") Long idHotel, @Param("datumOd")LocalDate datumOd, @Param("datumDo") LocalDate datumDo);
}
