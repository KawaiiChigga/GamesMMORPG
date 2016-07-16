package model.character;

import java.util.ArrayList;

import model.item.Item;

public class Human extends Character {
	public String job;
	public double exp, gold;
	public int level;
	public ArrayList <Item> inventory;
	
	public Human(String name, String job) {
		super(name);
		this.job = job;
		this.exp = 0;
		this.gold = 0;
		this.level = 1;
		if (job.equalsIgnoreCase("Warrior")) {
			super.attack = 15;
			super.hp = 100;
			super.mana = 150;
		} else if (job.equalsIgnoreCase("Mage")) {
			super.attack = 10;
			super.hp = 100;
			super.mana = 150;
		} else if (job.equalsIgnoreCase("Archer")) {
			super.attack = 8;
			super.hp = 100;
			super.mana = 150;
		}
	}
	
	@Override
	public String skill() {
		if (job.equalsIgnoreCase("Warrior")) {
			return "Warcry";
		} else if (job.equalsIgnoreCase("Mage")) {
			return "Heal";
		} else {
			return "Fireshot";
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

	@Override
	public void printData() {
		System.out.println("Nama : " + this.name);
		System.out.print("Job : " + this.job);
		System.out.println(", lvl : " + this.level);
		System.out.println("Attack : " + (this.level * (0.1 * this.attack) + this.attack));
		System.out.println("HP : " + this.hp);
		System.out.println("Mana : " + this.mana);
		System.out.println("Skill : " + skill());
		System.out.println("Weapon : " + weapon());
	}
}
