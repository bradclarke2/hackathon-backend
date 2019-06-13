package com.hackathon.howGreen.repository;

import com.hackathon.howGreen.domain.CategoryArea;
import com.hackathon.howGreen.domain.ProductInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductInformation, String> {
    List<ProductInformation> findByCategoryArea(CategoryArea categoryArea);
}
