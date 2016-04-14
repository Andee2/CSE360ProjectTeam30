
public class GamePlay
{
	private Player activePlayer;
	private Die activeDie;
	private GameMatch currentGame;
	private int monsterRoll;
	private int playerRoll;

	public GamePlay()
	{
		activePlayer = new Player();
		activeDie = new Die();
		currentGame = new GameMatch();
	}

	public GamePlay(String name)
	{
		activePlayer = new Player(name);
		activeDie = new Die();
		currentGame = new GameMatch();
	}

	public int rollDice()
	{
		monsterRoll = activeDie.mRoll();
		int firstRoll = activeDie.roll();
		int secRoll = activeDie.roll();
		return firstRoll + secRoll;
	}
	
	public void setPlayerRoll (int number)
	{
		playerRoll = number;
	}

}
