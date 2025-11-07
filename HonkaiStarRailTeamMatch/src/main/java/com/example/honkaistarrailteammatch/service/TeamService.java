package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import com.example.honkaistarrailteammatch.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CharacterRepository characterRepository;
    
    @Autowired
    PlayerRepository playerRepository;
}
