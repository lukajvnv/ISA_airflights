package com.airFlights.model.hotel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "rezervacije_hotela")
public class RezervacijaHotela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "rezervacija_zauzetost_soba", joinColumns = {
            @JoinColumn(name = "id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(referencedColumnName = "id",
                    nullable = false, updatable = false) })
    private Set<ZauzetostSobe> podaci_o_sobama = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "rezervacija_usluge", joinColumns = {
            @JoinColumn(name = "id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(referencedColumnName = "id",
                    nullable = false, updatable = false) })
    private Set<Usluga> dodatne_usluge = new HashSet<>();
    @Column(name = "ukupna_cena_rezervacije")
    private double ukupnaCenaRezervacije;
    @Column(name = "od_datuma")
    private LocalDate odDatuma;
    @Column(name = "do_datuma")
    private LocalDate doDatuma;
    @Column(name = "id_hotela") //TODO vidi hoces hotel ovde ili ti je id dosta
    private Long hotel;
    @Column(name = "broj_gostiju")
    private int brojGostiju;

    @Column(name = "otkazan")
    private boolean otkazan= false;

    public RezervacijaHotela(){}

    public RezervacijaHotela(Set<ZauzetostSobe> podaci_o_sobama, Set<Usluga> dodatne_usluge, long ukupnaCenaRezervacije) {
        this.podaci_o_sobama = podaci_o_sobama;
        this.dodatne_usluge = dodatne_usluge;
        this.ukupnaCenaRezervacije = ukupnaCenaRezervacije;
    }

    public RezervacijaHotela(Set<ZauzetostSobe> podaci_o_sobama, Set<Usluga> dodatne_usluge, double ukupnaCenaRezervacije, LocalDate odDatuma, LocalDate doDatuma, Long hotel, int brojGostiju) {
        this.podaci_o_sobama = podaci_o_sobama;
        this.dodatne_usluge = dodatne_usluge;
        this.ukupnaCenaRezervacije = ukupnaCenaRezervacije;
        this.odDatuma = odDatuma;
        this.doDatuma = doDatuma;
        this.hotel = hotel;
        this.brojGostiju = brojGostiju;
        this.otkazan = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ZauzetostSobe> getPodaci_o_sobama() {
        return podaci_o_sobama;
    }

    public void setPodaci_o_sobama(Set<ZauzetostSobe> podaci_o_sobama) {
        this.podaci_o_sobama = podaci_o_sobama;
    }

    public Set<Usluga> getDodatne_usluge() {
        return dodatne_usluge;
    }

    public void setDodatne_usluge(Set<Usluga> dodatne_usluge) {
        this.dodatne_usluge = dodatne_usluge;
    }

    public double getUkupnaCenaRezervacije() {
        return ukupnaCenaRezervacije;
    }

    public void setUkupnaCenaRezervacije(double ukupnaCenaRezervacije) {
        this.ukupnaCenaRezervacije = ukupnaCenaRezervacije;
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

    public Long getHotel() {
        return hotel;
    }

    public void setHotel(Long hotel) {
        this.hotel = hotel;
    }

    public int getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(int brojGostiju) {
        this.brojGostiju = brojGostiju;
    }

    public boolean isOtkazan() {
        return otkazan;
    }

    public void setOtkazan(boolean otkazan) {
        this.otkazan = otkazan;
    }
}
