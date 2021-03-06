package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
import edu.westga.cs6241.babble.model.TileRack;
/**
 * Tests TileRack class to make sure that removeWord(String text)
 * method removes word even if tiles in a TileRack are out-of-order
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenRemoveWordWhenTilesAreOutOfOrder {
	/**
	 * Checks if after removing the word CAT from the TileRack with tiles: TAACAAA
	 * the number of tiles needed is 3 and word AAAA
	 * can be made out of tiles that are left in the TileBag
	 */
	@Test
	public void testIfWordCatIsRemovedFromTileRackWithOutOfOrderTiles() {
		TileRack testTileRack = new TileRack(7);
		
		testTileRack.append(new Tile('T', 1));
		testTileRack.append(new Tile('A', 1));
		testTileRack.append(new Tile('A', 1));
		testTileRack.append(new Tile('C', 3));
		testTileRack.append(new Tile('A', 1));
		testTileRack.append(new Tile('A', 1));
		testTileRack.append(new Tile('A', 1));
		
		testTileRack.removeWord("CAT");
		
		assertTrue(testTileRack.canMakeWordFrom("AAAA"));
		assertEquals(3, testTileRack.getNumberOfTilesNeeded());
	}

}
