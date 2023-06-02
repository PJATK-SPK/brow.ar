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
package com.example.browar.repositories;

import com.example.browar.repositories.models.GetBeerResponse;
import com.example.browar.repositories.models.GetBeersResponse;
import com.example.browar.repositories.models.GetManufacturersResponse;
import com.example.browar.repositories.models.PatchBeerPayload;
import com.example.browar.repositories.models.PostBeerPayload;
import com.example.browar.repositories.models.PostCommentPayload;
import com.example.browar.repositories.models.PutRatesPayload;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BackendApi {
    @GET("manufacturers")
    Call<List<GetManufacturersResponse>> getManufacturers();

    @GET("beers")
    Call<List<GetBeersResponse>> getBeers(@Query("search") String search);

    @GET("beers/{id}")
    Call<GetBeerResponse> getBeer(@Path("id") int id);

    @POST("beers")
    Call <Void> addBeer(@Body PostBeerPayload beer);

    @PATCH("beers/{id}")
    Call updateBeer(@Path("id") int beerId, @Body PatchBeerPayload beer);

    @DELETE("beers/{id}")
    Call <Void> deleteBeer(@Path("id") int beerId);

    @PUT("beers/{id}/rates")
    Call <PutRatesPayload> addOrUpdateBeerRate(@Path("id") int beerId, @Body PutRatesPayload beer);

    @POST("beers/{id}/comments")
    Call <Void> addComment(@Path("id") int beerId, @Body PostCommentPayload beer);

    @DELETE("beers/{beerId}/comments/{commentId}")
    Call <Void> deleteComment(@Path("beerId") int beerId, @Path("commentId") int commentId);
}
