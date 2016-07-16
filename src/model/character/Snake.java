package model.character;

import model.item.Item;

public class Snake extends Monster{
	public Snake(String name) {
		super(name);
		super.isAttackable = true;
		super.hp = hpSnake;
		super.mana = manaSnake;
		super.attack = attackSnake;
		super.jmlColony = rand.nextInt(colonySnake) + 1;
	}

	@Override
	public String skill() {
		return "Bind";
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
		Item drop = new Item("Mana Potion", 0, 10, 0, 200);
		return drop;
	}
}
