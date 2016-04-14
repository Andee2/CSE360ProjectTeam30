package cse360GroupPrj;

public class GameMatch 
{
	private int playerScore;
	private int monsterScore;
	/** playerWins returns a boolean of true if the player won and a boolean false if the player loses
	 * @param playerNum is the number selected by the player
	 * monsterNum is the number selected by the monster/opponent
	 * rolledNum is the randomly generated number from the system 
	 * */
	public boolean playerWinsRound(int playerNum, int monsterNum, int rolledNum)
	{
		boolean result = false;
		
		if(Math.abs(playerNum-rolledNum)<Math.abs(monsterNum-rolledNum))
		{
			result = true;
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
	public int finalPlayerScore()
	{
		return playerScore;
	}

}
