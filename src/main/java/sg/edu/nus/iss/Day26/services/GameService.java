package sg.edu.nus.iss.Day26.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.Day26.models.Game;
import sg.edu.nus.iss.Day26.repositories.GameRepo;

@Service
public class GameService {
    
    @Autowired
    private GameRepo gameRepo;

    public List<Game> getGames(Integer limit, Integer skip) {
        return gameRepo.getGameList(limit, skip);
    }
}
