package com.example.honkaistarrailteammatch.model;

public class Character {
    private String characterName;
    private String characterPath;
    private String characterElement;
    private int characterRarity;

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

    public int getRarity() {
        return characterRarity;
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
}
