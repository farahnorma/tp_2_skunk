  
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class TestDice {
	

	@Test
	public void testRoll()
	{
		testableDice dice = new testableDice();
		dice.roll();	
	}
	
	@Test
	void testString() {
        testableDice dice = new testableDice();
        assertEquals(dice.toString(), "Dice with last roll: 12 => 6 + 6");
    }
	
	@Test
	void test1() {
        testableDice dice = new testableDice();
        dice.getLastRoll();
        assertEquals(dice.getLastRoll(), 12);
    }
	@Test
	void test2() {
	testableDice dice = new testableDice();
        testableDie die1 = new testableDie();
        testableDie die2 = new testableDie();
        int total = die1.getLastRoll() + die2.getLastRoll();
	dice.getLastRoll();
	assertEquals(dice.getLastRoll(), total);
	}
	@Test
	void test3() {
	testableDice dice = new testableDice();
        dice.getLastRoll();
        assertNotEquals(dice.getLastRoll(), 13);
	}
	@Test
	void test4() {
	testableDice dice = new testableDice();
        dice.getLastRoll();
        assertNotEquals(dice.getLastRoll(), -12);
	}
	@Test
	void test5() {
	testableDice dice = new testableDice();
        dice.getLastRoll();
        assertNotEquals(dice.getLastRoll(), 1);
	}
	@Test
	void test6() {
	testableDice dice = new testableDice();
        dice.getLastRoll();
        assertNotEquals(dice.getLastRoll(), 6);
	}
	
	
}