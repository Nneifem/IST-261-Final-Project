package com.example.honkaistarrailteammatch.service;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.model.Character;
import com.example.honkaistarrailteammatch.model.Team;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import com.example.honkaistarrailteammatch.repository.CharacterRepository;
import com.example.honkaistarrailteammatch.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private TeamService teamService;

    @Test
    void generateTeam() {
        Player player = new Player();
        player.setUsername("jane");
        player.setGeneratedTeams(new ArrayList<>());

        Character char1 = new Character();
        char1.setCharacterName("Dan Heng");

        Character char2 = new Character();
        char2.setCharacterName("Himeko");

        Character char3 = new Character();
        char3.setCharacterName("Welt");

        Character char4 = new Character();
        char4.setCharacterName("Herta");

        List<Character> characters = List.of(char1, char2, char3, char4);

        when(playerRepository.findById("jane")).thenReturn(Optional.of(player));
        when(characterRepository.findByCharacterNameIn(List.of("Dan Heng", "Himeko", "Welt"))).thenReturn(characters);

        Team team = teamService.generateTeam("jane", List.of("Dan Heng", "Himeko", "Welt"));

        assertNotNull(team);
        assertEquals("jane's Generated Team", team.getTeamName());
        assertEquals(4,  team.getCharacters().size());
        assertEquals(player, team.getPlayer());
    }

    @Test
    void getAllTeams() {
        List<Team> teams = List.of(new Team(),  new Team());
        when(teamRepository.findByPlayerUsername("jane")).thenReturn(teams);

        List<Team> results = teamService.getAllTeams("jane");
        assertEquals(teams, results);
    }

    @Test
    void getTeam() {
        Team team = new Team();
        team.setTeamId(1L);

        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));
        Team result = teamService.getTeam(1L);
        assertEquals(team, result);
    }

    @Test
    void getTeamsByUsername() {
        List<Team> teams = List.of(new Team(), new Team());
        when(teamRepository.findByPlayerUsername("jane")).thenReturn(teams);

        List<Team> results = teamService.getTeamsByUsername("jane");
        assertEquals(teams, results);
    }

    @Test
    void deleteTeam() {
        Player player = new Player();
        player.setGeneratedTeams(new ArrayList<>());

        Team team = new Team();
        team.setTeamId(1L);
        team.setPlayer(player);

        player.getGeneratedTeams().add(team);
        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));

        teamService.deleteTeam(1L);
        assertTrue(player.getGeneratedTeams().isEmpty());
    }
}