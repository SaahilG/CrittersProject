// Saahil Gupta
// 3/6/2023
// CS III
// Critter Project
// Class: Hippo

import java.awt.Color;
import java.util.Random;

public class Hippo extends Critter{
	private int hunger; // stores how much hunger is left for the hippo
	private int numDir; // stores how far a hippo has traveled in a certain direction
	private Direction prevMove; // stores the last direction the hippo traveled
	private Random random; // Random object to get direction in getMove() method
	
	/*
	 * Constructor for hippo
	 * @params: int hunger
	 */
	public Hippo(int hunger) {
		this.numDir = 5;
		random = new Random(38);
		this.hunger = hunger;
	}
	
	@Override
	public Color getColor() {
		if (this.hunger > 0) {
			return Color.GRAY;
		}
		return Color.WHITE;
	}
	
	@Override
	public boolean eat() {
		if (this.hunger > 0) {
			this.hunger--;
			return true;
		}
		return false;
	}
	
	@Override
	public Attack fight(String opponent) {
		if (this.hunger > 0) {
			return Attack.SCRATCH;
		}
		return Attack.POUNCE;
	}
	
	@Override
	public Direction getMove() {
		if (this.numDir == 5) {
			this.numDir = 0;
			int x = random.nextInt(4);
			if(x==0) {
				prevMove = Direction.NORTH;
			} else if (x==1) {
				prevMove = Direction.SOUTH;
			} else if (x==2) {
				prevMove = Direction.EAST;
			} else {
				prevMove = Direction.WEST;
			}
			numDir++;
			return prevMove;
			
		} else {
			this.numDir = this.numDir + 1;
			return this.prevMove;	
		}
	}
	
	
	@Override
	public String toString() {
		return String.valueOf(this.hunger);
	}
	
}
