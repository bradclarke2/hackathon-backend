package com.hackathon.howGreen.domain;

public class Packaging {
    private int recyclability;
    private int sustustainablePackaging;

    public Packaging() {
    }

    public Packaging(int recyclability, int sustainablePackaging) {
        this.recyclability = recyclability;
        this.sustustainablePackaging = sustainablePackaging;
    }

    public int getRecyclability() {
        return recyclability;
    }

    public int getSustustainablePackaging() {
        return sustustainablePackaging;
    }
}
