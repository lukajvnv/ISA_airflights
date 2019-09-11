package com.airFlights.dto.hotel;

import com.airFlights.model.hotel.Hotel;
import com.airFlights.model.hotel.OcenaHotel;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class HotelOcenaDTO {

    private Long id;
    private Integer ocena;
    @JsonIgnore
    private Hotel hotel;
    private Long version;


    public HotelOcenaDTO(){}
    public HotelOcenaDTO(OcenaHotel o){
        this.id = o.getId();
        this.ocena = o.getOcena();
        this.hotel = o.getHotel();
        this.version = o.getVersion();

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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
