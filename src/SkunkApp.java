import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class SkunkApp
{

	public static void main(String[] args)
	{
		Die d1 = new Die();
		Die d2 = new Die();
		List<Player> players = new ArrayList<Player>();
		int num;
		StdOut.println("How many players would like to play? ");
		num = StdIn.readInt();
			
		
		for (int i = 0; i < num; i++)
		{
			StdOut.println("Enter the name of player: " + (i + 1));
			String name = StdIn.readString();
			players.add(new Player(name));
		}

		SingleGame game = new SingleGame(d1, d2, players);
		StdOut.println("There are " + players.size() + " players");
		for(int i = 0; i < players.size(); i++)
		{
			StdOut.println(players.get(i).getName());
		}
		StdOut.println("\nWould you like to read the rules of the game?(y/n)");
		String a = StdIn.readString();
		if (a.equals("y"))
		{
			StdOut.println(game.getGameInstructions());
		}

		do
		{
			//boolean gameOn =true;
			int roundNumber = 0;
outterloop: 	while (roundNumber<=20)
			{
				StdOut.println("Round: " + (roundNumber + 1));
				for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();)
				{
					Player Player = (Player) iterator.next();
					StdOut.println("Your turn " + Player.getName()
						+ " (score: "+ Player.getCurrentScore() +", chips: "+ Player.getChips() +")");
					StdOut.println("\nThe Scoreboard is: ");
					for(Iterator iterator1 = players.iterator(); iterator1.hasNext();)
					{
						Player Player1 = (Player) iterator1.next();
						StdOut.println("\n" + Player1.getName() + ": total score: " + Player1.getTotalScore() + ", chips: " + Player1.getChips());
					}
					
					boolean continueGame = true;
					while (continueGame)
					{
						StdOut.println("\nWould you like to roll the dice(y/n)?");
						String d = StdIn.readString();
						if (d.equals("n"))
						{
							Player.setLastRoundScore(Player.getRoundScore());
							game.finishRound(Player);
							if (Player.getCurrentScore() >= 100)
							{
								StdOut.println("\n" + Player.getName() + "'s total score is: " + Player.getCurrentScore());
								StdOut.println("Your score is more than 100.");
								StdOut.println("The game winner is: " + Player.getName());
								Player.setLastRoundScore(Player.getRoundScore());
								game.finishRound(Player);
								
								for(int i = 0; i < players.size(); i++)
								{
									Player p = players.get(i);
									if (p != Player)
									{	
										StdOut.println("\n" + p.getName() + " You can try to reach 100.");
										boolean continueRoundGame = true;
										while (continueRoundGame)
										{
											StdOut.println("\n" + p.getName() + " Would you like to roll the dice(y/n)?");
											d = StdIn.readString();
											if (d.equals("n"))
											{
												p.setLastRoundScore(p.getRoundScore());
												game.finishRound(p);
												if (p.getCurrentScore() >= 100)
												{
													StdOut.println(p.getName() + "'s total score is: " + p.getCurrentScore());
													StdOut.println("Your score is more than 100.");
													StdOut.println("The game winner is: " + p.getName());
													p.setLastRoundScore(p.getRoundScore());
													p.setGamesWon(p.getGamesWon() + 1);
													game.finishRound(p);
													break;
											
												}
												break;
											}
											
											else
											{
												continueGame = game.playGameForOneRound(p);
											}
										}
									}
								}
								break outterloop;
							}
							break;
						}
						continueGame = game.playGameForOneRound(Player);
							
					}
					StdOut.println("Your turn is over, " + Player.getName()
							+ " (Total score: "+ Player.getCurrentScore() +", round score: " + Player.getLastRoundScore() + ", chips: "+ Player.getChips() +")");
					StdOut.println("Chips in kitty: " + game.getRoundChips());
					
				}


				StdOut.println("Round "+ (roundNumber + 1) +" is finished.");
				StdOut.println("Round "+ (roundNumber + 1) +" leader:");
				List<Player> list = game.getRoundWinner();
				if (list != null) {
					for (Iterator iterator = list.iterator(); iterator.hasNext();)
					{
						Player Player = (Player) iterator.next();
						StdOut.println(Player);
					}
				}
				roundNumber++;
			}
			
			game.collectChips();
			StdOut.println(game.displayChipNumbers());
			StdOut.println("Game Over");
			StdOut.println("Collected chips.");
			StdOut.println("This game's winner:");
			List<Player> list = game.getGameScoreWinner();
				if (list != null) {
				for (Iterator iterator = list.iterator(); iterator.hasNext();)
				{
					Player Player = (Player) iterator.next();
					Player.setGamesWon(Player.getGamesWon() + 1);
					StdOut.println(Player);
				}
			}
			StdOut.println("\nPlay Again?(y/n)");
			String y = StdIn.readString();
			if (y.equals("y"))
			{
				for (Iterator iterator = players.iterator(); iterator.hasNext();)
				{
					Player Player = (Player) iterator.next();
					Player.clearScores();
					StdOut.println(Player);
				}
				continue;
			}
			else
			{
				break;
			}

		}
		while (true);
		StdOut.println("End");
		StdOut.println("WINNER:");
		List<Player> list = game.getGameWinner();
		if (list != null) {
			for (Iterator iterator = list.iterator(); iterator.hasNext();)
			{
				Player Player = (Player) iterator.next();
				StdOut.println(Player);
			}
		}

	}

}