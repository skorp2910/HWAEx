package org.itstep.domain;

public enum Gender {
    MALE, FEMALE, UNKNOWN;

    public static Gender parse(String value) {
        switch (value) {
        case "Male":
            return MALE;
        case "Female":
            return FEMALE;
        default:
            return UNKNOWN;
        }
    }
}