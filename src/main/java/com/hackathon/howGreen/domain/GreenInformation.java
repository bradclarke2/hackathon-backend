package com.hackathon.howGreen.domain;

public class GreenInformation {
    private boolean isRecyclable;

    public GreenInformation(boolean isRecyclable) {
        this.isRecyclable = isRecyclable;
    }

    public boolean isRecyclable() {
        return isRecyclable;
    }
}
