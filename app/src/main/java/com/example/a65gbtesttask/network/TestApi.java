package com.example.a65gbtesttask.network;

import com.example.a65gbtesttask.model.GetEmployeesResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface TestApi {
    @GET("/65gb/static/raw/master/testTask.json")
    Call<GetEmployeesResponse> getEmployees();
}
