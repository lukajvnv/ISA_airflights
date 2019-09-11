package com.airFlights.model.hotel;



import javax.persistence.*;

import com.airFlights.dto.hotel.UslugaDTO;


@Entity(name = "usluge")
public class Usluga {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "naziv", nullable = false)
    private String naziv;
    @Column(name = "opis")
    private String opis;
    @Column(name = "cena", nullable = false)
    private int cena;
    @Column(name = "popust", nullable = false)
    private int popust; //za vrednost popust = 10, popust je 10%
    @ManyToOne(fetch = FetchType.LAZY) //TODO proveri hoces ovo ovako
    private Hotel hotel;
    @Column(name = "obrisana")
    private boolean obrisana = false;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isObrisana() {
        return obrisana;
    }

    public void setObrisana(boolean obrisana) {
        this.obrisana = obrisana;
    }

    public Usluga() {

    }
    public Usluga(UslugaDTO dto){
        this.cena = dto.getCena();
        this.hotel = dto.getHotel();
        this.naziv = dto.getNaziv();
        this.opis = dto.getOpis();
        this.popust = dto.getPopust();
        this.version = dto.getVersion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
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
}
