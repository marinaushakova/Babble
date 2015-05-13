package edu.westga.cs6241.babble.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.westga.cs6241.babble.controllers.BabbleController;

/**
 * Defines the panel that displays player's current score
 * and contains 'Start New Game' and 'Quit' buttons.
 * 
 * @author MARINA USHAKOVA
 * @version Fall 2014
 */
public class GameStatusPanel extends JPanel implements Observer {
	/**
	 * A version number of serializable class.
	 */
	private static final long serialVersionUID = 1L;
	private BabbleGUI gui;
	private BabbleController game;
	private JLabel lblScore;
	private JButton btnStartNewGame;
	
	/**
	 * Creates a new GameStatusPanel that observes the specified game. 
	 * 
	 * @param theGUI	the BabbleGUI object from which this panel gets its data
	 * 
	 * @requires 		theGUI != null
	 * @ensures			theGame.countObservers() = theGame.countObservers()@prev + 1
	 */
	public GameStatusPanel(BabbleGUI theGUI) {
		super();
		if (theGUI == null) {
			throw new IllegalArgumentException("Null BabbleGUI object");
		}
		this.gui = theGUI;
		this.game = this.gui.getGame();
		this.game.addObserver(this);
		this.lblScore = new JLabel();
	
		this.buildGameStatusPanel();
	}
	
	/*
	 * Builds GameStatusPanel, adds label and 2 buttons to it.
	 */
	private void buildGameStatusPanel() {
		this.setBorder(BorderFactory.createTitledBorder("Game status"));	
		this.add(Box.createHorizontalStrut(25));
		this.lblScore.setText("Your score: " + this.game.getScore());
		this.add(this.lblScore);
		this.add(Box.createRigidArea(new Dimension(25, 0)));
		
		this.btnStartNewGame = new JButton("Start New Game");
		this.btnStartNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(GameStatusPanel.this.gui.getMainFrame(), "Are you sure you want to start a new game?"
						+ "\nYou current progress will be lost",
						"Exit", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					GameStatusPanel.this.game.startGame();
					GameStatusPanel.this.game.refreshTileRack();
				}				
			}
		});
		this.add(this.btnStartNewGame);
		
		this.add(Box.createRigidArea(new Dimension(25, 0)));
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(GameStatusPanel.this.gui.getMainFrame(), 
						"Are you sure you want to quit the game?",
						"Exit", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}				
			}
		});
		this.add(btnQuit);
	}
	
	/**
	 * Sets this Panel's label text to show the return value of the Game's
	 * getScore() method. Called when the observed Game object notifies
	 * this Panel that a New Game was started ot Tile Bag was refreshed. 
	 * 
	 * @param obs	not used
	 * @param arg	not used
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * @ensures the panel's text displays current score
	 */
	@Override
	public void update(Observable obs, Object arg) {
		this.lblScore.setText("Your score: " + this.game.getScore());
	}
	
}
