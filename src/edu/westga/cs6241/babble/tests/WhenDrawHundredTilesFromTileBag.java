package edu.westga.cs6241.babble.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.westga.cs6241.babble.model.TileBag;
/**
 * Tests TileBag class to make sure that drawing 100 tiles
 * cause IllegalArgumentException being thrown.
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenDrawHundredTilesFromTileBag {
	
	/**
	 * Checks if IllegalArgumentException is thrown
	 * when 100 of tiles are drawn out of a TileBag
	 */
	@Test
	public void testThat100TilesCanNotBeDrawn() {
		try {
			TileBag testTileBag = new TileBag();
			for (int i = 0; i < 100; i++) {
				testTileBag.drawTile();
			}
			fail("IllegalStateException was not thrown when trying to draw a Tile out of an empty TileBag");
		} catch (IllegalStateException iae) {
			assertEquals("Invalid state: cannot draw tiles out of an empty bag", iae.getMessage());
		}
	}

}
