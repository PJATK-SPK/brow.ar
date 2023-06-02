package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostBeerPayload {
    public String name;

    public int manufacturerId;

    public String imageUrl;

    public String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
