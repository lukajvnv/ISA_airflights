package com.airFlights.service.hotel;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.airFlights.dto.hotel.SobaDTO;
import com.airFlights.model.hotel.Soba;
import com.airFlights.repository.hotel.SobaRepository;


@Service
@Transactional(readOnly = true)
public class SobaService {
    @Autowired
    private  SobaRepository sobaRepo;

    @Transactional(readOnly =  true)
    public Soba findOne(Long id) { return sobaRepo.getOne(id);}
    @Transactional(readOnly = false)
    public Soba save(Soba s) {return sobaRepo.save(s);}
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Long id){//sobaRepo.deleteById(id);
         }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Soba s){sobaRepo.delete(s);}
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public int update(SobaDTO dto){return sobaRepo.updateSoba(dto.getId(),dto.getBrojSobe(),dto.getOpis(),dto.getBrojKreveta(),dto.getSprat(),dto.isZauzeta());}
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void deleteLogical(Long idSobe){ sobaRepo.deleteLogical(idSobe);}

}
