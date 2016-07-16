package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class CharsDisplay extends JPanel implements Runnable{

	private final int BG_WIDTH = 640;
	private final int BG_HEIGHT = 480;
	private final int BTN_WIDTH = 300;
	private final int BTN_HEIGHT = 50;
	
	private int x;
	private int y;
	private String tmp;
	
	private Image bg;
	private JFrame frame;
	private JLabel human;
	private JLabel enemy;
	private JButton back;
	
	private Thread th = null;
	
	public CharsDisplay(JFrame frame, String tmp){
		this.tmp = tmp;
		this.frame = frame;
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
		
		back = new JButton("Back");
		back.setBounds(540, 460, 100, 20);
		
		human = new JLabel();
		
		enemy = new JLabel();
		if (tmp.equals("Graveyard")) {
			ImageIcon img = new ImageIcon("img/gy.png");
			bg = img.getImage();
			x = 300;
			y = 400;
			
			human.setIcon(new ImageIcon("img/human_right.png"));
			human.setBounds(x,y,44,79);
			
			ImageIcon imgE = new ImageIcon("img/ghost.png");
			enemy.setIcon(imgE);
			enemy.setBounds(490,130,imgE.getIconWidth(),imgE.getIconHeight());
			
		} else if (tmp.equals("Hill")) {
			ImageIcon img = new ImageIcon("img/hill.jpg");
			bg = img.getImage();
			x = 70;
			y = 200;
			
			human.setIcon(new ImageIcon("img/human_right.png"));
			human.setBounds(x,y,44,79);
			
			ImageIcon imgE = new ImageIcon("img/goblin.png");
			enemy.setIcon(imgE);
			enemy.setBounds(490,190,img.getIconWidth(),img.getIconHeight());
			
		} else if (tmp.equals("Jungle")) {
			ImageIcon img = new ImageIcon("img/jungle.png");
			bg = img.getImage();
			x = 300;
			y = 100;
			
			human.setIcon(new ImageIcon("img/human_left.png"));
			human.setBounds(x,y,44,79);
			
			ImageIcon imgE = new ImageIcon("img/insect.png");
			enemy.setIcon(imgE);
			enemy.setBounds(180,200,imgE.getIconWidth(),imgE.getIconHeight());
						
		} else if (tmp.equals("Village")) {
			ImageIcon img = new ImageIcon("img/village.png");
			bg = img.getImage();
			x = 10;
			y = 100;
			
			human.setIcon(new ImageIcon("img/human_right.png"));
			human.setBounds(x,y,44,79);
			
			enemy.setIcon(new ImageIcon("img/villagehuman.png"));
			enemy.setBounds(510,0,img.getIconWidth(),img.getIconHeight());
		}
		
		back.addActionListener(new CharsDisplay.button());
		
		add(human);
		add(enemy);
		add(back);
	}
	
	public void checkIntersect() {

		Rectangle r1 = human.getBounds();
		Rectangle r2 = enemy.getBounds();
		// rectangel utk tau pinggiran bound nya
		
		// intersects buat check bersentuhan
		if (r2.intersects(r1)) {
			new Battle(tmp);
			frame.dispose();
			}
		} 
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		human.setBounds(x,y,44,79);
		Toolkit.getDefaultToolkit().sync();
	}
	private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	
        }

        public void keyPressed(KeyEvent e) {
        	checkIntersect();
    		if (e.getKeyCode() == KeyEvent.VK_UP){
    			y -= 5;
    		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
    			y += 5;
    		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    			human.setIcon(new ImageIcon("img/human_left.png"));
    			x -= 5;
    		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    			human.setIcon(new ImageIcon("img/human_right.png"));
    			x += 5;
    		}
    		if (x < 0) {
    			x = 0;
    		} else if (x > BG_WIDTH - 44) {
    			x = BG_WIDTH - 44;
    		}
    		if (y < 0) {
    			y = 0;
    		} else if ( y > BG_HEIGHT - 79) {
    			y = BG_HEIGHT - 79;
    		}
        }
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
	
	public class button implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new Maps();
			frame.dispose();
		}
		
	}

}
