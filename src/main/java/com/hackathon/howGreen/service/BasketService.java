package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.Basket;
import com.hackathon.howGreen.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    public Basket createBasket() {
        List<String> productList = Collections.emptyList();
        Basket basket = new Basket(productList);
        basketRepository.save(basket);
        return basket;
    }
}
