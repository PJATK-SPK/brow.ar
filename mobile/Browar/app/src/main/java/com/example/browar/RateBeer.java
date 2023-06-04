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
package com.example.browar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.browar.bll.BeerRateChecker;
import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.PutRatesPayload;
import com.example.browar.repositories.utilities.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This activity allows the user to rate a beer on several criteria: taste, color, and aroma.
 * After the user rates the beer and submits, the rating is sent to the backend server.
 */
public class RateBeer extends AppCompatActivity {

    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);

    /**
     * Called when the activity is starting.
     * This is where most initialization should go: calling {@code setContentView(int)}
     * to inflate the activity's UI, and getting extras from intent, such as the beer ID
     * and possibly existing ratings.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                            being shut down then this Bundle contains the data it
     *                            most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_rate_beer);
        Intent intent = getIntent();
        int beerId = intent.getIntExtra("beerId", 0);
        boolean rateMocked = intent.getBooleanExtra("isMocked", true);
        int taste = intent.getIntExtra("taste", 0);
        int color = intent.getIntExtra("color", 0);
        int aroma = intent.getIntExtra("aroma", 0);

        RatingBar ratingTaste = findViewById(R.id.ratingTaste);
        RatingBar ratingColor = findViewById(R.id.ratingColor);
        RatingBar ratingAroma = findViewById(R.id.ratingAroma);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        if (!rateMocked) {
            ratingTaste.setRating(taste);
            ratingColor.setRating(color);
            ratingAroma.setRating(aroma);
        }

        // Handle submit button click
        btnSubmit.setOnClickListener(v -> {
            // Get the ratings
            int tasteRating = (int) ratingTaste.getRating();
            int colorRating = (int) ratingColor.getRating();
            int aromaRating = (int) ratingAroma.getRating();

            // Validate the ratings
            if (!BeerRateChecker.isValid(aromaRating,tasteRating,colorRating)) {
                // Display an error message or toast indicating the valid range of ratings
                Toast.makeText(getApplicationContext(), "Please rate between 1 and 5", Toast.LENGTH_SHORT).show();
                return; // Abort the submission if the ratings are not within the range
            }

            PutRatesPayload ratesPayload = new PutRatesPayload(tasteRating, colorRating, aromaRating);

            Call<PutRatesPayload> call = backendApi.addOrUpdateBeerRate(beerId, ratesPayload);
            call.enqueue(new Callback<PutRatesPayload>() {
                @Override
                public void onResponse(Call<PutRatesPayload> call, Response<PutRatesPayload> response) {
                    finish();
                }

                @Override
                public void onFailure(Call<PutRatesPayload> call, Throwable t) {
                    // Handle failure response
                }
            });
        });
    }
}