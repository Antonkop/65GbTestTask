package com.example.a65gbtesttask;

public class Converter {

    private String dateFormat = "%s.%s.%s";


    /**
     *
     * @param name employee firstName and lastName
     * @return name string with first char in upper case, other characters in lower case
     */
    public String convertName(String name) {
        if (name == null || name.length() == 0) {
            return "";
        } else {
            if (name.length() == 1) {
                return name.toUpperCase();
            } else return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
    }

    /**
     *
     * @param birthday employee birthday
     * @return birthday string in format dd.mm.yyyy, or return "-"
     */
    public String convertBirthday(String birthday) {
        if (birthday != null) {
            String[] dateParts = birthday.split("-");
            if (dateParts.length == 3) {
                if (dateParts[0].length() == 4) {
                    return String.format(dateFormat, dateParts[2], dateParts[1], dateParts[0]);
                } else if (dateParts[2].length() == 4) {
                    return String.format(dateFormat, dateParts[0], dateParts[1], dateParts[2]);
                }
            }
        }
        return "-";
    }
}
