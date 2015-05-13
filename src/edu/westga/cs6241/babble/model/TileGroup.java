package edu.westga.cs6241.babble.model;

import java.util.ArrayList;

/**
 * An abstract class that represent a group of tiles.
 * 
 * @author Marina Ushakova
 * @version 11/6/14
 *
 */
public abstract class TileGroup extends ArrayList<Tile> {
	
	/**
	 * A version number of serializable class.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Appends theTile to the end of a tile group
	 * 
	 * @param theTile	the tile to be appended
	 */
	public void append(Tile theTile) {
		if (theTile == null) {
			throw new IllegalArgumentException("Invalid tile object: must be not null");
		}
		this.add(theTile);
	}

	/**
	 * Removes theTile from a tile group
	 * 
	 * @param theTile	the tile to be removed
	 */
	public void remove(Tile theTile) {
		if (theTile == null) {
			throw new IllegalArgumentException("Invalid tile object: must be not null");
		}
		super.remove(theTile);
	}
	
	/**
	 * Returns the letters of the Tiles in order.
	 * 
	 * @return a String representation of the object
	 */
	@Override
	public String toString() {
		String letterString = "";
		for (Tile current : this) {
			letterString += current.getLetter();
		}
		return letterString;
	}
	
	/**
	 * Returns the whole group of tiles.
	 * 
	 * @return	the ArrayList of tiles in the group
	 */
	public ArrayList<Tile> getTiles() {
		return this;
	}
}
