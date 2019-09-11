package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE hoteli h SET h.naziv = :naziv, h.drzava= :drzava, h.grad=:grad, h.adresa=:adresa, h.promo_opis=:promoOpis WHERE h.id = :id", nativeQuery = true)
    void updateHotel(@Param("id") Long id, @Param("naziv") String naziv, @Param("drzava") String drzava, @Param("grad") String grad, @Param("adresa") String adresa, @Param("promoOpis") String promoOpis );

}
