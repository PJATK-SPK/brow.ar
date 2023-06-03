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

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.browar.repositories.BackendApi;
import com.example.browar.repositories.models.PostCommentPayload;
import com.example.browar.repositories.utilities.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity class responsible for adding a new comment.
 * Extends AppCompatActivity to utilize features of the Android compatibility library.
 */
public class AddCommentActivity extends AppCompatActivity {
    // Reference to the backend API to be used for making calls
    private BackendApi backendApi = RetrofitInstance.getRetrofitInstance().create(BackendApi.class);
    // Id of the beer for which a comment is being added
    private int beerId;

    /**
     * This method is part of the Android activity lifecycle and gets called when the activity gets created.
     * @param savedInstanceState Bundle object containing previously saved instance state, can be null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_comment);

        // Get the beerId from the intent extras
        beerId = getIntent().getIntExtra("beerId", 0);

        EditText editTextContent = findViewById(R.id.editTextContent);
        Button buttonAddComment = findViewById(R.id.buttonAddComment);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editTextContent.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    // Create the PostCommentPayload object
                    PostCommentPayload payload = new PostCommentPayload();
                    payload.content = content;

                    // Call the API to add the comment
                    addComment(payload);
                } else {
                    Toast.makeText(AddCommentActivity.this, "Please enter comment content", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity without adding a comment
            }
        });
    }

    /**
     * Method responsible for making a call to the backend API to add a comment.
     * @param payload The payload containing the content of the comment to be added.
     */
    private void addComment(PostCommentPayload payload) {
        backendApi.addComment(beerId, payload).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddCommentActivity.this, "Comment added successfully", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK); // Set the result to indicate success
                } else {
                    Toast.makeText(AddCommentActivity.this, "Failed to add comment", Toast.LENGTH_SHORT).show();
                }
                finish(); // Close the activity
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddCommentActivity.this, "Failed to add comment", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED); // Set the result to indicate failure
                finish(); // Close the activity
            }
        });
    }

}
