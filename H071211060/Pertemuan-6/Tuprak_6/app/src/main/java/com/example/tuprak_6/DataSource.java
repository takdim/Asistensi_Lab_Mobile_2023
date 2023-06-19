package com.example.tuprak_6;

import android.net.Uri;

import java.util.ArrayList;

public class DataSource {
    private static final String BASE_URI = "android.resource://com.example.tuprak_6/drawable/";
    private ArrayList<UserModel> users = new ArrayList<>();

    public DataSource() {
        this.users.addAll(generateData());
    }


    public ArrayList<UserModel> getUsers() {
        return users;
    }

    private ArrayList<UserModel> generateData() {
        ArrayList<UserModel> users1 = new ArrayList<>();
        for (int i = 0; i < listNames.length; i++) {
            UserModel user = new UserModel(listUsernames[i], listNames[i], listProfilePicture[i],
                    new PostModel(
                            "ini tugas praktikum mobile background thread....",
                            Uri.parse(BASE_URI + listProfilePicture[i])));

            users1.add(user);
        }
        return users1;
    }

    public void addUser(UserModel user) {
        this.users.add(0, user);
    }

    private String[] listNames = {"Raa", "Muhammad Fauzan Ismail", "Rahmat Hidayat", "Naya", "Rara"};
    private String[] listUsernames = {"zahraannissa", "AyamgulaiMCd", "rahmat_hidayat14", "nayyyyy..", "raramuthiiee"};
    private int[] listProfilePicture = {R.drawable.zahra, R.drawable.ocang, R.drawable.rahmat, R.drawable.naya, R.drawable.rara};
}
