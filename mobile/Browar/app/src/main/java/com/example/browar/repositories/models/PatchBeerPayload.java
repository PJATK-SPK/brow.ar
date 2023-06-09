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
 * Class to define payload for updating beers.
 */
public class PatchBeerPayload {
    /**
     * The updated name of the beer.
     */
    public String name;

    /**
     * The updated id of the manufacturer of the beer.
     */
    @SerializedName("manufacturer_id")
    public int manufacturerId;

    /**
     * The updated URL of the image representing the beer.
     */
    @SerializedName("image_url")
    public String imageUrl;

    /**
     * The updated description of the beer.
     */
    public String description;
}
