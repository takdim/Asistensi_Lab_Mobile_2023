package com.example.tuprak_6;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddPostFragment extends Fragment {
    ActivityResultLauncher<Intent> imageSelect;
    UserModel user;
    String image;
    ImageView ivPhoto;
    EditText etCaption;
    Button btnUpload;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = new UserModel("@andi_bagoes14", "Andi Muh. Ibnu Hibban Bagoes Malolo", R.drawable.gambarmuka, new PostModel());
        ivPhoto = view.findViewById(R.id.iv_photo);
        etCaption = view.findViewById(R.id.et_caption);
        btnUpload = view.findViewById(R.id.btn_upload);

        imageSelect = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK || result.getData() != null) {
                Uri uri = result.getData().getData();
                image = uri.toString();

                ivPhoto.setImageURI(uri);

                user.getPost().setPhoto(uri);
            }
        });

        ivPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            imageSelect.launch(intent);
        });

        btnUpload.setOnClickListener(v -> {
            String caption = etCaption.getText().toString();
            user.getPost().setCaption(caption);
            HomeFragment.dataSource.addUser(user);

            HomeFragment homeFragment = new HomeFragment();

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment)
                    .commit();
            etCaption.getText().clear();
        });

    }
}