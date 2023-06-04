package com.example.browar.bll;

import com.example.browar.repositories.models.GetBeerResponseRate;

import java.util.List;

public class BeerAverageRatingCalculator {

    /**
     * Calculates the average rating for a beer from a list of rating data.
     *
     * @param rates A list of rating data for the beer.
     * @return The average rating as a float value.
     */
    public static float execute(List<GetBeerResponseRate> rates) {
        if (rates == null || rates.isEmpty()) {
            return 0;
        }
        float total = 0;
        for (GetBeerResponseRate rate : rates) {
            total += (rate.tasteRating + rate.colorRating + rate.aromaRating) / 3.0;

        }

        return total / rates.size();
    }
}
