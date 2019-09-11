package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.SobaNaPopustu;
import com.airFlights.repository.hotel.SobaNaPopustuRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SobaNaPopustuService {
    @Autowired
    private SobaNaPopustuRepository repo;

    public List<SobaNaPopustu> findSveSobeZaHotel(Long idHotela) {return repo.findSveSobeZaHotel(idHotela);}
    public List<SobaNaPopustu> findSviPopustiZaSobu(Long idSobe) {return repo.findSvePopusteZaSobu(idSobe);}
    @Transactional(readOnly = false)
    public void save(SobaNaPopustu s) {repo.save(s);}
    public List<SobaNaPopustu> findSveZaDatume(Long idHotel, LocalDate datumOd, LocalDate datumDo){ return repo.findSvePopusteZaDatume(idHotel, datumOd, datumDo);}

    public List<SobaNaPopustu> findSveZaDatum(Long idHotel, LocalDate datumOd){ return repo.findSvePopusteZaDatum(idHotel, datumOd);}
}
