package edu.westga.cs6241.babble.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import edu.westga.cs6241.babble.controllers.BabbleController;

/**
 * Defines the menu bar that lets user start new game, exit the game, 
 * and show game info.
 * 
 * @author MARINA USHAKOVA
 * @version Fall 2014
 */
public class BabbleMenuBar extends JMenuBar {

	/**
	 * A version number of serializable class.
	 */
	private static final long serialVersionUID = 1L;
	private BabbleGUI gui;
	private JMenu menu;
	
	/**
	 * Creates a new BabbleMenuBar. 
	 * 
	 * @param theGUI	the BabbleGUI object from which this babbleMenuBar gets its data
	 * 
	 * @requires 		theGui != null
	 */
	public BabbleMenuBar(BabbleGUI theGUI) {
		if (theGUI == null) {
			throw new IllegalArgumentException("Invalid BabbleGUI object: has to be not null");
		}
		
		this.gui = theGUI;
		this.buildMenuBar();
	}
	
	//****************************** private helper methods *******************
	
	/*
	 * Creates 2 menus and adds them to the menuBar
	 */
	private void buildMenuBar() {

		this.buildFileMenu();
		this.buildHelpMenu();

	}
	
	/*
	 * Creates File menu and adds it the menu bar
	 */
	private void buildFileMenu() {
		this.menu = new JMenu("File");
		this.menu.setMnemonic(KeyEvent.VK_F);
		this.menu.getAccessibleContext().setAccessibleDescription("File menu");

		JMenuItem menuItem = new JMenuItem("New game", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(BabbleMenuBar.this.gui.getMainFrame(), 
						"Are you sure you want to start a new game?"
						+ "\nYou current progress will be lost",
						"Exit", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					BabbleMenuBar.this.gui.getGame().startGame();
					BabbleMenuBar.this.gui.getGame().refreshTileRack();
				}				
			}
		});
		this.menu.add(menuItem);

		this.menu.addSeparator();

		menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(BabbleMenuBar.this.gui.getMainFrame(), 
						"Are you sure you want to quit the game?",
						"Exit", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}				
			}
		});
		this.menu.add(menuItem);

		this.add(this.menu);
	}

	
	/*
	 * Creates Help menu and adds it to the menu bar
	 */
	private void buildHelpMenu() {
		this.menu = new JMenu("Help");
		this.menu.setMnemonic(KeyEvent.VK_H);
		this.menu.getAccessibleContext().setAccessibleDescription("Help menu");

		JMenuItem menuItem = new JMenuItem("Help", KeyEvent.VK_E);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String helpMessage = "\nBabble Game rules: \n\nIt's a single-player game. \n"
						+ "Try to make valid words from a random set of 7 letters - Tiles. "
						+ "These letters are stores on a Tile Rack. \n"
						+ "Type your word into indecated fiels and press 'Enter'. "
						+ "You get score points for each time you make a valid word "
						+ "based on letters you used in that word. \n"
						+ "If you enter invalid word corresponding error message is displayed. "
						+ "When a valid word is completed, it is added to the Word List "
						+ "on the left of the main window, used tiles are removed from the Tile Rack "
						+ "and randomly replenished from the remaining letters in a Tile Bag. \n"
						+ "When the bag is empty, the game is over.\n"
						+ "To start the new game click 'Start new game' button or pick corresponding menu option.\n"
						+ "To exit the game click 'Quit' button or pick corresponding menu option.\n"
						+ "\nGood Luck!";

				JTextArea helpTextArea = new JTextArea(helpMessage);
				helpTextArea.setRows(20);
				helpTextArea.setColumns(36);
				helpTextArea.setLineWrap(true);
				helpTextArea.setWrapStyleWord(true);
				helpTextArea.setEditable(false);
				helpTextArea.setOpaque(false);

				JScrollPane helpPane = new JScrollPane(helpTextArea);
				
				JOptionPane.showMessageDialog(BabbleMenuBar.this.gui.getMainFrame(), helpPane, "Help",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});

		this.menu.add(menuItem);

		menuItem = new JMenuItem("About", KeyEvent.VK_A);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String aboutMessage = "The Babble Game\nVersion: 0.1 (Fall 2014)"
						+ "\nContact info: mushako@my.westga.edu";
				JOptionPane.showMessageDialog(
						BabbleMenuBar.this.gui.getMainFrame(), aboutMessage,
						"About", JOptionPane.INFORMATION_MESSAGE);
			}

		});

		this.menu.add(menuItem);
		this.add(this.menu);
	}

	
}
