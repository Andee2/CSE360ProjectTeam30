/**
 * @author Andrew Leach
 * This class initializes a random number generator between 1 and 6
 * to act as the rolling of a 6 sided die.
 */

import java.util.Random;

public class Die
{
	private Random rand;

	public Die()
	{
		rand = new Random();
	}

	public int roll()
	{
		return rand.nextInt(6) + 1;
	}

}
