package com.example.retrofitjsonparsing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/cars_list.json")
    Call<List<CarModels>> getAllCarModels();

}
