// TODO PAWEL - Authors

package com.example.browar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.GetBeersResponse;
import com.example.browar.repositories.utilities.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrowseBeers extends AppCompatActivity {
    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
    List<GetBeersResponse> beers = new ArrayList<>();
    private RecyclerView recyclerView;
    private BeerAdapter beerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_beers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        beerAdapter = new BeerAdapter(beers);
        recyclerView.setAdapter(beerAdapter);

        fetchBeers();

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseBeers.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    private void fetchBeers() {
        Call<List<GetBeersResponse>> call = backendApi.getBeers();
        call.enqueue(new Callback<List<GetBeersResponse>>() {
            @Override
            public void onResponse(Call<List<GetBeersResponse>> call, Response<List<GetBeersResponse>> response) {
                if (response.isSuccessful()) {
                    beers = response.body();
                    beerAdapter = new BeerAdapter(beers);
                    recyclerView.setAdapter(beerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<GetBeersResponse>> call, Throwable t) {
                // obsłuż błąd
            }
        });
    }
}