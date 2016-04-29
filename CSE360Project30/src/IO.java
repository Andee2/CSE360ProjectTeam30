import java.io.*;

/**
 * Reading and writing player profiles to and from external files.
 * 
 * @author Aidan Spies
 */
public class IO
{	
	/**
	 * The write method takes in the player profile and the username for the profile to be
	 * archived as. It only needs to be called at the end of the game, and also saves the
	 * current user score onto the rankings. It also updates the rankings accordingly, and
	 * saves the list.
	 * 
	 * @param toSave - The Player profile that needs to be saved.
	 * @param username - The username to archive the profile as.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public static int write (Player toSave, String username) 
			throws FileNotFoundException, IOException, NullPointerException
	{
		int error;
		
		try
		{	
			FileOutputStream fileOut = new FileOutputStream ("profiles/" + username + ".prfl");
			ObjectOutputStream playerOut = new ObjectOutputStream (fileOut);
			
			playerOut.writeObject (toSave);
			playerOut.close ();
			
			error = 0;
		}
		
		catch (FileNotFoundException ex)
		{
			error = 1;
			System.out.println("You cannot save to the file. Make sure you have the "
					+ "permissions to access the file.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (IOException ex)
		{
			error = 2;
			System.out.println("There was an error writing to the File Output Stream.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (NullPointerException ex)
		{
			error = 3;
			System.out.println("The FileOutputStream is null.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (Exception ex)
		{
			error = 4;
			System.out.println("There was an error.\n");
			ex.printStackTrace(System.out);
		}
		
		return error;
	}
	
	/**
	 * The retrieve method takes a player username and searches for the Player profile.
	 * 
	 * @param username - The Player's username.
	 * @return The Player profile that was searched for.
	 * @throws FileNotFoundException
	 * @throws StreamCorruptedException
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public static Player retrieve (String username) 
			throws FileNotFoundException, StreamCorruptedException, IOException, NullPointerException
	{
		Player retrieved = null;
		
		try
		{
			FileInputStream fileIn = new FileInputStream ("profiles/" + username + ".prfl");
			ObjectInputStream playerIn = new ObjectInputStream (fileIn);
			
			retrieved = (Player) playerIn.readObject ();
			playerIn.close ();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("The file does not exist, or cannot be opened. "
					+ "Check to see if you're using the correct spelling and case, or if the file exists.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (StreamCorruptedException ex)
		{
			System.out.println("The filename is incorrect, or the file is corrupted.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (IOException ex)
		{
			System.out.println("There was an error reading from the File Input Stream.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (NullPointerException ex)
		{
			System.out.println("The FileInputStream is null.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (Exception ex)
		{
			System.out.println("There was an error.\n");
			ex.printStackTrace(System.out);
		}
		
		return retrieved;
	}
	
	/**
	 * This allows to open the manifest file to read from it.
	 * 
	 * @return 
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 */
	public static int readFromManifest (Player changed) 
			throws FileNotFoundException, NullPointerException
	{
		int error;
		
		try
		{
			FileInputStream fileIn = new FileInputStream ("manif.est");

			error = 0;
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("The manifest cannot be read. Likely, you do not have permission to read it.\n");
			ex.printStackTrace(System.out);
			
			error = 1;
		}
		
		catch (NullPointerException ex)
		{
			System.out.println("The FileInputStream is null.\n");
			ex.printStackTrace(System.out);
			
			error = 2;
		}
		
		catch (Exception ex)
		{
			System.out.println("There was an error.\n");
			ex.printStackTrace(System.out);
			
			error = 3;
		}
		
		return error;
	}
	
	/**
	 * This Writes to the manifest the score of the player.
	 * 
	 * @param head - The head of the linked list of players.
	 * @return Error number.
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 */
	public static int writeToManifest (PlayerNode head) 
			throws FileNotFoundException, NullPointerException
	{
		int error;
		
		try
		{	
			FileOutputStream fileOut = new FileOutputStream("manif.est");
			
			error = 0;
		}
		
		catch (FileNotFoundException ex)
		{
			error = 1;
			System.out.println("An error occured saving to the file.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (NullPointerException ex)
		{
			error = 2;
			System.out.println("The FileOutputStream is null.\n");
			ex.printStackTrace(System.out);
		}
		
		catch (Exception ex)
		{
			error = 3;
			System.out.println("There was an error.\n");
			ex.printStackTrace(System.out);
		}
		
		return error;
	}
}
