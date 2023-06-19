package com.example.tuprak_3_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    TextView questAmount, question;
    Button answerA, answerB, answerC, answerD;
    int score = 0;
    int totalQuestion = 5;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    int amountOfQuestion = 1;
    int bestScore = 0;
    int newScore = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        questAmount = findViewById(R.id.questAmount);
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        answerD.setOnClickListener(this);

        questAmount.setText("Question " + amountOfQuestion + " of " + totalQuestion);
        newQuestion();

    }

    @Override
    public void onClick(View view) {

        answerA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.btnColor));
        answerB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.btnColor));
        answerC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.btnColor));
        answerD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.btnColor));


        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.answerA || clickedButton.getId() == R.id.answerB || clickedButton.getId() == R.id.answerC || clickedButton.getId() == R.id.answerD) {
            selectedAnswer = clickedButton.getText().toString();
            if (selectedAnswer.equals(Question.correctAns[currentQuestionIndex])) {
                clickedButton.setBackgroundColor(Color.GREEN);
                score = score + 50;
            } else if (selectedAnswer != Question.correctAns[currentQuestionIndex]) {
                clickedButton.setBackgroundColor(Color.RED);
            }
            currentQuestionIndex++;
            amountOfQuestion++;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (currentQuestionIndex == 5) {
                        String name = getIntent().getStringExtra("name");
                        String profileImage = getIntent().getStringExtra("profile_image");

                        Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                        int a = getIntent().getIntExtra("bestScore", 0);
                        intent.putExtra("name", name);
                        intent.putExtra("profile_image", profileImage);
                        intent.putExtra("TOTAL_SCORE", score);
                        intent.putExtra("bestScore", a);
                        startActivity(intent);
                        return;
                    } else {
                        clickedButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.btnColor));
                        questAmount.setText("Question " + amountOfQuestion + " of " + totalQuestion);
                        newQuestion();
                    }
                }
            }, 1000);
        }
    }
    void newQuestion(){
        question.setText(Question.question[currentQuestionIndex]);

        //Mengambil pilihan jawaban
        answerA.setText(Question.choice[currentQuestionIndex][0]);
        answerB.setText(Question.choice[currentQuestionIndex][1]);
        answerC.setText(Question.choice[currentQuestionIndex][2]);
        answerD.setText(Question.choice[currentQuestionIndex][3]);
    }
}