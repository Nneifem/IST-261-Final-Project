package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Team;
import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.repository.TeamRepository;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CharacterRepository characterRepository;

    // look for the user to start the team generation process
    public Team generateTeam(String username, List<String> selectedCharacters) {
        Player player = playerRepository.findById(username).orElseThrow(() -> new RuntimeException("Player Not Found"));

        // deleting old teams
        List<Team> oldTeams = teamRepository.findByPlayerUsername(username);
        if (!oldTeams.isEmpty()) {
            teamRepository.deleteAll(oldTeams);
        }

        // getting the characters the user selected
        List<Character> selectCharacters = characterRepository.findByCharacterNameIn(selectedCharacters);

        Team team = new Team();
        team.setPlayer(player);
        team.setTeamName(player.getUsername() + "'s Generated Team");
        team.setCharacters(selectCharacters);

        player.getGeneratedTeams().add(team);
        playerRepository.save(player);
        return team;
    }

    // lists all the generated team for the user
    public List<Team> getAllTeams(String username) {
        return teamRepository.findByPlayerUsername(username);
    }

    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team Not Found"));
    }

    public List<Team> getTeamsByUsername(String username) {
        return teamRepository.findByPlayerUsername(username);
    }
}