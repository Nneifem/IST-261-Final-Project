package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;


}
