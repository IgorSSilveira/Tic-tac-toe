package com.sybetech.business;

public class TicTacToeGame {
    public static final String RESULT_IN_PROGRESS = "In progress";
    public static final String COORDINATE_ERR_MSG = "Coordinate must be between 1 and 3";
    public static final String FIELD_OCCUPIED_ERR_MSG = "Field is already occupied!";
    public static final String SAVE_STATE_ERR_MSG = "Could not save state to DB!";
    public static final String DROP_DB_ERR_MSG = "Could not drop DB collection!";
    public static final String RESULT_DRAW = "Draw";
    public static final String RESULT_WINNER = "Winner is %s";
    private static final char UNOCCUPIED = '\0';
    private static final int SIZE = 3;
    private Character[][] board = {
            {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
            , {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
            , {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
    };
    private char lastPlayer = UNOCCUPIED;
    private int counter = 1;
    private TicTacToeGameState state;

    public TicTacToeGame() {
        this(new TicTacToeGameState());
    }

    public TicTacToeGame(TicTacToeGameState state) {
        this.state = state;
        if(!this.state.clear()){
            throw new RuntimeException(DROP_DB_ERR_MSG);
        }
    }

    public char getLastPlayer() {
        return lastPlayer;
    }

    //

    /**
     * 1     2     3
     * |-----|-----|-----|-->x
     * 1|(1,1)|(2,1)|(3,1)|
     * 2|(1,2)|(2,2)|(3,2)|
     * 3|(1,3)|(2,3)|(3,3)|
     * |-----|-----|-----|
     * |
     * y
     * <p>
     * Hint: you may use the players ascii values: 'X'=88*3 = 264 => X wins, 'O'=79*3 = 237 => O wins
     **/
    private boolean isWin(int x, int y) {
        if (board[0][y - 1] == lastPlayer && board[1][y - 1] == lastPlayer && board[2][y - 1] == lastPlayer) {
            return true;
        } else if (board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer) {
            return true;
        } else if (board[2][0] == lastPlayer && board[1][1] == lastPlayer && board[0][2] == lastPlayer) {
            return true;
        }
        return board[x - 1][0] == lastPlayer && board[x - 1][1] == lastPlayer && board[x - 1][2] == lastPlayer;
    }

    // Hint: if one cell is UNOCCUPIED false, else true
    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == UNOCCUPIED) {
                    return false;
                }
            }
        }
        return true;
    }

    public String play(int x, int y) {
        checkCoordinate(x);
        checkCoordinate(y);
        lastPlayer = getNextPlayer();
        TicTacToeGameMove move = new TicTacToeGameMove(counter++, lastPlayer, x, y);
        setField(x, y);
        if (!state.save(move)) {
            throw new RuntimeException(DROP_DB_ERR_MSG);
        }
        if (isWin(x, y)) {
            return String.format(RESULT_WINNER, lastPlayer);
        } else if (isDraw()) {
            return RESULT_DRAW;
        } else {
            return RESULT_IN_PROGRESS;
        }
    }

    private void setField(int x, int y) {
        if (board[x - 1][y - 1] != UNOCCUPIED) {
            throw new RuntimeException(FIELD_OCCUPIED_ERR_MSG);
        }
        board[x - 1][y - 1] = lastPlayer;
    }

    private void checkCoordinate(int coordinate) {
        if (coordinate < 1 || coordinate > 3) {
            throw new RuntimeException(COORDINATE_ERR_MSG);
        }
    }

    public char getNextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }

    public TicTacToeGameState getState() {
        return state;
    }
}
