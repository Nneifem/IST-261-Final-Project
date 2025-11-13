package com.example.honkaistarrailteammatch.controller;

import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

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
}
