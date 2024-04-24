package com.example.fy_project;

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
import com.example.fy_project.QuestionRepository;

import java.util.ArrayList;

public class CategoryTestActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int timer_value = 20;

    TextView timer_count, total_question, question_no;
    ImageView back_btn;

    int index = 0;
    ArrayList<QuestionOptions> all_questions_list;
    QuestionOptions questionOptions;

    RelativeLayout card_question, card_oA, card_oB, card_oC, card_oD;

    TextView question, oA, oB, oC, oD;

    int user_answers[];
    int depressionScore = 0;
    int anxietyScore = 0;
    int bipolarScore = 0;
    int ocdScore = 0;

    private int missedQuestionsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity_test);

        // Retrieve test category information from intent
        String testCategory = getIntent().getStringExtra("test_category");

        Hooks();
        all_questions_list = QuestionRepository.getQuestionsForCategory(testCategory);
        user_answers = new int[all_questions_list.size()];
        Log.d("TestActivity", "NUMBER: " + String.valueOf(all_questions_list.size()));
        questionOptions = all_questions_list.get(index);

        total_question = findViewById(R.id.total_question);
        total_question.setText("/" + String.valueOf(all_questions_list.size()));
        question_no = findViewById(R.id.question_no);
        back_btn = findViewById(R.id.back_btn);

        SetAllData();

        timer_count = findViewById(R.id.timer_count);
        timer_count.setText("0");
        mProgressBar = findViewById(R.id.progress_bar_horizontal);

        mCountDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer_value--;
                timer_count.setText(String.valueOf(timer_value));
                mProgressBar.setProgress(timer_value * 5);
            }

            @Override
            public void onFinish() {
                // Check if no option was selected
                if (user_answers[index] == 0) {
                    // Increment missed questions count
                    missedQuestionsCount++;

                    // Log the missed question
                    Log.d("TestActivity", "Question " + (index + 1) + " was missed");
                }

                // Move to the next question or handle finish
                if (index != (all_questions_list.size() - 1)) {
                    moveToNextQuestion();
                } else {
                    handleQuestionFinish();
                }
            }

        };
        mCountDownTimer.start();

        // options click
        card_oA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                int selectedOption = questionOptions.getAnswer1();
                user_answers[index] = selectedOption;

                // Log the option click
                Log.d("TestActivity", "Option A selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                // Calculate scores based on the selected category
                switch (questionOptions.getCategory()) {
                    case "Depression":
                        depressionScore += selectedOption;
                        break;
                    case "Anxiety":
                        anxietyScore += selectedOption;
                        break;
                    case "Bipolar Disorder":
                        bipolarScore += selectedOption;
                        break;
                    case "OCD":
                        ocdScore += selectedOption;
                        break;
                }

                moveToNextQuestion();
            }
        });

        card_oB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                int selectedOption = questionOptions.getAnswer2();
                user_answers[index] = selectedOption;

                // Log the option click
                Log.d("TestActivity", "Option B selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                // Calculate scores based on the selected category
                switch (questionOptions.getCategory()) {
                    case "Depression":
                        depressionScore += selectedOption;
                        break;
                    case "Anxiety":
                        anxietyScore += selectedOption;
                        break;
                    case "Bipolar Disorder":
                        bipolarScore += selectedOption;
                        break;
                    case "OCD":
                        ocdScore += selectedOption;
                        break;
                }

                moveToNextQuestion();
            }
        });

        card_oC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                int selectedOption = questionOptions.getAnswer3();
                user_answers[index] = selectedOption;

                // Log the option click
                Log.d("TestActivity", "Option C selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                // Calculate scores based on the selected category
                switch (questionOptions.getCategory()) {
                    case "Depression":
                        depressionScore += selectedOption;
                        break;
                    case "Anxiety":
                        anxietyScore += selectedOption;
                        break;
                    case "Bipolar Disorder":
                        bipolarScore += selectedOption;
                        break;
                    case "OCD":
                        ocdScore += selectedOption;
                        break;
                }

                moveToNextQuestion();
            }
        });

        card_oD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                int selectedOption = questionOptions.getAnswer4();
                user_answers[index] = selectedOption;

                // Log the option click
                Log.d("TestActivity", "Option D selected for question " + (index + 1) + " - Category: " + questionOptions.getCategory());

                // Calculate scores based on the selected category
                switch (questionOptions.getCategory()) {
                    case "Depression":
                        depressionScore += selectedOption;
                        break;
                    case "Anxiety":
                        anxietyScore += selectedOption;
                        break;
                    case "Bipolar Disorder":
                        bipolarScore += selectedOption;
                        break;
                    case "OCD":
                        ocdScore += selectedOption;
                        break;
                }

                moveToNextQuestion();
            }
        });

        // back_btn click listener
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuitTestDialog();
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

    // Modify moveToNextQuestion() to reset the missed questions count
    private void moveToNextQuestion() {


        if (index != (all_questions_list.size() - 1)) {
            index++;
            questionOptions = all_questions_list.get(index);
            question_no.setText(String.valueOf(index + 1));
            SetAllData();
            mCountDownTimer.start();
            timer_value = 20;
        } else {
            handleQuestionFinish();
        }
    }

    private void handleQuestionFinish() {
        // Log final score for the current category
        String currentCategory = questionOptions.getCategory();
        switch (currentCategory) {
            case "Depression":
                Log.d("TestActivity", "Depression Score: " + depressionScore);
                break;
            case "Anxiety":
                Log.d("TestActivity", "Anxiety Score: " + anxietyScore);
                break;
            case "Bipolar":
                Log.d("TestActivity", "Bipolar Score: " + bipolarScore);
                break;
            case "OCD":
                Log.d("TestActivity", "OCD Score: " + ocdScore);
                break;
            default:
                // Handle other categories if needed
                break;
        }
        // Store the missed questions count in a variable
        int totalMissedQuestions = missedQuestionsCount;

        // Evaluate scores for the current category and show results or navigate to the result activity
        evaluateScores(totalMissedQuestions);
    }

    private void evaluateScores(int totalMissedQuestions) {
        // Evaluate scores and show results or navigate to result activity
        // Modify this logic based on your evaluation criteria
        String currentCategory = questionOptions.getCategory();

        switch (currentCategory) {
            case "Depression":
                evaluateDepression(totalMissedQuestions);
                break;
            case "Anxiety":
                evaluateAnxiety(totalMissedQuestions);
                break;
            case "Bipolar Disorder":
                evaluateBipolar(totalMissedQuestions);
                break;
            case "OCD":
                evaluateOCD(totalMissedQuestions);
                break;
            default:
                // Handle other categories if needed
                break;
        }
    }

    private void evaluateDepression(int totalMissedQuestions) {
        String severityLevel;

        if (depressionScore >= 0 && depressionScore <= 10) {
            severityLevel = "You are experiencing a normal level of mood. Keep up the positive attitude!";
        } else if (depressionScore >= 11 && depressionScore <= 16) {
            severityLevel = "You may be facing mild mood disturbance. Consider engaging in activities that uplift your mood.";
        } else if (depressionScore >= 17 && depressionScore <= 20) {
            severityLevel = "Your depression level is borderline clinical. It's important to seek support and consider professional help.Try engaging in activities like staying in touch with loved ones, going on a run, eating healthy and following a routine!";
        } else if (depressionScore >= 21 && depressionScore <= 30) {
            severityLevel = "You are experiencing moderate depression. It's recommended to talk to a mental health professional. Try engaging in activities like staying in touch with loved ones, going on a run, eating healthy and following a routine!";
        } else if (depressionScore >= 31 && depressionScore <= 40) {
            severityLevel = "Your depression level is severe. Please seek immediate professional assistance.";
        } else {
            severityLevel = "Your depression level is extremely high. Urgently reach out to a mental health professional or a helpline.";
        }

        Log.d("TestActivity", "Depression: " + severityLevel + " - Score: " + depressionScore);

        // Redirect to CategoryResultActivity
        redirectToCategoryResult("Depression", severityLevel, depressionScore, totalMissedQuestions);
    }

    private void evaluateAnxiety(int totalMissedQuestions) {
        String severityLevel;

        if (anxietyScore >= 0 && anxietyScore < 17) {
            severityLevel = "Your anxiety level is not present. Continue practicing good mental health habits!Try engaging in activities like the 333 rule, breathing exercises, taking a step back from situations that stress you out and writing down your thought in a diary!";
        } else if (anxietyScore >= 17 && anxietyScore <= 24) {
            severityLevel = "You may be experiencing mild to moderate anxiety. Consider relaxation techniques to manage stress.Try engaging in activities like the 333 rule, breathing exercises, taking a step back from situations that stress you out and writing down your thought in a diary!";
        } else if (anxietyScore >= 25 && anxietyScore <= 30) {
            severityLevel = "Your anxiety level is moderate to severe. It's advisable to seek professional advice and support. Also,try engaging in activities like the 333 rule, breathing exercises, taking a step back from situations that stress you out and writing down your thought in a diary!";
        } else {
            severityLevel = "You seem to have severe anxiety. Please consult with a mental health professional for a more accurate assessment.";  // Adjust as needed
        }

        Log.d("TestActivity", "Anxiety: " + severityLevel + " - Score: " + anxietyScore);

        // Redirect to CategoryResultActivity
        redirectToCategoryResult("Anxiety", severityLevel, anxietyScore, totalMissedQuestions);
    }


