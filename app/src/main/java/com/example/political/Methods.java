package com.example.political;

import com.example.political.CivicModel.MainPOJO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("civicinfo/v2/elections?key=AIzaSyAyQty1FlNhMMC2szpy0A9SHAjwKeHUN-8")
    Call<MainPOJO> getAllData();
}
