import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class GamePlay
{
	private Player activePlayer;
	private Die activeDie;
	private GameMatch currentGame;
	private int monsterRoll;
	//private int playerRoll;
	private int numOfMatches;
	private int matchesWon;
	private boolean matchEnded;
	private boolean gameOver;
	private LinkedList<Player> rankedList;
	
	public GamePlay()
	{
		activePlayer = new Player();
		activePlayer.resetScore();

		activeDie = new Die();
		currentGame = new GameMatch();
		matchEnded = false;
		numOfMatches = 0;
		matchesWon = 0;
		gameOver = false;
	}

	public GamePlay(Player Tester, LinkedList<Player> list)
	{
		activePlayer = Tester;
		activePlayer.resetScore();

		activeDie = new Die();
		currentGame = new GameMatch();
		matchEnded = false;
		numOfMatches = 0;
		matchesWon = 0;
		gameOver = false;
		rankedList = list;
	}

	/**
	 * rollDice simulates a round in the game. This includes picking the number to match, picking the opponent's number,
	 * comparing the player's guess and opponent's guess to the number to match, decides the winner and updates scores
	 *
	 * @calls Die.roll(), Die.mroll(), GameMatch.playerWinsRound(int, int, int), GameMatch.updateScore(boolean, int)
	 * @param playerNumber
	 * @return
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 * @throws IOException
	 */
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

		}
		else
		{
			feedback = feedback + "You have lost this round!\n";
			//no points for loss
		}

		feedback = feedback + nextRound();

		if(matchEnded)
		{
			activePlayer.incrementScore(currentGame.getFinalPlayerScore());
			feedback = feedback + nextMatch();
			currentGame = new GameMatch();
			matchEnded = false;
			rankedList.add(activePlayer);
			Collections.sort(rankedList);
			IO.writeToManifest(rankedList);
		}

		return feedback;
	}

	//No longer needed
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

			if(roundsWin > 1)
			{
				matchesWon++;
				result = "\nYou have won this match!\n";
				activePlayer.incrementWinCount(1);
			}
			else
			{
				result = "\nYou have lost this match!\n";
				activePlayer.incrementLossCount(1);
			}
			IO.write(activePlayer, activePlayer.getName());

			numOfMatches++;
			matchEnded = true;
		}
		else
		{
			int roundCount = currentGame.getRounds() + 1;
			result = String.format("\nBeginning Round %d of 3\n\n", roundCount);
		}
		return result;
	}

	private String nextMatch()
	{
		String result = "";
		if(numOfMatches > 2)
		{
			gameOver = true;
			activePlayer.resetScore();

			if(matchesWon > 1)
			{
				//Won the game
				result = String.format("\n\nCongratulations! You have beaten %d of the goblin generals!\n"
						+ "The goblin army is retreating as promised and the kingdom is safe once again!\n", matchesWon);
			}
			else
			{
				//Lost the game
				result = String.format("\n\nUnfortunately you were unable to beat the odds.\n"
						+ "You were able to win against %d of the three generals.\n"
						+ "You must now surrender your kingdom and its citizens to the goblin empire.\n", matchesWon);
			}
		}
		else
		{
			result = String.format("\nBeginning Match %d of 3\n"
					+ "Beginning Round 1 of 3\n\n", numOfMatches + 1);
		}

		return result;
	}

	public boolean getGameOver()
	{
		return gameOver;
	}

}