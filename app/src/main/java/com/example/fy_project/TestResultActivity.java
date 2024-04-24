package com.example.fy_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestResultActivity extends AppCompatActivity {

    TextView user_score_tv, test_result, test_score_tv,missed, attempted, exit_btn, final_category;

    int user_score, totalMissedQuestions, totalQuestionsAttempted;
    double score_percent;

    ProgressBar progressBar;

    FirebaseUser user;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);

        user_score = getIntent().getIntExtra("user_score", 0);
        String category = getIntent().getStringExtra("category");

        totalMissedQuestions = getIntent().getIntExtra("totalMissedQuestions", 0);

        totalQuestionsAttempted = 12 - totalMissedQuestions;

        Log.d("TestActivity", "totalMissedQuestions R: " + totalMissedQuestions);
        Log.d("TestActivity", "totalQuestionsAttempted R: " + totalQuestionsAttempted); // Logging user score
// Logging user score


        user_score_tv = findViewById(R.id.user_score_tv);
        test_result = findViewById(R.id.test_result);
        final_category = findViewById(R.id.final_category);
        test_score_tv = findViewById(R.id.test_score);
        exit_btn = findViewById(R.id.exit_btn);
        progressBar = findViewById(R.id.test_progress_bar);
        missed = findViewById(R.id.missed);
        attempted = findViewById(R.id.attempted);



        score_percent = (double) Math.round(((36 - user_score) / 36.0) * 100);
        user_score_tv.setText(score_percent + " %");


        attempted.setText(String.valueOf(totalQuestionsAttempted + " Questions \n Attempted"));
        missed.setText(String.valueOf(totalMissedQuestions +" Question \n Missed" ));



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            progressBar.setProgress((int) score_percent, true);
        }

        test_score_tv.setText((36 - user_score) + "/36");
        if (user_score < 15) {
            test_result.setText("Your mood looks great today. Why stop here? Improve your mental health by participating in many other activities.");
        } else {
            test_result.setText("Your mood doesn't look good today. Help yourself by participating in mental health improvement activities and have a great mental health.");
        }

        // Update the text of new_text_view with the category
        if (category != null && !category.isEmpty()) {
            final_category.setText(category);
        } else {
            final_category.setText("");  // Set empty text if category is unavailable
        }

        // Set click listener for the final category
        final_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the final category is clickable (not "You look good !!!")
                String selectedCategory = final_category.getText().toString().trim();
                if (!selectedCategory.equalsIgnoreCase("You look good !!!")) {
                    startCategoryTestActivity(selectedCategory);
                } else {
                    // Handle the case where "You look good !!!" is selected
                    Toast.makeText(TestResultActivity.this, "You already look good!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TakeATestActivity.class);
                startActivity(intent);
            }
        });

        //get user score
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference();

        reference.child("Score").child(user.getUid()).child("result").setValue(user_score)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(TestResultActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(TestResultActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void startCategoryTestActivity(String category) {
        if (!category.equalsIgnoreCase("You Are Good !!!!")) {
            Log.d("TestActivity", "CATEGORY" + category);
            Intent intent = new Intent(getApplicationContext(), CategoryTestActivity.class);
            intent.putExtra("test_category", category);
            startActivity(intent);
        } else {
            // Handle the case where "You look good !!!" is selected
            Toast.makeText(TestResultActivity.this, "You are totally fine, No need for any test.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), TakeATestActivity.class);
        startActivity(intent);
    }
}
