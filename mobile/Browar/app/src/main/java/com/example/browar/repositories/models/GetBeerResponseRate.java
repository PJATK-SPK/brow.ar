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

public class GetBeerResponseRate {
    public int id;

    @SerializedName("taste_rating")
    public int tasteRating;

    @SerializedName("color_rating")
    public int colorRating;

    @SerializedName("aroma_rating")
    public int aromaRating;

    @SerializedName("is_mock")
    public boolean isMock;
}
