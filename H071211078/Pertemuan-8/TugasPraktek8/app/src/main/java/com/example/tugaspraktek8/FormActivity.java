package com.example.tugaspraktek8;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    Button save, delete;
    EditText nama, nim, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        save = findViewById(R.id.btn_save);
        delete = findViewById(R.id.btn_delete);
        nama = findViewById(R.id.et_name);
        nim = findViewById(R.id.et_nim);
        description = findViewById(R.id.et_desc);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Intent toActivity = new Intent(this, MainActivity.class);
        Intent intent = getIntent();
        if (intent.getParcelableExtra("student") != null) {
            Student student = intent.getParcelableExtra("student");

            nama.setText(student.getName());
            nim.setText(student.getNim());
            description.setText(student.getDescription());

            delete.setVisibility(View.VISIBLE);
            save.setText("Update");

            save.setOnClickListener(view -> {
                String newName = nama.getText().toString();
                String newNim = nim.getText().toString();
                String newDesc = description.getText().toString();
                Student updatedStudent = new Student(student.getId(), newName, newNim, newDesc);
                dbHelper.updateStudent(updatedStudent);
                startActivity(toActivity);
                finish();
            });
            delete.setOnClickListener(view -> {
                dbHelper.deleteStudent(student.getId());
                startActivity(toActivity);
                finish();
            });
        } else {
            delete.setVisibility(View.GONE);

            save.setOnClickListener(view -> {
                String newName = nama.getText().toString();
                String newNim = nim.getText().toString();
                String newDesc = description.getText().toString();

                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String query = "SELECT COUNT(*) FROM " + DatabaseContract.DatabaseEntry.TABLE_NAME;
                Cursor cursor = db.rawQuery(query, null);
                int existingStudentCount = 0;
                if (cursor != null && cursor.moveToFirst()) {
                    existingStudentCount = cursor.getInt(0);
                    cursor.close();
                }
                int newStudentId = existingStudentCount + 1;
                Student newStudent = new Student(newStudentId, newName, newNim, newDesc);
                dbHelper.insertStudent(newStudent);

                startActivity(toActivity);
                finish();
            });
        }
    }
}