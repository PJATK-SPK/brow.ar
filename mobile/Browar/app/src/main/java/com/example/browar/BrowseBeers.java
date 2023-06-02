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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private BrowseBeersAdapter browseBeersAdapter;

    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_beers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        browseBeersAdapter = new BrowseBeersAdapter(beers);
        recyclerView.setAdapter(browseBeersAdapter);

        fetchBeers("");

        searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // not used
            }

            @Override
            public void afterTextChanged(Editable s) {
                fetchBeers(s.toString());
            }
        });

        Button addBeerButton = findViewById(R.id.addBeer);
        addBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseBeers.this, AddBeerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fetchBeers(String search) {
        Call<List<GetBeersResponse>> call = backendApi.getBeers(search);
        call.enqueue(new Callback<List<GetBeersResponse>>() {
            @Override
            public void onResponse(Call<List<GetBeersResponse>> call, Response<List<GetBeersResponse>> response) {
                if (response.isSuccessful()) {
                    beers = response.body();
                    browseBeersAdapter = new BrowseBeersAdapter(beers);
                    recyclerView.setAdapter(browseBeersAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<GetBeersResponse>> call, Throwable t) {
                // obsłuż błąd
            }
        });
    }
}