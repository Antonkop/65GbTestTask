package com.example.a65gbtesttask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    @SerializedName("f_name")
    private String firstName;
    @SerializedName("l_name")
    private String lastName;
    private String birthday;
    @SerializedName("avatr_url")
    private String avatarUrl;
    private List<Specialty> specialty;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public List<Specialty> getSpecialty() {
        return specialty;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }
}
