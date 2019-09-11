package com.airFlights.dto.hotel;

import com.airFlights.model.hotel.CenaNocenja;
import com.airFlights.model.hotel.Hotel;
import com.airFlights.model.hotel.OcenaSoba;
import com.airFlights.model.hotel.Soba;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class SobaDTO {
    private String brojSobe;
    private int brojKreveta;
    private String opis;
    @JsonIgnore
    private Hotel hotel;
    private int sprat;
    private boolean zauzeta;
    private Long id;
    private Long version;
    private ArrayList<SobaOcenaDTO> ocene = new ArrayList<>();
    private ArrayList<CenaNocenjaDTO> ceneNocenja = new ArrayList<>();
    private boolean obrisana = false;


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public SobaDTO(Soba s){
        this.brojSobe = s.getBrojSobe();
        this.brojKreveta = s.getBrojKreveta();
        this.opis = s.getOpis();
        this.hotel = s.getHotel();
        this.sprat = s.getSprat();
        this.zauzeta = s.isZauzeta();
        this.id = s.getId();
        this.version = s.getVersion();
        for(OcenaSoba o : s.getOcene()){
            ocene.add(new SobaOcenaDTO(o));
        }
        for(CenaNocenja cn : s.getCeneNocenja()){
            ceneNocenja.add(new CenaNocenjaDTO(cn));
        }
        this.obrisana = s.isObrisana();
    }

    public boolean isObrisana() {
        return obrisana;
    }

    public void setObrisana(boolean obrisana) {
        this.obrisana = obrisana;
    }

    public SobaDTO(){}

    public ArrayList<CenaNocenjaDTO> getCeneNocenja() {
        return ceneNocenja;
    }

    public void setCeneNocenja(ArrayList<CenaNocenjaDTO> ceneNocenja) {
        this.ceneNocenja = ceneNocenja;
    }

    public String getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(String brojSobe) {
        this.brojSobe = brojSobe;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public boolean isZauzeta() {
        return zauzeta;
    }

    public void setZauzeta(boolean zauzeta) {
        this.zauzeta = zauzeta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<SobaOcenaDTO> getOcene() {
        return ocene;
    }

    public void setOcene(ArrayList<SobaOcenaDTO> ocene) {
        this.ocene = ocene;
    }
}
