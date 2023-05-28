package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBeerResponse {
    @SerializedName("beer")
    public GetBeerResponseDetails details;

    public List<GetBeerResponseComment> comments;

    public List<GetBeerResponseRate> rates;
}
