package sg.edu.nus.iss.Day26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.Day26.models.Game;

@Repository
public class GameRepo {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String C_GAMES = "games";
    /*
     * db.games.find(
            {name : {$exists: true}},
            {_id: 0, name: 1, gid: 1}
        ).limit(25)
         .skip(0);
     */
    public List<Game> getGameList(Integer limit, Integer skip) {

        Criteria criteria = Criteria.where("name").exists(true);
        Query query = Query.query(criteria)
                            .limit(limit)
                            .skip(skip);
        query.fields().exclude("_id")
                      .include("name", "gid");
        // Convert the document to a list
        return mongoTemplate.find(query, Document.class, C_GAMES)
            .stream()
            .map(doc -> Game.create(doc))
            .toList();
    }
}