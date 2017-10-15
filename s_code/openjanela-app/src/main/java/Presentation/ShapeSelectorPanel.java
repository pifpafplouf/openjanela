package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.openjanela.data.MenuActionEventDraw;

import openjanela.app.configuration.controller.ShapeSelectorPanelController;
import openjanela.model.entities.partner.ValidShapes;
import util.XYConstraints;
import util.XYLayout;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * All rights reserved.
 * <p/>
 * Contributors:
 * Sherif El Dibani
 * Eddy Montenegro
 */
public class ShapeSelectorPanel extends JPanel {
	
	public ItemFrame myParent;
	
	public JPanel shapePanel = new JPanel();
	
	public JPanel myShapePanel = new JPanel();
	
	//public int shapeNo = 0;
	public int selectedShape = 0;
	public int selectedShapeLevel = 1; // 2 = Frame 1 = Overall
	
	public JPanel topPanel = new JPanel();
	public JPanel sideSelectorPanel = new JPanel();
	public JPanel mainButtons = new JPanel();
	
	public JPanel buttonPanel3 = new JPanel();
	public JPanel buttonPanel4 = new JPanel();
	public JPanel buttonPanel5 = new JPanel();
	public JPanel buttonPanel6 = new JPanel();
	public JPanel buttonPanelHR = new JPanel();
	public JPanel buttonPanelArch = new JPanel();
	public JPanel buttonPanelGothic = new JPanel();
	public JPanel buttonPanel8 = new JPanel();
	public JPanel gothicPanel = new JPanel();
	
	public JCheckBox acuteCheck = new JCheckBox("Acuto");
	
	public JRadioButton quinto = new JRadioButton("Quinto");
	public JRadioButton mezzo = new JRadioButton("Mezzo");
	public JRadioButton recto = new JRadioButton("Recto");
	public JRadioButton doble = new JRadioButton("Doble");
	public JRadioButton overallB = new JRadioButton();
	public JRadioButton frameB = new JRadioButton();
	public ButtonGroup accuteGroup = new ButtonGroup();
	//public ButtonGroup groups = new ButtonGroup();
	public ButtonGroup whichLevel = new ButtonGroup();
	
	public boolean extgothic = false;
	
	public JScrollPane shapeScroll = new JScrollPane();
	
	
	//Represents list of valid shapes
	//public int[] validShapes = new int[102];
	
	public JButton[] shapeButton;
	
	//public String[] shapeString = new String[102];
	
	//public ImageIcon[] shapeIcon;
	
	//***********************************
	//Menu buttons form sides
	//***********************************
	JButton sides3 = new JButton();
	JButton sides4 = new JButton();
	JButton sides5 = new JButton();
	JButton sides6 = new JButton();
	JButton sides8 = new JButton();
	JButton sidesHR = new JButton();
	JButton sidesArch = new JButton();
	JButton sidesGothic = new JButton();
	JButton sidesEllipse = new JButton();
	
	//*******************************************************************
	// Array buttons
	//*******************************************************************
	private final Map<Integer, JButton> shapesButtonsMap = new HashMap<Integer, JButton>();
	
	//*******************************************************************
	//Controller services
	//*******************************************************************
	private final ShapeSelectorPanelController shapeController;
	
	Map<Integer, ValidShapes> validShapesMap;
	
	//*******************************************************************
	// Getters and Setters
	//*******************************************************************
	public Map<Integer, JButton> getShapesButtonsMap() {
		return shapesButtonsMap;
	}
	
	public ShapeSelectorPanelController getShapeController() {
		return shapeController;
	}
	
	/**
	 * Degault constructor
	 *
	 * @param frame, ItemFrame
	 */
	public ShapeSelectorPanel(ItemFrame frame) {
		
		//Setting ItemFrame parent
		this.myParent = frame;
		
		//Init controller
		shapeController = new ShapeSelectorPanelController();
		
		//Init components layout
		initComponentsLayout();
		
		//Init components values
		initComponentsValues();
		
		//Register Listeners
		registerListeners();
		
		//Init selected shape level
		this.selectedShapeLevel = 1;
		//Init selected shape
		this.selectedShape = 1;
	}
	
