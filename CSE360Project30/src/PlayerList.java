import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerList {

	private static ArrayList playerStats = new ArrayList();

	public static void add(String name, int score)
	{
		//if playerStats is empty immediately just add to list
		if(playerStats.size() == 0)
		{
			playerStats.add(name);
			playerStats.add(score);
		}
		else
		{
			int count = 1;
			boolean done = false;
			//loops through until it finds an element that is less than score
			while(!done && count<=playerStats.size()) 
			//for(int count = 1; count <= playerStats.size(); count++)
			{
	
				if(count % 2 != 0)
				{
					//result = result + String.format("%d.", numbering);
					//result = result + String.format("%s\t\t", playerStats.get(count - 1));
					//numbering++;
					if((int)playerStats.get(count-1) < score)
					{
						playerStats.add(count-1, name);
						playerStats.add(count, score);
						done = true;
					}
				}
				
				count++;
			}
			//if it didn't find a score lass than the given 'score' it is the lowest and added to end of list
			if(!done)
			{
				playerStats.add(name);
				playerStats.add(score);
			}
		}
	}

	public static String listAsString()
	{
		String result = "Name:\t\tScore:\n";
		int numbering = 1;

		for(int count = 1; count <= playerStats.size(); count++)
		{

			if(count % 2 != 0)
			{
				result = result + String.format("%d.", numbering);
				result = result + String.format("%s\t\t", playerStats.get(count - 1));
				numbering++;
			}
			else
			{
				result = result + String.format("%d\n", playerStats.get(count - 1));

			}
		}
		return result;
	}

	public static void updateScore(String name, int newScore)
	{
		int position = search(name) + 1;
		playerStats.add(position, newScore);
		playerStats.remove(position + 1);
	}

	private static int search(String name)
	{
		int position = -1;
		for(int count = 0; count < playerStats.size(); count++)
		{
			if(name.equals(playerStats.get(count)))
			{
				position = count;
			}
		}
		return position;

	}
	
	public static void saveList() throws FileNotFoundException
	{
		try
		{
			PrintWriter printWrite = new PrintWriter(new FileOutputStream("PlayerStats.txt"));

			for(int count = 0; count < playerStats.size(); count++)
			{
				printWrite.println(playerStats.get(count));
			}
			printWrite.close();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("PlayerStats.txt was not found or could not be opened.\n");
			ex.printStackTrace(System.out);
		}
	}
	
	public static void loadList() throws FileNotFoundException
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("PlayerStats.txt");
			Scanner readIn = new Scanner(fileIn);

			while(readIn.hasNextLine())
			{
				if(readIn.hasNextInt())
				{
					int element = readIn.nextInt();
					String emptySpace = readIn.nextLine();
					playerStats.add(element);
				}
				else
				{
					playerStats.add(readIn.nextLine());
				}
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("PlayerStats.txt was not found or could not be opened.\n");
			ex.printStackTrace(System.out);
		}
	}
}
