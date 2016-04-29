import java.io.*;
import java.util.LinkedList;

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
			FileOutputStream fileOut = new FileOutputStream (username + ".prfl");
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
			System.out.println("There was an error writing to the FileOutputStream.\n");
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
			FileInputStream fileIn = new FileInputStream (username + ".prfl");
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
			System.out.println("There was an error reading from the FileInputStream.\n");
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
	 * This allows to open the manifest file to read from it. Just call the
	 * method, and it returns the already sorted LinkedList from the manifest.
	 * 
	 * @return The LinkedList that was stored in the manifest. If it was sorted before,
	 * 		   it is returned sorted. If there is no LinkedList stored in the manifest,
	 * 		   or the manifest does not exist, then it returns <b>null</b>.
	 * 
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 * @throws IOException 
	 */
	public static LinkedList<Player> readFromManifest() 
			throws FileNotFoundException, NullPointerException, IOException
	{
		BufferedReader reader = null;
		LinkedList<Player> list = null;
		boolean manifestExists = true;
		
		File manifest = new File("manifest.list");
		if (!manifest.exists())
			manifestExists = false;
		
		if (manifestExists)
		{
			try
			{
				reader = new BufferedReader (new FileReader ("manifest.list"));
				String currentLine = reader.readLine();
				
				while (!currentLine.equals("null"))
				{
					System.out.println(currentLine);
					
					if (list == null)
					{
						list = new LinkedList<Player>();
						list.add (retrieve(currentLine));
					}
					else
						list.add (retrieve(currentLine));
					
					currentLine = reader.readLine();
				}
				
			}
			
			catch (FileNotFoundException ex)
			{
				System.out.println("The manifest cannot be read. The file may not exist.\n");
				ex.printStackTrace(System.out);
				return null;
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
			
			finally
			{
				try
				{
					reader.close();
				} 
				
				catch (IOException ex)
				{
					System.out.println("IO Exception.\n");
					ex.printStackTrace(System.out);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * This writes to the manifest the name of the player. Just provide
	 * the LinkedList, and it will write the manifest based on that.
	 * 
	 * @param list - The LinkedList of players. If it is sorted, it will be
	 * 				 stored sorted.
	 * 
	 * @return The integer value of the error. Can be used for testing,
	 * 		   if needed.
	 * 
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 */
	public static int writeToManifest (LinkedList<Player> list) 
			throws FileNotFoundException, NullPointerException
	{
		PrintWriter writer = null;
		
		Object _players[] = list.toArray();
		Player players[] = new Player[_players.length];
		
		for (int pos = 0; pos < _players.length; pos++)
			players[pos] = (Player) _players[pos];
		
		int error = -1;
		
		try
		{	
			writer = new PrintWriter ("manifest.list", "UTF-8");
			
			int rank = 0;
			
			while (rank < players.length)
			{
				writer.print(players[rank].getName());
				writer.print('\n');
				rank++;
			}
			
			writer.println("null");
			
			error = 0;
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("An error occured saving to the file.\n");
			ex.printStackTrace(System.out);
			error = 1;
		}
		
		catch (NullPointerException ex)
		{
			System.out.println("The FileOutputStream is null.\n");
			ex.printStackTrace(System.out);
			error = 2;
		}
		
		catch (Exception ex)
		{
			System.out.println("There was an error.\n");
			ex.printStackTrace(System.out);
			error = 3;
		}
		
		finally
		{
			writer.close();
		}
		
		return error;
	}
}
