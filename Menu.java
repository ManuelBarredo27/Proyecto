package shootGhosts;

import java.awt.BorderLayout; 

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener, KeyListener {
	
	JFrame window = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	//JButton backgroundButton = new JButton();
	JLabel centerImageLabel = new JLabel();
	//JLabel infoLabel = new JLabel();
	
	Font customFont = new Font("Italic",Font.ITALIC,22); 
	
	Menu(){
		
		try {
			File sound = new File("sounds//radio_tuner_y.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		
		}catch(Exception e) {System.out.println(e);}
		
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		
		window.add(this);
		
		playButton.setBackground(Color.WHITE);
		playButton.setIcon(new ImageIcon("images//play.png"));
		playButton.addActionListener(this);
		playButton.addKeyListener(this);
		window.add(playButton, BorderLayout.PAGE_END);
		
		exitButton.setBackground(Color.WHITE);
		exitButton.setIcon(new ImageIcon("images//exit.png"));
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this);
		window.add(exitButton, BorderLayout.PAGE_START);
		
		/*backgroundButton.setBackground(Color.BLACK);
		backgroundButton.setIcon(new ImageIcon("images//maythe4th.png"));
		backgroundButton.addActionListener(this);
		backgroundButton.addKeyListener(this);
		window.add(backgroundButton, BorderLayout.WEST);*/
		
		
		/*//Texto en pantalla
		infoLabel.setText("Press S' to shoot");
		infoLabel.setFont(customFont);
		infoLabel.setOpaque(true);
		infoLabel.setBackground(Color.LIGHT_GRAY);
		infoLabel.setForeground(Color.BLACK);
		window.add(infoLabel,BorderLayout.EAST);*/
		
		centerImageLabel.setBackground(Color.BLACK);
		centerImageLabel.setIcon(new ImageIcon("images//menu.jpg"));
		window.add(centerImageLabel,null);
		
		window.setLocation(560,10); 
		window.setUndecorated(true);
		window.setSize(430,765);
		window.setVisible(true);
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE) {
			window.dispose();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER) {
			window.dispose();
			LevelsWindow lw = new LevelsWindow();
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exitButton) {
			window.dispose();
		}
		else if(ae.getSource()==playButton) {
			window.dispose();
			LevelsWindow lw = new LevelsWindow();
		}
	}

}
