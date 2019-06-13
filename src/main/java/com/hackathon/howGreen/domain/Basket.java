package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Basket {
    @Id
    private String id;
    private List<String> productList;
    private boolean completed;

    public Basket() {
    }

    public Basket(List<String> productList) {
        this.productList = productList;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public List<String> getProductList() {
        return productList;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void add(String ean) {
        this.productList.add(ean);
    }
}
