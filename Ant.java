// Saahil Gupta
// 3/6/2023
// CS III
// Critter Project
// Class: Ant

import java.awt.Color;

public class Ant extends Critter{
	
	private boolean walkSouth; // to determine which direction the ant will move
	private Direction prevMove = Direction.EAST; // prevMove used to track what the ant's next move will be depending on the previous move
	
	/*
	 * Constructor for Ant
	 * @params: boolean walkSouth
	 */
	public Ant(boolean walkSouth) {
		this.walkSouth = walkSouth;
	}
	
	@Override
	public Color getColor() {
		return Color.RED;
	}
	
	@Override
	public boolean eat() {
		return true;
	}
	
	@Override
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
	
	@Override
	public Direction getMove() {
		if(this.walkSouth==true) {
			if(this.prevMove==Direction.EAST) {
				this.prevMove = Direction.SOUTH;
				return Direction.SOUTH;
			}
		} else {
			if(this.prevMove==Direction.EAST) {
				this.prevMove = Direction.NORTH;
				return Direction.NORTH;
			}
		}
		this.prevMove = Direction.EAST;
		return Direction.EAST;
	}
	
	@Override
	public String toString() {
		return "%";
	}
	
}
