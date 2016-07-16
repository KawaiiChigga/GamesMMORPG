package model.character;


public class Ghost extends Monster {
	public Ghost(String name) {
		super(name);
		super.hp = hpGhost;
		super.mana = manaGhost;
		super.attack = attackGhost;
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
		skill();
		weapon();
	}
}
