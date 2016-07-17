package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.character.Human;
import model.character.HumanDefault;
import model.character.Character;

public class BattleDisplay extends JPanel implements Runnable, HumanDefault {

	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	private final int BTN_WIDTH = 300;
	private final int BTN_HEIGHT = 50;

	private Image bg;
	private JFrame frame;
	private ImageIcon imgH, imgE;
	private JLabel lblHP, lblMP, lblLvl, lblHPenemy, lblMPenemy, lblH, lblE;
	private JButton btnAtt, btnSkill;
	private boolean inGame;
	private boolean playerTurn;
	private String src;

	private String map;
	private Human player;
	private Character enemy;

	private Thread th;

	private Random r = new Random();

	MusicBattle background;

	public BattleDisplay(JFrame frame, String map, Human player, Character enemy) {
		background = new MusicBattle();
		inGame = true;
		playerTurn = true;
		this.frame = frame;
		this.map = map;
		this.player = player;
		this.enemy = enemy;
		initBattleDisplay();
	}

	private void initBattleDisplay() {
		setPreferredSize(new Dimension(BG_WIDTH, BG_HEIGHT));
		setBackground(Color.BLACK);

		th = new Thread(this);
		th.start();

		imgH = new ImageIcon("img/" + player.getJob() + "_right.png");
		lblH = new JLabel();
		lblH.setIcon(imgH);
		lblH.setBounds(50, 200, imgH.getIconWidth(), imgH.getIconHeight());
		add(lblH);

		if (map.equalsIgnoreCase("Jungle")) {
			src = "img/blackhood.png";
		} else if (map.equalsIgnoreCase("Hill")) {
			src = "img/goblin.png";
		} else if (map.equalsIgnoreCase("Graveyard")) {
			src = "img/ghost.png";
		}

		imgE = new ImageIcon(src);
		lblE = new JLabel();
		lblE.setIcon(imgE);
		lblE.setBounds(600, 200, imgE.getIconWidth(), imgE.getIconHeight());
		add(lblE);

		ImageIcon img = new ImageIcon("img/" + map + ".png");
		bg = img.getImage();

		setLayout(null);

		lblHP = new JLabel(player.getHp() + " / ");
		lblHP.setForeground(Color.WHITE);
		lblHP.setFont(new Font("Agency FB", Font.BOLD, 70));
		lblHP.setBounds(10, 320, 150, 100);
		add(lblHP);

		lblLvl = new JLabel("Level " +player.getLevel());
		lblLvl.setForeground(Color.WHITE);
		lblLvl.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblLvl.setBounds(10, 290, 70, 70);
		add(lblLvl);
		
		lblMP = new JLabel(player.getMana() + "");
		lblMP.setForeground(Color.WHITE);
		lblMP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblMP.setBounds(135, 330, 100, 100);
		add(lblMP);

		lblHPenemy = new JLabel(enemy.getHp() + " / ");
		lblHPenemy.setForeground(Color.WHITE);
		lblHPenemy.setFont(new Font("Agency FB", Font.BOLD, 70));
		lblHPenemy.setBounds(520, 320, 170, 100);
		add(lblHPenemy);

		lblMPenemy = new JLabel(enemy.getMana() + "");
		lblMPenemy.setForeground(Color.WHITE);
		lblMPenemy.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblMPenemy.setBounds(660, 330, 100, 100);
		add(lblMPenemy);

		add(btnAtt);
		add(btnSkill);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		lblHPenemy.setText(enemy.getHp() + " / ");
		lblMPenemy.setText(enemy.getMana() + "");
		lblHP.setText(player.getHp() + " / ");
		lblMP.setText(player.getMana() + "");
		Toolkit.getDefaultToolkit().sync();
	}

	public void check() {
		if (player.getHp() <= 0) {
			inGame = false;
			new Chars("Village", player);
			frame.dispose();
		}

		if (enemy.getHp() <= 0) {
			inGame = false;
			if (map.equals("Jungle")) {
				player.setLevel(player.getLevel() + 1);
				player.setMaxHp((int) (player.getMaxHp() * player.increase));
				CharsDisplay.isDieBlackHood = true;
			} else if (map.equals("Hill")) {
				player.setLevel(player.getLevel() + 1);
				player.setMaxHp((int) (player.getMaxHp() * player.increase));
				CharsDisplay.isDieGoblin = true;
			} else if (map.equals("Graveyard")) {
				CharsDisplay.isDieGhost = true;
			}
			new Chars(map, player);
			frame.dispose();
		}
	}

	public void turn() {
		if (playerTurn) {
			btnAtt = new JButton("Attack");
			btnAtt.setForeground(Color.WHITE);
			btnAtt.setFont(new Font("Agency FB", Font.BOLD, 30));
			btnAtt.setContentAreaFilled(false);
			btnAtt.setBorderPainted(false);
			btnAtt.setBounds(180, 330, 100, 30);
			btnAtt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					int dmg = r.nextInt(player.getAttackMax() - player.getAttackMin()) + player.getAttackMin();
					enemy.setHp(enemy.getHp() - dmg);
					playerTurn = false;
				}
			});

			btnSkill = new JButton("Skill");
			btnSkill.setForeground(Color.WHITE);
			btnSkill.setFont(new Font("Agency FB", Font.BOLD, 30));
			btnSkill.setContentAreaFilled(false);
			btnSkill.setBorderPainted(false);
			btnSkill.setBounds(180, 370, 100, 30);
			if (player.getManaCost() > player.getMana()) {
				btnSkill.setVisible(false);
			}
			btnSkill.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					int dmg = r.nextInt(player.getSkillMax() - player.getSkillMin()) + player.getSkillMin();
					enemy.setHp(enemy.getHp() - dmg);
					player.setMana(player.getMana() - player.getManaCost());

					if (player.getManaCost() > player.getMana()) {
						btnSkill.setVisible(false);
					}
					playerTurn = false;
				}
			});
		} else {
			int musuh;
			if (enemy.getManaSkill() > enemy.getMana()) {
				musuh = r.nextInt(3);
			} else {
				musuh = r.nextInt(2);
			}
			if (musuh == 2) { // pake skill
				int skillE = r.nextInt(enemy.getSkillMax() - enemy.getSkillMin()) + enemy.getSkillMin();
				player.setHp(player.getHp() - skillE);
				enemy.setMana(enemy.getMana() - enemy.getManaSkill());
			} else { // attack biasa
				int attackE = r.nextInt(enemy.getAttackMax() - enemy.getAttackMin()) + enemy.getAttackMin();
				player.setHp(player.getHp() - attackE);
			}
			playerTurn = true;
		}
	}

	@Override
	public void run() {
		while (inGame) {
			repaint();
			check();
			turn();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
		}
	}

}
