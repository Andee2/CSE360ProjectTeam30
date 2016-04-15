import static org.junit.Assert.*;

import org.junit.Test;

public class DieTest {

	@Test
	public void testDie() {
		Die dice = new Die();
		assertNotNull(dice);
	}

	@Test
	public void testRoll() {
		Die dice = new Die();
		int mynum = dice.roll();
		assertTrue(1 <= mynum && mynum <= 6);
	}

	@Test
	public void testMRoll() {
		Die dice = new Die();
		int mynum = dice.mRoll();
		assertTrue(1 <= mynum && mynum <= 12);
	}

}
