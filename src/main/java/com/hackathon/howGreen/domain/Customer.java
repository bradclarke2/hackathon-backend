package com.hackathon.howGreen.domain;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    public String id;

    private String firstName;
    private String lastName;
    private Score overallScore;

    public Customer() {}

    public Customer(String firstName, String lastName, Score overallScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.overallScore = overallScore;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Score getOverallScore() {
        return overallScore;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
