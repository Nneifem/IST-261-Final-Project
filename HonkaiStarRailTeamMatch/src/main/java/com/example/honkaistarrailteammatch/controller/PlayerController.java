package com.example.honkaistarrailteammatch.controller;


import com.example.honkaistarrailteammatch.model.Player;
import com.example.honkaistarrailteammatch.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api/players")

public class PlayerController {
}
