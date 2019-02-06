package com.airFlights.dto.rentacar;

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
