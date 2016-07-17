package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.character.Human;
import model.character.Character;

public class BattleDisplay extends JPanel {

	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	private final int BTN_WIDTH = 300;
	private final int BTN_HEIGHT = 50;
	
	private Image bg;
	private JFrame frame;
	private JButton btn1;
	
	private String map;
	private Human player;
	private Character enemy;
	
	
	public BattleDisplay(JFrame frame, String map, Human player, Character enemy ){
		this.frame = frame;
		this.map = map;
		this.player = player;
		this.enemy = enemy;
		initBattleDisplay();
	}
	
	private void initBattleDisplay(){
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setBackground(Color.BLACK);
		
		
		
		ImageIcon img = new ImageIcon("img/"+ map + ".png");
		bg = img.getImage();
		
		setLayout(null);
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
}
