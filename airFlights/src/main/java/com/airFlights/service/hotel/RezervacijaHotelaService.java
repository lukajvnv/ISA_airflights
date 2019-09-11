package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.model.hotel.RezervacijaHotela;
import com.airFlights.repository.hotel.RezervacijaHotelRepository;

import java.time.LocalDate;
import java.util.List;


@Service
public class RezervacijaHotelaService {
    @Autowired
    private RezervacijaHotelRepository rezHotelRepo;

    @Transactional(readOnly = false)
    public RezervacijaHotela save(RezervacijaHotela rez) { return rezHotelRepo.save(rez); }
    public List<RezervacijaHotela> findAllRezervacijeZaHotel(Long idHotela, LocalDate odDatuma, LocalDate doDatuma) {return rezHotelRepo.findAllForHotel(idHotela,odDatuma,doDatuma);}

    public RezervacijaHotela findOne(Long id) {System.out.println("usao sam ove, id: "+ id); return rezHotelRepo.getOne(id);}
    public List<RezervacijaHotela> findAllRezervacijeZaHotelIDatum(Long idHotela, LocalDate odDatuma, LocalDate doDatuma) {return rezHotelRepo.findAllRezervacijeZaHotelIDatum(idHotela,odDatuma,doDatuma);}
}
