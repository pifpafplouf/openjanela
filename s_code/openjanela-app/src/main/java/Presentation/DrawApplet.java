/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import openjanela.model.entities.partner.Series;

import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;

import Data.User;


public class DrawApplet extends JApplet {
	
	public ItemFrame frame = null;
	
	/**
	 * Create the applet.
	 */
	public DrawApplet() {
		
	}
	
	@Override
	public void init() {
		
		// Execute a job on the event-dispatching thread;
		// creating this applet's
		// GUI.
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				
				@Override
				public void run() {
					
					createGUI();
				}
			});
		} catch (final Exception e) {
			System.err
			.println("createGUI didn't complete successfully");
		}
	}
	
	private void createGUI() {
		
		// Create and set up the content pane.
		try {
			UIManager
			.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
			// UIManager.setLookAndFeel(newLookAndFeel)
			// .setLookAndFeel(new
			// SubstanceBusinessBlackSteelLookAndFeel());
		} catch (final Exception e) {
			System.err.println("Cannot set Look & Feel:" + e);
		}
		
		final Series mySys = new Series();
		final User myUser = new User();
		
		// frame = new ItemFrame(null);
		
		final Dimension screenSize =
					Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height - 30);
		// frame.setOpaque(true);
		setContentPane(frame);
//		try {
//			frame.connectToDB();
//			// frame.Initialize(mySys, myUser, null);
//		} catch (final Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
