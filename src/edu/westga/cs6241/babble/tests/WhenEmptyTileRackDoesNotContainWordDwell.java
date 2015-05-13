package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.TileRack;
/**
 * Tests TileRack class to make sure that canMakeWordFrom("DWELL")
 * method returns false when the TileRack is empty
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenEmptyTileRackDoesNotContainWordDwell {
	/**
	 * Checks that the word DWELL cannot be made when
	 * the TileRack is empty
	 */
	@Test
	public void testThatEmptyTileRackDoesNotHaveWordDWELL() {
		TileRack testTileRack = new TileRack(7);
		assertFalse(testTileRack.canMakeWordFrom("DWELL"));
	}

}
