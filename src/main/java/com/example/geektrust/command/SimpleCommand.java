package com.example.geektrust.command;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.CommandType;
import com.example.geektrust.constants.Plan;
import com.example.geektrust.constants.TopUpType;
import com.example.geektrust.interfaces.Command;

public class SimpleCommand implements Command {
    private final CommandType type;
    private final String startDate;
    private final Category category;
    private final Plan plan;
    private final TopUpType topUpType;
    private final int devices;

    private static final int DEFAULT_DEVICES = 0;

    public SimpleCommand(CommandType type) {
        this(type, null, null, null, null, DEFAULT_DEVICES);
    }

    public SimpleCommand(CommandType type, String startDate) {
        this(type, startDate, null, null, null, DEFAULT_DEVICES);
    }

    public SimpleCommand(CommandType type, Category category, Plan plan) {
        this(type, null, category, plan, null, DEFAULT_DEVICES);
    }

    public SimpleCommand(CommandType type, TopUpType topUpType, int devices) {
        this(type, null, null, null, topUpType, devices);
    }

    public SimpleCommand(CommandType type, String startDate, Category category, Plan plan, TopUpType topUpType, int devices) {
        this.type = type;
        this.startDate = startDate;
        this.category = category;
        this.plan = plan;
        this.topUpType = topUpType;
        this.devices = devices;
    }

    public CommandType getType() {
        return type;
    }

    public String getStartDate() {
        return startDate != null ? new String(startDate) : null;
    }

    public Category getCategory() {
        return category;
    }

    public Plan getPlan() {
        return plan;
    }

    public TopUpType getTopUpType() {
        return topUpType;
    }

    public int getDevices() {
        return devices;
    }
}
