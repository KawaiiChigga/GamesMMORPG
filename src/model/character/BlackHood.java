package model.character;


public class BlackHood extends Monster {
	public BlackHood(String name) {
		super(name);
		super.hp = hpBlackHood;
		super.mana = manaBlackHood;
		super.attackMax = attackBlackHood;
		super.attackMin = attackBlackHood - 5;
		super.skillMax = skillBlackHood;
		super.skillMin = skillBlackHood - 5;
	}

	@Override
	public String skill() {
		return "Throw Knife";
	}

	@Override
	public String weapon() {
		return "Dagger";
	}

}
