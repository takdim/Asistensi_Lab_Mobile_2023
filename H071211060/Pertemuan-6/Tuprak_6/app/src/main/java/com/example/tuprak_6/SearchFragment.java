package com.example.tuprak_6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {
    TextInputEditText etSearch;
    RecyclerView rvSearch;
    ProgressBar pbSearch;
    SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etSearch = view.findViewById(R.id.et_search);
        rvSearch = view.findViewById(R.id.rv_search);
        pbSearch = view.findViewById(R.id.pb_search);
        searchAdapter = new SearchAdapter();
        rvSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSearch.setAdapter(searchAdapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pbSearch.setVisibility(View.VISIBLE);
                rvSearch.setVisibility(View.GONE);
                Executor executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());

                executor.execute(()-> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    handler.post(()-> {
                        if (TextUtils.isEmpty(s)) {
                            searchAdapter.setUsers(new ArrayList<>());
                        } else {
                            searchAdapter.setUsers(searchUser(s.toString()));

                        }
                        searchAdapter.notifyDataSetChanged();
                        pbSearch.setVisibility(View.GONE);
                        rvSearch.setVisibility(View.VISIBLE);
                    });
                });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private ArrayList<UserModel> searchUser(String text){
        ArrayList<UserModel> users = HomeFragment.dataSource.getUsers();
        ArrayList<UserModel> filteredUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            UserModel user = users.get(i);
            String textLower = text.toLowerCase();
            String fullnameLower = user.getFullname().toLowerCase();
            String usernameLower = user.getUsername().toLowerCase();

            if (fullnameLower.startsWith(textLower)|| usernameLower.startsWith(textLower)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }
}