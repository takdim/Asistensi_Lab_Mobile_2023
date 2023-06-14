package com.example.tugaspraktek8;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton fabAdd;
    TextInputEditText search;
    TextInputLayout etSearch;
    TextView alertTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = findViewById(R.id.fab_add);
        search = findViewById(R.id.searchEditText);
        alertTv = findViewById(R.id.tv_alert);
        etSearch = findViewById(R.id.et_search);
        List<Student> studentList = getAllStudentNoteFromDatabase();

        recyclerView = findViewById(R.id.rv_note);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentAdapter favoriteAdapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(favoriteAdapter);

        fabAdd.setOnClickListener(view -> {
            Toast.makeText(this, "Add Favorite", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FormActivity.class);
            intent.putExtra("add", "test");
            startActivity(intent);
            finish();
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                performSearch(s.toString(), studentList);

            }

            @Override
            public void afterTextChanged(Editable s) {
                performSearch(s.toString(), studentList);
            }
        });
    }

    public void performSearch(String searchQuery, List<Student> studentList) {
        List<Student> searchStudent = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(searchQuery)) {
                searchStudent.add(studentList.get(i));
            }
        }
        StudentAdapter favoriteAdapter = new StudentAdapter(this, searchStudent);
        recyclerView.setAdapter(favoriteAdapter);
    }

    public void showAlert(){
        alertTv.setVisibility(View.VISIBLE);
    }

    public void hideAlert(){
        alertTv.setVisibility(View.INVISIBLE);
    }

    public void hideSearch(){
        search.setVisibility(View.INVISIBLE);
        etSearch.setVisibility(View.INVISIBLE);
    }

    private List<Student> getAllStudentNoteFromDatabase() {
        List<Student> studentList = new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor cursor = databaseHelper.getAllStudents();


        if (cursor != null && cursor.moveToFirst()) {

            int idColumnIndex = cursor.getColumnIndex(DatabaseContract.DatabaseEntry._ID);
            int nameColum = cursor.getColumnIndex(DatabaseContract.DatabaseEntry.COLUMN_NAME);
            int nimColum = cursor.getColumnIndex(DatabaseContract.DatabaseEntry.COLUMN_NIM);
            int descColumn = cursor.getColumnIndex(DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION);
            hideAlert();

            do {
                int id = (idColumnIndex != -1) ? cursor.getInt(idColumnIndex) : -1;
                String nama = (nameColum != -1) ? cursor.getString(nameColum) : null;
                String nim = (nimColum != -1) ? cursor.getString(nimColum) : null;
                String description = (descColumn != -1) ? cursor.getString(descColumn) : null;

                Student favorite = new Student(id, nama, nim, description);
                studentList.add(favorite);
            } while (cursor.moveToNext());
        }else{
            showAlert();
            hideSearch();
        }
        if (cursor != null) {
            cursor.close();
        }
        return studentList;
    }
}