package com.example.browar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.browar.repositories.models.GetBeerResponseComment;

import java.util.List;

public class BeerCommentsAdapter extends RecyclerView.Adapter<BeerCommentsAdapter.CommentViewHolder> {
    private List<GetBeerResponseComment> comments;

    public BeerCommentsAdapter(List<GetBeerResponseComment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        GetBeerResponseComment comment = comments.get(position);
        holder.content.setText(comment.content);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView content;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            content = itemView.findViewById(R.id.comment_content);
        }
    }
}
