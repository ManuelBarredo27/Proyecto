package shootGhosts;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OperacionM extends JPanel implements ActionListener {
	
	JFrame window = new JFrame();
	JLabel msg = new JLabel();
	JTextField ct = new JTextField();
	JButton boton = new JButton();
	JLabel resp = new JLabel("");
	
	Font customFont = new Font("Italic",Font.ITALIC,22);
	
	int size, i, rc=0;
	int a = (int) (Math.random()*11+1);
	int b = (int) (Math.random()*11+1);
	String r = String.valueOf(a*b);
	
	OperacionM() {
		this.setBackground(Color.gray);
		this.setForeground(Color.gray);
		
		window.add(this);
		
		boton.setFont(customFont);
		boton.setText("Capturar");
		boton.setForeground(Color.WHITE);
		boton.setBackground(Color.DARK_GRAY);
		boton.addActionListener(this);
		window.add(boton,BorderLayout.PAGE_START);
		
		msg.setFont(customFont);
		msg.setText(a + " x " + b);
		msg.setForeground(Color.BLACK);
		window.add(msg,BorderLayout.CENTER);
		
		
		ct.setFont(customFont);
		ct.getText();
		window.add(ct,BorderLayout.PAGE_END);
		
		window.setLocation(575,400); 
		window.setUndecorated(true);
		window.setSize(400,200);
		window.setVisible(true);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(r);
		}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton) {			
			//resp.setText(r + "");
			if(r.equals(ct.getText()))
			{
				System.out.print("Correcto\n");
				JOptionPane.showMessageDialog(null, "Correcto :)");	
				OperacionM op = new OperacionM();
				window.dispose();
			}
			else 
			{
				System.out.println("Incorrecto\n"); 
				JOptionPane.showMessageDialog(null, "Incorrecto\nA por ellos!!");
				MultLevel ml = new MultLevel();
				window.dispose();
			}
			
		}
	}
		
}



/*

		int i, Size;
	 
		Size = 3;
		
		int [] a = new int[Size];
		int [] b = new int[Size];
		int [] Addition = new int[Size];
		int [] Subtraction = new int[Size];
		int [] Multiplication = new int[Size];
		String [] Ops = new String[Size];
		
		for (i = 0; i < Size; i++)
		{
			a[i] = (int)(Math.random()*6+1);
		}
		
		
		for (i = 0; i < Size; i++)
		{
			b[i] = (int)(Math.random()*6+1);
		} 
		
		System.out.println("\n   Matriz");
		System.out.println("  [a] [b]");
		for(i=0; i<a.length; i++)
		{
			for(i=0; i<b.length; i++)
			{
				System.out.println((i+1) + ": " + a[i] + "   " + b[i]);
			}
		}
		
		
		
		
		for(i = 0; i < Size; i ++)
		{
			Addition [i]= a[i] + b[i];
		    Subtraction [i]= a[i] - b[i];
		    Multiplication [i]= a[i] * b[i];
		}
		

		System.out.println("\n");
		for (i = 0; i < Size; i++)
		{
			
			System.out.print((i+1) + ": " + a[i] + " + " + b[i] +" = " + Addition[i] + " \t ");
			System.out.print((i+1) + ": " + a[i] + " - " + b[i] +" = " + Subtraction[i] + " \t ");
			System.out.print((i+1) + ": " + a[i] + " x " + b[i] +" = " + Multiplication[i] + "\n" );
		}
*/