package com.example.geektrust.command;


import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandExecutor;
import com.example.geektrust.interfaces.DeviceSubscriptionManager;
import com.example.geektrust.interfaces.SubscriptionManager;

public class SimpleCommandExecutor implements CommandExecutor {
    private SubscriptionManager subscriptionManager;
    private DeviceSubscriptionManager deviceSubscriptionManager;

    public SimpleCommandExecutor(SubscriptionManager subscriptionManager, DeviceSubscriptionManager deviceSubscriptionManager) {
        this.subscriptionManager = subscriptionManager;
        this.deviceSubscriptionManager = deviceSubscriptionManager;
    }

    @Override
    public void executeCommand(Command command) {
        switch (command.getType()) {
            case START_SUBSCRIPTION:
                subscriptionManager.startSubscription(command.getStartDate());
                deviceSubscriptionManager.createDeviceSubscription(command.getStartDate());
                break;
            case ADD_SUBSCRIPTION:
                subscriptionManager.addSubscription(command.getCategory(), command.getPlan());
                break;
            case ADD_TOPUP:
                deviceSubscriptionManager.addTopUp(command.getTopUpType(), command.getDevices());
                break;
            default:
                break;
        }
    }



}
