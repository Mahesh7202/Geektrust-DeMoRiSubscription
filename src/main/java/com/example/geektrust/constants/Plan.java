package com.example.geektrust.constants;

public enum Plan {
    FREE("FREE"),

    PERSONAL("PERSONAL"),

    PREMIUM("PREMIUM");

    private final String value;

    Plan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


