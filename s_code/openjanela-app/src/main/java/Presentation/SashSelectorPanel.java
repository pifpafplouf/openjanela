package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import openjanela.app.configuration.controller.OpeningSelectorPanelController;
import openjanela.model.entities.admin.TypeOpening;
import openjanela.model.entities.design.OpeningClassTypes;
import openjanela.model.entities.design.OpeningTypes;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import openjanela.model.entities.partner.SeriesValidOpeningShapeOrder;

import org.apache.log4j.Logger;
import org.openjanela.component.JOpenJanelaComponent;
import org.openjanela.data.MenuActionEventDraw;

import util.XYConstraints;
import util.XYLayout;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * 
 * @author Sherif El Dibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
public class SashSelectorPanel extends JPanel implements JOpenJanelaComponent {

	// Apache log4j
	private static final Logger logger = Logger
			.getLogger(SashSelectorPanel.class);

	// ItemFrame parent
	public ItemFrame myParent;

	// Panels definitions
	public JPanel mainPanel = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel bodyPanel = new JPanel();
	private JPanel typePanel = new JPanel();

	public int openingClass = 0;
	public int userDefinedOpeningID = 0;
	public int noOfLeafs = 0;

	public int opens = 0; // 0=fixed 1=out 2=in 3= slide

	public SeriesValidOpeningShape mySelected = new SeriesValidOpeningShape();

	public JRadioButton subFrameButton = new JRadioButton();
	public JRadioButton subSashButton = new JRadioButton();

	private final JLabel subFL = new JLabel();
	private final JLabel subSL = new JLabel();

	private final JCheckBox removeSub = new JCheckBox();

	private final JRadioButton posIn = new JRadioButton(); // Inside track
	private final JRadioButton posMid = new JRadioButton(); // Middle track
	private final JRadioButton posOut = new JRadioButton(); // Outside track

	private final JLabel posInL = new JLabel();
	private final JLabel posMidL = new JLabel();
	private final JLabel posOutL = new JLabel();

	private final ButtonGroup subGroup = new ButtonGroup();
	private final ButtonGroup pos = new ButtonGroup();

	public int subOp = 0; // 0 = ignore, 1== frame 2 == sash 3 == remove

	public int selectedType = 0;

	public boolean isOriel = false;

	public int[] interlockTypes; // fold

	public int notracks = 1;

	public int[] sashOnTrack;
	// tracks from In to Out ; 1...n

	public double split = 0;

	public double percentA = 0;
	public double percentB = 0;
	public double percentC = 0;

	public boolean glazedOut = true;

	public boolean[] sashGlazedOut;

	public int whichPos = 0; // 1-in, 2 mid 3 out

	public int[] paneType;

	public boolean doDialog = false;
	public boolean useW = true;
	public double extendExtra = 0;

	public JRadioButton wButton = new JRadioButton(); // Windows button
	public JRadioButton dButton = new JRadioButton(); // Door button
	public JRadioButton eButton = new JRadioButton(); // Entrance button
	public JRadioButton sButton = new JRadioButton(); // Standar button

	public JLabel wButtonl = new JLabel(); // Windows button
	public JLabel dButtonl = new JLabel(); // Door button
	public JLabel eButtonl = new JLabel(); // Entrance button
	public JLabel sButtonl = new JLabel(); // Standar button

	ButtonGroup bGroup = new ButtonGroup();

	public JScrollPane openScroll = new JScrollPane();

	private JComboBox cboOpeningClass;

	// *******************************************************************
	// JTable Opening list valid
	// *******************************************************************
	public JList openingList = new JList(new DefaultListModel());

	// *******************************************************************
	// Controller services
	// *******************************************************************
	private final OpeningSelectorPanelController openingController;

	/**
	 * Create SashSelectorPanel constructor
	 * 
	 * @param frame
	 *            , ItemFrame
	 */
	public SashSelectorPanel(ItemFrame frame) {

		// Setting ItemFrame parent
		this.myParent = frame;

		// Init controller
		this.openingController = new OpeningSelectorPanelController();

		// Init components Layout
		initComponents();
		initValueComponents();
		initListenersComponents();
	}

	@Override
	public void initComponents() {

		// *************************************************************
		// Config top panel
		// *************************************************************
		this.initTopPanel();

		// *************************************************************
		// JTable Opening list
		// *************************************************************
		this.openingList.setCellRenderer(new ListCellRendererOpening());
		this.openingList.setFixedCellHeight(35);
		this.openingList.setLayoutOrientation(JList.VERTICAL);

		// *************************************************************
		// Open Scroll Component
		// *************************************************************
		this.openScroll.setPreferredSize(new Dimension(148, 180));
		this.openScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.openScroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.openScroll.getViewport().add(openingList);

		// *************************************************************
		// Config body panel
		// *************************************************************
		this.bodyPanel.setLayout(new BorderLayout());
		this.bodyPanel.setPreferredSize(new Dimension(200, 280));
		this.bodyPanel.add(openScroll, BorderLayout.CENTER);

		// *************************************************************
		// Config main panel
		// *************************************************************
		this.mainPanel.setLayout(new BorderLayout());
		this.mainPanel.setPreferredSize(new Dimension(300, 312));
		this.typePanel.setPreferredSize(new Dimension(50, 200));
		this.northPanel.setPreferredSize(new Dimension(200, 60));

		this.mainPanel.add(northPanel, BorderLayout.NORTH);
		this.mainPanel.add(bodyPanel, BorderLayout.CENTER);
		this.mainPanel.add(typePanel, BorderLayout.WEST);
	}

