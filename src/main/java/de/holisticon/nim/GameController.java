package de.holisticon.nim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public Game createGame(@Valid @RequestBody Game game){
        return gameService.createGame(game);
    }

    @PutMapping("/{gameId}")
    public void makeMove(@PathVariable Long gameId, @Valid @RequestBody Move move){
        gameService.makeMove(gameId, move);
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable Long gameId){
        return gameService.getGame(gameId);
    }

    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable Long gameId){
        gameService.deleteGame(gameId);
    }
}
