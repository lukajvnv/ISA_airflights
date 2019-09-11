package com.airFlights.dto.hotel;

public class PrihodiDTO {

    private long sobePrihod;
    private long uslugePrihod;
    private long ukupanPrihod;

    public PrihodiDTO() {}

    public PrihodiDTO(long sobePrihod, long uslugePrihod, long ukupanPrihod) {
        this.sobePrihod = sobePrihod;
        this.uslugePrihod = uslugePrihod;
        this.ukupanPrihod = ukupanPrihod;
    }

    public long getSobePrihod() {
        return sobePrihod;
    }

    public long getUkupanPrihod() {
        return ukupanPrihod;
    }

    public void setUkupanPrihod(long ukupanPrihod) {
        this.ukupanPrihod = ukupanPrihod;
    }

    public void setSobePrihod(long sobePrihod) {
        this.sobePrihod = sobePrihod;
    }

    public long getUslugePrihod() {
        return uslugePrihod;
    }

    public void setUslugePrihod(long uslugePrihod) {
        this.uslugePrihod = uslugePrihod;
    }
}
