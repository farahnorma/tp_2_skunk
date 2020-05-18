import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.princeton.cs.introcs.StdOut;


public class SingleGame
{
	Dice dice;
	Die die1;
	Die die2;
	int numberOfPlayers;
	int roundNumber;
	int roundChips;
	
	Player roundWinner;
	List<Player> players = new ArrayList<Player>();

	public SingleGame(Die Die1, Die Die2, List<Player> players)
	{
		this.dice = new Dice(Die1, Die2);
		this.die1 = Die1;
		this.die2 = Die2;
		this.players = players;
	}

	
	public SingleGame(testableDie die12, testableDie die22, List<Player> players2) {
		// TODO Auto-generated constructor stub
	}


	public List<Player> getRoundWinner()
	{
		int maxScore = players.get(0).getLastRoundScore();
		for (int i = 1; i < players.size(); i++)
		{
			if(maxScore < players.get(i).getLastRoundScore()) 
			{
				maxScore = players.get(i).getLastRoundScore();
			}
		}
		
		List<Player> roundWinner = new ArrayList<>();
		for (int i = 0; i < players.size(); i++)
		{
			if(maxScore == players.get(i).getLastRoundScore()) 
			{
				roundWinner.add(players.get(i));
			}
		}
		return roundWinner;
	}
	
	public List<Player> getGameScoreWinner()
	{
		int maxScore = players.get(0).getTotalScore();
		for (int i = 1; i < players.size(); i++)
		{
			if(maxScore < players.get(i).getTotalScore()) 
			{
				maxScore = players.get(i).getTotalScore();
			}
		}
		
		List<Player> gameWinner = new ArrayList<>();
		for (int i = 0; i < players.size(); i++)
		{
			if(maxScore == players.get(i).getTotalScore()) 
			{
				gameWinner.add(players.get(i));
			}
		}
		return gameWinner;
	}
	

	public List<Player> getGameWinner()
	{
		int maxScore = players.get(0).getChips();
		for (int i = 1; i < players.size(); i++)
		{
			if(maxScore < players.get(i).getChips()) 
			{
				maxScore = players.get(i).getChips();
			}
		}
		
		List<Player> gameWinner = new ArrayList<>();
		for (int i = 0; i < players.size(); i++)
		{
			if(maxScore == players.get(i).getChips()) 
			{
				gameWinner.add(players.get(i));
			}
		}
		
		return gameWinner;
	}

	public boolean playGameForOneRound(Player player)
	{
		
		this.dice.roll();
		StdOut.println("Die one rolled: " + this.dice.getLastRoll1());
		StdOut.println("Die two rolled: " + this.dice.getLastRoll2());
		int rollScore = this.dice.getLastTotalRoll();
		
		if (rollScore == 2) 
		{
			player.setTotalScore(0);
			player.setChips(player.getChips() - 4);
			StdOut.println("\nDouble skunk! Lose all accumulated points. " + player.getChips() + " chips left.");
			player.setRoundScore(0);
			roundChips = roundChips + 4;
			finishRound(player);
			return false;
		} 
		else if (dice.getLastRoll1() == 1 || dice.getLastRoll2() == 1) 
		{
			if (rollScore == 3) 
			{
				player.setChips(player.getChips() - 2);
				StdOut.println("\nOne skunk and a duece. You have " + player.getChips() + " chips left");
				roundChips = roundChips + 2;
			}
			else 
			{
				player.setChips(player.getChips() - 1);
				StdOut.println("\nOne skunk. " + player.getChips() + " chips left.");
				roundChips ++;
			}
			
			player.setRoundScore(0);
			finishRound(player);
			return false;
		}
		
		else
		{
			player.setRoundScore(player.getRoundScore() + rollScore);
			
			StdOut.println("Your total score is: " + player.getCurrentScore());
		
		}
		return true;
	}
	
	
	public void finishRound(Player player)
	{
		int roundScore = player.getRoundScore();
		player.setTotalScore(player.getTotalScore() + roundScore);
		player.setRoundScore(0);
		player.setLastRoundScore(roundScore);
	}
	
	
	public String getGameInstructions() 
	{
		return "Rules: "
    			+ "\nEvery player rolls dice twice per turn."
    			+ "\nIf both rolls have the same value, the player scores twice the sum of the two dice rolls."
    			+ "\nIf both rolls have different values, the player scores the sum of the rolls."
    			+ "\nFor each player, the result is cummulated after each turn."
    			+ "\nFirst player to reach or exceed 100 wins";
	}
	
	public int getRoundChips()
	{
		return roundChips;
	}

	public void setRoundChips(int roundChips)
	{
		this.roundChips = roundChips;
	}

	public void collectChips()
	{
		List<Player> list = getRoundWinner();
		
		for (int i = 0; i < players.size(); i++)
		{
			Player p = players.get(i);
			if (!list.contains(p)) {
				int k = 0;
				if (p.getTotalScore() == 0) {
					k = 10;
				} else {
					k = 5;
				}
				p.setChips(p.getChips() - k);
				roundChips = roundChips + k;
			}
		}
		
		for (int i = 0; i < list.size(); i++)
		{
			Player p = list.get(i);
			p.setChips(p.getChips() + roundChips / list.size());
		}
		roundChips = roundChips % list.size();		
	}
	
	public String displayChipNumbers()
	{
		String str = "";
		for (int i = 0; i < players.size(); i++) 
		{	
			Player p = players.get(i);
			str = str + "\n" + p.getName() + ", total score: " + p.getTotalScore()
			+ ", chips: " + p.getChips();
		}
		return str;
	}
	
}