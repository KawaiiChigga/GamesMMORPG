package view;

import javax.swing.JFrame;

public class Home extends JFrame {
	public Home() {
		initHome();
	}
	
	private void initHome() {
		add(new HomeDisplay(this));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
