import java.util.ArrayList;

public class PlayerList {

	private static ArrayList playerStats = new ArrayList();

	public static void add(String name, int score)
	{
		playerStats.add(name);
		playerStats.add(score);
	}

	public static String listAsString()
	{
		String result = "Name:\t\tScore:\n";
		int numbering = 1;

		for(int i = 1; i <= playerStats.size(); i++)
		{

			if(i % 2 != 0)
			{
				result = result + String.format("%d.", numbering);
				result = result + String.format("%s\t\t", playerStats.get(i - 1));
				numbering++;
			}
			else
			{
				result = result + String.format("%d\n", playerStats.get(i - 1));

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
}
