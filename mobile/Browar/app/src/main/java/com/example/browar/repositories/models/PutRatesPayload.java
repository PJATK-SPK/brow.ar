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
