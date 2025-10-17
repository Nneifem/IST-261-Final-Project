package com.example.honkaistarrailteammatch.model;


public class Player {
    private String username;
    private String ownedCharacters;

    // getters
    public String getUsername() {
        return username;
    }

    public String getOwnedCharacters() {
        return ownedCharacters;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setOwnedCharacters(String ownedCharacters) {
        this.ownedCharacters = ownedCharacters;
    }
}
