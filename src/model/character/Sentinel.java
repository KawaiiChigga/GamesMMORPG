package model.character;

import model.item.Item;

public class Sentinel extends Monster {
	public Sentinel(String name) {
		super(name);
		super.isAttackable = true;
		super.hp = hpSentinel;
		super.mana = manaSentinel;
		super.attack = attackSentinel;
		super.jmlColony = rand.nextInt(colonySentinel) + 1;
	}

	@Override
	public String skill() {
		return "Root";
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
		Item drop = new Item("Root", 70, 0, 3, 1200);
		return drop;
	}

}
