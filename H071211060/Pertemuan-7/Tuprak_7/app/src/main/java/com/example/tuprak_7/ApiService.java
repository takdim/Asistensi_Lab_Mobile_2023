package com.example.tuprak_7;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<UserResponses> getListUsers(@Query("page") int page, @Query("per_page") int perPage);

    @GET("api/users/{id}")
    Call<UserResponse> getUser(@Path("id") int id);
}
