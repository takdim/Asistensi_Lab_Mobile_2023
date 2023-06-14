package com.example.tugaspraktek8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.DatabaseEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseContract.DatabaseEntry.SQL_DROP_TABLE);
        onCreate(db);
    }

    // Create a new student record
    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME, student.getName());
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NIM, student.getNim());
        values.put(DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION, student.getDescription());

        db.insert(DatabaseContract.DatabaseEntry.TABLE_NAME, null, values);
        db.close();
    }

    // Retrieve a single student record by ID
    public Student getStudentById(int studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                DatabaseContract.DatabaseEntry._ID,
                DatabaseContract.DatabaseEntry.COLUMN_NAME,
                DatabaseContract.DatabaseEntry.COLUMN_NIM,
                DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION
        };

        String selection = DatabaseContract.DatabaseEntry._ID + " = ?";
        String[] selectionArgs = {String.valueOf(studentId)};

        Cursor cursor = db.query(
                DatabaseContract.DatabaseEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        Student student = null;
        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DatabaseContract.DatabaseEntry._ID);
            int nameIndex = cursor.getColumnIndex(DatabaseContract.DatabaseEntry.COLUMN_NAME);
            int nimIndex = cursor.getColumnIndex(DatabaseContract.DatabaseEntry.COLUMN_NIM);
            int descIndex = cursor.getColumnIndex(DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION);

            if (idIndex != -1 && nameIndex != -1 && nimIndex != -1 && descIndex != -1) {
                student = new Student(
                        cursor.getInt(idIndex),
                        cursor.getString(nameIndex),
                        cursor.getString(nimIndex),
                        cursor.getString(descIndex)
                );
            }

            cursor.close();
        }

        db.close();
        return student;
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                DatabaseContract.DatabaseEntry._ID,
                DatabaseContract.DatabaseEntry.COLUMN_NAME,
                DatabaseContract.DatabaseEntry.COLUMN_NIM,
                DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION
        };

        return db.query(
                DatabaseContract.DatabaseEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }


    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NAME, student.getName());
        values.put(DatabaseContract.DatabaseEntry.COLUMN_NIM, student.getNim());
        values.put(DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION, student.getDescription());

        String whereClause = DatabaseContract.DatabaseEntry._ID + " = ?";
        String[] whereArgs = {String.valueOf(student.getId())};

        db.update(DatabaseContract.DatabaseEntry.TABLE_NAME, values, whereClause, whereArgs);
        db.close();
    }

    public void deleteStudent(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = DatabaseContract.DatabaseEntry._ID + " = ?";
        String[] whereArgs = {String.valueOf(studentId)};

        db.delete(DatabaseContract.DatabaseEntry.TABLE_NAME, whereClause, whereArgs);
        db.close();
    }
}

