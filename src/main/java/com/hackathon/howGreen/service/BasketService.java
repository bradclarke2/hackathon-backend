package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.Basket;
import com.hackathon.howGreen.domain.ProductInformation;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductService productService;

    public Basket createBasket() {
        List<String> productList = Collections.emptyList();
        Basket basket = new Basket(productList);
        basketRepository.save(basket);
        return basket;
    }

    public Basket viewBasket(String basketid) {
        return basketRepository.findById(basketid).get();
    }

    public Basket addToBasket(String basketid, String ean) {
        Basket basket = basketRepository.findById(basketid).get();
        basket.add(ean);
        basketRepository.save(basket);
        return basket;
    }

    public Score getBasketScore(String basketId) {
        Basket basket = basketRepository.findById(basketId).get();

            Double sum = basket.getProductList().stream()
                    .mapToInt(ean -> productService.getProductScore(ean).getValue())
                    .average()
                    .getAsDouble();

        return new Score(sum.intValue());
    }

    public void completeBasket(String basketId) {
        Basket basket = basketRepository.findById(basketId).get();
        basket.setCompleted(true);
        basketRepository.save(basket);
    }
}
