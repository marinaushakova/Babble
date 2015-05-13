package edu.westga.cs6241.babble.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6241.babble.model.Word;
/**
 * Tests Word class to make sure that an empty word
 * has score of 0.
 * 
 * @author MARINA USHAKOVA
 * @version 11/20/2014
 *
 */
public class WhenGetScoreOfEmptyWord {
	/**
	 * Checks if an empty word has score of 0
	 */
	@Test
	public void testIfEmptyWordHasScore0() {
		Word testWord = new Word();
		
		assertEquals(0, testWord.getScore());
	}

}
