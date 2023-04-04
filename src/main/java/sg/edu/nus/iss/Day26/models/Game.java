package sg.edu.nus.iss.Day26.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Game {
    
    private String name;
    private Integer gid;
    
    public Game() {
    }
    
    public Game(String name, Integer gid) {
        this.name = name;
        this.gid = gid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Game [name=" + name + ", gid=" + gid + "]";
    }

    public static Game toGame(String jsonStr) {
        Game game = new Game();
        JsonReader reader = Json.createReader(new StringReader(jsonStr));
        JsonObject obj = reader.readObject();
        game.setName(obj.getString("name"));
        game.setGid(obj.getInt("gid"));
        return game;
    }
}
