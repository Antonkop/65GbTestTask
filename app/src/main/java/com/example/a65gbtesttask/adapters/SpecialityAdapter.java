package com.example.a65gbtesttask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a65gbtesttask.R;
import com.example.a65gbtesttask.model.Specialty;

import java.util.ArrayList;
import java.util.List;

public class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.SpecialityViewHolder>{

    private List<Specialty> specialties = new ArrayList<>();
    private OnItemClickListener listener;

    public void initAdapter(List<Specialty> specialties) {
        this.specialties.addAll(specialties);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SpecialityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speciality_list_item_layout, parent, false);
        return new SpecialityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialityViewHolder holder, int position) {
        holder.bind(specialties.get(position));
    }

    @Override
    public int getItemCount() {
        return specialties.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    class SpecialityViewHolder extends RecyclerView.ViewHolder {
        private TextView specialtyNameTextView;

        public void bind(Specialty specialty) {
            specialtyNameTextView.setText(specialty.getName());
            specialtyNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(view, getLayoutPosition());
                    }
                }
            });
        }

        public SpecialityViewHolder(@NonNull View itemView) {
            super(itemView);
            specialtyNameTextView = itemView.findViewById(R.id.specialty_name_textView);
        }
    }
}
