package view;

import java.awt.Color;
import java.awt.Dimension;
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

public class HomeDisplay extends JPanel{
	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	
	private Image bg;
	private JFrame frame;
	private JButton btnPlay;
	private JButton btnExit;
	
	public HomeDisplay(JFrame frame) {
		this.frame = frame;
		
		initDisplay();
	}
	
	private void initDisplay() {
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setFocusable(true);
		setLayout(null);
		setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon("img/home.png");
		bg = img.getImage();
		
		btnPlay = new JButton();
		btnPlay.setText("Play");
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBounds(305, 250, 100, 40);
		
		btnExit = new JButton();
		btnExit.setText("Exit");
		btnExit.setContentAreaFilled(false);
		btnExit.setBounds(305, 300, 100, 40);
		
		add(btnPlay);
		add(btnExit);
		
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog(null, "Name : ", "Insert Name", JOptionPane.PLAIN_MESSAGE);
				if (name.equals("")) {
					name = "noname";
				}
				new ChooseCharacter(name);
				frame.dispose();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		Toolkit.getDefaultToolkit().sync();
	}
}
