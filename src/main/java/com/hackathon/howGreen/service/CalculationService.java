package com.hackathon.howGreen.service;

import com.hackathon.howGreen.domain.GreenInformation;
import com.hackathon.howGreen.domain.Score;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CalculationService {

    private static final double AIR_MILE_WEIGHTING = 0.4;
    private static final double PACKAGING_WEIGHTING = 0.4;
    private static final double ACCREDITATION_WEIGHTING = 0.2;

    public Score calculateScore(GreenInformation greenInformation) {
        int airMilesFromSource = greenInformation.getAirMiles().getFromSource();
        int airMilesFromItems = greenInformation.getAirMiles().getItemsInProduct();
        double airMilesAverage = getAverage(airMilesFromSource, airMilesFromItems);

        int recyclability = greenInformation.getPackaging().getRecyclability();
        int packagingSustainablePackaging = greenInformation.getPackaging().getSustustainablePackaging();
        double packagingAverage = getAverage(recyclability, packagingSustainablePackaging);

        double accreditationAverage = getAccreditationAverage(greenInformation.getAccreditations().getAccreditationsAsList());
        return getWeightedAverageScore(airMilesAverage, packagingAverage, accreditationAverage);
    }

    private double getAccreditationAverage(ArrayList<Object> accreditations) {
        int numberOfAccreditationsAvailable = (int) accreditations.stream()
                .filter(Objects::nonNull)
                .count();

        int numberOfTrueAccreditations = (int) accreditations.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.equals(true))
                .count();

        return numberOfTrueAccreditations / numberOfAccreditationsAvailable;
    }

    private int getAverage(int airMilesFromSource, int airMilesFromItems) {
        return (airMilesFromItems + airMilesFromSource) / 2;
    }

    private Score getWeightedAverageScore(double airMileAverage, double packagingAverage, double accreditationAverage) {
        return new Score((int) (airMileAverage * AIR_MILE_WEIGHTING +
                                packagingAverage * PACKAGING_WEIGHTING +
                                accreditationAverage * ACCREDITATION_WEIGHTING));
    }
}
