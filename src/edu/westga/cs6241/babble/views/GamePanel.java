package edu.westga.cs6241.babble.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
/**
 * Defines the panel that contains three other panels: 
 * WordListPanel, InteractionPanel and GameStatusPanel.
 * 
 * 
 * @author MARINA USHAKOVA
 * @version Fall 2014
 */
public class GamePanel extends JPanel {

	/**
	 * A version number of serializable class.
	 */
	static final long serialVersionUID = 42L;
	private BabbleGUI gui;
	
	/**
	 * Creates a new GamePanel. Adds three other panels to it.
	 * 
	 * @param theGUI	the BabbleGUI object from which this panel gets its data
	 * 
	 * @requires 		theGUI != null
	 */
	public GamePanel(BabbleGUI theGUI) {
		super();
		if (theGUI == null) {
			throw new IllegalArgumentException("Invalid BabbleGUI object: has to be not null");
		}
		
		this.gui = theGUI;
		
		this.setPreferredSize(new Dimension(500, 450));
		this.setLayout(new BorderLayout());
		
		WordListPanel pnlWordList = new WordListPanel(this.gui);
		this.add(pnlWordList, BorderLayout.WEST);
		
		InteractionPanel pnlInteraction = new InteractionPanel(this.gui);
		this.add(pnlInteraction, BorderLayout.CENTER);
		
		GameStatusPanel pnlGameStatus = new GameStatusPanel(this.gui);
		this.add(pnlGameStatus, BorderLayout.SOUTH);
	}
	
	
}
