package edu.westga.cs6241.babble.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Defines the panel that displays list of composed words.
 * 
 * @author MARINA USHAKOVA
 * @version Fall 2014
 */
public class WordListPanel extends JPanel implements Observer {
	/**
	 * A version number of serializable class.
	 */
	private static final long serialVersionUID = 1L;
	private BabbleGUI gui;
	private JScrollPane areaScrollPane;
	private JTextPane txtWordList;
	
	/**
	 * Creates a new WordListPanel that observes the specified game. 
	 * 
	 * @param theGUI	the BabbleGUI object from which this panel gets its data
	 * 
	 * @requires 		theGUI != null
	 * @ensures			theGame.countObservers() = theGame.countObservers()@prev + 1
	 */
	public WordListPanel(BabbleGUI theGUI) {
		if (theGUI == null) {
			throw new IllegalArgumentException("Null BabbleGUI object");
		}
		this.gui = theGUI;
		this.gui.getGame().addObserver(this);
		
		this.txtWordList = new JTextPane();
		this.areaScrollPane = new JScrollPane(this.txtWordList);
		this.buildWordListPanel();
	}
		
	/*
	 * Builds WordListPanel, adds JTextPane to it.
	 */
	private void buildWordListPanel() {
		this.setBorder(BorderFactory.createTitledBorder("Word List"));
		
		StyledDocument doc = this.txtWordList.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	
		this.txtWordList.setEditable(false);
		this.txtWordList.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		this.txtWordList.setFont(new Font("HELVETICA", Font.PLAIN, 20));
		this.areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.areaScrollPane.setPreferredSize(new Dimension(200, 350));
			
		this.add(this.areaScrollPane, BorderLayout.NORTH);
		/*
		JCheckBox chkBoxShowWordList = new JCheckBox("Don't display words in Word List", false);
		if (chkBoxShowWordList.isSelected()) {
			this.txtWordList.setText("");
			this.txtWordList.setEnabled(false);
		}
		this.add(chkBoxShowWordList, BorderLayout.SOUTH);
		*/
	}
	
	/**
	 * Adds a new word to the word list. Called when the observed Game object notifies
	 * this Panel that a Tile Bag was refreshed. 
	 * 
	 * @param obs	not used
	 * @param arg	not used
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * @ensures last played word is added to the word list
	 */
	@Override
	public void update(Observable obs, Object arg) {
		if (!this.gui.getGame().getLastPlayedWord().isEmpty()) {
			String wordList = this.txtWordList.getText();
			this.txtWordList.setText(wordList + this.gui.getGame().getLastPlayedWord() + "\n");
		} else {
			this.txtWordList.setText("");
		}
		
	}
}
