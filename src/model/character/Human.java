package model.character;

import java.util.ArrayList;


public class Human extends Character implements HumanDefault {
	public String job;
	public double exp;
	public int level;
	
	public Human(String name, String job) {
		super(name);
		this.job = job;
		this.exp = 0;
		this.level = 1;
		if (job.equalsIgnoreCase("Warrior")) {
			super.attackMax = attackWarrior;
			super.attackMin = attackWarrior - 5;
			super.skillMax = skillWarrior;
			super.skillMin = skillWarrior - 5;
			super.hp = 100;
			super.mana = 150;
		} else if (job.equalsIgnoreCase("Mage")) {
			super.attackMax = attackMage;
			super.attackMin = attackMage - 5;
			super.skillMax = skillMage;
			super.skillMin = skillMage - 5;
			super.hp = 100;
			super.mana = 150;
		} else if (job.equalsIgnoreCase("Archer")) {
			super.attackMax = attackArcher;
			super.attackMin = attackArcher - 5;
			super.skillMax = skillArcher;
			super.skillMin = skillArcher - 5;
			super.hp = 100;
			super.mana = 150;
		}
	}
	
	@Override
	public String skill() {
		if (job.equalsIgnoreCase("Warrior")) {
			return "Warcry";
		} else if (job.equalsIgnoreCase("Mage")) {
			return "Fireball";
		} else {
			return "Charge Shot";
		}
	}

	@Override
	public String weapon() {
		if (job.equalsIgnoreCase("Warrior")) {
			return "Sword";
		} else if (job.equalsIgnoreCase("Mage")) {
			return "Mystic Staff";
		} else {
			return "Bow";
		}
	}
}
