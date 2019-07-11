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


public class SpecialtyListFragment extends Fragment {

    private RecyclerView specialtysRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.specialty_list_fragment_layout, container, false);
        specialtysRecyclerView = view.findViewById(R.id.specialty_list);
        specialtysRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
