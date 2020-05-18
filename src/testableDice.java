import edu.princeton.cs.introcs.StdOut;

public class testableDice{
	private int lastRoll;
	testableDie die1;
	private testableDie die2;
	static int doubleSkunkCount=0;

	
	public testableDice()
	{
		this.die1 = new testableDie();
		this.die2 = new testableDie();
		this.roll();
	}

	public testableDice(testableDie die1, testableDie die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		

		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();

	}



	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}


	
}
