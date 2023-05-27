package com.example.geektrust.modal;

import com.example.geektrust.constants.TopUpType;
import com.example.geektrust.interfaces.DeviceSubscription;

import static com.example.geektrust.constants.Cost.*;

public class DeviceSubscriptionTopUp implements DeviceSubscription {

    private TopUpType type;
    private int devices;

    public DeviceSubscriptionTopUp(TopUpType type, int devices) {
        this.type = type;
        this.devices = devices;
    }



    private double getFourDeviceCost() {
        return FOUR_DEVICE_COST.getValue();
    }

    private double getTenDeviceCost() {
        return TEN_DEVICE_COST.getValue();
    }

    private double getFreeCost() {
        return FREE_COST.getValue();
    }

    @Override
    public double getCost() {
        switch (getType()) {
            case FOUR_DEVICE:
                return getFourDeviceCost();
            case TEN_DEVICE:
                return getTenDeviceCost();
            default:
                return getFreeCost();
        }
    }

    @Override
    public TopUpType getType() {
        return type;
    }

    @Override
    public int getDevices() {
        return devices;
    }
}
