package com.sybetech.business;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.assertNotNull;

public class TicTacToeSmokeTest {

    @Test
    public void whenDeployedThenWebsiteIsReachable() throws IOException {
        URL url = new URL("http://localhost:8080/tictactoe");
        URLConnection urlConnection = url.openConnection();
        assertNotNull(urlConnection.getContent());
    }

    @Test
    public void whenDeployedThenDatabaseIsReachable(){
        TicTacToeGameState state = new TicTacToeGameState();
        state.findById(4711);
    }
}
