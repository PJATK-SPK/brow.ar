package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

public class PutRatesPayload {
    @SerializedName("taste_rating")
    public int tasteRating;

    @SerializedName("color_rating")
    public int colorRating;

    @SerializedName("aroma_rating")
    public int aromaRating;
}
