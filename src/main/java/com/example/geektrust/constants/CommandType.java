package com.example.geektrust.constants;

public enum CommandType {
    START_SUBSCRIPTION("START_SUBSCRIPTION"),
    ADD_SUBSCRIPTION("ADD_SUBSCRIPTION"),
    ADD_TOPUP("ADD_TOPUP"),
    PRINT_RENEWAL_DETAILS("PRINT_RENEWAL_DETAILS");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommandType fromString(String value) {
        for (CommandType type : CommandType.values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
