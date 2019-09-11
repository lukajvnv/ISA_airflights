package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.CenaNocenja;
import com.airFlights.repository.hotel.CenaNocenjaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CenaNocenjaService {

    @Autowired
    private CenaNocenjaRepository cenaNocenjaRepo;

    public CenaNocenja findOne (Long id){return cenaNocenjaRepo.getOne(id);}
    public List<CenaNocenja> findAll(){return cenaNocenjaRepo.findAll();}
    //public List<CenaNocenja> findAllSoba(Long idSobe) {return cenaNocenjaRepo.getCeneZaSobu(idSobe);}
    @Transactional(readOnly = false)
    public CenaNocenja save(CenaNocenja cn) { return cenaNocenjaRepo.save(cn);}
    public CenaNocenja getCenaNocenjaZaDatum(LocalDate datum, Long idSobe){return cenaNocenjaRepo.getCenaZaDatum(idSobe,datum);}
}
