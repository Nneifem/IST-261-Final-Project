package com.example.honkaistarrailteammatch.model;


public class Player {
    private String username;
    private String email;
    private String[] hsrCharacters;

    // getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String[] getHsrCharacters() {
        return hsrCharacters;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHsrCharacters(String[] hsrCharacters) {
        this.hsrCharacters = hsrCharacters;
    }
}
