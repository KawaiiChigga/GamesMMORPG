package model.character;

import java.util.Random;

public abstract class Monster extends Character implements CommonDefault{
	public Random rand = new Random();
	public Monster(String name) {
		super(name);
	}
}
