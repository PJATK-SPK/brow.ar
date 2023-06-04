package com.example.browar.bll;

import com.example.browar.repositories.models.GetBeerResponseRate;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BeerAverageRatingCalculatorTest {

    @Test
    public void averageRatingIsCorrect() {
        List<GetBeerResponseRate> rates = new ArrayList<>();

        GetBeerResponseRate rate1 = new GetBeerResponseRate();
        rate1.tasteRating = 5;
        rate1.colorRating = 7;
        rate1.aromaRating = 6;
        rates.add(rate1);

        GetBeerResponseRate rate2 = new GetBeerResponseRate();
        rate2.tasteRating = 7;
        rate2.colorRating = 8;
        rate2.aromaRating = 6;
        rates.add(rate2);

        GetBeerResponseRate rate3 = new GetBeerResponseRate();
        rate3.tasteRating = 8;
        rate3.colorRating = 7;
        rate3.aromaRating = 7;
        rates.add(rate3);

        assertEquals(6.0, BeerAverageRatingCalculator.execute(rates), 0.9);
    }

    @Test
    public void averageRatingIsZeroWhenListIsEmpty() {
        List<GetBeerResponseRate> rates = new ArrayList<>();

        assertEquals(0, BeerAverageRatingCalculator.execute(rates), 0.01);
    }

    @Test
    public void averageRatingIsZeroWhenListIsNull() {
        assertEquals(0, BeerAverageRatingCalculator.execute(null), 0.01);
    }

    @Test
    public void averageRatingIsCorrectWhenAllRatingsAreSame() {
        List<GetBeerResponseRate> rates = new ArrayList<>();

        GetBeerResponseRate rate = new GetBeerResponseRate();
        rate.tasteRating = 5;
        rate.colorRating = 5;
        rate.aromaRating = 5;
        rates.add(rate);

        assertEquals(5.0, BeerAverageRatingCalculator.execute(rates), 0.01);
    }

    @Test
    public void averageRatingIsCorrectWithDifferentRatings() {
        List<GetBeerResponseRate> rates = new ArrayList<>();

        GetBeerResponseRate rate1 = new GetBeerResponseRate();
        rate1.tasteRating = 1;
        rate1.colorRating = 5;
        rate1.aromaRating = 9;
        rates.add(rate1);

        GetBeerResponseRate rate2 = new GetBeerResponseRate();
        rate2.tasteRating = 2;
        rate2.colorRating = 6;
        rate2.aromaRating = 10;
        rates.add(rate2);

        assertEquals(5.5, BeerAverageRatingCalculator.execute(rates), 0.01);
    }

    @Test
    public void averageRatingIsCorrectWithMultipleRatingsSameValues() {
        List<GetBeerResponseRate> rates = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            GetBeerResponseRate rate = new GetBeerResponseRate();
            rate.tasteRating = 3;
            rate.colorRating = 4;
            rate.aromaRating = 5;
            rates.add(rate);
        }

        assertEquals(4.0, BeerAverageRatingCalculator.execute(rates), 0.01);
    }
}
