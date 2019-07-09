package com.example.a65gbtesttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a65gbtesttask.model.Employee;
import com.example.a65gbtesttask.model.GetEmployeesResponse;
import com.example.a65gbtesttask.network.NetworkService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkService.getInstance().getApi().getEmployees().enqueue(new Callback<GetEmployeesResponse>() {
            @Override
            public void onResponse(Call<GetEmployeesResponse> call, Response<GetEmployeesResponse> response) {
                if (response.body() != null && response.body().getResponse() != null) {
                    employees = new ArrayList<>(response.body().getResponse());
                }
            }

            @Override
            public void onFailure(Call<GetEmployeesResponse> call, Throwable t) {

            }
        });

    }
}
