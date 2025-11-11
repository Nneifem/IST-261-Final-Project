package com.example.honkaistarrailteammatch.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "character")
public class Character {

    @Id
    private String characterName;

    private String characterPath;
    private String characterElement;
    private int characterRarity;

    // multiple characters to multiple teams
    @ManyToMany(mappedBy = "characters")
    private List<Team> teams;

    // multiple characters to one player
    @ManyToMany(mappedBy = "owned_characters")
    private List<Player> players;


    // getters
    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterPath() {
        return characterPath;
    }

    public String getCharacterElement() {
        return characterElement;
    }

    public int getCharacterRarity() {
        return characterRarity;
    }

    public List<Team> getTeams() {
        return teams;
    }
    public List<Player> getPlayers() {
        return players;
    }


    // setters
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setCharacterPath(String characterPath) {
        this.characterPath = characterPath;
    }

    public void setCharacterElement(String characterElement) {
        this.characterElement = characterElement;
    }

    public void setCharacterRarity(int characterRarity) {
        this.characterRarity = characterRarity;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
