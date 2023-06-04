package com.example.browar.bll;

public class BeerRateChecker {
    /**
     * Checks if provided rates are valid
     *
     * @param aromaRating Aroma rating
     * @param tasteRating Taste rating
     * @param colorRating Color rating
     * @return True is rates are valid.
     */
    public static Boolean isValid(int aromaRating, int tasteRating, int colorRating){
        if (tasteRating < 1 || tasteRating > 5 ||
                colorRating < 1 || colorRating > 5 ||
                aromaRating < 1 || aromaRating > 5) {
            return false;
        }
        return true;
    }
}
