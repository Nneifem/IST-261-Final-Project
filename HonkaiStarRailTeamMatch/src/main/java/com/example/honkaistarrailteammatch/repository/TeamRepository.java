package com.example.honkaistarrailteammatch.repository;

import com.example.honkaistarrailteammatch.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByPlayerUsername(String username);
}
