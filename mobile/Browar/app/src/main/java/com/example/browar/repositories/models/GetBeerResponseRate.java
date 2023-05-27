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
