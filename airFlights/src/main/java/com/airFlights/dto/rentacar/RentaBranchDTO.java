package com.airFlights.dto.rentacar;

import com.airFlights.model.rentacar.RentaBranch;

public class RentaBranchDTO {

	private Integer branchId;
	
	private String name;
	
	private String location;
	
	
	public RentaBranchDTO() {
	}

	public RentaBranchDTO(Integer branchId, String name, String location) {
		super();
		this.branchId = branchId;
		this.name = name;
		this.location = location;
	}
	
	public RentaBranchDTO(RentaBranch rentaBranch) {
		this.branchId = rentaBranch.getBranchId();
		this.name = rentaBranch.getName();
		this.location = rentaBranch.getLocation();
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

}
