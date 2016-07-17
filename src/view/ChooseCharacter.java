package view;

import javax.swing.JFrame;

public class ChooseCharacter extends JFrame{
	private String name;
	public ChooseCharacter(String name) {
		this.name = name;
		initChooseCharacter();
	}
	
	private void initChooseCharacter() {
		add(new ChooseCharacterDisplay(this, name));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setTitle("Games MMORPG");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
