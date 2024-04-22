// Saahil Gupta
// 3/6/2023
// CS III
// Critter Project
// Class: Lion

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class Lion extends Critter{
	private int numDir; //store the amount of times the lion has moved in a certain direction
	private Direction prevMove = Direction.CENTER; //stores the previous move
	private Random random; // Random object for getMove() method
	private String[] enemies = {">", "<", "V", "^", "%", "S"}; // String array of the enemies toStrings
	private boolean justFoughtLion = false; // checks if lion has survived against fight against other lion
	private Attack testMove; //stores which move my lion is testing against opponent lion
	
	// these need to be static since all the lions should share the knowledge that they gain from fighting the enemy lions
	private static int attackCycle = 0; // helps to ensure that we test all three attack moves against other lion
	private static boolean discoveredLion = false; //have we found the lion's weakness yet
	private static Attack response; // stores the ultimate response of the lion against other lion
	
	/*
	 * Constructor for a lion
	 * @params: none
	 */
	public Lion() {
		this.numDir = 5;
		random = new Random(39);
	}
	
	@Override
	public boolean eat() {
		if(safeToRest()) {
			return true;
		}
		return false;
	}
	
	@Override
	public Color getColor() {
		return Color.YELLOW;
	}
	
	/*
	 * checks whether all neighboring squares are free of enemies
	 * @params: none
	 * @returns: boolean
	 */
	public boolean safeToRest() {
		if (getNeighbor(Direction.NORTH).equals(" ") || getNeighbor(Direction.NORTH).equals(".")) {
			if (getNeighbor(Direction.SOUTH).equals(" ") || getNeighbor(Direction.NORTH).equals(".")) {
				if (getNeighbor(Direction.EAST).equals(" ") || getNeighbor(Direction.NORTH).equals(".")) {
					if (getNeighbor(Direction.WEST).equals(" ") || getNeighbor(Direction.NORTH).equals(".")) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * checks whether a string is an integer (helper to check if enemy is hippo)
	 * @params: String input
	 * @returns: boolean
	 */
	public static boolean isParsable(String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (final NumberFormatException e) { // checks for NaN error
	        return false;
	    }
	}
	
	@Override
	public Direction getMove() {
		if (justFoughtLion) { // essentially checks if the my lion survived a fight with another lion
			justFoughtLion = false;
			response = testMove; // if it did, it knows how to respond next time
			discoveredLion=true;
		}
		
		while (getNeighbor(prevMove).equals("S") || numDir > 3
				|| (!(isParsable(getNeighbor(prevMove))) &&
				!(Arrays.asList(enemies).contains(getNeighbor(prevMove))))
				&& !(getNeighbor(prevMove).equals(" ") ||
					 getNeighbor(prevMove).equals("."))) {
				
			if(numDir > 3) {
				numDir = 0;
			}
			int x = random.nextInt(4);
			System.out.println(String.valueOf(x));
			if(x==0) {
				prevMove = Direction.NORTH;
			} else if (x==1) {
				prevMove = Direction.SOUTH;
			} else if (x==2) {
				prevMove = Direction.EAST;
			} else {
				prevMove = Direction.WEST;
			}
			
		}
		numDir++;
		return prevMove;				
	}
	
	@Override
	public Attack fight(String opponent) {
		if (Arrays.asList(enemies).contains(opponent) || isParsable(opponent)) {
			if (opponent.equals("%")) {
				return Attack.ROAR;
			} else if (opponent.equals("<") || opponent.equals(">") ||
				opponent.equals("V") || opponent.equals("^")) {
				return Attack.SCRATCH;
			} else if (opponent.equals("0")) {
				return Attack.SCRATCH;
			} else {
				return Attack.ROAR;
			}
		} else if (discoveredLion == true) { // this should mean that we know the other lion's weakness
			return response;
		} else { // otherwise we try to find the weakness
			justFoughtLion = true;
			if(attackCycle == 0) {
				testMove = Attack.ROAR;
			} else if (attackCycle==1) {
				testMove = Attack.POUNCE;
			} else if (attackCycle==2) {
				testMove = Attack.SCRATCH;
			}
			attackCycle++;
			return testMove;
		}
	}
	
	@Override
	public String toString() {
		return "}";
	}

}
