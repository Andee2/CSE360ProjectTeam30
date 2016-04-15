import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import org.junit.Test;

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

}
