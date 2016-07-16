package model.character;

import java.util.Random;

public abstract class Monster extends Character implements CommonDefault{
	public boolean isAttackable;
	public int jmlColony;
	public Random rand = new Random();
	public Monster(String name) {
		super(name);
	}

	public boolean isAttackable() {
		return isAttackable;
	}

	public void setAttackable(boolean isAttackable) {
		this.isAttackable = isAttackable;
	}
	
	
}
