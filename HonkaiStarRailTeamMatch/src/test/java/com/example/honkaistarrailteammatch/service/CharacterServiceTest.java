package com.example.honkaistarrailteammatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterService characterService;

    @Test
    void getAllCharacters() {
        Character character = new Character();
        character.setCharacterName("Sushang");

        when(characterRepository.findAll()).thenReturn(List.of(character));
        List<Character> results = characterService.getAllCharacters();

        assertEquals(1, results.size());
        assertEquals("Sushang", results.get(0).getCharacterName());
    }
}