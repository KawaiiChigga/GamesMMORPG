package view;

import javax.swing.JFrame;

public class Chars extends JFrame {
	private String tmp;
	
	public Chars(String tmp) {
		this.tmp = tmp;
		initChars();
	}

	private void initChars() {
		add(new CharsDisplay(this, tmp, "mage"));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
