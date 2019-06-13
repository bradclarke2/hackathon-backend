package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.GreenInformation;
import com.hackathon.howGreen.domain.ProductInformation;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Score getProductScore(String ean) {
        GreenInformation greenInformation = productRepository.findById(ean).get().getGreenInformation();
        return calculateScore(greenInformation);
    }

    public ProductInformation getProductInformation(String ean) {
        ProductInformation productInformation = productRepository.findById(ean).get();
        productInformation.getGreenInformation().setProductScore(getProductScore(ean));
        return productInformation;
    }

    private Score calculateScore(GreenInformation greenInformation){
        //TODO add model for calculation here
        return new Score(10);
    }
}
