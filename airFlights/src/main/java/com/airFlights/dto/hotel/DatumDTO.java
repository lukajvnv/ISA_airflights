package com.airFlights.dto.hotel;

import java.time.LocalDate;

public class DatumDTO {

    LocalDate datumDo;
    LocalDate datumOd;

    public DatumDTO(){}

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }
}
