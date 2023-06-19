package com.example.tuprak_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    TextView yourName, score;

    ImageView profile;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        yourName = findViewById(R.id.yourName);
        score = findViewById(R.id.score);
        profile = findViewById(R.id.profile);
        btnPlay = findViewById(R.id.btnPlay);

        String name = getIntent().getStringExtra("name");
        yourName.setText(name);

        String profileImage = getIntent().getStringExtra("profile_image");
        if (profileImage != null){
            Uri profileImageUri = Uri.parse(profileImage);
            profile.setImageURI(profileImageUri);
        }


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("profile_image", profileImage);
                startActivity(intent);
            }
        });
    }
}