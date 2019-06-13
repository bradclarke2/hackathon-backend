package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

public class ProductInformation {
    @Id private String ean;
    private GreenInformation greenInformation;
    private CategoryArea categoryArea;
    private double price;

    public ProductInformation() {
    }

    public ProductInformation(String ean, GreenInformation greenInformation, double price, CategoryArea categoryArea) {
        this.ean = ean;
        this.greenInformation = greenInformation;
        this.price = price;
        this.categoryArea = categoryArea;
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

    public CategoryArea getCategoryArea() {
        return categoryArea;
    }
}
