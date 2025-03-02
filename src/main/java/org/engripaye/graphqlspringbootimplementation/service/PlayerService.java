package org.engripaye.graphqlspringbootimplementation.service;

import jakarta.annotation.PostConstruct;
import org.engripaye.graphqlspringbootimplementation.model.Player;
import org.engripaye.graphqlspringbootimplementation.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0);

    // find all players
    public List<Player> findAll(){
        return players;
    }

    // find players by id

    public Optional<Player> findById(Integer id){
        return players.stream()
                .filter(player -> Objects.equals(player.Id(), id)).findFirst();
    }

    // create players

    public Player createPlayers(String name, Team team) {
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);
        return player;
    }

    // delete players
    public Player deletePlayer(Integer id){
        Player player = players.stream().filter(createPlayers -> Objects.equals(createPlayers.Id(), id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Player not found"));
        players.remove(player);
        return player;
    }

    // update players

    public Player updatePlayer(Integer id, String name, Team team){
        Player updatedPlayer = new Player(id, name, team);
        Optional<Player> optional = players.stream()
                .filter(createPlayers -> Objects.equals(createPlayers.Id(), id)).findFirst();

        if (optional.isPresent()) {
            Player player = optional.get();
            int index = players.indexOf(player);
            players.set(index, updatedPlayer);
        }else {
            throw new IllegalArgumentException("Invalid Player");
        }
        return updatedPlayer;
    }

    @PostConstruct
    private void init() {
        players.add(new Player(id.incrementAndGet(), "Raheem Sterling", Team.CHE));
        players.add(new Player(id.incrementAndGet(), "Vinicius Junior", Team.RMA));
        players.add(new Player(id.incrementAndGet(), "Lamine Yamal", Team.BAR));
        players.add(new Player(id.incrementAndGet(), "Bruno Fernandes", Team.MUN));
        players.add(new Player(id.incrementAndGet(), "Joseph Yobo", Team.CSK));

    }

}
