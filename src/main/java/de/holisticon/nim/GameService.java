package de.holisticon.nim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    public Game createGame(Game game){
        return gameRepository.save(game);
    }

    public Game getGame(Long gameId){
        return gameRepository.findById(gameId);
    }

    public void makeMove(Long gameId, Move move) {
        Game storedGame = gameRepository.findById(gameId);
        if(storedGame.getStatus() == Status.OPEN){
            reduceHeapAndSaveGame(storedGame, move.getNumberOfTakenObjects());

            if(storedGame.getHeapSize()>0)
                //computerMove(storedGame) //Computer takes random number
                computerWinningMove(storedGame); //Computer playes with winning strategy
            else{
                closeGame(storedGame,"Computer");
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game is already closed.");
        }
    }

    private void reduceHeapAndSaveGame(Game game, int numberOfObjectsToTake){
        if((game.getHeapSize()-numberOfObjectsToTake)>=0){
            game.setHeapSize(game.getHeapSize()-numberOfObjectsToTake);
            gameRepository.save(game);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not a valid number of objects to take from heap.");
        }
    }

    private void computerMove(Game game){
        Random random = new Random();

        if(game.getHeapSize()>2)
            //Random number between 1-3
            reduceHeapAndSaveGame(game, random.nextInt(3) + 1);
        else
            //Random number between 1-HeapSize
            reduceHeapAndSaveGame(game, random.nextInt(game.getHeapSize()) + 1);

        if(game.getHeapSize()==0){
            closeGame(game,"Player");
        }
    }

    private void computerWinningMove(Game game){
        switch(game.getHeapSize() % 4){
            case 0: reduceHeapAndSaveGame(game,3);
                    break;
            case 2: reduceHeapAndSaveGame(game,1);
                    break;
            case 3: reduceHeapAndSaveGame(game,2);
                    break;
            default: reduceHeapAndSaveGame(game, 1);
        }

        if(game.getHeapSize() == 0){
            closeGame(game,"Player");
        }
    }

    private void closeGame(Game game, String winner){
        game.setWinner(winner);
        game.setStatus(Status.CLOSED);
        gameRepository.save(game);
    }

    public void deleteGame(Long gameId) {
        gameRepository.delete(gameId);
    }
}
