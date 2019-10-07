package com.sybetech.business.frameworks;

import com.mongodb.MongoException;
import com.sybetech.business.TicTacToeGameMove;
import com.sybetech.business.TicTacToeGameState;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

/**
 * Demo for mocking framework JMockit
 */
public class TicTacToeGameStateJMockitTest {

    private TicTacToeGameState state;

//    @Mocked
    private MongoCollection mongoCollection;

    private TicTacToeGameMove move;

    @Before
    public void setUp() {
        move = new TicTacToeGameMove(3, 'X', 2, 1);

        // instantiate class to test

        // use Deencapsulation to set private field mongoCollection

    }

    // check save invocation.
    // use NonStrictExpectations and times to mock mongoCollection.save
    @Test
    public void whenSave_ThenInvokeMongoCollectionSaveAndReturnTrue() throws Exception {

    }

    // check when exception occurs during save, then save returns false
    // use Expectations and result to mock mongoCollection.save
    @Test
    public void givenMongoException_WhenSave_ThenReturnFalse() {

    }

    // check clear invocation
    // use Expectations to mock mongoCollection.drop()
    @Test
    public void whenClear_ThenInvokeMongoCollectionDrop() {

    }

    // check when exception occurs during clear, then clear returns false
    // use Expectations and result to mock mongoCollection.drop
    @Test
    public void givenMongoException_WhenClear_ThenReturnFalse() {

    }
}
