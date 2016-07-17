package model.character;

public abstract class Character {
	protected String name;
	protected int hp, mana;
	protected int attackMin, attackMax;
	protected int skillMin, skillMax;
	protected int manaSkill;
	public abstract String skill();
	public abstract String weapon();
	public Character(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getManaSkill() {
		return manaSkill;
	}
	public void setManaSkill(int manaSkill) {
		this.manaSkill = manaSkill;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getAttackMin() {
		return attackMin;
	}
	public void setAttackMin(int attackMin) {
		this.attackMin = attackMin;
	}
	public int getAttackMax() {
		return attackMax;
	}
	public void setAttackMax(int attackMax) {
		this.attackMax = attackMax;
	}
	public int getSkillMin() {
		return skillMin;
	}
	public void setSkillMin(int skillMin) {
		this.skillMin = skillMin;
	}
	public int getSkillMax() {
		return skillMax;
	}
	public void setSkillMax(int skillMax) {
		this.skillMax = skillMax;
	}
	
}
