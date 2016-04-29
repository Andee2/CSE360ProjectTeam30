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
	public void testWriteToManifest()
			throws FileNotFoundException, NullPointerException
	{
		LinkedList<Player> list = new LinkedList<Player>();
		
		list.add(new Player("Aidan"));
		list.add(new Player("Loi"));
		list.add(new Player("Jesse"));
		list.add(new Player("Marc"));
		list.add(new Player("Andrew"));
		
		int e = IO.writeToManifest(list);
	
		assertEquals(e, 0);
	}
	
	@Test
	public void testReadFromManifest()
			throws FileNotFoundException, NullPointerException, IOException
	{
		LinkedList<Player> list = IO.readFromManifest();
		assertEquals(list, null);
	}

}
