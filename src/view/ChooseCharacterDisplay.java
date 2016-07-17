package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.character.Human;

public class ChooseCharacterDisplay extends JPanel implements Runnable{
	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	
	private JFrame frame;
	private String name;
	private JButton ok;
	private JButton next;
	private JButton prev;
	private JLabel job;
	private JLabel title;
	private JLabel gbr;
	private ImageIcon jobPlayer;
	private JPanel pnlJob;
	
	private Thread th;
	
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
		
		title = new JLabel("Choose Your Character");
		title.setBounds(0, 50, 710, 100);
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Agency FB", Font.BOLD, 40));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		pnlJob = new JPanel();
		pnlJob.setBounds(255, 330, 200, 30);
		pnlJob.setLayout(new BorderLayout(20, 0));
		pnlJob.setOpaque(false);
		
		job = new JLabel();
		job.setText("Warrior");
		job.setHorizontalAlignment(JLabel.CENTER);
		pnlJob.add("Center", job);
		
		next = new JButton();
		next.setText(">");
		next.setContentAreaFilled(false);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (job.getText().equals("Warrior")){
					job.setText("Archer");
				} else if (job.getText().equals("Archer")) {
					job.setText("Mage");
				} else if (job.getText().equals("Mage")) {
					job.setText("Warrior");
				}
			}
		});
		pnlJob.add("East", next);
		
		prev = new JButton();
		prev.setText("<");
		prev.setContentAreaFilled(false);
		prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (job.getText().equals("Warrior")){
					job.setText("Mage");
				} else if (job.getText().equals("Archer")) {
					job.setText("Warrior");
				} else if (job.getText().equals("Mage")) {
					job.setText("Archer");
				}
			}
		});
		pnlJob.add("West", prev);
		
		jobPlayer = new ImageIcon("img/" + job.getText() + "_right.png");
		gbr = new JLabel();
		gbr.setIcon(jobPlayer);
		gbr.setBounds((BG_WIDTH/2) - jobPlayer.getIconWidth(), 220, jobPlayer.getIconWidth(), jobPlayer.getIconHeight());
		
		
		ok = new JButton();
		ok.setBounds(305, 370, 100, 20);
		ok.setText("OK");
		ok.setContentAreaFilled(false);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Human player = new Human(name, job.getText());
				new Chars("Village", player);
				frame.dispose();
			}
		});
		add(title);
		add(gbr);
		add(pnlJob);
		add(ok);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		jobPlayer = new ImageIcon("img/" + job.getText() + "_right.png");
		gbr.setIcon(jobPlayer);
		gbr.setBounds((BG_WIDTH/2) - (jobPlayer.getIconWidth()/2), 220, jobPlayer.getIconWidth(), jobPlayer.getIconHeight());
		Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void run() {
		while (true) {
			repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
	}
}
