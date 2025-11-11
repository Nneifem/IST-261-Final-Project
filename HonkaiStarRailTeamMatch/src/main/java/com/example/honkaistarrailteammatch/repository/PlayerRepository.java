package com.example.honkaistarrailteammatch.repository;

import com.example.honkaistarrailteammatch.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {
    Player findByUsernameAndPassword(String username, String password);
}
