package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.Hotel;
import com.airFlights.repository.hotel.HotelRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HotelService {
    @Autowired
    private HotelRepository hotelRepo;

    @Transactional(readOnly = true)
    public Hotel findOne(Long id){
        return hotelRepo.getOne(id);
    }
    @Transactional(readOnly = false)
    public Hotel save(Hotel h) { return hotelRepo.save(h);}
    @Transactional(readOnly = true)
    public List<Hotel> findAll (){return hotelRepo.findAll();}
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateHotel(Long id, String naziv, String drzava, String grad, String adresa, String promoOpis){hotelRepo.updateHotel(id,naziv,drzava,grad,adresa,promoOpis);}
}
