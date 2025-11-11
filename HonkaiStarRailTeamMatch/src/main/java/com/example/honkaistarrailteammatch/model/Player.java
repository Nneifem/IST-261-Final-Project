package com.example.honkaistarrailteammatch.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "player")
public class Player {

    @Id
    private String username;

    private String email;
    private String password;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Team> generatedTeams;

    // storing characters the player owns
    @ManyToMany
    @JoinTable(
            name = "owned_characters",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "character_name")
    )
    private List<Character> ownedCharacters;

    // getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Team> getGeneratedTeams() {
        return generatedTeams;
    }

    public List<Character> getOwnedCharacters() {
        return ownedCharacters;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGeneratedTeams(List<Team> generatedTeams) {
        this.generatedTeams = generatedTeams;
    }

    public void setOwnedCharacters(List<Character> ownedCharacters) {
        this.ownedCharacters = ownedCharacters;
    }
}
