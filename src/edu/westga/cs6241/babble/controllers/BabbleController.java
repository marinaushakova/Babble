package edu.westga.cs6241.babble.controllers;

import java.util.Observable;
import java.util.Scanner;

import javax.swing.ListModel;

import edu.westga.cs6241.babble.model.Tile;
import edu.westga.cs6241.babble.model.TileBag;
import edu.westga.cs6241.babble.model.TileRack;
import edu.westga.cs6241.babble.model.Word;

public class BabbleController extends Observable {

	public static final int VALID_WORD = 0;
	public static final int MISSPELLED_WORD = 1;
	public static final int NOT_ENOUGH_TILES = 2;
	
	private TileBag bag;
	private WordDictionary dictionary;
	private TileRack rack;
	private int score;
	private Word lastPlayedWord;
	
	/**
	 * Creates a new BabbleController.
	 */
	public BabbleController()
	{
		this.bag = null;
		this.rack = null;
		this.score = 0;
		this.dictionary = new WordDictionary();
		this.lastPlayedWord = new Word();
	}
	
	/**
	 * Initializes a new game.  This must be called before any other methods.
	 */
	public void startGame()
	{
		this.bag = new TileBag();
		this.rack = new TileRack(7);
		this.lastPlayedWord = new Word();
		this.score = 0;
		super.setChanged();
		super.notifyObservers("start");
	}
	
	/**
	 * Fills (or tops off) the tile rack up to its maximum (if possible)
	 */
	public void refreshTileRack()
	{
		this.checkState();
		int numberOfTilesToDraw = this.rack.getNumberOfTilesNeeded();
		for(int i=0; i<numberOfTilesToDraw; i++)
		{
			if(this.bag.isEmpty()) break;
			Tile tile;
			tile = this.bag.drawTile();
			this.rack.append(tile);
		}
		super.setChanged();
		super.notifyObservers("refresh");
	}
	
	/**
	 * Called at the beginning of the action methods (other than startGame()) to insure the rack and bag are not null.
	 */
	private void checkState()
	{
		if(this.bag == null || this.rack == null)
		{
			throw new IllegalStateException("Must call startGame() before any other methods");
		}
	}
	
	/**
	 * Gets all the Tiles on this rack as a string
	 * 
	 * @return the tiles' values, in order
	 */
	public String getTilesAsString()
	{
		this.checkState();
		return this.rack.toString();
	}
	
	/**
	 * Gets the total score earned so far
	 * 
	 * @return the score
	 */
	public int getScore()
	{
		return this.score;
	}
	
	/**
	 * Checks if a candidate word is good or not.
	 * 
	 * @param candidateText the word to check
	 * @return BabbleController.VALID_WORD if text is a usable word, BabbleController.MISSPELLED_WORD if cannot find text in the dictionary, BabbleController.NOT_ENOUGH_TILES if the current tile rack does not have the tiles to make the given word 
	 */
	public int checkCandidateWord(String candidateText)
	{	this.checkState();
		String normalizedText = candidateText.toUpperCase();
		if(!rack.canMakeWordFrom(normalizedText))
		{
			return NOT_ENOUGH_TILES;
		}
		else if(!this.dictionary.isValidWord(normalizedText))
		{
			return MISSPELLED_WORD;
		}
		else 
		{
			return VALID_WORD;
		}
	}
	
	/**
	 * Removes and returns the Word made from the tiles in text.
	 * @param text the tiles to remove
	 */
	public void removeWord(String text)
	{
		this.checkState();
		String normalizedText = text.toUpperCase();
		if(this.checkCandidateWord(normalizedText) != VALID_WORD)
		{
			throw new IllegalArgumentException("Cannot remove an invalid word / word requiring too many tiles");
		}
		
		this.lastPlayedWord = this.rack.removeWord(normalizedText);
		this.score += this.lastPlayedWord.getScore();
	}
	
	/**
	 * Game is over if the bag is empty
	 * 
	 * @return true if the game is over, false otherwise
	 */
	public boolean checkForEndGame()
	{
		this.checkState();
		return this.bag.isEmpty();
	}
	
	public String getLastPlayedWord() {
		return this.lastPlayedWord.toString();
	}

}
