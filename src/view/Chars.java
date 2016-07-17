package view;

import javax.swing.JFrame;

import model.character.Human;

public class Chars extends JFrame {
	private String tmp;
	private Human player;
	public Chars(String tmp, Human player) {
		this.tmp = tmp;
		this.player = player;
		initChars();
	}

	private void initChars() {
		add(new CharsDisplay(this, tmp, player));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
