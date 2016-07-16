package view;

import javax.swing.JFrame;

public class Battle extends JFrame {

	private String map;
	
	public Battle(String map){
		this.map = map;
		initBattle();
		
	}
	
	private void initBattle(){
		add(new BattleDisplay(this, map));
		setResizable(false);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
