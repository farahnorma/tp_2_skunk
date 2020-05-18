import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	public void testPlayer()
	{
		Player p = new Player("Norma");
		assertNotNull(p);
	}
	
	@Test
	public void testSetTotalScore()
	{
		Player p = new Player("Norma");
		p.setTotalScore(10);
		int points = p.getTotalScore();
		assertTrue(points == 10);
	}
	
	@Test
	public void testGetRoundsetRoundScore()
	{
		Player p = new Player("Norma");
		p.setRoundScore(4);
		assertTrue(p.getRoundScore() == 4);
	}
	
	@Test
	public void testGetPlayerName()
	{
		String name = "Norma";
		Player p = new Player(name);
		assertTrue(p.getName() == name);
	}
	
	@Test
	public void testSetPlayerName()
	{
		String name = "Norma";
		Player p = new Player("");
		p.setName(name);
		assertTrue(p.getName() == name);
	}
	
	@Test
	public void testGetChipsSetChips()
	{
		Player p = new Player("Norma");
		p.setChips(55);
		assertTrue(p.getChips() == 55);
	}
	
	@Test
	public void testToString()
	{
		Player p = new Player("Norma");
		System.out.println(p.toString());
		assertEquals("Name: Norma, total score: 0, round score: 0, chips: 50, games won: 0", p.toString());
	}
	
	@Test
	public void testClearScore()
	{
		Player p = new Player("Norma");
		p.setLastRoundScore(1);
		p.setRoundScore(1);
		p.setTotalScore(1);
		p.clearScores();
		assertEquals(0,p.getLastRoundScore());
		assertEquals(0,p.getTotalScore());
		assertEquals(0,p.getRoundScore());
	}
	
	@Test
	public void testGamesWon()
	{
		Player p = new Player("Norma");
		p.setGamesWon(1);
		assertEquals(1, p.getGamesWon());
	}
	
}
