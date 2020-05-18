import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class TestSingleGame {

	SingleGame game;
	testableDie die1;
	testableDie die2;
	
	Player player1;
	Player player2;
	List<Player> players;

	
	@Test
	void testString() {
		SingleGame game = new SingleGame(die1, die1, players);
		players.add(player1);
		players.add(player2);		
		assertEquals(game.displayChipNumbers(),"\nplayer1, total score: 0, chips: 50");
		
    }
	
	@Test
	public void test_roundChips() {
		game.setRoundChips(5);
		assertNotEquals(3, game.getRoundChips());
	}

	
	@Test
	public void test_game_winner()
	{
		
		game.playGameForOneRound(player1);
		game.finishRound(player1);
		game.playGameForOneRound(player2);
		game.finishRound(player2);
		game.collectChips();
		assertFalse(game.getGameWinner().contains(player1));
		assertTrue(game.getGameWinner().contains(player2));
	}
	
	@Test
	public void test_round_winner()
	{
		
		game.playGameForOneRound(player1);
		game.finishRound(player1);
		game.playGameForOneRound(player2);
		game.finishRound(player2);
		game.collectChips();
		assertTrue(game.getRoundWinner().contains(player2));
		assertTrue(game.getRoundWinner().size() == 1);
		assertEquals(55,player2.getChips());
	}	

	
	@Test
	public void test_game_instructions()
	{
		
		assertNotNull(game.getGameInstructions());
	}
	
	@Test
	public void test_displayChipNumbers() {
		assertEquals("\nPlayerOne, total score: 0, chips: 50" + 
				"\nPlayerTwo, total score: 0, chips: 50",game.displayChipNumbers());
	}
	

	
}
