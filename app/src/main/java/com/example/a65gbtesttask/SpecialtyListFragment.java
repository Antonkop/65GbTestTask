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

import com.example.a65gbtesttask.adapters.SpecialityAdapter;
import com.example.a65gbtesttask.db.EmployeesDbHelper;


public class SpecialtyListFragment extends Fragment {

    private RecyclerView specialityRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.specialty_list_fragment_layout, container, false);
        specialityRecyclerView = view.findViewById(R.id.specialty_list);
        specialityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EmployeesDbHelper dbHelper = new EmployeesDbHelper(getContext());
        SpecialityAdapter adapter = new SpecialityAdapter();
        adapter.initAdapter(dbHelper.getAllSpeciality());
        specialityRecyclerView.setAdapter(adapter);
        return view;
    }
}
