package shootGhosts;

public class DropperR extends Thread{
	
	RestaLevel rl;
	Ghost[][] ghosts;
	
	DropperR(RestaLevel rl, Ghost[][] ghosts)
	{
		this.ghosts = ghosts;
		this.rl = rl;
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
		rl.repaint();
		
		}
	}
	
	
}
