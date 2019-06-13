package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.GreenInformation;
import com.hackathon.howGreen.domain.ProductInformation;
import com.hackathon.howGreen.domain.Score;
import com.hackathon.howGreen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Score getProductScore(String ean) {
        GreenInformation greenInformation = productRepository.findById(ean).get().getGreenInformation();
        return calculateScore(greenInformation);
    }

    public ProductInformation getProductInformation(String ean) {
        ProductInformation productInformation = productRepository.findById(ean).get();
        productInformation.getGreenInformation().setProductScore(getProductScore(ean));
        return productInformation;
    }

    private Score calculateScore(GreenInformation greenInformation){

        int airMilesFromSource = greenInformation.getAirMiles().getFromSource();
        int airMilesFromItems = greenInformation.getAirMiles().getItemsInProduct();
        double airMilesAverage = (airMilesFromItems + airMilesFromSource) / 2;

        int packagingRecylavility = greenInformation.getPackaging().getRecyclability();
        int packagingSustainablePackaging  = greenInformation.getPackaging().getSustustainablePackaging();
        double packagingAverage = (packagingRecylavility + packagingSustainablePackaging) / 2;

        ArrayList<Boolean> list = new ArrayList<>();

        if (greenInformation.getAccreditations().getFairTrade()!=null) {
            list.add(greenInformation.getAccreditations().getFairTrade());
        }

        if (greenInformation.getAccreditations().getRainforestAlliance()!=null) {
            list.add(greenInformation.getAccreditations().getFairTrade());
        }

        if (greenInformation.getAccreditations().getMarineStewardshipCouncil()!=null) {
            list.add(greenInformation.getAccreditations().getFairTrade());
        }

        double score = list.stream()
                .filter(item -> item.equals(true))
                .count();

        double avScore = score / list.size();

        double airmilesWeighting = airMilesAverage * 0.4;
        double packagingWeighting = packagingAverage * 0.4;
        double accredWeighting = avScore * 0.2;

        int finalScore = (int) (airmilesWeighting + packagingWeighting + accredWeighting);

        return new Score(finalScore);
    }
}
