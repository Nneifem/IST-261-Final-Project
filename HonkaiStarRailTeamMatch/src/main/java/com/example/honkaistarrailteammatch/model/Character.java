package com.example.honkaistarrailteammatch.model;

import jakarta.persistence.*;

@Entity
@Table(name = "character")
public class Character {

    @Id
    private String characterName;

    private String characterPath;
    private String characterElement;
    private int characterRarity;

    // getters

    // setters
}
