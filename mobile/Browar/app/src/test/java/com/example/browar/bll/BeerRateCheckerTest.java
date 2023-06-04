/**
 * Project: Mobile App for Beer rating and commenting (students project)
 *
 * Description: In this app you can search your favorite beverage
 * find out what people think about it in the comments as well as by rating
 * and also rate it yourself according to your taste buds
 *
 * Author Pawel Badysiak
 * Author Sandro Sobczynski
 * Author Marcel Pankanin
 */
package com.example.browar.bll;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeerRateCheckerTest {
    @Test
    public void isValidReturnsTrueWhenRatingsAreInRange() {
        assertTrue(BeerRateChecker.isValid(1, 3, 5));
        assertTrue(BeerRateChecker.isValid(5, 5, 5));
        assertTrue(BeerRateChecker.isValid(1, 1, 1));
    }

    @Test
    public void isValidReturnsFalseWhenTasteRatingIsOutOfRange() {
        assertFalse(BeerRateChecker.isValid(3, 6, 4));
        assertFalse(BeerRateChecker.isValid(3, 0, 4));
    }

    @Test
    public void isValidReturnsFalseWhenColorRatingIsOutOfRange() {
        assertFalse(BeerRateChecker.isValid(2, 3, 6));
        assertFalse(BeerRateChecker.isValid(2, 3, 0));
    }

    @Test
    public void isValidReturnsFalseWhenAromaRatingIsOutOfRange() {
        assertFalse(BeerRateChecker.isValid(6, 3, 2));
        assertFalse(BeerRateChecker.isValid(0, 3, 2));
    }

    @Test
    public void isValidReturnsFalseWhenAllRatingsAreOutOfRange() {
        assertFalse(BeerRateChecker.isValid(0, 0, 0));
        assertFalse(BeerRateChecker.isValid(6, 6, 6));
    }

    @Test
    public void isValidReturnsFalseWhenAtLeastOneRatingIsOutOfRange() {
        assertFalse(BeerRateChecker.isValid(1, 6, 1));
        assertFalse(BeerRateChecker.isValid(1, 1, 6));
        assertFalse(BeerRateChecker.isValid(6, 1, 1));
    }

    @Test
    public void isValidReturnsTrueWhenRatingsAreAtBoundaryValues() {
        assertTrue(BeerRateChecker.isValid(1, 1, 1));
        assertTrue(BeerRateChecker.isValid(5, 5, 5));
    }

    @Test
    public void isValidReturnsFalseWhenRatingsAreOutsideBoundaryValues() {
        assertFalse(BeerRateChecker.isValid(0, 5, 5));
        assertFalse(BeerRateChecker.isValid(5, 0, 5));
        assertFalse(BeerRateChecker.isValid(5, 5, 0));
        assertFalse(BeerRateChecker.isValid(6, 5, 5));
        assertFalse(BeerRateChecker.isValid(5, 6, 5));
        assertFalse(BeerRateChecker.isValid(5, 5, 6));
    }
}