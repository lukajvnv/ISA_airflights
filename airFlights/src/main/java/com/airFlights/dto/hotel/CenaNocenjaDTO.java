package com.airFlights.dto.hotel;

import com.airFlights.model.hotel.CenaNocenja;
import com.airFlights.model.hotel.Soba;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.time.LocalDate;

public class CenaNocenjaDTO {

    private Long id;
    private LocalDate odDatuma;
    private LocalDate doDatuma;
    private int cena;
    @JsonIgnore
    private Soba soba;
    private Long version;


    public CenaNocenjaDTO(){}
    public CenaNocenjaDTO(CenaNocenja c){
        this.id = c.getId();
        this.odDatuma = c.getOdDatuma();
        this.doDatuma = c.getDoDatuma();
        this.soba = c.getSoba();
        this.cena = c.getCena();
        this.version = c.getVersion();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOdDatuma() {
        return odDatuma;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setOdDatuma(LocalDate odDatuma) {
        this.odDatuma = odDatuma;
    }

    public LocalDate getDoDatuma() {
        return doDatuma;
    }

    public void setDoDatuma(LocalDate doDatuma) {
        this.doDatuma = doDatuma;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
