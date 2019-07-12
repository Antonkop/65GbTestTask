package com.example.a65gbtesttask;

public class Converter {

    public String convertName(String name) {
        if (name == null || name.length() == 0) {
            return "";
        } else {
            if (name.length() == 1) {
                return name.toUpperCase();
            } else return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
    }
}
