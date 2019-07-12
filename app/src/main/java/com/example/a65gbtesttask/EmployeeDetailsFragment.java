package com.example.a65gbtesttask;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.example.a65gbtesttask.model.Employee;
import com.squareup.picasso.Picasso;

public class EmployeeDetailsFragment extends Fragment {

    private static final String EMPLOYEE_BUNDLE_KEY = "KEY";

    private AppCompatImageView imageView;
    private Employee employee;

    public static EmployeeDetailsFragment getInstance(Employee employee) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EMPLOYEE_BUNDLE_KEY, employee);
        EmployeeDetailsFragment fragment = new EmployeeDetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(EMPLOYEE_BUNDLE_KEY)) {
            employee = (Employee) getArguments().getSerializable(EMPLOYEE_BUNDLE_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee_detals_fragment_layout, container, false);
        imageView = view.findViewById(R.id.employee_avatar);
        if (employee != null) {
            Picasso.get().load(Uri.parse(employee.getAvatarUrl())).into(imageView);
        }
        return view;
    }
}
