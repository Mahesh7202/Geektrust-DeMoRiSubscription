package com.example.geektrust.constants;


public enum Category {
    MUSIC("MUSIC"),
    VIDEO("VIDEO"),
    PODCAST("PODCAST");

    String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}