package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

public class GetBeersResponse {
    public int id;

    public String name;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("is_mock")
    public boolean isMock;
}
