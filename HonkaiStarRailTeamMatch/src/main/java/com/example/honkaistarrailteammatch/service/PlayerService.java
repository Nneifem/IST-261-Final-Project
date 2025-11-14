package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    private CharacterRepository characterRepository;

    // saving user's account
    public Player registerPlayer(Player player) {
        return playerRepository.save(player);
    }

    // checking if the user enters information correct fpr existing account
    public Optional<Player> loginPlayer(String username, String password) {
        Player player = playerRepository.findByUsernameAndPassword(username, password);
        return Optional.ofNullable(player);
    }

    // get player
    public Optional<Player> getPlayer(String username) {
        return playerRepository.findById(username);
    }

    // save the characters to the user account
    public void savePlayerCharacters(String username, List<String> characterNames) {
        Player player = playerRepository.findById(username).orElseThrow();
        List<Character> selectedCharacters = characterRepository.findByCharacterNameIn(characterNames);
        player.setOwnedCharacters(selectedCharacters);
        playerRepository.save(player);
    }
}
