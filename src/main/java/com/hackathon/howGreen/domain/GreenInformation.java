package com.hackathon.howGreen.domain;

public class GreenInformation {
    private Score productScore;

    public GreenInformation() {
    }

    public GreenInformation(Score productScore) {
        this.productScore = productScore;
    }

    public Score getProductScore() {
        return productScore;
    }
}
