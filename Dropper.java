package shootGhosts;

public class Dropper extends Thread{
	
	BasicLevel l1;
	Ghost[][] ghosts;
	
	Dropper(BasicLevel l1, Ghost[][] ghosts)
	{
		this.ghosts = ghosts;
		this.l1 = l1;
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
		l1.repaint();
		
		}
	}
	
	
}
