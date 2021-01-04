package shootGhosts;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BasicLevel extends JPanel implements KeyListener {
	
	JFrame window = new JFrame("Suma Level");
	Shooter shooter = new Shooter(180,698,"images/user.png");
	Ghost[][] ghosts = new Ghost[6][6];
	int xAxis=0;
	int yAxis=0;
	Bullet[] bullets = new Bullet[1000];
	int count = 0;
	Dropper dropper = new Dropper(this,ghosts);
	private boolean fail = false;
	
	
	BasicLevel() {
		
		this.setFocusable(true);
		this.addKeyListener(this);
		
		window.add(this);
		
		try {
			File sound = new File("sounds//ufo_x.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		
		}catch(Exception e) {System.out.println(e);}
		
		for(int i=0; i<ghosts.length; i++) 
		{
			for(int j=0 ; j<ghosts[i].length; j++) 
			{
				ghosts[i][j] = new Ghost(xAxis,yAxis,"images/enemy.png");
				xAxis +=90;
			}
			yAxis +=90;
			xAxis = 0;
		}
		
		dropper.start();
		
		for(int i=0; i<bullets.length; i++) 
		{
			
			bullets[i] = new Bullet(180,780,"images/disparo.png");
		}
		
		window.setUndecorated(true);
		window.setSize(431,765);
		window.setLocation(560,10);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	
	public void paint(Graphics g) {
		ImageIcon background = new ImageIcon("images/basico.jpg");
		g.drawImage(background.getImage(),0,0,null);
		
		shooter.drawShooter(g);
		
		for(int i=0; i<ghosts.length; i++)
		{
			for(int j=0; j<ghosts[i].length; j++)
			{
				ghosts[i][j].drawGhost(g);
			}
		}
		
		for(int i=0; i<bullets.length; i++)
		{	
			bullets[i].drawBullet(g);
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("",Font.BOLD,22));
		g.drawString("Score: "+Fire.score, 135, 20);
		levelFailed();
		levelComplete();
		
	}
	
	
	
	public void levelComplete(){
		if(Fire.score>=30)
		{
			window.dispose();
			dropper.stop();
			JOptionPane.showMessageDialog(null, "Nivel completado");
			
		}
	}
	
	public void levelFailed()
	{
		for(int i=0; i<ghosts.length; i++)
		{
			for(int j=0; j<ghosts[i].length; j++)
			{
				if(ghosts[i][j].getyAxis()>820)
				{
					fail = true;
					dropper.stop();
					break;
				}
			}
		}
		if(fail==true)
		{
			window.dispose();
			JOptionPane.showMessageDialog(null, "Juego Terminado");
		
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(shooter.getxAxis()<350)
				shooter.setxAxis(shooter.getxAxis()+6);
			this.repaint();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(shooter.getxAxis()>0)
			{
				shooter.setxAxis(shooter.getxAxis()-6);
			}
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_SPACE)
		{
			try {
				File sound = new File("sounds//shot1.wav");
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			
			}catch(Exception e) {System.out.println(e);}
			
			Fire f = new Fire(bullets[count],this,ghosts);
			bullets[count].setxAxis(shooter.getxAxis()+15);
			bullets[count].setyAxis(shooter.getyAxis()+10);
			
			f.start();
			count++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
