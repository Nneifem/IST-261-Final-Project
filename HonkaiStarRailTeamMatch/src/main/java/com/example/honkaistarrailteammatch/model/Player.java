package com.example.honkaistarrailteammatch.model;


public class Player {
    private String username;
    private String[] ownedCharacters;
    private String[] selectedCharacters;

    // getters
    public String getUsername() {
        return username;
    }

    public String[] getOwnedCharacters() {
        return ownedCharacters;
    }

    public String[]  getSelectedCharacters() {
        return  selectedCharacters;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setOwnedCharacters(String[] ownedCharacters) {
        this.ownedCharacters = ownedCharacters;
    }

    public void setSelectedCharacters(String[] selectedCharacters) {
        this.selectedCharacters = selectedCharacters;
    }
}
