package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.Usluga;
import com.airFlights.repository.hotel.UslugaRepository;


@Service
@Transactional(readOnly = true)
public class UslugaService {
    @Autowired
    private UslugaRepository uslugaRepo;

    @Transactional(readOnly = false)
    public Usluga save(Usluga u) { return uslugaRepo.save(u);}
    @Transactional(readOnly = true)
    public Usluga findOne(Long id) { return uslugaRepo.getOne(id);}
}
