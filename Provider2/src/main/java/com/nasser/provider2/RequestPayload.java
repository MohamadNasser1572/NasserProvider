package com.nasser.provider2;
//create a payload class to understand the request of the sent info from json
public class RequestPayload {
    private Long phoneNumber;
    private String message;
    private String language;

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getLanguage() {
        return language;
    }
}
