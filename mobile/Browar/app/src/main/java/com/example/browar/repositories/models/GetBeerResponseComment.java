package com.example.browar.repositories.models;

import com.google.gson.annotations.SerializedName;

public class GetBeerResponseComment {
    public int id;

    public String content;

    @SerializedName("is_mock")
    public boolean isMock;
}
