package com.airFlights.model.hotel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "zauzetost_soba")
public class ZauzetostSobe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "odDatuma", nullable = false) //TODO ne sme se preklapati sa drugima
    private LocalDate odDatuma;
    @Column(name = "doDatuma", nullable = false)
    private LocalDate doDatuma;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Soba soba;

    public ZauzetostSobe(LocalDate odDatuma, LocalDate doDatuma, Soba soba) {
        this.odDatuma = odDatuma;
        this.doDatuma = doDatuma;
        this.soba = soba;
    }

    public ZauzetostSobe(){}

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
}
