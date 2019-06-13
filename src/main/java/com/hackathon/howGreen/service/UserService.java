package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.Basket;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.OptionalDouble;

@Service
public class UserService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    BasketService basketService;

    public Score getOverallScore() {
        OptionalDouble averageScoreForUser = basketRepository.findAll()
                .stream()
                .filter(Basket::isCompleted)
                .map(basket -> basketService.getBasketScore(basket.getId()))
                .mapToInt(Score::getValue)
                .average();

        Double score  = averageScoreForUser.orElse(0D);

        return new Score(score.intValue());
    }
}
