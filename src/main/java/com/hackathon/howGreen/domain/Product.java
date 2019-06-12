package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

public class Product {
    @Id private String tpnb;
    private String EAN;
    private GreenInformation greenInformation;

    public Product(String tpnb, String EAN, GreenInformation greenInformation) {
        this.tpnb = tpnb;
        this.EAN = EAN;
        this.greenInformation = greenInformation;
    }

    public String getTpnb() {
        return tpnb;
    }

    public String getEAN() {
        return EAN;
    }

    public GreenInformation getGreenInformation() {
        return greenInformation;
    }
}
