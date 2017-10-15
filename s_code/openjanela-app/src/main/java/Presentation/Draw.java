/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Sherif El Dibani
 */
package Presentation;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import openjanela.commons.util.ResourcesUtil;
import openjanela.model.entities.partner.Series;

import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;

import util.XYLayout;
import Data.User;


/**
 * This main class start main panel draw for openjanela
 */
public class Draw extends JFrame {
	
	public static JPanel jContentPane = null;
	
	static public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	static int taskBarSize = 0;
	
	public static ItemFrame frame = null;
	
	// Color backColor = new Color(200, 200, 212);
	
	public Draw() throws HeadlessException {
		
		// TODO Auto-generated constructor stub
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static JPanel getJContentPane() {
		
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new XYLayout());
		}
		return jContentPane;
	}
	
	/**
	 * Initialize main service draw
	 *
	 * @throws Exception, Exception
	 */
	private static void initialize() throws Exception {
		//******************************************
		//Init resource icon map
		//******************************************
		
		//******************************************
		//Configuring look and feel decoration
		//******************************************
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
		} catch (final Exception e) {
			System.err.println("Cannot set Look & Feel:" + e);
		}
		
		//***************************************
		//Configuring frame initial panel
		//***************************************
		JFrame mainFrame = new JFrame("OpenJanela");
		mainFrame.setTitle("OpenJanela V2.0.8b");
		mainFrame.setIconImage(ResourcesUtil.getImageIconMap().get("openJanelaIcon").getImage());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting screen size
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width, GraphicsEnvironment
					.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
		
		// mainFrame.setSize((int) screenSize.getWidth(), (int)
		// screenSize.getHeight() - taskBarSize);
		mainFrame.setContentPane(getJContentPane());
		
		//Configuring content pane
		// jContentPane.setSize(screenSize.width, screenSize.height -
		// taskBarSize);
		
		jContentPane.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width,
					GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
		
		//***************************************
		//Initializing ItemFrame
		//***************************************
		Series mySys = new Series();
		User myUser = new User();
//		frame = new ItemFrame(mainFrame);
//		frame.Initialize(mySys, myUser, null);
		
		jContentPane.add(frame.main, BorderLayout.CENTER);
		jContentPane.validate();
		jContentPane.repaint();
		frame.mainFramePanel.validate();
		frame.mainFramePanel.repaint();
		
		//Setting visual component for GUI screen
		mainFrame.pack();
		mainFrame.validate();
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}
	
	/**
	 * This main method init software execution
	 *
	 * @param args, String[]
	 * @throws Exception, Exception
	 */
	public static void main(final String args[]) throws Exception {
		
		//Start runnable thread method
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					//Initialize service
					initialize();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
