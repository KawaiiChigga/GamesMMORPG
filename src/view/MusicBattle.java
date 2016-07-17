package view;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class MusicBattle extends JFrame{
	public Clip clip;
	
	public MusicBattle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MUSICBACKGROUND");
		setSize(300, 200);
		setVisible(false);

		URL url = getClass().getClassLoader().getResource("bgSound.wav");
		try {
			AudioInputStream audioIS = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioIS);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

