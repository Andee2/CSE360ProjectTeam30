
public class Player {

	private String name; 		//Player name
	private float currentScore; 	//Total score of player
	private float totalScore; 	//Cumulative score of all games
	private int rank; 		//Player ranking
	private int playCount;		//Number of times player has played the game for stats
	private int deathcount; 	//Total times player has lost
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
	
	public int getPlayCount(){ 	//Returns number of times player has played the game
		return playCount;
	}
	
	public int getDeathcount(){ 	//Get number of player deaths
		return deathcount;
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
	
	public void setPlayCount(int playCount){		//Set number of times player has played the game for stats
		this.playCount = playCount;
	}
	
	public void setDeathcount(int deathcount){ 	//Set total times player has lost
		this.deathcount = deathcount;
	}
	
	public void setLives(int lives){		//Set player lives use if we decide to track this way
		this.lives = lives;
	}
}
