package model.character;

import java.util.ArrayList;


public class Human extends Character implements HumanDefault {
	private String job;
	private double exp = 0;
	private int level = 1;
	private int maxHp, maxMp;
	private int manaCost;
	
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

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
			maxHp = hpWarrior;
			maxMp = manaWarrior;
			super.hp = hpWarrior;
			super.mana = manaWarrior;
			manaCost = manaSkillWarrior;
		} else if (job.equalsIgnoreCase("Mage")) {
			super.attackMax = attackMage;
			super.attackMin = attackMage - 5;
			super.skillMax = skillMage;
			super.skillMin = skillMage - 5;
			maxHp = hpMage;
			maxMp = manaMage;
			super.hp = hpMage;
			super.mana = manaMage;
			manaCost = manaSkillMage;
		} else if (job.equalsIgnoreCase("Archer")) {
			super.attackMax = attackArcher;
			super.attackMin = attackArcher - 5;
			super.skillMax = skillArcher;
			super.skillMin = skillArcher - 5;
			maxHp = hpArcher;
			maxMp = manaArcher;
			super.hp = hpArcher;
			super.mana = manaArcher;
			manaCost = manaSkillArcher;
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
