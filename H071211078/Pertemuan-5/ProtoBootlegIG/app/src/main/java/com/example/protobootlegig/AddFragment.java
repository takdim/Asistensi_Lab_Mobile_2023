package com.example.protobootlegig;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.protobootlegig.databinding.FragmentAddBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {
    FragmentAddBinding binding;
    private Uri uriPic;
    List<String[]> items = new ArrayList<>();
    ActivityResultLauncher<Intent> imagePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imagePicker =  registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),result -> {
                    if(result.getData() != null){
                        uriPic = result.getData().getData();
                        if(uriPic != null){
                            Glide.with(requireActivity())
                                    .load(uriPic)
                                    .centerCrop()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(binding.postPic);
                        }
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater,container,false);
        items = ((MainActivity) requireActivity()).getItems();


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.postPic.setOnClickListener(v -> pickPic());
        binding.btnUpload.setOnClickListener(v -> upload());
    }

    @Override
    public void onResume()  {
        super.onResume();
        binding.captionPost.setText("");
    }

    private void upload(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        String caption = binding.captionPost.getText().toString();

        if(uriPic != null){
            ((MainActivity) requireActivity()).addPost(uriPic,caption);
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, homeFragment, HomeFragment.class.getSimpleName())
                    .commit();
            uriPic = null;
        }else{
            Toast.makeText(getActivity(), "Upload post pic first",Toast.LENGTH_SHORT).show();
        }
    }

    public void pickPic(){
        Intent imagePickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        imagePicker.launch(Intent.createChooser(imagePickerIntent,"Pick a pic"));
    }
}