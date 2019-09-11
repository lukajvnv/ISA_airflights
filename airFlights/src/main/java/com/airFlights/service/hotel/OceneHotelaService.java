package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.OcenaHotel;
import com.airFlights.repository.hotel.OceneHotelRepository;


@Service
public class OceneHotelaService {

    @Autowired
    private OceneHotelRepository repo;


    @Transactional(readOnly = false)
    public OcenaHotel save(OcenaHotel oh) {
        return repo.save(oh);
    }

    public OcenaHotel findOne(Long id) {
        return repo.getOne(id);
    }


}
