package com.example.a65gbtesttask.model;

import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private String birthday;
    private String AvatarUrl;
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
        return AvatarUrl;
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
        AvatarUrl = avatarUrl;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }
}