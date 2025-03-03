package org.engripaye.graphqlspringbootimplementation.controller;

import org.engripaye.graphqlspringbootimplementation.model.Player;
import org.engripaye.graphqlspringbootimplementation.model.Team;
import org.engripaye.graphqlspringbootimplementation.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

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

    @QueryMapping
    public Optional<Player> findById(@Argument Integer id) {
        return playerService.findById(id);
    }

    @MutationMapping
    public Player createPlayers(@Argument String name, @Argument Team team) {
        return playerService.createPlayers(name, team);
    }

    @MutationMapping
    public Player updatePlayers(@Argument Integer id, @Argument String name, @Argument Team team){
        return playerService.updatePlayer(id, name, team);
    }

    @MutationMapping
    public Player deletePlayers(@Argument Integer id){
        return playerService.deletePlayer(id);
    }
}
