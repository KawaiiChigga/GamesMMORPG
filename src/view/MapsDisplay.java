package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MapsDisplay extends JPanel {

	
	private final int BG_WIDTH = 1024;
	private final int BG_HEIGHT = 576;
	private final int BTN_WIDTH = 300;
	private final int BTN_HEIGHT = 50;
	
	private Image bg;
	private JFrame frame;
	
	public MapsDisplay(JFrame frame){
		this.frame = frame;
		initMapsDisplay();
	}
	
	private void initMapsDisplay(){
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setBackground(Color.BLACK);
		
		ImageIcon img = new ImageIcon("img/map.jpg");
		bg = img.getImage();
		
		setLayout(null);
		
		JButton graveyard = new JButton("Graveyard");
		JButton hill = new JButton("Hill");
		JButton jungle = new JButton("Jungle");
		JButton village = new JButton("Village");
		
		graveyard.setContentAreaFilled(false);
		graveyard.setBorderPainted(false);
		graveyard.setFont(new Font("Tahoma", Font.BOLD, 30));
		graveyard.setForeground(Color.WHITE);
		graveyard.setBounds(780, 500, BTN_WIDTH, BTN_HEIGHT);
		add(graveyard);
		
		hill.setContentAreaFilled(false);
		hill.setBorderPainted(false);
		hill.setFont(new Font("Tahoma", Font.BOLD, 30));
		hill.setForeground(Color.WHITE);
		hill.setBounds(520, 120, BTN_WIDTH, BTN_HEIGHT);
		add(hill);
		
		jungle.setContentAreaFilled(false);
		jungle.setBorderPainted(false);
		jungle.setFont(new Font("Tahoma", Font.BOLD, 30));
		jungle.setForeground(Color.WHITE);
		jungle.setBounds(350, 400, BTN_WIDTH, BTN_HEIGHT);
		add(jungle);
		
		village.setContentAreaFilled(false);
		village.setBorderPainted(false);
		village.setFont(new Font("Tahoma", Font.BOLD, 30));
		village.setForeground(Color.WHITE);
		village.setBounds(-50, 490, BTN_WIDTH, BTN_HEIGHT);
		add(village);
		
		graveyard.addActionListener(new MapsDisplay.button());
		hill.addActionListener(new MapsDisplay.button());
		jungle.addActionListener(new MapsDisplay.button());
		village.addActionListener(new MapsDisplay.button());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public class button implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String tmp = e.getActionCommand();
			new Chars(tmp);
			frame.dispose();
		}
		
	}
}
