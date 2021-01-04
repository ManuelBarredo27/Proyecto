package shootGhosts;

import java.awt.Graphics; 
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpeningWindow extends JPanel{
	
	JFrame window = new JFrame();
	
	OpeningWindow() {
		window.add(this);

		try {
			File sound = new File("sounds//laser_x.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		
		}catch(Exception e) {System.out.println(e);}
		
		window.setLocation(560,10); 
		window.setUndecorated(true);
		window.setSize(430,765);
		window.setVisible(true);
		
		try {
			Thread.sleep(4000);
			window.dispose();
			Menu m = new Menu();
		}catch(Exception e){System.out.println(e);}
	}
	
	public void paint(Graphics g) {
		ImageIcon background = new ImageIcon("images//space.jpg");
		
		g.drawImage(background.getImage(),0,0,null);
		
	}
	
}
