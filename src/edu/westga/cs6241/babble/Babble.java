package edu.westga.cs6241.babble;

import edu.westga.cs6241.babble.views.*;

/**
 * Main class for starting a Babble game. 
 * @author lewisb
 *
 */
public class Babble {

	public static void main(String[] args) throws Exception {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BabbleGUI().run();
			}
		});
	}
}
