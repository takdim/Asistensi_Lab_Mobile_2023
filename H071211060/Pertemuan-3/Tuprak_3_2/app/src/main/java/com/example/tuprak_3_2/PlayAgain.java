package com.example.tuprak_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayAgain extends AppCompatActivity {


    TextView yourName, bestScore;
    Button btnPlay;

    ImageView profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);

        yourName = findViewById(R.id.yourName);
        bestScore = findViewById(R.id.score);
        profile = findViewById(R.id.profile);
        btnPlay = findViewById(R.id.btnPlay);

        String profileImage = getIntent().getStringExtra("profile_image");
        if (profileImage != null){
            Uri profileImageUri = Uri.parse(profileImage);
            profile.setImageURI(profileImageUri);
        }

        String name = getIntent().getStringExtra("name");
        yourName.setText(name);

        int s = getIntent().getIntExtra("bestScore", 0);
        String score = String.valueOf(s);

        bestScore.setText("Best Score : " + score);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("profile_image", profileImage);
                intent.putExtra("bestScore", s);
                startActivity(intent);
            }
        });

    }
}