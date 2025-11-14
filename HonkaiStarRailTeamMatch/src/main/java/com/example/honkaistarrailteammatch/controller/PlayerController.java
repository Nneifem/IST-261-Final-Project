package com.example.honkaistarrailteammatch.controller;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.model.Team;
import com.example.honkaistarrailteammatch.repository.PlayerRepository;
import com.example.honkaistarrailteammatch.service.PlayerService;
import com.example.honkaistarrailteammatch.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamService teamService;

    @PostMapping("/signup")
    public Player signup(@RequestBody Player player) {
        return playerService.registerPlayer(player);
    }

    @PostMapping("/login")
        public Optional<Player> login(@RequestBody Player player) {
            return playerService.loginPlayer(player.getUsername(), player.getPassword());
    }

    @GetMapping("/{username}")
    public Optional<Player> getPlayer(@PathVariable String username) {
        return playerService.getPlayer(username);
    }

    @PostMapping("/{username}/characters")
    public ResponseEntity<String> savePlayerCharacters
            (@PathVariable String username,
             @RequestBody Map<String, List<String>> payload) {
            List<String> characterNames = payload.get("characters");
            playerService.savePlayerCharacters(username, characterNames);
            return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}/generateTeam")
    public Team generateTeam(
            @PathVariable String username,
            @RequestParam List<String> characterNames){
        return teamService.generateTeam(username, characterNames);
    }
}
