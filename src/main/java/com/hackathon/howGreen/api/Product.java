package com.hackathon.howGreen.api;

import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class Product {

    @Autowired
    ProductService productService;

    @GetMapping("/checkItem/{EAN}/score")
    public Score getProductScore(@PathVariable("EAN") String ean){
        return productService.getProductScore(ean);
    }
}
