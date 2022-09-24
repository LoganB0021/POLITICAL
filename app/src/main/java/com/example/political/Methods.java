package com.example.political;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("api/users?page=2")
    Call<DataModel> getAllData();
}
