package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.character.Human;



public class CharsDisplay extends JPanel implements Runnable{

	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	
	private static int x;
	private static int y;
	private String tmp;
	private Human player;
	
	public static boolean isDieGoblin;
	public static boolean isDieBlackHood;
	public static boolean isDieGhost;
	
	private Image bg;
	private ImageIcon imgH_left;
	private ImageIcon imgH_right;
	private static ImageIcon imgH;
	private JFrame frame;
	private JLabel human;
	private JLabel enemy;
	
	private Thread th = null;
	private static boolean ingame;
	
	public CharsDisplay(JFrame frame, String tmp, Human player){
		ingame = true;
		this.tmp = tmp;
		this.frame = frame;
		this.player = player;
		setFocusable(true);
		addKeyListener(new TAdapter());
		
		initDisplay();
	}
	
	private void initDisplay(){
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setBackground(Color.BLACK);
		
		th = new Thread(this);
		th.start();
		
		setLayout(null);
		
		human = new JLabel();
		y = 250;
		imgH_left = new ImageIcon("img/" + player.getJob() + "_left.png");
		imgH_right = new ImageIcon("img/" + player.getJob() + "_right.png");
		
		enemy = new JLabel();
		if (tmp.equals("Graveyard")) {
			ImageIcon img = new ImageIcon("img/graveyard.png");
			bg = img.getImage();
			
			human.setIcon(imgH);
			human.setBounds(x,y,imgH.getIconWidth(),imgH.getIconHeight());
			
			ImageIcon imgE = new ImageIcon("img/ghost.png");
			enemy.setIcon(imgE);
			if (isDieGhost) {
				enemy.setVisible(false);
				ingame = false;
			} else {
				enemy.setVisible(true);
				enemy.setBounds(650,y,imgE.getIconWidth(),imgE.getIconHeight());
			}
			
		} else if (tmp.equals("Hill")) {
			ImageIcon img = new ImageIcon("img/hill.png");
			bg = img.getImage();
			
			human.setIcon(imgH);
			human.setBounds(x,y,imgH.getIconWidth(),imgH.getIconHeight());
			
			ImageIcon imgE = new ImageIcon("img/goblin.png");
			enemy.setIcon(imgE);
			if (isDieGoblin) {
				enemy.setVisible(false);
			} else {
				enemy.setVisible(true);
				enemy.setBounds(650,y,imgE.getIconWidth(),imgE.getIconHeight());
			}
			
		} else if (tmp.equals("Jungle")) {
			ImageIcon img = new ImageIcon("img/jungle.png");
			bg = img.getImage();
			
			human.setIcon(imgH);
			human.setBounds(x,y,imgH.getIconWidth(),imgH.getIconHeight());
			
			ImageIcon imgE = new ImageIcon("img/blackhood.png");
			enemy.setIcon(imgE);
			if (isDieBlackHood) {
				enemy.setVisible(false);
			} else {
				enemy.setVisible(true);
				enemy.setBounds(650,y,imgE.getIconWidth(),imgE.getIconHeight());
			}
						
		} else if (tmp.equals("Village")) {
			ImageIcon img = new ImageIcon("img/village.png");
			bg = img.getImage();
			
			if (imgH == null) {
				imgH = imgH_right;
				x = 355;
			}
			player.setHp(player.getMaxHp());
			player.setMana(player.getMaxMp());
			isDieGoblin = false;
			isDieBlackHood = false;
			isDieGhost = false;
			
			human.setIcon(imgH);
			human.setBounds(x,y,imgH.getIconWidth(),imgH.getIconHeight());
		}
		add(human);
		add(enemy);
	}
	
	public void checkIntersect() {

		Rectangle r1 = human.getBounds();
		Rectangle r2 = enemy.getBounds();
		// rectangel utk tau pinggiran bound nya
		
		// intersects buat check bersentuhan
		if (r2.intersects(r1)) {
				new Battle(tmp, player);
				frame.dispose();
			}
		} 
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		human.setBounds(x,y,imgH_left.getIconWidth(),imgH_right.getIconHeight());
		Toolkit.getDefaultToolkit().sync();
	}
	private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	
        }

        public void keyPressed(KeyEvent e) {
        	checkIntersect();
    		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    			imgH = imgH_left;
    			human.setIcon(imgH);
    			x -= 8;
    		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    			imgH = imgH_right;
    			human.setIcon(imgH);
    			x += 8;
    		}
    		if (x < 0) {
    			if (tmp.equals("Village")) {
    				x = 0;
    			} else if (tmp.equals("Jungle")) {
    				new Chars("Village", player);
    				frame.dispose();
    				x = BG_WIDTH - imgH_left.getIconWidth();
    				imgH = imgH_left;
    			} else if (tmp.equals("Hill")) {
    				new Chars("Jungle", player);
    				frame.dispose();
    				x = BG_WIDTH - imgH_left.getIconWidth();
    				imgH = imgH_left;
    			} else if (tmp.equals("Graveyard")) {
    				new Chars("Hill", player);
    				frame.dispose();
    				x = BG_WIDTH - imgH_left.getIconWidth();
    				imgH = imgH_left;
    			}
    		} else if (x > BG_WIDTH - imgH_left.getIconWidth()) {
    			if (tmp.equals("Village")) {
    				new Chars("Jungle", player);
    				x = 0;
    				imgH = imgH_right;
    				frame.dispose();
    			} else if (tmp.equals("Jungle")) {
    				new Chars("Hill", player);
    				x = 0;
    				imgH = imgH_right;
    				frame.dispose();
    			} else if (tmp.equals("Hill")) {
    				new Chars("Graveyard", player);
    				x = 0;
    				imgH = imgH_right;
    				frame.dispose();
    			} else if (tmp.equals("Graveyard")) {
    				x = BG_WIDTH - imgH_left.getIconWidth();
    			}
    		}
        }
    }

	@Override
	public void run() {
		while (ingame) {
			repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
		System.exit(0);
	}
}
