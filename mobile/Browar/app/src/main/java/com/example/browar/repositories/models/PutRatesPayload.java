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

public class PutRatesPayload {
    @SerializedName("tasteRating")
    public int tasteRating;

    @SerializedName("colorRating")
    public int colorRating;

    @SerializedName("aromaRating")
    public int aromaRating;

    public PutRatesPayload(int tasteRating, int colorRating, int aromaRating) {
        this.tasteRating = tasteRating;
        this.colorRating = colorRating;
        this.aromaRating = aromaRating;
    }
}
