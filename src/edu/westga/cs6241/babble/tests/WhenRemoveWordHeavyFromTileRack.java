package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
import edu.westga.cs6241.babble.model.TileRack;
/**
 * Tests TileRack class to make sure that removeWord(String text)
 * method is working correctly
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenRemoveWordHeavyFromTileRack {
	/**
	 * Checks if after removing the word HEAVY from the TileRack
	 * the number of tiles needed is 5 and another word HEAVY
	 * cannot be made out of tiles that are left in the TileBag
	 */
	@Test
	public void testIfWordHeavyIsRemovedFromTileRack() {
		TileRack testTileRack = new TileRack(7);
		
		testTileRack.append(new Tile('H', 4));
		testTileRack.append(new Tile('E', 1));
		testTileRack.append(new Tile('A', 1));
		testTileRack.append(new Tile('V', 4));
		testTileRack.append(new Tile('Y', 4));
		testTileRack.append(new Tile('H', 4));
		testTileRack.append(new Tile('X', 8));
		
		testTileRack.removeWord("HEAVY");
		
		assertEquals(5, testTileRack.getNumberOfTilesNeeded());
		assertFalse(testTileRack.canMakeWordFrom("HEAVY"));
	}

}
