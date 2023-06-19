package com.example.tuprak_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    AddPostFragment addPostFragment = new AddPostFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    CardView cv_bottom_navigation;
    ImageView iv_home, iv_add, iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv_bottom_navigation = findViewById(R.id.cv_bottom_navigation);
        iv_home = findViewById(R.id.iv_home);
        iv_add = findViewById(R.id.iv_add);
        iv_profile = findViewById(R.id.iv_profile);

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getSimpleName());
        if(!(fragment instanceof HomeFragment)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }


        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                homeFragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_container, homeFragment)
                        .commit();
            }
        });

        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_container, addPostFragment)
                        .commit();
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_container, profileFragment)
                        .commit();
            }
        });


    }
}