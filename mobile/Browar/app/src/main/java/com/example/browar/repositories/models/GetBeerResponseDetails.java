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
 * Class to define the detailed response for a beer.
 */
public class GetBeerResponseDetails {
    /**
     * The id of the beer.
     */
    public int id;

    /**
     * The name of the beer.
     */
    public String name;

    /**
     * The name of the manufacturer of the beer.
     */
    @SerializedName("manufacturer_name")
    public String manufacturerName;

    /**
     * The URL of the image representing the beer.
     */
    @SerializedName("image_url")
    public String imageUrl;

    /**
     * The description of the beer.
     */
    public String description;

    /**
     * Boolean flag for mock beers.
     */
    @SerializedName("is_mock")
    public boolean isMock;
}
