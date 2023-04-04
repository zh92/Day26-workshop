package sg.edu.nus.iss.Day26.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

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

    public static Game create(Document d) {
        Game g = new Game();
        g.setName(d.getString("name"));
        g.setGid(d.getInteger("gid"));
        return g;
    }


    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("name", getName())
                .add("gid", getGid().toString())
                .build();
    }
}
