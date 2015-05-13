package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
/**
 * Tests Tile class to make sure that new Tile cannot
 * be created with lower case letter value
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenMakingTileWithLetterh {
	/**
	 * Checks if IllegalArgumentException is thrown
	 * when trying to create a Tile with letter value 'h'
	 */
	@Test
	public void testThrowingExceptionWhenCreatingTileWithValueh() {
		try {
			Tile testTile = new Tile('h', 4);
			fail("IllegalArgumentException not thrown when trying to create a Tile with lower case letter");
		} catch (IllegalArgumentException iae) {
			assertEquals("Invalid tile letter value: must be an upper case letter", iae.getMessage());
		}
		
	}

}