	/**
	 * Init components values Panel
	 */
	private void initComponentsLayout() {
		
		//*************************************************************
		//Init Buttons components
		//*************************************************************
		initButtonsComponents();
		
		//*************************************************************
		//Config panel sides shapes
		//*************************************************************
		this.buttonPanel3.setLayout(new XYLayout());
		this.buttonPanel4.setLayout(new XYLayout());
		this.buttonPanel5.setLayout(new XYLayout());
		this.buttonPanel6.setLayout(new XYLayout());
		this.buttonPanelHR.setLayout(new XYLayout());
		this.buttonPanelArch.setLayout(new XYLayout());
		this.buttonPanel8.setLayout(new XYLayout());
		this.gothicPanel.setLayout(new XYLayout());
		this.buttonPanelGothic.setLayout(new XYLayout());
		this.topPanel.setLayout(new XYLayout());
		
		this.sideSelectorPanel.setLayout(new XYLayout());
		this.mainButtons.setLayout(new BorderLayout());
		this.shapePanel.setLayout(new BorderLayout());
		this.myShapePanel.setLayout(new BorderLayout());
		
		this.buttonPanel3.setPreferredSize(new Dimension(148, 180));
		this.buttonPanel4.setPreferredSize(new Dimension(148, 180));
		this.buttonPanel5.setPreferredSize(new Dimension(148, 180));
		this.buttonPanel6.setPreferredSize(new Dimension(148, 180));
		this.buttonPanelHR.setPreferredSize(new Dimension(148, 180));
		this.buttonPanelArch.setPreferredSize(new Dimension(148, 180));
		this.buttonPanel8.setPreferredSize(new Dimension(148, 180));
		this.buttonPanelGothic.setPreferredSize(new Dimension(148, 180));
		this.sideSelectorPanel.setPreferredSize(new Dimension(48, 180));
		this.gothicPanel.setPreferredSize(new Dimension(150, 120));
		this.shapePanel.setPreferredSize(new Dimension(200, 560));
		this.topPanel.setPreferredSize(new Dimension(200, 27));
		this.myShapePanel.setPreferredSize(new Dimension(200, 312));
		
		//*************************************************************
		//Init JRadioButton values
		//*************************************************************
		this.quinto.setEnabled(false);
		this.mezzo.setEnabled(false);
		this.recto.setEnabled(false);
		this.doble.setEnabled(false);
		this.acuteCheck.setEnabled(false);
		this.overallB.setSelected(true);
		
		//*************************************************************
		//Init construct components
		//*************************************************************
	
		
		//Init top panel
		this.topPanel.add(this.overallB, new XYConstraints(1, 0, 40, 26));
		this.topPanel.add(this.frameB, new XYConstraints(50, 0, 40, 26));
		
		this.whichLevel.add(this.overallB);
		this.whichLevel.add(this.frameB);
		
		//Init myshape panel
		this.myShapePanel.add(this.topPanel, BorderLayout.NORTH);
		this.myShapePanel.add(this.mainButtons, BorderLayout.CENTER);
		
		//Init side selector panel
		this.sideSelectorPanel.add(this.sides3, new XYConstraints(1, 0, 35, 34));
		this.sideSelectorPanel.add(this.sides4, new XYConstraints(1, 35, 36, 34));
		this.sideSelectorPanel.add(this.sides5, new XYConstraints(1, 70, 36, 34));
		this.sideSelectorPanel.add(this.sides6, new XYConstraints(1, 105, 36, 34));
		this.sideSelectorPanel.add(this.sidesHR, new XYConstraints(1, 140, 36, 34));
		this.sideSelectorPanel.add(this.sidesArch, new XYConstraints(1, 175, 36, 34));
		this.sideSelectorPanel.add(this.sidesGothic, new XYConstraints(1, 210, 36, 34));
		this.sideSelectorPanel.add(this.sides8, new XYConstraints(1, 245, 36, 34));
		
		//Init shape scroll component
		this.shapeScroll.getViewport().add(this.buttonPanel4, null);
		this.shapeScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.shapeScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//Init main buttons
		this.mainButtons.add(sideSelectorPanel, BorderLayout.WEST);
		this.mainButtons.add(shapeScroll, BorderLayout.CENTER);
	}
	
