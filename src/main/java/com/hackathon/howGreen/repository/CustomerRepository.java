package com.hackathon.howGreen.repository;

import com.hackathon.howGreen.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);
}
