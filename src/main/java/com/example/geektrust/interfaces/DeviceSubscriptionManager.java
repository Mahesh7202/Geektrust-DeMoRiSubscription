package com.example.geektrust.interfaces;

import com.example.geektrust.constants.TopUpType;

public interface DeviceSubscriptionManager {
    void createDeviceSubscription(String date);

    void addTopUp(TopUpType topUpType, int devices);

    DeviceSubscription getDeviceSubscription();

    double calculateRenewalAmount();
}
