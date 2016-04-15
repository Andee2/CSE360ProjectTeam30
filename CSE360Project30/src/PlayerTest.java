import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player newGuy = new Player();
		assertNotNull(newGuy);
	}

	@Test
	public void testPlayerString() {
		Player newGuy = new Player("Bob");
		assertNotNull(newGuy);
	}

	@Test
	public void testGetName() {
		Player newGuy = new Player("Bob");
		assertEquals("Bob", newGuy.getName());
	}

	@Test
	public void testGetScore() {
		Player newGuy = new Player("Bob");
		newGuy.setScore(5);
		assertEquals(5, newGuy.getScore());
	}

	@Test
	public void testGetTotalScore() {
		Player newGuy = new Player("Bob");
		newGuy.setScore(5);
		assertEquals(5, newGuy.getTotalScore());
	}

	@Test
	public void testGetRank() {
		Player newGuy = new Player("Bob");
		newGuy.setRank(5);
		assertEquals(5, newGuy.getRank());
	}

	@Test
	public void testGetWinCount() {
		Player newGuy = new Player("Bob");
		newGuy.setWinCount(5);
		assertEquals(5, newGuy.getWinCount());
	}

	@Test
	public void testGetLossCount() {
		Player newGuy = new Player("Bob");
		newGuy.setLossCount(5);
		assertEquals(5, newGuy.getLossCount());
	}

	@Test
	public void testGetLives() {
		Player newGuy = new Player("Bob");
		newGuy.setLives(5);
		assertEquals(5, newGuy.getLives());
	}

	@Test
	public void testSetScore() {
		Player newGuy = new Player("Bob");
		newGuy.setScore(5);
		assertEquals(5, newGuy.getScore());
	}

	@Test
	public void testResetScore() {
		Player newGuy = new Player("Bob");
		newGuy.setScore(5);
		newGuy.resetScore();
		assertEquals(0, newGuy.getScore());
	}

	@Test
	public void testSetRank() {
		Player newGuy = new Player("Bob");
		newGuy.setRank(5);
		assertEquals(5, newGuy.getRank());
	}

	@Test
	public void testSetWinCount() {
		Player newGuy = new Player("Bob");
		newGuy.setWinCount(5);
		assertEquals(5, newGuy.getWinCount());
	}

	@Test
	public void testSetLossCount() {
		Player newGuy = new Player("Bob");
		newGuy.setLossCount(5);
		assertEquals(5, newGuy.getLossCount());
	}

	@Test
	public void testSetLives() {
		Player newGuy = new Player("Bob");
		newGuy.setLives(5);
		assertEquals(5, newGuy.getLives());
	}

	@Test
	public void testIncrementScore() {
		Player newGuy = new Player("Bob");
		newGuy.setScore(5);
		newGuy.incrementScore(2);
		assertEquals(7, newGuy.getScore());
	}

	@Test
	public void testIncrementWinCount() {
		Player newGuy = new Player("Bob");
		newGuy.setWinCount(5);
		newGuy.incrementWinCount(2);
		assertEquals(7, newGuy.getWinCount());
	}

	@Test
	public void testIncrementLossCount() {
		Player newGuy = new Player("Bob");
		newGuy.setLossCount(5);
		newGuy.incrementLossCount(2);
		newGuy.incrementLossCount(2);
		newGuy.incrementLossCount(2);
		assertEquals(11, newGuy.getLossCount());
	}

	@Test
	public void testIncrementPlayCount() {
		Player newGuy = new Player("Bob");
		newGuy.incrementPlayCount(5);
		assertEquals(5, newGuy.getPlayCount());
	}

	@Test
	public void testIncrementDeathCount() {
		Player newGuy = new Player("Bob");
		newGuy.incrementDeathCount(5);
		assertEquals(5, newGuy.getDeathCount());
	}

}
