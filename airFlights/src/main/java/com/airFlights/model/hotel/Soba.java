package com.airFlights.model.hotel;




import javax.persistence.*;

import com.airFlights.dto.hotel.SobaDTO;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "sobe")
public class Soba {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "brojSobe", nullable = false)
	private String brojSobe; //TODO ovo bi trebalo unique biti
	@Column(name = "brojKreveta", nullable = false)
	private int brojKreveta;
	@Column(name = "opis")
	private String opis;
	@ManyToOne(fetch = FetchType.LAZY) //TODO cascade?
	private Hotel hotel;
	@OneToMany(mappedBy = "soba", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OcenaSoba> ocene = new HashSet();
	@Column(name = "sprat")
	private int sprat;
	@Column(name = "zauzeta")
	private boolean zauzeta;
	@OneToMany(mappedBy = "soba", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CenaNocenja> ceneNocenja = new HashSet<>();
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

	public Soba() {
		super();
	}

	public Soba(SobaDTO dto){
		this.brojKreveta = dto.getBrojKreveta();
		this.brojSobe = dto.getBrojSobe();
		this.hotel = dto.getHotel();
		this.opis = dto.getOpis();
		this.sprat = dto.getSprat();
		this.zauzeta = false;
		this.version = dto.getVersion();
	}
	
	
	public String getBrojSobe() {
		return brojSobe;
	}


	public void setBrojSobe(String brojSobe) {
		this.brojSobe = brojSobe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<OcenaSoba> getOcene() {
		return ocene;
	}

	public void setOcene(Set<OcenaSoba> ocene) {
		this.ocene = ocene;
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

	public Set<CenaNocenja> getCeneNocenja() {
		return ceneNocenja;
	}

	public void setCeneNocenja(Set<CenaNocenja> ceneNocenja) {
		this.ceneNocenja = ceneNocenja;
	}
}
