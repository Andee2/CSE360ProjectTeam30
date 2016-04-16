//package cse360GroupPrj;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameMatchTest 
{
	@Test
	public void testGameMatch()
	{
		GameMatch aMatch = new GameMatch();
		assertNotNull(aMatch);
	}
	
	@Test
	public void testNextRound()
	{
		GameMatch aMatch = new GameMatch();
		assertTrue(aMatch.nextRound());
		assertTrue(aMatch.nextRound());
		assertTrue(aMatch.nextRound());
		assertFalse(aMatch.nextRound());
		
	}
	
	@Test
	public void testPlayerWinsRound()
	{
		GameMatch aMatch = new GameMatch();
		assertTrue(aMatch.playerWinsRound(7,7,7));
		assertTrue(aMatch.playerWinsRound(7,7,6));
		assertFalse(aMatch.playerWinsRound(6,7,7));
	}
	
	@Test
	public void testPlayerScore()
	{
		GameMatch aMatch = new GameMatch();
		assertEquals(0,aMatch.getFinalPlayerScore());
		aMatch.updateScore(true, 7);
		assertEquals(100,aMatch.getFinalPlayerScore());
		
	}
	
	@Test
	public void testMonsterScore()
	{
		GameMatch aMatch = new GameMatch();
		assertEquals(0,aMatch.getFinalMonsterScore());
		aMatch.updateScore(false, 7);
		assertEquals(100,aMatch.getFinalMonsterScore());
	}
	
	@Test
	public void testGetRounds()
	{
		GameMatch aMatch = new GameMatch();
		assertEquals(0,aMatch.getRounds());
		aMatch.nextRound();
		assertEquals(1,aMatch.getRounds());
		aMatch.nextRound();
		assertEquals(2,aMatch.getRounds());
	}
	
	@Test
	public void testGetWins()
	{
		GameMatch aMatch = new GameMatch();
		assertEquals(0,aMatch.getRounds());
		aMatch.playerWinsRound(7,7,7);
		assertEquals(1,aMatch.getPlayerWins());
		aMatch.playerWinsRound(3,7,2);
		assertEquals(2,aMatch.getPlayerWins());
	}
	
	@Test
	public void testUpdateScore()
	{
		GameMatch aMatch = new GameMatch();
		assertEquals(0,aMatch.getFinalPlayerScore());
		aMatch.updateScore(true, 7);
		assertEquals(100,aMatch.getFinalPlayerScore());
		aMatch.updateScore(true, 2);
		assertEquals(700,aMatch.getFinalPlayerScore());
		aMatch.updateScore(true, 10);
		assertEquals(900,aMatch.getFinalPlayerScore());
		aMatch.updateScore(true, 11);
		assertEquals(1200,aMatch.getFinalPlayerScore());
	}
}
