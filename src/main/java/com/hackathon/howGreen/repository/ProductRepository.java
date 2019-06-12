package com.hackathon.howGreen.repository;

import com.hackathon.howGreen.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByEAN(String EAN);
}
