package com.airFlights.dto.hotel;

import java.util.ArrayList;

public class RezervacijaHotelDTO {

    private RezervacijaSobaDTO podaci;
    private ArrayList<UslugaDTO> usluge = new ArrayList<>();
    private ArrayList<FiltriranaSobaDTO> sobe = new ArrayList<>();

    public RezervacijaHotelDTO() {
    }

    public RezervacijaHotelDTO(RezervacijaSobaDTO podaci, ArrayList<UslugaDTO> usluge, ArrayList<FiltriranaSobaDTO> sobe) {
        this.podaci = podaci;
        this.usluge = usluge;
        this.sobe = sobe;
    }

    public RezervacijaSobaDTO getPodaci() {
        return podaci;
    }

    public void setPodaci(RezervacijaSobaDTO podaci) {
        this.podaci = podaci;
    }

    public ArrayList<UslugaDTO> getUsluge() {
        return usluge;
    }

    public void setUsluge(ArrayList<UslugaDTO> usluge) {
        this.usluge = usluge;
    }

    public ArrayList<FiltriranaSobaDTO> getSobe() {
        return sobe;
    }

    public void setSobe(ArrayList<FiltriranaSobaDTO> sobe) {
        this.sobe = sobe;
    }
}

