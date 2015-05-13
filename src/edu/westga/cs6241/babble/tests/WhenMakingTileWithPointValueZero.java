package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
/**
 * Tests Tile class to make sure that new Tile cannot
 * be created with point value 0
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenMakingTileWithPointValueZero {
	/**
	 * Checks if IllegalArgumentException is thrown
	 * when trying to create a Tile with point value 0
	 */
	@Test
	public void testThrowingExceptionWhenCreatingTileWithPointValue0() {
		try {
			Tile testTile = new Tile('H', 0);
			fail("IllegalArgumentException not thrown when trying to create a Tile with 0 point value");
		} catch (IllegalArgumentException iae) {
			assertEquals("Invalid tile point value: must be greater than 0", iae.getMessage());
		}
	}

}
