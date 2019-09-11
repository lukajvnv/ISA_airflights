package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airFlights.model.hotel.ZauzetostSobe;
import com.airFlights.repository.hotel.ZauzetostSobeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ZauzetostSobeService {

    @Autowired
    private ZauzetostSobeRepository repo;

    public List<ZauzetostSobe> findZauzetostZaSobuOdDatuma(Long idSobe, LocalDate odDatuma){return repo.findZauzetostSobeOdDatuma(idSobe,odDatuma);}
}
