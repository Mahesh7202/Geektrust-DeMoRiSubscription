package com.example.geektrust.modal;

import com.example.geektrust.interfaces.Subscription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class SubscriptionPackage implements Subscription {
    private LocalDate startDate;
    private LocalDate expirationDate;

    public SubscriptionPackage(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Override
    public String getExpirationDate() {
        return expirationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }


    public void calculateExpirationDate() {
        LocalDate calculatedExpirationDate = getStartDate().plusMonths(getDuration()).minusDays(10);
        setExpirationDate(calculatedExpirationDate);
    }
}