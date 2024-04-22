// Saahil Gupta
// 3/6/2023
// CS III
// Critter Project
// Class: Bird

import java.awt.Color;

public class Bird extends Critter{
	private int numDir; // stores the amount of times the bird has flown a certain direction
	private Direction prevMove; // stores the current direction the bird is moving in
	
	/*
	 * Constructor for bird
	 * @params: none
	 */
	public Bird() {
		numDir = -1;
		prevMove = Direction.NORTH;
	}
	
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	
	@Override
	public boolean eat() {
		return false;
	}
	
	@Override
	public Attack fight(String opponent) {
		if (opponent.equals("%")) {
			return Attack.ROAR;
		}
		return Attack.POUNCE;
	}
	
	@Override
	public Direction getMove() {
		if (this.numDir == 2) {
			this.numDir = 0;
			if(this.prevMove== Direction.WEST) {
				prevMove = Direction.NORTH;
				return Direction.NORTH;
			} else if (this.prevMove == Direction.NORTH) {
				this.prevMove = Direction.EAST;
				return Direction.EAST;
			} else if (this.prevMove == Direction.EAST) {
				this.prevMove = Direction.SOUTH;
				return Direction.SOUTH;
			} else {
				this.prevMove = Direction.WEST;
				return Direction.WEST;
			}
		} else {
			this.numDir = this.numDir + 1;
			return this.prevMove;	
		}
	}
	
	
	@Override
	public String toString() {
		if (this.prevMove == Direction.NORTH) {
			return "^";
		} else if (this.prevMove == Direction.EAST) {
			return ">";
		} else if (this.prevMove == Direction.SOUTH) {
			return "V";
		} else {
			return "<";
		}
	}
	
}
