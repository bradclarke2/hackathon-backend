package com.hackathon.howGreen.api;

import com.hackathon.howGreen.domain.Basket;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping
    public Basket createBasket() {
        return basketService.createBasket();
    }

    @GetMapping("{basketid}")
    public Basket viewBasket(@PathVariable("basketid") String basketid) {
        return basketService.viewBasket(basketid);
    }

    @PostMapping("{basketid}/{ean}")
    public Basket addToBasket(@PathVariable("basketid") String basketid, @PathVariable("ean") String ean) {
        return basketService.addToBasket(basketid, ean);
    }

    @GetMapping("{basketId}/score")
    public Score getBasketScore(@PathVariable("basketId") String basketId){
        return basketService.getBasketScore(basketId);
    }
}
