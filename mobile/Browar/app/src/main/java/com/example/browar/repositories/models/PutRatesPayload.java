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
package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

/**
 * Class to define payload for rating beers.
 */
public class PutRatesPayload {
    /**
     * Rating for the taste of the beer.
     */
    @SerializedName("tasteRating")
    public int tasteRating;

    /**
     * Rating for the color of the beer.
     */
    @SerializedName("colorRating")
    public int colorRating;

    /**
     * Rating for the aroma of the beer.
     */
    @SerializedName("aromaRating")
    public int aromaRating;

    /**
     * Constructor for PutRatesPayload.
     * @param tasteRating integer representing the taste rating
     * @param colorRating integer representing the color rating
     * @param aromaRating integer representing the aroma rating
     */
    public PutRatesPayload(int tasteRating, int colorRating, int aromaRating) {
        this.tasteRating = tasteRating;
        this.colorRating = colorRating;
        this.aromaRating = aromaRating;
    }
}
