package edu.westga.cs6241.babble.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.westga.cs6241.babble.controllers.BabbleController;

/**
 * Subclass of JPanal.
 * Displays the Tile Rack, text field to type the word, 
 * 'Enter' button and confirmation/error label.
 * 
 * @author MARINA USHAKOVA
 * @version Fall 2014
 * 
 */
public class InteractionPanel extends JPanel implements Observer {
	/**
	 * A version number of serializable class.
	 */
	private static final long serialVersionUID = 1L;
	private BabbleGUI gui;
	private BabbleController game;
	private JTextField txtYourWord;
	private JTextField txtTileRack;
	private JLabel lblConfirmWord;
	private JLabel lblTryAgain;
	
	/**
	 * Creates a new InteractionPanel that observes the specified game. 
	 * 
	 * @param theGUI	the BabbleGUI object from which this panel gets its data
	 * 
	 * @requires 		theGUI != null
	 * @ensures			theGame.countObservers() = theGame.countObservers()@prev + 1
	 */
	public InteractionPanel(BabbleGUI theGUI) {
		super();
		if (theGUI == null) {
			throw new IllegalArgumentException("Null BabbleGUI object");
		}
		this.gui = theGUI;
		this.game = this.gui.getGame();
		this.game.addObserver(this);
		this.txtTileRack = new JTextField();
		this.txtYourWord = new JTextField();
		this.lblConfirmWord = new JLabel("");
		this.lblTryAgain = new JLabel("");
		this.buildInteractionPanel();
	}
	
	/*
	 * Adds components to the Panel
	 */
	private void buildInteractionPanel() {
		this.setBorder(BorderFactory.createTitledBorder("Your hand"));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, 50))); 
		
		this.game.refreshTileRack();
		this.txtTileRack = new JTextField(this.game.getTilesAsString());
		this.txtTileRack.setEditable(false);
		this.txtTileRack.setMaximumSize(new Dimension(200, 55));
		this.txtTileRack.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.txtTileRack.setHorizontalAlignment(JTextField.CENTER);
		Font tileRackFont = new Font("HELVETICA", Font.PLAIN, 36);
		this.txtTileRack.setFont(tileRackFont);
		this.add(this.txtTileRack);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JLabel lblYourWord = new JLabel("Type your word:");
		lblYourWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(lblYourWord);
		
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		
		this.txtYourWord = new JTextField();
		this.txtYourWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.txtYourWord.setColumns(7);
		this.txtYourWord.setMaximumSize(new Dimension(200, 55));
		this.txtYourWord.setHorizontalAlignment(JTextField.CENTER);
		this.txtYourWord.setFont(tileRackFont);
		this.add(this.txtYourWord);
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		this.addEnterButton();
		
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		this.lblConfirmWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(this.lblConfirmWord);
		this.lblTryAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.lblTryAgain.setForeground(Color.RED);
		this.add(this.lblTryAgain);
	}
	
	/*
	 * Creates and adds Enter button to the Interaction Panel 
	 */
	private void addEnterButton() {
		JButton btnAccept = new JButton("Enter");
		btnAccept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!InteractionPanel.this.txtYourWord.getText().isEmpty() && !InteractionPanel.this.txtYourWord.getText().equals("")) {	
					int guessResult = InteractionPanel.this.game.checkCandidateWord(InteractionPanel.this.txtYourWord.getText());
					switch(guessResult) {
						case BabbleController.VALID_WORD:
							InteractionPanel.this.lblConfirmWord.setForeground(Color.BLACK);
							InteractionPanel.this.lblConfirmWord.setText("Good job!");
							InteractionPanel.this.lblTryAgain.setVisible(false);
							InteractionPanel.this.lblConfirmWord.setVisible(true);
							InteractionPanel.this.game.removeWord(InteractionPanel.this.txtYourWord.getText());
							InteractionPanel.this.game.refreshTileRack();
							break;
						case BabbleController.NOT_ENOUGH_TILES:
							InteractionPanel.this.lblConfirmWord.setForeground(Color.RED);
							InteractionPanel.this.lblConfirmWord.setText("Not enough tiles to make that word.");
							InteractionPanel.this.lblTryAgain.setText("Please try again.");
							InteractionPanel.this.lblConfirmWord.setVisible(true);
							InteractionPanel.this.lblTryAgain.setVisible(true);
							break;
						case BabbleController.MISSPELLED_WORD:
							InteractionPanel.this.lblConfirmWord.setForeground(Color.RED);
							InteractionPanel.this.lblConfirmWord.setText("Misspelled word.");
							InteractionPanel.this.lblTryAgain.setText("Please try again.");
							InteractionPanel.this.lblConfirmWord.setVisible(true);
							InteractionPanel.this.lblTryAgain.setVisible(true);
							break;
						default:
							break;
					}
				}
			}
		});
		btnAccept.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(btnAccept);
		this.gui.getMainFrame().getRootPane().setDefaultButton(btnAccept);
	}

	/**
	 * Checks for the end of the game, refreshes the Tile Rack,
	 * displays confirmation/error labels, shows meddage if the game
	 * is over
	 * 
	 * @param obs	not used
	 * @param arg	not used
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * @ensures the Interaction Panel functionality is correct
	 */
	@Override
	public void update(Observable obs, Object arg) {
		if (!this.game.checkForEndGame()) {
			this.txtTileRack.setText(this.game.getTilesAsString());
			InteractionPanel.this.txtYourWord.setText("");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(InteractionPanel.this.gui.getMainFrame(), 
					"Game is over. Your final score: " + this.game.getScore()
					+ "\nWhould you like to start a new game?",
					"Game over", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				this.game.startGame();
				this.game.refreshTileRack();
			} else {
				System.exit(0);
			}
		}
		if (this.game.getLastPlayedWord().isEmpty()) {
			this.lblConfirmWord.setVisible(false);
			this.lblTryAgain.setVisible(false);
		}
		
	}
}
