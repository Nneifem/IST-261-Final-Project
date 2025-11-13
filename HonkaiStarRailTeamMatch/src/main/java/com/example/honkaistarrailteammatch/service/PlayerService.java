package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

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
}
