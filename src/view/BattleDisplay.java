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
import model.character.Character;

public class BattleDisplay extends JPanel {

	private final int BG_WIDTH = 710;
	private final int BG_HEIGHT = 410;
	private final int BTN_WIDTH = 300;
	private final int BTN_HEIGHT = 50;
	
	private Image bg;
	private JFrame frame;
	private ImageIcon imgH, imgE;
	
	private String map;
	private Human player;
	private Character enemy;
	
	private Random r = new Random();
	
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
		
//		imgH = new ImageIcon("img/" + player.getJob() + "_left.png");
//		System.out.println(player.getJob());
		
		ImageIcon img = new ImageIcon("img/"+ map + ".png");
		bg = img.getImage();
		
		setLayout(null);
		
//		JLabel lblHP = new JLabel(player.getHp()+ "");
		JLabel lblHP = new JLabel("100" + " / ");
		lblHP.setForeground(Color.WHITE);
		lblHP.setFont(new Font("Agency FB", Font.BOLD, 70));
		lblHP.setBounds(10,320,150,100);
		add(lblHP);
		
//		JLabel lblMP = new JLabel(player.getHp()+ "");
		JLabel lblMP = new JLabel("100");
		lblMP.setForeground(Color.WHITE);
		lblMP.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblMP.setBounds(135,330,100,100);
		add(lblMP);
		
		JButton btnAtt = new JButton("Attack");
		btnAtt.setForeground(Color.WHITE);
		btnAtt.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnAtt.setContentAreaFilled(false);
		btnAtt.setBorderPainted(false);
		btnAtt.setBounds(180,300,100,100);
		add(btnAtt);
		btnAtt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int dmg = r.nextInt(player.getAttackMax()- player.getAttackMin()) + player.getAttackMin();
				enemy.setHp(enemy.getHp()-dmg);
				System.out.println(enemy.getHp());
			}
		});
		
		JButton btnSkill = new JButton("Skill");
		btnSkill.setForeground(Color.WHITE);
		btnSkill.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnSkill.setContentAreaFilled(false);
		btnSkill.setBorderPainted(false);
		btnSkill.setBounds(180,340,100,100);
		add(btnSkill);
		btnSkill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int dmg = r.nextInt(player.getSkillMax()- player.getSkillMin()) + player.getSkillMin();
				enemy.setHp(enemy.getHp()-dmg);
				System.out.println(enemy.getHp());
			}
		});
		
		
//		JLabel lblHPenemy = new JLabel(enemy.getHp()+ "");
		JLabel lblHPenemy = new JLabel("100");
		lblHPenemy.setForeground(Color.WHITE);
		lblHPenemy.setFont(new Font("Agency FB", Font.BOLD, 70));
		lblHPenemy.setBounds(620,320,100,100);
		add(lblHPenemy);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
}
