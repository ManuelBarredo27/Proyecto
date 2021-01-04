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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelsWindow extends JPanel implements ActionListener, KeyListener{

	JFrame window = new JFrame();
	String[] s = {"Suma","Resta","Multiplicación"};
	JComboBox nameOfLevels = new JComboBox(s);
	JButton enterButton = new JButton();
	JButton backButton = new JButton();
	
	Font customFont = new Font("Bold",Font.BOLD,30);
	Font comboFont = new Font("Italic",Font.ITALIC,25);
	
		
	LevelsWindow(){
		
		try {
			File sound = new File("sounds//trumpet_x.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		
		}catch(Exception e) {System.out.println(e);}
		
		this.setBackground(Color.BLACK);
		window.add(this);
		
		nameOfLevels.setFont(comboFont);
		nameOfLevels.setForeground(Color.WHITE);
		nameOfLevels.setBackground(Color.DARK_GRAY);
		window.add(nameOfLevels,BorderLayout.PAGE_START);		
		
		
		backButton.setFont(customFont);
		backButton.setText("Regresar");
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.DARK_GRAY);
		backButton.addKeyListener(this);
		backButton.addActionListener(this);
		window.add(backButton,BorderLayout.PAGE_END);
		 
		enterButton.setIcon(new ImageIcon("images//openingImg.jpg"));
		enterButton.addKeyListener(this);
		enterButton.addActionListener(this);
		window.add(enterButton,BorderLayout.CENTER);
		
		window.setUndecorated(true);
		window.setSize(430,765);
		window.setLocation(560,10);
		window.setVisible(true);
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE){
			window.dispose();
			Menu m = new Menu();
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==0) {
			Operacion op = new Operacion();
			
			//BasicLevel bl = new BasicLevel();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==1) {
			OperacionR op = new OperacionR();
			//RestaLevel rl = new RestaLevel();
			//JOptionPane.showMessageDialog(null,"Nivel intermedio no listo");
		}
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==2) {
			OperacionM op = new OperacionM();
			//JOptionPane.showMessageDialog(null, "Nivel avanzado en mantenimiento");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==backButton) {
			window.dispose();
			Menu m = new Menu();
		}
		
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==0) {
			Operacion op = new Operacion();
			
			//BasicLevel bl = new BasicLevel();
		}
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==1) {
			OperacionR op = new OperacionR();
			//RestaLevel rl = new RestaLevel();
			//JOptionPane.showMessageDialog(null, "Nivel intermedio en mantenimiento");
		}
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==2) {
			OperacionM op = new OperacionM();
			//JOptionPane.showMessageDialog(null, "Nivel avanzado en mantenimiento");
		}
		
	}
	
}
