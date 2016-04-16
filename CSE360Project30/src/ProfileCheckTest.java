import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.Scanner;

public class ProfileCheckTest {

	@Test
	public void loadFileCheck() throws StreamCorruptedException, FileNotFoundException, NullPointerException, IOException {
		
		System.out.println("Please enter player name to search for");
		Player currentPlayer = new Player();
		String inputName;
		Scanner scanner = new Scanner(System.in);

		inputName = scanner.nextLine();
		//String path = System.getProperty("user.dir");
		//System.out.println(path);
		
		currentPlayer = IO.retrieve(inputName);
		
		//assertNotEquals(0,currentPlayer.getWinCount());
		assertNotEquals(0,currentPlayer.getLossCount());
		//assertNotEquals(0,currentPlayer.getScore());
		//assertNotEquals(0,currentPlayer.getTotalScore());
		//assertNotEquals(0,currentPlayer.getPlayCount());
	}
	
	public void writeFileCheck() throws StreamCorruptedException, FileNotFoundException, NullPointerException, IOException {
		
		System.out.println("Please enter player name to search for");
		Player currentPlayer = new Player();
		String inputName;
		Scanner scanner = new Scanner(System.in);

		inputName = scanner.nextLine();
		//String path = System.getProperty("user.dir");
		//System.out.println(path);
		
		currentPlayer = IO.retrieve(inputName);
		currentPlayer.setRank(5);
		IO.write(currentPlayer, inputName);
		
		assertEquals(5,currentPlayer.getRank());
		//assertNotEquals(0,currentPlayer.getLossCount());
		//assertNotEquals(0,currentPlayer.getScore());
		//assertNotEquals(0,currentPlayer.getTotalScore());
		//assertNotEquals(0,currentPlayer.getPlayCount());
	}

}
