package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.character.Human;

public class ChooseCharacterDisplay extends JPanel{
	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	
	private JFrame frame;
	private String name;
	private String job;
	public ChooseCharacterDisplay(JFrame frame, String name){
		this.frame = frame;
		this.name = name;
		initChooseCharacterDisplay();
	}
	
	private void initChooseCharacterDisplay() {
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setFocusable(true);
		setLayout(null);
		setBackground(Color.WHITE);
		
		Human player = new Human(name, "Warrior");
		frame.dispose();
		new Chars("Village", player);
		
	}
}
