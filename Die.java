/**
 * @author Andrew Leach
 * This class initializes a random number generator between 1 and 6
 * to act as the rolling of a 6 sided die.
 */

import java.util.Random;

public class Die
{
	private Random rand; //Uses java.util.Random to simulate a dice roll

	/**
	 * Constructor for Die.class
	 */
	public Die()
	{
		rand = new Random();
	}

	/**
	 * Simulates the roll of a six sided die
	 * @return Integer value between 1 and 6
	 */
	public int roll()
	{
		return rand.nextInt(6) + 1;
	}

	/**
	 * Reuses the Random object already initialized to simulate the monster's guess
	 * @return Integer value between 2 and 12
	 */
	public int mRoll()
	{
		return rand.nextInt(11) + 2;
	}

}
