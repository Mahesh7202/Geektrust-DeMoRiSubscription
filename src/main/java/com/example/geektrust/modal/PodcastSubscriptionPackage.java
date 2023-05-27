package com.example.geektrust.modal;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.Cost;
import com.example.geektrust.constants.Durations;
import com.example.geektrust.constants.Plan;

import java.time.LocalDate;

public class PodcastSubscriptionPackage extends SubscriptionPackage {
    private Plan plan;

    public PodcastSubscriptionPackage(LocalDate startDate, Plan plan) {
        super(startDate);
        this.plan = plan;
    }

    @Override
    public Category getCategory() {
        return Category.PODCAST;
    }

    @Override
    public Plan getPlan() {
        return plan;
    }

    @Override
    public double getCost() {
        switch (plan) {
            case PERSONAL:
                return getPersonalPodcastCost();
            case PREMIUM:
                return getPremiumPodcastCost();
            default:
                return getFreeCost();
        }
    }

    @Override
    public int getDuration() {
        switch (plan) {
            case PERSONAL:
                return getPersonalDuration();
            case PREMIUM:
                return getPremiumDuration();
            default:
                return getFreeDuration();
        }
    }

    private double getPersonalPodcastCost() {
        return Cost.PERSONAL_PODCAST_COST.getValue();
    }

    private double getPremiumPodcastCost() {
        return Cost.PREMIUM_PODCAST_COST.getValue();
    }

    private double getFreeCost() {
        return Cost.FREE_COST.getValue();
    }

    private int getPersonalDuration() {
        return Durations.PERSONAL_DURATION.getValue();
    }

    private int getPremiumDuration() {
        return Durations.PREMIUM_DURATION.getValue();
    }

    private int getFreeDuration() {
        return Durations.FREE_DURATION.getValue();
    }
}
