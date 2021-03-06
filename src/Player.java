public class Player 
{
	private String name;
	private int totalScore;
	private int roundScore;
	private int gamesWon;
	private int lastRoundScore;
	private int chips;
	
	public Player(String name)
	{
		this.name = name;
		this.totalScore = 0;
		this.chips = 50; 
		this.gamesWon = 0;
	}

	public int getGamesWon()
	{
		return gamesWon;
	}
	
	public void setGamesWon(int gamesWon)
	{
		this.gamesWon = gamesWon;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCurrentScore()
	{
		return totalScore + roundScore;
	}

	public int getTotalScore()
	{
		return totalScore;
	}

	public void setTotalScore(int totalScore)
	{
		this.totalScore = totalScore;
	}

	public int getRoundScore()
	{
		return roundScore;
	}

	public void setRoundScore(int roundScore)
	{
		this.roundScore = roundScore;
	}

	public int getChips()
	{
		return chips;
	}

	public void setChips(int chips)
	{
		this.chips = chips;
	}

	public int getLastRoundScore()
	{
		return lastRoundScore;
	}

	public void setLastRoundScore(int lastRoundScore)
	{
		this.lastRoundScore = lastRoundScore;
	}
	
	public void clearScores() {
		totalScore = 0;
		roundScore = 0;
		lastRoundScore = 0;
		chips = 50;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + name + ", total score: " + totalScore + ", round score: " + lastRoundScore + ", chips: " + chips + ", games won: " + gamesWon;
	}
}