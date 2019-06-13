package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Basket {
    @Id private String id;
    private List<String> productList;

    public Basket() {
    }

    public Basket(List<String> productList) {
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public List<String> getProductList() {
        return productList;
    }
}
