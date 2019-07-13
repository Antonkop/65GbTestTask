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
import com.example.a65gbtesttask.model.Specialty;

import java.util.ArrayList;


public class SpecialtyListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.specialty_list_fragment_layout, container, false);
        RecyclerView specialityRecyclerView = view.findViewById(R.id.specialty_list);
        specialityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EmployeesDbHelper dbHelper = new EmployeesDbHelper(getContext());
        SpecialityAdapter adapter = new SpecialityAdapter();
        final ArrayList<Specialty> specialties = new ArrayList<>(dbHelper.getAllSpeciality());
        adapter.initAdapter(specialties);
        adapter.setOnItemClickListener(new SpecialityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                if (getFragmentManager() != null) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, EmployersListFragment.getInstance(specialties.get(position).getSpecialtyId()))
                            .addToBackStack("slf")
                            .commit();
                }
            }
        });
        specialityRecyclerView.setAdapter(adapter);
        dbHelper.close();
        return view;
    }
}
