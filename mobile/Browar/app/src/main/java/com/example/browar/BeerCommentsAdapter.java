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

/**
 * Adapter for displaying the comments of a beer in a RecyclerView.
 * It handles the creation and binding of the view holders for each comment.
 * It also manages deleting comments through interactions with the backend server.
 */
public class BeerCommentsAdapter extends RecyclerView.Adapter<BeerCommentsAdapter.CommentViewHolder> {
    private List<GetBeerResponseComment> comments;
    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
    private int beerId;

    public BeerCommentsAdapter(List<GetBeerResponseComment> comments, int beerId) {
        this.comments = comments;
        this.beerId = beerId;
    }

    /**
     * Creates a new view holder for a comment.
     *
     * @param parent   The ViewGroup into which the new view will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new CommentViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_comment, parent, false);
        return new CommentViewHolder(view);
    }

    /**
     * Binds the view holder for a comment with the comment data.
     * It sets the content of the comment and handles the deletion of the comment.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
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

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return comments.size();
    }

    /**
     * A view holder for a beer comment, which includes an avatar, the comment content,
     * and a delete button.
     */
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
