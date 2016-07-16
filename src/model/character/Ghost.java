package model.character;

import model.item.Item;

public class Ghost extends Monster {
	public Ghost(String name) {
		super(name);
		super.isAttackable = false;
		super.hp = hpGhost;
		super.mana = manaGhost;
		super.attack = attackGhost;
		super.jmlColony = rand.nextInt(colonyGhost) + 1;
	}

	@Override
	public String skill() {
		return "Life Drain";
	}

	@Override
	public String weapon() {
		return null;
	}

	@Override
	public void printData() {
		System.out.println("Nama : " + this.name);
		System.out.println("Attack : " + this.attack);
		System.out.println("HP : " + this.hp);
		System.out.println("Mana : " + this.mana);
		System.out.println("Is Attackable : " + this.isAttackable());
		skill();
		weapon();
	}

	@Override
	public Item dropItem() {
		return null;
	}
	
}
