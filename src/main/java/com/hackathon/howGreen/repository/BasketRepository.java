package com.hackathon.howGreen.repository;

import com.hackathon.howGreen.domain.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasketRepository extends MongoRepository<Basket, String> {

}
