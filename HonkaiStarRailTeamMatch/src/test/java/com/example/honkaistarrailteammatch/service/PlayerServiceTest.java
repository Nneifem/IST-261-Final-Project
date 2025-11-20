package com.example.honkaistarrailteammatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void registerPlayer() {
        Player player = new Player();
        player.setUsername("faye");

        when(playerRepository.save(player)).thenReturn(player);
        Player savedPlayer = playerService.registerPlayer(player);

        assertNotNull(savedPlayer);
    }

    @Test
    void loginPlayer() {
        Player player = new Player();
        player.setUsername("faye");
        player.setPassword("something");

        when(playerRepository.findByUsernameAndPassword("faye", "something")).thenReturn(player);
        Optional<Player> results = playerService.loginPlayer("faye", "something");
        assertTrue(results.isPresent());
    }

    @Test
    void getPlayer() {
        Player player = new Player();
        player.setUsername("faye");

        when(playerRepository.findById("faye")).thenReturn(Optional.of(player));
        Optional<Player> results = playerService.getPlayer("faye");

        assertTrue(results.isPresent());
    }

    @Test
    void savePlayerCharacters() {
        Player player = new Player();
        player.setUsername("faye");

        Character char1 = new Character();
        char1.setCharacterName("Dan Heng");

        Character char2 = new Character();
        char2.setCharacterName("Blade");

        Character char3 = new Character();
        char3.setCharacterName("Jingliu");

        Character char4 = new Character();
        char4.setCharacterName("Jing Yuan");

        List<Character> characters = List.of(char1, char2, char3, char4);

        when(playerRepository.findById("faye")).thenReturn(Optional.of(player));
        when(characterRepository.findByCharacterNameIn(List.of("Dan Heng", "Blade", "Jingliu", "Jing Yuan"))).thenReturn(characters);

        playerService.savePlayerCharacters("faye", List.of("Dan Heng", "Blade", "Jingliu", "Jing Yuan"));

        assertEquals(4, player.getOwnedCharacters().size());
        verify(playerRepository).save(player);
    }

    @Test
    void getPlayerCharactersName() {
        Player player = new Player();
        player.setUsername("faye");

        Character char1 = new Character();
        char1.setCharacterName("Dan Heng");

        Character char2 = new Character();
        char2.setCharacterName("Blade");

        Character char3 = new Character();
        char3.setCharacterName("Jingliu");

        Character char4 = new Character();
        char4.setCharacterName("Jing Yuan");

        player.setOwnedCharacters(List.of(char1, char2, char3, char4));
        when(playerRepository.findById("faye")).thenReturn(Optional.of(player));

        List<String> names = playerService.getPlayerCharacterNames("faye");
        assertEquals(4, names.size());
    }
}