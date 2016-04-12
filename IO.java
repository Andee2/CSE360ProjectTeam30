import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
	public static void write (Player toSave, String username)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream (username + ".prfl");
			ObjectOutputStream playerOut = new ObjectOutputStream (fileOut);
			
			playerOut.writeObject (toSave);
			playerOut.close ();
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace ();
		}
	}
	
	/**
	 * The retrieve method takes a player username and searches for the Player profile.
	 * 
	 * @param username - The Player's username.
	 * @return The Player profile that was searched for.
	 */
	public static Player retrieve (String username)
	{
		
	}
	
	public static String profileToString (String username)
	{
		String result = "";
		
		return result;
	}
	
	public static String rankingToString ()
	{
		String result = "";
		
		return result;
	}
}
