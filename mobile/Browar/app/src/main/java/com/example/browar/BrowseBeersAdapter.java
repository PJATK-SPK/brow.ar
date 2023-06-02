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
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.browar.repositories.models.GetBeersResponse;

import java.util.List;

public class BrowseBeersAdapter extends RecyclerView.Adapter<BrowseBeersAdapter.BeerViewHolder> {
    private List<GetBeersResponse> beers;

    public static class BeerViewHolder extends RecyclerView.ViewHolder {
        public TextView beerName;
        public ImageView beerImage;

        public BeerViewHolder(View view) {
            super(view);
            beerName = view.findViewById(R.id.beer_name);
            beerImage = view.findViewById(R.id.beer_image);
        }
    }

    public BrowseBeersAdapter(List<GetBeersResponse> beers) {
        this.beers = beers;
    }

    @Override
    public BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_beers_card, parent, false);
        return new BeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeerViewHolder holder, int position) {
        GetBeersResponse beer = beers.get(position);
        holder.beerName.setText(beer.name);

        int pixels = (int) (100 * Resources.getSystem().getDisplayMetrics().density);
        Glide.with(holder.itemView.getContext())
                .load(beer.imageUrl)
                .override(pixels)
                .into(holder.beerImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Beer.class);
                intent.putExtra("BEER_ID", beer.id);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }
}