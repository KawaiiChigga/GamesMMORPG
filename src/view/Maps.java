package view;

import javax.swing.JFrame;


public class Maps extends JFrame {

	public Maps(){
		initMaps();
	}
	
	private void initMaps(){
		add(new MapsDisplay(this));
		setResizable(false);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
