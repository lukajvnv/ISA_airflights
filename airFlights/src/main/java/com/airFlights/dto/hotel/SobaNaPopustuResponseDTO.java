package com.airFlights.dto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class SobaNaPopustuResponseDTO {

    private SobaDTO soba;
    private Long idHotela;
    private ArrayList<UslugaDTO> usluge;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private Integer popust;
    private double staraCena;
    private double novaCena;

    public SobaNaPopustuResponseDTO(){}

    public SobaNaPopustuResponseDTO(SobaDTO soba, Long idHotela, ArrayList<UslugaDTO> usluge, LocalDate datumOd, LocalDate datumDo, Integer popust, double cena, double novaCena) {
        this.soba = soba;
        this.idHotela = idHotela;
        this.usluge = usluge;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.popust = popust;
        this.staraCena = cena;
        this.novaCena = novaCena;
    }

    public SobaDTO getSoba() {
        return soba;
    }

    public void setSoba(SobaDTO soba) {
        this.soba = soba;
    }

    public Long getIdHotela() {
        return idHotela;
    }

    public void setIdHotela(Long idHotela) {
        this.idHotela = idHotela;
    }

    public ArrayList<UslugaDTO> getUsluge() {
        return usluge;
    }

    public void setUsluge(ArrayList<UslugaDTO> usluge) {
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

    public double getStaraCena() {
        return staraCena;
    }

    public void setStaraCena(double staraCena) {
        this.staraCena = staraCena;
    }

    public double getNovaCena() {
        return novaCena;
    }

    public void setNovaCena(double novaCena) {
        this.novaCena = novaCena;
    }
}
