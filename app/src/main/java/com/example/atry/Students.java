package com.example.atry;

import androidx.annotation.Nullable;

public class Students {
    private String name, age, address, gender;

    public Students(String name, String age, String address, String gender){
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}
