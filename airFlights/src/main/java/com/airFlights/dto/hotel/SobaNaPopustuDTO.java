package com.airFlights.dto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class SobaNaPopustuDTO {

    private Long soba;
    private Long idHotela;
    private ArrayList<Long> usluge;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private Integer popust;

    public SobaNaPopustuDTO(){}

    public Long getSoba() {
        return soba;
    }

    public void setSoba(Long soba) {
        this.soba = soba;
    }

    public Long getIdHotela() {
        return idHotela;
    }

    public void setIdHotela(Long idHotela) {
        this.idHotela = idHotela;
    }

    public ArrayList<Long> getUsluge() {
        return usluge;
    }

    public void setUsluge(ArrayList<Long> usluge) {
        this.usluge = usluge;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public Integer getPopust() {
        return popust;
    }

    public void setPopust(Integer popust) {
        this.popust = popust;
    }
}
