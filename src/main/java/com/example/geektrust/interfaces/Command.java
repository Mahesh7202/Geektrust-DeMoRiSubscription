package com.example.geektrust.interfaces;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.CommandType;
import com.example.geektrust.constants.Plan;
import com.example.geektrust.constants.TopUpType;

public interface Command {
    CommandType getType();

    String getStartDate();

    Category getCategory();

    Plan getPlan();

    TopUpType getTopUpType();

    int getDevices();
}
