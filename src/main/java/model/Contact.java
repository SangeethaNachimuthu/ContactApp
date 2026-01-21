package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (!phoneNumber.matches("^\\d{10}$")) {
            throw new IllegalArgumentException("Invalid phone number. Enter 10 digit phone number");
        }
        this.phoneNumber = phoneNumber;
    }
}
