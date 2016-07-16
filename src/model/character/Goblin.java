package model.character;

import model.item.Item;

public class Goblin extends Monster {
	public Goblin(String name) {
		super(name);
		super.isAttackable = true;
		super.hp = hpGoblin;
		super.mana = manaGoblin;
		super.attack = attackGoblin;
		super.jmlColony = rand.nextInt(colonyGoblin) + 1;
	}

	@Override
	public String skill() {
		return "Roar";
	}

	@Override
	public String weapon() {
		return "Knife";
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
		Item drop = new Item("Knive", 0, 0, 15, 500);
		return drop;
	}
	
}
