package com.hackathon.howGreen.domain;

public class GreenInformation {
    private Score productScore;
    private Packaging packaging;
    private AirMiles airMiles;
    private Accreditations accreditations;

    public GreenInformation() {
    }

    public GreenInformation(Score productScore, Packaging packaging, AirMiles airMiles, Accreditations accreditations) {
        this.productScore = productScore;
        this.packaging = packaging;
        this.airMiles = airMiles;
        this.accreditations = accreditations;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public AirMiles getAirMiles() {
        return airMiles;
    }

    public Accreditations getAccreditations() {
        return accreditations;
    }

    public Score getProductScore() {
        return productScore;
    }
}
