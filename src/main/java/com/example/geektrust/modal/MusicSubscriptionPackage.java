package com.example.geektrust.modal;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.Cost;
import com.example.geektrust.constants.Durations;
import com.example.geektrust.constants.Plan;

import java.time.LocalDate;

public class MusicSubscriptionPackage extends SubscriptionPackage {
    private Plan plan;

    public MusicSubscriptionPackage(LocalDate startDate, Plan plan) {
        super(startDate);
        this.plan = plan;
    }

    @Override
    public Category getCategory() {
        return Category.MUSIC;
    }

    @Override
    public Plan getPlan() {
        return plan;
    }

    @Override
    public double getCost() {
        switch (plan) {
            case PERSONAL:
                return getPersonalMusicCost();
            case PREMIUM:
                return getPremiumMusicCost();
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

    private double getPersonalMusicCost() {
        return Cost.PERSONAL_MUSIC_COST.getValue();
    }

    private double getPremiumMusicCost() {
        return Cost.PREMIUM_MUSIC_COST.getValue();
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
