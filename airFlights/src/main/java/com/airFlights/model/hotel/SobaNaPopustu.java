package com.airFlights.model.hotel;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "sobe_na_popustu")
public class SobaNaPopustu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Soba soba;
    @Column(name = "od_datuma")
    private LocalDate odDatuma;
    @Column(name = "do_datuma")
    private LocalDate doDatuma;
    @Column(name = "popust")
    private int popust; //popust u procentima
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "soba_popust_usluga", joinColumns = {
            @JoinColumn(name = "id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(referencedColumnName = "id",
                    nullable = false, updatable = false) })
    private Set<Usluga> dodatneUsluge = new HashSet<>();

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public SobaNaPopustu() {}

    public SobaNaPopustu(Soba soba, LocalDate odDatuma, LocalDate doDatuma, int popust, Hotel hotel, Set<Usluga> dodatneUsluge) {
        this.soba = soba;
        this.odDatuma = odDatuma;
        this.doDatuma = doDatuma;
        this.popust = popust;
        this.hotel = hotel;
        this.dodatneUsluge = dodatneUsluge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public LocalDate getOdDatuma() {
        return odDatuma;
    }

    public void setOdDatuma(LocalDate odDatuma) {
        this.odDatuma = odDatuma;
    }

    public LocalDate getDoDatuma() {
        return doDatuma;
    }

    public void setDoDatuma(LocalDate doDatuma) {
        this.doDatuma = doDatuma;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public Set<Usluga> getDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(Set<Usluga> dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
