package model.character;


public class Goblin extends Monster {
	public Goblin(String name) {
		super(name);
		super.hp = hpGoblin;
		super.mana = manaGoblin;
		super.attackMax = attackGoblin;
		super.attackMin = attackGoblin - 5;
		super.skillMax = skillGoblin;
		super.skillMin = skillGoblin - 5;
	}

	@Override
	public String skill() {
		return "Roar";
	}

	@Override
	public String weapon() {
		return "Knife";
	}

}
