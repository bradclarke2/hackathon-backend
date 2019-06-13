package com.hackathon.howGreen.domain;

public class AirMiles {
    private int fromSource;
    private int itemsInProduct;

    public AirMiles() {
    }

    public AirMiles(int fromSource, int itemsInProduct) {
        this.fromSource = fromSource;
        this.itemsInProduct = itemsInProduct;
    }

    public int getFromSource() {
        return fromSource;
    }

    public int getItemsInProduct() {
        return itemsInProduct;
    }
}
