/**
 * This class is to act as the central command module between the other classes in this project
 * @author Andrew Leach
 *
 */


public class GamePlay
{
	private Player activePlayer;
	private Die activeDie;
	private GameMatch currentGame;
	private int monsterRoll;
	//private int playerRoll;
	private boolean matchEnded;

	/**
	 * Default constructor for GamePlay.class
	 */
	public GamePlay()
	{
		activePlayer = new Player();
		activeDie = new Die();
		currentGame = new GameMatch();
		matchEnded = false;
	}

	/**
	 * Preferred Constructor for GamePlay.class
	 * Takes in the player's name and creates a player object with it
	 * @param name
	 */
	public GamePlay(String name)
	{
		activePlayer = new Player(name);
		activeDie = new Die();
		currentGame = new GameMatch();
		matchEnded = false;
	}

	/**
	 * Performs the actions of a single round of gameplay
	 * and returns a String with the details of the round.
	 * @param playerNumber
	 * @return A String containing the number guessed by the player,
	 * the number guessed by the monster, both dice values and their sum,
	 * the outcome of the round, and the outcome of the match.
	 */
	public String rollDice(int playerNumber)
	{
		String feedback;

		//Calculate monster's roll and the roll to match
		monsterRoll = activeDie.mRoll();
		int firstRoll = activeDie.roll();
		int secRoll = activeDie.roll();
		int sumRoll = firstRoll + secRoll;

		feedback = String.format("You have guessed: %d\n"
				+ "The monster has guessed: %d\n"
				+ "The dice are thrown across the table.\n"
				+ "The first die shows a %d and the second shows a %d.\n"
				+ "The correct guess is %d.\n",
				playerNumber, monsterRoll, firstRoll, secRoll, sumRoll);

		//Determine who won and update scores
		boolean playerWin = currentGame.playerWinsRound(playerNumber, monsterRoll, sumRoll);
		currentGame.updateScore(playerWin, sumRoll);

		if(playerWin)
		{
			feedback = feedback + "You have won this round!\n";
		}
		else
		{
			feedback = feedback + "You have lost this round!\n";
		}

		feedback = feedback + nextRound();
		return feedback;
	}

	/*public void setPlayerRoll (int number)
	{
		playerRoll = number;
	}
	*/

	/**
	 * Determines if there is another round to the match.
	 * If the match is determined to be over, then this method
	 * resolves who won the match and returns the details as a string.
	 * This method also initiates the saving of the player's information.
	 * @return String containing the next rounds count or the results of the match
	 */
	private String nextRound()
	{
		String result;
		boolean continueGame = currentGame.nextRound();
		if (!continueGame)
		{
			int roundsWin = currentGame.getPlayerWins();
			matchEnded = true;

			if(roundsWin > 1)
			{
				result = "\nYou have won this match!\n";
				activePlayer.incrementWinCount(1);
			}
			else
			{
				result = "\nYou have lost this match!\n";
				activePlayer.incrementLossCount(1);
			}
			IO.write(activePlayer, activePlayer.getName());
		}
		else
		{
			int roundCount = currentGame.getRounds() + 1;
			result = String.format("\nBeginning Round %d of 3\n\n", roundCount);
		}
		return result;
	}

}
