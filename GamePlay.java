
public class GamePlay
{
	private Player activePlayer;
	private Die activeDie;
	private GameMatch currentGame;

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
		int firstRoll = activeDie.roll();
		int secRoll = activeDie.roll();
		return firstRoll + secRoll;
	}

}
