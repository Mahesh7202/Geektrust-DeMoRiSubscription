package com.example.geektrust.constants;


public enum Durations {
    FREE_DURATION(1),
    PERSONAL_DURATION(1),
    PREMIUM_DURATION(3);

    private final int value;

    Durations(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
