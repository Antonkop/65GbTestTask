package com.example.a65gbtesttask.model;

import com.google.gson.annotations.SerializedName;

public class Specialty {

    @SerializedName("specialty_id")
    private int specialtyId;
    private String name;

    public int getSpecialtyId() {
        return specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
