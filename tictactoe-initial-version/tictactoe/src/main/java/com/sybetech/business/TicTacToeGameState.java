package com.sybetech.business;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class TicTacToeGameState {

    static final String DB_NAME = "tic-tac-toe-db";
    static final String COLLECTION_NAME = "tic-tac-toe-collection";
    private MongoCollection mongoCollection;

    public TicTacToeGameState() {
        mongoCollection = new Jongo(new MongoClient().getDB(DB_NAME)).getCollection(COLLECTION_NAME);
    }

    public boolean save(TicTacToeGameMove move) {
        try {
            getMongoCollection().save(move);
            return true;
        } catch (MongoException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean clear() {
        try {
            getMongoCollection().drop();
            return true;
        } catch (MongoException e) {
            e.getMessage();
            return false;
        }
    }

    public TicTacToeGameMove findById(int id) {
        return getMongoCollection().findOne("{_id:#}", id).as(TicTacToeGameMove.class);
    }

    public MongoCollection getMongoCollection() {
        return mongoCollection;
    }
}
