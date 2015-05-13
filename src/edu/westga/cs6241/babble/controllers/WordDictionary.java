

package edu.westga.cs6241.babble.controllers;

import pt.tumba.spell.*;

/**
 * Spell checker for words we attempt to make with Babble
 * @author lewisb
 *
 */
public class WordDictionary {

	private SpellChecker checker;
	
	/**
	 * Creates a new WordDictionary
	 */
	public WordDictionary()
	{
		this.checker = new SpellChecker();

			try {
				this.checker.initialize("./english.txt");
			} catch (Exception e) {
				System.err.println("Wrong path to dictionary file");
				e.printStackTrace();
			}
	}
	
	/**
	 * Determines if a word is a real word or not.
	 * 
	 * @param s the word to check
	 * @return true if a valid word, false if gibberish
	 */
	public boolean isValidWord(String s)
	{
		String check = this.checker.spellCheckWord(s);
		return check.contains("<plain>");
	}
}
