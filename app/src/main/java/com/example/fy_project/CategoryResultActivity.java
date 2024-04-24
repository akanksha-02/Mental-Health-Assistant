
package com.example.fy_project;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;


public class CategoryResultActivity extends AppCompatActivity {

    TextView user_score_tv, test_result,t1, test_score_tv,attempted,missed, exit_btn ;

    int user_score;

    ProgressBar progressBar;

    FirebaseUser user;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity_result);



        user_score_tv = findViewById(R.id.user_score_tv);
        test_result = findViewById(R.id.test_result);
        test_score_tv = findViewById(R.id.test_score);
        exit_btn = findViewById(R.id.exit_btn);
        progressBar = findViewById(R.id.test_progress_bar);
        t1 = findViewById(R.id.t1);
        missed = findViewById(R.id.missed);
        attempted = findViewById(R.id.attempted);


        // Get data from the intent
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("category_name");
        String categoryType = intent.getStringExtra("category_type");
        int totalMarks = intent.getIntExtra("total_marks", 0);
        user_score = intent.getIntExtra("user_score", 0);
        int score_percent = intent.getIntExtra("percentage", 0);
        int missedQuestionsCount = getIntent().getIntExtra("total_missed", 0);

        int attemptedQuestionsCount = totalMarks / 3 - missedQuestionsCount;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            progressBar.setProgress((int) score_percent, true);
        }


        test_score_tv.setText(user_score +"/"+ totalMarks);
        user_score_tv.setText(score_percent + " %");
        test_result.setText(categoryType);
        t1.setText(categoryName + " Test Score Analysis");
        missed.setText(missedQuestionsCount + " questions\nSkipped");
        attempted.setText(attemptedQuestionsCount + " questions\nAttempted");


        // Set click listener for the final category

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TakeATestActivity.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), TakeATestActivity.class);
        startActivity(intent);
    }
}
