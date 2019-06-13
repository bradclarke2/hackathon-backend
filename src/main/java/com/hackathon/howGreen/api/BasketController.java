package com.hackathon.howGreen.api;

import com.hackathon.howGreen.domain.Basket;
import com.hackathon.howGreen.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping
    public Basket createBasket() {
        return basketService.createBasket();
    }

    @PostMapping("viewBasket/{basketid}")
        public Basket viewBasket(@PathVariable("basketid") String basketid) {
        return basketService.viewBasket(basketid);
    }
}
