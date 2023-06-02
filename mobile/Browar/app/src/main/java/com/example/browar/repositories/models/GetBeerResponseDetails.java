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

public class GetBeerResponseDetails {
    public int id;

    public String name;

    @SerializedName("manufacturer_name")
    public String manufacturerName;

    @SerializedName("image_url")
    public String imageUrl;

    public String description;

    @SerializedName("is_mock")
    public boolean isMock;
}
