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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.browar.bll.BeerAverageRatingCalculator;
import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.GetBeerResponse;
import com.example.browar.repositories.models.GetBeerResponseRate;
import com.example.browar.repositories.utilities.RetrofitInstance;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * This activity handles the display and management of an individual beer's details.
 * It fetches the beer's details from a backend server, calculates an average rating, and allows
 * users to rate the beer, add comments and delete the beer.
 */
public class Beer extends AppCompatActivity {
    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
    private GetBeerResponse beer;
    private static final int RATE_BEER_REQUEST_CODE = 1;
    private static final int ADD_COMMENT_REQUEST_CODE = 1;

    /**
     * This method is executed when the activity is first created.
     * It fetches the beer's details based on the beer ID passed through the intent.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                            being shut down then this Bundle contains the data it
     *                            most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer);

        Intent intent = getIntent();
        int beerId = intent.getIntExtra("BEER_ID", 0);

        fetchBeer(beerId);
    }

    /**
     * This method is called when an activity that was launched for a result has finished its execution.
     * In this case, the beer details are refreshed by re-fetching the beer's details from the backend server.
     *
     * @param requestCode The integer request code originally supplied to startActivityForResult(),
     *                    allowing you to identify who this result came from.
     * @param resultCode  The integer result code returned by the child activity through its setResult().
     * @param data        An Intent, which can return result data to the caller.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = getIntent();
        int beerId = intent.getIntExtra("BEER_ID", 0);

            // The RateBeer activity has finished successfully
            // Refresh the Beer activity here
            fetchBeer(beerId);
    }

    /**
     * Fetches the beer's details from the backend server based on the provided beer ID.
     *
     * @param id The ID of the beer to fetch.
     */
    public void fetchBeer(int id) {
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
                    Button removeBeer = findViewById(R.id.remove_beer_button);
                    Button rateBeer = findViewById(R.id.add_rating_button);
                    Button addCommentButton = findViewById(R.id.add_comment_button);

                    // Load beer image using library such as Glide or Picasso
                    Glide.with(Beer.this)
                            .load(beer.details.imageUrl)
                            .into(beerImage);

                    // Set beer name, manufacturer, and description
                    beerName.setText(beer.details.name);
                    beerManufacturer.setText(beer.details.manufacturerName);
                    beerDescription.setText(beer.details.description);

                    if (!beer.details.isMock) {
                        removeBeer.setVisibility(View.VISIBLE);
                    }

                    removeBeer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Call<Void> call = backendApi.deleteBeer(id);
                                call.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {
                                        showPopup();
                                    }

                                    @Override
                                    public void onFailure(Call<Void> call, Throwable t) {
                                        // obsłuż błąd
                                    }
                                });
                            }
                    });

                    rateBeer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(Beer.this, RateBeer.class);
                            intent.putExtra("beerId", id);
                            for (GetBeerResponseRate rate : beer.rates) {
                                if (!rate.isMock) {
                                    intent.putExtra("isMocked", false);
                                    intent.putExtra("taste", rate.tasteRating);
                                    intent.putExtra("aroma", rate.aromaRating);
                                    intent.putExtra("color", rate.colorRating);
                                }
                            }
                            startActivityForResult(intent, RATE_BEER_REQUEST_CODE);
                            };
                    });

                    // Button click listener for showing the add comment dialog
                    addCommentButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Beer.this, AddCommentActivity.class);
                            intent.putExtra("beerId", id); // Pass any necessary data to the AddCommentActivity
                            startActivityForResult(intent, ADD_COMMENT_REQUEST_CODE);
                        }
                    });

                    // Calculate average ratings and set rating bar
                    float averageRating = BeerAverageRatingCalculator.execute(beer.rates);
                    beerRating.setRating(averageRating);

                    // Set up RecyclerView with comments
                    BeerCommentsAdapter commentsAdapter = new BeerCommentsAdapter(beer.comments, id);
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

    /**
     * Displays a popup message indicating the beer has been deleted. Once the user clicks OK,
     * they are redirected to the BrowseBeers activity.
     */
    public void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Beer deleted!")
                .setMessage("Press OK to return to beer search window")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle OK button click
                                dialog.dismiss();
                                Intent intent = new Intent(Beer.this, BrowseBeers.class);
                                startActivity(intent);
                            }
                        }
                );

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}