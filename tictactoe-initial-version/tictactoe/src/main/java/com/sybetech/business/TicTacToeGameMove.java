package com.sybetech.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jongo.marshall.jackson.oid.MongoId;

import java.util.Arrays;
import java.util.List;

public class TicTacToeGameMove {

  	@MongoId
    private int id;
    private char player;
    private int x;
    private int y;

    @JsonIgnore
    private List<Character> allowedChars;

    private TicTacToeGameMove() {
        allowedChars = Arrays.asList('X', 'O');
    }

    public TicTacToeGameMove(int id, char player, int x, int y) {
        this();
        this.id = id;
        this.player = player;
        this.x = x;
        this.y = y;
    }

	public int getId() {
		return id;
	}

	public char getPlayer() {
		return player;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<Character> getAllowedChars() {
		return allowedChars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allowedChars == null) ? 0 : allowedChars.hashCode());
		result = prime * result + id;
		result = prime * result + player;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicTacToeGameMove other = (TicTacToeGameMove) obj;
		if (allowedChars == null) {
			if (other.allowedChars != null)
				return false;
		} else if (!allowedChars.equals(other.allowedChars))
			return false;
		if (id != other.id)
			return false;
		if (player != other.player)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicTacToeGameMove [id=" + id + ", player=" + player + ", x=" + x + ", y=" + y + "]";
	}
	
	
    
}
