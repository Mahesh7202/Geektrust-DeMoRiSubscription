package com.example.geektrust.interfaces;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.Plan;

public interface Subscription {
    Category getCategory();
    Plan getPlan();
    int getDuration();
    double getCost();
    String getExpirationDate();

}
