package com.example.honkaistarrailteammatch.controller;

import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    // getting all the characters
    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PostMapping("/sync")
    public String loadCharacters() {
        characterService.saveCharacterFromJson();
        return "Characters loaded successfully";
    }
}
