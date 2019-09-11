package com.airFlights.dto.hotel;

import com.airFlights.model.hotel.Hotel;
import com.airFlights.model.hotel.Usluga;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class UslugaDTO {
    private String naziv;
    private String opis;
    private int cena;
    private int popust;
    private Long id;
    private Long version;
    private boolean obrisana = false;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UslugaDTO(Usluga u){
        this.naziv = u.getNaziv();
        this.opis = u.getOpis();
        this.cena = u.getCena();
        this.popust = u.getPopust();
        this.hotel = u.getHotel();
        this.id = u.getId();
        this.version = u.getVersion();
        this.obrisana = u.isObrisana();
    }
    public UslugaDTO(){

    }
    @JsonIgnore
    private Hotel hotel;
    public String getNaziv() {
        return naziv;
    }

    public boolean isObrisana() {
        return obrisana;
    }

    public void setObrisana(boolean obrisana) {
        this.obrisana = obrisana;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
