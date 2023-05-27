package com.example.geektrust.manager;

import com.example.geektrust.constants.TopUpType;
import com.example.geektrust.interfaces.DeviceSubscriptionManager;
import com.example.geektrust.interfaces.DeviceSubscription;
import com.example.geektrust.modal.DeviceSubscriptionTopUp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DeviceSubscriptionManagerImpl implements DeviceSubscriptionManager {
    private static final String DATE_FORMATTER = "dd-MM-yyyy";
    private DeviceSubscription deviceSubscription;
    private LocalDate startDate;

    private static final String ADD_TOPUP_FAILED_DUPLICATE_TOPUP = "ADD_TOPUP_FAILED DUPLICATE_TOPUP";
    private static final String ADD_TOPUP_FAILED_INVALID_DATE = "ADD_TOPUP_FAILED INVALID_DATE";

    @Override
    public void createDeviceSubscription(String date) {
        try {
            this.startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMATTER));
        } catch (DateTimeParseException e) {
            this.startDate = null;
        }
    }

    @Override
    public void addTopUp(TopUpType topUpType, int devices) {
        if (startDate == null) {
            System.out.println(ADD_TOPUP_FAILED_INVALID_DATE);
            return;
        }
        if (deviceSubscription != null ) {
            System.out.println(ADD_TOPUP_FAILED_DUPLICATE_TOPUP);
            return;
        }

        deviceSubscription = new DeviceSubscriptionTopUp(topUpType, devices);
    }

    @Override
    public DeviceSubscription getDeviceSubscription() {
        return deviceSubscription;
    }

    @Override
    public double calculateRenewalAmount() {
        if (deviceSubscription != null) {
            return deviceSubscription.getCost() * deviceSubscription.getDevices();
        }
        return 0;
    }
}
