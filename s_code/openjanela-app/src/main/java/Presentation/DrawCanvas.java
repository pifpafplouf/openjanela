/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: Sherif El Dibani
 */

package Presentation;

import Model.*;
import Model.Frame;
import Model.ProfileParts.Profiles;
import Model.TextObjects.CouplerText;
import Model.TextObjects.FacetBotText;
import Model.TextObjects.TextFieldLeft;
import Model.TextObjects.TextFieldTop;
import Operations.*;

import com.objectplanet.image.PngEncoder;

import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.design.OpeningTypes;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import openjanela.model.entities.partner.ValidCouplerMullions;
import orderEntryUtility.UOMConvertData;

import org.jdesktop.swingx.JXTextField;
import org.openjanela.data.MenuActionEventDraw;

import util.ErrorMessage;
import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

/**
 * This class represents the canvas draw for design
 */
public class DrawCanvas extends JPanel {

	// *********************************************************
	// Execution variablesr
	// *********************************************************

	/**
	 * This property indicate if dimension lines and values should be draw for
	 * actual design into canvas.
	 */
	private boolean isDrawDimensionLines = true;

	public boolean warningIssued = false;

	// Graphics 2D Object DrawCanvas
	public Graphics2D g2;

	public int col = 0;

	public int row = 0;

	public ShapeObject myShape;

	public ItemFrame myParent;

	public double deduct = 0;

	public double scaleSize = 0;

	public double endX = 0;

	public double endY = 0;

	public int dimensionType = 0;

	public boolean changeDimDone = false;

	public boolean drawTextTop = true;

	public boolean drawTextBot = true;

	public boolean drawTextLeft = true;

	public boolean drawTextRight = true;

	boolean texttopdrawn = false;

	Object[] gpText;

	Object[] gpTextCoupler;

	Object[] gpTextXs;

	Object[] gpTextXe;

	Object[] gpTextFacetCol;

	Object[] gpTextFacetRow;

	Object[] gpTextXsFacet;

	Object[] gpTextXeFacet;

	Object[] gpTextbot;

	Object[] gpTextXsbot;

	Object[] gpTextXebot;

	Object[] gpTextrow;

	Object[] gpTextXsrow;

	Object[] gpTextXerow;

	Object[] gpTextright;

	Object[] gpTextXsright;

	Object[] gpTextXeright;

	public int selectedCol = 0;

	public int selectedfBot = 1;

	public int selectedColBot = 0;

	public int selectedRowLeft = 0;

	public int selectedRowRight = 0;

	public int selectedFrameNo = 1;

	public int selectedOpeningNo = 1;

	public int selectedfBotO = 1;

	public int selectedFrameBot = 0;

	public int selectedFrameLeft = 0;

	public int selectedFrameRight = 0;

	Font font;

	int totalMod = 0;

	int totalModBot = 0;

	int totalModLeft = 0;

	int totalModRight = 0;

	ActionListener myAction;

	ActionListener myActionBot;

	ActionListener myActionRadioCol;

	ActionListener myActionRadioRow;

	MouseListener myMouseListener;

	MouseMotionListener myMouseMotionListener;

	ActionListener myActionRadioColo;

	ActionListener myActionRadioRowo;

	public int selectedRadioForCol = 1;

	public int selectedRadioForFacetLeft = 1;

	public int selectedRadioForRow = 1;

	public int selectedRadioForColo = 1;

	public int selectedRadioForRowo = 1;

	public ShapeObject mySelectedFrame = null;

	public OpeningObject mySelectedOpening = null;

	public Facet mySelectedFacet = null;

	public ShapeObject mySelectedSFrame = null;

	public OpeningObject mySelectedSOpening = null;

	public Facet mySelectedSFacet = null;

	public int selectedShapeID = 0;

	ShapeDimensionDialog shapeDialog;

	// Class for finding Selected frame from Axis x and y
	public GetSelectedFrame getSelectedFrame;

	public int selectedWorH = 0;

	public boolean equalize = false;

	public boolean equalizeH = false;

	double centerSMx = 0;

	double centerSMy = 0;

	double centerSSx = 0;

	double centerSSy = 0;

	double centerEMx = 0;

	double centerEMy = 0;

	double centerESx = 0;

	double centerESy = 0;

	int masterStartRow = 0;

	int masterEndRow = 0;

	int slaveStartRow = 0;

	int slaveEndRow = 0;

	public boolean masterFound = false;

	Collection myVs = new ArrayList();

	int orientation = 0;

	boolean actionPerformed = true;

	public Rectangle currentRect = null;

	boolean mouseDrag = false;

	public JLabel myGlassLabel = new JLabel();

	public JLabel myPaneLabel = new JLabel();

	public String myNewFW = "";

	Collection potentialVs = new ArrayList();

	Collection potentialHs = new ArrayList();

	String[] myHStd;

	String[] myWStd;

	// **********************************************************************
	// Construction Map for Levels & Sequences
	// **********************************************************************

	// Construction map for draw
	private ConstructionMap constructionMap = null;

	// Indicate if draw an image frame
	public boolean drawImage = true;

	// Indicate if shape object found for assembly
	public boolean drawAssembly = false;

	/**
	 * Draw Canvas Constructor
	 */
	public DrawCanvas(ItemFrame myParent) {

		this.myParent = myParent;

		this.dimensionType = myParent.selectedDim;
		this.mySelectedFrame = myParent.mySelectedFrame;

		// Setting tool tip maneger
		ToolTipManager.sharedInstance().registerComponent(this);
		this.setToolTip("");

		// Setting Rows & Columns
		this.selectedRadioForCol = 0;
		this.selectedRadioForRow = 0;
		this.selectedRadioForColo = 0;
		this.selectedRadioForRowo = 0;

		// Setting Layout Design
		this.setLayout(new XYLayout());

		// Config Mouse Adapter listener
		myMouseAdapter mouseAdapter = new myMouseAdapter();
		this.addMouseListener(mouseAdapter);
		this.addMouseMotionListener(mouseAdapter);

		// Keeps Draw Panel Light color background
		this.setOpaque(false);

		// Setting dimension type and frame selected
		this.dimensionType = myParent.selectedDim;
		this.mySelectedFrame = myParent.mySelectedFrame;
	}

	/**
	 * Constructor for DrawCanvas
	 * 
	 * @param itemFrame
	 *            , ItemFrame
	 * @param radiorow
	 *            , Radio for row
	 * @param radiocol
	 *            , Radio for col
	 * @param radiorowo
	 *            , Radio for row o
	 * @param radiocolo
	 *            , Radio for col o
	 */
	public DrawCanvas(ItemFrame itemFrame, int radiorow, int radiocol,
			int radiorowo, int radiocolo) {

		// Setting tool tip maneger
		ToolTipManager.sharedInstance().registerComponent(this);
		this.setToolTip("");
		myParent = itemFrame;
		selectedRadioForCol = radiocol;
		selectedRadioForRow = radiorow;
		selectedRadioForColo = radiocolo;
		selectedRadioForRowo = radiorowo;

		// Setting layout design
		// this.setLayout(new XYLayout());
		this.setLayout(new XYLayout());

		// this.add(centerPanel, BorderLayout.CENTER);

		// centerPanel.add(topRadios, BorderLayout.NORTH);
		// centerPanel.add(leftRadios, BorderLayout.WEST);

		// Config Mouse Adapter listener
		myMouseAdapter mouseAdapter = new myMouseAdapter();
		this.addMouseListener(mouseAdapter);
		this.addMouseMotionListener(mouseAdapter);

		// Keeps Draw Panel Light color background
		// Need to set JDialog.setDefaultLookAndFeelDecorated(true) in Main
		// class
		this.setOpaque(false);

		// Setting dimension type and frame selected
		dimensionType = myParent.selectedDim;
		mySelectedFrame = myParent.mySelectedFrame;

		myParent.jobItem.hasSub();

		System.gc();

	}

	public void setToolTip(final String text) {

	}

	/**
	 * Get selected frame and opening
	 * 
	 * @param xxx
	 *            , Axis x position
	 * @param yyy
	 *            , Axis y position
	 * @param isAddMC
	 *            , Adding mullions coupler
	 */
	public void getSelectedFrameAndOpeningClick(int xxx, int yyy,
			boolean isAddMC) {

		// Get array of facets

		// Initialize collection of frames

		Collection allFrames = new ArrayList();

		Object[] facets = myParent.jobItem.design.frames.toArray();
		for (Object f : facets) {
			allFrames.addAll(((Facet) f).frames);
		}

		if (facets.length > 1) {
			myParent.mainFacetCheckBot[mySelectedFacet.startCol - 1].doClick();
		} else {
			selectedfBot = 1;
		}

		// Setting facet selected
		myParent.facetUsed = mySelectedFacet;

		// Initialize selected frame class
		this.getSelectedFrame = new GetSelectedFrame(xxx, yyy, allFrames);

		// Get selected frame find
		this.myParent.mySelectedFrame = this.mySelectedFrame = this.getSelectedFrame
				.getSelectedFrame();

		if (mySelectedFrame != null) {

			// Get array of frames from parent facet of my frame find
			Object[] frames = mySelectedFrame.myFacet.frames.toArray();

			// Clear list of frames from my facet
			this.mySelectedFrame.myFacet.frames.clear();

			for (Object frame : frames) {

				if (frame.equals(mySelectedFrame)) {
					((Frame) frame).isNewFrame = false;
				}

				// Adding frame to frames of parent facet
				mySelectedFrame.myFacet.frames.add(frame);
			}

			// Setting selected facet in used
			myParent.facetUsed = mySelectedFrame.myFacet;

			// Get openings from selected frame
			Object[] openingObjects = mySelectedFrame.openings.toArray();

			// Initialize GetSelectedFrame
			this.getSelectedFrame = null;

			// Initialize a point with Axis x and y
			Point p = new Point(xxx, yyy);

			for (Object O : openingObjects) {

				/**
				 * 1. GeneralPath opening object contains a point with x and y
				 * axis position Or 2. Axis x position is less or equals bx2
				 * opening && 3. Axis x position is less or equals bx3 opening
				 * && 4. Axis x position is greater or equals bx4 opening && 5.
				 * Axis y position is greater or equals by4 - heightPix opening
				 * && 6. Axis y position is less or equals by3 && 7. Axis y
				 * position is less or equals by4
				 */

				if (((OpeningObject) O).gp.contains(p)
						|| xxx <= ((OpeningObject) O).bX2
						&& xxx <= ((OpeningObject) O).bX3
						&& xxx >= ((OpeningObject) O).bX4
						&& yyy >= ((OpeningObject) O).bY4
								- ((OpeningObject) O).heightPix
						&& yyy <= ((OpeningObject) O).bY3
						&& yyy <= ((OpeningObject) O).bY4) {

					// Selected opening
					this.mySelectedOpening = (OpeningObject) O;

					// if (mySelectedOpening.myGlassMid != null)
					// myParent.mySelectedSUMid =
					// ItemFrame.getApplicationBase().getSUType(mySelectedOpening.myGlassMid.suID);
					// if (mySelectedOpening.myGlassIn != null)
					// myParent.mySelectedSUIn =
					// ItemFrame.getApplicationBase().getSUType(mySelectedOpening.myGlassIn.suID);
					// if (mySelectedOpening.myGlassOut != null)
					// myParent.mySelectedSUOut =
					// ItemFrame.getApplicationBase().getSUType(mySelectedOpening.myGlassOut.suID);

					// If selected opening has a subframe and is adding mullion
					// or coupler
					// ContentMid == 3 Opening contain a subframe
					if (this.mySelectedOpening.contentMid == 3 && isAddMC) {

						// Get subfacet from opening
						this.myParent.facetUsed = mySelectedOpening.subFacet;

						// Loogking for subframe object
						lookForSubFrameOpening(xxx, yyy, isAddMC, p);

						// If selected opening has a sashType and is
						// adding mullion or coupler ContentMid == 2 Opening
						// contain a SashType
					} else if (mySelectedOpening.contentMid >= 2 && isAddMC) {

						Object[] l = mySelectedOpening.sashObjectMid.frames
								.toArray();

						for (Object o : l) {

							if (xxx <= ((SashLeaf) o).bX2
									&& xxx <= ((SashLeaf) o).bX3
									&& xxx >= ((SashLeaf) o).bX4
									&& yyy >= ((SashLeaf) o).bY4
											- ((SashLeaf) o).heightPix
									&& yyy <= ((SashLeaf) o).bY3
									&& yyy <= ((SashLeaf) o).bY4) {

								// Content mid no content defined
								if (((SashLeaf) o).myParentO.contentMid == 1) {

									// Show error message dialog
									JOptionPane
											.showMessageDialog(
													this.myParent,
													"Division of Fixed Lite  is unavailable:\nTo request this feature please contact your supplier!",
													"Error",
													JOptionPane.ERROR_MESSAGE);

									// Setting selected opening null
									mySelectedOpening = null;

									break;
								}
							}
						}
						myParent.subFClicked = false;
					} else {
						myParent.subFClicked = false;
					}

				}
			}
		}
	}

	public void setSelectedGlass() {

		if (mySelectedOpening.myGlassIn != null
				&& mySelectedOpening.myGlassIn.suID > 0) {
			myParent.currentSUIn = ItemFrame.getApplicationBaseRules()
					.getSUType(mySelectedOpening.myGlassIn.suID);
		} else {
			myParent.currentSUIn = null;
		}
		if (mySelectedOpening.myGlassMid != null
				&& mySelectedOpening.myGlassMid.suID > 0) {
			myParent.currentSUMid = ItemFrame.getApplicationBaseRules()
					.getSUType(mySelectedOpening.myGlassMid.suID);
		} else {
			myParent.currentSUMid = null;
		}
		if (mySelectedOpening.myGlassOut != null
				&& mySelectedOpening.myGlassOut.suID > 0) {
			myParent.currentSUOut = ItemFrame.getApplicationBaseRules()
					.getSUType(mySelectedOpening.myGlassOut.suID);
		} else {
			myParent.currentSUOut = null;
		}
	}

	/**
	 * Obtain facet click selected
	 * 
	 * @param xxx
	 *            , Axis x position in canvas
	 * @param yyy
	 *            , Axis y position in canvas
	 */
	public void getSelectedFacetClick(int xxx, int yyy) {

		// Get array of facets
		Object[] facets = myParent.jobItem.design.frames.toArray();
		// Clear array of facets from ShapeObject design
		myParent.jobItem.design.frames.clear();

		// ************************************************
		// Iterate throw facets for getting object selected
		// TODO: This implementation should be checked for a better
		// performance. May be implements MouseListener.
		// ************************************************
		for (Object f : facets) {

			if (xxx <= ((Facet) f).bX2 && xxx <= ((Facet) f).bX3
					&& xxx >= ((Facet) f).bX4 && yyy >= ((Facet) f).highestY
					&& yyy <= ((Facet) f).lowestY) {

				// Setting facet in use semaphore indicating this is busy
				// for work
				((Facet) f).inUse = true;

				// Get facet selected for work
				mySelectedFacet = (Facet) f;

				if (facets.length > 1) {
					myParent.mainFacetCheckBot[((Facet) f).startCol - 1]
							.setSelected(true);
				}

			} else {
				((Facet) f).inUse = false;
			}

			// Adding facet again to ArrayList
			myParent.jobItem.design.frames.add(f);
		}

		// Setting facet selected from canvas to ItemFrame
		if (mySelectedFacet != null) {
			myParent.facetUsed = mySelectedFacet;
		}

		this.getSelectedFrameAndOpeningClick(xxx, yyy, false);
	}

	public void lookForSubFrameOpening(final int xxx, final int yyy,
			final boolean isAddMC, final Point p) {

		getSelectedFrame = new GetSelectedFrame(xxx, yyy,
				myParent.facetUsed.frames);

		mySelectedFrame = getSelectedFrame.getSelectedFrame();

		final Object[] framesS = myParent.facetUsed.frames.toArray();

		myParent.facetUsed.frames.clear();

		for (final Object sF : framesS) {
			if (((Frame) sF).equals(mySelectedFrame)) {
				((Frame) sF).isNewFrame = false;
			}
			myParent.facetUsed.frames.add(sF);
		}

		final Object[] openingObjects = mySelectedFrame.openings.toArray();

		getSelectedFrame = null;
		for (final Object sO : openingObjects) {
			if (xxx <= Math.max(((OpeningObject) sO).bX2,
					((OpeningObject) sO).bX3)
					&& xxx >= Math.min(((OpeningObject) sO).bX4,
							((OpeningObject) sO).startingX)
					&& yyy >= ((OpeningObject) sO).highestY
					&& yyy <= ((OpeningObject) sO).lowestY) {

				mySelectedOpening = (OpeningObject) sO;

				if (mySelectedOpening.contentMid == 2 && isAddMC) {
					final Object[] l = mySelectedOpening.sashObjectMid.frames
							.toArray();
					for (final Object so : l) {
						if (xxx <= Math.max(((SashLeaf) so).bX2,
								((SashLeaf) so).bX3)
								&& xxx >= Math.min(((SashLeaf) so).bX4,
										((SashLeaf) so).startingX)
								&& yyy >= ((SashLeaf) so).highestY
								&& yyy <= ((SashLeaf) so).lowestY) {
							if (((SashLeaf) so).myParentO.contentMid == 1) {
								JOptionPane
										.showMessageDialog(
												this.myParent,
												"Division of Fixed Lite  is unavailable:\nTo request this feature please contact your supplier!",
												"Error",
												JOptionPane.ERROR_MESSAGE);
								mySelectedOpening = null;
								break;
							} else {
								final Object[] ops = ((SashLeaf) so).openings
										.toArray();

								for (final Object op : ops) {

									if (xxx <= Math.max(
											((OpeningObject) op).bX2,
											((OpeningObject) op).bX3)
											&& xxx >= Math
													.min(((OpeningObject) op).bX4,
															((OpeningObject) op).startingX)
											&& yyy >= ((OpeningObject) op).highestY
											&& yyy <= ((OpeningObject) op).lowestY) {

										mySelectedOpening = (OpeningObject) op;
									}
								}
							}

						}
					}

					myParent.subFClicked = false;
				} else {

					myParent.subFClicked = false;
				}
				if (mySelectedOpening != null && myParent.sashPanel.subOp == 3
						&& mySelectedOpening.contentMid == 3) {
					mySelectedOpening.contentMid = 1;
					myParent.subFClicked = false;
					myParent.sashPanel.subOp = 0;
					mySelectedOpening.subFacet = null;

					myParent.facetUsed = myParent.facetUsed;
					myParent.sashPanel.noOfLeafs = 0;
					myParent.sashPanel.whichPos = 2;
					myParent.sashPanel.opens = 0;
					myParent.sashPanel.glazedOut = true;
					myParent.sashPanel.paneType = new int[1];
					myParent.sashPanel.paneType[0] = 1;// Picture

				} else if (mySelectedOpening != null
						&& myParent.sashPanel.subOp == 3
						&& mySelectedOpening.contentMid != 3) {
					JOptionPane.showMessageDialog(this.myParent,
							"No SubFrame in selected Opening!\n",
							"Invalid Opening Selected - Error!",
							JOptionPane.ERROR_MESSAGE);
				}

				if (mySelectedOpening != null
						&& mySelectedOpening.contentMid == 3) {

					final Object[] sFs = mySelectedOpening.subFacet.frames
							.toArray();
					for (final Object sf : sFs) {
						if (Math.min(((Frame) sf).startingX, ((Frame) sf).bX4) <= xxx
								&& Math.max(((Frame) sf).bX2, ((Frame) sf).bX3) >= xxx
								&& ((Frame) sf).highestY <= yyy
								&& Math.max(((Frame) sf).bY4, ((Frame) sf).bY3) >= yyy) {

							mySelectedFrame = (Frame) sf;
							final Object[] openingObjects2 = mySelectedFrame.openings
									.toArray();
							for (final Object ssO : openingObjects2) {
								if (((OpeningObject) ssO).gp.contains(p)
										|| xxx <= ((OpeningObject) ssO).bX2
										&& xxx <= ((OpeningObject) ssO).bX3
										&& xxx >= ((OpeningObject) ssO).bX4
										&& yyy >= ((OpeningObject) ssO).bY4
												- ((OpeningObject) ssO).heightPix

										&& yyy <= ((OpeningObject) ssO).bY3
										&& yyy <= ((OpeningObject) ssO).bY4) {

									if (((OpeningObject) ssO).contentMid == 2) {
										final Object[] leafs = ((OpeningObject) ssO).sashObjectMid.frames
												.toArray();
										for (final Object pp : leafs) {

											if (((SashLeaf) pp).gp.contains(p)
													|| xxx <= ((SashLeaf) pp).bX2
													&& xxx <= ((SashLeaf) pp).bX3
													&& xxx >= ((SashLeaf) pp).bX4
													&& yyy >= ((SashLeaf) pp).bY4
															- ((SashLeaf) pp).heightPix

													&& yyy <= ((SashLeaf) pp).bY3
													&& yyy <= ((SashLeaf) pp).bY4) {

												final Object[] ops = ((SashLeaf) pp).openings
														.toArray();

												for (final Object op : ops) {

													if (((OpeningObject) ssO).gp
															.contains(p)
															|| xxx <= ((OpeningObject) op).bX2
															&& xxx <= ((OpeningObject) op).bX3
															&& xxx >= ((OpeningObject) op).bX4
															&& yyy >= ((OpeningObject) op).bY4
																	- ((OpeningObject) op).heightPix

															&& yyy <= ((OpeningObject) op).bY3
															&& yyy <= ((OpeningObject) op).bY4) {

														mySelectedOpening = (OpeningObject) op;
													}
												}
											}
										}

									} else if (((OpeningObject) ssO).contentMid == 1) {
										mySelectedOpening = (OpeningObject) ssO;
									}

								}
							}
						}
					}
				}
			}// If x,y Inside Bounds
		}// for openings
	}

	/**
	 * Set parameters default
	 * 
	 * @param parent
	 *            , ItemFrame
	 * @param radiorow
	 *            , int
	 * @param radiocol
	 *            , int
	 * @param radiorowo
	 *            , int
	 * @param radiocolo
	 *            , int
	 */
	public void setParameters(ItemFrame parent, int radiorow, int radiocol,
			int radiorowo, int radiocolo) {

		myParent = parent;
		selectedRadioForCol = radiocol;
		selectedRadioForRow = radiorow;
		selectedRadioForColo = radiocolo;
		selectedRadioForRowo = radiorowo;
	}

	/**
	 * Method for drawing launch drawing overall or parts windows
	 * 
	 * @param event
	 *            , MouseEvent
	 */
	public void drawing_MouseClicked(MouseEvent event) {

		try {

			if (event.getButton() != 3
					&& event.getX() > myParent.jobItem.startingX
					&& event.getX() < endX
					&& event.getY() > myParent.jobItem.startingY
					&& event.getY() < endY) {

				myParent.lastSelectedDim = dimensionType;

				if (myParent.getActionTypeEvent() == MenuActionEventDraw.GRIDS_EVENT
						.getValue()
						&& myParent.gridOp != 9
						&& myParent.gridOp != 10
						|| myParent.getActionTypeEvent() != MenuActionEventDraw.GRIDS_EVENT
								.getValue()) {
					// Draw canvas for event with axis x and y position
					canvasMouseClickedAction(event.getX(), event.getY(), event);
				}
			}

			if (event.getButton() == 3) {
				resetActionToNothing();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetActionToNothing() {
		myParent.setButtonsFalse();

		this.myParent.stopCustomCursor(this.myParent.main);

		MenuActionEventDraw.NOT_SELECTION.resetValue();

		this.myParent.setActionTypeEvent(0);
	}

	/**
	 * Updating Size, Need to do only if cut grid button is selected
	 * 
	 * @param e
	 *            , MouseEvent
	 */
	public void updateSize(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		currentRect.setSize(x - currentRect.x, y - currentRect.y);

		if (myParent.gridOp == 9 || myParent.gridOp == 10) {
			this.revalidate();
			this.repaint();
		}
	}

	public void setSelectedDims(int dim) {

		dimensionType = dim;
		myParent.selectedDim = dim;

		this.redrawTextForColRow(true);
	}

	/**
	 * Mouse click event canvas drawing
	 * 
	 * @param xxx
	 *            , Axis x position click
	 * @param yyy
	 *            , Axis y position click
	 * @param event
	 *            , MouseEvent
	 */
	public void canvasMouseClickedAction(int xxx, int yyy, MouseEvent event) {

		// Adding design to undo array
		this.myParent.addToUndo();

		// this.myParent.jobItem.glassBOM.clear();
		this.myParent.jobItem.bom.clear();

		// Adding actual ShapeObject model to memory undo changes.
		this.myParent.wEntered = myParent.hEntered = false;

		// Setting dimension options
		this.myParent.jobItem.setDimensionOptions();

		// Setting selected facet click
		this.getSelectedFacetClick(xxx, yyy);

		// Setting selected frame and opening
		this.getSelectedFrameAndOpeningClick(xxx, yyy, true);

		this.myParent.jobItem.resetGraphics();

		// Indicating position
		int whichPos = 2;

		this.myParent.startWaitCursor(this.myParent.main);

		if (myParent.dim.isSash.isSelected() && myParent.mySelectedSash == null) {
			this.findSelectedSash(xxx, yyy);
			myParent.dim.sashTip.setVisible(false);

			this.myParent.facetUsed = myParent.mySelectedSash;
		}

		if (xxx > myParent.jobItem.startingX && xxx < endX
				& yyy > myParent.jobItem.startingY && yyy < endY) {

			// ************************************************
			// Adding a new Coupler Or Mullion option selected
			// 1. MullionsTask panel is selected
			// 2. Extends coupler & mullions is not active
			// 3. Align vertical option is not active
			// 4. Align horizontal option is not active
			// 5. Edit coupler & mullions option is not active
			// ************************************************

			if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.COUPLER_MULLION_EVENT
					.getValue()) {

				// Doing feature after clicking
				doFeatureClick(xxx, yyy, whichPos);
				myParent.setActionTypeEvent(MenuActionEventDraw.COUPLER_MULLION_EVENT
						.getValue());
			}

			// ************************************************
			// Morfo shape selection
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.SHAPE_EVENT
					.getValue()) {

				// Doing shape feature clicking
				doShapeClick(xxx, yyy);
				myParent.setActionTypeEvent(MenuActionEventDraw.SHAPE_EVENT
						.getValue());

			}

			// ************************************************
			// Adding any type of entrance, window, door etc
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.SASH_EVENT
					.getValue()) {

				if (mySelectedOpening != null) {
					myParent.resetModTextsV = true;
					myParent.resetModTextsH = true;
					this.doOpeningClick(xxx, yyy);
				} else {
					JOptionPane
							.showMessageDialog(this.myParent,
									"Invalid Area Selection:"
											+ "\n Please reselect Area!",
									"Invalid Area Selection",
									JOptionPane.ERROR_MESSAGE);
				}

				myParent.setActionTypeEvent(MenuActionEventDraw.SASH_EVENT
						.getValue());
			}

			// ************************************************
			// Adding glass SU Type to configuration Glass
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.GLASS_SEALED_UNIT_EVENT
					.getValue()
					&& this.myParent.glassPanel.oneGlass.isSelected()) {

				if (mySelectedOpening != null) {
					// Evaluating Glass In
					try {
						myParent.jobItem.design.searchOpeningAndSetSUType(
								mySelectedOpening, xxx, yyy);
					} catch (Exception e) {
						e.printStackTrace();
						e.printStackTrace();
					}
				}

				myParent.setActionTypeEvent(MenuActionEventDraw.GLASS_SEALED_UNIT_EVENT
						.getValue());
			}

			// ************************************************
			// Adding or editing grid options
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.GRIDS_EVENT
					.getValue() && this.myParent.hasGrids) {
				doChangeGrids(xxx, yyy);
				myParent.setActionTypeEvent(MenuActionEventDraw.GRIDS_EVENT
						.getValue());
			}

			// ************************************************
			// Align vertical option selected
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.ALIGN_VERTICAL
					.getValue()) {
				myParent.resetModTextsV = true;
				this.alignVAction(xxx, yyy, whichPos);
				myParent.setActionTypeEvent(MenuActionEventDraw.ALIGN_VERTICAL
						.getValue());
				myParent.myCursor = Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
			}

			// ************************************************
			// Align horizontal option selected
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.ALIGN_HORIZONTAL
					.getValue()) {
				if (dimensionType > 4) {
					if (myParent.frameDim) {
						myParent.dim.center.doClick();
					} else {
						myParent.dim.frame.doClick();
					}
				}

				myParent.resetModTextsH = true;
				this.alignHAction(xxx, yyy, whichPos);
				myParent.setActionTypeEvent(MenuActionEventDraw.ALIGN_HORIZONTAL
						.getValue());
				myParent.myCursor = Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

			}

			// ************************************************
			// Edit coupler or mullion selected
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.EDIT_COUPLER_MULLION
					.getValue()) {
				if (dimensionType > 4) {
					myParent.dim.center.doClick();
				}

				if (myParent.mullionsPanel.selectedLevel == 1) {
					// JOptionPane.showMessageDialog(null,
					// "Coupler Editing is not available.",
					// "Invalid Vertical Selected - Warning!",
					// JOptionPane.WARNING_MESSAGE);
				} else if (myParent.mullionsPanel.selectedLevel == 2) {
					myParent.mullionsPanel.resetEdit();
					this.findEditingMullion(xxx, yyy);
					myParent.mullionsPanel.setEditVisible(true,
							myParent.editingMullion);
				} else if (myParent.mullionsPanel.selectedLevel == 3) {
				}

				myParent.setActionTypeEvent(MenuActionEventDraw.EDIT_COUPLER_MULLION
						.getValue());
				myParent.myCursor = Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				// this.resetActionToNothing();
			}

			// ************************************************
			// Extends coupler or mullions selected
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.EXTEND_COUPLER_MULLION
					.getValue()) {

				if (dimensionType > 4) {

					if (myParent.frameDim) {
						myParent.dim.center.doClick();
					} else {
						myParent.dim.frame.doClick();
					}
				}

				this.extendAction(xxx, yyy, whichPos);
				myParent.setActionTypeEvent(MenuActionEventDraw.EXTEND_COUPLER_MULLION
						.getValue());
				myParent.myCursor = Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				// this.resetActionToNothing();
			} else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.EDIT_FRAME
					.getValue()) {

				if (dimensionType > 4) {
					if (myParent.frameDim) {
						myParent.dim.center.doClick();
					} else {
						myParent.dim.frame.doClick();
					}
				}

				this.editFrameAction(xxx, yyy);
				myParent.setActionTypeEvent(MenuActionEventDraw.EDIT_FRAME
						.getValue());
				myParent.myCursor = Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				// this.resetActionToNothing();
			}

			// ************************************************
			// Remove frame action event
			// ************************************************
			else if (this.myParent.getActionTypeEvent() == MenuActionEventDraw.REMOVE_FRAME
					.getValue()) {

				this.removeFrameAction(xxx, yyy);

				myParent.resetActive();
				myParent.setActionTypeEvent(MenuActionEventDraw.REMOVE_FRAME
						.getValue());
				myParent.myCursor = Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				// this.resetActionToNothing();
			}

			if (actionPerformed) {
				myParent.dimAction();

				myParent.resetModTextsV = false;
				myParent.resetModTextsH = false;
			}

			this.myParent.stopWaitCursor(this.myParent.main);

		} else {

			if (xxx < myParent.jobItem.startingX && actionPerformed) { // Left
				this.getSelectedRowLeft(xxx, yyy);
			} else if (yyy < myParent.jobItem.startingY && actionPerformed) {
				this.getSelectedRowLeft(xxx, yyy);
			}
		}

		if (myParent.cView != null) {
			myParent.cView.initPriceCategories();
		}

		// Reset options panel values
		this.myParent.options.initValues();

		// Reset Bill of Material Calculation for Rules
		this.myParent.calcBom = true;

		this.myParent.options.buildOptionsTables();

		this.myParent.jobItem.hasSub();

		this.myParent.jobItem.resetGraphics();
	}

	private void doChangeGrids(final int xxx, final int yyy) {

		myParent.gridsPanel.l2.setVisible(false);

		if (myParent.gridOp >= 1 && myParent.gridOp <= 4
				|| myParent.gridOp == 8) {

			myParent.setChangeGridMaster(xxx, yyy, myParent.gridOp,
					myParent.gridsPanel.whichPos, myParent.gridsPanel.form,
					currentRect);

		} else if (myParent.gridOp == 9 || myParent.gridOp == 10
				&& (currentRect.width == 0 || currentRect.height == 0)) {

			myParent.setChangeGridMaster(xxx, yyy, myParent.gridOp,
					myParent.gridsPanel.whichPos, myParent.gridsPanel.form,
					currentRect);

		} else if (myParent.gridOp == 7) {
			myParent.resetModTextsV = true;
			myParent.resetModTextsH = true;
			myParent.getSelectedDLO(xxx, yyy, myParent.gridOp,
					myParent.gridsPanel.whichPos, myParent.gridsPanel.form);

		}

		this.myParent.stopWaitCursor(this.myParent.main);
	}

	/**
	 * Change basic shape object to any form design
	 * 
	 * @param xxx
	 *            , Axis x position
	 * @param yyy
	 *            , Axis y position
	 */
	public void doShapeClick(int xxx, int yyy) {

		// ********************************************
		// Validation error messages
		// ********************************************
		String openingNotFound = "Opening not Found!";
		String invalidShapeforFrameSelected = "Invalid shape for selected Frame - Shape Error!";
		String noShapeSelected = " No Shape Selected - Please Select a Shape!";
		boolean proceed = true;
		boolean goodToGo = true;
		this.myParent.shapeChangeFrame = new Frame();
		// Not selected any shape form to process
		if (myParent.shapesPanel.selectedShape == 0) {

			// Show error message
			JOptionPane.showMessageDialog(this.myParent, noShapeSelected, "",
					JOptionPane.ERROR_MESSAGE);

		} else {

			// Get selected facet
			getSelectedFacetClick(xxx, yyy);

			// Setting edit frame to false
			myParent.editor.editFrame = false;
			// Setting width entered to true
			myParent.wEntered = true;
			// Setting align vertical false
			myParent.alignV = false;
			// Setting align horizontal false
			myParent.alignH = false;
			// Setting edit coupler or mullion false
			myParent.editCM = false;

			ShapeObject selectedOpening = this.mySelectedOpening;

			NumSidesShapes noSides = new NumSidesShapes(
					myParent.shapesPanel.selectedShape);

			if (myParent.shapesPanel.selectedShape == 10
					&& myParent.shapesPanel.selectedShapeLevel == 1) {

				myParent.shapesPanel.selectedShapeLevel = 2;
				myParent.shapesPanel.frameB.setSelected(true);
				myParent.shapesPanel.overallB.setSelected(false);
				myParent.dim.frame.doClick();
				proceed = true;

				JOptionPane.showMessageDialog(this.myParent,
						"Selected Level for Shape Change\n"
								+ "will be set to Frame!",
						"Invalid Opening Selected - Error!",
						JOptionPane.WARNING_MESSAGE);
			}

			if (myParent.facetUsed.shapeID != 1
					&& myParent.shapesPanel.selectedShapeLevel == 2
					&& myParent.facetUsed.bOpeningObject.mullionsH.size() == 0) {

				myParent.shapesPanel.selectedShapeLevel = 1;
				myParent.shapesPanel.overallB.setSelected(true);
				myParent.shapesPanel.frameB.setSelected(false);
				myParent.dim.center.setSelected(true);
				proceed = true;

				JOptionPane.showMessageDialog(this.myParent,
						"Selected Level for Shape Change\n"
								+ "will be set to Overall!",
						"Invalid Opening Selected - Error!",
						JOptionPane.WARNING_MESSAGE);
			}

			if (myParent.shapesPanel.selectedShapeLevel == 1
					&& myParent.facetUsed.bOpeningObject.mullionsH.size() > 0) {
				myParent.shapesPanel.selectedShapeLevel = 2;
				myParent.shapesPanel.frameB.setSelected(true);
				myParent.shapesPanel.validate();myParent.shapesPanel.repaint();
				JOptionPane.showMessageDialog(this.myParent,
						"Selected Level for Shape Change\n"
								+ "will be set to Frame!",
						"Invalid Opening Selected - Error!",
						JOptionPane.WARNING_MESSAGE);

			} 
//			else if (myParent.shapesPanel.selectedShape > 1 //= 150
////					&& myParent.shapesPanel.selectedShape <= 168
//					) {
//				if (myParent.shapesPanel.selectedShapeLevel == 1
//						&& (myParent.facetUsed.bOpeningObject.mullions.size() > 0
//						|| myParent.facetUsed.bOpeningObject.mullionsH.size() > 0)) {
//					myParent.shapesPanel.selectedShapeLevel = 2;
//					myParent.shapesPanel.frameB.setSelected(true);
//					myParent.shapesPanel.overallB.setSelected(false);
////					JOptionPane.showMessageDialog(this.myParent,
////							"Selected Level for Shape Change\n"
////									+ "will be set to Frame!",
////							"Invalid Opening Selected - Error!",
////							JOptionPane.WARNING_MESSAGE);
//				}
//			}

			if (proceed) {

				this.dimensionType = myParent.selectedDim;

				if (myParent.shapesPanel.selectedShapeLevel == 2) {

					getSelectedFrame = new GetSelectedFrame(xxx, yyy,
							myParent.facetUsed.frames);
					selectedOpening = this.myParent.shapeChangeFrame = getSelectedFrame.getSelectedFrame();

					if (selectedOpening == null) {
						getSelectedFrame = new GetSelectedFrame(xxx, yyy,
								myParent.facetUsed.openings);
						selectedOpening = getSelectedFrame.getSelectedOpening();
					}

				} else {
					// getSelectedFrameAndOpeningClick(xxx, yyy, true);
				}

				if (myParent.shapesPanel.selectedShapeLevel == 2) {

					if (myParent.shapesPanel.selectedShape == 203
							&& (int) (this.mySelectedFrame.widthPix / 2) != (int) mySelectedFrame.heightPix) {

						selectedFrameNo = this.mySelectedFrame.startRow;

						Object[] rto = myParent.rowTextObjects.toArray();

						myParent.rowTextObjects.clear();
						int i = 0;
						for (Object r : rto) {

							String w = r.toString();

							if (i == selectedFrameNo - 1) {
								BigDecimal d = new BigDecimal(
										(this.mySelectedFrame.widthPix / 2));
								w = d + "";
							}
							i++;

							myParent.rowTextObjects.add(w);
						}

						Object[] textFields = myParent.myTextLeft;

						for (Object textField : textFields) {
							JTextField txt = (JTextField) textField;
							if (this.mySelectedFrame.startRow == Integer
									.parseInt(txt.getName())) {
								txt.setText(this.mySelectedFrame.widthPix / 2
										+ "");
								break;
							}

						}

						this.modFrameRowH(this.mySelectedFrame.widthPix / 2);

						this.validate();
						this.repaint();
					}

					double minL = mySelectedFrame.bot1Part.partDimB;
					if (myParent.currentUOM == 1) {
						minL = mySelectedFrame.bot1Part.partDimB;
					} else {
						minL = mySelectedFrame.bot1Part.partDimBi;
					}
				
					if (myParent.shapesPanel.selectedShape == 200
							&& (int) mySelectedFrame.heightPix < minL * 2
									+ (int) (this.mySelectedFrame.widthPix / 2)) {
						myParent.shapesPanel.selectedShape = 300;
	
					}

					if ((myParent.shapesPanel.selectedShape == 204 || myParent.shapesPanel.selectedShape == 205)
							&& (int) this.mySelectedFrame.widthPix != (int) mySelectedFrame.heightPix) {
						goodToGo = false;
						JOptionPane
								.showMessageDialog(
										this.myParent,
										"W !=  2* H Please select Arc or set correct Dimensions!",
										"", JOptionPane.ERROR_MESSAGE);

					}

					if (myParent.shapesPanel.selectedShape >= 700
							&& myParent.shapesPanel.selectedShape < 800) {
						if (selectedOpening.xCols > 1
								&& selectedOpening.yRows > 1) {
							goodToGo = false;
							JOptionPane
									.showMessageDialog(
											this.myParent,
											"Unable to Change Shape, please remove Horizontal Mullions!",
											"", JOptionPane.ERROR_MESSAGE);
						}
					}

					// New LeanTo
					SetLeanTo setlean = new SetLeanTo(
							myParent.shapesPanel.selectedShape, 0, 0, 0, 0);

					if (selectedOpening.rightIn
							&& !getShapeOnSide(selectedOpening, 4)) {
						if (!selectedOpening.topIn) {
							if (setlean.lean2 == 1 || setlean.lean2 == 3) {
								goodToGo = false;
							}
						} else if (selectedOpening.topIn
								&& !getShapeOnSide(selectedOpening, 1)) {
							if (setlean.lean2 == 2 || setlean.lean2 == 3) {
								goodToGo = false;
							}
						}
					}

					if (selectedOpening.leftIn
							&& !getShapeOnSide(selectedOpening, 3)) {
						if (!selectedOpening.topIn) {
							if (setlean.lean4 == 2 || setlean.lean4 == 3) {
								goodToGo = false;
							}
						} else if (selectedOpening.topIn
								&& !getShapeOnSide(selectedOpening, 1)) {
							if (setlean.lean4 == 1 || setlean.lean2 == 3) {
								goodToGo = false;
							}
						}
					}

					if (selectedOpening.botIn
							&& !getShapeOnSide(selectedOpening, 2)) {
						if (selectedOpening.rightIn
								&& !getShapeOnSide(selectedOpening, 4)) {
							if (setlean.lean3 == 2 || setlean.lean3 == 3) {
								goodToGo = false;
							}
						}
						if (selectedOpening.leftIn
								&& !getShapeOnSide(selectedOpening, 3)) {
							if (setlean.lean3 == 1 || setlean.lean3 == 3) {
								goodToGo = false;
							}
						}
						if (!selectedOpening.leftIn && !selectedOpening.rightIn
								&& !getShapeOnSide(selectedOpening, 4)
								&& !getShapeOnSide(selectedOpening, 3)) {

							if (setlean.lean3 == 3) {
								goodToGo = false;
							}
						}
					}

					if (selectedOpening.topIn
							&& !getShapeOnSide(selectedOpening, 1)) {
						if (selectedOpening.rightIn
								&& !getShapeOnSide(selectedOpening, 4)) {
							if (setlean.lean == 1 || setlean.lean == 3) {
								goodToGo = false;
							}
						}
						if (selectedOpening.leftIn
								&& !getShapeOnSide(selectedOpening, 3)) {
							if (setlean.lean == 2 || setlean.lean == 3) {
								goodToGo = false;
							}
						}
						if (!selectedOpening.leftIn && !selectedOpening.rightIn
								&& !getShapeOnSide(selectedOpening, 4)
								&& !getShapeOnSide(selectedOpening, 3)) {
							if (setlean.lean == 3) {
								goodToGo = false;
							}
						}
					}

					if (this.myParent.shapesPanel.selectedShape == 203
							|| this.myParent.shapesPanel.selectedShape == 303) {

						if (myParent.shapesPanel.selectedShapeLevel == 1) {

							if (myParent.facetUsed.yRows > 1) {
								// goodToGo = false;
								// JOptionPane.showMessageDialog(
								// null,
								// hrhawithDivision,
								// "",
								// JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				} else {

					if (this.myParent.shapesPanel.selectedShape == 203
							&& ((int) (this.mySelectedFrame.widthPix / 2) != (int) mySelectedFrame.heightPix)) {
						goodToGo = false;
						JOptionPane
								.showMessageDialog(
										this.myParent,
										"W != 2* H Please select Arc or set correct Dimensions!",
										"", JOptionPane.ERROR_MESSAGE);

					}

					if ((myParent.shapesPanel.selectedShape == 204 || myParent.shapesPanel.selectedShape == 205)
							&& (int) this.mySelectedFrame.widthPix != (int) mySelectedFrame.heightPix) {
						goodToGo = false;
						JOptionPane
								.showMessageDialog(
										this.myParent,
										"W !=  H Please select Arc or set correct Dimensions!",
										"", JOptionPane.ERROR_MESSAGE);

					}

					if (myParent.shapesPanel.selectedShape >= 700
							&& myParent.shapesPanel.selectedShape < 800) {
						if (myParent.facetUsed.xCols > 1
								&& myParent.facetUsed.yRows > 1) {
							goodToGo = false;
							JOptionPane
									.showMessageDialog(
											this.myParent,
											"Unable to Change Shape, please remove Horizontal Couplers!",
											"", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					Object[] frames = myParent.facetUsed.frames.toArray();
					double thickMax =0;
					for(Object f : frames){
						if (myParent.currentUOM == 1
								&& ((Frame)f).bot1Part.partDimB>thickMax ) {
							thickMax = ((Frame)f).bot1Part.partDimB;
						} else if (myParent.currentUOM > 1
								&& ((Frame)f).bot1Part.partDimB>thickMax ) {
							thickMax =  ((Frame)f).bot1Part.partDimBi;
						}
					}
					
					double legSize = myParent.facetUsed.heightPix - (myParent.facetUsed.widthPix/2);
					
					if (myParent.shapesPanel.selectedShape == 200
							&& legSize < thickMax * 2) {
						
						myParent.shapesPanel.selectedShape = 300;
					}
						
				}

				if (this.myParent.shapesPanel.selectedShape == 203
						|| this.myParent.shapesPanel.selectedShape == 303) {

					if (myParent.shapesPanel.selectedShapeLevel == 1) {
						if (myParent.facetUsed.yRows > 1) {
							// goodToGo = false;
							// JOptionPane.showMessageDialog(
							// null,
							// hrhawithDivision,
							// "",
							// JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				if (goodToGo) {

					if (selectedOpening == null) {

						if (myParent.shapesPanel.selectedShapeLevel == 2) {

							JOptionPane.showMessageDialog(this.myParent,
									openingNotFound, "",
									JOptionPane.ERROR_MESSAGE);
						} else {
							selectedShapeID = myParent.shapesPanel.selectedShape;
							myParent.resetModTextsV = true;
							myParent.resetModTextsH = true;
							shapeDialog = new ShapeDimensionDialog(this,
									selectedOpening, xxx, yyy,
									myParent.shapesPanel.selectedShapeLevel,
									selectedShapeID);
						}
					} else {
						selectedShapeID = myParent.shapesPanel.selectedShape;
						myParent.resetModTextsV = true;
						myParent.resetModTextsH = true;
						shapeDialog = new ShapeDimensionDialog(this,
								selectedOpening, xxx, yyy,
								myParent.shapesPanel.selectedShapeLevel,
								selectedShapeID);
					}

					if (myParent.hasGrids) {
						if (myParent.btnGridsSelect.isSelected()) {
							myParent.btnGridsSelect.doClick();
						}

						myParent.setgrids();
					}

				} else {
					JOptionPane.showMessageDialog(this.myParent,
							invalidShapeforFrameSelected, "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public boolean getShapeOnSide(final ShapeObject myShape, final int side) {

		boolean isTen = false;
		final Object[] frames = myParent.facetUsed.frames.toArray();

		if (side == 1) {// top
			for (final Object f : frames) {
				if (((Frame) f).startCol <= myShape.startCol
						&& ((Frame) f).endCol >= myShape.endCol
						&& ((Frame) f).endRow == myShape.startRow - 1
						&& ((Frame) f).shapeID == 10) {

					isTen = true;
				}
			}
		}

		if (side == 2) {// bot
			for (final Object f : frames) {
				if (((Frame) f).startCol <= myShape.startCol
						&& ((Frame) f).endCol >= myShape.endCol
						&& ((Frame) f).startRow == myShape.endRow + 1
						&& ((Frame) f).shapeID == 10) {

					isTen = true;
				}
			}
		}

		if (side == 3) {// left
			for (final Object f : frames) {
				if (((Frame) f).endCol + 1 == myShape.startCol
						&& ((Frame) f).startRow <= myShape.startRow
						&& ((Frame) f).endRow >= myShape.endRow
						&& ((Frame) f).shapeID == 10) {

					isTen = true;
				}
			}
		}

		if (side == 4) {// right
			for (final Object f : frames) {
				if (((Frame) f).startCol - 1 == myShape.endCol
						&& ((Frame) f).startRow <= myShape.startRow
						&& ((Frame) f).endRow >= myShape.endRow
						&& ((Frame) f).shapeID == 10) {

					isTen = true;
				}
			}
		}

		return isTen;
	}

	/**
	 * Doing feature selected in menu option for couplers & mullions
	 * 
	 * @param xxx
	 *            , Axis x position selected
	 * @param yyy
	 *            , Axis y position selected
	 * @param whichPos
	 *            , position which
	 */
	public void doFeatureClick(int xxx, int yyy, int whichPos) {

		if (myParent.facetUsed.shapeID >= 800
				|| myParent.facetUsed.shapeID >= 11
				&& myParent.facetUsed.shapeID <= 99) {

			// Error message not allow
			String dividerShapeNotAllowed = "Division for shape "
					+ myParent.facetUsed.shapeID
					+ " is unavailable:\nTo request this feature please contact your supplier!";
			// Show error message bad action
			JOptionPane.showMessageDialog(this.myParent,
					dividerShapeNotAllowed, "Error", JOptionPane.ERROR_MESSAGE);

		} else {

			// Defining type of action to execute
			myParent.mullionsPanel.coupleTypeAction();

			// ****************************************************
			// Divide facet action is selected for coupler option
			// ****************************************************
			if (myParent.mullionsPanel.divideFacet) {

				// Get mullions from backgroundOpenings
				Object[] mullions = myParent.jobItem.design.bOpeningObject.mullions
						.toArray();

				// Angle coupler selected
				double angle = myParent.mullionsPanel.angle;

				for (Object mullion : mullions) {

					// Angle selected is not ZERO
					if (angle != 0) {

						if (((Profiles) mullion).angle != angle) {

							// Mullions panel to use false
							myParent.mullionsPanel.okToUse = false;

							// Error message text
							String customLayoutAddDivider = "Custom layout with Varying Divider Angles within a desing\n"
									+ " will be developed according to demand.\n \n"
									+ "To request this fuctionlaity, please contact your supplier!";

							// Show error message
							JOptionPane.showMessageDialog(this.myParent,
									customLayoutAddDivider, "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						// Get angle from mullions in background
						// opening
						angle = ((Profiles) mullion).angle;
					}
				}

				if (myParent.mullionsPanel.okToUse) {
					setSelectedGlass();
					myParent.roundW = true;
					myParent.wEntered = true;
					myParent.hEntered = true;

					// Clear frames text
					myParent.clearItemFrameTextObjects();

					// Clear facets text
					myParent.clearFacetTexts();

					// ***********************************************
					// Change Width and Height dimension
					// ***********************************************
					if (myParent.currentUOM == Metrics.METRIC.getValue()) {
						myParent.jobItem.setWHDimChange(
								myParent.jobItem._WIDTH_Metric_O / 100,
								myParent.jobItem._HEIGHT_Metric_O / 100, true);
					} else if (myParent.currentUOM == Metrics.IMPERIAL_DECIMAL
							.getValue()) {
						myParent.jobItem.setWHDimChange(
								myParent.jobItem._WIDTH_Imp_O,
								myParent.jobItem._HEIGHT_Metric_O, true);
					} else if (myParent.currentUOM == Metrics.IMPERIAL_FRACTION
							.getValue()) {
						myParent.jobItem.setWHDimChange(
								myParent.jobItem._WIDTH_Imp_O,
								myParent.jobItem._HEIGHT_Metric_O, true);
					}

					if (myParent.mullionsPanel.selectedHV == 1) {
						// Divide action
						myParent.doDividerClick(xxx, yyy, whichPos,
								dimensionType, mySelectedOpening,
								mySelectedFrame);
					} else {
						// Error message
						String horizontalDividerFeatureRequest = "Horizontal Facet Dividers (for Garden Windows and other 3D designs)\n are not currently available."
								+ "\nTo request this feature please contact your supplier!";
						// Show error message dialog
						JOptionPane.showMessageDialog(this.myParent,
								horizontalDividerFeatureRequest, "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {

					// Error message
					String dividerConditions = "Facet Dividers cannot be added when  the following conditions are true:\n"
							+ "  1. If no 180 Couplers were already added in the design.\n"
							+ "  2. If the design were already converted to a non flat design.\n"
							+ "  3. The desgin must contain only 1 divider angle (Feature Request).\n"
							+ "\n"
							+ "To request alternative fuctionlaity please contact your supplier!";
					// Show error message dialog
					JOptionPane.showMessageDialog(this.myParent,
							dividerConditions, "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				// ****************************************************
				// Divide with mullion option selected
				// ****************************************************
			} else {

				if (mySelectedFrame == null) {
					JOptionPane
							.showMessageDialog(
									this.myParent,
									"Please select an appropriate "
											+ "position for adding Couplers or Mullions.",
									"Selection - Error",
									JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (mySelectedOpening == null) {
					JOptionPane
							.showMessageDialog(
									this.myParent,
									"Please select an appropriate "
											+ "position for adding Couplers or Mullions.",
									"Selection - Error",
									JOptionPane.ERROR_MESSAGE);
					return;
				}

				myParent.roundW = true;

				// Get selected frame and Opening
				// getSelectedFrameAndOpeningClick(xxx, yyy, true);

				if (mySelectedFrame != null
						&& mySelectedFrame.myParentO.shapeChanged) {
					resetFrameShapeChange(xxx, yyy);
				}

				// Divided setting to TRUE
				boolean okDivide = true;

				// Creating ShapeDivision object
				ShapeDivision shapeDiv = new ShapeDivision(
						mySelectedOpening.shapeID,
						myParent.mullionsPanel.selectedHV,
						myParent.mullionsPanel.selectedLevel);

				if (!shapeDiv.vcPossible || !shapeDiv.hcPossible) {
					okDivide = false;
				}

				if (mySelectedOpening != null && okDivide) {
					setSelectedGlass();
					if (mySelectedOpening.contentMid <= 3
							&& myParent.mullionsPanel.selectedLevel <= ValidCouplerMullions.MULLION
									.getValue()) {

						if (myParent.mullionsPanel.selectedLevel == ValidCouplerMullions.COUPLER
								.getValue()) {

							if (mySelectedOpening.myParent.myFacet.a_levelID == 101) {

								// Show error message dialog
								JOptionPane
										.showMessageDialog(
												this.myParent,
												"Sub-Frame Division not available."
														+ "\nTo request this feature please contact your supplier!",
												"Error",
												JOptionPane.ERROR_MESSAGE);
							} else {
								myParent.doCouplerMullionClick(xxx, yyy,
										whichPos, dimensionType,
										mySelectedOpening, mySelectedFrame);
							}
						}

						if (myParent.mullionsPanel.selectedLevel == ValidCouplerMullions.MULLION
								.getValue()) {

							boolean cont = true;

							if (mySelectedOpening.myParent.myFacet.a_levelID == 101) {

								if (mySelectedOpening.contentMid == 1) {

									// Show error message dialog
									JOptionPane
											.showMessageDialog(
													this.myParent,
													"Sub-Frame Mullions are not available."
															+ "\nTo request this feature please contact your supplier!",
													"Error",
													JOptionPane.ERROR_MESSAGE);

									cont = false;
								}
							}

							if (cont) {
								myParent.doCouplerMullionClick(xxx, yyy,
										whichPos, dimensionType,
										mySelectedOpening, mySelectedFrame);
							}
						}

						if (myParent.hasGrids) {
							if (myParent.btnGridsSelect.isSelected()) {
								myParent.btnGridsSelect.doClick();
							}
							myParent.setgrids();
						}

					} else {

						// Show error message dialog
						JOptionPane
								.showMessageDialog(
										this.myParent,
										"Division of Sub-Frames and Sub-Sashes is unavailable:"
												+ "\nTo request this feature please contact your supplier!",
										"Error", JOptionPane.ERROR_MESSAGE);

						actionPerformed = false;

					}
				} else {
					if (okDivide) {
						JOptionPane.showMessageDialog(this.myParent,
								"Invalid Area Selection:"
										+ "\n Please reselect Area!",
								"Invalid Area Selection",
								JOptionPane.ERROR_MESSAGE);
					} else {
						// JOptionPane
						// .showMessageDialog(
						// null,
						// "Couplers/Mullions are not allowed in selected shape!",
						// "Error!",
						// JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}

		enableLayouts();
	}

	public void resetFrameShapeChange(int xxx, int yyy) {

		mySelectedOpening.setLeanTo(0, 0, 0, 0);
		mySelectedOpening.setDimABCDFromShapeChange(0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		ShapeDimensionDialog sdd = new ShapeDimensionDialog(this,
				mySelectedOpening, xxx, yyy, 2, 1);

	}

	public void enableLayouts() {

		Object[] myMs = myParent.jobItem.design.bOpeningObject.mullions
				.toArray();

		myMs = myParent.jobItem.design.bOpeningObject.mullions.toArray();

		final double[] myAs = new double[myMs.length];

		for (int i = 0; i < myAs.length; i++) {
			myAs[i] = 0;
		}

		int countV = 0;

		for (Object m : myMs) {
			if ((((Profiles) m).angle != 180 || !((Profiles) m).fixedAngle)
					&& ((Profiles) m).orientation == 1
					&& ((Profiles) m).posCondition == 1) {
				myAs[countV] = ((Profiles) m).angle;
				countV++;
			}
		}

		myParent.layoutP.noC = countV;

		if (countV == 1) {
			myParent.layoutP.flat.setEnabled(false);
			myParent.layoutP.bay.setEnabled(false);
			myParent.layoutP.bow.setEnabled(false);
			myParent.layoutP.custom.setEnabled(true);

			myParent.layoutP.validate();
			myParent.layoutP.repaint();
		}
		if (countV == 2) {
			myParent.layoutP.flat.setEnabled(false);
			myParent.layoutP.bay.setEnabled(true);
			myParent.layoutP.bay.setSelected(true);
			myParent.layoutP.bow.setEnabled(false);
			myParent.layoutP.custom.setEnabled(true);
			myParent.layoutP.validate();
			myParent.layoutP.repaint();
		}
		if (countV > 2) {
			myParent.layoutP.flat.setEnabled(false);
			myParent.layoutP.bay.setEnabled(false);
			myParent.layoutP.bow.setEnabled(true);
			myParent.layoutP.bow.setSelected(true);
			myParent.layoutP.custom.setEnabled(true);
			myParent.layoutP.validate();
			myParent.layoutP.repaint();
		}

		if (myParent.layoutP.bay.isEnabled()
				|| myParent.layoutP.bow.isEnabled()
				|| myParent.layoutP.custom.isEnabled()) {
		}

	}

	public void canvasMouseReleaseAction(final MouseEvent e) {

		myParent.addToUndo();

		if (currentRect != null) {

			if (myParent.hasGrids) {

				if (myParent.gridOp == 9 || myParent.gridOp == 10) {
					myParent.setChangeGridMaster(
							(int) currentRect.getCenterX(),
							(int) currentRect.getCenterY(), myParent.gridOp,
							myParent.gridsPanel.whichPos,
							myParent.gridsPanel.form, currentRect);
				}
			}

			if (actionPerformed) {

				myParent.dim.resetDim();

				myParent.resetModTextsV = false;
				myParent.resetModTextsH = false;
				this.validate();
				this.repaint();
			}

		}

		myParent.jobItem.hasSub();

	}

	/**
	 * Do opening click action
	 * 
	 * @param xxx
	 *            , Axis x position
	 * @param yyy
	 *            , Axis y position
	 */
	public void doOpeningClick(int xxx, int yyy) {

		Object[] returns2 = mySelectedOpening.checkOpeningLimit(
				this.mySelectedOpening, myParent.sashPanel.mySelected);
		boolean errorFound = false;

		if (Integer.valueOf(returns2[0].toString()) == 1) {

			try {

				// Generic message selected - opening sash not selected
				String noSashSelected = " No Opening/Sash Type Selected - Please Select an Opening/Sash!";

				if (myParent.sashPanel.openingClass == 0) {

					// Throw error message if selected sash = 0

					JOptionPane.showMessageDialog(this.myParent,
							noSashSelected, "", JOptionPane.ERROR_MESSAGE);

				} else {

					// Evaluation variable
					boolean ok = true;

					if ((myParent.sashPanel.selectedType == OpeningTypes.DOOR
							.getValue() || myParent.sashPanel.selectedType == OpeningTypes.ENTRANCE
							.getValue())
							&& mySelectedFrame.myParentO.myParent.endRow != mySelectedFrame.myFacet.yRows
							&& mySelectedOpening.endRow != mySelectedOpening.myParent.yRows) {

						ok = false;

					}

					if (ok) {
						setSelectedGlass();

						mySelectedOpening.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;

						if (mySelectedOpening.shapeID != 1) {

							if (myParent.sashPanel.openingClass == 4
									|| myParent.sashPanel.openingClass == 8
									|| myParent.sashPanel.openingClass == 10
									|| myParent.sashPanel.selectedType > OpeningTypes.DOOR
											.getValue()) {

								ok = false;

							}
						}

						if (ok) {
							myParent.editor.editFrame = false;
							myParent.alignV = false;
							myParent.alignH = false;
							myParent.editCM = false;

							// Get array of facets from overall
							// design
							Object[] facets = myParent.jobItem.design.frames
									.toArray();
							// Clear collection of facets
							myParent.jobItem.design.frames.clear();

							for (Object f : facets) {

								// Compare facet used to process
								if (((Facet) f).startCol == myParent.facetUsed.startCol) {

									// Get array of frames from
									// facet
									Object[] frames = ((Facet) f).frames
											.toArray();
									// Clear collection of frames
									((Facet) f).frames.clear();

									for (Object frame : frames) {

										// Compare frame used to
										// process
										if (((Frame) frame).a_sequenceID == mySelectedFrame.a_sequenceID) {

											// Setting selected frame
											myParent.mySelectedFrame = (Frame) frame;

											// Adding sash in frame
											// opening object

											// RECALC frame is Seq =
											// 11
											if (mySelectedOpening.a_sequenceID == 11
													|| myParent.mySeries
															.getFrameInOutByAny()) {
												// myParent.wEntered
												// = true;

												Object[] os = ((Frame) frame).openings
														.toArray();

												((Frame) frame).openings
														.clear();

												for (Object o : os) {
													if (((OpeningObject) o).a_sequenceID == mySelectedOpening.a_sequenceID) {

														if (myParent.sashPanel.whichPos == 1) {
															((OpeningObject) o).contentIn = 0;
														} else if (myParent.sashPanel.whichPos == 2) {
															((OpeningObject) o).contentMid = 0;
														} else if (myParent.sashPanel.whichPos == 3) {
															((OpeningObject) o).contentOut = 0;
														}

														if (myParent.sashPanel.openingClass != 1) {
															// No Glass if Not
															// PW
															((OpeningObject) o).unGlazed = true;
															((OpeningObject) o).contentMid = 2;

														} else {
															((OpeningObject) o).unGlazed = false;
															((OpeningObject) o).contentMid = 1;
														}
													}

													((Frame) frame).openings
															.add(o);

												}

												frame = recalFramebasedOnOpening((Frame) frame);

											}

											frame = doAddSashInFrameOpening(
													((Frame) frame), xxx, yyy);

											// Adding frame with
											// changes into facet
											((Facet) f).frames.add(frame);

										} else {

											// Adding frame without
											// changes into facet
											((Facet) f).frames.add(frame);
										}
									}

									// Drawing frames for facet
									((Facet) f).drawFrames();
								}

								// Adding facet to collection of overall
								myParent.jobItem.design.frames.add(f);

							}

						} else {
							JOptionPane.showMessageDialog(this.myParent,
									"Invalid Shape for Sash Type",
									"Invalid Sash Shape - Error!",
									JOptionPane.ERROR_MESSAGE);
						}

						if (myParent.hasGrids) {
							if (myParent.btnGridsSelect.isSelected()) {
								myParent.btnGridsSelect.doClick();
							}
							myParent.setgrids();
						}

					} else {
						String DoorPositionError = "Doors can only be added in the bottom most row of a design.\n"
								+ "To request a change please contact your supplier!";
						JOptionPane.showMessageDialog(this.myParent,
								DoorPositionError, "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			} catch (Exception e) {
				// Show error message
				errorFound = true;
				// JOptionPane.showMessageDialog(null, e.getMessage(),
				// "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();

			}
			if (errorFound) {
				// // Return a default opening for series class
				// this.myParent.sashPanel.openingClass =
				// myParent.mySeries.getDefaultOpeningType();
				// // Do opening click to reset default opening
				// this.doOpeningClick(xxx, yyy);
				this.myParent.undoAction();
			}
		} else {
			JOptionPane.showMessageDialog(this.myParent,
					returns2[1].toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public Object recalcualteNewFrameForSashType(Object frame,
			final boolean doOpening) {

		try {

			if (mySelectedOpening.a_sequenceID == 11) {
				Object[] openingObjects = ((Frame) frame).openings.toArray();
				Collection existingFrames = new ArrayList();

				existingFrames.add(frame);

				if (mySelectedOpening.a_sequenceID == 11) {

					for (Object O : openingObjects) {

						if (((OpeningObject) O).a_sequenceID == mySelectedOpening.a_sequenceID) {
							((Frame) frame).glazedOut = false;
							((Frame) frame).controlOpSeq = ((OpeningObject) O).a_sequenceID;
							((Frame) frame).controlUserDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
							((Frame) frame).controlOpeningClass = myParent.sashPanel.openingClass;

							frame = recalcFrame(
									((Frame) frame),
									((Frame) frame).controlOpeningClass,
									((Frame) frame).controlUserDefinedOpeningID,
									((Frame) frame).controlOpeningClassType,
									((Frame) frame).glazedOut,
									((OpeningObject) O).sashObjectIn,
									((OpeningObject) O).sashObjectMid,
									((OpeningObject) O).sashObjectOut,
									existingFrames, true);
						}
					}
				}
			}
			((ShapeObject) frame).doOpenings();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return frame;
	}

	/**
	 * Do sash in frame Opening
	 * 
	 * @param frame
	 *            , Frame
	 * @param xxx
	 *            , Axis x position
	 * @param yyy
	 *            , Axis y position
	 * @return Frame
	 */
	public Frame doAddSashInFrameOpening(Frame frame, int xxx, int yyy) {

		try {

			warningIssued = true;
			myParent.openingChanged = false;

			// Get opening objects from Frame object
			Object[] openingObjects = frame.openings.toArray();

			// Setting selected frame null
			getSelectedFrame = null;

			boolean noConflict = true;

			// Creating new collection of existing frames
			Collection existingFrames = new ArrayList();
			existingFrames.add(frame);

			openingObjects = frame.openings.toArray();

			frame.openings.clear();

			for (Object O : openingObjects) {

				if (((OpeningObject) O).a_sequenceID == mySelectedOpening.a_sequenceID) {

					if (noConflict) {
						((OpeningObject) O).openingClass = myParent.sashPanel.openingClass;
						((OpeningObject) O).userDefinedOpeningID = ((OpeningObject) O).controlUserDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;

						warningIssued = false;

						if (((OpeningObject) O).contentMid == 3
								&& myParent.sashPanel.subOp == 1
								&& myParent.subFClicked) {

							JOptionPane.showMessageDialog(this.myParent,
									"Cannot Add SubFrame into an Existing SubFrame!\n"
											+ "SubFrame will be Ignored",
									"Invalid Opening Selected - Error!",
									JOptionPane.ERROR_MESSAGE);

							myParent.sashPanel.subFrameButton
									.setSelected(false);
							myParent.sashPanel.subOp = 0;

							myParent.sashPanel.subSashButton.setSelected(false);

							break;

						} else if (((OpeningObject) O).contentMid == 3
								&& (myParent.sashPanel.subOp > 1 || myParent.sashPanel.mySelected
										.isAuto_subframe())) {

							Object[] sFs = ((OpeningObject) O).frames.toArray();

							for (Object sf : sFs) {

								if (Math.min(((Frame) sf).startingX,
										((Frame) sf).bX4) <= xxx
										&& Math.max(((Frame) sf).bX2,
												((Frame) sf).bX3) >= xxx
										&& ((Frame) sf).highestY <= yyy
										&& Math.max(((Frame) sf).bY4,
												((Frame) sf).bY3) >= yyy) {

									frame = (Frame) sf;
									openingObjects = frame.openings.toArray();
									frame.openings.clear();
									Point p = new Point(xxx, yyy);

									for (Object sO : openingObjects) {

										if (((OpeningObject) sO).gp.contains(p)
												|| xxx <= ((OpeningObject) sO).bX2
												&& xxx <= ((OpeningObject) sO).bX3
												&& xxx >= ((OpeningObject) sO).bX4
												&& yyy >= ((OpeningObject) sO).bY4
														- ((OpeningObject) sO).heightPix
												&& yyy <= ((OpeningObject) sO).bY3
												&& yyy <= ((OpeningObject) sO).bY4) {
											O = sO;
										}
									}
								}
							}
						}

						((OpeningObject) O).myFacet = myParent.facetUsed;

						if (myParent.lastChangedOpening == null) {
							myParent.lastChangedOpening = (OpeningObject) O;
							myParent.openingChanged = true;
							myParent.lastChangedLeaf = -1;

						} else if (frame.a_sequenceID != myParent.lastChangedOpening.myParent.a_sequenceID
								|| myParent.lastChangedOpening.a_sequenceID != ((OpeningObject) O).a_sequenceID
								|| (myParent.lastChangedOpening.sashObjectIn != null
										&& myParent.lastChangedOpening.contentIn == 2
										&& myParent.lastChangedOpening.sashObjectIn.sashClassType != myParent.sashPanel.openingClass && myParent.sashPanel.whichPos == 1)
								|| (myParent.lastChangedOpening.sashObjectMid != null
										&& myParent.lastChangedOpening.contentMid == 2
										&& myParent.lastChangedOpening.sashObjectMid.sashClassType != myParent.sashPanel.openingClass && myParent.sashPanel.whichPos == 2)
								|| (myParent.lastChangedOpening.sashObjectOut != null
										&& myParent.lastChangedOpening.contentOut == 2
										&& myParent.lastChangedOpening.sashObjectOut.sashClassType != myParent.sashPanel.openingClass && myParent.sashPanel.whichPos == 3)) {

							myParent.lastChangedOpening = (OpeningObject) O;
							myParent.openingChanged = true;
							myParent.lastChangedLeaf = -1;

						}

						int contenType = 2;

						if (myParent.sashPanel.wButton.isSelected()) {
							contenType = 2;
						} else if (myParent.sashPanel.dButton.isSelected()) {
							contenType = 2;
						} else if (myParent.sashPanel.eButton.isSelected()) {
							contenType = 5;
						} else if (myParent.sashPanel.sButton.isSelected()) {
							contenType = 2;
						}

						if (myParent.sashPanel.subOp == 1
								|| myParent.sashPanel.mySelected
										.isAuto_subframe()) {
							contenType = 3; // sub Frame
							// if (myParent.sashPanel.mySelected.auto_subsash
							// && mySelectedOpening.openingClass > 1) {
							// contenType = 4;// sub Sash
							// }
							myParent.sashPanel.whichPos = 2;
						} else if (myParent.sashPanel.subOp == 2
								|| myParent.sashPanel.mySelected
										.isAuto_subframe()) {
							contenType = 4;
						} else if (myParent.sashPanel.subOp == 3) {
							contenType = 1;
						} else if (myParent.sashPanel.subOp == 0
								&& myParent.sashPanel.opens == 0) {
							contenType = 1;
						}

						int selectedSash = myParent.sashPanel.openingClass;
						int selectedSashID = myParent.sashPanel.userDefinedOpeningID;

						if (myParent.sashPanel.whichPos == 1) {

							((OpeningObject) O).contentIn = contenType;

							if (contenType != 1) {
								((OpeningObject) O).myGlassOut = null;

								((OpeningObject) O).clearBomForShape();
								((OpeningObject) O).clearGlassBomForShape();

								if (((OpeningObject) O).myGlassIn != null) {
									((OpeningObject) O).myGlassIn.bom.clear();
									((OpeningObject) O).myGlassIn
											.clearBomForShape();
									((OpeningObject) O).myGlassIn
											.clearGlassBomForShape();
									((OpeningObject) O).myGlassIn = null;
								}
								if (((OpeningObject) O).dloIn != null) {
									((OpeningObject) O).dloIn.bom.clear();
									((OpeningObject) O).dloIn
											.clearBomForShape();
									((OpeningObject) O).dloIn
											.clearGlassBomForShape();
									((OpeningObject) O).dloIn = null;
								}

								((OpeningObject) O).glazingBeadsIn = new ArrayList();

								CreateGlazingStops cgb = new CreateGlazingStops(
										((OpeningObject) O), myParent);
								GlazingBeads myBeads = new GlazingBeads();

								myBeads.myFrame2 = this.myParent;

								myBeads = cgb.initSashLeaf(myBeads,
										((OpeningObject) O).topIn,
										((OpeningObject) O).botIn,
										((OpeningObject) O).leftIn,
										((OpeningObject) O).rightIn);

								myBeads.clearBomForShape();

							}

						} else if (myParent.sashPanel.whichPos == 2) {

							((OpeningObject) O).contentMid = contenType;

							if (contenType != 1) {

								((OpeningObject) O).clearBomForShape();
								((OpeningObject) O).clearGlassBomForShape();

								if (((OpeningObject) O).myGlassMid != null) {
									((OpeningObject) O).myGlassMid.bom.clear();
									((OpeningObject) O).myGlassMid
											.clearBomForShape();
									((OpeningObject) O).myGlassMid
											.clearGlassBomForShape();
									((OpeningObject) O).myGlassMid = null;
								}
								if (((OpeningObject) O).dloMid != null) {
									((OpeningObject) O).dloMid.bom.clear();
									((OpeningObject) O).dloMid
											.clearBomForShape();
									((OpeningObject) O).dloMid
											.clearGlassBomForShape();
									((OpeningObject) O).dloMid = null;
								}

								((OpeningObject) O).glazingBeadsMid = new ArrayList();

								CreateGlazingStops cgb = new CreateGlazingStops(
										((OpeningObject) O), myParent);
								GlazingBeads myBeads = new GlazingBeads();
								myBeads.myFrame2 = this.myParent;

								myBeads = cgb.initSashLeaf(myBeads,
										((OpeningObject) O).topIn,
										((OpeningObject) O).botIn,
										((OpeningObject) O).leftIn,
										((OpeningObject) O).rightIn);

								myBeads.clearBomForShape();

							}

						} else if (myParent.sashPanel.whichPos == 3) {

							((OpeningObject) O).contentOut = contenType;

							if (contenType != 1) {

								((OpeningObject) O).myGlassOut = null;

								((OpeningObject) O).clearBomForShape();
								((OpeningObject) O).clearGlassBomForShape();

								if (((OpeningObject) O).myGlassOut != null) {
									((OpeningObject) O).myGlassOut.bom.clear();
									((OpeningObject) O).myGlassOut
											.clearBomForShape();
									((OpeningObject) O).myGlassOut
											.clearGlassBomForShape();
									((OpeningObject) O).myGlassOut = null;
								}
								if (((OpeningObject) O).dloOut != null) {
									((OpeningObject) O).dloOut.bom.clear();
									((OpeningObject) O).dloOut
											.clearBomForShape();
									((OpeningObject) O).dloOut
											.clearGlassBomForShape();
									((OpeningObject) O).dloOut = null;
								}

								((OpeningObject) O).glazingBeadsOut = new ArrayList();

								CreateGlazingStops cgb = new CreateGlazingStops(
										((OpeningObject) O), myParent);
								GlazingBeads myBeads = new GlazingBeads();
								myBeads.myFrame2 = this.myParent;

								myBeads = cgb.initSashLeaf(myBeads,
										((OpeningObject) O).topIn,
										((OpeningObject) O).botIn,
										((OpeningObject) O).leftIn,
										((OpeningObject) O).rightIn);

								myBeads.clearBomForShape();

							}

						}

						if ((myParent.sashPanel.subOp == 1 || myParent.sashPanel.mySelected.isAuto_subframe())
								&& myParent.alignClicks <= 1) {

							Collection existingFacets = new ArrayList();
							((OpeningObject) O).subFacet = new Facet();

							CreateFacets createFacet = new CreateFacets((OpeningObject) O, existingFacets, myParent);
							((OpeningObject) O).subFacet = createFacet.doFacet(false, false, true, true);
							((OpeningObject) O).subFacet.a_levelID = 101;
							((OpeningObject) O).subFacet.a_assemblyLevel = 200;
							((OpeningObject) O).subFacet.a_sequenceID = 11;
							((OpeningObject) O).subFacet.doOpenings();
							((OpeningObject) O).subFacet.doCouplers();

							((OpeningObject) O).subFacet.doFrames(true, true,
									true, true);

							((OpeningObject) O).subFacet.drawFrames();

							((OpeningObject) O).subFacet.setOriginalDimsInit(
									((OpeningObject) O).subFacet.widthPix,
									((OpeningObject) O).subFacet.heightPix);
							((OpeningObject) O).subFacet.setDimsChange(
									((OpeningObject) O).subFacet.widthPix,
									((OpeningObject) O).subFacet.heightPix);

							existingFacets = null;

							myParent.sashPanel.subFrameButton
									.setSelected(false);
							myParent.sashPanel.subSashButton.setSelected(false);

							Object[] subFs = ((OpeningObject) O).subFacet.frames
									.toArray();

							((OpeningObject) O).subFacet.frames.clear();

							for (Object ff : subFs) {
								Object[] subOs = ((Frame) ff).openings
										.toArray();
								mySelectedSFrame = (Frame) ff;

								for (Object o : subOs) {
									mySelectedSOpening = (OpeningObject) o;
								}

								myParent.sashPanel.openingClass = selectedSash;
								myParent.sashPanel.userDefinedOpeningID = selectedSashID;
								myParent.sashPanel.setSashInfo();
								warningIssued = true;

								Object[] openings = ((Frame) ff).openings
										.toArray();

								getSelectedFrame = null;

								((Frame) ff).openings.clear();

								for (Object OO : openings) {

									if (((OpeningObject) OO)
											.equals(mySelectedSOpening)) {

										warningIssued = false;

										((OpeningObject) OO).myFacet = ((OpeningObject) O).subFacet;

										if (myParent.lastChangedOpening == null) {
											myParent.lastChangedOpening = (OpeningObject) OO;
											myParent.openingChanged = true;
											myParent.lastChangedLeaf = -1;

										} else if (((Frame) ff).a_sequenceID != myParent.lastChangedOpening.myParent.a_sequenceID
												|| myParent.lastChangedOpening.a_sequenceID != ((OpeningObject) OO).a_sequenceID
												|| myParent.lastChangedOpening.contentIn == 2
												&& myParent.lastChangedOpening.sashObjectIn.sashClassType != myParent.sashPanel.openingClass
												&& myParent.sashPanel.whichPos == 1
												|| myParent.lastChangedOpening.contentMid == 2
												&& myParent.lastChangedOpening.sashObjectMid.sashClassType != myParent.sashPanel.openingClass
												&& myParent.sashPanel.whichPos == 2
												|| myParent.lastChangedOpening.contentOut == 2
												&& myParent.lastChangedOpening.sashObjectOut.sashClassType != myParent.sashPanel.openingClass
												&& myParent.sashPanel.whichPos == 3) {

											myParent.lastChangedOpening = (OpeningObject) OO;
											myParent.openingChanged = true;
											myParent.lastChangedLeaf = -1;
										}

										contenType = 2;

										if (myParent.sashPanel.subOp == 0
												&& myParent.sashPanel.openingClass == 1) {
											contenType = 1;
										}

										if (myParent.sashPanel.whichPos == 1) {
											((OpeningObject) OO).contentIn = contenType;
										} else if (myParent.sashPanel.whichPos == 2) {
											((OpeningObject) OO).contentMid = contenType;
										} else if (myParent.sashPanel.whichPos == 3) {
											((OpeningObject) OO).contentOut = contenType;
										}
									}

									if (myParent.sashPanel.doDialog) {
										if (myParent.sashPanel.whichPos == 2
												&& mySelectedOpening.contentMid == 2) {
											myParent.sashPanel.percentA = mySelectedOpening.sashObjectMid.percentA;
											myParent.sashPanel.percentB = mySelectedOpening.sashObjectMid.percentB;
											myParent.sashPanel.percentC = mySelectedOpening.sashObjectMid.percentC;
										} else if (myParent.sashPanel.whichPos == 1
												&& mySelectedOpening.contentIn == 2) {
											myParent.sashPanel.percentA = mySelectedOpening.sashObjectIn.percentA;
											myParent.sashPanel.percentB = mySelectedOpening.sashObjectIn.percentB;
											myParent.sashPanel.percentC = mySelectedOpening.sashObjectIn.percentC;
										} else if (myParent.sashPanel.whichPos == 3
												&& mySelectedOpening.contentOut == 2) {
											myParent.sashPanel.percentA = mySelectedOpening.sashObjectOut.percentA;
											myParent.sashPanel.percentB = mySelectedOpening.sashObjectOut.percentB;
											myParent.sashPanel.percentC = mySelectedOpening.sashObjectOut.percentC;
										}

										this.continueSash(warningIssued,
												(OpeningObject) OO, false);

										double split = myParent.sashPanel.split;
										int noOfLeafs = myParent.sashPanel.noOfLeafs;
										int notracks = myParent.sashPanel.notracks;
										int[] sashOnTrack = myParent.sashPanel.sashOnTrack;
										int opens = myParent.sashPanel.opens;
										boolean glazedOut = myParent.sashPanel.glazedOut;
										boolean[] sashGlazedOut = myParent.sashPanel.sashGlazedOut;
										int[] paneType = myParent.sashPanel.paneType;
										boolean isOriel = myParent.sashPanel.isOriel;
										int[] interLocks = myParent.sashPanel.interlockTypes;
										int sashTypeID = myParent.sashPanel.openingClass;
										int userDefinedID = myParent.sashPanel.userDefinedOpeningID;
										int whichPos = myParent.sashPanel.whichPos;
										double extraExtension = myParent.sashPanel.extendExtra;
										int productType = myParent.sashPanel.selectedType;

										SashOrielDialog orielDialog = new SashOrielDialog();

										orielDialog.run(myParent.sashPanel,
												((OpeningObject) OO),
												((Frame) ff),
												myParent.sashPanel.whichPos,
												myParent.sashPanel.percentA,
												myParent.sashPanel.percentB,
												myParent.sashPanel.percentC,
												myParent);

										CreateSash createSash = new CreateSash(
												((OpeningObject) OO),
												sashTypeID, userDefinedID,
												noOfLeafs, notracks,
												sashOnTrack, whichPos, split,
												opens, null, glazedOut,
												sashGlazedOut, paneType,
												isOriel, interLocks,
												extraExtension, myParent,
												productType);

										((OpeningObject) OO).sashObjectMid = myParent.sashType = createSash
												.createSashType();
										((OpeningObject) OO).sashObjectMid.percentA = myParent.sashPanel.percentA;
										((OpeningObject) OO).sashObjectMid.percentB = myParent.sashPanel.percentB;
										((OpeningObject) OO).sashObjectMid.percentC = myParent.sashPanel.percentC;
										((Frame) ff).glazedOut = glazedOut;
										((Frame) ff).controlOpSeq = ((OpeningObject) OO).a_sequenceID;
										((Frame) ff).controlUserDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
										((Frame) ff).controlOpeningClass = myParent.sashPanel.openingClass;
										((Frame) ff).isNewFrame = true;

									} else {
										OO = this.continueSash(warningIssued,
												(OpeningObject) OO, true);
									}

									((Frame) ff).openingClass = selectedSash;
									((Frame) ff).userDefinedOpeningID = selectedSashID;

									if (((OpeningObject) OO).a_sequenceID == 11) {
										((Frame) ff).isNewFrame = true;
										((Frame) ff).newPart = true;
									}

									((Frame) ff).openings.add(OO);
								}

								if (myParent.sashPanel.opens == 1) {
									((Frame) ff).glazedOut = true;
								} else {
									((Frame) ff).glazedOut = false;
								}
								((OpeningObject) O).subFacet.frames.add(ff);
							}

							((OpeningObject) O).subFacet.a_assemblyLevel = 200;
							((OpeningObject) O).subFacet.a_sequenceID = 11;
						}

						if (((OpeningObject) O).contentMid != 3) {

							if (myParent.sashPanel.doDialog) {

								SashOrielDialog orielDialog = new SashOrielDialog();

								orielDialog.run(myParent.sashPanel,
										((OpeningObject) O), frame,
										myParent.sashPanel.whichPos,
										myParent.sashPanel.percentA,
										myParent.sashPanel.percentB,
										myParent.sashPanel.percentC, myParent);

								O = orielDialog.selectedOpening;

								O = this.continueSash(warningIssued,
										(OpeningObject) O, true);

								if (mySelectedOpening.a_sequenceID == 11) {
									frame.glazedOut = false;
									frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
									frame.controlUserDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
									frame.controlOpeningClass = myParent.sashPanel.openingClass;
									frame.controlOpeningClassType = myParent.sashPanel.selectedType;
								}

								// SashOrielDialog orielDialog = new
								// SashOrielDialog();
								// orielDialog.run(myParent.sashPanel,
								// ((OpeningObject) O), frame,
								// myParent.sashPanel.whichPos,
								// myParent.sashPanel.percentA,
								// myParent.sashPanel.percentB,
								// myParent.sashPanel.percentC, myParent);
								//
								// O = orielDialog.selectedOpening;

							} else {
								((OpeningObject) O).subFacet = null;
								O = this.continueSash(warningIssued,
										(OpeningObject) O, true);
							}
						}

						if (myParent.sashPanel.subOp == 0) {

							if (mySelectedOpening.a_sequenceID == 11) {
								frame.openingClass = myParent.sashPanel.openingClass;
								frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
							}

							if (((OpeningObject) O).a_sequenceID == 11) {

								if (myParent.sashPanel.opens != 2) {
									frame.glazedOut = true;
								} else if (myParent.sashPanel.opens == 2) {
									frame.glazedOut = false;
								}

								frame.isNewFrame = true;
								frame.newPart = true;

							} else {
								boolean okGO = true;
								if (frame.glazedOut
										&& myParent.sashPanel.opens >= 2) {

									for (Object OO : openingObjects) {
										if (((OpeningObject) OO).a_sequenceID != mySelectedOpening.a_sequenceID
												&& ((OpeningObject) OO).contentMid == 2) {
											okGO = false;
											break;
										}
									}
									if (okGO) {
										frame.glazedOut = false;
									}
								} else if (!frame.glazedOut
										&& myParent.sashPanel.opens == 1) {
									for (Object OO : openingObjects) {
										if (((OpeningObject) OO).a_sequenceID != mySelectedOpening.a_sequenceID
												&& ((OpeningObject) OO).contentMid == 2) {
											okGO = false;
											break;
										}
									}

									if (okGO) {
										frame.glazedOut = true;
									}
								}
							}
						}
					}
				}

				// Execute part rules
				((OpeningObject) O).executePartRules(true, true,
						"drawcanvas.doaddsashinframe.2813");

				frame.openings.add(O);

			}

			if (myParent.sashPanel.doDialog
					&& mySelectedOpening.a_sequenceID == 11) {
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return frame;
	}

	/**
	 * Recalculate frame based on Opening
	 * 
	 * @param frame
	 *            , Frame
	 * @return Frame
	 */
	public Frame recalFramebasedOnOpening(Frame frame) {

		Collection mframe = new ArrayList();

		mframe.add(frame);

		frame.isNewFrame = true;

		Object[] fOps = frame.openings.toArray();

		for (Object O : fOps) {
			if (((OpeningObject) O).a_sequenceID == 11
					|| myParent.mySeries.getFrameInOutByAny()) {

				if (myParent.sashPanel.mySelected.getParent_frame_ud_id() > 0) {

					SeriesValidOpeningShape p = ItemFrame
							.getApplicationBaseRules()
							.getSeriesValidOpeningById(
									myParent.sashPanel.mySelected
											.getParent_frame_ud_id());

					frame = recalcFrame(frame, p.getSeriesValidOpeningPK()
							.getOpeningId(), p.getSeriesValidOpeningPK()
							.getId(), p.getSeriesValidOpeningPK()
							.getOpeningId(),
							this.myParent.mySeries.isGlazedout(),
							((OpeningObject) O).sashObjectIn,
							((OpeningObject) O).sashObjectMid,
							((OpeningObject) O).sashObjectOut, mframe, true);

				} else {

					frame = recalcFrame(frame, myParent.sashPanel.openingClass,
							myParent.sashPanel.userDefinedOpeningID,
							myParent.sashPanel.openingClass,
							myParent.sashPanel.glazedOut,
							((OpeningObject) O).sashObjectIn,
							((OpeningObject) O).sashObjectMid,
							((OpeningObject) O).sashObjectOut, mframe, true);

				}

				// do not recalculate Frame

				break;
			}
		}

		return frame;
	}

	/**
	 * Check Opening limits adding to frame
	 * 
	 * @param frame
	 *            , Frame
	 */

	/**
	 * set control Oprning ID, OpeneningClass and OpeningID
	 * <p/>
	 * FOR FRAME
	 * 
	 * @param frame
	 * @param openingObjects
	 * @param O
	 * @param noConflict
	 * @param existingFrames
	 * @return
	 */
	public Object[] checkconflicts(Frame frame, Object[] openingObjects,
			Object O, boolean noConflict, Collection existingFrames)
			throws Exception {

		Object[] returns = new Object[2];

		if (myParent.sashPanel.subOp == 0) {

			if (frame.glazedOut && myParent.sashPanel.opens >= 2) {

				for (Object OO : openingObjects) {
					if (((OpeningObject) OO).a_sequenceID != this.mySelectedOpening.a_sequenceID
							&& ((OpeningObject) O).a_sequenceID != 11
							&& !myParent.mySeries.getFrameInOutByAny()) {
						noConflict = false;
						break;
					}
				}

				if (noConflict && ((OpeningObject) O).a_sequenceID == 11) {
					frame.glazedOut = false;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;

					/**
					 * set control Oprning ID, OpeneningClass and OpeningID
					 * 
					 * FOR FRAME
					 * 
					 */

					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;

				} else if (noConflict && myParent.mySeries.getFrameInOutByAny()) {
					frame.glazedOut = true;
					frame.glazedOut = false;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;
				}
			}

			if (!frame.glazedOut && myParent.sashPanel.opens == 1) {

				for (Object OO : openingObjects) {
					if (((OpeningObject) OO).a_sequenceID != mySelectedOpening.a_sequenceID
							&& ((OpeningObject) O).a_sequenceID != 11
							&& !myParent.mySeries.getFrameInOutByAny()) {
						noConflict = false;
						break;
					}
				}

				if (noConflict && ((OpeningObject) O).a_sequenceID == 11) {
					frame.glazedOut = true;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;

				} else if (noConflict && myParent.mySeries.getFrameInOutByAny()) {
					frame.glazedOut = true;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;
				}
			}

			if (frame.glazedOut && myParent.sashPanel.opens == 0
					&& !myParent.sashPanel.glazedOut) {

				for (Object OO : openingObjects) {
					if (((OpeningObject) OO).a_sequenceID != this.mySelectedOpening.a_sequenceID
							&& ((OpeningObject) O).a_sequenceID != 11
							&& !myParent.mySeries.getFrameInOutByAny()) {
						noConflict = false;
						break;
					}
				}

				if (noConflict && ((OpeningObject) O).a_sequenceID == 11) {
					frame.glazedOut = false;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;

				} else if (noConflict && myParent.mySeries.getFrameInOutByAny()) {

					frame.glazedOut = false;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;
				}

			}

			if (!frame.glazedOut && myParent.sashPanel.opens == 0
					&& myParent.sashPanel.glazedOut) {

				for (Object OO : openingObjects) {
					if (((OpeningObject) OO).a_sequenceID != this.mySelectedOpening.a_sequenceID
							&& ((OpeningObject) O).a_sequenceID != 11
							&& !myParent.mySeries.getFrameInOutByAny()) {
						noConflict = false;
						break;
					}
				}

				if (noConflict && ((OpeningObject) O).a_sequenceID == 11) {
					frame.glazedOut = true;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;

				} else if (noConflict && myParent.mySeries.getFrameInOutByAny()) {

					frame.glazedOut = true;
					frame.controlOpSeq = ((OpeningObject) O).a_sequenceID;
					frame.controlUserDefinedOpeningID = frame.userDefinedOpeningID = myParent.sashPanel.userDefinedOpeningID;
					frame.controlOpeningClass = frame.openingClass = myParent.sashPanel.openingClass;
					frame.controlOpeningClassType = myParent.sashPanel.selectedType;
					frame = doChangeFrameINOUT(frame, existingFrames);
					myParent.openingChanged = true;
				}

			}

			if (!noConflict) {
				if (frame.glazedOut) {
					doConflictMessage(1);
				} else if (!frame.glazedOut) {
					doConflictMessage(2);
				}
			}
		}

		returns[0] = noConflict;
		returns[1] = frame;
		return returns;
	}

	public Frame doChangeFrameINOUT(Frame frame, final Collection existingFrames)
			throws Exception {

		frame.openings.toArray();

		OpeningObject mOp = mySelectedOpening.cloneOpening(mySelectedOpening);

		mOp = addSash(false, mySelectedOpening, true);

		frame = recalcFrame(frame, frame.controlOpeningClass,
				frame.controlUserDefinedOpeningID,
				frame.controlOpeningClassType, frame.glazedOut,
				mOp.sashObjectIn, mOp.sashObjectMid, mOp.sashObjectOut,
				existingFrames, true);

		mOp = null;

		return frame;
	}

	public Frame recalcFrame(Frame frame, int sashType, int sashID,
			int controlType, boolean glazedOut, SashTypeObject in,
			SashTypeObject mid, SashTypeObject out, Collection existingFrames,
			boolean isReCalc) {

		try {

			CreateFrames createFrame = new CreateFrames(frame.myParentO,
					existingFrames, myParent);

			frame = createFrame.doFrame(sashType, sashID, controlType, in, mid,
					out, glazedOut, true, isReCalc, false);
			frame.bOpeningObject = frame.doMullions(frame.bOpeningObject);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return frame;
	}

	public void doConflictMessage(int inOut) {

		if (inOut == 1) {
			JOptionPane
					.showMessageDialog(
							this.myParent,
							"Open In Sash inserted into Glazed Out Frame.\n"
									+ "Add Subframe to correct, or contact your Supplier.",
							"Glazing Leg Conflict - Error!",
							JOptionPane.ERROR_MESSAGE);

		} else {
			JOptionPane
					.showMessageDialog(
							this.myParent,
							"Open Out Sash inserted into Glazed In Frame.\n"
									+ "Add Subframe to correct, or contact your Supplier.",
							"Glazing Leg Conflict - Error!",
							JOptionPane.ERROR_MESSAGE);
		}
	}

	public OpeningObject continueSash(boolean warningIssued,
			OpeningObject myOpening, boolean doSash) throws Exception {

		myOpening = addSash(warningIssued, myOpening, doSash);

		return myOpening;
	}

	/**
	 * Add Sash
	 * 
	 * @param warningIssued
	 *            , boolean
	 * @param myOpening
	 *            , OpeningObject
	 * @param doSash
	 *            , boolean
	 * @return OpeningObject
	 */
	public OpeningObject addSash(boolean warningIssued,
			OpeningObject myOpening, boolean doSash) throws Exception {

		double split = myParent.sashPanel.split;
		int noOfLeafs = myParent.sashPanel.noOfLeafs;
		int notracks = myParent.sashPanel.notracks;
		int[] sashOnTrack = myParent.sashPanel.sashOnTrack;
		int opens = myParent.sashPanel.opens;
		boolean glazedOut = myParent.sashPanel.glazedOut;
		boolean[] sashGlazedOut = myParent.sashPanel.sashGlazedOut;
		int[] paneType = myParent.sashPanel.paneType;
		boolean isOriel = myParent.sashPanel.isOriel;
		int[] interLocks = myParent.sashPanel.interlockTypes;
		int sashTypeID = myParent.sashPanel.openingClass;
		int userDefinedID = myParent.sashPanel.userDefinedOpeningID;
		int whichPos = myParent.sashPanel.whichPos;
		double extraExtension = myParent.sashPanel.extendExtra;
		int productType = myParent.sashPanel.selectedType;

		if (myOpening != null
				&& myOpening.contentMid != OpeningTypes.ENTRANCE.getValue()) {

			CreateSash createSash = new CreateSash(myOpening, sashTypeID,
					userDefinedID, noOfLeafs, notracks, sashOnTrack, whichPos,
					split, opens, null, glazedOut, sashGlazedOut, paneType,
					isOriel, interLocks, extraExtension, myParent, productType);

			myParent.sashType = createSash.createSashType();
			myParent.sashType.percentA = myParent.sashPanel.percentA;
			myParent.sashType.percentB = myParent.sashPanel.percentB;
			myParent.sashType.percentC = myParent.sashPanel.percentC;
			createSash.myExistingSashes = null;

			myOpening = createSash.doNewSash(myParent.sashType, false, null);

		} else {
			if (warningIssued) {
				JOptionPane.showMessageDialog(this.myParent,
						"No suitable Opening found for Sash!",
						"Invalid Opening Selected - Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		return myOpening;
	}

	private void editFrameAction(final int x, final int y) {

		Object[] returns = new Object[2];
		boolean found = false;
		if (mySelectedFrame != null) {
			final Object[] frames = myParent.facetUsed.frames.toArray();

			/*
			 * selectedEditLevel = 1 Frame selectedEditLevel = 2 Sash
			 * selectedEditLevel = 3 Sub Sash selectedEditLevel = 4 Sub Frame
			 * selectedEditLevel = 5 sash of Sub Frame selectedEditLevel = 6 sub
			 * sash of sub frame
			 */

			for (final Object F : frames) {
				if (found) {
					break;
				}

				if (myParent.editor.selectedEditLevel == 1
						|| myParent.editor.selectedEditLevel == 4) {

					returns = this.findParts(x, y, found, (ShapeObject) F);

					found = Boolean.parseBoolean(returns[0].toString());

				}
				if (found) {

					myParent.editor.cancel.setVisible(true);
					myParent.editor.cancel.setEnabled(true);
					break;
				} else {
					final Object[] openings = ((ShapeObject) F).openings
							.toArray();
					for (final Object O : openings) {

						if (myParent.editor.selectedEditLevel == 2
								|| myParent.editor.selectedEditLevel == 5) {
							found = lookForSashParts(x, y, found, O);

						}

					}
				}

			}
			if (!found) {
				myParent.editor.selectPart.setVisible(false);
				myParent.editor.edit.setEnabled(true);
				myParent.editor.removePart.setEnabled(true);
				myParent.editor.setEditProfileVisible(false, null);
				myParent.editor.editFrame = false;
				JOptionPane
						.showMessageDialog(this.myParent, "Part Not Found!\n"
								+ "Please Change Selection.",
								"Invalid Selection - Error!",
								JOptionPane.ERROR_MESSAGE);
				myParent.editor.cancel.doClick();

			}
		} else {
			returns = this.findParts(x, y, found, myParent.facetUsed);

			final Object[] facets = myParent.jobItem.design.frames.toArray();
			myParent.jobItem.design.frames.clear();

			for (final Object facet : facets) {
				if (((Facet) facet).a_sequenceID == myParent.facetUsed.a_sequenceID) {
					myParent.jobItem.design.frames.add(returns[1]);
				} else {
					myParent.jobItem.design.frames.add(facet);
				}
			}

			found = Boolean.parseBoolean(returns[0].toString());
		}
	}

	public boolean lookForSashParts(final int x, final int y, boolean found,
			final Object O) {

		Object[] returns = new Object[2];
		Object[] leafs;

		if (((OpeningObject) O).sashObjectIn != null) {
			leafs = ((OpeningObject) O).sashObjectIn.frames.toArray();
			for (final Object S : leafs) {
				if (!found) {
					returns = this.findParts(x, y, found, (ShapeObject) S);

					found = Boolean.parseBoolean(returns[0].toString());
				}
			}// In
				// Sash
		}

		if (!found) {

			if (((OpeningObject) O).sashObjectMid != null) {
				leafs = ((OpeningObject) O).sashObjectMid.frames.toArray();
				for (final Object S : leafs) {
					if (!found) {
						returns = this.findParts(x, y, found, (ShapeObject) S);

						found = Boolean.parseBoolean(returns[0].toString());
					}
				}// In
					// Sash

			}// Mid
				// Sash
		}
		if (!found) {

			if (((OpeningObject) O).sashObjectOut != null) {
				leafs = ((OpeningObject) O).sashObjectOut.frames.toArray();
				for (final Object S : leafs) {
					if (!found) {
						returns = this.findParts(x, y, found, (ShapeObject) S);
						found = Boolean.parseBoolean(returns[0].toString());
					}
				}// In
					// Sash

			}// In
				// Sash
		}
		if (found) {

			myParent.editor.cancel.setVisible(true);
			myParent.editor.cancel.setEnabled(true);
		}

		return found;
	}

	public Object[] findParts(final int x, final int y, boolean found,
			final ShapeObject F) {

		final Object[] returns = new Object[2];
		Object[] parts;
		parts = F.partObjects.toArray();
		F.partObjects.clear();
		for (final Object P : parts) {

			// if (((Profiles) P).partForm > 1)
			// {
			// JOptionPane
			// .showMessageDialog(
			// null,
			// "End Types at Curved parts will not Change!\n"
			// +
			// "Please Contact your supplier to request this feature.",
			// "End Type Modification - Warning!",
			// JOptionPane.WARNING_MESSAGE);
			// }

			final Polygon m = new Polygon();
			m.addPoint((int) ((Profiles) P).startXC,
					(int) ((Profiles) P).startYC);
			m.addPoint((int) ((Profiles) P).endXC, (int) ((Profiles) P).endYC);
			m.addPoint((int) ((Profiles) P).endXA, (int) ((Profiles) P).endYA);
			m.addPoint((int) ((Profiles) P).startXA,
					(int) ((Profiles) P).startYA);

			if (m.contains(x, y)) {
				((Profiles) P).poly = m;
				((Profiles) P).profileSelected = 1;
				F.partObjects.add(P);

				myParent.editor.setEditProfileVisible(true, ((Profiles) P));
				myParent.selectedFrame = F;
				myParent.selectedPart = (Profiles) P;
				myParent.editor.selectPart.setVisible(false);

				found = true;

			} else {
				F.partObjects.add(P);
			}
		}
		returns[0] = found;
		returns[1] = F;
		return returns;
	}

	private void removeFrameAction(final int x, final int y) {

		final Object[] frameObjects = myParent.facetUsed.frames.toArray();

		final Object[] frames = frameObjects;

		Object[] parts = null;

		boolean found = false;

		for (final Object F : frames) {

			parts = ((Frame) F).partObjects.toArray();
			((Frame) F).partObjects.clear();
			for (final Object P : parts) {
				final Polygon m = new Polygon();
				m.addPoint((int) ((Profiles) P).startXC,
						(int) ((Profiles) P).startYC);
				m.addPoint((int) ((Profiles) P).endXC,
						(int) ((Profiles) P).endYC);
				m.addPoint((int) ((Profiles) P).endXA,
						(int) ((Profiles) P).endYA);
				m.addPoint((int) ((Profiles) P).startXA,
						(int) ((Profiles) P).startYA);

				if (m.contains(x, y)) {

					if (((Profiles) P).position == 5
							&& ((Frame) F).noSidesBot == 1
							&& ((Profiles) P).leftIn && ((Profiles) P).rightIn) {
						((Profiles) P).poly = m;
						((Profiles) P).profileSelected = 1;
						((Frame) F).partObjects.add(P);

						myParent.selectedFrame = (Frame) F;
						myParent.selectedPart = (Profiles) P;
						myParent.editor.selectPart.setVisible(false);
						found = true;
						myParent.editor.setRemoveVisible(true);
					} else if (((Profiles) P).position == 5
							&& ((Frame) F).noSidesBot == 1
							&& !((Profiles) P).leftIn && ((Profiles) P).rightIn
							&& ((Frame) F).leftPart.endTypeRB == 2) {
						((Profiles) P).poly = m;
						((Profiles) P).profileSelected = 1;
						((Frame) F).partObjects.add(P);

						myParent.selectedFrame = (Frame) F;
						myParent.selectedPart = (Profiles) P;
						myParent.editor.selectPart.setVisible(false);
						found = true;
						myParent.editor.setRemoveVisible(true);
					} else if (((Profiles) P).position == 5
							&& ((Frame) F).noSidesBot == 1
							&& ((Profiles) P).leftIn && !((Profiles) P).rightIn
							&& ((Frame) F).rightPart.endTypeLT == 2) {
						((Profiles) P).poly = m;
						((Profiles) P).profileSelected = 1;
						((Frame) F).partObjects.add(P);

						myParent.selectedFrame = (Frame) F;
						myParent.selectedPart = (Profiles) P;
						myParent.editor.selectPart.setVisible(false);
						found = true;
						myParent.editor.setRemoveVisible(true);
					} else if (((Profiles) P).position == 5
							&& ((Frame) F).noSidesBot == 1
							&& !((Profiles) P).leftIn
							&& !((Profiles) P).rightIn
							&& ((Frame) F).rightPart.endTypeLT == 2
							&& ((Frame) F).leftPart.endTypeRB == 2) {
						((Profiles) P).poly = m;
						((Profiles) P).profileSelected = 1;
						((Frame) F).partObjects.add(P);

						myParent.selectedFrame = (Frame) F;
						myParent.selectedPart = (Profiles) P;
						myParent.editor.selectPart.setVisible(false);
						found = true;
						myParent.editor.setRemoveVisible(true);
					} else

					{
						JOptionPane
								.showMessageDialog(
										this.myParent,
										"Error in Part selection:\n"
												+ "a. Check that the Selected Profile is\n"
												+ "   at the Bottom position of the frame,\n"
												+ "b. Profiles Left and Right of the \n"
												+ "   are Straight Cut.  ",
										"Invalid Part Selected - Warning!",
										JOptionPane.WARNING_MESSAGE);
						((Frame) F).partObjects.add(P);
						myParent.editor.editFrame = false;
						myParent.editor.removeFrame = false;
						myParent.editor.edit.setEnabled(true);
						myParent.editor.removePart.setEnabled(true);
						myParent.editor.cancel.doClick();
					}

				} else {
					((Frame) F).partObjects.add(P);
				}
			}
			if (found) {

				break;
			}
		}
	}

	private void extendAction(final int xxx, final int yyy, final int pos) {

		// TODO Auto-generated method stub

		// if (masterEndRow < slaveStartRow) {
		int type = 0;
		if ((Profiles) myParent.myMaster == null) {

			type = this.getMasterType(xxx, yyy, 1);

			if (type == 0) {
				type = this.getMasterType(xxx, yyy, 2);

			}

		} else {
			type = ((Profiles) myParent.myMaster).cOrM;

		}

		if (type > 0) {
			myParent.alignClicks++;
			if (myParent.alignClicks > 2) {
				myParent.alignClicks = 2;
			}
			final Object[] frameObjects = myParent.facetUsed.frames.toArray();

			if (myParent.dim.masterSelected.isSelected()
					&& myParent.alignClicks == 1) {

				if (type != 0) {
					if (type == 1 && !myParent.foundPotential) {

						this.findPotentialE(myParent.facetUsed,
								((Profiles) myParent.myMaster).orientation);

					}
					if (!myParent.foundPotential) {
						for (final Object F : frameObjects) {
							if (((Profiles) myParent.myMaster).myParent.myParent
									.equals(((ShapeObject) F).bOpeningObject.myParent)) {
								this.findPotentialE(
										(ShapeObject) F,
										((Profiles) myParent.myMaster).orientation);
								if (myParent.foundPotential) {
									break;
								}
							} else if (!myParent.foundPotential) {
								final Object[] openings = ((ShapeObject) F).openings
										.toArray();
								Object[] leafs = null;

								for (final Object O : openings) {

									if (((OpeningObject) O).sashObjectIn != null) {
										leafs = ((OpeningObject) O).sashObjectIn.frames
												.toArray();
										for (final Object S : leafs) {
											if (((Profiles) myParent.myMaster).myParent.myParent
													.equals(S)) {
												this.findPotentialE(
														(ShapeObject) S,
														((Profiles) myParent.myMaster).orientation);
											}
										}

									}// In
										// Sash
									if (!myParent.foundPotential) {

										if (((OpeningObject) O).sashObjectMid != null) {
											leafs = ((OpeningObject) O).sashObjectMid.frames
													.toArray();
											for (final Object S : leafs) {
												if (((Profiles) myParent.myMaster).myParent.myParent
														.equals(S)) {
													this.findPotentialE(
															(ShapeObject) S,
															((Profiles) myParent.myMaster).orientation);
												}
											}
										}// mid
											// Sash
									}
									if (!myParent.foundPotential) {

										if (((OpeningObject) O).sashObjectOut != null) {
											leafs = ((OpeningObject) O).sashObjectOut.frames
													.toArray();
											for (final Object S : leafs) {
												if (((Profiles) myParent.myMaster).myParent.myParent
														.equals(S)) {
													this.findPotentialE(
															(ShapeObject) S,
															((Profiles) myParent.myMaster).orientation);
												}
											}
										}// out
											// Sash
									}
									if (myParent.foundPotential) {
										break;
									}

								}
							}

							//
						}
					}
				}
			} else if (myParent.alignClicks > 1) {
				if (((Profiles) myParent.myMaster).orientation == 1) {
					Collection myVs = new ArrayList();
					myVs = this.getAllVs();
					this.slaveSelectionMethodII(xxx, yyy, myVs, pos);
					this.updateVerticalMC(myVs.toArray());
				} else {

					Collection myHs = new ArrayList();
					myHs = this.getAllHs();
					this.slaveSelectionMethodIIH(xxx, yyy, myHs, pos);
					this.updateHorizontalMC(myHs.toArray());
				}

			}

			if (myParent.dim.slaveSelected.isSelected()) {
				myParent.dim.doAlign.setEnabled(true);
				myParent.dim.changeAlign.setEnabled(true);
			}

		} else {
			JOptionPane.showMessageDialog(this.myParent,
					"Please select Valid Verical.",
					"Invalid Vertical Selected - Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void alignVAction(final int xxx, final int yyy, final int pos) {

		// TODO Auto-generated method stub

		int type = 0;

		if (myParent.alignClicks == 0) {
			myVs = new ArrayList();
			type = this.getMasterType(xxx, yyy, 1);

		} else {
			type = myParent.myMasterType;
		}
		if (type > 0) {
			myParent.alignClicks++;
			if (myParent.alignClicks > 2) {
				myParent.alignClicks = 2;
			}

			myParent.facetUsed.frames.toArray();
			if (myParent.alignClicks == 1) {

				if (type != 0 && masterFound) {

					this.findPotentialS();// ;(ShapeObject)
					// F);
					myParent.alignClicks = 1;
					// }
					if (myParent.jobItem.design.findDLO != null) {
						myParent.jobItem.design.findDLO.findPotentialVGrid(
								(Profiles) myParent.myMaster, pos);
					}
				}
				this.verifyPotentialS(myParent.myMasterType);
			}
			// }

			if (myParent.alignClicks == 2) {

				myVs.addAll(this.getAllVs());

				if (myParent.jobItem.design.findDLO != null) {
					myVs.addAll(myParent.jobItem.design.findDLO
							.getPotenitalVGrid((Profiles) myParent.myMaster,
									pos));
				}

				this.slaveSelectionMethodII(xxx, yyy, myVs, pos);

				this.updateVerticalMC(myVs.toArray());
			}

			if (myParent.alignSeq == 2) {
				myParent.dim.doAlign.setEnabled(true);
				myParent.dim.changeAlign.setEnabled(true);
			}

		} else {
			JOptionPane.showMessageDialog(this.myParent,
					"Please select Valid Verical.",
					"Invalid Vertical Selected - Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public Collection slaveSelectionMethodII(final int xxx, final int yyy,
			final Collection myVs, final int pos) {

		this.doSlaveSelection(xxx, yyy, myVs, pos);

		if (((Profiles) myParent.myMaster).cOrM > 1
				|| ((Profiles) myParent.myMaster).cOrM == 1
				&& !myParent.extendCM) {
			this.verifyPotentialS(myParent.myMasterType);
		}

		return myVs;
	}

	public Collection slaveSelectionMethodIIH(final int xxx, final int yyy,
			final Collection myHs, final int pos) {

		this.doSlaveSelectionIIH(xxx, yyy, myHs, pos);

		if (((Profiles) myParent.myMaster).cOrM > 1
				|| ((Profiles) myParent.myMaster).cOrM == 1
				&& !myParent.extendCM) {
			this.verifyPotentialS(myParent.myMasterType);
		}

		return myHs;
	}

	private void alignHAction(final int xxx, final int yyy, final int pos) {

		int type = 0;

		if (myParent.alignClicks == 0) {
			type = this.getMasterType(xxx, yyy, 2);

		} else {
			type = myParent.myMasterType;
		}
		if (type > 0) {
			myParent.alignClicks++;
			if (myParent.alignClicks > 2) {
				myParent.alignClicks = 2;
			}

			if (myParent.alignClicks == 1) {

				if (type != 0 && masterFound) {

					this.findPotentialSH();// (ShapeObject)

					myParent.alignClicks = 1;

					if (myParent.jobItem.design.findDLO != null) {
						myParent.jobItem.design.findDLO.findPotentialHGrid(
								(Profiles) myParent.myMaster, pos);
					}

				}

				this.verifyPotentialS(myParent.myMasterType);
			}

			if (myParent.alignClicks == 2) {

				final Collection myHs = this.getAllHs();

				if (myParent.jobItem.design.findDLO != null) {
					myHs.addAll(myParent.jobItem.design.findDLO
							.getPotenitalHGrid((Profiles) myParent.myMaster,
									pos));
				}

				this.slaveSelectionMethodIIH(xxx, yyy, myHs, pos);
				this.updateHorizontalMC(myHs.toArray());
			}

			this.verifyPotentialSH(myParent.myMasterType);

			if (myParent.alignSeq == 2) {
				myParent.dim.doAlign.setEnabled(true);
				myParent.dim.changeAlign.setEnabled(true);
			}

		} else {
			JOptionPane.showMessageDialog(this.myParent,
					"Please select Valid Horizontal.",
					"No Valid Horizontal Selected - Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void findCouplerMaster(final int xxx, final int yyy) {

		if (myParent.facetUsed.bOpeningObject.mullions != null
				&& myParent.facetUsed.bOpeningObject.mullions.size() > 0) {

			myParent.facetUsed.bOpeningObject.mullionObjectsV = myParent.facetUsed.bOpeningObject.mullions
					.toArray();

			myParent.facetUsed.bOpeningObject.mullions.clear();
			for (final Object C : myParent.facetUsed.bOpeningObject.mullionObjectsV) {
				if (xxx > ((Profiles) C).x1 && xxx < ((Profiles) C).x3
						&& yyy > ((Profiles) C).y1 && yyy < ((Profiles) C).y3
						&& ((Profiles) C).posCondition != 1) {
					myParent.alignSeq = myParent.alignSeq + 1;

					if (myParent.alignSeq == 1) {
						myParent.dim.masterSelected.setSelected(true);
						myParent.myMaster = C;
						myParent.myMasterType = 1;

						((Profiles) C).profileSelected = myParent.alignSeq;

					}

					myParent.facetUsed.bOpeningObject.mullions.add(C);

				} else {

					if (((Profiles) C).profileSelected != 1) {
						((Profiles) C).profileSelected = 0;
					}
					myParent.facetUsed.bOpeningObject.mullions.add(C);
				}

			}

		}
	}

	private void findCouplerMasterH(final int xxx, final int yyy) {

		if (myParent.facetUsed.bOpeningObject.mullionsH != null
				&& myParent.facetUsed.bOpeningObject.mullionsH.size() > 0) {

			myParent.facetUsed.bOpeningObject.mullionObjectsH = myParent.facetUsed.bOpeningObject.mullionsH
					.toArray();

			myParent.facetUsed.bOpeningObject.mullionsH.clear();
			for (final Object C : myParent.facetUsed.bOpeningObject.mullionObjectsH) {
				if (xxx > ((Profiles) C).x1 && xxx < ((Profiles) C).x3
						&& yyy > ((Profiles) C).y1 && yyy < ((Profiles) C).y3
						&& ((Profiles) C).posCondition != 1) {
					myParent.alignSeq = myParent.alignSeq + 1;

					if (myParent.alignSeq == 1) {
						myParent.dim.masterSelected.setSelected(true);
						myParent.myMaster = C;
						myParent.myMasterType = 1;

						((Profiles) C).profileSelected = myParent.alignSeq;

					}

					myParent.facetUsed.bOpeningObject.mullionsH.add(C);

				} else {

					if (((Profiles) C).profileSelected != 1) {
						((Profiles) C).profileSelected = 0;
					}
					myParent.facetUsed.bOpeningObject.mullionsH.add(C);
				}

			}

		}
	}

	private void findSelectedSash(final int xxx, final int yyy) {

		boolean found = false;
		final Object[] frameObjects = myParent.facetUsed.frames.toArray();
		for (final Object F : frameObjects) {

			final Object[] openings = ((ShapeObject) F).openings.toArray();

			if (found) {
				break;
			}

			for (final Object O : openings) {
				if (Math.min(((OpeningObject) O).startingX,
						((OpeningObject) O).bX4) < xxx
						&& Math.max(((OpeningObject) O).bX2,
								((OpeningObject) O).bX3) > xxx
						&& ((OpeningObject) O).highestY < yyy
						&& Math.max(((OpeningObject) O).bY4,
								((OpeningObject) O).bY3) > yyy) {
					if (((OpeningObject) O).subFacet == null) {
						if (myParent.selectedPos == 1) {
							if (((OpeningObject) O).sashObjectIn != null) {
								myParent.mySelectedSash = ((OpeningObject) O).sashObjectIn;
								found = true;
								break;
							}
						} else if (myParent.selectedPos == 2) {
							if (((OpeningObject) O).sashObjectMid != null) {
								myParent.mySelectedSash = ((OpeningObject) O).sashObjectMid;
								found = true;
								break;
							}
						} else {
							if (((OpeningObject) O).sashObjectOut != null) {
								myParent.mySelectedSash = ((OpeningObject) O).sashObjectOut;
								found = true;
								break;
							}
						}
					} else {
						final Object[] framesS = ((OpeningObject) O).subFacet.frames
								.toArray();
						for (final Object sF : framesS) {
							final Object[] openingsS = ((ShapeObject) sF).openings
									.toArray();

							if (found) {
								break;
							}
							for (final Object sO : openingsS) {
								if (Math.min(((OpeningObject) sO).startingX,
										((OpeningObject) sO).bX4) < xxx
										&& Math.max(((OpeningObject) sO).bX2,
												((OpeningObject) sO).bX3) > xxx
										&& ((OpeningObject) sO).highestY < yyy
										&& Math.max(((OpeningObject) sO).bY4,
												((OpeningObject) sO).bY3) > yyy) {

									if (myParent.selectedPos == 1) {
										if (((OpeningObject) sO).sashObjectIn != null) {
											myParent.mySelectedSash = ((OpeningObject) sO).sashObjectIn;
											found = true;
											break;
										}
									} else if (myParent.selectedPos == 2) {
										if (((OpeningObject) sO).sashObjectMid != null) {
											myParent.mySelectedSash = ((OpeningObject) sO).sashObjectMid;
											found = true;
											break;
										}
									} else {
										if (((OpeningObject) sO).sashObjectOut != null) {
											myParent.mySelectedSash = ((OpeningObject) sO).sashObjectOut;
											found = true;
											break;
										}
									}
								}
							}

						}
					}
				}
			}
		}

		if (!found) {
			JOptionPane.showMessageDialog(this.myParent,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		} else {

			myParent.dim.guidePanel.setVisible(false);
			myParent.dim.setDimsActive(true);

		}
	}

	private void findEditingMullion(final int xxx, final int yyy) {

		final Object[] frameObjects = myParent.facetUsed.frames.toArray();

		boolean found = false;
		found = lookForVMullionInFrame(frameObjects, xxx, yyy, found);

		if (!found) {
			found = lookForHMullionInFrame(frameObjects, xxx, yyy, found);
		}// look for H Mullion
		if (!found) {// look in Sash

			for (final Object F : frameObjects) {

				final Object[] openings = ((ShapeObject) F).openings.toArray();
				for (final Object O : openings) {
					if (myParent.facetUsed.a_levelID == 1) {
						found = lookForMullionsInSash(xxx, yyy, found, O);
					} else if (myParent.facetUsed.a_levelID == 101) { // Sub
						// Frame
						// TRUE

						final Object[] sFrames = myParent.facetUsed.frames
								.toArray();
						found = lookForVMullionInFrame(sFrames, xxx, yyy, found);

						if (!found) {
							found = lookForHMullionInFrame(sFrames, xxx, yyy,
									found);
						}// look
							// for H Mullion
						if (!found) {// look
							// in Sash

							for (final Object sF : sFrames) {

								final Object[] openingsS = ((ShapeObject) sF).openings
										.toArray();
								for (final Object sO : openingsS) {

									found = lookForMullionsInSash(xxx, yyy,
											found, sO);

								}// ////
							}

						}// look
							// in sash Sub Frame

					}
				}// ////
			}
		}

	}

	public boolean lookForVMullionInFrame(final Object[] myFrames,
			final int xxx, final int yyy, boolean found) {

		for (final Object F : myFrames) {
			if (((ShapeObject) F).bOpeningObject.mullions != null
					&& ((ShapeObject) F).bOpeningObject.mullions.size() > 0) {

				final Object[] mVs = ((ShapeObject) F).bOpeningObject.mullions
						.toArray();

				((ShapeObject) F).bOpeningObject.mullions.clear();
				for (final Object M : mVs) {
					if (xxx > ((Profiles) M).x1al && xxx < ((Profiles) M).x3cl
							&& yyy > ((Profiles) M).y1al
							&& yyy < ((Profiles) M).y3cl) {
						myParent.mySelectedFrame = (Frame) F;
						mySelectedFrame = (Frame) F;

						myParent.editingMullion = (Profiles) M;

						myParent.HorV = 1;

						((Profiles) M).profileSelected = 1;

						((ShapeObject) F).bOpeningObject.mullions.add(M);

						found = true;

					} else {
						((ShapeObject) F).bOpeningObject.mullions.add(M);
					}

				}

			}

		}
		return found;
	}

	public boolean lookForHMullionInFrame(final Object[] myFrames,
			final int xxx, final int yyy, boolean found) {

		for (final Object F : myFrames) {
			if (((ShapeObject) F).bOpeningObject.mullionsH != null
					&& ((ShapeObject) F).bOpeningObject.mullionsH.size() > 0) {

				final Object[] mHs = ((ShapeObject) F).bOpeningObject.mullionsH
						.toArray();

				((ShapeObject) F).bOpeningObject.mullionsH.clear();
				for (final Object M : mHs) {
					if (xxx > ((Profiles) M).x1al && xxx < ((Profiles) M).x3cl
							&& yyy < ((Profiles) M).y1al
							&& yyy > ((Profiles) M).y3cl) {
						((Profiles) M).profileSelected = 1;
						myParent.editingMullion = (Profiles) M;
						myParent.HorV = 2;

						((ShapeObject) F).bOpeningObject.mullionsH.add(M);
						found = true;

					} else {
						((ShapeObject) F).bOpeningObject.mullionsH.add(M);
					}

				}

			}

		}
		return found;
	}

	public boolean lookForMullionsInSash(final int xxx, final int yyy,
			boolean found, final Object O) {

		Object[] leafs;
		if (((OpeningObject) O).sashObjectIn != null) {
			leafs = ((OpeningObject) O).sashObjectIn.frames.toArray();
			if (!found) {
				found = this.getEditSashMullionV(xxx, yyy, found, leafs);
				if (!found) {
					found = this.getEditSashMullionH(xxx, yyy, found, leafs);
				}
			} else {
				// break;
			}

		}// In Sash
		if (!found) {

			if (((OpeningObject) O).sashObjectMid != null) {
				leafs = ((OpeningObject) O).sashObjectMid.frames.toArray();
				if (!found) {
					found = this.getEditSashMullionV(xxx, yyy, found, leafs);
					if (!found) {
						found = this
								.getEditSashMullionH(xxx, yyy, found, leafs);
					}
				} else {
					// break;
				}

			}// In
				// Sash
		}
		if (!found) {

			if (((OpeningObject) O).sashObjectOut != null) {
				leafs = ((OpeningObject) O).sashObjectOut.frames.toArray();
				if (!found) {
					found = this.getEditSashMullionV(xxx, yyy, found, leafs);
					if (!found) {
						found = this
								.getEditSashMullionH(xxx, yyy, found, leafs);
					}
				} else {
					// break;
				}

			}
		}
		return found;
	}

	public boolean getEditSashMullionV(final int xxx, final int yyy,
			boolean found, final Object[] leafs) {

		for (final Object S : leafs) {
			if (!found) {
				final Object[] MVs = ((SashLeaf) S).bOpeningObject.mullions
						.toArray();
				((SashLeaf) S).bOpeningObject.mullions.clear();
				for (final Object MV : MVs) {
					if (xxx > ((Profiles) MV).x1al
							&& xxx < ((Profiles) MV).x3cl
							&& yyy > ((Profiles) MV).y1al
							&& yyy < ((Profiles) MV).y3cl) {

						myParent.editingMullion = (Profiles) MV;
						myParent.HorV = 1;

						((Profiles) MV).profileSelected = 1;

						((SashLeaf) S).bOpeningObject.mullions.add(MV);
						myParent.mullionsPanel.isSashMullion = true;
						found = true;

					} else {
						((SashLeaf) S).bOpeningObject.mullions.add(MV);
					}
				}
			} else {
				break;
			}
		}
		return found;
	}

	public boolean getEditSashMullionH(final int xxx, final int yyy,
			boolean found, final Object[] leafs) {

		for (final Object S : leafs) {
			if (!found) {
				final Object[] MVs = ((SashLeaf) S).bOpeningObject.mullionsH
						.toArray();
				((SashLeaf) S).bOpeningObject.mullionsH.clear();
				for (final Object MV : MVs) {
					if (xxx > ((Profiles) MV).x1al
							&& xxx < ((Profiles) MV).x3cl
							&& yyy < ((Profiles) MV).y1al
							&& yyy > ((Profiles) MV).y3cl) {

						myParent.editingMullion = (Profiles) MV;
						myParent.HorV = 2;

						((Profiles) MV).profileSelected = 1;
						myParent.mullionsPanel.isSashMullion = true;
						((SashLeaf) S).bOpeningObject.mullionsH.add(MV);
						found = true;

					} else {
						((SashLeaf) S).bOpeningObject.mullionsH.add(MV);
					}
				}
			} else {
				break;
			}
		}
		return found;
	}

	private void findEditingCoupler(final int xxx, final int yyy) {

		boolean found = false;
		if (myParent.facetUsed.bOpeningObject.mullions != null
				&& myParent.facetUsed.bOpeningObject.mullions.size() > 0) {

			myParent.facetUsed.bOpeningObject.mullionObjectsV = myParent.facetUsed.bOpeningObject.mullions
					.toArray();

			myParent.facetUsed.bOpeningObject.mullions.clear();
			for (final Object C : myParent.facetUsed.bOpeningObject.mullionObjectsV) {
				if (xxx > ((Profiles) C).x1 && xxx < ((Profiles) C).x3
						&& yyy > ((Profiles) C).y1 && yyy < ((Profiles) C).y3
						&& ((Profiles) C).posCondition != 1) {
					((Profiles) C).profileSelected = 1;
					myParent.HorV = 1;
					myParent.editingCoupler = (Profiles) C;

					found = true;
					myParent.facetUsed.bOpeningObject.mullions.add(C);

				} else {

					myParent.facetUsed.bOpeningObject.mullions.add(C);
				}

			}

		}
		if (!found) {
			if (myParent.facetUsed.bOpeningObject.mullionsH != null
					&& myParent.facetUsed.bOpeningObject.mullionsH.size() > 0) {

				myParent.facetUsed.bOpeningObject.mullionObjectsH = myParent.facetUsed.bOpeningObject.mullionsH
						.toArray();

				myParent.facetUsed.bOpeningObject.mullionsH.clear();
				for (final Object C : myParent.facetUsed.bOpeningObject.mullionObjectsH) {
					if (xxx > ((Profiles) C).x1 && xxx < ((Profiles) C).x3
							&& yyy > ((Profiles) C).y1
							&& yyy < ((Profiles) C).y3
							&& ((Profiles) C).posCondition != 1) {
						((Profiles) C).profileSelected = 1;
						myParent.HorV = 2;
						myParent.editingCoupler = (Profiles) C;
						found = true;
						myParent.facetUsed.bOpeningObject.mullionsH.add(C);

					} else {
						myParent.facetUsed.bOpeningObject.mullionsH.add(C);
					}

				}

			}
		}
	}

	public int getMasterType(final int xxx, final int yyy, final int V) {

		int type = 0;
		final Object[] facets = myParent.jobItem.design.frames.toArray();

		for (final Object facet : facets) {

			final Object[] frameObjects = ((Facet) facet).frames.toArray();

			if (V == 1) {
				type = this.checkMasterCouplers(xxx, yyy, type, (Facet) facet);

				if (!masterFound) {
					for (final Object F : frameObjects) {

						if (type == 0) {

							type = this.getMasterTypeMV(xxx, yyy, type, F, 1);
						}
						if (type == 0) {
							type = this
									.checkMasterInOpenings(xxx, yyy, type, F);

						}
						if (type == 0) {
							type = this.checkMasterInGrids(xxx, yyy, type,
									myParent.gridsPanel.form);
							if (type != 0
									&& myParent.jobItem.design.findDLO.selectedDLO != null) {
								this.masterFound = true;
							}
						}
						if (type != 0) {
							break;
						}

					}
				}
			} else {

				type = this.checkMasterCouplersH(xxx, yyy, type, (Facet) facet);

				if (!masterFound) {

					for (final Object F : frameObjects) {

						if (type == 0) {
							type = this.getMasterTypeMH(xxx, yyy, type, F, 1);
						}
						if (type == 0) {
							type = this.checkMasterInOpeningsH(xxx, yyy, type,
									F);

						}
						if (type == 0) {
							type = this.checkMasterInGridsH(xxx, yyy, type,
									myParent.gridsPanel.form);
							if (type > 0) {
								this.masterFound = true;
							}
						}
						if (type != 0) {
							break;
						}

					}
				}
			}
		}

		return type;
	}

	public int checkMasterInGrids(final int xxx, final int yyy, final int type,
			final int form) {

		if (myParent.hasGrids) {
			if (myParent.jobItem.design.findDLO != null) {

				myParent.jobItem.design.findDLO.initMasterChange(xxx, yyy, 5,
						2, form);

			}
		}

		return myParent.myMasterType;
	}

	public int checkMasterInGridsH(final int xxx, final int yyy,
			final int type, final int form) {

		if (myParent.hasGrids) {
			if (myParent.jobItem.design.findDLO != null) {
				myParent.jobItem.design.findDLO.initMasterChange(xxx, yyy, 6,
						2, form);
			}
		}

		return myParent.myMasterType;
	}

	public int checkMasterInOpenings(final int xxx, final int yyy, int type,
			final Object F) {

		final Object[] openings = ((ShapeObject) F).openings.toArray();
		((ShapeObject) F).openings.clear();
		Object[] leafs = null;

		for (final Object O : openings) {

			if (type == 0 && ((OpeningObject) O).sashObjectIn != null) {
				leafs = ((OpeningObject) O).sashObjectIn.frames.toArray();
				for (final Object S : leafs) {
					type = this.getMasterTypeMV(xxx, yyy, type, S, 2);
				}

				if (type == 0
						&& ((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
					type = this.getMasterTypeMV(xxx, yyy, type,
							((OpeningObject) O).sashObjectIn, 2);
				}
			}
			if (type == 0 && ((OpeningObject) O).sashObjectMid != null) {
				if (type == 0
						&& ((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
					type = this.getMasterTypeMV(xxx, yyy, type,
							((OpeningObject) O).sashObjectMid, 2);
				}

				if (type == 0) {

					leafs = ((OpeningObject) O).sashObjectMid.frames.toArray();
					for (final Object S : leafs) {
						type = this.getMasterTypeMV(xxx, yyy, type, S, 2);
					}
					if (type == 0
							&& ((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
						type = this.getMasterTypeMV(xxx, yyy, type,
								((OpeningObject) O).sashObjectMid, 2);
					}
				}
			}
			if (type == 0 && ((OpeningObject) O).sashObjectOut != null) {
				leafs = ((OpeningObject) O).sashObjectOut.frames.toArray();
				for (final Object S : leafs) {
					type = this.getMasterTypeMV(xxx, yyy, type, S, 2);
				}
				if (type == 0
						&& ((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
					type = this.getMasterTypeMV(xxx, yyy, type,
							((OpeningObject) O).sashObjectOut, 2);
				}
			}
			((ShapeObject) F).openings.add(O);
		}

		return type;
	}

	public int checkMasterInOpeningsH(final int xxx, final int yyy, int type,
			final Object F) {

		final Object[] openings = ((ShapeObject) F).openings.toArray();
		((ShapeObject) F).openings.clear();
		Object[] leafs = null;

		for (final Object O : openings) {

			if (type == 0 && ((OpeningObject) O).sashObjectIn != null) {
				leafs = ((OpeningObject) O).sashObjectIn.frames.toArray();
				for (final Object S : leafs) {
					type = this.getMasterTypeMH(xxx, yyy, type, S, 2);
				}

				if (type == 0
						&& ((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
					type = this.getMasterTypeMH(xxx, yyy, type,
							((OpeningObject) O).sashObjectIn, 2);
				}
			}
			if (type == 0 && ((OpeningObject) O).sashObjectMid != null) {
				leafs = ((OpeningObject) O).sashObjectMid.frames.toArray();
				for (final Object S : leafs) {
					type = this.getMasterTypeMH(xxx, yyy, type, S, 2);
				}
				if (type == 0
						& ((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
					type = this.getMasterTypeMH(xxx, yyy, type,
							((OpeningObject) O).sashObjectMid, 2);
				}
			}
			if (type == 0 && ((OpeningObject) O).sashObjectOut != null) {
				leafs = ((OpeningObject) O).sashObjectOut.frames.toArray();
				for (final Object S : leafs) {
					type = this.getMasterTypeMH(xxx, yyy, type, S, 2);
				}
				if (type == 0
						& ((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
					type = this.getMasterTypeMH(xxx, yyy, type,
							((OpeningObject) O).sashObjectOut, 2);
				}
			}
			((ShapeObject) F).openings.add(O);
		}

		return type;
	}

	public int checkMasterCouplers(final int xxx, final int yyy, int type,
			final Facet myFacet) {

		final Object[] mVs = myFacet.bOpeningObject.mullions.toArray();
		myFacet.bOpeningObject.mullions.clear();
		for (final Object C : mVs) {
			if (xxx > ((Profiles) C).x1 - 5 && xxx < ((Profiles) C).x3 + 5
					&& yyy > ((Profiles) C).y1 && yyy < ((Profiles) C).y3
			// && (((Profiles) C).posCondition != 1)
			) {
				type = 1;
				((Profiles) C).profileSelected = 1;

				myParent.alignSeq = 1;

				myParent.dim.masterSelected.setSelected(true);

				myParent.myMaster = C;

				myParent.myMasterType = type;
				masterFound = true;
				myParent.editor.selectedEditLevel = 0;

			}
			myFacet.bOpeningObject.mullions.add(C);
		}

		return type;
	}

	public int checkMasterCouplersH(final int xxx, final int yyy, int type,
			final Facet myFacet) {

		final Object[] mHs = myFacet.bOpeningObject.mullionsH.toArray();
		myFacet.bOpeningObject.mullionsH.clear();
		for (final Object C : mHs) {
			if (xxx > ((Profiles) C).x1 && xxx < ((Profiles) C).x3
					&& yyy < ((Profiles) C).y1 + 5
					&& yyy > ((Profiles) C).y3 - 5
			// && (((Profiles) C).posCondition != 1)
			) {
				type = 1;
				((Profiles) C).profileSelected = 1;

				myParent.alignSeq = 1;

				myParent.dim.masterSelected.setSelected(true);

				myParent.myMaster = C;

				myParent.myMasterType = type;
				masterFound = true;
				myParent.editor.selectedEditLevel = 0;

			}
			myFacet.bOpeningObject.mullionsH.add(C);
		}

		return type;
	}

	public int getMasterTypeMV(final int xxx, final int yyy, int type,
			final Object F, final int level) {

		if (((ShapeObject) F).bOpeningObject.mullions != null
				&& ((ShapeObject) F).bOpeningObject.mullions.size() > 0) {
			((ShapeObject) F).bOpeningObject.mullionObjectsV = ((ShapeObject) F).bOpeningObject.mullions
					.toArray();
			((ShapeObject) F).bOpeningObject.mullions.clear();
			for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsV) {
				if (((Profiles) M).poly.contains(xxx, yyy)) {
					type = ((Profiles) M).cOrM;

					((Profiles) M).profileSelected = 1;

					myParent.alignSeq = 1;

					myParent.dim.masterSelected.setSelected(true);

					myParent.myMaster = M;

					myParent.myMasterType = type;
					masterFound = true;
					// myParent.selectedEditLevel =
					// level;

				}
				((ShapeObject) F).bOpeningObject.mullions.add(M);
			}

		}
		return type;
	}

	public int getMasterTypeMH(final int xxx, final int yyy, int type,
			final Object F, final int level) {

		if (((ShapeObject) F).bOpeningObject.mullionsH != null
				&& ((ShapeObject) F).bOpeningObject.mullionsH.size() > 0) {
			((ShapeObject) F).bOpeningObject.mullionObjectsH = ((ShapeObject) F).bOpeningObject.mullionsH
					.toArray();
			((ShapeObject) F).bOpeningObject.mullionsH.clear();
			for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsH) {
				if (((Profiles) M).poly.contains(xxx, yyy)) {
					type = ((Profiles) M).cOrM;

					((Profiles) M).profileSelected = 1;

					myParent.alignSeq = 1;

					myParent.dim.masterSelected.setSelected(true);

					myParent.myMaster = M;

					myParent.myMasterType = type;
					masterFound = true;

				}
				((ShapeObject) F).bOpeningObject.mullionsH.add(M);
			}

		}
		return type;
	}

	public int getMasterTypeMH(final int xxx, final int yyy, int type,
			final Object F) {

		if (((ShapeObject) F).bOpeningObject.mullionsH != null
				&& ((ShapeObject) F).bOpeningObject.mullionsH.size() > 0) {
			((ShapeObject) F).bOpeningObject.mullionObjectsH = ((ShapeObject) F).bOpeningObject.mullionsH
					.toArray();

			for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsH) {
				if (xxx > ((Profiles) M).x1al && xxx < ((Profiles) M).x3cl
						&& yyy < ((Profiles) M).y1al
						&& yyy > ((Profiles) M).y3cl) {
					type = ((Profiles) M).cOrM;
				}
			}
		}
		return type;
	}

	private Collection doSlaveSelection(final int xxx, final int yyy,
			final Collection myVs, final int pos) {

		myParent.facetUsed.myLine.reset();

		for (final Object M : myVs) {
			if (((Profiles) M).poly.contains(xxx, yyy) && !myParent.extendCM) {
				myParent.alignSeq = 2;
				myParent.dim.slaveSelected.setSelected(true);
				if (myParent.myMasterType >= 2 && myParent.myMasterType <= 7) {

					myParent.mySlave = M;
					myParent.mySlaveType = ((Profiles) M).cOrM;

					if (((Profiles) M).myParent.myParent == null) {
						myParent.mySlaveFrame = ((Profiles) M).myParent.a_sequenceID;
						myParent.slave = ((Profiles) M).myParent;
					} else {
						myParent.mySlaveFrame = ((Profiles) M).myParent.a_sequenceID;
						myParent.slave = ((Profiles) M).myParent.myParent;
					}

					((Profiles) M).profileSelected = myParent.alignSeq;

					if (((Profiles) M).centerYs > ((Profiles) myParent.myMaster).centerYe) {

						myParent.facetUsed.myLine.reset();
						myParent.facetUsed.myLine.moveTo(
								((Profiles) myParent.myMaster).centerXs,
								((Profiles) myParent.myMaster).centerYs);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) myParent.myMaster).centerXe,
										((Profiles) myParent.myMaster).centerYe
												+ (((Profiles) M).centerYs - ((Profiles) myParent.myMaster).centerYe)
												/ 2);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) M).centerXs,
										((Profiles) myParent.myMaster).centerYe
												+ (((Profiles) M).centerYs - ((Profiles) myParent.myMaster).centerYe)
												/ 2);
						myParent.facetUsed.myLine.lineTo(
								((Profiles) M).centerXs,
								((Profiles) M).centerYs);
						myParent.masterAboveLeft = true;

					} else if (((Profiles) M).centerYe < ((Profiles) myParent.myMaster).centerYs) {

						myParent.facetUsed.myLine.reset();
						myParent.facetUsed.myLine.moveTo(
								((Profiles) myParent.myMaster).centerXe,
								((Profiles) myParent.myMaster).centerYe);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) myParent.myMaster).centerXs,
										((Profiles) myParent.myMaster).centerYs
												+ (((Profiles) M).centerYe - ((Profiles) myParent.myMaster).centerYs)
												/ 2);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) M).centerXe,
										((Profiles) myParent.myMaster).centerYs
												+ (((Profiles) M).centerYe - ((Profiles) myParent.myMaster).centerYs)
												/ 2);
						myParent.facetUsed.myLine.lineTo(
								((Profiles) M).centerXe,
								((Profiles) M).centerYe);
						myParent.masterAboveLeft = false;

					}

				} else if (myParent.myMasterType == 1) {
					if (((Profiles) M).centerYs > ((Profiles) myParent.myMaster).centerYe
							|| ((Profiles) M).centerYe < ((Profiles) myParent.myMaster).centerYs) {
						boolean closest = false;

						if (((Profiles) M).myParent.myParent != null) {
							closest = this.closestVM(
									((Profiles) M).myParent.myParent, //
									((Profiles) myParent.myMaster).centerXs, //
									((Profiles) M).centerXs, true);
						} else {
							closest = closestVM(((Profiles) M).myParent, //
									((Profiles) myParent.myMaster).centerXs, //
									((Profiles) M).centerXs, true);
						}

						if (closest && ((Profiles) M).exists == 1) {

							myParent.mySlave = M;
							myParent.mySlaveType = ((Profiles) M).cOrM;

							myParent.mySlaveFrame = ((Profiles) M).myParent.a_sequenceID;
							myParent.slave = ((Profiles) M).myParent.myParent;
							((Profiles) M).profileSelected = 2;
							// ((ShapeObject)
							// F).bOpeningObject.mullions
							// .add(M);

							if (((Profiles) M).centerYs > ((Profiles) myParent.myMaster).centerYe) {

								myParent.facetUsed.myLine.reset();
								myParent.facetUsed.myLine
										.moveTo(((Profiles) myParent.myMaster).centerXs,
												((Profiles) myParent.myMaster).centerYs);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) myParent.myMaster).centerXe,
												((Profiles) myParent.myMaster).centerYe
														+ (((Profiles) M).centerYs - ((Profiles) myParent.myMaster).centerYe)
														/ 2);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) M).centerXs,
												((Profiles) myParent.myMaster).centerYe
														+ (((Profiles) M).centerYs - ((Profiles) myParent.myMaster).centerYe)
														/ 2);
								myParent.facetUsed.myLine.lineTo(
										((Profiles) M).centerXs,
										((Profiles) M).centerYs);
								myParent.masterAboveLeft = true;

							} else if (((Profiles) M).centerYe < ((Profiles) myParent.myMaster).centerYs) {

								myParent.facetUsed.myLine.reset();
								myParent.facetUsed.myLine
										.moveTo(((Profiles) myParent.myMaster).centerXe,
												((Profiles) myParent.myMaster).centerYe);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) myParent.myMaster).centerXs,
												((Profiles) myParent.myMaster).centerYs
														+ (((Profiles) M).centerYe - ((Profiles) myParent.myMaster).centerYs)
														/ 2);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) M).centerXe,
												((Profiles) myParent.myMaster).centerYs
														+ (((Profiles) M).centerYe - ((Profiles) myParent.myMaster).centerYs)
														/ 2);
								myParent.facetUsed.myLine.lineTo(
										((Profiles) M).centerXe,
										((Profiles) M).centerYe);
								myParent.masterAboveLeft = false;

							}

						}

					} else {
						myParent.alignSeq = 1;
						JOptionPane.showMessageDialog(this.myParent,
								"Vertical Slave must be Above or Below Master Coupler!\n"
										+ "Please Change Selection.",
								"Invalid Slave - Error!",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			} else if (((Profiles) M).poly.contains(xxx, yyy)
					&& myParent.extendCM) {
				myParent.alignSeq = 2;
				myParent.dim.slaveSelected.setSelected(true);
				myParent.mySlave = M;

				myParent.mySlaveType = ((Profiles) M).cOrM;
				((Profiles) M).profileSelected = 2;
				break;
			} else if (xxx > ((Profiles) M).x1al && xxx < ((Profiles) M).x3cl
					&& yyy > ((Profiles) M).y1al && yyy < ((Profiles) M).y3cl
					&& !((Profiles) M).potentialS
					&& ((Profiles) M).profileSelected == 0
					&& myParent.alignSeq == 2) {
				myParent.alignSeq = 1;
				JOptionPane.showMessageDialog(this.myParent,
						"An Invalid Vertical Slave Mullion Selected!\n"
								+ "Please Change Selection.",
						"Invalid Slave - Error!", JOptionPane.ERROR_MESSAGE);
			}
			//

		}// for MullionV loop

		if (!myParent.dim.slaveSelected.isSelected()) {

			if (myParent.jobItem.design.findDLO != null) {
				myParent.jobItem.design.findDLO.getSelectedVGrid(xxx, yyy, pos);
			}
		}

		return myVs;

	}

	private Collection doSlaveSelectionIIH(final int xxx, final int yyy,
			final Collection myHs, final int pos) {

		myParent.facetUsed.myLine.reset();

		for (final Object M : myHs) {// HERE
			if (((Profiles) M).poly.contains(xxx, yyy) && !myParent.extendCM)// &&
			// ((Profiles)
			// M).cOrM
			// !=
			// 7)
			{
				myParent.alignSeq = 2;
				myParent.dim.slaveSelected.setSelected(true);
				if (myParent.myMasterType >= 2 && myParent.myMasterType <= 7) {

					myParent.mySlave = M;
					myParent.mySlaveType = ((Profiles) M).cOrM;

					if (((Profiles) M).myParent.myParent != null) {
						myParent.mySlaveFrame = ((Profiles) M).myParent.a_sequenceID;
						myParent.slave = ((Profiles) M).myParent.myParent;
					} else {
						myParent.mySlaveFrame = ((Profiles) M).myParent.a_sequenceID;
						myParent.slave = ((Profiles) M).myParent;
					}

					((Profiles) M).profileSelected = myParent.alignSeq;

					if (((Profiles) M).centerXs > ((Profiles) myParent.myMaster).centerXe) {

						myParent.facetUsed.myLine.reset();
						myParent.facetUsed.myLine.moveTo(
								((Profiles) myParent.myMaster).centerXs,
								((Profiles) myParent.myMaster).centerYs);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) myParent.myMaster).centerXe
										+ (((Profiles) M).centerXs - ((Profiles) myParent.myMaster).centerXe)
										/ 2,
										((Profiles) myParent.myMaster).centerYe);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) myParent.myMaster).centerXe
										+ (((Profiles) M).centerXs - ((Profiles) myParent.myMaster).centerXe)
										/ 2, ((Profiles) M).centerYs);
						myParent.facetUsed.myLine.lineTo(
								((Profiles) M).centerXs,
								((Profiles) M).centerYs);
						myParent.masterAboveLeft = true;

					} else if (((Profiles) M).centerXe < ((Profiles) myParent.myMaster).centerXs) {

						myParent.facetUsed.myLine.reset();
						myParent.facetUsed.myLine.moveTo(
								((Profiles) M).centerXe,
								((Profiles) M).centerYe);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) M).centerXe
										+ Math.abs(((Profiles) M).centerXe
												- ((Profiles) myParent.myMaster).centerXs)
										/ 2, ((Profiles) M).centerYe);
						myParent.facetUsed.myLine
								.lineTo(((Profiles) M).centerXe
										+ Math.abs(((Profiles) M).centerXe
												- ((Profiles) myParent.myMaster).centerXs)
										/ 2,
										((Profiles) myParent.myMaster).centerYs);
						myParent.facetUsed.myLine.lineTo(
								((Profiles) myParent.myMaster).centerXe,
								((Profiles) myParent.myMaster).centerYe);
						myParent.masterAboveLeft = false;

					}

				} else if (myParent.myMasterType == 1) {
					if (((Profiles) M).centerXs > ((Profiles) myParent.myMaster).centerXe
							|| ((Profiles) M).centerXe < ((Profiles) myParent.myMaster).centerXs) {

						boolean closest = false;

						if (((Profiles) M).myParent.myParent != null) {
							closest = closestVM(
									((Profiles) M).myParent.myParent, //
									((Profiles) myParent.myMaster).centerXs, //
									((Profiles) M).centerXs, true);
						} else {
							closest = closestVM(((Profiles) M).myParent, //
									((Profiles) myParent.myMaster).centerXs, //
									((Profiles) M).centerXs, true);
						}

						if (closest && ((Profiles) M).exists == 1) {
							myParent.dim.slaveSelected.setSelected(true);
							myParent.mySlave = M;
							myParent.mySlaveType = 2;
							((Profiles) M).profileSelected = myParent.alignSeq;

							if (((Profiles) M).centerXs > ((Profiles) myParent.myMaster).centerXe) {

								myParent.facetUsed.myLine.reset();
								myParent.facetUsed.myLine
										.moveTo(((Profiles) myParent.myMaster).centerXs,
												((Profiles) myParent.myMaster).centerYs);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) myParent.myMaster).centerXe
												+ (((Profiles) M).centerXs - ((Profiles) myParent.myMaster).centerXe)
												/ 2,
												((Profiles) myParent.myMaster).centerYe);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) myParent.myMaster).centerXe
												+ (((Profiles) M).centerXs - ((Profiles) myParent.myMaster).centerXe)
												/ 2, ((Profiles) M).centerYs);
								myParent.facetUsed.myLine.lineTo(
										((Profiles) M).centerXs,
										((Profiles) M).centerYs);
								myParent.masterAboveLeft = true;

							} else if (((Profiles) M).centerXe < ((Profiles) myParent.myMaster).centerXs) {

								myParent.facetUsed.myLine.reset();
								myParent.facetUsed.myLine.moveTo(
										((Profiles) M).centerXe,
										((Profiles) M).centerYe);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) M).centerXe
												+ Math.abs(((Profiles) M).centerXe
														- ((Profiles) myParent.myMaster).centerXs)
												/ 2, ((Profiles) M).centerYe);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) M).centerXe
												+ Math.abs(((Profiles) M).centerXe
														- ((Profiles) myParent.myMaster).centerXs)
												/ 2,
												((Profiles) myParent.myMaster).centerYs);
								myParent.facetUsed.myLine
										.lineTo(((Profiles) myParent.myMaster).centerXe,
												((Profiles) myParent.myMaster).centerYe);
								myParent.masterAboveLeft = false;

							}

						}

					} else {
						myParent.alignSeq = 1;
						JOptionPane.showMessageDialog(this.myParent,
								"Vertical Slave must be Above or Below Master Coupler!\n"
										+ "Please Change Selection.",
								"Invalid Slave - Error!",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			} else if (((Profiles) M).poly.contains(xxx, yyy)
					&& myParent.extendCM) {

				myParent.alignSeq = 2;
				myParent.dim.slaveSelected.setSelected(true);
				myParent.mySlave = M;
				myParent.mySlaveType = 1;
				((Profiles) M).profileSelected = 2;
				// }
			} else if (xxx > ((Profiles) M).x1al && xxx < ((Profiles) M).x3cl
					&& yyy < ((Profiles) M).y1al && yyy > ((Profiles) M).y3cl
					&& !((Profiles) M).potentialS
					&& ((Profiles) M).profileSelected == 0
					&& myParent.alignSeq == 2) {
				myParent.alignSeq = 1;
				JOptionPane.showMessageDialog(this.myParent,
						"An Invalid H. Slave Selected!\n"
								+ "Please Change Selection.",
						"Invalid Slave - Error!", JOptionPane.ERROR_MESSAGE);
			}
			//

		}// for MullionV loop

		if (!myParent.dim.slaveSelected.isSelected()
				&& myParent.jobItem.design.findDLO != null) {
			myParent.jobItem.design.findDLO.getSelectedHGrid(xxx, yyy, pos);
		}

		return myHs;

	}

	private void findPotentialE(final ShapeObject F, final int orientation) {

		final Profiles myMaster = (Profiles) myParent.myMaster;

		if (orientation == 1) {
			if (F.bOpeningObject.mullions != null
					&& F.bOpeningObject.mullions.size() > 0) {

				F.bOpeningObject.mullionObjectsV = F.bOpeningObject.mullions
						.toArray();
				F.bOpeningObject.mullions.clear();

				// if (((ShapeObject) F)
				// .equals(((Profiles)
				// this.myParent.myMaster).myParent))
				// {
				for (final Object M : F.bOpeningObject.mullionObjectsV) {
					if (F.equals(((Profiles) myParent.myMaster).myParent.myParent)) {
						if (((Profiles) M).rowCol == myMaster.rowCol
								&& (((Profiles) M).startPos == myMaster.endPos + 1 || ((Profiles) M).endPos + 1 == myMaster.startPos)
								&& ((Profiles) M).profileSelected == 0) {
							((Profiles) M).potentialS = true;
							myParent.foundPotential = true;
							myParent.alignClicks = 2;

						}

						if (((Profiles) M).partForm != 1
								|| ((Profiles) M).offsetRB != 0
								|| ((Profiles) M).offsetTL != 0) {
							((Profiles) M).potentialS = false;
						}

						F.bOpeningObject.mullions.add(M);

					}
				}
			}
		} else if (orientation == 2) {
			if (F.bOpeningObject.mullionsH != null
					&& F.bOpeningObject.mullionsH.size() > 0) {

				F.bOpeningObject.mullionObjectsH = F.bOpeningObject.mullionsH
						.toArray();
				F.bOpeningObject.mullionsH.clear();

				for (final Object M : F.bOpeningObject.mullionObjectsH) {
					if (F.equals(((Profiles) myParent.myMaster).myParent.myParent)) {
						if (((Profiles) M).rowCol == myMaster.rowCol
								&& (((Profiles) M).startPos == myMaster.endPos + 1 || ((Profiles) M).endPos + 1 == myMaster.startPos)
								&& ((Profiles) M).profileSelected == 0) {
							((Profiles) M).potentialS = true;
							myParent.foundPotential = true;
							myParent.alignClicks = 2;
						}

						if (((Profiles) M).partForm != 1
								|| ((Profiles) M).offsetRB != 0
								|| ((Profiles) M).offsetTL != 0) {
							((Profiles) M).potentialS = false;
						}

					}
					F.bOpeningObject.mullionsH.add(M);
				}
			}
		}
		if (!myParent.foundPotential) {
			JOptionPane.showMessageDialog(this.myParent,
					"No Valid Slave Mullions Found! \n"
							+ "Please Change Selection.",
					" No Slave Mullion - Error!", JOptionPane.ERROR_MESSAGE);
			myParent.dim.cancelAlign.doClick();

		}
	}

	private void findPotentialS() {
		this.findPotentialSII();
	}

	private void findPotentialSII() {

		potentialVs = new ArrayList();

		final Profiles myMaster = (Profiles) myParent.myMaster;

		final Collection myVs = this.getAllVs();

		final Object[] myVObjects = this.getVDeltas(myMaster, myVs);

		double myDeltaL = 10000;
		double myDeltaR = 10000;
		for (final Object V2 : myVObjects) {
			// Overall

			if (((Profiles) V2).profileSelected != 1
					&& ((Profiles) V2).potentialS) {
				if (((Profiles) V2).centerXs < myMaster.centerXs) {

					if (((Profiles) V2).delta < myDeltaL) {
						myDeltaL = ((Profiles) V2).delta;
					}

				}

				if (((Profiles) V2).centerXs > myMaster.centerXs) {
					if (((Profiles) V2).delta < myDeltaR) {
						myDeltaR = ((Profiles) V2).delta;
					}
				}
			}
		}

		for (final Object V2 : myVObjects) {
			if (((Profiles) V2).profileSelected == 1) {
				((Profiles) V2).potentialS = false;
			}

			if (((Profiles) V2).cOrM == 1) {

				((Profiles) V2).potentialS = false;

			} else if (((Profiles) V2).centerYe <= myMaster.centerYe
					&& ((Profiles) V2).centerYs >= myMaster.centerYs) {

				((Profiles) V2).potentialS = false;

			} else if (((Profiles) V2).centerXe == myMaster.centerXs
					|| ((Profiles) V2).centerXs == myMaster.centerXe) {

				((Profiles) V2).potentialS = false;

			} else {
				if (((Profiles) V2).centerXs < myMaster.centerXs) {

					if (((Profiles) V2).delta != myDeltaL) {
						((Profiles) V2).potentialS = false;
					}

				} else if (((Profiles) V2).centerXs > myMaster.centerXs) {
					if (((Profiles) V2).delta != myDeltaR) {
						((Profiles) V2).potentialS = false;
					}
				} else {
					((Profiles) V2).potentialS = true;
					potentialVs.add(V2);
				}
			}
		}

		this.updateVerticalMC(myVObjects);

		for (final Object h : myVObjects) {
			if (((Profiles) h).potentialS) {
				myParent.foundPotential = true;
				break;
			}
		}

		// myVObjects = null;
		System.gc();

	}

	private void findPotentialSIIH() {

		potentialHs = new ArrayList();

		final Profiles myMaster = (Profiles) myParent.myMaster;

		// final Object[] frames =
		// myParent.facetUsed.frames
		// .toArray();

		final Collection myHs = this.getAllHs();

		final Object[] myHObjects = this.getHDeltas(myMaster, myHs);

		double myDeltaL = 10000;
		double myDeltaR = 10000;
		for (final Object V2 : myHObjects) {
			// Overall

			if (((Profiles) V2).profileSelected != 1)
			// took this out for grids align bug && ((Profiles) V2).potentialS)
			{
				if (((Profiles) V2).centerYe < myMaster.centerYs) {

					if (((Profiles) V2).delta < myDeltaL) {
						myDeltaL = ((Profiles) V2).delta;
					}

				}

				if (((Profiles) V2).centerYs > myMaster.centerYe) {
					if (((Profiles) V2).delta < myDeltaR) {
						myDeltaR = ((Profiles) V2).delta;
					}
				}
			}
		}

		for (final Object V2 : myHObjects) {
			if (((Profiles) V2).profileSelected == 1) {
				((Profiles) V2).potentialS = false;
			}

			if (((Profiles) V2).cOrM == 1) {

				((Profiles) V2).potentialS = false;

			} else if (((Profiles) V2).centerXs <= myMaster.centerXs
					&& ((Profiles) V2).centerXe >= myMaster.centerXe) {

				((Profiles) V2).potentialS = false;

			} else if (((Profiles) V2).centerYs == myMaster.centerYs
					|| ((Profiles) V2).centerYe == myMaster.centerYe) {

				((Profiles) V2).potentialS = false;

			} else {
				if (((Profiles) V2).centerYe < myMaster.centerYs) {

					if (((Profiles) V2).delta != myDeltaL) {
						((Profiles) V2).potentialS = false;
					}

				} else if (((Profiles) V2).centerYs > myMaster.centerYe) {
					if (((Profiles) V2).delta != myDeltaR) {
						((Profiles) V2).potentialS = false;
					}
				} else {
					((Profiles) V2).potentialS = true;
					// potentialHs.add(V2);

				}
			}
		}

		this.updateHorizontalMC(myHObjects);

		for (final Object h : myHObjects) {
			if (((Profiles) h).potentialS) {
				myParent.foundPotential = true;
				break;
			}
		}

		// myHObjects = null;

		System.gc();

	}

	public void updateVerticalMC(final Object[] myVObjects) {

		for (final Object V2 : myVObjects) {
			if (((Profiles) V2).cOrM == 1
					&& ((Profiles) V2).myParent.a_levelID == 1) {

				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {
					if (((Facet) facet).a_sequenceID == ((Profiles) V2).myParent.myParent.a_sequenceID) {
						((Facet) facet).bOpeningObject.mullions.add(V2);
					}
				}

			} else if (((Profiles) V2).cOrM == 2
					&& ((Profiles) V2).myParent.myParent.a_levelID == 3) {
				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {
					if (((Facet) facet).a_sequenceID == ((Profiles) V2).myParent.myParent.myFacet.a_sequenceID) {
						final Object[] frames = ((Facet) facet).frames
								.toArray();
						for (final Object f : frames) {
							if (((Frame) f).a_sequenceID == ((Profiles) V2).myParent.myParent.a_sequenceID) {
								((Frame) f).bOpeningObject.mullions.add(V2);
							}
						}
					}
				}

			} else if (((Profiles) V2).cOrM == 2
					&& ((Profiles) V2).myParent.myParent.a_levelID == 12) {

				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {

					final Object[] frames = ((Facet) facet).frames.toArray();

					for (final Object f : frames) {
						final Object[] openings = ((Frame) f).openings
								.toArray();
						for (final Object O : openings) {
							if (((OpeningObject) O).sashObjectIn != null) {
								final Object[] leafs = ((OpeningObject) O).sashObjectIn.frames
										.toArray();

								for (final Object s : leafs) {
									if (((Profiles) V2).myParent.myParent
											.equals(s)) {
										((SashLeaf) s).bOpeningObject.mullions
												.add(V2);
									}
								}
							}

							if (((OpeningObject) O).sashObjectMid != null) {
								final Object[] leafs = ((OpeningObject) O).sashObjectMid.frames
										.toArray();

								for (final Object s : leafs) {
									if (((Profiles) V2).myParent.myParent
											.equals(s)) {
										((SashLeaf) s).bOpeningObject.mullions
												.add(V2);
									}
								}
							}

							if (((OpeningObject) O).sashObjectOut != null) {
								final Object[] leafs = ((OpeningObject) O).sashObjectOut.frames
										.toArray();

								for (final Object s : leafs) {
									if (((Profiles) V2).myParent.myParent
											.equals(s)) {
										((SashLeaf) s).bOpeningObject.mullions
												.add(V2);
									}
								}
							}

						}

					}

				}

			}

			if (((Profiles) V2).cOrM >= 3 && ((Profiles) V2).cOrM <= 6) {

				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {

					final Object[] frames = ((Facet) facet).frames.toArray();
					for (final Object f : frames) {
						final Object[] openings = ((Frame) f).openings
								.toArray();
						for (final Object O : openings) {
							if (((OpeningObject) O).sashObjectIn != null) {

								if (((Profiles) V2).myParent.myParent
										.equals(((OpeningObject) O).sashObjectIn)) {
									((OpeningObject) O).sashObjectIn.bOpeningObject.mullions
											.add(V2);
								}

							}

							if (((OpeningObject) O).sashObjectMid != null) {
								if (((Profiles) V2).myParent.myParent
										.equals(((OpeningObject) O).sashObjectMid)) {
									((OpeningObject) O).sashObjectMid.bOpeningObject.mullions
											.add(V2);
								}
							}

							if (((OpeningObject) O).sashObjectOut != null) {
								if (((Profiles) V2).myParent.myParent
										.equals(((OpeningObject) O).sashObjectOut)) {
									((OpeningObject) O).sashObjectOut.bOpeningObject.mullions
											.add(V2);
								}
							}

						}

					}

				}

			}

		}

	}

	public void updateHorizontalMC(final Object[] myVObjects) {

		for (final Object V2 : myVObjects) {
			if (((Profiles) V2).cOrM == 1
					&& ((Profiles) V2).myParent.myParent.a_levelID == 1) {

				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {
					if (((Facet) facet).a_sequenceID == ((Profiles) V2).myParent.myParent.a_sequenceID) {
						((Facet) facet).bOpeningObject.mullionsH.add(V2);
					}
				}

			} else if (((Profiles) V2).cOrM == 2
					&& ((Profiles) V2).myParent.myParent.a_levelID == 3) {
				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {
					if (((Facet) facet).a_sequenceID == ((Profiles) V2).myParent.myParent.myFacet.a_sequenceID) {
						final Object[] frames = ((Facet) facet).frames
								.toArray();
						for (final Object f : frames) {
							if (((Frame) f).a_sequenceID == ((Profiles) V2).myParent.myParent.a_sequenceID) {
								((Frame) f).bOpeningObject.mullionsH.add(V2);
							}
						}
					}
				}

			} else if (((Profiles) V2).cOrM == 2
					&& ((Profiles) V2).myParent.myParent.a_levelID == 12) {

				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {

					final Object[] frames = ((Facet) facet).frames.toArray();

					for (final Object f : frames) {
						final Object[] openings = ((Frame) f).openings
								.toArray();
						for (final Object O : openings) {
							if (((OpeningObject) O).sashObjectIn != null) {
								final Object[] leafs = ((OpeningObject) O).sashObjectIn.frames
										.toArray();

								for (final Object s : leafs) {
									if (((Profiles) V2).myParent.myParent
											.equals(s)) {
										((SashLeaf) s).bOpeningObject.mullionsH
												.add(V2);
									}
								}
							}

							if (((OpeningObject) O).sashObjectMid != null) {
								final Object[] leafs = ((OpeningObject) O).sashObjectMid.frames
										.toArray();

								for (final Object s : leafs) {
									if (((Profiles) V2).myParent.myParent
											.equals(s)) {
										((SashLeaf) s).bOpeningObject.mullionsH
												.add(V2);
									}
								}
							}

							if (((OpeningObject) O).sashObjectOut != null) {
								final Object[] leafs = ((OpeningObject) O).sashObjectOut.frames
										.toArray();

								for (final Object s : leafs) {
									if (((Profiles) V2).myParent.myParent
											.equals(s)) {
										((SashLeaf) s).bOpeningObject.mullionsH
												.add(V2);
									}
								}
							}

						}

					}

				}

			}

			if (((Profiles) V2).cOrM >= 3 && ((Profiles) V2).cOrM <= 6) {

				final Object[] facets = myParent.jobItem.design.frames
						.toArray();
				for (final Object facet : facets) {

					final Object[] frames = ((Facet) facet).frames.toArray();
					for (final Object f : frames) {
						final Object[] openings = ((Frame) f).openings
								.toArray();
						for (final Object O : openings) {
							if (((OpeningObject) O).sashObjectIn != null) {

								if (((Profiles) V2).myParent.myParent
										.equals(((OpeningObject) O).sashObjectIn)) {
									((OpeningObject) O).sashObjectIn.bOpeningObject.mullions
											.add(V2);
								}

							}

							if (((OpeningObject) O).sashObjectMid != null) {
								if (((Profiles) V2).myParent.myParent
										.equals(((OpeningObject) O).sashObjectMid)) {
									((OpeningObject) O).sashObjectMid.bOpeningObject.mullions
											.add(V2);
								}
							}

							if (((OpeningObject) O).sashObjectOut != null) {
								if (((Profiles) V2).myParent.myParent
										.equals(((OpeningObject) O).sashObjectOut)) {
									((OpeningObject) O).sashObjectOut.bOpeningObject.mullions
											.add(V2);
								}
							}

						}

					}

				}

			}

		}

	}

	public Object[] getVDeltas(final Profiles myMaster, final Collection myVs) {

		final Object[] myVObjects = myVs.toArray();
		for (final Object V : myVObjects) {
			if (((Profiles) V).isValid
					&& ((Profiles) V).exists == 1
					&& ((Profiles) V).profileSelected != 1
					&& (((Profiles) V).centerYe < myMaster.centerYs || ((Profiles) V).centerYs > myMaster.centerYe)
					&& ((Profiles) V).centerXs == ((Profiles) V).centerXe) {
				((Profiles) V).potentialS = true;

				if (((Profiles) V).centerXs < myMaster.centerXs) {
					((Profiles) V).delta = myMaster.centerXs
							- ((Profiles) V).centerXs;

				}

				if (((Profiles) V).centerXs > myMaster.centerXs) {
					((Profiles) V).delta = ((Profiles) V).centerXs
							- myMaster.centerXs;

				}

			}

		}
		return myVObjects;
	}

	public Object[] getHDeltas(final Profiles myMaster, final Collection myHs) {

		final Object[] myHObjects = myHs.toArray();
		for (final Object V : myHObjects) {
			((Profiles) V).potentialS = false;
			if (((Profiles) V).isValid
					&& ((Profiles) V).exists == 1
					&& ((Profiles) V).profileSelected != 1
					&& (((Profiles) V).centerXe < myMaster.centerXs || ((Profiles) V).centerXs > myMaster.centerXe)
					&& ((Profiles) V).centerYs == ((Profiles) V).centerYe) {
				((Profiles) V).potentialS = true;

				if (((Profiles) V).centerYe < myMaster.centerYs) {
					((Profiles) V).delta = myMaster.centerYs
							- ((Profiles) V).centerYe;

				}

				if (((Profiles) V).centerYs > myMaster.centerYe) {
					((Profiles) V).delta = ((Profiles) V).centerYs
							- myMaster.centerYe;

				}

			}

		}
		return myHObjects;
	}

	public Collection getAllVs() {

		final Object[] facets = myParent.jobItem.design.frames.toArray();
		final Collection myVs = new ArrayList();

		for (final Object facet : facets) {
			final Object[] frames = ((Facet) facet).frames.toArray();
			myVs.addAll(((Facet) facet).bOpeningObject.mullions);
			((Facet) facet).bOpeningObject.mullions.clear();
			for (final Object f : frames) {

				if (((Frame) f).startingX < Math.min(
						((Profiles) myParent.myMaster).centerXs,
						((Profiles) myParent.myMaster).centerXe)
						&& ((Frame) f).bX2 > Math.max(
								((Profiles) myParent.myMaster).centerXs,
								((Profiles) myParent.myMaster).centerXe)) {

					myVs.addAll(((Frame) f).bOpeningObject.mullions);

					((Frame) f).bOpeningObject.mullions.clear();

					final Object[] openings = ((Frame) f).openings.toArray();
					Object[] leafs = null;

					for (final Object O : openings) {

						if (((OpeningObject) O).sashObjectIn != null
								&& ((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
							myVs.addAll(((OpeningObject) O).sashObjectIn.bOpeningObject.mullions);
							((OpeningObject) O).sashObjectIn.bOpeningObject.mullions
									.clear();

							leafs = ((OpeningObject) O).sashObjectIn.frames
									.toArray();

							if (leafs.length > 0) {
								for (final Object s : leafs) {
									myVs.addAll(((SashLeaf) s).bOpeningObject.mullions);
									((SashLeaf) s).bOpeningObject.mullions
											.clear();

									final Object[] sO = ((SashLeaf) s).openings
											.toArray();
									for (final Object so : sO) {
										if (((OpeningObject) so).contentIn == 1
												&& !((OpeningObject) so).unGlazed) {
											// myVs.addAll(((OpeningObject)
											// so).dloIn.bOpeningObject.mullions);
											// ((OpeningObject)
											// so).dloIn.bOpeningObject.mullions
											// .clear();
										}
									}

								}

							}

						} else if (((OpeningObject) O).contentIn == 1
								&& !((OpeningObject) O).unGlazed) {
							// myVs.addAll(((OpeningObject)
							// O).dloIn.bOpeningObject.mullions);
							// ((OpeningObject)
							// O).dloIn.bOpeningObject.mullions
							// .clear();
						}
						if (((OpeningObject) O).sashObjectMid != null
								&& ((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
							myVs.addAll(((OpeningObject) O).sashObjectMid.bOpeningObject.mullions);
							((OpeningObject) O).sashObjectMid.bOpeningObject.mullions
									.clear();

							leafs = ((OpeningObject) O).sashObjectMid.frames
									.toArray();
							if (leafs.length > 0) {
								for (final Object s : leafs) {
									myVs.addAll(((SashLeaf) s).bOpeningObject.mullions);
									((SashLeaf) s).bOpeningObject.mullions
											.clear();
									final Object[] sO = ((SashLeaf) s).openings
											.toArray();
									for (final Object so : sO) {
										if (((OpeningObject) so).contentMid == 1
												&& !((OpeningObject) so).unGlazed) {
											// myVs.addAll(((OpeningObject)
											// so).dloMid.bOpeningObject.mullions);
											// ((OpeningObject)
											// so).dloMid.bOpeningObject.mullions
											// .clear();
										}
									}
								}

							}
						} else if (((OpeningObject) O).contentMid == 1
								&& !((OpeningObject) O).unGlazed) {
							// myVs.addAll(((OpeningObject)
							// O).dloMid.bOpeningObject.mullions);
							// ((OpeningObject)
							// O).dloMid.bOpeningObject.mullions
							// .clear();
						}
						if (((OpeningObject) O).sashObjectOut != null
								&& ((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
							myVs.addAll(((OpeningObject) O).sashObjectOut.bOpeningObject.mullions);
							((OpeningObject) O).sashObjectOut.bOpeningObject.mullions
									.clear();

							leafs = ((OpeningObject) O).sashObjectOut.frames
									.toArray();
							if (leafs.length > 0) {
								for (final Object s : leafs) {
									myVs.addAll(((SashLeaf) s).bOpeningObject.mullions);
									((SashLeaf) s).bOpeningObject.mullions
											.clear();
									final Object[] sO = ((SashLeaf) s).openings
											.toArray();
									for (final Object so : sO) {
										if (((OpeningObject) so).contentOut == 1
												&& !((OpeningObject) so).unGlazed) {
											// myVs.addAll(((OpeningObject)
											// so).dloOut.bOpeningObject.mullions);
											// ((OpeningObject)
											// so).dloOut.bOpeningObject.mullions
											// .clear();
										}
									}
								}

							}
						} else if (((OpeningObject) O).contentOut == 1
								&& !((OpeningObject) O).unGlazed) {
							// myVs.addAll(((OpeningObject)
							// O).dloOut.bOpeningObject.mullions);
							// ((OpeningObject)
							// O).dloOut.bOpeningObject.mullions
							// .clear();
						}
					}// For opening

				}

			}

		}

		return myVs;
	}

	public Collection getAllHs() {

		final Object[] facets = myParent.jobItem.design.frames.toArray();
		final Collection myHs = new ArrayList();

		for (final Object facet : facets) {

			final Object[] frames = ((Facet) facet).frames.toArray();
			myHs.addAll(((Facet) facet).bOpeningObject.mullionsH);
			((Facet) facet).bOpeningObject.mullionsH.clear();
			for (final Object f : frames) {

				if (((Frame) f).highestY < Math.min(
						((Profiles) myParent.myMaster).centerYs,
						((Profiles) myParent.myMaster).centerYe)
						&& ((Frame) f).lowestY > Math.max(
								((Profiles) myParent.myMaster).centerYs,
								((Profiles) myParent.myMaster).centerYe)) {

					myHs.addAll(((Frame) f).bOpeningObject.mullionsH);

					((Frame) f).bOpeningObject.mullionsH.clear();

					final Object[] openings = ((Frame) f).openings.toArray();
					Object[] leafs = null;

					for (final Object O : openings) {

						if (((OpeningObject) O).sashObjectIn != null
								&& ((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
							myHs.addAll(((OpeningObject) O).sashObjectIn.bOpeningObject.mullionsH);
							((OpeningObject) O).sashObjectIn.bOpeningObject.mullionsH
									.clear();

							leafs = ((OpeningObject) O).sashObjectIn.frames
									.toArray();

							if (leafs.length > 0) {
								for (final Object s : leafs) {
									myHs.addAll(((SashLeaf) s).bOpeningObject.mullionsH);
									((SashLeaf) s).bOpeningObject.mullionsH
											.clear();

									final Object[] sO = ((SashLeaf) s).openings
											.toArray();
									for (final Object so : sO) {
										if (((OpeningObject) so).contentIn == 1
												&& !((OpeningObject) so).unGlazed) {
											// myHs.addAll(((OpeningObject)
											// so).dloIn.bOpeningObject.mullionsH);
											// ((OpeningObject)
											// so).dloIn.bOpeningObject.mullionsH
											// .clear();
										}
									}

								}

							}

						} else if (((OpeningObject) O).contentIn == 1
								&& !((OpeningObject) O).unGlazed) {
							// myHs.addAll(((OpeningObject)
							// O).dloIn.bOpeningObject.mullionsH);
							// ((OpeningObject)
							// O).dloIn.bOpeningObject.mullionsH
							// .clear();
						}
						if (((OpeningObject) O).sashObjectMid != null
								&& ((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
							myHs.addAll(((OpeningObject) O).sashObjectMid.bOpeningObject.mullionsH);
							((OpeningObject) O).sashObjectMid.bOpeningObject.mullionsH
									.clear();

							leafs = ((OpeningObject) O).sashObjectMid.frames
									.toArray();
							if (leafs.length > 0) {
								for (final Object s : leafs) {
									myHs.addAll(((SashLeaf) s).bOpeningObject.mullionsH);
									((SashLeaf) s).bOpeningObject.mullionsH
											.clear();
									final Object[] sO = ((SashLeaf) s).openings
											.toArray();
									for (final Object so : sO) {
										if (((OpeningObject) so).contentMid == 1
												&& !((OpeningObject) so).unGlazed) {
											// myHs.addAll(((OpeningObject)
											// so).dloMid.bOpeningObject.mullionsH);
											// ((OpeningObject)
											// so).dloMid.bOpeningObject.mullionsH
											// .clear();
										}
									}
								}

							}
						} else if (((OpeningObject) O).contentMid == 1
								&& !((OpeningObject) O).unGlazed) {
							// myHs.addAll(((OpeningObject)
							// O).dloMid.bOpeningObject.mullionsH);
							// ((OpeningObject)
							// O).dloMid.bOpeningObject.mullionsH
							// .clear();
						}
						if (((OpeningObject) O).sashObjectOut != null
								&& ((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
							myHs.addAll(((OpeningObject) O).sashObjectOut.bOpeningObject.mullionsH);
							((OpeningObject) O).sashObjectOut.bOpeningObject.mullionsH
									.clear();

							leafs = ((OpeningObject) O).sashObjectOut.frames
									.toArray();
							if (leafs.length > 0) {
								for (final Object s : leafs) {
									myHs.addAll(((SashLeaf) s).bOpeningObject.mullionsH);
									((SashLeaf) s).bOpeningObject.mullionsH
											.clear();
									final Object[] sO = ((SashLeaf) s).openings
											.toArray();
									for (final Object so : sO) {
										if (((OpeningObject) so).contentOut == 1
												&& !((OpeningObject) so).unGlazed) {
											// myHs.addAll(((OpeningObject)
											// so).dloOut.bOpeningObject.mullionsH);
											// ((OpeningObject)
											// so).dloOut.bOpeningObject.mullionsH
											// .clear();
										}
									}
								}

							}
						} else if (((OpeningObject) O).contentOut == 1
								&& !((OpeningObject) O).unGlazed) {
							// myHs.addAll(((OpeningObject)
							// O).dloOut.bOpeningObject.mullionsH);
							// ((OpeningObject)
							// O).dloOut.bOpeningObject.mullionsH
							// .clear();
						}
					}// For opening

				}

			}

		}

		return myHs;
	}

	public Collection getAllHso(final Object[] frames) {

		final Collection myHs = new ArrayList();
		myHs.addAll(myParent.facetUsed.bOpeningObject.mullionsH);
		myParent.facetUsed.bOpeningObject.mullionsH.clear();

		for (final Object f : frames) {

			if (((Frame) f).highestY < Math.min(
					((Profiles) myParent.myMaster).centerYs,
					((Profiles) myParent.myMaster).centerYe)
					&& ((Frame) f).lowestY > Math.max(
							((Profiles) myParent.myMaster).centerYs,
							((Profiles) myParent.myMaster).centerYe)) {

				myHs.addAll(((Frame) f).bOpeningObject.mullionsH);

				((Frame) f).bOpeningObject.mullionsH.clear();

				final Object[] openings = ((Frame) f).openings.toArray();
				Object[] leafs = null;

				for (final Object O : openings) {

					if (((OpeningObject) O).sashObjectIn != null
							&& ((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
						myHs.addAll(((OpeningObject) O).sashObjectIn.bOpeningObject.mullionsH);
						((OpeningObject) O).sashObjectIn.bOpeningObject.mullionsH
								.clear();

						leafs = ((OpeningObject) O).sashObjectIn.frames
								.toArray();

						if (leafs.length > 0) {
							for (final Object s : leafs) {
								myHs.addAll(((SashLeaf) s).bOpeningObject.mullionsH);
								((SashLeaf) s).bOpeningObject.mullionsH.clear();

								final Object[] sO = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sO) {
									if (((OpeningObject) so).contentIn == 1
											&& !((OpeningObject) so).unGlazed) {
										// myHs.addAll(((OpeningObject)
										// so).dloIn.bOpeningObject.mullionsH);
										// ((OpeningObject)
										// so).dloIn.bOpeningObject.mullionsH
										// .clear();
									}
								}

							}

						}

					} else if (((OpeningObject) O).contentIn == 1
							&& !((OpeningObject) O).unGlazed) {
						// myHs.addAll(((OpeningObject)
						// O).dloIn.bOpeningObject.mullionsH);
						// ((OpeningObject)
						// O).dloIn.bOpeningObject.mullionsH
						// .clear();
					}
					if (((OpeningObject) O).sashObjectMid != null
							&& ((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
						myHs.addAll(((OpeningObject) O).sashObjectMid.bOpeningObject.mullionsH);
						((OpeningObject) O).sashObjectMid.bOpeningObject.mullionsH
								.clear();

						leafs = ((OpeningObject) O).sashObjectMid.frames
								.toArray();
						if (leafs.length > 0) {
							for (final Object s : leafs) {
								myHs.addAll(((SashLeaf) s).bOpeningObject.mullionsH);
								((SashLeaf) s).bOpeningObject.mullionsH.clear();
								final Object[] sO = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sO) {
									if (((OpeningObject) so).contentMid == 1
											&& !((OpeningObject) so).unGlazed) {
										// myHs.addAll(((OpeningObject)
										// so).dloMid.bOpeningObject.mullionsH);
										// ((OpeningObject)
										// so).dloMid.bOpeningObject.mullionsH
										// .clear();
									}
								}
							}

						}
					} else if (((OpeningObject) O).contentMid == 1
							&& !((OpeningObject) O).unGlazed) {
						// myHs.addAll(((OpeningObject)
						// O).dloMid.bOpeningObject.mullionsH);
						// ((OpeningObject)
						// O).dloMid.bOpeningObject.mullionsH
						// .clear();
					}
					if (((OpeningObject) O).sashObjectOut != null
							&& ((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
						myHs.addAll(((OpeningObject) O).sashObjectOut.bOpeningObject.mullionsH);
						((OpeningObject) O).sashObjectOut.bOpeningObject.mullionsH
								.clear();

						leafs = ((OpeningObject) O).sashObjectOut.frames
								.toArray();
						if (leafs.length > 0) {
							for (final Object s : leafs) {
								myHs.addAll(((SashLeaf) s).bOpeningObject.mullionsH);
								((SashLeaf) s).bOpeningObject.mullionsH.clear();
								final Object[] sO = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sO) {
									if (((OpeningObject) so).contentOut == 1
											&& !((OpeningObject) so).unGlazed) {
										// myHs.addAll(((OpeningObject)
										// so).dloOut.bOpeningObject.mullionsH);
										// ((OpeningObject)
										// so).dloOut.bOpeningObject.mullionsH
										// .clear();
									}
								}
							}

						}
					} else if (((OpeningObject) O).contentOut == 1
							&& !((OpeningObject) O).unGlazed) {
						// myHs.addAll(((OpeningObject)
						// O).dloOut.bOpeningObject.mullionsH);
						// ((OpeningObject)
						// O).dloOut.bOpeningObject.mullionsH
						// .clear();
					}
				}// For opening

			}
		}
		return myHs;
	}

	private void findPotentialSH() {
		this.findPotentialSIIH();
	}

	private void verifyPotentialS(final int type) {

		final Object[] frameObjects = myParent.facetUsed.frames.toArray();

		for (final Object F : frameObjects) {
			if (myParent.foundPotential) {
				break;
			}
			if (myParent.editor.selectedEditLevel == 1) {
				this.verifyAction(F);
			} else {
				final Object[] openings = ((ShapeObject) F).openings.toArray();
				Object[] leafs = null;

				for (final Object O : openings) {

					if (((OpeningObject) O).sashObjectIn != null) {
						leafs = ((OpeningObject) O).sashObjectIn.frames
								.toArray();
						for (final Object S : leafs) {
							this.verifyAction(S);
						}
					}
					if (!myParent.foundPotential) {

						if (((OpeningObject) O).sashObjectMid != null
								&& ((OpeningObject) O).sashObjectMid.frames != null) {
							leafs = ((OpeningObject) O).sashObjectMid.frames
									.toArray();
							for (final Object S : leafs) {
								this.verifyAction(S);
							}
						}
					}
					if (!masterFound) {
						leafs = ((OpeningObject) O).sashObjectOut.frames
								.toArray();
						for (final Object S : leafs) {
							this.verifyAction(S);
						}
					}

				}// For opening
			}

		}

		if (!myParent.foundPotential) {
			JOptionPane.showMessageDialog(this.myParent,
					"No Potential Verticals were found \nfor alignment"
							+ "with selected Master.",
					"No Potential Slaves Found - Warning!",
					JOptionPane.WARNING_MESSAGE);
			myParent.dim.cancelAlign.doClick();

		}
	}

	public void resetPotentials(final Object F) {

		((ShapeObject) F).bOpeningObject.mullionObjectsV = ((ShapeObject) F).bOpeningObject.mullions
				.toArray();

		((ShapeObject) F).bOpeningObject.mullions.clear();

		for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsV) {
			((Profiles) M).potentialS = false;
			((Profiles) M).profileSelected = 0;
			((ShapeObject) F).bOpeningObject.mullions.add(M);
		}
	}

	public void verifyAction(final Object F) {

		((ShapeObject) F).bOpeningObject.mullionObjectsV = ((ShapeObject) F).bOpeningObject.mullions
				.toArray();

		for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsV) {
			if (((Profiles) M).potentialS) {
				myParent.foundPotential = true;
				break;
			}
		}
	}

	private void verifyPotentialSH(final int type) {

		final Object[] frameObjects = myParent.facetUsed.frames.toArray();
		for (final Object F : frameObjects) {

			if (myParent.foundPotential) {
				break;
			}
			if (myParent.editor.selectedEditLevel == 1) {
				this.verifyActionH(F);
			} else {
				final Object[] openings = ((ShapeObject) F).openings.toArray();
				Object[] leafs = null;

				for (final Object O : openings) {

					if (((OpeningObject) O).sashObjectIn != null) {
						leafs = ((OpeningObject) O).sashObjectIn.frames
								.toArray();
						for (final Object S : leafs) {
							this.verifyActionH(S);
						}
					}
					if (!myParent.foundPotential) {
						leafs = ((OpeningObject) O).sashObjectMid.frames
								.toArray();
						for (final Object S : leafs) {
							this.verifyActionH(S);
						}
					}
					if (!myParent.foundPotential) {
						leafs = ((OpeningObject) O).sashObjectOut.frames
								.toArray();
						for (final Object S : leafs) {
							this.verifyActionH(S);
						}
					}

				}// For opening
			}
		}

		if (!myParent.foundPotential) {
			JOptionPane.showMessageDialog(this.myParent,
					"No Potential Horizontals were found \nfor alignment"
							+ "with selected Master.",
					"No Potential Slaves Found - Warning!",
					JOptionPane.WARNING_MESSAGE);
			myParent.dim.cancelAlign.doClick();

		}
	}

	public void resetPotentialsH(final Object F) {

		((ShapeObject) F).bOpeningObject.mullionObjectsH = ((ShapeObject) F).bOpeningObject.mullionsH
				.toArray();
		((ShapeObject) F).bOpeningObject.mullionsH.clear();
		for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsH) {
			((Profiles) M).potentialS = false;
			((Profiles) M).profileSelected = 0;
			((ShapeObject) F).bOpeningObject.mullionsH.add(M);
		}
	}

	public void verifyActionH(final Object F) {

		((ShapeObject) F).bOpeningObject.mullionObjectsH = ((ShapeObject) F).bOpeningObject.mullionsH
				.toArray();
		for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsH) {
			if (((Profiles) M).potentialS) {
				myParent.foundPotential = true;
				break;
			}

		}
	}

	private boolean isMatchRowS(final Collection myRowS,
			final Collection myRowE, final int rowCol, final int yRows) {

		boolean startOK = true;
		boolean endOK = true;
		final Object[] rS = myRowS.toArray();
		myRowE.toArray();
		for (final Object element : rS) {
			if (rowCol == Integer.parseInt(element.toString())) {
				startOK = false;
				endOK = false;
			}
		}

		if (startOK && endOK) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isMatchColS(final int myRowS[], final int myRowE[],
			final int startPos, final int endPos, final int yRows) {

		boolean startOK = false;
		boolean endOK = false;
		boolean goodToTest = false;
		for (final int element : myRowS) {
			if (element > 0) {
				goodToTest = true;
				break;
			}
		}
		for (final int element : myRowE) {
			if (element > 0) {
				goodToTest = true;
				break;
			}
		}

		if (goodToTest) {
			for (final int element : myRowE) {
				if (startPos == 1 && endPos < yRows) {

					for (final int element2 : myRowS) {
						if (endPos < element2 && startPos < element2) { // above
							// only
							startOK = true;
							endOK = true;
							break;
						}
					}

				} else if (startPos > 1 && endPos < yRows) {

					for (final int element2 : myRowS) {
						if (startPos > element && endPos > element
						// or
								|| startPos < element2 && endPos < element2) { // above
							startOK = true;
							endOK = true;
							break;
						}

					}

				} else if (startPos > 1 && endPos == yRows) {
					for (final int element2 : myRowS) {
						if (startPos > element && endPos > element) { // below
							// only
							startOK = true;
							endOK = true;
							break;
						}

					}

				}

			}

			if (startOK && endOK) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	private boolean closestVM(final ShapeObject myFrame, final double centerM,
			final double centerS, final boolean above) {

		boolean closest = true;
		myFrame.bOpeningObject.mullionObjectsV = myFrame.bOpeningObject.mullions
				.toArray();
		final double delta = Math.abs(centerM - centerS);
		for (final Object M : myFrame.bOpeningObject.mullionObjectsV) {
			if (!above) {
				if (centerS < centerM) {
					if (centerM - ((Profiles) M).centerXs < delta
							&& ((Profiles) M).centerXs != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
				if (centerS > centerM) {
					if (((Profiles) M).centerXs - centerM < delta
							&& ((Profiles) M).centerXs != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
			} else {
				if (centerS < centerM) {
					if (centerM - ((Profiles) M).centerXe < delta
							&& ((Profiles) M).centerXe != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
				if (centerS > centerM) {
					if (((Profiles) M).centerXe - centerM < delta
							&& ((Profiles) M).centerXe != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
			}

		}

		return closest;
	}

	private boolean closestHM(final Frame myFrame, final double centerM,
			final double centerS, final boolean above) {

		boolean closest = true;
		myFrame.bOpeningObject.mullionObjectsH = myFrame.bOpeningObject.mullionsH
				.toArray();
		final double delta = Math.abs(centerM - centerS);
		for (final Object M : myFrame.bOpeningObject.mullionObjectsH) {
			if (!above) {
				if (centerS < centerM) {
					if (centerM - ((Profiles) M).centerYs < delta
							&& ((Profiles) M).centerYs != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
				if (centerS > centerM) {
					if (((Profiles) M).centerYs - centerM < delta
							&& ((Profiles) M).centerYs != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
			} else {
				if (centerS < centerM) {
					if (centerM - ((Profiles) M).centerYe < delta
							&& ((Profiles) M).centerYe != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
				if (centerS > centerM) {
					if (((Profiles) M).centerYe - centerM < delta
							&& ((Profiles) M).centerYe != centerS
							&& ((Profiles) M).exists == 1) {
						closest = false;
					}
				}
			}

		}

		return closest;
	}

	public void getSelectedColTopOLD(final int xxx, final int yyy) {

		Object[] gpText = myParent.colTextObjects.toArray();
		myParent.textFieldsTop = gpText;
		Object[] gpTextXs = myParent.colTextPosXs.toArray();
		Object[] gpTextXe = myParent.colTextPosXe.toArray();

		if (dimensionType == 1 || dimensionType == 3) {
			gpText = myParent.colTextObjectsc.toArray();
			myParent.textFieldsTop = gpText;
			gpTextXs = myParent.colTextPosXsc.toArray();
			gpTextXe = myParent.colTextPosXec.toArray();

		}
		double xpos = 0;
		double xpose = 0;
		//
		// get metrics from the graphics
		this.getMyFont();

		final FontMetrics metrics = g2.getFontMetrics(font);
		g2.getFontRenderContext();

		for (int i = 0; i < myParent.textFieldsTop.length; i++) {

			xpos = ((Double) gpTextXs[i]).doubleValue();
			xpose = ((Double) gpTextXe[i]).doubleValue();
			metrics.getHeight();
			// get the advance of my text in
			// this font
			// and
			// render context
			int adv = metrics.stringWidth((String) gpText[i]);
			String frac = "";

			if (myParent.myTopPanel.impFrac.isSelected()) {

				try {
					frac = UOMConvert.fractionToImperial((String) gpText[i]);

					adv = metrics.stringWidth(frac) + 15;
				} catch (final Exception e) {
					// TODO
					// Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (myParent.myTopPanel.metric.isSelected()
					|| myParent.myTopPanel.percent.isSelected()) {
				final String myString = myParent.sixDecimal.format(Double
						.parseDouble((String) gpText[i]));
				adv = metrics.stringWidth(myString);
			}
			// calculate the size of a box to
			// hold the
			// text
			// with some padding.
			final double startXrect = Math.floor(xpos + (xpose - xpos) / 2
					- adv / 2f);
			if (dimensionType <= 2) {
				if (xxx >= (int) startXrect
						&& xxx <= (int) startXrect + adv + 2) {
					selectedCol = i + 1;
					break;
				} else {

				}
			} else {
				if (xxx >= (int) startXrect
						&& xxx <= (int) startXrect + adv + 2
						&& yyy <= (int) mySelectedFrame.bOpeningObject.startingY) {
					selectedCol = i + 1;
					break;
				} else {

				}
			}
		}
		myParent.textFieldsTop = myParent.topTexts.toArray();
		for (int i = 0; i < myParent.textFieldsTop.length; i++) {
			if (dimensionType <= 2) {
				if (i == selectedCol - 1) {
					selectedFrameNo = ((TextFieldTop) myParent.textFieldsTop[i]).colNo;
					break;
				}
			} else {
				if (i == selectedCol - 1) {
					selectedOpeningNo = ((TextFieldTop) myParent.textFieldsTop[i]).colNo;
					break;
				}
			}
		}

	}

	public void getSelectedColTop(final int xxx, final int yyy) {

		myParent.doFacetRadioClick();

		final Object[] gpText = myParent.colTextObjects.toArray();
		myParent.textFieldsTop = gpText;
		final Object[] gpTextXs = myParent.colTextPosXs.toArray();
		final Object[] gpTextXe = myParent.colTextPosXe.toArray();

		for (int i = 0; i < gpTextXs.length; i++) {

			for (int ii = 0; ii < gpTextXe.length; ii++) {

				if (i == ii) {
					if (xxx >= Double.valueOf(gpTextXs[i].toString())
							&& xxx <= Double.valueOf(gpTextXe[ii].toString())) {

						selectedCol = i + 1;
						break;
					}
				}
			}

		}

		myParent.textFieldsTop = myParent.topTexts.toArray();
		for (int i = 0; i < myParent.textFieldsTop.length; i++) {
			if (dimensionType <= 2) {
				if (i == selectedCol - 1) {
					selectedFrameNo = ((TextFieldTop) myParent.textFieldsTop[i]).colNo;

					break;
				}
			} else {
				if (i == selectedCol - 1) {
					selectedOpeningNo = ((TextFieldTop) myParent.textFieldsTop[i]).colNo;

					break;
				}
			}
		}

	}

	public void getSelectedColFacetBot(final int xxx, final int yyy) {

		final Object[] gpText = myParent.fcolTextObjects.toArray();
		myParent.textFieldsFBot = gpText;
		final Object[] gpTextXs = myParent.fcolTextPosXs.toArray();
		final Object[] gpTextXe = myParent.fcolTextPosXe.toArray();

		for (int i = 0; i < gpTextXs.length; i++) {

			for (int ii = 0; ii < gpTextXe.length; ii++) {

				if (i == ii) {
					if (xxx >= Double.valueOf(gpTextXs[i].toString())
							&& xxx <= Double.valueOf(gpTextXe[ii].toString())) {

						selectedfBot = i + 1;

					}
				}
			}

		}

		myParent.textFieldsFBot = myParent.fcolTexts.toArray();
		for (int i = 0; i < myParent.textFieldsFBot.length; i++) {
			if (dimensionType <= 2) {
				if (i == selectedfBot - 1) {
					selectedfBot = ((FacetBotText) myParent.textFieldsFBot[i]).colNo;
					break;
				}
			} else {
				if (i == selectedCol - 1) {
					selectedfBotO = ((FacetBotText) myParent.textFieldsFBot[i]).colNo;
					break;
				}
			}
		}

		myParent.doFacetRadioClick();

	}

	public void getSetSelectedCoupler(final int x, final int eX, final double a) {

		final Object[] myMs = myParent.facetUsed.bOpeningObject.mullions
				.toArray();
		myParent.facetUsed.bOpeningObject.mullions.clear();
		for (final Object m : myMs) {

			if (x < ((Profiles) m).centerXe && eX > ((Profiles) m).centerXe) {
				((Profiles) m).angle = a;
			}
			myParent.facetUsed.bOpeningObject.mullions.add(m);
		}
	}

	public void getSelectedRowLeftOLD(final int xxx, final int yyy) {

		gpTextrow = myParent.rowTextObjects.toArray();
		myParent.textFieldsLeft = gpTextrow;
		gpTextXsrow = myParent.rowTextPosYs.toArray();
		gpTextXerow = myParent.rowTextPosYe.toArray();

		if (dimensionType == 1 || dimensionType == 3) {
			gpTextrow = myParent.rowTextObjectsc.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYsc.toArray();
			gpTextXerow = myParent.rowTextPosYec.toArray();
		}
		double ypos = 0;
		double ypose = 0;
		endX = myParent.jobItem.startingX
				+ myParent.jobItem.design_flat_WIDTHpix;
		endY = myParent.jobItem.startingY + myParent.jobItem._HEIGHTpix;
		// get metrics from the graphics
		this.getMyFont();
		int hgt = 0;
		double startYrect = 0;
		final FontMetrics metrics = g2.getFontMetrics(font);
		g2.getFontRenderContext();

		for (int j = 0; j < myParent.textFieldsLeft.length; j++) {
			ypos = ((Double) gpTextXsrow[j]).doubleValue();
			ypose = ((Double) gpTextXerow[j]).doubleValue();
			// get the height of a line of text
			// in this
			// font
			// and render context
			hgt = metrics.getHeight();
			metrics.stringWidth((String) myParent.textFieldsLeft[j]);
			// calculate the size of a box to
			// hold the
			// text
			// with some padding.
			startYrect = ypos + (ypose - ypos - hgt) / 2;

			if (yyy >= (int) startYrect - 3
					&& yyy <= (int) startYrect + hgt + 2
					&& xxx < myParent.jobItem.startingX) {
				selectedRowLeft = j + 1;
				break;
			} else {

			}
		}
		myParent.textFieldsLeft = myParent.leftTexts.toArray();
		for (int i = 0; i < myParent.textFieldsLeft.length; i++) {
			if (i == selectedRowLeft - 1) {
				selectedFrameNo = ((TextFieldLeft) myParent.textFieldsLeft[i]).rowNo;
				selectedOpeningNo = ((TextFieldLeft) myParent.textFieldsLeft[i]).rowNo;
				break;
			}
		}
	}

	public void getSelectedRowLeft(final int xxx, final int yyy) {

		myParent.doFacetRadioClick();

		gpTextrow = myParent.rowTextObjects.toArray();
		myParent.textFieldsLeft = gpTextrow;
		final Object[] gpTextYs = myParent.rowTextPosYs.toArray();
		final Object[] gpTextYe = myParent.rowTextPosYe.toArray();

		for (int i = 0; i < gpTextYs.length; i++) {

			for (int ii = 0; ii < gpTextYe.length; ii++) {

				if (i == ii) {
					if (yyy >= Double.valueOf(gpTextYs[i].toString())
							&& yyy <= Double.valueOf(gpTextYe[ii].toString())) {

						selectedRowLeft = i + 1;

					}
				}
			}

		}

		myParent.textFieldsLeft = myParent.leftTexts.toArray();
		for (int i = 0; i < myParent.textFieldsLeft.length; i++) {
			if (i == selectedRowLeft - 1) {
				selectedFrameNo = ((TextFieldLeft) myParent.textFieldsLeft[i]).rowNo;

				selectedOpeningNo = ((TextFieldLeft) myParent.textFieldsLeft[i]).rowNo;
				break;
			}
		}

	}

	public void updateTextLeftWithStd(final int xxx, final int yyy,
			JXTextField txt) {

		myParent.doFacetRadioClick();

		gpTextrow = myParent.rowTextObjects.toArray();
		myParent.textFieldsLeft = gpTextrow;
		final Object[] gpTextYs = myParent.rowTextPosYs.toArray();
		final Object[] gpTextYe = myParent.rowTextPosYe.toArray();

		for (int i = 0; i < gpTextYs.length; i++) {

			for (int ii = 0; ii < gpTextYe.length; ii++) {

				if (i == ii) {
					if (yyy >= Double.valueOf(gpTextYs[i].toString())
							&& yyy <= Double.valueOf(gpTextYe[ii].toString())) {

						selectedRowLeft = i + 1;

					}
				}
			}

		}

		Object[] rto = myParent.rowTextObjects.toArray();
		myParent.rowTextObjects.clear();
		for (int i = 0; i < rto.length; i++) {

			String h = txt.getText();

			if (i == selectedRowLeft - 1) {
				h = new BigDecimal(txt.getText()) + "";
			}

			myParent.rowTextObjects.add(h);
		}

	}

	public void updateTextTopWithStd(final int xxx, final int yyy,
			JXTextField txt) {

		myParent.doFacetRadioClick();

		this.gpText = myParent.colTextObjects.toArray();
		myParent.textFieldsTop = gpText;
		final Object[] gpTextYs = myParent.colTextPosXs.toArray();
		final Object[] gpTextYe = myParent.colTextPosXe.toArray();

		for (int i = 0; i < gpTextXs.length; i++) {

			for (int ii = 0; ii < gpTextXe.length; ii++) {

				if (i == ii) {
					if (xxx >= Double.valueOf(gpTextXs[i].toString())
							&& xxx <= Double.valueOf(gpTextXe[ii].toString())) {

						this.selectedCol = i + 1;

					}
				}
			}

		}

		Object[] rto = myParent.colTextObjects.toArray();
		myParent.colTextObjects.clear();
		for (int i = 0; i < rto.length; i++) {

			String w = txt.getText();

			if (i == selectedCol - 1) {
				w = new BigDecimal(txt.getText()) + "";
			}

			myParent.colTextObjects.add(w);
		}

	}

	public void getSelectedFrameFromTextRC() {

		final Object[] frames = myParent.facetUsed.frames.toArray();
		for (final Object frame : frames) {
			if (((Frame) frame).startCol == this.myParent.lastRC
					&& ((Frame) frame).startRow == this.myParent.lastRR) {
				this.mySelectedFrame = (Frame) frame;
				break;
			}
		}

	}

	/**
	 * Get fonts configuration
	 */
	public void getMyFont() {

		font = new Font("SansSerif", 0, 9);

		if (myParent.facetUsed != null) {
			if (myParent.facetUsed.bOpeningObject.xCols >= 5) {
				font = new Font("SansSerif", 0, 8);
			}
			if (myParent.facetUsed.bOpeningObject.xCols >= 7) {
				font = new Font("SansSerif", 0, 8);
			}
			if (myParent.facetUsed.bOpeningObject.xCols >= 9) {
				font = new Font("SansSerif", 0, 7);
			}
			if (myParent.facetUsed.bOpeningObject.xCols >= 10) {
				font = new Font("SansSerif", 0, 6);
			}
			if (myParent.facetUsed.bOpeningObject.xCols >= 12) {
				font = new Font("SansSerif", 0, 5);
			}
		}

	}

	private void getMyFontOpening() {

		// this.font = new Font("SansSerif", 0, 9);
		// if (this.mySelectedFrame.xCols >= 5) {
		// this.font = new Font("SansSerif", 0, 8);
		// }
		// if (this.mySelectedFrame.xCols >= 7) {
		// this.font = new Font("SansSerif", 0, 8);
		// }
		// if (this.mySelectedFrame.xCols >= 9) {
		// this.font = new Font("SansSerif", 0, 7);
		// }
		// if (this.mySelectedFrame.xCols >= 10) {
		// this.font = new Font("SansSerif", 0, 6);
		// }
		// if (this.mySelectedFrame.xCols >= 12) {
		// this.font = new Font("SansSerif", 0, 5);
		// }
	}

	public void createTextFieldsFacet() {

		double xpos = 0;
		double xpose = 0;
		this.getMyFont();

		endX = myParent.jobItem.startingX
				+ myParent.jobItem.design_flat_WIDTHpix;

		endY = myParent.jobItem.startingY + myParent.jobItem._HEIGHTpix;

		int hgt = 10;
		int adv = 50;

		String myString = "";

		double startXrect = 0;

		gpTextFacetCol = myParent.fcolTextObjects.toArray();

		myParent.textFieldsFBot = gpTextFacetCol;

		gpTextXsFacet = myParent.fcolTextPosXs.toArray();

		gpTextXeFacet = myParent.fcolTextPosXe.toArray();

		myParent.myTextFacetBot = new JXTextField[myParent.textFieldsFBot.length];

		col = myParent.textFieldsFBot.length;

		if (col > 1) {
			for (int j = 0; j < myParent.textFieldsFBot.length; j++) {
				if (myParent.jobItem.g2 != null) {
					final FontMetrics metrics = myParent.jobItem.g2
							.getFontMetrics(font);

					myParent.jobItem.g2.getFontRenderContext();

					xpos = ((Double) gpTextXsFacet[j]).doubleValue();
					xpose = ((Double) gpTextXeFacet[j]).doubleValue();

					hgt = metrics.getHeight();

					adv = metrics.stringWidth(gpTextFacetCol[j] + "");
					if (myParent.myTopPanel.metric.isSelected()
							&& myParent.prevUOM <= 2) {

						myString = myParent.sixDecimal.format(Double
								.parseDouble(gpTextFacetCol[j].toString()));
						adv = metrics.stringWidth(myString);
					} else if (myParent.myTopPanel.metric.isSelected()
							&& myParent.prevUOM == 3) {
						myString = "";

						try {
							myString = UOMConvert
									.fractionToMetric(gpTextFacetCol[j]
											.toString());
						} catch (final Exception e) {
							e.printStackTrace();
						}

						myString = myParent.sixDecimal.format(Double
								.parseDouble(myString));
						adv = metrics.stringWidth(myString);
					} else if (myParent.myTopPanel.impFrac.isSelected()) {
						if (adv < 50) {
							adv = 53;
						}
					}

				}

				startXrect = xpos + (xpose - xpos - adv) / 2;

				myParent.myTextFacetBot[j] = new JXTextField();
				myParent.myTextFacetBot[j].setOpaque(true);
				myParent.myTextFacetBot[j].setBackground(Color.WHITE);
				myParent.myTextFacetBot[j].setBorder(BorderFactory
						.createEtchedBorder());

				myParent.myTextFacetBot[j]
						.setToolTipText("Please Press Enter to set size");

				myParent.myTextFacetBot[j]
						.setHorizontalAlignment(SwingConstants.CENTER);
				// this.getMyFont();
				myParent.myTextFacetBot[j].setFont(font);

				myParent.myTextFacetBot[j].setPreferredSize(new Dimension(
						adv + 4, hgt + 4));
				myParent.myTextFacetBot[j].setMinimumSize(new Dimension(
						adv + 4, hgt + 4));
				myParent.myTextFacetBot[j].setAlignmentX(CENTER_ALIGNMENT);

				myParent.myTextFacetBot[j].setDisabledTextColor(Color.BLACK);
				myParent.myTextFacetBot[j].removeAll();
				myParent.myTextFacetBot[j].setText("");

				this.add(myParent.myTextFacetBot[j], new XYConstraints(
						(int) startXrect, (int) endY + 17, adv + 6, hgt + 4));

				myParent.myTextFacetBot[j].setText(myParent.textFieldsFBot[j]
						.toString());
				myParent.myTextFacetBot[j].setEnabled(false);
				if (myParent.textFieldsFBot.length > 1) {
					myParent.myTextFacetBot[j].setEditable(true);
					myParent.myTextFacetBot[j].setVisible(true);
					myParent.myTextFacetBot[j].setEnabled(true);
				}
				myAction = new ActionListener() {

					@Override
					public void actionPerformed(final ActionEvent e) {

						DrawCanvas.this.myTextFacetBot_actionPerformed(e);
					}

				};
				myParent.myTextFacetBot[j].addActionListener(myAction);
				myParent.myTextFacetBot[j].addFocusListener(new FocusAdapter() {

					@Override
					public void focusLost(final FocusEvent e) {

					}

					@Override
					public void focusGained(final FocusEvent e) {

						//
						((JXTextField) e.getSource()).selectAll();
					}

				});

				myParent.myTextFacetBot[j].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(final MouseEvent e) {

						//
						((JXTextField) e.getSource()).selectAll();
					}

				});

			}
		}

		final Object[] textsFacet = myParent.fcolTexts.toArray();

		for (int j = 0; j < textsFacet.length; j++) {
			if (myParent.myTextFacetBot != null
					&& myParent.myTextFacetBot.length > 0
					&& myParent.myTextFacetBot[j] != null) {
				if (j == myParent.lastFB - 1 && myParent.myTextFacetBot != null) {
					// if (myParent.layoutP!=null &&
					// !myParent.layoutP.bay.isSelected() &&
					// !myParent.layoutP.bow.isSelected()) {
					myParent.myTextFacetBot[j].setEnabled(true);
					// } else {
					// myParent.myTextFacetBot[j].setEnabled(false);
					// }
				} else {
					myParent.myTextFacetBot[j].setEnabled(false);
				}
			}
		}

	}

	public void createRadioforFacets(final int col) { // Horizontal

		myParent.radioForFacetBot = new ButtonGroup();
		final ShapeObject ov = myParent.jobItem.design;
		final Object[] mVs = myParent.jobItem.design.bOpeningObject.mullions
				.toArray();
		final int cols = mVs.length + 1;

		final int endY = (int) (myParent.jobItem.startingY + ov.heightPix);
		if (cols >= 2) {
			myParent.mainFacetCheckBot = new JCheckBox[cols];
			myParent.frcPosx = new int[cols];
			for (int c = 0; c < cols; c++) {
				myParent.mainFacetCheckBot[c] = new JCheckBox();

				if (c + 1 == col) {
					// myParent.radioFacetBot[c]
					// .setSelected(true);
				}
			}
			double xs = 0;
			double xe = 0;
			int xc = 0;

			// Object[] mVs = ov.bOpeningObject.mullions.toArray();
			// ov.bOpeningObject.mullionsH.toArray();
			//
			for (int i = 0; i < cols; i++) {
				if (i == 0) {
					for (final Object element : mVs) {
						if (((Profiles) mVs[i]).rowCol == 1) {
							xe = ((Profiles) element).x1;
							break;
						}

					}

					xs = Math.min(ov.startingX, ov.bX4);

					xc = (int) xs + (int) ((xe - xs) / 2) - 15;
					// if (i + 1 == col)
					// {
					// // myParent.radioFacetBot[i]
					// .setSelected(true);
					// }
					// else
					// {
					// myParent.radioFacetBot[i]
					// .setSelected(false);
					// }

					myParent.radioForFacetBot
							.add(myParent.mainFacetCheckBot[i]);
					myParent.mainFacetCheckBot[i].setFont(new Font("SansSerif",
							0, 10));
					myParent.mainFacetCheckBot[i].setIconTextGap(0);
					myParent.mainFacetCheckBot[i].setToolTipText(i + 1 + "");
					this.add(myParent.mainFacetCheckBot[i], new XYConstraints(
							xc + 8, endY + 35, 17, 17));
					myParent.frcPosx[i] = xc;
					myParent.mainFacetCheckBot[i].setVisible(true);

				} else if (i == ov.bOpeningObject.xCols - 1) {
					xe = ov.bX2;
					for (final Object element : ov.bOpeningObject.mullionObjectsV) {
						if (((Profiles) element).rowCol == i) {
							xs = ((Profiles) element).x2;
							break;
						}
					}

					xc = (int) xs + (int) ((xe - xs) / 2) - 15;
					// myParent.radioFacetBot[i]
					// .setSelected(true);

					myParent.radioForFacetBot
							.add(myParent.mainFacetCheckBot[i]);
					myParent.mainFacetCheckBot[i].setFont(new Font("SansSerif",
							0, 10));
					myParent.mainFacetCheckBot[i].setIconTextGap(0);
					myParent.mainFacetCheckBot[i].setToolTipText(i + 1 + "");
					this.add(myParent.mainFacetCheckBot[i], new XYConstraints(
							xc + 8, endY + 35, 17, 17));
					myParent.frcPosx[i] = xc;
					myParent.mainFacetCheckBot[i].setVisible(true);

				} else {
					for (final Object element : ov.bOpeningObject.mullionObjectsV) {
						if (((Profiles) element).rowCol == i) {
							xs = ((Profiles) element).x2;
							break;
						}
					}
					for (final Object element : ov.bOpeningObject.mullionObjectsV) {
						if (((Profiles) element).rowCol == i + 1) {
							xe = ((Profiles) element).x1;
							break;
						}
					}

					xc = (int) xs + (int) ((xe - xs) / 2) - 15;

					myParent.radioForFacetBot
							.add(myParent.mainFacetCheckBot[i]);
					myParent.mainFacetCheckBot[i].setFont(new Font("SansSerif",
							0, 10));
					myParent.mainFacetCheckBot[i].setIconTextGap(0);
					myParent.mainFacetCheckBot[i].setToolTipText("" + (i + 1));
					this.add(myParent.mainFacetCheckBot[i], new XYConstraints(
							xc + 8, endY + 35, 17, 17));
					myParent.frcPosx[i] = xc;
					myParent.mainFacetCheckBot[i].setVisible(true);

				}
				myActionRadioCol = new ActionListener() {

					@Override
					public void actionPerformed(final ActionEvent e) {

						DrawCanvas.this.radioFacetBot_Action(e);
					}

				};
				myParent.mainFacetCheckBot[i]
						.addActionListener(myActionRadioCol);
				myParent.mainFacetCheckBot[i]
						.addMouseListener(new MouseAdapter() {

							@Override
							public void mouseClicked(final MouseEvent e) {

								DrawCanvas.this.radioCol_MouseClicked(e);
							}

						});
			}
			myParent.mainFacetCheckBot[myParent.lastFB - 1].setSelected(true);
		}
		validate();
		repaint();
	}

	public void createTextFieldsCoupler() {

		double xpos = 0;
		double ypos = 0;
		this.getMyFont();

		final Object[] myMs = myParent.jobItem.design.bOpeningObject.mullions
				.toArray();
		myParent.couplerTexts = new ArrayList();
		myParent.textFieldsCoupler = null;
		for (final Object m : myMs) {

			if (((Profiles) m).orientation == 1
					&& ((Profiles) m).posCondition == 1
					&& ((Profiles) m).cOrM == 1
					&& (((Profiles) m).angle != 180 || !((Profiles) m).fixedAngle)) {
				myParent.couplerText = new CouplerText(((Profiles) m).angle,
						((Profiles) m).fixedAngle, ((Profiles) m).centerXe,
						((Profiles) m).centerYe);

				myParent.couplerTexts.add(myParent.couplerText);

			}
		}

		int hgt = 10;
		int adv = 50;

		final Object[] myCT = myParent.couplerTexts.toArray();
		String myString = "";

		if (myParent.jobItem.g2 != null) {
			final FontMetrics metrics = myParent.jobItem.g2
					.getFontMetrics(font);

			myParent.jobItem.g2.getFontRenderContext();

			for (int j = 0; j < myCT.length; j++) {

				hgt = metrics.getHeight();

				myString = ((CouplerText) myCT[j]).angle + "?";

				adv = metrics.stringWidth(myString);
			}

		}

		myParent.myTextCoupler = new JXTextField[myParent.couplerTexts.size()];

		col = myParent.couplerTexts.size() + 1;

		for (int j = 0; j < myCT.length; j++) {

			xpos = ((CouplerText) myCT[j]).centerX - adv / 2;

			ypos = ((CouplerText) myCT[j]).endY;

			myParent.myTextCoupler[j] = new JXTextField();

			myParent.myTextCoupler[j].setBorder(BorderFactory
					.createLineBorder(new Color(0, 200, 0)));

			myParent.myTextCoupler[j]
					.setToolTipText("Please Press Enter to set Angle");

			myParent.myTextCoupler[j]
					.setHorizontalAlignment(SwingConstants.CENTER);

			myParent.myTextCoupler[j].setFont(font);

			myParent.myTextCoupler[j].setAlignmentX(CENTER_ALIGNMENT);

			myParent.myTextCoupler[j].setDisabledTextColor(Color.BLACK);
			myParent.myTextCoupler[j].removeAll();
			myParent.myTextCoupler[j].setText("");
			myParent.myTextCoupler[j].setText(myString);

			if (myParent.layoutP != null && !myParent.layoutP.flat.isSelected()) {
				myParent.myTextCoupler[j].setVisible(true);
			} else {
				myParent.myTextCoupler[j].setVisible(false);
			}

			myParent.myTextCoupler[j].setOpaque(true);

			myParent.myTextCoupler[j].setEditable(true);

			if (!((CouplerText) myCT[j]).isFixed
					&& !myParent.layoutP.bay.isSelected()
					&& !myParent.layoutP.bow.isSelected()) {
				this.add(myParent.myTextCoupler[j], new XYConstraints(
						(int) xpos, (int) ypos + 7, adv + 6, hgt + 2));

				myParent.myTextCoupler[j].setEnabled(true);

			}

			myAction = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.myTextBot_actionPerformed(e);
				}

			};
			myParent.myTextCoupler[j].addActionListener(myAction);
			myParent.myTextCoupler[j].addFocusListener(new FocusAdapter() {

				@Override
				public void focusLost(final FocusEvent e) {

					DrawCanvas.this.myTextBot_focusLost(e);
				}

				@Override
				public void focusGained(final FocusEvent e) {

					DrawCanvas.this.myTextBot_focusGained(e);
				}

			});

			myParent.myTextCoupler[j].addKeyListener(new KeyAdapter() {

				@Override
				public void keyReleased(final KeyEvent e) {

					DrawCanvas.this.myTextBot_keyReleased(e);
				}

			});

		}

		if (myParent.layoutP != null && myParent.layoutP.flat.isSelected()
				&& myParent.couplerTexts.size() > 0) {
			// Get Error Type by Number from DB
			// table system
			// Errors by language
			final Object[] err = myParent.errors.toArray();
			myParent.errors.clear();
			for (final Object er : err) {
				if (((ErrorMessage) er).type != 1) {
					myParent.errors.add(er);
				}
			}
			final ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.type = 1;
			errorMessage.typeDesc = " System Error";
			errorMessage.errorDesc = "Angled Coupler in Flat Layout.\nChoose 180° Coupler (Fixed or variable)";

			myParent.errors.add(errorMessage);

		} else {
			final Object[] err = myParent.errors.toArray();
			myParent.errors.clear();
			for (final Object er : err) {
				if (((ErrorMessage) er).type != 1) {
					myParent.errors.add(er);
				}
			}
			if (myParent.errors.size() == 0) {
				myParent.myTabs.remove(myParent.errorsPanel);
			}

		}
		if (myParent.errors.size() > 0
				&& myParent.myTabs.indexOfTab(myParent.errorImage) != 0) {

			myParent.myTabs.addTab("", myParent.errorImage,
					myParent.errorsPanel, myParent.errorTip);

			// myParent.isave.setEnabled(false);

		} else {
			myParent.btnSave.setEnabled(true);
		}

	}

	/**
	 * This method create radio button for selection column design
	 * 
	 * @param col
	 *            , Column selection value
	 * @param ov
	 *            , ShapeObject selection object
	 */
	public void createChecksforCols(final int col, final ShapeObject ov) { // Horizontal

		selectedRadioForCol = col;
		myParent.radioForCol = new ButtonGroup();
		myParent.topChecks.removeAll();
		final Object[] mVs = ov.bOpeningObject.mullionObjectsV = ov.bOpeningObject.mullions
				.toArray();
		final Object[] openings = ov.openings.toArray();

		// int cols =ov.xCols;

		final int cols = 0;
		final Collection myOpenings = new ArrayList();
		for (final Object op : openings) {
			if (((OpeningObject) op).startRow == this.selectedRadioForRow) {
				myOpenings.add(op);
			}
		}
		final Object[] myOs = myOpenings.toArray();

		myParent.mainColCheck = new JCheckBox[myOs.length];
		myParent.rcPosx = new int[myOs.length];

		double xs = 0;
		double xe = 0;
		int xc = 0;
		myParent.leftChecks.removeAll();
		int count = 0;
		for (final Object element : myOs) {
			myParent.mainColCheck[count] = new JCheckBox();
			myParent.mainColCheck[count].setIconTextGap(0);

			this.remove(myParent.mainColCheck[count]);

			OpeningObject minWO = new OpeningObject(myParent);
			double minW = 99999999;

			for (final Object ops : openings) {
				if (((OpeningObject) ops).startCol == ((OpeningObject) element).startCol) {
					if (((OpeningObject) ops).widthPix < minW) {
						minWO = (OpeningObject) ops;
						minW = ((OpeningObject) ops).widthPix;
					}
				}
			}
			xe = Math.min(minWO.startingX, minWO.bX4) + minW;

			xs = Math.min(minWO.startingX, minWO.bX4);

			xc = (int) xs + (int) ((xe - xs) / 2);
			if (((OpeningObject) element).startCol == this.selectedRadioForCol) {
				myParent.mainColCheck[count].setSelected(true);
			} else {
				myParent.mainColCheck[count].setSelected(false);
			}

			myParent.radioForCol.add(myParent.mainColCheck[count]);
			myParent.mainColCheck[count].setFont(new Font("SansSerif", 0, 10));
			myParent.mainColCheck[count].setIconTextGap(0);
			myParent.mainColCheck[count]
					.setToolTipText(((OpeningObject) element).startCol + "");

			// this.add(myParent.mainColCheck[count], new XYConstraints(xc + 4,
			// 0, 18, 18));

			myParent.topChecks.add(myParent.mainColCheck[count],
					new XYConstraints(xc + 30, -3, 18, 18));

			myParent.rcPosx[count] = xc;
			myParent.mainColCheck[count].setVisible(true);

			if (myOs.length == 1) {
				myParent.mainColCheck[count].setSelected(true);
				myParent.mainColCheck[count].setEnabled(false);
			}

			myActionRadioCol = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.radioCol_actionPerformed(e);
				}

			};
			myParent.mainColCheck[count].addActionListener(myActionRadioCol);
			myParent.mainColCheck[count].addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(final MouseEvent e) {

					DrawCanvas.this.radioCol_MouseClicked(e);
				}

			});

			count++;
		}

		validate();
		repaint();
	}

	/**
	 * This method create text fields top for dimension update
	 */
	public void createTextFieldsTop() {

		// ******************************************************
		// Init collections for dimension type
		// ******************************************************
		if (this.dimensionType == 1) {
			this.gpText = myParent.colTextObjectsc.toArray();
			this.myParent.textFieldsTop = gpText;
			this.gpTextXs = myParent.colTextPosXsc.toArray();
			this.gpTextXe = myParent.colTextPosXec.toArray();
		} else if (this.dimensionType == 2) {
			this.gpText = myParent.colTextObjects.toArray();
			this.myParent.textFieldsTop = gpText;
			this.gpTextXs = myParent.colTextPosXs.toArray();
			this.gpTextXe = myParent.colTextPosXe.toArray();
		} else if (this.dimensionType == 3) {
			this.gpText = myParent.colTextObjectsc.toArray();
			this.myParent.textFieldsTop = gpText;
			this.gpTextXs = myParent.colTextPosXsc.toArray();
			this.gpTextXe = myParent.colTextPosXec.toArray();
		} else if (this.dimensionType == 4) {
			this.gpText = myParent.colTextObjects.toArray();
			this.myParent.textFieldsTop = gpText;
			this.gpTextXs = myParent.colTextPosXs.toArray();
			this.gpTextXe = myParent.colTextPosXe.toArray();
		} else if (this.dimensionType == 5) {
			this.gpText = myParent.colTextObjectsc.toArray();
			this.myParent.textFieldsTop = gpText;
			this.gpTextXs = myParent.colTextPosXsc.toArray();
			this.gpTextXe = myParent.colTextPosXec.toArray();
		} else if (this.dimensionType >= 6) {
			this.gpText = myParent.colTextObjects.toArray();
			this.myParent.textFieldsTop = gpText;
			this.gpTextXs = myParent.colTextPosXs.toArray();
			this.gpTextXe = myParent.colTextPosXe.toArray();
		}

		// Reset end x & y position
		this.endX = myParent.jobItem.startingX
				+ myParent.jobItem.design_flat_WIDTHpix;
		this.endY = myParent.jobItem.startingY + myParent.jobItem._HEIGHTpix;

		// Init startX position rect
		double startXrect = 0;

		// Init array text fields row from collection length
		this.myParent.myTextRow = new JXTextField[myParent.textFieldsTop.length];
		// Init number of columns from tet fields length
		this.col = myParent.textFieldsTop.length;

		// Init font value
		this.getMyFont();

		// Get font metrics
		FontMetrics metrics = this.getFontMetrics(font);

		// Init x positions
		double xpos;
		double xpose;
		int hgt = 10;
		int adv = 50;

		String myString = "";

		for (int j = 0; j < myParent.textFieldsTop.length; j++) {

			// Update values for x positions
			xpos = (Double) gpTextXs[j];
			xpose = (Double) gpTextXe[j];

			// Update height text metrics
			hgt = metrics.getHeight();
			adv = metrics.stringWidth(gpText[j] + "");

			if (myParent.myTopPanel.metric.isSelected()
					&& myParent.prevUOM <= 2) {
				myString = myParent.sixDecimal.format(Double
						.parseDouble((String) gpText[j]));
				adv = metrics.stringWidth(myString);
			} else if (myParent.myTopPanel.metric.isSelected()
					&& myParent.prevUOM == 3) {
				myString = "";
				try {
					myString = UOMConvert.fractionToMetric((String) gpText[j]);
				} catch (Exception e) {
					e.printStackTrace();
				}
				myString = myParent.sixDecimal.format(Double
						.parseDouble(myString));
				adv = metrics.stringWidth(myString);

			} else if (myParent.myTopPanel.impFrac.isSelected()) {

				if (adv < 50) {
					adv = 53;
				}
			}

			// Update start rectangular value
			startXrect = xpos + (xpose - xpos - adv) / 2;

			// **********************************************************************
			// Create new TextField top object
			// **********************************************************************
			myParent.myTextRow[j] = new JXTextField();
			myParent.myTextRow[j].setOpaque(true);
			myParent.myTextRow[j].setBackground(Color.WHITE);
			myParent.myTextRow[j].setHorizontalAlignment(SwingConstants.CENTER);
			myParent.myTextRow[j].setBorder(BorderFactory.createEtchedBorder());
			myParent.myTextRow[j].setPreferredSize(new Dimension(adv + 4,
					hgt + 4));
			myParent.myTextRow[j]
					.setMinimumSize(new Dimension(adv + 4, hgt + 4));
			myParent.myTextRow[j]
					.setToolTipText("Please Press Enter to set size");
			myParent.myTextRow[j].setAlignmentX(CENTER_ALIGNMENT);
			myParent.myTextRow[j].setDisabledTextColor(Color.BLACK);
			myParent.myTextRow[j].setFont(font);
			myParent.myTextRow[j].removeAll();
			myParent.myTextRow[j].setText((String) myParent.textFieldsTop[j]);
			myParent.myTextRow[j].setEnabled(false);
			myParent.myTextRow[j].setName(j + 1 + "");

			// Adding text field to Draw Canvas
			this.add(myParent.myTextRow[j], new XYConstraints((int) startXrect,
					(int) myParent.jobItem.startingY - 25 - (hgt + 2) / 2,
					adv + 6, hgt + 4));

			// Adding action events and selection editable values if text
			// fields top is more than 1
			if (myParent.textFieldsTop.length > 1
					|| myParent.myTopPanel.stdButton.isSelected()) {

				// Setting enabled and editable values
				myParent.myTextRow[j].setEditable(true);
				myParent.myTextRow[j].setVisible(true);
				myParent.myTextRow[j].setEnabled(true);

				// Adding action listener
				myParent.myTextRow[j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						changeDimDone = false;
						DrawCanvas.this.myTextRow_actionPerformed(e);

					}
				});

				// Adding focus listener
				myParent.myTextRow[j].addFocusListener(new FocusAdapter() {

					@Override
					public void focusLost(FocusEvent e) {

						changeDimDone = false;
						DrawCanvas.this.myTextRow_focusLost(e);

					}

					@Override
					public void focusGained(FocusEvent e) {

						DrawCanvas.this.myTextRow_focusGained(e);
					}
				});

				// Adding key listener
				myParent.myTextRow[j].addKeyListener(new KeyAdapter() {

					@Override
					public void keyReleased(final KeyEvent e) {

						DrawCanvas.this.myTextRow_keyReleased(e);

					}
				});

				// Adding mouse listener
				myParent.myTextRow[j].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(final MouseEvent e) {

						DrawCanvas.this.myTextTop_MouseClicked(e);

					}
				});
			}
		}
	}

	/**
	 * This method creates text fields left for dimensions update
	 */
	public void createTextFieldsLeft() {

		// ******************************************************
		// Init collections for dimension type
		// ******************************************************
		if (dimensionType == 1) {
			gpTextrow = myParent.rowTextObjectsc.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYsc.toArray();
			gpTextXerow = myParent.rowTextPosYec.toArray();
		} else if (dimensionType == 2) {
			gpTextrow = myParent.rowTextObjects.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYs.toArray();
			gpTextXerow = myParent.rowTextPosYe.toArray();
		} else if (dimensionType == 3) {
			gpTextrow = myParent.rowTextObjectsc.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYsc.toArray();
			gpTextXerow = myParent.rowTextPosYec.toArray();
		} else if (dimensionType == 4) {
			gpTextrow = myParent.rowTextObjects.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYs.toArray();
			gpTextXerow = myParent.rowTextPosYe.toArray();
		} else if (dimensionType == 5) {
			gpTextrow = myParent.rowTextObjectsc.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYsc.toArray();
			gpTextXerow = myParent.rowTextPosYec.toArray();
		} else if (dimensionType >= 6) {
			gpTextrow = myParent.rowTextObjects.toArray();
			myParent.textFieldsLeft = gpTextrow;
			gpTextXsrow = myParent.rowTextPosYs.toArray();
			gpTextXerow = myParent.rowTextPosYe.toArray();
		}

		// Init array text fields row from collection length
		this.myParent.myTextLeft = new JXTextField[myParent.textFieldsLeft.length];

		// Reset end x & y position
		this.endX = myParent.jobItem.startingX
				+ myParent.jobItem.design_flat_WIDTHpix;
		this.endY = myParent.jobItem.startingY + myParent.jobItem._HEIGHTpix;

		// Init font value
		this.getMyFont();

		// Get font metrics
		FontMetrics metrics = this.getFontMetrics(font);

		// Init startY position rect
		double startYrect = 0;

		// Init y positions
		double ypos;
		double ypose;
		int hgt = 10;
		int adv = 50;

		String myString = "";

		for (int j = 0; j < myParent.textFieldsLeft.length; j++) {

			// Update values for Y positions
			ypos = ((Double) gpTextXsrow[j]).doubleValue();
			ypose = ((Double) gpTextXerow[j]).doubleValue();

			// Get the height of a line of text in this font and render
			// context
			hgt = metrics.getHeight();
			// Get the advance of my text in this font and render context
			adv = metrics.stringWidth((String) myParent.textFieldsLeft[j]);

			if (myParent.myTopPanel.metric.isSelected()
					&& myParent.prevUOM <= 2) {
				myString = myParent.sixDecimal.format(Double
						.parseDouble((String) myParent.textFieldsLeft[j]));
				adv = metrics.stringWidth(myString);
			} else if (myParent.myTopPanel.metric.isSelected()
					&& myParent.prevUOM == 3) {
				myString = "";
				try {
					myString = UOMConvert
							.fractionToMetric((String) myParent.textFieldsLeft[j]);
				} catch (final Exception e) {
					e.printStackTrace();
				}

				myString = myParent.sixDecimal.format(Double
						.parseDouble(myString));
				adv = metrics.stringWidth(myString);

			} else if (myParent.myTopPanel.impFrac.isSelected()) {
				if (adv < 50) {
					adv = 53;
				}
			}

			// Update start Y rectangular position
			startYrect = ypos + (ypose - ypos - hgt) / 2;

			// **********************************************************************
			// Create new TextField left object
			// **********************************************************************
			myParent.myTextLeft[j] = new JXTextField();
			myParent.myTextLeft[j].setOpaque(true);
			myParent.myTextLeft[j].setBackground(Color.WHITE);
			myParent.myTextLeft[j]
					.setBorder(BorderFactory.createEtchedBorder());
			myParent.myTextLeft[j].setAlignmentX(CENTER_ALIGNMENT);
			myParent.myTextLeft[j]
					.setHorizontalAlignment(SwingConstants.CENTER);
			myParent.myTextLeft[j].setPreferredSize(new Dimension(adv + 4,
					hgt + 4));
			myParent.myTextLeft[j].setMinimumSize(new Dimension(adv + 4,
					hgt + 4));
			myParent.myTextLeft[j]
					.setToolTipText("Please Press Enter to set size");
			myParent.myTextLeft[j].setDisabledTextColor(Color.BLACK);
			myParent.myTextLeft[j].setFont(font);
			myParent.myTextLeft[j].removeAll();
			myParent.myTextLeft[j].setText((String) myParent.textFieldsLeft[j]);
			myParent.myTextLeft[j].setEnabled(false);
			myParent.myTextLeft[j].setName(j + 1 + "");

			// Adding text field to draw canvas
			this.add(myParent.myTextLeft[j], new XYConstraints(
					(int) myParent.jobItem.startingX - 30 - (adv + 2),
					(int) startYrect, adv + 6, hgt + 4));

			// Adding action events and selection editable values if text
			// fields top is more than 1
			if (myParent.textFieldsLeft.length > 1
					|| myParent.myTopPanel.isStdSelected) {

				// Setting enabled and editable values
				myParent.myTextLeft[j].setEditable(true);
				myParent.myTextLeft[j].setVisible(true);
				myParent.myTextLeft[j].setEnabled(true);

				// Adding Action Listener
				myParent.myTextLeft[j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						changeDimDone = false;
						DrawCanvas.this.myTextColLeft_actionPerformed(e);
					}
				});

				// Adding Focus Listener
				myParent.myTextLeft[j].addFocusListener(new FocusAdapter() {

					@Override
					public void focusLost(final FocusEvent e) {

						changeDimDone = false;
						DrawCanvas.this.myTextColLeft_focusLost(e);
					}

					@Override
					public void focusGained(final FocusEvent e) {

						DrawCanvas.this.myTextColLeft_focusGained(e);
					}
				});

				// Adding Key Listener
				myParent.myTextLeft[j].addKeyListener(new KeyAdapter() {

					@Override
					public void keyReleased(final KeyEvent e) {

						DrawCanvas.this.myTextRow_keyReleased(e);
					}
				});

				// Adding Mouse Listener
				myParent.myTextLeft[j].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(final MouseEvent e) {

						DrawCanvas.this.myTextLeft_MouseClicked(e);
					}
				});
			}
		}
	}

	public void createChecksforRows(final int row, final ShapeObject ov) { // Horizontal

		selectedRadioForRow = row;
		myParent.radioForRows = new ButtonGroup();
		ov.bOpeningObject.mullionObjectsH = ov.bOpeningObject.mullionsH
				.toArray();
		myParent.leftChecks.removeAll();
		// final int rows = ov.bOpeningObject.yRows;

		final Object[] openings = ov.openings.toArray();

		final Collection myOpenings = new ArrayList();
		for (final Object op : openings) {
			if (((OpeningObject) op).startCol == this.selectedRadioForCol) {
				myOpenings.add(op);
			}
		}

		final Object[] myOs = myOpenings.toArray();

		myParent.mainRowCheck = new JCheckBox[myOs.length];

		myParent.rrPosy = new int[myOs.length];

		double ys = 0;
		double ye = 0;
		int yc = 0;
		int count = 0;

		for (final Object element : myOs) {

			myParent.mainRowCheck[count] = new JCheckBox();
			myParent.mainRowCheck[count].setIconTextGap(0);

			this.remove(myParent.mainRowCheck[count]);

			OpeningObject minHO = new OpeningObject(myParent);
			double minH = 99999999;

			for (final Object ops : openings) {
				if (((OpeningObject) ops).startRow == ((OpeningObject) element).startRow) {
					if (((OpeningObject) ops).heightPix < minH) {
						minHO = (OpeningObject) ops;
						minH = ((OpeningObject) ops).heightPix;
					}
				}
			}

			ye = minHO.highestYC + minH;
			ys = minHO.highestYC;
			yc = (int) ys + (int) ((ye - ys) / 2);
			if (((OpeningObject) element).startRow == this.selectedRadioForRow) {
				myParent.mainRowCheck[count].setSelected(true);

			} else {
				myParent.mainRowCheck[count].setSelected(false);
			}

			myParent.radioForRows.add(myParent.mainRowCheck[count]);
			myParent.mainRowCheck[count].setFont(new Font("SansSerif", 0, 10));
			myParent.mainRowCheck[count].setIconTextGap(0);
			myParent.mainRowCheck[count]
					.setToolTipText(((OpeningObject) element).startRow + "");

			// this.add(myParent.mainRowCheck[count], new XYConstraints(1, yc,
			// 40, 17));

			myParent.leftChecks.add(myParent.mainRowCheck[count],
					new XYConstraints(-3, yc - 8, 18, 18));

			myParent.rrPosy[count] = yc;
			myParent.mainRowCheck[count].setVisible(true);

			if (myOs.length == 1) {
				myParent.mainRowCheck[count].setSelected(true);
				myParent.mainRowCheck[count].setEnabled(false);
			}

			myActionRadioRow = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.radioRow_actionPerformed(e);
				}

			};
			myParent.mainRowCheck[count].addActionListener(myActionRadioRow);
			myParent.mainRowCheck[count].addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(final MouseEvent e) {

					DrawCanvas.this.radioRow_MouseClicked(e);
				}

			});

			count++;
		}
		validate();
		repaint();
	}

	public void createRadiosForOpeningRows(final ShapeObject myFrame) { // Horizontal

		myParent.radioForRowOpening = new ButtonGroup();
		mySelectedFrame = myFrame;
		myParent.mySelectedFrame = myFrame;

		final Object[] openings = myFrame.openings.toArray();

		final Collection allOpenings = new ArrayList();

		for (final Object op : openings) {

			if (((OpeningObject) op).startCol == this.selectedRadioForColo) {
				allOpenings.add(op);
			}

		}
		final Object[] allOs = allOpenings.toArray();

		int q = 0;
		boolean f = false;
		if (myFrame.bOpeningObject.yRows > 1) {
			do {
				if (((OpeningObject) allOs[q]).startRow == selectedRadioForRowo
						&& ((OpeningObject) allOs[q]).contentMid != 1) {
					selectedRadioForRowo++;
				}
				if (((OpeningObject) allOs[q]).startRow == selectedRadioForRowo
						&& ((OpeningObject) allOs[q]).contentMid == 1) {
					f = true;
				}
				q++;
			} while (!f);
		}

		final Collection myOpenings = new ArrayList();

		for (final Object op : openings) {
			if (myFrame.bOpeningObject.yRows > 1) {
				if (((OpeningObject) op).startCol == this.selectedRadioForColo
						&& ((OpeningObject) op).contentMid == 1) {
					myOpenings.add(op);
				}
			} else {
				if (((OpeningObject) op).startCol == this.selectedRadioForColo) {
					myOpenings.add(op);
					break;
				}
			}
		}

		final Object[] myOs = myOpenings.toArray();

		myParent.radioRowOpening = new JRadioButton[myOs.length];
		myParent.rrPosyo = new int[myOs.length];

		double ys = 0;
		double ye = 0;
		int yc = 0;

		int count = 0;
		for (final Object element : myOs) {
			myParent.radioRowOpening[count] = new JRadioButton();

			myParent.radioRowOpening[count].setIconTextGap(0);

			OpeningObject minHO = new OpeningObject(myParent);
			double minH = 10000;

			for (final Object ops : openings) {
				if (((OpeningObject) ops).startRow == ((OpeningObject) element).startRow) {
					if (((OpeningObject) ops).heightPix < minH) {
						minHO = (OpeningObject) ops;
						minH = ((OpeningObject) ops).heightPix;
					}
				}
			}

			ye = minHO.highestYC + minH;
			ys = minHO.highestYC;
			yc = (int) ys + (int) ((ye - ys) / 2);

			myParent.radioRowOpening[count]
					.setFont(new Font("SansSerif", 0, 10));

			myParent.radioRowOpening[count]
					.setToolTipText(((OpeningObject) element).startRow + "");

			myParent.leftChecks.add(myParent.radioRowOpening[count],
					new XYConstraints(20, yc - 8, 16, 16));

			myParent.rrPosyo[count] = yc;

			if (myOs.length == 1) {
				myParent.radioRowOpening[count].setSelected(true);
				myParent.radioRowOpening[count].setEnabled(false);
			}

			if (((OpeningObject) element).startRow == this.selectedRadioForRowo) {
				myParent.radioRowOpening[count].setSelected(true);

			} else {
				myParent.radioRowOpening[count].setSelected(false);
			}

			myActionRadioRowo = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.radioRowo_actionPerformed(e);
				}

			};
			myParent.radioRowOpening[count]
					.addActionListener(myActionRadioRowo);
			myParent.radioRowOpening[count]
					.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(final MouseEvent e) {

							DrawCanvas.this.radioRowo_MouseClicked(e);
						}

					});

			myParent.radioForRowOpening.add(myParent.radioRowOpening[count]);
			count++;
		}

		// readyToDraw = true;
		validate();
		repaint();
	}

	public void createRadiosForOpeningCols(final ShapeObject myFrame) { // Horizontal

		myParent.radioForColOpening = new ButtonGroup();
		mySelectedFrame = myFrame;
		myParent.mySelectedFrame = myFrame;
		final Object[] openings = myFrame.openings.toArray();

		final Collection allOpenings = new ArrayList();

		for (final Object op : openings) {

			if (((OpeningObject) op).startRow == this.selectedRadioForRowo) {
				allOpenings.add(op);
			}

		}
		final Object[] allOs = allOpenings.toArray();

		int q = 0;
		boolean f = false;
		if (myFrame.bOpeningObject.xCols > 1) {
			do {
				if (((OpeningObject) allOs[q]).startCol == selectedRadioForColo
						&& ((OpeningObject) allOs[q]).contentMid != 1) {
					selectedRadioForColo++;
				}
				if (((OpeningObject) allOs[q]).startCol == selectedRadioForColo
						&& ((OpeningObject) allOs[q]).contentMid == 1) {
					f = true;
				}
				q++;
			} while (!f && q < allOs.length);
		}

		final int cols = 0;
		final Collection myOpenings = new ArrayList();
		for (final Object op : openings) {
			if (myFrame.bOpeningObject.xCols > 1) {
				if (((OpeningObject) op).startRow == this.selectedRadioForRowo
						&& ((OpeningObject) op).contentMid == 1) {
					myOpenings.add(op);
				}
			} else {
				if (((OpeningObject) op).startRow == this.selectedRadioForRowo) {
					myOpenings.add(op);
				}
			}
		}
		final Object[] myOs = myOpenings.toArray();

		myParent.radioColOpening = new JRadioButton[myOs.length];
		// if (myOs.length >= 2)
		// {

		myParent.rcPosxo = new int[myOs.length];

		double xs = 0;
		double xe = 0;
		int xc = 0;

		int count = 0;
		for (final Object element : myOs) {
			myParent.radioColOpening[count] = new JRadioButton();
			myParent.radioColOpening[count].setIconTextGap(0);
			OpeningObject minWO = new OpeningObject(myParent);
			double minW = 10000;

			for (final Object ops : openings) {
				if (((OpeningObject) ops).startCol == ((OpeningObject) element).startCol) {
					if (((OpeningObject) ops).widthPix < minW) {
						minWO = (OpeningObject) ops;
						minW = ((OpeningObject) ops).widthPix;
					}
				}
			}
			xe = Math.min(minWO.startingX, minWO.bX4) + minW;

			xs = Math.min(minWO.startingX, minWO.bX4);

			xc = (int) xs + (int) ((xe - xs) / 2);

			if (((OpeningObject) element).startCol == this.selectedRadioForColo) {
				myParent.radioColOpening[count].setSelected(true);
			} else {
				myParent.radioColOpening[count].setSelected(false);
			}

			myParent.radioColOpening[count]
					.setFont(new Font("SansSerif", 0, 10));
			myParent.radioColOpening[count].setIconTextGap(0);
			myParent.radioColOpening[count]
					.setToolTipText(((OpeningObject) element).startCol + "");

			myParent.topChecks.add(myParent.radioColOpening[count],
					new XYConstraints(xc + 30, 22, 16, 16));

			myParent.rcPosxo[count] = xc;

			if (myOs.length == 1) {
				myParent.radioColOpening[count].setSelected(true);
				// myParent.radioColOpening[count]
				// .setEnabled(false);
			}

			myActionRadioCol = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.radioColo_actionPerformed(e);
				}

			};
			myParent.radioColOpening[count].addActionListener(myActionRadioCol);
			myParent.radioColOpening[count]
					.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(final MouseEvent e) {

							DrawCanvas.this.radioRowo_MouseClicked(e);
						}

					});

			myParent.radioForColOpening.add(myParent.radioColOpening[count]);
			count++;
		}

	}

	public void createRadiosForSashOpRows(SashLeaf myFrame) { // Horizontal

		this.myParent.radioForRowSashOp = new ButtonGroup();
		mySelectedFrame = myFrame;
		myParent.mySelectedFrame = myFrame;

		Object[] openings = myFrame.openings.toArray();

		Collection myOpenings = new ArrayList();
		for (Object op : openings) {
			if (((OpeningObject) op).startCol == this.selectedRadioForColo) {
				myOpenings.add(op);
			}
		}

		Object[] myOs = myOpenings.toArray();

		myParent.radioRowSashOp = new JRadioButton[myOs.length];
		myParent.rrPosyo = new int[myOs.length];

		double ys = 0;
		double ye = 0;
		int yc = 0;

		int count = 0;
		for (Object element : myOs) {
			myParent.radioRowSashOp[count] = new JRadioButton();

			myParent.radioRowSashOp[count].setIconTextGap(0);

			OpeningObject minHO = new OpeningObject(myParent);
			double minH = 10000;

			for (final Object ops : openings) {
				if (((OpeningObject) ops).startRow == ((OpeningObject) element).startRow) {
					if (((OpeningObject) ops).heightPix < minH) {
						minHO = (OpeningObject) ops;
						minH = ((OpeningObject) ops).heightPix;
					}
				}
			}

			ye = minHO.highestYC + minH;
			ys = minHO.highestYC;

			yc = (int) ys + (int) ((ye - ys) / 2);

			myParent.radioRowSashOp[count]
					.setFont(new Font("SansSerif", 0, 10));

			myParent.radioRowSashOp[count]
					.setToolTipText(((OpeningObject) element).startRow + "");

			this.myParent.leftChecks.add(myParent.radioRowSashOp[count],
					new XYConstraints(20, yc - 8, 16, 16));

			myParent.rrPosyo[count] = yc;
			myParent.radioRowSashOp[count].setVisible(true);

			if (myOs.length == 1) {
				myParent.radioRowSashOp[count].setSelected(true);
				myParent.radioRowSashOp[count].setEnabled(false);
			}

			if (((OpeningObject) element).startRow == this.selectedRadioForRowo) {
				myParent.radioRowSashOp[count].setSelected(true);

			} else {
				myParent.radioRowSashOp[count].setSelected(false);
			}

			myActionRadioRowo = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.radioRowo_actionPerformed(e);
				}

			};
			myParent.radioRowSashOp[count].addActionListener(myActionRadioRowo);
			myParent.radioRowSashOp[count].addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(final MouseEvent e) {

					DrawCanvas.this.radioRowo_MouseClicked(e);
				}

			});
			myParent.radioForRowSashOp.add(myParent.radioRowSashOp[count]);
			count++;
		}
		validate();
		repaint();
	}

	public void createRadiosForSashOpCols(SashLeaf myFrame) { // Horizontal

		myParent.radioForColSashOp = new ButtonGroup();
		mySelectedFrame = myFrame;
		myParent.mySelectedFrame = myFrame;

		Object[] openings = myFrame.openings.toArray();

		int cols = 0;
		Collection myOpenings = new ArrayList();

		for (Object op : openings) {
			if (((OpeningObject) op).startRow == this.selectedRadioForRowo) {
				myOpenings.add(op);
			}
		}

		Object[] myOs = myOpenings.toArray();
		myParent.radioColSashOp = new JRadioButton[myOs.length];
		myParent.rcPosxo = new int[myOs.length];

		double xs = 0;
		double xe = 0;
		int xc = 0;

		int count = 0;
		for (Object element : myOs) {
			myParent.radioColSashOp[count] = new JRadioButton();
			myParent.radioColSashOp[count].setIconTextGap(0);
			OpeningObject minWO = new OpeningObject(myParent);
			double minW = 10000;

			for (final Object ops : openings) {
				if (((OpeningObject) ops).startCol == ((OpeningObject) element).startCol) {
					if (((OpeningObject) ops).widthPix < minW) {
						minWO = (OpeningObject) ops;
						minW = ((OpeningObject) ops).widthPix;
					}
				}
			}
			xe = Math.min(minWO.startingX, minWO.bX4) + minW;

			xs = Math.min(minWO.startingX, minWO.bX4);

			xc = (int) xs + (int) ((xe - xs) / 2);

			if (((OpeningObject) element).startCol == this.selectedRadioForColo) {
				myParent.radioColSashOp[count].setSelected(true);
			} else {
				myParent.radioColSashOp[count].setSelected(false);
			}

			myParent.radioColSashOp[count]
					.setFont(new Font("SansSerif", 0, 10));
			myParent.radioColSashOp[count].setIconTextGap(0);
			myParent.radioColSashOp[count]
					.setToolTipText(((OpeningObject) element).startCol + "");
			this.add(myParent.radioColSashOp[count], new XYConstraints(xc + 30,
					20, 16, 16));

			myParent.rcPosxo[count] = xc;

			myParent.radioColSashOp[count].setVisible(true);

			if (myOs.length == 1) {
				myParent.radioColSashOp[count].setSelected(true);
				myParent.radioColSashOp[count].setEnabled(false);
			}

			myActionRadioCol = new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {

					DrawCanvas.this.radioColo_actionPerformed(e);
				}

			};
			myParent.radioColSashOp[count].addActionListener(myActionRadioCol);
			myParent.radioColSashOp[count].addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					DrawCanvas.this.radioRowo_MouseClicked(e);
				}

			});
			myParent.radioForColSashOp.add(myParent.radioColSashOp[count]);
			count++;
		}

		validate();
		repaint();
	}

	public void setTopSizeForStd(JXTextField tf) {

		final int x = (int) (tf).getLocation().getX();

		final int y = (int) (tf).getLocation().getY();

		getSelectedColTop(x, y);// Get Selected
		getSelectedFrameFromTextRC();

		Object[] values = new Object[2];
		try {
			values = myParent.readTextCurrentUOM(tf);
		} catch (final Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * This method clear all object components within this canvas and repaint a
	 * UI.
	 */
	public void clearDrawCanvasComponents() {

		// Remove all components from drawCanvas
		this.removeAll();

		// Refresh drawCanvas components
		this.updateUI();
	}

	public void clearDrawObjects() {

		myParent.gpFillShapes.clear();
		myParent.gpColors.clear();
		myParent.gpObjects.clear();

		myParent.clearItemFrameTextObjects();
	}

	/**
	 * Draw Graphics2D to Image file
	 * 
	 * @param isDrawDimensionLines
	 *            , Indicate if dimension lines should be draw for this byte[]
	 *            image array.
	 * @return BufferedImage
	 */
	public byte[] drawToImage(boolean isDrawDimensionLines) {

		// Setting draw dimension lines values
		this.isDrawDimensionLines = isDrawDimensionLines;

		// int dimw = (int)
		// (this.myParent.jobItem.design.bCX2-this.myParent.jobItem.design.startingCX);
		// int dimh = (int)
		// (this.myParent.jobItem.design.highestY+this.myParent.jobItem.design.heightPix);
		// Dimension imageSize = new Dimension(dimw, dimh);
		//
		// int startX = this.getX();
		// int startY = this.getY();
		//
		//
		// Rectangle captureRect = new Rectangle(startX+
		// (int)this.myParent.jobItem.design.startingCX, startY + (int)
		// this.myParent.jobItem.design.highestY,
		// dimw, dimh);
		//
		// Robot robot = null;
		// try {
		// robot = new Robot();
		// } catch (AWTException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// BufferedImage awtImage = robot.createScreenCapture(captureRect);

		BufferedImage awtImage = new BufferedImage(this.getWidth() - 100,
				this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = awtImage.getGraphics();
		this.paint(g);

		// Converto to PNG format and save into byte[] array
		PngEncoder encoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

		// Convert to Byte Array
		ByteArrayOutputStream out = null;
		try {
			out = new ByteArrayOutputStream();
			encoder.encode(awtImage, out);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return out.toByteArray();
	}

	/**
	 * Invoke by swing to draw components
	 * 
	 * @param g
	 *            , Graphics
	 */
	@Override
	public void paint(Graphics g) {

		// Initialize graphics 2D DrawCanvas
		g2 = (Graphics2D) g;

		// Initialize graphics 2D JobItem
		myParent.jobItem.g2 = (Graphics2D) g;

		// new JLabel();
		JLabel layoutLabel = new JLabel();

		// Configure myviewIcon
		if (myParent.jobItem.viewOut) {
			Image myviewIcon = (myParent.iconFiles.get("viewOut")).getImage();
		} else {
			Image myviewIcon = (myParent.iconFiles.get("viewIn")).getImage();
		}

		if (myParent.jobItem.layout == 1) {
			layoutLabel.setIcon(myParent.layoutP.flatIcon);
			layoutLabel.setToolTipText("Flat Layout");
		} else if (myParent.jobItem.layout == 4) {
			layoutLabel.setIcon(myParent.layoutP.customIcon);
			layoutLabel.setToolTipText("Custom Layout");
		} else if (myParent.jobItem.layout == 2) {
			layoutLabel.setIcon(myParent.layoutP.bayIcon);
			layoutLabel.setToolTipText("Bay Layout");
		} else if (myParent.jobItem.layout == 3) {
			layoutLabel.setIcon(myParent.layoutP.bowIcon);
			layoutLabel.setToolTipText("Bow Layout");
		}

		this.endX = myParent.jobItem.startingX
				+ myParent.jobItem.design_flat_WIDTHpix;
		this.endY = myParent.jobItem.startingY + myParent.jobItem._HEIGHTpix;

		// ******************************************************
		// Drawing Dimensions design
		// ******************************************************
		this.drawDimensionLines();

		// ******************************************************
		// Drawing Draw Facets
		// ******************************************************
		drawFacet();
	}

	/**
	 * Draw Facets Shape Object
	 */
	public void drawFacet() {

		// ******************************************************
		// Drawing Facet Shape Object
		// ******************************************************
		for (Object object : this.myParent.jobItem.design.frames) {

			// Return Facet Object
			Facet facet = (Facet) object;

			if (!this.drawAssembly) {

				// Drawing profiles curves
				this.drawProfilesCurves(facet.partObjects.toArray());

				// Drawing profiles
				this.drawProfiles(facet.partObjects.toArray());

				// Drawing couplers from facet
				this.drawCouplers(facet);

				// Draw Dividers
				this.drawCouplers(this.myParent.jobItem.design);

				// Drawing mullions selected
				this.drawMullionsSelected(facet, false);
			}

			// ***************************************************
			// Drawing Frame Shape Object
			// ***************************************************
			if (this.myParent.jobItem.viewOut) {
				drawFrame(facet);
				drawFrameSelected(facet);
			}

			// ***************************************************
			// Setting Default Values Configuration
			// ***************************************************
			Stroke drawingStroke = new BasicStroke(2, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0);

			if (myParent.alignClicks == 2) {
				g2.setStroke(drawingStroke);
				g2.setColor(Color.RED);
				g2.draw(myParent.facetUsed.myLine);
				g2.setStroke(new BasicStroke());
			}

			if (myParent.alignSeq == 2) {
				myParent.dim.doAlign.setEnabled(true);
			}
		}
	}

	/**
	 * Draw Frames Shape Object Model
	 * 
	 * @param facet
	 *            , Facet
	 */
	public void drawFrame(Facet facet) {

		// ***************************************************
		// Setting Default Values Configuration
		// ***************************************************
		if (this.currentRect != null && this.currentRect.width > 0
				&& this.currentRect.height > 0) {
			g2.setColor(Color.BLUE);
			g2.draw(currentRect);

			g2.setColor(new Color(255, 255, 255, 64));
			g2.setStroke(new BasicStroke());
		}

		// ***************************************************
		// Init Frames Values Collection
		// ***************************************************
		for (Object object : facet.frames) {

			// Get Frame Object Model
			Frame frame = (Frame) object;

			// Found frame object
			this.drawImage = false;

			// **************************************************************************
			// Show Attributes Names
			// **************************************************************************
			if (myParent.dim.showName.isSelected()) {

				JLabel pane = new JLabel();

				pane.setBackground(new Color(255, 128, 0, 64));
				pane.setOpaque(true);

				this.add(pane, new XYConstraints((int) frame.startingX + 1,
						(int) frame.startingY + 1, 5, 5));

				String frameName = ItemFrame
						.getApplicationBaseRules()
						.getSeriesValidOpeningById(
								frame.controlUserDefinedOpeningID)
						.getSeriesValidOpeningPK().getAbbreviation();

				String attributes = "";

				for (Object n : frame.notes.toArray()) {
					attributes = ((ShapeNotes) n).stockcode + " : "
							+ ((ShapeNotes) n).description + "<br>";
				}

				pane.setToolTipText("<html>" + frameName + " <br>" + attributes
						+ "</html>");
			}

			if (frame.shapeID != 10) {

				// *********************************************************************
				// Setting draw assembly true
				// *********************************************************************
				boolean isForFrame = frame.isForFrame(this.drawAssembly,
						this.constructionMap);

				if (!isForFrame) {
					continue;
				}

				if (this.drawAssembly && isForFrame) {

					// Draw Image setting false
					this.drawImage = true;
				}

				// *******************************************************************
				// Do Open in Sash Object
				// *******************************************************************
				for (Object opening : frame.openings) {

					// Do Open In Sash
					this.doOpenInSash(frame, opening);

					// Draw Glass for Frame Object
					if (((OpeningObject) opening).contentMid != 3) {
						this.drawGlass(opening);
					}
				}

				// Preparing draw inter locks
				if (!frame.glazedout) {
					this.prepareDrawInterlocks(frame);
				}

				// *******************************************************************
				// Drawing part objects from Frame object
				// *******************************************************************
				if (frame.partObjects != null && frame.partObjects.size() > 0) {
					this.drawProfilesCurves(frame.partObjects.toArray());
					this.drawProfiles(frame.partObjects.toArray());
				}

				// *******************************************************************
				// Drawing mullions from Frame object
				// *******************************************************************
				if (frame.bOpeningObject != null
						&& (frame.bOpeningObject.mullions != null || frame.bOpeningObject.mullionsH != null)
						&& (frame.bOpeningObject.mullions.size() > 0 || frame.bOpeningObject.mullionsH
								.size() > 0)) {
					this.drawMullions(frame);
				}

				if (frame.glazedout) {
					this.prepareDrawInterlocks(frame);
				}

				// Draw fixed pane slider beads
				this.drawFixedPaneSliderBeads(frame);

				// *******************************************************************
				// Drawing opening from Frame Object
				// *******************************************************************
				for (Object opening : frame.openings) {

					if (((OpeningObject) opening).contentMid != 3) {
						doOpenOutSash(opening);
					} else {

						// Get frames from subfacet in opening object
						Object[] subFrames = ((OpeningObject) opening).subFacet.frames
								.toArray();

						for (Object subFrame : subFrames) {

							if (((Frame) subFrame).shapeID != 10) {

								// Get openings from subFrame
								Object[] subFrameOpenings = ((Frame) subFrame).openings
										.toArray();

								// **************************************************
								// Draw Open in sash
								// **************************************************
								for (Object subFrameOpening : subFrameOpenings) {
									doOpenInSash(subFrame, subFrameOpening);
								}

								// **************************************************
								// Draw SubFrame opening
								// **************************************************
								for (Object subFrameOpening : subFrameOpenings) {
									if (((OpeningObject) subFrameOpening).contentMid != 3) {
										this.drawGlass(subFrameOpening);
									}
								}

								// Preparing draw interlocks
								this.prepareDrawInterlocks(subFrame);

								// **************************************************
								// Draw Parts object from SubFrame
								// **************************************************
								if (((Frame) subFrame).partObjects != null
										&& ((Frame) subFrame).partObjects
												.size() > 0) {
									this.drawProfilesCurves(((Frame) subFrame).partObjects
											.toArray());
									this.drawProfiles(((Frame) subFrame).partObjects
											.toArray());
								}

								// **************************************************
								// Draw Mullions from BkgrdOpening object
								// **************************************************
								if (((Frame) subFrame).bOpeningObject != null
										&& (((Frame) subFrame).bOpeningObject.mullions != null || ((Frame) subFrame).bOpeningObject.mullionsH != null)) {
									this.drawMullions((Frame) subFrame);
								}

								// Draw Fixed pane slider beads
								this.drawFixedPaneSliderBeads(subFrame);

								// *************************************************
								// Do Open out sash
								// *************************************************
								for (Object subFrameOpening : subFrameOpenings) {
									doOpenOutSash(subFrameOpening);
								}
							}
						}
					}
				}

				// this.drawFixedPaneSliderBeads(frame);

				// ******************************************************************
				// Frame found - stop loop
				// ******************************************************************
				if (drawImage) {
					break;
				}
			}
		}
	}

	/**
	 * Draw Frames Shape Object Model Selected
	 * 
	 * @param facet
	 *            , Facet
	 */
	public void drawFrameSelected(Facet facet) {

		for (Object object : facet.frames) {

			// Get Frame Object
			Frame frame = (Frame) object;

			// Found frame object
			this.drawImage = false;

			if (frame.shapeID != 10) {

				// *********************************************************************
				// Setting draw assembly true
				// *********************************************************************
				if (!frame.isForFrame(this.drawAssembly, this.constructionMap)) {
					continue;
				}

				if (this.drawAssembly
						&& frame.isForFrame(this.drawAssembly,
								this.constructionMap)) {

					// Draw Image setting false
					this.drawImage = true;
				}

				this.drawMullionsSelected(frame, false);

				// Get array of openings from frame object
				Object[] openingObjects = frame.openings.toArray();

				for (Object O : openingObjects) {

					// Opening sash in object
					if (((OpeningObject) O).sashObjectIn != null) {

						// getting frames from sashIn object
						Object[] sash = ((OpeningObject) O).sashObjectIn.frames
								.toArray();

						// Drawing sashes
						this.drawSashes(sash, true);
					}

					// Opening sash mid object
					if (((OpeningObject) O).sashObjectMid != null) {

						// getting frames from sashMid object
						Object[] sash = ((OpeningObject) O).sashObjectMid.frames
								.toArray();

						// Drawing sashes
						this.drawSashes(sash, true);

					}

					// Opening sash out object
					if (((OpeningObject) O).sashObjectOut != null) {

						// getting frames from sashOut object
						Object[] sash = ((OpeningObject) O).sashObjectOut.frames
								.toArray();

						// Drawing sashes
						this.drawSashes(sash, true);

					} else {
						// drawGlazingBeads(O);
					}
				}

				// *********************************************************************
				// Setting draw assembly true
				// *********************************************************************
				if (drawImage) {
					break;
				}
			}
		}
	}

	/**
	 * Draw dimension lines for a specific design into Canvas. This method
	 * execute if isDrawDimensionLines property values is put to true.
	 */
	public void drawDimensionLines() {

		if (isDrawDimensionLines) {

			// Get fonts configuration
			this.getMyFont();

			// Get font metrics
			FontMetrics metrics = this.g2.getFontMetrics(font);
			// Get font render context
			FontRenderContext frc = this.g2.getFontRenderContext();

			if (this.myParent.dim.heightAF.isSelected()) {

				Stroke drawingStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_BEVEL, 2, new float[] { 3 }, 0);

				g2.setStroke(drawingStroke);
				g2.setColor(Color.blue);

				Line2D d = new Line2D.Double(endX + 4, endY, endX + 4,
						endY + 39);
				g2.draw(d);

				g2.setStroke(new BasicStroke());
				int hgt = metrics.getHeight();
				String haf = myParent.sixDecimal.format(myParent.jobItem.haf
						* myParent.scale.doubleValue())
						+ "";
				int adv = metrics.stringWidth(haf);
				TextLayout layout2 = new TextLayout(haf, font, frc);
				Rectangle2D bounds = layout2.getBounds();

				bounds.setRect(endX - adv / 2 - 2, endY + 12, adv + 6, hgt + 2);

				g2.setColor(Color.BLUE);
				g2.draw(bounds);
				bounds.setRect(endX - adv / 2 - 1, endY + 13, adv + 5, hgt + 1);
				g2.setColor(Color.white);
				g2.fill(bounds);

				g2.setColor(Color.black);
				layout2.draw(g2, (float) (endX - adv / 2 + 2),
						(float) (endY + 23));

				g2.setColor(Color.DARK_GRAY);

				Stroke drawingStroke2 = new BasicStroke(3,
						BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 2,
						new float[] { 3 }, 0);

				Line2D line = new Line2D.Double(
						myParent.jobItem.startingX - 60, endY + 40, endX + 60,
						endY + 40);

				g2.setStroke(drawingStroke2);
				g2.draw(line);
				g2.setStroke(new BasicStroke());
			}

			/**
			 * Draw a horizontal line for selection radio row into draw canvas
			 * design if radios is grather than 1.
			 */
			if (this.myParent.mainRowCheck != null
					&& this.myParent.mainRowCheck.length > 1) {

				for (int i = 0; i < myParent.mainRowCheck.length; i++) {

					// Preparing a draw stroke and color
					Rectangle2D cb = myParent.mainRowCheck[i].getBounds();
					cb.setRect(
							0 + myParent.mainRowCheck[i].getWidth() / 2,
							myParent.rrPosy[i]
									+ myParent.mainRowCheck[i].getHeight() / 2
									- 1, 4, 4);

					this.g2.setStroke(new BasicStroke());
					this.g2.setColor(Color.white);

					// Draw horizontal line if actual radio iteration is
					// selected
					if (myParent.mainRowCheck[i].isSelected()
							&& this.myParent.drawGuide) {

						// Setting general path color
						this.g2.setColor(Color.red);

						// Preparing drawing stroke
						Stroke drawingStroke = new BasicStroke(1,
								BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
								0, new float[] { 1 }, 0);

						// Config Line 2D start & end point
						Line2D line = new Line2D.Double(
								myParent.jobItem.startingX, myParent.rrPosy[i]
										+ myParent.mainRowCheck[i].getHeight()
										/ 2 + 2, endX, myParent.rrPosy[i]
										+ myParent.mainRowCheck[i].getHeight()
										/ 2 + 2);

						// Setting stroke to general path
						g2.setStroke(drawingStroke);

						// Drawing line to canvas
						g2.draw(line);

						// Return stroke to basic
						g2.setStroke(new BasicStroke());
					}
				}
			}

			/**
			 * Draw a vertical line for selection radio col into draw canvas
			 * design if radios is grather than 1.
			 */
			if (this.myParent.mainColCheck != null
					&& this.myParent.mainColCheck.length > 1) {

				for (int i = 0; i < myParent.mainColCheck.length; i++) {

					// Preparing a draw stroke anc color
					Rectangle2D cb = myParent.mainColCheck[i].getBounds();
					cb.setRect(myParent.rcPosx[i] + 17 - 3,
							(int) myParent.jobItem.startingY - 70 + 12, 4, 4);
					this.g2.setStroke(new BasicStroke());
					this.g2.setColor(Color.white);

					// Draw vertical line if actual radio iteration is selected
					if (myParent.mainColCheck[i].isSelected()
							&& this.myParent.drawGuide) {

						// Setting general path color
						this.g2.setColor(Color.red);

						// Preparing drawing stroke
						Stroke drawingStroke = new BasicStroke(1,
								BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
								0, new float[] { 1 }, 0);

						// Config Line 2D start & end point
						Line2D line = new Line2D.Double(
								myParent.rcPosx[i] + 17,
								(int) myParent.jobItem.startingY,
								myParent.rcPosx[i] + 17, endY);

						// Setting stroke to general path
						g2.setStroke(drawingStroke);

						// Drawing line to canvas
						g2.draw(line);

						// Return stroke to basic
						g2.setStroke(new BasicStroke());
					}
				}
			}

			/**
			 * Draw vertical line for Opening Nominal size dimension
			 */
			if (this.myParent.radioColOpening != null
					&& this.mySelectedFrame != null) {

				/**
				 * Evaluate radio column opening collections and draw line
				 * stroke to canvas
				 */
				for (int ii = 0; ii < myParent.radioColOpening.length; ii++) {

					/**
					 * Radio column opening should be selected for drawing
					 */
					if (myParent.radioColOpening[ii].isSelected()) {

						// Setting element selected again
						this.myParent.radioColOpening[ii].setSelected(true);
						// Setting draw color for general path to BLUE
						this.g2.setColor(Color.blue);

						// Preparing drawing stroke
						Stroke drawingStroke = new BasicStroke(1,
								BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
								0, new float[] { 1 }, 0);
						this.g2.setStroke(drawingStroke);

						// Get highest Y position for Background Opening
						// Object from selected frame
						double myY = mySelectedFrame.bOpeningObject.highestY;

						// Config Line 2D for start and end point
						Line2D line = new Line2D.Double(
								this.myParent.rcPosxo[ii] + 17, (int) myY,
								this.myParent.rcPosxo[ii] + 17, this.endY);

						// Draw line to canvas
						this.g2.draw(line);

						// Return to basic stroke for general path
						this.g2.setStroke(new BasicStroke());
					}
				}

				// Clean radio column for opening nominal size
				this.myParent.radioColOpening = new JRadioButton[0];
			}

			/**
			 * Draw horizontal line for Opening Nominal size dimension
			 */
			if (this.myParent.radioRowOpening != null
					&& this.mySelectedFrame != null) {

				/**
				 * Evaluate radio row opening collections and draw line stroke
				 * to canvas
				 */
				for (int ii = 0; ii < myParent.radioRowOpening.length; ii++) {

					/**
					 * Row column opening should be selected for drawing
					 */
					if (myParent.radioRowOpening[ii].isSelected()) {

						// Setting element selected again
						this.myParent.radioRowOpening[ii].setSelected(true);
						// Setting draw color for general path to BLUE
						this.g2.setColor(Color.blue);

						// Preparing drawing stroke
						Stroke drawingStroke = new BasicStroke(1,
								BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
								0, new float[] { 1 }, 0);
						g2.setStroke(drawingStroke);

						// Config Line 2D for start and end point
						Line2D line = new Line2D.Double(
								mySelectedFrame.bOpeningObject.startingX,
								myParent.rrPosyo[ii]
										+ myParent.radioRowOpening[ii]
												.getHeight() / 2 + 2, endX,
								myParent.rrPosyo[ii]
										+ myParent.radioRowOpening[ii]
												.getHeight() / 2 + 2);

						// Draw line to canvas
						this.g2.draw(line);

						// Return to basic stroke for general path
						this.g2.setStroke(new BasicStroke());
					}
				}

				// Clean radio row for opening nominal size
				this.myParent.radioRowOpening = new JRadioButton[0];
			}

			// *****************************************************************
			// Prepare dimension values to draw
			// *****************************************************************
			myParent.gpObjects.toArray();
			myParent.gpColors.toArray();
			myParent.gpFillShapes.toArray();

			gpText = myParent.colTextObjects.toArray();
			gpTextFacetCol = myParent.fcolTextObjects.toArray();
			gpTextCoupler = myParent.couplerTexts.toArray();

			myParent.textFieldsTop = gpText;
			myParent.textFieldsCoupler = gpTextCoupler;
			myParent.textFieldsFBot = gpTextFacetCol;

			gpTextXs = myParent.colTextPosXs.toArray();
			gpTextXe = myParent.colTextPosXe.toArray();
			gpTextrow = myParent.rowTextObjects.toArray();
			gpTextXsrow = myParent.rowTextPosYs.toArray();
			gpTextXerow = myParent.rowTextPosYe.toArray();
			gpTextXsFacet = myParent.fcolTextPosXs.toArray();
			gpTextXeFacet = myParent.fcolTextPosXe.toArray();

			if (dimensionType == 1) {
				gpText = myParent.colTextObjectsc.toArray();
				myParent.textFieldsTop = gpText;
				gpTextXs = myParent.colTextPosXsc.toArray();
				gpTextXe = myParent.colTextPosXec.toArray();
				gpTextrow = myParent.rowTextObjectsc.toArray();
				gpTextXsrow = myParent.rowTextPosYsc.toArray();
				gpTextXerow = myParent.rowTextPosYec.toArray();
			}

			if (dimensionType == 4 || dimensionType == 6) {
				gpText = myParent.colTextObjects.toArray();
				myParent.textFieldsTop = gpText;
				gpTextXs = myParent.colTextPosXs.toArray();
				gpTextXe = myParent.colTextPosXe.toArray();
				gpTextrow = myParent.rowTextObjects.toArray();
				gpTextXsrow = myParent.rowTextPosYs.toArray();
				gpTextXerow = myParent.rowTextPosYe.toArray();
			}

			if (dimensionType == 3 || dimensionType == 5) {
				gpText = myParent.colTextObjectsc.toArray();
				myParent.textFieldsTop = gpText;
				gpTextXs = myParent.colTextPosXsc.toArray();
				gpTextXe = myParent.colTextPosXec.toArray();
				gpTextrow = myParent.rowTextObjectsc.toArray();
				gpTextXsrow = myParent.rowTextPosYsc.toArray();
				gpTextXerow = myParent.rowTextPosYec.toArray();
			}

			// *****************************************************************
			// Prepare dimension lines for top and left sides
			// *****************************************************************

			double xpos;
			double xpose;
			double ypos;
			double ypose;

			// Preparing end X & Y position ending
			this.endX = myParent.jobItem.startingX
					+ myParent.jobItem.design_flat_WIDTHpix;
			this.endY = myParent.jobItem.startingY
					+ myParent.jobItem._HEIGHTpix;

			for (int i = 0; i < gpText.length; i++) {

				xpos = (Double) gpTextXs[i];
				xpose = (Double) gpTextXe[i];

				int hgt = metrics.getHeight();

				// get the advance of my text in this font and render context
				int adv = metrics.stringWidth((String) gpText[i]);

				if (myParent.myTopPanel.metric.isSelected()
						&& myParent.prevUOM <= 2) {
					String myString = myParent.sixDecimal.format(Double
							.parseDouble((String) gpText[i]));
					adv = metrics.stringWidth(myString);
				} else if (myParent.myTopPanel.metric.isSelected()
						&& myParent.prevUOM == 3) {
					String myString = "";
					try {
						myString = UOMConvert
								.fractionToMetric((String) gpText[i]);
					} catch (Exception e) {
						e.printStackTrace();
					}

					myString = myParent.sixDecimal.format(Double
							.parseDouble(myString));
					adv = metrics.stringWidth(myString);

				} else if (myParent.myTopPanel.impFrac.isSelected()
						|| myParent.myTopPanel.feet.isSelected()) {

					if (adv < 50) {
						adv = 53;
					}
				}

				// calculate the size of a box to hold the text with some
				// padding.
				double startXrect = xpos + (xpose - xpos - adv) / 2;

				if (dimensionType <= 2) {
					g2.setColor(Color.RED);
				} else {
					g2.setColor(Color.blue);
				}

				g2.drawLine((int) xpos, (int) myParent.jobItem.startingY - 25,
						(int) startXrect, (int) myParent.jobItem.startingY - 25);
				g2.drawLine((int) startXrect + adv + 2,
						(int) myParent.jobItem.startingY - 25, (int) xpose,
						(int) myParent.jobItem.startingY - 25);
				g2.drawLine((int) xpos, (int) myParent.jobItem.startingY - 3,
						(int) xpos, (int) myParent.jobItem.startingY - 35);
				g2.drawLine((int) xpose, (int) myParent.jobItem.startingY - 3,
						(int) xpose, (int) myParent.jobItem.startingY - 35);

				texttopdrawn = false;

				if (drawTextTop) {

					TextLayout layout = new TextLayout((String) gpText[i],
							font, frc);
					Rectangle2D bounds = layout.getBounds();

					bounds.setRect((int) startXrect,
							(int) myParent.jobItem.startingY - 25 - (hgt + 2)
									/ 2, adv + 2, hgt + 2);

					g2.draw(bounds);
					g2.setColor(Color.black);

					int adv2 = metrics.stringWidth((String) gpText[i]);

					layout.draw(g2, (int) startXrect + 2 + adv / 2 - adv2 / 2,
							(int) myParent.jobItem.startingY - 25f + (hgt + 1)
									/ 4 + 1);
				}
			}

			for (int i = 0; i < gpTextrow.length; i++) {

				ypos = ((Double) gpTextXsrow[i]).doubleValue();
				ypose = ((Double) gpTextXerow[i]).doubleValue();

				// get the height of a line of text in this font and render
				// context
				int hgt = metrics.getHeight();

				// get the advance of my text in this font and render context
				int adv = metrics.stringWidth((String) gpTextrow[i]);

				if (myParent.myTopPanel.metric.isSelected()
						&& myParent.prevUOM <= 2) {
					String myString = myParent.sixDecimal.format(Double
							.parseDouble((String) gpTextrow[i]));
					adv = metrics.stringWidth(myString);
				} else if (myParent.myTopPanel.metric.isSelected()
						&& myParent.prevUOM == 3) {
					String myString = "";
					try {
						myString = UOMConvert
								.fractionToMetric((String) gpTextrow[i]);
					} catch (final Exception e) {
						e.printStackTrace();
					}
					myString = myParent.sixDecimal.format(Double
							.parseDouble(myString));
					adv = metrics.stringWidth(myString);
				} else if (myParent.myTopPanel.impFrac.isSelected()
						|| myParent.myTopPanel.feet.isSelected()) {
					if (adv < 50) {
						adv = 53;
					}
				}

				// calculate the size of a final box to final hold the text
				// with some padding.
				double startYrect = ypos + (ypose - ypos - hgt) / 2;

				if (dimensionType <= 2) {
					g2.setColor(Color.RED);
				} else {
					g2.setColor(Color.blue);
				}

				g2.drawLine((int) myParent.jobItem.startingX - 40, (int) ypos,
						(int) myParent.jobItem.startingX - 40, (int) startYrect);
				g2.drawLine((int) myParent.jobItem.startingX - 40,
						(int) startYrect + hgt + 2,
						(int) myParent.jobItem.startingX - 40, (int) ypose);
				g2.drawLine((int) myParent.jobItem.startingX - 50, (int) ypos,
						(int) myParent.jobItem.startingX - 4, (int) ypos);
				g2.drawLine((int) myParent.jobItem.startingX - 50, (int) ypose,
						(int) myParent.jobItem.startingX - 4, (int) ypose);

				if (drawTextLeft) {
					TextLayout layout = new TextLayout((String) gpTextrow[i],
							font, frc);
					Rectangle2D bounds = layout.getBounds();
					bounds.setRect((int) myParent.jobItem.startingX - 30
							- (adv + 2), (int) startYrect, adv + 2, hgt + 2);
					g2.draw(bounds);
					g2.setColor(Color.black);

					int adv2 = metrics.stringWidth((String) gpTextrow[i]);

					layout.draw(g2, (int) myParent.jobItem.startingX - 30
							- (adv + 2) + adv / 2 - adv2 / 2, (int) startYrect
							+ hgt - 2 + 1);
				}
			}

			if (gpTextFacetCol.length > 1) {

				for (int i = 0; i < gpTextFacetCol.length; i++) {
					xpos = ((Double) gpTextXsFacet[i]).doubleValue();
					xpose = ((Double) gpTextXeFacet[i]).doubleValue();

					// get the height of a line of text in this font and
					// render context
					int hgt = metrics.getHeight();

					// get the advance of my text in this font and render
					// context
					int adv = metrics.stringWidth(gpTextFacetCol[i].toString());

					if (myParent.myTopPanel.metric.isSelected()
							&& myParent.prevUOM <= 2) {

						String myString = myParent.sixDecimal.format(Double
								.parseDouble(gpTextFacetCol[i].toString()));
						adv = metrics.stringWidth(myString);

					} else if (myParent.myTopPanel.metric.isSelected()
							&& myParent.prevUOM == 3) {
						String myString = "";
						try {
							myString = UOMConvert
									.fractionToMetric(gpTextFacetCol[i]
											.toString());
						} catch (final Exception e) {
							e.printStackTrace();
						}

						myString = myParent.sixDecimal.format(Double
								.parseDouble(myString));
						adv = metrics.stringWidth(myString);
					} else if (myParent.myTopPanel.impFrac.isSelected()
							|| myParent.myTopPanel.feet.isSelected()) {
						if (adv < 50) {
							adv = 53;
						}
					}

					// calculate the size of a box to hold the text with some
					// padding.
					double startXrect = xpos + (xpose - xpos - adv) / 2;

					g2.setColor(new Color(0, 200, 0));
					g2.drawLine((int) xpos, (int) endY + 25, (int) startXrect,
							(int) endY + 25);
					g2.drawLine((int) startXrect + adv + 2, (int) endY + 25,
							(int) xpose, (int) endY + 25);

					if (xpos == myParent.jobItem.startingX) {
						g2.drawLine((int) xpos, (int) endY + 3, (int) xpos,
								(int) endY + 35);
					} else {
						g2.drawLine((int) xpos, (int) endY + 17, (int) xpos,
								(int) endY + 35);
					}

					if (xpose == myParent.jobItem.startingX
							+ myParent.jobItem._WIDTHpix) {
						g2.drawLine((int) xpose, (int) endY + 3, (int) xpose,
								(int) endY + 35);
					} else {
						g2.drawLine((int) xpose, (int) endY + 17, (int) xpose,
								(int) endY + 35);

					}

					texttopdrawn = false;

					TextLayout layout = new TextLayout(
							gpTextFacetCol[i].toString(), font, frc);
					Rectangle2D bounds = layout.getBounds();
					bounds.setRect((int) startXrect, (int) endY + 25
							- (hgt + 2) / 2, adv + 2, hgt + 2);

					g2.draw(bounds);
					g2.setColor(Color.black);

					int adv2 = metrics
							.stringWidth(gpTextFacetCol[i].toString());
					layout.draw(g2, (int) startXrect + 2 + adv / 2 - adv2 / 2,
							(int) endY + 25 + (hgt + 1) / 4 + 1);
				}
			}

			double xposC;

			for (int i = 0; i < gpTextCoupler.length; i++) {

				String myString = ((CouplerText) gpTextCoupler[i]).angle + "°";
				double advC = metrics.stringWidth(myString);

				xposC = ((CouplerText) gpTextCoupler[i]).centerX - advC / 2;
				int hgtC = metrics.getHeight();

				if (((CouplerText) gpTextCoupler[i]).isFixed) {
					g2.setColor(Color.RED);
				} else {
					g2.setColor(new Color(0, 200, 0));
				}

				TextLayout layout = new TextLayout(myString, font, frc);

				Rectangle2D boundsC = layout.getBounds();
				boundsC.setRect((int) xposC,
						((CouplerText) gpTextCoupler[i]).endY + 3, advC + 2,
						hgtC + 2);

				g2.setColor(Color.black);
				metrics.stringWidth(myString);

				layout.draw(g2,
						(float) (((CouplerText) gpTextCoupler[i]).centerX
								- advC / 2 + 1f),
						(float) (((CouplerText) gpTextCoupler[i]).endY + 3f
								+ hgtC - 1));

			}
		}

		/**
		 * We have to make sure this variables is always (true), to have the
		 * design consistency with his dimension on screen and user interface.
		 * This option is disable for design we don't want to save on file or
		 * bytes into database the actual dimension for window and door
		 * configuration.
		 */
		this.isDrawDimensionLines = true;
	}

	/**
	 * Do Open Out Sash
	 * 
	 * @param O
	 *            , OpeningObject
	 */
	public void doOpenOutSash(Object O) {

		if (((OpeningObject) O).sashObjectIn != null
				&& ((OpeningObject) O).contentIn == 2
				&& ((OpeningObject) O).sashObjectIn.opens == 1) {
			Object[] sash = ((OpeningObject) O).sashObjectIn.frames.toArray();

			this.drawSashes(sash, false);

		} else if (((OpeningObject) O).contentIn == 1) {
			this.drawGlazingBeads(O);
		}

		if (((OpeningObject) O).sashObjectMid != null
				&& ((OpeningObject) O).contentMid == 2
				&& ((OpeningObject) O).sashObjectMid.opens == 1) {
			Object[] sash = ((OpeningObject) O).sashObjectMid.frames.toArray();
			this.drawSashes(sash, false);
		} else if (((OpeningObject) O).contentMid == 1) {
			this.drawGlazingBeads(O);
		}

		if (((OpeningObject) O).sashObjectOut != null
				&& ((OpeningObject) O).contentOut == 2
				&& ((OpeningObject) O).sashObjectOut.opens == 1) {
			Object[] sash = ((OpeningObject) O).sashObjectOut.frames.toArray();
			this.drawSashes(sash, false);
		} else if (((OpeningObject) O).contentOut == 1) {
			this.drawGlazingBeads(O);
		}
	}

	/**
	 * Do Open In Sash
	 * 
	 * @param F
	 *            , FrameObject
	 * @param O
	 *            , OpeningObject
	 */
	public void doOpenInSash(Object F, Object O) {

		if (((OpeningObject) O).sashObjectIn != null
				&& ((OpeningObject) O).contentIn == 2
				&& ((OpeningObject) O).sashObjectIn.opens >= 2) {

			Object[] sash = ((OpeningObject) O).sashObjectIn.frames.toArray();
			this.drawSashes(sash, false);
		} else if (((OpeningObject) O).contentIn == 1) {
			this.drawGlazingBeads(O);
		}

		if (((OpeningObject) O).sashObjectMid != null
				&& ((OpeningObject) O).contentMid == 2
				&& ((OpeningObject) O).sashObjectMid.opens >= 2) {

			Object[] sash = ((OpeningObject) O).sashObjectMid.frames.toArray();
			this.drawSashes(sash, false);
			this.prepareDrawAstragalsOut(F);
		} else if (((OpeningObject) O).contentMid == 1) {
			this.drawGlazingBeads(O);
		}

		if (((OpeningObject) O).sashObjectOut != null
				&& ((OpeningObject) O).contentOut == 2
				&& ((OpeningObject) O).sashObjectOut.opens >= 2) {
			Object[] sash = ((OpeningObject) O).sashObjectOut.frames.toArray();
			this.drawSashes(sash, false);
		} else if (((OpeningObject) O).contentOut == 1) {
			this.drawGlazingBeads(O);
		}
	}

	public void prepareDrawInterlocks(Object F) {

		Object[] openings = ((ShapeObject) F).openings.toArray();

		for (final Object O : openings) {
			if (((OpeningObject) O).sashObjectIn != null
					&& ((OpeningObject) O).contentIn == 2
					&& (((OpeningObject) O).sashObjectIn.opens == 1
							|| ((OpeningObject) O).sashObjectIn.opens == 3 || ((OpeningObject) O).sashObjectIn.opens == 4)) {
				if (((OpeningObject) O).sashObjectIn.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectIn.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectIn.sashClassType >= 70) {
					Object[] openingOb = ((OpeningObject) O).sashObjectIn.openings
							.toArray();

					for (Object o : openingOb) {
						this.drawGlass(o);
					}

					this.drawInterLocks(((OpeningObject) O).sashObjectIn.bOpeningObject);
				}
			}

			if (((OpeningObject) O).sashObjectMid != null
					&& ((OpeningObject) O).contentMid == 2
					&& (((OpeningObject) O).sashObjectMid.opens == 1
							|| ((OpeningObject) O).sashObjectMid.opens == 3 || ((OpeningObject) O).sashObjectMid.opens == 4)) {

				if (((OpeningObject) O).sashObjectMid.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectMid.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectMid.sashClassType >= 70) {
					final Object[] so = ((OpeningObject) O).sashObjectMid.openings
							.toArray();

					for (final Object o : so) {
						this.drawGlass(o);
					}

					this.drawInterLocks(((OpeningObject) O).sashObjectMid.bOpeningObject);
				}
			}

			if (((OpeningObject) O).sashObjectOut != null
					&& ((OpeningObject) O).contentOut == 2
					&& (((OpeningObject) O).sashObjectOut.opens == 1
							|| ((OpeningObject) O).sashObjectOut.opens == 3 || ((OpeningObject) O).sashObjectOut.opens == 4)) {

				if (((OpeningObject) O).sashObjectOut.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectOut.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectOut.sashClassType >= 70) {

					Object[] so = ((OpeningObject) O).sashObjectOut.openings
							.toArray();

					for (final Object o : so) {
						this.drawGlass(o);
					}

					this.drawInterLocks(((OpeningObject) O).sashObjectOut.bOpeningObject);
				}
			}
		}
	}

	public void prepareDrawAstragalsOut(Object F) {

		Object[] ops = ((ShapeObject) F).openings.toArray();
		for (Object O : ops) {
			if (((OpeningObject) O).sashObjectIn != null
					&& ((OpeningObject) O).contentIn == 2
					&& ((OpeningObject) O).sashObjectIn.opens == 2) {

				if (((OpeningObject) O).sashObjectIn.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectIn.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectIn.sashClassType >= 70) {
					this.drawInterLocks(((OpeningObject) O).sashObjectIn.bOpeningObject);
				}
			}

			if (((OpeningObject) O).sashObjectMid != null
					&& ((OpeningObject) O).contentMid == 2
					&& ((OpeningObject) O).sashObjectMid.opens == 2) {

				if (((OpeningObject) O).sashObjectMid.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectMid.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectMid.sashClassType >= 70) {
					this.drawInterLocks(((OpeningObject) O).sashObjectMid.bOpeningObject);
				}
			}

			if (((OpeningObject) O).sashObjectOut != null
					&& ((OpeningObject) O).contentOut == 2
					&& ((OpeningObject) O).sashObjectOut.opens == 2) {
				if (((OpeningObject) O).sashObjectOut.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectOut.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectOut.sashClassType >= 70) {
					this.drawInterLocks(((OpeningObject) O).sashObjectOut.bOpeningObject);
				}
			}
		}
	}

	public void drawFixedPaneSliderBeads(Object F) {

		Object[] ops = ((ShapeObject) F).openings.toArray();
		for (Object O : ops) {
			if (((OpeningObject) O).sashObjectIn != null
					&& ((OpeningObject) O).contentIn == 2
					&& (((OpeningObject) O).sashObjectIn.opens == 1
							|| ((OpeningObject) O).sashObjectIn.opens == 3 || ((OpeningObject) O).sashObjectIn.opens == 4)) {
				if (((OpeningObject) O).sashObjectIn.sashClassType >= 11
						|| ((OpeningObject) O).sashObjectIn.sashClassType <= 40) {
					Object[] ops2 = ((OpeningObject) O).sashObjectIn.openings
							.toArray();
					for (Object o : ops2) {
						this.drawGlazingBeads(o);
					}
				}

			}
			if (((OpeningObject) O).sashObjectMid != null
					&& (((OpeningObject) O).sashObjectMid.opens == 1
							|| ((OpeningObject) O).sashObjectMid.opens == 3 || ((OpeningObject) O).sashObjectMid.opens == 4)) {

				if (((OpeningObject) O).sashObjectMid.sashClassType >= 11
						|| ((OpeningObject) O).sashObjectMid.sashClassType <= 40) {
					Object[] so = ((OpeningObject) O).sashObjectMid.openings
							.toArray();
					for (Object o : so) {
						this.drawGlazingBeads(o);
					}
				}

			}
			if (((OpeningObject) O).sashObjectOut != null
					&& ((OpeningObject) O).contentOut == 2
					&& (((OpeningObject) O).sashObjectOut.opens == 1
							|| ((OpeningObject) O).sashObjectMid.opens == 3 || ((OpeningObject) O).sashObjectMid.opens == 4)) {
				if (((OpeningObject) O).sashObjectOut.sashClassType >= 11
						|| ((OpeningObject) O).sashObjectOut.sashClassType <= 40) {
					Object[] so = ((OpeningObject) O).sashObjectOut.openings
							.toArray();
					for (Object o : so) {
						this.drawGlazingBeads(o);
					}
				}
			}
		}
	}

	public void prepareDrawInterlocksSelected(Object F) {

		Object[] ops = ((ShapeObject) F).openings.toArray();

		for (Object O : ops) {

			if (((OpeningObject) O).sashObjectIn != null
					&& ((OpeningObject) O).contentIn == 2
					&& (((OpeningObject) O).sashObjectIn.opens == 1
							|| ((OpeningObject) O).sashObjectIn.opens == 3 || ((OpeningObject) O).sashObjectIn.opens == 4)) {

				if (((OpeningObject) O).sashObjectIn.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectIn.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectIn.sashClassType >= 70) {
					// drawInterLocks(((OpeningObject)
					// O).sashObjectIn.bOpeningObject);
					Object[] ops2 = ((OpeningObject) O).sashObjectIn.openings
							.toArray();
					for (Object o : ops2) {
						// drawGlass(o);
					}
					this.drawInterLocks(((OpeningObject) O).sashObjectIn.bOpeningObject);
				}
			}

			if (((OpeningObject) O).sashObjectMid != null
					&& ((OpeningObject) O).contentMid == 2
					&& (((OpeningObject) O).sashObjectMid.opens == 1
							|| ((OpeningObject) O).sashObjectMid.opens == 3 || ((OpeningObject) O).sashObjectMid.opens == 4)) {

				if (((OpeningObject) O).sashObjectMid.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectMid.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectMid.sashClassType >= 70) {
					Object[] so = ((OpeningObject) O).sashObjectMid.openings
							.toArray();
					for (Object o : so) {
						// drawGlass(o);
					}
					this.drawInterLocks(((OpeningObject) O).sashObjectMid.bOpeningObject);
				}
			}

			if (((OpeningObject) O).sashObjectOut != null
					&& ((OpeningObject) O).contentOut == 2
					&& (((OpeningObject) O).sashObjectOut.opens == 1
							|| ((OpeningObject) O).sashObjectOut.opens == 3 || ((OpeningObject) O).sashObjectOut.opens == 4)) {

				if (((OpeningObject) O).sashObjectOut.sashClassType >= 11
						&& ((OpeningObject) O).sashObjectOut.sashClassType <= 50
						|| ((OpeningObject) O).sashObjectOut.sashClassType >= 70) {

					Object[] so = ((OpeningObject) O).sashObjectOut.openings
							.toArray();
					for (Object o : so) {
						// drawGlass(o);
					}
					this.drawInterLocks(((OpeningObject) O).sashObjectOut.bOpeningObject);
				}
			}
		}
	}

	/**
	 * Drawing glass object
	 * 
	 * @param O
	 *            , OpeningObject
	 */
	public void drawGlass(Object O) {

		if (((OpeningObject) O).contentIn == 1
				&& ((OpeningObject) O).myGlassIn != null) {

			if (((OpeningObject) O).myGlassIn.glazingType != 0
					&& !((OpeningObject) O).unGlazed) {

				if (((OpeningObject) O).dloIn.hasGrids) {
					this.doGrids(O);
				}

				g2.setColor(Color.DARK_GRAY);

				new BasicStroke(2, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_BEVEL, 0, new float[] { 3 }, 0);

				g2.draw(((OpeningObject) O).myGlassIn.gp);
				g2.setPaint(new Color(235, 235, 240, 64));
				g2.fill(((OpeningObject) O).myGlassIn.gp);

				if (((OpeningObject) O).dloIn.masterW
						&& myParent.dim.showGridMaster.isSelected()) {
					String masterW = "V";
					FontRenderContext frc = g2.getFontRenderContext();

					TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.BLUE);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 10),
							(float) (((OpeningObject) O).startingYA + 10));
				}

				if (((OpeningObject) O).dloIn.masterH
						&& myParent.dim.showGridMaster.isSelected()) {

					String masterW = "H";
					FontRenderContext frc = g2.getFontRenderContext();

					TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.BLUE);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 12),
							(float) (((OpeningObject) O).startingYA + 10));
				}
			}
		}

		if (((OpeningObject) O).contentMid == 1
				&& ((OpeningObject) O).myGlassMid != null) {

			if (((OpeningObject) O).myGlassMid.glazingType != 0
					&& !((OpeningObject) O).unGlazed) {

				if (((OpeningObject) O).dloMid.hasGrids) {
					this.doGrids(O);
				}

				// Show glass information label
				if (myParent.dim.showGlass.isSelected()) {

					JLabel glass = new JLabel();

					this.add(glass, new XYConstraints(
							(int) ((OpeningObject) O).myGlassMid.startingX,
							(int) ((OpeningObject) O).myGlassMid.startingY,
							(int) ((OpeningObject) O).myGlassMid.widthPix,
							(int) ((OpeningObject) O).myGlassMid.heightPix));

					String attributes = "";

					for (Object n : ((OpeningObject) O).myGlassMid.notes
							.toArray()) {
						attributes = ((ShapeNotes) n).stockcode + " : "
								+ ((ShapeNotes) n).value + "<br>";

					}

					if (myParent.currentUOM == 1) {
						glass.setToolTipText("<html>"
								+ ((OpeningObject) O).myGlassMid.stockCode
								+ " : "
								+ ((OpeningObject) O).myGlassMid.description
								+ "<br>" + "Width :"
								+ ((OpeningObject) O).myGlassMid.widthM / 100d
								+ "<br>" + "Height :"
								+ ((OpeningObject) O).myGlassMid.heightM / 100d
								+ "<br> <br>" + attributes + "</html>");

					} else if (myParent.currentUOM == 2) {
						glass.setToolTipText("<html>"
								+ ((OpeningObject) O).myGlassMid.stockCode
								+ " : "
								+ ((OpeningObject) O).myGlassMid.description
								+ "<br>" + "<br>" + "Width :"
								+ ((OpeningObject) O).myGlassMid.widthI / 64d
								+ "<br>" + "Height :"
								+ ((OpeningObject) O).myGlassMid.heightI / 64d
								+ "<br> <br>" + attributes + "</html>");
					} else if (myParent.currentUOM == 2) {
						try {
							glass.setToolTipText("<html>"
									+ ((OpeningObject) O).myGlassMid.stockCode
									+ " : "
									+ ((OpeningObject) O).myGlassMid.description
									+ "<br>"
									+ "<br>"
									+ "Width :"
									+ UOMConvertData
											.imperialToFraction((((OpeningObject) O).myGlassMid.widthI / 64d)
													+ "")
									+ "<br>"
									+ "Height :"
									+ UOMConvertData
											.imperialToFraction((((OpeningObject) O).myGlassMid.heightI / 64d)
													+ "") + "<br> <br>"
									+ attributes + "</html>");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

				g2.setPaint(new Color(200, 200, 200, 64));
				g2.fill(((OpeningObject) O).myGlassMid.gp);

				if (((OpeningObject) O).dloMid.masterW
						&& !((OpeningObject) O).dloMid.masterH
						&& myParent.dim.showGridMaster.isSelected()) {

					String masterW = "|";
					FontRenderContext frc = g2.getFontRenderContext();

					TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.RED);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 12),
							(float) (((OpeningObject) O).startingYA + 10));
				}

				if (((OpeningObject) O).dloMid.masterH
						&& !((OpeningObject) O).dloMid.masterW
						&& myParent.dim.showGridMaster.isSelected()) {

					String masterW = "---";
					FontRenderContext frc = g2.getFontRenderContext();

					final TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.RED);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 12),
							(float) (((OpeningObject) O).startingYA + 10));
				}
				if (((OpeningObject) O).dloMid.masterH
						&& ((OpeningObject) O).dloMid.masterW
						&& myParent.dim.showGridMaster.isSelected()) {

					String masterW = "-|-";
					FontRenderContext frc = g2.getFontRenderContext();

					final TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.RED);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 12),
							(float) (((OpeningObject) O).startingYA + 10));
				}
			}
		}

		if (((OpeningObject) O).contentOut == 1
				&& ((OpeningObject) O).myGlassOut != null) {

			if (((OpeningObject) O).myGlassOut.glazingType != 0
					&& !((OpeningObject) O).unGlazed) {

				if (((OpeningObject) O).dloOut.hasGrids) {
					this.doGrids(O);
				}

				g2.setColor(Color.DARK_GRAY);
				new BasicStroke(2, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_BEVEL, 0, new float[] { 3 }, 0);

				g2.draw(((OpeningObject) O).myGlassOut.gp);
				g2.setPaint(new Color(235, 235, 240, 64));
				g2.fill(((OpeningObject) O).myGlassOut.gp);

				if (((OpeningObject) O).dloOut.masterW
						&& myParent.dim.showGridMaster.isSelected()) {

					String masterW = "V";
					FontRenderContext frc = g2.getFontRenderContext();

					TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.BLUE);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 10),
							(float) (((OpeningObject) O).startingYA + 10));
				}

				if (((OpeningObject) O).dloOut.masterH
						&& myParent.dim.showGridMaster.isSelected()) {

					String masterW = "H";
					FontRenderContext frc = g2.getFontRenderContext();

					final TextLayout view = new TextLayout(masterW, font, frc);
					g2.setColor(Color.BLUE);
					view.draw(g2,
							(float) (((OpeningObject) O).startingXA + 12),
							(float) (((OpeningObject) O).startingYA + 10));
				}
			}
		}
	}

	/**
	 * Drawing couplers
	 * 
	 * @param myFacet
	 *            , Facet
	 */
	public void drawCouplers(Facet myFacet) {

		// Get array of verticals mullions
		myFacet.bOpeningObject.mullionObjectsV = myFacet.bOpeningObject.mullions
				.toArray();

		// Get array of horizontal mullions
		myFacet.bOpeningObject.mullionObjectsH = myFacet.bOpeningObject.mullionsH
				.toArray();

		// Drawing horizontal couplers or mullions
		drawHC(myFacet);

		// Drawing Vertical coupler or mullions
		drawVC(myFacet);
	}

	/**
	 * Draw Vertical coupler
	 * 
	 * @param myFacet
	 *            , Facet
	 */
	public void drawVC(Facet myFacet) {

		for (Object V : myFacet.bOpeningObject.mullionObjectsV) {

			if (((Profiles) V).isValid) {
				g2.setColor(new Color(((Profiles) V).rgb_R,
						((Profiles) V).rgb_G, ((Profiles) V).rgb_B,
						((Profiles) V).transp));
				g2.fill(((Profiles) V).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) V).gp);

				if (((Profiles) V).profileSelected == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) V).poly);
					g2.setColor(Color.black);
					g2.draw(((Profiles) V).poly);
					g2.setColor(Color.black);
					g2.setStroke(new BasicStroke());
				}
			}
		}
	}

	/**
	 * Drawing horizontal coupler or mullions
	 * 
	 * @param myFacet
	 *            , Facet
	 */
	public void drawHC(Facet myFacet) {

		for (Object H : myFacet.bOpeningObject.mullionObjectsH) {

			if (((Profiles) H).isValid) {

				g2.setColor(new Color(((Profiles) H).rgb_R,
						((Profiles) H).rgb_G, ((Profiles) H).rgb_B,
						((Profiles) H).transp));
				g2.fill(((Profiles) H).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) H).gp);

				if (((Profiles) H).profileSelected == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) H).poly);
					g2.setColor(Color.black);
					g2.draw(((Profiles) H).poly);
					g2.setColor(Color.black);
					g2.setStroke(new BasicStroke());
				}
			}
		}
	}

	/**
	 * Drawing couplers from BkgrdOpening Object
	 * 
	 * @param myFacet
	 *            , Overall
	 */
	public void drawCouplers(Overall myFacet) {

		myFacet.bOpeningObject.mullionObjectsV = myFacet.bOpeningObject.mullions
				.toArray();
		myFacet.bOpeningObject.mullionObjectsH = myFacet.bOpeningObject.mullionsH
				.toArray();

		for (Object V : myFacet.bOpeningObject.mullionObjectsV) {

			if (((Profiles) V).thickness > 0) {

				g2.setColor(new Color(((Profiles) V).rgb_R,
						((Profiles) V).rgb_G, ((Profiles) V).rgb_B,
						((Profiles) V).transp));
				g2.fill(((Profiles) V).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) V).gp);

				if (((Profiles) V).profileSelected == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) V).poly);
					g2.setColor(Color.black);
					g2.draw(((Profiles) V).poly);
					g2.setColor(Color.black);
					g2.setStroke(new BasicStroke());
				}
			}
		}

		for (Object H : myFacet.bOpeningObject.mullionObjectsH) {
			if (((Profiles) H).thickness > 0) {
				g2.setColor(new Color(((Profiles) H).rgb_R,
						((Profiles) H).rgb_G, ((Profiles) H).rgb_B,
						((Profiles) H).transp));
				g2.fill(((Profiles) H).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) H).gp);

				if (((Profiles) H).profileSelected == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) H).poly);
					g2.setColor(Color.black);
					g2.draw(((Profiles) H).poly);
					g2.setColor(Color.black);
					g2.setStroke(new BasicStroke());
				}
			}
		}
	}

	/**
	 * Drawing profiles
	 * 
	 * @param parts
	 *            , Object[]
	 */
	public void drawProfiles(Object[] parts) {

		for (final Object P : parts) {

			if (!((Profiles) P).remove
			// && (((Profiles) P).partDimB > 0
			// || ((Profiles) P).partDimA > 0 || ((Profiles) P).partDimC > 0)
			) {

				if (((Profiles) P).partForm == 1 && ((Profiles) P).partDimB>0) {
					g2.setColor(new Color(((Profiles) P).rgb_R,
							((Profiles) P).rgb_G, ((Profiles) P).rgb_B,
							((Profiles) P).transp));
					g2.fill(((Profiles) P).gp);
					g2.setColor(Color.black);
					g2.draw(((Profiles) P).gp);

				}

				if (((Profiles) P).profileSelected == 1
						&& ((Profiles) P).partForm == 1 && ((Profiles) P).partDimB>0) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) P).polygon);
				} else if (((Profiles) P).profileSelected == 1
						&& ((Profiles) P).partForm == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) P).polygon);
				}

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());

			}
		}
	}

	public void drawFrameToolTips(Frame frame, final Object[] parts) {

		if (myParent.dim.showName.isSelected()) {

			String frameName = ItemFrame
					.getApplicationBaseRules()
					.getSeriesValidOpeningById(
							((Frame) frame).controlUserDefinedOpeningID)
					.getSeriesValidOpeningPK().getAbbreviation();

			String attributes = "";

			for (Object n : ((Frame) frame).notes.toArray()) {
				attributes = ((ShapeNotes) n).stockcode + " : "
						+ ((ShapeNotes) n).description + "<br>";
			}

			for (final Object P : parts) {
				if (!((Profiles) P).remove
				// && (((Profiles) P).partDimB > 0
				// || ((Profiles) P).partDimA > 0 || ((Profiles) P).partDimC >
				// 0)
				) {

					if (((Profiles) P).partForm == 1) {

						JLabel pane = new JLabel();

						pane.setBackground(new Color(255, 128, 0, 64));
						pane.setOpaque(true);
						pane.setToolTipText("<html>" + frameName + " <br>"
								+ attributes + "</html>");

						this.add(pane, new XYConstraints(
								(int) ((Profiles) P).startingX,
								(int) ((Profiles) P).startingY + 1,
								(int) ((Profiles) P).partDimB,
								(int) ((Profiles) P).partDimB));

					}

				}
			}
		}
	}

	/**
	 * Drawing grids parts from background opening object from DLO
	 * 
	 * @param parts
	 *            , Object[]
	 */
	public void drawGrids(Object[] parts) {

		for (Object P : parts) {

			if (!((Profiles) P).remove) {

				if (((Profiles) P).partForm == 1) {
					g2.setColor(new Color(((Profiles) P).rgb_R,
							((Profiles) P).rgb_G, ((Profiles) P).rgb_B, 255));
					// g2.setColor(new Color(255,
					// 255, 255, 64));
					g2.fill(((Profiles) P).gp);
					g2.setColor(Color.black);
					g2.draw(((Profiles) P).gp);

				} else if (((Profiles) P).partForm > 1) {
					// g2.setColor(new Color(((Profiles) P).rgb_R,
					// ((Profiles) P).rgb_G, ((Profiles) P).rgb_B,
					// ((Profiles) P).transp));
					g2.setColor(new Color(((Profiles) P).rgb_R,
							((Profiles) P).rgb_G, ((Profiles) P).rgb_B, 255));
					g2.draw(((Profiles) P).gp);
					g2.setColor(Color.black);
					g2.draw(((Profiles) P).curveB);
					g2.draw(((Profiles) P).curveBA);
					g2.draw(((Profiles) P).curveA);
				}

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			}
		}
	}

	/**
	 * Drawing spokes
	 * 
	 * @param parts
	 *            , Object[]
	 */
	public void drawSpokes(Object[] parts) {

		for (Object P : parts) {

			if (!((Profiles) P).remove && !((Profiles) P).remove) {

				if (((Profiles) P).partForm == 1) {
					g2.setColor(new Color(((Profiles) P).rgb_R,
							((Profiles) P).rgb_G, ((Profiles) P).rgb_B, 255));
					g2.fill(((Profiles) P).gp);

					// g2.setColor(new Color(255,
					// 255, 255, 64));
					// g2.fill(((Profiles) P).gp);

					g2.setColor(Color.black);
					g2.draw(((Profiles) P).gp);

				} else if (((Profiles) P).profileSelected == 1
						&& ((Profiles) P).partForm == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) P).gp);
					g2.setColor(Color.black);
					g2.draw(((Profiles) P).gp);

				} else if (((Profiles) P).profileSelected == 1
						&& ((Profiles) P).partForm == 1) {
					g2.setColor(new Color(255, 0, 0, 64));
					g2.fill(((Profiles) P).gp);
					g2.setColor(Color.black);
					g2.draw(((Profiles) P).gp);
				}

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());

			}
		}
	}

	/**
	 * Drawing profiles curves
	 * 
	 * @param parts
	 *            , Object[]
	 */
	public void drawProfilesCurves(Object[] parts) {

		for (Object P : parts) {

			if (!((Profiles) P).remove
			// && (((Profiles) P).partDimB > 0
			// || ((Profiles) P).partDimA > 0 || ((Profiles) P).partDimC > 0)
			) {

				if (((Profiles) P).partForm != 1 && ((Profiles) P).partDimB>0) {

					g2.setColor(new Color(((Profiles) P).rgb_R,
							((Profiles) P).rgb_G, ((Profiles) P).rgb_B,
							((Profiles) P).transp));

					g2.draw(((Profiles) P).gp);

					g2.setColor(Color.black);
					g2.draw(((Profiles) P).curveB);
					g2.draw(((Profiles) P).curveA);

					if (((Profiles) P).partDimA > 0) {
						g2.draw(((Profiles) P).curveBA);
					}
				}

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			}
		}
	}

	/**
	 * Drawin mullions components from BkgrdOpening
	 * 
	 * @param shapeObject
	 *            , ShapeObject
	 */
	public void drawMullions(ShapeObject shapeObject) {

		// Get mullions objects verticals
		shapeObject.bOpeningObject.mullionObjectsV = shapeObject.bOpeningObject.mullions
				.toArray();

		for (Object mullion : shapeObject.bOpeningObject.mullionObjectsV) {

			if (((Profiles) mullion).profileSelected == 0) {

				g2.setColor(new Color(((Profiles) mullion).rgb_R,
						((Profiles) mullion).rgb_G, ((Profiles) mullion).rgb_B,
						((Profiles) mullion).transp));
				g2.fill(((Profiles) mullion).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) mullion).gp);

			} else if (((Profiles) mullion).profileSelected == 1) {

				g2.setColor(new Color(((Profiles) mullion).rgb_R,
						((Profiles) mullion).rgb_G, ((Profiles) mullion).rgb_B,
						((Profiles) mullion).transp));
				g2.fill(((Profiles) mullion).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) mullion).gp);

				Polygon m = ((Profiles) mullion).poly;
				g2.setColor(new Color(255, 0, 0, 64));
				g2.fill(m);

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());

			} else if (((Profiles) mullion).profileSelected == 2) {
				g2.setColor(new Color(((Profiles) mullion).rgb_R,
						((Profiles) mullion).rgb_G, ((Profiles) mullion).rgb_B,
						((Profiles) mullion).transp));
				g2.fill(((Profiles) mullion).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) mullion).gp);

				Polygon m = ((Profiles) mullion).poly;
				g2.setColor(new Color(0, 0, 255, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());

			} else if (((Profiles) mullion).potentialS) {
				g2.setColor(new Color(((Profiles) mullion).rgb_R,
						((Profiles) mullion).rgb_G, ((Profiles) mullion).rgb_B,
						((Profiles) mullion).transp));
				g2.fill(((Profiles) mullion).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) mullion).gp);

				Polygon m = ((Profiles) mullion).poly;
				g2.setColor(new Color(0, 255, 0, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			}
		}

		// Get mullions objects horizontal
		shapeObject.bOpeningObject.mullionObjectsH = shapeObject.bOpeningObject.mullionsH
				.toArray();

		for (Object M : shapeObject.bOpeningObject.mullionObjectsH) {

			if (((Profiles) M).profileSelected == 0) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));
				g2.fill(((Profiles) M).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

			} else if (((Profiles) M).profileSelected == 1) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));
				g2.fill(((Profiles) M).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(255, 0, 0, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());

			} else if (((Profiles) M).profileSelected == 2) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));
				g2.fill(((Profiles) M).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(0, 0, 255, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());

			} else if (((Profiles) M).potentialS) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));
				g2.fill(((Profiles) M).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(0, 255, 0, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			}
		}
	}

	/**
	 * Draw mullions selected
	 * 
	 * @param F
	 *            , Object
	 * @param isGrid
	 *            , is a Grid
	 */
	public void drawMullionsSelected(Object F, final boolean isGrid) {

		((ShapeObject) F).bOpeningObject.mullionObjectsV = ((ShapeObject) F).bOpeningObject.mullions
				.toArray();

		for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsV) {
			this.drawSelectedMullions(M, false);
		}

		((ShapeObject) F).bOpeningObject.mullionObjectsH = ((ShapeObject) F).bOpeningObject.mullionsH
				.toArray();

		for (final Object M : ((ShapeObject) F).bOpeningObject.mullionObjectsH) {
			this.drawSelectedMullions(M, isGrid);
		}
	}

	/**
	 * Draw Selected Mullions
	 * 
	 * @param M
	 *            , Object
	 * @param isGrid
	 *            , is a Grid
	 */
	public void drawSelectedMullions(Object M, final boolean isGrid) {

		if (((Profiles) M).profileSelected == 1) {

			Polygon m = ((Profiles) M).poly;
			if (!isGrid) {
				g2.setColor(new Color(255, 0, 0, 64));
			} else {
				g2.setColor(new Color(255, 0, 0, 200));
			}

			g2.fill(m);
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke());

		} else if (((Profiles) M).profileSelected == 2) {

			Polygon m = ((Profiles) M).poly;

			if (!isGrid) {
				g2.setColor(new Color(0, 255, 0, 64));
			} else {
				g2.setColor(new Color(0, 255, 0, 200));
			}

			g2.fill(m);
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke());
		} else if (((Profiles) M).potentialS) {

			Polygon m = ((Profiles) M).poly;

			if (!isGrid) {
				g2.setColor(new Color(0, 0, 255, 64));
			} else {
				g2.setColor(new Color(0, 0, 255, 200));
			}

			g2.fill(m);
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke());
		}
	}

	/**
	 * Draw Interlocks
	 * 
	 * @param F
	 *            , BkgrdOpening Object
	 */
	public void drawInterLocks(BkgrdOpeningObject F) {

		Object[] vm = F.mullions.toArray();

		for (Object M : vm) {
			if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).profileSelected == 0) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);
			} else if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).profileSelected == 1) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);

				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(255, 0, 0, 64));
				g2.fill(m);

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			} else if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).profileSelected == 2) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);

				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(0, 0, 255, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			} else if ((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0
					|| (((Profiles) M).partDimBi + ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0
					|| ((Profiles) M).potentialS) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);

				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(0, 255, 0, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			}

		}

		Object[] hm = F.mullionsH.toArray();

		for (Object M : hm) {

			if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).profileSelected == 0) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);

				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);
			} else if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).profileSelected == 1) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);

				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(255, 0, 0, 64));
				g2.fill(m);

				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			} else if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).profileSelected == 2) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);

				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(0, 0, 255, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			} else if (((((Profiles) M).partDimB + ((Profiles) M).partDimA + ((Profiles) M).partDimC) > 0 || (((Profiles) M).partDimBi
					+ ((Profiles) M).partDimAi + ((Profiles) M).partDimCi) > 0)
					&& ((Profiles) M).potentialS) {
				g2.setColor(new Color(((Profiles) M).rgb_R,
						((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
						((Profiles) M).transp));

				g2.fill(((Profiles) M).gp);
				g2.setColor(Color.black);
				g2.draw(((Profiles) M).gp);

				Polygon m = ((Profiles) M).poly;
				g2.setColor(new Color(0, 255, 0, 64));
				g2.fill(m);
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke());
			}
		}
	}

	/**
	 * Drawing sashes
	 * 
	 * @param sash
	 *            , Object[]
	 * @param selected
	 *            , boolean
	 */
	public void drawSashes(Object[] sash, boolean selected) {

		Collection sashesOrderedOnTrack = new ArrayList();

		int track = 1;

		for (Object B : sash) {
			for (Object B2 : sash) {
				if (((SashLeaf) B2).trackNo == track) {
					sashesOrderedOnTrack.add(B2);
				}
			}

			track++;
		}

		Object[] orderedSashes = sashesOrderedOnTrack.toArray();

		for (Object B : orderedSashes) {
			if ((((SashLeaf) B).openingClass != 61
					&& ((SashLeaf) B).openingClass != 62 && ((SashLeaf) B).openingClass != 63)
					|| ((((SashLeaf) B).openingClass == 61
							|| ((SashLeaf) B).openingClass == 62 || ((SashLeaf) B).openingClass == 63) && ((SashLeaf) B).myParent.isglazed)) {

				if (!selected) {
					Object[] openingObjects = ((SashLeaf) B).openings.toArray();
					Object[] parts = ((SashLeaf) B).partObjects.toArray();

					if (!((SashLeaf) B).glazedOut) {
						this.drawSashOpenings(B);

						this.drawProfilesCurves(parts);
						this.drawProfiles(parts);

						this.drawMullions((SashLeaf) B);
						this.drawMullionsSelected(B, false);

						for (Object b : openingObjects) {
							this.drawGlazingBeads(b);
						}

						drawSashMullions(sash, selected, sashesOrderedOnTrack);

					} else {

						this.drawProfilesCurves(parts);
						this.drawProfiles(parts);

						this.drawMullions((SashLeaf) B);
						this.drawMullionsSelected(B, false);

						this.drawSashMullions(sash, selected,
								sashesOrderedOnTrack);

						this.drawSashOpenings(B);

						for (Object b : openingObjects) {
							this.drawGlazingBeads(b);
						}

					}
				} else {
					this.drawMullionsSelected(B, false);
				}

				Object[] symbols = ((SashLeaf) B).symbol.toArray();

				for (Object L : symbols) {

					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);

					if (((SashLeaf) B).paneType != 50
							&& ((SashLeaf) B).paneType != 51) {
						g2.setColor(new Color(255, 0, 0, 128));
						g2.draw((Shape) L);
					} else {
						Stroke drawingStroke = new BasicStroke(1,
								BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER,
								1, new float[] { 10 }, 0);

						g2.setStroke(drawingStroke);
						g2.setColor(new Color(255, 0, 0, 128));

						g2.draw((Shape) L);
						g2.setColor(Color.black);
						g2.setStroke(new BasicStroke());
					}

					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_OFF);
				}
			}

			else {

				g2.setColor(Color.DARK_GRAY);

				new BasicStroke(2, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_BEVEL, 0, new float[] { 3 }, 0);

				GeneralPath myOpen = new GeneralPath();

				SeriesValidOpeningShape s = ItemFrame.getApplicationBaseRules()
						.getSeriesValidOpeningById(
								((SashLeaf) B).userDefinedOpeningID);

				double overlap = 0;

				if (myParent.mySeries.getSeriesUom() == 1) {

					overlap = new BigDecimal(s.getLouvreoverlap()).multiply(
							myParent.metricscale).doubleValue();

				} else {

					overlap = new BigDecimal(s.getLouvreoverlapi()).multiply(
							myParent.imperialscale).doubleValue();

				}

				if (((SashLeaf) B).trackNo == 1) {
					myOpen.moveTo((int) ((SashLeaf) B).px4 + 2,
							(int) ((SashLeaf) B).py4);
					myOpen.lineTo((int) ((SashLeaf) B).px3 - 2,
							(int) ((SashLeaf) B).py3);
				} else {
					myOpen.moveTo((int) ((SashLeaf) B).px4 + 2,
							(int) ((SashLeaf) B).py4 + overlap);
					myOpen.lineTo((int) ((SashLeaf) B).px3 - 2,
							(int) ((SashLeaf) B).py3 + overlap);
				}

				g2.setStroke(new BasicStroke(2));
				g2.draw(myOpen);

				// g2.setColor(Color.black);
				// g2.draw(((SashLeaf) B).gp);

				Object[] parts = ((SashLeaf) B).partObjects.toArray();

				int r = 230;
				int g = 230;
				int b = 255;

				for (Object p : parts) {
					r = ((Profiles) p).rgb_R;
					g = ((Profiles) p).rgb_G;
					b = ((Profiles) p).rgb_B;
					break;
				}

				g2.setPaint(new Color(r, g, b, 255));

				g2.fill(((SashLeaf) B).gp);

			}

		}
	}

	/**
	 * Draw Sash Mullions
	 * 
	 * @param sash
	 *            , Object[]
	 * @param selected
	 *            , If Object is selected
	 * @param sashesOrderedOnTrack
	 *            , sashes Ordered On Track
	 */
	public void drawSashMullions(Object[] sash, boolean selected,
			Collection sashesOrderedOnTrack) {

		Object[] orderedSashes = sashesOrderedOnTrack.toArray();

		for (Object B : orderedSashes) {

			if (!selected) {
				Object[] openingObjects = ((SashLeaf) B).openings.toArray();

				this.drawMullions((SashLeaf) B);
				this.drawMullionsSelected(B, false);

			} else {
				((SashLeaf) B).openings.toArray();
				this.drawMullionsSelected(B, false);
			}
		}
	}

	/**
	 * Draw Sash Openings
	 * 
	 * @param B
	 *            , Object
	 */
	public void drawSashOpenings(Object B) {

		Object[] openingObjects = ((SashLeaf) B).openings.toArray();

		for (Object O2 : openingObjects) {

			this.drawGlass(O2);
		}
	}

	/**
	 * Do draw glass for opening object
	 * 
	 * @param O2
	 *            , Object
	 */
	public void doGrids(Object O2) {

		Object[] myPs = ((OpeningObject) O2).dloMid.gridPartsS.toArray();
		this.drawSpokes(myPs);

		myPs = ((OpeningObject) O2).dloMid.bOpeningObject.mullionsH.toArray();
		this.drawGrids(myPs);

		for (Object M : myPs) {
			this.drawSelectedMullions(M, true);
		}

		myPs = ((OpeningObject) O2).dloMid.bOpeningObject.mullions.toArray();
		this.drawGrids(myPs);

		for (Object M : myPs) {
			this.drawSelectedMullions(M, true);
		}
	}

	/**
	 * Draw Glazing beads
	 * 
	 * @param O
	 *            , Object
	 */
	public void drawGlazingBeads(Object O) {

		if (((OpeningObject) O).glazedOut && myParent.jobItem.viewOut) {
			if (((OpeningObject) O).contentIn == 1
					&& ((OpeningObject) O).myGlassIn != null) {
				Object[] bead = ((OpeningObject) O).glazingBeadsIn.toArray();
				this.drawProfilesCurves(bead);
				this.drawProfiles(bead);
			}

			if (((OpeningObject) O).contentMid == 1) {
				Object[] sos = ((OpeningObject) O).openings.toArray();

				for (Object oo : sos) {
					Object[] bead = ((OpeningObject) oo).glazingBeadsMid
							.toArray();

					this.drawProfilesCurves(bead);
					this.drawProfiles(bead);
				}

				Object[] bead = ((OpeningObject) O).glazingBeadsMid.toArray();

				this.drawProfilesCurves(bead);
				this.drawProfiles(bead);

			}
			if (((OpeningObject) O).contentOut == 1
					&& ((OpeningObject) O).myGlassOut != null) {
				Object[] bead = ((OpeningObject) O).glazingBeadsOut.toArray();
				this.drawProfilesCurves(bead);
				this.drawProfiles(bead);

			}
		}

	}

	// /**
	// * Adding SUType functionality to Glass
	// *
	// * @param glassSU , GlassSU Object
	// * @see Model.ShapeObject
	// */
	// public void doAddingSUTypeGlass(OpeningObject openingObject, GlassSU
	// glassSU)
	// throws Exception {
	//
	// // Get selected SUType
	// SUType suType = myParent.glassPanel.getSuTypeSelected();
	//
	// // Create glass function for GlassSU
	// CreateGlass createGlass = new CreateGlass(openingObject,
	// openingObject.myFrame2);
	//
	// // Setting SUType to all glass
	// if (myParent.glassPanel.allGlass.isSelected()) {
	// createGlass.configSUTypeGlassSU(glassSU, suType);
	// }
	//
	// // Setting SUType to glass selected
	// if (myParent.glassPanel.oneGlass.isSelected()) {
	//
	// if (glassSU.equals(myParent.selectedGlassSU)) {
	// createGlass.configSUTypeGlassSU(glassSU, suType);
	// myParent.selectedGlassSU = null;
	// }
	// }
	// }

	public void equalizeWidthsNew() {

		try {

			myParent.dim.getSelectedDim();

			final Object[] tfTop = myParent.topTexts.toArray();

			if (tfTop.length > 1) {

				if (dimensionType <= 4) {
					final Object[] facets = myParent.jobItem.design.frames
							.toArray();

					final Collection existingFacets = new ArrayList();

					existingFacets.addAll(myParent.jobItem.design.frames);

					myParent.jobItem.design.frames.clear();

					for (Object facet : facets) {
						if (((Facet) facet).a_sequenceID == myParent.facetUsed.a_sequenceID) {

							final CreateFacets createFacet = new CreateFacets(
									((Facet) facet).myParentO, existingFacets,
									myParent);

							facet = createFacet.doFacet(false, false, false,
									true);

							((Facet) facet).doCouplers();

							((Facet) facet).doFrames(true, true, true, false);
							((Facet) facet).drawFrames();

							((Facet) facet).setOriginalDimsInit(
									((Facet) facet).widthPix,
									((Facet) facet).heightPix);
							((Facet) facet).setDimsChange(
									((Facet) facet).widthPix,
									((Facet) facet).heightPix);

							((Facet) facet)
									.reDrawRadioRowCol(
											((Facet) facet).bOpeningObject.yRows,
											((Facet) facet).bOpeningObject.xCols,
											1,
											myParent.jobItem.myCanvas.selectedRadioForRow,
											myParent.jobItem.myCanvas.selectedRadioForCol,
											(Facet) facet);

						}
						myParent.jobItem.design.frames.add(facet);
					}

				}// Dim <= 3

				else if (dimensionType == 5) {
					final Object[] facets = myParent.jobItem.design.frames
							.toArray();

					final Collection existingFacets = new ArrayList();

					existingFacets.addAll(myParent.jobItem.design.frames);

					myParent.jobItem.design.frames.clear();

					for (final Object facet : facets) {
						if (((Facet) facet).a_sequenceID == myParent.facetUsed.a_sequenceID) {

							final Object[] frames = ((Facet) facet).frames
									.toArray();

							final Collection existingFrames = new ArrayList();
							existingFrames.addAll(((Facet) facet).frames);

							((Facet) facet).frames.clear();
							for (Object frame : frames) {
								if (((Frame) frame).a_sequenceID == mySelectedFrame.a_sequenceID) {

									if (existingFrames.size() > 0) {
										for (final Object f : existingFrames) {

											final Object[] fo = ((Frame) f).openings
													.toArray();
											for (final Object o : fo) {
												if (((Frame) f).controlOpSeq == ((OpeningObject) o).a_sequenceID) {
													if (((OpeningObject) o).contentMid == 2) {

														myParent.sashType = ((OpeningObject) o).sashObjectMid;

													} else {

														myParent.getSashType((OpeningObject) o);// setDefaultSashType(O);

													}
												}
											}

										}
									}

									final CreateFrames createFrame = new CreateFrames(
											((Frame) frame).myParentO,
											existingFrames, myParent);

									frame = createFrame
											.doFrame(
													myParent.sashType.sashClassType,
													myParent.sashType.userDefinedOpeningID,
													myParent.sashType.openingTypeClass,
													null,
													myParent.sashType,
													null,
													myParent.sashType.glazedOut,
													true, true, true);

									// ((Frame)frame).reDrawRadioRowCol(
									// ((Frame)frame).bOpeningObject.yRows,
									// ((Frame)frame).bOpeningObject.xCols,
									// 1,
									// myParent.jobItem.myCanvas.selectedRadioForRow,
									// myParent.jobItem.myCanvas.selectedRadioForCol,((Frame)frame));

								}
								((Facet) facet).frames.add(frame);
							}

						}
						myParent.jobItem.design.frames.add(facet);

					}

					myParent.dimAction();

				}

			}

			myParent.jobItem.myCanvas.validate();
			myParent.jobItem.myCanvas.repaint();

		} catch (Exception e) {
			e.printStackTrace();

			// JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
			// "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void equalizeWidths() {

		try {

			Object[] tfTop = myParent.topTexts.toArray();

			if (equalize && tfTop.length > 1) {
				myParent.dim.getSelectedDim();
				if (myParent.selectedDim <= 2) {
					if (myParent.selectedDim != 1) {
						if (myParent.frameDim) {
							myParent.dim.center.doClick();
						} else {
							myParent.dim.frame.doClick();
						}
					}
					for (int tf = 0; tf < myParent.topTextsMod.length; tf++) {
						myParent.topTextsMod[tf] = 0;
					}
				} else if (myParent.selectedDim >= 3
						&& myParent.selectedDim <= 6) {
					for (int tf = 0; tf < myParent.topTextsModo.length; tf++) {
						myParent.topTextsModo[tf] = 0;
					}
				}

				tfTop = myParent.topTexts.toArray();

				boolean allEquals = true;

				for (int i = 1; i < tfTop.length; i++) {

					if (!tfTop[i].toString().equals(tfTop[0])) {
						allEquals = false;
						break;
					}
				}

				if (!allEquals) {
					myParent.topTexts.clear();
					double totalW = 0;
					double totalWC = 0;
					int tf = 0;
					if (myParent.selectedDim <= 4 || myParent.selectedDim > 6) {
						for (tf = 0; tf < tfTop.length; tf++) {

							totalW = totalW + ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;

							totalWC = totalWC
									+ ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;

						}
					} else {

						for (tf = 0; tf < tfTop.length; tf++) {

							totalW = totalW + ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;

							totalWC = totalWC
									+ ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;

						}

					}

					double myNewWidth = totalW / tfTop.length;
					double myNewWidthC = totalWC / tfTop.length;

					if (!Double.isNaN(myNewWidth)) {

						for (tf = 0; tf < tfTop.length; tf++) {
							if (dimensionType <= 2) {

								if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {
									((TextFieldTop) tfTop[tf]).newPos = myParent.jobItem.startingX;
									((TextFieldTop) tfTop[tf]).newPosc = myParent.jobItem.startingX;
									((TextFieldTop) tfTop[tf]).newPose = myParent.jobItem.startingX
											+ myNewWidth;
									((TextFieldTop) tfTop[tf]).newPosec = myParent.jobItem.startingX
											+ myNewWidthC;

								} else if (((TextFieldTop) tfTop[tf]).endRowCol == myParent.facetUsed.bOpeningObject.xCols) {

									((TextFieldTop) tfTop[tf]).newPos = this
											.getposcforLastColumn(
													((TextFieldTop) tfTop[tf]).startRowCol,
													tfTop)
											+ ((TextFieldTop) tfTop[tf]).deltaL
											+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
									((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
											- ((TextFieldTop) tfTop[tf]).deltaL;
									((TextFieldTop) tfTop[tf]).newPose = endX;
									((TextFieldTop) tfTop[tf]).newPosec = endX;

								} else {
									((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
											+ ((TextFieldTop) tfTop[tf]).deltaL
											+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
									((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
											- ((TextFieldTop) tfTop[tf]).deltaL;
									((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
											+ myNewWidth;
									((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
											+ myNewWidthC;

								}
								myParent.topTexts.add(tfTop[tf]);

							} else {

								if (dimensionType != 7 && dimensionType != 8) {
									if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {
										((TextFieldTop) tfTop[tf]).newPos = mySelectedFrame.bOpeningObject.startingX;
										((TextFieldTop) tfTop[tf]).newPosc = mySelectedFrame.bOpeningObject.startingCX;
										((TextFieldTop) tfTop[tf]).newPose = mySelectedFrame.bOpeningObject.startingX
												+ myNewWidth;
										((TextFieldTop) tfTop[tf]).newPosec = mySelectedFrame.bOpeningObject.startingCX
												+ myNewWidthC;

									} else if (((TextFieldTop) tfTop[tf]).endRowCol == mySelectedFrame.xCols) {
										((TextFieldTop) tfTop[tf]).newPos = this
												.getposcforLastColumn(
														((TextFieldTop) tfTop[tf]).startRowCol,
														tfTop)
												+ ((TextFieldTop) tfTop[tf]).deltaL
												+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
										((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
												- ((TextFieldTop) tfTop[tf]).deltaL;
										((TextFieldTop) tfTop[tf]).newPose = endX;
										((TextFieldTop) tfTop[tf]).newPosec = endX;
									} else {
										((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
												+ ((TextFieldTop) tfTop[tf]).deltaL
												+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
										((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
												- ((TextFieldTop) tfTop[tf]).deltaL;
										((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
												+ myNewWidth;
										((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
												+ myNewWidthC;
									}
								} else {
									if (((TextFieldTop) tfTop[tf]).colNo == 1) {
										((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf]).parent.startingX;
										((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).parent.startingCX;
										((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
												+ myNewWidth;
										((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
												+ myNewWidthC;
									} else {
										((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
												+ ((TextFieldTop) tfTop[tf - 1]).deltaR
												+ ((TextFieldTop) tfTop[tf]).deltaL;
										((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf - 1]).newPosec;
										((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
												+ myNewWidth;
										((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
												+ myNewWidthC;
									}
								}

								myParent.topTexts.add(tfTop[tf]);

							}

						}// for textTop

						if (dimensionType <= 2) {
							myParent.facetUsed.modifyInternalDims(
									selectedRadioForRow, 1);

						} else if (dimensionType >= 3 && dimensionType <= 9) {

							if (dimensionType == 9) {

								myParent.jobItem.design.findDLO
										.changeInternalDims(
												selectedRadioForRow,
												selectedRadioForCol,
												selectedRadioForRowo,
												selectedRadioForColo,
												selectedOpeningNo,
												myParent.topTexts,
												2,
												1,
												myParent.facetUsed.myClickedFrame);
							} else {
								mySelectedFrame.modifyInternalDims(
										selectedRadioForRowo, 1, dimensionType);
							}
						}

					}

				}

				// myParent.dimAction();
			}
		} catch (Exception e) {
			e.printStackTrace();

			// JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
			// "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void equalizeWidthsInShape() {

		try {

			if (myParent.selectedDim <= 2) {

				Object[] facets = this.myParent.jobItem.design.frames.toArray();
				myParent.jobItem.design.frames.clear();
				for (Object f : facets) {
					if (((Facet) f).a_sequenceID == this.myParent.facetUsed.a_sequenceID) {
						((Facet) f).bOpeningObject = ((Facet) f).bOpeningObject
								.VMCGEqualize(((Facet) f).bOpeningObject);

						((Facet) f).doOpenings();

					}

					myParent.jobItem.design.frames.add(f);
				}

			} else if (myParent.selectedDim >= 3 && myParent.selectedDim <= 6) {

			} else if (myParent.selectedDim <= 4 || myParent.selectedDim > 6) {

			}

			myParent.dimAction();
		} catch (Exception e) {
			e.printStackTrace();
			// JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
			// "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void equalizeHeights() {

		Object[] tfLeft = myParent.leftTexts.toArray();

		if (equalizeH && tfLeft.length > 1) {

			if (dimensionType <= 2) {
				for (int tf = 0; tf < myParent.leftTextsMod.length; tf++) {
					myParent.leftTextsMod[tf] = 0;
				}
			} else if (dimensionType == 4) {
				for (int tf = 0; tf < myParent.leftTextsModo.length; tf++) {
					myParent.leftTextsModo[tf] = 0;
				}
			} else if (dimensionType == 3) {
				for (int tf = 0; tf < myParent.leftTextsModo.length; tf++) {
					myParent.leftTextsModo[tf] = 0;
				}
			}
			tfLeft = myParent.leftTexts.toArray();

			double totalH = 0;

			double totalHC = 0;

			boolean allEquals = true;

			for (int i = 1; i < tfLeft.length; i++) {

				if (!tfLeft[i].toString().equals(tfLeft[0])) {
					allEquals = false;
					break;
				}
			}

			if (!allEquals) {
				int tf = 0;
				for (tf = 0; tf < tfLeft.length; tf++) {

					totalH = totalH + ((TextFieldLeft) tfLeft[tf]).size;// /this.myParent.scale;

					totalHC = totalHC + ((TextFieldLeft) tfLeft[tf]).sizeC;// /this.myParent.scale;

				}
				final double myNewH = totalH / tf;
				final double myNewHC = totalHC / tf;
				for (int tfn = 0; tfn < tfLeft.length; tfn++) {

					((TextFieldLeft) tfLeft[tfn]).size = myNewH;// /this.myParent.scale;

					((TextFieldLeft) tfLeft[tfn]).sizeC = myNewHC;// /this.myParent.scale;

				}
				if (!Double.isNaN(myNewH)) {
					this.modRowHeights(myNewH);
				}

			}
		}
	}

	public void resetdrawTextForColRow() {

		if (dimensionType <= 2) {
			myParent.facetUsed.resetTextsforRowCol(selectedRadioForRow,
					selectedRadioForCol, selectedRadioForRowo,
					selectedRadioForColo, false);

		} else if (dimensionType >= 3 || dimensionType <= 9) {
			myParent.facetUsed.resetTextsforRowCol(selectedRadioForRow,
					selectedRadioForCol, selectedRadioForRowo,
					selectedRadioForColo, true);

		}

		myParent.facetUsed.resetPanels();
	}

	public void redrawTextForColRow(boolean mod) {

		try {

			if (myParent.facetUsed != null) {
				ShapeObject dimOverall = myParent.facetUsed;

				if (myParent.dim.isSash.isSelected()
						&& myParent.mySelectedSash != null) {
					dimOverall = myParent.mySelectedSash;
				}

				if (myParent.dim.sFLevel.isSelected()) {

					final Object[] fs = myParent.facetUsed.frames.toArray();

					for (final Object f : fs) {
						if (((Frame) f).startRow == selectedRadioForRow
								&& ((Frame) f).startCol == selectedRadioForCol) {
							final Object[] ops = ((Frame) f).openings.toArray();
							for (final Object o : ops) {
								if (((OpeningObject) o).myParent.startRow == selectedRadioForRow
										&& ((OpeningObject) o).myParent.startCol == selectedRadioForCol
										&& ((OpeningObject) o).contentMid == 3) {
									dimOverall = ((OpeningObject) o).subFacet;
									myParent.facetUsed = dimOverall;
								}
							}
						}
					}
				}

				if (myParent.dim.isSash.isSelected()
						&& myParent.mySelectedSash != null) {
					myParent.topTexts.clear();
					myParent.leftTexts.clear();
				}

				if (dimensionType == 0) {
					dimOverall.reDrawTextsforRowCol(selectedRadioForRow,
							selectedRadioForCol, mod, dimOverall);
				} else if (dimensionType == 1 || dimensionType == 2) {
					dimOverall.reDrawTextsforRowCol(selectedRadioForRow,
							selectedRadioForCol, mod, dimOverall);
				} else if (dimensionType == 3 || dimensionType == 4) {

					dimOverall.reDrawTextsforRowColOp(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo, mod, dimensionType);

				} else if (dimensionType == 5)// sash
				{

					dimOverall.reDrawTextsforRowColOp(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo, mod, dimensionType);

				} else if (dimensionType == 6)// sashOpening
				{

					dimOverall.reDrawTextsforRowColOp(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo, mod, dimensionType);

				} else if (dimensionType == 7)// Glass
				{

					dimOverall.reDrawTextsforRowColOp(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo, mod, dimensionType);

				} else if (dimensionType == 8)// dlo
				{

					dimOverall.reDrawTextsforRowColOp(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo, mod, dimensionType);

				} else if (dimensionType == 9)// grids
				{

					dimOverall.reDrawTextsforRowColOp(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo, mod, dimensionType);

				}

				// myParent.redrawTextDone=true;

				if (myParent.dim.isSash.isSelected()
						&& myParent.mySelectedSash != null) {

					createRadioforFacets(selectedfBot);

					final Object[] leafs = ((SashTypeObject) myParent.mySelectedSash).frames
							.toArray();

					for (final Object f : leafs) {
						if (((SashLeaf) f).startCol == selectedRadioForColo
								&& ((SashLeaf) f).startRow == selectedRadioForRowo) {
							myParent.mySelectedSashLeaf = (SashLeaf) f;

							if (myParent.selectedDim >= 5
									&& myParent.selectedDim <= 8) {
								((SashLeaf) f).doTopTextModOpening(
										selectedRadioForRow,
										selectedRadioForCol,
										selectedRadioForRowo,
										selectedRadioForColo);

								((SashLeaf) f).doLeftTextModOpening(
										selectedRadioForRow,
										selectedRadioForCol,
										selectedRadioForRowo,
										selectedRadioForColo);

							} else if (myParent.selectedDim == 9) {
								final Object[] openings = ((SashLeaf) f).openings
										.toArray();

								for (final Object so : openings) {
									if (((OpeningObject) so).startRow == selectedRadioForRowo
											&& ((OpeningObject) so).startCol == selectedRadioForColo) {

										((OpeningObject) so).dloMid
												.doTopTextModGrid(
														selectedRadioForRow,
														selectedRadioForCol,
														selectedRadioForRowo,
														selectedRadioForColo);

										((OpeningObject) so).dloMid
												.doLeftTextModGrid(
														selectedRadioForRow,
														selectedRadioForCol,
														selectedRadioForRowo,
														selectedRadioForColo);
									}
								}
							}
						}
					}
				}

				myParent.resetModTextsV = false;
				myParent.resetModTextsH = false;
				// myParent.setCostPrice();
			}

			this.myParent.jobItem.design.reDrawRadioRowCol(
					this.myParent.jobItem.design.yRows,
					this.myParent.jobItem.design.xCols, 1, selectedRadioForRow,
					selectedRadioForCol, this.myParent.facetUsed);

			// this.validate();
			// this.repaint();
			// myParent.validate();
			// myParent.repaint();

		} catch (Exception e) {
			e.printStackTrace();
			// JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
			// "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Text Row Action Performed
	 * 
	 * @param e
	 *            , ActionEvent
	 */
	public void myTextRow_actionPerformed(ActionEvent e) {
		myParent.modifyDims = false;
		JXTextField tf = (JXTextField) e.getSource();
		textRowAction(tf);
	}

	/**
	 * Text Row Action
	 * 
	 * @param tf
	 *            , JTextField
	 */
	public void textRowAction(JXTextField tf) {
		if (Double.parseDouble(tf.getText()) > 0) {

			if (!changeDimDone) {

				boolean was5 = false;

				int x = (int) (tf).getLocation().getX();

				int y = (int) (tf).getLocation().getY();

				tf.getWidth();

				// get Column No - column selected for change
				this.getSelectedColTop(x, y);// Get Selected
				getSelectedFrameFromTextRC();

				myParent.doFacetRadioClick();
				BigDecimal myScale = new BigDecimal(0);

				if (myParent.myTopPanel.metric.isSelected()) {
					myScale = myParent.scale.multiply(new BigDecimal(100));
				} else {
					myScale = myParent.scale;
				}

				changeDimDone = true;

				myParent.modifyDims = false;
				double myW = 0;

				Collection allFrames = new ArrayList();

				Object[] facets = myParent.jobItem.design.frames.toArray();
				for (Object f : facets) {
					allFrames.addAll(((Facet) f).frames);
				}

				for (Object f : allFrames) {
					if (((Frame) f).startRow == selectedRadioForRow
							&& ((Frame) f).startCol == selectedRadioForCol) {
						mySelectedFrame = (Frame) f;
					}
				}

				OpeningObject selectedOpening = new OpeningObject();

				if (this.dimensionType == 5) {

					for (Object o : mySelectedFrame.openings.toArray()) {
						if (((OpeningObject) o).startRow == this.selectedRadioForRow
								&& ((OpeningObject) o).startCol == this.selectedCol) {
							selectedOpening = ((OpeningObject) o);
							break;
						}
					}

					this.myParent.showDims = false;
					this.myParent.dim.fOpeningA.doClick();
					was5 = true;
				}

				String myString = (tf).getText();

				if (was5) {
					double myOEntry = Double.parseDouble((tf).getText());
					double myOpeningW = 0;
					double delta = 0;
					if (myParent.currentUOM == 1) {
						myOpeningW = selectedOpening.widthM / 100;
						delta = (selectedOpening.widthMN - selectedOpening.widthM) / 100;
					} else {
						myOpeningW = selectedOpening.widthI / 64;
						delta = (selectedOpening.widthIN - selectedOpening.widthI) / 64;
					}

					myString = (Double.parseDouble(myString) - delta) + "";

				}

				myW = getEnteredTextInPix(myScale.doubleValue(), myString);

				Object[] values = new Object[2];
				try {
					values = myParent.readTextCurrentUOM((tf));
				} catch (final Exception e1) {
					e1.printStackTrace();
				}

				if (myParent.myTopPanel.isStdSelected
						&& this.mySelectedFrame.startRow == 1) {

					Object[] tfTop = myParent.topTexts.toArray();

					myParent.topTexts.clear();
					this.myParent.jobItem.isStd = true;
					double sum = 0;
					double sumC = 0;
					double total = 0;
					double totalC = 0;
					final String size[] = new String[tfTop.length];
					final String sizeC[] = new String[tfTop.length];

					double delta = 0;
					String dString = "";
					double originalFW = 0;

					final Object[] frames = myParent.facetUsed.frames.toArray();
					myParent.facetUsed.frames.clear();
					for (final Object frame : frames) {
						if (((Frame) frame).startRow == 1
								&& ((Frame) frame).startCol == this.selectedCol) {

							((Frame) frame).isStdW = true;
							if (myParent.currentUOM == 1) {
								((Frame) frame).widthM = (int) Double
										.parseDouble(values[0].toString()) * 100;

							} else {
								((Frame) frame).widthI = (int) Double
										.parseDouble(values[0].toString());

							}
						}
						myParent.facetUsed.frames.add(frame);
					}
					this.myParent.showDims = true;
				} else {
					this.myParent.showDims = true;
					doTopTextChange(tf, myScale, myW);
				}

				if (was5) {
					this.myParent.showDims = true;
					this.myParent.dim.fOpeningN.doClick();
				}

			}
		} else {
			JOptionPane.showMessageDialog(this.myParent,
					"Please check the dimension entered!", "Error",
					JOptionPane.ERROR_MESSAGE);
			this.myParent.showDims = true;
			tf.setText(myParent.lastTextValue + "");
		}

	}

	public void setFInalOWfromFW(JXTextField tf, BigDecimal myScale, double myW) {
		this.myParent.myTopPanel.resetSize(false);
		doTopTextChange(tf, myScale, myW);
	}

	public void setOWbyFrameW(BigDecimal myScale, final String myString,
			Object[] values) {

		double myW;
		Object[] tfTop = myParent.topTexts.toArray();

		myParent.topTexts.clear();
		this.myParent.jobItem.isStd = true;
		double sum = 0;
		double sumC = 0;
		double total = 0;
		double totalC = 0;
		final String size[] = new String[tfTop.length];
		final String sizeC[] = new String[tfTop.length];

		double delta = 0;
		String dString = "";
		double originalFW = 0;

		final Object[] frames = myParent.facetUsed.frames.toArray();
		myParent.facetUsed.frames.clear();
		for (final Object frame : frames) {
			if (((Frame) frame).startCol == selectedFrameNo) {

				((Frame) frame).isStdW = true;
				if (myParent.currentUOM == 1) {
					originalFW = ((Frame) frame).widthM;
					((Frame) frame).widthM = (int) (Double
							.parseDouble(values[0].toString()) * 100);
					delta = ((Frame) frame).widthM - originalFW;
				} else {
					originalFW = ((Frame) frame).widthI;
					((Frame) frame).widthI = (int) Double.parseDouble(values[0]
							.toString());
					delta = ((Frame) frame).widthI - originalFW;
				}
			}
			myParent.facetUsed.frames.add(frame);
		}

		double totalW = Double.parseDouble(this.myParent.myTopPanel.fW
				.getText());

		// this.myParent.myTopPanel.fW.setText(myParent.doRoundDim(totalC) +
		// "");
		//
		// myParent.myTopPanel.resetSize(false);
		//
		// if (myParent.myTopPanel.metric.isSelected()) {
		// myScale = myParent.scale .multiply( new BigDecimal(100));
		// } else {
		// myScale = myParent.scale;
		// }
		//
		// // myParent.scale = myScale / 100;
		//
		// myW = getEnteredTextInPix(myScale.doubleValue(), myString);
		//
		// delta = getEnteredTextInPix(myScale.doubleValue(), dString);
		//
		// tfTop = myParent.topTexts.toArray();
		//
		// tfTop = myParent.topTexts.toArray();
		// myParent.topTexts.clear();
		//
		// total = 0;
		// totalC = 0;
		// for (int tf = 0; tf < tfTop.length; tf++) {
		//
		// if (((TextFieldTop) tfTop[tf]).colNo == selectedFrameNo) {
		//
		// ((TextFieldTop) tfTop[tf]).size = myW;
		// ((TextFieldTop) tfTop[tf]).sizeC = myW + delta;
		//
		// } else {
		// ((TextFieldTop) tfTop[tf]).size =
		// getEnteredTextInPix(myScale.doubleValue(), size[tf]);
		//
		// ((TextFieldTop) tfTop[tf]).sizeC =
		// getEnteredTextInPix(myScale.doubleValue(), sizeC[tf]);
		//
		// }
		// total = total + ((TextFieldTop) tfTop[tf]).size;
		// totalC = totalC + ((TextFieldTop) tfTop[tf]).sizeC;
		//
		// ((TextFieldTop) tfTop[tf]).newSizeC = ((TextFieldTop)
		// tfTop[tf]).sizeC;
		// ((TextFieldTop) tfTop[tf]).newSize = ((TextFieldTop)
		// tfTop[tf]).size;
		//
		// myParent.lastSelectedCol = selectedFrameNo;
		//
		// myParent.topTexts.add(tfTop[tf]);
		// }
		//
		// // modColWSTD(myW, total, totalC);
		// // myParent.myTopPanel.stdSetButton.doClick();
		// // myParent.dim.frame.doClick();
		// // myParent.myTopPanel.stdButton.doClick();
	}

	public void myTextColLeft_actionPerformed(final ActionEvent e) {

		myParent.modifyDims = false;

		JXTextField tf = (JXTextField) e.getSource();

		textColAction(tf);

	}

	public void doTopTextChange(JXTextField tf, BigDecimal myScale, double myW) {

		Object[] returns = new Object[3];

		returns = frameColumnsTextChange(myW, myScale.doubleValue());

		if (!Boolean.parseBoolean(returns[0].toString())) {
			JOptionPane.showMessageDialog(this.myParent,
					"Invalid Dimension Entered!", "Invalid Dimension - Error!",
					JOptionPane.ERROR_MESSAGE);

			if (dimensionType == 1 || dimensionType == 3) {
				tf.setText(Double.valueOf(returns[2].toString())
						* myScale.doubleValue() + "");
			} else if (dimensionType == 2 || dimensionType == 4) {
				tf.setText(Double.valueOf(returns[1].toString())
						* myScale.doubleValue() + "");
			}
			myParent.lastSelectedDim = dimensionType;

			myParent.dim.resetDim();

		}
	}

	public void textColAction(JXTextField txt) {

		if (Double.parseDouble(txt.getText()) > 0) {

			if (!changeDimDone) {
				final int x = (int) (txt).getLocation().getX();

				final int y = (int) (txt).getLocation().getY();

				this.getSelectedRowLeft(x, y);

				getSelectedFrameFromTextRC();

				BigDecimal myScale = new BigDecimal(0);

				if (myParent.myTopPanel.metric.isSelected()) {
					myScale = myParent.scale.multiply(new BigDecimal(100));
				} else {
					myScale = myParent.scale;
				}

				Collection allFrames = new ArrayList();

				Object[] facets = myParent.jobItem.design.frames.toArray();
				for (Object f : facets) {
					allFrames.addAll(((Facet) f).frames);
				}

				for (Object f : allFrames) {
					if (((Frame) f).startRow == selectedRadioForRow
							&& ((Frame) f).startCol == selectedRadioForCol) {
						mySelectedFrame = (Frame) f;
					}
				}

				OpeningObject selectedOpening = new OpeningObject();

				boolean was5 = false;

				if (this.dimensionType == 5) {

					for (Object o : mySelectedFrame.openings.toArray()) {
						if (((OpeningObject) o).startRow == this.selectedRowLeft
								&& ((OpeningObject) o).startCol == this.selectedRadioForCol) {
							selectedOpening = ((OpeningObject) o);
							break;
						}
					}

					this.myParent.showDims = false;
					this.myParent.dim.fOpeningA.doClick();
					was5 = true;
				}

				changeDimDone = true;

				myParent.modifyDims = false;
				double myH = 0;
				String myString = (txt).getText();

				if (was5) {
					double myOEntry = Double.parseDouble((txt).getText());
					double myOpeningH = 0;
					double delta = 0;
					if (myParent.currentUOM == 1) {
						myOpeningH = selectedOpening.heightM / 100;
						delta = (selectedOpening.heightMN - selectedOpening.heightM) / 100;
					} else {
						myOpeningH = selectedOpening.heightI / 64;
						delta = (selectedOpening.heightIN - selectedOpening.heightI) / 64;
					}

					myString = (Double.parseDouble(myString) - delta) + "";

				}

				myH = getEnteredTextInPix(myScale.doubleValue(), myString);

				Object[] returns = new Object[3];

				Object[] values = new Object[2];
				try {
					values = myParent.readTextCurrentUOM(txt);
				} catch (final Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (myParent.myTopPanel.isStdSelected
						&& this.mySelectedFrame.startRow == 1) {

					Object[] tfTop = myParent.leftTexts.toArray();

					myParent.leftTexts.clear();
					this.myParent.jobItem.isStd = true;
					double sum = 0;
					double sumC = 0;
					double total = 0;
					double totalC = 0;
					final String size[] = new String[tfTop.length];
					final String sizeC[] = new String[tfTop.length];

					double delta = 0;
					String dString = "";

					final Object[] frames = myParent.facetUsed.frames.toArray();
					myParent.facetUsed.frames.clear();
					for (final Object frame : frames) {
						if (((Frame) frame).startCol == 1
								&& ((Frame) frame).startRow == this.selectedRowLeft) {

							((Frame) frame).isStdH = true;
							if (myParent.currentUOM == 1) {
								((Frame) frame).heightM = (int) Double
										.parseDouble(values[0].toString()) * 100;

							} else {
								((Frame) frame).heightI = (int) Double
										.parseDouble(values[0].toString());

							}
						}
						myParent.facetUsed.frames.add(frame);
					}

				} else {

					doLeftTextChange(txt, myScale, myH);

				}

				if (was5) {
					this.myParent.showDims = true;
					this.myParent.dim.fOpeningN.doClick();
				}

			}
		} else {
			JOptionPane.showMessageDialog(this.myParent,
					"Please check the dimension entered!", "Error",
					JOptionPane.ERROR_MESSAGE);
			txt.setText(myParent.lastTextValue + "");
		}
	}

	public void doLeftTextChange(JXTextField txt, BigDecimal myScale, double myW) {

		Object[] returns;
		returns = this.frameRowsTextChange(myW, myScale.doubleValue());

		if (!Boolean.parseBoolean(returns[0].toString())) {
			JOptionPane.showMessageDialog(this.myParent,
					"Invalid Dimension Entered!", "Invalid Dimension - Error!",
					JOptionPane.ERROR_MESSAGE);

			if (dimensionType == 1 || dimensionType == 3) {
				(txt).setText(Double.valueOf(returns[2].toString())
						* myScale.doubleValue() + "");
			} else if (dimensionType == 2 || dimensionType == 4) {
				(txt).setText(Double.valueOf(returns[1].toString())
						* myScale.doubleValue() + "");
			}
			myParent.lastSelectedDim = dimensionType;

			myParent.dim.resetDim();

		}
	}

	public double getEnteredTextInPix(final double myScale,
			final String myString) {

		double myW = 0;
		if (myParent.myTopPanel.metric.isSelected()) {
			myW = Double.parseDouble(myString) * myScale;

		} else if (myParent.myTopPanel.impDec.isSelected()) {
			myW = Double.parseDouble(myString) * 64 * myScale;

		} else if (myParent.myTopPanel.impFrac.isSelected()) {
			try {
				myW = Double.parseDouble(UOMConvert
						.fractionToImperial(myString)) * 64 * myScale;
			} catch (final NumberFormatException e1) {
				// TODO
				// Auto-generated catch
				// block
				e1.printStackTrace();
			} catch (final Exception e1) {
				// TODO
				// Auto-generated catch
				// block
				e1.printStackTrace();
			}

		} else if (myParent.myTopPanel.percent.isSelected()) {
			myW = Double.parseDouble(myString)
					* myParent.jobItem.design_flat_WIDTHpix * myScale;
		}
		return myW;
	}

	public void myTextBot_actionPerformed(final ActionEvent e) {

		final int x = (int) ((JXTextField) e.getSource()).getLocation().getX();

		((JXTextField) e.getSource()).getLocation().getY();
		final int xx = ((JXTextField) e.getSource()).getWidth();

		final int endX = x + xx;
		final double a = Double.parseDouble(((JXTextField) e.getSource())
				.getText());

		this.getSetSelectedCoupler(x, endX, a);

		this.createTextFieldsCoupler();

	}

	public void myTextFacetBot_actionPerformed(final ActionEvent e) {

		myParent.modifyDims = false;

		if (!changeDimDone) {
			int x = (int) ((JXTextField) e.getSource()).getLocation().getX();

			final int y = (int) ((JXTextField) e.getSource()).getLocation()
					.getY();

			final int xx = ((JXTextField) e.getSource()).getWidth();

			x = x + xx / 2;

			Object[] values = new Object[2];

			try {
				values = myParent.readTextCurrentUOM((JXTextField) e
						.getSource());
			} catch (final Exception e1) {
				// TODO Auto-generated catch
				// block
				e1.printStackTrace();
			}

			myNewFW = values[0].toString();

			changeFacetW(x, y, Double.parseDouble(myNewFW));
			setStdWH((Facet) myParent.facetUsed);
		}

	}

	public Facet setStdWH(final Facet myFacet) {

		BigDecimal myScale = new BigDecimal(0);

		if (myParent.myTopPanel.metric.isSelected()) {
			myScale = myParent.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myParent.scale;
		}

		mySelectedFacet = myFacet;

		if (myParent.mainFacetCheckBot != null) {
			myParent.mainFacetCheckBot[myFacet.startCol].doClick();
		}

		if (myParent.frameDim) {
			myParent.dim.center.doClick();
		} else {
			myParent.dim.frame.doClick();
		}

		Object[] frames = myFacet.frames.toArray();
		// myFacet.frames.clear();
		int sumStdW = 0;
		int sumStdH = 0;
		int noneStdW = 0;
		int noneStdH = 0;

		final Collection stdCols = new ArrayList();
		final Collection stdRowa = new ArrayList();

		for (final Object frame : frames) {
			if (((Frame) frame).isStdW) {

				if (myParent.currentUOM == 1) {

					sumStdW = sumStdW + ((Frame) frame).stdWM;
					myParent.myTextRow[((Frame) frame).startCol - 1]
							.setText(((Frame) frame).stdWM + "");

					selectedOpeningNo = 1;

					selectedFrameNo = ((Frame) frame).startCol;

					frameColumnsTextChange(
							((Frame) frame).stdWM * myScale.doubleValue(),
							myScale.doubleValue());
				} else {
					// / WRONG needs the
					// right format Fract or Dec.
					sumStdW = sumStdW + ((Frame) frame).stdWI;
					myParent.myTextRow[((Frame) frame).startCol - 1]
							.setText(((Frame) frame).stdWI / 64 + "");

					selectedOpeningNo = 1;

					selectedFrameNo = ((Frame) frame).startCol;

					frameColumnsTextChange(
							((Frame) frame).stdWI / 64 * myScale.doubleValue(),
							myScale.doubleValue());
				}
			}

			if (((Frame) frame).isStdH) {
				if (myParent.currentUOM == 1) {
					sumStdH = sumStdH + ((Frame) frame).stdHM;
					myParent.myTextLeft[((Frame) frame).startRow - 1]
							.setText(((Frame) frame).stdHM + "");
					selectedOpeningNo = 1;
					selectedFrameNo = ((Frame) frame).startRow;
					frameRowsTextChange(
							((Frame) frame).stdHM * myScale.doubleValue(),
							myScale.doubleValue());
				} else {
					// / WRONG needs the
					// right format Fract or Dec.
					sumStdH = sumStdH + ((Frame) frame).stdHI;
					myParent.myTextLeft[((Frame) frame).startRow - 1]
							.setText(((Frame) frame).stdHI / 64 + "");
					selectedOpeningNo = 1;
					selectedFrameNo = ((Frame) frame).startRow;
					frameRowsTextChange(
							((Frame) frame).stdHI / 64 * myScale.doubleValue(),
							myScale.doubleValue());
				}

			}

			if (!((Frame) frame).isStdW) {
				noneStdW++;
			}
			if (!((Frame) frame).isStdW) {
				noneStdH++;
			}

			// myFacet.frames.add(frame);
		}

		frames = myFacet.frames.toArray();

		int nstdW = 0;
		int nstdH = 0;

		if (myParent.currentUOM == 1) {
			nstdW = (myFacet.widthM / 100 - sumStdW) / noneStdW;
			nstdH = (myFacet.heightM / 100 - sumStdH) / noneStdH;
		} else {
			nstdW = (myFacet.widthI - sumStdW) / noneStdW;
			nstdH = (myFacet.heightI - sumStdH) / noneStdH;
		}

		for (final Object frame : frames) {

			if (!((Frame) frame).isStdW) {
				if (myParent.currentUOM == 1) {

					myParent.myTextRow[((Frame) frame).startCol - 1]
							.setText(nstdW + "");

					selectedOpeningNo = 1;

					selectedFrameNo = ((Frame) frame).startCol;

					frameColumnsTextChange(nstdW * myScale.doubleValue(),
							myScale.doubleValue());
				} else {

					myParent.myTextRow[((Frame) frame).startCol - 1]
							.setText(nstdW / 64 + "");

					selectedOpeningNo = 1;

					selectedFrameNo = ((Frame) frame).startCol;

					frameColumnsTextChange(nstdW / 64 * myScale.doubleValue(),
							myScale.doubleValue());
				}
			}
			if (!((Frame) frame).isStdH) {
				if (myParent.currentUOM == 1) {

					myParent.myTextLeft[((Frame) frame).startRow - 1]
							.setText(nstdH + "");
					selectedOpeningNo = ((Frame) frame).startRow;
					selectedFrameNo = ((Frame) frame).startRow;
					frameRowsTextChange(nstdH * myScale.doubleValue(),
							myScale.doubleValue());
				} else {

					myParent.myTextLeft[((Frame) frame).startRow - 1]
							.setText(nstdH / 64 + "");
					selectedOpeningNo = ((Frame) frame).startRow;
					selectedFrameNo = ((Frame) frame).startRow;
					frameRowsTextChange(nstdH / 64 * myScale.doubleValue(),
							myScale.doubleValue());
				}

			}

		}

		this.redrawTextForColRow(false);

		return myFacet;
	}

	public void changeFacetW(final int x, final int y, final double newFW) {

		try {

			BigDecimal myScale = new BigDecimal(0);
			if (myParent.myTopPanel.metric.isSelected()) {
				myScale = myParent.scale.multiply(new BigDecimal(100));
			} else {
				myScale = myParent.scale;
			}

			double newW = 0;
			// this.getSelectedColFacetBot(x, y);
			final AddMullionV addMullion = new AddMullionV(
					myParent.jobItem.design.bOpeningObject, myParent.jobItem,
					myParent, 0);
			final Object[] mVs = myParent.jobItem.design.bOpeningObject.mullions
					.toArray();
			final Collection doneRows = new Vector();
			doneRows.add(0);
			int myCol = 1;
			double maxThickForRow = 0;
			double myThickness = 0;
			double totalThick = 0;
			for (final Object element : mVs) {
				addMullion.getProfileDims((Profiles) element);

				myThickness = addMullion.thickness;

				myCol = ((Profiles) element).rowCol;
				if (!doneRows.contains(myCol)) {
					for (final Object element2 : mVs) {
						if (((Profiles) element2).rowCol == myCol) {
							myCol = ((Profiles) element2).rowCol;
							doneRows.add(myCol);
							if (myThickness > maxThickForRow) {
								maxThickForRow = addMullion.thickness;
							}
						}
					}
					totalThick = totalThick + maxThickForRow;
				}
			}

			final Object[] fs = myParent.fcolTextObjects.toArray();

			myParent.fcolTextObjects.clear();

			for (int j = 0; j < fs.length; j++) {
				if (myParent.facetUsed.startCol - 1 == j) {
					myParent.fcolTextObjects.add(newFW + "");
					newW = newW + newFW;

				} else {
					myParent.fcolTextObjects.add(fs[j].toString());
					newW = newW + Double.parseDouble(fs[j].toString());
				}

			}

			newW = newW + totalThick / myScale.doubleValue();

			myScale = myParent.jobItem.calcScale(newW,
					myParent.jobItem.design.heightPix / myScale.doubleValue());

			myParent.changeFacetW = true;
			myParent.wEntered = true;

			final Object[] openings = myParent.jobItem.design.openings
					.toArray();
			myParent.jobItem.design.openings.clear();

			for (final Object f : openings) {
				if (((OpeningObject) f).startCol == myParent.facetUsed.startCol) {
					((OpeningObject) f).autoW = false;
				}
				myParent.jobItem.design.openings.add(f);

			}

			Object[] facets = myParent.jobItem.design.frames.toArray();
			myParent.jobItem.design.frames.clear();

			for (final Object f : facets) {
				if (((Facet) f).startCol == myParent.facetUsed.startCol) {
					((Facet) f).inUse = true;
					((Facet) f).autoW = false;

					((Facet) f).widthPix = newFW * myScale.doubleValue();

					if (myParent.currentUOM == 1) {
						((Facet) f).heightPix = ((Facet) f).heightM / 100
								* myScale.doubleValue();

					} else if (myParent.currentUOM >= 2) {
						((Facet) f).heightPix = ((Facet) f).heightI
								* myScale.doubleValue();
					}
					if (myParent.currentUOM == 1) {
						((Facet) f).widthM = ((Facet) f).widthMO = (int) (myParent
								.roundDim(newFW, 1, myParent.metricRound, 1) * 100);
						((Facet) f).widthI = ((Facet) f).widthIO = (int) myParent
								.roundDim(newFW / 25.4, 2, myParent.impRound, 2);
					} else if (myParent.currentUOM == 2) {
						((Facet) f).widthM = ((Facet) f).widthMO = (int) (myParent
								.roundDim(newFW * 25.4, 1,
										myParent.metricRound, 1) * 100);
						((Facet) f).widthI = ((Facet) f).widthIO = (int) myParent
								.roundDim(newFW, 2, myParent.impRound, 2);
					} else if (myParent.currentUOM == 3) {
						try {
							((Facet) f).widthM = ((Facet) f).widthMO = (int) (myParent
									.roundDim(Double.parseDouble(UOMConvert
											.fractionToMetric(newFW + "")), 1,
											myParent.metricRound, 1) * 100);
							((Facet) f).widthI = ((Facet) f).widthIO = (int) myParent
									.roundDim(Double.parseDouble(UOMConvert
											.fractionToImperial(newFW + "")),
											2, myParent.impRound, 2);
						} catch (final NumberFormatException e1) {
							// TODO
							// Auto-generated catch block
							e1.printStackTrace();
						} catch (final Exception e1) {
							// TODO
							// Auto-generated catch block
							e1.printStackTrace();
						}

					}

				} else {
					((Facet) f).inUse = false;
					((Facet) f).autoW = false;

					if (myParent.currentUOM == 1) {
						((Facet) f).widthPix = ((Facet) f).widthM / 100
								* myScale.doubleValue();
						((Facet) f).heightPix = ((Facet) f).heightM / 100
								* myScale.doubleValue();

					} else if (myParent.currentUOM >= 2) {
						((Facet) f).widthPix = ((Facet) f).widthI
								* myScale.doubleValue();
						((Facet) f).heightPix = ((Facet) f).heightI
								* myScale.doubleValue();
					}

				}
				myParent.jobItem.design.frames.add(f);

			}

			if (myParent.currentUOM == 1) {
				myParent.jobItem.setWHDimChange(newW,
						myParent.jobItem._HEIGHT_Metric / 100, true);

			} else if (myParent.currentUOM >= 2) {
				myParent.jobItem.setWHDimChange(newW,
						myParent.jobItem._HEIGHT_Imp, true);
			}

			// if(myParent.myTopPanel.metric.isSelected()) {
			// myScale = myParent.scale*100;
			// }else {
			// myScale = myParent.scale;
			// }
			//

			myParent.jobItem.design.initOverallSize(
					newW * myScale.doubleValue(), myParent.jobItem._HEIGHTpix,
					myParent.jobItem._WIDTHpix, myParent.jobItem._HEIGHTpix,
					myParent.jobItem.design, 0, false);

			// myParent.changeFacetW = false;

			facets = myParent.jobItem.design.frames.toArray();
			myParent.jobItem.design.frames.clear();

			if (myParent.myTopPanel.metric.isSelected()) {
				myScale = myParent.scale.multiply(new BigDecimal(100));
			} else {
				myScale = myParent.scale;
			}

			for (final Object f : facets) {
				if (((Facet) f).startCol == myParent.facetUsed.startCol) {
					((Facet) f).inUse = true;
					((Facet) f).autoW = false;
					((Facet) f).widthMO = 0;
					((Facet) f).widthPix = newFW * myScale.doubleValue();
					((Facet) f).heightPix = ((Facet) f).heightPix;
					((Facet) f).setOriginalDimsInit(((Facet) f).widthPix,
							((Facet) f).heightPix);

					myParent.facetUsed = (Facet) f;

				}

				// f = setStdWH((Facet) f);

				myParent.jobItem.design.frames.add(f);

			}

			myParent.changeFacetW = false;
			myParent.doFacetRadioClick();
			myParent.dimAction();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Object[] frameColumnsTextChange(final double myW,
			final double myScale) {

		double total = 0;
		double totalC = 0;
		double gTotal = 0;
		double gTotalC = 0;
		final Object[] tfTop = myParent.topTexts.toArray();
		boolean isOk = true;
		final Object[] returns = new Object[3];

		double original = 0;
		double originalC = 0;

		for (int tf = 0; tf < tfTop.length; tf++) {
			if (selectedFrameNo != 0
					&& ((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
				total = total + ((TextFieldTop) tfTop[tf]).size;

				totalC = totalC + ((TextFieldTop) tfTop[tf]).sizeC;
			} else if (selectedOpeningNo != 0 // && selectedFrameNo == 0
					&& ((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
				total = total + ((TextFieldTop) tfTop[tf]).size;

				totalC = totalC + ((TextFieldTop) tfTop[tf]).sizeC;
			}

			if (selectedFrameNo != 0
					&& ((TextFieldTop) tfTop[tf]).colNo == selectedFrameNo) {
				original = ((TextFieldTop) tfTop[tf]).size;

				originalC = ((TextFieldTop) tfTop[tf]).sizeC;
			}

			if (selectedOpeningNo != 0 && selectedFrameNo == 0
					&& ((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
				original = ((TextFieldTop) tfTop[tf]).size;

				originalC = ((TextFieldTop) tfTop[tf]).sizeC;
			}

			gTotal = gTotal + ((TextFieldTop) tfTop[tf]).size;
			gTotalC = gTotalC + ((TextFieldTop) tfTop[tf]).sizeC;

		}

		double newTotal = 0;
		double newTotalC = 0;

		if (dimensionType == 1 || dimensionType == 3) {
			newTotalC = Math.abs(gTotalC - myW) / (tfTop.length - 1);

			if (newTotalC + myW > totalC + originalC) {
				isOk = false;
			}
		} else if (dimensionType == 2 || dimensionType == 4) {
			newTotal = Math.abs(gTotal - myW) / (tfTop.length - 1);

			if (newTotal + myW > total + original) {
				isOk = false;
			}
		}

		if (!isOk) {
			// JOptionPane.showMessageDialog(
			// null,
			// "Invalid Dimension Entered!",
			// "Invalid Dimension - Error!",
			// JOptionPane.ERROR_MESSAGE);
			//
			// if (dimensionType == 1 || dimensionType == 3)
			// {
			// ((JXTextField) e.getSource()).setText(originalC * myScale
			// + "");
			// }
			// else if (dimensionType == 2 || dimensionType == 4)
			// {
			// ((JXTextField) e.getSource()).setText(original * myScale
			// + "");
			// }
			// myParent.lastSelectedDim = dimensionType;
			//
			// // myParent.dimAction();
			// myParent.dim.resetDim();

		} else {

			// double myW =
			// Double.parseDouble(this.myTextRow[this.selectedCol-1].getText())/this.myParent.scale;

			if (selectedFrameNo == 0) {

				// this.getSelectedColTop(x, y);
			}

			this.modColWidths(myW, true);
			changeDimDone = false;

		}

		returns[0] = isOk;
		returns[1] = original;
		returns[2] = originalC;
		return returns;
	}

	public Object[] frameRowsTextChange(final double myW, final double myScale) {

		double total = 0;
		double totalC = 0;
		double gTotal = 0;
		double gTotalC = 0;

		final Object[] tfTop = myParent.leftTexts.toArray();

		double original = 0;
		double originalC = 0;

		boolean isOk = true;
		final Object[] returns = new Object[3];

		for (int tf = 0; tf < tfTop.length; tf++) {
			if (selectedFrameNo != 0
					&& ((TextFieldLeft) tfTop[tf]).rowNo != selectedFrameNo) {
				total = total + ((TextFieldLeft) tfTop[tf]).size;

				totalC = totalC + ((TextFieldLeft) tfTop[tf]).sizeC;
			}
			if (selectedOpeningNo != 0 && selectedFrameNo == 0
					&& ((TextFieldLeft) tfTop[tf]).rowNo != selectedOpeningNo) {
				total = total + ((TextFieldLeft) tfTop[tf]).size;

				totalC = totalC + ((TextFieldLeft) tfTop[tf]).sizeC;
			}

			if (selectedFrameNo != 0
					&& ((TextFieldLeft) tfTop[tf]).rowNo == selectedFrameNo) {
				original = ((TextFieldLeft) tfTop[tf]).size;

				originalC = ((TextFieldLeft) tfTop[tf]).sizeC;
			}

			if (selectedOpeningNo != 0 && selectedFrameNo == 0
					&& ((TextFieldLeft) tfTop[tf]).rowNo == selectedOpeningNo) {
				original = ((TextFieldLeft) tfTop[tf]).size;

				originalC = ((TextFieldLeft) tfTop[tf]).sizeC;
			}

			gTotal = gTotal + ((TextFieldLeft) tfTop[tf]).size;
			gTotalC = gTotalC + ((TextFieldLeft) tfTop[tf]).sizeC;

		}

		double newTotal = 0;
		double newTotalC = 0;

		if (dimensionType == 1 || dimensionType == 3) {
			newTotalC = Math.abs(gTotalC - myW) / (tfTop.length - 1);

			if (newTotalC + myW > totalC + originalC) {
				isOk = false;
			}
		}
		if (dimensionType == 2 || dimensionType == 4) {
			newTotal = Math.abs(gTotal - myW) / (tfTop.length - 1);

			if (((int) ((newTotal + myW) * 100000)) / 100000 > ((int) ((total + original) * 100000)) / 100000) {
				isOk = false;
			}
		}

		if (!isOk) {

		} else {
			if (selectedRowLeft == 0) {

				// this.getSelectedRowLeft(x, y);

			}
			this.modRowHeights(myW);
			changeDimDone = false;
		}

		returns[0] = isOk;
		returns[1] = original;
		returns[2] = originalC;
		return returns;

	}

	public void modColWidths(final double myW, final boolean redrawText) {

		try {

			if (myParent.dim.isSash.isSelected()) {
				modColWidthsSash(myW, redrawText);
			} else {

				if (dimensionType <= 2) {
					myParent.modifyDims = false;

					double totalW = 0;
					double totalWC = 0;
					double sumSizeMod = 0;
					double sumSizeModC = 0;

					boolean reCalc = false;
					final Object[] tfTop = myParent.topTexts.toArray();
					myParent.topTexts.clear();

					for (int tf = 0; tf < tfTop.length; tf++) {
						((TextFieldTop) tfTop[tf]).mod = myParent.topTextsMod[tf];
						totalW = totalW + ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
						totalWC = totalWC + ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;

					}

					for (int tf = 0; tf < tfTop.length; tf++) {
						if (dimensionType == 1) {
							if (((TextFieldTop) tfTop[tf]).colNo == selectedFrameNo) {
								myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
								myParent.topTextsMod[tf] = myParent.lastSelectedCol;
								if (myParent.lastSelectedCol > tfTop.length) {
									myParent.lastSelectedCol = 1;
									myParent.topTextsMod[tf] = myParent.topTextsMod[tf] - 1;
									((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
								}

								((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
								((TextFieldTop) tfTop[tf]).newSizeC = myW;
								((TextFieldTop) tfTop[tf]).newSize = myW
										- ((TextFieldTop) tfTop[tf]).deltaL
										- ((TextFieldTop) tfTop[tf]).deltaR;
								break;
							}
						} else if (dimensionType == 2) {
							if (((TextFieldTop) tfTop[tf]).colNo == selectedFrameNo) {
								myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
								myParent.topTextsMod[tf] = myParent.lastSelectedCol;
								if (myParent.lastSelectedCol > tfTop.length) {
									myParent.lastSelectedCol = 1;
									myParent.topTextsMod[tf] = myParent.topTextsMod[tf] - 1;
									((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
								}
								((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
								((TextFieldTop) tfTop[tf]).newSize = myW;
								((TextFieldTop) tfTop[tf]).newSizeC = myW
										+ ((TextFieldTop) tfTop[tf]).deltaL
										+ ((TextFieldTop) tfTop[tf]).deltaR;
								break;
							}
						}
					}
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).mod > 0
								&& ((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
							((TextFieldTop) tfTop[tf]).newSize = ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
							((TextFieldTop) tfTop[tf]).newSizeC = ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;
						}
					}
					totalMod = 0;
					sumSizeMod = 0;
					sumSizeModC = 0;
					for (final Object element : tfTop) {
						if (((TextFieldTop) element).mod > 0) {
							totalMod = totalMod + 1;
							sumSizeMod = sumSizeMod
									+ ((TextFieldTop) element).newSize;
							sumSizeModC = sumSizeModC
									+ ((TextFieldTop) element).newSizeC;
						}
					}
					if ((sumSizeMod >= totalW
							- 3
							* (myParent.facetUsed.left.partDimA
									+ myParent.facetUsed.left.partDimB + myParent.facetUsed.left.partDimC) || sumSizeModC >= totalWC
							- 3
							* (myParent.facetUsed.left.partDimA
									+ myParent.facetUsed.left.partDimB + myParent.facetUsed.left.partDimC))
							&& totalMod != tfTop.length) {
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
								((TextFieldTop) tfTop[tf]).mod = 0;
							}
						}
						reCalc = true;
					} else {
						double sumOther = 0;
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (totalMod != tfTop.length) {
								if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo
										&& ((TextFieldTop) tfTop[tf]).mod == 0) {
									((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
											/ (tfTop.length - totalMod);
									((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
											/ (tfTop.length - totalMod);
									sumOther = sumOther
											+ ((TextFieldTop) tfTop[tf]).newSize;
								}

							} else {
								reCalc = true;// true;
								if (myParent.modSeqUndo == tfTop.length) {
									myParent.modSeqUndo = 0;
								}
								myParent.modSeqUndo = myParent.modSeqUndo + 1;
								break;
							}
						}
					}

					if (((totalW - sumSizeMod) / (tfTop.length - totalMod) < 3 * (myParent.facetUsed.left.partDimA + myParent.facetUsed.left.partDimB) || (totalWC - sumSizeModC)
							/ (tfTop.length - totalMod) < 3 * (myParent.facetUsed.left.partDimA + myParent.facetUsed.left.partDimB))
							&& !reCalc) {
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
								((TextFieldTop) tfTop[tf]).mod = 0;
							}
						}
						reCalc = true;
					}

					if (reCalc) {
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (((TextFieldTop) tfTop[tf]).mod == myParent.modSeqUndo) {
								((TextFieldTop) tfTop[tf]).mod = 0;
								myParent.topTextsMod[tf] = 0;
							}
						}
						totalMod = 0;
						sumSizeMod = 0;
						sumSizeModC = 0;
						for (final Object element : tfTop) {
							if (((TextFieldTop) element).mod > 0) {
								totalMod = totalMod + 1;
								sumSizeMod = sumSizeMod
										+ ((TextFieldTop) element).newSize;
								sumSizeModC = sumSizeModC
										+ ((TextFieldTop) element).newSizeC;
							}
						}
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (totalMod != tfTop.length) {
								if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo
										&& ((TextFieldTop) tfTop[tf]).mod == 0) {
									((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
											/ (tfTop.length - totalMod);
									((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
											/ (tfTop.length - totalMod);
								}
							}
						}
					}

					for (int tf = 0; tf < tfTop.length; tf++) {

						if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {

							((TextFieldTop) tfTop[tf]).newPos = myParent.jobItem.startingX;
							((TextFieldTop) tfTop[tf]).newPosc = myParent.jobItem.startingX;
							((TextFieldTop) tfTop[tf]).newPose = myParent.jobItem.startingX
									+ ((TextFieldTop) tfTop[tf]).newSize;
							((TextFieldTop) tfTop[tf]).newPosec = myParent.jobItem.startingX
									+ ((TextFieldTop) tfTop[tf]).newSizeC;

						} else if (((TextFieldTop) tfTop[tf]).endRowCol == myParent.facetUsed.bOpeningObject.xCols) {

							((TextFieldTop) tfTop[tf]).newPos = this
									.getposcforLastColumn(
											((TextFieldTop) tfTop[tf]).startRowCol,
											tfTop)
									+ ((TextFieldTop) tfTop[tf]).deltaL
									+ ((TextFieldTop) tfTop[tf - 1]).deltaR;

							((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
									- ((TextFieldTop) tfTop[tf]).deltaL;
							((TextFieldTop) tfTop[tf]).newPose = endX;
							((TextFieldTop) tfTop[tf]).newPosec = endX;

						} else {
							((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
									+ ((TextFieldTop) tfTop[tf]).deltaL
									+ ((TextFieldTop) tfTop[tf - 1]).deltaR;

							((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
									- ((TextFieldTop) tfTop[tf]).deltaL;
							((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
									+ ((TextFieldTop) tfTop[tf]).newSize;
							((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
									+ ((TextFieldTop) tfTop[tf]).newSizeC;
						}

						myParent.topTexts.add(tfTop[tf]);
					}

					myParent.facetUsed.modifyInternalDims(selectedRadioForRow,
							1);

				} else if (dimensionType >= 3 || dimensionType <= 9) {

					myParent.modifyDims = false;

					double totalW = 0;
					double totalWC = 0;
					double sumSizeMod = 0;
					double sumSizeModC = 0;

					boolean reCalc = false;
					final Object[] tfTop = myParent.topTexts.toArray();
					myParent.topTexts.clear(); /*
												 * Gets the total clear width of
												 * all openings make Sure that
												 * toTextMod is done.
												 */
					if (myParent.topTextsModo.length == 0
							&& !myParent.dim.isSash.isSelected()) {
						myParent.facetUsed.doTopTextModOpening(
								selectedRadioForRow, selectedRadioForCol,
								selectedRadioForRowo, selectedRadioForColo);
						myParent.facetUsed.doLeftTextModOpening(
								selectedRadioForRow, selectedRadioForCol,
								selectedRadioForRowo, selectedRadioForColo);
					}
					for (int tf = 0; tf < tfTop.length; tf++) {

					}

					for (int tf = 0; tf < tfTop.length; tf++) {
						((TextFieldTop) tfTop[tf]).mod = myParent.topTextsModo[tf];

						totalW = totalW + ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
						totalWC = totalWC + ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;
					}

					for (int tf = 0; tf < tfTop.length; tf++) {
						if (!((TextFieldTop) tfTop[tf]).isSash) {
							if (dimensionType == 3 || dimensionType == 5) {

								if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
									myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
									myParent.topTextsModo[tf] = myParent.lastSelectedCol;
									if (myParent.lastSelectedCol > tfTop.length) {
										myParent.lastSelectedCol = 1;
										myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
										((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
									}

									((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
									((TextFieldTop) tfTop[tf]).newSizeC = myW;
									((TextFieldTop) tfTop[tf]).newSize = myW
											- ((TextFieldTop) tfTop[tf]).deltaL
											- ((TextFieldTop) tfTop[tf]).deltaR;
									break;
								}
							} else if (dimensionType == 4 || dimensionType >= 6) {
								if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
									myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
									myParent.topTextsModo[tf] = myParent.lastSelectedCol;
									if (myParent.lastSelectedCol > tfTop.length) {
										myParent.lastSelectedCol = 1;
										myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
										((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
									}
									((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
									((TextFieldTop) tfTop[tf]).newSize = myW;
									((TextFieldTop) tfTop[tf]).newSizeC = myW
											+ ((TextFieldTop) tfTop[tf]).deltaL
											+ ((TextFieldTop) tfTop[tf]).deltaR;
									break;
								}
							}
						} else {// if Sash
							if (dimensionType == 3 || dimensionType == 5) {

								if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
									myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
									myParent.topTextsModo[tf] = myParent.lastSelectedCol;
									if (myParent.lastSelectedCol > tfTop.length) {
										myParent.lastSelectedCol = 1;
										myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
										((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
									}

									((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
									((TextFieldTop) tfTop[tf]).newSizeC = myW;
									((TextFieldTop) tfTop[tf]).newSize = myW
											- ((TextFieldTop) tfTop[tf]).deltaL
											- ((TextFieldTop) tfTop[tf]).deltaR;
									break;
								}
							} else if (dimensionType == 4 || dimensionType >= 6) {
								if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
									myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
									myParent.topTextsModo[tf] = myParent.lastSelectedCol;
									if (myParent.lastSelectedCol > tfTop.length) {
										myParent.lastSelectedCol = 1;
										myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
										((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
									}
									((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
									((TextFieldTop) tfTop[tf]).newSize = myW;
									((TextFieldTop) tfTop[tf]).newSizeC = myW
											+ ((TextFieldTop) tfTop[tf]).deltaL
											+ ((TextFieldTop) tfTop[tf]).deltaR;
									break;
								}
							}
						}
					}

					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).mod > 0
								&& ((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
							((TextFieldTop) tfTop[tf]).newSize = ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
							((TextFieldTop) tfTop[tf]).newSizeC = ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;
						}
					}

					totalMod = 0;
					sumSizeMod = 0;
					sumSizeModC = 0;
					for (final Object element : tfTop) {
						if (((TextFieldTop) element).mod > 0) {
							totalMod = totalMod + 1;
							sumSizeMod = sumSizeMod
									+ ((TextFieldTop) element).newSize;
							sumSizeModC = sumSizeModC
									+ ((TextFieldTop) element).newSizeC;
						}
					}
					if (sumSizeMod >= totalW
							- 3
							* (mySelectedFrame.left.partDimA + mySelectedFrame.left.partDimB)
							|| sumSizeModC >= totalWC
									- 3
									* (mySelectedFrame.left.partDimA + mySelectedFrame.left.partDimB)
							&& totalMod != tfTop.length) {
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
								((TextFieldTop) tfTop[tf]).mod = 0;
								// Lowest
								// Value to
								// be
								// changed not
								// all?????
							}
						}
						reCalc = true;
					} else {
						double sumOther = 0;
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (totalMod != tfTop.length) {
								if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo
										&& ((TextFieldTop) tfTop[tf]).mod == 0) {
									((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
											/ (tfTop.length - totalMod);
									((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
											/ (tfTop.length - totalMod);
									sumOther = sumOther
											+ ((TextFieldTop) tfTop[tf]).newSize;
								}

							} else {
								reCalc = true;// true;
								if (myParent.modSeqUndo == tfTop.length) {
									myParent.modSeqUndo = 0;
								}
								myParent.modSeqUndo = myParent.modSeqUndo + 1;
								break;
							}
						}
					}

					if (((totalW - sumSizeMod) / (tfTop.length - totalMod) < 3 * (mySelectedFrame.left.partDimA + mySelectedFrame.left.partDimB) || (totalWC - sumSizeModC)
							/ (tfTop.length - totalMod) < 3 * (mySelectedFrame.left.partDimA + mySelectedFrame.left.partDimB))
							&& !reCalc) {
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
								((TextFieldTop) tfTop[tf]).mod = 0;
							}
						}
						reCalc = true;
					}

					if (reCalc) {
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (((TextFieldTop) tfTop[tf]).mod == myParent.modSeqUndo) {
								((TextFieldTop) tfTop[tf]).mod = 0;
								myParent.topTextsModo[tf] = 0;
							}
						}
						totalMod = 0;
						sumSizeMod = 0;
						sumSizeModC = 0;
						for (final Object element : tfTop) {
							if (((TextFieldTop) element).mod > 0) {
								totalMod = totalMod + 1;
								sumSizeMod = sumSizeMod
										+ ((TextFieldTop) element).newSize;
								sumSizeModC = sumSizeModC
										+ ((TextFieldTop) element).newSizeC;
							}
						}
						for (int tf = 0; tf < tfTop.length; tf++) {
							if (totalMod != tfTop.length) {
								if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo
										&& ((TextFieldTop) tfTop[tf]).mod == 0) {
									((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
											/ (tfTop.length - totalMod);
									((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
											/ (tfTop.length - totalMod);
								}
							}
						}
					}
					for (int tf = 0; tf < tfTop.length; tf++) {

						if (dimensionType != 7 && dimensionType != 8) {

							if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {
								((TextFieldTop) tfTop[tf]).newPos = mySelectedFrame.bOpeningObject.startingX;
								((TextFieldTop) tfTop[tf]).newPosc = mySelectedFrame.bOpeningObject.startingX;
								((TextFieldTop) tfTop[tf]).newPose = mySelectedFrame.bOpeningObject.startingX
										+ ((TextFieldTop) tfTop[tf]).newSize;
								((TextFieldTop) tfTop[tf]).newPosec = mySelectedFrame.bOpeningObject.startingX
										+ ((TextFieldTop) tfTop[tf]).newSizeC;

							} else { // if (((TextFieldTop)
										// tfTop[tf]).startRowCol > 1
										// && ((TextFieldTop)
										// tfTop[tf]).endRowCol <
										// mySelectedFrame.xCols) {
								((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
										+ ((TextFieldTop) tfTop[tf]).deltaL
										+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
								((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
										- ((TextFieldTop) tfTop[tf]).deltaL;
								((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
										+ ((TextFieldTop) tfTop[tf]).newSize;
								((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
										+ ((TextFieldTop) tfTop[tf]).newSizeC;

							}

							// else if (((TextFieldTop) tfTop[tf]).endRowCol ==
							// mySelectedFrame.xCols) {
							//
							// ((TextFieldTop) tfTop[tf]).newPos = this
							// .getposcforLastColumn(
							// ((TextFieldTop) tfTop[tf]).startRowCol,
							// tfTop)
							// + ((TextFieldTop) tfTop[tf]).deltaL
							// + ((TextFieldTop) tfTop[tf - 1]).deltaR;
							// ((TextFieldTop) tfTop[tf]).newPosc =
							// ((TextFieldTop) tfTop[tf]).newPos
							// - ((TextFieldTop) tfTop[tf]).deltaL;
							// ((TextFieldTop) tfTop[tf]).newPose = endX;
							// ((TextFieldTop) tfTop[tf]).newPosec = endX;
							//
							// }

						} else {

							if (((TextFieldTop) tfTop[tf]).colNo == 1) {
								((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf]).parent.startingX;

								((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).parent.startingCX;

								((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
										+ ((TextFieldTop) tfTop[tf]).newSize;

								((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
										+ ((TextFieldTop) tfTop[tf]).newSizeC;
							} else {
								((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
										+ ((TextFieldTop) tfTop[tf - 1]).deltaR
										+ ((TextFieldTop) tfTop[tf]).deltaL;

								((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf - 1]).newPosec;

								((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
										+ ((TextFieldTop) tfTop[tf]).newSize;

								((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
										+ ((TextFieldTop) tfTop[tf]).newSizeC;

							}
						}

						myParent.topTexts.add(tfTop[tf]);
						// System.out.print(((TextFieldTop)
						// tfTop[tf]));
					}
					if (dimensionType == 9) {

						myParent.jobItem.design.findDLO.changeInternalDims(
								selectedRadioForRow, selectedRadioForCol,
								selectedRadioForRowo, selectedRadioForColo,
								selectedOpeningNo, myParent.topTexts, 2, 1,
								this.mySelectedFrame);
					} else if (!myParent.dim.isSash.isSelected()) {

						mySelectedFrame.modifyInternalDims(
								selectedRadioForRowo, 1, dimensionType);
					} else if (myParent.dim.isSash.isSelected()) {

						this.myParent.mySelectedSashLeaf.modifyInternalDims(
								selectedRadioForRowo, 1, dimensionType);
					}
				}
				if (redrawText) {
					this.redrawTextForColRow(false);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modColWSTD(final double myW, final double t, final double tc) {

		try {

			myParent.modifyDims = false;

			final double totalW = t;
			final double totalWC = tc;
			final double sumSizeMod = 0;
			final double sumSizeModC = 0;

			final boolean reCalc = false;
			final Object[] tfTop = myParent.topTexts.toArray();
			myParent.topTexts.clear();

			for (int tf = 0; tf < tfTop.length; tf++) {
				if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {
					((TextFieldTop) tfTop[tf]).newPos = myParent.jobItem.startingX;
					((TextFieldTop) tfTop[tf]).newPosc = myParent.jobItem.startingX;
					((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
							+ ((TextFieldTop) tfTop[tf]).newSize;
					((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
							+ ((TextFieldTop) tfTop[tf]).newSizeC;

				} else {
					((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
							+ ((TextFieldTop) tfTop[tf]).deltaL
							+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
					((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
							- ((TextFieldTop) tfTop[tf]).deltaL;
					((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
							+ ((TextFieldTop) tfTop[tf]).newSize;
					((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
							+ ((TextFieldTop) tfTop[tf]).newSizeC;

				}
				myParent.topTexts.add(tfTop[tf]);

			}

			myParent.facetUsed.modifyInternalDims(selectedRadioForRow, 1);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void modColWidthsSash(final double myW, final boolean redrawText) {

		try {

			if (dimensionType <= 2) {
				myParent.modifyDims = false;

				double totalW = 0;
				double totalWC = 0;
				double sumSizeMod = 0;
				double sumSizeModC = 0;

				boolean reCalc = false;
				final Object[] tfTop = myParent.topTexts.toArray();
				myParent.topTexts.clear();

				for (int tf = 0; tf < tfTop.length; tf++) {
					((TextFieldTop) tfTop[tf]).mod = myParent.topTextsMod[tf];
					totalW = totalW + ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
					totalWC = totalWC + ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;

				}

				for (int tf = 0; tf < tfTop.length; tf++) {
					if (dimensionType == 1) {
						if (((TextFieldTop) tfTop[tf]).colNo == selectedFrameNo) {
							myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
							myParent.topTextsMod[tf] = myParent.lastSelectedCol;
							if (myParent.lastSelectedCol > tfTop.length) {
								myParent.lastSelectedCol = 1;
								myParent.topTextsMod[tf] = myParent.topTextsMod[tf] - 1;
								((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
							}

							((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
							((TextFieldTop) tfTop[tf]).newSizeC = myW;
							((TextFieldTop) tfTop[tf]).newSize = myW
									- ((TextFieldTop) tfTop[tf]).deltaL
									- ((TextFieldTop) tfTop[tf]).deltaR;
							break;
						}
					} else if (dimensionType == 2) {
						if (((TextFieldTop) tfTop[tf]).colNo == selectedFrameNo) {
							myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
							myParent.topTextsMod[tf] = myParent.lastSelectedCol;
							if (myParent.lastSelectedCol > tfTop.length) {
								myParent.lastSelectedCol = 1;
								myParent.topTextsMod[tf] = myParent.topTextsMod[tf] - 1;
								((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
							}
							((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
							((TextFieldTop) tfTop[tf]).newSize = myW;
							((TextFieldTop) tfTop[tf]).newSizeC = myW
									+ ((TextFieldTop) tfTop[tf]).deltaL
									+ ((TextFieldTop) tfTop[tf]).deltaR;
							break;
						}
					}
				}
				for (int tf = 0; tf < tfTop.length; tf++) {
					if (((TextFieldTop) tfTop[tf]).mod > 0
							&& ((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
						((TextFieldTop) tfTop[tf]).newSize = ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
						((TextFieldTop) tfTop[tf]).newSizeC = ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;
					}
				}
				totalMod = 0;
				sumSizeMod = 0;
				sumSizeModC = 0;
				for (final Object element : tfTop) {
					if (((TextFieldTop) element).mod > 0) {
						totalMod = totalMod + 1;
						sumSizeMod = sumSizeMod
								+ ((TextFieldTop) element).newSize;
						sumSizeModC = sumSizeModC
								+ ((TextFieldTop) element).newSizeC;
					}
				}
				if ((sumSizeMod >= totalW
						- 3
						* (myParent.mySelectedSash.left.partDimA + myParent.mySelectedSash.left.partDimB) || sumSizeModC >= totalWC
						- 3
						* (myParent.mySelectedSash.left.partDimA + myParent.mySelectedSash.left.partDimB))
						&& totalMod != tfTop.length) {
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
							((TextFieldTop) tfTop[tf]).mod = 0;
						}
					}
					reCalc = true;
				} else {
					double sumOther = 0;
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (totalMod != tfTop.length) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo
									&& ((TextFieldTop) tfTop[tf]).mod == 0) {
								((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
										/ (tfTop.length - totalMod);
								((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
										/ (tfTop.length - totalMod);
								sumOther = sumOther
										+ ((TextFieldTop) tfTop[tf]).newSize;
							}

						} else {
							reCalc = true;// true;
							if (myParent.modSeqUndo == tfTop.length) {
								myParent.modSeqUndo = 0;
							}
							myParent.modSeqUndo = myParent.modSeqUndo + 1;
							break;
						}
					}
				}

				if (((totalW - sumSizeMod) / (tfTop.length - totalMod) < 3 * (myParent.mySelectedSash.left.partDimA + myParent.mySelectedSash.left.partDimB) || (totalWC - sumSizeModC)
						/ (tfTop.length - totalMod) < 3 * (myParent.mySelectedSash.left.partDimA + myParent.mySelectedSash.left.partDimB))
						&& !reCalc) {
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo) {
							((TextFieldTop) tfTop[tf]).mod = 0;
						}
					}
					reCalc = true;
				}

				if (reCalc) {
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).mod == myParent.modSeqUndo) {
							((TextFieldTop) tfTop[tf]).mod = 0;
							myParent.topTextsMod[tf] = 0;
						}
					}
					totalMod = 0;
					sumSizeMod = 0;
					sumSizeModC = 0;
					for (final Object element : tfTop) {
						if (((TextFieldTop) element).mod > 0) {
							totalMod = totalMod + 1;
							sumSizeMod = sumSizeMod
									+ ((TextFieldTop) element).newSize;
							sumSizeModC = sumSizeModC
									+ ((TextFieldTop) element).newSizeC;
						}
					}
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (totalMod != tfTop.length) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedFrameNo
									&& ((TextFieldTop) tfTop[tf]).mod == 0) {
								((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
										/ (tfTop.length - totalMod);
								((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
										/ (tfTop.length - totalMod);
							}
						}
					}
				}
				for (int tf = 0; tf < tfTop.length; tf++) {
					if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {
						((TextFieldTop) tfTop[tf]).newPos = myParent.jobItem.startingX;
						((TextFieldTop) tfTop[tf]).newPosc = myParent.jobItem.startingX;
						((TextFieldTop) tfTop[tf]).newPose = myParent.jobItem.startingX
								+ ((TextFieldTop) tfTop[tf]).newSize;
						((TextFieldTop) tfTop[tf]).newPosec = myParent.jobItem.startingX
								+ ((TextFieldTop) tfTop[tf]).newSizeC;

					} else if (((TextFieldTop) tfTop[tf]).endRowCol == myParent.mySelectedSash.bOpeningObject.xCols) {

						((TextFieldTop) tfTop[tf]).newPos = this
								.getposcforLastColumn(
										((TextFieldTop) tfTop[tf]).startRowCol,
										tfTop)
								+ ((TextFieldTop) tfTop[tf]).deltaL
								+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
						((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
								- ((TextFieldTop) tfTop[tf]).deltaL;
						((TextFieldTop) tfTop[tf]).newPose = endX;
						((TextFieldTop) tfTop[tf]).newPosec = endX;
						;
					} else {
						((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
								+ ((TextFieldTop) tfTop[tf]).deltaL
								+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
						((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
								- ((TextFieldTop) tfTop[tf]).deltaL;
						((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
								+ ((TextFieldTop) tfTop[tf]).newSize;
						((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
								+ ((TextFieldTop) tfTop[tf]).newSizeC;

					}
					myParent.topTexts.add(tfTop[tf]);
					// System.out.print(((TextFieldTop)
					// tfTop[tf]));
				}

				myParent.mySelectedSash.modifyInternalDims(selectedRadioForRow,
						1);
			}

			// /////////////////

			else if (dimensionType >= 3 || dimensionType <= 9) {

				myParent.modifyDims = false;

				double totalW = 0;
				double totalWC = 0;
				double sumSizeMod = 0;
				double sumSizeModC = 0;

				boolean reCalc = false;
				final Object[] tfTop = myParent.topTexts.toArray();
				myParent.topTexts.clear(); /*
											 * Gets the total clear width of all
											 * openings make Sure that toTextMod
											 * is done.
											 */
				if (myParent.topTextsModo.length == 0
						&& !myParent.dim.isSash.isSelected()) {
					myParent.facetUsed.doTopTextModOpening(selectedRadioForRow,
							selectedRadioForCol, selectedRadioForRowo,
							selectedRadioForColo);
					myParent.facetUsed.doLeftTextModOpening(
							selectedRadioForRow, selectedRadioForCol,
							selectedRadioForRowo, selectedRadioForColo);
				}
				for (int tf = 0; tf < tfTop.length; tf++) {

				}

				for (int tf = 0; tf < tfTop.length; tf++) {
					((TextFieldTop) tfTop[tf]).mod = myParent.topTextsModo[tf];

					totalW = totalW + ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
					totalWC = totalWC + ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;
				}

				for (int tf = 0; tf < tfTop.length; tf++) {
					if (!((TextFieldTop) tfTop[tf]).isSash) {
						if (dimensionType == 3 || dimensionType == 5) {

							if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
								myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
								myParent.topTextsModo[tf] = myParent.lastSelectedCol;
								if (myParent.lastSelectedCol > tfTop.length) {
									myParent.lastSelectedCol = 1;
									myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
									((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
								}

								((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
								((TextFieldTop) tfTop[tf]).newSizeC = myW;
								((TextFieldTop) tfTop[tf]).newSize = myW
										- ((TextFieldTop) tfTop[tf]).deltaL
										- ((TextFieldTop) tfTop[tf]).deltaR;
								break;
							}
						} else if (dimensionType == 4 || dimensionType >= 6) {
							if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
								myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
								myParent.topTextsModo[tf] = myParent.lastSelectedCol;
								if (myParent.lastSelectedCol > tfTop.length) {
									myParent.lastSelectedCol = 1;
									myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
									((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
								}
								((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
								((TextFieldTop) tfTop[tf]).newSize = myW;
								((TextFieldTop) tfTop[tf]).newSizeC = myW
										+ ((TextFieldTop) tfTop[tf]).deltaL
										+ ((TextFieldTop) tfTop[tf]).deltaR;
								break;
							}
						}
					} else {// if Sash
						if (dimensionType == 3 || dimensionType == 5) {

							if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
								myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
								myParent.topTextsModo[tf] = myParent.lastSelectedCol;
								if (myParent.lastSelectedCol > tfTop.length) {
									myParent.lastSelectedCol = 1;
									myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
									((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
								}

								((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
								((TextFieldTop) tfTop[tf]).newSizeC = myW;
								((TextFieldTop) tfTop[tf]).newSize = myW
										- ((TextFieldTop) tfTop[tf]).deltaL
										- ((TextFieldTop) tfTop[tf]).deltaR;
								break;
							}
						} else if (dimensionType == 4 || dimensionType >= 6) {
							if (((TextFieldTop) tfTop[tf]).colNo == selectedOpeningNo) {
								myParent.lastSelectedCol = myParent.lastSelectedCol + 1;
								myParent.topTextsModo[tf] = myParent.lastSelectedCol;
								if (myParent.lastSelectedCol > tfTop.length) {
									myParent.lastSelectedCol = 1;
									myParent.topTextsModo[tf] = myParent.topTextsModo[tf] - 1;
									((TextFieldTop) tfTop[tf]).mod = ((TextFieldTop) tfTop[tf]).mod - 1;
								}
								((TextFieldTop) tfTop[tf]).mod = myParent.lastSelectedCol;// this.myParent.topTextsMod[tf];
								((TextFieldTop) tfTop[tf]).newSize = myW;
								((TextFieldTop) tfTop[tf]).newSizeC = myW
										+ ((TextFieldTop) tfTop[tf]).deltaL
										+ ((TextFieldTop) tfTop[tf]).deltaR;
								break;
							}
						}
					}
				}

				for (int tf = 0; tf < tfTop.length; tf++) {
					if (((TextFieldTop) tfTop[tf]).mod > 0
							&& ((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
						((TextFieldTop) tfTop[tf]).newSize = ((TextFieldTop) tfTop[tf]).size;// /this.myParent.scale;
						((TextFieldTop) tfTop[tf]).newSizeC = ((TextFieldTop) tfTop[tf]).sizeC;// /this.myParent.scale;
					}
				}

				totalMod = 0;
				sumSizeMod = 0;
				sumSizeModC = 0;
				for (final Object element : tfTop) {
					if (((TextFieldTop) element).mod > 0) {
						totalMod = totalMod + 1;
						sumSizeMod = sumSizeMod
								+ ((TextFieldTop) element).newSize;
						sumSizeModC = sumSizeModC
								+ ((TextFieldTop) element).newSizeC;
					}
				}
				if (sumSizeMod >= totalW
						- 3
						* (myParent.mySelectedSashLeaf.left.partDimA + myParent.mySelectedSashLeaf.left.partDimB)
						|| sumSizeModC >= totalWC
								- 3
								* (myParent.mySelectedSashLeaf.left.partDimA + myParent.mySelectedSashLeaf.left.partDimB)
						&& totalMod != tfTop.length) {
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
							((TextFieldTop) tfTop[tf]).mod = 0;
							// Lowest
							// Value to
							// be
							// changed
							// not
							// all?????
						}
					}
					reCalc = true;
				} else {
					double sumOther = 0;
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (totalMod != tfTop.length) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo
									&& ((TextFieldTop) tfTop[tf]).mod == 0) {
								((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
										/ (tfTop.length - totalMod);
								((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
										/ (tfTop.length - totalMod);
								sumOther = sumOther
										+ ((TextFieldTop) tfTop[tf]).newSize;
							}

						} else {
							reCalc = true;// true;
							if (myParent.modSeqUndo == tfTop.length) {
								myParent.modSeqUndo = 0;
							}
							myParent.modSeqUndo = myParent.modSeqUndo + 1;
							break;
						}
					}
				}

				if (((totalW - sumSizeMod) / (tfTop.length - totalMod) < 3 * (myParent.mySelectedSashLeaf.left.partDimA + myParent.mySelectedSashLeaf.left.partDimB) || (totalWC - sumSizeModC)
						/ (tfTop.length - totalMod) < 3 * (myParent.mySelectedSashLeaf.left.partDimA + myParent.mySelectedSashLeaf.left.partDimB))
						&& !reCalc) {
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo) {
							((TextFieldTop) tfTop[tf]).mod = 0;
						}
					}
					reCalc = true;
				}

				if (reCalc) {
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (((TextFieldTop) tfTop[tf]).mod == myParent.modSeqUndo) {
							((TextFieldTop) tfTop[tf]).mod = 0;
							myParent.topTextsModo[tf] = 0;
						}
					}
					totalMod = 0;
					sumSizeMod = 0;
					sumSizeModC = 0;
					for (final Object element : tfTop) {
						if (((TextFieldTop) element).mod > 0) {
							totalMod = totalMod + 1;
							sumSizeMod = sumSizeMod
									+ ((TextFieldTop) element).newSize;
							sumSizeModC = sumSizeModC
									+ ((TextFieldTop) element).newSizeC;
						}
					}
					for (int tf = 0; tf < tfTop.length; tf++) {
						if (totalMod != tfTop.length) {
							if (((TextFieldTop) tfTop[tf]).colNo != selectedOpeningNo
									&& ((TextFieldTop) tfTop[tf]).mod == 0) {
								((TextFieldTop) tfTop[tf]).newSize = (totalW - sumSizeMod)
										/ (tfTop.length - totalMod);
								((TextFieldTop) tfTop[tf]).newSizeC = (totalWC - sumSizeModC)
										/ (tfTop.length - totalMod);
							}
						}
					}
				}
				for (int tf = 0; tf < tfTop.length; tf++) {

					if (dimensionType != 7 && dimensionType != 8) {
						if (((TextFieldTop) tfTop[tf]).startRowCol == 1) {
							((TextFieldTop) tfTop[tf]).newPos = myParent.mySelectedSashLeaf.bOpeningObject.startingX;
							((TextFieldTop) tfTop[tf]).newPosc = myParent.mySelectedSashLeaf.bOpeningObject.startingX;
							((TextFieldTop) tfTop[tf]).newPose = myParent.mySelectedSashLeaf.bOpeningObject.startingX
									+ ((TextFieldTop) tfTop[tf]).newSize;
							((TextFieldTop) tfTop[tf]).newPosec = myParent.mySelectedSashLeaf.bOpeningObject.startingX
									+ ((TextFieldTop) tfTop[tf]).newSizeC;

						} else if (((TextFieldTop) tfTop[tf]).endRowCol == myParent.mySelectedSashLeaf.xCols) {

							((TextFieldTop) tfTop[tf]).newPos = this
									.getposcforLastColumn(
											((TextFieldTop) tfTop[tf]).startRowCol,
											tfTop)
									+ ((TextFieldTop) tfTop[tf]).deltaL
									+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
							((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
									- ((TextFieldTop) tfTop[tf]).deltaL;
							((TextFieldTop) tfTop[tf]).newPose = endX;
							((TextFieldTop) tfTop[tf]).newPosec = endX;
							;
						} else {
							((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
									+ ((TextFieldTop) tfTop[tf]).deltaL
									+ ((TextFieldTop) tfTop[tf - 1]).deltaR;
							((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).newPos
									- ((TextFieldTop) tfTop[tf]).deltaL;
							((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
									+ ((TextFieldTop) tfTop[tf]).newSize;
							((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
									+ ((TextFieldTop) tfTop[tf]).newSizeC;

						}
					} else {
						if (((TextFieldTop) tfTop[tf]).colNo == 1) {
							((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf]).parent.startingX;

							((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf]).parent.startingCX;

							((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
									+ ((TextFieldTop) tfTop[tf]).newSize;

							((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
									+ ((TextFieldTop) tfTop[tf]).newSizeC;
						} else {
							((TextFieldTop) tfTop[tf]).newPos = ((TextFieldTop) tfTop[tf - 1]).newPose
									+ ((TextFieldTop) tfTop[tf - 1]).deltaR
									+ ((TextFieldTop) tfTop[tf]).deltaL;

							((TextFieldTop) tfTop[tf]).newPosc = ((TextFieldTop) tfTop[tf - 1]).newPosec;

							((TextFieldTop) tfTop[tf]).newPose = ((TextFieldTop) tfTop[tf]).newPos
									+ ((TextFieldTop) tfTop[tf]).newSize;

							((TextFieldTop) tfTop[tf]).newPosec = ((TextFieldTop) tfTop[tf]).newPosc
									+ ((TextFieldTop) tfTop[tf]).newSizeC;

						}
					}

					myParent.topTexts.add(tfTop[tf]);
					// System.out.print(((TextFieldTop)
					// tfTop[tf]));
				}
				if (dimensionType == 9) {

					myParent.jobItem.design.findDLO.changeInternalDims(
							selectedRadioForRow, selectedRadioForCol,
							selectedRadioForRowo, selectedRadioForColo,
							selectedOpeningNo, myParent.topTexts, 2, 1,
							this.myParent.mySelectedSashLeaf);
				} else {

					myParent.mySelectedSashLeaf.modifyInternalDims(
							selectedRadioForRowo, 1, dimensionType);
				}

			}
			if (redrawText) {
				this.redrawTextForColRow(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modRowHeights(final double myW) {

		if (dimensionType <= 2) {
			modFrameRowH(myW);
		}
		// //////////
		else if (dimensionType >= 3 || dimensionType <= 9) {
			if (!myParent.dim.isSash.isSelected()) {
				modOpeningRowH(myW);
			} else {
				modOpeningRowHSash(myW);
			}
		}

		this.redrawTextForColRow(false);

	}

	public void modFrameRowH(final double myW) {

		try {

			myParent.modifyDims = false;

			double totalH = 0;
			double totalHC = 0;
			double sumSizeMod = 0;
			double sumSizeModC = 0;

			boolean reCalc = false;
			final Object[] tfLeft = myParent.leftTexts.toArray();
			myParent.leftTexts.clear();

			for (int tf = 0; tf < tfLeft.length; tf++) {
				((TextFieldLeft) tfLeft[tf]).mod = myParent.leftTextsMod[tf];
				totalH = totalH + ((TextFieldLeft) tfLeft[tf]).size;// /this.myParent.scale;
				totalHC = totalHC + ((TextFieldLeft) tfLeft[tf]).sizeC;// /this.myParent.scale;

			}
			// this.myParent.lastSelectedColBot=this.selectedColBot;
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (dimensionType == 1) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == selectedFrameNo) {
						myParent.lastSelectedRowLeft = myParent.lastSelectedRowLeft + 1;
						myParent.leftTextsMod[tf] = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						if (myParent.lastSelectedRowLeft > tfLeft.length) {
							myParent.lastSelectedRowLeft = 1;
							myParent.leftTextsMod[tf] = myParent.leftTextsMod[tf] - 1;
							((TextFieldLeft) tfLeft[tf]).mod = ((TextFieldLeft) tfLeft[tf]).mod - 1;
						}

						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).newSizeC = myW;
						((TextFieldLeft) tfLeft[tf]).newSize = myW
								- ((TextFieldLeft) tfLeft[tf]).deltaLT
								- ((TextFieldLeft) tfLeft[tf]).deltaRB;
						break;
					}
				} else if (dimensionType == 2) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == selectedFrameNo) {
						myParent.lastSelectedRowLeft = myParent.lastSelectedRowLeft + 1;
						myParent.leftTextsMod[tf] = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						if (myParent.lastSelectedRowLeft > tfLeft.length) {
							myParent.lastSelectedRowLeft = 1;
							myParent.leftTextsMod[tf] = myParent.leftTextsMod[tf] - 1;
							((TextFieldLeft) tfLeft[tf]).mod = ((TextFieldLeft) tfLeft[tf]).mod - 1;
						}

						((TextFieldLeft) tfLeft[tf]).newSize = myW;
						((TextFieldLeft) tfLeft[tf]).newSizeC = myW
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf]).deltaRB;
						break;
					}
				}
			}
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (((TextFieldLeft) tfLeft[tf]).mod > 0
						&& ((TextFieldLeft) tfLeft[tf]).rowNo != selectedFrameNo) {
					((TextFieldLeft) tfLeft[tf]).newSize = ((TextFieldLeft) tfLeft[tf]).size;// /this.myParent.scale;
					((TextFieldLeft) tfLeft[tf]).newSizeC = ((TextFieldLeft) tfLeft[tf]).sizeC;// /this.myParent.scale;
				}
			}
			double sumOther = 0;
			totalModLeft = 0;
			sumSizeMod = 0;
			sumSizeModC = 0;
			for (final Object element : tfLeft) {
				if (((TextFieldLeft) element).mod > 0) {
					totalModLeft = totalModLeft + 1;
					sumSizeMod = sumSizeMod + ((TextFieldLeft) element).newSize;
					sumSizeModC = sumSizeModC
							+ ((TextFieldLeft) element).newSizeC;
				}
			}
			if ((sumSizeMod >= totalH
					- 3
					* (myParent.facetUsed.top1.partDimA + myParent.facetUsed.top1.partDimB) || sumSizeModC >= totalHC
					- 3
					* (myParent.facetUsed.top1.partDimA + myParent.facetUsed.top1.partDimB))
					&& totalModLeft != tfLeft.length) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedFrameNo) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
					}
				}
				reCalc = true;
			} else {

				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (totalModLeft != tfLeft.length) {
						if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedFrameNo
								&& ((TextFieldLeft) tfLeft[tf]).mod == 0) {
							((TextFieldLeft) tfLeft[tf]).newSize = (totalH - sumSizeMod)
									/ (tfLeft.length - totalModLeft);
							((TextFieldLeft) tfLeft[tf]).newSizeC = (totalHC - sumSizeModC)
									/ (tfLeft.length - totalModLeft);
							sumOther = sumOther
									+ ((TextFieldLeft) tfLeft[tf]).newSize;
						}
					} else {
						reCalc = true;// true;
						if (myParent.modSeqUndoLeft == tfLeft.length) {
							myParent.modSeqUndoLeft = 0;
						}
						myParent.modSeqUndoLeft = myParent.modSeqUndoLeft + 1;
						break;
					}
				}
			}

			if (((totalH - sumSizeMod) / (tfLeft.length - totalModLeft) < 3 * (myParent.facetUsed.top1.partDimA + myParent.facetUsed.top1.partDimB) || (totalHC - sumSizeModC)
					/ (tfLeft.length - totalModLeft) < 3 * (myParent.facetUsed.top1.partDimA + myParent.facetUsed.top1.partDimB))
					&& !reCalc) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedFrameNo) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
					}
				}
				reCalc = true;
			}

			if (reCalc) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).mod == myParent.modSeqUndoLeft) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
						myParent.leftTextsMod[tf] = 0;
					}

				}

				totalModLeft = 0;
				sumSizeMod = 0;
				sumSizeModC = 0;
				for (final Object element : tfLeft) {
					if (((TextFieldLeft) element).mod > 0) {
						totalModLeft = totalModLeft + 1;
						sumSizeMod = sumSizeMod
								+ ((TextFieldLeft) element).newSize;
						sumSizeModC = sumSizeModC
								+ ((TextFieldLeft) element).newSizeC;
					}
				}
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (totalModLeft != tfLeft.length) {
						if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedFrameNo
								&& ((TextFieldLeft) tfLeft[tf]).mod == 0) {
							((TextFieldLeft) tfLeft[tf]).newSize = (totalH - sumSizeMod)
									/ (tfLeft.length - totalModLeft);
							((TextFieldLeft) tfLeft[tf]).newSizeC = (totalHC - sumSizeModC)
									/ (tfLeft.length - totalModLeft);
						}
					}
				}
			}
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (((TextFieldLeft) tfLeft[tf]).startRowCol == 1) {
					((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf]).pos;
					((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).pos;
					((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).pos
							+ ((TextFieldLeft) tfLeft[tf]).newSize;
					((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).pos
							+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

				} else if (((TextFieldLeft) tfLeft[tf]).endRowCol == myParent.facetUsed.bOpeningObject.yRows) {

					((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
							+ ((TextFieldLeft) tfLeft[tf]).deltaLT
							+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
					((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
							- ((TextFieldLeft) tfLeft[tf]).deltaLT;
					((TextFieldLeft) tfLeft[tf]).newPose = endY;
					((TextFieldLeft) tfLeft[tf]).newPosec = endY;
					;
				} else {
					((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
							+ ((TextFieldLeft) tfLeft[tf]).deltaLT
							+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
					((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
							- ((TextFieldLeft) tfLeft[tf]).deltaLT;
					((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
							+ ((TextFieldLeft) tfLeft[tf]).newSize;
					((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
							+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

				}
				myParent.leftTexts.add(tfLeft[tf]);
				// System.out.print(((TextFieldLeft)
				// tfLeft[tf]));
			}
			myParent.facetUsed.modifyInternalDims(selectedRadioForCol, 2);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modRowHSTD(final double myW, final double t, final double tc) {

		try {

			myParent.modifyDims = false;

			final double totalH = t;
			final double totalHC = tc;
			final double sumSizeMod = 0;
			final double sumSizeModC = 0;

			final boolean reCalc = false;

			final Object[] tfLeft = myParent.leftTexts.toArray();
			myParent.leftTexts.clear();

			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (((TextFieldLeft) tfLeft[tf]).startRowCol == 1) {
					((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf]).pos;
					((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).pos;
					((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).pos
							+ ((TextFieldLeft) tfLeft[tf]).newSize;
					((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).pos
							+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

				} else if (((TextFieldLeft) tfLeft[tf]).endRowCol == myParent.facetUsed.bOpeningObject.yRows) {

					((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
							+ ((TextFieldLeft) tfLeft[tf]).deltaLT
							+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
					((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
							- ((TextFieldLeft) tfLeft[tf]).deltaLT;
					((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
							+ ((TextFieldLeft) tfLeft[tf]).newSize;
					((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
							+ ((TextFieldLeft) tfLeft[tf]).newSizeC;
				} else {
					((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
							+ ((TextFieldLeft) tfLeft[tf]).deltaLT
							+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
					((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
							- ((TextFieldLeft) tfLeft[tf]).deltaLT;
					((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
							+ ((TextFieldLeft) tfLeft[tf]).newSize;
					((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
							+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

				}
				myParent.leftTexts.add(tfLeft[tf]);

			}
			myParent.facetUsed.modifyInternalDims(selectedRadioForCol, 2);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modOpeningRowH(final double myW) {

		try {

			myParent.modifyDims = false;

			double totalH = 0;
			double totalHC = 0;
			double sumSizeMod = 0;
			double sumSizeModC = 0;

			boolean reCalc = false;
			final Object[] tfLeft = myParent.leftTexts.toArray();
			myParent.leftTexts.clear();

			if (myParent.leftTextsModo.length == 0) {

				myParent.facetUsed.doTopTextModOpening(selectedRadioForRow,
						selectedRadioForCol, selectedRadioForRowo,
						selectedRadioForColo);
				myParent.facetUsed.doLeftTextModOpening(selectedRadioForRow,
						selectedRadioForCol, selectedRadioForRowo,
						selectedRadioForColo);
			}

			for (int tf = 0; tf < tfLeft.length; tf++) {
				((TextFieldLeft) tfLeft[tf]).mod = myParent.leftTextsModo[tf];
				totalH = totalH + ((TextFieldLeft) tfLeft[tf]).size;
				totalHC = totalHC + ((TextFieldLeft) tfLeft[tf]).sizeC;

			}

			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (dimensionType == 3 || dimensionType == 5) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == selectedOpeningNo) {
						myParent.lastSelectedRowLeft = myParent.lastSelectedRowLeft + 1;
						myParent.leftTextsModo[tf] = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						if (myParent.lastSelectedRowLeft > tfLeft.length) {
							myParent.lastSelectedRowLeft = 1;
							myParent.leftTextsModo[tf] = myParent.leftTextsModo[tf] - 1;
							((TextFieldLeft) tfLeft[tf]).mod = ((TextFieldLeft) tfLeft[tf]).mod - 1;
						}

						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).newSizeC = myW;
						((TextFieldLeft) tfLeft[tf]).newSize = myW
								- ((TextFieldLeft) tfLeft[tf]).deltaLT
								- ((TextFieldLeft) tfLeft[tf]).deltaRB;
						break;
					}
				} else if (dimensionType == 4 || dimensionType >= 6) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == selectedOpeningNo) {
						myParent.lastSelectedRowLeft = myParent.lastSelectedRowLeft + 1;
						myParent.leftTextsModo[tf] = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						if (myParent.lastSelectedRowLeft > tfLeft.length) {
							myParent.lastSelectedRowLeft = 1;
							myParent.leftTextsModo[tf] = myParent.leftTextsModo[tf] - 1;
							((TextFieldLeft) tfLeft[tf]).mod = ((TextFieldLeft) tfLeft[tf]).mod - 1;
						}

						((TextFieldLeft) tfLeft[tf]).newSize = myW;
						((TextFieldLeft) tfLeft[tf]).newSizeC = myW
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf]).deltaRB;
						break;
					}
				}
			}
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (((TextFieldLeft) tfLeft[tf]).mod > 0
						&& ((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo) {
					((TextFieldLeft) tfLeft[tf]).newSize = ((TextFieldLeft) tfLeft[tf]).size;// /this.myParent.scale;
					((TextFieldLeft) tfLeft[tf]).newSizeC = ((TextFieldLeft) tfLeft[tf]).sizeC;// /this.myParent.scale;
				}
			}
			double sumOther = 0;
			totalModLeft = 0;
			sumSizeMod = 0;
			sumSizeModC = 0;
			for (final Object element : tfLeft) {
				if (((TextFieldLeft) element).mod > 0) {
					totalModLeft = totalModLeft + 1;
					sumSizeMod = sumSizeMod + ((TextFieldLeft) element).newSize;
					sumSizeModC = sumSizeModC
							+ ((TextFieldLeft) element).newSizeC;
				}
			}
			if ((sumSizeMod >= totalH
					- 3
					* (mySelectedFrame.top1.partDimA + mySelectedFrame.top1.partDimB) || sumSizeModC >= totalHC
					- 3
					* (mySelectedFrame.top1.partDimA + mySelectedFrame.top1.partDimB))
					&& totalModLeft != tfLeft.length) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
					}
				}
				reCalc = true;
			} else {

				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (totalModLeft != tfLeft.length) {
						if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo
								&& ((TextFieldLeft) tfLeft[tf]).mod == 0) {
							((TextFieldLeft) tfLeft[tf]).newSize = (totalH - sumSizeMod)
									/ (tfLeft.length - totalModLeft);
							((TextFieldLeft) tfLeft[tf]).newSizeC = (totalHC - sumSizeModC)
									/ (tfLeft.length - totalModLeft);
							sumOther = sumOther
									+ ((TextFieldLeft) tfLeft[tf]).newSize;
						}
					} else {
						reCalc = true;// true;
						if (myParent.modSeqUndoLeft == tfLeft.length) {
							myParent.modSeqUndoLeft = 0;
						}
						myParent.modSeqUndoLeft = myParent.modSeqUndoLeft + 1;
						break;
					}
				}
			}

			if (((totalH - sumSizeMod) / (tfLeft.length - totalModLeft) < 3 * (mySelectedFrame.top1.partDimA + mySelectedFrame.top1.partDimB) || (totalHC - sumSizeModC)
					/ (tfLeft.length - totalModLeft) < 3 * (mySelectedFrame.top1.partDimA + mySelectedFrame.top1.partDimB))
					&& !reCalc) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedRowLeft) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
					}
				}
				reCalc = true;
			}

			if (reCalc) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).mod == myParent.modSeqUndoLeft) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
						myParent.leftTextsModo[tf] = 0;
					}

				}

				totalModLeft = 0;
				sumSizeMod = 0;
				sumSizeModC = 0;
				for (final Object element : tfLeft) {
					if (((TextFieldLeft) element).mod > 0) {
						totalModLeft = totalModLeft + 1;
						sumSizeMod = sumSizeMod
								+ ((TextFieldLeft) element).newSize;
						sumSizeModC = sumSizeModC
								+ ((TextFieldLeft) element).newSizeC;
					}
				}
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (totalModLeft != tfLeft.length) {
						if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo
								&& ((TextFieldLeft) tfLeft[tf]).mod == 0) {
							((TextFieldLeft) tfLeft[tf]).newSize = (totalH - sumSizeMod)
									/ (tfLeft.length - totalModLeft);
							((TextFieldLeft) tfLeft[tf]).newSizeC = (totalHC - sumSizeModC)
									/ (tfLeft.length - totalModLeft);
						}
					}
				}
			}
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (dimensionType != 7 && dimensionType != 8) {
					if (((TextFieldLeft) tfLeft[tf]).startRowCol == 1) {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf]).pos;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).pos;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).pos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).pos
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					} else if (((TextFieldLeft) tfLeft[tf]).endRowCol == mySelectedFrame.yRows
							&& dimensionType < 9) {

						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = endY;
						((TextFieldLeft) tfLeft[tf]).newPosec = endY;

					} else {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					}
				} else {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == 1) {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf]).pos;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).posc;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).pos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).posc
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					} else if (((TextFieldLeft) tfLeft[tf]).rowNo == mySelectedFrame.yRows
							&& dimensionType < 9) {

						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = endY;
						((TextFieldLeft) tfLeft[tf]).newPosec = endY;

					} else {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					}
				}
				myParent.leftTexts.add(tfLeft[tf]);

			}
			if (dimensionType == 9) {
				myParent.jobItem.design.findDLO.changeInternalDims(
						selectedRadioForRow, selectedRadioForCol,
						selectedRadioForRowo, selectedRadioForColo,
						selectedOpeningNo, myParent.leftTexts, 2, 2,
						this.mySelectedFrame);
			} else {
				mySelectedFrame.modifyInternalDims(selectedRadioForColo, 2,
						dimensionType);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void modOpeningRowHSash(final double myW) {

		try {

			myParent.modifyDims = false;

			double totalH = 0;
			double totalHC = 0;
			double sumSizeMod = 0;
			double sumSizeModC = 0;

			boolean reCalc = false;
			final Object[] tfLeft = myParent.leftTexts.toArray();
			myParent.leftTexts.clear();

			if (myParent.leftTextsModo.length == 0) {

				myParent.facetUsed.doTopTextModOpening(selectedRadioForRow,
						selectedRadioForCol, selectedRadioForRowo,
						selectedRadioForColo);
				myParent.facetUsed.doLeftTextModOpening(selectedRadioForRow,
						selectedRadioForCol, selectedRadioForRowo,
						selectedRadioForColo);
			}

			for (int tf = 0; tf < tfLeft.length; tf++) {
				((TextFieldLeft) tfLeft[tf]).mod = myParent.leftTextsModo[tf];
				totalH = totalH + ((TextFieldLeft) tfLeft[tf]).size;
				totalHC = totalHC + ((TextFieldLeft) tfLeft[tf]).sizeC;

			}

			// this.myParent.lastSelectedColBot=this.selectedColBot;
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (dimensionType == 3 || dimensionType == 5) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == selectedOpeningNo) {
						myParent.lastSelectedRowLeft = myParent.lastSelectedRowLeft + 1;
						myParent.leftTextsModo[tf] = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						if (myParent.lastSelectedRowLeft > tfLeft.length) {
							myParent.lastSelectedRowLeft = 1;
							myParent.leftTextsModo[tf] = myParent.leftTextsModo[tf] - 1;
							((TextFieldLeft) tfLeft[tf]).mod = ((TextFieldLeft) tfLeft[tf]).mod - 1;
						}

						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).newSizeC = myW;
						((TextFieldLeft) tfLeft[tf]).newSize = myW
								- ((TextFieldLeft) tfLeft[tf]).deltaLT
								- ((TextFieldLeft) tfLeft[tf]).deltaRB;
						break;
					}
				} else if (dimensionType == 4 || dimensionType >= 6) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == selectedOpeningNo) {
						myParent.lastSelectedRowLeft = myParent.lastSelectedRowLeft + 1;
						myParent.leftTextsModo[tf] = myParent.lastSelectedRowLeft;
						((TextFieldLeft) tfLeft[tf]).mod = myParent.lastSelectedRowLeft;
						if (myParent.lastSelectedRowLeft > tfLeft.length) {
							myParent.lastSelectedRowLeft = 1;
							myParent.leftTextsModo[tf] = myParent.leftTextsModo[tf] - 1;
							((TextFieldLeft) tfLeft[tf]).mod = ((TextFieldLeft) tfLeft[tf]).mod - 1;
						}

						((TextFieldLeft) tfLeft[tf]).newSize = myW;
						((TextFieldLeft) tfLeft[tf]).newSizeC = myW
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf]).deltaRB;
						break;
					}
				}
			}
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (((TextFieldLeft) tfLeft[tf]).mod > 0
						&& ((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo) {
					((TextFieldLeft) tfLeft[tf]).newSize = ((TextFieldLeft) tfLeft[tf]).size;// /this.myParent.scale;
					((TextFieldLeft) tfLeft[tf]).newSizeC = ((TextFieldLeft) tfLeft[tf]).sizeC;// /this.myParent.scale;
				}
			}
			double sumOther = 0;
			totalModLeft = 0;
			sumSizeMod = 0;
			sumSizeModC = 0;
			for (final Object element : tfLeft) {
				if (((TextFieldLeft) element).mod > 0) {
					totalModLeft = totalModLeft + 1;
					sumSizeMod = sumSizeMod + ((TextFieldLeft) element).newSize;
					sumSizeModC = sumSizeModC
							+ ((TextFieldLeft) element).newSizeC;
				}
			}
			if ((sumSizeMod >= totalH
					- 3
					* (myParent.mySelectedSashLeaf.top1.partDimA + myParent.mySelectedSashLeaf.top1.partDimB) || sumSizeModC >= totalHC
					- 3
					* (myParent.mySelectedSashLeaf.top1.partDimA + myParent.mySelectedSashLeaf.top1.partDimB))
					&& totalModLeft != tfLeft.length) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
					}
				}
				reCalc = true;
			} else {

				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (totalModLeft != tfLeft.length) {
						if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo
								&& ((TextFieldLeft) tfLeft[tf]).mod == 0) {
							((TextFieldLeft) tfLeft[tf]).newSize = (totalH - sumSizeMod)
									/ (tfLeft.length - totalModLeft);
							((TextFieldLeft) tfLeft[tf]).newSizeC = (totalHC - sumSizeModC)
									/ (tfLeft.length - totalModLeft);
							sumOther = sumOther
									+ ((TextFieldLeft) tfLeft[tf]).newSize;
						}
					} else {
						reCalc = true;// true;
						if (myParent.modSeqUndoLeft == tfLeft.length) {
							myParent.modSeqUndoLeft = 0;
						}
						myParent.modSeqUndoLeft = myParent.modSeqUndoLeft + 1;
						break;
					}
				}
			}

			if (((totalH - sumSizeMod) / (tfLeft.length - totalModLeft) < 3 * (myParent.mySelectedSashLeaf.top1.partDimA + myParent.mySelectedSashLeaf.top1.partDimB) || (totalHC - sumSizeModC)
					/ (tfLeft.length - totalModLeft) < 3 * (myParent.mySelectedSashLeaf.top1.partDimA + myParent.mySelectedSashLeaf.top1.partDimB))
					&& !reCalc) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedRowLeft) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
					}
				}
				reCalc = true;
			}

			if (reCalc) {
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (((TextFieldLeft) tfLeft[tf]).mod == myParent.modSeqUndoLeft) {
						((TextFieldLeft) tfLeft[tf]).mod = 0;
						myParent.leftTextsModo[tf] = 0;
					}

				}

				totalModLeft = 0;
				sumSizeMod = 0;
				sumSizeModC = 0;
				for (final Object element : tfLeft) {
					if (((TextFieldLeft) element).mod > 0) {
						totalModLeft = totalModLeft + 1;
						sumSizeMod = sumSizeMod
								+ ((TextFieldLeft) element).newSize;
						sumSizeModC = sumSizeModC
								+ ((TextFieldLeft) element).newSizeC;
					}
				}
				for (int tf = 0; tf < tfLeft.length; tf++) {
					if (totalModLeft != tfLeft.length) {
						if (((TextFieldLeft) tfLeft[tf]).rowNo != selectedOpeningNo
								&& ((TextFieldLeft) tfLeft[tf]).mod == 0) {
							((TextFieldLeft) tfLeft[tf]).newSize = (totalH - sumSizeMod)
									/ (tfLeft.length - totalModLeft);
							((TextFieldLeft) tfLeft[tf]).newSizeC = (totalHC - sumSizeModC)
									/ (tfLeft.length - totalModLeft);
						}
					}
				}
			}
			for (int tf = 0; tf < tfLeft.length; tf++) {
				if (dimensionType != 7 && dimensionType != 8) {
					if (((TextFieldLeft) tfLeft[tf]).startRowCol == 1) {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf]).pos;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).pos;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).pos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).pos
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					} else if (((TextFieldLeft) tfLeft[tf]).endRowCol == myParent.mySelectedSashLeaf.yRows
							&& dimensionType < 9) {

						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = endY;
						((TextFieldLeft) tfLeft[tf]).newPosec = endY;

					} else {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					}
				} else {
					if (((TextFieldLeft) tfLeft[tf]).rowNo == 1) {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf]).pos;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).posc;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).pos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).posc
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					} else if (((TextFieldLeft) tfLeft[tf]).rowNo == myParent.mySelectedSashLeaf.yRows
							&& dimensionType < 9) {

						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = endY;
						((TextFieldLeft) tfLeft[tf]).newPosec = endY;

					} else {
						((TextFieldLeft) tfLeft[tf]).newPos = ((TextFieldLeft) tfLeft[tf - 1]).newPose
								+ ((TextFieldLeft) tfLeft[tf]).deltaLT
								+ ((TextFieldLeft) tfLeft[tf - 1]).deltaRB;
						((TextFieldLeft) tfLeft[tf]).newPosc = ((TextFieldLeft) tfLeft[tf]).newPos
								- ((TextFieldLeft) tfLeft[tf]).deltaLT;
						((TextFieldLeft) tfLeft[tf]).newPose = ((TextFieldLeft) tfLeft[tf]).newPos
								+ ((TextFieldLeft) tfLeft[tf]).newSize;
						((TextFieldLeft) tfLeft[tf]).newPosec = ((TextFieldLeft) tfLeft[tf]).newPosc
								+ ((TextFieldLeft) tfLeft[tf]).newSizeC;

					}
				}
				myParent.leftTexts.add(tfLeft[tf]);

			}
			if (dimensionType == 9) {
				myParent.jobItem.design.findDLO.changeInternalDims(
						selectedRadioForRow, selectedRadioForCol,
						selectedRadioForRowo, selectedRadioForColo,
						selectedOpeningNo, myParent.leftTexts, 2, 2,
						this.myParent.mySelectedSashLeaf);
			} else {
				myParent.mySelectedSashLeaf.modifyInternalDims(
						selectedRadioForColo, 2, dimensionType);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.myParent, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public double getposcforLastColumn(final int col, final Object[] tfTop) {

		double newPose = 0;
		for (final Object element : tfTop) {
			if (((TextFieldTop) element).endRowCol == col - 1) {
				newPose = ((TextFieldTop) element).newPose;
				break;
			}
		}
		return newPose;

	}

	public void myTextTop_MouseClicked(final MouseEvent e) {

		((JXTextField) e.getSource()).selectAll();
		final int x = (int) ((JXTextField) e.getSource()).getLocation().getX();

		final int y = (int) ((JXTextField) e.getSource()).getLocation().getY();

		this.getSelectedColTop(x, y);

		selectedWorH = 1;

	}

	public void myTextLeft_MouseClicked(final MouseEvent e) {

		((JXTextField) e.getSource()).selectAll();
		final int x = (int) ((JXTextField) e.getSource()).getLocation().getX();
		final int y = (int) ((JXTextField) e.getSource()).getLocation().getY();
		this.getSelectedRowLeft(x, y);
		selectedWorH = 2;
	}

	public void myTextRow_focusLost(final FocusEvent e) {

		JXTextField tf = (JXTextField) e.getSource();
		final int x = (int) (tf).getLocation().getX();
		final int y = (int) (tf).getLocation().getY();

		if (!myParent.myTopPanel.isStdSelected) {

			tf.setText(myParent.lastTextValue + "");

		} else {

			updateTextTopWithStd(x, y, tf);
			textRowAction(tf);
		}

		((JXTextField) e.getSource()).repaint();
	}

	public void myTextColLeft_focusLost(final FocusEvent e) {

		JXTextField tf = (JXTextField) e.getSource();
		final int x = (int) (tf).getLocation().getX();
		final int y = (int) (tf).getLocation().getY();

		if (!myParent.myTopPanel.isStdSelected) {
			tf.setText(myParent.lastTextValue + "");

		} else {
			this.updateTextLeftWithStd(x, y, tf);
			textColAction(tf);
		}

		((JXTextField) e.getSource()).repaint();
	}

	public void myTextRow_focusGained(final FocusEvent e) {
		this.myParent.lastTextValue = Double.parseDouble(((JXTextField) e
				.getSource()).getText());
		((JXTextField) e.getSource()).selectAll();

	}

	public void myTextColLeft_focusGained(final FocusEvent e) {
		this.myParent.lastTextValue = Double.parseDouble(((JXTextField) e
				.getSource()).getText());
		((JXTextField) e.getSource()).selectAll();
		// ((JXTextField) e.getSource()).setEditable(true);
		// ((JXTextField) e.getSource()).setEnabled(true);
	}

	public void myTextBot_focusGained(final FocusEvent e) {
		this.myParent.lastTextValue = Double.parseDouble(((JXTextField) e
				.getSource()).getText());
		((JXTextField) e.getSource()).selectAll();

	}

	public void myTextBot_focusLost(final FocusEvent e) {
		((JXTextField) e.getSource()).setText(myParent.lastTextValue + "");
		((JXTextField) e.getSource()).repaint();
	}

	public void myTextRow_keyReleased(final KeyEvent e) {

	}

	public void myTextBot_keyReleased(final KeyEvent e) {

	}

	public void radioCol_actionPerformed(final ActionEvent e) {

		radioCol_Action(e);
	}

	public void radioCol_MouseClicked(final MouseEvent e) {

		radioCol_Action(e);
	}

	public void radioRow_actionPerformed(final ActionEvent e) {

		radioRow_Action(e);

	}

	public void radioRow_MouseClicked(final MouseEvent e) {

		radioRow_Action(e);
	}

	public void radioRowo_actionPerformed(final ActionEvent e) {

		radioRow_Opening_Action(e);
	}

	public void radioRowo_MouseClicked(final MouseEvent e) {

		radioRow_Opening_Action(e);

	}

	public void radioColo_actionPerformed(final ActionEvent e) {

		radioCol_Opening_Action(e);
	}

	public void radioColo_MouseClicked(MouseEvent e) {

		radioCol_Opening_Action(e);
	}

	public void radioRow_Action(ActionEvent e) {

		myParent.resetModTextsH = true;
		myParent.resetModTextsV = true;
		selectedRadioForRow = Integer.parseInt(((JCheckBox) e.getSource())
				.getToolTipText());
		myParent.lastRR = selectedRadioForRow;
		myParent.jobItem.hasSubRC(selectedRadioForRow, selectedRadioForCol);
		this.redrawTextForColRow(false);
	}

	public void radioRow_Action(MouseEvent e) {

		myParent.resetModTextsH = true;
		myParent.resetModTextsV = true;
		selectedRadioForRow = Integer.parseInt(((JCheckBox) e.getSource())
				.getToolTipText());
		myParent.lastRR = selectedRadioForRow;
		myParent.jobItem.hasSubRC(selectedRadioForRow, selectedRadioForCol);
		this.redrawTextForColRow(false);
	}

	public void radioRow_Opening_Action(final MouseEvent e) {

		//
		// myParent.resetModTextsH=true;
		// myParent.resetModTextsV=true;
		// selectedRadioForRowo =
		// Integer.parseInt(((JRadioButton) e
		// .getSource()).getToolTipText());
		//
		// myParent.jobItem.getOpeningContent(selectedRadioForRow,
		// selectedRadioForCol, selectedRadioForRowo,
		// selectedRadioForColo);
		//
		// myParent.lastRRo = selectedRadioForRowo;
		//
		// // myParent.jobItem.hasSubRC(selectedRadioForRow,
		// selectedRadioForCol);
		// //
		// myParent.facetUsed
		// .doTopTextModOpening(selectedRadioForRow,
		// selectedRadioForCol, selectedRadioForRowo,
		// selectedRadioForColo);
		// this.redrawTextForColRow(false);
		// ((JRadioButton) e.getSource())
		// .setSelected(true);

		// completeRadioRowOpeningAction(e);
	}

	public void radioRow_Opening_Action(ActionEvent e) {

		selectedRadioForRowo = Integer.parseInt(((JRadioButton) e.getSource())
				.getToolTipText());
		radioRowOpeningAction();
		myParent.dimAction();
	}

	public void radioCol_Action(MouseEvent e) {

		myParent.resetModTextsH = true;
		myParent.resetModTextsV = true;
		selectedRadioForCol = Integer.parseInt(((JCheckBox) e.getSource())
				.getToolTipText());
		myParent.lastRC = selectedRadioForCol;
		myParent.jobItem
				.getOpeningContent(selectedRadioForRow, selectedRadioForCol,
						selectedRadioForRowo, selectedRadioForColo);

		myParent.jobItem.hasSubRC(selectedRadioForRow, selectedRadioForCol);
		this.redrawTextForColRow(false);
	}

	public void radioCol_Action(ActionEvent e) {

		myParent.resetModTextsH = true;
		myParent.resetModTextsV = true;
		selectedRadioForCol = Integer.parseInt(((JCheckBox) e.getSource())
				.getToolTipText());
		myParent.lastRC = selectedRadioForCol;
		myParent.jobItem
				.getOpeningContent(selectedRadioForRow, selectedRadioForCol,
						selectedRadioForRowo, selectedRadioForColo);

		myParent.jobItem.hasSubRC(selectedRadioForRow, selectedRadioForCol);
		this.redrawTextForColRow(false);
	}

	public void radioFacetBot_Action(ActionEvent e) {

		selectedfBot = Integer.parseInt(((JCheckBox) e.getSource())
				.getToolTipText());

		myParent.lastFB = selectedfBot;

		final String myseq = String.valueOf(selectedRadioForFacetLeft)
				+ String.valueOf(selectedfBot) + "";

		final Object[] facets = myParent.jobItem.design.frames.toArray();

		for (final Object f : facets) {
			if (((Facet) f).a_sequenceID == Integer.parseInt(myseq)) {
				mySelectedFacet = (Facet) f;
				myParent.facetUsed = (Facet) f;

			}
		}

		final Object[] textsFacet = myParent.fcolTexts.toArray();

		for (int j = 0; j < textsFacet.length; j++) {
			if (myParent.myTextFacetBot != null
					&& myParent.myTextFacetBot[j] != null) {
				if (selectedfBot - 1 == j) {
					if (!myParent.layoutP.bay.isSelected()
							&& !myParent.layoutP.bow.isSelected()) {
						myParent.myTextFacetBot[j].setEnabled(true);
					} else {
						myParent.myTextFacetBot[j].setEnabled(false);
					}
				} else {
					myParent.myTextFacetBot[j].setEnabled(false);
				}
			}

		}

		this.redrawTextForColRow(false);

	}

	public void radioCol_Opening_Action(ActionEvent e) {

		selectedRadioForColo = Integer.parseInt(((JRadioButton) e.getSource())
				.getToolTipText());
		radioColOpeningAction();

		// this.redrawTextForColRow(false);
		myParent.dimAction();
	}

	public void radioCol_Opening_Action(MouseEvent e) {

		// completeRadioColOpeningAction(e);
	}

	public void radioColOpeningAction() {

		myParent.resetModTextsH = true;
		myParent.resetModTextsV = true;
		myParent.lastRCo = selectedRadioForColo;

		myParent.jobItem.hasSubRC(selectedRadioForRow, selectedRadioForCol);

		myParent.facetUsed
				.doLeftTextModOpening(selectedRadioForRow, selectedRadioForCol,
						selectedRadioForRowo, selectedRadioForColo);
	}

	public void radioRowOpeningAction() {

		myParent.resetModTextsH = true;
		myParent.resetModTextsV = true;
		myParent.lastRRo = selectedRadioForRowo;

		myParent.jobItem.hasSubRC(selectedRadioForRow, selectedRadioForCol);

		myParent.facetUsed
				.doTopTextModOpening(selectedRadioForRow, selectedRadioForCol,
						selectedRadioForRowo, selectedRadioForColo);

	}

	/**
	 * Mouse Adapter for DrawCanvas JPanel
	 */
	private class myMouseAdapter extends MouseInputAdapter {

		/**
		 * MousePressed Event
		 * 
		 * @param e
		 *            , MouseEvent
		 */
		@Override
		public void mousePressed(MouseEvent e) {

			// Get current rectangle mouse click event with height and
			// width zero
			currentRect = new Rectangle(e.getX(), e.getY(), 0, 0);

			// Call drawing_MouseClicked
			drawing_MouseClicked(e);
		}

		/**
		 * MouseReleased Event
		 * 
		 * @param e
		 *            , MouseEvent
		 */
		@Override
		public void mouseReleased(MouseEvent e) {

			// Update size current rectangle
			updateSize(e);

			if (myParent.getActionTypeEvent() == MenuActionEventDraw.GRIDS_EVENT
					.getValue()
					&& myParent.gridOp == 9
					|| myParent.gridOp == 10
					&& currentRect.width > 0
					&& currentRect.height > 0) {
				// Canvas mouse release action
				canvasMouseReleaseAction(e);
			} else if (myParent.getActionTypeEvent() == MenuActionEventDraw.GRIDS_EVENT
					.getValue()
					&& myParent.gridOp == 9
					|| myParent.gridOp == 10
					&& currentRect.width == 0
					&& currentRect.height == 0) {
				// Canvas mouse release action
				canvasMouseReleaseAction(e);
			}
		}

		/**
		 * MouseDragged Event
		 * 
		 * @param e
		 *            , MouseEvent
		 */
		@Override
		public void mouseDragged(MouseEvent e) {

			// Setting mouse draw to true
			mouseDrag = true;
			// Update size current rectangle
			updateSize(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Point p = e.getPoint();
			if (!DrawCanvas.this.getBounds().contains(p)) {
				if (myParent.myCursor != Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR)) {
					myParent.stopCustomCursor(myParent.main);

					MenuActionEventDraw.NOT_SELECTION.resetValue();
					myParent.setActionTypeEvent(0);

				}
				// myParent.jobItem.resetGraphics();
			}

		}

	}

}
