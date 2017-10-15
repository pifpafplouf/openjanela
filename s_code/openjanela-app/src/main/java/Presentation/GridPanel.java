/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;

import Model.DLO;
import Operations.FindBiggestDLO;
import openjanela.app.configuration.controller.GridsPanelController;
import openjanela.model.entities.partner.Grids;

import org.openjanela.component.JOpenJanelaComponent;
import org.openjanela.data.MenuActionEventDraw;

import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GridPanel implements JOpenJanelaComponent {

	/**
	 * Item Frame Parent UI Main configuration
	 */
	public ItemFrame myParent;

	public Map<String, ImageIcon> iconFiles = new HashMap<String, ImageIcon>();

	public JPanel gridPanel;

	public JPanel p14;
	public JPanel p15;
	public JPanel p16;

	public JLabel l2;
	public JLabel lH;
	public JLabel lS;
	public JLabel lV;

	public JLabel setHVL;
	public JLabel setRSL;

	public JTextField tV;
	public JTextField tH;
	public JTextField tS;

	public JComboBox gridCombo;

	public JButton bSetSelectedGrid;
	public JButton bAddSelectedGrid;
	public JButton bRemoveAll;
	public JButton bRemoveGrid;
	public JButton bCutGrid;
	public JButton bChangeMasterH;
	public JButton bChangeMasterV;
	public JButton bChangeNumGrids;
	public JButton bSetNumberGrid;
	public JButton bAddGrids;
	public JButton bEqualizeV;
	public JButton bEqualizeH;

	public ButtonGroup buttonGroup1;
	public ButtonGroup cutGroup;

	public JRadioButton setHV;
	public JRadioButton setRS;

	public ImageIcon vhGrids;
	public ImageIcon vgrid;
	public ImageIcon hgrid;
	public ImageIcon radiusgrids;
	public ImageIcon spokes;
	public ImageIcon imageNoGrid;
	public ImageIcon imageRemoveGrid;
	public ImageIcon imageCutGrid;
	public ImageIcon imagechangmaterH;
	public ImageIcon imagechangmaterV;
	public ImageIcon imageaddGrid;
	public ImageIcon imageNumGrids;
	public ImageIcon imageEqualiseV;
	public ImageIcon imageEqualiseH;
	public ImageIcon imageAlignV;
	public ImageIcon imageAlignH;
	public ImageIcon cutCursor;

	public int whichPos = 2;
	public int form = 0;
	public int xxx = 0;
	public int yyy = 0;

	// Edit design for grid panel
	private boolean resetGridValue = false;

	// Selected grid from component UI
	public Grids myGrid;
	// Collection of Grids components
	public Collection grids = new ArrayList();

	public List<Grids> myGrids;

	// Controllers
	private GridsPanelController gridsController;

	/**
	 * Grid Panel Constructor UI
	 */
	public GridPanel() {
		// Init Controllers
		gridsController = new GridsPanelController();
	}

	/**
	 * Grid Panel Constructor UI
	 * 
	 * @param myParent
	 *            , ItemFrame main parent component
	 */
	public GridPanel(ItemFrame myParent) {

		// Call super constructor
		this();

		// Setting ItemFrame parent
		this.myParent = myParent;

		// Init components
		initComponents();

		// Init value components
		initValueComponents();

		// Init events listeners
		initListenersComponents();
	}

	@Override
	public void initComponents() {

		// *****************************************************************
		// Init Icon images values
		// *****************************************************************
		this.vhGrids = ItemFrame.iconFiles.get("vandhgrids");
		this.vgrid = ItemFrame.iconFiles.get("vgrid");
		this.hgrid = ItemFrame.iconFiles.get("hgrid");
		this.spokes = ItemFrame.iconFiles.get("spokes");
		this.radiusgrids = ItemFrame.iconFiles.get("radiusgrids");
		this.imageNoGrid = ItemFrame.iconFiles.get("imagenogrid");
		this.imageRemoveGrid = ItemFrame.iconFiles.get("imageremoveGrid");
		this.imageCutGrid = ItemFrame.iconFiles.get("imagecutGrid");
		this.imagechangmaterH = ItemFrame.iconFiles.get("imagechangmaterH");
		this.imagechangmaterV = ItemFrame.iconFiles.get("imagechangmaterV");
		this.imageaddGrid = ItemFrame.iconFiles.get("imageaddGrid");
		this.imageNumGrids = ItemFrame.iconFiles.get("imageNoGrids");
		this.cutCursor = ItemFrame.iconFiles.get("imagecutGrid");
		this.imageEqualiseV = ItemFrame.iconFiles.get("equalize");
		this.imageEqualiseH = ItemFrame.iconFiles.get("equalizeH");
		this.imageAlignV = ItemFrame.iconFiles.get("alignV");
		this.imageAlignH = ItemFrame.iconFiles.get("alignH");

		// *******************************************************************
		// Init configuration components UI
		// *******************************************************************

		l2 = new JLabel();
		l2.setText("");
		l2.setPreferredSize(new Dimension(12, 200));

		lV = new JLabel();
		lV.setToolTipText("Set # V grids");
		lV.setIcon(vgrid);
		lV.setEnabled(true);

		lH = new JLabel();
		lH.setToolTipText("Set # H grids");
		lH.setIcon(hgrid);
		lH.setEnabled(true);

		lS = new JLabel();
		lS.setToolTipText("Set # Spokes");
		lS.setIcon(spokes);
		lS.setEnabled(false);

		setHVL = new JLabel();
		setHVL.setToolTipText("Set # H and V grids");
		setHVL.setIcon(vhGrids);

		setRSL = new JLabel();
		setRSL.setToolTipText("Set Radii and # Sokes");
		setRSL.setIcon(radiusgrids);

		setHV = new JRadioButton();
		setHV.setToolTipText("Set # H and V grids");
		setHV.setSelected(true);

		setRS = new JRadioButton();
		setRS.setToolTipText("Set Radii and # Sokes");

		bAddSelectedGrid = new JButton();
		bAddSelectedGrid.setToolTipText("ADD to existing Configuration");
		bAddSelectedGrid.setIcon(myParent.addImage);
		bAddSelectedGrid.setEnabled(false);

		bSetSelectedGrid = new JButton();
		bSetSelectedGrid.setToolTipText("Set Selected Grid");
		bSetSelectedGrid.setIcon(myParent.setImage);

		bRemoveAll = new JButton();
		bRemoveAll.setToolTipText("Remove All Grids");
		bRemoveAll.setIcon(imageNoGrid);
		bRemoveAll.setPreferredSize(new Dimension(24, 24));

		bRemoveGrid = new JButton();
		bRemoveGrid.setToolTipText("Remove 1 Grid");
		bRemoveGrid.setIcon(imageRemoveGrid);
		bRemoveGrid.setPreferredSize(new Dimension(24, 24));

		bCutGrid = new JButton();
		bCutGrid.setToolTipText("Cut Part of Grid");
		bCutGrid.setIcon(imageCutGrid);

		bChangeMasterH = new JButton();
		bChangeMasterH.setToolTipText("Change Horizontal Master");
		bChangeMasterH.setIcon(imagechangmaterH);
		bChangeMasterH.setEnabled(true);

		bChangeMasterV = new JButton();
		bChangeMasterV.setToolTipText("Change Vertical Master");
		bChangeMasterV.setIcon(imagechangmaterV);
		bChangeMasterV.setEnabled(true);

		bAddGrids = new JButton();
		bAddGrids.setToolTipText("Cut Part of Grid");
		bAddGrids.setIcon(imageaddGrid);

		bChangeNumGrids = new JButton();
		bChangeNumGrids
				.setToolTipText("Change Grid Configuration && # of Grids");
		bChangeNumGrids.setIcon(imageNumGrids);

		bSetNumberGrid = new JButton();
		bSetNumberGrid.setToolTipText("Execute Change");
		bSetNumberGrid.setIcon(myParent.setImage);

		bEqualizeH = new JButton();
		bEqualizeH.setToolTipText("Equalize Horizontal Grids");
		bEqualizeH.setIcon(imageEqualiseH);

		bEqualizeV = new JButton();
		bEqualizeV.setToolTipText("Equalize Vertical Grids");
		bEqualizeV.setIcon(imageEqualiseV);

		tV = new JTextField();
		tV.setColumns(3);
		tV.setEnabled(true);

		tH = new JTextField();
		tH.setColumns(3);
		tH.setEnabled(true);

		tS = new JTextField();
		tS.setColumns(3);
		tS.setEnabled(false);

		gridCombo = new JComboBox();

		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(setHV);
		buttonGroup1.add(setRS);

		cutGroup = new ButtonGroup();
		cutGroup.add(bRemoveAll);
		cutGroup.add(bRemoveGrid);
		cutGroup.add(bCutGrid);

		// *******************************************************************
		// Init configuration panels UI
		// *******************************************************************
		
		// JPanel p15
		buildP15Panel();

		// JPanel grid main panel
		buildGridPanel();
	}

	private void buildGridPanel() {
		gridPanel = new JPanel(new BorderLayout());
		gridPanel.setBorder(BorderFactory.createEtchedBorder());
		gridPanel.setPreferredSize(new Dimension(180, 312));

        buildP14Panel();
		gridPanel.add(p14, BorderLayout.NORTH);
	}

	private void buildP14Panel() {
		p14 = new JPanel(new XYLayout());
		p14.setMinimumSize(new Dimension(300, 50));

		p14.add(gridCombo, new XYConstraints(0, 1, 200, 19));
		// p14.add(bSetSelectedGrid, new XYConstraints(142, 1, 40, 19));
	}

	private void buildP16Panel() {
		p16 = new JPanel(new XYLayout());
		p16.setVisible(false);

		p16.add(setHV, new XYConstraints(1, 1, 20, 19));
		p16.add(setHVL, new XYConstraints(22, 1, 20, 19));
		p16.add(lV, new XYConstraints(73, 1, 20, 19));
		p16.add(lH, new XYConstraints(73, 22, 20, 19));
		p16.add(tV, new XYConstraints(125, 1, 40, 19));
		p16.add(tH, new XYConstraints(125, 22, 40, 19));
		p16.add(setRS, new XYConstraints(1, 43, 20, 19));
		p16.add(setRSL, new XYConstraints(22, 43, 70, 19));
		p16.add(lS, new XYConstraints(73, 43, 50, 19));
		p16.add(tS, new XYConstraints(125, 43, 40, 19));
		p16.add(bSetNumberGrid, new XYConstraints(125, 65, 40, 19));
	}

	private void buildP15Panel() {
		
		p15 = new JPanel(new XYLayout());
		p15.setMinimumSize(new Dimension(300, 250));
		p15.setBorder(null);

		p15.add(bAddSelectedGrid, new XYConstraints(142, 1, 40, 19));
		p15.add(bEqualizeH, new XYConstraints(13, 1, 30, 19));
		p15.add(bEqualizeV, new XYConstraints(13, 22, 30, 19));
		p15.add(bChangeNumGrids, new XYConstraints(45, 1, 30, 19));
		p15.add(bRemoveAll, new XYConstraints(45, 22, 30, 19));
		p15.add(bRemoveGrid, new XYConstraints(77, 1, 30, 19));
		p15.add(bCutGrid, new XYConstraints(77, 22, 30, 19));
		p15.add(bChangeMasterH, new XYConstraints(109, 1, 30, 19));
		p15.add(bChangeMasterV, new XYConstraints(109, 22, 30, 19));
		p15.add(l2, new XYConstraints(1, 65, 246, 19));
		
		 buildP16Panel();
		 
		p15.add(p16, new XYConstraints(1, 45, 170, 90));
	}

	@Override
	public void initValueComponents() {

		// Initialize values for grids JComboBox component
		this.myGrids = gridsController.searchAllGrids();
		this.gridCombo.setModel(new DefaultComboBoxModel(myGrids.toArray()));
		if (gridCombo.getModel().getSize() > 0) {
			gridCombo.setSelectedIndex(0);
		}

		// Initialize default GridType for JobItem model
		if (this.myParent.jobItem != null && this.myParent.jobItem.gridType > 0) {
			for (Grids grid : this.myGrids) {
				if (grid.getId().intValue() == this.myParent.jobItem.gridType) {
					if (gridCombo.getModel().getSize() > 0) {
						gridCombo.setSelectedItem(grid);

						// Setting Grid Action
						setGridAction(1);

						// Reset Grid Design
						resetGridDesign(1);

						break;
					}
				}
			}
		}
	}

	@Override
	public void initListenersComponents() {

		// Grid ComboBox listener
		gridCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (resetGridValue) {
					myGrid = (Grids) gridCombo.getSelectedItem();

					setGridAction(1);
					resetGridDesign(1);

                    //****************************************************
                    //Recalculate Bom for Window
                    //****************************************************
                    myParent.calcBom = true;
				}
			}
		});

		// Remove all grids component action listener
		bRemoveAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				   
				l2.setText("Select Glass to Remove Grids");
				
				myParent.gridOp = 8;
				bRemoveAll.setSelected(false);
				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Remove grid components action listener
		bRemoveGrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Click Grid to Remove");
			
				myParent.gridOp = 9;
				bRemoveGrid.setSelected(false);

				//
				// myParent.myCursorImage =
				// myParent.iconFiles.get("imageremoveGrid");
				// myParent.myCursor =
				// myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(),
				// new Point(0, 0), "");
				// myParent.startCustomCursor(myParent.main, myParent.myCursor);
				//
				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Cut grid component action listener
		bCutGrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Click Grid Segment to Cut");
			
				myParent.gridOp = 10;

				Toolkit tk = Toolkit.getDefaultToolkit();
				Image image = cutCursor.getImage();
				tk.createCustomCursor(image, new Point(0, 0), "Cut");

				bCutGrid.setSelected(false);

				// myParent.myCursorImage =
				// myParent.iconFiles.get("imageCutGrid");
				// myParent.myCursor =
				// myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(),
				// new Point(0, 0), "");
				// myParent.startCustomCursor(myParent.main, myParent.myCursor);

				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Equilize vertical grids components action listener
		bEqualizeV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Equalize V. Grid Pos. In Opening");
				
				myParent.gridOp = 3;
				bEqualizeV.setSelected(false);
				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Equilize horizontal grids components action listener
		bEqualizeH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Equalize H. Grid Pos. In Opening");
				
				myParent.gridOp = 4;
				bEqualizeH.setSelected(false);
				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Change horizontal master action listener
		bChangeMasterH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Select New Horizontal Master");
			
				myParent.gridOp = 2;
				bChangeMasterH.setSelected(false);
				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Change vertical master action listener
		bChangeMasterV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Select New Vertical Master");
				
				myParent.gridOp = 1;
				bChangeMasterV.setSelected(false);
				resetPanel();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Setting selected grid option
		bSetSelectedGrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				// setGridAction(1);
				// resetGridDesign(1);

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Setting selected grid option
		bAddSelectedGrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				setGridAction(2);

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Change number of grids options
		bChangeNumGrids.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				l2.setText("Click Glass to Configure");
				
				form = 0;
				setHV.doClick();
				setRS.setSelected(false);
				
				myParent.gridOp = 7;
				bChangeNumGrids.setSelected(false);
				resetPanel();

				// Reset grids from facet selected used
				myParent.facetUsed.resetGrids();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Setting number of grids
		bSetNumberGrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Adding a undo action for this
				myParent.addToUndo();
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				myParent.gridOp = 7;
				myParent.SetNumGrids(xxx, yyy, 7, 2, form);

				bChangeNumGrids.setSelected(false);
				resetPanel();

				// Reset grids from facet selected used
				myParent.facetUsed.resetGrids();

				// Call dimension action from ItemFrame
				myParent.dimAction();

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Setting horizontal and vertical action listener
		setHV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				form = 0;
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				myParent.gridOp = 7;

				lV.setEnabled(true);
				lH.setEnabled(true);
				tV.setEnabled(true);
				tH.setEnabled(true);

				lS.setEnabled(false);
				tS.setEnabled(false);

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}
		});

		// Setting action listener
		setRS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				form = 1;
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT.getValue());
				 
				myParent.gridOp = 7;

				lV.setEnabled(false);
				lH.setEnabled(false);
				tV.setEnabled(false);
				tH.setEnabled(false);

				lS.setEnabled(true);
				tS.setEnabled(true);

                //****************************************************
                //Recalculate Bom for Window
                //****************************************************
                myParent.calcBom = true;
			}

		});
	}

	/**
	 * Init Grid Value Components
	 * 
	 * @param resetGridValue
	 *            , Indicate if this panel should restart grid options
	 */
	public void initGridValueComponents(boolean resetGridValue) {

		// Edit design
		this.resetGridValue = resetGridValue;

		// Initialize values for grids JComboBox component
		this.myGrids = gridsController.searchAllGrids();
		this.gridCombo.setModel(new DefaultComboBoxModel(myGrids.toArray()));

		// Initialize default GridType for JobItem model
		if (this.myParent.jobItem != null && this.myParent.jobItem.gridType > 0) {
			for (Grids grid : this.myGrids) {
				if (grid.getId().intValue() == this.myParent.jobItem.gridType) {
					if (gridCombo.getModel().getSize() > 0) {
						gridCombo.setSelectedItem(grid);

						// Setting Grid Action
						setGridAction(1);
						break;
					}
				}
			}
		}

		// Always true - only the first time not reset if design is edit
		this.resetGridValue = true;
	}

	/**
	 * This method set grid action performed for design component
	 * 
	 * @param type, Type of Grid action performed
	 */
	private void setGridAction(int type) {

		// Get grid selected
		this.myGrid = (Grids) gridCombo.getSelectedItem();

		if (this.myGrid.getId() > 0) {
			this.myParent.hasGrids = true;
			this.myParent.dim.grids.setEnabled(true);
			
			if (p15.isShowing()) {
				this.gridPanel.remove(p15);
			}
			
			this.buildP15Panel();

			this.gridPanel.add(this.p15, BorderLayout.CENTER);

			this.gridPanel.validate();
			this.gridPanel.repaint();

		} else {
			this.myParent.hasGrids = false;
			this.myParent.dim.grids.setEnabled(false);

			this.gridPanel.remove(p15);
			this.gridPanel.validate();
			this.gridPanel.repaint();
		}
	}

	/**
	 * Reset Grid Design
	 * 
	 * @param type
	 *            , Type of Grid action performed
	 */
	private void resetGridDesign(int type) {

		// Starts grid to model design
		this.myParent.jobItem.design.findDLO = new FindBiggestDLO(myParent);
		this.myParent.jobItem.design.startGrids(this.myGrid.getId(), this.myGrid.getGridTypeId(), 2, type);

		// Set selected grid to false
		this.bSetSelectedGrid.setSelected(false);

		// Reset Options values
		this.myParent.options.initValues();

		// Reset panel
		this.resetPanel();

        //****************************************************
        //Recalculate Bom for Window
        //****************************************************
        this.myParent.calcBom = true;

		this.myParent.validate();
		this.myParent.repaint();
	}

	/**
	 * Reset panel setting visible panel #16
	 */
	public void resetPanel() {
		p16.setVisible(false);
	}

	public void setGridChangePanel(DLO selecteddlo, int x, int y) {

		xxx = x;
		yyy = y;
		setHV.setSelected(true);
		if (selecteddlo.gridForm >= 1) {
			setRS.doClick();
		}
		tV.setText(selecteddlo.anchorsV.size() + "");
		tH.setText(selecteddlo.anchorsH.size() + "");
		tS.setText(selecteddlo.noGridsS + "");

		p16.setVisible(true);

	}
}
