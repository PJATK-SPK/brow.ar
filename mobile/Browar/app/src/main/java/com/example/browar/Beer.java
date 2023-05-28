// TODO PAWEL - Authors

package com.example.browar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.GetBeerResponse;
import com.example.browar.repositories.models.GetBeerResponseComment;
import com.example.browar.repositories.models.GetBeerResponseRate;
import com.example.browar.repositories.models.GetBeersResponse;
import com.example.browar.repositories.utilities.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Beer extends AppCompatActivity {
    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
    private GetBeerResponse beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer);

        Intent intent = getIntent();
        int beerId = intent.getIntExtra("BEER_ID", 0);

        fetchBeer(beerId);

//        Button returnButton = findViewById(R.id.returnButton);
//        returnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Beer.this, BrowseBeers.class);
//                startActivity(intent);
//            }
//        });
    }

    private void fetchBeer(int id) {
        Call<GetBeerResponse> call = backendApi.getBeer(id);
        call.enqueue(new Callback<GetBeerResponse>() {
            @Override
            public void onResponse(Call<GetBeerResponse> call, Response<GetBeerResponse> response) {
                if (response.isSuccessful()) {
                    beer = response.body();

                    ImageView beerImage = findViewById(R.id.beer_image);
                    TextView beerName = findViewById(R.id.beer_name);
                    TextView beerManufacturer = findViewById(R.id.beer_manufacturer);
                    TextView beerDescription = findViewById(R.id.beer_description);
                    RatingBar beerRating = findViewById(R.id.beer_rating);
                    RecyclerView commentsSection = findViewById(R.id.comments_section);

                    // Load beer image using library such as Glide or Picasso
                    Glide.with(Beer.this)
                            .load(beer.details.imageUrl)
                            .into(beerImage);

                    // Set beer name, manufacturer, and description
                    beerName.setText(beer.details.name);
                    beerManufacturer.setText(beer.details.manufacturerName);
                    beerDescription.setText(beer.details.description);

                    // Calculate average ratings and set rating bar
                    float averageRating = calculateAverageRating(beer.rates);
                    beerRating.setRating(averageRating);

                    // Set up RecyclerView with comments
                    BeerCommentsAdapter commentsAdapter = new BeerCommentsAdapter(beer.comments);
                    commentsSection.setLayoutManager(new LinearLayoutManager(Beer.this));
                    commentsSection.setAdapter(commentsAdapter);
                }
            }

            @Override
            public void onFailure(Call<GetBeerResponse> call, Throwable t) {
                // obsłuż błąd
            }
        });
    }

    private float calculateAverageRating(List<GetBeerResponseRate> rates) {
        if (rates == null || rates.isEmpty()) {
            return 0;
        }
        float total = 0;
        for (GetBeerResponseRate rate : rates) {
            total += (rate.tasteRating + rate.colorRating + rate.aromaRating) / 3.0;
        }
        return total / rates.size();
    }
}