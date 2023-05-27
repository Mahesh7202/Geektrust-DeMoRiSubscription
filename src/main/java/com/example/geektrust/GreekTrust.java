package com.example.geektrust;

import com.example.geektrust.command.SimpleCommandBuilder;
import com.example.geektrust.command.SimpleCommandExecutor;
import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.RenewalDetailsPrinter;
import com.example.geektrust.interfaces.DeviceSubscriptionManager;
import com.example.geektrust.io.FileCommandReader;
import com.example.geektrust.manager.DeviceSubscriptionManagerImpl;
import com.example.geektrust.interfaces.SubscriptionManager;
import com.example.geektrust.manager.SubscriptionManagerImpl;
import com.example.geektrust.printer.ConsoleRenewalDetailsPrinter;

import java.io.IOException;

public class GreekTrust {
    private String filepath;
    GreekTrust(String filepath){
        this.filepath = filepath;
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the input file path.");
            return;
        }

        GreekTrust greekTrust = new GreekTrust(args[0]);
        greekTrust.start();
    }

    public void start() {
        try {
            FileCommandReader fileCommandReader = new FileCommandReader(filepath);
            SimpleCommandBuilder simpleCommandBuilder = new SimpleCommandBuilder();
            SubscriptionManager subscriptionManager = new SubscriptionManagerImpl();
            DeviceSubscriptionManager deviceSubscriptionManager = new DeviceSubscriptionManagerImpl();
            SimpleCommandExecutor simpleCommandExecutor = new SimpleCommandExecutor(subscriptionManager, deviceSubscriptionManager);
            RenewalDetailsPrinter renewalDetailsPrinter = new ConsoleRenewalDetailsPrinter();

            String commandString;
            while ((commandString = fileCommandReader.readNextCommand()) != null) {
                Command command = simpleCommandBuilder.parseCommand(commandString);
                if (command != null) {
                    simpleCommandExecutor.executeCommand(command);
                }
            }

            renewalDetailsPrinter.printRenewalDetails(subscriptionManager, deviceSubscriptionManager);

            fileCommandReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
