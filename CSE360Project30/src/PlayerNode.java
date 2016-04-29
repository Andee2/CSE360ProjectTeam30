/**
 * The class in which the player nodes for the linked list
 * are kept.
 * 
 * @author Aidan Spies
 */
public class PlayerNode 
{
	private Player player;
	private PlayerNode next;
	
	public PlayerNode()
	{
		player = null;
		next = null;
	}
	
	public PlayerNode (Player _player)
	{
		player = _player;
		next = null;
	}
	
	public void addPlayer (Player toAdd)
	{
		if (next == null)
			next = new PlayerNode (toAdd);
		
		else if (toAdd.getTotalScore() > player.getTotalScore())
		{
			next.addPlayer (player);
			player = toAdd;
		}
		
		else
			next.addPlayer (toAdd);
	}
}
