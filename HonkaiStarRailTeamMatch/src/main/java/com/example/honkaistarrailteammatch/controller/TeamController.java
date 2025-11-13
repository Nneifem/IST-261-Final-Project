package com.example.honkaistarrailteammatch.controller;


import com.example.honkaistarrailteammatch.model.Team;
import com.example.honkaistarrailteammatch.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // displaying all the generated team the user has
    @PostMapping("/generate/{username}")
    public Team generateTeam(
            @PathVariable String username,
            @RequestBody List<String> selectedCharacterNames
    ) {
        return teamService.generateTeam(username, selectedCharacterNames);
    }

    // getting the team associated with the player
    @GetMapping("/all/{username}")
    public List<Team> getAllTeams(@PathVariable String username) {
        return teamService.getAllTeams(username);
    }

    // getting generated team
    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }
}
