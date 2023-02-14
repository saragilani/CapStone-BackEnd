package com.example.Orbit.services;

public class LoginDTO {

    private String password;
    private String emailAddress;

    public LoginDTO (String password, String emailAddress){
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public LoginDTO(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
