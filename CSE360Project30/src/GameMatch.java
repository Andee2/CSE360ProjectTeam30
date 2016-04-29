//package cse360GroupPrj;

public class GameMatch
{
	private int playerScore;
	private int monsterScore;
	private int rounds;
	private int maxRounds;
	private int playerWins;
	//private int winStreak;


	/**GameMatch is a constructor setting up scores, rounds, and player wins*/
	public GameMatch()
	{
		playerScore = 0;
		monsterScore = 0;
		rounds = 0;
		maxRounds = 3;
		playerWins = 0;
		//winStreak = 0;
	}

	/**********for potentially setting more than 3 rounds***********/
	/*public GameMatch(int setRounds)
	{
		playerScore = 0;
		monsterScore = 0;
		rounds = 0;
		maxRounds = setRounds;
		playerWins = 0;
		//winStreak = 0;
	}*/

	/**nextRound increments to the next round and until it is equal to the max number of rounds
	 * when it is the same it will trigger endMatch*/
	public boolean nextRound()
	{
		boolean nextRound;
		if(rounds < maxRounds - 1 && playerWins <= maxRounds / 2)
		{
			nextRound = true;
			rounds++;
		}
		else
		{
			nextRound = false;
			//endMatch();
		}
		return nextRound;
	}

	/** playerWinsRound returns a boolean of true if the player won and a boolean false if the player loses
	 * @param playerNum is the number selected by the player
	 * monsterNum is the number selected by the monster/opponent
	 * rolledNum is the randomly generated number from the system
	 * */
	public boolean playerWinsRound(int playerNum, int monsterNum, int rolledNum)
	{
		boolean result = false;

		if(Math.abs(playerNum-rolledNum)<=Math.abs(monsterNum-rolledNum))
		{
			result = true;
			playerWins++;
		}

		return result;
	}

	/** updateScore will update the score of the winner of the round and give a higher score based
	 * on the probability of that number being rolled in the first place
	 * @param playerWin is a boolean to indicate who gets the points for the round
	 * winningNum is the number chosen by the winner during the round
	 * */
	public void updateScore(boolean playerWin, int winningNum)
	{
		int baseScore = 100;
		if(playerWin)
		{
			switch(winningNum)
			{
			case 2: playerScore = playerScore + baseScore*(6/1);
					break;
			case 3: playerScore = playerScore + baseScore*(6/2);
					break;
			case 4: playerScore = playerScore + baseScore*(6/3);
					break;
			case 5: playerScore = playerScore + baseScore*(6/4);
					break;
			case 6: playerScore = playerScore + baseScore*(6/5);
					break;
			case 7: playerScore = playerScore + baseScore*(6/6);
					break;
			case 8: playerScore = playerScore + baseScore*(6/5);
					break;
			case 9: playerScore = playerScore + baseScore*(6/4);
					break;
			case 10: playerScore = playerScore + baseScore*(6/3);
					break;
			case 11: playerScore = playerScore + baseScore*(6/2);
					break;
			case 12: playerScore = playerScore + baseScore*(6/1);
					break;
			}
		}
		else
		{
			switch(winningNum)
			{
			case 2: monsterScore = monsterScore + baseScore*(6/1);
					break;
			case 3: monsterScore = monsterScore + baseScore*(6/2);
					break;
			case 4: monsterScore = monsterScore + baseScore*(6/3);
					break;
			case 5: monsterScore = monsterScore + baseScore*(6/4);
					break;
			case 6: monsterScore = monsterScore + baseScore*(6/5);
					break;
			case 7: monsterScore = monsterScore + baseScore*(6/6);
					break;
			case 8: monsterScore = monsterScore + baseScore*(6/5);
					break;
			case 9: monsterScore = monsterScore + baseScore*(6/4);
					break;
			case 10: monsterScore = monsterScore + baseScore*(6/3);
					break;
			case 11: monsterScore = monsterScore + baseScore*(6/2);
					break;
			case 12: monsterScore = monsterScore + baseScore*(6/1);
					break;
			}
		}
	}
	/**finalPlayerScore simply returns the score of the player at the end of the match or when the player decides to quit*/
	public int getFinalPlayerScore()
	{
		return playerScore;
	}

	public int getFinalMonsterScore()
	{
		return monsterScore;
	}

	/**getPlayerWins returns the number of rounds won*/
	public int getPlayerWins()
	{
		return playerWins;
	}

	public int getRounds()
	{
		return rounds;
	}


	/**endMatch prints or returns whether or not the player has won the match */
	/* No longer needed
	public void endMatch()
	{
		if(playerWins>1)
		{
			System.out.println("The player has won the match");
		}
		else
		{
			System.out.println("The player has lost the match");
		}

	}
	*/
}