
public class Player {

	private String name; 		//player name
	private float currentScore; //total score of player
	private float totalScore; 	//cumulative score of all games
	private int rank; 			//player ranking
	private int deathcount; 	//total times player has lost
	private int lives;			//player lives use if we decide to track this way
	
	public Player(){ 			//default player constructor
		name = "No Name";
		currentScore = 0;
		totalScore = 0;
		rank = 0;
	}
	
	public Player(String name){ //player constructor with name
		this.name = name;
	}
	
	public String getName(){ //get player name
		return name;
	}
	
	public float getScore(){ //get player score
		return currentScore;
	}
	
	public float getTotalScore(){ //get player score
		return totalScore;
	}
	
	public int getRank(){ //get player rank
		return rank;
	}
	
	public int getDeathcount(){ //get player rank
		return deathcount;
	}
	
	public int getLives(){ //get player rank
		return lives;
	}
	
	public void setScore(float score){ //set current score which also increments total score
		currentScore = currentScore + score;
		totalScore = totalScore + currentScore;
	}
	
	public void resetScore(){ //reset current score (when starting new game)
		currentScore = 0;
	}
}
