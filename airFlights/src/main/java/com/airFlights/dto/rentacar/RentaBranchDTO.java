package com.airFlights.dto.rentacar;

public class RentaBranchDTO {

	private Long branchId;
	
	private String name;
	
	private String location;
	
	public RentaBranchDTO() {
	}

	public RentaBranchDTO(Long branchId, String name, String location) {
		super();
		this.branchId = branchId;
		this.name = name;
		this.location = location;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
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
