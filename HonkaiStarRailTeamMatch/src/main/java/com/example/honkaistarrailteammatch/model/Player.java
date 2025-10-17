package com.example.honkaistarrailteammatch.model;


import java.util.List;

public class Player {
    private String username;
    private String email;
    private List<Character> ownedCharacters;
    private List<Team> generatedTeam;

    // getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<Character> getOwnedCharacters() {
        return ownedCharacters;
    }

    public List<Team> getGeneratedTeam() {
        return generatedTeam;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwnedCharacters(List<Character> ownedCharacters) {
        this.ownedCharacters = ownedCharacters;
    }

    public void setGeneratedTeam(List<Team> generatedTeam) {
        this.generatedTeam = generatedTeam;
    }
}
