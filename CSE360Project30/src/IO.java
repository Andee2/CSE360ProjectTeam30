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
	 */
	public static int write (Player toSave, String username) 
			throws FileNotFoundException, IOException, NullPointerException
	{
		int error;
		
		try
		{	
			
			String path = System.getProperty("user.dir");
			path = path.replaceAll("bin", "");
			//System.out.println(path);
			
			
			FileOutputStream fileOut = new FileOutputStream (path + "/profiles/" + username + ".prfl");
			ObjectOutputStream playerOut = new ObjectOutputStream (fileOut);
			
			playerOut.writeObject (toSave);
			playerOut.close ();
			
			error = 0;
		}
		
		catch (FileNotFoundException ex)
		{
			error = 1;
			System.out.println("The file name may be the name of a directory, or you cannot save to the file. "
					+ "Make sure you have the permissions to access the file, or that it is not a directory.");
			ex.printStackTrace(System.out);
		}
		
		catch (IOException ex)
		{
			error = 2;
			System.out.println("There was an error writing to the File Output Stream.");
			ex.printStackTrace(System.out);
		}
		
		catch (NullPointerException ex)
		{
			error = 3;
			System.out.println("The FileOutputStream is null. Contact the distributors.");
			ex.printStackTrace(System.out);
		}
		
		catch (Exception ex)
		{
			error = 4;
			System.out.println("There was an error.");
			ex.printStackTrace(System.out);
		}
		
		return error;
	}
	
	/**
	 * The retrieve method takes a player username and searches for the Player profile.
	 * 
	 * @param username - The Player's username.
	 * @return The Player profile that was searched for.
	 */
	public static Player retrieve (String username) 
			throws FileNotFoundException, StreamCorruptedException, IOException, NullPointerException
	{
		Player retrieved = null;
		
		try
		{
			String path = System.getProperty("user.dir");
			path = path.replaceAll("bin", "");
			//System.out.println(path);
			
			FileInputStream fileIn = new FileInputStream (path + "/profiles/" + username + ".prfl");
			ObjectInputStream playerIn = new ObjectInputStream (fileIn);
			
			retrieved = (Player) playerIn.readObject ();
			playerIn.close ();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("The file does not exist, or cannot be opened. "
					+ "Check to see if you're using the correct spelling and case, or if the file exists.");
			ex.printStackTrace(System.out);
		}
		
		catch (StreamCorruptedException ex)
		{
			System.out.println("The filename is incorrect, or the file is corrupted.");
			ex.printStackTrace(System.out);
		}
		
		catch (IOException ex)
		{
			System.out.println("There was an error reading from the File Input Stream.");
			ex.printStackTrace(System.out);
		}
		
		catch (NullPointerException ex)
		{
			System.out.println("The FileInputStream is null. Contact the distributors.");
			ex.printStackTrace(System.out);
		}
		
		catch (Exception ex)
		{
			System.out.println("There was an error.");
			ex.printStackTrace(System.out);
		}
		
		return retrieved;
	}
}