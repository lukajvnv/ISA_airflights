package com.airFlights.model.hotel;


import javax.persistence.*;

import com.airFlights.model.user.User;

@Entity(name = "oceneSoba")
public class OcenaSoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ocena", nullable = false)
    private Integer ocena;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User korisnik;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Soba soba;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public OcenaSoba(){

    }


}
