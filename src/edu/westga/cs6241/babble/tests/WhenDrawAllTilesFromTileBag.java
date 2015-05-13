package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.TileBag;

/**
 * Tests TileBag class to make sure all 98 tiles can be drawn 
 * from a TileBag and a TileBag is left empty
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenDrawAllTilesFromTileBag {
	/**
	 * Checks if Tile Bag is empty after 98 tiles have been drawn
	 */
	@Test
	public void testIfTileBagIsEmptyAfterDrawingAllTiles() {
		TileBag testTileBag = new TileBag();
		
		for (int i = 0; i < 98; i++) {
			testTileBag.drawTile();
		}
		
		assertTrue(testTileBag.isEmpty());
	}

}
