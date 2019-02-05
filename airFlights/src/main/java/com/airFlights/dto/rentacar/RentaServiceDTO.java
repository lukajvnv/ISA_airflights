package com.airFlights.dto.rentacar;

public class RentaServiceDTO {

	private Long serviceId;
	
	private String serviceName;
	
	private Float price;
	
	public RentaServiceDTO() {
		
	}

	public RentaServiceDTO(Long serviceId, String serviceName, Float price) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.price = price;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}
