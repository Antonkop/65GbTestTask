package com.example.a65gbtesttask.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a65gbtesttask.model.Employee;
import com.example.a65gbtesttask.model.Specialty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "55GbTestDb";
    public static final String TABLE_SPECIALTYS_NAME = "SPECIALTYS";
    public static final String TABLE_EMPLOYEES_NAME = "EMPLOYEES";
    private static final int DB_VERSION = 1;

    private final String ID = "ID";
    private final String NAME = "name";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String BIRTHDAY = "birthday";
    private final String AVATAR_URL = "avatarUrl";
    private final String SPECIALTY_ID = "specialtyId";
    private final String SPECIALTY_ARRAY_STRING = "specialtyArrayString";



    private ContentValues contentValues = new ContentValues();
    private Gson gson = new GsonBuilder().create();


    public EmployeesDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void addSpecialty(Specialty specialty) {
        contentValues.put(ID, specialty.getSpecialtyId());
        contentValues.put(NAME, specialty.getName());
        getWritableDatabase().insert(TABLE_SPECIALTYS_NAME, null, contentValues);
        contentValues.clear();
    }

    public void addEmployee(Employee employee, int SpecialtyId) {
        contentValues.put(FIRST_NAME, employee.getFirstName());
        contentValues.put(LAST_NAME, employee.getLastName());
        contentValues.put(BIRTHDAY, employee.getBirthday());
        contentValues.put(AVATAR_URL, employee.getAvatarUrl());
        contentValues.put(SPECIALTY_ID, SpecialtyId);
        String specialtyArray = gson.toJson(employee.getSpecialty());
        contentValues.put(SPECIALTY_ARRAY_STRING, specialtyArray);
        getWritableDatabase().insert(TABLE_EMPLOYEES_NAME, null, contentValues);
        contentValues.clear();
    }

    public List<Specialty> getAllSpeciality() {
        ArrayList<Specialty> result = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query(TABLE_SPECIALTYS_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ID));
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            result.add(new Specialty(id, name));
        }
        cursor.close();
        return result;
    }

    public List<Employee> getEmployeesBySpeciality(int specialityId) {
        ArrayList<Employee> result = new ArrayList<>();
        Employee employee;
        Cursor cursor = getWritableDatabase().query(TABLE_EMPLOYEES_NAME, null,
                SPECIALTY_ID + " == " + specialityId, null, null, null, null);
        while (cursor.moveToNext()) {
            employee = new Employee();
            employee.setFirstName(cursor.getString(cursor.getColumnIndex(FIRST_NAME)));
            employee.setLastName(cursor.getString(cursor.getColumnIndex(LAST_NAME)));
            employee.setBirthday(cursor.getString(cursor.getColumnIndex(BIRTHDAY)));
            employee.setAvatarUrl(cursor.getString(cursor.getColumnIndex(AVATAR_URL)));
            String specialtyArray = cursor.getString(cursor.getColumnIndex(SPECIALTY_ARRAY_STRING));
            ArrayList<Specialty> specialties = new ArrayList<>();
            specialties.addAll(gson.fromJson(specialtyArray,ArrayList.class));
            employee.setSpecialty(specialties);
            result.add(employee);
        }
        cursor.close();
        return result;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_SPECIALTYS_TABLE = "CREATE TABLE " + TABLE_SPECIALTYS_NAME +
                "(" + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT)";
        final String SQL_CREATE_EMPLOYEES_TABLE = "CREATE TABLE " + TABLE_EMPLOYEES_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIRST_NAME + " TEXT, " +
                LAST_NAME + " TEXT, " +
                BIRTHDAY + " TEXT, " +
                AVATAR_URL + " TEXT, " +
                SPECIALTY_ID + " INTEGER," +
                SPECIALTY_ARRAY_STRING + " TEXT)";
        sqLiteDatabase.execSQL(SQL_CREATE_SPECIALTYS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_EMPLOYEES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
