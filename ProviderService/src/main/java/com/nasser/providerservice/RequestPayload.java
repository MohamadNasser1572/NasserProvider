package com.nasser.providerservice;

public class RequestPayload {
    private Long phoneNumber;
    private String message;
    private String language;

    //put getters for deserialization,
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getLanguage() {
        return language;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