	/**
	 * Init components values
	 */
	private void initComponentsValues() {
		
		//Init shapes buttons
		initShapesButtons();
		
		//***************************************************
		//Config overall and shape application form
		//***************************************************
		
		//Initialize 3 shapes options panel
		do3SidesShapes();
		//Initialize 4 shapes options panel
		do4SidesShapes();
		//Initialize 5 shapes options panel
		do5SidesShapes();
		//Initialize 6 shapes options panel
		do6SidesShapes();
		//Initialize 8 shapes options panel
		do8SidesShapes();
		//Initialize round sides shapes
		doHRSidesShapes();
		//Initialize arch sides shapes
		doArchSidesShapes();
		//Initialize gothic sides shapes
		doGothicSidesShapes();
	}
	
	/**
	 * Init Buttons configuration icons and tooltip text
	 */
	private void initButtonsComponents() {
		
		//**********************************************
		//Setting buttons dimensions
		//**********************************************
		sides3.setPreferredSize(new Dimension(32, 32));
		sides4.setPreferredSize(new Dimension(32, 32));
		sides5.setPreferredSize(new Dimension(32, 32));
		sides6.setPreferredSize(new Dimension(32, 32));
		sides8.setPreferredSize(new Dimension(32, 32));
		sidesArch.setPreferredSize(new Dimension(32, 32));
		sidesHR.setPreferredSize(new Dimension(32, 32));
		sidesGothic.setPreferredSize(new Dimension(32, 32));
		
		//***********************************************
		//Setting icons
		//***********************************************
		sides3.setIcon(ItemFrame.iconFiles.get("3sided"));
		sides4.setIcon(ItemFrame.iconFiles.get("4sided"));
		sides5.setIcon(ItemFrame.iconFiles.get("5sided"));
		sides6.setIcon(ItemFrame.iconFiles.get("6sided"));
		sides8.setIcon(ItemFrame.iconFiles.get("oddshape"));
		sidesHR.setIcon(ItemFrame.iconFiles.get("roundtop"));
		sidesArch.setIcon(ItemFrame.iconFiles.get("archtop"));
		sidesGothic.setIcon(ItemFrame.iconFiles.get("gothictop"));
		sidesEllipse.setIcon(ItemFrame.iconFiles.get("shape400"));
		
		overallB.setIcon(myParent.overallShapeImage);
		frameB.setIcon(myParent.frameShapeImage);
		overallB.setSelectedIcon(myParent.overallSShapeImage);
		frameB.setSelectedIcon(myParent.frameSShapeImage);
		
		//************************************************
		//Setting tooltipText
		//************************************************
		sides3.setToolTipText("3 Sided");
		sides4.setToolTipText("4 Sided");
		sides5.setToolTipText("5 Sided");
		sides6.setToolTipText("6 Sided");
		sides8.setToolTipText("Other Shapes");
		sidesHR.setToolTipText("Round Top");
		sidesArch.setToolTipText("Arch Top");
		sidesGothic.setToolTipText("Gothic");
		sidesEllipse.setToolTipText("Elliptical");
		
		overallB.setToolTipText("Set Overall Shape -  Wire Design");
		frameB.setToolTipText("Set Frame Shape");
	}
	
	/**
	 * Init shapes buttons
	 */
	private void initShapesButtons() {
		
		//Get valid shapes map
		validShapesMap = shapeController.getValidShapesMap();
		
		ImageIcon imageIcon;
		String imageName;
		
		for (Map.Entry<Integer, ValidShapes> validShape : validShapesMap.entrySet()) {
			imageName = "shape" + validShape.getKey() + "";
			imageIcon = ItemFrame.iconFiles.get(imageName);
			
			if (imageIcon != null) {
				JButton shapeButton = new JButton();
				shapeButton.setIcon(imageIcon);
				shapeButton.setBackground(Color.LIGHT_GRAY);
				shapeButton.setSelected(false);
				shapeButton.setName(validShape.getKey() + "");
				shapeButton.setMinimumSize(new Dimension(36, 36));
				shapeButton.setPreferredSize(new Dimension(36, 36));
				shapeButton.setEnabled(true);
				
				shapeButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						myParent.setActionTypeEvent(MenuActionEventDraw.SHAPE_EVENT.getValue());
						ShapeSelectorPanel.this.setSelectedShape(e);
						
					}
				});
				
				//Adding button to shapePanel
				shapePanel.add(shapeButton);
				//groups.add(shapeButton);
				
