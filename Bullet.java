package shootGhosts;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Bullet {
	
	private int xAxis;
	private int yAxis;
	private String imagePath;
	
	public Bullet(int xAxis, int yAxis, String imagePath) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.imagePath = imagePath;
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void drawBullet(Graphics g) {
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage(),xAxis,yAxis,null);
		
	}
	

}
