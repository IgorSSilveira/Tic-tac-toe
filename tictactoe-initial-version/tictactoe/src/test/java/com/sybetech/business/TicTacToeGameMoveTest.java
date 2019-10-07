package com.sybetech.business;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * JUnit Demo
 * use assertEquals, assertTrue (with and without message
 */
public class TicTacToeGameMoveTest {

    // https://github.com/junit-team/junit4/wiki/rules (JUnit interceptors)
//    @Rule
    public final TestName name = new TestName();
    private final int id = 3;
    private final int x = 1;
    private final int y = 1;
    private final char player = 'X';
    private TicTacToeGameMove move;

    @BeforeClass
    public static void beforeClass() {
        // called once on class initialization time
    }

    @AfterClass
    public static void afterClass() {
        // called once after all methods are executed
    }

    @Before
    public void before() {
        move = new TicTacToeGameMove(id, player, x, y);
    }

    //    @After
    public void after() {
        // called after each method execution
    }

    // check id is set after instantiation
    @Test
    public void whenInstantiated_ThenIdIsSet() {
        assertEquals("Asserting that id is set in constructor", 3, move.getId());
    }

    // check x is set after instantiation
    @Test
    public void whenInstantiated_ThenXIsSet() {
        assertEquals("Asserting that id is set in constructor", 1, move.getX());
    }

    // check y is set after instantiation
    @Test
    public void whenInstantiated_ThenYIsSet() {
        assertEquals("Asserting that the Y axis is set in the constructor", 1, move.getY());
    }

    // check player is set after instantiation
    @Test
    public void whenInstantiated_ThenPlayerIsSet() {
        assertEquals("Asserting that the player is set in the constructor as X", 'X', move.getPlayer());

        TicTacToeGameMove move1 = new TicTacToeGameMove(2, 'O', 2, 3);
        assertEquals("Asserting that the player is set in the constructor as O", 'O', move1.getPlayer());
    }

    // check allowedChars are O and X after instantiation
    @Test
    public void whenInstantiated_ThenAllowedCharsAreOAndX() {
        List<Character> expectedChars = Arrays.asList('X', 'O');
        assertTrue(move.getAllowedChars().containsAll(expectedChars));
        assertEquals(2, move.getAllowedChars().size());
        assertEquals(2, expectedChars.size());

    }

}
