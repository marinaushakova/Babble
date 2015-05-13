package edu.westga.cs6241.babble.views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.westga.cs6241.babble.controllers.BabbleController;
/**
 * Defines the GUI for the Babble Game.
 *  
 * @author MARINA USHAKOVA
 * @version Fall 2014
 */
public class BabbleGUI {
	private BabbleController game;
	private JFrame babbleFrame;
	private BabbleMenuBar menuBar;
	
	/**
	 * Creates a Gui object to provide the view for Babble Game
	 * 
	 * @ensures	 the GUI is displayed
	 */
	public BabbleGUI() {
		this.game = new BabbleController();
		this.babbleFrame = new JFrame("Babble Game - CS6241");
	}
	
	/**
	 * The game being played
	 * 
	 * @return	current BabbleController object
	 */
	public BabbleController getGame() {
		return this.game;
	}
	
	/**
	 * Returns the main frame
	 * 
	 * @return	the main frame of the game
	 */
	public JFrame getMainFrame() {
		return this.babbleFrame;
	}
	
	/**
	 * Starts the game, creates frame, adds NimMenuBar, GamePanel. 
	 * Packs the main frame and sets it visible.
	 */
	public void run() {
		this.game.startGame();
		try {
			this.babbleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			this.babbleFrame.getContentPane().add(new GamePanel(this));
			this.menuBar = new BabbleMenuBar(this);
			this.babbleFrame.setJMenuBar(this.menuBar);
			this.babbleFrame.pack();
			this.babbleFrame.setVisible(true);
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage());
		}
		
	}
}
