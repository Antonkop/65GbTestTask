package com.example.a65gbtesttask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public int getAge(String birthday) {
        if (birthday != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date birthdayDate = dateFormat.parse(convertBirthday(birthday));
                Calendar birthDay = new GregorianCalendar();
                birthDay.setTime(birthdayDate);
                Calendar today = new GregorianCalendar();
                return today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
