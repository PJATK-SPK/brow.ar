package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostBeerPayload {
    public String name;

    @SerializedName("manufacturer_id")
    public int manufacturerId;

    @SerializedName("image_url")
    public String imageUrl;

    public String description;
}
