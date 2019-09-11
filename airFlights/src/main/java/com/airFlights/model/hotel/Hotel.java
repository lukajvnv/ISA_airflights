package com.airFlights.model.hotel;




import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "hoteli")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "naziv", nullable = false) //TODO da bude UNIQUE
    private String naziv;
    @Column(name = "drzava" ,nullable = false)
    private String drzava;
    @Column(name = "grad" ,nullable = false)
    private String grad;
    @Column(name = "adresa", nullable = false)
    private String adresa; //TODO prikaz lokacije koriscenjem google mapa
    @Column(name = "promoOpis", nullable = false)
    private String promoOpis;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Usluga> dodatneUsluge = new HashSet<>();
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Soba> sobe = new HashSet<>();
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<OcenaHotel> ocene = new HashSet<>();
    @Column(name = "obrisan")
    private boolean obrisan = false;

    @Version
    private Long version;

    public Hotel(String naziv, String drzava, String grad, String adresa, String promoOpis, Long version, boolean obrisan) {
        this.naziv = naziv;
        this.drzava = drzava;
        this.grad = grad;
        this.adresa = adresa;
        this.promoOpis = promoOpis;
        this.version = version;
        this.obrisan = obrisan;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Hotel() {
        super();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Usluga> getDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(Set<Usluga> dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    public Set<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(Set<Soba> sobe) {
        this.sobe = sobe;
    }

    public Set<OcenaHotel> getOcene() {
        return ocene;
    }

    public void setOcene(Set<OcenaHotel> ocene) {
        this.ocene = ocene;
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

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }




}
