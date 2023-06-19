package com.example.tuprak_6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class ProfileFragment extends Fragment {
    private UserModel user;
    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShapeableImageView ivProfile = view.findViewById(R.id.iv_profil);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvUsername = view.findViewById(R.id.tv_username);

        ivProfile.setImageResource(user.getProfilePicture());
        tvName.setText(user.getFullname());
        tvUsername.setText(user.getUsername());
    }
}