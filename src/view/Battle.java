package view;

import javax.swing.JFrame;

import model.character.Human;
import model.character.BlackHood;
import model.character.Character;
import model.character.Ghost;
import model.character.Goblin;

public class Battle extends JFrame {

	private String map;
	private Human player;
	private Character enemy;
	
	public Battle(String map, Human player){
		this.map = map;
		this.player = player;
		
		if(map.equalsIgnoreCase("Jungle")){
			enemy = new BlackHood("BlackHood");
		}else if(map.equalsIgnoreCase("Hill")){
			enemy = new Goblin("Goblin");
		}else if(map.equalsIgnoreCase("Graveyard")){
			enemy = new Ghost("Ghost");
		}
		
		initBattle();
		
	}
	
	private void initBattle(){
		add(new BattleDisplay(this, map, player, enemy));
		setResizable(false);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
