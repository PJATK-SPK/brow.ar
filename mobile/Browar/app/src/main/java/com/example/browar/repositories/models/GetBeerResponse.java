package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBeerResponse {
    public int id;

    public String name;

    @SerializedName("manufacturer_name")
    public String manufacturerName;

    @SerializedName("image_url")
    public String imageUrl;

    public String description;

    @SerializedName("is_mock")
    public boolean isMock;

    public List<GetBeerResponseComment> comments;

    public List<GetBeerResponseRate> rates;
}
