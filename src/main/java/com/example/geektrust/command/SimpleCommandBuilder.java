package com.example.geektrust.command;

import com.example.geektrust.constants.Category;
import com.example.geektrust.constants.CommandType;
import com.example.geektrust.constants.Plan;
import com.example.geektrust.constants.TopUpType;
import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandParser;

public class SimpleCommandBuilder implements CommandParser {
    public Command parseCommand(String commandString) {
        String[] tokens = commandString.split(" ");
        CommandType type = CommandType.fromString(tokens[0]);
        if (type == null) {
            return null;
        }

        switch (type) {
            case START_SUBSCRIPTION:
                return parseStartSubscriptionCommand(tokens);
            case ADD_SUBSCRIPTION:
                return parseAddSubscriptionCommand(tokens);
            case ADD_TOPUP:
                return parseAddTopUpCommand(tokens);
            default:
                return null;
        }
    }

    private SimpleCommand parseStartSubscriptionCommand(String[] tokens) {
        String packageName = extractPackageName(tokens);
        return new SimpleCommand(CommandType.START_SUBSCRIPTION, packageName);
    }

    private SimpleCommand parseAddSubscriptionCommand(String[] tokens) {
        Category category = extractCategory(tokens);
        Plan plan = extractPlan(tokens);
        return new SimpleCommand(CommandType.ADD_SUBSCRIPTION, category, plan);
    }

    private SimpleCommand parseAddTopUpCommand(String[] tokens) {
        TopUpType topUpType = extractTopUpType(tokens);
        int devices = extractDevices(tokens);
        if (devices < 0) {
            return null;
        }
        return new SimpleCommand(CommandType.ADD_TOPUP, topUpType, devices);
    }

    private String extractPackageName(String[] tokens) {
        return tokens[1];
    }

    private Category extractCategory(String[] tokens) {
        return Category.valueOf(tokens[1]);
    }

    private Plan extractPlan(String[] tokens) {
        return Plan.valueOf(tokens[2]);
    }

    private TopUpType extractTopUpType(String[] tokens) {
        return TopUpType.valueOf(tokens[1]);
    }

    private int extractDevices(String[] tokens) {
        try {
            return Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
