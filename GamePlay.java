
public class GamePlay
{
	Player activePlayer;
	Die activeDie = new Die();

	public GamePlay()
	{
		activePlayer = new Player();
	}

	public GamePlay(String name)
	{
		activePlayer = new Player(name);
	}

	public int rollDice()
	{
		int firstRoll = activeDie.roll();
		int secRoll = activeDie.roll();
		return firstRoll + secRoll;
	}



}
