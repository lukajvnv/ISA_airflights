package com.airFlights.dto.hotel;



import java.time.LocalDate;

public class GrafikRequestDTO {

    private LocalDate datumOd;
    private LocalDate datumDo;
    private String tip;

    public GrafikRequestDTO(){}

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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
