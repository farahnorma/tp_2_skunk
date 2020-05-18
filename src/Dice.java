public class Dice
{
	private Die die1;
	private Die die2;

	public Dice(Die die1, Die die2)
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	public void roll()
	{
		die1.roll();
		die2.roll();
	}

	public int getLastRoll1()
	{
		return die1.getLastRoll();
	}

	public int getLastRoll2()
	{
		return die2.getLastRoll();
	}
	

	public int getLastTotalRoll()
	{
		return die1.getLastRoll() + die2.getLastRoll();
		
	}
}