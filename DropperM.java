package shootGhosts;

public class DropperM extends Thread{
	
	MultLevel ml;
	Ghost[][] ghosts;
	
	DropperM(MultLevel ml, Ghost[][] ghosts)
	{
		this.ghosts = ghosts;
		this.ml = ml;
	}
	
	public void run()
	{
		while(ghosts[0][0].getyAxis()<700)
		{
		for(int i=0; i<ghosts.length; i++)
		{
			for(int j=0; j<ghosts[i].length; j++)
				{
				ghosts[i][j].setyAxis(ghosts[i][j].getyAxis()+12);
				System.out.println(ghosts[i][j].getyAxis());
				}
		}
		try {
			Thread.sleep(900);
		}catch(Exception e) {System.out.println(e);}
		ml.repaint();
		
		}
	}
	
	
}
