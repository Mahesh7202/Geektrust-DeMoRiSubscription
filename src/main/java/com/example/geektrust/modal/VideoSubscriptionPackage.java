package com.example.geektrust.modal;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.Cost;
import com.example.geektrust.constants.Durations;
import com.example.geektrust.constants.Plan;

import java.time.LocalDate;

public class VideoSubscriptionPackage extends SubscriptionPackage {
    private Plan plan;

    public VideoSubscriptionPackage(LocalDate startDate, Plan plan) {
        super(startDate);
        this.plan = plan;
    }

    @Override
    public Category getCategory() {
        return Category.VIDEO;
    }

    @Override
    public Plan getPlan() {
        return plan;
    }

    @Override
    public double getCost() {
        switch (plan) {
            case PERSONAL:
                return getPersonalVideoCost();
            case PREMIUM:
                return getPremiumVideoCost();
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

    private double getPersonalVideoCost() {
        return Cost.PERSONAL_VIDEO_COST.getValue();
    }

    private double getPremiumVideoCost() {
        return Cost.PREMIUM_VIDEO_COST.getValue();
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
