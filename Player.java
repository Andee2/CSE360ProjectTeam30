
public class Player {

	private String name; 		//Player name
	private float currentScore; 	//Total score of player
	private float totalScore; 	//Cumulative score of all games
	private int rank; 		//Player ranking
	private int wins;		//Number of times player has won the game
	private int losses; 		//Number of times player has lost the game
	private int lives;		//Player lives use if we decide to track this way
	
	public Player(){ 		//Default player constructor
		name = "No Name";
		currentScore = 0;
		totalScore = 0;
		rank = 0;
		playCount = 0;
		deathCount = 0;
		lives = 0;
	}
	
	public Player(String name){ 	//Player constructor with name
		this.name = name;
	}
	
	public String getName(){ 	//Get player name
		return name;
	}
	
	public float getScore(){ 	//Get player score
		return currentScore;
	}
	
	public float getTotalScore(){ 	//Get player score
		return totalScore;
	}
	
	public int getRank(){ 		//Get player rank
		return rank;
	}
	
	public int getWinCount(){ 	//Returns number of times player has won the game
		return wins;
	}
	
	public int getLossCount(){ 	//Get number of times player has lost the game
		return losses;
	}
	
	public int getLives(){ 		//Get player's number of lives left
		return lives;
	}
	
	public void setScore(float score){ 		//Set current score which also increments total score
		currentScore = currentScore + score;
		totalScore = totalScore + currentScore;
	}
	
	public void resetScore(){ 			//reset current score (when starting new game)
		currentScore = 0;
	}
	
	public void setRank(int rank){ 			//Set player ranking
		this.rank = rank;
	}
	
	public void setPlayCount(int wins){		//Set number of times player has won the game for stats
		this.wins = wins;
	}
	
	public void setLossCount(int losses){ 	//Set total times player has lost
		this.losses = losses;
	}
	
	public void setLives(int lives){		//Set player lives use if we decide to track this way
		this.lives = lives;
	}
}
