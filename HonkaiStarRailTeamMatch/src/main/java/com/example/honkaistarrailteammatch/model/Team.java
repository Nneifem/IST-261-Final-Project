package com.example.honkaistarrailteammatch.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String teamName;
    private String teamExplanation;

    // storing generated team to the player
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;


    // same character can be in multiple teams
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "generated_team",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "character_name")
    )
    private List<Character> characters;


    // getters
    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamExplanation() {
        return teamExplanation;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    // setters
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public  void setTeamExplanation(String teamExplanation) {
        this.teamExplanation = teamExplanation;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
