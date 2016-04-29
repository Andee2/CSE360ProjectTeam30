import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import org.junit.Test;
import java.util.LinkedList;

public class IOTest 
{

	@Test
	public void testWrite() 
			throws FileNotFoundException, NullPointerException, IOException 
	{
		String username = "Aidan";
		Player myPlayer = new Player(username);
		
		int error = IO.write(myPlayer, username);
		
		assertEquals(error, 0);
	}
	
	@Test
	public void testRetrieve() 
			throws StreamCorruptedException, FileNotFoundException, NullPointerException, IOException 
	{
		String username = "Aidan";
		Player myPlayer = IO.retrieve(username);
		
		assertNotEquals(myPlayer, null);
	}
	
	@Test
	public void testReadFromManifest()
			throws FileNotFoundException, NullPointerException, IOException
	{
		LinkedList<Player> list = IO.readFromManifest();
		assertNotEquals(list, null);
	}
	
	@Test
	public void testWriteToManifest()
			throws NullPointerException, IOException
	{
		LinkedList<Player> list = new LinkedList<Player>();
		
		int e = IO.writeToManifest(list);
		assertEquals(e, 0);
		
		Player p1 = new Player("Aidan");
		Player p2 = new Player("Loi");
		Player p3 = new Player("Jesse");
		Player p4 = new Player("Marc");
		Player p5 = new Player("Andrew");
		
		IO.write(p1, "Aidan");
		IO.write(p2, "Loi");
		IO.write(p3, "Jesse");
		IO.write(p4, "Marc");
		IO.write(p5, "Andrew");
		
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		e = IO.writeToManifest(list);
		assertEquals(e, 0);
	}
	


}
