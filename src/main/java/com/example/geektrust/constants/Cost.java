package com.example.geektrust.constants;

public enum Cost {
    FREE_COST(0),
    PERSONAL_VIDEO_COST(200),
    PERSONAL_MUSIC_COST(100),
    PERSONAL_PODCAST_COST(100),
    PREMIUM_MUSIC_COST(250),
    PREMIUM_VIDEO_COST(500),
    PREMIUM_PODCAST_COST(300),

    FOUR_DEVICE_COST(50),
    TEN_DEVICE_COST(100);


    private final int value;

    Cost(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



