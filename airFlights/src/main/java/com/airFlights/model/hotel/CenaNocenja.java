package com.airFlights.model.hotel;



import javax.persistence.*;

import com.airFlights.dto.hotel.CenaNocenjaDTO;

import java.time.LocalDate;

@Entity(name = "cene_nocenja")
public class CenaNocenja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "odDatuma", nullable = false) //TODO mora se obratiti paznja na to da ne mogu da se preklapaju intervali za cene nocenja za istu sobu
    private LocalDate odDatuma;
    @Column(name = "doDatuma", nullable = false)
    private LocalDate doDatuma;
    @Column(name = "cena", nullable = false)
    private int cena;
    @ManyToOne(fetch = FetchType.LAZY) //TODO cascade?
    private Soba soba;
    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public CenaNocenja(){

    }
    public CenaNocenja(CenaNocenjaDTO dto){
        this.id = dto.getId();
        this.version = dto.getVersion();
        this.cena = dto.getCena();
        this.doDatuma = dto.getDoDatuma();
        this.odDatuma = dto.getOdDatuma();
        this.soba = dto.getSoba();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
