package com.example.a65gbtesttask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a65gbtesttask.db.EmployeesDbHelper;
import com.example.a65gbtesttask.model.Employee;
import com.example.a65gbtesttask.model.GetEmployeesResponse;
import com.example.a65gbtesttask.model.Specialty;
import com.example.a65gbtesttask.network.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkService.getInstance().getApi().getEmployees().enqueue(new Callback<GetEmployeesResponse>() {
            @Override
            public void onResponse(Call<GetEmployeesResponse> call, Response<GetEmployeesResponse> response) {
                if (response.body() != null && response.body().getResponse() != null) {
                    addToDb(response.body().getResponse());
                }
            }

            @Override
            public void onFailure(Call<GetEmployeesResponse> call, Throwable t) {
                startSpecialtyFragment();
            }
        });
    }

    private void addToDb(List<Employee> employees) {
        EmployeesDbHelper dbHelper = new EmployeesDbHelper(this);
        dbHelper.getWritableDatabase().delete(EmployeesDbHelper.TABLE_EMPLOYEES_NAME, null, null);
        for (Employee employee : employees) {
            ArrayList<Specialty> specialtys = new ArrayList<>(employee.getSpecialty());
            for (Specialty specialty : specialtys) {
                dbHelper.addSpecialty(specialty);
                dbHelper.addEmployee(employee,specialty.getSpecialtyId());
            }
        }
        startSpecialtyFragment();
        dbHelper.close();

    }

    private void startSpecialtyFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new SpecialtyListFragment())
                .addToBackStack("mine")
                .commit();
    }
}
