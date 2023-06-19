package com.example.tuprak_7;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponses {
    @SerializedName("data")
    private List<User> data;
    public List<User> getData() {
        return data;
    }
}
