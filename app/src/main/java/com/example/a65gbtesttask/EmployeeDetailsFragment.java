package com.example.a65gbtesttask;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.example.a65gbtesttask.model.Employee;
import com.squareup.picasso.Picasso;

public class EmployeeDetailsFragment extends Fragment {

    private static final String EMPLOYEE_BUNDLE_KEY = "EMPLOYEE_BUNDLE_KEY";

    private AppCompatImageView imageView;
    private AppCompatTextView name;
    private AppCompatTextView lastName;
    private AppCompatTextView birhday;
    private AppCompatTextView age;
    private AppCompatTextView speciality;

    private Employee employee;
    private Converter converter;

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
        name = view.findViewById(R.id.employee_first_name);
        lastName = view.findViewById(R.id.employee_last_name);
        birhday = view.findViewById(R.id.employee_birthday);
        age= view.findViewById(R.id.employee_age);
        speciality = view.findViewById(R.id.employee_specialty);
        if (employee != null) {
            Picasso.get().load(Uri.parse(employee.getAvatarUrl())).into(imageView);
        }
        converter = new Converter();
        name.setText(converter.convertName(employee.getFirstName()));
        lastName.setText(converter.convertName(employee.getLastName()));
        birhday.setText(converter.convertBirthday(employee.getBirthday()));
        age.setText(String.valueOf(converter.getAge(employee.getBirthday())));
        String specialtys = "";
        for (int i = 0; i < employee.getSpecialty().size(); i++) {
            if (i == employee.getSpecialty().size() - 1) {
                specialtys += employee.getSpecialty().get(i).getName();
            } else specialtys += employee.getSpecialty().get(i).getName() + ", ";
        }
        speciality.setText(specialtys);
        return view;
    }
}
