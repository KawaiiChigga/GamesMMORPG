package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BattleDisplay extends JPanel {

	private final int BG_WIDTH = 1024;
	private final int BG_HEIGHT = 576;
	private final int BTN_WIDTH = 300;
	private final int BTN_HEIGHT = 50;
	
	private Image bg;
	private JFrame frame;
	private String map;
	
	public BattleDisplay(JFrame frame, String map){
		this.frame = frame;
		this.map = map;
		initBattleDisplay();
	}
	
	private void initBattleDisplay(){
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setBackground(Color.BLACK);
		
		ImageIcon img = new ImageIcon("img/coba.jpg");
		bg = img.getImage();
		
		setLayout(null);
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
}