				//Adding button to ShapePanel map
				shapesButtonsMap.put(validShape.getKey(), shapeButton);
			}
			
			//Setting imageIcon to null
			imageIcon = null;
		}
	}
	
	/**
	 * Register Listeners events components
	 */
	public void registerListeners() {
		
		this.sides3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanel3, null);
			}
		});
		
		this.sides4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanel4, null);
			}
		});
		
		this.sides5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanel5, null);
			}
		});
		
		this.sides6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanel6, null);
			}
		});
		
		this.sides8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanel8, null);
			}
		});
		
		this.sidesHR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanelHR, null);
			}
		});
		
		this.sidesArch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanelArch, null);
			}
		});
		
		this.sidesGothic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShape = 0;
				shapeScroll.getViewport().add(buttonPanelGothic, null);
			}
		});
		
		this.frameB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShapeLevel = 2;
				frameB.setSelectedIcon(myParent.frameSShapeImage);
				overallB.setSelectedIcon(myParent.overallShapeImage);
			}
		});
		
		overallB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShapeLevel = 1;
				overallB.setSelectedIcon(myParent.overallSShapeImage);
				frameB.setSelectedIcon(myParent.frameShapeImage);
			}
		});
		
		acuteCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (acuteCheck.isSelected()) {
					quinto.setEnabled(true);
					mezzo.setEnabled(true);
					recto.setEnabled(true);
					doble.setEnabled(true);
				} else {
					quinto.setEnabled(false);
					mezzo.setEnabled(false);
					recto.setEnabled(false);
					doble.setEnabled(false);
				}
			}
		});
		
		quinto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (quinto.isSelected()) {
					mezzo.setSelected(false);
					recto.setSelected(false);
					doble.setSelected(false);
					
					if (extgothic) {
						selectedShape = ValidShapes.validShapes_454.getValue();
					} else {
						selectedShape = ValidShapes.validShapes_455.getValue();
					}
				}
			}
		});
		
		mezzo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mezzo.isSelected()) {
					quinto.setSelected(false);
					recto.setSelected(false);
					doble.setSelected(false);
					
					if (extgothic) {
						selectedShape = ValidShapes.validShapes_456.getValue();
					} else {
						selectedShape = ValidShapes.validShapes_457.getValue();
					}
				}
			}
		});
		
		recto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recto.isSelected()) {
					quinto.setSelected(false);
					mezzo.setSelected(false);
					doble.setSelected(false);
					
					if (extgothic) {
						selectedShape = ValidShapes.validShapes_458.getValue();
					} else {
						selectedShape = ValidShapes.validShapes_459.getValue();
					}
				}
			}
		});
		
		doble.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (doble.isSelected()) {
					quinto.setSelected(false);
					recto.setSelected(false);
					mezzo.setSelected(false);
					
					if (extgothic) {
						selectedShape = ValidShapes.validShapes_460.getValue();
					} else {
						selectedShape = ValidShapes.validShapes_461.getValue();
					}
				}
			}
		});
	}
	
	/**
	 * Do 3 sides shapes buttons
	 */
	public void do3SidesShapes() {
		
		buttonPanel3.add(shapesButtonsMap.get(700), new XYConstraints(3, 1, 36, 36));
		buttonPanel3.add(shapesButtonsMap.get(701), new XYConstraints(41, 1, 36, 36));
		buttonPanel3.add(shapesButtonsMap.get(705), new XYConstraints(79, 1, 36, 36));
		buttonPanel3.add(shapesButtonsMap.get(706), new XYConstraints(117, 1, 36, 36));
		
		buttonPanel3.add(shapesButtonsMap.get(704), new XYConstraints(3, 39, 36, 36));
		buttonPanel3.add(shapesButtonsMap.get(707), new XYConstraints(41, 39, 36, 36));
		buttonPanel3.add(shapesButtonsMap.get(702), new XYConstraints(79, 39, 36, 36));
		buttonPanel3.add(shapesButtonsMap.get(703), new XYConstraints(117, 39, 36, 36));
		
		shapesButtonsMap.get(707).setEnabled(false);
	}
	
	/**
	 * Do 4 sides shapes buttons
	 */
	public void do4SidesShapes() {
		
		buttonPanel4.add(shapesButtonsMap.get(1), new XYConstraints(3, 1, 36, 36));
		
		buttonPanel4.add(shapesButtonsMap.get(10), new XYConstraints(117, 1, 36, 36));
		
		buttonPanel4.add(shapesButtonsMap.get(100), new XYConstraints(3, 39, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(101), new XYConstraints(41, 39, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(104), new XYConstraints(79, 39, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(105), new XYConstraints(117, 39, 36, 36));
		
		buttonPanel4.add(shapesButtonsMap.get(102), new XYConstraints(3, 77, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(103), new XYConstraints(41, 77, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(106), new XYConstraints(79, 77, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(107), new XYConstraints(117, 77, 36, 36));
		
		buttonPanel4.add(shapesButtonsMap.get(108), new XYConstraints(3, 115, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(109), new XYConstraints(41, 115, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(110), new XYConstraints(79, 115, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(111), new XYConstraints(117, 115, 36, 36));
		
		buttonPanel4.add(shapesButtonsMap.get(112), new XYConstraints(3, 153, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(113), new XYConstraints(41, 153, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(114), new XYConstraints(79, 153, 36, 36));
		buttonPanel4.add(shapesButtonsMap.get(115), new XYConstraints(117, 153, 36, 36));
	}
	
	/**
	 * Do 5 sides shape buttons
	 */
	public void do5SidesShapes() {
		
		buttonPanel5.add(shapesButtonsMap.get(150), new XYConstraints(3, 1, 36, 36));
		buttonPanel5.add(shapesButtonsMap.get(151), new XYConstraints(41, 1, 36, 36));
		buttonPanel5.add(shapesButtonsMap.get(152), new XYConstraints(79, 1, 36, 36));
		buttonPanel5.add(shapesButtonsMap.get(153), new XYConstraints(117, 1, 36, 36));
		
		buttonPanel5.add(shapesButtonsMap.get(154), new XYConstraints(1, 39, 36, 36));
		buttonPanel5.add(shapesButtonsMap.get(155), new XYConstraints(41, 39, 36, 36));
		buttonPanel5.add(shapesButtonsMap.get(156), new XYConstraints(79, 39, 36, 36));
		buttonPanel5.add(shapesButtonsMap.get(157), new XYConstraints(117, 39, 36, 36));
		
		shapesButtonsMap.get(151).setEnabled(false);
		shapesButtonsMap.get(152).setEnabled(false);
		shapesButtonsMap.get(153).setEnabled(false);
		shapesButtonsMap.get(156).setEnabled(false);
		shapesButtonsMap.get(157).setEnabled(false);
	}
	
	/**
	 * Do 6 sides shapes buttons
	 */
	public void do6SidesShapes() {
		
		buttonPanel6.add(shapesButtonsMap.get(160), new XYConstraints(3, 1, 36, 36));
		buttonPanel6.add(shapesButtonsMap.get(161), new XYConstraints(41, 1, 36, 36));
		buttonPanel6.add(shapesButtonsMap.get(162), new XYConstraints(79, 1, 36, 36));
		buttonPanel6.add(shapesButtonsMap.get(163), new XYConstraints(117, 1, 36, 36));
		
		buttonPanel6.add(shapesButtonsMap.get(165), new XYConstraints(3, 39, 36, 36));
		buttonPanel6.add(shapesButtonsMap.get(166), new XYConstraints(41, 39, 36, 36));
		buttonPanel6.add(shapesButtonsMap.get(167), new XYConstraints(79, 39, 36, 36));
		buttonPanel6.add(shapesButtonsMap.get(168), new XYConstraints(117, 39, 36, 36));
		
		shapesButtonsMap.get(161).setEnabled(false);
		shapesButtonsMap.get(162).setEnabled(false);
		shapesButtonsMap.get(163).setEnabled(false);
		shapesButtonsMap.get(166).setEnabled(false);
		shapesButtonsMap.get(167).setEnabled(false);
		shapesButtonsMap.get(168).setEnabled(false);
	}
	
	/**
	 * Do HR sides shapes buttons
	 */
	public void doHRSidesShapes() {
		
		buttonPanelHR.add(shapesButtonsMap.get(200), new XYConstraints(3, 1, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(206), new XYConstraints(41, 1, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(211), new XYConstraints(79, 1, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(216), new XYConstraints(117, 1, 36, 36));
		
		buttonPanelHR.add(shapesButtonsMap.get(201), new XYConstraints(3, 39, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(207), new XYConstraints(41, 39, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(212), new XYConstraints(79, 39, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(217), new XYConstraints(117, 39, 36, 36));
		
		buttonPanelHR.add(shapesButtonsMap.get(202), new XYConstraints(3, 77, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(208), new XYConstraints(41, 77, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(213), new XYConstraints(79, 77, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(218), new XYConstraints(117, 77, 36, 36));
		
		buttonPanelHR.add(shapesButtonsMap.get(203), new XYConstraints(3, 115, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(209), new XYConstraints(41, 115, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(214), new XYConstraints(79, 115, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(219), new XYConstraints(117, 115, 36, 36));
		
		buttonPanelHR.add(shapesButtonsMap.get(204), new XYConstraints(3, 153, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(205), new XYConstraints(41, 153, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(210), new XYConstraints(79, 153, 36, 36));
		buttonPanelHR.add(shapesButtonsMap.get(215), new XYConstraints(117, 153, 36, 36));
		
		shapesButtonsMap.get(206).setEnabled(false);
		shapesButtonsMap.get(211).setEnabled(false);
		shapesButtonsMap.get(216).setEnabled(false);
		shapesButtonsMap.get(207).setEnabled(false);
		shapesButtonsMap.get(212).setEnabled(false);
		shapesButtonsMap.get(217).setEnabled(false);
		shapesButtonsMap.get(208).setEnabled(false);
		shapesButtonsMap.get(213).setEnabled(false);
		shapesButtonsMap.get(218).setEnabled(false);
		shapesButtonsMap.get(209).setEnabled(false);
		shapesButtonsMap.get(214).setEnabled(false);
		shapesButtonsMap.get(219).setEnabled(false);
		shapesButtonsMap.get(210).setEnabled(false);
		shapesButtonsMap.get(215).setEnabled(false);
	}
	
	/**
	 * Do Arch sides shapes buttons
	 */
	public void doArchSidesShapes() {
		
		buttonPanelArch.add(shapesButtonsMap.get(300), new XYConstraints(3, 1, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(306), new XYConstraints(41, 1, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(311), new XYConstraints(79, 1, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(316), new XYConstraints(117, 1, 36, 36));
		
		buttonPanelArch.add(shapesButtonsMap.get(301), new XYConstraints(3, 39, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(307), new XYConstraints(41, 39, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(312), new XYConstraints(79, 39, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(317), new XYConstraints(117, 39, 36, 36));
		
		buttonPanelArch.add(shapesButtonsMap.get(302), new XYConstraints(3, 77, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(308), new XYConstraints(41, 77, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(313), new XYConstraints(79, 77, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(318), new XYConstraints(117, 77, 36, 36));
		
		buttonPanelArch.add(shapesButtonsMap.get(303), new XYConstraints(3, 115, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(309), new XYConstraints(41, 115, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(314), new XYConstraints(79, 115, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(319), new XYConstraints(117, 115, 36, 36));
		
		buttonPanelArch.add(shapesButtonsMap.get(304), new XYConstraints(3, 153, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(305), new XYConstraints(41, 153, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(310), new XYConstraints(79, 153, 36, 36));
		buttonPanelArch.add(shapesButtonsMap.get(315), new XYConstraints(117, 153, 36, 36));
		
		shapesButtonsMap.get(306).setEnabled(false);
		shapesButtonsMap.get(311).setEnabled(false);
		shapesButtonsMap.get(316).setEnabled(false);
		shapesButtonsMap.get(307).setEnabled(false);
		shapesButtonsMap.get(312).setEnabled(false);
		shapesButtonsMap.get(317).setEnabled(false);
		shapesButtonsMap.get(308).setEnabled(false);
		shapesButtonsMap.get(313).setEnabled(false);
		shapesButtonsMap.get(318).setEnabled(false);
		shapesButtonsMap.get(309).setEnabled(false);
		shapesButtonsMap.get(314).setEnabled(false);
		shapesButtonsMap.get(319).setEnabled(false);
		shapesButtonsMap.get(310).setEnabled(false);
		shapesButtonsMap.get(315).setEnabled(false);
	}
	
	/**
	 * Do Gothic sides shapes buttons
	 */
	public void doGothicSidesShapes() {
		
		buttonPanelGothic.add(shapesButtonsMap.get(450), new XYConstraints(3, 1, 36, 36));
		buttonPanelGothic.add(shapesButtonsMap.get(453), new XYConstraints(41, 1, 36, 36));
		
		shapesButtonsMap.get(453).setEnabled(false);
		
		accuteGroup.add(quinto);
		accuteGroup.add(mezzo);
		accuteGroup.add(recto);
		accuteGroup.add(doble);
		
		buttonPanelGothic.add(acuteCheck, new XYConstraints(1, 46, 80, 19));
		buttonPanelGothic.add(quinto, new XYConstraints(20, 68, 80, 20));
		buttonPanelGothic.add(mezzo, new XYConstraints(20, 90, 80, 20));
		buttonPanelGothic.add(recto, new XYConstraints(20, 112, 80, 20));
		buttonPanelGothic.add(doble, new XYConstraints(20, 136, 80, 20));
	}
	
	/**
	 * Do 8 sides shapes buttons
	 */
	public void do8SidesShapes() {
		
		buttonPanel8.add(shapesButtonsMap.get(90), new XYConstraints(3, 1, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(91), new XYConstraints(41, 1, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(92), new XYConstraints(79, 1, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(93), new XYConstraints(117, 1, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(800), new XYConstraints(3, 39, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(400), new XYConstraints(41, 39, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(401), new XYConstraints(79, 39, 36, 36));
		buttonPanel8.add(shapesButtonsMap.get(402), new XYConstraints(117, 39, 36, 36));
		
		shapesButtonsMap.get(400).setEnabled(false);
		shapesButtonsMap.get(401).setEnabled(false);
		shapesButtonsMap.get(402).setEnabled(false);
	}
	
	//******************************************************************************************************************
	// ACTIONS EVENTS METHODS
	//******************************************************************************************************************
	
	/**
	 * Stablish selected shape from action events for valid shapes
	 *
	 * @param e, ActionEvent
	 */
	private void setSelectedShape(ActionEvent e) {
		
		myParent.stopCustomCursor(this.myParent.main);
		
		// Need to set all buttons to Light Grey and update
		
		setButtonBackgroundLightGrey();
		
		// Get selected sash key
		int selectedShapeKey = Integer.valueOf(((JButton) e.getSource()).getName());
		
		myParent.setActionTypeEvent(MenuActionEventDraw.SHAPE_EVENT.getValue());
		
//		String imageName = "shape" + ((JButton) e.getSource()).getName() + "";
//			myParent.myCursorImage = ItemFrame.iconFiles.get(imageName);
//			myParent.myCursor = myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(), new Point(0, 0), "");
//			myParent.startCustomCursor(myParent.main, myParent.myCursor);
		
		
		// Added set background color to dark gery for selected Button.
		
		((JButton) e.getSource()).setBackground(Color.DARK_GRAY);
		
		if (selectedShapeKey != ValidShapes.validShapes_450.getValue() &&
					selectedShapeKey != ValidShapes.validShapes_453.getValue()) {
			
			//Setting acute check disabled
			this.acuteCheck.setEnabled(false);
			
			//Setting selected shape
			this.selectedShape = selectedShapeKey;
		}
		
		if (selectedShapeKey == ValidShapes.validShapes_450.getValue() ||
					selectedShapeKey == ValidShapes.validShapes_453.getValue()) {
			
			//Setting acute check enabled
			this.acuteCheck.setEnabled(true);
			
			if (selectedShapeKey == ValidShapes.validShapes_450.getValue())
				extgothic = true;
			else
				extgothic = false;
		}
		
		
	}
	
	public void setButtonBackgroundLightGrey()
	{
		
		shapesButtonsMap.get(700).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(701).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(705).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(706).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(704).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(707).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(702).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(703).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(707).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(1).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(10).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(100).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(101).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(104).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(105).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(102).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(103).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(106).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(107).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(108).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(109).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(110).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(111).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(112).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(113).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(114).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(115).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(150).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(151).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(152).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(153).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(154).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(155).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(156).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(157).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(160).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(161).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(162).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(163).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(165).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(166).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(167).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(168).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(200).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(206).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(211).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(216).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(201).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(207).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(212).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(217).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(202).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(208).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(213).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(218).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(203).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(209).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(214).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(219).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(204).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(205).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(210).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(215).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(300).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(306).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(311).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(316).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(301).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(307).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(312).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(317).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(302).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(308).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(313).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(318).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(303).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(309).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(314).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(319).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(304).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(305).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(310).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(315).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(450).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(453).setBackground(Color.LIGHT_GRAY);
		
		shapesButtonsMap.get(90).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(91).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(92).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(93).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(800).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(400).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(401).setBackground(Color.LIGHT_GRAY);
		shapesButtonsMap.get(402).setBackground(Color.LIGHT_GRAY);
		
		this.validate();
		this.repaint();

	}
	
}
