package com.example.geektrust.interfaces;

import com.example.geektrust.constants.TopUpType;

public interface DeviceSubscription {

    double getCost();

    TopUpType getType();

    int getDevices();
}
