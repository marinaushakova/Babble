package edu.westga.cs6241.babble.model;

/**\
 * 
 * Implements a single tile that has a letter value
 * and a point value.
 * 
 * @author Marina Ushakova
 * @version 11/6/2014
 *
 */
public class Tile {

	private char letter;
	private int pointValue;
	
	/**
	 * Initiates a Tile object
	 * 
	 * @param letter	letter value of a Tile
	 * @param value		point value of a Tile
	 */
	public Tile(char letter, int value) {
		if (letter < 'A' || letter > 'Z') {
			throw new IllegalArgumentException("Invalid tile letter value: must be an upper case letter");
		}
		if (value <= 0) {
			throw new IllegalArgumentException("Invalid tile point value: must be greater than 0");
		}
		this.letter = letter;
		this.pointValue = value;
	}
	
	/**
	 * Getter method that returns a letter value of a tile
	 * 
	 * @return	a letter value of a tile
	 */
	public char getLetter() {
		return this.letter;
	}
	
	/**
	 * Getter method that returns a point value of a tile
	 * 
	 * @return	a point value of a tile
	 */
	public int getPointValue() {
		return this.pointValue;
	}

}
