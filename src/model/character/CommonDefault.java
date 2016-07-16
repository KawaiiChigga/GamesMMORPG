package model.character;

import model.item.Item;

public interface CommonDefault {
	public static final int hpGoblin = 70;
	public static final int manaGoblin = 50;
	public static final int attackGoblin = 12;
	
	public static final int hpGhost = 1;
	public static final int manaGhost = 1;
	public static final int attackGhost = 5;
	
	public static final int hpInsect = 30;
	public static final int manaInsect = 20;
	public static final int attackInsect = 8;
	
	public static final int hpSnake = 65;
	public static final int manaSnake = 40;
	public static final int attackSnake = 14;
	
	public static final int hpSentinel = 150;
	public static final int manaSentinel = 50;
	public static final int attackSentinel = 5;
	
	public static final int colonyGoblin = 12;
	public static final int colonyGhost = 8;
	public static final int colonyInsect = 15;
	public static final int colonySnake = 5;
	public static final int colonySentinel = 3;
	
	public abstract Item dropItem();
}
