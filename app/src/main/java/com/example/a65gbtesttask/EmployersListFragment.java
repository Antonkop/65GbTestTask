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

public class EmployersListFragment extends Fragment {

    private RecyclerView employersRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employers_list_fragment_layout, container, false);
        employersRecyclerView = view.findViewById(R.id.employers_list);
        employersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
