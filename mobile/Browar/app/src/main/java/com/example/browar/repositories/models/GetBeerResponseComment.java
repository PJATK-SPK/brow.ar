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

/**
 * Class to define the comment response for a beer.
 */
public class GetBeerResponseComment {
    /**
     * The id of the comment.
     */
    public int id;

    /**
     * The content of the comment.
     */
    public String content;

    /**
     * Boolean flag for mock comments.
     */
    @SerializedName("is_mock")
    public boolean isMock;
}
