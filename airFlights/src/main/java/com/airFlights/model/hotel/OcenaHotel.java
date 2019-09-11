package com.airFlights.model.hotel;



import javax.persistence.*;

import com.airFlights.model.user.User;

@Entity(name = "oceneHotela")
public class OcenaHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ocena", nullable = false)
    private Integer ocena;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User korisnik;
    @ManyToOne(fetch = FetchType.LAZY) //kako on bese prepoznaje sa cime pravi vezu? //TODO cascade?
    private Hotel hotel;

    @Version
    private Long version;


    public OcenaHotel(Integer ocena, User korisnik, Hotel hotel, Long version) {
        this.ocena = ocena;
        this.korisnik = korisnik;
        this.hotel = hotel;
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public OcenaHotel(){

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

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik( User korisnik) {
        this.korisnik = korisnik;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
