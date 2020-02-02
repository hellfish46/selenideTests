package com.petclinic.pageObject;

public enum ValidationMessage {
    //Create new owner validation messages
    FIRSTNAMELESSTWOSYMBOLS("First name must be at least 2 characters long"),
    FIRSTNAMEISREQUIRED("First name is required"),
    LASTNAMELESSTWOSYMBOLS("Last name must be at least 2 characters long"),
    LASTNAMEISREQUIRED("Last name is required"),
    ADDRESSISREQUIRED("Address is required"),
    CITYISREQUIRED("City is required"),
    PHONEMUSTBEDIGITS("Phone number only accept digits"),
    PHONEISREQUIRED("Phone number is required");

    private String message;
    ValidationMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
