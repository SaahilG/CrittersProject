// Saahil Gupta
// 3/6/2023
// CS III
// Critter Project
// Class: Vulture

import java.awt.Color;

public class Vulture extends Bird{
	private boolean needsFood = true;
	
	public Vulture() {
		super();
	}
	
	@Override
	public Color getColor() {
		return Color.BLACK;
	}
	
	@Override
	public boolean eat() {
		if (needsFood) {
			needsFood = false;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Attack fight(String opponent) {
		this.needsFood = true;
		if (opponent.equals("%")) {
			return Attack.ROAR;
		} 
		return Attack.POUNCE;
	}
}
