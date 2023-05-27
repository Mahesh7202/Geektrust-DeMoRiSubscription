package com.example.geektrust.manager;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.Plan;
import com.example.geektrust.interfaces.SubscriptionManager;
import com.example.geektrust.modal.MusicSubscriptionPackage;
import com.example.geektrust.modal.PodcastSubscriptionPackage;
import com.example.geektrust.modal.SubscriptionPackage;
import com.example.geektrust.modal.VideoSubscriptionPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionManagerImpl implements SubscriptionManager {
    private final Map<Category, SubscriptionPackage> subscriptions;

    private static final String DATE_FORMATTER = "dd-MM-yyyy";

    private static final String ADD_SUBSCRIPTION_FAILED_INVALID_DATE = "ADD_SUBSCRIPTION_FAILED INVALID_DATE";
    private static final String ADD_SUBSCRIPTION_FAILED_DUPLICATE_CATEGORY = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY";

    private LocalDate startDate;
    private static final String ERROR_INVALID_DATE = "INVALID_DATE";

    public SubscriptionManagerImpl() {
        this.subscriptions = new LinkedHashMap<>();
    }

    @Override
    public void startSubscription(String date) {
        try {
            this.startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMATTER));
        } catch (DateTimeParseException e) {
            System.out.println(ERROR_INVALID_DATE);
        }
    }

    @Override
    public void addSubscription(Category category, Plan plan) {
        if (subscriptions.containsKey(category)) {
            System.out.println(ADD_SUBSCRIPTION_FAILED_DUPLICATE_CATEGORY);
            return;
        }

        if(startDate == null){
            System.out.println(ADD_SUBSCRIPTION_FAILED_INVALID_DATE);
            return;
        }

        SubscriptionPackage subscriptionPackage = createSubscription(category, startDate, plan);
        updateExpiryDates(subscriptionPackage);
        subscriptions.put(category, subscriptionPackage);

    }

    @Override
    public SubscriptionPackage createSubscription(Category category, LocalDate startDate, Plan plan) {
        switch (category) {
            case MUSIC:
                return new MusicSubscriptionPackage(startDate, plan);
            case VIDEO:
                return new VideoSubscriptionPackage(startDate, plan);
            case PODCAST:
                return new PodcastSubscriptionPackage(startDate, plan);
            default:
                return null;
        }
    }

    @Override
    public void updateExpiryDates(SubscriptionPackage subscriptionPackage) {
            subscriptionPackage.calculateExpirationDate();
    }

    @Override
    public List<SubscriptionPackage> getSubscriptions() {
        return new ArrayList<>(subscriptions.values());
    }


    @Override
    public double calculateRenewalAmount() {
        return subscriptions.values().stream()
                .mapToDouble(SubscriptionPackage::getCost)
                .sum();
    }


}
