package com.example.honkaistarrailteammatch.repository;

import com.example.honkaistarrailteammatch.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, String> {
    List<Character> findByCharacterNameIn(List<String> names);
}
