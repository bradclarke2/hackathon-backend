package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

public class ProductInformation {
    @Id private String ean;
    private GreenInformation greenInformation;
    private double price;

    public ProductInformation() {
    }

    public ProductInformation(String ean, GreenInformation greenInformation, double price) {
        this.ean = ean;
        this.greenInformation = greenInformation;
        this.price = price;
    }
    public GreenInformation getGreenInformation() {
        return greenInformation;
    }

    public String getEan() {
        return ean;
    }

    public double getPrice() {
        return price;
    }
}
