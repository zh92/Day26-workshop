package sg.edu.nus.iss.Day26.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.Day26.models.Game;
import sg.edu.nus.iss.Day26.services.GameService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<String> getGames(
            @RequestParam Integer limit, @RequestParam Integer offset) {

        List<Game> results = gameService.getGames(limit, offset);
        JsonObject result = null;

        JsonObjectBuilder objBuilder = Json.createObjectBuilder();
        Game game = new Game();
        game.setName(results);
        game.setGid(offset);
        }
    
}
