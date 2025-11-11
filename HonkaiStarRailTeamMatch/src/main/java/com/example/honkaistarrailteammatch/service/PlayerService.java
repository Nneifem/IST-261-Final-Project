package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    // finding the account and if not found throw error
    public Player findPlayerByUserAndPassword(String username, String password) {
        if (this.playerRepository.findByUsernameAndPassword(username, password) != null) {
            return this.playerRepository.findByUsernameAndPassword(username, password);
        }
        else {
            throw new IllegalArgumentException("Username is not found");
        }
    }

    // saving user's account
    public Player existingUsernameAndPassword(Player player) {
        return playerRepository.save(player);
    }
}
