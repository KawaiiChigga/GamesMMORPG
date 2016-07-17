package model.character;


public class Ghost extends Monster {
	public Ghost(String name) {
		super(name);
		super.hp = hpGhost;
		super.mana = manaGhost;
		super.attackMax = attackGhost;
		super.attackMin = attackGhost - 5;
		super.skillMax = skillGhost;
		super.skillMin = skillGhost - 5;
		super.manaSkill = manaSkillGhost;
	}

	@Override
	public String skill() {
		return "Life Drain";
	}

	@Override
	public String weapon() {
		return null;
	}
}
