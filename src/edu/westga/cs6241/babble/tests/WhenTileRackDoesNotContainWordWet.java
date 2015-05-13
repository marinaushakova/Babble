package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Tile;
import edu.westga.cs6241.babble.model.TileRack;
/**
 * Tests TileRack class to make sure that canMakeWordFrom("WET")
 * method returns false when the TileRack has following tile in it: HEAVYHX
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenTileRackDoesNotContainWordWet {
	/**
	 * Checks that the word WET cannot be made out of HEAVYHX tiles
	 * in the TileRack
	 */
	@Test
	public void testThatTileRackDoesNotHaveWordWET() {
		TileRack testTileRack = new TileRack(7);
		
		testTileRack.append(new Tile('H', 4));
		testTileRack.append(new Tile('E', 1));
		testTileRack.append(new Tile('A', 1));
		testTileRack.append(new Tile('V', 4));
		testTileRack.append(new Tile('Y', 4));
		testTileRack.append(new Tile('H', 4));
		testTileRack.append(new Tile('X', 8));
		
		assertFalse(testTileRack.canMakeWordFrom("WET"));
	}

}