	@Override
	public void initValueComponents() {

		// ********************************************************************
		// Search for valid openings using the series selected value
		// ********************************************************************
		this.openingController.findValidOpenings();

		// ********************************************************************
		// Filter Openings Values
		// ********************************************************************
		if (!this.openingController.getWindowsMap().isEmpty()) {
			this.wButton.setEnabled(true);
			this.wButton.setSelected(true);
		}

		if (!this.openingController.getDoorsMap().isEmpty()) {
			this.dButton.setEnabled(true);
			if (!wButton.isSelected()) {
				this.dButton.setSelected(true);
			}
		}

		if (!this.openingController.getEntranceMap().isEmpty()) {
			this.eButton.setEnabled(true);
			if (!dButton.isSelected()) {
				this.eButton.setSelected(true);
			}
		}

		if (!this.openingController.getStandardMap().isEmpty()) {
			this.sButton.setEnabled(true);
			if (!this.eButton.isSelected()) {
				this.sButton.setSelected(true);
			}
		}

		// ********************************************************************
		// Load Opening Class Type Values
		// ********************************************************************
		List<OpeningClassTypes> openingClassTypes = new ArrayList<OpeningClassTypes>();

		openingClassTypes.add(OpeningClassTypes.ALL);

		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.OUT_SWING.getValue())) {
			openingClassTypes.add(OpeningClassTypes.OUT_SWING);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.IN_SWING.getValue())) {
			openingClassTypes.add(OpeningClassTypes.IN_SWING);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.S_SLIDER.getValue())) {
			openingClassTypes.add(OpeningClassTypes.S_SLIDER);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.D_SLIDER.getValue())) {
			openingClassTypes.add(OpeningClassTypes.D_SLIDER);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.N_SLIDER.getValue())) {
			openingClassTypes.add(OpeningClassTypes.D_SLIDER);
		}
		if (openingController.isContainsValidOpenings(OpeningClassTypes.FOLDING
				.getValue())) {
			openingClassTypes.add(OpeningClassTypes.FOLDING);
		}
		if (openingController.isContainsValidOpenings(OpeningClassTypes.TRANSOM
				.getValue())) {
			openingClassTypes.add(OpeningClassTypes.TRANSOM);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.SIDE_LIGHT
						.getValue())) {
			openingClassTypes.add(OpeningClassTypes.SIDE_LIGHT);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.KICK_PANEL
						.getValue())) {
			openingClassTypes.add(OpeningClassTypes.KICK_PANEL);
		}
		if (openingController.isContainsValidOpenings(OpeningClassTypes.POCKET
				.getValue())) {
			openingClassTypes.add(OpeningClassTypes.POCKET);
		}
		if (openingController.isContainsValidOpenings(OpeningClassTypes.PIVOT
				.getValue())) {
			openingClassTypes.add(OpeningClassTypes.PIVOT);
		}
		if (openingController
				.isContainsValidOpenings(OpeningClassTypes.LOUVERED.getValue())) {
			openingClassTypes.add(OpeningClassTypes.LOUVERED);
		}

		cboOpeningClass.setModel(new DefaultComboBoxModel(openingClassTypes
				.toArray()));

		cboOpeningClass.setSelectedIndex(0);

		// Clear opening list values
		this.openingList.removeAll();

		// Setting selected index to first list value
		this.cboOpeningClass.setSelectedIndex(0);

		// Setting selected options
		if (this.myParent.mySeries.isOpeningIn()) {
			this.posIn.setEnabled(true);
		}

		if (this.myParent.mySeries.isOpeningMid()) {
			this.posMid.setEnabled(true);
		}

		if (this.myParent.mySeries.isOpeningOut()) {
			this.posOut.setEnabled(true);
		}

		if (this.myParent.mySeries.isSubFrame()) {
			this.subFrameButton.setEnabled(true);
		}

		if (this.myParent.mySeries.isSubSash()) {
			this.subSashButton.setEnabled(true);
		}
	}

	@Override
	public void initListenersComponents() {

		cboOpeningClass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				OpeningClassTypes openingClassTypes = (OpeningClassTypes) ((JComboBox) e
						.getSource()).getSelectedItem();

				// Opening type value
				int openingType = openingClassTypes.getValue();

				// Setting parent type event
				myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT
						.getValue());

				if (openingType == OpeningClassTypes.OUT_SWING.getValue()) {
					outSwing_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.IN_SWING.getValue()) {
					inSwing_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.S_SLIDER.getValue()) {
					sSlide_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.D_SLIDER.getValue()) {
					dSlide_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.FOLDING.getValue()) {
					folding_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.TRANSOM.getValue()) {
					transom_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.SIDE_LIGHT
						.getValue()) {
					sideLight_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.KICK_PANEL
						.getValue()) {
					kickPanel_actionPerformed(e);
				} else if (openingType == OpeningClassTypes.POCKET.getValue()) {
					pocket_actionEvent(e);
				} else if (openingType == OpeningClassTypes.PIVOT.getValue()) {
					pivot_actionEvent(e);
				} else if (openingType == OpeningClassTypes.LOUVERED.getValue()) {
					louvered_actionEvent(e);
				} else if (openingType == OpeningClassTypes.ALL.getValue()) {
					all_actionPerformed(e);
				}
			}
		});

		subFrameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT
						.getValue());
				if (subOp == 0 || subOp == 2) {
					subFrameButton.setSelected(true);
					subOp = 1;
				} else {
					subFrameButton.setSelected(false);
					removeSub.doClick();
					subOp = 0;

				}
			}
		});

		subSashButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT
						.getValue());
				if (subOp == 0 || subOp == 1) {
					subSashButton.setSelected(true);
					subOp = 2;
				} else {
					subSashButton.setSelected(false);
					removeSub.doClick();
					subOp = 0;
					SashSelectorPanel.this.validate();
					SashSelectorPanel.this.repaint();
					myParent.validate();
					myParent.repaint();
				}
			}
		});

		removeSub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT
						.getValue());
				subSashButton.setSelected(false);
				subFrameButton.setSelected(false);

				SashSelectorPanel.this.validate();
				SashSelectorPanel.this.repaint();
			}
		});

		openingList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {

				if (event.getValueIsAdjusting()) {
					return;
				} else {

					myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT
							.getValue());
					myOpeningSelectionMethod();
					openingList.clearSelection();
				}

			}
		});

		wButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cboOpeningClass.setSelectedIndex(0);
			}
		});

		dButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cboOpeningClass.setSelectedIndex(0);
			}
		});

		eButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cboOpeningClass.setSelectedIndex(0);
			}
		});

		sButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cboOpeningClass.setSelectedIndex(0);
			}
		});

	}

	private void myOpeningSelectionMethod() {
		if (openingList.getSelectedValue() != null) {

			// Setting selected valid opening shape
			mySelected = ((SeriesValidOpeningShape) openingList
					.getSelectedValue());

			// Setting selected type opening
			if (mySelected.isWindow()) {
				selectedType = OpeningTypes.WINDOW.getValue();
			} else if (mySelected.isDoor()) {
				selectedType = OpeningTypes.DOOR.getValue();
			} else if (mySelected.isEntrance()) {
				selectedType = OpeningTypes.ENTRANCE.getValue();
			} else if (mySelected.isStandard()) {
				selectedType = OpeningTypes.STANDARD.getValue();
			}

			String imageName = "op"
					+ mySelected.getSeriesValidOpeningPK().getOpeningId();
			myParent.myCursorImage = ItemFrame.iconFiles.get(imageName);
			myParent.myCursor = myParent.toolkit.createCustomCursor(
					myParent.myCursorImage.getImage(), new Point(0, 0), "");
			myParent.startCustomCursor(myParent.main, myParent.myCursor);

			// Set selected opening shape
			setSelectedOpening(mySelected);
		}
	}

	/**
	 * Config Top Panel components
	 */
	private void initTopPanel() {

		this.subFL.setIcon(ItemFrame.iconFiles.get("subFrame"));
		this.subSL.setIcon(ItemFrame.iconFiles.get("subsash"));
		this.posInL.setIcon(ItemFrame.iconFiles.get("pos1In"));
		this.posMidL.setIcon(ItemFrame.iconFiles.get("pos2Mid"));
		this.posOutL.setIcon(ItemFrame.iconFiles.get("pos3Out"));

		this.wButtonl.setIcon(ItemFrame.iconFiles.get("windows"));
		this.dButtonl.setIcon(ItemFrame.iconFiles.get("doors"));
		this.eButtonl.setIcon(ItemFrame.iconFiles.get("entry"));
		this.sButtonl.setIcon(ItemFrame.iconFiles.get("standard"));

		this.bGroup.add(this.wButton);
		this.bGroup.add(this.dButton);
		this.bGroup.add(this.eButton);
		this.bGroup.add(this.sButton);

		this.subGroup.add(this.subFrameButton);
		this.subGroup.add(this.subSashButton);
		this.subGroup.add(this.removeSub);

		this.pos.add(posIn);
		this.pos.add(posMid);
		this.pos.add(posOut);

		this.posMid.setEnabled(false);
		this.posMid.setSelected(false);
		this.posIn.setEnabled(false);
		this.posIn.setEnabled(false);
		this.posOut.setEnabled(false);
		this.posOut.setEnabled(false);

		this.subFrameButton.setEnabled(false);
		this.subSashButton.setEnabled(false);

		this.subFrameButton
				.setToolTipText("Add Sash complete with Frame(Frame in Frame)");
		this.subSashButton.setToolTipText("Add Sash in Sash");
		this.subFL
				.setToolTipText("Add Sash complete with Frame(Frame in Frame)");
		this.subSL.setToolTipText("Add Sash in Sash");
		this.posInL.setToolTipText("Inside Edge of Frame");
		this.posMidL.setToolTipText("Middle of Frame");
		this.posOutL.setToolTipText("Outside Edge of Frame");
		this.posIn.setToolTipText("Inside Track");
		this.posMid.setToolTipText("Middle Track");
		this.posOut.setToolTipText("Outside Track");

		this.wButtonl.setToolTipText("Filter Windows");
		this.dButtonl.setToolTipText("Filter Doors");
		this.eButtonl.setToolTipText("Filter Entry Doors");
		this.sButtonl.setToolTipText("Filter Std. Products");

		this.wButton.setToolTipText("Filter Windows");
		this.wButton.setEnabled(false);

		this.dButton.setToolTipText("Filter Doors");
		this.dButton.setEnabled(false);

		this.eButton.setToolTipText("Filter Entry Doors");
		this.eButton.setEnabled(false);

		this.sButton.setToolTipText("Filter Std. Products");
		this.sButton.setEnabled(false);

		this.cboOpeningClass = new JComboBox();

		this.northPanel.setPreferredSize(new Dimension(255, 56));
		this.northPanel.setLayout(new XYLayout());

		this.northPanel.add(wButton, new XYConstraints(50, 1, 30, 30));
		this.northPanel.add(wButtonl, new XYConstraints(82, 1, 30, 30));
		this.northPanel.add(dButton, new XYConstraints(114, 1, 30, 30));
		this.northPanel.add(dButtonl, new XYConstraints(146, 1, 30, 30));
		this.northPanel.add(eButton, new XYConstraints(178, 1, 30, 30));
		this.northPanel.add(eButtonl, new XYConstraints(210, 1, 30, 30));
		this.northPanel.add(sButton, new XYConstraints(242, 1, 30, 30));
		this.northPanel.add(sButtonl, new XYConstraints(274, 1, 30, 30));

		this.typePanel.add(posIn, new XYConstraints(0, 1, 18, 22));
		this.typePanel.add(posInL, new XYConstraints(20, 1, 18, 22));
		this.typePanel.add(posMid, new XYConstraints(0, 25, 18, 22));
		this.typePanel.add(posMidL, new XYConstraints(20, 25, 18, 22));
		this.typePanel.add(posOut, new XYConstraints(0, 49, 18, 22));
		this.typePanel.add(posOutL, new XYConstraints(20, 49, 18, 22));

		this.typePanel.add(subFrameButton, new XYConstraints(0, 73, 20, 22));
		this.typePanel.add(subFL, new XYConstraints(20, 73, 18, 22));
		this.typePanel.add(subSashButton, new XYConstraints(0, 97, 20, 22));
		this.typePanel.add(subSL, new XYConstraints(20, 97, 18, 22));

		this.northPanel
				.add(cboOpeningClass, new XYConstraints(50, 35, 255, 22));
	}

	private void all_actionPerformed(ActionEvent event) {
		getAllOpenings();

	}

	private void getAllOpenings() {

		myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT.getValue());

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : openingController.getTypeOpenings()) {
			// if (openingController.isContainsValidOpenings(o.getId())) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
			// }
		}

		openingList.removeAll();

		openingList.removeAll();

		// Order Collection
		Collections.sort(validOpeningShapes,
				SeriesValidOpeningShapeOrder.SEQUENCE);

		openingList.setListData(validOpeningShapes.toArray());
	}

	private void outSwing_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isOutswing() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());
	}

	private void inSwing_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isInswing() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void sSlide_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isSslider() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void dSlide_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isDslider() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void customSlide_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isNslider() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void folding_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isFolding() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void transom_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isTransom() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void sideLight_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isSidelight() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void kickPanel_actionPerformed(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isKickpanel() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void pocket_actionEvent(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isPocket() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void pivot_actionEvent(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isPivot() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	private void louvered_actionEvent(ActionEvent event) {

		// Default window in sashes values for window In
		List<TypeOpening> typeOpenings = new ArrayList();

		for (TypeOpening o : openingController.getTypeOpenings()) {
			if (o.isLouvered() || o.isPicture()) {
				typeOpenings.add(o);
			}
		}

		List<SeriesValidOpeningShape> validOpeningShapes = new ArrayList();
		for (TypeOpening o : typeOpenings) {
			validOpeningShapes.addAll(openingController.getValidOpeningShape(
					o.getId(), wButton.isSelected(), dButton.isSelected(),
					eButton.isSelected(), sButton.isSelected()));
		}

		openingList.removeAll();
		openingList.setListData(validOpeningShapes.toArray());

	}

	/*
	 * Pane Types Symbols: 1= Fixed/Direct Glazed 2 = LH // 3 = RH // 4 = Awning
	 * // 5 = Fixed Sash // 6 = Hopper // 7 = LSlide // 8 = RSlide // 9 = Bi
	 * Slide // 10 = Fixed Slider Sash // 11 = slide Down // 12 = slide Up // 13
	 * = TTL // 14 = TTR // 15 = pivot V // 16 = pivot H // 17 = folding // 18 =
	 * JalousieL // 19 = JalousieS // 20 = JalousieG // 30 = LH+Slide R 31 =
	 * RH+Slide L 50 = slave L Projected 51 = slave R Projected
	 */
	public int[] getDefaultSashType() {

		// Get default sash type
		openingClass = myParent.mySeries.getDefaultOpeningClass();
		userDefinedOpeningID = myParent.mySeries.getDefaultOpeningType();

		mySelected = ItemFrame.getApplicationBaseRules()
				.getSeriesValidOpeningById(
						myParent.mySeries.getDefaultOpeningType());

		// Setting sashInfo
		setSashInfo();

		// ********************************
		// Preparing sash type information
		// ********************************
		int[] info = new int[3];
		info[0] = openingClass;
		info[1] = userDefinedOpeningID;
		info[2] = 0;

		if (glazedOut) {
			info[2] = 1;
		}

		return info;
	}

	public int[] setDefaultSashType() {

		// Get default sash type
		openingClass = myParent.mySeries.getDefaultOpeningClass();
		userDefinedOpeningID = myParent.mySeries.getDefaultOpeningType();

		mySelected = ItemFrame.getApplicationBaseRules()
				.getSeriesValidOpeningById(
						myParent.mySeries.getDefaultOpeningType());

		// Setting sashInfo
		setSashInfo();

		// ********************************
		// Preparing sash type information
		// ********************************
		int[] info = new int[3];
		info[0] = openingClass;
		info[1] = userDefinedOpeningID;
		info[2] = 0;

		if (glazedOut) {
			info[2] = 1;
		}

		return info;
	}

	public int[] setSashType(int opClass, int udid) {

		// Get default sash type
		openingClass = opClass;
		userDefinedOpeningID = udid;

		mySelected = ItemFrame.getApplicationBaseRules()
				.getSeriesValidOpeningById(udid);

		// Setting sashInfo
		setSashInfo();

		// ********************************
		// Preparing sash type information
		// ********************************
		int[] info = new int[3];
		info[0] = openingClass;
		info[1] = userDefinedOpeningID;
		info[2] = 0;

		if (glazedOut) {
			info[2] = 1;
		}

		return info;
	}

	/**
	 * This method setting selected valid shape opening information to process
	 * 
	 * @param validOpeningShape
	 *            , SeriesValidOpeningShape
	 */
	private void setSelectedOpening(SeriesValidOpeningShape validOpeningShape) {

		myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT.getValue());
		// Setting selected sashes and IDs
		this.openingClass = validOpeningShape.getSeriesValidOpeningPK()
				.getOpeningId();
		this.userDefinedOpeningID = validOpeningShape.getSeriesValidOpeningPK()
				.getId();

		// Evaluate selected sash key
		if (this.openingClass > 100 && this.selectedType == 1) {
			isOriel = true;
		} else if (this.openingClass > 700 && this.selectedType == 2) {
			isOriel = true;
		} else if (this.openingClass > 900 && this.selectedType == 3) {
			isOriel = true;
		} else {
			isOriel = false;
		}

		// Setting sash information
		setSashInfo();
	}

	/**
	 * Setting sash information
	 * 
	 * @return boolean
	 */
	public boolean setSashInfo() {
		myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT.getValue());
		boolean found = false;
		doDialog = false;
		useW = true;

		switch (openingClass) {

		case 1:
		case 501:
			found = pictureWindow();
			break;
		case 2:
		case 3:
		case 4:
		case 502:
		case 503:
		case 504:
			casementSwingOut();
			found = true;
			break;
		case 5:
		case 505:
			fixedSwingOut();
			found = true;
			break;
		case 6:
		case 7:
		case 8:
		case 506:
		case 507:
		case 508:
			casementInSwing();
			found = true;
			break;
		case 9:
		case 509:
			fixedInSwing();
			found = true;
			break;
		case 10:
		case 510:
			hopper();
			found = true;
			break;
		case 11:
		case 12:
		case 511:
		case 512:
			ss2LS();
			found = true;
			break;
		case 13:
		case 513:
			ss3LS();
			found = true;
			break;
		case 14:
		case 514:
			ss4LS();
			found = true;
			break;
		case 15:
		case 16:
		case 17:
		case 515:
		case 516:
		case 517:
			ssCenterSlide();
			found = true;
			break;
			
		case 18:
			// Custom 1T Slider
			found = true;
			break;
			
		case 518:
			// Custom 2T Slider
			found = true;
			break;
			
		case 21:
		case 22:
		case 521:
		case 522:
			ds2LS();
			found = true;
			break;
		case 23:
		case 523:
			ds3LS();
			found = true;
			break;
		case 24:
		case 524:
			ds4LS();
			found = true;
			break;
		case 25:
		case 26:
		case 27:
		case 525:
		case 526:
		case 527:
			dsCenterSlide();
			found = true;
			break;
			
//		case 28:
//		case 528:
//			// Custom 2T Slider
//			found = true;
//			break;
			
		case 31:
		case 531:
			ssSH();
			found = true;
			useW = false;
			break;
		case 32:
		case 532:
			dsDH();
			found = true;
			useW = false;
			break;
		case 41:
		case 541:
			ttL();
			found = true;
			break;
		case 42:
		case 542:
			ttR();
			found = true;
			break;
		case 43:
		case 543:
			ttLsR();
			found = true;
			break;
		case 44:
		case 544:
			ttRsL();
			found = true;
			break;
		case 51:
		case 551:
			pivotV();
			found = true;
			break;
		case 52:
		case 552:
			pivotH();
			found = true;
			break;
		case 61:
		case 561:
			jGlass();
			found = true;
			break;
		case 62:
			jSash();
			found = true;
			break;
		case 63:
			jLouver();
			found = true;
			break;
		case 71:
		case 571:
			cLR(1);// Swing Out
			found = true;
			break;
		case 72:
		case 572:
			cL_RS(1);// Swing Out
			found = true;
			break;
		case 73:
		case 573:
			cR_LS(1);// Swing Out
			found = true;
			break;
		case 76:
		case 576:
			cLR(2);// Swing In
			found = true;
			break;
		case 77:
		case 577:
			cL_RS(2);
			found = true;
			break;
		case 78:
		case 578:
			cR_LS(2);
			found = true;
			break;
		case 211:
		case 212:
		case 711:
			ss2LS();
			found = true;
			break;
		case 213:
		case 713:
			ss3LS();
			found = true;
			break;
		case 214:
		case 714:
			ss4LS();
			found = true;
			break;
		case 215:
		case 216:
		case 217:
		case 715:
		case 716:
		case 717:
			ssCenterSlide();
			found = true;
			break;
			
//		case 218:
//		case 718:
//			// Custom 1T Slider
//			found = true;
//			break;
			
		case 221:
		case 222:
		case 721:
		case 722:
			ds2LS();
			found = true;
			break;
		case 223:
		case 723:
			ds3LS();
			found = true;
			break;
		case 224:
		case 724:
			ds4LS();
			found = true;
			break;
		case 225:
		case 226:
		case 227:
		case 725:
		case 726:
		case 727:
			dsCenterSlide();
			found = true;
			break;
//		case 228:
//		case 728:
//			// Custom 2T Slider
//			found = true;
//			break;
		case 231:
		case 731:
			ssSH();
			found = true;
			useW = false;
			break;
		case 232:
		case 732:
			dsDH();
			found = true;
			useW = false;
			break;
		case 243:
		case 743:
			ttLsR();
			found = true;
			break;
		case 271:
		case 771:
			cLR(1);// Swing Out
			found = true;
			break;
		case 272:
		case 772:
			cL_RS(1);// Swing Out
			found = true;
			break;
		case 273:
		case 773:
			cR_LS(1);// Swing Out
			found = true;
			break;
		case 276:
		case 776:
			cLR(2);// Swing In
			found = true;
			break;
		case 277:
		case 777:
			cL_RS(2);// Swing In
			found = true;
			break;
		case 278:
		case 778:
			cR_LS(2);// Swing In
			found = true;
			break;
		
		case 291:
		case 791:
			// Custom Sliders L
			found = true;
			break;
		
		case 292:
		case 792:
			// Custom Sliders R
			found = true;
			break;
		
		case 293:
		case 793:
			// Custom Sliders C
			found = true;
			break;
		
		case 301:
		case 302:
		case 303:
		case 801:
		case 802:
		case 803:
			folding();
			found = true;
			break;
		
		
		case 311:
		case 811:
			// Custom Pocket L
			useW = true;
			pocket();
			found = true;
			break;
		
		
		case 312:
		case 812:
			// Custom Pocket R
			useW = true;
			pocket();
			found = true;
			break;
		
		
		case 313:
		case 813:
			// Custom Pocket C
			useW = true;
			pocket();
			found = true;
			break;
		default:
			// Do nothing - no value found
			break;
		}

		if (openingClass == 1 || openingClass == 501) {
			if (this.myParent.mySeries.isGlazedout()) {
				glazedOut = true;
			} else {
				glazedOut = false;
			}
		} else {
			glazedOut = mySelected.isGlazedout();
		}
		// if (this.myParent.mySeries.isGlazedout()) {
		// glazedOut = true;
		// }
		if (openingClass >= 200) {
			doDialog = true;
		}

		return found;
	}

	private void ttL() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 2;
		// glazedOut = false;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();

		split = 100;

		sashOnTrack[0] = 1;

		paneType[0] = 13;

	}

	private void pivotH() {
		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		split = 100;
		sashOnTrack[0] = 1;
		paneType[0] = 16;
	}

	private void pivotV() {
		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		split = 100;
		sashOnTrack[0] = 1;
		paneType[0] = 15;
	}

	private void ttR() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 2;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		split = 100;
		sashOnTrack[0] = 1;
		paneType[0] = 14;
	}

	private void jGlass() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 2;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = false;
		split = 100;
		sashOnTrack[0] = 1;
		paneType[0] = 20;
	}

	private void jSash() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 2;
		// glazedOut = true;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = false;

		split = 100;

		sashOnTrack[0] = 1;

		paneType[0] = 20;
	}

	private void jLouver() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 1;
		// glazedOut = true;
		sashGlazedOut = new boolean[noOfLeafs];

		sashGlazedOut[0] = false;

		split = 100;

		sashOnTrack[0] = 1;

		paneType[0] = 20;
	}

	private void ttLsR() {
		noOfLeafs = 2;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 2;
		split = 50;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashOnTrack[0] = 1;
		sashOnTrack[1] = 1;
		paneType[0] = 13;
		paneType[1] = 51;
		interlockTypes[0] = 6;
	}

	private void ttRsL() {

		noOfLeafs = 2;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 2;
		split = 50;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashOnTrack[0] = 1;
		sashOnTrack[1] = 1;
		paneType[0] = 50;
		paneType[1] = 14;
		interlockTypes[0] = 6;
	}

	private void cLR(final int open) {

		noOfLeafs = 2;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = open;
		// glazedOut = false;
		split = 50;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashOnTrack[0] = 1;
		sashOnTrack[1] = 1;
		paneType[0] = 2;
		paneType[1] = 3;
		// doDialog = true;
		interlockTypes[0] = 6;
	}

	private void cL_RS(final int open) {

		noOfLeafs = 2;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = open;
		// glazedOut = false;
		split = 50;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashOnTrack[0] = 1;
		sashOnTrack[1] = 1;
		paneType[0] = 2;
		paneType[1] = 51;
		interlockTypes[0] = 6;
		// doDialog = true;
	}

	private void cR_LS(final int open) {

		noOfLeafs = 2;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = open;
		// glazedOut = false;
		split = 50;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];

		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashOnTrack[0] = 1;
		sashOnTrack[1] = 1;
		paneType[0] = 50;
		paneType[1] = 3;
		// doDialog = true;
		interlockTypes[0] = 6;
	}

	private void dsDH() {

		noOfLeafs = 2;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();

		split = 50;

		sashOnTrack[0] = 2;// Outside track
		sashOnTrack[1] = 1;// Inside track
		paneType[0] = 11;
		paneType[1] = 12;
		interlockTypes[0] = 5;
	}

	private void ssSH() {

		split = 50;
		noOfLeafs = 2;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];

		sashGlazedOut[0] = this.myParent.mySeries.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashOnTrack[0] = 2; // outside track
		sashOnTrack[1] = 1; // inside track
		paneType[0] = 1;
		paneType[1] = 12;
		interlockTypes[0] = 4;
	}

	private void ssCenterSlide() {

		noOfLeafs = 3;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashOnTrack[0] = 1; // lowest track inside always
		sashOnTrack[1] = 2; // lowest track inside always
		sashOnTrack[2] = 1;
		split = 33.3f;
		sashGlazedOut[0] = this.myParent.mySeries.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = this.myParent.mySeries.isGlazedout();
		paneType[0] = 1;
		paneType[2] = 1;

		if (openingClass == 15) {
			paneType[1] = 7;
		}
		if (openingClass == 16) {
			paneType[1] = 8;
		}
		if (openingClass == 17) {
			paneType[1] = 9;
		}
		interlockTypes[0] = 4;
		interlockTypes[1] = 3;
	}

	private void fixedSwingOut() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		sashOnTrack[0] = 1;
		// glazedOut = false;
		sashGlazedOut = new boolean[noOfLeafs];
		sashGlazedOut[0] = mySelected.isGlazedout();
		opens = 1;
		paneType = new int[1];

		paneType[0] = 5;

		whichPos = 2; // 1=In 3= out 2 = mid.
	}

	private void casementSwingOut() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		sashOnTrack[0] = 1;
		// glazedOut = false;
		sashGlazedOut = new boolean[noOfLeafs];
		sashGlazedOut[0] = mySelected.isGlazedout();
		opens = 1;
		paneType = new int[1];
		if (openingClass == 2) {
			paneType[0] = 2;
		} else if (openingClass == 3) {
			paneType[0] = 3;
		} else if (openingClass == 4) {
			paneType[0] = 4;
		}
		whichPos = 2; // 1=In 3= out 2 = mid.
	}

	private boolean pictureWindow() {

		boolean found;
		noOfLeafs = 0;
		whichPos = 2;
		opens = 0;

		found = true;
		paneType = new int[1];
		paneType[0] = 1;// Picture
		return found;
	}

	private void casementInSwing() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		sashOnTrack[0] = 1;
		sashGlazedOut = new boolean[noOfLeafs];
		sashGlazedOut[0] = mySelected.isGlazedout();
		opens = 2;
		paneType = new int[1];

		if (openingClass == 6) {
			paneType[0] = 2;
		} else if (openingClass == 7) {
			paneType[0] = 3;
		} else if (openingClass == 8) {
			paneType[0] = 4;
		}
		whichPos = 2; // 1=In 3= out 2 = mid.
	}

	private void fixedInSwing() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		sashOnTrack[0] = 1;
		sashGlazedOut = new boolean[noOfLeafs];
		sashGlazedOut[0] = mySelected.isGlazedout();
		opens = 2;
		paneType = new int[1];
		paneType[0] = 5;
		whichPos = 2; // 1=In 3= out 2 = mid.
	}

	private void hopper() {

		noOfLeafs = 1;
		notracks = 1;
		sashOnTrack = new int[noOfLeafs];
		sashOnTrack[0] = 1;
		sashGlazedOut = new boolean[noOfLeafs];
		sashGlazedOut[0] = mySelected.isGlazedout();
		opens = 2;
		paneType = new int[1];
		paneType[0] = 6;
		whichPos = 2; // 1=In 3= out 2 = mid.
	}

	private void ss2LS() {

		split = 50;
		noOfLeafs = 2;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashGlazedOut = new boolean[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		paneType = new int[noOfLeafs];
		doDialog = false;

		if (openingClass == 11 || openingClass == 211) {
			sashGlazedOut[0] = myParent.mySeries.isGlazedout();
			sashGlazedOut[1] = mySelected.isGlazedout();
			sashOnTrack[0] = 2;
			sashOnTrack[1] = 1;
			paneType[0] = 1;
			paneType[1] = 7;
			interlockTypes[0] = 3;
		} else if (openingClass == 12 || openingClass == 212) {
			sashGlazedOut[0] = mySelected.isGlazedout();
			;
			sashGlazedOut[1] = myParent.mySeries.isGlazedout();
			sashOnTrack[0] = 1;
			sashOnTrack[1] = 2;
			paneType[0] = 8;
			paneType[1] = 1;
			interlockTypes[0] = 4;
		}
		if (openingClass > 200) {
			doDialog = true;
		}
	}

	private void ds2LS() {

		noOfLeafs = 2;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		split = 50;
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];

		if (openingClass == 21 || openingClass == 221) {
			sashGlazedOut[0] = mySelected.isGlazedout();
			sashGlazedOut[1] = mySelected.isGlazedout();
			sashOnTrack[0] = 2;
			sashOnTrack[1] = 1;
			paneType[0] = 8;
			paneType[1] = 7;
			interlockTypes[0] = 5;
		} else if (openingClass == 22 || openingClass == 222) {
			sashGlazedOut[0] = mySelected.isGlazedout();
			sashGlazedOut[1] = mySelected.isGlazedout();
			sashOnTrack[0] = 1;
			sashOnTrack[1] = 2;
			paneType[0] = 8;
			paneType[1] = 7;
			interlockTypes[0] = 5;
		}
	}

	private void ss4LS() {

		noOfLeafs = 4;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashOnTrack[0] = 2; // lowest track inside always
		sashOnTrack[1] = 1;
		sashOnTrack[2] = 1;
		sashOnTrack[3] = 2;
		split = 25;
		sashGlazedOut[0] = myParent.mySeries.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		sashGlazedOut[3] = myParent.mySeries.isGlazedout();
		paneType[0] = 1;
		paneType[1] = 7;
		paneType[2] = 8;
		paneType[3] = 1;
		interlockTypes[0] = 3;
		interlockTypes[1] = 6;
		interlockTypes[2] = 4;
	}

	private void ss3LS() {

		noOfLeafs = 3;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		sashOnTrack[0] = 1; // lowest track inside always
		sashOnTrack[1] = 2;
		sashOnTrack[2] = 1;
		opens = 3;
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = myParent.mySeries.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		paneType[0] = 8;
		paneType[1] = 1;
		paneType[2] = 7;
		interlockTypes[0] = 4;
		interlockTypes[1] = 3;
		split = 25;
	}

	private void ds3LS() {
		noOfLeafs = 3;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		sashOnTrack[0] = 1; // lowest track inside always
		sashOnTrack[1] = 2;
		sashOnTrack[2] = 1;
		opens = 3;
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		paneType[0] = 8;
		paneType[1] = 10;
		paneType[2] = 7;
		interlockTypes[0] = 5;
		interlockTypes[1] = 5;
		split = 25;
	}

	private void dsCenterSlide() {
		noOfLeafs = 3;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashOnTrack[0] = 2; // lowest track inside always
		sashOnTrack[1] = 1; // lowest track inside always
		sashOnTrack[2] = 2;
		split = 33.3f;
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		paneType[0] = 10;

		paneType[2] = 10;
		if (openingClass == 25 || openingClass == 225) {
			paneType[1] = 7;
		}
		if (openingClass == 26 || openingClass == 226) {
			paneType[1] = 8;
		}
		if (openingClass == 27 || openingClass == 227) {
			paneType[1] = 9;
		}
		interlockTypes[0] = 5;
		interlockTypes[1] = 5;
	}

	private void ds4LS() {

		noOfLeafs = 4;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashOnTrack[0] = 2; // lowest track inside always
		sashOnTrack[1] = 1;
		sashOnTrack[2] = 1;
		sashOnTrack[3] = 2;
		split = 25;
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		sashGlazedOut[3] = mySelected.isGlazedout();
		paneType[0] = 10;
		paneType[1] = 7;
		paneType[2] = 8;
		paneType[3] = 10;
		interlockTypes[0] = 5;
		interlockTypes[1] = 6;
		interlockTypes[2] = 5;
	}

	private void folding() {

		doDialog = true;
		isOriel = false;
		
		
		noOfLeafs = 4;
		notracks = 1;
		
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		
		paneType = new int[noOfLeafs];
		
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashOnTrack[0] = 1; // lowest track inside always
		sashOnTrack[1] = 1;
		sashOnTrack[2] = 1;
		sashOnTrack[3] = 1;
		
		split = 25;
		
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		sashGlazedOut[3] = mySelected.isGlazedout();
		
		paneType[0] = 2;
		paneType[1] = 2;
		paneType[2] = 3;
		paneType[3] = 3;
		
		interlockTypes[0] = 5;
		interlockTypes[1] = 6;
		interlockTypes[2] = 5;
	}

	private void pocket() {

		doDialog = true;
		isOriel = false;
		noOfLeafs = 4;
		notracks = 2;
		sashOnTrack = new int[noOfLeafs];
		interlockTypes = new int[noOfLeafs - 1];
		sashGlazedOut = new boolean[noOfLeafs];
		paneType = new int[noOfLeafs];
		whichPos = 2;// 1=In 3= out 2 = mid.
		opens = 3;
		sashOnTrack[0] = 2;
		sashOnTrack[1] = 1;
		sashOnTrack[2] = 1;
		sashOnTrack[3] = 2;
		extendExtra = 3;
		split = 25;
		sashGlazedOut[0] = mySelected.isGlazedout();
		sashGlazedOut[1] = mySelected.isGlazedout();
		sashGlazedOut[2] = mySelected.isGlazedout();
		sashGlazedOut[3] = mySelected.isGlazedout();
		paneType[0] = 10;
		paneType[1] = 7;
		paneType[2] = 8;
		paneType[3] = 10;
		interlockTypes[0] = 5;
		interlockTypes[1] = 6;
		interlockTypes[2] = 5;
	}
}
