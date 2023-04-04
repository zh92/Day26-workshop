package sg.edu.nus.iss.Day26.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Games {
    
    private List<Game> games;
    private Integer offset;
    private Integer limit;
    private Integer total;
    private LocalDateTime timestamp;
    
    public Games() {
    }
    
    public Games(List<Game> games, Integer offset, Integer limit, Integer total, LocalDateTime timestamp) {
        this.games = games;
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.timestamp = timestamp;
    }

    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("games", getGames().toString())
                .add("offset", getOffset())
                .add("limit", getLimit())
                .add("total", getTotal())
                .add("timestamp", getTimestamp().toString())
                .build();
    }
}
