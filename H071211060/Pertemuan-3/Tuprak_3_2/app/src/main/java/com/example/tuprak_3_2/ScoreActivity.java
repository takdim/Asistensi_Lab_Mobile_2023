package com.example.tuprak_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {


    TextView newScore, bestScore, status;
    Button btnBack;
    int score;
    int a = 0;
    int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        newScore = findViewById(R.id.newScore);
        bestScore = findViewById(R.id.bestScore);
        status = findViewById(R.id.status);
        btnBack = findViewById(R.id.btnBack);

        String profileImage = getIntent().getStringExtra("profile_image");
        String name = getIntent().getStringExtra("name");
        int bs = getIntent().getIntExtra("bestScore",0);
        status.setText("MANTULLL " + name + "!!");
        score = getIntent().getIntExtra("TOTAL_SCORE", 0);
        String s = String.valueOf(score);

        a = bs;
        b = score;
        newScore.setText(String.valueOf(score));
        bestScore.setText(String.valueOf(bs));
        if (b > a){
            a = b;
            bestScore.setText(String.valueOf(a));
        } else {

        }








        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PlayAgain.class);
                intent.putExtra("name", name);
                intent.putExtra("profile_image", profileImage);
                intent.putExtra("bestScore", a);
                startActivity(intent);
            }
        });

    }
}