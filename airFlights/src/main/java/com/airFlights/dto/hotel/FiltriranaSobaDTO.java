package com.airFlights.dto.hotel;

public class FiltriranaSobaDTO {

    private SobaDTO soba;
    private long ukupnaCena;
    private float ocena;

    public FiltriranaSobaDTO(SobaDTO s, long c, float o){
        this.soba = s;
        this.ukupnaCena = c;
        this.ocena = o;
    }

    public FiltriranaSobaDTO(){}

    public SobaDTO getSoba() {
        return soba;
    }

    public void setSoba(SobaDTO soba) {
        this.soba = soba;
    }

    public long getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(long ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }
}
