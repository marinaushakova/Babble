package edu.westga.cs6241.babble.views;

import java.util.Scanner;

import edu.westga.cs6241.babble.controllers.BabbleController;

/**
 * Provides the Babble Game with the TUI
 * 
 * @author MARINA USHAKOVA
 * @version Fall 2014
 *
 */
public class BabbleTUI {

	/**
	 * Runs Babble Game TUI
	 */
	public void run() {
		BabbleController game = new BabbleController();
		Scanner scanner = new Scanner(System.in);
		game.startGame();
		
		while (!game.checkForEndGame()) {
			game.refreshTileRack();
			System.out.println("Current score: " + game.getScore());
			System.out.println("Current hand: " + game.getTilesAsString());
			System.out.print("Word?> ");
			String myGuess = scanner.next();
			int guessResult = game.checkCandidateWord(myGuess);
			switch(guessResult) {
				case BabbleController.VALID_WORD:
					System.out.println("Good job!");
					game.removeWord(myGuess);
					break;
				case BabbleController.NOT_ENOUGH_TILES:
					System.out.println("Not enough tiles to make that word. Please try again.");
					break;
				case BabbleController.MISSPELLED_WORD:
					System.out.println("Misspelled word.  Please try again.");
					break;
				default:
					break;
			}
		}
		System.out.println("Game over!");
		System.out.println("Final score: " + game.getScore());
		scanner.close();
	}

}
