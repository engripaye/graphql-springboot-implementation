package org.engripaye.graphqlspringbootimplementation.controller;

import org.engripaye.graphqlspringbootimplementation.model.Player;
import org.engripaye.graphqlspringbootimplementation.service.PlayerService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public List<Player> findAll() {
        return playerService.findAll();
    }
}
