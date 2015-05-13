package edu.westga.cs6241.babble.model;

/**
 * Subclass of the TileGroup class.
 * Represents a group of Tiles that is used as 
 * a tile rack in a Scrabble game.
 * 
 * @author Marina Ushakova
 * @version 11/6/14
 *
 */
@SuppressWarnings("serial")
public class TileRack extends TileGroup {
	private int maxSize;
	
	/**
	 * Initiates a TileRack object.
	 * Sets a value of a maxSize variable.
	 * 
	 * @param size	value of TileRack maximum size.
	 */
	public TileRack(int size) {
		if (size < 1 || size > 98) {
			throw new IllegalArgumentException("Invalid size of the TileRack: must be greater than 0 and less than 98");
		}
		this.maxSize = size;
	}

	/**
	 * Removes a word from a TileRack.
	 * 
	 * @param text	word being removed.
	 * @return		Word object of the removed word.
	 */
	public Word removeWord(String text) {
		if (text == null) {
			throw new IllegalArgumentException("Invalid text object: can not be null");
		}
		if (text.equals("")) {
			throw new IllegalArgumentException("Invalid text object: can not be empty");
		}
		
		Word theWord = new Word();
		for (int i = 0; i < text.length(); i++) {
			for (Tile current : this) {
				if (text.charAt(i) == current.getLetter()) {
					theWord.append(current);
					this.remove(current);
					break;
				}
			}
		}
		return theWord;
	}
	
	/**
	 * Returns a number of tiles needed to be moved to 
	 * the tile rack for it to be full.
	 * 
	 * @return	the number of tiles missing in a TileRack.
	 */
	public int getNumberOfTilesNeeded() {
		return this.maxSize - this.getTiles().size();
	}
	
	/**
	 * Returns true if all of the letters of text
	 * are present in the TileRack, and false if otherwise.
	 * 
	 * @param text	string containing the letters 
	 * 					which are being checked on presence in the TileRack.
	 * @return		true if all of the letters in text are present in the TileRack,
	 * 				false if at lease one letter is not in the TileRack.
	 */
	public boolean canMakeWordFrom(String text) {
		if (text == null) {
			throw new IllegalArgumentException("Invalid text object: can not be null");
		}
		if (text.equals("")) {
			throw new IllegalArgumentException("Invalid text object: can not be empty");
		}
		
		boolean currentLetterExists = false;
		for (int i = 0; i < text.length(); i++) {
			for (Tile current : this.getTiles()) {
				if (text.charAt(i) == current.getLetter()) {
					currentLetterExists = true;
				}
			}
			if (!currentLetterExists) {
				return false;
			}
			currentLetterExists = false;
		}
		return true;
	}
}
