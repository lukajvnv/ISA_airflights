package com.airFlights.model.rentacar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RentaBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer branchId;
	
	@Column(name = "branchName", nullable = false)
	private String name;
	
	@Column(name = "branchLocation", nullable = false)
	private String location;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Rentacar rentacar;
	
	public RentaBranch() {
		super();
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Rentacar getRentacar() {
		return rentacar;
	}

	public void setRentacar(Rentacar rentacar) {
		this.rentacar = rentacar;
	}


}
