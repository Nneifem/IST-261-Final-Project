package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // reading player's character list
    public List<Player> findAllByCharacter(Character character) {
        return playerRepository.findAll();
    }
}
