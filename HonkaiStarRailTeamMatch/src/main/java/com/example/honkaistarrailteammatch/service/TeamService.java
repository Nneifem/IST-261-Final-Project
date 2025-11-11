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

        // getting the characters the user selected
        List<Character> characters = characterRepository.findAllById(selectedCharacters);

        Team team = new Team();
        team.setPlayer(player);
        team.setTeamName(player.getUsername() + "'s Generated Team");
        team.setCharacters(characters);
        team.setTeamExplanation(generateExplanation(characters));

        return teamRepository.save(team);
    }

    // creating the generateExplanation for why the team was chosen
    private String generateExplanation(List<Character> team) {
        Set<String> paths = team.stream().map(Character::getCharacterPath).collect(Collectors.toSet());
        Set<String> elements = team.stream().map(Character::getCharacterElement).collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        sb.append("The following characters have been assigned to the team:\n. The elements it contains are");
        sb.append(elements.size()).append(" and ");
        sb.append(paths.size()).append(" paths. ");

        if (paths.contains("Abundance")) sb.append(paths.contains("Has a healer"));
        if (paths.contains("Preservation")) sb.append(paths.contains("Has a shielder"));
        if (paths.contains("Harmony")) sb.append(paths.contains("Has a support buffer"));
        if (paths.contains("Destruction") || paths.contains("Hunt")) sb.append(paths.contains("Has at least one DPS"));

        sb.append("Balanced team for the main story quest.");
        return sb.toString();
    }

    // lists all the generated team for the user
    public List<Team> getAllTeams(String username) {
        return teamRepository.findByPlayerUsername(username);
    }

    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team Not Found"));
    }
}
