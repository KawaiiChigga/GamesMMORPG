package model.character;


public class BlackHood extends Monster {
	public BlackHood(String name) {
		super(name);
		super.hp = hpBlackHood;
		super.mana = manaBlackHood;
		super.attack = attackBlackHood;
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
		skill();
		weapon();
	}

}
