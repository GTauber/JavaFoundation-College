package com.tauber.atfundbarber.model.enums;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");


    private String gender;

    Gender(String gender) {
    }

    public String getGender() {
        return this.gender;
    }

}
