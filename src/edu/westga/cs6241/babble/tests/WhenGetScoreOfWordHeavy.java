package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
import edu.westga.cs6241.babble.model.TileRack;
import edu.westga.cs6241.babble.model.Word;
/**
 * Tests Word class to make sure that append(Tile tile) method
 * and getScore() method are working correctly.
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenGetScoreOfWordHeavy {
	/**
	 * Checks if the word HEAVY has score of 14
	 */
	@Test
	public void testIfWordHeavyHasScore14() {
		Word testWord = new Word();
		
		testWord.append(new Tile('H', 4));
		testWord.append(new Tile('E', 1));
		testWord.append(new Tile('A', 1));
		testWord.append(new Tile('V', 4));
		testWord.append(new Tile('Y', 4));
		
		assertEquals(14, testWord.getScore());
	}

}