//    private void evaluateBipolar(int totalMissedQuestions) {
//        String severityLevel;
//
//        // Modify the conditions based on your evaluation criteria for Bipolar
//        if (bipolarScore >= 23) {
//            severityLevel = "You may be experiencing symptoms of Bipolar Disorder. It's crucial to consult with a mental health professional for a more accurate assessment.";
//        } else {
//            severityLevel = "No indication of Bipolar Disorder. Keep practicing good mental health habits!";
//        }
//
//        Log.d("TestActivity", "Bipolar Disorder: " + severityLevel + " - Score: " + bipolarScore);
//
//        // Redirect to CategoryResultActivity
//        redirectToCategoryResult("Bipolar Disorder", severityLevel, bipolarScore, totalMissedQuestions);
//    }

    private void evaluateBipolar(int totalMissedQuestions) {
        String severityLevel;

        if (bipolarScore >= 0 && bipolarScore <= 10) {
            severityLevel = "You are not showing signs of Bipolar Disorder. Keep up the positive mental health habits!";
        } else if (bipolarScore >= 11 && bipolarScore <= 22) {
            severityLevel = "No indication of Bipolar Disorder. Continue practicing good mental health habits!";
        } else if (bipolarScore >= 23 && bipolarScore <= 30) {
            severityLevel = "You may be experiencing mild symptoms of Bipolar Disorder. Try engaging in activities like get into a routine, sleeping well, tracking your mood\n" +
                    "!\nIt's advisable to monitor your mood and consult with a mental health professional if needed.";
        } else {
            severityLevel = "You may be experiencing symptoms of Bipolar Disorder. Try engaging in activities like get into a routine, sleeping well, tracking your mood\n" +
                    "!\nIt's crucial to consult with a mental health professional for a more accurate assessment.";
        }

        Log.d("TestActivity", "Bipolar Disorder: " + severityLevel + " - Score: " + bipolarScore);

        // Redirect to CategoryResultActivity
        redirectToCategoryResult("Bipolar Disorder", severityLevel, bipolarScore, totalMissedQuestions);
    }


    private void evaluateOCD(int totalMissedQuestions) {
        String severityLevel;

        // Modify the conditions based on your evaluation criteria for OCD
        if (ocdScore >= 21) {
            severityLevel = "You may be showing signs of Obsessive-Compulsive Disorder (OCD). Consider consulting with a mental health professional for further evaluation.Also,try engaging in activities like distracting yourself from compulsions, physical activities and most importantly, learning to accept your thoughts!";
        } else {
            severityLevel = "No indication of Obsessive-Compulsive Disorder (OCD). Keep practicing good mental health habits!";
        }

        Log.d("TestActivity", "OCD: " + severityLevel + " - Score: " + ocdScore);

        // Redirect to CategoryResultActivity
        redirectToCategoryResult("OCD", severityLevel, ocdScore, totalMissedQuestions);
    }


    private void redirectToCategoryResult(String categoryName, String severityLevel, int score, int totalMissedQuestions) {
        // Calculate total marks and percentage
        int totalMarks = all_questions_list.size() * 3; // Assuming each question has a maximum of 3 marks

        // Calculate percentage
        int percentage = (score * 100) / totalMarks;

        // Log the data that will be passed to CategoryResultActivity
        Log.d("CategoryTestActivity", "Category Name: " + categoryName);
        Log.d("CategoryTestActivity", "Total Marks: " + totalMarks);
        Log.d("CategoryTestActivity", "User Score: " + score);
        Log.d("CategoryTestActivity", "Percentage: " + percentage);
        Log.d("CategoryTestActivity", "Total Missed: " + totalMissedQuestions);

        // Prepare intent to start CategoryResultActivity
        Intent intent = new Intent(CategoryTestActivity.this, CategoryResultActivity.class);
        intent.putExtra("category_name", categoryName);
        intent.putExtra("total_marks", totalMarks);
        intent.putExtra("user_score", score);
        intent.putExtra("percentage", percentage);
        intent.putExtra("category_type", severityLevel);
        intent.putExtra("total_missed", totalMissedQuestions);

        startActivity(intent);
        finish(); // Finish the current activity to prevent going back to the test
    }


    private void showQuitTestDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CategoryTestActivity.this);
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