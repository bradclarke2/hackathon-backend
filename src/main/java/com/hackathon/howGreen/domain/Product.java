package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

public class Product {
    @Id private String ean;
    private GreenInformation greenInformation;

    public Product(String ean, GreenInformation greenInformation) {
        this.ean = ean;
        this.greenInformation = greenInformation;
    }
    public String getEan() {
        return ean;
    }

    public GreenInformation getGreenInformation() {
        return greenInformation;
    }
}
