package com.airFlights.dto.hotel;


import java.util.ArrayList;

import com.airFlights.model.hotel.Hotel;
import com.airFlights.model.hotel.OcenaHotel;
import com.airFlights.model.hotel.Soba;
import com.airFlights.model.hotel.Usluga;

public class HotelDTO {

    private String naziv;
    private Long id;
    private String adresa;
    private String drzava;
    private String grad;
    private String promoOpis;
    private ArrayList<UslugaDTO> dodatneUsluge = new ArrayList<>();
    private ArrayList<SobaDTO> sobe = new ArrayList<>();
    private ArrayList<HotelOcenaDTO> ocene = new ArrayList<>();
    private Long version;
    private boolean obrisan = false;

    public Long getVersion() {
        return version;
    }

    public HotelDTO(){}

    public void setVersion(Long version) {
        this.version = version;
    }


    public HotelDTO(Hotel hotel){
        this.naziv = hotel.getNaziv();
        this.id = hotel.getId();
        this.adresa = hotel.getAdresa();
        this.promoOpis = hotel.getPromoOpis();
        this.version = hotel.getVersion();
        this.grad = hotel.getGrad();
        this.drzava = hotel.getDrzava();
        for(Usluga u : hotel.getDodatneUsluge()){
            if(!u.isObrisana())
                this.dodatneUsluge.add(new UslugaDTO(u));
        }
        for(Soba s : hotel.getSobe()){
            if(!s.isObrisana())
                this.sobe.add(new SobaDTO(s));
        }
        for(OcenaHotel o : hotel.getOcene()){
            if(o!=null)
            this.ocene.add(new HotelOcenaDTO(o));
        }
        this.obrisan = hotel.isObrisan();

    }

    public HotelDTO(String naziv, String adresa, String drzava, String grad, String promoOpis, Long version) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.drzava = drzava;
        this.grad = grad;
        this.promoOpis = promoOpis;
        this.version = version;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPromoOpis() {
        return promoOpis;
    }

    public void setPromoOpis(String promoOpis) {
        this.promoOpis = promoOpis;
    }

    public ArrayList<UslugaDTO> getDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(ArrayList<UslugaDTO> dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    public ArrayList<SobaDTO> getSobe() {
        return sobe;
    }

    public void setSobe(ArrayList<SobaDTO> sobe) {
        this.sobe = sobe;
    }

    public ArrayList<HotelOcenaDTO> getOcene() {
        return ocene;
    }

    public void setOcene(ArrayList<HotelOcenaDTO> ocene) {
        this.ocene = ocene;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
}
