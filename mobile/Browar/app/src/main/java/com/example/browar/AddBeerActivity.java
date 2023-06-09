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
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.PostBeerPayload;
import com.example.browar.repositories.utilities.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity for adding a new beer.
 */
public class AddBeerActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Spinner manufacturerSpinner;
    private EditText imageUrlEditText;
    private EditText descriptionEditText;
    private Button saveButton;
    private ImageButton backButton;

    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);

    /**
     * Sets up the activity, finding views and setting click listeners.
     * @param savedInstanceState if the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);

        // Find views
        nameEditText = findViewById(R.id.beerNameEditText);
        manufacturerSpinner = findViewById(R.id.manufacturerSpinner);
        imageUrlEditText = findViewById(R.id.imageUrlEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        // Set click listener for the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBeer();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBackToBrowseBeersPage();
            }
        });
    }

    /**
     * Navigates back to the Browse Beers page.
     */
    private void getBackToBrowseBeersPage() {
        Intent intent = new Intent(AddBeerActivity.this, BrowseBeers.class);
        startActivity(intent);
        finish();
    }

    /**
     * Retrieves the user input and sends a POST request to save a new beer.
     */
    private void saveBeer() {
        // Get the values from the input fields
        String name = nameEditText.getText().toString();
        String imageUrl = imageUrlEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        // Get the selected manufacturer ID from the spinner
        int manufacturerId = (int) manufacturerSpinner.getSelectedItemId() + 1;

        // Create a new PostBeerPayload object with the input values
        PostBeerPayload beerPayload = new PostBeerPayload();
        beerPayload.setName(name);
        beerPayload.setManufacturerId(manufacturerId);
        beerPayload.setImageUrl(imageUrl);
        beerPayload.setDescription(description);

        // Make the POST request to add the beer
        Call<Void> call = backendApi.addBeer(beerPayload);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Beer added successfully
                    Toast.makeText(AddBeerActivity.this, "Beer added successfully", Toast.LENGTH_SHORT).show();

                    // Return to the previous screen after a delay
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getBackToBrowseBeersPage();
                        }
                    }, 1000); // Delay for 1 second (adjust as needed)
                } else {
                    // Handle error response
                    Toast.makeText(AddBeerActivity.this, "Failed to add beer. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle network failure or other error
                Toast.makeText(AddBeerActivity.this, "Failed to add beer. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

