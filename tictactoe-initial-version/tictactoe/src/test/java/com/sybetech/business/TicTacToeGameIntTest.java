package com.sybetech.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Demo for integration test
 * - tests should run fast. Therefore test only what is not yet unit tested
 * - Requires MongoDB running at default port 27017.
 */
public class TicTacToeGameIntTest {
    /****************************************************************************************
     * BP2: integrate real MongoDb.
     ****************************************************************************************/

    /**
     * 1: interface to MongoDb (drop and save) should work
     */
    @Test
    public void givenMongoDbIsUp_WhenPlay_ThenDropAndSaveWork() {
        TicTacToeGame game = new TicTacToeGame();
        TicTacToeGameMove move1 = new TicTacToeGameMove(1, 'X', 1, 1);
        TicTacToeGameMove move2 = new TicTacToeGameMove(2, 'O', 1, 2);

        game.play(move1.getX(), move1.getY());
        game.play(move2.getX(), move2.getY());

        TicTacToeGameState state = new TicTacToeGameState();

        TicTacToeGameMove persistedMove1 = state.findById(move1.getId());
        TicTacToeGameMove persistedMove2 = state.findById(move2.getId());

        assertEquals(move1, persistedMove1);
        assertEquals(move2, persistedMove2);


    }
}
