package com.hackathon.howGreen.api;

import com.hackathon.howGreen.domain.Customer;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.CustomerRepository;
import com.hackathon.howGreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void createUser(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @GetMapping("/score")
    public Score getScore(){
        return userService.getOverallScore();
    }
}
