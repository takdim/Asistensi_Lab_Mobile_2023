package com.example.tuprak_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    String profileUri;
    EditText edName;
    Button btnSubmit;
    private ImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.name);
        btnSubmit = findViewById(R.id.btnSubmit);
        profile = findViewById(R.id.profile);

        String name = getIntent().getStringExtra("name");

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Pilih Foto"), PICK_IMAGE_REQUEST);
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edName.getText().toString();

                if (edName.getText().toString().isEmpty()) {
                    edName.setError("Input Your Name");
                } else {
                    Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("profile_image", profileUri);
                    startActivity(intent);

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            profileUri = uri.toString();
            profile.setImageURI(uri);
        }
    }
}