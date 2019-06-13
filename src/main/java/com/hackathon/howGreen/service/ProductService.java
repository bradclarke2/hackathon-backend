package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.CategoryArea;
import com.hackathon.howGreen.domain.GreenInformation;
import com.hackathon.howGreen.domain.ProductInformation;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductInformation> getAlternatives(String ean) {
        CategoryArea categoryArea = productRepository.findById(ean).get().getCategoryArea();
        final Score score = getProductScore(ean);
        return productRepository.findByCategoryArea(categoryArea)
                .stream()
                .filter(productInformation -> getProductScore(productInformation.getEan()).getValue() > score.getValue())
                .collect(Collectors.toList());
    }
}
