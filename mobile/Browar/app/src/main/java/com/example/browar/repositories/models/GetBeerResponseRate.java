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
 * Class to define the rating response for a beer.
 */
public class GetBeerResponseRate {
    /**
     * The id of the rating.
     */
    public int id;

    /**
     * The taste rating of the beer.
     */
    @SerializedName("taste_rating")
    public int tasteRating;

    /**
     * The color rating of the beer.
     */
    @SerializedName("color_rating")
    public int colorRating;

    /**
     * The aroma rating of the beer.
     */
    @SerializedName("aroma_rating")
    public int aromaRating;

    /**
     * Boolean flag for mock ratings.
     */
    @SerializedName("is_mock")
    public boolean isMock;
}
