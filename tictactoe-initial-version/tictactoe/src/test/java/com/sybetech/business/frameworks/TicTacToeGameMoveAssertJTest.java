package com.sybetech.business.frameworks;

import com.sybetech.business.TicTacToeGameMove;
import org.junit.Before;
import org.junit.Test;

/**
 * Demo for testing framework util AssertJ
 * Benefits:
 * - fluent
 * - one import
 * use org.assertj.core.api.Java6Assertions.assertThat(.isEqualTo)(.hasSize)(.containsExactlyInAnyOrder)(.containsExactly)
 */
public class TicTacToeGameMoveAssertJTest {

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

    // check x is set after instantiation
    @Test
    public void whenInstantiated_ThenXIsSet() {

    }

    // check y is set after instantiation
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
