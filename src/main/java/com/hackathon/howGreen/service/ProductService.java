package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Score getProductScore(String ean) {
        return productRepository.findById(ean).get().getGreenInformation().getProductScore();
    }
}
