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
    private String teamDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "generated_team",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "character_name")
    )
    private List<Character> characters;

    @ManyToOne
    @JoinColumn(name = "username")
    private Player player;

    // getters
    public Long

    // setters

}
