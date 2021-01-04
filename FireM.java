package shootGhosts;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class FireM extends Thread{
	
	Bullet bullet;
	MultLevel ml;
	Ghost[][] ghost;
	public static int score = 0;
	
	FireM(Bullet bullet, MultLevel ml, Ghost[][] ghost)
	{
		this.bullet = bullet;
		this.ml = ml;
		this.ghost = ghost;
	}
	
	@Override
	public void run() 
	{
		while(bullet.getyAxis()>-100)
		{
			bullet.setyAxis(bullet.getyAxis()-40);
			checkCollision();
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			ml.repaint();
		}
	}
	
	public void checkCollision()
	{
		Rectangle bulletRect = new Rectangle(bullet.getxAxis(),bullet.getyAxis(),22,22);
		
		for(int i = 0; i<ghost.length; i++)
		{
			for(int j=0; j<ghost[i].length; j++)
			{
				Rectangle ghostRect = new Rectangle(ghost[i][j].getxAxis(),ghost[i][j].getyAxis(),48,48);
				if(bulletRect.intersects(ghostRect))
				{
					ghost[i][j].setxAxis(5000000);
					bullet.setxAxis(-5000);
					score++;
					try {
						File sound = new File("sounds//explosion.wav");
						AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
						Clip clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
					
					}catch(Exception e) {System.out.println(e);}
				}
			}
		}
	}	

}
