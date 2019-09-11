package com.airFlights.dto.hotel;

import com.airFlights.model.hotel.OcenaSoba;
import com.airFlights.model.hotel.Soba;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class SobaOcenaDTO {

    private Long id;
    private Integer ocena;
    @JsonIgnore
    private Soba soba;
    private Long version;


    public SobaOcenaDTO(){}
    public SobaOcenaDTO(OcenaSoba s){
        this.id = s.getId();
        this.ocena = s.getOcena();
        this.soba = s.getSoba();
        this.version = s.getVersion();


    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
