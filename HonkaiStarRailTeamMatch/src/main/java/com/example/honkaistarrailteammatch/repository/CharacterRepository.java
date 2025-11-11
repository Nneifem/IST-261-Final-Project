package com.example.honkaistarrailteammatch.repository;

import com.example.honkaistarrailteammatch.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, String> {
}
