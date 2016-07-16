package model.character;


public class Goblin extends Monster {
	public Goblin(String name) {
		super(name);
		super.hp = hpGoblin;
		super.mana = manaGoblin;
		super.attack = attackGoblin;
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
		skill();
		weapon();
	}
	
}
