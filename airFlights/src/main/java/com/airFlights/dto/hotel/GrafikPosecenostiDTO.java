package com.airFlights.dto.hotel;

public class GrafikPosecenostiDTO {

    private String label;
    private int brojGostiju;

    public GrafikPosecenostiDTO(){}

    public GrafikPosecenostiDTO(String label, int brojGostiju) {
        this.label = label;
        this.brojGostiju = brojGostiju;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(int brojGostiju) {
        this.brojGostiju = brojGostiju;
    }
}
