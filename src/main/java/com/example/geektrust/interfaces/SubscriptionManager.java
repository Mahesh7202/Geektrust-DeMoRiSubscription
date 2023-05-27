package com.example.geektrust.interfaces;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.Plan;
import com.example.geektrust.modal.SubscriptionPackage;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionManager {
    void startSubscription(String date);

    public void addSubscription(Category category, Plan plan);


    SubscriptionPackage createSubscription(Category category, LocalDate startDate, Plan plan);

    void updateExpiryDates(SubscriptionPackage subscriptionPackage);

    List<SubscriptionPackage> getSubscriptions();

    double calculateRenewalAmount();
}
