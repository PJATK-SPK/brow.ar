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

/**
 * Class to define payload for posting beers.
 */
public class PostBeerPayload {
    /**
     * The name of the beer.
     */
    public String name;

    /**
     * The id of the manufacturer of the beer.
     */
    public int manufacturerId;

    /**
     * The URL of the image representing the beer.
     */
    public String imageUrl;

    /**
     * The description of the beer.
     */
    public String description;

    // setters

    /**
     * Setter for the name of the beer.
     * @param name the name of the beer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the manufacturer id of the beer.
     * @param manufacturerId the id of the manufacturer
     */
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     * Setter for the image URL of the beer.
     * @param imageUrl the URL of the image
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Setter for the description of the beer.
     * @param description the description of the beer
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
