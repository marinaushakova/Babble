package edu.westga.cs6241.babble.model;

/**
 * Subclass of the TileGroup class.
 * Represents a group of Tiles and has functionality
 * to calculate the score of the word.
 * 
 * @author Marina Ushakova
 * @version 11/6/14
 *
 */
@SuppressWarnings("serial")
public class Word extends TileGroup {
	
	/**
	 * Returns the score of the word.
	 * 
	 * @return 	the sum of point values for each letter in the word.
	 */
	public int getScore() {
		int score = 0;
		for (Tile current : this) {
			score += current.getPointValue();
		}
		return score;
	}
}
