package model.character;

import model.item.Item;

public class Insect extends Monster{
	public Insect(String name) {
		super(name);
		super.isAttackable = true;
		super.hp = hpInsect;
		super.mana = manaInsect;
		super.attack = attackInsect;
		super.jmlColony = rand.nextInt(colonyInsect) + 1;
	}

	@Override
	public String skill() {
		return "Poison Sting";
	}

	@Override
	public String weapon() {
		return "Sting";
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
		Item drop = new Item("Coccon", 50, 10, 0, 750);
		return drop;
	}
}
