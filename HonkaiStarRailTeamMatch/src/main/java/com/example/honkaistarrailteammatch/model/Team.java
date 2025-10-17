package com.example.honkaistarrailteammatch.model;

public class Team {
    private String playerSelectedCharacters;
    private String generatedTeam;
    private String teamExplaination;

    // getters
    public String getPlayerSelectedCharacters() {
        return playerSelectedCharacters;
    }

    public String getGeneratedTeam() {
        return generatedTeam;
    }

    public  String getTeamExplaination() {
        return teamExplaination;
    }

    // setters
    public void setTeamExplaination(String teamExplaination) {
        this.teamExplaination = teamExplaination;
    }

    public void setPlayerSelectedCharacters(String playerSelectedCharacters) {
        this.playerSelectedCharacters = playerSelectedCharacters;
    }

    public void setGeneratedTeam(String generatedTeam) {
        this.generatedTeam = generatedTeam;
    }
}
