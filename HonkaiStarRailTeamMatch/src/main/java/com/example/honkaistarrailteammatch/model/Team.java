package com.example.honkaistarrailteammatch.model;


import java.util.List;

public class Team {
    private List<Character> playerCharacters;
    private List<Team> teams;

    // getters
    public List<Character> getCharacters() {return playerCharacters;
    }

    public List<Team> getTeams() {
        return teams;
    }

    // setters
    public void setCharacters(List<Character> characters) {
        this.playerCharacters = characters;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
