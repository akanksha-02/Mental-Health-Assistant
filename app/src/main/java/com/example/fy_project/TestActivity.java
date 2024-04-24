package com.example.fy_project;

import static com.example.fy_project.TakeATestActivity.listOfQ;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fy_project.Models.QuestionOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private static final int NO_OF_QUESTIONS = 12;

    // Cutoff scores for each category
    private static final int DEPRESSION_CUTOFF = 8;
    private static final int ANXIETY_CUTOFF = 7;
    private static final int OCD_CUTOFF = 2;
    private static final int BIPOLAR_CUTOFF = 6;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i = 0;
    int timer_value = 20;

    TextView timer_count, total_question, question_no;
    ImageView back_btn;

    // test parameters
    int index = 0;
    ArrayList<QuestionOptions> all_questions_list;
    QuestionOptions questionOptions;

    RelativeLayout card_question, card_oA, card_oB, card_oC, card_oD;

    TextView question, oA, oB, oC, oD;

    int user_answers[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int user_score = 0;

    final LoadingDialog loadingDialog = new LoadingDialog(TestActivity.this);
    // category scores
    int depressionScore = 0;
    int anxietyScore = 0;
    int ocdScore = 0;
    int bipolarScore = 0;
    int totalMissedQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Hooks();

        total_question = findViewById(R.id.total_question);
        total_question.setText("/" + String.valueOf(NO_OF_QUESTIONS));
        question_no = findViewById(R.id.question_no);
        back_btn = findViewById(R.id.back_btn);

        all_questions_list = listOfQ;
        questionOptions = all_questions_list.get(index);

        SetAllData();

        timer_count = findViewById(R.id.timer_count);
        timer_count.setText("0");
        mProgressBar = findViewById(R.id.progress_bar_horizontal);

        mCountDownTimer = new CountDownTimer(20000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timer_value = timer_value - 1;
                timer_count.setText(String.valueOf(timer_value));
                mProgressBar.setProgress(timer_value * 5);
            }

            @Override
            public void onFinish() {
                if (user_answers[index] == 0) {
                    totalMissedQuestions++;
                    Log.d("TestActivity", "Question " + (index + 1) + " was missed");
                }

                if (index != (NO_OF_QUESTIONS - 1)) {
                    index++;
                    questionOptions = all_questions_list.get(index);
                    question_no.setText(String.valueOf(index + 1));
                    SetAllData();
                    mCountDownTimer.start();
                    timer_value = 20;
                } else {
                    // Handle the last question, whether the user selected an option or the time is out
                    handleLastQuestion();
                }
            }

        };
        mCountDownTimer.start();

        // options click
        card_oA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                user_answers[index] = questionOptions.getAnswer1();
                Log.d("TestActivity", "Option A selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                if (index != (NO_OF_QUESTIONS - 1)) {
                    index++;
                    questionOptions = all_questions_list.get(index);
                    question_no.setText(String.valueOf(index + 1));
                    SetAllData();
                    mCountDownTimer.start();
                    timer_value = 20;
                } else {
                    handleLastQuestion();
                }
            }
        });

        card_oB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                user_answers[index] = questionOptions.getAnswer2();
                Log.d("TestActivity", "Option B selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                if (index != (NO_OF_QUESTIONS - 1)) {
                    index++;
                    questionOptions = all_questions_list.get(index);
                    question_no.setText(String.valueOf(index + 1));
                    SetAllData();
                    mCountDownTimer.start();
                    timer_value = 20;
                } else {
                    handleLastQuestion();
                }
            }
        });

        card_oC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                user_answers[index] = questionOptions.getAnswer3();
                Log.d("TestActivity", "Option C selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                if (index != (NO_OF_QUESTIONS - 1)) {
                    index++;
                    questionOptions = all_questions_list.get(index);
                    question_no.setText(String.valueOf(index + 1));
                    SetAllData();
                    mCountDownTimer.start();
                    timer_value = 20;
                } else {
                    handleLastQuestion();
                }
            }
        });

        card_oD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                user_answers[index] = questionOptions.getAnswer4();
                Log.d("TestActivity", "Option D selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                if (index != (NO_OF_QUESTIONS - 1)) {
                    index++;
                    questionOptions = all_questions_list.get(index);
                    question_no.setText(String.valueOf(index + 1));
                    SetAllData();
                    mCountDownTimer.start();
                    timer_value = 20;
                } else {
                    handleLastQuestion();
                }
            }
        });

        // back_btn
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
                alertDialogBuilder.setTitle("Quit Test!")
                        .setMessage("Are you sure, you want to quit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), TakeATestActivity.class);
                                finish();
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alertDialogBuilder.create().show();
            }
        });
    }

    private void Hooks() {
        card_oA = findViewById(R.id.op_1);
        card_oB = findViewById(R.id.op_2);
        card_oC = findViewById(R.id.op_3);
        card_oD = findViewById(R.id.op_4);

        oA = findViewById(R.id.op1);
        oB = findViewById(R.id.op2);
        oC = findViewById(R.id.op3);
        oD = findViewById(R.id.op4);
        question = findViewById(R.id.test_question);
    }

    private void SetAllData() {
        question.setText(questionOptions.getQuestion());
        oA.setText(questionOptions.getoA());
        oB.setText(questionOptions.getoB());
        oC.setText(questionOptions.getoC());
        oD.setText(questionOptions.getoD());
    }

    private void handleLastQuestion() {
        Log.d("TestActivity", "Last question reached");

        // Redirect to the result page
        handleQuestionFinish();
    }

    private void handleQuestionFinish() {
        Log.d("TestActivity", "Last question reached");

        if (index == (NO_OF_QUESTIONS - 1)) {
            // If it's the last question, show the result
            // dialog start
            loadingDialog.startLoadingDialog();
            Intent intent = new Intent(getApplicationContext(), TestResultActivity.class);

            // Calculate category scores
            int depressionScore = calculateCategoryScore(Arrays.asList(1, 2, 6, 8, 11));
            int anxietyScore = calculateCategoryScore(Arrays.asList(3, 4, 7, 9));
            int ocdScore = calculateCategoryScore(Arrays.asList(10));
            int bipolarScore = calculateCategoryScore(Arrays.asList(5, 12));

            // Log category scores and whether they passed the cutoff
            Log.d("TestActivity", "Depression Score: " + depressionScore + " (Passed: " + (depressionScore >= DEPRESSION_CUTOFF) + ")");
            Log.d("TestActivity", "Anxiety Score: " + anxietyScore + " (Passed: " + (anxietyScore >= ANXIETY_CUTOFF) + ")");
            Log.d("TestActivity", "OCD Score: " + ocdScore + " (Passed: " + (ocdScore >= OCD_CUTOFF) + ")");
            Log.d("TestActivity", "Bipolar Score: " + bipolarScore + " (Passed: " + (bipolarScore >= BIPOLAR_CUTOFF) + ")");

            // Prioritization logic (modify priorities as needed)
            boolean isDepressionPassed = depressionScore >= DEPRESSION_CUTOFF;
            boolean isAnxietyPassed = anxietyScore >= ANXIETY_CUTOFF;
            boolean isOcdPassed = ocdScore >= OCD_CUTOFF;
            boolean isBipolarPassed = bipolarScore >= BIPOLAR_CUTOFF;

            // List to store the passed categories
            List<String> passedCategories = new ArrayList<>();

            if (isDepressionPassed) {
                passedCategories.add("Depression");
            }
            if (isAnxietyPassed) {
                passedCategories.add("Anxiety");
            }
            if (isOcdPassed) {
                passedCategories.add("OCD");
            }
            if (isBipolarPassed) {
                passedCategories.add("Bipolar Disorder");
            }

            if (!passedCategories.isEmpty()) {
                // Sort the passed categories based on the predefined order
                Collections.sort(passedCategories, (category1, category2) -> {
                    List<String> priorityOrder = Arrays.asList("Depression", "Anxiety", "OCD", "Bipolar Disorder");
                    return Integer.compare(priorityOrder.indexOf(category1), priorityOrder.indexOf(category2));
                });

                // The first category in the sorted list is the highest priority
                String highestCategory = passedCategories.get(0);
                Log.d("TestActivity", "Final Category: " + highestCategory);


                // ... process the highest category (e.g., display results, further tests)
                intent.putExtra("category", highestCategory);
            } else {
                // Handle cases where not all conditions passed

                String message = "You Are Good !!!!";
                intent.putExtra("category", message);
            }

            for (i = 0; i < user_answers.length; i++)
                user_score += user_answers[i];
            intent.putExtra("user_score", user_score);
            intent.putExtra("totalMissedQuestions", totalMissedQuestions);

            startActivity(intent);
            // Dialog stop
            loadingDialog.dismissDialog();
            Log.d("TestActivity", "totalMissedQuestions: " + totalMissedQuestions); // Logging user score

            Log.d("TestActivity", "User score: " + user_score); // Logging user score
        } else {
            // If it's not the last question, proceed to the next question
            index++;
            questionOptions = all_questions_list.get(index);
            question_no.setText(String.valueOf(index + 1));
            SetAllData();
            mCountDownTimer.start();
            timer_value = 20;
        }
    }

    // Helper method to calculate category scores
    private int calculateCategoryScore(List<Integer> questionIndices) {
        int score = 0;
        for (int index : questionIndices) {
            score += user_answers[index - 1]; // Adjusting for 0-based index
        }
        return score;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder.setTitle("Quit Test!")
                .setMessage("Are you sure, you want to quit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), TakeATestActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alertDialogBuilder.create().show();
    }
}
