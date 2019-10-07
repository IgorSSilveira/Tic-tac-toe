package com.sybetech.business.frameworks;

import com.sybetech.business.TicTacToeGameMove;
import org.junit.Before;
import org.junit.Test;


/**
 * Demo for testing framework util Hamcrest
 * Some Benefits:
 * - readability
 * - type safety
 * - natively supported by JUnit (org.junit.Assert)
 * - portability: combine with TestNG and JUnit
 * - custom matchers
 *
 * use org.hamcrest.MatcherAssert.assertThat and org.junit.Assert.assertThat (with and without message),
 * is, not, equalTo, hasSize, containsInAnyOrder from org.hamcrest.Matchers.
 * implement MyHamcrestMatcher.myEqualTo and use it here
 */
public class TicTacToeGameMoveHamcrestTest {

    private TicTacToeGameMove move;
    private final int id = 3;
    private final int x = 1;
    private final int y = 1;
    private final char player = 'X';

    @Before
    public void before() {
        move = new TicTacToeGameMove(id, player, x, y);
    }

    // check id is set after instantiation
    @Test
    public void whenInstantiated_ThenIdIsSet() {

    }

    // check x is set after instantiation. use junit assertThat
    @Test
    public void whenInstantiated_ThenXIsSet() {

    }

    // check y is set after instantiation. use MyHamcrestMatcher.myEqualTo
    @Test
    public void whenInstantiated_ThenYIsSet() {

    }

    // check player is set after instantiation
    @Test
    public void whenInstantiated_ThenPlayerIsSet() {

    }

    // check allowedChars are O and X after instantiation
    @Test
    public void whenInstantiated_ThenAllowedCharsAreOandX() {

    }
}
