package de.holisticon.nim;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class GameRepository {
    HashMap<Long,Game> games = new HashMap<>();

    public Game findById(Long id){
        return games.get(id);
    }

    public Game save(Game game){
        games.put(game.getId(),game);
        return game;
    }

    public void delete(Long id){
        games.remove(id);
    }

}
