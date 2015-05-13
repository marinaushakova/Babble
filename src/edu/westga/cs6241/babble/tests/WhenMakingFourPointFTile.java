package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
/**
 * Tests Tile class to make sure that new Tile is created
 * correctly and methods getPoinValue() and getLetter() 
 * are working right.
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenMakingFourPointFTile {
	/**
	 * Checks if new Tile with letter value 'F' and
	 * point value 4 is created correctly and getter methods 
	 * of the Tile class return right values.
	 */
	@Test
	public void testCreatingTileWithLetterFandValue4() {
		Tile testTile = new Tile('F', 4);
		
		assertEquals(4, testTile.getPointValue());
		assertEquals('F', testTile.getLetter());
	}

}
