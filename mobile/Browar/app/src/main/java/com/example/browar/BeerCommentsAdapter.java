package com.example.browar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.GetBeerResponseComment;
import com.example.browar.repositories.utilities.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerCommentsAdapter extends RecyclerView.Adapter<BeerCommentsAdapter.CommentViewHolder> {
    private List<GetBeerResponseComment> comments;
    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
    private int beerId;

    public BeerCommentsAdapter(List<GetBeerResponseComment> comments, int beerId) {
        this.comments = comments;
        this.beerId = beerId;
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

        // Check if the comment is a mock comment
        boolean isMockComment = comment.isMock;

        if (isMockComment) {
            // If it's a mock comment, hide the delete button
            holder.deleteButton.setVisibility(View.GONE);
        } else {
            // If it's not a mock comment, show the delete button
            holder.deleteButton.setVisibility(View.VISIBLE);
            holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int commentId = comment.id; // Get the ID of the comment
                    // Call the deleteComment method from your BackendApi interface to delete the comment
                    Call<Void> deleteCommentCall = backendApi.deleteComment(beerId, commentId);
                    deleteCommentCall.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.isSuccessful()) {
                                // Comment deleted successfully
                                comments.remove(comment); // Remove the comment from the list
                                notifyDataSetChanged(); // Notify the adapter of the change
                            } else {
                                // Handle API error
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            // Handle failure
                        }
                    });
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView content;
        ImageButton deleteButton;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            content = itemView.findViewById(R.id.comment_content);
            deleteButton = itemView.findViewById(R.id.delete_comment_button);
        }
    }
}
