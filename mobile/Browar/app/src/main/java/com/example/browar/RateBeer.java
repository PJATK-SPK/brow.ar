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

import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.PutRatesPayload;
import com.example.browar.repositories.utilities.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RateBeer extends AppCompatActivity {

    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
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
            if (tasteRating < 1 || tasteRating > 5 ||
                    colorRating < 1 || colorRating > 5 ||
                    aromaRating < 1 || aromaRating > 5) {
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