package com.tauber.atfundbarber.enums;

public enum Gender {
    FAMALE("Female"),
    MALE("Male");


    private String gender;

    Gender(String gender) {
    }

    public String getGender() {
        return this.gender;
    }

}
