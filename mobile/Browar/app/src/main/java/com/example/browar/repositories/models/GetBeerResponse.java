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

import java.util.List;

/**
 * Class to define the general response for a beer.
 */
public class GetBeerResponse {
    /**
     * Detailed information about the beer.
     */
    @SerializedName("beer")
    public GetBeerResponseDetails details;

    /**
     * A list of comments about the beer.
     */
    public List<GetBeerResponseComment> comments;

    /**
     * A list of ratings for the beer.
     */
    public List<GetBeerResponseRate> rates;
}
