package com.hackathon.howGreen.repository;

import com.hackathon.howGreen.domain.ProductInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductInformation, String> {
//    ProductInformation findByEan(String ean);
}
