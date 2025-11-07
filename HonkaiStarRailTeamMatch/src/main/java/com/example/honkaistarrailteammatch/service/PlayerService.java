package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // get all players
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    // get player by username
    public Player findByUsername(String username) {
        return playerRepository.findById(username).orElse(null);
    }

    // update player


    // delete player

}
