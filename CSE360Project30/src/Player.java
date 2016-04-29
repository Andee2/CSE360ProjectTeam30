import java.io.Serializable;

/**
 * Player class for dice game
 * @author mkchun
 *
 */

public class Player implements Serializable, Comparable<Player>{

	private String name; 		//Player name
	private int currentScore; 	//Total score of player
	private int totalScore; 	//Cumulative score of all games
	private int rank; 		//Player ranking
	private int wins;		//Number of times player has won the game
	private int losses; 		//Number of times player has lost the game
	private int lives;		//Player lives use if we decide to track this way
	private int playCount;
	private int deathCount;
	private static final long serialVersionUID = 3214215555786442118L;
	
	/** 
	 * Player Constructor will create a player with default values
	 */
	public Player(){ 		//Default player constructor
		name = null;
		currentScore = 0;
		totalScore = 0;
		rank = 0;
		wins = 0;
		losses = 0;
		lives = 0;
		playCount = 0;
		deathCount = 0;
	}
	
	/** 
	 * Player Constructor will create a player with a name
	 * @param name = Player name
	 */
	public Player(String name){ 	//Player constructor with name
		this.name = name;
		currentScore = 0;
		totalScore = 0;
		rank = 0;
		wins = 0;
		losses = 0;
		lives = 0;
		playCount = 0;
		deathCount = 0;
	}
	
	/**
	 * getName will return the name of the Player
	 * @return = name of Player
	 */
	public String getName(){ 	//Get player name
		return name;
	}
	
	/**
	 * getScore will retrieve the current score of the Player
	 * @return = current score of Player
	 */
	public int getScore(){ 	//Get player score
		return currentScore;
	}
	
	/**
	 * getTotalScore will return the cumulative value of the Player's total
	 * score over all games.
	 * @return = cumulative total score of all games for Player
	 */
	public int getTotalScore(){ 	//Get player score
		return totalScore;
	}
	
	/**
	 * getRank will return the current rank of the Player
	 * @return = current rank of player
	 */
	public int getRank(){ 		//Get player rank
		return rank;
	}
	
	/**
	 * getWinCount will return the total wins the Player has accumulated
	 * @return = total wins of player
	 */
	public int getWinCount(){ 	//Returns number of times player has won the game
		return wins;
	}
	
	/**
	 * getLossCount will return the total losses the Player has accumulated
	 * @return = total losses of player
	 */
	public int getLossCount(){ 	//Get number of times player has lost the game
		return losses;
	}
	
	/**
	 * getLives will return the total number of lives the player has left
	 * @return = number of lives left
	 */
	public int getLives(){ 		//Get player's number of lives left
		return lives;
	}
	
	/**
	 * getPlayCount will return total number of times Player has Played game
	 * @return = number times player has played the game
	 */
	public int getPlayCount(){
		return playCount;
	}
	
	/**
	 * getDeathCount will return total number of deaths player has
	 * @return = number of deaths for Player
	 */
	public int getDeathCount(){
		return deathCount;
	}
	
	/**
	 * setScore will set the current Player's score to a certain value 
	 * and also increment the Player's total score by the same value
	 * @param score = score in which to set Player's score to
	 */
	public void setScore(int score){ 		//Set current score which also increments total score
		currentScore = score;
		totalScore = totalScore + currentScore;
	}
	
	/**
	 * resetScore will reset the Player's current score, it will not 
	 * change the total accumulated score for Player
	 */
	public void resetScore(){ 			//reset current score (when starting new game)
		currentScore = 0;
	}
	
	/**
	 * setRank will set the Player's rank to a certain int value
	 * @param rank = current rank of Player
	 */
	public void setRank(int rank){ 			//Set player ranking
		this.rank = rank;
	}
	
	/**
	 * setWinCount will set the current Player's win count to a certain value
	 * @param wins = amount to set Player's win count to
	 */
	public void setWinCount(int wins){		//Set number of times player has won the game for stats
		this.wins = wins;
	}
	
	/**
	 * setLossCount will set the current Player's loss count to a certain value
	 * @param losses = amount to set Player's loss count to
	 */
	public void setLossCount(int losses){ 	//Set total times player has lost
		this.losses = losses;
	}
	
	/**
	 * setLives will set the current Player's life count to a certain value
	 * @param lives = number of lives to set to current Player
	 */
	public void setLives(int lives){		//Set player lives use if we decide to track this way
		this.lives = lives;
	}
	
	/**
	 * incrementScore will add to the current Player's score
	 * and also increment the Player's total score by the same value
	 * @param score = score in which to set Player's score to
	 */
	public void incrementScore(int score){ 		//increment current score which also increments total score
		currentScore = currentScore + score;
		totalScore = totalScore + currentScore;
	}
	
	/**
	 * incrementWinCount will add to the current Player's win count
	 * @param wins = amount to add to current Player's wins
	 */
	public void incrementWinCount(int wins){		//increment number of times player has won the game for stats
		this.wins = this.wins + wins;
	}
	
	/**
	 * incrementLossCount will add to the current Player's loss count
	 * @param losses = amount to add to current Player's losses
	 */
	public void incrementLossCount(int losses){		//increment number of times player has loss the game for stats
		this.losses = this.losses + losses;
	}
	
	/**
	 * incrementPlayCount will add to the current Player's total number of
	 * times Player has played the game
	 * @param plays = add to total number of games played count
	 */
	public void incrementPlayCount(int plays){		//increment playCount
		playCount = plays + playCount;
	}
	
	/**
	 * incrementDeathCount will add to the current Player's total number of
	 * deaths
	 * @param deaths = add to total number of deaths for player
	 */
	public void incrementDeathCount(int deaths){		//increment deathCount
		deathCount = deathCount + deaths;
	}
	
	/**compares two players by score
	 * @param E is a player object to be compared
	 */
	public int compareTo(Player E)
	{
			  if(this.getScore() < E.getScore())
			  {
				  return 1;
			  } 
			  else 
			  {
				  return -1;
			  }		
	}
	
	public String toString()
	{
		String details = "";
		details = "Player Name: " + name + " Player Score:"+ totalScore + "\n";
		return details;
	}
	
}
