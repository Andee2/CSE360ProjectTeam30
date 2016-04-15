import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;

import javax.swing.JApplet;


public class Main extends JApplet
{

	public void init() 
	{
		// TODO Auto-generated method stub
		Menu newMenu = new Menu();
		
		Container cont = getContentPane();
		cont.add(newMenu);
		setSize(650,650);
		
	}
	

}
