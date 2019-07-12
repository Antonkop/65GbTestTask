package com.example.a65gbtesttask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a65gbtesttask.adapters.EmployersAdapter;
import com.example.a65gbtesttask.db.EmployeesDbHelper;
import com.example.a65gbtesttask.model.Employee;

import java.util.ArrayList;

public class EmployersListFragment extends Fragment {

    private static final String ID_BUNDLE_KEY = "KEY";

    private RecyclerView employersRecyclerView;
    private int specialityId;
    private ArrayList<Employee> employees = new ArrayList<>();

    public static EmployersListFragment getInstance(int specialityId) {
        Bundle bundle = new Bundle();
        bundle.putInt(ID_BUNDLE_KEY, specialityId);
        EmployersListFragment fragment = new EmployersListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(ID_BUNDLE_KEY)) {
            specialityId = getArguments().getInt(ID_BUNDLE_KEY);
            EmployeesDbHelper dbHelper = new EmployeesDbHelper(getContext());
            employees.addAll(dbHelper.getEmployeesBySpeciality(specialityId));
            dbHelper.close();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employers_list_fragment_layout, container, false);
        employersRecyclerView = view.findViewById(R.id.employers_list);
        employersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EmployersAdapter employersAdapter = new EmployersAdapter();
        employersAdapter.initAdapter(employees);
        employersRecyclerView.setAdapter(employersAdapter);
        return view;
    }
}
