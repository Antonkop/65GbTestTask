package com.example.a65gbtesttask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a65gbtesttask.R;
import com.example.a65gbtesttask.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployersAdapter extends RecyclerView.Adapter<EmployersAdapter.EmployersViewHolder>{

    private List<Employee> employees = new ArrayList<>();
    private OnItemClickListener listener;

    public void initAdapter(List<Employee> employees) {
        this.employees.addAll(employees);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employers_list_item, parent, false);
        return new EmployersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployersViewHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    class EmployersViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTextView;
        private TextView lastNameTextView;
        private TextView birthdayTextView;

        public void bind(Employee employee) {
            nameTextView.setText(employee.getFirstName());
            lastNameTextView.setText(employee.getLastName());
            birthdayTextView.setText(employee.getBirthday());
        }

        public EmployersViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.first_name);
            lastNameTextView = itemView.findViewById(R.id.last_name);
            birthdayTextView = itemView.findViewById(R.id.birthday);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(view,getLayoutPosition());
                    }
                }
            });
        }
    }
}
