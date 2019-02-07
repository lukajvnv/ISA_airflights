package com.airFlights.model.avio;

public class AirlineAnalyticsOneValue {
	
	private String label;
	private int value;
	
	public AirlineAnalyticsOneValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirlineAnalyticsOneValue(String label, int value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	public AirlineAnalyticsOneValue(String label, Integer v) {
		super();
		this.label = label;
		if(v == null) {
			this.value = 0;
		}else {
			this.value = v;
		}		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
