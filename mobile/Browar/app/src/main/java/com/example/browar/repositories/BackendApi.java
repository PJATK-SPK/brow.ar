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

/**
 * Interface defining the API endpoints.
 */
public interface BackendApi {
    /**
     * Get a list of manufacturers from the server.
     * @return a Call object with a list of manufacturers in the response
     */
    @GET("manufacturers")
    Call<List<GetManufacturersResponse>> getManufacturers();

    /**
     * Get a list of beers from the server, with an optional search parameter.
     * @param search the search term to filter the beers
     * @return a Call object with a list of beers in the response
     */
    @GET("beers")
    Call<List<GetBeersResponse>> getBeers(@Query("search") String search);

    /**
     * Get a specific beer from the server.
     * @param id the ID of the beer
     * @return a Call object with the beer details in the response
     */
    @GET("beers/{id}")
    Call<GetBeerResponse> getBeer(@Path("id") int id);

    /**
     * Send a POST request to the server to add a new beer.
     * @param beer the beer details to send in the request body
     * @return a Call object for the request
     */
    @POST("beers")
    Call <Void> addBeer(@Body PostBeerPayload beer);

    /**
     * Send a PATCH request to the server to update a specific beer.
     * @param beerId the ID of the beer to update
     * @param beer the updated beer details to send in the request body
     * @return a Call object for the request
     */
    @PATCH("beers/{id}")
    Call updateBeer(@Path("id") int beerId, @Body PatchBeerPayload beer);

    /**
     * Send a DELETE request to the server to delete a specific beer.
     * @param beerId the ID of the beer to delete
     * @return a Call object for the request
     */
    @DELETE("beers/{id}")
    Call <Void> deleteBeer(@Path("id") int beerId);

    /**
     * Send a PUT request to the server to add or update a rating for a specific beer.
     * @param beerId the ID of the beer to rate
     * @param beer the rating details to send in the request body
     * @return a Call object with the rating in the response
     */
    @PUT("beers/{id}/rates")
    Call <PutRatesPayload> addOrUpdateBeerRate(@Path("id") int beerId, @Body PutRatesPayload beer);

    /**
     * Send a POST request to the server to add a new comment for a specific beer.
     * @param beerId the ID of the beer to comment on
     * @param beer the comment to send in the request body
     * @return a Call object for the request
     */
    @POST("beers/{id}/comments")
    Call <Void> addComment(@Path("id") int beerId, @Body PostCommentPayload beer);

    /**
     * Send a DELETE request to the server to delete a specific comment for a specific beer.
     * @param beerId the ID of the beer
     * @param commentId the ID of the comment to delete
     * @return a Call object for the request
     */
    @DELETE("beers/{beerId}/comments/{commentId}")
    Call <Void> deleteComment(@Path("beerId") int beerId, @Path("commentId") int commentId);
}
