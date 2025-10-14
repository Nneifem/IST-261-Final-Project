package com.example.honkaistarrailteammatch.model;

public class Character {
    private String characterName;
    private String characterPath;
    private String characterElement;

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
}
