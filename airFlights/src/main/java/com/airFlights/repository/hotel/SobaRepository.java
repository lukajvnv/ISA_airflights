package com.airFlights.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airFlights.model.hotel.Soba;

public interface SobaRepository extends JpaRepository<Soba, Long> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE sobe c SET c.brojSobe = :brojSobe, c.opis = :opis, c.brojKreveta=:brojKreveta, c.sprat=:sprat,c.zauzeta = :zauzeta WHERE c.id = :id")
    public int updateSoba(@Param("id") Long id, @Param("brojSobe") String brojSobe, @Param("opis") String opis, @Param("brojKreveta") int brojKreveta, @Param(("sprat")) int sprat, @Param("zauzeta") boolean zauzeta);
    @Modifying
    @Query(value = "UPDATE sobe c SET c.obrisana = true WHERE c.id = :idSobe")
    public void deleteLogical(@Param("idSobe") Long idSobe);
}
