package com.example.geektrust.printer;

import com.example.geektrust.interfaces.DeviceSubscriptionManager;
import com.example.geektrust.interfaces.RenewalDetailsPrinter;
import com.example.geektrust.interfaces.SubscriptionManager;
import com.example.geektrust.modal.SubscriptionPackage;

import java.util.List;

public class ConsoleRenewalDetailsPrinter implements RenewalDetailsPrinter {
    private static final String SUBSCRIPTIONS_NOT_FOUND = "SUBSCRIPTIONS_NOT_FOUND";
    private static final String ADD_TOPUP_FAILED_SUBSCRIPTIONS_NOT_FOUND = "ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND";

    @Override
    public void printRenewalDetails(SubscriptionManager subscriptionManager, DeviceSubscriptionManager deviceSubscriptionManager) {
        List<SubscriptionPackage> subscriptionPackages = subscriptionManager.getSubscriptions();

        if (noSubscriptionsFound(subscriptionPackages, deviceSubscriptionManager)) {
            printSubscriptionsNotFound();
            return;
        }

        double amount = calculateRenewalAmount(subscriptionManager, deviceSubscriptionManager);

        if (subscriptionPackages.isEmpty()) {
            printAddTopUpFailed();
            printSubscriptionsNotFound();
            return;
        }

        printSubscriptionReminders(subscriptionPackages);
        printRenewalAmount(amount);
    }

    private boolean noSubscriptionsFound(List<SubscriptionPackage> subscriptionPackages, DeviceSubscriptionManager deviceSubscriptionManager) {
        return subscriptionPackages.isEmpty() && deviceSubscriptionManager.getDeviceSubscription() == null;
    }

    private void printSubscriptionsNotFound() {
        System.out.println(SUBSCRIPTIONS_NOT_FOUND);
    }

    private double calculateRenewalAmount(SubscriptionManager subscriptionManager, DeviceSubscriptionManager deviceSubscriptionManager) {
        return deviceSubscriptionManager.calculateRenewalAmount() + subscriptionManager.calculateRenewalAmount();
    }

    private void printAddTopUpFailed() {
        System.out.println(ADD_TOPUP_FAILED_SUBSCRIPTIONS_NOT_FOUND);
    }

    private void printSubscriptionReminders(List<SubscriptionPackage> subscriptionPackages) {
        for (SubscriptionPackage subscriptionPackage : subscriptionPackages) {
            System.out.println("RENEWAL_REMINDER " + subscriptionPackage.getCategory()
                    + " " + subscriptionPackage.getExpirationDate());
        }
    }

    private void printRenewalAmount(double amount) {
        System.out.println("RENEWAL_AMOUNT " + (int) amount);
    }

}
