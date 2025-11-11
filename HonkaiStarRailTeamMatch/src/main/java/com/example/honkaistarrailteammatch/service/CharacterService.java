package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public List<Character> loadCharactersFromJson() throws IOException {
        try {
            // loading the file
            InputStream inputStream = new ClassPathResource("hsr_characters.json").getInputStream();

            // converting JSON file into List<Character>
            List<Character> characters = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Character>>() {}
            );
            return characters;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    // saving all the characters in the database
    public void savedCharactersFromJson() throws IOException {
        List<Character> savedCharacters = loadCharactersFromJson();
        characterRepository.saveAll(savedCharacters);
    }
    
    // getting all the characters
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }
}
