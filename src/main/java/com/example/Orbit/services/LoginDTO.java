package com.example.Orbit.services;

public class LoginDTO {

    private String userPassword;
    private String userEmailAddress;

    public LoginDTO (String userPassword, String userEmailAddress){
        this.userEmailAddress = userEmailAddress;
        this.userPassword = userPassword;
    }

    public LoginDTO(){}

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }
}
