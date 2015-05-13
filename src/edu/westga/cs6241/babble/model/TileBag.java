package edu.westga.cs6241.babble.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a bag of tiles.
 * Generates an initial set of tiles that decrease
 * in number every time player draw from a bag.
 * 
 * @author Marina Ushakova
 * @version 11/6/14
 */
public class TileBag extends ArrayList<Tile> {

	
	/**
	 * A version number of serializable class.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a TileBag object, fills it with Tiles
	 * according to Scrabble letter distribution.
	 */
	public TileBag() {
		for (int i = 0; i < 12; i++) {
			this.add(new Tile('E', 1));
		}
		for (int i = 0; i < 9; i++) {
			this.add(new Tile('A', 1));
			this.add(new Tile('I', 1));
		}
		for (int i = 0; i < 8; i++) {
			this.add(new Tile('O', 1));
		}
		for (int i = 0; i < 6; i++) {
			this.add(new Tile('N', 1));
			this.add(new Tile('R', 1));
			this.add(new Tile('T', 1));
		}
		for (int i = 0; i < 4; i++) {
			this.add(new Tile('L', 1));
			this.add(new Tile('S', 1));
			this.add(new Tile('U', 1));
			this.add(new Tile('D', 2));
		}
		for (int i = 0; i < 3; i++) {
			this.add(new Tile('G', 2));
		}
		for (int i = 0; i < 2; i++) {
			this.add(new Tile('B', 3));
			this.add(new Tile('C', 3));
			this.add(new Tile('M', 3));
			this.add(new Tile('P', 3));
			this.add(new Tile('F', 4));
			this.add(new Tile('H', 4));
			this.add(new Tile('V', 4));
			this.add(new Tile('W', 4));
			this.add(new Tile('Y', 4));
		}
		this.add(new Tile('K', 5));
		this.add(new Tile('J', 8));
		this.add(new Tile('X', 8));
		this.add(new Tile('Q', 10));
		this.add(new Tile('Z', 10));
	}

	/**
	 * Randomly chooses one tile from a TileBag, returns it and
	 * removes it from a TileBag.
	 * 
	 * @return randomly chosen Tile
	 */
	public Tile drawTile() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Invalid state: cannot draw tiles out of an empty bag");
		}
		Random generator = new Random();
		Tile randomTile = this.remove(generator.nextInt(this.size()));
		return randomTile;
	}
	
	/**
	 * Checks if a TileBag is empty:
	 *  returns True if it is and False is it's not
	 *  
	 * @return 	true if tile bag is empty,
	 * 			false if tile bag still has tiles left in it
	 */
	public boolean isEmpty() {
		return (this.size() == 0);
	}
}
