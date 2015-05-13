package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
/**
 * Tests Tile class to make sure that new Tile cannot
 * be created with negative point value
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenMakingTileWithPointValueNegativeFour {
	/**
	 * Checks if IllegalArgumentException is thrown
	 * when trying to create a Tile with point value -4
	 */
	@Test
	public void testThrowingExceptionWhenCreatingTileWithPointValueNegative4() {
		try {
			Tile testTile = new Tile('H', -4);
			fail("IllegalArgumentException not thrown when trying to create a Tile with negative point value");
		} catch (IllegalArgumentException iae) {
			assertEquals("Invalid tile point value: must be greater than 0", iae.getMessage());
		}
	}

}
