import java.io.FileNotFoundException;
import java.io.IOException;

public class GamePlay
{
	private Player activePlayer;
	private Die activeDie;
	private GameMatch currentGame;
	private int monsterRoll;
	//private int playerRoll;
	private boolean matchEnded;

	public GamePlay()
	{
		activePlayer = new Player();
		activeDie = new Die();
		currentGame = new GameMatch();
		matchEnded = false;
	}

	public GamePlay(Player Tester)
	{
		activePlayer = Tester;
		activeDie = new Die();
		currentGame = new GameMatch();
		matchEnded = false;
	}

	public String rollDice(int playerNumber) throws FileNotFoundException, NullPointerException, IOException
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

		boolean playerWin = currentGame.playerWinsRound(playerNumber, monsterRoll, sumRoll);
		currentGame.updateScore(playerWin, sumRoll);

		if(playerWin)
		{
			feedback = feedback + "You have won this round!\n";
			//probably need to edit if gamematch score is incremental and not singular
			//gameplay is not working properly as well so need to edit later when it is fixed - mkchun
			activePlayer.incrementScore(currentGame.getFinalPlayerScore());
		}
		else
		{
			feedback = feedback + "You have lost this round!\n";
			//no points for loss
		}

		feedback = feedback + nextRound();
		return feedback;
	}

	/*public void setPlayerRoll (int number)
	{
		playerRoll = number;
	}
	*/

	private String nextRound() throws FileNotFoundException, NullPointerException, IOException 
	{
		String result = "";
		boolean cont = currentGame.nextRound();
		if (!cont)
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