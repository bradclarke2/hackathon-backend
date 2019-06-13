package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.GreenInformation;
import com.hackathon.howGreen.domain.ProductInformation;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CalculationService calculationService;

    public Score getProductScore(String ean) {
        GreenInformation greenInformation = productRepository.findById(ean).get().getGreenInformation();
        return calculationService.calculateScore(greenInformation);
    }

    public ProductInformation getProductInformation(String ean) {
        ProductInformation productInformation = productRepository.findById(ean).get();
        productInformation.getGreenInformation().setProductScore(getProductScore(ean));
        return productInformation;
    }
}
