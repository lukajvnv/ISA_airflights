package com.airFlights.dto.hotel;

import java.time.LocalDate;

public class RezervacijaSobaDTO {
    private LocalDate datumDolaska;
    private int brojGostiju;
    private int brojNocenja;
    private int cenaPoNocenjuOd;
    private int cenaPoNocenjuDo;

    public RezervacijaSobaDTO(){}

    public LocalDate getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(LocalDate datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public int getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(int brojGostiju) {
        this.brojGostiju = brojGostiju;
    }

    public int getBrojNocenja() {
        return brojNocenja;
    }

    public void setBrojNocenja(int brojNocenja) {
        this.brojNocenja = brojNocenja;
    }

    public int getCenaPoNocenjuOd() {
        return cenaPoNocenjuOd;
    }

    public void setCenaPoNocenjuOd(int cenaPoNocenjuOd) {
        this.cenaPoNocenjuOd = cenaPoNocenjuOd;
    }

    public int getCenaPoNocenjuDo() {
        return cenaPoNocenjuDo;
    }

    public void setCenaPoNocenjuDo(int cenaPoNocenjuDo) {
        this.cenaPoNocenjuDo = cenaPoNocenjuDo;
    }
}
