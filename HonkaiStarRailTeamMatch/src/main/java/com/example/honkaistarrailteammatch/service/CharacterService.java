package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init(){
        if (characterRepository.count() == 0) {
            saveCharacterFromJson();
        }
    }

    public void saveCharacterFromJson() {
        try {
            // loading the file
            InputStream inputStream = new ClassPathResource("hsr_characters.json").getInputStream();
            List<Character> characters = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Character>>() {}
            );

            // checking for any new characters added into the database
            for (Character character : characters) {
                if (!characterRepository.existsById(character.getCharacterName())) {
                    characterRepository.save(character);
                }
            }
            System.out.println("Character has been saved successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // getting all the characters
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }
}
