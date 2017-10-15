/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Collections;

import javax.swing.JOptionPane;

import Model.ProfileParts.*;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.partner.Grids;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.parts.Parts;
import Model.BillOfMat;
import Model.BkgrdOpeningObject;
import Model.DLO;
import Model.Facet;
import Model.Frame;
import Model.OpeningObject;
import Model.Overall;
import Model.SashLeaf;
import Model.ShapeObject;
import Model.TextObjects.TextFieldLeft;
import Model.TextObjects.TextFieldTop;
import Presentation.ItemFrame;

import org.openjanela.data.ApplicationBaseApp;

import util.UOMConvert;

// No Further
public class FindBiggestDLO {

	public Overall myDesign;

	public Collection DLOs = new ArrayList();

	public Collection glassDLOs = new ArrayList();

	public Collection verticals = new ArrayList();

	public Collection horizontals = new ArrayList();

	public List<Double> hardVs = new ArrayList<Double>();

	public List<Double> hardHs = new ArrayList<Double>();

	public List<Double> sortedhardVs = new ArrayList<Double>();

	public List<Double> sortedhardHs = new ArrayList<Double>();

	final boolean phiW = false;

	final boolean phiH = false;

	final boolean reversePhi = false;

	public int gridID = 0;

	public int gridType = 0;

	public int whichPos = 0;

	public double myThick = 0;

	public int nS = 0;

	public double yFirst = 0;

	public double yLast = 0;

	public double deduct1 = 0;

	public double deduct2 = 0;

	double myX = 0;

	double myY = 0;

	public Collection xCoordB = new ArrayList();

	public Collection yCoordB = new ArrayList();

	public Collection selectedGridsV = new ArrayList();

	public Collection selectedGridsS = new ArrayList();

	public Collection selectedGridsH = new ArrayList();

	public Collection selectedRemoveRC = new ArrayList();

	public DLO selectedDLO = null;

	public boolean cutSpoke = false;

	public int frameSeq = 0;

	ItemFrame myFrame2;

	Rectangle myRectangle;

	public BigDecimal myScale = new BigDecimal(0);

	public Collection mastersW = new ArrayList();

	public Collection mastersH = new ArrayList();

	int pos = 0;

	Grids myGrid = new Grids();

	Parts myProfile = new Parts();

	Parts mySimProfile = new Parts();

	Parts myCross = new Parts();

	Parts myL = new Parts();

	Parts myT = new Parts();

	boolean inGlass = false;

	boolean inOpening = false;

	public FindBiggestDLO() {
	}

	public FindBiggestDLO(ItemFrame myframe) {

		myFrame2 = myframe;

		setGridInfo();

		myFrame2 = myframe;

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

	}

	public void setGridInfo() {

		myGrid = myFrame2.gridsPanel.myGrid;
		myDesign = myFrame2.jobItem.design;
		gridID = myGrid.getId();
		gridType = myGrid.getGridTypeId();

		if (gridType <= 2 || gridType == 5 || gridType == 6) {
			inGlass = true;
		}
		if (gridType >= 5) {
			inOpening = true;
		}

		if (myGrid.getPartid() != null && myGrid.getPartid() > 0) {

			if (myGrid.isRemote()) {
				myProfile = ItemFrame.getApplicationRemoteBaseRules().getPart(
						myGrid.getSupplierId(), myGrid.getPartid());
			} else {
				myProfile = ItemFrame.getApplicationBase().getPart(
						myGrid.getPartid());
			}

			if (myGrid.getPartidSim() > 0 && inOpening && inGlass) {
				if (myGrid.isRemote()) {
					mySimProfile = ItemFrame.getApplicationRemoteBaseRules()
							.getPart(myGrid.getSupplierId(),
									myGrid.getPartidSim());
				} else {
					mySimProfile = ItemFrame.getApplicationBase().getPart(
							myGrid.getPartidSim());
				}
			}

			if (myGrid.getPartidT() > 0) {
				if (myGrid.isRemote()) {
					myT = ItemFrame.getApplicationRemoteBaseRules().getPart(
							myGrid.getSupplierId(), myGrid.getPartidT());
				} else {
					myT = ItemFrame.getApplicationBase().getPart(
							myGrid.getPartidT());
				}
			}

			if (myGrid.getPartidL() > 0) {
				if (myGrid.isRemote()) {
					myL = ItemFrame.getApplicationRemoteBaseRules().getPart(
							myGrid.getSupplierId(), myGrid.getPartidL());
				} else {
					myL = ItemFrame.getApplicationBase().getPart(
							myGrid.getPartidL());
				}
			}

			if (myGrid.getPartidCross() > 0) {
				if (myGrid.isRemote()) {
					myCross = ItemFrame.getApplicationRemoteBaseRules()
							.getPart(myGrid.getSupplierId(),
									myGrid.getPartidCross());
				} else {
					myCross = ItemFrame.getApplicationBase().getPart(
							myGrid.getPartidCross());
				}
			}
		}
		if (myGrid.getPartid() == null) {
			removeAllGrids();
		}
	}

	public DLO initMasterChange(int xxx, int yyy, int op, int pos, int form) {

		this.pos = pos;
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		Object[] mydlos = DLOs.toArray();

		boolean found = false;

		for (Object dlo : mydlos) {

			if (((DLO) dlo).startingX <= xxx && ((DLO) dlo).bX2 >= xxx
					&& ((DLO) dlo).highestY <= yyy
					&& ((DLO) dlo).lowestY >= yyy) {

				selectedDLO = (DLO) dlo;

				if (selectedDLO.myMasterH == null) {
					selectedDLO.myMasterH = new DLO();

				}

				if (selectedDLO.myMasterW == null) {
					selectedDLO.myMasterW = new DLO();

				}

				found = true;
				break;
			}

		}

		mydlos = null;

		if (op == 9) {

			Object[] vs = selectedDLO.bOpeningObject.mullions.toArray();

			if (myFrame2.jobItem.myCanvas.currentRect.width > 0
					&& myFrame2.jobItem.myCanvas.currentRect.height > 0) {

				for (Object g : vs) {
					final int[] which = new int[2];
					if (((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect)) {
						which[0] = ((Profiles) g).rowCol;
						which[1] = ((Profiles) g).orientation;
						selectedRemoveRC.add(which);
					}
				}

			} else {
				myFrame2.jobItem.myCanvas.currentRect.x = xxx - 3;
				myFrame2.jobItem.myCanvas.currentRect.y = yyy - 3;
				myFrame2.jobItem.myCanvas.currentRect.width = 6;
				myFrame2.jobItem.myCanvas.currentRect.height = 6;
				for (Object g : vs) {
					int[] which = new int[2];
					if (((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect)) {
						which[0] = ((Profiles) g).rowCol;
						which[1] = ((Profiles) g).orientation;
						selectedRemoveRC.add(which);
					}
				}
			}

			Object[] hs = selectedDLO.bOpeningObject.mullionsH.toArray();

			if (myFrame2.jobItem.myCanvas.currentRect.width > 0
					&& myFrame2.jobItem.myCanvas.currentRect.height > 0) {
				for (Object g : hs) {
					int[] which2 = new int[2];
					Rectangle2D myRect = null;
					if (((Profiles) g).partForm > 1) {
						Arc2D arcF = new Arc2D.Double(
								((Profiles) g).bkgrdStartX,
								((Profiles) g).bkgrdStartY,
								((Profiles) g).bkgrdWidth,
								((Profiles) g).bkgrdHeight,
								((Profiles) g).startAngle,
								((Profiles) g).endAngle, Arc2D.OPEN);

						myRect = arcF.getBounds2D();
					}

					final double thick = selectedDLO.gridThick
							* myScale.doubleValue();

					if ((((Profiles) g).partForm == 1 && ((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect))
							|| (((Profiles) g).partForm > 1
									&& myRect != null
									&& myRect
											.intersects(myFrame2.jobItem.myCanvas.currentRect) && myRect
									.getMaxY() - thick < selectedDLO.startingY)) {
						which2[0] = ((Profiles) g).rowCol;
						which2[1] = ((Profiles) g).orientation;
						selectedRemoveRC.add(which2);
					}
				}

			} else {
				myFrame2.jobItem.myCanvas.currentRect.x = xxx - 3;
				myFrame2.jobItem.myCanvas.currentRect.y = yyy - 3;
				myFrame2.jobItem.myCanvas.currentRect.width = 6;
				myFrame2.jobItem.myCanvas.currentRect.height = 6;
				for (Object g : hs) {
					int[] which2 = new int[2];
					if (((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect)) {
						which2[0] = ((Profiles) g).rowCol;
						which2[1] = ((Profiles) g).orientation;
						selectedRemoveRC.add(which2);
					}
				}
			}

			hs = null;
			vs = null;

		}

		if (op == 10) {

			final Object[] vs = selectedDLO.gridPartsV.toArray();
			if (myFrame2.jobItem.myCanvas.currentRect.width > 0
					&& myFrame2.jobItem.myCanvas.currentRect.height > 0) {
				for (Object g : vs) {
					((Profiles) g).poly = ((Profiles) g).doPoly();
					if (((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect)) {
						selectedGridsV.add(g);
					}
				}
			} else {
				for (Object g : vs) {
					if (((Profiles) g).gp.contains(xxx, yyy)) {
						selectedGridsV.add(g);
					}
				}
			}

			Object[] hs = selectedDLO.gridPartsH.toArray();
			if (myFrame2.jobItem.myCanvas.currentRect.width > 0
					&& myFrame2.jobItem.myCanvas.currentRect.height > 0) {
				for (Object g : hs) {
					((Profiles) g).poly = ((Profiles) g).doPoly();
					if (((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect)) {
						selectedGridsH.add(g);
					}
				}
			} else {
				for (Object g : hs) {
					if (((Profiles) g).gp.contains(xxx, yyy)) {
						selectedGridsH.add(g);
					}
				}
			}

			Object[] ss = selectedDLO.gridPartsS.toArray();
			if (myFrame2.jobItem.myCanvas.currentRect.width > 0
					&& myFrame2.jobItem.myCanvas.currentRect.height > 0) {
				for (Object g : ss) {
					((Profiles) g).poly = ((Profiles) g).doPoly();
					if (((Profiles) g).poly
							.intersects(myFrame2.jobItem.myCanvas.currentRect)) {
						selectedGridsS.add(g);
					}
				}
			} else {
				for (Object g : ss) {

					if (((Profiles) g).gp.contains(xxx, yyy)) {
						selectedGridsS.add(g);
					}
				}
			}
		}

		if (found && op > 0) {
			if (op == 1) {
				myFrame2.resetModTextsV = true;
				this.changeMasterW();
				myFrame2.gridOp = 0;
			} else if (op == 2) {
				myFrame2.resetModTextsH = true;
				this.changeMasterH();
				myFrame2.gridOp = 0;
			} else if (op == 3) {
				myFrame2.resetModTextsV = true;
				this.equalizeV();
				myFrame2.gridOp = 0;
			} else if (op == 4) {
				myFrame2.resetModTextsH = true;
				this.equalizeH();
				myFrame2.gridOp = 0;
			} else if (op == 5) {
				myFrame2.resetModTextsV = true;
				this.checkMasterInGrids(xxx, yyy);
				myFrame2.gridOp = 0;
			} else if (op == 6) {
				myFrame2.resetModTextsH = true;
				this.checkMasterInGridsH(xxx, yyy);
				myFrame2.gridOp = 0;
			} else if (op == 7) {
				myFrame2.resetModTextsV = true;
				myFrame2.resetModTextsH = true;
				this.initGridNumberChange(pos, op);
				myFrame2.gridOp = 0;
			} else if (op == 8) {
				myFrame2.resetModTextsV = true;
				myFrame2.resetModTextsH = true;
				this.clearAllGrids();
				myFrame2.gridOp = 0;
			} else if (op == 9) {
				myFrame2.resetModTextsV = true;
				myFrame2.resetModTextsH = true;

				if (myFrame2.jobItem.myCanvas.currentRect.width > 0
						&& myFrame2.jobItem.myCanvas.currentRect.height > 0) {
					this.removeGridNew(pos, op, xxx, yyy);
				} else {
					this.removeGrid(pos, op, xxx, yyy);
				}
				myFrame2.gridOp = 0;
			} else if (op == 10) {
				this.cutGridNew(pos, op, xxx, yyy);

				myFrame2.gridOp = 0;
			}
		}

		// ************************************************************
		// Execute Rules
		// ************************************************************

		// Verticals
		Object[] gridsV = selectedDLO.bOpeningObject.mullions.toArray();
		for (Object grid : gridsV) {
			((ProfileParts) grid).executeRulesMethod("Grid Profile");
			((ProfileParts) grid).executePartRules(true);
		}

		Object[] gridsH = selectedDLO.bOpeningObject.mullionsH.toArray();
		for (Object grid : gridsH) {
			((ProfileParts) grid).executeRulesMethod("Grid Profile");
			((ProfileParts) grid).executePartRules(true);
		}

		Object[] gridsS = selectedDLO.gridPartsS.toArray();
		for (Object grid : gridsS) {
			((ProfileParts) grid).executeRulesMethod("Grid Profile");
			((ProfileParts) grid).executePartRules(true);
		}

		Object[] gridsHub = selectedDLO.gridPartsH.toArray();
		for (Object grid : gridsHub) {
			if (((Profiles) grid).partForm > 1) {
				((ProfileParts) grid).executeRulesMethod("Grid Profile");
				((ProfileParts) grid).executePartRules(true);
			}
		}

		this.buildConnectors(selectedDLO);

		return selectedDLO;
	}

	public void resetAllGrids(final int pos) {

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		removeAllGrids();

		if (pos == 1) {
			this.setAllDLOsIn();
		} else if (pos == 2) {
			this.setAllDLOsMid(false);
		} else if (pos == 3) {
			this.setAllDLOsOut();
		}

	}

	public void removeAllGrids() {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {

			resetDLO(dlo);

			if (inGlass) {
				if (((DLO) dlo).myParentO.myGlassMid != null) {
					Object[] gop = ((DLO) dlo).myParentO.myGlassMid.openings
							.toArray();
					((DLO) dlo).myParentO.myGlassMid.openings.clear();

					for (Object o : gop) {
						if (((OpeningObject) o).dloMid != null) {
							((OpeningObject) o).dloMid = resetDLO(((OpeningObject) o).dloMid);
							if (((DLO) dlo).myParentO.myGlassMid != null) {
								((DLO) dlo).myParentO.myGlassMid.openings
										.add(o);
							}
						}
					}
				}
			}

			DLOs.add(dlo);
		}

	}

	public DLO resetDLO(final Object dlo) {

		((DLO) dlo).gridForm = 0;
		((DLO) dlo).noGridsH = 0;
		((DLO) dlo).noGridsV = 0;
		((DLO) dlo).noGridsS = 0;
		((DLO) dlo).noGridsS = 0;

		if (((DLO) dlo).myParentO.myGlassMid != null) {
			((DLO) dlo).myParentO.myGlassMid.gridType = 0;
			((DLO) dlo).myParentO.myGlassMid.gridID = 0;
			((DLO) dlo).myParentO.myGlassMid.noGridsH = 0;
			((DLO) dlo).myParentO.myGlassMid.noGridsV = 0;
			((DLO) dlo).myParentO.myGlassMid.noGridsS = 0;
			((DLO) dlo).myParentO.myGlassMid.noGridsR = 0;
		}

		((DLO) dlo).gridPartsH.clear();
		((DLO) dlo).gridPartsV.clear();
		((DLO) dlo).gridPartsS.clear();
		((DLO) dlo).bOpeningObject.mullions.clear();
		((DLO) dlo).bOpeningObject.mullionsH.clear();
		((DLO) dlo).bOpeningObject.mullionObjectsH = null;
		((DLO) dlo).bOpeningObject.mullionObjectsV = null;
		((DLO) dlo).gridID = 0;
		((DLO) dlo).gridThick = 0;
		((DLO) dlo).gridType = 0;
		((DLO) dlo).hasGrids = false;
		((DLO) dlo).openings.clear();
		return (DLO) dlo;
	}

	public void clearAllGrids() {

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				((DLO) dlo).gridForm = 0;
				((DLO) dlo).noGridsH = 0;
				((DLO) dlo).noGridsV = 0;
				((DLO) dlo).noGridsS = 0;
				((DLO) dlo).noGridsS = 0;
				((DLO) dlo).gridPartsH.clear();
				((DLO) dlo).gridPartsV.clear();
				((DLO) dlo).gridPartsS.clear();
				((DLO) dlo).bOpeningObject.mullions.clear();
				((DLO) dlo).bOpeningObject.mullionsH.clear();
				((DLO) dlo).gridID = 0;
				((DLO) dlo).gridThick = 0;
				((DLO) dlo).gridType = 0;

				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.gridType = 0;
					((DLO) dlo).myParentO.myGlassMid.gridID = 0;
					((DLO) dlo).myParentO.myGlassMid.noGridsH = 0;
					((DLO) dlo).myParentO.myGlassMid.noGridsV = 0;
					((DLO) dlo).myParentO.myGlassMid.noGridsS = 0;
					((DLO) dlo).myParentO.myGlassMid.noGridsR = 0;
				}

				if (inGlass) {

					Object[] gop = null;

					if (((DLO) dlo).myParentO.myGlassMid != null) {
						gop = ((DLO) dlo).myParentO.myGlassMid.openings
								.toArray();

						((DLO) dlo).myParentO.myGlassMid.gridType = 0;
						((DLO) dlo).myParentO.myGlassMid.gridID = 0;
						((DLO) dlo).myParentO.myGlassMid.noGridsH = 0;
						((DLO) dlo).myParentO.myGlassMid.noGridsV = 0;
						((DLO) dlo).myParentO.myGlassMid.noGridsS = 0;
						((DLO) dlo).myParentO.myGlassMid.noGridsR = 0;
						((DLO) dlo).myParentO.myGlassMid.openings.clear();
					}

					if (gop != null && gop.length > 0) {
						for (Object o : gop) {
							if (((OpeningObject) o).dloMid != null) {
								((OpeningObject) o).dloMid.gridForm = 0;
								((OpeningObject) o).dloMid.noGridsH = 0;
								((OpeningObject) o).dloMid.noGridsV = 0;
								((OpeningObject) o).dloMid.noGridsS = 0;
								((OpeningObject) o).dloMid.noGridsR = 0;

								if (((OpeningObject) o).myGlassMid != null) {
									((OpeningObject) o).myGlassMid.noGridsH = 0;
									((OpeningObject) o).myGlassMid.noGridsV = 0;
									((OpeningObject) o).myGlassMid.noGridsS = 0;
									((OpeningObject) o).myGlassMid.noGridsR = 0;
								}

								((OpeningObject) o).dloMid.gridPartsH.clear();
								((OpeningObject) o).dloMid.gridPartsV.clear();
								((OpeningObject) o).dloMid.gridPartsS.clear();
								((OpeningObject) o).dloMid.bOpeningObject.mullions
										.clear();
								((OpeningObject) o).dloMid.bOpeningObject.mullionsH
										.clear();
								((OpeningObject) o).dloMid.gridID = 0;

								((OpeningObject) o).dloMid.gridThick = 0;
								((OpeningObject) o).dloMid.gridType = 0;

								((OpeningObject) o).myGlassMid.gridType = 0;
								((OpeningObject) o).myGlassMid.gridID = 0;

								if (((DLO) dlo).myParentO.myGlassMid != null) {
									((DLO) dlo).myParentO.myGlassMid.openings
											.add(o);
								}

							}
						}
					}
				}

			}

			DLOs.add(dlo);
		}

		this.setAllDLOsMid(true);

	}

	public Collection getAllDLOsOut() {

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		final Collection DLOs = this.getDLOsOut();

		return DLOs;
	}

	public Collection getDLOsIn() {

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		Collection DLOs = new ArrayList();
		Object[] fs = myDesign.frames.toArray();

		for (Object f : fs) {

			if (((Frame) f).shapeID != 10) {
				Object[] ops = ((Frame) f).openings.toArray();

				for (Object o : ops) {

					if (((OpeningObject) o).contentIn == 1) {
						if (!((OpeningObject) o).unGlazed) {
							DLOs.add(((OpeningObject) o).dloIn);
						}

					} else if (((OpeningObject) o).contentIn == 2) {
						Object[] sashes = ((OpeningObject) o).sashObjectIn.frames
								.toArray();
						for (Object s : sashes) {
							Object[] sops = ((SashLeaf) s).openings.toArray();
							for (Object so : sops) {
								if (!((OpeningObject) so).unGlazed) {
									if (((OpeningObject) so).contentIn == 1) {
										if (!((OpeningObject) so).unGlazed) {
											DLOs.add(((OpeningObject) so).dloIn);
										}

									} else if (((OpeningObject) o).contentIn == 2) {

									}
								}
							}

						}
					}

				}

			}

		}
		return DLOs;
	}

	public Collection getDLOsOut() {

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		final Collection DLOs = new ArrayList();
		final Object[] fs = myDesign.frames.toArray();

		for (final Object f : fs) {
			if (((Frame) f).shapeID != 10) {
				final Object[] ops = ((Frame) f).openings.toArray();

				for (final Object o : ops) {

					if (((OpeningObject) o).contentOut == 1) {
						if (!((OpeningObject) o).unGlazed) {
							DLOs.add(((OpeningObject) o).dloOut);
						}

					} else if (((OpeningObject) o).contentOut == 2) {
						final Object[] sashes = ((OpeningObject) o).sashObjectOut.frames
								.toArray();
						for (final Object s : sashes) {
							final Object[] sops = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sops) {
								if (!((OpeningObject) so).unGlazed) {
									if (((OpeningObject) so).contentOut == 1) {
										if (!((OpeningObject) so).unGlazed) {
											DLOs.add(((OpeningObject) so).dloOut);
										}

									} else if (((OpeningObject) o).contentOut == 2) {

									}
								}
							}

						}
					}

				}

			}

		}
		return DLOs;
	}

	public void getDLOsMid(final int actionType) {

		hardVs.clear();
		hardHs.clear();
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		whichPos = 2;
		DLOs = new ArrayList();

		final Object[] fs = myDesign.frames.toArray();

		setVandH(myDesign);

		for (final Object facet : fs) {

			
			final Object[] fframes = ((Facet) facet).frames.toArray();

			// ((Facet) facet).frames.clear();

			setVandH(((Facet) facet));

			for (final Object f : fframes) {
				if (((Frame) f).shapeID != 10) {
					Object[] ops = ((Frame) f).openings.toArray();

					setVandH(((Frame) f));

					// ((Frame) f).openings.clear();
					for (final Object o : ops) {

						if (((OpeningObject) o).contentMid == 1) {

							// TDL can be unglazed.
							if (!((OpeningObject) o).unGlazed || gridType == 3
									|| gridType == 4) {

								((OpeningObject) o).dloMid.myFrame2 = myFrame2;
								((OpeningObject) o).dloMid.bOpeningObject.myFrame2 = myFrame2;
								((OpeningObject) o).dloMid.gridID = ((OpeningObject) o).myGlassMid.gridID = this.gridID;
								((OpeningObject) o).dloMid.gridType = ((OpeningObject) o).myGlassMid.gridType = this.gridType;

								if (actionType == 1) {
									((OpeningObject) o).dloMid = resetDLO(((OpeningObject) o).dloMid);
								}
								DLOs.add(((OpeningObject) o).dloMid);

							}

						} else if (((OpeningObject) o).contentMid == 2) {
							final Object[] sTypeO = ((OpeningObject) o).sashObjectMid.openings
									.toArray();

							// setVandH(((OpeningObject)
							// o).sashObjectMid);

							for (final Object sTO : sTypeO) {

								if (((OpeningObject) sTO).contentMid == 1) {
									// final Object[] sTops = ((OpeningObject)
									// sTO).openings.toArray();

									// for (final Object sTo : sTops)
									// {
									if (!((OpeningObject) sTO).unGlazed) {
										((OpeningObject) sTO).dloMid.myFrame2 = myFrame2;
										((OpeningObject) sTO).dloMid.bOpeningObject.myFrame2 = myFrame2;
										((OpeningObject) sTO).dloMid.gridID = ((OpeningObject) sTO).myGlassMid.gridID = this.gridID;
										((OpeningObject) sTO).dloMid.gridType = ((OpeningObject) sTO).myGlassMid.gridType = this.gridType;
										if (actionType == 1) {
											((OpeningObject) sTO).dloMid = resetDLO(((OpeningObject) sTO).dloMid);
										}
										DLOs.add(((OpeningObject) sTO).dloMid);
									}
									// ((OpeningObject)
									// o).sashObjectMid.openings.add(sTo);
									// }

								}
								// ((OpeningObject)
								// o).sashObjectMid.openings.add(sTO);
							}

							final Object[] sL = ((OpeningObject) o).sashObjectMid.frames
									.toArray();

							for (final Object l : sL) {
								final Object[] sLo = ((SashLeaf) l).openings
										.toArray();

								setVandH(((SashLeaf) l));

								for (final Object so : sLo) {

									if (!((OpeningObject) so).unGlazed) {

										((OpeningObject) so).dloMid.myFrame2 = myFrame2;
										((OpeningObject) so).dloMid.bOpeningObject.myFrame2 = myFrame2;
										((OpeningObject) so).dloMid.gridID = ((OpeningObject) so).myGlassMid.gridID = this.gridID;
										((OpeningObject) so).dloMid.gridType = ((OpeningObject) so).myGlassMid.gridType = this.gridType;
										if (actionType == 1) {
											((OpeningObject) so).dloMid = resetDLO(((OpeningObject) so).dloMid);
										}
										DLOs.add(((OpeningObject) so).dloMid);
									}
									// ((SashLeaf) l).openings.add(so);
								}
								// ((OpeningObject)
								// o).sashObjectMid.frames.add(l);
							}

						} else if (((OpeningObject) o).contentMid == 3) {
							Object[] frames = ((OpeningObject) o).subFacet.frames
									.toArray();

							setVandH(((OpeningObject) o).subFacet);

							for (final Object ff : frames) {

								ops = ((Frame) ff).openings.toArray();

								// ((Frame)ff).openings.clear();

								for (final Object os : ops) {

									if (((OpeningObject) os).contentMid == 1) {
										if (!((OpeningObject) os).unGlazed) {
											((OpeningObject) os).dloMid.myFrame2 = myFrame2;
											((OpeningObject) os).dloMid.bOpeningObject.myFrame2 = myFrame2;
											((OpeningObject) os).dloMid.gridID = ((OpeningObject) os).myGlassMid.gridID = this.gridID;
											((OpeningObject) os).dloMid.gridType = ((OpeningObject) os).myGlassMid.gridType = this.gridType;
											if (actionType == 1) {
												((OpeningObject) os).dloMid = resetDLO(((OpeningObject) os).dloMid);
											}

											DLOs.add(((OpeningObject) os).dloMid);
										}

									} else if (((OpeningObject) os).contentMid == 2) {
										final Object[] sTypeO = ((OpeningObject) os).sashObjectMid.openings
												.toArray();

										// setVandH(((OpeningObject)
										// os).sashObjectMid);

										for (final Object sTO : sTypeO) {

											if (((OpeningObject) sTO).contentMid == 1) {
												final Object[] sTops = ((OpeningObject) sTO).openings
														.toArray();
												((OpeningObject) sTO).openings
														.clear();
												for (final Object sTo : sTops) {

													if (!((OpeningObject) sTo).unGlazed) {
														((OpeningObject) sTo).dloMid.myFrame2 = myFrame2;
														((OpeningObject) sTo).dloMid.bOpeningObject.myFrame2 = myFrame2;
														((OpeningObject) sTo).dloMid.gridID = ((OpeningObject) sTo).myGlassMid.gridID = this.gridID;
														((OpeningObject) sTo).dloMid.gridType = ((OpeningObject) sTo).myGlassMid.gridType = this.gridType;
														if (actionType == 1) {
															((OpeningObject) sTo).dloMid = resetDLO(((OpeningObject) sTo).dloMid);
														}
														DLOs.add(((OpeningObject) sTo).dloMid);
													}
													// ((OpeningObject)
													// os).sashObjectMid.openings.add(sTo);
												}

											}
											// ((OpeningObject)
											// os).sashObjectMid.openings.add(sTO);
										}

										final Object[] sL = ((OpeningObject) os).sashObjectMid.frames
												.toArray();

										for (final Object l : sL) {
											final Object[] sLo = ((SashLeaf) l).openings
													.toArray();

											setVandH(((SashLeaf) l));

											for (final Object so : sLo) {

												if (!((OpeningObject) so).unGlazed) {

													((OpeningObject) so).dloMid.myFrame2 = myFrame2;
													((OpeningObject) so).dloMid.bOpeningObject.myFrame2 = myFrame2;
													((OpeningObject) so).dloMid.gridID = ((OpeningObject) so).myGlassMid.gridID = this.gridID;
													((OpeningObject) so).dloMid.gridType = ((OpeningObject) so).myGlassMid.gridType = this.gridType;
													if (actionType == 1) {
														((OpeningObject) so).dloMid = resetDLO(((OpeningObject) so).dloMid);
													}
													DLOs.add(((OpeningObject) so).dloMid);
												}
												// ((OpeningObject)
												// os).sashObjectMid.frames.add(so);
											}
											// ((OpeningObject)
											// os).sashObjectMid.frames.add(l);
										}

									}
									// ((Frame)ff).openings.add(os);
								}
								// ((OpeningObject)
								// o).subFacet.frames.add(ff);
							}
						}
						// ((Frame) f).openings.add(o);
					}

				}
				// ((Facet) facet).frames.add(f);
			}// Frames
				// myDesign.frames.add(fs);
		}// facets

	}

	public void setVandH(ShapeObject shape) {

		if (shape.bOpeningObject.mullions.size() > 0) {
			Object[] dV = shape.bOpeningObject.mullions.toArray();
			for (Object d : dV) {
				verticals.add(((Profiles) d));

				addValueToList(hardVs, ((Profiles) d).centerXs);
			}

		}
		if (shape.myParent != null
				&& shape.myParent.bOpeningObject.mullions.size() > 0) {
			Object[] dV = shape.myParent.bOpeningObject.mullions.toArray();
			for (Object d : dV) {
				verticals.add(((Profiles) d));

				addValueToList(hardVs, ((Profiles) d).centerXs);

			}

		}
		if (shape.bOpeningObject.mullionsH.size() > 0) {
			Object[] dV = shape.bOpeningObject.mullionsH.toArray();
			for (Object d : dV) {
				horizontals.add(((Profiles) d));

				addValueToList(hardHs, ((Profiles) d).centerYs);
			}

		}
		if (shape.myParent != null
				&& shape.myParent.bOpeningObject.mullionsH.size() > 0) {

			Object[] dV = shape.myParent.bOpeningObject.mullionsH.toArray();
			for (Object d : dV) {
				horizontals.add(((Profiles) d));

				addValueToList(hardHs, ((Profiles) d).centerYs);

			}
		}
	}

	public void getDLOsMidInFrame(final ShapeObject myFrame) {

		whichPos = 2;
		DLOs = new ArrayList();
		myDesign.frames.toArray();

		// for (final Object f : fs)
		// {
		if (myFrame.shapeID != 10 && myFrame.a_sequenceID == frameSeq) {
			Object[] ops = myFrame.openings.toArray();

			for (final Object o : ops) {

				if (((OpeningObject) o).contentMid == 1) {
					if (!((OpeningObject) o).unGlazed) {
						((OpeningObject) o).dloMid.myFrame2 = myFrame2;
						((OpeningObject) o).dloMid.bOpeningObject.myFrame2 = myFrame2;
						DLOs.add(((OpeningObject) o).dloMid);
					}

				} else if (((OpeningObject) o).contentMid == 2) {
					final Object[] sTypeO = ((OpeningObject) o).sashObjectMid.openings
							.toArray();
					for (final Object sTO : sTypeO) {

						if (((OpeningObject) sTO).contentMid == 1) {
							final Object[] sTops = ((OpeningObject) sTO).openings
									.toArray();
							for (final Object sTo : sTops) {

								if (!((OpeningObject) sTo).unGlazed) {
									((OpeningObject) sTo).dloMid.myFrame2 = myFrame2;
									((OpeningObject) sTo).dloMid.bOpeningObject.myFrame2 = myFrame2;
									DLOs.add(((OpeningObject) sTo).dloMid);
								}

							}

						}

					}

					final Object[] sL = ((OpeningObject) o).sashObjectMid.frames
							.toArray();

					for (final Object l : sL) {
						final Object[] sLo = ((SashLeaf) l).openings.toArray();
						for (final Object so : sLo) {

							if (!((OpeningObject) so).unGlazed) {

								((OpeningObject) so).dloMid.myFrame2 = myFrame2;
								((OpeningObject) so).dloMid.bOpeningObject.myFrame2 = myFrame2;
								DLOs.add(((OpeningObject) so).dloMid);
							}

						}

					}

				} else if (((OpeningObject) o).contentMid == 3) {
					final Object[] frames = ((OpeningObject) o).subFacet.frames
							.toArray();

					for (final Object ff : frames) {

						ops = ((Frame) ff).openings.toArray();

						for (final Object os : ops) {

							if (((OpeningObject) os).contentMid == 1) {
								if (!((OpeningObject) os).unGlazed) {
									((OpeningObject) os).dloMid.myFrame2 = myFrame2;
									((OpeningObject) os).dloMid.bOpeningObject.myFrame2 = myFrame2;
									DLOs.add(((OpeningObject) os).dloMid);
								}

							} else if (((OpeningObject) os).contentMid == 2) {
								final Object[] sTypeO = ((OpeningObject) os).sashObjectMid.openings
										.toArray();
								for (final Object sTO : sTypeO) {

									if (((OpeningObject) sTO).contentMid == 1) {
										final Object[] sTops = ((OpeningObject) sTO).openings
												.toArray();
										for (final Object sTo : sTops) {

											if (!((OpeningObject) sTo).unGlazed) {
												((OpeningObject) sTo).dloMid.myFrame2 = myFrame2;
												((OpeningObject) sTo).dloMid.bOpeningObject.myFrame2 = myFrame2;
												DLOs.add(((OpeningObject) sTo).dloMid);
											}

										}

									}

								}

								final Object[] sL = ((OpeningObject) os).sashObjectMid.frames
										.toArray();

								for (final Object l : sL) {
									final Object[] sLo = ((SashLeaf) l).openings
											.toArray();
									for (final Object so : sLo) {

										if (!((OpeningObject) so).unGlazed) {

											((OpeningObject) so).dloMid.myFrame2 = myFrame2;
											((OpeningObject) so).dloMid.bOpeningObject.myFrame2 = myFrame2;
											DLOs.add(((OpeningObject) so).dloMid);
										}

									}

								}

							}

						}
					}
				}
			}

		}

		// }

	}

	public Collection getAllDLOsIn() {

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		whichPos = 1;
		final Collection DLOs = this.getDLOsIn();

		return DLOs;
	}

	public void setAllDLOsOut() {

		final Object[] mydlos = DLOs.toArray();

		final Object[] fs = myDesign.frames.toArray();

		for (final Object f : fs) {
			if (((Frame) f).shapeID != 10) {
				final Object[] ops = ((Frame) f).openings.toArray();

				((Frame) f).openings.clear();

				for (final Object o : ops) {

					if (((OpeningObject) o).contentOut == 1) {
						if (!((OpeningObject) o).unGlazed) {

							for (final Object dlo : mydlos) {

								if (((OpeningObject) o).dloOut.startingX == ((DLO) dlo).startingX
										&& ((OpeningObject) o).dloOut.bX2 == ((DLO) dlo).bX2
										&& ((OpeningObject) o).dloOut.startingY == ((DLO) dlo).startingY
										&& ((OpeningObject) o).dloOut.bY2 == ((DLO) dlo).bY2
										&& ((OpeningObject) o).dloOut.bX3 == ((DLO) dlo).bX3
										&& ((OpeningObject) o).dloOut.bY3 == ((DLO) dlo).bY3
										&& ((OpeningObject) o).dloOut.bX4 == ((DLO) dlo).bX4
										&& ((OpeningObject) o).dloOut.bY4 == ((DLO) dlo).bY4) {

									((OpeningObject) o).dloOut = (DLO) dlo;
									break;
								}

							}

						}

					} else if (((OpeningObject) o).contentOut == 2) {
						final Object[] sTypeO = ((OpeningObject) o).sashObjectOut.openings
								.toArray();

						((OpeningObject) o).sashObjectOut.openings.clear();
						for (final Object sTO : sTypeO) {

							if (((OpeningObject) sTO).contentOut == 1) {
								final Object[] sTops = ((OpeningObject) sTO).openings
										.toArray();
								for (final Object sTo : sTops) {

									if (!((OpeningObject) sTo).unGlazed) {

										for (final Object dlo : mydlos) {

											if (((OpeningObject) sTo).dloOut.startingX == ((DLO) dlo).startingX
													&& ((OpeningObject) sTo).dloOut.bX2 == ((DLO) dlo).bX2
													&& ((OpeningObject) sTo).dloOut.startingY == ((DLO) dlo).startingY
													&& ((OpeningObject) sTo).dloOut.bY2 == ((DLO) dlo).bY2
													&& ((OpeningObject) sTo).dloOut.bX3 == ((DLO) dlo).bX3
													&& ((OpeningObject) sTo).dloOut.bY3 == ((DLO) dlo).bY3
													&& ((OpeningObject) sTo).dloOut.bX4 == ((DLO) dlo).bX4
													&& ((OpeningObject) sTo).dloOut.bY4 == ((DLO) dlo).bY4) {

												((OpeningObject) sTo).dloOut = (DLO) dlo;
												break;
											}

										}

									}
									((OpeningObject) o).sashObjectOut.openings
											.add(sTo);

								}

							}

						}

						final Object[] sL = ((OpeningObject) o).sashObjectOut.frames
								.toArray();

						for (final Object l : sL) {
							final Object[] sLo = ((SashLeaf) l).openings
									.toArray();
							((SashLeaf) l).openings.clear();

							for (final Object so : sLo) {

								if (!((OpeningObject) so).unGlazed) {
									for (final Object dlo : mydlos) {

										if (((OpeningObject) so).dloOut.startingX == ((DLO) dlo).startingX
												&& ((OpeningObject) so).dloOut.bX2 == ((DLO) dlo).bX2
												&& ((OpeningObject) so).dloOut.startingY == ((DLO) dlo).startingY
												&& ((OpeningObject) so).dloOut.bY2 == ((DLO) dlo).bY2
												&& ((OpeningObject) so).dloOut.bX3 == ((DLO) dlo).bX3
												&& ((OpeningObject) so).dloOut.bY3 == ((DLO) dlo).bY3
												&& ((OpeningObject) so).dloOut.bX4 == ((DLO) dlo).bX4
												&& ((OpeningObject) so).dloOut.bY4 == ((DLO) dlo).bY4) {

											((OpeningObject) so).dloOut = (DLO) dlo;
											break;
										}

									}
								}

								((SashLeaf) l).openings.add(so);
							}

						}

					}

					((Frame) f).openings.add(o);
				}

			}

		}

	}

	/**
	 * Return all DLO's mid from OpeningObject model
	 * 
	 * @param actionType
	 *            , Type action selection
	 * @return Collection
	 */
	public Collection getAllDLOsMid(int actionType) {

		// type: 1 = set Grids 2= add, 0= just do existing

		// Init values for this class properties
		myGrid = myFrame2.gridsPanel.myGrid;
		myDesign = myFrame2.jobItem.design;
		gridID = myGrid.getId();
		gridType = myGrid.getGridTypeId();

		// Preparing scale for current unit of metric
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myScale = myFrame2.metricscale;
		} else {
			myScale = myFrame2.imperialscale;
		}

		// Get all DLO's for Mid
		this.getDLOsMid(actionType);

		if (gridID > 0) {

			this.getGridTypeInDLO(true, null, gridID);

//			if (gridType % 2 != 0 && DLOs.size() > 0) {
//				this.hardVs.clear();
//				this.hardHs.clear();
//			}

			this.findNarrowestDLOsII(gridType);

			this.findShortestDLOsII(gridType);

//			Object[] mydlos = DLOs.toArray();
//			DLOs.clear();
//			for (Object dlo : mydlos) {
//				if (((DLO) dlo).shapeID > 1) {
//					((DLO) dlo).masterH = true;
//					((DLO) dlo).masterW = true;
//				}
//				DLOs.add(dlo);
//			}

			this.setAnchorsWInMaster();
			this.setAnchorsHInMaster();

			// if (gridType % 2 != 0) {

			Object[] mydlos = DLOs.toArray();
			
			this.DLOs.clear();
			this.setAnchorsWInSlave(whichPos, mydlos);

			mydlos = DLOs.toArray();
			this.DLOs.clear();
			this.setAnchorsHInSlave(whichPos, mydlos);

			// }

			mydlos = DLOs.toArray();

			// Clear actual collection for DLO
			this.DLOs.clear();

			for (Object dlo : mydlos) {
				((DLO) dlo).yRows = 1;
				((DLO) dlo).xCols = 1;
				((DLO) dlo).gridPartsS.clear();

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			}
			this.setAllDLOsMid(false);
		} else {
			this.clearDLOs();
			this.setAllDLOsMid(false);
		}

		return DLOs;
	}

	public void recalcGridBOM() {

		Object[] dlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : dlos) {

			((DLO) dlo).clearBomForDLO();

			gridBOMFromDLO(dlo);

			DLOs.add(dlo);
		}
	}

	public void gridBOMFromDLO(Object dlo) {

		if (inOpening || inGlass) {

			Object[] spokes = ((DLO) dlo).gridPartsS.toArray();
			for (Object spoke : spokes) {
				this.myFrame2.jobItem.bom.addAll(this.resetRecalcMullionBom(
						((Profiles) spoke), (DLO) dlo));

			}

			Object[] rads = ((DLO) dlo).gridPartsH.toArray();
			for (Object rad : rads) {

				if (((Profiles) rad).partForm > 1) {
					this.myFrame2.jobItem.bom
							.addAll(this.resetRecalcMullionBom(
									((Profiles) rad), (DLO) dlo));
				}
			}

			Object[] vgs = ((DLO) dlo).bOpeningObject.mullions.toArray();
			for (Object vg : vgs) {
				this.myFrame2.jobItem.bom.addAll(this.resetRecalcMullionBom(
						((Profiles) vg), (DLO) dlo));

			}

			Object[] hgs = ((DLO) dlo).bOpeningObject.mullionsH.toArray();
			for (Object hg : hgs) {
				if (((Profiles) hg).partForm == 1) {
					this.myFrame2.jobItem.bom.addAll(this
							.resetRecalcMullionBom(((Profiles) hg), (DLO) dlo));
				}
			}

			if (((DLO) dlo).lConnectors > 0 || ((DLO) dlo).tConnectors > 0
					|| ((DLO) dlo).crossConnectors > 0) {
				this.myFrame2.jobItem.bom.addAll(this
						.resetRecalcConnectorsBom((DLO) dlo));
			}

		}
	}

	public void setAllDLOsMid(final boolean fromChange) {

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {
			if (fromChange) {
				if (((DLO) dlo).startingX == selectedDLO.startingX
						&& ((DLO) dlo).bX2 == selectedDLO.bX2
						&& ((DLO) dlo).startingY == selectedDLO.startingY
						&& ((DLO) dlo).bY2 == selectedDLO.bY2
						&& ((DLO) dlo).bX3 == selectedDLO.bX3
						&& ((DLO) dlo).bY3 == selectedDLO.bY3
						&& ((DLO) dlo).bX4 == selectedDLO.bX4
						&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
					this.setDLOMullionsStartEndPos(dlo);
					this.setOpeningDLO(dlo);
					this.setDLOLites(dlo);
					this.setTDLs(dlo);

				}
			} else {
				this.setDLOMullionsStartEndPos(dlo);
				this.setOpeningDLO(dlo);
				this.setDLOLites(dlo);
				this.setTDLs(dlo);

			}

			((DLO) dlo).executePartRules(true, true,
					"findbiggestdlo.setAllDLOMid.1683");

			DLOs.add(dlo);
		}

		mydlos = DLOs.toArray();

		final Object[] fs = myDesign.frames.toArray();

		myDesign.frames.clear();

		for (final Object facet : fs) {
			final Object[] frames = ((Facet) facet).frames.toArray();

			((Facet) facet).frames.clear();

			for (Object f : frames) {
				if (fromChange) {
					if (((Frame) f).shapeID != 10
							&& ((Frame) f).startingX < selectedDLO.startingX
							&& ((Frame) f).bX2 > selectedDLO.bX2
							&& ((Frame) f).highestY < selectedDLO.highestY

							&& ((Frame) f).bX3 > selectedDLO.bX3
							&& ((Frame) f).bY3 > selectedDLO.bY3
							&& ((Frame) f).bX4 < selectedDLO.bX4
							&& ((Frame) f).bY4 > selectedDLO.bY4) {

						f = this.setDLOinFrame(((Frame) f), mydlos, fromChange);

					}
				} else {
					f = this.setDLOinFrame(((Frame) f), mydlos, fromChange);
				}

				((Facet) facet).frames.add(f);
			}

			myDesign.frames.add(facet);

		}

	}

	public void setAllDLOsIn() {

		final Object[] mydlos = DLOs.toArray();

		final Object[] fs = myDesign.frames.toArray();

		for (final Object f : fs) {
			if (((Frame) f).shapeID != 10) {
				final Object[] ops = ((Frame) f).openings.toArray();

				((Frame) f).openings.clear();

				for (final Object o : ops) {

					if (((OpeningObject) o).contentIn == 1) {
						if (!((OpeningObject) o).unGlazed) {

							for (final Object dlo : mydlos) {

								if (((OpeningObject) o).dloIn.startingX == ((DLO) dlo).startingX
										&& ((OpeningObject) o).dloIn.bX2 == ((DLO) dlo).bX2
										&& ((OpeningObject) o).dloIn.startingY == ((DLO) dlo).startingY
										&& ((OpeningObject) o).dloIn.bY2 == ((DLO) dlo).bY2
										&& ((OpeningObject) o).dloIn.bX3 == ((DLO) dlo).bX3
										&& ((OpeningObject) o).dloIn.bY3 == ((DLO) dlo).bY3
										&& ((OpeningObject) o).dloIn.bX4 == ((DLO) dlo).bX4
										&& ((OpeningObject) o).dloIn.bY4 == ((DLO) dlo).bY4) {

									((OpeningObject) o).dloIn = (DLO) dlo;
									break;
								}

							}

						}

					} else if (((OpeningObject) o).contentIn == 2) {
						final Object[] sTypeO = ((OpeningObject) o).sashObjectIn.openings
								.toArray();

						((OpeningObject) o).sashObjectIn.openings.clear();
						for (final Object sTO : sTypeO) {

							if (((OpeningObject) sTO).contentIn == 1) {
								final Object[] sTops = ((OpeningObject) sTO).openings
										.toArray();
								for (final Object sTo : sTops) {

									if (!((OpeningObject) sTo).unGlazed) {

										for (final Object dlo : mydlos) {

											if (((OpeningObject) sTo).dloIn.startingX == ((DLO) dlo).startingX
													&& ((OpeningObject) sTo).dloIn.bX2 == ((DLO) dlo).bX2
													&& ((OpeningObject) sTo).dloIn.startingY == ((DLO) dlo).startingY
													&& ((OpeningObject) sTo).dloIn.bY2 == ((DLO) dlo).bY2
													&& ((OpeningObject) sTo).dloIn.bX3 == ((DLO) dlo).bX3
													&& ((OpeningObject) sTo).dloIn.bY3 == ((DLO) dlo).bY3
													&& ((OpeningObject) sTo).dloIn.bX4 == ((DLO) dlo).bX4
													&& ((OpeningObject) sTo).dloIn.bY4 == ((DLO) dlo).bY4) {

												((OpeningObject) sTo).dloIn = (DLO) dlo;
												break;
											}

										}

									}
									((OpeningObject) o).sashObjectIn.openings
											.add(sTo);

								}

							}

						}

						final Object[] sL = ((OpeningObject) o).sashObjectIn.frames
								.toArray();

						for (final Object l : sL) {
							final Object[] sLo = ((SashLeaf) l).openings
									.toArray();
							((SashLeaf) l).openings.clear();

							for (final Object so : sLo) {

								if (!((OpeningObject) so).unGlazed) {
									for (final Object dlo : mydlos) {

										if (((OpeningObject) so).dloIn.startingX == ((DLO) dlo).startingX
												&& ((OpeningObject) so).dloIn.bX2 == ((DLO) dlo).bX2
												&& ((OpeningObject) so).dloIn.startingY == ((DLO) dlo).startingY
												&& ((OpeningObject) so).dloIn.bY2 == ((DLO) dlo).bY2
												&& ((OpeningObject) so).dloIn.bX3 == ((DLO) dlo).bX3
												&& ((OpeningObject) so).dloIn.bY3 == ((DLO) dlo).bY3
												&& ((OpeningObject) so).dloIn.bX4 == ((DLO) dlo).bX4
												&& ((OpeningObject) so).dloIn.bY4 == ((DLO) dlo).bY4) {

											((OpeningObject) so).dloIn = (DLO) dlo;
											break;
										}

									}
								}

								((SashLeaf) l).openings.add(so);
							}

						}

					}

					((Frame) f).openings.add(o);
				}

			}

		}

	}

	public Frame setDLOinFrame(final Frame f, final Object[] mydlos,
			final boolean fromChange) {

		final Object[] ops = f.openings.toArray();

		f.openings.clear();

		for (Object o : ops) {

			if (((OpeningObject) o).contentMid == 1) {
				if (!((OpeningObject) o).unGlazed) {

					for (final Object dlo : mydlos) {

						if (((OpeningObject) o).dloMid.startingX == ((DLO) dlo).startingX
								&& ((OpeningObject) o).dloMid.bX2 == ((DLO) dlo).bX2
								&& ((OpeningObject) o).dloMid.startingY == ((DLO) dlo).startingY
								&& ((OpeningObject) o).dloMid.bY2 == ((DLO) dlo).bY2
								&& ((OpeningObject) o).dloMid.bX3 == ((DLO) dlo).bX3
								&& ((OpeningObject) o).dloMid.bY3 == ((DLO) dlo).bY3
								&& ((OpeningObject) o).dloMid.bX4 == ((DLO) dlo).bX4
								&& ((OpeningObject) o).dloMid.bY4 == ((DLO) dlo).bY4) {

							((OpeningObject) o).dloMid = ((OpeningObject) o).dloMid
									.cloneDLO((DLO) dlo);

							// this.cloneDLO(((OpeningObject) o).dloMid,
							// (DLO) dlo);

						}

					}

				}

			} else if (((OpeningObject) o).contentMid == 2) {

				final Object[] sashTypeOs = ((OpeningObject) o).sashObjectMid.openings
						.toArray();

				((OpeningObject) o).sashObjectMid.openings.clear();

				for (final Object sashTypeOpening : sashTypeOs) {

					if (((OpeningObject) sashTypeOpening).contentMid == 1) {

						final Object[] sTops = ((OpeningObject) sashTypeOpening).openings
								.toArray();

						((OpeningObject) sashTypeOpening).openings.clear();

						for (final Object sTo : sTops) {

							if (!((OpeningObject) sTo).unGlazed) {

								for (final Object dlo : mydlos) {

									if (((OpeningObject) sTo).dloMid.startingX == ((DLO) dlo).startingX
											&& ((OpeningObject) sTo).dloMid.bX2 == ((DLO) dlo).bX2
											&& ((OpeningObject) sTo).dloMid.startingY == ((DLO) dlo).startingY
											&& ((OpeningObject) sTo).dloMid.bY2 == ((DLO) dlo).bY2
											&& ((OpeningObject) sTo).dloMid.bX3 == ((DLO) dlo).bX3
											&& ((OpeningObject) sTo).dloMid.bY3 == ((DLO) dlo).bY3
											&& ((OpeningObject) sTo).dloMid.bX4 == ((DLO) dlo).bX4
											&& ((OpeningObject) sTo).dloMid.bY4 == ((DLO) dlo).bY4) {

										((OpeningObject) sTo).dloMid = ((OpeningObject) sTo).dloMid
												.cloneDLO((DLO) dlo);

									}

								}

							}
							((OpeningObject) sashTypeOpening).openings.add(sTo);

						}

					}
					((OpeningObject) o).sashObjectMid.openings
							.add(sashTypeOpening);
				}

				final Object[] sashLeaves = ((OpeningObject) o).sashObjectMid.frames
						.toArray();

				((OpeningObject) o).sashObjectMid.frames.clear();

				for (final Object sash : sashLeaves) {
					final Object[] sashOpenings = ((SashLeaf) sash).openings
							.toArray();
					((SashLeaf) sash).openings.clear();
					for (final Object sashOpening : sashOpenings) {

						if (!((OpeningObject) sashOpening).unGlazed) {

							((OpeningObject) sashOpening).dloMid.myFrame2 = myFrame2;

							for (final Object dlo : mydlos) {

								if (((OpeningObject) sashOpening).dloMid.startingX == ((DLO) dlo).startingX
										&& ((OpeningObject) sashOpening).dloMid.bX2 == ((DLO) dlo).bX2
										&& ((OpeningObject) sashOpening).dloMid.startingY == ((DLO) dlo).startingY
										&& ((OpeningObject) sashOpening).dloMid.bY2 == ((DLO) dlo).bY2
										&& ((OpeningObject) sashOpening).dloMid.bX3 == ((DLO) dlo).bX3
										&& ((OpeningObject) sashOpening).dloMid.bY3 == ((DLO) dlo).bY3
										&& ((OpeningObject) sashOpening).dloMid.bX4 == ((DLO) dlo).bX4
										&& ((OpeningObject) sashOpening).dloMid.bY4 == ((DLO) dlo).bY4) {

									((OpeningObject) sashOpening).dloMid = ((OpeningObject) sashOpening).dloMid
											.cloneDLO((DLO) dlo);

								}

							}

						}
						((SashLeaf) sash).openings.add(sashOpening);
					}
					((OpeningObject) o).sashObjectMid.frames.add(sash);
				}

			} else if (((OpeningObject) o).contentMid == 3) {
				o = doSetSubFrameGrids(f, mydlos, fromChange,
						((OpeningObject) o));
			}

			f.openings.add(o);
		}

		return f;
	}

	public OpeningObject doSetSubFrameGrids(final Frame f,
			final Object[] mydlos, final boolean fromChange,
			final OpeningObject o) {

		final Object[] fs = o.subFacet.frames.toArray();

		o.subFacet.frames.clear();

		for (Object sf : fs) {
			if (fromChange) {
				if (((Frame) sf).shapeID != 10
						&& ((Frame) sf).startingX < selectedDLO.startingX
						&& ((Frame) sf).bX2 > selectedDLO.bX2
						&& ((Frame) sf).highestY < selectedDLO.highestY

						&& ((Frame) sf).bX3 > selectedDLO.bX3
						&& ((Frame) sf).bY3 > selectedDLO.bY3
						&& ((Frame) sf).bX4 < selectedDLO.bX4
						&& ((Frame) sf).bY4 > selectedDLO.bY4) {

					sf = this
							.setDLOinSubFrame(((Frame) sf), mydlos, fromChange);

				}
			} else {
				sf = this.setDLOinSubFrame(((Frame) sf), mydlos, fromChange);
			}

			o.subFacet.frames.add(sf);

		}
		return o;
	}

	public Frame setDLOinSubFrame(final Frame f, final Object[] mydlos,
			final boolean fromChange) {

		Object[] ops = f.openings.toArray();

		f.openings.clear();

		for (Object o : ops) {

			if (((OpeningObject) o).contentMid == 1) {
				if (!((OpeningObject) o).unGlazed) {

					for (final Object dlo : mydlos) {

						if (((OpeningObject) o).dloMid.startingX == ((DLO) dlo).startingX
								&& ((OpeningObject) o).dloMid.bX2 == ((DLO) dlo).bX2
								&& ((OpeningObject) o).dloMid.startingY == ((DLO) dlo).startingY
								&& ((OpeningObject) o).dloMid.bY2 == ((DLO) dlo).bY2
								&& ((OpeningObject) o).dloMid.bX3 == ((DLO) dlo).bX3
								&& ((OpeningObject) o).dloMid.bY3 == ((DLO) dlo).bY3
								&& ((OpeningObject) o).dloMid.bX4 == ((DLO) dlo).bX4
								&& ((OpeningObject) o).dloMid.bY4 == ((DLO) dlo).bY4) {
							((OpeningObject) o).dloMid = ((OpeningObject) o).dloMid
									.cloneDLO((DLO) dlo);
							// this.cloneDLO(((OpeningObject) o).dloMid,
							// (DLO) dlo);

						}

					}

				}

			} else if (((OpeningObject) o).contentMid == 2) {
				final Object[] sTypeO = ((OpeningObject) o).sashObjectMid.openings
						.toArray();

				((OpeningObject) o).sashObjectMid.openings.clear();
				for (final Object sTO : sTypeO) {

					if (((OpeningObject) sTO).contentMid == 1) {
						final Object[] sTops = ((OpeningObject) sTO).openings
								.toArray();
						((OpeningObject) sTO).openings.clear();
						for (final Object sTo : sTops) {

							if (!((OpeningObject) sTo).unGlazed) {

								for (final Object dlo : mydlos) {

									if (((OpeningObject) sTo).dloMid.startingX == ((DLO) dlo).startingX
											&& ((OpeningObject) sTo).dloMid.bX2 == ((DLO) dlo).bX2
											&& ((OpeningObject) sTo).dloMid.startingY == ((DLO) dlo).startingY
											&& ((OpeningObject) sTo).dloMid.bY2 == ((DLO) dlo).bY2
											&& ((OpeningObject) sTo).dloMid.bX3 == ((DLO) dlo).bX3
											&& ((OpeningObject) sTo).dloMid.bY3 == ((DLO) dlo).bY3
											&& ((OpeningObject) sTo).dloMid.bX4 == ((DLO) dlo).bX4
											&& ((OpeningObject) sTo).dloMid.bY4 == ((DLO) dlo).bY4) {

										((OpeningObject) o).dloMid = ((OpeningObject) o).dloMid
												.cloneDLO((DLO) dlo);
										// this.cloneDLO(((OpeningObject)
										// sTo).dloMid, (DLO) dlo);

									}

								}

							}
							((OpeningObject) sTO).openings.add(sTo);

						}

					} else if (((OpeningObject) sTO).contentMid == 2) {

						final Object[] sL = ((OpeningObject) o).sashObjectMid.frames
								.toArray();
						((OpeningObject) o).sashObjectMid.frames.clear();
						for (final Object l : sL) {
							final Object[] sLo = ((SashLeaf) l).openings
									.toArray();
							((SashLeaf) l).openings.clear();

							for (final Object so : sLo) {

								if (!((OpeningObject) so).unGlazed) {
									for (final Object dlo : mydlos) {

										if (((OpeningObject) so).dloMid.startingX == ((DLO) dlo).startingX
												&& ((OpeningObject) so).dloMid.bX2 == ((DLO) dlo).bX2
												&& ((OpeningObject) so).dloMid.startingY == ((DLO) dlo).startingY
												&& ((OpeningObject) so).dloMid.bY2 == ((DLO) dlo).bY2
												&& ((OpeningObject) so).dloMid.bX3 == ((DLO) dlo).bX3
												&& ((OpeningObject) so).dloMid.bY3 == ((DLO) dlo).bY3
												&& ((OpeningObject) so).dloMid.bX4 == ((DLO) dlo).bX4
												&& ((OpeningObject) so).dloMid.bY4 == ((DLO) dlo).bY4) {

											((OpeningObject) o).dloMid = ((OpeningObject) o).dloMid
													.cloneDLO((DLO) dlo);
											// this.cloneDLO(((OpeningObject)
											// so).dloMid, (DLO)
											// dlo);

										}

									}
								}

								((SashLeaf) l).openings.add(so);
							}

							((OpeningObject) o).sashObjectMid.frames.add(l);

						}

					}

					((OpeningObject) o).sashObjectMid.openings.add(sTO);

				}

			}

			f.openings.add(o);
		}

		return f;
	}

	public void setTDLs(final Object dlo) {

		final Object[] oo = ((DLO) dlo).openings.toArray();

		((DLO) dlo).openings.clear();

		for (int ii = 0; ii < oo.length; ii++) {
			((OpeningObject) oo[ii]).contentIn = 0;
			((OpeningObject) oo[ii]).contentMid = 0;
			((OpeningObject) oo[ii]).contentOut = 0;

			((OpeningObject) oo[ii]).glazedOut = true;
			((OpeningObject) oo[ii]).unGlazed = true;
			((OpeningObject) oo[ii]).myGlassIn = null;
			((OpeningObject) oo[ii]).myGlassMid = null;
			((OpeningObject) oo[ii]).myGlassOut = null;
			((OpeningObject) oo[ii]).glazingBeadsIn.clear();
			((OpeningObject) oo[ii]).glazingBeadsMid.clear();
			((OpeningObject) oo[ii]).glazingBeadsOut.clear();

			((DLO) dlo).openings.add(oo[ii]);
		}
	}

	public void setDLOLitesOLD(final Object dlo) {

		final Object[] aws = ((DLO) dlo).bOpeningObject.mullions.toArray();
		final Object[] ahs = ((DLO) dlo).bOpeningObject.mullionsH.toArray();

		if (aws.length > 0 || ahs.length > 0) {
			((DLO) dlo).openings.clear();
		}

		for (int i = 0; i <= aws.length; i++) {
			for (int j = 0; j <= ahs.length; j++) {
				final OpeningObject lite = new OpeningObject(myFrame2);
				lite.myParent = (DLO) dlo;
				if (i == 0) {
					lite.startingX = lite.startingCX = lite.bX4 = lite.bCX4 = ((DLO) dlo).startingX;
					if (aws.length > 0) {
						lite.bX2 = lite.bX3 = ((Profiles) aws[i]).x1;
						lite.bCX2 = lite.bCX3 = ((Profiles) aws[i]).centerXs;
					} else {
						lite.bX2 = lite.bX3 = lite.bCX2 = lite.bCX3 = ((DLO) dlo).bX2;
					}
					lite.startCol = i + 1;
					lite.endCol = i + 1;
					this.checkRow(dlo, ahs, j, lite);

				} else if (i < aws.length) {
					lite.startingX = lite.bX4 = ((Profiles) aws[i - 1]).x2;
					lite.startingCX = lite.bCX4 = ((Profiles) aws[i - 1]).centerXs;
					lite.bX2 = lite.bX3 = ((Profiles) aws[i]).x1;
					lite.bCX2 = lite.bCX3 = ((Profiles) aws[i]).centerXs;
					lite.startCol = i + 1;
					lite.endCol = i + 1;
					this.checkRow(dlo, ahs, j, lite);
				} else {
					lite.startingX = lite.bX4 = ((Profiles) aws[i - 1]).x2;
					lite.startingCX = lite.bCX4 = ((Profiles) aws[i - 1]).centerXs;
					lite.bX2 = lite.bX3 = ((DLO) dlo).bX2;
					lite.bCX2 = lite.bCX3 = ((DLO) dlo).bX2;
					lite.startCol = i + 1;
					lite.endCol = i + 1;
					this.checkRow(dlo, ahs, j, lite);
				}

				lite.widthPix = (int) (Math.max(lite.bX2, lite.bX3) - Math.min(
						lite.startingX, lite.bX4));
				lite.heightPix = (int) (lite.bY4 - lite.highestY);

				lite.a_sequenceID = Integer.parseInt(String
						.valueOf(lite.startRow)
						+ String.valueOf(lite.startCol)
						+ "");

				((DLO) dlo).openings.add(lite);
			}
		}

		((DLO) dlo).xCols = ((DLO) dlo).anchorsV.size() + 1;
		((DLO) dlo).yRows = ((DLO) dlo).anchorsH.size() + 1;
		((DLO) dlo).bOpeningObject.xCols = ((DLO) dlo).anchorsV.size() + 1;
		((DLO) dlo).bOpeningObject.yRows = ((DLO) dlo).anchorsH.size() + 1;
	}

	public void setDLOLites(final Object dlo) {

		final Object[] aws = ((DLO) dlo).gridPartsV.toArray();

		final Object[] ahs = ((DLO) dlo).gridPartsH.toArray();

		if (aws.length > 0 || ahs.length > 0) {
			((DLO) dlo).openings.clear();
		}

		for (int i = 0; i <= aws.length; i++) {

			final OpeningObject lite = new OpeningObject(myFrame2);
			//
			// for (int j = 0; j <= ahs.length; j++)
			// {

			lite.myParent = (DLO) dlo;
			if (i == 0) {
				lite.startingX = lite.startingCX = lite.bX4 = lite.bCX4 = ((DLO) dlo).startingX;
				if (aws.length > 0) {
					lite.bX2 = lite.bX3 = ((Profiles) aws[i]).x1;
					lite.bCX2 = lite.bCX3 = ((Profiles) aws[i]).centerXs;
				} else {
					lite.bX2 = lite.bX3 = lite.bCX2 = lite.bCX3 = ((DLO) dlo).bX2;
				}
				lite.startCol = i + 1;
				lite.endCol = i + 1;
				// this.checkRow(
				// dlo,
				// ahs,
				// j,
				// lite);

			} else if (i < aws.length) {
				lite.startingX = lite.bX4 = ((Profiles) aws[i - 1]).x2;
				lite.startingCX = lite.bCX4 = ((Profiles) aws[i - 1]).centerXs;
				lite.bX2 = lite.bX3 = ((Profiles) aws[i]).x1;
				lite.bCX2 = lite.bCX3 = ((Profiles) aws[i]).centerXs;
				lite.startCol = i + 1;
				lite.endCol = i + 1;
				// this.checkRow(
				// dlo,
				// ahs,
				// j,
				// lite);
			} else {
				lite.startingX = lite.bX4 = ((Profiles) aws[i - 1]).x2;
				lite.startingCX = lite.bCX4 = ((Profiles) aws[i - 1]).centerXs;
				lite.bX2 = lite.bX3 = ((DLO) dlo).bX2;
				lite.bCX2 = lite.bCX3 = ((DLO) dlo).bX2;
				lite.startCol = i + 1;
				lite.endCol = i + 1;
				// this.checkRow(
				// dlo,
				// ahs,
				// j,
				// lite);
			}

			lite.widthPix = (int) (Math.max(lite.bX2, lite.bX3) - Math.min(
					lite.startingX, lite.bX4));
			lite.heightPix = (int) (lite.bY4 - lite.highestY);

			lite.a_sequenceID = Integer.parseInt(String.valueOf(lite.startRow)
					+ String.valueOf(lite.startCol) + "");

			((DLO) dlo).openings.add(lite);
			// }
		}

		((DLO) dlo).xCols = ((DLO) dlo).anchorsV.size() + 1;
		((DLO) dlo).yRows = ((DLO) dlo).anchorsH.size() + 1;
		((DLO) dlo).bOpeningObject.xCols = ((DLO) dlo).anchorsV.size() + 1;
		((DLO) dlo).bOpeningObject.yRows = ((DLO) dlo).anchorsH.size() + 1;
	}

	public void setOpeningDLO(final Object dlo) {

		final Object[] dloo = ((DLO) dlo).openings.toArray();
		((DLO) dlo).openings.clear();
		for (final Object o : dloo) {
			((OpeningObject) o).contentIn = 0;
			((OpeningObject) o).contentMid = 0;
			((OpeningObject) o).contentOut = 0;
			((OpeningObject) o).myGlassIn = null;
			((OpeningObject) o).myGlassMid = null;

			((OpeningObject) o).unGlazed = true;
			((OpeningObject) o).myGlassIn = null;
			((OpeningObject) o).myGlassMid = null;
			((OpeningObject) o).myGlassOut = null;
			((OpeningObject) o).glazingBeadsIn.clear();
			((OpeningObject) o).glazingBeadsMid.clear();
			((OpeningObject) o).glazingBeadsOut.clear();
			((DLO) dlo).openings.add(o);
		}
		if (dloo.length == 1) {
			((DLO) dlo).yRows = 1;
			((DLO) dlo).xCols = 1;
			((DLO) dlo).bOpeningObject.yRows = 1;
			((DLO) dlo).bOpeningObject.xCols = 1;

		}
	}

	public void setDLOMullionsStartEndPos(final Object dlo) {

		if (myGrid.getContinuityIn() == 1 || myGrid.getContinuityIn() == 3) {
			final Object[] myHs = ((DLO) dlo).bOpeningObject.mullionsH
					.toArray();

			final Object[] myVs = ((DLO) dlo).bOpeningObject.mullions.toArray();

			((DLO) dlo).bOpeningObject.mullions.clear();
			((DLO) dlo).bOpeningObject.mullionsH.clear();

			for (final Object myV : myVs) {

				((Profiles) myV).myFrame2 = myFrame2;
				((Profiles) myV).startPos = 1;
				((Profiles) myV).endPos = myHs.length + 1;
				((DLO) dlo).bOpeningObject.mullions.add(myV);

			}

			for (final Object myH : myHs) {
				((Profiles) myH).startPos = 1;
				((Profiles) myH).endPos = myVs.length + 1;
				((Profiles) myH).myFrame2 = myFrame2;
				((DLO) dlo).bOpeningObject.mullionsH.add(myH);

			}
		}
	}

	/**
	 * Creating Grid Parts Mid
	 * 
	 * @param dlo
	 *            , DLO
	 * @return DLO
	 */
	public DLO createGridPartsMid(DLO dlo) {

		dlo.yRows = dlo.anchorsH.size() + 1;
		dlo.xCols = dlo.anchorsV.size() + 1;
		dlo.bOpeningObject.yRows = dlo.yRows;
		dlo.bOpeningObject.xCols = dlo.xCols;

		AddMullionV mV = new AddMullionV(dlo.bOpeningObject, myFrame2.jobItem,
				myFrame2, 7);
		AddMullionH mH = new AddMullionH(dlo.bOpeningObject, myFrame2.jobItem,
				myFrame2, 7);
		// DLOs
		CalculateGridV calcMullion = new CalculateGridV(mV);
		CalculateMullionHii calcMullionH = new CalculateMullionHii(mH);

		if (dlo.bOpeningObject.mullions.size() == 0) {
			dlo = this.doMullionsFromPartsV(dlo);
		}

		if (dlo.bOpeningObject.mullionsH.size() == 0) {
			dlo = this.doMullionsFromPartsH(dlo);
		}

		Object[] myVs = dlo.gridPartsV.toArray();
		dlo.gridPartsV.clear();

		Object[] myHs = dlo.gridPartsH.toArray();
		dlo.gridPartsH.clear();

		Object[] myMasksV = dlo.gridMasksV.toArray();
		dlo.gridMasksV.clear();

		Object[] aV = dlo.anchorsV.toArray();

		Object[] returns = new Object[2];

		boolean doArc = false;

		/* Init vertical Grids */
		dlo = doVGrids(dlo, mV, calcMullion, myVs, myHs, myMasksV, aV);

		// DLOs
		if (dlo.gridForm >= 1) {

			doArc = true;
			dlo = this.removeAddHMullions(dlo, myHs, doArc);

			myHs = dlo.gridPartsH.toArray();

			dlo.gridPartsH.clear();

			// if (myFrame2.compareTwoDoubles(dlo.widthPix / 2, dlo.radius1)) {
			dlo.gridPartsV.clear();
			// }

			myMasksV = dlo.gridMasksV.toArray();

			aV = dlo.anchorsV.toArray();

			resetHPositioninLeg(dlo);

			myHs = dlo.gridPartsH.toArray();

			this.removeAddHMullions(dlo, myHs, doArc);

			dlo = doHGrids(dlo, mH, calcMullionH, myVs, myHs, doArc);

			dlo = doVGridsInHR(dlo, mV, calcMullion);

			// dlo = doVGrids(dlo, mV, calcMullion, myVs, myHs, myMasksV, aV);

			dlo = this.doVsBelowHRGridsNEW(dlo);

			dlo = sortGridPartsV(dlo);

			dlo = doSpokeLogic(dlo);

		} else {
			// Get new anchors in case they changed when Arc was added
			dlo = doHGrids(dlo, mH, calcMullionH, myVs, myHs, doArc);

		}

		dlo.gridPartsS.toArray();

		// Create Full Lenght grids from Segments If Necessary

		if (dlo.gridType % 2 != 0) {
			dlo = this.doMullionsFromPartsV(dlo);
			dlo = this.doMullionsFromPartsH(dlo);
			dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);
		}

		// ************************************************************
		// Execute DLO Rules
		// ************************************************************
		dlo.executePartRules(true);

		// ************************************************************
		// Execute Rules
		// ************************************************************
		executeGridPartRules(dlo);

		return dlo;
	}

	// W != 2*H

	private DLO doVGrids(DLO dlo, AddMullionV mV, CalculateGridV calcMullion,
			Object[] myVs, Object[] myHs, Object[] myMasksV, Object[] aV) {
		int countv = 0;
		int counth = 0;

		// Create individual segements of V Grids to allow cut

		for (Object a : aV) {

			for (Object myV : myVs) {

				if (((Profiles) myV).centerXs == Double.parseDouble(String
						.valueOf(a))) {

					if (dlo.gridType % 2 != 0) {
						counth = 0;
						countv++;

						if (counth == 0 || myHs.length == 0) {
							dlo = this.doFirstV(dlo, mV, calcMullion, myVs,
									myHs, myMasksV, counth, myV);
						}

						if ((myGrid.getContinuityIn() == 2 || myGrid
								.getContinuityIn() == 3)
								&& (!myFrame2.alignH && !myFrame2.alignV)) {
							for (Object myH : myHs) {

								counth++;

								if (counth + 1 < dlo.yRows) {
									dlo = this.doInMidlleV(dlo, mV,
											calcMullion, myVs, myHs, myMasksV,
											myV, myH);

								} else if (counth + 1 == dlo.yRows) {
									dlo = this.doLastV(dlo, mV, calcMullion,
											myVs, myHs, myMasksV, myV, myH);
								}
							}
						} else {
							Collection completedRows = new ArrayList();

							for (Object myH : myHs) {

								if (((Profiles) myH).rowCol + 1 < dlo.yRows
										&& !this.isValueInCollection(
												((Profiles) myH).rowCol,
												completedRows)) {
									dlo = this.doInMidlleV(dlo, mV,
											calcMullion, myVs, myHs, myMasksV,
											myV, myH);
									completedRows.add(((Profiles) myH).rowCol);
								} else if (((Profiles) myH).rowCol + 1 == dlo.yRows
										&& !this.isValueInCollection(
												((Profiles) myH).rowCol,
												completedRows)) {
									dlo = this.doLastV(dlo, mV, calcMullion,
											myVs, myHs, myMasksV, myV, myH);
									completedRows.add(((Profiles) myH).rowCol);
								}
							}
						}

					} else {
						dlo = doFirstVPerimeter(dlo, mV, calcMullion, myVs,
								myHs, myMasksV, counth, myV);
					}

					break;
				}
			}
		}
		return dlo;
	}

	public boolean isValueInCollection(int myInt, Collection intCollection) {
		boolean isIn = false;

		for (Object i : intCollection.toArray()) {
			if (Integer.parseInt(i.toString()) == myInt) {
				isIn = true;
				break;
			}
		}

		return isIn;
	}

	private DLO doHGrids(DLO dlo, AddMullionH mH,
			CalculateMullionHii calcMullionH, Object[] myVs, Object[] myHs,
			boolean doArc) {

		Object[] returns;
		Object[] aH = dlo.anchorsH.toArray();

		int countv = 0;
		int counth = 0;

		// Create individual segements of H Grids to allow cut

		for (Object a : aH) {

			for (Object myH : myHs) {

				if (((Profiles) myH).centerYs == Double.parseDouble(String
						.valueOf(a)) && ((Profiles) myH).partForm == 1) {

					if (dlo.gridType % 2 != 0) {
						countv = 0;
						counth++;

						if (countv == 0 || myVs.length == 0) {
							returns = this.doFirstH(dlo, mH, calcMullionH,
									countv, myH, myVs, myHs, doArc);
							Boolean.parseBoolean(returns[0].toString());
							dlo = (DLO) returns[1];
						}

						Object[] mVMs = dlo.bOpeningObject.mullions.toArray();
						if ((myGrid.getContinuityIn() == 2 || myGrid
								.getContinuityIn() == 3)
								&& (!myFrame2.alignH && !myFrame2.alignV)) {

							for (Object myV : mVMs) {
								countv++;

								if (countv + 1 < dlo.xCols) {

									dlo = this.doInMiddleH(dlo, mH,
											calcMullionH, myVs, myHs, myH, myV);

								} else if (countv + 1 == dlo.xCols) {
									dlo = this.doLastH(dlo, mH, calcMullionH,
											myVs, myHs, myH, myV);
								}
							}
						} else {
							Collection completedRows = new ArrayList();

							for (Object myV : mVMs) {

								if (((Profiles) myV).rowCol + 1 < dlo.xCols
										&& !this.isValueInCollection(
												((Profiles) myV).rowCol,
												completedRows)) {

									dlo = this.doInMiddleH(dlo, mH,
											calcMullionH, myVs, myHs, myH, myV);
									completedRows.add(((Profiles) myV).rowCol);
								} else if (((Profiles) myV).rowCol + 1 == dlo.xCols
										&& !this.isValueInCollection(
												((Profiles) myV).rowCol,
												completedRows)) {
									dlo = this.doLastH(dlo, mH, calcMullionH,
											myVs, myHs, myH, myV);
									completedRows.add(((Profiles) myV).rowCol);
								}
							}
						}

					} else {
						if (((Profiles) myH).partForm > 1) {
							doArc = true;
							dlo = this.doFirstHPerimeter(dlo, mH, calcMullionH,
									countv, myH, myVs, myHs, doArc);
						}
					}
					break;

				} else if (((Profiles) myH).centerYs == Double
						.parseDouble(String.valueOf(a))
						&& ((Profiles) myH).partForm == 2) {
					((Profiles) myH).orientation = 2;
					dlo.gridPartsH.add(myH);
					dlo.noGridsR++;
				}

			}
		}
		return dlo;
	}

	public DLO removeAddHMullions(DLO dlo, Object[] myHs, boolean doArc) {

		if (doArc) {

			Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();

			dlo.bOpeningObject.mullionsH.clear();
			final double thick = dlo.gridThick * myScale.doubleValue();
			double partDimA = 0;
			double partDimB = 0;
			if (myHms.length == 0) {
				partDimB = thick;

			}
			for (final Object myH : myHms) {

				partDimA = ((Profiles) myH).partDimA;
				partDimB = ((Profiles) myH).partDimB;

				if (dlo.top1Part.startAngle < 90
						&& dlo.top1Part.startAngle + dlo.top1Part.endAngle > 90) {// HR/Arch)

					if (dlo.noSides >= 4) {

						if (myFrame2.compareTwoDoubles(dlo.widthPix / 2,
								dlo.radius1)) {// HR

							if (((Profiles) myH).y1 > dlo.startingY) {

								dlo.bOpeningObject.mullionsH.add(myH);

							}

						} else {// Arch

							double firstY = 9999999;

							for (Object hg : myHms) {
								if (firstY > ((Profiles) hg).y2) {
									firstY = ((Profiles) hg).y2;
								}
							}

							if (dlo.startingY > firstY
									&& (((Profiles) myH).y1 > dlo.startingY && ((Profiles) myH).y2 > dlo.startingY)) {

								dlo.bOpeningObject.mullionsH.add(myH);

							} else if (dlo.startingY < firstY) {
								if (((Profiles) myH).y2 > firstY) {
									dlo.bOpeningObject.mullionsH.add(myH);
								}
							}

						}
						((Profiles) myH).isExtra = false;
					} else {
						// 2 sides... there should be nothing to remove.
						// but we need to add the existing Arcs
					}

				} else if (dlo.top1Part.startAngle > 90) {// QRL
					if (dlo.noSides >= 4) {
						if (((Profiles) myH).y1 > dlo.startingY) {
							((Profiles) myH).isExtra = false;

							dlo.bOpeningObject.mullionsH.add(myH);
							partDimA = ((Profiles) myH).partDimA;
							partDimB = ((Profiles) myH).partDimB;
						}
					} else {

					}
				} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR
					if (dlo.noSides >= 4) {
						if (((Profiles) myH).y1 > dlo.bY2) {
							((Profiles) myH).isExtra = false;

							dlo.bOpeningObject.mullionsH.add(myH);
							partDimA = ((Profiles) myH).partDimA;
							partDimB = ((Profiles) myH).partDimB;
						}
					} else {

					}
				}

			}

			myHms = dlo.bOpeningObject.mullionsH.toArray();

			int vSize = (dlo.xCols - 1) / 2;// dlo.bOpeningObject.mullions.size()
											// / 2;
			// if(this.myGrid.getContinuityIn() ==0){
			//
			// vSize = (dlo.bOpeningObject.mullions.size()/dlo.yRows) / 2;
			// }

			if (vSize == 0) {
				vSize = 1;
			}

			// double rH = (dlo.startingY - dlo.highestY)
			// / (dlo.bOpeningObject.mullions.size() / 2 + 1);

			double rH = (dlo.startingY - dlo.highestY) / (vSize + 1);

			if (dlo.top1Part.startAngle > 90) {// QRL
				vSize = (dlo.xCols - 1);// dlo.bOpeningObject.mullions.size();
				rH = (dlo.startingY - dlo.highestY)
						/ (dlo.bOpeningObject.mullions.size() + 1);
			} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR
				vSize = (dlo.xCols - 1);// dlo.bOpeningObject.mullions.size();
				rH = (dlo.bY2 - dlo.highestY)
						/ (dlo.bOpeningObject.mullions.size() + 1);
			}

			for (int i = 0; i < vSize; i++) {

				Profiles myHM = new Profiles();

				myHM.centerYs = myHM.centerYe = dlo.highestY + rH * (i + 1);

				myHM.y1 = myHM.y1al = myHM.y1a = myHM.centerYs + thick / 2;
				myHM.y2 = myHM.y2cl = myHM.y2a = myHM.centerYs - thick / 2;

				myHM.y4 = myHM.y4al = myHM.y4a = myHM.centerYe + thick / 2;
				myHM.y3 = myHM.y3cl = myHM.y3a = myHM.centerYe - thick / 2;

				myHM.partDimA = partDimA;
				myHM.partDimB = partDimB;
				myHM.thickness = thick;
				Profiles vs = new Profiles();
				Profiles ve = new Profiles();
				dlo.bOpeningObject.mullions.size();
				final Object[] mV = dlo.bOpeningObject.mullions.toArray();

				if (dlo.top1Part.startAngle < 90
						&& dlo.top1Part.startAngle + dlo.top1Part.endAngle > 90) {// HR/Arch)

					for (final Object v : mV) {
						if (((Profiles) v).rowCol == i + 1) {
							vs = (Profiles) v;
						}
						if (((Profiles) v).rowCol == dlo.xCols - (i + 1)) {
							ve = (Profiles) v;
						}
					}

					if (vs.x1 == 0) {

						vs.x1 = dlo.startingX + (dlo.startingY - dlo.highestY)
								/ (vSize + 1);
						vs.x2 = vs.x1 + thick;

						ve.x2 = dlo.bX2 - (dlo.startingY - dlo.highestY)
								/ (vSize + 1);
						ve.x1 = vs.x2 - thick;

					}

					myHM = this.doHRNew(dlo, myHM, vs, ve);

					myHM.startPos = i + 1;
					myHM.endPos = dlo.xCols - (i + 1);

				} else if (dlo.top1Part.startAngle > 90) {// QRL
					for (final Object v : mV) {
						if (((Profiles) v).rowCol == i + 1) {
							vs = (Profiles) v;
							break;
						}

					}

					myHM = this.doQRLNew(dlo, myHM, vs);
					myHM.startPos = i + 1;
					myHM.endPos = dlo.xCols;
				} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR

					for (final Object v : mV) {
						if (((Profiles) v).rowCol == dlo.xCols - (i + 1)) {
							vs = (Profiles) v;
							break;
						}

					}

					myHM = this.doQRRNew(dlo, myHM, vs);
					myHM.startPos = i + 1;
					myHM.endPos = dlo.xCols;
				}

				myHM = this.doGeneralPathMullionH(myHM);

				myHM.partForm = 2;

				myHM.startIn = false;

				myHM.endIn = false;

				myHM.posCondition = 1;

				myHM.length = 2 * Math.PI * myHM.radius1
						* Math.max(myHM.endAngle, myHM.endAngleA) / 360;

				myHM.orientation = 2;
				myHM.thickness = partDimB;

				myHM.whichPos = pos;

				myHM.exists = 1;

				myHM.cOrM = 7;
				myHM = doGridsLevels(dlo, myHM);

				myHM.myParent = dlo;

				myHM.myFrame2 = dlo.myFrame2;

				dlo.bOpeningObject.mullionsH.add(myHM);
			}

			dlo.yRows = dlo.bOpeningObject.yRows = dlo.bOpeningObject.mullionsH
					.size() + 1;

			dlo = sortHGridsMullions(dlo, myHs);

		}
		return dlo;
	}

	private DLO doVGridsInHR(DLO dlo, AddMullionV aV, CalculateGridV calcMullion) {
		int counth = 0;
		int countv = 0;

		Profiles myFirstH = new Profiles();

		// if (myFrame2.compareTwoDoubles(dlo.widthPix / 2, dlo.radius1)
		// || myFrame2.compareTwoDoubles(dlo.widthPix, dlo.radius1)) {
		for (Object a : dlo.bOpeningObject.mullionsH.toArray()) {
			if (((Profiles) a).partForm == 1
					&& ((Profiles) a).y1 > Math.max(dlo.startingY, dlo.bY2)) {
				myFirstH = ((Profiles) a);

				doVGridsUnderHR(dlo, aV, calcMullion, myFirstH);

			}

		}

		return dlo;
	}

	private void doVGridsUnderHR(DLO dlo, AddMullionV aV,
			CalculateGridV calcMullion, Profiles myFirstH) {
		if (myFirstH.y2 > 0) {
			for (Object a : dlo.bOpeningObject.mullions.toArray()) {
				Profiles myVM = (Profiles) a;
				double myYC = 0;
				double myY1 = 0;
				double myY2 = 0;
				double myY1a = 0;
				double myY2c = 0;

				if (myFirstH.partForm == 1) {

					myVM.myFrame2 = myFrame2;
					myVM = this.cloneMullion(myVM, (Profiles) myVM);

					myVM.newStartingYCenter = myYC = this.intersectY(
							myVM.centerXs, myVM.centerYs, myVM.centerXe,
							myVM.centerYe, myFirstH.x1, myFirstH.y1,
							myFirstH.x4, myFirstH.y4);

					myVM.newStartingYLB = myY1 = this.intersectY(myVM.x1al,
							myVM.y1al, myVM.x4al, myVM.y4al, myFirstH.x1,
							myFirstH.y1, myFirstH.x4, myFirstH.y4);

					myVM.newStartingYLBa = myY1a = this.intersectY(myVM.x1,
							myVM.y1, myVM.x4, myVM.y4, myFirstH.x1,
							myFirstH.y1, myFirstH.x4, myFirstH.y4);

					myVM.newStartingYRT = myY2 = this.intersectY(myVM.x2,
							myVM.y2, myVM.x3, myVM.y3, myFirstH.x1,
							myFirstH.y1, myFirstH.x4, myFirstH.y4);

					myVM.newStartingYRTc = myY2c = this.intersectY(myVM.x2cl,
							myVM.y2cl, myVM.x3cl, myVM.y3cl, myFirstH.x1,
							myFirstH.y1, myFirstH.x4, myFirstH.y4);

				}

				final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
				final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();
				this.verifyLimitLRV(myVM, dlo, myFirstH.rowCol + 1,
						myFirstH.rowCol + 1, myVM.centerXs, myHms, myVms, aV);

				myVM.startPos = myFirstH.rowCol + 1;
				myVM.endPos = myFirstH.rowCol + 1;

				myVM = calcMullion.calculateCoord(myVM);

				myVM.x1a = myVM.x1 = myVM.x1al;
				myVM.x2a = myVM.x2 = myVM.x2cl;
				myVM.x4a = myVM.x3 = myVM.x4al;
				myVM.x3a = myVM.x4 = myVM.x3cl;

				myVM.y1a = myVM.y1a = myVM.y1b = myVM.y1al;
				myVM.y2a = myVM.y2a = myVM.y2b = myVM.y2cl;
				myVM.y4a = myVM.y3a = myVM.y3b = myVM.y4al;
				myVM.y3a = myVM.y4a = myVM.y4b = myVM.y3cl;
				myVM.ycs = myVM.centerYs;
				myVM.yce = myVM.centerYe;

				final Profiles myNewMullion = this.doGeneralPathMullionH(myVM);

				if (myNewMullion.startPos != 1) {
					myNewMullion.startIn = true;
				} else {
					myNewMullion.startIn = false;
				}
				if (myNewMullion.endPos != dlo.yRows) {
					myNewMullion.endIn = true;
				} else {
					myNewMullion.endIn = false;
				}
				myNewMullion.posCondition = this.getPosCondition(
						myNewMullion.startIn, myNewMullion.endIn);

				for (final Object vp : dlo.gridMasksV.toArray()) {
					if (((Profiles) vp).rowCol == myNewMullion.rowCol
							&& ((Profiles) vp).startPos == myNewMullion.startPos
							&& ((Profiles) vp).endPos == myNewMullion.endPos) {
						myNewMullion.remove = ((Profiles) vp).remove;
					}

				}

				dlo.gridPartsV.add(myNewMullion);

			}
		}
	}

	private DLO doVsBelowHRGridsNEW(DLO dlo) {
		Object[] myHs;
		int oddCol = 0;

		Object[] myHG = dlo.bOpeningObject.mullionsH.toArray();

		// myFirstH = dlo.bot1Part;
		boolean countBelow = false;

		// Find first Horizontal Straight
		Profiles myFirstH = new Profiles();
		Profiles myHRG = new Profiles();
		for (Object hg : myHG) {
			if (((Profiles) hg).partForm == 1
					&& ((Profiles) hg).y2 > dlo.startingY) {
				myFirstH = (Profiles) hg;
				countBelow = true;
				break;
			}
		}
		boolean okShape = true;// 200.201.202.203.
		if (dlo.shapeID >= 200 && dlo.shapeID <= 219) {
			okShape = false;

		}

		if (dlo.noSides > 3 && okShape) {
			for (Object mV : dlo.bOpeningObject.mullions.toArray()) {

				for (Object mH : dlo.bOpeningObject.mullionsH.toArray()) {

					if (((Profiles) mH).partForm > 1) {

						if (((Profiles) mV).rowCol == ((Profiles) mH).startPos) {

							Profiles newSegV = ((Profiles) mV).cloneProfile(
									((Profiles) mV), null);

							newSegV.startPos = newSegV.endPos = ((Profiles) mH).rowCol + 1;

							newSegV = xyIntersectionLeft(newSegV, mH);

							newSegV.y1a = newSegV.y1a = newSegV.y1b = newSegV.y1al;
							newSegV.y2a = newSegV.y2a = newSegV.y2b = newSegV.y2cl;

							newSegV.ycs = newSegV.centerYs = ((newSegV.y1 + newSegV.y2)) / 2;
							newSegV.xcs = newSegV.centerXs = ((newSegV.x1 + newSegV.x2)) / 2;

							doEndOfGrid(dlo, myFirstH, newSegV);

							// break;

						} else if (((Profiles) mV).rowCol < ((Profiles) mH).endPos
								&& ((Profiles) mV).rowCol > ((Profiles) mH).startPos) {

							for (Object hg : myHG) {
								if (((Profiles) hg).partForm > 1) {
									myHRG = (Profiles) hg;

									Profiles newSegV = ((Profiles) mV)
											.cloneProfile(((Profiles) mV), null);

									newSegV.startPos = newSegV.endPos = ((Profiles) myHRG).rowCol + 1;

									final EllipseLineIntersections arcX = new EllipseLineIntersections();

									newSegV.y1 = newSegV.y1a = newSegV.y1al = newSegV.y1b = // pc.getY();
									arcX.getYusingX(newSegV.x1, 0, newSegV.x4,
											0, myHRG.radius1A, myHRG.focal1X,
											myHRG.focal1Y, false);

									newSegV.y2 = newSegV.y2a = newSegV.y2cl = newSegV.y2b = // pc.getY();
									arcX.getYusingX(newSegV.x2, 0, newSegV.x3,
											0, myHRG.radius1A, myHRG.focal1X,
											myHRG.focal1Y, false);

									newSegV.ycs = newSegV.centerYs = arcX
											.getYusingX(newSegV.centerXs, 0,
													newSegV.centerXe, 0,
													myHRG.radius1A,
													myHRG.focal1X,
													myHRG.focal1Y, false);

									doEndOfGrid(dlo, myFirstH, newSegV);
								}
							}
							// break;
						} else if (((Profiles) mV).rowCol == ((Profiles) (Profiles) mH).endPos) {

							Profiles newSegV = ((Profiles) mV).cloneProfile(
									((Profiles) mV), null);

							newSegV.startPos = newSegV.endPos = ((Profiles) mH).rowCol + 1;

							newSegV = xyIntersectionRight(newSegV, mH);

							newSegV.y1a = newSegV.y1a = newSegV.y1b = newSegV.y1al;
							newSegV.y2a = newSegV.y2a = newSegV.y2b = newSegV.y2cl;

							newSegV.ycs = newSegV.centerYs = ((newSegV.y1 + newSegV.y2)) / 2;
							newSegV.xcs = newSegV.centerXs = ((newSegV.x1 + newSegV.x2)) / 2;

							doEndOfGrid(dlo, myFirstH, newSegV);

							break;
						}

					}

				}
			}
		}

		return dlo;
	}

	private void doEndOfGrid(DLO dlo, Profiles myFirstH, Profiles newSegV) {

		if (myFirstH.y2 == 0) {
			newSegV.y4 = newSegV.y4a = newSegV.y4al = newSegV.y4b = this
					.intersectY(newSegV.x1, newSegV.y1, newSegV.x4, newSegV.y4,
							dlo.bX4, dlo.bY4, dlo.bX3, dlo.bY3);

			newSegV.y3 = newSegV.y3a = newSegV.y3cl = newSegV.y3b = this
					.intersectY(newSegV.x2, newSegV.y2, newSegV.x3, newSegV.y3,
							dlo.bX4, dlo.bY4, dlo.bX3, dlo.bY3);
		} else {
			newSegV.y4 = newSegV.y4a = newSegV.y4al = newSegV.y4b = this
					.intersectY(newSegV.x1, newSegV.y1, newSegV.x4, newSegV.y4,
							myFirstH.x2, myFirstH.y2, myFirstH.x3, myFirstH.y3);

			newSegV.y3 = newSegV.y3a = newSegV.y3cl = newSegV.y3b = this
					.intersectY(newSegV.x2, newSegV.y2, newSegV.x3, newSegV.y3,
							myFirstH.x2, myFirstH.y2, myFirstH.x3, myFirstH.y3);
		}

		newSegV.yce = newSegV.centerYe = ((newSegV.y3 + newSegV.y4)) / 2;
		newSegV.xce = newSegV.centerXe = ((newSegV.x3 + newSegV.x4)) / 2;

		newSegV.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		Profiles myNewMullion = new Profiles();

		myNewMullion = this.cloneMullion(myNewMullion, newSegV);

		if (myNewMullion.startPos != 1) {
			myNewMullion.startIn = true;
		} else {
			myNewMullion.startIn = false;
		}
		if (myNewMullion.endPos != dlo.yRows) {
			myNewMullion.endIn = true;
		} else {
			myNewMullion.endIn = false;
		}

		myNewMullion.posCondition = this.getPosCondition(myNewMullion.startIn,
				myNewMullion.endIn);
		Polygon m = new Polygon();

		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		m.addPoint((int) myNewMullion.x2a, (int) myNewMullion.y2a);
		m.addPoint((int) myNewMullion.x3a, (int) myNewMullion.y3a);
		m.addPoint((int) myNewMullion.x4a, (int) myNewMullion.y4a);
		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		myNewMullion.gp.reset();
		myNewMullion.poly.reset();
		myNewMullion.gp.append(m, false);
		myNewMullion.poly = m;

		for (Object vp : dlo.gridMasksV) {
			if (((Profiles) vp).rowCol == myNewMullion.rowCol
					&& ((Profiles) vp).startPos == myNewMullion.startPos
					&& ((Profiles) vp).endPos == myNewMullion.endPos) {
				myNewMullion.remove = ((Profiles) vp).remove;
				break;
			}

		}
		myNewMullion.opDone = false;
		dlo.gridPartsV.add(myNewMullion);

		dlo.gridMasksV.add(myNewMullion);
	}

	private DLO doSpokeLogic(DLO dlo) {
		Object[] myHs = dlo.gridPartsH.toArray();
		if (nS > 0) {

			if (myHs.length > 0) {
				boolean hasHR = false;

				// dlo = this.doFullSpokes(dlo);

				for (Object h : myHs) {
					if (((Profiles) h).isValid && ((Profiles) h).partForm > 1
							&& !cutSpoke) {
						dlo = this.doSpokes(dlo, (Profiles) h, myHs, cutSpoke);
						hasHR = true;
					}
				}
				if (!hasHR) {
					for (Object h : myHs) {
						if (((Profiles) h).partForm == 1 && !cutSpoke
								&& ((Profiles) h).rowCol == 1) {
							dlo = this.doSpokes(dlo, (Profiles) h, myHs,
									cutSpoke);
							hasHR = true;
						}
					}
				}
			}
		}
		return dlo;
	}

	private Profiles xyIntersectionRight(Object v, Object hg) {
		Arc2D arcF = new Arc2D.Double(
				((Profiles) hg).bkgrdStartXA,
				((Profiles) hg).bkgrdStartYA, //
				((Profiles) hg).bkgrdWidthA,
				((Profiles) hg).bkgrdHeightA, //
				((Profiles) hg).startAngleA, ((Profiles) hg).endAngleA,
				Arc2D.OPEN);

		Rectangle2D myRect = arcF.getBounds2D();

		((Profiles) v).y1 = ((Profiles) v).y1al = myRect.getMaxY();
		((Profiles) v).x1 = ((Profiles) v).x1al = myRect.getMaxX();

		arcF = new Arc2D.Double(((Profiles) hg).bkgrdStartX,
				((Profiles) hg).bkgrdStartY, ((Profiles) hg).bkgrdWidth,
				((Profiles) hg).bkgrdHeight, ((Profiles) hg).startAngle,
				((Profiles) hg).endAngle, Arc2D.OPEN);
		myRect = arcF.getBounds2D();

		((Profiles) v).y2 = ((Profiles) v).y2cl = myRect.getMaxY();
		((Profiles) v).x2 = ((Profiles) v).x2cl = myRect.getMaxX();

		arcF = new Arc2D.Double(
				(((Profiles) hg).bkgrdStartX - ((Profiles) hg).bkgrdStartXA) / 2,
				(((Profiles) hg).bkgrdStartY - ((Profiles) hg).bkgrdStartYA) / 2,
				(((Profiles) hg).bkgrdWidth - ((Profiles) hg).bkgrdWidthA) / 2,
				(((Profiles) hg).bkgrdHeight - ((Profiles) hg).bkgrdHeightA) / 2,
				(((Profiles) hg).startAngle - ((Profiles) hg).startAngleA) / 2,
				(((Profiles) hg).endAngle - ((Profiles) hg).endAngleA) / 2,
				Arc2D.OPEN);

		myRect = arcF.getBounds2D();

		((Profiles) v).centerYs = ((((Profiles) v).y2 + ((Profiles) v).y1)) / 2;
		((Profiles) v).centerXs = ((((Profiles) v).x2 + ((Profiles) v).x1)) / 2;

		return (Profiles) v;
	}

	private Profiles xyIntersectionLeft(Object v, Object hg) {
		Arc2D arcF = new Arc2D.Double(((Profiles) hg).bkgrdStartX,
				((Profiles) hg).bkgrdStartY, ((Profiles) hg).bkgrdWidth,
				((Profiles) hg).bkgrdHeight, ((Profiles) hg).startAngle,
				((Profiles) hg).endAngle, Arc2D.OPEN);

		Rectangle2D myRect = arcF.getBounds2D();

		((Profiles) v).y1 = ((Profiles) v).y1al = myRect.getMaxY();
		((Profiles) v).x1 = ((Profiles) v).x1al = myRect.getX();
		// .getMaxX();

		arcF = new Arc2D.Double(((Profiles) hg).bkgrdStartXA,
				((Profiles) hg).bkgrdStartYA, ((Profiles) hg).bkgrdWidthA,
				((Profiles) hg).bkgrdHeightA, ((Profiles) hg).startAngleA,
				((Profiles) hg).endAngleA, Arc2D.OPEN);

		myRect = arcF.getBounds2D();

		((Profiles) v).y2 = ((Profiles) v).y2cl = myRect.getMaxY();
		// .getMaxY();
		((Profiles) v).x2 = ((Profiles) v).x2cl = myRect.getX();
		// .getMaxX();

		arcF = new Arc2D.Double(
				(((Profiles) hg).bkgrdStartXA - ((Profiles) hg).bkgrdStartX) / 2,
				(((Profiles) hg).bkgrdStartYA - ((Profiles) hg).bkgrdStartY) / 2,
				(((Profiles) hg).bkgrdWidthA - ((Profiles) hg).bkgrdWidth) / 2,
				(((Profiles) hg).bkgrdHeightA - ((Profiles) hg).bkgrdHeight) / 2,
				(((Profiles) hg).startAngleA - ((Profiles) hg).startAngle) / 2,
				(((Profiles) hg).endAngleA - ((Profiles) hg).endAngle) / 2,
				Arc2D.OPEN);

		myRect = arcF.getBounds2D();

		((Profiles) v).centerYs = ((((Profiles) v).y2 + ((Profiles) v).y1)) / 2;
		((Profiles) v).centerXs = ((((Profiles) v).x2 + ((Profiles) v).x1)) / 2;

		return (Profiles) v;
	}

	// W != 2*H
	public DLO sortGridPartsV(DLO dlo) {

		Collection byCol = new ArrayList();
		Collection byRow = new ArrayList();
		Object[] mGPV = dlo.gridPartsV.toArray();
		dlo.gridPartsV.clear();
		for (int i = 0; i < dlo.xCols; i++) {
			for (int ii = 0; ii < dlo.yRows; ii++) {
				for (Object v : mGPV) {

					if (((Profiles) v).rowCol == i + 1
							&& (((Profiles) v).startPos == ii + 1 && ((Profiles) v).endPos >= ii + 1)) {

						dlo.gridPartsV.add(v);

					}
				}

			}
		}

		return dlo;
	}

	public DLO sortHGrids(final DLO dlo) {

		Object[] myMs = dlo.gridPartsH.toArray();

		final double[] deltas = new double[myMs.length];
		int count = 0;
		for (final Object m : myMs) {

			deltas[count] = ((Profiles) m).centerYs;
			count++;
			dlo.gridPartsH.add(m);

		}

		Arrays.sort(deltas);

		myMs = dlo.gridPartsH.toArray();
		dlo.gridPartsH.clear();

		for (final Object d : deltas) {
			for (final Object m : myMs) {

				if (Double.parseDouble(d.toString()) == ((Profiles) m).centerYs) {
					dlo.gridPartsH.add(m);
					break;
				}

			}
		}

		myMs = dlo.gridPartsH.toArray();
		final Object[] myMM = dlo.bOpeningObject.mullionsH.toArray();

		dlo.gridPartsH.clear();

		final int[] rows = new int[dlo.bOpeningObject.mullionsH.size()];
		count = 0;
		for (final Object mm : myMM) {
			rows[count] = ((Profiles) mm).rowCol;
			count++;
			for (final Object m : myMs) {

				if (((Profiles) mm).centerYs == ((Profiles) m).centerYs) {
					((Profiles) m).rowCol = ((Profiles) mm).rowCol;
					dlo.gridPartsH.add(m);

				}

			}
		}

		// final Object[] gps = dlo.gridPartsH.toArray();
		// final int myInitSize = dlo.gridPartsH.size();
		// dlo.gridPartsH.clear();
		// int start =1;
		// boolean doneAll = false;
		// for(final Object m : gps) {
		// if(!doneAll) {
		// if(((Profiles) m).partForm == 1) {
		//
		// for(int i = 0; i < rows.length; i++) {
		// start=1;
		// for(final Object mm : gps) {
		//
		// if( (((Profiles) mm).rowCol == rows[i]) &&
		// (((Profiles) mm).partForm == 1)) {
		// ((Profiles) mm).startPos = start;
		// ((Profiles) mm).endPos = start;
		// start++;
		//
		// dlo.gridPartsH.add(mm);
		// if(dlo.gridPartsH.size() == myInitSize) {
		// doneAll=true;
		// }
		// }
		// }
		//
		// }
		// }else {
		// dlo.gridPartsH.add(m);
		// }
		// }else {
		// break;
		// }
		//
		// }
		//
		//

		return dlo;
	}

	public DLO sortHGridsMullions(DLO dlo, final Object[] myHs) {

		Object[] myMs = dlo.bOpeningObject.mullionsH.toArray();
		dlo.bOpeningObject.mullionsH.clear();
		dlo.anchorsH.clear();
		final double[] deltas = new double[myMs.length];
		int count = 0;

		for (final Object m : myMs) {

			deltas[count] = ((Profiles) m).centerYs;
			count++;
			dlo.bOpeningObject.mullionsH.add(m);

		}

		Arrays.sort(deltas);

		myMs = dlo.bOpeningObject.mullionsH.toArray();
		dlo.bOpeningObject.mullionsH.clear();

		for (final Object d : deltas) {
			for (final Object m : myMs) {

				if (Double.parseDouble(d.toString()) == ((Profiles) m).centerYs) {

					dlo.bOpeningObject.mullionsH.add(m);
					dlo.anchorsH.add(((Profiles) m).centerYs);

					break;
				}

			}
		}
		myMs = dlo.bOpeningObject.mullionsH.toArray();
		dlo.bOpeningObject.mullionsH.clear();
		int rc = 1;
		int countInLeg = 0;

		for (final Object m : myMs) {
			((Profiles) m).rowCol = ((Profiles) m).order = rc;

			dlo.bOpeningObject.mullionsH.add(m);

			rc++;

			if (((Profiles) m).y1 > dlo.startingY) {
				countInLeg++;
			}

		}

		dlo.gridPartsH.clear();
		myMs = dlo.bOpeningObject.mullionsH.toArray();

		for (final Object m : myMs) {
			dlo.gridPartsH.add(m);
		}

		double legSize = dlo.lowestY - dlo.startingY;

		/** Recalc pos H within Leg */
		// dlo = resetHPositioninLeg(dlo, countInLeg);

		return dlo;
	}

	private DLO resetHPositioninLeg(DLO dlo) {
		Object[] myMs;
		int countInLeg = 0;
		if (dlo.myFrame2.jobItem.design.xCols == 1 && dlo.noSides == 4) {

			myMs = dlo.bOpeningObject.mullionsH.toArray();
			dlo.bOpeningObject.mullionsH.clear();

			dlo.gridPartsH.clear();

			double myThick = dlo.gridThick * myScale.doubleValue();
			Object[] aH = dlo.anchorsH.toArray();
			dlo.anchorsH.clear();

			double startY = Math.max(dlo.startingY, dlo.bY2) + myThick / 2;
			double midY = 0;

			Collection midYs = new ArrayList();

			double maxY = 0;
			for (Object m : myMs) {

				if (((Profiles) m).partForm > 1) {

					midYs.add(((Profiles) m).bkgrdStartY);
					dlo.bOpeningObject.mullionsH.add(m);

				} else if (((Profiles) m).y2 < Math.max(dlo.startingY, dlo.bY2)) {

					midYs.add(((Profiles) m).centerYs);
					dlo.bOpeningObject.mullionsH.add(m);
				}

			}

			myMs = dlo.bOpeningObject.mullionsH.toArray();

			for (Object ah : aH) {
				for (Object ys : midYs.toArray()) {
					if (Double.valueOf(ys.toString()) - myThick < Double
							.valueOf(ah.toString())
							|| Double.valueOf(ys.toString()) - myThick < Double
									.valueOf(ah.toString()) + myThick) {

						dlo.anchorsH.add(ah);
					}
				}
			}

			double legH = dlo.lowestY - startY;

			boolean ideal = false;
			double myIdealGH = dlo.idealGH * myScale.doubleValue();

			if (phiH) {
				myIdealGH = dlo.idealGW * myScale.doubleValue()
						* 1.61803399999999f;
			}
			if (phiH && reversePhi) {
				myIdealGH = dlo.idealGW * myScale.doubleValue()
						/ 1.61803399999999f;
			}

			int initNoLites = (int) Math.ceil(legH / myIdealGH); // added
			// =1
			double totalThick = myThick * (initNoLites - 1);
			double resultLiteH = (legH - totalThick) / initNoLites;

			if (resultLiteH == myIdealGH) {
				ideal = true;
			} else {

				int countG = 0;
				double lastH = 0;
				double delta = 0;
				double lastDelta = 0;
				int lastNoLites = 0;
				do {
					initNoLites = initNoLites + countG;
					countG++;
					totalThick = myThick * (initNoLites - 1);
					resultLiteH = (legH - totalThick) / initNoLites;

					delta = Math.abs(myIdealGH - resultLiteH);
					lastDelta = Math.abs(myIdealGH - lastH);
					if (delta > lastDelta) {
						resultLiteH = lastH;
						initNoLites = lastNoLites;
						ideal = true;
					} else if (resultLiteH <= myIdealGH) {
						ideal = true;
					} else {
						lastH = resultLiteH;
						lastNoLites = initNoLites;
					}

				} while (!ideal);

				double anchorH = 0;

				totalThick = (initNoLites - 1) * myThick;
				resultLiteH = (legH - totalThick) / initNoLites;
				dlo.liteH = resultLiteH;

				/** Calculate new Anchors in LEG */

				for (int i = 0; i < initNoLites - 1; i++) {

					if (i == 0) {
						anchorH = startY + resultLiteH + myThick / 2;
					} else {
						anchorH = anchorH + myThick / 2 + resultLiteH + myThick
								/ 2;
					}

					Collections.sort(hardHs);

					Object[] ancH = hardHs.toArray();

					hardHs.clear();

					for (final Object aw3 : ancH) {
						if (Double.parseDouble(aw3.toString()) >= startY
								&& Double.parseDouble(aw3.toString()) <= dlo.lowestY) {
							if (Double.parseDouble(aw3.toString()) < startY
									+ dlo.gridRemovalZoneH
									* myScale.doubleValue()
									|| Double.parseDouble(aw3.toString()) > dlo.lowestY
											- dlo.gridRemovalZoneW
											* myScale.doubleValue()) {
								// do not
								// add
							} else {
								addValueToList(hardHs,
										Double.parseDouble(aw3.toString()));
							}
						} else {
							addValueToList(hardHs,
									Double.parseDouble(aw3.toString()));
						}

					}

					Object[] hHs = hardHs.toArray();
					double minDelta = 1000000;
					for (Object hv : hHs) {
						if (Math.abs(anchorH
								- Double.parseDouble(hv.toString())) < minDelta) {
							minDelta = Math.abs(anchorH
									- Double.parseDouble(hv.toString()));
						}
					}

					boolean isNewAnchor = true;

					if (anchorH < startY + dlo.gridRemovalZoneH
							* myScale.doubleValue()
							|| anchorH > dlo.lowestY - dlo.gridRemovalZoneH
									* myScale.doubleValue()) {
						continue;
					} else {

						Profiles grid = new Profiles();

						grid.endTypeLT = 3;
						grid.endTypeRB = 3;

						grid.myFrame2 = myFrame2;
						grid.partForm = 1;
						grid.orientation = 2;
						grid.whichPos = pos;
						grid.partDimB = myThick;
						grid.y1al = grid.y1a = grid.y1 = anchorH + myThick / 2;
						grid.y4al = grid.y4a = grid.y4 = anchorH + myThick / 2;

						grid.y2cl = grid.y2a = grid.y2 = anchorH - myThick / 2;
						grid.y3cl = grid.y3a = grid.y3 = anchorH - myThick / 2;

						double glassToSpacer = 0;
						if (dlo.myFrame2.mySeries.getSeriesUom() == 1) {
							glassToSpacer = UOMConvert.getBigDecimalConversion(
									dlo.myParentGlass.glassToSpacer,
									myFrame2.metricscale, 1);
						} else {
							glassToSpacer = UOMConvert.getBigDecimalConversion(
									dlo.myParentGlass.glassToSpacerImp,
									myFrame2.imperialscale, 1);
						}

						grid.x1al = grid.x1a = grid.x1 = grid.x2cl = grid.x2 = grid.x2a = dlo.myParentGlass.startingX
								+ glassToSpacer;
						grid.x4al = grid.x4a = grid.x4 = grid.x3cl = grid.x3 = grid.x3a = dlo.myParentGlass.bX2
								- glassToSpacer;

						grid.centerXs = dlo.myParentGlass.startingX
								+ glassToSpacer;
						grid.centerXe = dlo.myParentGlass.bX2 - glassToSpacer;

						grid.centerYs = anchorH;
						grid.centerYe = anchorH;
						grid.length = grid.centerXe - grid.centerXs;
						grid.cOrM = 7;
						grid = doGridsLevels(dlo, grid);
						grid.thickness = myThick;
						grid.exists = 1;
						this.doGridPolygon(grid);
						grid.myParent = (DLO) dlo;
						grid.rowCol = i + 1;
						grid.exists = 1;
						grid.startPos = 1;
						grid.endPos = initNoLites;
						grid.isNew = true;
						dlo.gridPartsH.add(grid);

						grid.myFrame2 = myFrame2;
						grid.gridID = dlo.gridID;
						grid.gridTypeID = dlo.gridType;

						dlo.bOpeningObject.mullionsH.add(grid);
						dlo.anchorsH.add(anchorH);

						if (isNewAnchor) {
							addValueToList(hardHs, anchorH);
						}

						dlo.noGridsH++;

						if (dlo.myParentO.myGlassMid != null) {
							dlo.myParentO.myGlassMid.noGridsH = dlo.anchorsH
									.size();
						}

					}
				}

			}
		}

		return dlo;

	}

	public DLO removeVInCurves(final DLO dlo, final double yFirst,
			final double yLast, final double deduct1, final double deduct2,
			final int diff) {

		final Object[] VPs = dlo.gridPartsV.toArray();
		final Object[] myHs = dlo.gridPartsH.toArray();
		dlo.gridPartsV.clear();
		dlo.gridMasksV.clear();
		Profiles myFirstH = null;

		for (final Object hp : myHs) {
			if (dlo.top1Part.startAngle < 90
					&& dlo.top1Part.startAngle + dlo.top1Part.endAngle > 90) {// HR/Arch

				if (((Profiles) hp).y1 > dlo.startingY) {
					myFirstH = (Profiles) hp;
					break;
				}

			} else if (dlo.top1Part.startAngle >= 90) {// QRL

				if (((Profiles) hp).y1 > dlo.startingY) {
					myFirstH = (Profiles) hp;
					break;
				}

			} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR

				if (((Profiles) hp).y1 > dlo.bY2) {
					myFirstH = (Profiles) hp;
					break;
				}
			}

		}

		double x1 = 0;
		double y1 = 0;
		double x4 = 0;
		double y4 = 0;

		if (myFirstH != null) {
			x1 = myFirstH.x1;
			y1 = myFirstH.y1;
			x4 = myFirstH.x4;
			y4 = myFirstH.y4;
		} else {
			if (dlo.top1Part.startAngle < 90
					&& dlo.top1Part.startAngle + dlo.top1Part.endAngle > 90) {
			} else if (dlo.top1Part.startAngle >= 90) {

			} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {

			}

		}

		final Collection rHs = new ArrayList();
		for (final Object h : myHs) {
			if (((Profiles) h).partForm > 1) {
				rHs.add(h);

			}
		}

		for (Object vp : VPs) {

			if (myFirstH != null
					&& ((Profiles) vp).endPos <= myFirstH.rowCol - diff
					&& !((Profiles) vp).opDone) {
				((Profiles) vp).remove = true;

			} else if (myFirstH == null) {
				if (((Profiles) vp).y1 < yFirst && ((Profiles) vp).y4 < yFirst
						|| ((Profiles) vp).y1 < yLast
						&& ((Profiles) vp).y4 < yLast

						&& !((Profiles) vp).opDone) {
					((Profiles) vp).remove = true;

				}

			}
			if (((Profiles) vp).y1 < yFirst && ((Profiles) vp).y4 > yFirst
					|| ((Profiles) vp).y1 < yLast && ((Profiles) vp).y4 > yLast

					&& !((Profiles) vp).opDone) {
				final Object[] hRs = rHs.toArray();
				for (final Object r : hRs) {

					if (((Profiles) vp).x1 == ((Profiles) r).bkgrdStartX
							|| Double.parseDouble(myFrame2.twoDecimal
									.format(((Profiles) vp).x2)) == Double
									.parseDouble(myFrame2.twoDecimal
											.format(((Profiles) r).bkgrdStartX
													+ ((Profiles) r).bkgrdWidth))) {

						((Profiles) vp).remove = false;

						if (dlo.top1Part.startAngle < 90
								&& dlo.top1Part.startAngle
										+ dlo.top1Part.endAngle > 90) {// HR/Arch
							((Profiles) vp).y1 = ((Profiles) vp).y1a = ((Profiles) vp).y1al = ((Profiles) vp).y2 = ((Profiles) vp).y2a = ((Profiles) vp).y2cl = ((Profiles) vp).centerYs = this
									.intersectY(((Profiles) vp).x1,
											((Profiles) vp).y1,
											((Profiles) vp).x4,
											((Profiles) vp).y4, dlo.startingX,
											dlo.startingY, dlo.bX2, dlo.bY2);
							((Profiles) vp).opDone = true;
						} else if (dlo.top1Part.startAngle >= 90) {
							((Profiles) vp).y1 = ((Profiles) vp).y1a = ((Profiles) vp).y1al = ((Profiles) vp).y2 = ((Profiles) vp).y2a = ((Profiles) vp).y2cl = ((Profiles) vp).centerYs = this
									.intersectY(((Profiles) vp).x1,
											((Profiles) vp).y1,
											((Profiles) vp).x4,
											((Profiles) vp).y4, dlo.startingX,
											dlo.startingY, dlo.bX2 + 500,
											dlo.bY2);

							((Profiles) vp).opDone = true;
						} else if (dlo.top1Part.startAngle
								+ dlo.top1Part.endAngle <= 90) {
							((Profiles) vp).y1 = ((Profiles) vp).y1a = ((Profiles) vp).y1al = ((Profiles) vp).y2 = ((Profiles) vp).y2a = ((Profiles) vp).y2cl = ((Profiles) vp).centerYs = this
									.intersectY(((Profiles) vp).x1,
											((Profiles) vp).y1,
											((Profiles) vp).x4,
											((Profiles) vp).y4, dlo.bX2,
											dlo.bY2, 0, dlo.bY2);

							((Profiles) vp).opDone = true;
						}
					} else {
						((Profiles) vp).remove = false;
						((Profiles) vp).y1 = ((Profiles) vp).y1a = ((Profiles) vp).y1al = ((Profiles) vp).y2 = ((Profiles) vp).y2a = ((Profiles) vp).y2cl = ((Profiles) vp).centerYs = this
								.intersectY(((Profiles) vp).x1,
										((Profiles) vp).y1, ((Profiles) vp).x4,
										((Profiles) vp).y4, x1, y1, x4, y4);

						((Profiles) vp).opDone = true;

					}
				}

			}

			vp = this.doGridPolygon(((Profiles) vp));
			dlo.gridPartsV.add(vp);
		}

		myFirstH = null;

		return dlo;
	}

	public DLO doLastV(final DLO dlo, final AddMullionV mV,
			final CalculateGridV calcMullion, final Object[] myVs,
			final Object[] myHs, final Object[] myMasksV, final Object myV,
			final Object myH) {

		Profiles myVM = new Profiles();

		myVM.myFrame2 = myFrame2;
		myVM = this.cloneMullion(myVM, (Profiles) myV);

		mV.newStartingYCenter = this.intersectY(myVM.centerXs, myVM.centerYs,
				myVM.centerXe, myVM.centerYe, ((Profiles) myH).x1,
				((Profiles) myH).y1, ((Profiles) myH).x4, ((Profiles) myH).y4);

		mV.newStartingYLB = this.intersectY(myVM.x1al, myVM.y1al, myVM.x4al,
				myVM.y4al, ((Profiles) myH).x1, ((Profiles) myH).y1,
				((Profiles) myH).x4, ((Profiles) myH).y4);

		mV.newStartingYLBa = this.intersectY(myVM.x1, myVM.y1, myVM.x4,
				myVM.y4, ((Profiles) myH).x1, ((Profiles) myH).y1,
				((Profiles) myH).x4, ((Profiles) myH).y4);

		mV.newStartingYRT = this.intersectY(myVM.x2, myVM.y2, myVM.x3, myVM.y3,
				((Profiles) myH).x1, ((Profiles) myH).y1, ((Profiles) myH).x4,
				((Profiles) myH).y4);

		mV.newStartingYRTc = this.intersectY(myVM.x2cl, myVM.y2cl, myVM.x3cl,
				myVM.y3cl, ((Profiles) myH).x1, ((Profiles) myH).y1,
				((Profiles) myH).x4, ((Profiles) myH).y4);

		final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
		final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();
		this.verifyLimitLRV(myVM, dlo, ((Profiles) myH).rowCol + 1, dlo.yRows,
				myVM.centerXs, myHms, myVms, mV);

		myVM.startPos = ((Profiles) myH).rowCol + 1;
		myVM.endPos = dlo.yRows;

		myVM = calcMullion.calculateCoord(myVM);

		if (myVM.partForm == 1) {
			myVM.length = Math
					.sqrt(Math.pow(
							(Math.max(myVM.centerXe, myVM.centerXs) - Math.min(
									myVM.centerXe, myVM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myVM.centerYe, myVM.centerYs) - Math
											.min(myVM.centerYe, myVM.centerYs)),
									2));
		} else {
			myVM.length = 2 * Math.PI * myVM.radius1
					* Math.max(myVM.endAngle, myVM.endAngleA) / 360;
		}

		myVM.x1a = myVM.x1al;
		myVM.x2a = myVM.x2cl;
		myVM.x4a = myVM.x4al;
		myVM.x3a = myVM.x3cl;

		myVM.y1a = myVM.y1a = myVM.y1b = myVM.y1al;
		myVM.y2a = myVM.y2a = myVM.y2b = myVM.y2cl;
		myVM.y4a = myVM.y3a = myVM.y3b = myVM.y4al;
		myVM.y3a = myVM.y4a = myVM.y4b = myVM.y3cl;
		myVM.ycs = myVM.centerYs;
		myVM.yce = myVM.centerYe;

		final Profiles myNewMullion = this.doGeneralPathMullionH(myVM);
		if (myNewMullion.startPos != 1) {
			myNewMullion.startIn = true;
		} else {
			myNewMullion.startIn = false;
		}
		if (myNewMullion.endPos != dlo.yRows) {
			myNewMullion.endIn = true;
		} else {
			myNewMullion.endIn = false;
		}
		myNewMullion.posCondition = this.getPosCondition(myNewMullion.startIn,
				myNewMullion.endIn);
		for (final Object vp : myMasksV) {
			if (((Profiles) vp).rowCol == myNewMullion.rowCol
					&& ((Profiles) vp).startPos == myNewMullion.startPos
					&& ((Profiles) vp).endPos == myNewMullion.endPos) {
				myNewMullion.remove = ((Profiles) vp).remove;
			}
		}

		dlo.gridPartsV.add(myNewMullion);
		dlo.gridMasksV.add(myNewMullion);

		return dlo;
	}

	public DLO doInMidlleV(final DLO dlo, final AddMullionV mV,
			final CalculateGridV calcMullion, final Object[] myVs,
			final Object[] myHs, final Object[] myMasksV, final Object myV,
			final Object myH) {

		Profiles myVM = new Profiles();

		myVM.myFrame2 = myFrame2;
		myVM = this.cloneMullion(myVM, (Profiles) myV);

		mV.newStartingYCenter = this.intersectY(myVM.centerXs, myVM.centerYs,
				myVM.centerXe, myVM.centerYe, ((Profiles) myH).x1,
				((Profiles) myH).y1, ((Profiles) myH).x4, ((Profiles) myH).y4);

		mV.newStartingYLB = this.intersectY(myVM.x1al, myVM.y1al, myVM.x4al,
				myVM.y4al, ((Profiles) myH).x1, ((Profiles) myH).y1,
				((Profiles) myH).x4, ((Profiles) myH).y4);
		;
		mV.newStartingYLBa = this.intersectY(myVM.x1, myVM.y1, myVM.x4,
				myVM.y4, ((Profiles) myH).x1, ((Profiles) myH).y1,
				((Profiles) myH).x4, ((Profiles) myH).y4);
		;
		mV.newStartingYRT = this.intersectY(myVM.x2, myVM.y2, myVM.x3, myVM.y3,
				((Profiles) myH).x1, ((Profiles) myH).y1, ((Profiles) myH).x4,
				((Profiles) myH).y4);
		;
		mV.newStartingYRTc = this.intersectY(myVM.x2cl, myVM.y2cl, myVM.x3cl,
				myVM.y3cl, ((Profiles) myH).x1, ((Profiles) myH).y1,
				((Profiles) myH).x4, ((Profiles) myH).y4);
		;
		final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
		final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();
		this.verifyLimitLRV(myVM, dlo, ((Profiles) myH).rowCol + 1,
				((Profiles) myH).rowCol + 1, myVM.centerXs, myHms, myVms, mV);

		myVM.startPos = ((Profiles) myH).rowCol + 1;
		myVM.endPos = ((Profiles) myH).rowCol + 1;

		myVM = calcMullion.calculateCoord(myVM);

		myVM.x1a = myVM.x1 = myVM.x1al;
		myVM.x2a = myVM.x2 = myVM.x2cl;
		myVM.x4a = myVM.x3 = myVM.x4al;
		myVM.x3a = myVM.x4 = myVM.x3cl;

		myVM.y1a = myVM.y1a = myVM.y1b = myVM.y1al;
		myVM.y2a = myVM.y2a = myVM.y2b = myVM.y2cl;
		myVM.y4a = myVM.y3a = myVM.y3b = myVM.y4al;
		myVM.y3a = myVM.y4a = myVM.y4b = myVM.y3cl;
		myVM.ycs = myVM.centerYs;
		myVM.yce = myVM.centerYe;

		if (myVM.partForm == 1) {
			myVM.length = Math
					.sqrt(Math.pow(
							(Math.max(myVM.centerXe, myVM.centerXs) - Math.min(
									myVM.centerXe, myVM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myVM.centerYe, myVM.centerYs) - Math
											.min(myVM.centerYe, myVM.centerYs)),
									2));
		} else {
			myVM.length = 2 * Math.PI * myVM.radius1
					* Math.max(myVM.endAngle, myVM.endAngleA) / 360;
		}

		final Profiles myNewMullion = this.doGeneralPathMullionH(myVM);
		if (myNewMullion.startPos != 1) {
			myNewMullion.startIn = true;
		} else {
			myNewMullion.startIn = false;
		}
		if (myNewMullion.endPos != dlo.yRows) {
			myNewMullion.endIn = true;
		} else {
			myNewMullion.endIn = false;
		}
		myNewMullion.posCondition = this.getPosCondition(myNewMullion.startIn,
				myNewMullion.endIn);

		for (final Object vp : myMasksV) {
			if (((Profiles) vp).rowCol == myNewMullion.rowCol
					&& ((Profiles) vp).startPos == myNewMullion.startPos
					&& ((Profiles) vp).endPos == myNewMullion.endPos) {
				myNewMullion.remove = ((Profiles) vp).remove;
			}

		}

		dlo.gridPartsV.add(myNewMullion);
		dlo.gridMasksV.add(myNewMullion);

		return dlo;
	}

	public DLO doFirstV(DLO dlo, AddMullionV mV, CalculateGridV calcMullion,
			Object[] myVs, Object[] myHs, Object[] myMasksV, int counth,
			Object myV) {

		Profiles myVM = new Profiles();
		myVM.myFrame2 = myFrame2;
		myVM = this.cloneMullion(myVM, (Profiles) myV);

		mV.newStartingXCenter = myVM.centerXs;
		mV.newStartingXLB = myVM.x1;
		mV.newStartingXLBa = myVM.x1al;
		mV.newStartingXRT = myVM.x2;
		mV.newStartingXRTc = myVM.x2cl;

		mV.newStartingYCenter = myVM.centerYs;

		mV.newStartingYLB = myVM.y1;
		mV.newStartingYLBa = myVM.y1al;
		mV.newStartingYRT = myVM.y2;
		mV.newStartingYRTc = myVM.y2cl;

		if (myHs.length == 0) {
			this.verifyLimitLRV(myVM, dlo, 1, dlo.yRows, myVM.centerXs, myHs,
					myVs, mV);
			myVM.startPos = 1;
			myVM.endPos = dlo.yRows;
		} else if (counth == 0 && myHs.length > 0) {

			final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
			final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();

			for (Object myh : myHs) {

				this.verifyLimitLRV(myVM, dlo, ((Profiles) myh).rowCol,
						((Profiles) myh).rowCol, myVM.centerXs, myHms, myVms,
						mV);
				myVM.startPos = 1;
				myVM.endPos = ((Profiles) myh).rowCol;
				break;
			}
		}

		myVM = calcMullion.calculateCoord(myVM);

		myVM.x1a = myVM.x1al;
		myVM.x2a = myVM.x2cl;
		myVM.x4a = myVM.x4al;
		myVM.x3a = myVM.x3cl;

		myVM.y1a = myVM.y1a = myVM.y1b = myVM.y1al;
		myVM.y2a = myVM.y2a = myVM.y2b = myVM.y2cl;
		myVM.y4a = myVM.y3a = myVM.y3b = myVM.y4al;
		myVM.y3a = myVM.y4a = myVM.y4b = myVM.y3cl;
		myVM.ycs = myVM.centerYs;
		myVM.yce = myVM.centerYe;

		myVM.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		if (myVM.partForm == 1) {
			myVM.length = Math
					.sqrt(Math.pow(
							(Math.max(myVM.centerXe, myVM.centerXs) - Math.min(
									myVM.centerXe, myVM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myVM.centerYe, myVM.centerYs) - Math
											.min(myVM.centerYe, myVM.centerYs)),
									2));
		} else {
			myVM.length = 2 * Math.PI * myVM.radius1
					* Math.max(myVM.endAngle, myVM.endAngleA) / 360;
		}

		Profiles myNewMullion = new Profiles();

		myNewMullion = this.cloneMullion(myNewMullion, myVM);

		if (myNewMullion.startPos != 1) {
			myNewMullion.startIn = true;
		} else {
			myNewMullion.startIn = false;
		}
		if (myNewMullion.endPos != dlo.yRows) {
			myNewMullion.endIn = true;
		} else {
			myNewMullion.endIn = false;
		}

		myNewMullion.posCondition = this.getPosCondition(myNewMullion.startIn,
				myNewMullion.endIn);
		Polygon m = new Polygon();

		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		m.addPoint((int) myNewMullion.x2a, (int) myNewMullion.y2a);
		m.addPoint((int) myNewMullion.x3a, (int) myNewMullion.y3a);
		m.addPoint((int) myNewMullion.x4a, (int) myNewMullion.y4a);
		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		myNewMullion.gp.reset();
		myNewMullion.poly.reset();
		myNewMullion.gp.append(m, false);
		myNewMullion.poly = m;

		for (Object vp : myMasksV) {
			if (((Profiles) vp).rowCol == myNewMullion.rowCol
					&& ((Profiles) vp).startPos == myNewMullion.startPos
					&& ((Profiles) vp).endPos == myNewMullion.endPos) {
				myNewMullion.remove = ((Profiles) vp).remove;
				break;
			}

		}
		myNewMullion.opDone = false;
		dlo.gridPartsV.add(myNewMullion);
		dlo.gridMasksV.add(myNewMullion);

		return dlo;
	}

	public DLO doFirstVPerimeter(DLO dlo, final AddMullionV mV,
			final CalculateGridV calcMullion, final Object[] myVs,
			final Object[] myHs, final Object[] myMasksV, final int counth,
			final Object myV) {

		Profiles myVM = new Profiles();
		myVM.myFrame2 = myFrame2;
		myVM = this.cloneMullion(myVM, (Profiles) myV);

		mV.newStartingXCenter = myVM.centerXs;
		mV.newStartingXLB = myVM.x1;
		mV.newStartingXLBa = myVM.x1al;
		mV.newStartingXRT = myVM.x2;
		mV.newStartingXRTc = myVM.x2cl;

		mV.newStartingYCenter = myVM.centerYs;

		mV.newStartingYLB = myVM.y1;
		mV.newStartingYLBa = myVM.y1al;
		mV.newStartingYRT = myVM.y2;
		mV.newStartingYRTc = myVM.y2cl;
		myVM.startPos = 1;
		myVM.endPos = dlo.yRows;

		this.verifyLimitLRV(myVM, dlo, myVM.startPos, myVM.endPos,
				myVM.centerXs, myHs, myVs, mV);

		myVM = calcMullion.calculateCoord(myVM);

		myVM.x1a = myVM.x1al;
		myVM.x2a = myVM.x2cl;
		myVM.x4a = myVM.x4al;
		myVM.x3a = myVM.x3cl;

		myVM.y1a = myVM.y1a = myVM.y1b = myVM.y1al;
		myVM.y2a = myVM.y2a = myVM.y2b = myVM.y2cl;
		myVM.y4a = myVM.y3a = myVM.y3b = myVM.y4al;
		myVM.y3a = myVM.y4a = myVM.y4b = myVM.y3cl;
		myVM.ycs = myVM.centerYs;
		myVM.yce = myVM.centerYe;

		myVM.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		Profiles myNewMullion = new Profiles();
		myNewMullion = this.cloneMullion(myNewMullion, myVM);
		if (myNewMullion.startPos != 1) {
			myNewMullion.startIn = true;
		} else {
			myNewMullion.startIn = false;
		}
		if (myNewMullion.endPos != dlo.yRows) {
			myNewMullion.endIn = true;
		} else {
			myNewMullion.endIn = false;
		}

		if (myNewMullion.partForm == 1) {
			myNewMullion.length = Math
					.sqrt(Math.pow((Math.max(myNewMullion.centerXe,
							myNewMullion.centerXs) - Math.min(
							myNewMullion.centerXe, myNewMullion.centerXs)), 2)
							+ Math.pow((Math.max(myNewMullion.centerYe,
									myNewMullion.centerYs) - Math.min(
									myNewMullion.centerYe,
									myNewMullion.centerYs)), 2));
		} else {
			myNewMullion.length = 2 * Math.PI * myNewMullion.radius1
					* Math.max(myNewMullion.endAngle, myNewMullion.endAngleA)
					/ 360;
		}

		myNewMullion.posCondition = this.getPosCondition(myNewMullion.startIn,
				myNewMullion.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		m.addPoint((int) myNewMullion.x2a, (int) myNewMullion.y2a);
		m.addPoint((int) myNewMullion.x3a, (int) myNewMullion.y3a);
		m.addPoint((int) myNewMullion.x4a, (int) myNewMullion.y4a);
		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		myNewMullion.gp.reset();
		myNewMullion.poly.reset();
		myNewMullion.gp.append(m, false);
		myNewMullion.poly = m;

		for (final Object vp : myMasksV) {
			if (((Profiles) vp).rowCol == myNewMullion.rowCol
					&& ((Profiles) vp).startPos == myNewMullion.startPos
					&& ((Profiles) vp).endPos == myNewMullion.endPos) {
				myNewMullion.remove = ((Profiles) vp).remove;
				break;
			}

		}
		myNewMullion.opDone = false;
		dlo.gridPartsV.add(myNewMullion);
		dlo.gridMasksV.add(myNewMullion);
		dlo = this.doMullionsFromPartsV(dlo);
		dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);
		return dlo;
	}

	public Object[] doFirstH(DLO dlo, final AddMullionH mH,
			final CalculateMullionHii calcMullionH, final int countv,
			final Object myH, final Object[] myVs, final Object[] myHs,
			final boolean doArc) {

		boolean isArc = false;
		final Object returns[] = new Object[2];
		Profiles myHM = new Profiles();

		myHM.myFrame2 = myFrame2;

		myHM = cloneMullion(myHM, (Profiles) myH);

		mH.newStartingXCenter = myHM.centerXs;
		mH.newStartingXLB = myHM.x1;
		mH.newStartingXLBa = myHM.x1al;
		mH.newStartingXRT = myHM.x2;
		mH.newStartingXRTc = myHM.x2cl;

		mH.newStartingYCenter = myHM.centerYs;

		mH.newStartingYLB = myHM.y1;
		mH.newStartingYLBa = myHM.y1al;
		mH.newStartingYRT = myHM.y2;
		mH.newStartingYRTc = myHM.y2cl;

		if (myVs.length == 0) {

			this.verifyLimitLRH(myHM, dlo, 1, dlo.xCols, myHM.centerYs, myHs,
					myVs, mH);

			myHM.startPos = 1;
			myHM.endPos = dlo.xCols;

		} else if (countv == 0 && myVs.length > 0) {

			final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
			final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();

			for (final Object myv : myVs) {

				this.verifyLimitLRH(myHM, dlo, ((Profiles) myv).rowCol,
						((Profiles) myv).rowCol, myHM.centerYs, myHms, myVms,
						mH);

				myHM.startPos = ((Profiles) myv).rowCol;
				myHM.endPos = ((Profiles) myv).rowCol;

				break;
			}

		}
		myHM = calcMullionH.calculateCoord(myHM);

		myHM.x1a = myHM.x1al;
		myHM.x2a = myHM.x2cl;
		myHM.x4a = myHM.x4al;
		myHM.x3a = myHM.x3cl;

		myHM.y1a = myHM.y1a = myHM.y1b = myHM.y1al;
		myHM.y2a = myHM.y2a = myHM.y2b = myHM.y2cl;
		myHM.y4a = myHM.y3a = myHM.y3b = myHM.y4al;
		myHM.y3a = myHM.y4a = myHM.y4b = myHM.y3cl;
		myHM.ycs = myHM.centerYs;
		myHM.yce = myHM.centerYe;

		if (myHM.partForm == 1) {
			myHM.length = Math
					.sqrt(Math.pow(
							(Math.max(myHM.centerXe, myHM.centerXs) - Math.min(
									myHM.centerXe, myHM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myHM.centerYe, myHM.centerYs) - Math
											.min(myHM.centerYe, myHM.centerYs)),
									2));
		} else {
			myHM.length = 2 * Math.PI * myHM.radius1
					* Math.max(myHM.endAngle, myHM.endAngleA) / 360;
		}

		if (myHM.startPos != 1) {
			myHM.startIn = true;
		} else {
			myHM.startIn = false;
		}
		if (myHM.endPos != dlo.yRows) {
			myHM.endIn = true;
		} else {
			myHM.endIn = false;
		}

		myHM.posCondition = this.getPosCondition(myHM.startIn, myHM.endIn);

		isArc = false;
		dlo = this.doHOutsideArch(dlo, myHs, myHM);

		returns[0] = isArc;
		returns[1] = dlo;
		return returns;
	}

	public DLO doFirstHPerimeter(DLO dlo, final AddMullionH mH,
			final CalculateMullionHii calcMullionH, final int countv,
			final Object myH, final Object[] myVs, final Object[] myHs,
			final boolean doArc) {

		Profiles myHM = new Profiles();

		myHM.myFrame2 = myFrame2;

		myHM = this.cloneMullion(myHM, (Profiles) myH);

		myHM.x1a = myHM.x1al;
		myHM.x2a = myHM.x2cl;
		myHM.x4a = myHM.x4al;
		myHM.x3a = myHM.x3cl;

		myHM.y1a = myHM.y1a = myHM.y1b = myHM.y1al;
		myHM.y2a = myHM.y2a = myHM.y2b = myHM.y2cl;
		myHM.y4a = myHM.y3a = myHM.y3b = myHM.y4al;
		myHM.y3a = myHM.y4a = myHM.y4b = myHM.y3cl;
		myHM.ycs = myHM.centerYs;
		myHM.yce = myHM.centerYe;

		if (myHM.partForm == 1) {
			myHM.length = Math
					.sqrt(Math.pow(
							(Math.max(myHM.centerXe, myHM.centerXs) - Math.min(
									myHM.centerXe, myHM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myHM.centerYe, myHM.centerYs) - Math
											.min(myHM.centerYe, myHM.centerYs)),
									2));
		} else {
			myHM.length = 2 * Math.PI * myHM.radius1
					* Math.max(myHM.endAngle, myHM.endAngleA) / 360;
		}

		if (dlo.gridForm >= 1 && doArc) {

			if (mH.inArchL > 0 || mH.inArchR > 0) {

				// myHM.partForm = 2;
				// dlo =
				// this
				// .doHGridArc(
				// dlo,
				// myHM,
				// myHs,
				// true,
				// dlo.gridPartsV
				// .toArray());

			} else {

				dlo = this.doHOutsideArch(dlo, myHs, myHM);
			}

		} else {
			if (dlo.gridType % 2 != 0) {
				dlo = this.doHOutsideArch(dlo, myHs, myHM);
			}
		}

		return dlo;
	}

	public DLO doHOutsideArch(final DLO dlo, final Object[] myHs,
			final Profiles myHM) {

		myHM.x1a = myHM.x1al;
		myHM.x2a = myHM.x2cl;
		myHM.x4a = myHM.x4al;
		myHM.x3a = myHM.x3cl;

		myHM.y1a = myHM.y1a = myHM.y1b = myHM.y1al;
		myHM.y2a = myHM.y2a = myHM.y2b = myHM.y2cl;
		myHM.y4a = myHM.y4a = myHM.y4b = myHM.y4al;
		myHM.y3a = myHM.y3a = myHM.y3b = myHM.y3cl;

		myHM.ycs = myHM.centerYs;
		myHM.yce = myHM.centerYe;

		final Profiles myNewMullion = this.doGeneralPathMullionH(myHM);

		if (myNewMullion.startPos != 1) {
			myNewMullion.startIn = true;
		} else {
			myNewMullion.startIn = false;
		}
		if (myNewMullion.endPos != dlo.xCols) {
			myNewMullion.endIn = true;
		} else {
			myNewMullion.endIn = false;
		}
		myNewMullion.posCondition = this.getPosCondition(myNewMullion.startIn,
				myNewMullion.endIn);

		for (final Object vp : myHs) {
			if (((Profiles) vp).rowCol == myNewMullion.rowCol
					&& ((Profiles) vp).startPos == myNewMullion.startPos
					&& ((Profiles) vp).endPos == myNewMullion.endPos) {
				myNewMullion.remove = ((Profiles) vp).remove;
			}

		}
		dlo.gridPartsH.add(myNewMullion);
		return dlo;
	}

	public DLO doInMiddleH(DLO dlo, AddMullionH mH,
			CalculateMullionHii calcMullionH, Object[] myVs, Object[] myHs,
			Object myH, Object myV) {

		Profiles myHM = new Profiles();
		myHM.myFrame2 = myFrame2;
		myHM = this.cloneMullion(myHM, (Profiles) myH);
		mH.newStartingXCenter = ((Profiles) myV).x1;

		mH.newStartingXLB = ((Profiles) myV).x1;
		mH.newStartingXLBa = ((Profiles) myV).x1;
		mH.newStartingXRT = ((Profiles) myV).x1;
		mH.newStartingXRTc = ((Profiles) myV).x1;
		final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
		final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();
		this.verifyLimitLRH(myHM, dlo, ((Profiles) myV).rowCol + 1,
				((Profiles) myV).rowCol + 1, myHM.centerYs, myHms, myVms, mH);

		myHM.startPos = ((Profiles) myV).rowCol + 1;
		myHM.endPos = ((Profiles) myV).rowCol + 1;

		myHM = calcMullionH.calculateCoord(myHM);

		myHM.x1a = myHM.x1al;
		myHM.x2a = myHM.x2cl;
		myHM.x4a = myHM.x4al;
		myHM.x3a = myHM.x3cl;

		myHM.y1a = myHM.y1a = myHM.y1b = myHM.y1al;
		myHM.y2a = myHM.y2a = myHM.y2b = myHM.y2cl;
		myHM.y4a = myHM.y3a = myHM.y3b = myHM.y4al;
		myHM.y3a = myHM.y4a = myHM.y4b = myHM.y3cl;
		myHM.ycs = myHM.centerYs;
		myHM.yce = myHM.centerYe;

		if (myHM.partForm == 1) {
			myHM.length = Math
					.sqrt(Math.pow(
							(Math.max(myHM.centerXe, myHM.centerXs) - Math.min(
									myHM.centerXe, myHM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myHM.centerYe, myHM.centerYs) - Math
											.min(myHM.centerYe, myHM.centerYs)),
									2));
		} else {
			myHM.length = 2 * Math.PI * myHM.radius1
					* Math.max(myHM.endAngle, myHM.endAngleA) / 360;
		}

		dlo = this.doHOutsideArch(dlo, myHs, myHM);
		return dlo;
	}

	public DLO doLastH(DLO dlo, final AddMullionH mH,
			final CalculateMullionHii calcMullionH, final Object[] myVs,
			final Object[] myHs, final Object myH, final Object myV) {

		Profiles myHM = new Profiles();
		myHM.myFrame2 = myFrame2;
		myHM = this.cloneMullion(myHM, (Profiles) myH);

		mH.newStartingXCenter = ((Profiles) myV).x1;

		mH.newStartingXLB = ((Profiles) myV).x1;
		mH.newStartingXLBa = ((Profiles) myV).x1;
		mH.newStartingXRT = ((Profiles) myV).x1;
		mH.newStartingXRTc = ((Profiles) myV).x1;
		final Object[] myVms = dlo.bOpeningObject.mullions.toArray();
		final Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();

		this.verifyLimitLRH(myHM, dlo, ((Profiles) myV).rowCol + 1, dlo.xCols,
				myHM.centerYs, myHms, myVms, mH);

		myHM.startPos = ((Profiles) myV).rowCol + 1;
		myHM.endPos = dlo.xCols;

		myHM = calcMullionH.calculateCoord(myHM);

		myHM.x1a = myHM.x1al;
		myHM.x2a = myHM.x2cl;
		myHM.x4a = myHM.x4al;
		myHM.x3a = myHM.x3cl;

		myHM.y1a = myHM.y1a = myHM.y1b = myHM.y1al;
		myHM.y2a = myHM.y2a = myHM.y2b = myHM.y2cl;
		myHM.y4a = myHM.y3a = myHM.y3b = myHM.y4al;
		myHM.y3a = myHM.y4a = myHM.y4b = myHM.y3cl;
		myHM.ycs = myHM.centerYs;
		myHM.yce = myHM.centerYe;

		if (myHM.partForm == 1) {
			myHM.length = Math
					.sqrt(Math.pow(
							(Math.max(myHM.centerXe, myHM.centerXs) - Math.min(
									myHM.centerXe, myHM.centerXs)), 2)
							+ Math.pow(
									(Math.max(myHM.centerYe, myHM.centerYs) - Math
											.min(myHM.centerYe, myHM.centerYs)),
									2));
		} else {
			myHM.length = 2 * Math.PI * myHM.radius1
					* Math.max(myHM.endAngle, myHM.endAngleA) / 360;
		}

		myHM.length = new BigDecimal(myHM.length).divide(new BigDecimal(1), 12,
				BigDecimal.ROUND_UP).doubleValue();
		dlo = this.doHOutsideArch(dlo, myHs, myHM);
		return dlo;
	}

	public DLO doFullSpokes(DLO dlo) {

		myThick = dlo.gridThick * myScale.doubleValue();

		boolean doMidSpoke = true;
		myY = 0;
		myY = dlo.startingY;

		if (myFrame2.gridsPanel.tS.getText().length() > 0
				&& !myFrame2.gridsPanel.tS.getText().isEmpty()) {
			nS = Integer.parseInt(myFrame2.gridsPanel.tS.getText());
		}

		Object[] VPs = dlo.gridPartsS.toArray();

		if (nS != dlo.noGridsS) {
			dlo.gridPartsS.clear();
		}

		if (nS > 0) {

			boolean isOddCol = true;
			final int mycols = dlo.xCols - 1;
			if (mycols % 2 == 0) {
				isOddCol = false;
			}
			boolean isOddS = true;
			if (nS % 2 == 0) {
				isOddS = false;
			}
			if (dlo.top1Part.startAngle >= 90
					|| dlo.top1Part.startAngle + dlo.top1Part.endAngle < 90) {
				isOddCol = false;
			}
			final double m1 = dlo.anchorsV.size() / 2f;

			int midCol = (int) (m1 + 0.5);
			if (dlo.anchorsV.size() % 2 == 0) {
				midCol = 0;
			}

			double angles = (dlo.top1Part.endAngle - dlo.top1Part.startAngle)
					/ (nS + 1);

			// if (dlo.top1Part.startAngle >= 90) {// QRL
			//
			// double a1 = 180 - dlo.top1Part.startAngle
			// - dlo.top1Part.endAngle;
			// a1 = 180 - a1 - dlo.top1Part.startAngle;
			// angles = a1 / (nS + 1);
			//
			// }

			if (isOddCol && isOddS) {

				VPs = dlo.gridPartsV.toArray();
				dlo.gridPartsV.clear();

				for (final Object vp : VPs) {

					if (((Profiles) vp).rowCol == midCol) {
						((Profiles) vp).remove = false;
					}
					dlo.gridPartsV.add(vp);

				}

			}
			int oddS = 0;
			if (isOddS) {
				final double oS = nS / 2f;
				oddS = (int) (oS + 0.5);
			}

			dlo.noGridsS = nS;
			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsS = nS;
			}

			if (dlo.top1Part.startAngle >= 90
					|| dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QR
																				// L
																				// or
																				// R

				midCol = 0;

			}

			if (!myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2)) {// Not HR
				if (dlo.top1Part.startAngle >= 90
						|| dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QR
																					// L
																					// or
																					// R

				} else if (nS < 3) {
					nS = 3;
				}

			}

			for (int s = 0; s < nS; s++) {

				boolean doSpoke = true;
				if (midCol > 0) {
					if (isOddS) {
						if (oddS == s) {
							doSpoke = false;
						}
					}
				}

				if (doSpoke) {

					Profiles spoke = new Profiles();
					spoke.myFrame2 = ((DLO) dlo).myFrame2;

					spoke.partForm = 1;
					spoke.orientation = 1;
					spoke.partDimB = myThick;

					this.doFullLengthSpokes(dlo, myThick, midCol, angles,
							s + 1, spoke);

				} else {

					if (doMidSpoke) {

					}
				}
			}

		}

		return dlo;
	}

	public DLO doSpokes(DLO dlo, Profiles myHM, Object[] myHs, boolean cutspoke) {

		myThick = dlo.gridThick * myScale.doubleValue();

		boolean doMidSpoke = true;
		myY = 0;
		Profiles myFirstH = null;

		for (Object hp : myHs) {
			if (((Profiles) hp).y1 > dlo.startingY
					&& ((Profiles) hp).partForm == 1) {
				myFirstH = (Profiles) hp;
				break;
			}
		}
		if (myHM == null) {

		}

		if (myFirstH == null) {
			myY = dlo.bot1Part.endY;
		} else {
			myY = myFirstH.y2;
		}

		if (myHM.partForm == 1) {
			for (Object h : myHs) {
				if (((Profiles) h).rowCol == 1) {
					myY = ((Profiles) h).y2;
				}
			}
		}

		Object[] VPs = dlo.gridPartsS.toArray();

		if (myFrame2.gridsPanel.tS.getText().length() > 0
				&& !myFrame2.gridsPanel.tS.getText().isEmpty()) {
			nS = Integer.parseInt(myFrame2.gridsPanel.tS.getText());
		}
		if (nS != dlo.noGridsS) {
			dlo.gridPartsS.clear();
		}

		if (nS > 0) {

			boolean isOddCol = true;
			final int mycols = dlo.xCols - 1;
			if (mycols % 2 == 0) {
				isOddCol = false;
			}
			boolean isOddS = true;
			if (nS % 2 == 0) {
				isOddS = false;
			}
			if (dlo.top1Part.startAngle >= 90
					|| dlo.top1Part.startAngle + dlo.top1Part.endAngle < 90) {
				isOddCol = false;
			}
			final double m1 = dlo.anchorsV.size() / 2f;

			int midCol = (int) (m1 + 0.5);
			if (dlo.anchorsV.size() % 2 == 0) {
				midCol = 0;
			}

			double angles = dlo.top1Part.endAngle / (nS + 1);
			if (dlo.top1Part.startAngle >= 90) {// QRL

				double a1 = 180 - dlo.top1Part.startAngle
						- dlo.top1Part.endAngle;
				a1 = 180 - a1 - dlo.top1Part.startAngle;
				angles = a1 / (nS + 1);

			}

			if (isOddCol && isOddS) {

				VPs = dlo.gridPartsV.toArray();
				dlo.gridPartsV.clear();

				for (final Object vp : VPs) {

					if (((Profiles) vp).rowCol == midCol) {
						((Profiles) vp).remove = false;
					}
					dlo.gridPartsV.add(vp);

				}

			}
			int oddS = 0;
			if (isOddS) {
				final double oS = nS / 2f;
				oddS = (int) (oS + 0.5);
			}

			dlo.noGridsS = nS;
			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsS = nS;
			}

			if (dlo.top1Part.startAngle >= 90
					|| dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QR
																				// L
																				// or
																				// R

				midCol = 0;

			}

			if (!myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2)) {// Not HR
				if (dlo.top1Part.startAngle >= 90
						|| dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QR
																					// L
																					// or
																					// R

				} else if (nS < 3) {
					// nS = 3;
				}

			}

			for (int s = nS; s > 0; s--) {
				boolean doSpoke = true;
				if (midCol > 0) {
					if (isOddS) {
						if (oddS == s) {
							doSpoke = false;
						}
					}
				}
				if (doSpoke) {

					Profiles spoke = new Profiles();
					spoke.myFrame2 = dlo.myFrame2;

					spoke.partForm = 1;
					spoke.orientation = 1;
					spoke.partDimB = myThick;

					boolean found = false;

					Object[] mH = dlo.gridPartsH.toArray();
					Profiles myPrevH = dlo.top1Part;
					Profiles myLastH = dlo.top1Part;

					if (myHM.rowCol == 1 && myHM.isValid) {

						this.doSpokesRow1(dlo, myHM, myThick, midCol, angles,
								s, spoke);

						found = true;

					} else if (myHM.rowCol > 1 && myHM.isValid) {

						for (Object h : mH) {
							if (((Profiles) h).isValid
									&& ((Profiles) h).rowCol == myHM.rowCol - 1) {
								myPrevH = (Profiles) h;
								break;
							}

						}

						if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {
							this.doSpokesRowNQRR(dlo, myHM, myThick, midCol,
									angles, s, spoke, myPrevH);

						} else {
							this.doSpokesRowN(dlo, myHM, myThick, midCol,
									angles, s, spoke, myPrevH);
						}
						found = true;
					}

					if (found) {

						if ((myY < dlo.startingY || myHM.rowCol + 1 == dlo.yRows)
								&& dlo.top1Part.startAngle < 90
								&& dlo.top1Part.startAngle
										+ dlo.top1Part.endAngle > 90
						// && !isOddCol
						) {

							if (myFirstH != null) {
								this.doInHubSimple(dlo, myHM, myThick, midCol,
										angles, s, myY, spoke, myFirstH);
							} else {
								this.doInHubSimple(dlo, myHM, myThick, midCol,
										angles, s, myY, spoke, null);
							}

						}
					} else {

						// .

						if (myFirstH != null) {
							this.doSpokesNoGrids(dlo, dlo.top1Part, myThick,
									midCol, angles, s, spoke);
						} else {
							this.doSpokesNoGrids(dlo, dlo.top1Part, myThick,
									midCol, angles, s, spoke);
						}

					}

				} else {

					if (doMidSpoke) {

						Profiles spoke = new Profiles();
						spoke.myFrame2 = dlo.myFrame2;

						spoke.partForm = 1;
						spoke.orientation = 1;
						spoke.partDimB = myThick;

						Profiles mySpoke = new Profiles();
						mySpoke.myFrame2 = dlo.myFrame2;

						boolean found = false;

						if (myHM.rowCol == 1 && myHM.isValid) {
							mySpoke = this.doSpokesRow1MID(dlo, myHM, myThick,
									midCol, angles, s, spoke);

							found = true;

						} else if (myHM.rowCol > 1 && myHM.isValid) {

							Object[] mH = dlo.bOpeningObject.mullionsH
									.toArray();
							Profiles myPrevH = new Profiles();
							for (Object h : mH) {
								if (((Profiles) h).rowCol == myHM.rowCol - 1) {
									myPrevH = (Profiles) h;
									break;
								}
							}
							mySpoke = this.doSpokesRowNMID(dlo, myHM, myThick,
									midCol, angles, s, spoke, myPrevH);

							found = true;

						}
						if (myFrame2.compareTwoDoubles(dlo.widthPix / 2,
								dlo.radius1)
								|| myFrame2.compareTwoDoubles(dlo.widthPix,
										dlo.radius1)) {// HR
							if (found
									&& (myY < dlo.startingY || myHM.rowCol + 1 == dlo.yRows)
									&& dlo.top1Part.startAngle < 90
									&& dlo.top1Part.startAngle
											+ dlo.top1Part.endAngle > 90) {

								this.doInHubMID(dlo, myHM, myThick, midCol,
										angles, s, myY, mySpoke);

							} else {

								this.doInHubMID(dlo, dlo.top1Part, myThick,
										midCol, angles, s, myY, mySpoke);

							}
						}

					}
				}
			}

		}

		return dlo;
	}

	public Profiles doFullLengthSpokes(DLO dlo, double myThick, int midCol,
			double angles, int s, Profiles spoke) {

		double angle1 = 0;
		double baseXDeltaGrid = 0;
		double triangleBase = 0;
		final double thick = dlo.gridThick * myScale.doubleValue();

		if (dlo.top1Part.startAngle >= 90) { // QRL

			angle1 = dlo.top1Part.endAngle + s * angles;

		} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) { // QRR

			angle1 = dlo.top1Part.startAngle + s * angles;

		} else {

			if (myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2)
					|| (dlo.noSides == 4 && dlo.top1Part.partForm > 1)
					|| dlo.noSides == 2) { // HR

				// angle1 = (180 - dlo.top1Part.startAngle -
				// dlo.top1Part.endAngle)
				// + (s * angles);

				angle1 = dlo.top1Part.startAngle + (s * angles);

			}
			// else {
			//
			// final double original = 180 - dlo.top1Part.startAngle
			// + dlo.top1Part.endAngle;
			//
			// baseXDeltaGrid = myThick / 2
			// / Math.cos(Math.toRadians(original));
			//
			// triangleBase = dlo.radius1 * Math.cos(Math.toRadians(original));
			//
			// angle1 = Math.toDegrees(Math
			// .acos((triangleBase - baseXDeltaGrid) / dlo.radius1));
			//
			// Math.abs(angle1 - original);
			//
			// if (s == nS) {
			//
			// // angle1 = 0;
			// // doSpokeShoulder(dlo, myHM, myThick, 1);
			//
			// } else if (s != nS && s != 1) {
			//
			// double noS = nS - 3;
			// if (noS == 0) {
			// angle1 = 90;
			//
			// } else if (noS > 0) {
			//
			// noS = noS + 1;
			//
			// final double sa = (180 - 2 * angle1) / noS;
			//
			// angle1 = angle1 + (nS - s) * sa;
			//
			// }
			//
			// } else if (s == 1) {
			//
			// angle1 = 0;
			//
			// }
			//
			// }

		}

		if (angle1 > 0 && angle1 < 90 && s != midCol) {

			spoke.centerXe = dlo.centerPointX + (dlo.top1Part.radius1)
					* Math.cos(Math.toRadians(angle1));

			spoke.centerYe = dlo.centerPointY - (dlo.top1Part.radius1)
					* Math.sin(Math.toRadians(angle1));

			spoke.centerXs = dlo.centerPointX;
			spoke.centerYs = dlo.centerPointY;

			double d = thick / 2 / Math.sin(Math.toRadians(angle1));
			spoke.x1 = spoke.x1al = spoke.x1a = dlo.centerPointX + d;
			spoke.x2 = spoke.x2cl = spoke.x2a = dlo.centerPointX - d;
			spoke.y1 = spoke.y1al = spoke.y1a = dlo.centerPointY;
			spoke.y2 = spoke.y2cl = spoke.y2a = dlo.centerPointY;

			double tempx = dlo.centerPointX + (spoke.x1 - dlo.top1Part.radius1)
					* Math.cos(Math.toRadians(angle1));

			double tempy = dlo.centerPointY - (spoke.y1 - dlo.top1Part.radius1)
					* Math.sin(Math.toRadians(angle1));

			Point2D pc = this.getIntersectionLineArc(
					//
					dlo.top1Part.bkgrdStartXA,
					dlo.top1Part.bkgrdStartYA, //
					dlo.top1Part.bkgrdWidthA,
					dlo.top1Part.bkgrdHeightA, //
					dlo.top1Part.startAngleA,
					dlo.top1Part.endAngleA, //
					dlo.top1Part.focal1X, dlo.top1Part.focal1Y, spoke.x1,
					spoke.y1, tempx, tempy, 2, true);

			spoke.x4al = spoke.x4 = spoke.x4a = pc.getX();
			spoke.y4al = spoke.y4 = spoke.y4a = pc.getY();

			tempx = dlo.centerPointX + (spoke.x2 - dlo.top1Part.radius1)
					* Math.cos(Math.toRadians(angle1));

			tempy = dlo.centerPointY - (spoke.y2 - dlo.top1Part.radius1)
					* Math.sin(Math.toRadians(angle1));

			pc = this.getIntersectionLineArc(
					//
					dlo.top1Part.bkgrdStartXA,
					dlo.top1Part.bkgrdStartYA, //
					dlo.top1Part.bkgrdWidthA,
					dlo.top1Part.bkgrdHeightA, //
					dlo.top1Part.startAngleA,
					dlo.top1Part.endAngleA, //
					dlo.top1Part.focal1X, dlo.top1Part.focal1Y, spoke.x2,
					spoke.y2, tempx, tempy, 2, true);

			spoke.x3cl = spoke.x3 = spoke.x3a = pc.getX();
			spoke.y3cl = spoke.y3 = spoke.y3a = pc.getY();

			spoke.whichPos = 2;
			spoke.exists = 1;
			spoke.thickness = myThick;
			spoke.exists = 1;
			spoke.cOrM = 7;
			spoke = doGridsLevels(dlo, spoke);
			spoke.length = Math.sqrt(Math.pow(
					(spoke.centerYe - spoke.centerYs), 2)
					+ Math.pow((spoke.centerXe - spoke.centerYs), 2));

			spoke.isNew = true;

			spoke.myParent = dlo;
			spoke.myFrame2 = dlo.myFrame2;

			spoke.rowCol = 1;
			spoke.startPos = 1;
			spoke.endPos = 1;
			this.doGridPolygon(spoke);
			spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
			dlo.gridPartsS.add(spoke);
		}

		else if (angle1 > 90 && s != midCol) {
			// spoke.centerXe = dlo.centerPointX + (dlo.top1Part.radius1)
			// * Math.cos(Math.toRadians(angle1));
			//
			// spoke.centerYe = dlo.centerPointY - (dlo.top1Part.radius1)
			// * Math.sin(Math.toRadians(angle1));
			//
			// spoke.centerXs = dlo.centerPointX;
			// spoke.centerYs = dlo.centerPointY;
			//
			// double d = thick / 2 / Math.sin(Math.toRadians(angle1));
			// spoke.x1 = spoke.x1al = spoke.x1a = dlo.centerPointX + d;
			// spoke.x2 = spoke.x2cl = spoke.x2a = dlo.centerPointX - d;
			// spoke.y1 = spoke.y1al = spoke.y1a = dlo.centerPointY;
			// spoke.y2 = spoke.y2cl = spoke.y2a = dlo.centerPointY;
			//
			// double tempx = dlo.centerPointX + (spoke.x1 -
			// dlo.top1Part.radius1)
			// * Math.cos(Math.toRadians(angle1));
			//
			// double tempy = dlo.centerPointY - (spoke.y1 -
			// dlo.top1Part.radius1)
			// * Math.sin(Math.toRadians(angle1));
			//
			// Point2D pc = this.getIntersectionLineArc(
			// //
			// dlo.top1Part.bkgrdStartXA,
			// dlo.top1Part.bkgrdStartYA, //
			// dlo.top1Part.bkgrdWidthA,
			// dlo.top1Part.bkgrdHeightA, //
			// dlo.top1Part.startAngleA,
			// dlo.top1Part.endAngleA, //
			// dlo.top1Part.focal1X, dlo.top1Part.focal1Y, spoke.x1,
			// spoke.y1, tempx, tempy, 2, true);
			//
			// spoke.x4al = spoke.x4 = spoke.x4a = pc.getX();
			// spoke.y4al = spoke.y4 = spoke.y4a = pc.getY();
			//
			// tempx = dlo.centerPointX + (spoke.x2 - dlo.top1Part.radius1)
			// * Math.cos(Math.toRadians(angle1));
			//
			// tempy = dlo.centerPointY - (spoke.y2 - dlo.top1Part.radius1)
			// * Math.sin(Math.toRadians(angle1));
			//
			// pc = this.getIntersectionLineArc(
			// //
			// dlo.top1Part.bkgrdStartXA,
			// dlo.top1Part.bkgrdStartYA, //
			// dlo.top1Part.bkgrdWidthA,
			// dlo.top1Part.bkgrdHeightA, //
			// dlo.top1Part.startAngleA,
			// dlo.top1Part.endAngleA, //
			// dlo.top1Part.focal1X, dlo.top1Part.focal1Y, spoke.x2,
			// spoke.y2, tempx, tempy, 2, true);
			//
			// spoke.x3cl = spoke.x3 = spoke.x3a = pc.getX();
			// spoke.y3cl = spoke.y3 = spoke.y3a = pc.getY();
			//
			// spoke.whichPos = 2;
			// spoke.exists = 1;
			// spoke.thickness = myThick;
			// spoke.exists = 1;
			// spoke.cOrM = 7;
			// spoke = doGridsLevels(dlo, spoke);
			// spoke.length = // spoke.centerYe - spoke.centerYs;
			// Math.sqrt(Math.pow((spoke.centerYe - spoke.centerYs), 2)
			// + Math.pow((spoke.centerXe - spoke.centerYs), 2));
			//
			// spoke.isNew = true;
			//
			// spoke.myParent = dlo;
			// spoke.rowCol = 1;
			// spoke.startPos = 1;
			// spoke.endPos = 1;
			// this.doGridPolygon(spoke);
			// spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
			// dlo.gridPartsS.add(spoke);
		} else if (s == midCol) {

		}

		return spoke;
	}

	public Profiles doSpokesRow1(DLO dlo, Profiles myHM, double myThick,
			int midCol, double angles, int s, Profiles spoke) {

		double angle1 = 0;
		double baseXDeltaGrid = 0;
		double triangleBase = 0;

		if (dlo.top1Part.startAngle >= 90) {// QRL

			angle1 = dlo.top1Part.startAngle + s * angles;

		} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) { // QRR

			angle1 = dlo.top1Part.startAngle + s * angles;

		} else {

			if (myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2) || dlo.noSides == 2) { // HR

				angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle
						+ s * angles;

			} else {

				final double original = 180 - (dlo.top1Part.startAngle + dlo.top1Part.endAngle);
				baseXDeltaGrid = myThick / 2
						/ Math.cos(Math.toRadians(original));
				triangleBase = dlo.radius1 * Math.cos(Math.toRadians(original));
				angle1 = Math.toDegrees(Math
						.acos((triangleBase - baseXDeltaGrid) / dlo.radius1));
				Math.abs(angle1 - original);

				if (s == nS) {
					angle1 = 0;
					doSpokeShoulder(dlo, myHM, myThick, 1);

				} else if (s != nS && s != 1) {

					double noS = nS - 3;
					if (noS == 0) {
						angle1 = 90;

					} else if (noS > 0) {
						noS = noS + 1;
						final double sa = (180 - 2 * angle1) / noS;
						angle1 = angle1 + (nS - s) * sa;

					}

				} else if (s == 1) {
					angle1 = 0;
				}

			}

		}

		if (angle1 > 0) {

			angle1 = Math.toRadians(angle1);

			spoke.centerXs = dlo.centerPointX - dlo.top1Part.radius1
					* Math.cos(angle1);
			spoke.centerXe = dlo.centerPointX - myHM.radius1 * Math.cos(angle1);
			spoke.centerYs = dlo.centerPointY - dlo.top1Part.radius1
					* Math.sin(angle1);
			spoke.centerYe = dlo.centerPointY - myHM.radius1 * Math.sin(angle1);

			double a1 = 2 * Math.atan(myThick / 4 / myHM.radius1A);

			spoke.x4al = spoke.x4 = spoke.x4a = // spoke.centerXs;
			dlo.centerPointX + myHM.radius1A * Math.cos(angle1 + a1);

			spoke.x3cl = spoke.x3 = spoke.x3a = // spoke.centerXs;
			dlo.centerPointX + myHM.radius1A * Math.cos(angle1 - a1);

			spoke.y4al = spoke.y4 = spoke.y4a = // spoke.centerYs;
			dlo.centerPointY - myHM.radius1A * Math.sin(angle1 + a1);

			spoke.y3cl = spoke.y3 = spoke.y3a = // spoke.centerYs;
			dlo.centerPointY - myHM.radius1A * Math.sin(angle1 - a1);

			a1 = 2 * Math.atan(myThick / 4 / dlo.top1Part.radius1);

			spoke.x1al = spoke.x1 = spoke.x1a = // spoke.centerXe;
			dlo.centerPointX + dlo.top1Part.radius1 * Math.cos(angle1 + a1);

			spoke.x2cl = spoke.x2 = spoke.x2a = // spoke.centerXe;
			dlo.centerPointX + dlo.top1Part.radius1 * Math.cos(angle1 - a1);

			spoke.y1al = spoke.y1 = spoke.y1a = // spoke.centerYe;
			dlo.centerPointY - dlo.top1Part.radius1 * Math.sin(angle1 + a1);

			spoke.y2cl = spoke.y2 = spoke.y2a = // spoke.centerYe;
			dlo.centerPointY - dlo.top1Part.radius1 * Math.sin(angle1 - a1);

			if (myHM.radius1 == 0) {

				spoke.centerXe = dlo.centerPointX;

				spoke.centerYe = myY;

				double d = myThick / Math.sin(Math.toDegrees(angle1));
				spoke.y3cl = spoke.y3 = spoke.y3a = spoke.y4al = spoke.y4 = spoke.y4a = spoke.centerYe;

				spoke.x4al = spoke.x4 = spoke.x4a = spoke.centerXe
						- (myThick / 2);
				spoke.x3cl = spoke.x3 = spoke.x3a = spoke.centerXe
						+ (myThick / 2);
			}

			spoke.whichPos = 2;
			spoke.exists = 1;
			spoke.thickness = myThick;
			spoke.exists = 1;
			spoke.cOrM = 7;
			spoke = doGridsLevels(dlo, spoke);
			spoke.length = // spoke.centerYe - spoke.centerYs;
			Math.sqrt(Math.pow((spoke.centerYe - spoke.centerYs), 2)
					+ Math.pow((spoke.centerXe - spoke.centerYs), 2));

			spoke.isNew = true;

			spoke.myParent = dlo;
			spoke.myFrame2 = dlo.myFrame2;

			spoke.rowCol = myHM.rowCol;
			spoke.startPos = myHM.rowCol;
			spoke.endPos = myHM.rowCol;
			this.doGridPolygon(spoke);
			spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
			dlo.gridPartsS.add(spoke);
		}

		return spoke;
	}

	public Profiles doSpokesNoGrids(DLO dlo, Profiles myHM, double myThick,
			int midCol, double angles, int s, Profiles spoke) {

		double angle1 = 0;
		double baseXDeltaGrid = 0;
		double triangleBase = 0;
		final double thick = dlo.gridThick * myScale.doubleValue();

		if (dlo.top1Part.startAngle >= 90) {// QRL

			angle1 = dlo.top1Part.startAngle + s * angles;

		} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) { // QRR

			angle1 = dlo.top1Part.startAngle + s * angles;

		} else {

			if (myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2) || dlo.noSides == 2) { // HR

				angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle
						+ s * angles;

			} else {

				final double original = 180 - (dlo.top1Part.startAngle + dlo.top1Part.endAngle);
				baseXDeltaGrid = myThick / 2
						/ Math.cos(Math.toRadians(original));
				triangleBase = dlo.radius1 * Math.cos(Math.toRadians(original));
				angle1 = Math.toDegrees(Math
						.acos((triangleBase - baseXDeltaGrid) / dlo.radius1));
				Math.abs(angle1 - original);

				if (s == nS) {
					angle1 = 0;
					doSpokeShoulder(dlo, myHM, myThick, 1);

				} else if (s != nS && s != 1) {

					double noS = nS - 3;
					if (noS == 0) {
						angle1 = 90;

					} else if (noS > 0) {
						noS = noS + 1;
						final double sa = (180 - 2 * angle1) / noS;
						angle1 = angle1 + (nS - s) * sa;

					}

				} else if (s == 1) {
					angle1 = 0;
				}

			}

		}

		if (angle1 > 0) {

			angle1 = Math.toRadians(angle1);

			spoke.centerXs = dlo.centerPointX - dlo.top1Part.radius1
					* Math.cos(angle1);

			spoke.centerYs = dlo.centerPointY - dlo.top1Part.radius1
					* Math.sin(angle1);

			// this.intersectY(0, myY, 1000, myY,
			// dlo.centerPointX, dlo.centerPointY,
			// dlo.centerPointX, 0);

			double a1 = 2 * Math.atan(myThick / 4 / dlo.top1Part.radius1);

			spoke.x1al = spoke.x1 = spoke.x1a = // spoke.centerXe;
			dlo.centerPointX + dlo.top1Part.radius1 * Math.cos(angle1 + a1);

			spoke.x2cl = spoke.x2 = spoke.x2a = // spoke.centerXe;
			dlo.centerPointX + dlo.top1Part.radius1 * Math.cos(angle1 - a1);

			spoke.y1al = spoke.y1 = spoke.y1a = // spoke.centerYe;
			dlo.centerPointY - dlo.top1Part.radius1 * Math.sin(angle1 + a1);

			spoke.y2cl = spoke.y2 = spoke.y2a = // spoke.centerYe;
			dlo.centerPointY - dlo.top1Part.radius1 * Math.sin(angle1 - a1);

			double d = thick / 2 / Math.sin(angle1);

			spoke.centerXe = dlo.centerPointX;

			spoke.centerYe = this.intersectY(0, myY, 1000, myY, spoke.centerXs,
					spoke.centerYs, dlo.centerPointX, dlo.centerPointY);

			spoke.x4al = spoke.x4 = spoke.x4a = this.intersectX(0, myY, 1000,
					myY, spoke.x1, spoke.y1, dlo.centerPointX - d,
					dlo.centerPointY);

			spoke.x3cl = spoke.x3 = spoke.x3a = this.intersectX(0, myY, 1000,
					myY, spoke.x2, spoke.y2, dlo.centerPointX + d,
					dlo.centerPointY);

			spoke.y4al = spoke.y4 = spoke.y4a = spoke.y3cl = spoke.y3 = spoke.y3a = this
					.intersectY(0, myY, 1000, myY, spoke.x1, spoke.y1,
							dlo.centerPointX - d, dlo.centerPointY);

			spoke.whichPos = 2;
			spoke.exists = 1;
			spoke.thickness = myThick;
			spoke.exists = 1;
			spoke.cOrM = 7;
			spoke = doGridsLevels(dlo, spoke);
			spoke.length = // spoke.centerYe - spoke.centerYs;
			Math.sqrt(Math.pow((spoke.centerYe - spoke.centerYs), 2)
					+ Math.pow((spoke.centerXe - spoke.centerYs), 2));

			spoke.isNew = true;

			spoke.myParent = dlo;
			spoke.rowCol = myHM.rowCol;
			spoke.startPos = myHM.rowCol;
			spoke.endPos = myHM.rowCol;
			this.doGridPolygon(spoke);
			spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
			dlo.gridPartsS.add(spoke);
		}

		if (s > midCol) {

			// angle1 = Math.toRadians(angle1);
			//
			// spoke.centerXs = dlo.centerPointX - dlo.top1Part.radius1
			// * Math.cos(angle1);
			//
			// spoke.centerXe = dlo.centerPointX;
			//
			// spoke.centerYs = dlo.centerPointY - dlo.top1Part.radius1
			// * Math.sin(angle1);
			//
			// spoke.centerYe = myY;
			//
			// double d = thick / 2 / Math.sin(Math.toRadians(angle1));
			//
			// double a1 = 2 * Math.atan(myThick / 4 / myHM.radius1A);
			//
			// spoke.x4al = spoke.x4 = spoke.x4a = spoke.centerXe - d;
			//
			// spoke.x3cl = spoke.x3 = spoke.x3a = spoke.centerXe + d;
			//
			// spoke.y4al = spoke.y4 = spoke.y4a =
			// spoke.y3cl = spoke.y3 = spoke.y3a = spoke.centerYe;
			//
			// a1 = 2 * Math.atan(myThick / 4 / dlo.top1Part.radius1);
			//
			// spoke.x1al = spoke.x1 = spoke.x1a = // spoke.centerXe;
			// dlo.centerPointX + dlo.top1Part.radius1 * Math.cos(angle1 + a1);
			//
			// spoke.x2cl = spoke.x2 = spoke.x2a = // spoke.centerXe;
			// dlo.centerPointX + dlo.top1Part.radius1 * Math.cos(angle1 - a1);
			//
			// spoke.y1al = spoke.y1 = spoke.y1a = // spoke.centerYe;
			// dlo.centerPointY - dlo.top1Part.radius1 * Math.sin(angle1 + a1);
			//
			// spoke.y2cl = spoke.y2 = spoke.y2a = // spoke.centerYe;
			// dlo.centerPointY - dlo.top1Part.radius1 * Math.sin(angle1 - a1);
			//
			// spoke.whichPos = 2;
			// spoke.exists = 1;
			// spoke.thickness = myThick;
			// spoke.exists = 1;
			// spoke.cOrM = 7;
			// spoke = doGridsLevels(dlo, spoke);
			// spoke.length = // spoke.centerYe - spoke.centerYs;
			// Math.sqrt(Math.pow((spoke.centerYe - spoke.centerYs), 2)
			// + Math.pow((spoke.centerXe - spoke.centerYs), 2));
			//
			// spoke.isNew = true;
			//
			// spoke.myParent = dlo;
			// spoke.rowCol = myHM.rowCol;
			// spoke.startPos = myHM.rowCol;
			// spoke.endPos = myHM.rowCol;
			// this.doGridPolygon(spoke);
			// spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
			// dlo.gridPartsS.add(spoke);
		}

		return spoke;
	}

	public Profiles doSpokesRowN(final DLO dlo, final Profiles myHM,
			final double myThick, final int midCol, final double angles,
			final int s, final Profiles spoke, final Profiles myPrevH) {

		double baseXDeltaGrid = 0;
		double triangleBase = 0;
		double angle1 = 0;

		if (dlo.top1Part.startAngle >= 90) {
			// if (dlo.top1Part.startAngle + dlo.top1Part.endAngle == 180)
			// {// QRR
			//
			// angle1 = myPrevH.startAngle + s * angles;
			//
			// }
			// else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <
			// 180)
			// {// Q Arch R

			angle1 = myPrevH.startAngle + s * angles;
			// }
		} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) { // QRL
																			// o
																			// if
																			// (dlo.top1Part.startAngle
																			// ==
																			// 0)
																			// {//
																			// QRL
			angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle + s
					* angles;
			// }
			// else if (dlo.top1Part.startAngle > 0)
			// {// Q ArchL
			// angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle
			// + s * angles;
			// }
		} else {
			if (myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2) || dlo.noSides == 2) { // HR

				angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle
						+ s * angles;

			} else {

				final double original = 180 - (dlo.top1Part.startAngle + dlo.top1Part.endAngle);
				baseXDeltaGrid = myThick / 2
						/ Math.cos(Math.toRadians(original));
				triangleBase = dlo.radius1 * Math.cos(Math.toRadians(original));
				angle1 = Math.toDegrees(Math
						.acos((triangleBase - baseXDeltaGrid) / dlo.radius1));
				Math.abs(angle1 - original);

				if (s == nS) {
					angle1 = 0;
				} else if (s != nS && s != 1) {

					double noS = nS - 3;
					if (noS == 0) {
						angle1 = 90;

					} else if (noS > 0) {
						noS = noS + 1;
						final double sa = (180 - 2 * angle1) / noS;
						angle1 = angle1 + (nS - s) * sa;

					}

				} else if (s == 1) {
					angle1 = 0;
				}

			}

		}

		if (angle1 > 0) {
			if (myFrame2.compareTwoDoubles(dlo.startingY - dlo.highestY,
					dlo.widthPix / 2) || dlo.noSides == 2) { // HR
				rowN_HR_Spoke(dlo, myHM, myThick, spoke, myPrevH, angle1);
			}
			if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR
				rowN_QRR_Spoke(dlo, myHM, myThick, spoke, myPrevH, angle1);
			} else {// Q ArchL
				rowN_QRL_Spoke(dlo, myHM, myThick, spoke, myPrevH, angle1);
			}

			dlo.gridPartsS.add(spoke);
		}
		return spoke;

	}

	public void rowN_HR_Spoke(final DLO dlo, final Profiles myHM,
			final double myThick, Profiles spoke, final Profiles myPrevH,
			double angle1) {

		angle1 = Math.toRadians(angle1);

		spoke.centerXs = dlo.centerPointX - myPrevH.radius1A * Math.cos(angle1);

		spoke.centerXe = dlo.centerPointX - myHM.radius1 * Math.cos(angle1);

		spoke.centerYs = dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1);

		spoke.centerYe = dlo.centerPointY - myHM.radius1 * Math.sin(angle1);

		double a1 = 2 * Math.atan(myThick / 4 / myPrevH.radius1A);
		//
		spoke.x1al = spoke.x1 = spoke.x1a = // spoke.centerXs;
		dlo.centerPointX - myPrevH.radius1A * Math.cos(angle1 + a1);
		//
		spoke.x2cl = spoke.x2 = spoke.x2a = // spoke.centerXs;
		dlo.centerPointX - myPrevH.radius1A * Math.cos(angle1 - a1);

		spoke.y1al = spoke.y1 = spoke.y1a = // spoke.centerYs;
		dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1 + a1);

		spoke.y2cl = spoke.y2 = spoke.y2a = // spoke.centerYs;
		dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1 - a1);

		a1 = 2 * Math.atan(myThick / 4 / myHM.radius1);

		spoke.x4al = spoke.x4 = spoke.x4a = // spoke.centerXe;
		dlo.centerPointX - myHM.radius1 * Math.cos(angle1 + a1);

		spoke.x3cl = spoke.x3 = spoke.x3a = // spoke.centerXe;
		dlo.centerPointX - myHM.radius1 * Math.cos(angle1 - a1);

		spoke.y4al = spoke.y4 = spoke.y4a = // spoke.centerYe;
		dlo.centerPointY - myHM.radius1 * Math.sin(angle1 + a1);

		spoke.y3cl = spoke.y3 = spoke.y3a = // spoke.centerYe;
		dlo.centerPointY - myHM.radius1 * Math.sin(angle1 - a1);

		spoke.whichPos = 2;
		spoke.exists = 1;
		spoke.thickness = myThick;
		spoke.exists = 1;
		spoke.cOrM = 7;
		spoke = doGridsLevels(dlo, spoke);
		spoke.length = spoke.centerYe - spoke.centerYs;

		spoke.isNew = true;

		spoke.myParent = dlo;
		spoke.rowCol = myHM.rowCol;
		spoke.startPos = myHM.rowCol;
		spoke.endPos = myHM.rowCol;
		this.doGridPolygon(spoke);
		spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
	}

	public void rowN_QRL_Spoke(final DLO dlo, final Profiles myHM,
			final double myThick, Profiles spoke, final Profiles myPrevH,
			double angle1) {

		angle1 = Math.toRadians(angle1);

		spoke.centerXs = dlo.centerPointX + myPrevH.radius1A * Math.cos(angle1);

		spoke.centerXe = dlo.centerPointX + myHM.radius1 * Math.cos(angle1);

		spoke.centerYs = dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1);
		spoke.centerYe = dlo.centerPointY - myHM.radius1 * Math.sin(angle1);

		double a1 = 2 * Math.atan(myThick / 4 / myPrevH.radius1A);
		//
		spoke.x1al = spoke.x1 = spoke.x1a = // spoke.centerXs;
		dlo.centerPointX + myPrevH.radius1A * Math.cos(angle1 + a1);
		//
		spoke.x2cl = spoke.x2 = spoke.x2a = // spoke.centerXs;
		dlo.centerPointX + myPrevH.radius1A * Math.cos(angle1 - a1);

		spoke.y1al = spoke.y1 = spoke.y1a = // spoke.centerYs;
		dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1 + a1);

		spoke.y2cl = spoke.y2 = spoke.y2a = // spoke.centerYs;
		dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1 - a1);

		a1 = 2 * Math.atan(myThick / 4 / myHM.radius1);

		spoke.x4al = spoke.x4 = spoke.x4a = // spoke.centerXe;
		dlo.centerPointX + myHM.radius1 * Math.cos(angle1 + a1);

		spoke.x3cl = spoke.x3 = spoke.x3a = // spoke.centerXe;
		dlo.centerPointX + myHM.radius1 * Math.cos(angle1 - a1);

		spoke.y4al = spoke.y4 = spoke.y4a = // spoke.centerYe;
		dlo.centerPointY - myHM.radius1 * Math.sin(angle1 + a1);

		spoke.y3cl = spoke.y3 = spoke.y3a = // spoke.centerYe;
		dlo.centerPointY - myHM.radius1 * Math.sin(angle1 - a1);

		spoke.whichPos = 2;
		spoke.exists = 1;
		spoke.thickness = myThick;
		spoke.exists = 1;
		spoke.cOrM = 7;
		spoke = doGridsLevels(dlo, spoke);
		spoke.length = spoke.centerYe - spoke.centerYs;

		spoke.isNew = true;

		spoke.myParent = dlo;
		spoke.myFrame2 = dlo.myFrame2;

		spoke.rowCol = myHM.rowCol;
		spoke.startPos = myHM.rowCol;
		spoke.endPos = myHM.rowCol;
		this.doGridPolygon(spoke);
		spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(spoke);
	}

	public void rowN_QRR_Spoke(final DLO dlo, final Profiles myHM,
			final double myThick, Profiles spoke, final Profiles myPrevH,
			double angle1) {

		angle1 = Math.toRadians(angle1);

		spoke.centerXs = dlo.centerPointX + myPrevH.radius1A * Math.cos(angle1);

		spoke.centerXe = dlo.centerPointX + myHM.radius1 * Math.cos(angle1);

		spoke.centerYs = dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1);
		spoke.centerYe = dlo.centerPointY - myHM.radius1 * Math.sin(angle1);

		double a1 = 2 * Math.atan(myThick / 4 / myPrevH.radius1A);
		//
		spoke.x1al = spoke.x1 = spoke.x1a = // spoke.centerXs;
		dlo.centerPointX + myPrevH.radius1A * Math.cos(angle1 + a1);
		//
		spoke.x2cl = spoke.x2 = spoke.x2a = // spoke.centerXs;
		dlo.centerPointX + myPrevH.radius1A * Math.cos(angle1 - a1);

		spoke.y1al = spoke.y1 = spoke.y1a = // spoke.centerYs;
		dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1 + a1);

		spoke.y2cl = spoke.y2 = spoke.y2a = // spoke.centerYs;
		dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1 - a1);

		a1 = 2 * Math.atan(myThick / 4 / myHM.radius1);

		spoke.x4al = spoke.x4 = spoke.x4a = // spoke.centerXe;
		dlo.centerPointX + myHM.radius1 * Math.cos(angle1 + a1);

		spoke.x3cl = spoke.x3 = spoke.x3a = // spoke.centerXe;
		dlo.centerPointX + myHM.radius1 * Math.cos(angle1 - a1);

		spoke.y4al = spoke.y4 = spoke.y4a = // spoke.centerYe;
		dlo.centerPointY - myHM.radius1 * Math.sin(angle1 + a1);

		spoke.y3cl = spoke.y3 = spoke.y3a = // spoke.centerYe;
		dlo.centerPointY - myHM.radius1 * Math.sin(angle1 - a1);

		spoke.whichPos = 2;
		spoke.exists = 1;
		spoke.thickness = myThick;
		spoke.exists = 1;
		spoke.cOrM = 7;
		spoke = doGridsLevels(dlo, spoke);
		spoke.length = spoke.centerYe - spoke.centerYs;

		spoke.isNew = true;

		spoke.myParent = dlo;
		spoke.myFrame2 = dlo.myFrame2;

		spoke.rowCol = myHM.rowCol;
		spoke.startPos = myHM.rowCol;
		spoke.endPos = myHM.rowCol;
		this.doGridPolygon(spoke);
		spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(spoke);
	}

	public Profiles doSpokesRowNQRR(final DLO dlo, final Profiles myHM,
			final double myThick, final int midCol, final double angles,
			final int s, final Profiles spoke, final Profiles myPrevH) {

		double angle1 = 0;
		if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR

			angle1 = dlo.top1Part.startAngle // myPrevH
					+ s * angles;

		}

		rowN_QRL_Spoke(dlo, myHM, myThick, spoke, myPrevH, angle1);

		return spoke;

	}

	public Profiles doSpokesRow1MID(DLO dlo, Profiles myHM, double myThick,
			int midCol, double angles, int s, Profiles spoke) {

		double angle1 = 0;

		// angle1 =180 - dlo.top1Part.startAngle -
		// dlo.top1Part.endAngle +
		// s
		// * angles;

		if (dlo.top1Part.startAngle < 90
				&& dlo.top1Part.startAngle + dlo.top1Part.endAngle > 90
				|| dlo.noSides == 2) {// HR/Arch
			angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle + s
					* angles;

		} else if (dlo.top1Part.startAngle >= 90) {// QRL
			angle1 = dlo.top1Part.startAngle + s * angles;
		} else if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {// QRR
			angle1 = dlo.top1Part.startAngle + s * angles;
		}

		angle1 = Math.toRadians(angle1);

		spoke.centerXs = dlo.centerPointX;
		spoke.centerXe = dlo.centerPointX;
		spoke.centerYs = dlo.centerPointY - dlo.top1Part.radius1
				* Math.sin(angle1);
		spoke.centerYe = dlo.centerPointY - myHM.radius1 * Math.sin(angle1);

		spoke.x4al = spoke.x4 = spoke.x4a = spoke.x1al = spoke.x1 = spoke.x1a = dlo.centerPointX
				- myThick / 2;
		spoke.x3cl = spoke.x3 = spoke.x3a = spoke.x2cl = spoke.x2 = spoke.x2a = dlo.centerPointX
				+ myThick / 2;
		spoke.y4al = spoke.y4 = spoke.y4a = spoke.centerYe;
		spoke.y3cl = spoke.y3 = spoke.y3a = spoke.centerYe;
		spoke.y1al = spoke.y1 = spoke.y1a = spoke.centerYs;
		spoke.y2cl = spoke.y2 = spoke.y2a = spoke.centerYs;
		spoke.whichPos = 2;
		spoke.exists = 1;
		spoke.thickness = myThick;
		spoke.exists = 1;
		spoke.cOrM = 7;
		spoke = doGridsLevels(dlo, spoke);
		spoke.length = spoke.centerYe - spoke.centerYs;

		spoke.isNew = true;
		spoke.myParent = dlo;
		spoke.myFrame2 = dlo.myFrame2;

		spoke.rowCol = myHM.rowCol;
		spoke.startPos = myHM.rowCol;
		spoke.endPos = myHM.rowCol;
		this.doGridPolygon(spoke);
		spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(spoke);

		return spoke;
	}

	public Profiles doSpokesRowNMID(final DLO dlo, final Profiles myHM,
			final double myThick, final int midCol, final double angles,
			final int s, Profiles spoke, final Profiles myPrevH) {

		double angle1;

		angle1 = 180 - myPrevH.startAngle// mPrwe
				- myPrevH.endAngle + s * angles;
		angle1 = Math.toRadians(angle1);

		spoke.centerXs = dlo.centerPointX;

		spoke.centerXe = dlo.centerPointX;

		spoke.centerYs = dlo.centerPointY - myPrevH.radius1A * Math.sin(angle1);
		spoke.centerYe = dlo.centerPointY - myHM.radius1 * Math.sin(angle1);

		spoke.x1al = spoke.x1 = spoke.x1a = dlo.centerPointX - myThick / 2;
		spoke.x2cl = spoke.x2 = spoke.x2a = dlo.centerPointX + myThick / 2;
		spoke.y1al = spoke.y1 = spoke.y1a = spoke.centerYs;
		spoke.y2cl = spoke.y2 = spoke.y2a = spoke.centerYs;

		spoke.x4al = spoke.x4 = spoke.x4a = dlo.centerPointX - myThick / 2;

		spoke.x3cl = spoke.x3 = spoke.x3a = dlo.centerPointX + myThick / 2;

		spoke.y4al = spoke.y4 = spoke.y4a = spoke.centerYe;

		spoke.y3cl = spoke.y3 = spoke.y3a = spoke.centerYe;

		spoke.whichPos = 2;
		spoke.exists = 1;
		spoke.thickness = myThick;
		spoke.exists = 1;
		spoke.cOrM = 7;
		spoke = doGridsLevels(dlo, spoke);
		spoke.length = spoke.centerYe - spoke.centerYs;

		spoke.isNew = true;

		spoke.myParent = dlo;
		spoke.myFrame2 = dlo.myFrame2;

		spoke.rowCol = myHM.rowCol;
		spoke.startPos = myHM.rowCol;
		spoke.endPos = myHM.rowCol;
		this.doGridPolygon(spoke);
		spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(spoke);

		return spoke;

	}

	public void doInHub(final DLO dlo, final Profiles myHM,
			final double myThick, final int midCol, final double angles,
			final int s, final double myY, final Profiles spoke) {

		Profiles hub = new Profiles();
		hub.partForm = 1;
		hub.orientation = 1;
		hub.partDimB = myThick;

		double angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle
				+ s * angles;

		angle1 = Math.toRadians(angle1);

		hub.centerXs = dlo.centerPointX - myHM.radius1A * Math.cos(angle1);
		hub.centerXe = dlo.centerPointX;
		hub.centerYs = dlo.centerPointY - myHM.radius1A * Math.sin(angle1);
		hub.centerYe = myY;

		double a1 = 2 * Math.atan(myThick / 4 / myHM.radius1A);
		hub.x1al = hub.x1 = hub.x1a = dlo.centerPointX - myHM.radius1A
				* Math.cos(angle1 + a1);
		hub.x2cl = hub.x2 = hub.x2a = dlo.centerPointX - myHM.radius1A
				* Math.cos(angle1 - a1);
		hub.y1al = hub.y1 = hub.y1a = dlo.centerPointY - myHM.radius1A
				* Math.sin(angle1 + a1);
		hub.y2cl = hub.y2 = hub.y2a = dlo.centerPointY - myHM.radius1A
				* Math.sin(angle1 - a1);

		if (s < midCol) {
			hub.x4al = hub.x4 = hub.x4a = this.intersectX(spoke.x1a, spoke.y1a,
					spoke.x4a, spoke.y4a, dlo.centerPointX, dlo.centerPointY,
					0, dlo.centerPointY);

			hub.x3cl = hub.x3 = hub.x3a = this.intersectX(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, dlo.centerPointX, dlo.centerPointY,
					0, dlo.centerPointY);

			hub.y3cl = hub.y3 = hub.y3a = this.intersectY(spoke.x1a, spoke.y1a,
					spoke.x4a, spoke.y4a, 0, dlo.centerPointY, 500,
					dlo.centerPointY);

			hub.y4al = hub.y4 = hub.y4a = dlo.centerPointY;

		} else if (s > midCol) {

			hub.x4al = hub.x4 = hub.x4a = this.intersectX(spoke.x1a, spoke.y1a,
					spoke.x4a, spoke.y4a, dlo.centerPointX, dlo.centerPointY,
					0, dlo.centerPointY);

			hub.x3cl = hub.x3 = hub.x3a = this.intersectX(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, dlo.centerPointX, dlo.centerPointY,
					0, dlo.centerPointY);

			hub.y4al = hub.y4 = hub.y4a = this.intersectY(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, 0, dlo.centerPointY, 500,
					dlo.centerPointY);

			hub.y3cl = hub.y3 = hub.y3a = dlo.centerPointY;

		}

		hub.whichPos = 2;
		hub.exists = 1;
		hub.thickness = myThick;
		hub.exists = 1;
		hub.cOrM = 7;
		hub = doGridsLevels(dlo, hub);
		hub.length = hub.centerYe - hub.centerYs;

		hub.isNew = true;

		hub.myParent = dlo;
		hub.myFrame2 = dlo.myFrame2;

		hub.rowCol = myHM.rowCol;
		hub.startPos = myHM.rowCol;
		hub.endPos = myHM.rowCol;
		this.doGridPolygon(hub);
		hub.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(hub);

	}

	public void doInHubSimple(final DLO dlo, final Profiles myHM,
			final double myThick, final int midCol, final double angles,
			final int s, final double myY, final Profiles spoke,
			Profiles myFirst) {

		Profiles hub = new Profiles();
		hub.partForm = 1;
		hub.orientation = 1;
		hub.partDimB = myThick;

		// if (s > midCol)
		// {

		hub.centerXs = spoke.centerXe;
		hub.centerYs = spoke.centerYe;

		hub.x1al = hub.x1 = hub.x1a = spoke.x4;
		hub.y1al = hub.y1 = hub.y1a = spoke.y4;

		hub.x2cl = hub.x2 = hub.x2a = spoke.x3;
		hub.y2cl = hub.y2 = hub.y2a = spoke.y3;

		if (myFirst != null) {
			hub.x3cl = hub.x3 = hub.x3a = this.intersectX(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, myFirst.x2, myFirst.y2, myFirst.x3,
					myFirst.y3);

			hub.x4al = hub.x4 = hub.x4a = this.intersectX(spoke.x1a, spoke.y1a,
					spoke.x4a, spoke.y4a, myFirst.x2, myFirst.y2, myFirst.x3,
					myFirst.y3);

			hub.y3cl = hub.y3 = hub.y3a = this.intersectY(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, myFirst.x2, myFirst.y2, myFirst.x3,
					myFirst.y3);

			hub.y4al = hub.y4 = hub.y4a = this.intersectY(spoke.centerXs,
					spoke.centerYs, spoke.centerXe, spoke.centerYe, myFirst.x2,
					myFirst.y2, myFirst.x3, myFirst.y3);
		} else {

			hub.x3cl = hub.x3 = hub.x3a = this.intersectX(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, dlo.startingX, dlo.startingY,
					dlo.bX2, dlo.bY2);

			hub.x4al = hub.x4 = hub.x4a = this.intersectX(spoke.x1a, spoke.y1a,
					spoke.x4a, spoke.y4a, dlo.startingX, dlo.startingY,
					dlo.bX2, dlo.bY2);

			hub.y3cl = hub.y3 = hub.y3a = this.intersectY(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, dlo.startingX, dlo.startingY,
					dlo.bX2, dlo.bY2);

			hub.y4al = hub.y4 = hub.y4a = this.intersectY(spoke.centerXs,
					spoke.centerYs, spoke.centerXe, spoke.centerYe,
					dlo.startingX, dlo.startingY, dlo.bX2, dlo.bY2);

		}

		hub.whichPos = 2;
		hub.exists = 1;
		hub.thickness = myThick;
		hub.exists = 1;
		hub.cOrM = 7;
		hub = doGridsLevels(dlo, hub);
		hub.length = hub.centerYe - hub.centerYs;

		hub.isNew = true;

		hub.myParent = dlo;
		hub.myFrame2 = dlo.myFrame2;

		hub.rowCol = myHM.rowCol;
		hub.startPos = myHM.rowCol;
		hub.endPos = myHM.rowCol;
		this.doGridPolygon(hub);
		hub.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(hub);

	}

	public void doInHubII(final DLO dlo, final Profiles myHM,
			final double myThick, final int midCol, final double angles,
			final int s,
			// final Profiles myFirst,
			final double myY, final Profiles spoke) {

		Profiles hub = new Profiles();
		hub.partForm = 1;
		hub.orientation = 1;
		hub.partDimB = myThick;

		if (s > midCol) {
			final Point2D pc = this.getIntersectionLineArc(
					//
					myHM.bkgrdStartXA,
					myHM.bkgrdStartYA, //
					myHM.bkgrdWidthA,
					myHM.bkgrdHeightA, //
					myHM.startAngleA,
					myHM.endAngleA, //
					myHM.focal1X, myHM.focal1Y, spoke.centerXs, spoke.centerYs,
					spoke.centerXe, spoke.centerYe, 1, true);

			hub.centerXs = pc.getX();
			hub.centerYs = pc.getY();

			Point2D p1 = this.getIntersectionLineArc(
					//
					myHM.bkgrdStartXA,
					myHM.bkgrdStartYA, //
					myHM.bkgrdWidthA,
					myHM.bkgrdHeightA, //
					myHM.startAngleA,
					myHM.endAngleA, //
					myHM.focal1X, myHM.focal1Y, spoke.x1, spoke.y1, spoke.x4,
					spoke.y4, 1, false);

			hub.x1al = hub.x1 = hub.x1a = p1.getX();
			hub.y1al = hub.y1 = hub.y1a = p1.getY();

			p1 = this.getIntersectionLineArc(
					//
					myHM.bkgrdStartXA,
					myHM.bkgrdStartYA, //
					myHM.bkgrdWidthA,
					myHM.bkgrdHeightA, //
					myHM.startAngleA,
					myHM.endAngleA, //
					myHM.focal1X, myHM.focal1Y, spoke.x2, spoke.y2, spoke.x3,
					spoke.y3, 1, false);

			hub.x2cl = hub.x2 = hub.x2a = p1.getX();
			hub.y2cl = hub.y2 = hub.y2a = p1.getY();

			hub.x3cl = hub.x3 = hub.x3a = this.intersectX(spoke.x1a, spoke.y1a,
					spoke.x4a, spoke.y4a, dlo.centerPointX, dlo.centerPointY,
					0, dlo.centerPointY);

			hub.x4al = hub.x4 = hub.x4a = this.intersectX(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, dlo.centerPointX, dlo.centerPointY,
					0, dlo.centerPointY);

			hub.y3cl = hub.y3 = hub.y3a = this.intersectY(spoke.x2a, spoke.y2a,
					spoke.x3a, spoke.y3a, 0, dlo.centerPointY, 500,
					dlo.centerPointY);

			hub.y4al = hub.y4 = hub.y4a = dlo.centerPointY;

		}

		hub.whichPos = 2;
		hub.exists = 1;
		hub.thickness = myThick;
		hub.exists = 1;
		hub.cOrM = 7;
		hub = doGridsLevels(dlo, hub);
		hub.length = hub.centerYe - hub.centerYs;

		hub.isNew = true;

		hub.myParent = dlo;
		hub.myFrame2 = dlo.myFrame2;

		hub.rowCol = myHM.rowCol;
		hub.startPos = myHM.rowCol;
		hub.endPos = myHM.rowCol;
		this.doGridPolygon(hub);
		hub.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(hub);

	}

	public void doInHubMID(DLO dlo, Profiles myHM, double myThick, int midCol,
			double angles, int s, double myY, Profiles spoke) {

		Profiles hub = new Profiles();
		hub.partForm = 1;
		hub.orientation = 1;
		hub.partDimB = myThick;

		double angle1 = 180 - dlo.top1Part.startAngle - dlo.top1Part.endAngle
				+ s * angles;
		angle1 = Math.toRadians(angle1);

		hub.centerXs = dlo.centerPointX;
		hub.centerXe = dlo.centerPointX;

		hub.centerYs = hub.y1al = hub.y1 = hub.y1a = hub.y2cl = hub.y2 = hub.y2a = dlo.centerPointY
				- myHM.radius1A * Math.sin(angle1);

		hub.centerYe = hub.y4al = hub.y4 = hub.y4a = hub.y3cl = hub.y3 = hub.y3a = dlo.startingY;// centerPointY;

		hub.x1al = hub.x1 = hub.x1a = hub.x4al = hub.x4 = hub.x4a = dlo.centerPointX
				- myThick / 2;

		hub.x2cl = hub.x2 = hub.x2a = hub.x3cl = hub.x3 = hub.x3a = dlo.centerPointX
				+ myThick / 2;

		hub.whichPos = 2;
		hub.exists = 1;
		hub.thickness = myThick;
		hub.exists = 1;
		hub.cOrM = 7;
		hub = doGridsLevels(dlo, hub);
		hub.length = hub.centerYe - hub.centerYs;
		hub.isNew = true;
		hub.myParent = dlo;
		hub.myFrame2 = dlo.myFrame2;

		hub.rowCol = myHM.rowCol;
		hub.startPos = myHM.rowCol;
		hub.endPos = myHM.rowCol;
		this.doGridPolygon(hub);
		hub.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
		dlo.gridPartsS.add(hub);

	}

	public void doSpokeShoulderOld(final DLO dlo, final Profiles myHM,
			final double myThick, final Profiles myFirstH) {

		if (myFirstH.y2 > dlo.centerPointY || dlo.top1Part.startAngle > 0
				|| dlo.top1Part.endAngle < 180) {
			if (myHM.rowCol == 1) {

				Profiles spoke = new Profiles();
				spoke.myFrame2 = dlo.myFrame2;

				Profiles spoke2 = new Profiles();
				spoke2.myFrame2 = dlo.myFrame2;

				double angle1 = Math.toRadians(dlo.top1Part.startAngle);
				spoke.partForm = 1;
				spoke.orientation = 1;
				spoke.partDimB = myThick;
				spoke2.partForm = 1;
				spoke2.orientation = 1;
				spoke2.partDimB = myThick;

				spoke.centerXs = dlo.centerPointX + dlo.top1Part.radius1
						* Math.cos(angle1);
				spoke.centerXe = dlo.centerPointX + myHM.radius1
						* Math.cos(angle1);

				angle1 = Math.toRadians(180 - dlo.top1Part.endAngle
						- dlo.top1Part.startAngle);

				spoke2.centerXs = dlo.centerPointX - dlo.top1Part.radius1
						* Math.cos(angle1);
				spoke2.centerXe = dlo.centerPointX - myHM.radius1
						* Math.cos(angle1);

				spoke.centerYs = dlo.top1Part.endYC;
				spoke.y1al = spoke.centerYs - myThick / 2;
				spoke.y2cl = spoke.y1al + myThick;

				spoke.centerYe = myHM.endYC;
				spoke.y4al = spoke.centerYe - myThick / 2;
				spoke.y3cl = spoke.y4al + myThick;

				spoke2.centerYs = dlo.startingY;
				spoke2.y1al = spoke2.centerYs + myThick / 2;
				spoke2.y2cl = spoke.y1al - myThick;

				spoke2.centerYe = myHM.startYC;
				spoke2.y4al = spoke2.centerYe + myThick / 2;
				spoke2.y3cl = spoke.y4al - myThick;

				spoke.x1al = spoke.x1 = spoke.centerXs;

				spoke.x2cl = spoke.x2 = spoke.centerXs;

				spoke.x4al = spoke.x4 = spoke.centerXe;

				spoke.x3cl = spoke.x3 = spoke.centerXe;

				spoke2.x1al = spoke2.x1 = spoke2.x1a = spoke2.centerXs;

				spoke2.x2cl = spoke2.x2 = spoke2.x2a = spoke2.centerXs;

				spoke2.x4al = spoke2.x4 = spoke2.x4a = spoke2.centerXe;

				spoke2.x3cl = spoke2.x3 = spoke2.x3a = spoke2.centerXe;

				spoke.whichPos = 2;
				spoke.exists = 1;
				spoke.thickness = myThick;
				spoke.exists = 1;
				spoke.cOrM = 7;
				spoke = doGridsLevels(dlo, spoke);
				spoke.length = spoke.centerYe - spoke.centerYs;

				spoke.isNew = true;

				spoke.myParent = dlo;
				spoke.rowCol = myHM.rowCol;
				spoke.startPos = myHM.rowCol;
				spoke.endPos = myHM.rowCol;
				spoke.seq = spoke.startPos + 100;

				// /////

				spoke2.whichPos = 2;
				spoke2.exists = 1;
				spoke2.thickness = myThick;
				spoke2.exists = 1;
				spoke2.cOrM = 7;
				spoke2 = doGridsLevels(dlo, spoke2);
				spoke2.length = spoke2.centerYe - spoke2.centerYs;

				spoke2.isNew = true;

				spoke2.myParent = dlo;
				spoke2.rowCol = myHM.rowCol;
				spoke2.startPos = myHM.rowCol;
				spoke2.endPos = myHM.rowCol;
				spoke2.seq = spoke2.startPos + 100;
				// /////

				this.doGridPolygon(spoke);
				spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
				dlo.gridPartsS.add(spoke);

				this.doGridPolygon(spoke2);
				spoke2.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
				dlo.gridPartsS.add(spoke2);
			} else if (myHM.rowCol > 1) {

				final Object[] mH = dlo.bOpeningObject.mullionsH.toArray();
				Profiles myPrevH = new Profiles();
				for (final Object h : mH) {
					if (((Profiles) h).rowCol == myHM.rowCol - 1) {
						myPrevH = (Profiles) h;
						break;
					}
				}

				Profiles spoke = new Profiles();
				spoke.myFrame2 = dlo.myFrame2;

				Profiles spoke2 = new Profiles();
				spoke2.myFrame2 = dlo.myFrame2;

				double angle1 = Math.toRadians(myPrevH.startAngleA);
				spoke.partForm = 1;
				spoke.orientation = 1;
				spoke.partDimB = myThick;
				spoke2.partForm = 1;
				spoke2.orientation = 1;
				spoke2.partDimB = myThick;

				spoke.centerXs = dlo.centerPointX + myPrevH.radius1
						* Math.cos(angle1);

				spoke.centerXe = dlo.centerPointX + myHM.radius1
						* Math.cos(angle1);

				angle1 = Math.toRadians(180 - myPrevH.endAngle
						- myPrevH.startAngle);

				spoke2.centerXs = dlo.centerPointX - myPrevH.radius1
						* Math.cos(angle1);
				spoke2.centerXe = dlo.centerPointX - myHM.radius1
						* Math.cos(angle1);

				spoke.centerYs = myPrevH.endYC;
				spoke.y1al = spoke.centerYs - myThick / 2;
				spoke.y2cl = spoke.y1al + myThick;

				spoke.centerYe = myHM.endYC;
				spoke.y4al = spoke.centerYe - myThick / 2;
				spoke.y3cl = spoke.y4al + myThick;

				spoke2.centerYs = myPrevH.startYC;
				spoke2.y1al = spoke2.centerYs + myThick / 2;
				spoke2.y2cl = spoke.y1al - myThick;

				spoke2.centerYe = myHM.startYC;
				spoke2.y4al = spoke2.centerYe + myThick / 2;
				spoke2.y3cl = spoke.y4al - myThick;

				spoke.x1al = spoke.x1 = spoke.centerXs;

				spoke.x2cl = spoke.x2 = spoke.centerXs;

				spoke.x4al = spoke.x4 = spoke.centerXe;

				spoke.x3cl = spoke.x3 = spoke.centerXe;

				spoke2.x1al = spoke2.x1 = spoke2.x1a = spoke2.centerXs;

				spoke2.x2cl = spoke2.x2 = spoke2.x2a = spoke2.centerXs;

				spoke2.x4al = spoke2.x4 = spoke2.x4a = spoke2.centerXe;

				spoke2.x3cl = spoke2.x3 = spoke2.x3a = spoke2.centerXe;

				spoke.whichPos = 2;
				spoke.exists = 1;
				spoke.thickness = myThick;
				spoke.exists = 1;
				spoke.cOrM = 7;
				spoke = doGridsLevels(dlo, spoke);
				spoke.length = spoke.centerYe - spoke.centerYs;

				spoke.isNew = true;

				spoke.myParent = dlo;
				spoke.rowCol = myHM.rowCol;
				spoke.startPos = myHM.rowCol;
				spoke.endPos = myHM.rowCol;
				spoke.seq = spoke.startPos + 100;
				// /////

				spoke2.whichPos = 2;
				spoke2.exists = 1;
				spoke2.thickness = myThick;
				spoke2.exists = 1;
				spoke = doGridsLevels(dlo, spoke);

				spoke2.length = spoke2.centerYe - spoke2.centerYs;

				spoke2.isNew = true;

				spoke2.myParent = dlo;
				spoke2.rowCol = myHM.rowCol;
				spoke2.startPos = myHM.rowCol;
				spoke2.endPos = myHM.rowCol;
				spoke2.seq = spoke2.startPos + 100;
				// /////

				this.doGridPolygon(spoke);
				spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
				dlo.gridPartsS.add(spoke);

				this.doGridPolygon(spoke2);
				spoke2.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);
				dlo.gridPartsS.add(spoke2);
			}
		}
	}

	public void doSpokeShoulder(final DLO dlo, final Profiles myHM,
			final double myThick, final int type) {

		// type = 1 Arch, 2 QRL, 3QRR

		if (myHM.rowCol == 1) {

			Profiles spoke = new Profiles();
			spoke.myFrame2 = dlo.myFrame2;

			Arc2D arcF = new Arc2D.Double(dlo.top1Part.bkgrdStartX,
					dlo.top1Part.bkgrdStartY, dlo.top1Part.bkgrdWidth,
					dlo.top1Part.bkgrdHeight, dlo.top1Part.startAngle,
					dlo.top1Part.endAngle, Arc2D.OPEN);

			Rectangle2D myRect = arcF.getBounds2D();

			double y1 = dlo.startingY;// myRect.getMaxY();
			double x1 = dlo.startingX;// myRe;ct.getMinX();

			arcF = new Arc2D.Double(myHM.bkgrdStartXA, myHM.bkgrdStartYA,
					myHM.bkgrdWidthA, myHM.bkgrdHeightA, myHM.startAngleA,
					myHM.endAngleA, Arc2D.OPEN);

			myRect = arcF.getBounds2D();

			double y4 = myRect.getMaxY();
			double x4 = myRect.getMinX();

			double triangleH = y4 - y1;
			double triangleBase = x4 - x1;

			double theta = Math.toDegrees(Math.atan(triangleH / triangleBase));

			double SpokeLength = triangleBase / Math.cos(theta);

			double gridTriHyp = myThick / 2 / Math.sin(Math.toRadians(theta));

			double gridTriBase = gridTriHyp * Math.cos(Math.toRadians(theta));

			double heightPerpGridTri = gridTriBase
					* Math.sin(Math.toRadians(theta));

			double centerYe = y4 - heightPerpGridTri;
			double centerYs = y1 - heightPerpGridTri;

			double deltaX = heightPerpGridTri
					/ Math.tan(Math.toRadians(90 - theta));

			double centerXe = x4 + deltaX;
			double centerXs = x1 + deltaX;

			gridTriHyp = myThick / Math.sin(Math.toRadians(theta));

			gridTriBase = gridTriHyp * Math.cos(Math.toRadians(theta));

			heightPerpGridTri = gridTriBase * Math.sin(Math.toRadians(theta));

			double y3 = y4 - heightPerpGridTri;
			double y2 = y1 - heightPerpGridTri;

			deltaX = heightPerpGridTri / Math.tan(Math.toRadians(90 - theta));

			double x3 = x4 + deltaX;
			double x2 = x1 + deltaX;

			spoke.x1 = spoke.x1a = spoke.x1al = x1;
			spoke.x4 = spoke.x4a = spoke.x4al = x4;
			spoke.x2 = spoke.x2a = spoke.x2cl = x2;
			spoke.x3 = spoke.x3a = spoke.x3cl = x3;
			spoke.centerXs = centerXs;
			spoke.centerXe = centerXe;

			spoke.y1 = spoke.y1a = spoke.y1al = y1;
			spoke.y4 = spoke.y4a = spoke.y4al = y4;
			spoke.y2 = spoke.y2a = spoke.y2cl = y2;
			spoke.y3 = spoke.y3a = spoke.y3cl = y3;
			spoke.centerYs = centerYs;
			spoke.centerYe = centerYe;

			spoke.partForm = 1;
			spoke.orientation = 1;
			spoke.partDimB = myThick;
			spoke.myParent = dlo;
			spoke.myFrame2 = dlo.myFrame2;
			spoke.whichPos = 2;
			spoke.exists = 1;
			spoke.thickness = myThick;
			spoke.exists = 1;
			spoke.cOrM = 7;
			spoke = doGridsLevels(dlo, spoke);
			spoke.length = SpokeLength;

			spoke.isNew = true;

			spoke.myParent = dlo;
			spoke.rowCol = myHM.rowCol;
			spoke.startPos = myHM.rowCol;
			spoke.endPos = myHM.rowCol;
			spoke.seq = spoke.startPos + 100;

			this.doGridPolygon(spoke);
			spoke.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

			if (type == 1 || type == 2) {
				dlo.gridPartsS.add(spoke);
			}

			// /////////////////////////////////////////////////////////////////

			Profiles spoke2 = new Profiles();

			arcF = new Arc2D.Double(dlo.top1Part.bkgrdStartX,
					dlo.top1Part.bkgrdStartY, dlo.top1Part.bkgrdWidth,
					dlo.top1Part.bkgrdHeight, dlo.top1Part.startAngle,
					dlo.top1Part.endAngle, Arc2D.OPEN);

			myRect = arcF.getBounds2D();

			y4 = dlo.bY2;// myRect.getMaxY();
			x4 = dlo.bX2;// myRect.getMaxX();

			arcF = new Arc2D.Double(myHM.bkgrdStartXA, myHM.bkgrdStartYA,
					myHM.bkgrdWidthA, myHM.bkgrdHeightA, myHM.startAngleA,
					myHM.endAngleA, Arc2D.OPEN);

			myRect = arcF.getBounds2D();

			y1 = myRect.getMaxY();
			x1 = myRect.getMaxX();

			triangleH = y1 - y4;
			triangleBase = x4 - x1;

			theta = Math.toDegrees(Math.atan(triangleH / triangleBase));

			SpokeLength = triangleBase / Math.cos(theta);

			gridTriHyp = myThick / 2 / Math.sin(Math.toRadians(theta));

			gridTriBase = gridTriHyp * Math.cos(Math.toRadians(theta));

			heightPerpGridTri = gridTriBase * Math.sin(Math.toRadians(theta));

			centerYs = y1 - heightPerpGridTri;

			centerYe = y4 - heightPerpGridTri;

			deltaX = heightPerpGridTri / Math.tan(Math.toRadians(90 - theta));

			centerXs = x1 - deltaX;
			centerXe = x4 - deltaX;

			gridTriHyp = myThick / Math.sin(Math.toRadians(theta));

			gridTriBase = gridTriHyp * Math.cos(Math.toRadians(theta));

			heightPerpGridTri = gridTriBase * Math.sin(Math.toRadians(theta));

			y2 = y1 - heightPerpGridTri;
			y3 = y4 - heightPerpGridTri;

			deltaX = heightPerpGridTri / Math.tan(Math.toRadians(90 - theta));

			x2 = x1 - deltaX;
			x3 = x4 - deltaX;

			spoke2.x1 = spoke2.x1a = spoke2.x1al = x1;
			spoke2.x4 = spoke2.x4a = spoke2.x4al = x4;
			spoke2.x2 = spoke2.x2a = spoke2.x2cl = x2;
			spoke2.x3 = spoke2.x3a = spoke2.x3cl = x3;
			spoke2.centerXs = centerXs;
			spoke2.centerXe = centerXe;

			spoke2.y1 = spoke2.y1a = spoke2.y1al = y1;
			spoke2.y4 = spoke2.y4a = spoke2.y4al = y4;
			spoke2.y2 = spoke2.y2a = spoke2.y2cl = y2;
			spoke2.y3 = spoke2.y3a = spoke2.y3cl = y3;
			spoke2.centerYs = centerYs;
			spoke2.centerYe = centerYe;

			spoke2.partForm = 1;
			spoke2.orientation = 1;
			spoke2.partDimB = myThick;
			spoke2.myParent = dlo;
			spoke2.myFrame2 = dlo.myFrame2;
			spoke2.whichPos = 2;
			spoke2.exists = 1;
			spoke2.thickness = myThick;
			spoke2.exists = 1;
			spoke2.cOrM = 7;
			spoke2 = doGridsLevels(dlo, spoke2);
			spoke2.length = SpokeLength;

			spoke2.isNew = true;

			spoke2.myParent = dlo;
			spoke2.rowCol = myHM.rowCol;
			spoke2.startPos = myHM.rowCol;
			spoke2.endPos = myHM.rowCol;
			spoke2.seq = spoke2.startPos + 100;

			this.doGridPolygon(spoke2);
			spoke2.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

			if (type == 1 || type == 3) {
				dlo.gridPartsS.add(spoke2);
			}
		}

	}

	public Profiles doHRNew(final DLO dlo, final Profiles myHM,
			final Profiles myVS, final Profiles myVE) {

		myHM.partForm = 2;

		deduct1 = myVS.x1 - dlo.startingX;

		final Profiles myLastV = myVE;
		myLastV.myFrame2 = dlo.myFrame2;

		yFirst = this.intersectY(myVS.x1, myVS.y1, myVS.x4, 500, dlo.startingX,
				dlo.startingY, dlo.centerPointX, dlo.startingY);
		// dlo.centerPointY);

		yLast = this.intersectY(myLastV.x2, myLastV.y2, myLastV.x3, 500,
				dlo.bX2, dlo.bY2, dlo.centerPointX, dlo.bY2);
		// dlo.centerPointY);

		deduct2 = dlo.bX2 - myLastV.x2;

		myHM.bkgrdWidth = dlo.top1Part.bkgrdWidth - deduct1 - deduct2;

		myHM.radius1 = dlo.radius1 - deduct1;// myHM.bkgrdWidth/2;

		myHM.radius1A = myHM.radius1 - myHM.thickness;// myHM.bkgrdWidth/2;

		myHM.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;
		myHM.bkgrdStartY = dlo.highestY + deduct1;

		myHM.focal1X = myHM.focal1XBA = myHM.focal1XA = dlo.centerPointX;

		myHM.focal1Y = myHM.focal1YBA = myHM.focal1YA = dlo.centerPointY;

		myHM.focal2X = myHM.focal2XBA = myHM.focal2XA = dlo.centerPointX2;

		myHM.focal2Y = myHM.focal2YBA = myHM.focal2YA = dlo.centerPointY2;

		myHM.bkgrdHeight = 2 * myHM.radius1;

		myHM.bkgrdStartXA = myHM.bkgrdStartXBA = myHM.bkgrdStartX
				+ myHM.thickness;

		myHM.bkgrdStartYA = myHM.bkgrdStartYBA = myHM.bkgrdStartY
				+ myHM.thickness;

		myHM.bkgrdWidthA = myHM.bkgrdWidthBA = myHM.radius1A * 2;

		myHM.bkgrdHeightA = myHM.bkgrdHeightBA = myHM.radius1A * 2;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		double[] anglesOut;
		double[] anglesIn;

		anglesOut = createShape.getArchesAngles(myVS.x1, myLastV.x2, yFirst,
				yLast, myHM.radius1, myHM.focal1X, myHM.focal1Y, false, false);

		anglesIn = createShape.getArchesAngles(myVS.x2, myLastV.x1, yFirst,
				yLast, myHM.radius1A, myHM.focal1X, myHM.focal1Y, false, false);

		createShape = null;

		myHM.startAngle = anglesOut[0];
		myHM.endAngle = anglesOut[1];
		myHM.startYC = anglesOut[2];
		myHM.endYC = anglesOut[3];

		myHM.startAngleA = anglesIn[0];
		myHM.endAngleA = anglesIn[1];
		myHM.startYA = anglesIn[2];
		myHM.endYA = anglesIn[3];
		myHM.startPos = 1;
		myHM.endPos = dlo.xCols;

		return myHM;
	}

	public Profiles doQRLNew(final DLO dlo, final Profiles myHM,
			final Profiles myVS) {

		myHM.partForm = 2;
		myHM.myFrame2 = dlo.myFrame2;

		deduct1 = myVS.x1 - dlo.startingX;

		yFirst = yLast = this.intersectY(myVS.x1, myVS.y1, myVS.x4, 500,
				dlo.startingX, dlo.startingY, dlo.centerPointX, dlo.startingY);
		// dlo.centerPointY);

		myHM.bkgrdWidth = dlo.top1Part.bkgrdWidth - 2 * deduct1;

		myHM.radius1 = dlo.top1Part.radius1 - deduct1;// myHM.bkgrdWidth/2;

		myHM.bkgrdHeight = 2 * myHM.radius1;

		myHM.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		myHM.bkgrdStartY = dlo.highestY + deduct1;

		myHM.focal1X = myHM.focal1XBA = myHM.focal1XA = dlo.centerPointX;

		myHM.focal1Y = myHM.focal1YBA = myHM.focal1YA = dlo.centerPointY;

		myHM.radius1A = myHM.radius1 - myHM.thickness;

		myHM.bkgrdStartXA = myHM.bkgrdStartXBA = myHM.bkgrdStartX
				+ myHM.thickness;

		myHM.bkgrdStartYA = myHM.bkgrdStartYBA = myHM.bkgrdStartY
				+ myHM.thickness;

		myHM.bkgrdWidthA = myHM.bkgrdWidthBA = myHM.radius1A * 2;

		myHM.bkgrdHeightA = myHM.bkgrdHeightBA = myHM.radius1A * 2;

		myHM.focal2X = myHM.focal2XBA = myHM.focal2XA = dlo.centerPointX2;

		myHM.focal2Y = myHM.focal2YBA = myHM.focal2YA = dlo.centerPointY2;

		double[] anglesOutE;
		double[] anglesInE;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		anglesOutE = createShape
				.getArchesAngles(myVS.x1, myVS.x4, myVS.y1, myVS.y4,
						myHM.radius1, myHM.focal1X, myHM.focal1Y, false, false);

		anglesInE = createShape.getArchesAngles(myVS.x2, myVS.x3, myVS.y2,
				myVS.y3, myHM.radius1A, myHM.focal1X, myHM.focal1Y, false,
				false);

		double[] anglesOutS;
		double[] anglesInS;

		anglesOutS = createShape.getArchesAngles(dlo.rightPart.startXC,
				dlo.rightPart.endXC, dlo.rightPart.startYC,
				dlo.rightPart.endYC, myHM.radius1, myHM.focal1X, myHM.focal1Y,
				false, false);

		anglesInS = createShape.getArchesAngles(dlo.rightPart.startXC,
				dlo.rightPart.endXC, dlo.rightPart.startYC,
				dlo.rightPart.endYC, myHM.radius1A, myHM.focal1X, myHM.focal1Y,
				false, false);

		createShape = null;

		myHM.startAngle = anglesOutS[0];
		myHM.endAngle = anglesOutE[0] - myHM.startAngle;
		myHM.startYC = anglesOutE[2];
		myHM.endYC = anglesOutS[3];

		myHM.startAngleA = myHM.startAngleBA = anglesInS[0];
		if (anglesInE[0] < 90 && anglesInE[1] > 90) {
			myHM.endAngleA = myHM.endAngleBA = anglesInE[1] - myHM.startAngleA;
		} else if (anglesInE[0] > 90) {
			myHM.endAngleA = myHM.endAngleBA = anglesInE[0] - myHM.startAngleA;
		}

		myHM.startYA = myHM.startYBA = anglesInE[2];
		myHM.endYA = myHM.endYBA = anglesInS[3];

		return myHM;
	}

	public Profiles doQRRNew(final DLO dlo, final Profiles myHM,
			final Profiles myV) {

		myHM.partForm = 2;
		myHM.myFrame2 = dlo.myFrame2;

		deduct1 = dlo.bX2 - myV.x2;

		yFirst = this.intersectY(myV.x2, myV.y2, myV.x3, myV.y3, dlo.bX2,
				dlo.bY2, dlo.startingX, dlo.bY2);

		myHM.bkgrdWidth = dlo.top1Part.bkgrdWidth - 2 * deduct1;

		myHM.radius1 = dlo.radius1 - deduct1;// myHM.bkgrdWidth/2;

		myHM.radius1A = myHM.radius1 - myHM.thickness;// myHM.bkgrdWidth/2;

		myHM.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		myHM.bkgrdStartY = dlo.highestY + deduct1;

		myHM.focal1X = myHM.focal1XBA = myHM.focal1XA = dlo.centerPointX;

		myHM.focal1Y = myHM.focal1YBA = myHM.focal1YA = dlo.centerPointY;

		myHM.focal2X = myHM.focal2XBA = myHM.focal2XA = dlo.centerPointX2;

		myHM.focal2Y = myHM.focal2YBA = myHM.focal2YA = dlo.centerPointY2;

		myHM.bkgrdHeight = 2 * myHM.radius1;

		myHM.bkgrdStartXA = myHM.bkgrdStartXBA = myHM.bkgrdStartX
				+ myHM.thickness;

		myHM.bkgrdStartYA = myHM.bkgrdStartYBA = myHM.bkgrdStartY
				+ myHM.thickness;

		myHM.bkgrdWidthA = myHM.bkgrdWidthBA = myHM.radius1A * 2;

		myHM.bkgrdHeightA = myHM.bkgrdHeightBA = myHM.radius1A * 2;

		double[] anglesOutE;
		double[] anglesInE;

		double[] anglesOutS;
		double[] anglesInS;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);
		anglesOutS = createShape.getArchesAngles(myV.x2, myV.x3, myV.y2,
				myV.y3, myHM.radius1, myHM.focal1X, myHM.focal1Y, false, false);

		anglesInS = createShape.getArchesAngles(myV.x2, myV.x3, myV.y2, myV.y3,
				myHM.radius1A, myHM.focal1X, myHM.focal1Y, false, false);

		anglesOutE = createShape.getArchesAngles(dlo.leftPart.startXC,
				dlo.leftPart.endXC, dlo.leftPart.startYC, dlo.leftPart.endYC,
				myHM.radius1, myHM.focal1X, myHM.focal1Y, false, false);

		anglesInE = createShape.getArchesAngles(dlo.leftPart.startXC,
				dlo.leftPart.endXC, dlo.leftPart.startYC, dlo.leftPart.endYC,
				myHM.radius1A, myHM.focal1X, myHM.focal1Y, false, false);

		createShape = null;

		myHM.startAngle = anglesOutS[0];
		myHM.endAngle = anglesOutE[0] - myHM.startAngle;
		myHM.startYC = anglesOutE[2];
		myHM.endYC = anglesOutS[3];

		myHM.startAngleA = myHM.startAngleBA = anglesInS[0];
		myHM.endAngleA = myHM.endAngleBA = anglesInE[0] - myHM.startAngleA;
		myHM.startYA = myHM.startYBA = anglesInE[2];
		myHM.endYA = myHM.endYBA = anglesInS[3];

		return myHM;
	}

	public Profiles doGeneralPathMullionH(Profiles myHM) {

		myHM.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		Profiles myNewMullion = new Profiles();

		myNewMullion = this.cloneMullion(myNewMullion, myHM);

		final Polygon m = new Polygon();

		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		m.addPoint((int) myNewMullion.x2a, (int) myNewMullion.y2a);
		m.addPoint((int) myNewMullion.x3a, (int) myNewMullion.y3a);
		m.addPoint((int) myNewMullion.x4a, (int) myNewMullion.y4a);
		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);

		myNewMullion.gp.reset();
		myNewMullion.poly.reset();
		myNewMullion.gp.append(m, false);
		myNewMullion.poly = m;

		return myNewMullion;
	}

	/**
	 * Do mullions from parts Vertical
	 * 
	 * @param dlo
	 *            , DLO
	 * @return DLO
	 */
	public DLO doMullionsFromPartsV(DLO dlo) {

		AddMullionV mV = new AddMullionV(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);

		new AddMullionH(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);

		dlo.bOpeningObject.mullions.clear();

		Object[] myVs = dlo.gridPartsV.toArray();
		// No cont = 0, V = 1, H = 2, V&H = 3
		if (myGrid.getContinuityIn() == 1 || myGrid.getContinuityIn() == 3) { // V
																				// Cont
																				// or
																				// H&V
																				// Cont.

			Profiles myNewVM = null;
			boolean found = false;
			boolean fin = false;

			double y4N = 0;

			Object[] connectors = new Object[4];

			for (int c = 1; c < dlo.xCols; c++) {

				int startPos = 0;
				int endPos = 0;
				int lastEval = 0;
				fin = false;

				for (Object myV : myVs) {

					if (fin) {
						break;
					}

					found = false;

					if (((Profiles) myV).rowCol == c
							&& !((Profiles) myV).remove
							&& ((Profiles) myV).startPos > endPos) {

						myNewVM = new Profiles();
						found = true;
						startPos = ((Profiles) myV).startPos;
						endPos = ((Profiles) myV).endPos;
						myNewVM = this.cloneMullion(myNewVM, (Profiles) myV);
						myNewVM.startPos = startPos;

						myNewVM.centerXs = ((Profiles) myV).centerXs;
						myNewVM.centerYs = ((Profiles) myV).centerYs;

						myNewVM.x1al = myNewVM.x1a = myNewVM.x1 = ((Profiles) myV).x1al;
						myNewVM.x2cl = myNewVM.x2a = myNewVM.x2 = ((Profiles) myV).x2cl;

						myNewVM.y1al = myNewVM.y1a = myNewVM.y1 = ((Profiles) myV).y1al;
						myNewVM.y2cl = myNewVM.y2a = myNewVM.y2 = ((Profiles) myV).y2cl;

						myNewVM.endPos = endPos;

						myNewVM.x4al = myNewVM.x4a = myNewVM.x4 = ((Profiles) myV).x4al;
						myNewVM.x3cl = myNewVM.x3a = myNewVM.x3 = ((Profiles) myV).x3cl;

						myNewVM.y4al = myNewVM.y4a = myNewVM.y4 = ((Profiles) myV).y4al;
						myNewVM.y3cl = myNewVM.y3a = myNewVM.y3 = ((Profiles) myV).y3cl;

						myNewVM.centerXe = ((Profiles) myV).centerXe;
						myNewVM.centerYe = ((Profiles) myV).centerYe;

					}

					if (found) {

						for (int i = 0; i < myVs.length; i++) {

							if (((Profiles) myVs[i]).rowCol == c
									&& ((Profiles) myVs[i]).startPos > endPos
									&& !((Profiles) myVs[i]).remove) {

								endPos = ((Profiles) myVs[i]).endPos;

								myNewVM.endPos = endPos;

								y4N = ((Profiles) myVs[i]).y1al;

								myNewVM.x4al = myNewVM.x4 = myNewVM.x4a = ((Profiles) myVs[i]).x4al;
								myNewVM.x3cl = myNewVM.x3 = myNewVM.x3a = ((Profiles) myVs[i]).x3cl;

								myNewVM.y4al = myNewVM.y4 = myNewVM.y4a = ((Profiles) myVs[i]).y4al;
								myNewVM.y3cl = myNewVM.y3 = myNewVM.y3a = ((Profiles) myVs[i]).y3cl;

								myNewVM.centerXe = ((Profiles) myVs[i]).centerXe;
								myNewVM.centerYe = ((Profiles) myVs[i]).centerYe;

								myNewVM.notches.add(mV.addNotching(22, false,
										false, false, false, false, false,
										false, false, 2,
										((Profiles) myVs[i]).startPos, 3, 3,
										myNewVM.x1al, y4N - myNewVM.thickness,
										myNewVM.x4al, y4N, myNewVM.x4, y4N,
										myNewVM.centerXe, y4N, myNewVM.x3, y4N,
										myNewVM.x3cl, y4N, myNewVM.x2cl, y4N
												- myNewVM.thickness));

							} else if (((Profiles) myVs[i]).rowCol == c
									&& ((Profiles) myVs[i]).startPos > endPos
									&& ((Profiles) myVs[i]).remove) {
								lastEval = ((Profiles) myVs[i]).endPos;
								break;
							}

						}

						this.addVM(dlo, startPos, endPos, myNewVM);
						if (myNewVM.endPos == dlo.yRows
								|| lastEval == dlo.yRows) {
							fin = true;
							break;
						}
					}
				}
			}

		} else { // Not Cotinuous or H Cont.

			for (Object myV : myVs) {
				((Profiles) myV).myFrame2 = myFrame2;
				dlo.bOpeningObject.mullions.add(myV);
			}
		}

		return dlo;
	}

	public DLO doMergeGridParts(DLO dlo) {

		AddMullionV mV = new AddMullionV(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);

		new AddMullionH(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);

		// dlo.bOpeningObject.mullions.clear();

		Object[] myVs = dlo.gridPartsV.toArray();
		dlo.gridPartsV.clear();

		Profiles myNewVM = null;
		boolean found = false;
		boolean fin = false;

		double y4N = 0;

		Object[] connectors = new Object[4];

		for (int c = 1; c < dlo.xCols; c++) {

			int startPos = 0;
			int endPos = 0;
			int lastEval = 0;
			fin = false;

			for (Object myV : myVs) {

				if (fin) {
					break;
				}

				found = false;

				if (((Profiles) myV).rowCol == c && !((Profiles) myV).remove
						&& ((Profiles) myV).startPos > endPos) {

					myNewVM = new Profiles();
					found = true;
					startPos = ((Profiles) myV).startPos;
					endPos = ((Profiles) myV).endPos;
					myNewVM = this.cloneMullion(myNewVM, (Profiles) myV);
					myNewVM.startPos = startPos;

					myNewVM.centerXs = ((Profiles) myV).centerXs;
					myNewVM.centerYs = ((Profiles) myV).centerYs;

					myNewVM.x1al = myNewVM.x1a = myNewVM.x1 = ((Profiles) myV).x1al;
					myNewVM.x2cl = myNewVM.x2a = myNewVM.x2 = ((Profiles) myV).x2cl;

					myNewVM.y1al = myNewVM.y1a = myNewVM.y1 = ((Profiles) myV).y1al;
					myNewVM.y2cl = myNewVM.y2a = myNewVM.y2 = ((Profiles) myV).y2cl;

					myNewVM.endPos = endPos;

					myNewVM.x4al = myNewVM.x4a = myNewVM.x4 = ((Profiles) myV).x4al;
					myNewVM.x3cl = myNewVM.x3a = myNewVM.x3 = ((Profiles) myV).x3cl;

					myNewVM.y4al = myNewVM.y4a = myNewVM.y4 = ((Profiles) myV).y4al;
					myNewVM.y3cl = myNewVM.y3a = myNewVM.y3 = ((Profiles) myV).y3cl;

					myNewVM.centerXe = ((Profiles) myV).centerXe;
					myNewVM.centerYe = ((Profiles) myV).centerYe;

				}

				if (found) {

					for (int i = 0; i < myVs.length; i++) {

						if (((Profiles) myVs[i]).rowCol == c
								&& ((Profiles) myVs[i]).startPos > endPos
								&& !((Profiles) myVs[i]).remove) {

							endPos = ((Profiles) myVs[i]).endPos;

							myNewVM.endPos = endPos;

							y4N = ((Profiles) myVs[i]).y1al;

							myNewVM.x4al = myNewVM.x4 = myNewVM.x4a = ((Profiles) myVs[i]).x4al;
							myNewVM.x3cl = myNewVM.x3 = myNewVM.x3a = ((Profiles) myVs[i]).x3cl;

							myNewVM.y4al = myNewVM.y4 = myNewVM.y4a = ((Profiles) myVs[i]).y4al;
							myNewVM.y3cl = myNewVM.y3 = myNewVM.y3a = ((Profiles) myVs[i]).y3cl;

							myNewVM.centerXe = ((Profiles) myVs[i]).centerXe;
							myNewVM.centerYe = ((Profiles) myVs[i]).centerYe;

							myNewVM.notches.add(mV.addNotching(22, false,
									false, false, false, false, false, false,
									false, 2, ((Profiles) myVs[i]).startPos, 3,
									3, myNewVM.x1al, y4N - myNewVM.thickness,
									myNewVM.x4al, y4N, myNewVM.x4, y4N,
									myNewVM.centerXe, y4N, myNewVM.x3, y4N,
									myNewVM.x3cl, y4N, myNewVM.x2cl, y4N
											- myNewVM.thickness));

						} else if (((Profiles) myVs[i]).rowCol == c
								&& ((Profiles) myVs[i]).startPos > endPos
								&& ((Profiles) myVs[i]).remove) {
							lastEval = ((Profiles) myVs[i]).endPos;
							break;
						}

					}

					this.addMergedGridPartsV(dlo, startPos, endPos, myNewVM);
					if (myNewVM.endPos == dlo.yRows || lastEval == dlo.yRows) {
						fin = true;
						break;
					}
				}
			}

		}

		return dlo;
	}

	public Profiles calcGridLength(Profiles mullion) {

		mullion.myFrame2 = this.myFrame2;

		if (mullion.partForm == 1) {
			mullion.length = Math
					.sqrt(Math.pow((Math
							.max(mullion.centerXe, mullion.centerXs) - Math
							.min(mullion.centerXe, mullion.centerXs)), 2)
							+ Math.pow((Math.max(mullion.centerYe,
									mullion.centerYs) - Math.min(
									mullion.centerYe, mullion.centerYs)), 2));
		} else {
			mullion.length = 2 * Math.PI * mullion.radius1
					* Math.max(mullion.endAngle, mullion.endAngleA) / 360;
		}

		mullion.length = new BigDecimal(mullion.length).divide(
				new BigDecimal(1), 12, BigDecimal.ROUND_UP).doubleValue();
		mullion.lengthM = (new BigDecimal(mullion.length).divide(
				myFrame2.metricscale, 20, BigDecimal.ROUND_UP)).intValue();
		mullion.lengthI = (new BigDecimal(mullion.length).divide(
				myFrame2.imperialscale, 20, BigDecimal.ROUND_UP)).intValue();

		mullion.bom.clear();
		mullion.clearBomForProfile();

		return mullion;
	}

	public Collection resetRecalcMullionBom(Profiles mullion, DLO dlo) {

		mullion.myFrame2 = this.myFrame2;

		if (mullion.partForm == 1) {
			mullion.length = Math
					.sqrt(Math.pow((Math
							.max(mullion.centerXe, mullion.centerXs) - Math
							.min(mullion.centerXe, mullion.centerXs)), 2)
							+ Math.pow((Math.max(mullion.centerYe,
									mullion.centerYs) - Math.min(
									mullion.centerYe, mullion.centerYs)), 2));
		} else {
			mullion.length = 2 * Math.PI * mullion.radius1
					* Math.max(mullion.endAngle, mullion.endAngleA) / 360;
		}

		mullion.length = new BigDecimal(mullion.length).divide(
				new BigDecimal(1), 12, BigDecimal.ROUND_UP).doubleValue();
		mullion.lengthM = (new BigDecimal(mullion.length).divide(
				myFrame2.metricscale, 20, BigDecimal.ROUND_UP)).intValue();
		mullion.lengthI = (new BigDecimal(mullion.length).divide(
				myFrame2.imperialscale, 20, BigDecimal.ROUND_UP)).intValue();

		mullion.bom.clear();
		mullion.clearBomForProfile();

		BillOfMat bom = new BillOfMat(this.myFrame2.executePartRules);

		Collection bomRecords = new ArrayList();

		bom = bom.setBomCommonElements(mullion, myProfile, dlo, mullion, null,
				false, null, 1, 0, 0, 0, 0, 0);
		this.myFrame2.executePartRules.calcCostPrice(1d, myProfile, bom);

		if (inGlass) {
			bomRecords.add(bom);
		}

		if (inOpening) {
			bomRecords.add(bom);
			bomRecords.add(bom);
		}

		if (myGrid.getPartidSim() > 0 && inGlass && inOpening) {
			bom = bom.setBomCommonElements(mullion, mySimProfile, dlo, mullion,
					null, false, null, 1, 0, 0, 0, 0, 0);
			this.myFrame2.executePartRules.calcCostPrice(1d, mySimProfile, bom);

			if (inGlass) {
				bomRecords.add(bom);
			}
			if (inOpening) {
				bomRecords.add(bom);
				bomRecords.add(bom);
			}
		}

		return bomRecords;
	}

	public Collection resetRecalcConnectorsBom(DLO dlo) {

		BillOfMat bom = new BillOfMat(this.myFrame2.executePartRules);

		Collection bomRecords = new ArrayList();

		if (myGrid.getPartidT() != null && myGrid.getPartidT() > 0
				&& dlo.tConnectors > 0 && myGrid.getPartidT() > 0) {
			bom = bom.setBomCommonElements(null, myT, dlo, null, null, false,
					null, dlo.tConnectors, 0, 0, 0, 0, -3);

			this.myFrame2.executePartRules.calcCostPrice(1d, myT, bom);

			if (inGlass) {
				bomRecords.add(bom);
			}
			if (inOpening) {
				bomRecords.add(bom);
				bomRecords.add(bom);
			}
		}

		if (myGrid.getPartidL() != null && myGrid.getPartidL() > 0
				&& dlo.lConnectors > 0 && myGrid.getPartidL() > 0) {
			bom = bom.setBomCommonElements(null, myL, dlo, null, null, false,
					null, dlo.lConnectors, 0, 0, 0, 0, -1);

			this.myFrame2.executePartRules.calcCostPrice(1d, myL, bom);

			if (inGlass) {
				bomRecords.add(bom);
			}
			if (inOpening) {
				bomRecords.add(bom);
				bomRecords.add(bom);
			}
		}

		if (myGrid.getPartidCross() != null && myGrid.getPartidCross() > 0
				&& dlo.crossConnectors > 0 && myGrid.getPartidCross() > 0) {
			bom = bom.setBomCommonElements(null, myCross, dlo, null, null,
					false, null, dlo.crossConnectors, 0, 0, 0, 0, -2);

			this.myFrame2.executePartRules.calcCostPrice(1d, myCross, bom);

			if (inGlass) {
				bomRecords.add(bom);
			}
			if (inOpening) {
				bomRecords.add(bom);
				bomRecords.add(bom);
			}
		}

		// this.myFrame2.jobItem.bom.addAll(bomRecords);

		return bomRecords;
	}

	/**
	 * Do mullions from Parts Horizontal
	 * 
	 * @param dlo
	 *            , DLO
	 * @return DLO
	 */
	public DLO doMullionsFromPartsH(DLO dlo) {

		AddMullionV mV = new AddMullionV(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);
		new AddMullionH(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);

		dlo.bOpeningObject.mullionsH.clear();

		Object[] myHs = dlo.gridPartsH.toArray();

		// No cont = 0, V = 1, H = 2, V&H = 3
		if (myGrid.getContinuityIn() == 2 || myGrid.getContinuityIn() == 3) {

			Profiles myNewHM = null;
			boolean found = false;
			boolean fin = false;
			double x4N = 0;

			for (int c = 1; c < dlo.yRows; c++) {

				fin = false;
				int startPos = 0;
				int endPos = 0;
				int lastEval = 0;

				for (Object myH : myHs) {

					if (!((Profiles) myH).isExtra) {

						if (fin) {
							break;
						}

						found = false;

						if (((Profiles) myH).rowCol == c
								&& !((Profiles) myH).remove
								&& ((Profiles) myH).startPos > endPos) {

							myNewHM = new Profiles();
							found = true;
							startPos = ((Profiles) myH).startPos;
							endPos = ((Profiles) myH).endPos;
							myNewHM = this
									.cloneMullion(myNewHM, (Profiles) myH);
							this.setNewGridCloneXYs(myNewHM, startPos, endPos,
									myH);

						}

						if (found) {

							for (int i = 0; i < myHs.length; i++) {

								if (((Profiles) myHs[i]).rowCol == c
										&& ((Profiles) myHs[i]).startPos > endPos
										&& !((Profiles) myHs[i]).remove) {

									endPos = ((Profiles) myHs[i]).endPos;
									myNewHM.endPos = endPos;
									x4N = ((Profiles) myHs[i]).x1al;
									this.setNewGridXYs(myHs, myNewHM, i);
									this.doNotches(mV, myHs, myNewHM, x4N, i);

								} else if (((Profiles) myHs[i]).rowCol == c
										&& ((Profiles) myHs[i]).startPos > endPos
										&& ((Profiles) myHs[i]).remove) {
									lastEval = ((Profiles) myHs[i]).endPos;
									break;
								}

							}
							if (myNewHM.endAngle < 0) {
								myNewHM.endAngle = Math.abs(myNewHM.endAngle);
							}
							dlo = this.addHM(dlo, myNewHM, startPos, endPos);

							if (myNewHM.endPos == dlo.xCols
									|| lastEval == dlo.xCols) {
								fin = true;
								break;
							}
						}

					}
				}
			}

			// ////DO Extra

			int startPos = 0;
			int endPos = 0;
			int myRowCol = 0;

			for (Object myH : myHs) {

				if (((Profiles) myH).isExtra) {
					found = false;
					myRowCol = ((Profiles) myH).rowCol;

					if (!((Profiles) myH).remove
							&& ((Profiles) myH).startPos > endPos) {

						myNewHM = new Profiles();
						found = true;
						startPos = ((Profiles) myH).startPos;
						endPos = ((Profiles) myH).endPos;
						myNewHM = this.cloneMullion(myNewHM, (Profiles) myH);
						this.setNewGridCloneXYs(myNewHM, startPos, endPos, myH);

					}
					if (found) {

						for (int i = 0; i < myHs.length; i++) {

							if (((Profiles) myHs[i]).isExtra
									&& ((Profiles) myHs[i]).rowCol == myRowCol
									&& ((Profiles) myHs[i]).startPos > endPos
									&& !((Profiles) myHs[i]).remove) {

								endPos = ((Profiles) myHs[i]).endPos;
								myNewHM.endPos = endPos;
								x4N = ((Profiles) myHs[i]).x2cl;
								this.setNewGridXYs(myHs, myNewHM, i);
								this.doNotches(mV, myHs, myNewHM, x4N, i);

							} else if (((Profiles) myHs[i]).startPos > endPos
									&& ((Profiles) myHs[i]).remove) {
								break;
							}

						}

						dlo = this.addHM(dlo, myNewHM, startPos, endPos);
					}

				}

			}

		} else {
			// Not Cotinuous or H Cont.
			for (Object myH : myHs) {
				((Profiles) myH).myFrame2 = myFrame2;
				dlo.bOpeningObject.mullionsH.add(myH);
			}
		}

		return dlo;
	}

	public DLO doMergeGridPartsH(DLO dlo) {

		AddMullionV mV = new AddMullionV(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);
		new AddMullionH(dlo.bOpeningObject, myFrame2.jobItem,
				dlo.myParent.myFrame2, 7);

		// dlo.bOpeningObject.mullionsH.clear();

		Object[] myHs = dlo.gridPartsH.toArray();
		dlo.gridPartsH.clear();

		Profiles myNewHM = null;
		boolean found = false;
		boolean fin = false;
		double x4N = 0;

		for (int c = 1; c < dlo.yRows; c++) {

			fin = false;
			int startPos = 0;
			int endPos = 0;
			int lastEval = 0;

			for (Object myH : myHs) {

				if (!((Profiles) myH).isExtra) {

					if (fin) {
						break;
					}

					found = false;

					if (((Profiles) myH).rowCol == c
							&& !((Profiles) myH).remove
							&& ((Profiles) myH).startPos > endPos) {

						myNewHM = new Profiles();
						found = true;
						startPos = ((Profiles) myH).startPos;
						endPos = ((Profiles) myH).endPos;
						myNewHM = this.cloneMullion(myNewHM, (Profiles) myH);
						this.setNewGridCloneXYs(myNewHM, startPos, endPos, myH);

					}

					if (found) {

						for (int i = 0; i < myHs.length; i++) {

							if (((Profiles) myHs[i]).rowCol == c
									&& ((Profiles) myHs[i]).startPos > endPos
									&& !((Profiles) myHs[i]).remove) {

								endPos = ((Profiles) myHs[i]).endPos;
								myNewHM.endPos = endPos;
								x4N = ((Profiles) myHs[i]).x1al;
								this.setNewGridXYs(myHs, myNewHM, i);
								this.doNotches(mV, myHs, myNewHM, x4N, i);

							} else if (((Profiles) myHs[i]).rowCol == c
									&& ((Profiles) myHs[i]).startPos > endPos
									&& ((Profiles) myHs[i]).remove) {
								lastEval = ((Profiles) myHs[i]).endPos;
								break;
							}

						}
						if (myNewHM.endAngle < 0) {
							myNewHM.endAngle = Math.abs(myNewHM.endAngle);
						}
						dlo = this
								.addGrisPartsH(dlo, myNewHM, startPos, endPos);

						if (myNewHM.endPos == dlo.xCols
								|| lastEval == dlo.xCols) {
							fin = true;
							break;
						}
					}

				}
			}
		}

		// ////DO Extra

		int startPos = 0;
		int endPos = 0;
		int myRowCol = 0;

		for (Object myH : myHs) {

			if (((Profiles) myH).isExtra) {
				found = false;
				myRowCol = ((Profiles) myH).rowCol;

				if (!((Profiles) myH).remove
						&& ((Profiles) myH).startPos > endPos) {

					myNewHM = new Profiles();
					found = true;
					startPos = ((Profiles) myH).startPos;
					endPos = ((Profiles) myH).endPos;
					myNewHM = this.cloneMullion(myNewHM, (Profiles) myH);
					this.setNewGridCloneXYs(myNewHM, startPos, endPos, myH);

				}
				if (found) {

					for (int i = 0; i < myHs.length; i++) {

						if (((Profiles) myHs[i]).isExtra
								&& ((Profiles) myHs[i]).rowCol == myRowCol
								&& ((Profiles) myHs[i]).startPos > endPos
								&& !((Profiles) myHs[i]).remove) {

							endPos = ((Profiles) myHs[i]).endPos;
							myNewHM.endPos = endPos;
							x4N = ((Profiles) myHs[i]).x2cl;
							this.setNewGridXYs(myHs, myNewHM, i);
							this.doNotches(mV, myHs, myNewHM, x4N, i);

						} else if (((Profiles) myHs[i]).startPos > endPos
								&& ((Profiles) myHs[i]).remove) {
							break;
						}

					}

					dlo = this.addGrisPartsH(dlo, myNewHM, startPos, endPos);
				}

			}

		}

		return dlo;
	}

	public DLO buildConnectors(DLO dlo) {

		boolean found = false;

		Collection connectors = new ArrayList();
		int connectorCount = 0;

		Object[] myVs = dlo.gridPartsV.toArray();
		Object[] myHs = dlo.gridPartsH.toArray();

		dlo.crossConnectors = 0;
		dlo.tConnectors = 0;
		dlo.lConnectors = 0;
		dlo.spacerConnectors = 0;
		dlo.hubConnector = 0;
		dlo.spokeConnectors = 0;

		for (int c = 1; c < dlo.xCols; c++) {

			int startPos = 0;
			int endPos = 0;
			int lastEval = 0;

			for (Object myV : myVs) {
				if (connectorCount > 1) {
					connectors.add(connectorCount);
				}

				connectorCount = 0;

				found = false;
				if (((Profiles) myV).rowCol == c
						&& ((Profiles) myV).startPos >= endPos) {

					found = true;
					startPos = ((Profiles) myV).startPos;
					endPos = ((Profiles) myV).endPos;
					connectorCount++;

				}

				if (found) {

					for (int i = 0; i < myVs.length; i++) {

						if (((Profiles) myVs[i]).rowCol == c
								&& ((Profiles) myVs[i]).startPos == endPos + 1
								&& !((Profiles) myVs[i]).remove) {

							endPos = ((Profiles) myVs[i]).endPos;
							connectorCount++;
							break;

						}

					}

					for (Object myH : myHs) {

						if (!((Profiles) myH).isExtra
								&& ((Profiles) myH).rowCol == ((Profiles) myV).endPos
								&& !((Profiles) myH).remove
								&& ((Profiles) myH).endPos == ((Profiles) myV).rowCol) {

							connectorCount++;

						}

						if (!((Profiles) myH).isExtra
								&& ((Profiles) myH).rowCol == ((Profiles) myV).endPos
								&& !((Profiles) myH).remove
								&& ((Profiles) myH).startPos == ((Profiles) myV).rowCol + 1) {

							connectorCount++;
							break;
						}

					}

				}

			}

		}

		for (Object myH : myHs) {
			if (((Profiles) myH).posCondition != 4) {
				dlo.spacerConnectors++;
			}
			if (((Profiles) myH).posCondition == 1) {
				dlo.spacerConnectors++;
			}
		}

		for (Object myV : myVs) {
			if (((Profiles) myV).posCondition != 4) {
				dlo.spacerConnectors++;
			}
			if (((Profiles) myV).posCondition == 1) {
				dlo.spacerConnectors++;
			}
		}

		Object[] cs = connectors.toArray();

		for (Object c : cs) {
			if (Integer.parseInt(c.toString()) == 2) {
				dlo.lConnectors++;
			} else if (Integer.parseInt(c.toString()) == 3) {
				dlo.tConnectors++;
			} else if (Integer.parseInt(c.toString()) == 4) {
				dlo.crossConnectors++;
			}
		}
		if (myGrid.getPartidspacer() == 0) {
			dlo.spacerConnectors = 0;
		}
		if (myGrid.getPartidCross() == 0) {
			dlo.crossConnectors = 0;
		}
		if (myGrid.getPartidL() == 0) {
			dlo.lConnectors = 0;
		}
		if (myGrid.getPartidT() == 0) {
			dlo.lConnectors = 0;
		}

		// we have 4 type of connectors: Spacer, + T L

		return dlo;
	}

	public void setNewGridCloneXYs(final Profiles myNewHM, final int startPos,
			final int endPos, final Object myH) {

		myNewHM.partForm = ((Profiles) myH).partForm;

		myNewHM.startPos = startPos;

		myNewHM.centerXs = ((Profiles) myH).centerXs;

		myNewHM.centerYs = ((Profiles) myH).centerYs;

		myNewHM.x1al = ((Profiles) myH).x1al;

		myNewHM.x2cl = ((Profiles) myH).x2cl;

		myNewHM.y1al = ((Profiles) myH).y1al;

		myNewHM.y2cl = ((Profiles) myH).y2cl;

		myNewHM.x1a = ((Profiles) myH).x1al;

		myNewHM.x2a = ((Profiles) myH).x2cl;

		myNewHM.y1a = ((Profiles) myH).y1al;

		myNewHM.y2a = ((Profiles) myH).y2cl;

		myNewHM.endPos = endPos;

		myNewHM.x4al = ((Profiles) myH).x4al;
		myNewHM.x3cl = ((Profiles) myH).x3cl;

		myNewHM.y4al = ((Profiles) myH).y4al;

		myNewHM.y3cl = ((Profiles) myH).y3cl;

		myNewHM.x4a = ((Profiles) myH).x4al;

		myNewHM.x3a = ((Profiles) myH).x3cl;

		myNewHM.y4a = ((Profiles) myH).y4al;

		myNewHM.y3a = ((Profiles) myH).y3cl;

		myNewHM.centerXe = ((Profiles) myH).centerXe;

		myNewHM.centerYe = ((Profiles) myH).centerYe;
	}

	public void setNewGridXYs(final Object[] myHs, final Profiles myNewHM,
			final int i) {

		myNewHM.x4al = myNewHM.x4 = ((Profiles) myHs[i]).x4al;
		myNewHM.x3cl = myNewHM.x3 = ((Profiles) myHs[i]).x3cl;

		myNewHM.y4al = myNewHM.y4 = ((Profiles) myHs[i]).y4al;
		myNewHM.y3cl = myNewHM.y3 = ((Profiles) myHs[i]).y3cl;

		myNewHM.x4a = ((Profiles) myHs[i]).x4al;
		myNewHM.x3a = ((Profiles) myHs[i]).x3cl;

		myNewHM.y4a = ((Profiles) myHs[i]).y4al;
		myNewHM.y3a = ((Profiles) myHs[i]).y3cl;
		myNewHM.centerXe = ((Profiles) myHs[i]).centerXe;
		myNewHM.centerYe = ((Profiles) myHs[i]).centerYe;
	}

	public void doNotches(final AddMullionV mV, final Object[] myHs,
			final Profiles myNewHM, final double x4N, final int i) {

		// myNewHM.notches.add(mV.addNotching(22, false, false, false, false,
		// false, false, false, false, 1,
		// ((Profiles) myHs[i]).startPos, 3, 3,
		// x4N - myNewHM.thickness, myNewHM.y1al,
		// x4N, myNewHM.y4al,
		// myNewHM.x4, x4N,
		// x4N, myNewHM.centerYe,
		// x4N, myNewHM.y3,
		// x4N, myNewHM.y3cl,
		// x4N - myNewHM.thickness, myNewHM.x2cl));

		myNewHM.notches.add(mV.addNotching(22, false, false, false, false,
				false, false, false, false, 1, ((Profiles) myHs[i]).startPos,
				3, 3, x4N - myNewHM.thickness, myNewHM.y1al, x4N, myNewHM.y1al,
				x4N, myNewHM.y1al, x4N, myNewHM.centerYs, x4N, myNewHM.y2, x4N,
				myNewHM.y2cl, x4N - myNewHM.thickness, myNewHM.y2cl));
	}

	public void addVM(final DLO dlo, final int startPos, final int endPos,
			Profiles myNewVM) {

		if (startPos != 1) {
			myNewVM.startIn = true;
		} else {
			myNewVM.startIn = false;
		}
		if (endPos != dlo.yRows) {
			myNewVM.endIn = true;
		} else {
			myNewVM.endIn = false;
		}
		myNewVM.posCondition = this.getPosCondition(myNewVM.startIn,
				myNewVM.endIn);
		myNewVM.myFrame2 = myFrame2;

		myNewVM.orientation = 1;

		myNewVM = doGridsLevels(dlo, myNewVM);

		dlo.bOpeningObject.mullions.add(myNewVM);
	}

	public void addMergedGridPartsV(final DLO dlo, final int startPos,
			final int endPos, Profiles myNewVM) {

		if (startPos != 1) {
			myNewVM.startIn = true;
		} else {
			myNewVM.startIn = false;
		}
		if (endPos != dlo.yRows) {
			myNewVM.endIn = true;
		} else {
			myNewVM.endIn = false;
		}
		myNewVM.posCondition = this.getPosCondition(myNewVM.startIn,
				myNewVM.endIn);
		myNewVM.myFrame2 = myFrame2;

		myNewVM.orientation = 1;

		myNewVM = doGridsLevels(dlo, myNewVM);

		dlo.gridPartsV.add(myNewVM);
	}

	public Profiles doGridsLevels(final DLO dlo, Profiles myNewVM) {

		myNewVM.a_assemblyLevel = 29;
		myNewVM.a_levelID = 9;

		myNewVM.a_1Level = dlo.a_assemblyLevel;
		myNewVM.a_1Sequence = dlo.a_sequenceID;
		myNewVM.a_2Level = dlo.a_1Level;
		myNewVM.a_2Sequence = dlo.a_1Sequence;
		myNewVM.a_3Level = dlo.a_2Level;
		myNewVM.a_3Sequence = dlo.a_2Sequence;
		myNewVM.a_4Level = dlo.a_3Level;
		myNewVM.a_4Sequence = dlo.a_3Sequence;

		myNewVM.a_5Level = dlo.a_4Level;
		myNewVM.a_5Sequence = dlo.a_4Sequence;
		myNewVM.a_6Level = dlo.a_5Level;
		myNewVM.a_6Sequence = dlo.a_5Sequence;
		myNewVM.a_7Level = dlo.a_6Level;
		myNewVM.a_7Sequence = dlo.a_6Sequence;
		myNewVM.a_8Level = dlo.a_7Level;
		myNewVM.a_8Sequence = dlo.a_7Sequence;
		myNewVM.a_9Level = dlo.a_8Level;
		myNewVM.a_9Sequence = dlo.a_8Sequence;
		myNewVM.a_10Level = dlo.a_9Level;
		myNewVM.a_10Sequence = dlo.a_9Sequence;

		myNewVM.a_11Level = dlo.a_10Level;
		myNewVM.a_11Sequence = dlo.a_10Sequence;
		myNewVM.a_12Level = dlo.a_11Level;
		myNewVM.a_12Sequence = dlo.a_11Sequence;
		myNewVM.a_13Level = dlo.a_12Level;
		myNewVM.a_13Sequence = dlo.a_12Sequence;
		myNewVM.a_14Level = dlo.a_13Level;
		myNewVM.a_14Sequence = dlo.a_13Sequence;

		myNewVM.a_15Level = dlo.a_14Level;
		myNewVM.a_15Sequence = dlo.a_14Sequence;
		myNewVM.a_16Level = dlo.a_15Level;
		myNewVM.a_16Sequence = dlo.a_15Sequence;
		myNewVM.a_17Level = dlo.a_16Level;
		myNewVM.a_17Sequence = dlo.a_16Sequence;
		myNewVM.a_18Level = dlo.a_17Level;
		myNewVM.a_18Sequence = dlo.a_17Sequence;
		myNewVM.a_19Level = dlo.a_18Level;
		myNewVM.a_19Sequence = dlo.a_18Sequence;
		myNewVM.a_20Level = dlo.a_19Level;
		myNewVM.a_20Sequence = dlo.a_19Sequence;
		myNewVM.a_21Level = dlo.a_20Level;
		myNewVM.a_21Sequence = dlo.a_20Sequence;
		myNewVM.a_22Level = dlo.a_21Level;
		myNewVM.a_22Sequence = dlo.a_21Sequence;

		myNewVM.gridID = dlo.gridID;
		myNewVM.gridTypeID = dlo.gridType;

		return myNewVM;
	}

	public DLO addHM(final DLO dlo, final Profiles myNewHM, final int startPos,
			final int endPos) {

		if (startPos != 1) {
			myNewHM.startIn = true;
		} else {
			myNewHM.startIn = false;
		}
		if (endPos != dlo.xCols) {
			myNewHM.endIn = true;
		} else {
			myNewHM.endIn = false;
		}
		myNewHM.posCondition = this.getPosCondition(myNewHM.startIn,
				myNewHM.endIn);
		myNewHM.myFrame2 = myFrame2;
		myNewHM.orientation = 2;
		dlo.bOpeningObject.mullionsH.add(myNewHM);
		return dlo;
	}

	public DLO addGrisPartsH(final DLO dlo, final Profiles myNewHM,
			final int startPos, final int endPos) {

		if (startPos != 1) {
			myNewHM.startIn = true;
		} else {
			myNewHM.startIn = false;
		}
		if (endPos != dlo.xCols) {
			myNewHM.endIn = true;
		} else {
			myNewHM.endIn = false;
		}
		myNewHM.posCondition = this.getPosCondition(myNewHM.startIn,
				myNewHM.endIn);
		myNewHM.myFrame2 = myFrame2;
		myNewHM.orientation = 2;
		dlo.gridPartsH.add(myNewHM);
		return dlo;
	}

	public int getPosCondition(final boolean sIn, final boolean eIn) {

		int poscond = 0;
		if (!sIn && !eIn) {
			poscond = 1;
		} else if (!sIn && eIn) {
			poscond = 2;
		} else if (sIn && !eIn) {
			poscond = 3;
		} else {
			poscond = 4;
		}
		return poscond;
	}

	public DLO finalCheck(final DLO dlo) {

		Object[] myVs = dlo.bOpeningObject.mullions.toArray();
		final Object[] myHs = dlo.bOpeningObject.mullionsH.toArray();

		dlo.bOpeningObject.mullions.clear();

		if (myGrid.getContinuityIn() == 0) {

			for (final Object myV : myVs) {

				if (!((Profiles) myV).opDone) {
					for (int j = 1; j < dlo.yRows; j++) {

						for (final Object myH : myHs) {
							if (((Profiles) myH).rowCol == j) {
								if (((Profiles) myH).rowCol == ((Profiles) myV).startPos - 1) {
									if (((Profiles) myH).startPos == ((Profiles) myV).rowCol + 1) {
										((Profiles) myV).y1 = ((Profiles) myV).y1a = ((Profiles) myV).y1al = ((Profiles) myH).y2;
										((Profiles) myV).centerYs = this
												.intersectY(
														((Profiles) myV).x1,
														((Profiles) myV).y1,
														((Profiles) myV).x2,
														((Profiles) myV).y2,
														((Profiles) myV).centerXs,
														((Profiles) myV).y1,
														((Profiles) myV).centerXe,
														((Profiles) myV).centerYe);
									}

									if (((Profiles) myH).endPos == ((Profiles) myV).rowCol) {
										((Profiles) myV).y2 = ((Profiles) myV).y2a = ((Profiles) myV).y2cl = ((Profiles) myH).y3;
										((Profiles) myV).centerYs = this
												.intersectY(
														((Profiles) myV).x1,
														((Profiles) myV).y1,
														((Profiles) myV).x2,
														((Profiles) myV).y2,
														((Profiles) myV).centerXs,
														((Profiles) myV).y1,
														((Profiles) myV).centerXe,
														((Profiles) myV).centerYe);

									}

								}

								// ////
								if (((Profiles) myH).rowCol == ((Profiles) myV).endPos) {
									if (((Profiles) myH).startPos == ((Profiles) myV).rowCol + 1) {
										((Profiles) myV).y4 = ((Profiles) myV).y4a = ((Profiles) myV).y4al = ((Profiles) myH).y1;
										((Profiles) myV).centerYe = this
												.intersectY(
														((Profiles) myV).x4,
														((Profiles) myV).y4,
														((Profiles) myV).x3,
														((Profiles) myV).y3,
														((Profiles) myV).centerXe,
														((Profiles) myV).centerYe,
														((Profiles) myV).centerXs,
														((Profiles) myV).centerYs);

									}

									if (((Profiles) myH).endPos == ((Profiles) myV).rowCol) {
										((Profiles) myV).y3 = ((Profiles) myV).y3a = ((Profiles) myV).y3cl = ((Profiles) myH).y4;
										((Profiles) myV).centerYe = this
												.intersectY(
														((Profiles) myV).x4,
														((Profiles) myV).y4,
														((Profiles) myV).x3,
														((Profiles) myV).y3,
														((Profiles) myV).centerXe,
														((Profiles) myV).centerYe,
														((Profiles) myV).centerXs,
														((Profiles) myV).centerYs);

									}

								}

							}

						}
					}
					((Profiles) myV).myFrame2 = myFrame2;
					dlo.bOpeningObject.mullions.add(myV);
				} else {
					((Profiles) myV).myFrame2 = myFrame2;
					dlo.bOpeningObject.mullions.add(myV);
				}
			}

			myVs = dlo.bOpeningObject.mullions.toArray();

			dlo.bOpeningObject.mullionsH.clear();

			for (final Object myH : myHs) {

				// if (((Profiles)
				// myH).startPos > 1)
				// {

				for (int j = 1; j < dlo.xCols; j++) {

					for (final Object myV : myVs) {
						if (((Profiles) myV).rowCol == j) {
							if (((Profiles) myV).rowCol == ((Profiles) myH).startPos - 1) {
								if (((Profiles) myV).startPos == ((Profiles) myH).rowCol + 1) {
									((Profiles) myH).x2 = ((Profiles) myH).x2a = ((Profiles) myH).x2cl = ((Profiles) myV).x1;
									((Profiles) myH).centerXs = this
											.intersectX(((Profiles) myH).x1,
													((Profiles) myH).y1,
													((Profiles) myH).x2,
													((Profiles) myH).y2,
													((Profiles) myH).centerXs,
													((Profiles) myH).centerYs,
													((Profiles) myH).centerXe,
													((Profiles) myH).centerYe);
								}
								if (((Profiles) myV).endPos == ((Profiles) myH).rowCol) {
									((Profiles) myH).x1 = ((Profiles) myH).x1a = ((Profiles) myH).x1al = ((Profiles) myV).x4;
									((Profiles) myH).centerXs = this
											.intersectX(((Profiles) myH).x1,
													((Profiles) myH).y1,
													((Profiles) myH).x2,
													((Profiles) myH).y2,
													((Profiles) myH).centerXs,
													((Profiles) myH).centerYs,
													((Profiles) myH).centerXe,
													((Profiles) myH).centerYe);
								}

							}
							if (((Profiles) myV).rowCol == ((Profiles) myH).endPos) {
								if (((Profiles) myV).startPos == ((Profiles) myH).rowCol + 1) {
									((Profiles) myH).x3 = ((Profiles) myH).x3a = ((Profiles) myH).x3cl = ((Profiles) myV).x2;
									((Profiles) myH).centerXe = this
											.intersectX(((Profiles) myH).x3,
													((Profiles) myH).y3,
													((Profiles) myH).x4,
													((Profiles) myH).y4,
													((Profiles) myH).centerXs,
													((Profiles) myH).centerYs,
													((Profiles) myH).centerXe,
													((Profiles) myH).centerYe);
								}
								if (((Profiles) myV).endPos == ((Profiles) myH).rowCol) {
									((Profiles) myH).x4 = ((Profiles) myH).x4a = ((Profiles) myH).x4al = ((Profiles) myV).x3;
									((Profiles) myH).centerXe = this
											.intersectX(((Profiles) myH).x3,
													((Profiles) myH).y3,
													((Profiles) myH).x4,
													((Profiles) myH).y4,
													((Profiles) myH).centerXs,
													((Profiles) myH).centerYs,
													((Profiles) myH).centerXe,
													((Profiles) myH).centerYe);
								}

							}
						}

					}
				}

				// }
				((Profiles) myH).myFrame2 = myFrame2;
				dlo.bOpeningObject.mullionsH.add(myH);
			}
			// }

		} else if (myGrid.getContinuityIn() == 3) {
			// final Object[] myVs =
			// dlo.gridPartsV.toArray();
			//
			// for (final Object myV : myVs)
			// {
			//
			// dlo.bOpeningObject.mullions.add(myV);
			// }
		}

		return dlo;
	}

	public void checkRow(final Object dlo, final Object[] ahs, final int j,
			final OpeningObject lite) {

		if (j == 0) {

			lite.startingY = lite.bY2 = lite.startingCY = lite.bCY2 = Math.min(
					((DLO) dlo).startingY, ((DLO) dlo).highestY);

			lite.highestY = ((DLO) dlo).highestY;

			if (ahs.length > 0) {
				lite.bY3 = lite.bY4 = ((Profiles) ahs[j]).y2;
				lite.bCY3 = lite.bCY4 = ((Profiles) ahs[j]).centerYs;
			} else {
				lite.bY3 = lite.bY4 = ((DLO) dlo).lowestY;
				lite.bCY3 = lite.bCY4 = ((DLO) dlo).lowestY;
			}

			lite.startRow = j + 1;
			lite.endRow = j + 1;

		} else if (j < ahs.length) {
			lite.startingY = lite.highestY = lite.bY2 = ((Profiles) ahs[j - 1]).y1;
			lite.startingCY =

			lite.bCY2 = ((Profiles) ahs[j - 1]).centerYs;

			lite.bY3 = lite.bY4 = ((Profiles) ahs[j]).y2;
			lite.bCY3 = lite.bCY4 = ((Profiles) ahs[j]).centerYe;

			lite.startRow = j + 1;
			lite.endRow = j + 1;
		} else {
			lite.startingY = lite.highestY = lite.bY2 = ((Profiles) ahs[j - 1]).y1;
			lite.startingCY =

			lite.bCY2 = ((Profiles) ahs[j - 1]).centerYs;

			lite.bY3 = lite.bY4 = ((DLO) dlo).bY4;
			lite.bCY3 = lite.bCY4 = ((DLO) dlo).bY4;
			lite.startRow = j + 1;
			lite.endRow = j + 1;
		}
	}

	public void findWidestDLOsIIOLD(final int gridType) {

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		if (gridType % 2 != 0 && mydlos.length > 0) {
			DLO maxDLO = new DLO(myFrame2);
			maxDLO = this.getMaxW(mydlos, 10000f);
			int count = 0;

			DLOs.clear();

			do {

				if (!((DLO) mydlos[count]).equals(maxDLO)
						&& ((DLO) mydlos[count]).startingX >= maxDLO.startingX
						&& ((DLO) mydlos[count]).startingX <= maxDLO.bX2
						&& ((DLO) mydlos[count]).widthPix <= maxDLO.widthPix) {

					((DLO) mydlos[count]).masterW = false;
					((DLO) mydlos[count]).myMasterW = maxDLO;

					count++;
				} else if (!((DLO) mydlos[count]).equals(maxDLO)
						&& ((DLO) mydlos[count]).bX2 > maxDLO.startingX
						&& ((DLO) mydlos[count]).bX2 <= maxDLO.bX2
						&& ((DLO) mydlos[count]).widthPix <= maxDLO.widthPix) {

					((DLO) mydlos[count]).masterW = false;
					((DLO) mydlos[count]).myMasterW = maxDLO;

					count++;
				} else if (((DLO) mydlos[count]).startingX > maxDLO.bX2) {

					final boolean widest = this.checkWidestAfter(mydlos,
							((DLO) mydlos[count]), maxDLO);

					if (widest) {
						((DLO) mydlos[count]).masterW = true;
						((DLO) mydlos[count]).msx = ((DLO) mydlos[count]).startingX;
						((DLO) mydlos[count]).mex = ((DLO) mydlos[count]).bX2;
						mydlos[count] = this.getAreaofInfluenceW(mydlos,
								((DLO) mydlos[count]));
						count++;
					} else {
						((DLO) mydlos[count]).masterW = false;
						count++;
					}

				} else if (((DLO) mydlos[count]).bX2 < maxDLO.startingX) {

					final boolean widest = this.checkWidestBefore(mydlos,
							((DLO) mydlos[count]), maxDLO);

					if (widest) {
						((DLO) mydlos[count]).masterW = true;
						((DLO) mydlos[count]).msx = ((DLO) mydlos[count]).startingX;
						((DLO) mydlos[count]).mex = ((DLO) mydlos[count]).bX2;
						mydlos[count] = this.getAreaofInfluenceW(mydlos,
								((DLO) mydlos[count]));
						count++;
					} else {
						((DLO) mydlos[count]).masterW = false;
						count++;
					}

				} else if (((DLO) mydlos[count]).equals(maxDLO)) {
					count++;
				}

			} while (count < mydlos.length);

			DLOs.clear();

			for (final Object dlo : mydlos) {
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();

				DLOs.add(dlo);

			}
			mydlos = DLOs.toArray();
			this.recheckAreaOfInfluenceW();
		} else {
			for (final Object dlo : mydlos) {
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();

				((DLO) dlo).masterW = true;

				DLOs.add(dlo);

			}
		}

		// return DLOs;
	}

	public void findWidestDLOsII(final int gridType) {

		Object[] mydlos = null;

		if (gridType % 2 != 0 && DLOs.size() > 0) {
			new DLO(myFrame2);

			getMaxW();

			mydlos = DLOs.toArray();

			DLOs.clear();

			for (final Object dlo : mydlos) {
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();

				DLOs.add(dlo);

			}
			mydlos = DLOs.toArray();
			// this.recheckAreaOfInfluenceW();
		} else {
			mydlos = DLOs.toArray();
			DLOs.clear();
			for (final Object dlo : mydlos) {
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();

				((DLO) dlo).masterW = true;

				DLOs.add(dlo);

			}
		}

		// return DLOs;
	}

	public void findNarrowestDLOsII(final int gridType) {

		Object[] mydlos = null;

		// if (gridType % 2 != 0 && DLOs.size() > 0) {

		getMinW();

		mydlos = DLOs.toArray();

		DLOs.clear();

		for (final Object dlo : mydlos) {
			((DLO) dlo).anchorsV.clear();
			((DLO) dlo).gridPartsV.clear();

			if (((DLO) dlo).myMasterW != null
					&& ((DLO) dlo).myMasterW.widthPix == 0) {

				((DLO) dlo).myMasterW = null;

			}

			DLOs.add(dlo);

		}
		mydlos = DLOs.toArray();
	}

	public void findShortestDLOsII(final int gridType) {

		Object[] mydlos = null;

		// if (gridType % 2 != 0 && DLOs.size() > 0) {
		new DLO(myFrame2);

		getMinH();

		mydlos = DLOs.toArray();

		DLOs.clear();

		for (final Object dlo : mydlos) {
			((DLO) dlo).anchorsH.clear();
			((DLO) dlo).gridPartsH.clear();

			if (((DLO) dlo).myMasterH != null
					&& ((DLO) dlo).myMasterH.widthPix == 0) {
				((DLO) dlo).myMasterH = null;
			}

			DLOs.add(dlo);

		}
		mydlos = DLOs.toArray();

	}

	public void getGridTypeInDLO(final boolean all, final DLO myDLO,
			final int gridid) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		for (Object dlo : mydlos) {
			if (all) {

				((DLO) dlo).gridID = gridID;
				((DLO) dlo).gridType = this.gridType;

				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.gridType = gridType;
					((DLO) dlo).myParentO.myGlassMid.gridID = this.gridID;
				}

				dlo = getGridInfo(dlo);

				if (gridid > 0) {
					((DLO) dlo).hasGrids = true;
				}

				((DLO) dlo).clearBomForDLO();
				DLOs.add(dlo);
			} else {
				if (((DLO) dlo).startingX == myDLO.startingX
						&& ((DLO) dlo).bX2 == myDLO.bX2
						&& ((DLO) dlo).startingY == myDLO.startingY
						&& ((DLO) dlo).bY2 == myDLO.bY2
						&& ((DLO) dlo).bX3 == myDLO.bX3
						&& ((DLO) dlo).bY3 == myDLO.bY3
						&& ((DLO) dlo).bX4 == myDLO.bX4
						&& ((DLO) dlo).bY4 == myDLO.bY4) {

					((DLO) dlo).gridID = gridID;
					((DLO) dlo).gridType = this.gridType;
					if (((DLO) dlo).myParentO.myGlassMid != null) {
						((DLO) dlo).myParentO.myGlassMid.gridType = gridType;
						((DLO) dlo).myParentO.myGlassMid.gridID = this.gridID;
					}

					dlo = getGridInfo(dlo);

					if (gridid > 0) {
						((DLO) dlo).hasGrids = true;
					}

				}
				((DLO) dlo).clearBomForDLO();
				DLOs.add(dlo);
				break;
			}

		}

	}

	public DLO getGridInfo(final Object dlo) {

		if (this.myFrame2.mySeries.getSeriesUom() == 1) {
			((DLO) dlo).gridThick = myGrid.getThickness();
			((DLO) dlo).idealGW = myGrid.getIdealW();
			((DLO) dlo).idealGH = myGrid.getIdealH();
			((DLO) dlo).minGW = myGrid.getMinW();
			((DLO) dlo).minGH = myGrid.getMinH();
			((DLO) dlo).maxGW = myGrid.getMaxW();
			((DLO) dlo).maxGH = myGrid.getMaxH();
			((DLO) dlo).gridRemovalZoneW = myGrid.getRemoveW();
			((DLO) dlo).gridRemovalZoneH = myGrid.getRemoveH();
			((DLO) dlo).perimeterV = myGrid.getPerimeterV();
			((DLO) dlo).perimeterH = myGrid.getPerimeterH();
			((DLO) dlo).continuity = myGrid.getContinuityIn();
			((DLO) dlo).continuityOut = myGrid.getContinuityOut();

			if (myGrid.getIdealW() == 0
					&& myFrame2.mySeries.getGridWidthIdeal() > 0) {
				((DLO) dlo).idealGW = myFrame2.mySeries.getGridWidthIdeal();
			}

			if (myGrid.getIdealH() == 0
					&& myFrame2.mySeries.getGridHeightIdeal() > 0) {
				((DLO) dlo).idealGH = myFrame2.mySeries.getGridHeightIdeal();
			}

			if (myGrid.getMinW() == 0
					&& myFrame2.mySeries.getGridWidthMin() > 0) {
				((DLO) dlo).minGW = myFrame2.mySeries.getGridWidthMin();
			}

			if (myGrid.getMinH() == 0
					&& myFrame2.mySeries.getGridHeightMin() > 0) {
				((DLO) dlo).minGH = myFrame2.mySeries.getGridHeightMin();
			}

			if (myGrid.getMaxW() == 0
					&& myFrame2.mySeries.getGridWidthMax() > 0) {
				((DLO) dlo).maxGW = myFrame2.mySeries.getGridWidthMax();
			}

			if (myGrid.getMaxH() == 0
					&& myFrame2.mySeries.getGridHeightMax() > 0) {
				((DLO) dlo).maxGH = myFrame2.mySeries.getGridHeightMax();
			}

		} else {
			((DLO) dlo).gridThick = myGrid.getThicknessImp();
			((DLO) dlo).idealGW = myGrid.getIdealWi();
			((DLO) dlo).idealGH = myGrid.getIdealHi();
			((DLO) dlo).minGW = myGrid.getMinWi();
			((DLO) dlo).minGH = myGrid.getMinHi();
			((DLO) dlo).maxGW = myGrid.getMaxWi();
			((DLO) dlo).maxGH = myGrid.getMaxHi();
			((DLO) dlo).gridRemovalZoneW = myGrid.getRemoveWi();
			((DLO) dlo).gridRemovalZoneH = myGrid.getRemoveHi();
			((DLO) dlo).perimeterV = myGrid.getPerimeterVi();
			((DLO) dlo).perimeterH = myGrid.getPerimeterHi();

			if (myGrid.getIdealWi() == 0
					&& myFrame2.mySeries.getGridWidthIdealI() > 0) {
				((DLO) dlo).idealGW = myFrame2.mySeries.getGridWidthIdealI();
			}

			if (myGrid.getIdealHi() == 0
					&& myFrame2.mySeries.getGridHeightIdealI() > 0) {
				((DLO) dlo).idealGH = myFrame2.mySeries.getGridHeightIdealI();
			}

			if (myGrid.getMinWi() == 0
					&& myFrame2.mySeries.getGridWidthMinI() > 0) {
				((DLO) dlo).minGW = myFrame2.mySeries.getGridWidthMinI();
			}

			if (myGrid.getMinHi() == 0
					&& myFrame2.mySeries.getGridHeightMinI() > 0) {
				((DLO) dlo).minGH = myFrame2.mySeries.getGridHeightMinI();
			}

			if (myGrid.getMaxWi() == 0
					&& myFrame2.mySeries.getGridWidthMaxI() > 0) {
				((DLO) dlo).maxGW = myFrame2.mySeries.getGridWidthMaxI();
			}

			if (myGrid.getMaxHi() == 0
					&& myFrame2.mySeries.getGridHeightMaxI() > 0) {
				((DLO) dlo).maxGH = myFrame2.mySeries.getGridHeightMaxI();
			}

		}

		if (myGrid.getPartid() > 0) {

			if (myFrame2.mySeries.getSeriesUom() == 1) {
				((DLO) dlo).gridThick = myProfile.getDimb();
			} else {
				((DLO) dlo).gridThick = myProfile.getDimbi();
			}

		}

		return (DLO) dlo;

	}

	public void setAnchorsWInMaster() {

		Object[] mydlos;
		mydlos = DLOs.toArray();
		DLOs.clear();

		int initNoLites = 0;
		double totalThick = 0;
		double resultLiteW = 0;

		double myIdealGW = 0;

		double dloW = 0;
		for (Object dlo : mydlos) {

			dloW = Math.max(((DLO) dlo).bX2, ((DLO) dlo).bX3)
					- Math.min(((DLO) dlo).startingX, ((DLO) dlo).bX4);

			if (((DLO) dlo).gridType % 2 != 0) {
				if (((DLO) dlo).masterW) {

					boolean ideal = false;
					myIdealGW = ((DLO) dlo).idealGW * myScale.doubleValue();
					if (phiW) {
						myIdealGW = ((DLO) dlo).idealGH * myScale.doubleValue()
								* 1.61803399999999f;
						((DLO) dlo).idealGW = myIdealGW * myScale.doubleValue();
					}
					if (phiW && reversePhi) {
						myIdealGW = ((DLO) dlo).idealGH * myScale.doubleValue()
								/ 1.61803399999999f;
						((DLO) dlo).idealGW = myIdealGW + myScale.doubleValue();
					}

					myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

					double deltaF = 0;
					double deltaC = 0;

					initNoLites = (int) Math.ceil(dloW / myIdealGW);
					totalThick = myThick * (initNoLites - 1);
					resultLiteW = (dloW - totalThick) / initNoLites;
					deltaC = Math.abs(resultLiteW - myIdealGW);

					initNoLites = (int) Math.floor(dloW / myIdealGW);
					totalThick = myThick * (initNoLites - 1);
					resultLiteW = (dloW - totalThick) / initNoLites;
					deltaF = Math.abs(resultLiteW - myIdealGW);

					if (deltaF < deltaC) {
						initNoLites = (int) Math.floor(dloW / myIdealGW);
						totalThick = myThick * (initNoLites - 1);
						resultLiteW = (dloW - totalThick) / initNoLites;
					} else {
						initNoLites = (int) Math.ceil(dloW / myIdealGW);
						totalThick = myThick * (initNoLites - 1);
						resultLiteW = (dloW - totalThick) / initNoLites;

					}

					if (resultLiteW == myIdealGW) {
						ideal = true;
					} else {

						int count = 0;
						double lastW = resultLiteW;
						double delta = 0;
						double lastDelta = 0;
						int lastNoLites = 0;
						do {
							initNoLites = initNoLites + count;
							count++;
							totalThick = myThick * (initNoLites - 1);
							resultLiteW = (dloW - totalThick) / initNoLites;

							delta = Math.abs(myIdealGW - resultLiteW);
							lastDelta = Math.abs(myIdealGW - lastW);
							if (delta > lastDelta) {
								resultLiteW = lastW;
								initNoLites = lastNoLites;
								ideal = true;
							} else if (resultLiteW <= myIdealGW) {
								ideal = true;
							} else {
								lastW = resultLiteW;
								lastNoLites = initNoLites;
							}

						} while (!ideal);
						final double anchorW = ((DLO) dlo).startingX;

						totalThick = (initNoLites - 1) * myThick;
						resultLiteW = (dloW - totalThick) / initNoLites;

						((DLO) dlo).liteW = resultLiteW;

						dlo = this.calcAnchorW(initNoLites, resultLiteW,
								myThick, anchorW, dlo, whichPos, true);

					}

				}

			} else {
				dlo = doPerimeterGridV((DLO) dlo);
			}

			DLOs.add(dlo);
		}

	}

	public DLO doPerimeterGridV(final DLO dlo) {

		if (dlo.masterW) {
			if (Math.max(dlo.bX2, dlo.bX3) - Math.min(dlo.startingX, dlo.bX4) < 3
					* dlo.perimeterV * myScale.doubleValue()) {
				JOptionPane.showMessageDialog(null, "Daylight Opening (DLO : "
						+ dlo.a_sequenceID + " ) Width too small \n"
						+ "for the selected grid's Perimeter Distance!",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {

				double myThick;
				dlo.anchorsV.clear();
				dlo.gridPartsV.clear();
				dlo.gridMasksV.clear();

				dlo.anchorsV.add(dlo.startingX + dlo.perimeterV
						* myScale.doubleValue());
				dlo.anchorsV.add(dlo.bX2 - dlo.perimeterV
						* myScale.doubleValue());

				this.hardVs.addAll(dlo.anchorsV);

				double myDist = dlo.bX2
						- dlo.perimeterV
						* myScale.doubleValue()
						- (dlo.startingX + dlo.perimeterV
								* myScale.doubleValue());
				int noS = (int) Math.ceil(myDist
						/ (dlo.maxGW * myScale.doubleValue()));
				myThick = dlo.gridThick * myScale.doubleValue();

				Object[] aV = dlo.anchorsV.toArray();
				int count = 0;

				for (Object av : aV) {
					count++;

					if (count == 1 && dlo.noSidesLeft == 1) {
						leftPartPerimeter(dlo, myThick);
						dlo.noGridsV = dlo.noGridsV + 1;
						if (dlo.myParentO.myGlassMid != null) {
							dlo.myParentO.myGlassMid.noGridsV = dlo.noGridsV + 1;
						}

					}

					if (count == 2 && dlo.noSidesRight == 1) {

						rightPartPerimeter(dlo, myThick);
						dlo.noGridsV = dlo.noGridsV + 1;
						if (dlo.myParentO.myGlassMid != null) {
							dlo.myParentO.myGlassMid.noGridsV = dlo.noGridsV + 1;
						}

					}

					dlo.liteW = dlo.perimeterV;
				}

			}
		}

		return dlo;
	}

	public void topPartPerimeter(final DLO dlo, final double myThick) {

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		Profiles grid = new Profiles();

		grid.myFrame2 = myFrame2;

		grid.partForm = 1;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.thickness = myThick;
		grid.partDimB = myThick;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;

		final double halfThick = myThick / 2;
		double dist = 0;
		double newP = 0;
		if (!dlo.masterH) {

			for (Object d : dlo.anchorsH.toArray()) {
				dist = Double.parseDouble(d.toString());
				dist = dist - myThick;
				break;
			}

			if (dlo.gridType % 2 == 0) {
				newP = (dist - dlo.highestY) / myScale.doubleValue();
			}
		}

		double py2 = newP * myScale.doubleValue();

		grid.y2cl = grid.y2 = dlo.top1Part.startY + py2;

		grid.y3cl = grid.y3 = dlo.top1Part.endY + py2;

		grid.y1al = grid.y1 = grid.y4al = grid.y4 = grid.y2cl + myThick;

		grid.centerYs = grid.centerYe = grid.y2cl + halfThick;

		Profiles limitL = dlo.leftPart;

		Profiles limitR = dlo.rightPart;

		grid.x1al = grid.x1 = grid.x2cl = grid.x2 = grid.centerXs = limitL.endX;
		// this.intersectX(limitL.endX, grid.y1,
		// limitL.startX, grid.y4, limitL.startX,
		// limitL.startY, limitL.endX, limitL.endY);

		grid.x4al = grid.x4 = grid.x3cl = grid.x3 = grid.centerXe = limitR.startX;
		// this.intersectX(limitR.startX, grid.y1,
		// limitR.endX, grid.y1, limitR.startX,
		// limitR.startY, limitR.endX, limitR.endY);

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = 1;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;

		grid.y1a = grid.y1al;
		grid.y2a = grid.y2cl;
		grid.y4a = grid.y4al;
		grid.y3a = grid.y3cl;

		grid.x1a = grid.x1a = grid.x1b = grid.x1al;
		grid.x2a = grid.x2a = grid.x2b = grid.x2cl;
		grid.x4a = grid.x3a = grid.x3b = grid.x4al;
		grid.x3a = grid.x4a = grid.x4b = grid.x3cl;
		grid.xcs = grid.centerXs;
		grid.xce = grid.centerXe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);

		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);

		arcX = null;
	}

	public void botPartPerimeter(final DLO dlo, final double myThick) {

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		Profiles grid = new Profiles();

		grid.myFrame2 = myFrame2;

		grid.partForm = 1;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.thickness = myThick;
		grid.partDimB = myThick;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;

		final double halfThick = myThick / 2;
		double dist = 0;
		double max = 0;
		double newP = 0;
		if (!dlo.masterH) {

			for (Object d : dlo.anchorsH.toArray()) {
				if (Double.parseDouble(d.toString()) > max) {
					max = Double.parseDouble(d.toString());
				}
			}

			for (Object d : dlo.anchorsH.toArray()) {
				if (Double.parseDouble(d.toString()) == max) {
					dist = Double.parseDouble(d.toString());
					dist = dist + myThick;
					break;
				}
			}

			if (dlo.gridType % 2 == 0) {
				newP = (dlo.bY3 - dist) / myScale.doubleValue();
				;
			}
		}

		double py1 = newP * myScale.doubleValue();
		grid.y1al = grid.y1 = grid.y4al = grid.y4 = dlo.bot1Part.startY - py1;

		grid.y2cl = grid.y2 = grid.y3cl = grid.y3 = grid.y1al - myThick;

		grid.centerYs = grid.centerYe = grid.y2cl + halfThick;

		Profiles limitL = dlo.leftPart;

		Profiles limitR = dlo.rightPart;

		grid.x1al = grid.x1 = grid.x2cl = grid.x2 = grid.centerXs = limitL.endX;

		// this.intersectX(limitL.endX, grid.y1,
		// limitL.startX, grid.y1, limitL.startX,
		// limitL.startY, limitL.endX, limitL.endY);

		grid.x4al = grid.x4 = grid.x3cl = grid.x3 = grid.centerXe = limitR.startX;

		// this.intersectX(limitR.startX, grid.y1,
		// limitR.endX, grid.y1, limitR.startX,
		// limitR.startY, limitR.endX, limitR.endY);

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = 2;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;

		grid.y1a = grid.y1al;
		grid.y2a = grid.y2cl;
		grid.y4a = grid.y4al;
		grid.y3a = grid.y3cl;

		grid.x1a = grid.x1a = grid.x1b = grid.x1al;
		grid.x2a = grid.x2a = grid.x2b = grid.x2cl;
		grid.x4a = grid.x3a = grid.x3b = grid.x4al;
		grid.x3a = grid.x4a = grid.x4b = grid.x3cl;
		grid.xcs = grid.centerXs;
		grid.xce = grid.centerXe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);

		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);

		arcX = null;
	}

	public void leftPartPerimeter(final DLO dlo, final double myThick) {

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		Profiles grid = new Profiles();

		grid.myFrame2 = myFrame2;

		grid.partForm = 1;
		grid.orientation = 1;
		grid.whichPos = whichPos;
		grid.thickness = myThick;
		grid.partDimB = myThick;

		grid.startPos = 1;
		grid.endPos = dlo.yRows;
		final double slope = (dlo.leftPart.endYC - dlo.leftPart.startYC)
				/ (dlo.leftPart.endXC - dlo.leftPart.startXC);

		final double halfThick = myThick / 2;

		final double theta = Math.atan(Math.abs(slope));

		if (!dlo.masterW) {
			double dist = 0;
			for (Object d : dlo.anchorsV.toArray()) {
				dist = Double.parseDouble(d.toString());
				// dist = dist - halfThick;
				break;
			}

			if (dlo.gridType % 2 == 0) {
				dlo.perimeterH = (dist - dlo.startingX) / myScale.doubleValue();
			}
		}

		double px1 = dlo.perimeterH * myScale.doubleValue();

		double pxc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		double px2 = dlo.perimeterH * myScale.doubleValue() + myThick;

		if (theta != 0) {
			px2 = px2 / Math.sin(theta);

			pxc = pxc / Math.sin(theta);

			px1 = px1 / Math.sin(theta);
		}

		grid.x1al = grid.x1 = dlo.leftPart.endXC + px1;

		grid.x4al = grid.x4 = dlo.leftPart.startXC + px1;

		grid.x2cl = grid.x2 = dlo.leftPart.endXC + px2;

		grid.x3cl = grid.x3 = dlo.leftPart.startXC + px2;

		grid.centerXs = dlo.leftPart.endXC + pxc;
		grid.centerXe = dlo.leftPart.startXC + pxc;

		Profiles limitT = new Profiles();

		Profiles limitB = new Profiles();

		limitT = dlo.top1Part;

		if (dlo.bot2Part.posInUse) {
			limitB = dlo.bot2Part;
		} else {
			limitB = dlo.bot1Part;
		}
		if (limitT.partForm == 1 || limitT.partForm > 1
				&& (int) limitT.startAngle == 0
				&& Math.ceil(limitT.endAngle) == 180) {
			// HR
			grid.y1al = grid.y1 = this.intersectY(grid.x1, dlo.leftPart.endYC,
					grid.x4, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, limitT.endXC, limitT.endYC);
			grid.x1al = grid.x1 = this.intersectX(grid.x1, dlo.leftPart.endYC,
					grid.x4, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, limitT.endXC, limitT.endYC);

			grid.y2cl = grid.y2 = this.intersectY(grid.x2, dlo.leftPart.endYC,
					grid.x3, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, limitT.endXC, limitT.endYC);

			grid.x2cl = grid.x2 = this.intersectX(grid.x2, dlo.leftPart.endYC,
					grid.x3, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, limitT.endXC, limitT.endYC);

			grid.centerYs = this.intersectY(grid.centerXs, dlo.leftPart.endYC,
					grid.centerXe, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, limitT.endXC, limitT.endYC);

			grid.centerXs = this.intersectX(grid.centerXs, dlo.leftPart.endYC,
					grid.centerXe, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, limitT.endXC, limitT.endYC);

		} else if (limitT.partForm == 1 || limitT.partForm > 1
				&& (int) limitT.startAngle > 90
				&& Math.ceil(limitT.endAngle + limitT.startAngle) == 180) {
			// HR
			grid.y1al = grid.y1 = this.intersectY(grid.x1, dlo.leftPart.endYC,
					grid.x4, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, 500, limitT.startYC);
			grid.x1al = grid.x1 = this.intersectX(grid.x1, dlo.leftPart.endYC,
					grid.x4, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, 500, limitT.startYC);

			grid.y2cl = grid.y2 = this.intersectY(grid.x2, dlo.leftPart.endYC,
					grid.x3, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, 500, limitT.startYC);

			grid.x2cl = grid.x2 = this.intersectX(grid.x2, dlo.leftPart.endYC,
					grid.x3, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, 500, limitT.startYC);

			grid.centerYs = this.intersectY(grid.centerXs, dlo.leftPart.endYC,
					grid.centerXe, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, 500, limitT.startYC);

			grid.centerXs = this.intersectX(grid.centerXs, dlo.leftPart.endYC,
					grid.centerXe, dlo.leftPart.startYC, limitT.startXC,
					limitT.startYC, 500, limitT.startYC);

		} else {

			grid.y1al = grid.y1 = arcX.getYusingX(grid.x1, 0, grid.x4, 500,
					limitT.radius1BA, limitT.x1, limitT.y1, false);

			grid.y2cl = grid.y2 = arcX.getYusingX(grid.x2, 0, grid.x3, 500,
					limitT.radius1BA, limitT.x1, limitT.y1, false);

			grid.centerYs = arcX.getYusingX(grid.centerXs, 0, grid.centerXe,
					500, limitT.radius1BA, limitT.x1, limitT.y1, false);

		}

		if (limitB.partForm == 1
				|| limitB.partForm > 1
				&& ((int) limitB.startAngle == 180
						&& Math.ceil(limitT.endAngle) == 180 || (int) limitT.startAngle == 270
						&& Math.ceil(limitT.endAngle) == 90)) {

			grid.y4al = grid.y4 = this.intersectY(grid.x1, dlo.leftPart.endYC,
					grid.x4, dlo.leftPart.startYC, limitB.startXC,
					limitB.startYC, limitB.endXC, limitB.endYC);

			grid.x4al = grid.x4 = this.intersectX(grid.x1, dlo.leftPart.endYC,
					grid.x4, dlo.leftPart.startYC, limitB.startXC,
					limitB.startYC, limitB.endXC, limitB.endYC);

			grid.y3cl = grid.y3 = this.intersectY(grid.x2, dlo.leftPart.endYC,
					grid.x3, dlo.leftPart.startYC, limitB.startXC,
					limitB.startYC, limitB.endXC, limitB.endYC);
			grid.x3cl = grid.x3 = this.intersectX(grid.x2, dlo.leftPart.endYC,
					grid.x3, dlo.leftPart.startYC, limitB.startXC,
					limitB.startYC, limitB.endXC, limitB.endYC);

			grid.centerYe = this.intersectY(grid.centerXs, dlo.leftPart.endYC,
					grid.centerXe, dlo.leftPart.startYC, limitB.startXC,
					limitB.startYC, limitB.endXC, limitB.endYC);
			grid.centerXe = this.intersectX(grid.centerXs, dlo.leftPart.endYC,
					grid.centerXe, dlo.leftPart.startYC, limitB.startXC,
					limitB.startYC, limitB.endXC, limitB.endYC);
		} else if (limitB.partForm >= 2) {

			grid.y4al = grid.y4 = arcX.getYusingX(grid.x1, 0, grid.x4, 500,
					limitB.radius1BA, limitB.x1, limitB.y1, true);

			grid.y3cl = grid.y3 = arcX.getYusingX(grid.x2, 0, grid.x3, 500,
					limitB.radius1BA, limitB.x1, limitB.y1, true);

			grid.centerYe = arcX.getYusingX(grid.centerXs, 0, grid.centerXe,
					500, limitB.radius1BA, limitB.x1, limitB.y1, true);

		}

		grid.exists = 1;
		grid.length = grid.centerYe - grid.centerYs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = 1;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.yRows;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y3a = grid.y3b = grid.y4al;
		grid.y3a = grid.y4a = grid.y4b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);
		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsV.add(grid);

		dlo.gridMasksV.add(grid);

		dlo.bOpeningObject.mullions.add(grid);

		arcX = null;
	}

	public void rightPartPerimeter(final DLO dlo, final double myThick) {

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		Profiles grid = new Profiles();

		grid.myFrame2 = myFrame2;

		grid.partForm = 1;
		grid.orientation = 1;
		grid.whichPos = whichPos;
		grid.thickness = myThick;
		grid.partDimB = myThick;
		grid.startPos = 1;
		grid.endPos = dlo.yRows;

		final double slope = (dlo.rightPart.endYC - dlo.rightPart.startYC)
				/ (dlo.rightPart.endXC - dlo.rightPart.startXC);

		final double halfThick = myThick / 2;

		final double theta = Math.atan(Math.abs(slope));

		double dist = 0;
		double max = 0;

		if (!dlo.masterW) {
			for (Object d : dlo.anchorsV.toArray()) {
				if (Double.parseDouble(d.toString()) > max) {
					max = Double.parseDouble(d.toString());
				}
			}

			for (Object d : dlo.anchorsV.toArray()) {
				if (Double.parseDouble(d.toString()) == max) {
					dist = Double.parseDouble(d.toString());
					// dist = dist + halfThick;
					break;
				}
			}

			if (dlo.gridType % 2 == 0) {
				dlo.perimeterH = (dlo.bX2 - dist) / myScale.doubleValue();
				;
			}
		}

		double px2 = dlo.perimeterH * myScale.doubleValue();

		double pxc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		double px1 = dlo.perimeterH * myScale.doubleValue() + myThick;

		if (theta != 0) {
			px2 = px2 / Math.sin(theta);

			pxc = pxc / Math.sin(theta);

			px1 = px1 / Math.sin(theta);
		}

		grid.x1al = grid.x1 = dlo.rightPart.startXC - px1;

		grid.x4al = grid.x4 = dlo.rightPart.endXC - px1;

		grid.x2cl = grid.x2 = dlo.rightPart.startXC - px2;

		grid.x3cl = grid.x3 = dlo.rightPart.endXC - px2;

		grid.centerXs = dlo.rightPart.startXC - pxc;
		grid.centerXe = dlo.rightPart.endXC - pxc;

		Profiles limitT = new Profiles();

		Profiles limitB = new Profiles();

		limitB = dlo.bot1Part;

		if (dlo.top2Part.posInUse) {
			limitT = dlo.top2Part;
		} else {
			limitT = dlo.top1Part;
		}
		if (limitT.partForm == 1 || limitT.partForm > 1
				&& (int) limitT.startAngle == 0
				&& Math.ceil(limitT.endAngle) == 180) {

			// HR
			grid.y1al = grid.y1 = this.intersectY(grid.x1,
					dlo.rightPart.startYC, grid.x4, dlo.rightPart.endYC,
					limitT.startXC, limitT.startYC, limitT.endXC, limitT.endYC);
			grid.x1al = grid.x1 = this.intersectX(grid.x1,
					dlo.rightPart.startYC, grid.x4, dlo.rightPart.endYC,
					limitT.startXC, limitT.startYC, limitT.endXC, limitT.endYC);

			grid.y2cl = grid.y2 = this.intersectY(grid.x2,
					dlo.rightPart.startYC, grid.x3, dlo.rightPart.endYC,
					limitT.startXC, limitT.startYC, limitT.endXC, limitT.endYC);

			grid.x2cl = grid.x2 = this.intersectX(grid.x2,
					dlo.rightPart.startYC, grid.x3, dlo.rightPart.endYC,
					limitT.startXC, limitT.startYC, limitT.endXC, limitT.endYC);

			grid.centerYs = this.intersectY(grid.centerXs,
					dlo.rightPart.startYC, grid.centerXe, dlo.rightPart.endYC,
					limitT.startXC, limitT.startYC, limitT.endXC, limitT.endYC);

			grid.centerXs = this.intersectX(grid.centerXs,
					dlo.rightPart.startYC, grid.centerXe, dlo.rightPart.endYC,
					limitT.startXC, limitT.startYC, limitT.endXC, limitT.endYC);
		} else if (limitT.partForm == 1 || limitT.partForm > 1
				&& (int) limitT.startAngle == 0
				&& Math.ceil(limitT.endAngle + limitT.startAngle) < 90) {

			// HR QRR
			grid.y1al = grid.y1 = this.intersectY(grid.x1,
					dlo.rightPart.startYC, grid.x4, dlo.rightPart.endYC,
					limitT.startXC, limitT.endYC, limitT.endXC, limitT.endYC);
			grid.x1al = grid.x1 = this.intersectX(grid.x1,
					dlo.rightPart.startYC, grid.x4, dlo.rightPart.endYC,
					limitT.startXC, limitT.endYC, limitT.endXC, limitT.endYC);

			grid.y2cl = grid.y2 = this.intersectY(grid.x2,
					dlo.rightPart.startYC, grid.x3, dlo.rightPart.endYC,
					limitT.startXC, limitT.endYC, limitT.endXC, limitT.endYC);

			grid.x2cl = grid.x2 = this.intersectX(grid.x2,
					dlo.rightPart.startYC, grid.x3, dlo.rightPart.endYC,
					limitT.startXC, limitT.endYC, limitT.endXC, limitT.endYC);

			grid.centerYs = this.intersectY(grid.centerXs,
					dlo.rightPart.startYC, grid.centerXe, dlo.rightPart.endYC,
					limitT.startXC, limitT.endYC, limitT.endXC, limitT.endYC);

			grid.centerXs = this.intersectX(grid.centerXs,
					dlo.rightPart.startYC, grid.centerXe, dlo.rightPart.endYC,
					limitT.startXC, limitT.endYC, limitT.endXC, limitT.endYC);
		} else {

			grid.y1al = grid.y1 = arcX.getYusingX(grid.x1, 0, grid.x4, 500,
					limitT.radius1BA, limitT.x1, limitT.y1, false);

			grid.y2cl = grid.y2 = arcX.getYusingX(grid.x2, 0, grid.x3, 500,
					limitT.radius1BA, limitT.x1, limitT.y1, false);

			grid.centerYs = arcX.getYusingX(grid.centerXs, 0, grid.centerXe,
					500, limitT.radius1BA, limitT.x1, limitT.y1, false);

		}

		if (limitB.partForm == 1
				|| limitB.partForm > 1
				&& ((int) limitB.startAngle >= 180
						&& Math.ceil(limitB.endAngle) == 180 || (int) limitB.startAngle >= 270)) {

			grid.y4al = grid.y4 = this.intersectY(grid.x1,
					dlo.rightPart.startYC, grid.x4, dlo.rightPart.endYC,
					limitB.startXC, limitB.startYC, limitB.endXC, limitB.endYC);

			grid.x4al = grid.x4 = this.intersectX(grid.x1,
					dlo.rightPart.startYC, grid.x4, dlo.rightPart.endYC,
					limitB.startXC, limitB.startYC, limitB.endXC, limitB.endYC);

			grid.y3cl = grid.y3 = this.intersectY(grid.x2,
					dlo.rightPart.startYC, grid.x3, dlo.rightPart.endYC,
					limitB.startXC, limitB.startYC, limitB.endXC, limitB.endYC);
			grid.x3cl = grid.x3 = this.intersectX(grid.x2,
					dlo.rightPart.startYC, grid.x3, dlo.rightPart.endYC,
					limitB.startXC, limitB.startYC, limitB.endXC, limitB.endYC);

			grid.centerYe = this.intersectY(grid.centerXs,
					dlo.rightPart.startYC, grid.centerXe, dlo.rightPart.endYC,
					limitB.startXC, limitB.startYC, limitB.endXC, limitB.endYC);
			grid.centerXe = this.intersectX(grid.centerXs,
					dlo.rightPart.startYC, grid.centerXe, dlo.rightPart.endYC,
					limitB.startXC, limitB.startYC, limitB.endXC, limitB.endYC);
		} else {

			grid.y4al = grid.y4 = arcX.getYusingX(grid.x1, 0, grid.x4, 500,
					limitB.radius1BA, limitB.x1, limitB.y1, false);

			grid.y3cl = grid.y3 = arcX.getYusingX(grid.x2, 0, grid.x3, 500,
					limitB.radius1BA, limitB.x1, limitB.y1, false);

			grid.centerYe = arcX.getYusingX(grid.centerXs, 0, grid.centerXe,
					500, limitB.radius1BA, limitB.x1, limitB.y1, false);
			arcX = null;

		}
		grid.exists = 1;
		grid.length = grid.centerYe - grid.centerYs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = 2;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.yRows;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y3a = grid.y3b = grid.y4al;
		grid.y3a = grid.y4a = grid.y4b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);
		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsV.add(grid);

		dlo.gridMasksV.add(grid);

		dlo.bOpeningObject.mullions.add(grid);

	}

	public void setAnchorsHInMaster() {

		Object[] mydlos;
		mydlos = DLOs.toArray();
		DLOs.clear();

		int initNoLites = 0;
		double totalThick = 0;
		double resultLiteH = 0;

		double myIdealGH = 0;
		double myThick = 0;
		double dloH = 0;
		for (Object dlo : mydlos) {
			dloH = ((DLO) dlo).lowestY - ((DLO) dlo).highestY;

			if (((DLO) dlo).gridType % 2 != 0) {
				if (((DLO) dlo).masterH) {

					boolean ideal = false;
					myIdealGH = ((DLO) dlo).idealGH * myScale.doubleValue();

					if (phiH) {
						myIdealGH = ((DLO) dlo).idealGW * myScale.doubleValue()
								* 1.61803399999999f;
					}
					if (phiH && reversePhi) {
						myIdealGH = ((DLO) dlo).idealGW * myScale.doubleValue()
								/ 1.61803399999999f;
					}

					myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

					double deltaF = 0;
					double deltaC = 0;

					initNoLites = (int) Math.ceil(dloH / myIdealGH);
					totalThick = myThick * (initNoLites - 1);
					resultLiteH = (dloH - totalThick) / initNoLites;
					deltaC = Math.abs(resultLiteH - myIdealGH);

					initNoLites = (int) Math.floor(dloH / myIdealGH);
					totalThick = myThick * (initNoLites - 1);
					resultLiteH = (dloH - totalThick) / initNoLites;
					deltaF = Math.abs(resultLiteH - myIdealGH);

					if (deltaF < deltaC) {
						initNoLites = (int) Math.floor(dloH / myIdealGH);
						totalThick = myThick * (initNoLites - 1);
						resultLiteH = (dloH - totalThick) / initNoLites;
					} else {
						initNoLites = (int) Math.ceil(dloH / myIdealGH);
						totalThick = myThick * (initNoLites - 1);
						resultLiteH = (dloH - totalThick) / initNoLites;
					}

					if (resultLiteH == myIdealGH) {
						ideal = true;
					} else {

						int count = 0;
						double lastH = 0;
						double delta = 0;
						double lastDelta = 0;
						int lastNoLites = 0;
						do {
							initNoLites = initNoLites + count;
							count++;
							totalThick = myThick * (initNoLites - 1);
							resultLiteH = (dloH - totalThick) / initNoLites;

							delta = Math.abs(myIdealGH - resultLiteH);
							lastDelta = Math.abs(myIdealGH - lastH);
							if (delta > lastDelta) {
								resultLiteH = lastH;
								initNoLites = lastNoLites;
								ideal = true;
							} else if (resultLiteH <= myIdealGH) {
								ideal = true;
								// count
								// =
								// count-2;
							} else {
								lastH = resultLiteH;
								lastNoLites = initNoLites;
							}

						} while (!ideal);
						final double anchorH = ((DLO) dlo).highestY;

						totalThick = (initNoLites - 1) * myThick;
						resultLiteH = (dloH - totalThick) / initNoLites;
						((DLO) dlo).liteH = resultLiteH;

						dlo = this.calcAnchorH(initNoLites, resultLiteH,
								myThick, dlo, anchorH, whichPos, true);

					}

				}
			} else {
				dlo = doPerimeterGridH((DLO) dlo);

			}// if Perimeter

			DLOs.add(dlo);
		}

	}

	public DLO doPerimeterGridH(final DLO dlo) {

		if (dlo.masterH) {
			boolean doTop3 = true;
			boolean doBot = true;
			boolean doTop = true;
			boolean doTop2 = true;
			boolean cont = true;

			String message = "Daylight Opening (DLO : " + dlo.a_sequenceID
					+ " ) Height too small \n"
					+ "for the selected grid's Perimeter Distance!";

			if (Math.max(dlo.bY3, dlo.bY4) - dlo.highestY < 3 * dlo.perimeterH
					* myScale.doubleValue()
					&& dlo.noSidesTop == 1) {
				if (dlo.botIn
						&& !dlo.topIn
						&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
								* myScale.doubleValue()) {
					doTop = true;
					doBot = false;
					cont = true;
					message = "Only Top Perimeter Grid will be calculated for \n"
							+ " Opening (DLO : " + dlo.a_sequenceID + " )";
				} else if (!dlo.botIn
						&& dlo.topIn
						&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
								* myScale.doubleValue()) {
					doTop = false;
					doBot = true;
					cont = true;
					message = "Only Bottom Perimeter Grid will be calculated for \n"
							+ " Opening (DLO : " + dlo.a_sequenceID + " )";
				} else if (!dlo.botIn
						&& !dlo.topIn
						&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
								* myScale.doubleValue()) {
					doBot = false;
					doTop = false;
					cont = false;

				}
				JOptionPane.showMessageDialog(null, message,
						"DLO Height Error", JOptionPane.ERROR_MESSAGE);

			} else if (dlo.noSidesTop > 1
					&& Math.max(dlo.bX2, dlo.bX3) - Math.max(dlo.bY3, dlo.bY4)
							- dlo.highestY < 3 * dlo.perimeterH
							* myScale.doubleValue()) {

				doTop3 = true;
				doBot = true;
				doTop = true;
				doTop2 = true;
				cont = true;

				final double top2Slope = (dlo.top2Part.endYC - dlo.top2Part.startYC)
						/ (dlo.top2Part.endXC - dlo.top2Part.startXC);

				final double top1Slope = (dlo.top1Part.endYC - dlo.top1Part.startYC)
						/ (dlo.top1Part.endXC - dlo.top1Part.startXC);

				if (dlo.top2Part.partForm == 1 && top2Slope == 0) {
					doTop2 = false;
					if (dlo.botIn
							&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
									* myScale.doubleValue()) {
						doTop2 = true;

						cont = true;
						message = "Only Top Perimeter Grid will be calculated for \n"
								+ " Opening (DLO : " + dlo.a_sequenceID + " )";
					}

				} else if (dlo.top1Part.partForm == 1 && top1Slope == 0) {
					doTop = false;
					if (dlo.botIn
							&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
									* myScale.doubleValue()) {
						doTop = true;

						cont = true;
						message = "Only Top Perimeter Grid will be calculated for \n"
								+ " Opening (DLO : " + dlo.a_sequenceID + " )";
					}

				} else if (dlo.top3Part.posInUse) {
					doTop3 = false;
					if (dlo.botIn
							&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
									* myScale.doubleValue()) {
						doTop3 = true;

						cont = true;
						message = "Only Top Perimeter Grid will be calculated for \n"
								+ " Opening (DLO : " + dlo.a_sequenceID + " )";
					}
				}
				doBot = false;
				if (!dlo.botIn
						&& !dlo.topIn
						&& Math.max(dlo.bY3, dlo.bY4) - dlo.highestY > dlo.perimeterH
								* myScale.doubleValue() && !doTop) {

					doBot = true;
					cont = true;
					message = "Only Bottom Perimeter Grid will be calculated for \n"
							+ " Opening (DLO : " + dlo.a_sequenceID + " )";
				}

				JOptionPane.showMessageDialog(null, message,
						"DLO Height Error", JOptionPane.ERROR_MESSAGE);

			}

			if (cont) {

				if (!dlo.top3Part.posInUse) {
					doTop3 = false;
				}

				double myThick;
				dlo.anchorsH.clear();
				dlo.gridPartsH.clear();

				dlo.anchorsH.add(dlo.highestY + dlo.perimeterH
						* myScale.doubleValue());
				dlo.anchorsH.add(dlo.lowestY - dlo.perimeterH
						* myScale.doubleValue());

				myThick = dlo.gridThick * myScale.doubleValue();

				final Object[] aV = dlo.anchorsH.toArray();
				int count = 0;
				for (final Object av : aV) {
					count++;

					if (count == 1) {
						if (dlo.noSidesTop >= 1 && doTop) {

							this.hardHs.addAll(dlo.anchorsH);

							top1PartPerimeter(dlo, myThick, count, doTop3);
						}

						if (dlo.noSidesTop >= 2 && doTop2) {

							top2PartPerimeter(dlo, myThick, count, doTop3);
						}

						if (dlo.noSidesTop >= 3 && doTop3) {

							top3PartPerimeter(dlo, myThick, count);
						}

					} else if (count == 2 && doBot) {

						doBotPerimeterH(dlo, myThick, count);

					}
					dlo.liteH = dlo.perimeterH;
					dlo.noGridsH = dlo.anchorsH.size();
					if (((DLO) dlo).myParentO.myGlassMid != null) {
						((DLO) dlo).myParentO.myGlassMid.noGridsH = dlo.noGridsH;
					}

				}
			}
		}

		return dlo;
	}

	public void top1PartPerimeter(final DLO dlo, final double myThick,
			final int count, final boolean doTop3) {

		Profiles grid = new Profiles();

		grid.myFrame2 = myFrame2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		grid.partForm = dlo.top1Part.partForm;

		grid.orientation = 2;
		grid.thickness = myThick;
		grid.partDimB = myThick;
		grid.whichPos = whichPos;

		final double slope = (dlo.top1Part.endYC - dlo.top1Part.startYC)
				/ (dlo.top1Part.endXC - dlo.top1Part.startXC);

		final double halfThick = myThick / 2;

		double theta = 0;

		double py2 = 0;

		double pyc = 0;

		double py1 = 0;

		theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		py2 = dlo.perimeterH * myScale.doubleValue();

		pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		py1 = dlo.perimeterH * myScale.doubleValue() + myThick;

		if (grid.partForm == 1) {

			if (theta != 0) {
				py2 = py2 / Math.sin(theta);

				pyc = pyc / Math.sin(theta);

				py1 = py1 / Math.sin(theta);
			}

			grid.y1al = grid.y1 = dlo.top1Part.startYC + py1;

			grid.y4al = grid.y4 = dlo.top1Part.endYC + py1;

			grid.y2cl = grid.y2 = dlo.top1Part.startYC + py2;

			grid.y3cl = grid.y3 = dlo.top1Part.endYC + py2;

			grid.centerYs = dlo.top1Part.startYC + pyc;
			grid.centerYe = dlo.top1Part.endYC + pyc;

			Profiles limitL = new Profiles();

			Profiles limitEnd = new Profiles();

			if (dlo.left.posInUse) {
				limitL = dlo.leftPart;
			} else if (!dlo.left.posInUse && dlo.bot2.posInUse) {
				limitL = dlo.bot2Part;
			} else if (!dlo.left.posInUse && !dlo.bot2.posInUse) {
				limitL = dlo.bot1Part;
			}

			if (!dlo.top2.posInUse && dlo.right.posInUse) {
				limitEnd = dlo.rightPart;
			} else if (!dlo.top2.posInUse && !dlo.right.posInUse) {
				limitEnd = dlo.bot1Part;
			} else if (dlo.top2.posInUse && !dlo.top3.posInUse) {
				limitEnd = dlo.top2Part;
			} else if (dlo.top3.posInUse) {
				limitEnd = dlo.top3Part;
			}

			grid.x1al = grid.x1 = this.intersectX(dlo.top1Part.startXC,
					grid.y1, dlo.top1Part.endXC, grid.y4, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.x2cl = grid.x2 = this.intersectX(dlo.top1Part.startXC,
					grid.y2, dlo.top1Part.endXC, grid.y3, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.centerXs = this.intersectX(dlo.top1Part.startXC,
					grid.centerYs, dlo.top1Part.endXC, grid.centerYe,
					limitL.endXC, limitL.endYC, limitL.startXC, limitL.startYC);

			grid.y1al = grid.y1 = this.intersectY(dlo.top1Part.startXC,
					grid.y1, dlo.top1Part.endXC, grid.y4, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.y2cl = grid.y2 = this.intersectY(dlo.top1Part.startXC,
					grid.y2, dlo.top1Part.endXC, grid.y3, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.centerYs = this.intersectY(dlo.top1Part.startXC,
					grid.centerYs, dlo.top1Part.endXC, grid.centerYe,
					limitL.endXC, limitL.endYC, limitL.startXC, limitL.startYC);

			if (dlo.noSides != 6) {
				grid.x4al = grid.x4 = this.intersectX(dlo.top1Part.startXC,
						grid.y1, dlo.top1Part.endXC, grid.y4, limitEnd.startXC,
						limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

				grid.x3cl = grid.x3 = this.intersectX(dlo.top1Part.startXC,
						grid.y2, dlo.top1Part.endXC, grid.y3, limitEnd.startXC,
						limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

				grid.centerXe = this.intersectX(dlo.top1Part.startXC,
						grid.centerYs, dlo.top1Part.endXC, grid.centerYe,
						limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
						limitEnd.endYC);

				grid.y4al = grid.y4 = this.intersectY(dlo.top1Part.startXC,
						grid.y1, dlo.top1Part.endXC, grid.y4, limitEnd.startXC,
						limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

				grid.y3cl = grid.y3 = this.intersectY(dlo.top1Part.startXC,
						grid.y2, dlo.top1Part.endXC, grid.y3, limitEnd.startXC,
						limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

				grid.centerYe = this.intersectY(dlo.top1Part.startXC,
						grid.centerYs, dlo.top1Part.endXC, grid.centerYe,
						limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
						limitEnd.endYC);
			} else {
				theta = Math.atan(Math.abs(slope));

				py2 = dlo.perimeterH * myScale.doubleValue();

				pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

				py1 = dlo.perimeterH * myScale.doubleValue() + myThick;

				if (theta != 0) {
					py2 = py2 / Math.sin(theta);

					pyc = pyc / Math.sin(theta);

					py1 = py1 / Math.sin(theta);
				}

				grid.x4al = grid.x4 = dlo.top1Part.endXC + py1;

				grid.x3cl = grid.x3 = dlo.top1Part.endXC + py2;

				grid.centerXe = dlo.top1Part.endXC + pyc;

				grid.x4al = grid.x4 = this.intersectX(grid.x1,
						dlo.top1Part.startYC, grid.x4, dlo.top1Part.endYC,
						limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
						limitEnd.endYC);

				grid.x3cl = grid.x3 = this.intersectX(grid.x2,
						dlo.top1Part.startYC, grid.x3, dlo.top1Part.endYC,
						limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
						limitEnd.endYC);

				grid.centerXe = this.intersectX(grid.centerXs,
						dlo.top1Part.startYC, grid.centerXe,
						dlo.top1Part.endYC, limitEnd.startXC, limitEnd.startYC,
						limitEnd.endXC, limitEnd.endYC);

				grid.y4al = grid.y4 = this.intersectY(grid.x1,
						dlo.top1Part.startYC, grid.x4, dlo.top1Part.endYC,
						limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
						limitEnd.endYC);

				grid.y3cl = grid.y3 = this.intersectY(grid.x2,
						dlo.top1Part.startYC, grid.x3, dlo.top1Part.endYC,
						limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
						limitEnd.endYC);

				grid.centerYe = this.intersectY(grid.centerXs,
						dlo.top1Part.startYC, grid.centerXe,
						dlo.top1Part.endYC, limitEnd.startXC, limitEnd.startYC,
						limitEnd.endXC, limitEnd.endYC);
			}
		} else if (grid.partForm > 1) {// HR/Arch

			grid.partForm = 2;

			deduct1 = deduct2 = py2;

			if (dlo.shapeID == 200 || dlo.shapeID == 300) {// HR/Arch

				doTop1ArcHRPerimter(dlo, grid, py2);

			} else if (dlo.shapeID == 201) {// QRL

				doTop1ArcHRPerimter(dlo, grid, py2);

			} else if (dlo.shapeID == 202) {// QRR

				doTop1ArcHRPerimter(dlo, grid, py2);

			} else if (dlo.shapeID == 203) {// QRR

				doTop1ArcHRPerimter(dlo, grid, py2);

			} else if (dlo.shapeID == 204 || dlo.shapeID == 205
					&& dlo.noSidesTop == 1) {// QRR

				doTop1ArcHRPerimter(dlo, grid, py2);

			} else if (dlo.shapeID == 300) {// HR/Arch

				doTop1ArcPerimterLRSides(dlo, grid, py2);

			} else if (dlo.shapeID == 301 && dlo.noSidesTop == 1) {// QAL

				doTop1ArcPerimterLRSides(dlo, grid, py2);

			} else if (dlo.shapeID == 302 && dlo.noSidesTop == 1) {// QAR

				doTop1ArcPerimterLRSides(dlo, grid, py2);

			} else if (dlo.shapeID == 304 && dlo.noSidesTop == 1
					&& dlo.noSidesRight == 1) {// QRl

				doTop1ArcQRL(dlo, grid, py2);

			} else if (dlo.shapeID == 305 && dlo.noSidesTop == 1
					&& dlo.noSidesLeft == 1) {// QRr

				doTop1ArcQRR(dlo, grid, py2);

			} else if (dlo.noSidesTop == 3) {// QRr

				doTop1ArcTop3(dlo, grid, py2, doTop3);

			} else if (dlo.shapeID > 300 && dlo.noSidesTop == 1
					&& dlo.noSidesRight == 0 && dlo.noSidesLeft == 0
					&& dlo.noSidesBot == 1) {// QRl

				doTop1HalfArcPerimter(dlo, grid, py2);

			} else if (dlo.shapeID == 303) {// QRR

				doTop1HalfArcPerimter(dlo, grid, py2);

			}

		}

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = count;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y4a = grid.y4b = grid.y4al;
		grid.y3a = grid.y3a = grid.y3b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);

		if (grid.partForm == 1) {
			final Polygon m = new Polygon();

			m.addPoint((int) grid.x1a, (int) grid.y1a);
			m.addPoint((int) grid.x2a, (int) grid.y2a);
			m.addPoint((int) grid.x3a, (int) grid.y3a);
			m.addPoint((int) grid.x4a, (int) grid.y4a);
			m.addPoint((int) grid.x1a, (int) grid.y1a);
			grid.gp.reset();
			grid.poly.reset();
			grid.gp.append(m, false);
			grid.poly = m;
		} else {

			grid.gp = grid.curvePart(grid, 0, true);
			grid.curveB = grid.curvePart(grid, 1, true);
			grid.curveBA = grid.curvePart(grid, 2, true);

			grid.curveA = grid.curvePart(grid, 3, true);
		}

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);

	}

	public void doTop1ArcHRPerimter(final DLO dlo, final Profiles grid,
			final double py2) {

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		yFirst = dlo.top1Part.startYC;

		yLast = dlo.top1Part.endYC;

		grid.focal1X = grid.focal1XA = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YA = grid.focal1YBA = grid.focal1YA = dlo.centerPointY;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2;

		grid.radius1 = dlo.radius1 - deduct1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.radius1 - deduct1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = grid.radius1 * 2;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = grid.radius1A * 2;

		grid.bkgrdHeight = 2 * grid.radius1;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = grid.radius1A * 2;

		grid.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top1Part.bkgrdStartX
				+ deduct1 + +grid.thickness;

		grid.bkgrdStartY = dlo.highestY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = dlo.highestY + deduct1
				+ grid.thickness;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		double[] anglesOut;
		double[] anglesIn;
		if ((int) dlo.top1Part.startAngle == 0
				&& Math.ceil(dlo.top1Part.endAngle) == 180
				|| (int) dlo.top1Part.startAngle == 0
				&& Math.ceil(dlo.top1Part.endAngle) == 90) {
			anglesOut = createShape.getArchesAngles(0, 500, yFirst, yLast,
					grid.radius1, grid.focal1X, grid.focal1Y, false, false);

			anglesIn = createShape.getArchesAngles(0, 500, yFirst, yLast,
					grid.radius1A, grid.focal1XA, grid.focal1YA, false, false);
		} else {
			anglesOut = createShape.getArchesAngles(dlo.top1Part.startXC,
					dlo.top1Part.endXC, yFirst, yLast, grid.radius1,
					grid.focal1X, grid.focal1Y, false, false);

			anglesIn = createShape.getArchesAngles(dlo.top1Part.startXC,
					dlo.top1Part.endXC, yFirst + deduct1, yLast + deduct1,
					grid.radius1A, grid.focal1XA, grid.focal1YA, false, false);
		}

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = anglesOut[1];
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = anglesIn[1];
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];

	}

	public void doTop1ArcPerimterLRSides(final DLO dlo, final Profiles grid,
			final double py2) {

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		grid.focal1X = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YBA = grid.focal1YA = dlo.centerPointY
				+ deduct1;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2
				+ deduct1;

		yFirst = dlo.top1Part.startYC + deduct1;
		yLast = dlo.top1Part.endYC + deduct1;

		grid.radius1 = dlo.radius1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.top1Part.radius1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = dlo.top1Part.bkgrdWidth;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = dlo.top1Part.bkgrdWidth - 2
				* grid.thickness;

		grid.bkgrdHeight = dlo.top1Part.bkgrdHeight;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = dlo.top1Part.bkgrdHeight - 2
				* grid.thickness;

		grid.bkgrdStartX = dlo.top1Part.bkgrdStartX;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top1Part.bkgrdStartX
				+ +grid.thickness;

		grid.bkgrdStartY = dlo.highestY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = grid.bkgrdStartY
				+ +grid.thickness;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		double[] anglesOut;
		double[] anglesIn;
		if ((int) dlo.top1Part.startAngle == 0
				&& Math.ceil(dlo.top1Part.endAngle) == 180
				|| (int) dlo.top1Part.startAngle == 0
				&& Math.ceil(dlo.top1Part.endAngle) == 90) {
			anglesOut = createShape.getArchesAngles(0, 500, yFirst, yLast,
					grid.radius1, grid.focal1X, grid.focal1Y, false, false);

			anglesIn = createShape.getArchesAngles(0, 500, yFirst, yLast,
					grid.radius1A, grid.focal1XA, grid.focal1YA, false, false);
		} else {
			anglesOut = createShape.getArchesAngles(dlo.top1Part.startXC,
					dlo.top1Part.endXC, yFirst, yLast, grid.radius1,
					grid.focal1X, grid.focal1Y, false, false);

			anglesIn = createShape.getArchesAngles(dlo.top1Part.startXC,
					dlo.top1Part.endXC, yFirst + deduct1, yLast + deduct1,
					grid.radius1A, grid.focal1XA, grid.focal1YA, false, false);
		}

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = anglesOut[1];
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = anglesIn[1];
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];
	}

	public void doTop1ArcQRL(final DLO dlo, final Profiles grid,
			final double py2) {

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		yFirst = dlo.top1Part.startYC;

		yLast = dlo.top1Part.endYC + deduct1;

		grid.focal1X = grid.focal1XA = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YA = grid.focal1YBA = grid.focal1YA = dlo.centerPointY;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2;

		grid.radius1 = dlo.radius1 - deduct1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.radius1 - deduct1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = grid.radius1 * 2;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = grid.radius1A * 2;

		grid.bkgrdHeight = 2 * grid.radius1;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = grid.radius1A * 2;

		grid.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top1Part.bkgrdStartX
				+ deduct1 + +grid.thickness;

		grid.bkgrdStartY = dlo.highestY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = dlo.highestY + deduct1
				+ grid.thickness;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		double sX = arcX.getXusingY(0, yFirst, 500, yFirst, grid.radius1,
				grid.focal1X, grid.focal1Y, false);

		double[] anglesOut;
		double[] anglesIn;
		anglesOut = createShape.getArchesAngles(sX, dlo.top1Part.endXC, yFirst,
				yLast, grid.radius1, grid.focal1X, grid.focal1Y, false, false);

		sX = arcX.getXusingY(0, yFirst, 500, yFirst, grid.radius1A,
				grid.focal1XA, grid.focal1YA, false);

		anglesIn = createShape.getArchesAngles(sX, dlo.top1Part.endXC, yFirst,
				yLast, grid.radius1A, grid.focal1XA, grid.focal1YA, false,
				false);
		// }

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = anglesOut[1];
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = anglesIn[1];
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];

		arcX = null;
	}

	public void doTop1ArcQRR(final DLO dlo, final Profiles grid,
			final double py2) {

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		yFirst = dlo.top1Part.startYC + deduct1;

		yLast = dlo.top1Part.endYC;

		grid.focal1X = grid.focal1XA = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YA = grid.focal1YBA = grid.focal1YA = dlo.centerPointY;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2;

		grid.radius1 = dlo.radius1 - deduct1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.radius1 - deduct1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = grid.radius1 * 2;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = grid.radius1A * 2;

		grid.bkgrdHeight = 2 * grid.radius1;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = grid.radius1A * 2;

		grid.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top1Part.bkgrdStartX
				+ deduct1 + +grid.thickness;

		grid.bkgrdStartY = dlo.highestY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = dlo.highestY + deduct1
				+ grid.thickness;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		double sX = arcX.getXusingY(0, yLast, 500, yLast, grid.radius1,
				grid.focal1X, grid.focal1Y, true);

		double[] anglesOut;
		double[] anglesIn;

		anglesOut = createShape.getArchesAngles(dlo.top1Part.startXC, sX,
				yFirst, yLast, grid.radius1, grid.focal1X, grid.focal1Y, true,
				true);

		sX = arcX.getXusingY(0, yLast, 500, yLast, grid.radius1A,
				grid.focal1XA, grid.focal1YA, true);

		anglesIn = createShape.getArchesAngles(dlo.top1Part.startXC, sX,
				yFirst, yLast, grid.radius1A, grid.focal1XA, grid.focal1YA,
				true, true);

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = anglesOut[1];
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = anglesIn[1];
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];

		arcX = null;
	}

	public void doTop1ArcTop3(final DLO dlo, final Profiles grid,
			final double py2, final boolean doTop3) {

		yFirst = dlo.bot1Part.endYC;

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		yLast = dlo.top3Part.startYC;

		grid.focal1X = grid.focal1XA = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YA = grid.focal1YBA = grid.focal1YA = dlo.centerPointY;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2;

		grid.radius1 = dlo.radius1 - deduct1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.radius1 - deduct1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = grid.radius1 * 2;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = grid.radius1A * 2;

		grid.bkgrdHeight = 2 * grid.radius1;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = grid.radius1A * 2;

		grid.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top1Part.bkgrdStartX
				+ deduct1 + +grid.thickness;

		grid.bkgrdStartY = dlo.top1Part.bkgrdStartY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = dlo.top1Part.bkgrdStartY
				+ deduct1 + grid.thickness;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		if (dlo.noSidesLeft == 1) {
			yFirst = arcX.getXusingY(dlo.leftPart.startXC,
					dlo.leftPart.startYC, dlo.leftPart.endXC,
					dlo.leftPart.endYC, grid.radius1, grid.focal1X,
					grid.focal1Y, false);
		}

		double sX = 0;
		double eX = 0;

		eX = arcX.getXusingY(dlo.top3Part.startXC, dlo.top3Part.startYC,
				dlo.top3Part.endXC, dlo.top3Part.endYC, grid.radius1,
				grid.focal1X, grid.focal1Y, false);

		if (dlo.noSidesLeft == 1) {
			sX = dlo.top1Part.startXC;
		} else {
			sX = arcX.getXusingY(dlo.bot1Part.startXC, dlo.bot1Part.startYC,
					dlo.bot1Part.endXC, dlo.bot1Part.endYC, grid.radius1,
					grid.focal1X, grid.focal1Y, false);
		}

		double[] anglesOut;
		double[] anglesIn;

		anglesOut = createShape.getArchesAngles(sX, eX, yFirst, yLast,
				grid.radius1, grid.focal1X, grid.focal1Y, true, true);

		eX = arcX.getXusingY(dlo.top3Part.startXC, dlo.top3Part.startYC,
				dlo.top3Part.endXC, dlo.top3Part.endYC, grid.radius1A,
				grid.focal1XA, grid.focal1YA, false);

		if (dlo.noSidesLeft == 1) {
			sX = dlo.top1Part.startXC;
		} else {
			sX = arcX.getXusingY(dlo.bot1Part.startXC, dlo.bot1Part.startYC,
					dlo.bot1Part.endXC, dlo.bot1Part.endYC, grid.radius1A,
					grid.focal1XA, grid.focal1YA, false);
		}

		anglesIn = createShape.getArchesAngles(sX, eX, yFirst, yLast,
				grid.radius1A, grid.focal1XA, grid.focal1YA, true, true);

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = anglesOut[1];
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = anglesIn[1];
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];

		arcX = null;
	}

	public void doTop1HalfArcPerimter(final DLO dlo, final Profiles grid,
			final double py2) {

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		yFirst = dlo.bot1Part.endYC;

		yLast = dlo.bot1Part.startYC;

		grid.focal1X = grid.focal1XA = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YA = grid.focal1YBA = grid.focal1YA = dlo.centerPointY;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2;

		grid.radius1 = dlo.radius1 - deduct1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.radius1 - deduct1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = grid.radius1 * 2;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = grid.radius1A * 2;

		grid.bkgrdHeight = 2 * grid.radius1;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = grid.radius1A * 2;

		grid.bkgrdStartX = dlo.top1Part.bkgrdStartX + deduct1;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top1Part.bkgrdStartX
				+ deduct1 + +grid.thickness;

		grid.bkgrdStartY = dlo.highestY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = dlo.highestY + deduct1
				+ grid.thickness;

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		final EllipseLineIntersections arcX = new EllipseLineIntersections();

		final double sX = arcX.getXusingY(0, yFirst, 500, yFirst, grid.radius1,
				grid.focal1X, grid.focal1Y, false);

		final double eX = arcX.getXusingY(0, yFirst, 500, yFirst, grid.radius1,
				grid.focal1X, grid.focal1Y, true);

		double[] anglesOut;
		double[] anglesIn;

		anglesOut = createShape.getArchesAngles(sX, eX, yFirst, yLast,
				grid.radius1, grid.focal1X, grid.focal1Y, true, true);

		anglesIn = createShape.getArchesAngles(sX, eX, yFirst, yLast,
				grid.radius1A, grid.focal1XA, grid.focal1YA, true, true);

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = 180 - 2 * grid.startAngle;
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = 180 - 2 * grid.startAngleA;
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];

	}

	public void top2PartPerimeter(final DLO dlo, final double myThick,
			final int count, final boolean doTop3) {

		double slope;
		double halfThick;
		double theta;
		double py2;
		double pyc;
		double py1;

		Profiles grid = new Profiles();
		grid.myFrame2 = myFrame2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		grid.partForm = dlo.top2Part.partForm;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.startPos = grid.endPos = 1;
		grid.thickness = myThick;
		grid.partDimB = myThick;
		slope = (dlo.top2Part.endYC - dlo.top2Part.startYC)
				/ (dlo.top2Part.endXC - dlo.top2Part.startXC);

		halfThick = myThick / 2;

		theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		py2 = dlo.perimeterH * myScale.doubleValue();

		pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		py1 = dlo.perimeterH * myScale.doubleValue() + myThick;
		if (grid.partForm == 1) {

			if (theta != 0) {
				py2 = py2 / Math.sin(theta);

				pyc = pyc / Math.sin(theta);

				py1 = py1 / Math.sin(theta);
			}

			grid.y1al = grid.y1 = dlo.top2Part.startYC + py1;

			grid.y4al = grid.y4 = dlo.top2Part.endYC + py1;

			grid.y2cl = grid.y2 = dlo.top2Part.startYC + py2;

			grid.y3cl = grid.y3 = dlo.top2Part.endYC + py2;

			grid.centerYs = dlo.top2Part.startYC + pyc;
			grid.centerYe = dlo.top2Part.endYC + pyc;

			Profiles limitL = new Profiles();

			Profiles limitEnd = new Profiles();

			if (!dlo.top3.posInUse) {
				limitL = dlo.top1Part;
			} else if (dlo.top3.posInUse) {
				limitL = dlo.top3Part;
			}

			if (dlo.right.posInUse) {
				limitEnd = dlo.rightPart;
			} else if (!dlo.right.posInUse) {
				limitEnd = dlo.bot1Part;
			}

			grid.x4al = grid.x4 = this.intersectX(dlo.top2Part.startXC,
					grid.y1, dlo.top2Part.endXC, grid.y4, limitEnd.startXC,
					limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

			grid.x3cl = grid.x3 = this.intersectX(dlo.top2Part.startXC,
					grid.y2, dlo.top2Part.endXC, grid.y3, limitEnd.startXC,
					limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

			grid.centerXe = this.intersectX(grid.centerYs,
					dlo.top2Part.startYC, grid.centerYe, dlo.top2Part.endYC,
					limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
					limitEnd.endYC);

			grid.y4al = grid.y4 = this.intersectY(dlo.top2Part.startXC,
					grid.y1, dlo.top2Part.endXC, grid.y4, limitEnd.startXC,
					limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

			grid.y3cl = grid.y3 = this.intersectY(dlo.top2Part.startXC,
					grid.y2, dlo.top2Part.endXC, grid.y3, limitEnd.startXC,
					limitEnd.startYC, limitEnd.endXC, limitEnd.endYC);

			grid.centerYe = this.intersectY(grid.centerYs,
					dlo.top2Part.startYC, grid.centerYe, dlo.top2Part.endYC,
					limitEnd.startXC, limitEnd.startYC, limitEnd.endXC,
					limitEnd.endYC);

			if (dlo.noSides != 6) {
				grid.x1al = grid.x1 = this.intersectX(dlo.top2Part.startXC,
						grid.y1, dlo.top2Part.endXC, grid.y4, limitL.startXC,
						limitL.startYC, limitL.endXC, limitL.endYC);

				grid.x2cl = grid.x2 = this.intersectX(dlo.top2Part.startXC,
						grid.y2, dlo.top2Part.endXC, grid.y3, limitL.startXC,
						limitL.startYC, limitL.endXC, limitL.endYC);

				grid.centerXs = this.intersectX(dlo.top2Part.startXC,
						grid.centerYs, dlo.top2Part.endXC, grid.centerYe,
						limitL.startXC, limitL.startYC, limitL.endXC,
						limitL.endYC);

				grid.y1al = grid.y1 = this.intersectY(dlo.top2Part.startXC,
						grid.y1, dlo.top2Part.endXC, grid.y4, limitL.startXC,
						limitL.startYC, limitL.endXC, limitL.endYC);

				grid.y2cl = grid.y2 = this.intersectY(dlo.top2Part.startXC,
						grid.y2, dlo.top2Part.endXC, grid.y3, limitL.startXC,
						limitL.startYC, limitL.endXC, limitL.endYC);

				grid.centerYs = this.intersectY(dlo.top2Part.startXC,
						grid.centerYs, dlo.top2Part.endXC, grid.centerYe,
						limitL.startXC, limitL.startYC, limitL.endXC,
						limitL.endYC);
			} else {
				theta = Math.atan(Math.abs(slope));

				py2 = dlo.perimeterH * myScale.doubleValue();

				pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

				py1 = dlo.perimeterH * myScale.doubleValue() + myThick;

				if (theta != 0) {
					py2 = py2 / Math.sin(theta);

					pyc = pyc / Math.sin(theta);

					py1 = py1 / Math.sin(theta);
				}

				grid.x1al = grid.x1 = dlo.top2Part.startXC - py1;

				grid.x2cl = grid.x2 = dlo.top2Part.startXC - py2;

				grid.centerXs = dlo.top2Part.startXC - pyc;

				grid.x1al = grid.x1 = this.intersectX(grid.x1,
						dlo.top2Part.startYC, grid.x4, dlo.top2Part.endYC,
						limitL.startXC, limitL.startYC, limitL.endXC,
						limitL.endYC);

				grid.x2cl = grid.x2 = this.intersectX(grid.x2,
						dlo.top2Part.startYC, grid.x3, dlo.top2Part.endYC,
						limitL.startXC, limitL.startYC, limitL.endXC,
						limitL.endYC);

				grid.centerXs = this.intersectX(grid.centerXs,
						dlo.top2Part.startYC, grid.centerXe,
						dlo.top2Part.endYC, limitL.startXC, limitL.startYC,
						limitL.endXC, limitL.endYC);

				grid.y1al = grid.y1 = this.intersectY(grid.x1,
						dlo.top2Part.startYC, grid.x4, dlo.top2Part.endYC,
						limitL.startXC, limitL.startYC, limitL.endXC,
						limitL.endYC);

				grid.y2cl = grid.y2 = this.intersectY(grid.x2,
						dlo.top2Part.startYC, grid.x3, dlo.top2Part.endYC,
						limitL.startXC, limitL.startYC, limitL.endXC,
						limitL.endYC);

				grid.centerYs = this.intersectY(grid.centerXs,
						dlo.top2Part.startYC, grid.centerXe,
						dlo.top2Part.endYC, limitL.startXC, limitL.startYC,
						limitL.endXC, limitL.endYC);

			}

		} else {
			if (dlo.top3Part.posInUse) {

				doTop2ArcTop3(dlo, grid, py2, doTop3);
			} else {

			}
		}
		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;

		grid.lengthM = (new BigDecimal(grid.length).divide(
				myFrame2.metricscale, 20, BigDecimal.ROUND_UP)).intValue();
		grid.lengthI = (new BigDecimal(grid.length).divide(
				myFrame2.imperialscale, 20, BigDecimal.ROUND_UP)).intValue();

		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = count;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y4a = grid.y4b = grid.y4al;
		grid.y3a = grid.y3a = grid.y3b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);

		if (grid.partForm == 1) {
			final Polygon m = new Polygon();

			m.addPoint((int) grid.x1a, (int) grid.y1a);
			m.addPoint((int) grid.x2a, (int) grid.y2a);
			m.addPoint((int) grid.x3a, (int) grid.y3a);
			m.addPoint((int) grid.x4a, (int) grid.y4a);
			m.addPoint((int) grid.x1a, (int) grid.y1a);
			grid.gp.reset();
			grid.poly.reset();
			grid.gp.append(m, false);
			grid.poly = m;
		} else {

			grid.gp = grid.curvePart(grid, 0, true);
			grid.curveB = grid.curvePart(grid, 1, true);
			grid.curveBA = grid.curvePart(grid, 2, true);

			grid.curveA = grid.curvePart(grid, 3, true);
		}

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);

	}

	public void doTop2ArcTop3(final DLO dlo, final Profiles grid,
			final double py2, final boolean doTop3) {

		EllipseLineIntersections arcX = new EllipseLineIntersections();

		yLast = dlo.bot1Part.startYC;

		grid.partForm = 2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		deduct1 = deduct2 = py2;

		yFirst = dlo.top3Part.startYC;

		grid.focal1X = grid.focal1XA = grid.focal1XBA = grid.focal1XA = dlo.centerPointX;

		grid.focal1Y = grid.focal1YA = grid.focal1YBA = grid.focal1YA = dlo.centerPointY;

		grid.focal2X = grid.focal2XBA = grid.focal2XA = dlo.centerPointX2;

		grid.focal2Y = grid.focal2YBA = grid.focal2YA = dlo.centerPointY2;

		grid.radius1 = dlo.radius1 - deduct1;// grid.bkgrdWidth/2;

		grid.radius1A = grid.radius1BA = dlo.radius1 - deduct1 - grid.thickness;// grid.bkgrdWidth/2;

		grid.bkgrdWidth = grid.radius1 * 2;

		grid.bkgrdWidthA = grid.bkgrdWidthBA = grid.radius1A * 2;

		grid.bkgrdHeight = 2 * grid.radius1;

		grid.bkgrdHeightA = grid.bkgrdHeightBA = grid.radius1A * 2;

		grid.bkgrdStartX = dlo.top2Part.bkgrdStartX + deduct1;

		grid.bkgrdStartXA = grid.bkgrdStartXBA = dlo.top2Part.bkgrdStartX
				+ deduct1 + +grid.thickness;

		grid.bkgrdStartY = dlo.top2Part.bkgrdStartY + deduct1;

		grid.bkgrdStartYA = grid.bkgrdStartYBA = dlo.top2Part.bkgrdStartY
				+ deduct1 + grid.thickness;

		if (dlo.noSidesRight == 1) {
			yLast = arcX.getYusingX(dlo.rightPart.startXC,
					dlo.rightPart.startYC, dlo.rightPart.endXC,
					dlo.rightPart.endYC, grid.radius1, grid.focal1X,
					grid.focal1Y, true);
		}

		CreateShapeMethods createShape = new CreateShapeMethods(dlo, whichPos,
				myFrame2);

		double sX = 0;
		double eX = 0;

		sX = arcX.getXusingY(dlo.top3Part.startXC, dlo.top3Part.startYC,
				dlo.top3Part.endXC, dlo.top3Part.endYC, grid.radius1,
				grid.focal1X, grid.focal1Y, true);

		if (dlo.noSidesRight == 1) {
			eX = dlo.rightPart.startXC;
		} else {
			eX = arcX.getXusingY(dlo.bot1Part.startXC, dlo.bot1Part.startYC,
					dlo.bot1Part.endXC, dlo.bot1Part.endYC, grid.radius1,
					grid.focal1X, grid.focal1Y, true);
		}

		double[] anglesOut;
		double[] anglesIn;

		anglesOut = createShape.getArchesAngles(sX, eX, yFirst, yLast,
				grid.radius1, grid.focal1X, grid.focal1Y, true, true);

		sX = arcX.getXusingY(dlo.top3Part.startXC, dlo.top3Part.startYC,
				dlo.top3Part.endXC, dlo.top3Part.endYC, grid.radius1A,
				grid.focal1XA, grid.focal1YA, true);

		if (dlo.noSidesRight == 1) {
			eX = dlo.rightPart.startXC;
		} else {
			eX = arcX.getXusingY(dlo.bot1Part.startXC, dlo.bot1Part.startYC,
					dlo.bot1Part.endXC, dlo.bot1Part.endYC, grid.radius1A,
					grid.focal1XA, grid.focal1YA, true);
		}

		anglesIn = createShape.getArchesAngles(sX, eX, yFirst, yLast,
				grid.radius1A, grid.focal1XA, grid.focal1YA, true, true);

		createShape = null;

		grid.startAngle = anglesOut[0];
		grid.endAngle = anglesOut[1];
		grid.startYC = anglesOut[2];
		grid.endYC = anglesOut[3];

		grid.startAngleA = anglesIn[0];
		grid.endAngleA = anglesIn[1];
		grid.startYA = anglesIn[2];
		grid.endYA = anglesIn[3];

		arcX = null;
	}

	public void top3PartPerimeter(final DLO dlo, final double myThick,
			final int count) {

		final EllipseLineIntersections arcX = new EllipseLineIntersections();

		Profiles grid = new Profiles();
		grid.myFrame2 = myFrame2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		grid.partForm = dlo.top3Part.partForm;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.startPos = grid.endPos = 1;

		grid.thickness = myThick;
		grid.partDimB = myThick;

		double slope;
		double halfThick;
		double theta;
		double py2;
		double pyc;
		double py1;
		slope = (dlo.top3Part.endYC - dlo.top3Part.startYC)
				/ (dlo.top3Part.endXC - dlo.top3Part.startXC);

		halfThick = myThick / 2;

		theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		py2 = dlo.perimeterH * myScale.doubleValue();

		pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		py1 = dlo.perimeterH * myScale.doubleValue() + myThick;

		if (theta != 0) {
			py2 = py2 / Math.sin(theta);

			pyc = pyc / Math.sin(theta);

			py1 = py1 / Math.sin(theta);
		}

		grid.rowCol = 1;

		grid.y1al = grid.y1 = dlo.top3Part.startYC + py1;

		grid.y4al = grid.y4 = dlo.top3Part.endYC + py1;

		grid.y2cl = grid.y2 = dlo.top3Part.startYC + py2;

		grid.y3cl = grid.y3 = dlo.top3Part.endYC + py2;

		grid.centerYs = dlo.top3Part.startYC + pyc;
		grid.centerYe = dlo.top3Part.endYC + pyc;

		if (dlo.top1Part.partForm == 1) {
			grid.x1al = grid.x1 = this.intersectX(dlo.top3Part.startXC,
					grid.y1, dlo.top3Part.endXC, grid.y4, dlo.top1Part.endXC,
					dlo.top1Part.endYC, dlo.top1Part.startXC,
					dlo.top1Part.startYC);

			grid.x2cl = grid.x2 = this.intersectX(dlo.top3Part.startXC,
					grid.y2, dlo.top3Part.endXC, grid.y3, dlo.top1Part.endXC,
					dlo.top1Part.endYC, dlo.top1Part.startXC,
					dlo.top1Part.startYC);

			grid.centerXs = this.intersectX(dlo.top3Part.startXC,
					grid.centerYs, dlo.top3Part.endXC, grid.centerYe,
					dlo.top1Part.endXC, dlo.top1Part.endYC,
					dlo.top1Part.startXC, dlo.top1Part.startYC);
		} else {
			grid.x1al = grid.x1 = arcX.getXusingY(0, grid.y1, 500, grid.y4,
					dlo.top1Part.radius1, dlo.top1Part.x1, dlo.top1Part.y1,
					false);

			grid.x2cl = grid.x2 = arcX.getXusingY(0, grid.y2, 500, grid.y3,
					dlo.top1Part.radius1, dlo.top1Part.x1, dlo.top1Part.y1,
					false);

			grid.centerXs = arcX.getXusingY(0, grid.centerYs, 500,
					grid.centerYe, dlo.top1Part.radius1, dlo.top1Part.x1,
					dlo.top1Part.y1, false);

		}

		if (dlo.top2Part.partForm == 1) {
			grid.x4al = grid.x4 = this.intersectX(dlo.top3Part.startXC,
					grid.y1, dlo.top3Part.endXC, grid.y4, dlo.top2Part.endXC,
					dlo.top2Part.endYC, dlo.top2Part.startXC,
					dlo.top2Part.startYC);

			grid.x3cl = grid.x3 = this.intersectX(dlo.top3Part.startXC,
					grid.y2, dlo.top3Part.endXC, grid.y3, dlo.top2Part.endXC,
					dlo.top2Part.endYC, dlo.top2Part.startXC,
					dlo.top2Part.startYC);

			grid.centerXe = this.intersectX(dlo.top3Part.startXC,
					grid.centerYs, dlo.top3Part.endXC, grid.centerYe,
					dlo.top2Part.endXC, dlo.top2Part.endYC,
					dlo.top2Part.startXC, dlo.top2Part.startYC);
		} else {
			grid.x4al = grid.x4 = arcX.getXusingY(0, grid.y1, 500, grid.y4,
					dlo.top1Part.radius1, dlo.top1Part.x1, dlo.top1Part.y1,
					true);

			grid.x3cl = grid.x3 = arcX.getXusingY(0, grid.y2, 500, grid.y3,
					dlo.top1Part.radius1, dlo.top1Part.x1, dlo.top1Part.y1,
					true);

			grid.centerXe = arcX.getXusingY(0, grid.centerYs, 500,
					grid.centerYe, dlo.top1Part.radius1, dlo.top1Part.x1,
					dlo.top1Part.y1, true);

		}

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;

		grid.lengthM = (new BigDecimal(grid.length).divide(
				myFrame2.metricscale, 20, BigDecimal.ROUND_UP)).intValue();
		grid.lengthI = (new BigDecimal(grid.length).divide(
				myFrame2.imperialscale, 20, BigDecimal.ROUND_UP)).intValue();

		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;
		this.doGridPolygon(grid);
		grid.myParent = dlo;

		grid.rowCol = count;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y4a = grid.y4b = grid.y4al;
		grid.y3a = grid.y3a = grid.y3b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);
		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);
	}

	public void doBotPerimeterH(final DLO dlo, final double myThick,
			final int count) {

		bot1PartPerimeter(dlo, myThick, count);

		if (dlo.noSidesBot >= 2) {
			bot2PartPerimeter(dlo, myThick, count);
		}

		if (dlo.noSidesBot == 3) {

			bot3PartPerimeter(dlo, myThick, count);

		}
	}

	public void bot1PartPerimeter(final DLO dlo, final double myThick,
			final int count) {

		EllipseLineIntersections arcX = new EllipseLineIntersections();
		Profiles grid = new Profiles();

		grid.myFrame2 = myFrame2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		grid.partForm = dlo.bot1Part.partForm;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.thickness = myThick;
		grid.partDimB = myThick;
		final double slope = (dlo.bot1Part.endYC - dlo.bot1Part.startYC)
				/ (dlo.bot1Part.endXC - dlo.bot1Part.startXC);

		final double halfThick = myThick / 2;

		double theta = 0;

		double py2 = 0;

		double pyc = 0;

		double py1 = 0;

		// if(slope ==0) {
		theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		py1 = dlo.perimeterH * myScale.doubleValue();

		pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		py2 = dlo.perimeterH * myScale.doubleValue() + myThick;

		Profiles limitL = new Profiles();

		Profiles limitEnd = new Profiles();

		if (!dlo.bot3.posInUse && !dlo.bot2.posInUse && dlo.left.posInUse) {
			limitL = dlo.leftPart;
		}
		if (!dlo.bot3.posInUse && !dlo.bot2.posInUse && !dlo.left.posInUse) {
			limitL = dlo.top1Part;
		} else if (!dlo.bot3.posInUse && dlo.bot2.posInUse) {
			limitL = dlo.bot2Part;
		} else if (!dlo.left.posInUse && !dlo.bot2.posInUse
				&& !dlo.bot3.posInUse) {
			limitL = dlo.top1Part;
		} else if (dlo.bot3.posInUse) {
			limitL = dlo.bot3Part;
		}

		if (dlo.right.posInUse) {
			limitEnd = dlo.rightPart;
		} else if (!dlo.right.posInUse && dlo.top2.posInUse) {
			limitEnd = dlo.top2Part;
		} else if (!dlo.right.posInUse && !dlo.top2.posInUse) {
			limitEnd = dlo.top1Part;
		}

		grid.y1al = grid.y1 = dlo.bot1Part.endYC - py1;

		grid.y4al = grid.y4 = dlo.bot1Part.startYC - py1;

		grid.y2cl = grid.y2 = dlo.bot1Part.endYC - py2;

		grid.y3cl = grid.y3 = dlo.bot1Part.startYC - py2;

		grid.centerYs = dlo.bot1Part.endYC - pyc;
		grid.centerYe = dlo.bot1Part.startYC - pyc;

		if (limitL.partForm == 1) {

			if (theta != 0) {
				py2 = py2 / Math.sin(theta);

				pyc = pyc / Math.sin(theta);

				py1 = py1 / Math.sin(theta);
			}

			grid.y1al = grid.y1 = dlo.bot1Part.endYC - py1;

			grid.y4al = grid.y4 = dlo.bot1Part.startYC - py1;

			grid.y2cl = grid.y2 = dlo.bot1Part.endYC - py2;

			grid.y3cl = grid.y3 = dlo.bot1Part.startYC - py2;

			grid.centerYs = dlo.bot1Part.endYC - pyc;
			grid.centerYe = dlo.bot1Part.startYC - pyc;

			grid.x1al = grid.x1 = this.intersectX(dlo.bot1Part.startXC,
					grid.y4, dlo.bot1Part.endXC, grid.y1, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.x2cl = grid.x2 = this.intersectX(dlo.bot1Part.startXC,
					grid.y3, dlo.bot1Part.endXC, grid.y2, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.centerXs = this.intersectX(dlo.bot1Part.startXC,
					grid.centerYe, dlo.bot1Part.endXC, grid.centerYs,
					limitL.endXC, limitL.endYC, limitL.startXC, limitL.startYC);

			grid.y1al = grid.y1 = this.intersectY(dlo.bot1Part.startXC,
					grid.y4, dlo.bot1Part.endXC, grid.y1, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.y2cl = grid.y2 = this.intersectY(dlo.bot1Part.startXC,
					grid.y3, dlo.bot1Part.endXC, grid.y2, limitL.endXC,
					limitL.endYC, limitL.startXC, limitL.startYC);

			grid.centerYs = this.intersectY(dlo.bot1Part.startXC,
					grid.centerYe, dlo.bot1Part.endXC, grid.centerYs,
					limitL.endXC, limitL.endYC, limitL.startXC, limitL.startYC);

		} else {
			boolean positive = false;
			if (dlo.shapeID == 205 || dlo.shapeID == 305) {
				positive = true;
			}
			if (dlo.noSidesTop == 3 || dlo.noSidesTop == 1
					&& dlo.noSidesLeft == 0 && dlo.noSidesRight == 0) {
				positive = false;
			}
			grid.x1al = grid.x1 = arcX.getXusingY(0, grid.y1, 500, grid.y4,
					limitL.radius1A, limitL.x1, limitL.y1, positive);

			grid.x2cl = grid.x2 = arcX.getXusingY(0, grid.y2, 500, grid.y3,
					limitL.radius1A, limitL.x1, limitL.y1, positive);

			grid.centerXs = arcX.getXusingY(0, grid.centerYs, 500,
					grid.centerYe, limitL.radius1A, limitL.x1, limitL.y1,
					positive);

		}

		if (limitEnd.partForm == 1) {
			grid.x4al = grid.x4 = this.intersectX(dlo.bot1Part.startXC,
					grid.y4, dlo.bot1Part.endXC, grid.y1, limitEnd.endXC,
					limitEnd.endYC, limitEnd.startXC, limitEnd.startYC);

			grid.x3cl = grid.x3 = this.intersectX(dlo.bot1Part.startXC,
					grid.y3, dlo.bot1Part.endXC, grid.y2, limitEnd.endXC,
					limitEnd.endYC, limitEnd.startXC, limitEnd.startYC);

			grid.centerXe = this.intersectX(dlo.bot1Part.startXC,
					grid.centerYe, dlo.bot1Part.endXC, grid.centerYs,
					limitEnd.endXC, limitEnd.endYC, limitEnd.startXC,
					limitEnd.startYC);

			grid.y4al = grid.y4 = this.intersectY(dlo.bot1Part.startXC,
					grid.y4, dlo.bot1Part.endXC, grid.y1, limitEnd.endXC,
					limitEnd.endYC, limitEnd.startXC, limitEnd.startYC);

			grid.y3cl = grid.y3 = this.intersectY(dlo.bot1Part.startXC,
					grid.y3, dlo.bot1Part.endXC, grid.y2, limitEnd.endXC,
					limitEnd.endYC, limitEnd.startXC, limitEnd.startYC);

			grid.centerYe = this.intersectY(dlo.bot1Part.startXC,
					grid.centerYe, dlo.bot1Part.endXC, grid.centerYs,
					limitEnd.endXC, limitEnd.endYC, limitEnd.startXC,
					limitEnd.startYC);
		} else {
			boolean positive = false;
			if (dlo.shapeID == 205 || dlo.shapeID == 305 || dlo.shapeID == 303
					|| dlo.shapeID == 203) {
				positive = true;
			}
			if (dlo.noSidesTop == 3 || dlo.noSidesTop == 1
					&& dlo.noSidesLeft == 0 && dlo.noSidesRight == 0) {
				positive = true;
			}
			grid.x4al = grid.x4 = arcX.getXusingY(0, grid.y1, 500, grid.y4,
					limitEnd.radius1A, limitEnd.x1, limitEnd.y1, positive);

			grid.x3cl = grid.x3 = arcX.getXusingY(0, grid.y2, 500, grid.y3,
					limitEnd.radius1A, limitEnd.x1, limitEnd.y1, positive);

			grid.centerXe = arcX.getXusingY(0, grid.centerYs, 500,
					grid.centerYe, limitEnd.radius1A, limitEnd.x1, limitEnd.y1,
					positive);

		}

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = count;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y4a = grid.y4b = grid.y4al;
		grid.y3a = grid.y3a = grid.y3b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);
		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);

		arcX = null;

	}

	public void bot2PartPerimeter(final DLO dlo, final double myThick,
			final int count) {

		double slope;
		double halfThick;
		double theta;
		double py2;
		double pyc;
		double py1;

		Profiles grid = new Profiles();
		grid.myFrame2 = myFrame2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		grid.partForm = dlo.bot2Part.partForm;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.startPos = grid.endPos = 1;
		grid.thickness = myThick;
		grid.partDimB = myThick;
		slope = (dlo.bot2Part.endYC - dlo.bot2Part.startYC)
				/ (dlo.bot2Part.endXC - dlo.bot2Part.startXC);

		halfThick = myThick / 2;

		theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		py1 = dlo.perimeterH * myScale.doubleValue();

		pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		py2 = dlo.perimeterH * myScale.doubleValue() + myThick;

		if (theta != 0) {
			py2 = py2 / Math.sin(theta);

			pyc = pyc / Math.sin(theta);

			py1 = py1 / Math.sin(theta);
		}

		// if(slope==0) {

		grid.y1al = grid.y1 = dlo.bot2Part.endYC - py1;

		grid.y4al = grid.y4 = dlo.bot2Part.startYC - py1;

		grid.y2cl = grid.y2 = dlo.bot2Part.endYC - py2;

		grid.y3cl = grid.y3 = dlo.bot2Part.startYC - py2;

		grid.centerYs = dlo.bot2Part.endYC - pyc;
		grid.centerYe = dlo.bot2Part.startYC - pyc;

		Profiles limitL = new Profiles();

		Profiles limitEnd = new Profiles();

		if (dlo.left.posInUse) {
			limitL = dlo.leftPart;
		} else if (!dlo.left.posInUse) {
			limitL = dlo.top1Part;
		}

		if (dlo.bot3.posInUse) {
			limitEnd = dlo.bot3Part;
		} else if (!dlo.bot3.posInUse) {
			limitEnd = dlo.bot1Part;
		}

		grid.x1al = grid.x1 = this.intersectX(dlo.bot2Part.startXC, grid.y4,
				dlo.bot2Part.endXC, grid.y1, limitL.endXC, limitL.endYC,
				limitL.startXC, limitL.startYC);

		grid.x2cl = grid.x2 = this.intersectX(dlo.bot2Part.startXC, grid.y3,
				dlo.bot2Part.endXC, grid.y2, limitL.endXC, limitL.endYC,
				limitL.startXC, limitL.startYC);

		grid.centerXs = this.intersectX(dlo.bot2Part.startXC, grid.centerYe,
				dlo.bot2Part.endXC, grid.centerYs, limitL.endXC, limitL.endYC,
				limitL.startXC, limitL.startYC);

		grid.y1al = grid.y1 = this.intersectY(dlo.bot2Part.startXC, grid.y4,
				dlo.bot2Part.endXC, grid.y1, limitL.endXC, limitL.endYC,
				limitL.startXC, limitL.startYC);

		grid.y2cl = grid.y2 = this.intersectY(dlo.bot2Part.startXC, grid.y3,
				dlo.bot2Part.endXC, grid.y2, limitL.endXC, limitL.endYC,
				limitL.startXC, limitL.startYC);

		grid.centerYs = this.intersectY(dlo.bot2Part.startXC, grid.centerYe,
				dlo.bot2Part.endXC, grid.centerYs, limitL.endXC, limitL.endYC,
				limitL.startXC, limitL.startYC);

		grid.x4al = grid.x4 = this.intersectX(dlo.bot2Part.startXC, grid.y4,
				dlo.bot2Part.endXC, grid.y1, limitEnd.endXC, limitEnd.endYC,
				limitEnd.startXC, limitEnd.startYC);

		grid.x3cl = grid.x3 = this.intersectX(dlo.bot2Part.startXC, grid.y3,
				dlo.bot2Part.endXC, grid.y2, limitEnd.endXC, limitEnd.endYC,
				limitEnd.startXC, limitEnd.startYC);

		grid.centerXe = this.intersectX(dlo.bot2Part.startXC, grid.centerYe,
				dlo.bot2Part.endXC, grid.centerYs, limitEnd.endXC,
				limitEnd.endYC, limitEnd.startXC, limitEnd.startYC);

		grid.y4al = grid.y4 = this.intersectY(dlo.bot2Part.startXC, grid.y4,
				dlo.bot2Part.endXC, grid.y1, limitEnd.endXC, limitEnd.endYC,
				limitEnd.startXC, limitEnd.startYC);

		grid.y3cl = grid.y3 = this.intersectY(dlo.bot2Part.startXC, grid.y3,
				dlo.bot2Part.endXC, grid.y2, limitEnd.endXC, limitEnd.endYC,
				limitEnd.startXC, limitEnd.startYC);

		grid.centerYe = this.intersectY(dlo.bot2Part.startXC, grid.centerYe,
				dlo.bot2Part.endXC, grid.centerYs, limitEnd.endXC,
				limitEnd.endYC, limitEnd.startXC, limitEnd.startYC);

		// if(((DLO) dlo).noSidesBot==2) {
		// grid.x4al =
		// grid.x4 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		// grid.x3cl =
		// grid.x3 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		// grid.centerXe = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.endX,
		// grid.centerYs,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		//
		//
		// }

		// }else

		// if (slope !=0){ // no sides always > 2 if part2 slope !=
		// 0
		// grid.y1al =
		// grid.y1 = ((DLO) dlo).bot2Part.endY-py1;
		//
		//
		// grid.y4al =
		// grid.y4 =((DLO) dlo).bot2Part.startY-py1;
		//
		// grid.y2cl =
		// grid.y2 = ((DLO) dlo).bot2Part.endY-py2;
		//
		// grid.y3cl =
		// grid.y3 =((DLO) dlo).bot2Part.startY-py2;
		//
		// grid.centerYs =((DLO) dlo).bot2Part.endY-pyc;
		// grid.centerYe = ((DLO) dlo).bot2Part.startY-pyc;
		//
		// grid.x1al =
		// grid.x1 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).leftPart.endX,
		// ((DLO) dlo).leftPart.endY,
		// ((DLO) dlo).leftPart.startX,
		// ((DLO) dlo).leftPart.startY) ;
		//
		// grid.x2cl =
		// grid.x2 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).leftPart.endX,
		// ((DLO) dlo).leftPart.endY,
		// ((DLO) dlo).leftPart.startX,
		// ((DLO) dlo).leftPart.startY) ;
		//
		// grid.centerXs = this.intersectX(
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.startY,
		// grid.centerYs,
		// ((DLO) dlo).bot2Part.endY,
		// ((DLO) dlo).leftPart.endX,
		// ((DLO) dlo).leftPart.endY,
		// ((DLO) dlo).leftPart.startX,
		// ((DLO) dlo).leftPart.startY) ;
		//
		// grid.y1al =
		// grid.y1 = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).leftPart.endX,
		// ((DLO) dlo).leftPart.endY,
		// ((DLO) dlo).leftPart.startX,
		// ((DLO) dlo).leftPart.startY) ;
		//
		// grid.y2cl =
		// grid.y2 = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).leftPart.endX,
		// ((DLO) dlo).leftPart.endY,
		// ((DLO) dlo).leftPart.startX,
		// ((DLO) dlo).leftPart.startY) ;
		//
		// grid.centerYs = this.intersectY(
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.startY,
		// grid.centerYs,
		// ((DLO) dlo).bot2Part.endY,
		// ((DLO) dlo).leftPart.endX,
		// ((DLO) dlo).leftPart.endY,
		// ((DLO) dlo).leftPart.startX,
		// ((DLO) dlo).leftPart.startY) ;
		//
		//
		//
		// if(((DLO) dlo).noSidesBot==2) {
		//
		// grid.x4al =
		// grid.x4 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		//
		//
		// grid.x3cl =
		// grid.x3 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		// grid.centerXe = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.endX,
		// grid.centerYs,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		// grid.y4al =
		// grid.y4 = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		//
		//
		// grid.y3cl =
		// grid.y3 = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		// grid.centerYe = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.endX,
		// grid.centerYs,
		// ((DLO) dlo).bot1Part.endX,
		// ((DLO) dlo).bot1Part.endY,
		// ((DLO) dlo).bot1Part.startX,
		// ((DLO) dlo).bot1Part.startY) ;
		//
		//
		// }else if(((DLO) dlo).noSidesBot==3) {
		//
		// grid.x4al =
		// grid.x4 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).bot3Part.endX,
		// ((DLO) dlo).bot3Part.endY,
		// ((DLO) dlo).bot3Part.startX,
		// ((DLO) dlo).bot3Part.startY) ;
		//
		//
		//
		// grid.x3cl =
		// grid.x3 = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).bot3Part.endX,
		// ((DLO) dlo).bot3Part.endY,
		// ((DLO) dlo).bot3Part.startX,
		// ((DLO) dlo).bot3Part.startY) ;
		//
		// grid.centerXe = this.intersectX(
		// ((DLO) dlo).bot2Part.startX,
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.endX,
		// grid.centerYs,
		// ((DLO) dlo).bot3Part.endX,
		// ((DLO) dlo).bot3Part.endY,
		// ((DLO) dlo).bot3Part.startX,
		// ((DLO) dlo).bot3Part.startY) ;
		//
		// grid.y4al =
		// grid.y4 = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y4,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y1,
		// ((DLO) dlo).bot3Part.endX,
		// ((DLO) dlo).bot3Part.endY,
		// ((DLO) dlo).bot3Part.startX,
		// ((DLO) dlo).bot3Part.startY) ;
		//
		//
		//
		// grid.y3cl =
		// grid.y3 = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.y3,
		// ((DLO) dlo).bot2Part.endX,
		// grid.y2,
		// ((DLO) dlo).bot3Part.endX,
		// ((DLO) dlo).bot3Part.endY,
		// ((DLO) dlo).bot3Part.startX,
		// ((DLO) dlo).bot3Part.startY) ;
		//
		// grid.centerYe = this.intersectY(
		// ((DLO) dlo).bot2Part.startX,
		// grid.centerYe,
		// ((DLO) dlo).bot2Part.endX,
		// grid.centerYs,
		// ((DLO) dlo).bot3Part.endX,
		// ((DLO) dlo).bot3Part.endY,
		// ((DLO) dlo).bot3Part.startX,
		// ((DLO) dlo).bot3Part.startY) ;
		//
		//
		// }
		//
		//
		//
		// }

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;

		grid.myParent = dlo;

		grid.rowCol = count;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y4a = grid.y4b = grid.y4al;
		grid.y3a = grid.y3a = grid.y3b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);
		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);

	}

	public void bot3PartPerimeter(final DLO dlo, final double myThick,
			final int count) {

		Profiles grid = new Profiles();
		grid.myFrame2 = myFrame2;
		grid.gridID = dlo.gridID;
		grid.gridTypeID = dlo.gridType;

		grid.partForm = dlo.bot3Part.partForm;
		grid.orientation = 2;
		grid.whichPos = whichPos;
		grid.startPos = grid.endPos = 1;
		grid.thickness = myThick;
		grid.partDimB = myThick;
		double slope;
		double halfThick;
		double theta;
		double py2;
		double pyc;
		double py1;
		slope = (dlo.bot3Part.endYC - dlo.bot3Part.startYC)
				/ (dlo.bot3Part.endXC - dlo.bot3Part.startXC);

		halfThick = myThick / 2;

		theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		py1 = dlo.perimeterH * myScale.doubleValue();

		pyc = dlo.perimeterH * myScale.doubleValue() + halfThick;

		py2 = dlo.perimeterH * myScale.doubleValue() + myThick;

		if (theta != 0) {
			py2 = py2 / Math.sin(theta);

			pyc = pyc / Math.sin(theta);

			py1 = py1 / Math.sin(theta);
		}

		grid.rowCol = 1;

		grid.y1al = grid.y1 = dlo.bot3Part.endYC - py1;

		grid.y4al = grid.y4 = dlo.bot3Part.startYC - py1;

		grid.y2cl = grid.y2 = dlo.bot3Part.endYC - py2;

		grid.y3cl = grid.y3 = dlo.bot3Part.startYC - py2;

		grid.centerYs = dlo.bot3Part.endYC - pyc;
		grid.centerYe = dlo.bot3Part.startYC - pyc;

		grid.x1al = grid.x1 = this.intersectX(dlo.bot3Part.startXC, grid.y4,
				dlo.bot3Part.endXC, grid.y1, dlo.bot2Part.endXC,
				dlo.bot2Part.endYC, dlo.bot2Part.startXC, dlo.bot2Part.startYC);

		grid.x2cl = grid.x2 = this.intersectX(dlo.bot3Part.startXC, grid.y3,
				dlo.bot3Part.endXC, grid.y2, dlo.bot2Part.endXC,
				dlo.bot2Part.endYC, dlo.bot2Part.startXC, dlo.bot2Part.startYC);

		grid.centerXs = this.intersectX(dlo.bot3Part.startXC, grid.centerYe,
				dlo.bot3Part.endXC, grid.centerYs, dlo.bot2Part.endXC,
				dlo.bot2Part.endYC, dlo.bot2Part.startXC, dlo.bot2Part.startYC);

		grid.x4al = grid.x4 = this.intersectX(dlo.bot3Part.startXC, grid.y4,
				dlo.bot3Part.endXC, grid.y1, dlo.bot1Part.endXC,
				dlo.bot1Part.endYC, dlo.bot1Part.startXC, dlo.bot1Part.startYC);

		grid.x3cl = grid.x3 = this.intersectX(dlo.bot3Part.startXC, grid.y3,
				dlo.bot3Part.endXC, grid.y2, dlo.bot1Part.endXC,
				dlo.bot1Part.endYC, dlo.bot1Part.startXC, dlo.bot1Part.startYC);

		grid.centerXe = this.intersectX(dlo.bot3Part.startXC, grid.centerYe,
				dlo.bot3Part.endXC, grid.centerYs, dlo.bot1Part.endXC,
				dlo.bot1Part.endYC, dlo.bot1Part.startXC, dlo.bot1Part.startYC);

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(dlo, grid);
		grid.thickness = myThick;
		this.doGridPolygon(grid);
		grid.myParent = dlo;

		grid.rowCol = count;
		grid.isNew = true;

		grid.myFrame2 = myFrame2;

		grid.startPos = 1;
		grid.endPos = dlo.xCols;
		grid.x1a = grid.x1al;
		grid.x2a = grid.x2cl;
		grid.x4a = grid.x4al;
		grid.x3a = grid.x3cl;

		grid.y1a = grid.y1a = grid.y1b = grid.y1al;
		grid.y2a = grid.y2a = grid.y2b = grid.y2cl;
		grid.y4a = grid.y4a = grid.y4b = grid.y4al;
		grid.y3a = grid.y3a = grid.y3b = grid.y3cl;
		grid.ycs = grid.centerYs;
		grid.yce = grid.centerYe;

		grid.setColor(255, 255, 255, 255, 255, 255, 255, 255, 255);

		grid.startIn = false;

		grid.endIn = false;

		grid.posCondition = this.getPosCondition(grid.startIn, grid.endIn);
		final Polygon m = new Polygon();

		m.addPoint((int) grid.x1a, (int) grid.y1a);
		m.addPoint((int) grid.x2a, (int) grid.y2a);
		m.addPoint((int) grid.x3a, (int) grid.y3a);
		m.addPoint((int) grid.x4a, (int) grid.y4a);
		m.addPoint((int) grid.x1a, (int) grid.y1a);
		grid.gp.reset();
		grid.poly.reset();
		grid.gp.append(m, false);
		grid.poly = m;

		grid.opDone = false;

		dlo.gridPartsH.add(grid);

		dlo.gridMasksH.add(grid);

		dlo.bOpeningObject.mullionsH.add(grid);
	}

	public void doBotPerimeterHOLD(final Object dlo, final double myThick,
			final int count) {

		Profiles grid = new Profiles();
		grid.myFrame2 = myFrame2;
		grid.gridID = ((DLO) dlo).gridID;
		grid.gridTypeID = ((DLO) dlo).gridType;

		grid.partForm = 1;
		grid.orientation = 2;
		grid.whichPos = whichPos;

		// m = (y2 - y1) / (x2 - x1)
		double slope = (((DLO) dlo).bot1Part.endYC - ((DLO) dlo).bot1Part.startYC)
				/ (((DLO) dlo).bot1Part.endXC - ((DLO) dlo).bot1Part.startXC);

		double halfThick = myThick / 2;

		double theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

		double py1 = ((DLO) dlo).perimeterH * myScale.doubleValue();

		double pyc = ((DLO) dlo).perimeterH * myScale.doubleValue() + halfThick;

		double py2 = ((DLO) dlo).perimeterH * myScale.doubleValue() + myThick;

		if (theta != 0) {
			py2 = py2 / Math.sin(theta);

			pyc = pyc / Math.sin(theta);

			py1 = py1 / Math.sin(theta);
		}

		grid.rowCol = 2;
		grid.y1al = grid.y1 = ((DLO) dlo).bot1Part.endYC - py1;

		grid.y4al = grid.y4 = ((DLO) dlo).bot1Part.startYC - py1;

		grid.y2cl = grid.y2 = ((DLO) dlo).bot1Part.endYC - py2;

		grid.y3cl = grid.y3 = ((DLO) dlo).bot1Part.startYC - py2;

		grid.centerYs = ((DLO) dlo).bot1Part.endYC - pyc;
		grid.centerYe = ((DLO) dlo).bot1Part.startYC - pyc;

		grid.x1al = grid.x1 = grid.x2cl = grid.x2 = grid.centerXs = ((DLO) dlo).bot1Part.endXC;
		grid.x4al = grid.x4 = grid.x3cl = grid.x3 = grid.centerXe = ((DLO) dlo).bot1Part.startXC;
		;

		grid.exists = 1;
		grid.length = grid.centerXe - grid.centerXs;
		grid.cOrM = 7;
		grid = doGridsLevels(((DLO) dlo), grid);
		grid.thickness = myThick;
		this.doGridPolygon(grid);
		grid.myParent = (DLO) dlo;

		grid.rowCol = count;
		grid.isNew = true;
		((DLO) dlo).gridPartsH.add(grid);
		grid.myFrame2 = myFrame2;
		((DLO) dlo).bOpeningObject.mullionsH.add(grid);

		if (((DLO) dlo).noSidesBot >= 2) {

			slope = (((DLO) dlo).bot2Part.endYC - ((DLO) dlo).bot2Part.startYC)
					/ (((DLO) dlo).bot2Part.endXC - ((DLO) dlo).bot2Part.startXC);

			halfThick = myThick / 2;

			theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

			py2 = ((DLO) dlo).perimeterH * myScale.doubleValue();

			pyc = ((DLO) dlo).perimeterH * myScale.doubleValue() + halfThick;

			py1 = ((DLO) dlo).perimeterH * myScale.doubleValue() + myThick;

			if (theta != 0) {
				py2 = py2 / Math.sin(theta);

				pyc = pyc / Math.sin(theta);

				py1 = py1 / Math.sin(theta);
			}

			grid.rowCol = 2;
			grid.y1al = grid.y1 = ((DLO) dlo).bot2Part.endYC - py1;

			grid.y4al = grid.y4 = ((DLO) dlo).bot2Part.startYC - py1;

			grid.y2cl = grid.y2 = ((DLO) dlo).bot2Part.endYC - py2;

			grid.y3cl = grid.y3 = ((DLO) dlo).bot2Part.startYC - py2;

			grid.centerYs = ((DLO) dlo).bot2Part.endYC - pyc;
			grid.centerYe = ((DLO) dlo).bot2Part.startYC - pyc;

			grid.x1al = grid.x1 = grid.x2cl = grid.x2 = grid.centerXs = ((DLO) dlo).bot2Part.endXC;
			grid.x4al = grid.x4 = grid.x3cl = grid.x3 = grid.centerXe = ((DLO) dlo).bot2Part.startXC;
			;

			grid.exists = 1;
			grid.length = grid.centerXe - grid.centerXs;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			grid.thickness = myThick;
			this.doGridPolygon(grid);
			grid.myParent = (DLO) dlo;

			grid.rowCol = count;
			grid.isNew = true;
			((DLO) dlo).gridPartsH.add(grid);
			grid.myFrame2 = myFrame2;
			((DLO) dlo).bOpeningObject.mullionsH.add(grid);

		}
		if (((DLO) dlo).noSidesBot == 3) {

			slope = (((DLO) dlo).bot3Part.endYC - ((DLO) dlo).bot3Part.startYC)
					/ (((DLO) dlo).bot3Part.endXC - ((DLO) dlo).bot3Part.startXC);

			halfThick = myThick / 2;

			theta = Math.toRadians(90) - Math.atan(Math.abs(slope));

			py2 = ((DLO) dlo).perimeterH * myScale.doubleValue();

			pyc = ((DLO) dlo).perimeterH * myScale.doubleValue() + halfThick;

			py1 = ((DLO) dlo).perimeterH * myScale.doubleValue() + myThick;

			if (theta != 0) {
				py2 = py2 / Math.sin(theta);

				pyc = pyc / Math.sin(theta);

				py1 = py1 / Math.sin(theta);
			}

			grid.rowCol = 2;

			grid.y1al = grid.y1 = ((DLO) dlo).bot3Part.endYC - py1;

			grid.y4al = grid.y4 = ((DLO) dlo).bot3Part.startYC - py1;

			grid.y2cl = grid.y2 = ((DLO) dlo).bot3Part.endYC - py2;

			grid.y3cl = grid.y3 = ((DLO) dlo).bot3Part.startYC - py2;

			grid.centerYs = ((DLO) dlo).bot3Part.endYC - pyc;
			grid.centerYe = ((DLO) dlo).bot3Part.startYC - pyc;

			grid.x1al = grid.x1 = grid.x2cl = grid.x2 = grid.centerXs = ((DLO) dlo).bot3Part.endXC;
			grid.x4al = grid.x4 = grid.x3cl = grid.x3 = grid.centerXe = ((DLO) dlo).bot3Part.startXC;
			;

			grid.exists = 1;
			grid.length = grid.centerXe - grid.centerXs;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			grid.thickness = myThick;
			this.doGridPolygon(grid);
			grid.myParent = (DLO) dlo;

			grid.rowCol = count;
			grid.isNew = true;
			((DLO) dlo).gridPartsH.add(grid);
			grid.myFrame2 = myFrame2;
			((DLO) dlo).bOpeningObject.mullionsH.add(grid);

		}
	}

	// widthPix

	public void setAnchorsWInSlave(final int pos, Object[] mydlos) {

		double myThick = 0;

		for (Object dlo : mydlos) {

			if (((DLO) dlo).myMasterW != null) {
				if (gridType % 2 != 0) {
					dlo = doSetAnchorsInSlaveDLOWNew(pos, dlo);
				} else {
					dlo = this.doSetAnchorsInSlavePerimeterDLOWNew(pos, dlo);
				}
			}

			DLOs.add(dlo);

		}

	}

	// public DLO doSetAnchorsInSlaveDLOW(final int pos, Object dlo) {
	//
	// double myThick;
	// ((DLO) dlo).anchorsV.clear();
	// ((DLO) dlo).gridPartsV.clear();
	//
	// ((DLO) dlo).bOpeningObject.mullions.clear();
	//
	// ((DLO) dlo).liteW = ((DLO) dlo).myMasterW.liteW;
	//
	// myThick = ((DLO) dlo).gridThick * myScale.doubleValue();
	// Object[] ancW = ((DLO) dlo).myMasterW.anchorsV.toArray();
	//
	// for (Object aw : ancW) {
	//
	// if (Double.parseDouble(aw.toString()) > ((DLO) dlo).startingX
	// && Double.parseDouble(aw.toString()) < ((DLO) dlo).bX2) {
	//
	// ((DLO) dlo).anchorsV.add(Double.parseDouble(aw.toString()));
	//
	// }
	//
	// }
	// // //////////////////////////////////////
	// if (((DLO) dlo).startingX >= ((DLO) dlo).myMasterW.startingX
	// && ((DLO) dlo).bX2 > ((DLO) dlo).myMasterW.bX2) {
	//
	// double lastAnchorPos = 0;
	// ancW = ((DLO) dlo).anchorsV.toArray();
	// final int count = 0;
	// for (final Object aw2 : ancW) {
	// if (count == ancW.length - 1) {
	// lastAnchorPos = Double.parseDouble(aw2.toString());
	// }
	//
	// }
	//
	// double delta = ((DLO) dlo).bX2 - lastAnchorPos;
	// do {
	// if (lastAnchorPos + ((DLO) dlo).liteW < ((DLO) dlo).bX2
	// - ((DLO) dlo).liteW) {
	// if (lastAnchorPos + ((DLO) dlo).liteW + myThick < ((DLO) dlo).startingX
	// + ((DLO) dlo).gridRemovalZoneW
	// * myScale.doubleValue()
	// || lastAnchorPos + ((DLO) dlo).liteW + myThick > ((DLO) dlo).bX2
	// - ((DLO) dlo).gridRemovalZoneW
	// * myScale.doubleValue()) {
	// delta = 0;
	// } else {
	// ((DLO) dlo).anchorsV.add(lastAnchorPos
	// + ((DLO) dlo).liteW + myThick);
	//
	// delta = delta - ((DLO) dlo).liteW;
	// }
	// } else {
	// delta = 0;
	// }
	// } while (delta > 0);
	//
	// }
	// // //////////////////////////////////
	// else if (((DLO) dlo).startingX < ((DLO) dlo).myMasterW.startingX
	// && ((DLO) dlo).bX2 <= ((DLO) dlo).myMasterW.bX2) {
	//
	// double firstPos = 0;
	// ancW = ((DLO) dlo).anchorsV.toArray();
	// final int count = 0;
	// for (final Object aw2 : ancW) {
	// if (count == 0) {
	// firstPos = Double.parseDouble(aw2.toString());
	//
	// }
	//
	// }
	//
	// double delta = firstPos - ((DLO) dlo).startingX;
	//
	// do {
	// if (firstPos - ((DLO) dlo).liteW < ((DLO) dlo).startingX
	// + ((DLO) dlo).liteW) {
	// if (firstPos - ((DLO) dlo).liteW < ((DLO) dlo).startingX
	// + ((DLO) dlo).gridRemovalZoneW
	// * myScale.doubleValue()
	// || firstPos - ((DLO) dlo).liteW > ((DLO) dlo).bX2
	// - ((DLO) dlo).gridRemovalZoneW
	// * myScale.doubleValue()) {
	// delta = 0;
	// } else {
	// ((DLO) dlo).anchorsV.add(firstPos - ((DLO) dlo).liteW);
	//
	// delta = delta - ((DLO) dlo).liteW;
	// }
	// } else {
	// delta = 0;
	// }
	// } while (delta > 0);
	//
	// }
	//
	// // ///////////////////////////////////////////////////
	//
	// ancW = ((DLO) dlo).anchorsV.toArray();
	// ((DLO) dlo).anchorsV.clear();
	// for (final Object aw3 : ancW) {
	//
	// if (Double.parseDouble(aw3.toString()) < ((DLO) dlo).startingX
	// + ((DLO) dlo).gridRemovalZoneW * myScale.doubleValue()
	// || Double.parseDouble(aw3.toString()) > ((DLO) dlo).bX2
	// - ((DLO) dlo).gridRemovalZoneW
	// * myScale.doubleValue()) {
	//
	// } else {
	// ((DLO) dlo).anchorsV.add(aw3);
	// }
	//
	// }
	//
	// ancW = ((DLO) dlo).anchorsV.toArray();
	// int count = 0;
	// for (final Object aw3 : ancW) {
	// count++;
	// Profiles grid = new Profiles();
	// grid.partForm = 1;
	// grid.partDimB = myThick;
	// grid.x1al = grid.x1 = grid.x4al = grid.x4 = Double.parseDouble(aw3
	// .toString()) - myThick / 2;
	// grid.x2cl = grid.x2 = grid.x3cl = grid.x3 = Double.parseDouble(aw3
	// .toString()) + myThick / 2;
	// grid.y1al = grid.y1 = grid.y2cl = grid.y2 = ((DLO) dlo).highestY;
	// grid.y4al = grid.y4 = grid.y3cl = grid.y3 = ((DLO) dlo).lowestY;
	// grid.centerXs = grid.centerXe = Double.parseDouble(aw3.toString());
	// grid.centerYs = ((DLO) dlo).highestY;
	// grid.centerYe = ((DLO) dlo).lowestY;
	// grid.exists = 1;
	// grid.length = grid.centerYe - grid.centerYs;
	// grid.whichPos = pos;
	// grid.thickness = myThick;
	// grid.exists = 1;
	// grid.cOrM = 7;
	// grid = doGridsLevels(((DLO) dlo), grid);
	// final Polygon m = new Polygon();
	//
	// m.addPoint((int) grid.x1al, (int) grid.y1al);
	// m.addPoint((int) grid.x2cl, (int) grid.y2cl);
	// m.addPoint((int) grid.x3cl, (int) grid.y3cl);
	// m.addPoint((int) grid.x4al, (int) grid.y4al);
	// m.addPoint((int) grid.x1al, (int) grid.y1al);
	//
	// grid.gp.append(m, false);
	// grid.poly = m;
	// grid.myParent = (DLO) dlo;
	// grid.rowCol = count;
	// grid.startPos = 1;
	// grid.endPos = ancW.length;
	// grid.isNew = true;
	// grid.myFrame2 = myFrame2;
	// ((DLO) dlo).bOpeningObject.mullions.add(grid);
	//
	// ((DLO) dlo).gridPartsV.add(grid);
	// ((DLO) dlo).noGridsV = ((DLO) dlo).anchorsV.size();
	// if (((DLO) dlo).myParentO.myGlassMid != null) {
	// ((DLO) dlo).myParentO.myGlassMid.noGridsV = ((DLO) dlo).anchorsV
	// .size();
	// }
	// // ((DLO)
	// // dlo).anchorsW[i]
	// // =
	// // anchorW;
	// }
	//
	// return (DLO) dlo;
	// }

	public DLO doSetAnchorsInSlaveDLOWNew(final int pos, Object dlo) {

		double remZone = ((DLO) dlo).gridRemovalZoneW * myScale.doubleValue();

		((DLO) dlo).anchorsV.clear();
		((DLO) dlo).gridPartsV.clear();

		((DLO) dlo).bOpeningObject.mullions.clear();

		((DLO) dlo).liteW = ((DLO) dlo).myMasterW.liteW;

		myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

		Object[] ancW = ((DLO) dlo).myMasterW.anchorsV.toArray();

		Collections.sort(hardVs);

		Object[] hvs = hardVs.toArray();

		for (Object hv : hvs) {
			if (Double.parseDouble(hv.toString()) > ((DLO) dlo).startingX
					&& Double.parseDouble(hv.toString()) < ((DLO) dlo).bX2) {
				((DLO) dlo).anchorsV.add(Double.parseDouble(hv.toString()));
			}
		}

		int count = 0;

		double firstPos = 0;
		double lastPos = 0;

		double delta = 0;

		// First Position

		for (Object aw2 : hvs) {
			if (count == 0) {
				firstPos = Double.parseDouble(aw2.toString()) - myThick / 2;
				break;
			}
			count++;
		}

		addAtBeginingV(dlo, firstPos, ((DLO) dlo).liteW, 1);

		// Last Position

		count = 0;
		for (Object aw2 : hvs) {
			if (count == hvs.length - 1) {
				lastPos = Double.parseDouble(aw2.toString()) + myThick / 2;
				break;
			}
			count++;
		}

		addAtEndV(dlo, lastPos, ((DLO) dlo).liteW, 1);

		// between Position

		addInBetweenV(dlo, hvs, ((DLO) dlo).liteW, 1);

		// ///////////////////////////////////////////////////

		ancW = ((DLO) dlo).anchorsV.toArray();
		((DLO) dlo).anchorsV.clear();
		for (final Object aw3 : ancW) {

			if (Double.parseDouble(aw3.toString()) < ((DLO) dlo).startingX
					+ ((DLO) dlo).gridRemovalZoneW * myScale.doubleValue()
					|| Double.parseDouble(aw3.toString()) > ((DLO) dlo).bX2
							- ((DLO) dlo).gridRemovalZoneW
							* myScale.doubleValue()) {

			} else {
				((DLO) dlo).anchorsV.add(aw3);
			}

		}

		ancW = ((DLO) dlo).anchorsV.toArray();
		count = 0;
		for (final Object aw3 : ancW) {
			count++;
			Profiles grid = new Profiles();
			grid.partForm = 1;
			grid.partDimB = myThick;
			grid.x1al = grid.x1 = grid.x4al = grid.x4 = Double.parseDouble(aw3
					.toString()) - myThick / 2;
			grid.x2cl = grid.x2 = grid.x3cl = grid.x3 = Double.parseDouble(aw3
					.toString()) + myThick / 2;
			grid.orientation = 1;
			double glassToSpacer = 0;
			if (((DLO) dlo).myFrame2.mySeries.getSeriesUom() == 1) {
				glassToSpacer = UOMConvert.getBigDecimalConversion(
						((DLO) dlo).myParentGlass.glassToSpacer,
						myFrame2.metricscale, 1);
			} else {
				glassToSpacer = UOMConvert.getBigDecimalConversion(
						((DLO) dlo).myParentGlass.glassToSpacerImp,
						myFrame2.imperialscale, 1);
			}

			grid.y1al = grid.y1 = grid.y2cl = grid.y2 = grid.centerYs = ((DLO) dlo).myParentGlass.highestY
					+ glassToSpacer;
			grid.y4al = grid.y4 = grid.y3cl = grid.y3 = grid.centerYe = ((DLO) dlo).myParentGlass.lowestY
					- glassToSpacer;

			grid.centerXs = grid.centerXe = Double.parseDouble(aw3.toString());

			grid.exists = 1;
			grid.length = grid.centerYe - grid.centerYs;
			grid.whichPos = pos;
			grid.thickness = myThick;
			grid.exists = 1;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			final Polygon m = new Polygon();

			m.addPoint((int) grid.x1al, (int) grid.y1al);
			m.addPoint((int) grid.x2cl, (int) grid.y2cl);
			m.addPoint((int) grid.x3cl, (int) grid.y3cl);
			m.addPoint((int) grid.x4al, (int) grid.y4al);
			m.addPoint((int) grid.x1al, (int) grid.y1al);

			grid.gp.append(m, false);
			grid.poly = m;
			grid.myParent = (DLO) dlo;
			grid.rowCol = count;
			grid.startPos = 1;
			grid.endPos = ancW.length;
			grid.isNew = true;
			grid.myFrame2 = myFrame2;
			((DLO) dlo).bOpeningObject.mullions.add(grid);

			((DLO) dlo).gridPartsV.add(grid);

			((DLO) dlo).noGridsV = ((DLO) dlo).anchorsV.size();

			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsV = ((DLO) dlo).anchorsV
						.size();
			}
		}

		return (DLO) dlo;
	}

	public DLO doSetAnchorsInSlavePerimeterDLOWNew(final int pos, Object dlo) {

		double remZone = 0;

		((DLO) dlo).anchorsV.clear();
		((DLO) dlo).gridPartsV.clear();

		((DLO) dlo).bOpeningObject.mullions.clear();

		myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

		Collections.sort(hardVs);

		Object[] hvs = hardVs.toArray();

		((DLO) dlo).anchorsV.addAll(hardVs);

		Object[] aV = ((DLO) dlo).anchorsV.toArray();

		int count = 0;
		for (Object av : aV) {
			count++;

			if (count == 1 && ((DLO) dlo).noSidesLeft == 1) {
				leftPartPerimeter(((DLO) dlo), myThick);
				((DLO) dlo).noGridsV = ((DLO) dlo).noGridsV + 1;
				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.noGridsV = ((DLO) dlo).noGridsV + 1;
				}

			}

			if (count == 2 && ((DLO) dlo).noSidesRight == 1) {

				rightPartPerimeter(((DLO) dlo), myThick);
				((DLO) dlo).noGridsV = ((DLO) dlo).noGridsV + 1;
				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.noGridsV = ((DLO) dlo).noGridsV + 1;
				}

			}

			((DLO) dlo).liteW = ((DLO) dlo).perimeterV;
		}

		return (DLO) dlo;
	}

	public void addInBetweenV(Object dlo, Object[] positions, double liteSize,
			int orientation) {

		int count;
		count = 0;

		double initPos = 0;

		double myEnd = 0;

		for (Object aw2 : positions) {
			initPos = Double.parseDouble(aw2.toString()) + myThick;

			for (Object aw3 : positions) {
				if (Double.parseDouble(aw3.toString()) > initPos) {
					myEnd = Double.parseDouble(aw3.toString()) - myThick / 2;
					int ngrids = 0;
					do {
						if (myEnd - initPos > 2 * liteSize) {
							ngrids = (int) ((myEnd - initPos) / liteSize);

							if (ngrids >= 1) {
								if (orientation == 1) {
									((DLO) dlo).anchorsV.add(initPos + liteSize
											+ myThick / 2);
								} else {
									((DLO) dlo).anchorsH.add(initPos + liteSize
											+ myThick / 2);
								}

								initPos = initPos + liteSize + myThick;
								ngrids = (int) ((myEnd - initPos) / liteSize);

							}
						} else {
							ngrids = 0;
						}

					} while (ngrids > 0);

					break;
				}
			}

		}

	}

	public void addAtEndV(Object dlo, double lastPos, double liteSize,
			int orientation) {

		double myEnd = ((DLO) dlo).bX2;
		if (orientation > 1) {
			myEnd = ((DLO) dlo).lowestY;
		}

		int ngrids = 0;
		do {

			if ((myEnd - lastPos) > 2 * liteSize) {

				ngrids = (int) ((myEnd - lastPos) / liteSize);

				if (ngrids >= 1) {
					if (orientation == 1) {
						((DLO) dlo).anchorsV.add(lastPos + liteSize + myThick
								/ 2);
					} else {
						((DLO) dlo).anchorsH.add(lastPos + liteSize + myThick
								/ 2);
					}

					myEnd = myEnd - liteSize - myThick;

					ngrids = (int) ((myEnd - lastPos) / liteSize);

				}
			} else {
				ngrids = 0;
			}

		} while (ngrids > 0);
	}

	public void addAtBeginingV(Object dlo, double firstPos, double liteSize,
			int orientation) {

		double myBegining = ((DLO) dlo).startingX;
		if (orientation > 1) {
			myBegining = ((DLO) dlo).highestY;
		}

		int ngrids = 0;
		do {
			if (firstPos - myBegining > 2 * liteSize) {
				ngrids = (int) ((firstPos - myBegining) / liteSize);

				if (ngrids >= 1) {
					if (orientation == 1) {
						((DLO) dlo).anchorsV.add(myBegining + liteSize
								+ myThick / 2);
					} else {
						((DLO) dlo).anchorsH.add(myBegining + liteSize
								+ myThick / 2);
					}

					myBegining = myBegining + liteSize + myThick;

					ngrids = (int) ((firstPos - myBegining) / liteSize);

				}
			} else {
				ngrids = 0;
			}

		} while (ngrids > 0);
	}

	public void setAnchorsHInSlave(final int pos, Object[] mydlos) {

		double myThick = 0;

		for (Object dlo : mydlos) {
			if (((DLO) dlo).myMasterH != null) {

				// dlo = doSetAnchorsInSlaveDLOH(pos, dlo);
				dlo = doSetAnchorsInSlaveDLOHNew(pos, dlo);

				if (gridType % 2 != 0) {
					dlo = doSetAnchorsInSlaveDLOHNew(pos, dlo);
				} else {
					dlo = this.doSetAnchorsInSlaveDLOPerimeterHNew((DLO) dlo);
				}

			}

			DLOs.add(dlo);

		}

	}

	// public DLO doSetAnchorsInSlaveDLOH(final int pos, final Object dlo) {
	//
	// double myThick;
	// ((DLO) dlo).anchorsH.clear();
	// ((DLO) dlo).gridPartsH.clear();
	// ((DLO) dlo).bOpeningObject.mullionsH.clear();
	// ((DLO) dlo).liteH = ((DLO) dlo).myMasterH.liteH;
	//
	// myThick = ((DLO) dlo).gridThick * myScale.doubleValue();
	// Object[] ancH = ((DLO) dlo).myMasterH.anchorsH.toArray();
	//
	// for (final Object aw : ancH) {
	// if (Double.parseDouble(aw.toString()) > ((DLO) dlo).highestY
	// && Double.parseDouble(aw.toString()) < ((DLO) dlo).lowestY) {
	// ((DLO) dlo).anchorsH.add(Double.parseDouble(aw.toString()));
	// }
	//
	// }
	// // //////////////////////////////////////
	// if (((DLO) dlo).myMasterH.shapeID == 1
	// && ((DLO) dlo).highestY >= ((DLO) dlo).myMasterH.highestY
	// && ((DLO) dlo).lowestY > ((DLO) dlo).myMasterH.lowestY
	// || ((DLO) dlo).myMasterH.shapeID != 1
	// && ((DLO) dlo).highestY >= ((DLO) dlo).myMasterH.highestY
	// - ((DLO) dlo).myMasterH.myParent.top1Part.partDimB
	// && ((DLO) dlo).lowestY > ((DLO) dlo).myMasterH.lowestY
	// + ((DLO) dlo).myMasterH.myParent.top1Part.partDimB) {
	//
	// double lastAnchorPos = 0;
	// ancH = ((DLO) dlo).anchorsH.toArray();
	// final int count = 0;
	// for (final Object aw2 : ancH) {
	// if (count == ancH.length - 1) {
	// lastAnchorPos = Double.parseDouble(aw2.toString());
	// }
	//
	// }
	//
	// double delta = ((DLO) dlo).bX2 - lastAnchorPos;
	// do {
	// if (lastAnchorPos + ((DLO) dlo).liteH < ((DLO) dlo).bX2
	// - ((DLO) dlo).liteH) {
	// if (lastAnchorPos + ((DLO) dlo).liteH + myThick > ((DLO) dlo).highestY
	// + ((DLO) dlo).gridRemovalZoneH
	// * myScale.doubleValue()
	// && lastAnchorPos + ((DLO) dlo).liteH + myThick < ((DLO) dlo).lowestY
	// - ((DLO) dlo).gridRemovalZoneH
	// * myScale.doubleValue()) {
	// ((DLO) dlo).anchorsH.add(lastAnchorPos
	// + ((DLO) dlo).liteH + myThick);
	//
	// delta = delta - ((DLO) dlo).liteH;
	//
	// } else {
	// delta = 0;
	// }
	// } else {
	// delta = 0;
	// }
	// } while (delta > 0);
	//
	// }
	// // //////////////////////////////////
	// else if (((DLO) dlo).myMasterH.shapeID == 1
	// && ((DLO) dlo).highestY < ((DLO) dlo).myMasterH.highestY
	// && ((DLO) dlo).lowestY <= ((DLO) dlo).myMasterH.lowestY
	// || ((DLO) dlo).myMasterH.shapeID != 1
	// && ((DLO) dlo).highestY < ((DLO) dlo).myMasterH.highestY
	// - ((DLO) dlo).myMasterH.myParent.top1Part.partDimB
	// && ((DLO) dlo).lowestY <= ((DLO) dlo).myMasterH.lowestY
	// + ((DLO) dlo).myMasterH.myParent.top1Part.partDimB) {
	//
	// double firstPos = 0;
	// ancH = ((DLO) dlo).anchorsH.toArray();
	// final int count = 0;
	// for (final Object aw2 : ancH) {
	// if (count == 0) {
	// firstPos = Double.parseDouble(aw2.toString());
	//
	// }
	//
	// }
	//
	// double delta = firstPos - ((DLO) dlo).startingX;
	//
	// do {
	// if (firstPos - ((DLO) dlo).liteH < ((DLO) dlo).startingX
	// + ((DLO) dlo).liteH) {
	//
	// if (firstPos - ((DLO) dlo).liteH > ((DLO) dlo).highestY
	// + ((DLO) dlo).gridRemovalZoneH
	// * myScale.doubleValue()
	// && firstPos - ((DLO) dlo).liteH < ((DLO) dlo).lowestY
	// - ((DLO) dlo).gridRemovalZoneH
	// * myScale.doubleValue()) {
	// ((DLO) dlo).anchorsH.add(firstPos - ((DLO) dlo).liteH);
	//
	// delta = delta - ((DLO) dlo).liteH;
	// } else {
	// delta = 0;
	// }
	// } else {
	// delta = 0;
	// }
	// } while (delta > 0);
	//
	// }
	//
	// // ///////////////////////////////////////////////////
	//
	// ancH = ((DLO) dlo).anchorsH.toArray();
	//
	// ((DLO) dlo).anchorsH.clear();
	// for (final Object aw3 : ancH) {
	//
	// if (Double.parseDouble(aw3.toString()) < ((DLO) dlo).highestY
	// + ((DLO) dlo).gridRemovalZoneH * myScale.doubleValue()
	// || Double.parseDouble(aw3.toString()) > ((DLO) dlo).lowestY
	// - ((DLO) dlo).gridRemovalZoneW
	// * myScale.doubleValue()) {
	// // do not
	// // add
	// } else {
	// ((DLO) dlo).anchorsH.add(aw3);
	// }
	//
	// }
	//
	// ancH = ((DLO) dlo).anchorsH.toArray();
	// int count = 0;
	// for (final Object aw3 : ancH) {
	// count++;
	// Profiles grid = new Profiles();
	// grid.partForm = 1;
	// grid.orientation = 2;
	// grid.partDimB = myThick;
	// grid.y1al = grid.y1 = grid.y4al = grid.y4 = Double.parseDouble(aw3
	// .toString()) + myThick / 2;
	// grid.y2cl = grid.y2 = grid.y3cl = grid.y3 = Double.parseDouble(aw3
	// .toString()) - myThick / 2;
	// grid.x1al = grid.x1 = grid.x2cl = grid.x2 = ((DLO) dlo).startingX;
	// grid.x4al = grid.x4 = grid.x3cl = grid.x3 = ((DLO) dlo).bX2;
	// grid.centerXs = ((DLO) dlo).startingX;
	// grid.centerXe = ((DLO) dlo).bX2;
	//
	// grid.centerYs = Double.parseDouble(aw3.toString());
	// grid.centerYe = Double.parseDouble(aw3.toString());
	// grid.length = grid.centerXe - grid.centerXs;
	//
	// grid.whichPos = pos;
	// grid.thickness = myThick;
	//
	// grid.startPos = 1;
	// grid.endPos = ancH.length;
	//
	// grid.exists = 1;
	// grid.cOrM = 7;
	// grid = doGridsLevels(((DLO) dlo), grid);
	// final Polygon m = new Polygon();
	//
	// m.addPoint((int) grid.x1al, (int) grid.y1al);
	// m.addPoint((int) grid.x2cl, (int) grid.y2cl);
	// m.addPoint((int) grid.x3cl, (int) grid.y3cl);
	// m.addPoint((int) grid.x4al, (int) grid.y4al);
	// m.addPoint((int) grid.x1al, (int) grid.y1al);
	//
	// grid.gp.append(m, false);
	// grid.poly = m;
	// grid.myParent = (DLO) dlo;
	// ((DLO) dlo).gridPartsH.add(grid);
	// grid.rowCol = count;
	// grid.isNew = true;
	// grid.myFrame2 = myFrame2;
	//
	// ((DLO) dlo).bOpeningObject.mullionsH.add(grid);
	// ((DLO) dlo).noGridsH = ((DLO) dlo).anchorsH.size();
	// if (((DLO) dlo).myParentO.myGlassMid != null) {
	// ((DLO) dlo).myParentO.myGlassMid.noGridsH = 0;
	// }
	//
	// }
	//
	// return (DLO) dlo;
	// }

	public DLO doSetAnchorsInSlaveDLOHNew(final int pos, final Object dlo) {

		double myThick;
		((DLO) dlo).anchorsH.clear();
		((DLO) dlo).gridPartsH.clear();
		((DLO) dlo).bOpeningObject.mullionsH.clear();
		((DLO) dlo).liteH = ((DLO) dlo).myMasterH.liteH;

		myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

		Collections.sort(hardHs);

		Object[] hhs = hardHs.toArray();

		for (Object hh : hhs) {
			if (Double.parseDouble(hh.toString()) > ((DLO) dlo).highestY
					&& Double.parseDouble(hh.toString()) < ((DLO) dlo).lowestY) {
				((DLO) dlo).anchorsH.add(Double.parseDouble(hh.toString()));
			}

		}

		int count = 0;

		double firstPos = 0;
		double lastPos = 0;

		double delta = 0;

		// First Position

		for (Object aw2 : hhs) {
			if (count == 0) {
				firstPos = Double.parseDouble(aw2.toString()) - myThick / 2;
				break;
			}
			count++;
		}

		addAtBeginingV(dlo, firstPos, ((DLO) dlo).liteH, 2);

		// Last Position

		count = 0;
		for (Object aw2 : hhs) {
			if (count == hhs.length - 1) {
				lastPos = Double.parseDouble(aw2.toString()) + myThick / 2;
				break;
			}
			count++;
		}

		addAtEndV(dlo, lastPos, ((DLO) dlo).liteH, 2);

		// between Position

		addInBetweenV(dlo, hhs, ((DLO) dlo).liteH, 2);

		// ///////////////////////////////////////////////////

		Object[] ancH = ((DLO) dlo).anchorsH.toArray();

		((DLO) dlo).anchorsH.clear();
		for (final Object aw3 : ancH) {

			if (Double.parseDouble(aw3.toString()) < ((DLO) dlo).highestY
					+ ((DLO) dlo).gridRemovalZoneH * myScale.doubleValue()
					|| Double.parseDouble(aw3.toString()) > ((DLO) dlo).lowestY
							- ((DLO) dlo).gridRemovalZoneW
							* myScale.doubleValue()) {
				// do not
				// add
			} else {
				((DLO) dlo).anchorsH.add(aw3);
			}

		}

		ancH = ((DLO) dlo).anchorsH.toArray();
		count = 0;
		for (final Object aw3 : ancH) {
			count++;
			Profiles grid = new Profiles();
			grid.partForm = 1;
			grid.orientation = 2;
			grid.partDimB = myThick;

			double glassToSpacer = 0;
			if (((DLO) dlo).myFrame2.mySeries.getSeriesUom() == 1) {
				glassToSpacer = UOMConvert.getBigDecimalConversion(
						((DLO) dlo).myParentGlass.glassToSpacer,
						myFrame2.metricscale, 1);
			} else {
				glassToSpacer = UOMConvert.getBigDecimalConversion(
						((DLO) dlo).myParentGlass.glassToSpacerImp,
						myFrame2.imperialscale, 1);
			}

			grid.y1al = grid.y1 = grid.y4al = grid.y4 = Double.parseDouble(aw3
					.toString()) + myThick / 2;
			grid.y2cl = grid.y2 = grid.y3cl = grid.y3 = Double.parseDouble(aw3
					.toString()) - myThick / 2;

			grid.x1al = grid.x1 = grid.x2cl = grid.x2 = grid.centerXs = ((DLO) dlo).myParentGlass.startingX
					+ glassToSpacer;
			grid.x4al = grid.x4 = grid.x3cl = grid.x3 = grid.centerXe = ((DLO) dlo).myParentGlass.bX2
					- glassToSpacer;

			grid.centerYs = Double.parseDouble(aw3.toString());
			grid.centerYe = Double.parseDouble(aw3.toString());
			grid.length = grid.centerXe - grid.centerXs;

			grid.whichPos = pos;
			grid.thickness = myThick;

			grid.startPos = 1;
			grid.endPos = ancH.length;

			grid.exists = 1;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			final Polygon m = new Polygon();

			m.addPoint((int) grid.x1al, (int) grid.y1al);
			m.addPoint((int) grid.x2cl, (int) grid.y2cl);
			m.addPoint((int) grid.x3cl, (int) grid.y3cl);
			m.addPoint((int) grid.x4al, (int) grid.y4al);
			m.addPoint((int) grid.x1al, (int) grid.y1al);

			grid.gp.append(m, false);
			grid.poly = m;
			grid.myParent = (DLO) dlo;
			((DLO) dlo).gridPartsH.add(grid);
			grid.rowCol = count;
			grid.isNew = true;
			grid.myFrame2 = myFrame2;

			((DLO) dlo).bOpeningObject.mullionsH.add(grid);
			((DLO) dlo).noGridsH = ((DLO) dlo).anchorsH.size();

			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsH = ((DLO) dlo).anchorsH
						.size();
			}

		}

		return (DLO) dlo;
	}

	public DLO doSetAnchorsInSlaveDLOPerimeterHNew(final DLO dlo) {

		double remZone = 0;

		((DLO) dlo).anchorsH.clear();
		((DLO) dlo).gridPartsH.clear();

		((DLO) dlo).bOpeningObject.mullionsH.clear();

		myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

		Collections.sort(hardHs);

		Object[] hvs = hardHs.toArray();

		((DLO) dlo).anchorsH.addAll(hardHs);

		Object[] aV = ((DLO) dlo).anchorsH.toArray();

		int count = 0;
		for (Object av : aV) {
			count++;

			if (count == 1) {
				this.topPartPerimeter(((DLO) dlo), myThick);
				((DLO) dlo).noGridsH = ((DLO) dlo).noGridsH + 1;
				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.noGridsH = ((DLO) dlo).noGridsH + 1;
				}

			}

			if (count == 2) {

				this.botPartPerimeter(((DLO) dlo), myThick);
				((DLO) dlo).noGridsH = ((DLO) dlo).noGridsH + 1;
				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.noGridsH = ((DLO) dlo).noGridsH + 1;
				}

			}

			((DLO) dlo).liteH = ((DLO) dlo).perimeterH;
		}

		return dlo;
	}

	public void initGridNumberChange(final int pos, final int op) {

		if (op == 7) {
			int nV = Integer.parseInt(myFrame2.gridsPanel.tV.getText());
			nS = Integer.parseInt(myFrame2.gridsPanel.tS.getText());
			int nH = Integer.parseInt(myFrame2.gridsPanel.tH.getText());

			if (myFrame2.gridsPanel.setHV.isSelected()) {
				nS=0;
				selectedDLO.gridForm = 0;
				if (selectedDLO.noGridsV == nV) {
					if (selectedDLO.noGridsH != nH || nS>0) {
						this.SetNumGridsH(selectedDLO, nV, nH, pos);
					}
				} else {
					this.SetNumGridsV(selectedDLO, nV, nH, pos);
					if (selectedDLO.noGridsH != nH  || nS>0) {
						this.SetNumGridsH(selectedDLO, nV, nH, pos);
					}
				}
				if (selectedDLO.noGridsH == nH) {
					if (selectedDLO.noGridsV != nV) {
						this.SetNumGridsV(selectedDLO, nV, nH, pos);
					}
				} else {
					this.SetNumGridsH(selectedDLO, nV, nH, pos);
					if (selectedDLO.noGridsV != nV) {
						this.SetNumGridsV(selectedDLO, nV, nH, pos);
					}
				}
				nS=0;
			} else if (myFrame2.gridsPanel.setRS.isSelected()) {

				if (selectedDLO.lastNVGrid != 0 && selectedDLO.lastNHGrid != 0) {
					nV = selectedDLO.lastNVGrid;
					nH = selectedDLO.lastNHGrid;
				}
				
				if(selectedDLO.gridPartsH.size()>0){
					this.SetNumGridsHforHR(selectedDLO, nV, nH, pos);
				}

				selectedDLO.gridForm = 1;

				final Object[] mydlos = DLOs.toArray();
				DLOs.clear();
				for (Object dlo : mydlos) {
					if (((DLO) dlo).startingX == selectedDLO.startingX
							&& ((DLO) dlo).bX2 == selectedDLO.bX2
							&& ((DLO) dlo).startingY == selectedDLO.startingY
							&& ((DLO) dlo).bY2 == selectedDLO.bY2
							&& ((DLO) dlo).bX3 == selectedDLO.bX3
							&& ((DLO) dlo).bY3 == selectedDLO.bY3
							&& ((DLO) dlo).bX4 == selectedDLO.bX4
							&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

						// DLOs.add(this.createGridPartsMid((DLO) dlo));

						dlo = this.createGridPartsMid((DLO) dlo);
					}
					DLOs.add(dlo);
				}

				// }

			}
			selectedDLO.lastNVGrid = nV;
			selectedDLO.lastNHGrid = nH;
			selectedDLO.lastNSGrid = nS;
		}

		this.setAllDLOsMid(true);

	}

	// Searching for DLOs.add

	public boolean checkGoodForRadii(final Object[] mHs, boolean goodToGo) {

		for (final Object mH : mHs) {
			if (selectedDLO.top1Part.startingY >= ((Profiles) mH).y2 &&

			selectedDLO.top1Part.startingY <= ((Profiles) mH).y1) {
				goodToGo = true;

			}
		}
		if (selectedDLO.top1Part.startAngle + selectedDLO.top1Part.endAngle <= 90) {// QRR
			for (final Object mH : mHs) {
				if (selectedDLO.top1Part.endYC >= ((Profiles) mH).y3 &&

				selectedDLO.top1Part.endYC <= ((Profiles) mH).y4) {
					goodToGo = true;

				}
			}
		}
		return goodToGo;
	}

	public void SetNumGridsV(final DLO selectedDLO, final int noV,
			final int noH, final int pos) {

		int initNoLites = noV + 1;
		double anchorW = selectedDLO.startingX;

		double myThick = selectedDLO.gridThick * myScale.doubleValue();

		double totalThick = myThick * (initNoLites - 1);
		double dloW = Math.max(selectedDLO.bX2, selectedDLO.bX3)
				- Math.min(selectedDLO.startingX, selectedDLO.bX4);

		double resultLiteW = (dloW - totalThick) / initNoLites;

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {

			// if(selectedDLO.masterW){

			// boolean follow = false;
			// if(hardVs.size()>0 & hardVs.size() < initNoLites){
			// int response =0;
			//
			// Object[] options = {"Yes", "No"};
			//
			// response = JOptionPane.showOptionDialog(null,
			// "Align to Couplers/Mullions ?", "Align to Fixed Positions",
			// JOptionPane.DEFAULT_OPTION,
			// JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			//
			// if (response == 0) {
			// follow = true;
			// }
			// }
			//
			// dlo = calcAnchorW(initNoLites, resultLiteW, myThick, anchorW,
			// ((DLO) dlo), whichPos, follow);

			// this.setAnchorsWInSlave(whichPos);
			// this.setAnchorsHInSlave(whichPos);
			//
			//
			// for (Object dlo2 : mydlos)
			// {
			// ((DLO) dlo2).yRows = 1;
			// ((DLO) dlo2).xCols = 1;
			// ((DLO) dlo2).gridPartsS.clear();
			//
			// DLOs.add(this.createGridPartsMid((DLO) dlo));
			// }
			//
			// this.setAllDLOsMid(false);
			//
			// }else{

			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				dlo = doSetNoGridsV(selectedDLO, noH, pos, initNoLites,
						myThick, resultLiteW, dlo);

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				// if (selectedDLO.masterW && (((DLO) dlo).myMasterW.startingX
				// == selectedDLO.startingX && ((DLO) dlo).myMasterW.bX2 ==
				// selectedDLO.bX2
				// && ((DLO) dlo).myMasterW.startingY == selectedDLO.startingY
				// && ((DLO) dlo).myMasterW.bY2 == selectedDLO.bY2
				// && ((DLO) dlo).myMasterW.bX3 == selectedDLO.bX3 && ((DLO)
				// dlo).myMasterW.bY3 == selectedDLO.bY3
				// && ((DLO) dlo).myMasterW.bX4 == selectedDLO.bX4 && ((DLO)
				// dlo).myMasterW.bY4 == selectedDLO.bY4))
				// {
				// this.setAnchorsWInSlave(whichPos, mydlos);
				//
				// this.createGridPartsMid((DLO) dlo);
				// }

				DLOs.add(dlo);
			}
		}

		// }

	}

	public DLO doSetNoGridsV(final DLO selectedDLO, final int noH,
			final int pos, double initNoLites, double myThick,
			double resultLiteW, Object dlo) {

		double anchorW = selectedDLO.startingX;
		((DLO) dlo).gridForm = selectedDLO.gridForm;
		((DLO) dlo).anchorsV.clear();
		((DLO) dlo).gridPartsV.clear();
		((DLO) dlo).gridPartsS.clear();
		((DLO) dlo).bOpeningObject.mullions.clear();

		boolean forceAlign = false;
		// int counter =0;

		Object[] ma = null;

		if (!selectedDLO.masterW) {
			if (selectedDLO.myMasterW.noGridsV == initNoLites - 1) {
				forceAlign = true;
				ma = selectedDLO.myMasterW.anchorsV.toArray();
			}
		}

		for (int i = 0; i < initNoLites - 1; i++) {
			if (i == 0) {
				anchorW = ((DLO) dlo).startingX + resultLiteW + myThick / 2;
			} else {
				anchorW = anchorW + myThick / 2 + resultLiteW + myThick / 2;
			}

			if (anchorW < ((DLO) dlo).startingX + ((DLO) dlo).gridRemovalZoneW
					* myScale.doubleValue()
					|| anchorW > ((DLO) dlo).bX2 - ((DLO) dlo).gridRemovalZoneW
							* myScale.doubleValue()) {
				continue;
			}

			if (forceAlign && ma != null) {

				anchorW = (Double) ma[i];

			}

			Profiles grid = new Profiles();

			grid.partForm = 1;
			grid.orientation = 1;

			grid.x1al = grid.x1 = grid.x4al = grid.x4 = anchorW - myThick / 2;
			grid.x2cl = grid.x2 = grid.x3cl = grid.x3 = anchorW + myThick / 2;
			grid.y1al = grid.y1 = grid.y2cl = grid.y2 = ((DLO) dlo).highestY;
			grid.y4al = grid.y4 = grid.y3cl = grid.y3 = ((DLO) dlo).lowestY;

			grid.centerXs = grid.centerXe = anchorW;
			grid.centerYs = ((DLO) dlo).highestY;
			grid.centerYe = ((DLO) dlo).lowestY;
			grid.whichPos = pos;
			grid.thickness = myThick;
			grid.exists = 1;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			grid.length = grid.centerYe - grid.centerYs;

			this.doGridPolygon(grid);
			grid.myParent = (DLO) dlo;
			((DLO) dlo).gridPartsV.add(grid);

			grid.rowCol = i + 1;
			grid.startPos = 1;
			grid.endPos = noH + 1;
			grid.myFrame2 = myFrame2;

			((DLO) dlo).bOpeningObject.mullions.add(grid);

			((DLO) dlo).anchorsV.add(anchorW);

			((DLO) dlo).noGridsV = ((DLO) dlo).anchorsV.size();

			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsV = ((DLO) dlo).anchorsV
						.size();
			}
		}
		return (DLO) dlo;
	}

	public void SetNumGridsHforHR(final DLO selectedDLO, final int noV,
			final int noH, final int pos) {

		myThick = selectedDLO.gridThick * myScale.doubleValue();

		// double myStartY = selectedDLO.top1Part.startingY + myThick / 2;//
		// original

		double myStartY = selectedDLO.highestY;// min

		// if (selectedDLO.top1Part.startAngle + selectedDLO.top1Part.endAngle
		// <= 90) {// QRR
		// myStartY = selectedDLO.bY2 + myThick / 2;// min
		// }

		int initNoLites = 0;

		double gh = selectedDLO.idealGH;

		initNoLites = (int) ((selectedDLO.lowestY - myStartY) / (selectedDLO.idealGH * myScale
				.doubleValue()));
		
//		gh = (selectedDLO.lowestY - myStartY) / initNoLites;

	
		// if (selectedDLO.top1Part.startAngle + selectedDLO.top1Part.endAngle
		// <= 90) {// QRR
		// gh = (selectedDLO.lowestY - selectedDLO.bY2) / initNoLites;
		// }

		if (initNoLites > 0) {
			
			gh = (selectedDLO.lowestY - myStartY) / initNoLites;

			do {
				initNoLites++;
				gh = (selectedDLO.lowestY - myStartY) / initNoLites;

				// if (selectedDLO.top1Part.startAngle
				// + selectedDLO.top1Part.endAngle <= 90) {// QRR
				// gh = (selectedDLO.lowestY - selectedDLO.bY2) / initNoLites;
				// }

			} while (gh > selectedDLO.maxGH * myScale.doubleValue()
					|| gh < selectedDLO.minGH * myScale.doubleValue());
		}
		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		double anchorH = myStartY;

		for (Object dlo : mydlos) {
			if (((DLO) dlo).equals(selectedDLO)) {

				// == selectedDLO.startingX
				// && ((DLO) dlo).bX2 == selectedDLO.bX2
				// && ((DLO) dlo).startingY == selectedDLO.startingY
				// && ((DLO) dlo).bY2 == selectedDLO.bY2
				// && ((DLO) dlo).bX3 == selectedDLO.bX3
				// && ((DLO) dlo).bY3 == selectedDLO.bY3
				// && ((DLO) dlo).bX4 == selectedDLO.bX4
				// && ((DLO) dlo).bY4 == selectedDLO.bY4) {

				dlo = doSetNoHforHR(noV, pos, myStartY, initNoLites, gh, dlo);

			}

			DLOs.add(dlo);
		}

	}

	public DLO doSetNoHforHR(final int noV, final int pos, double myStartY,
			int initNoLites, double gh, final Object dlo) {

		double anchorH;
		anchorH = myStartY;
		((DLO) dlo).anchorsH.clear();
		((DLO) dlo).gridPartsH.clear();

		((DLO) dlo).bOpeningObject.mullionsH.clear();

		final double v1 = ((DLO) dlo).startingY - ((DLO) dlo).highestY;
		final double v2 = ((DLO) dlo).widthPix / 2;

		if (((DLO) dlo).top1Part.startAngle > 90) {// QRL
			((DLO) dlo).anchorsH.add(((DLO) dlo).top1Part.startingY);
		} else if (((DLO) dlo).top1Part.startAngle
				+ ((DLO) dlo).top1Part.endAngle <= 90) {// QRR
			((DLO) dlo).anchorsH.add(((DLO) dlo).top1Part.endY);
		}

		if (myFrame2.compareTwoDoubles(v1, v2)) {
			((DLO) dlo).anchorsH.add(((DLO) dlo).startingY);
		}

		anchorH = 0;
		for (int i = 0; i < initNoLites - 1; i++) {
			if (i == 0) {
				anchorH = myStartY + gh + myThick / 2;
			} else {
				anchorH = anchorH + myThick / 2 + gh + myThick / 2;
			}

			((DLO) dlo).anchorsH.add(anchorH);

		}

		Object[] aHs = ((DLO) dlo).anchorsH.toArray();
		((DLO) dlo).anchorsH.clear();

		Arrays.sort(aHs);

		for (final Object as : aHs) {
			((DLO) dlo).anchorsH.add(as);
		}

		aHs = ((DLO) dlo).anchorsH.toArray();

		int i = 0;
		for (final Object a : aHs) {

			Profiles grid = new Profiles();

			grid.partForm = 1;
			grid.orientation = 2;
			grid.partDimB = myThick;
			grid.whichPos = pos;
			grid.y1al = grid.y1 = grid.y4al = grid.y4 = Double.parseDouble(a
					.toString()) + myThick / 2;
			grid.y2cl = grid.y2 = grid.y3cl = grid.y3 = Double.parseDouble(a
					.toString()) - myThick / 2;
			grid.x1al = grid.x1 = grid.x2cl = grid.x2 = ((DLO) dlo).startingX;
			grid.x4al = grid.x4 = grid.x3cl = grid.x3 = ((DLO) dlo).bX2;

			grid.centerXs = ((DLO) dlo).startingX;

			grid.centerXe = ((DLO) dlo).bX2;

			grid.centerYs = Double.parseDouble(a.toString());
			grid.centerYe = Double.parseDouble(a.toString());
			grid.exists = 1;
			grid.length = grid.centerXe - grid.centerXs;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			grid.thickness = myThick;
			this.doGridPolygon(grid);
			grid.myParent = (DLO) dlo;

			grid.rowCol = i + 1;

			grid.startPos = 1;
			grid.endPos = noV + 1;
			grid.myFrame2 = myFrame2;

			((DLO) dlo).bOpeningObject.mullionsH.add(grid);

			((DLO) dlo).gridPartsH.add(grid);

			((DLO) dlo).noGridsH = ((DLO) dlo).anchorsH.size();

			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsH = ((DLO) dlo).anchorsH
						.size();
			}

			i++;
		}

		return (DLO) dlo;
	}

	public void SetNumGridsH(final DLO selectedDLO, final int noV,
			final int noH, final int pos) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		final double initNoLites = noH + 1;
		double anchorH = selectedDLO.highestY;

		final double myThick = selectedDLO.gridThick * myScale.doubleValue();

		final double totalThick = myThick * (initNoLites - 1);
		final double resultLiteH = (selectedDLO.lowestY - selectedDLO.highestY - totalThick)
				/ initNoLites;

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				dlo = doSetNoGridsH(noV, pos, initNoLites, myThick,
						resultLiteH, dlo);

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}

		}

	}

	public DLO doSetNoGridsH(final int noV, final int pos,
			final double initNoLites, final double myThick,
			final double resultLiteH, final Object dlo) {

		double anchorH = ((DLO) dlo).highestY;
		((DLO) dlo).anchorsH.clear();
		((DLO) dlo).gridPartsH.clear();

		((DLO) dlo).bOpeningObject.mullionsH.clear();

		Object[] ma = null;
		boolean forceAlign = false;

		if (!selectedDLO.masterH) {
			if (selectedDLO.myMasterH.noGridsH == initNoLites - 1) {
				forceAlign = true;
				ma = selectedDLO.myMasterH.anchorsH.toArray();
			}
		}

		for (int i = 0; i < initNoLites - 1; i++) {
			if (i == 0) {
				anchorH = ((DLO) dlo).highestY + resultLiteH + myThick / 2;
			} else {
				anchorH = anchorH + myThick / 2 + resultLiteH + myThick / 2;
			}

			if (forceAlign && ma != null) {

				anchorH = (Double) ma[i];

			}

			if (anchorH < ((DLO) dlo).highestY + ((DLO) dlo).gridRemovalZoneH
					* myScale.doubleValue()
					|| anchorH > ((DLO) dlo).lowestY
							- ((DLO) dlo).gridRemovalZoneH
							* myScale.doubleValue()) {
				continue;
			} else {

				Profiles grid = new Profiles();
				grid.partForm = 1;
				grid.orientation = 2;
				grid.partDimB = myThick;
				grid.whichPos = pos;
				grid.y1al = grid.y1 = grid.y4al = grid.y4 = anchorH + myThick
						/ 2;
				grid.y2cl = grid.y2 = grid.y3cl = grid.y3 = anchorH - myThick
						/ 2;
				grid.x1al = grid.x1 = grid.x2cl = grid.x2 = ((DLO) dlo).startingX;
				grid.x4al = grid.x4 = grid.x3cl = grid.x3 = ((DLO) dlo).bX2;

				grid.centerXs = ((DLO) dlo).startingX;

				grid.centerXe = ((DLO) dlo).bX2;

				grid.centerYs = anchorH;
				grid.centerYe = anchorH;
				grid.exists = 1;
				grid.length = grid.centerXe - grid.centerXs;
				grid.cOrM = 7;
				grid = doGridsLevels(((DLO) dlo), grid);
				grid.thickness = myThick;
				this.doGridPolygon(grid);
				grid.myParent = (DLO) dlo;

				grid.rowCol = i + 1;
				grid.startPos = 1;
				grid.endPos = noV + 1;
				grid.myFrame2 = myFrame2;

				((DLO) dlo).bOpeningObject.mullionsH.add(grid);

				((DLO) dlo).gridPartsH.add(grid);

				((DLO) dlo).anchorsH.add(anchorH);
				((DLO) dlo).noGridsH = ((DLO) dlo).anchorsH.size();
				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.noGridsH = ((DLO) dlo).anchorsH
							.size();
				}

			}
		}
		return (DLO) dlo;
	}

	public void cutGridNew(final int pos, final int op, final int xxx,
			final int yyy) {

		final Object[] mydlos = DLOs.toArray();

		boolean found = false;

		for (Object dlo : mydlos) {

			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				if (((DLO) dlo).gridType % 2 != 0) {
					dlo = doCutgridNew((DLO) dlo);

				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Perimeter Grid cannot be Cut\n "
											+ "To request this feature please contact your supplier!",
									"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
			// HERE
			DLOs.add(dlo);
		}

		this.setAllDLOsMid(true);
		selectedGridsV.clear();
		selectedGridsH.clear();
		selectedGridsS.clear();
	}

	public DLO doCutgridNew(DLO dlo) {

		boolean found = false;

		final Object[] vg = dlo.gridPartsV.toArray();
		dlo.gridPartsV.clear();

		Object[] sg = selectedGridsV.toArray();

		for (Object g : vg) {

			for (Object s : sg) {
				if (((Profiles) g).equals(s)) {
					((Profiles) g).remove = true;
					found = true;
				}
			}
			dlo.gridPartsV.add(g);
		}

		final Object[] hg = dlo.gridPartsH.toArray();
		dlo.gridPartsH.clear();

		sg = selectedGridsH.toArray();

		for (final Object g : hg) {
			for (final Object s : sg) {
				if (((Profiles) g).equals(s)) {
					((Profiles) g).remove = true;
					found = true;
				}
			}
			dlo.gridPartsH.add(g);
		}

		final Object[] ssg = dlo.gridPartsS.toArray();
		dlo.gridPartsS.clear();

		sg = selectedGridsS.toArray();

		for (Object g : ssg) {
			for (final Object s : sg) {
				if (((Profiles) g).equals(s)) {
					((Profiles) g).remove = true;
					found = true;
				}
			}
			dlo.gridPartsS.add(g);
		}

		dlo.bOpeningObject.mullions.clear();
		dlo.bOpeningObject.mullionsH.clear();

		dlo = this.doMullionsFromPartsV(dlo);
		dlo = this.doMullionsFromPartsH(dlo);

		dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);

		return dlo;
	}

	public void cutGrid(final int pos, final int op, final int xxx,
			final int yyy) {

		final Object[] mydlos = DLOs.toArray();

		final double myThick = selectedDLO.gridThick * myScale.doubleValue();

		Object[] result = new Object[2];
		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				if (((DLO) dlo).gridType % 2 != 0) {
					dlo = doCutGrid(pos, xxx, yyy, myThick, (DLO) dlo);

				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Perimeter Grid cannot be Cut\n "
											+ "To request this feature please contact your supplier!",
									"Error", JOptionPane.ERROR_MESSAGE);
				}

			}

			DLOs.add(dlo);
		}

		this.setAllDLOsMid(true);
	}

	public DLO doCutGrid(final int pos, final int xxx, final int yyy,
			final double myThick, DLO dlo) {

		Object[] result;
		boolean found = false;
		result = this.cutVGrid(pos, xxx, yyy, myThick, dlo);
		dlo = (DLO) result[1];
		found = (Boolean) result[0];

		if (!found) {

			result = this.cutHGrid(pos, xxx, yyy, myThick, dlo);
			dlo = (DLO) result[1];
			found = (Boolean) result[0];
		}

		if (!found) {
			cutSpoke = true;
			result = this.cutSpoke(pos, xxx, yyy, myThick, dlo);
			dlo = (DLO) result[1];
			found = (Boolean) result[0];
		}

		dlo = this.doMullionsFromPartsV(dlo);

		dlo = this.doMullionsFromPartsH(dlo);
		// dlo = this.finalCheck(((DLO) dlo));
		dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);
		return dlo;
	}

	public Object[] cutVGrid(final int pos, final int xxx, final int yyy,
			final double myThick, final DLO dlo) {

		final Object[] aV = dlo.gridPartsV.toArray();

		dlo.gridPartsV.clear();

		final Object[] result = new Object[2];

		result[0] = false;
		for (final Object av : aV) {

			if (((Profiles) av).gp.contains(xxx, yyy)
					&& ((Profiles) av).y1a < yyy && ((Profiles) av).y4a > yyy) {
				((Profiles) av).remove = true;
				result[0] = true;
			} else if (((Profiles) av).remove) {
				((Profiles) av).remove = true;
			}

			dlo.gridPartsV.add(av);

			result[1] = dlo;
		}

		return result;
	}

	public Object[] cutHGrid(final int pos, final int xxx, final int yyy,
			final double myThick, final DLO dlo) {

		final Object[] aV = dlo.gridPartsH.toArray();

		dlo.gridPartsH.clear();
		final Object[] result = new Object[2];
		result[0] = false;
		for (final Object av : aV) {

			if (((Profiles) av).gp.contains(xxx, yyy)
					&& ((Profiles) av).x1a < xxx && ((Profiles) av).x4a > xxx) {
				((Profiles) av).remove = true;
				result[0] = true;
			}
			dlo.gridPartsH.add(av);
			result[1] = dlo;
		}

		return result;
	}

	public Object[] cutArcGrid(final int pos, final int xxx, final int yyy,
			final double myThick, final DLO dlo) {

		final Object[] aV = dlo.gridPartsH.toArray();

		dlo.gridPartsH.clear();
		final Object[] result = new Object[2];
		result[0] = false;
		for (final Object av : aV) {

			if (((Profiles) av).partForm > 1
					&& ((Profiles) av).arc2B.getBounds().contains(xxx, yyy)) {
				((Profiles) av).remove = true;
				result[0] = true;
			}
			dlo.gridPartsH.add(av);
			result[1] = dlo;
		}

		return result;
	}

	public Object[] cutSpoke(final int pos, final int xxx, final int yyy,
			final double myThick, final DLO dlo) {

		final Object[] aV = dlo.gridPartsS.toArray();

		dlo.gridPartsS.clear();

		final Object[] result = new Object[2];
		for (final Object av : aV) {

			if (((Profiles) av).gp.contains(xxx, yyy)) {
				((Profiles) av).remove = true;
				((Profiles) av).remove = true;
				result[0] = true;
			}
			dlo.gridPartsS.add(av);
			result[1] = dlo;
		}

		return result;
	}

	public void removeGridNew(final int pos, final int op, final int xxx,
			final int yyy) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				dlo = doRemoveGridNew((DLO) dlo);

			}

			DLOs.add(dlo);
		}

		this.setAllDLOsMid(true);
		selectedRemoveRC.clear();
	}

	public DLO doRemoveGridNew(DLO dlo) {

		final Object[] cols = selectedRemoveRC.toArray();

		if (dlo.gridType % 2 != 0) {
			final Object[] vp = dlo.gridPartsV.toArray();

			dlo.gridPartsV.clear();

			dlo.bOpeningObject.mullions.clear();
			dlo.bOpeningObject.mullionsH.clear();

			for (final Object g : vp) {
				for (final Object c : cols) {
					final int[] col = (int[]) c;
					final int o = col[1];
					final int cc = col[0];
					if (!((Profiles) g).remove && ((Profiles) g).rowCol == cc
							&& ((Profiles) g).orientation == o) {
						((Profiles) g).remove = true;
						((Profiles) g).isValid = false;
					}
				}

				dlo.gridPartsV.add(g);

			}

			final Object[] hp = dlo.gridPartsH.toArray();

			dlo.gridPartsH.clear();
			for (final Object g : hp) {
				for (final Object c : cols) {
					final int[] col = (int[]) c;
					final int o = col[1];
					final int cc = col[0];
					if (!((Profiles) g).remove && ((Profiles) g).rowCol == cc
							&& ((Profiles) g).orientation == o) {
						((Profiles) g).remove = true;
						((Profiles) g).isValid = false;
					}
				}

				dlo.gridPartsH.add(g);

			}

		} else {
			final Object[] vm = dlo.bOpeningObject.mullions.toArray();

			dlo.bOpeningObject.mullions.clear();
			for (final Object g : vm) {
				for (final Object c : cols) {
					final int[] col = (int[]) c;
					final int o = col[1];
					final int cc = col[0];
					if (!((Profiles) g).remove && ((Profiles) g).rowCol == cc
							&& ((Profiles) g).orientation == o) {
						((Profiles) g).remove = true;
						((Profiles) g).isValid = false;
					}

				}
				dlo.bOpeningObject.mullions.add(g);
			}

			final Object[] hm = dlo.bOpeningObject.mullionsH.toArray();

			dlo.bOpeningObject.mullionsH.clear();
			for (final Object g : hm) {
				for (final Object c : cols) {
					final int[] col = (int[]) c;
					final int o = col[1];
					final int cc = col[0];
					if (!((Profiles) g).remove && ((Profiles) g).rowCol == cc
							&& ((Profiles) g).orientation == o) {
						((Profiles) g).remove = true;
						((Profiles) g).isValid = false;
					}

				}
				dlo.bOpeningObject.mullionsH.add(g);
			}

		}

		if (nS > 0) {
			dlo.gridPartsS.clear();
			Object[] myHs = dlo.gridPartsH.toArray();
			if (myHs.length > 0) {
				boolean hasHR = false;

				// dlo = this.doFullSpokes(dlo);

				for (Object h : myHs) {
					if (((Profiles) h).partForm > 1 && !cutSpoke) {
						dlo = this.doSpokes(dlo, (Profiles) h, myHs, cutSpoke);
						hasHR = true;
					}
				}
				if (!hasHR) {
					for (Object h : myHs) {
						if (((Profiles) h).partForm == 1 && !cutSpoke
								&& ((Profiles) h).rowCol == 1) {
							dlo = this.doSpokes(dlo, (Profiles) h, myHs,
									cutSpoke);
							hasHR = true;
						}
					}
				}
			}
		}

		if (dlo.gridType % 2 != 0) {
			dlo = this.doMullionsFromPartsV(dlo);

			dlo = this.doMullionsFromPartsH(dlo);
		}

		dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);
		return dlo;
	}

	public void removeGrid(final int pos, final int op, final int xxx,
			final int yyy) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		int found = 0;

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				dlo = removeGrid(pos, xxx, yyy, (DLO) dlo);

			}

			DLOs.add(dlo);
		}

		this.setAllDLOsMid(true);
	}

	public DLO removeGrid(final int pos, final int xxx, final int yyy, DLO dlo) {

		int found;
		found = this.removeVGridPerimeter(pos, xxx, yyy, dlo);

		if (found > 0) {
			final Object[] hp = dlo.bOpeningObject.mullions.toArray();
			dlo.bOpeningObject.mullions.clear();

			for (final Object p : hp) {
				if (((Profiles) p).rowCol == found) {
					((Profiles) p).remove = true;
				}
				if (dlo.gridType == 3) {
					dlo.bOpeningObject.mullions.add(p);
				}

			}

			final Object[] ppp = dlo.gridPartsV.toArray();
			dlo.gridPartsV.clear();
			for (final Object p : ppp) {
				if (((Profiles) p).rowCol == found) {
					((Profiles) p).remove = true;

				}
				dlo.gridPartsV.add(p);
			}

		} else
		// if (found == 0 &&
		// ((DLO)
		// dlo).gridType==3)
		{
			found = this.removeHGridPerimeter(pos, xxx, yyy, dlo);
			if (found > 0) {
				final Object[] hp = dlo.bOpeningObject.mullionsH.toArray();
				dlo.bOpeningObject.mullionsH.clear();

				for (final Object p : hp) {

					if (((Profiles) p).rowCol == found) {
						((Profiles) p).remove = true;

					}
					if (dlo.gridType == 3) {
						dlo.bOpeningObject.mullionsH.add(p);
					}
				}

				final Object[] pp = dlo.gridPartsH.toArray();
				dlo.gridPartsH.clear();
				for (final Object p : pp) {

					if (((Profiles) p).rowCol == found) {
						((Profiles) p).remove = true;

					}
					dlo.gridPartsH.add(p);
				}

			}

		}

		if (found == 0) {

			JOptionPane
					.showMessageDialog(
							null,
							"Selected Grid cannot be removed\n "
									+ "To request this feature please contact your supplier!",
							"Error", JOptionPane.ERROR_MESSAGE);
		} else {

			if (dlo.gridType % 2 != 0) {
				dlo = this.doMullionsFromPartsV(dlo);

				dlo = this.doMullionsFromPartsH(dlo);
			}

			dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);

		}
		return dlo;
	}

	public int removeVGrid(final int pos, final int xxx, final int yyy,
			final Object dlo) {

		final Object[] vp = ((DLO) dlo).gridPartsV.toArray();

		int col = 0;
		for (final Object p : vp) {

			if (((Profiles) p).gp.contains(xxx, yyy)) {
				col = ((Profiles) p).rowCol;
				break;
			}
		}

		return col;
	}

	public int removeVGridPerimeter(final int pos, final int xxx,
			final int yyy, final Object dlo) {

		final Object[] vp = ((DLO) dlo).bOpeningObject.mullions.toArray();

		int col = 0;
		for (final Object p : vp) {

			if (((Profiles) p).gp.contains(xxx, yyy)) {
				col = ((Profiles) p).rowCol;
				break;
			}
		}

		return col;
	}

	public int removeHGrid(final int pos, final int xxx, final int yyy,
			final Object dlo) {

		final Object[] hp = ((DLO) dlo).gridPartsH.toArray();

		int row = 0;
		for (final Object p : hp) {

			if (((Profiles) p).gp.contains(xxx, yyy)) {
				row = ((Profiles) p).rowCol;
				break;
			}
		}

		return row;
	}

	public int removeHGridPerimeter(final int pos, final int xxx,
			final int yyy, final Object dlo) {

		final Object[] hp = ((DLO) dlo).bOpeningObject.mullionsH.toArray();

		int row = 0;
		for (final Object p : hp) {

			if (((Profiles) p).gp.contains(xxx, yyy)) {
				row = ((Profiles) p).rowCol;
				break;
			}
		}

		return row;
	}

	public int removeArcGrid(final int pos, final int xxx, final int yyy,
			final Object dlo) {

		final Object[] hp = ((DLO) dlo).gridPartsH.toArray();

		int row = 0;
		for (final Object p : hp) {

			if (((Profiles) p).partForm > 1) {
				final Arc2D myArc = new Arc2D.Double(
						(int) ((Profiles) p).bkgrdStartXBA,
						(int) ((Profiles) p).bkgrdStartYBA,
						(int) ((Profiles) p).bkgrdWidthBA,
						(int) ((Profiles) p).bkgrdHeightBA,
						((Profiles) p).startAngleBA, ((Profiles) p).endAngleBA,
						Arc2D.OPEN);

				if (myArc.getBounds().contains(xxx, yyy)) {
					row = ((Profiles) p).rowCol;
					break;
				}

			}
		}

		return row;
	}

	public void recheckAreaOfInfluenceW() {

		Object[] mydlos;

		mydlos = DLOs.toArray();

		DLOs.clear();
		for (final Object o : mydlos) {
			if (((DLO) o).masterW) {
				DLOs.clear();
				for (final Object oo : mydlos) {
					if (!((DLO) oo).equals(o)) {
						if (((DLO) oo).startingX >= ((DLO) o).msx
								&& ((DLO) oo).bX2 <= ((DLO) o).mex
								&& ((DLO) oo).widthPix < ((DLO) o).widthPix) {
							((DLO) oo).masterW = false;

						}
					}
					DLOs.add(oo);
				}

			}

		}
	}

	public boolean checkWidestAfter(final Object[] mydlos, final DLO myDLO,
			final DLO myMaster) {

		boolean isWidest = false;

		double widest = 0;
		for (final Object ooo : mydlos) {
			if (((DLO) ooo).startingX > myMaster.bX2) {
				if (((DLO) ooo).widthPix > widest) {
					widest = ((DLO) ooo).widthPix;
				}
			}

		}

		if (myDLO.widthPix == widest) {
			if (mastersW.size() > 0) {
				final Object[] ms = mastersW.toArray();
				for (final Object m : ms) {
					if (myDLO.startingX >= ((DLO) m).msx
							|| myDLO.bX2 <= ((DLO) m).mex) {
						isWidest = false;
					} else {
						isWidest = true;
						mastersW.add(myDLO);
					}
				}
			} else {
				isWidest = true;
				mastersW.add(myDLO);
			}

		}

		return isWidest;

	}

	public boolean checkNarrowestAfter(final DLO myDLO, final DLO myMaster,
			int narrowest) {

		boolean isNarrowest = false;

		int myDLOW = 0;
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myDLOW = myDLO.widthM;
		} else {
			myDLOW = myDLO.widthI;
		}

		if (myDLOW == narrowest) {
			if (mastersW.size() > 0) {
				final Object[] ms = mastersW.toArray();
				for (final Object m : ms) {
					if (myDLO.startingX >= ((DLO) m).mex) {
						isNarrowest = true;
					}
				}
			} else {
				isNarrowest = true;
			}

		}

		return isNarrowest;

	}

	public boolean checkShortestAfter(final DLO myDLO, final DLO myMaster,
			int shortest) {

		boolean isShortest = false;

		int myDLOH = 0;
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myDLOH = myDLO.heightM;
		} else {
			myDLOH = myDLO.heightI;
		}

		if (myDLOH == shortest) {
			if (mastersH.size() > 0) {
				final Object[] ms = mastersH.toArray();
				for (final Object m : ms) {
					if (myDLO.startingY >= ((DLO) m).mey) {
						isShortest = true;
					}
				}
			} else {
				isShortest = true;
			}

		}

		return isShortest;

	}

	public boolean checkWidestBefore(final Object[] mydlos, final DLO myDLO,
			final DLO myMaster) {

		boolean isWidest = false;
		double widest = 0;
		int myDLOW = 0;

		for (final Object ooo : mydlos) {

			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOW = ((DLO) ooo).widthM;
			} else {
				myDLOW = ((DLO) ooo).widthI;
			}

			if (((DLO) ooo).bX2 < myMaster.startingX) {
				if (myDLOW > widest) {
					widest = myDLOW;
				}
			}
		}

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myDLOW = myDLO.widthM;
		} else {
			myDLOW = myDLO.widthI;
		}

		if (myDLOW == widest) {
			isWidest = true;
		}

		return isWidest;

	}

	public boolean checkNarrowestBefore(final DLO myDLO, final DLO myMaster,
			int narrowest) {

		boolean isNarrowest = false;

		int myDLOW = 0;
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myDLOW = myDLO.widthM;
		} else {
			myDLOW = myDLO.widthI;
		}

		if (myDLOW == narrowest) {
			if (mastersW.size() > 0) {
				final Object[] ms = mastersW.toArray();
				for (final Object m : ms) {
					if (myDLO.bX2 <= ((DLO) m).msx) {
						isNarrowest = true;
					}
				}
			} else {
				isNarrowest = true;
			}

		}

		return isNarrowest;

	}

	public boolean checkShortestBefore(final DLO myDLO, final DLO myMaster,
			int shortest) {

		boolean isShortest = false;

		int myDLOH = 0;
		if (myFrame2.mySeries.getSeriesUom() == 1) {
			myDLOH = myDLO.heightM;
		} else {
			myDLOH = myDLO.heightI;
		}

		if (myDLOH == shortest) {
			if (mastersH.size() > 0) {
				final Object[] ms = mastersH.toArray();
				for (final Object m : ms) {
					if (myDLO.lowestY <= ((DLO) m).msy) {
						isShortest = true;
					}
				}
			} else {
				isShortest = true;
			}

		}

		return isShortest;

	}

	public int checkOverLapW(final Object[] mydlos, final DLO myDLO) {

		int addtoCount = 0;
		for (final Object ooo : mydlos) {
			if (((DLO) ooo).masterW) {

				if (!myDLO.equals(ooo)) {
					if (myDLO.startingX >= ((DLO) ooo).msx
							&& myDLO.bX2 <= ((DLO) ooo).mex) {
						myDLO.masterW = false;
						myDLO.myMasterW = (DLO) ooo;
						myDLO.msx = 0;
						myDLO.mex = 0;
						addtoCount++;
					}
				}

			}

		}
		return addtoCount;
	}

	public void getMyMasterW() {

		int addtoCount = 0;
		final Object[] mydlos = DLOs.toArray();

		for (final Object ooo : mydlos) {
			if (((DLO) ooo).masterW) {
				DLOs.clear();
				for (final Object o : mydlos) {
					if (!((DLO) o).equals(ooo)) {
						if (((DLO) o).startingX >= ((DLO) ooo).msx
								&& ((DLO) o).bX2 <= ((DLO) ooo).mex) {
							((DLO) o).masterW = false;
							((DLO) o).myMasterW = (DLO) ooo;
							((DLO) o).msx = 0;
							((DLO) o).mex = 0;

							addtoCount++;
						}

					}
					DLOs.add(o);
				}

			}

		}
		// return DLOs;
	}

	public DLO getAreaofInfluenceW(final Object[] mydlos, final DLO myMasterDLO) {

		myMasterDLO.msx = Math.min(myMasterDLO.startingX, myMasterDLO.bX4);
		myMasterDLO.mex = Math.max(myMasterDLO.bX2, myMasterDLO.bX3);

		for (final Object oo : mydlos) {
			if (!((DLO) oo).equals(myMasterDLO)
					&& ((DLO) oo).startingX < myMasterDLO.startingX) {
				if (((DLO) oo).bX2 <= myMasterDLO.bX2
						&& ((DLO) oo).bX2 > myMasterDLO.startingX) {
					myMasterDLO.msx = ((DLO) oo).startingX;
				}

				if (((DLO) oo).startingX >= myMasterDLO.startingX
						&& ((DLO) oo).startingX < myMasterDLO.bX2) {
					myMasterDLO.msx = ((DLO) oo).startingX;
				}

			}
		}

		for (final Object oo : mydlos) {
			if (!((DLO) oo).equals(myMasterDLO)
					&& ((DLO) oo).bX2 > myMasterDLO.bX2) {
				if (((DLO) oo).startingX >= myMasterDLO.startingX
						&& ((DLO) oo).startingX < myMasterDLO.bX2) {
					myMasterDLO.mex = ((DLO) oo).bX2;
				}

			}
		}

		return myMasterDLO;
	}

	public DLO getMaxW(final Object[] mydlos, final double currentMaxW) {

		DLO maxDLO = new DLO(myFrame2);
		double maxW = 0;
		for (final Object d : mydlos) {

			int myDLOW = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOW = ((DLO) d).widthM;
			} else {
				myDLOW = ((DLO) d).widthI;
			}

			if (myDLOW < currentMaxW && myDLOW > maxW) {
				maxDLO = (DLO) d;
				maxW = myDLOW;
				maxDLO.masterW = true;

				maxDLO.msx = maxDLO.startingX;
				maxDLO.mex = maxDLO.bX2;
				maxDLO = getAreaofInfluenceW(mydlos, maxDLO);

			} else {
				((DLO) d).myMasterW = maxDLO;
			}
		}

		return maxDLO;
	}

	public DLO getMinW(final Object[] mydlos) {

		DLO minDLO = new DLO(myFrame2);
		double minW = 10000;

		for (final Object d : mydlos) {

			int myDLOW = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOW = ((DLO) d).widthM;
			} else {
				myDLOW = ((DLO) d).widthI;
			}

			if (myDLOW < minW) {
				minDLO = (DLO) d;
				if (minW == 10000) {
					minW = myDLOW;
				} else {
					minW = minW - myDLOW;
				}
			}
		}
		return minDLO;
	}

	public DLO getMaxW() {

		this.mastersW.clear();
		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		DLO maxDLO = new DLO(myFrame2);
		double maxW = 0;
		for (final Object d : mydlos) {
			if (((DLO) d).widthPix > maxW) {

				maxW = ((DLO) d).widthPix;

				((DLO) d).masterW = false;
			}
			DLOs.add(d);
		}

		mydlos = DLOs.toArray();
		DLOs.clear();
		boolean maxFound = false;
		for (Object d : mydlos) {

			if (((DLO) d).widthPix == maxW && !maxFound) {
				((DLO) d).masterW = true;
				maxDLO = (DLO) d;

				((DLO) d).msx = ((DLO) d).startingX;
				((DLO) d).mex = ((DLO) d).bX2;
				d = this.getAreaofInfluenceW(mydlos, maxDLO);
				maxDLO = (DLO) d;
				maxFound = true;

			} else
			// if (maxFound)
			{
				if (((DLO) d).startingX > maxDLO.bX2) {
					((DLO) d).masterW = true;
				} else if (((DLO) d).bX2 < maxDLO.startingX) {
					((DLO) d).masterW = true;
				} else {
					((DLO) d).masterW = false;
				}

			}

			DLOs.add(d);
		}

		mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object d : mydlos) {

			if (!((DLO) d).masterW) {

				if (((DLO) d).startingX > maxDLO.bX2) {
					final boolean widest = this.checkWidestAfter(mydlos,
							((DLO) d), maxDLO);

					if (widest) {
						((DLO) d).masterW = true;
						((DLO) d).msx = ((DLO) d).startingX;
						((DLO) d).mex = ((DLO) d).bX2;
						d = this.getAreaofInfluenceW(mydlos, ((DLO) d));
					}
				} else if (((DLO) d).bX2 < maxDLO.startingX) {
					final boolean widest = this.checkWidestBefore(mydlos,
							((DLO) d), maxDLO);

					if (widest) {
						((DLO) d).masterW = true;
						((DLO) d).msx = ((DLO) d).startingX;
						((DLO) d).mex = ((DLO) d).bX2;
						d = this.getAreaofInfluenceW(mydlos, ((DLO) d));
					}
				}

			}
			DLOs.add(d);

		}

		mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object d : mydlos) {

			if (!((DLO) d).masterW) {

				if (((DLO) d).startingX > maxDLO.bX2) {
					final boolean widest = this.checkWidestAfter(mydlos,
							((DLO) d), maxDLO);

					if (widest) {
						((DLO) d).masterW = true;
						((DLO) d).msx = ((DLO) d).startingX;
						((DLO) d).mex = ((DLO) d).bX2;
						d = this.getAreaofInfluenceW(mydlos, ((DLO) d));
					}
				} else if (((DLO) d).bX2 < maxDLO.startingX) {
					final boolean widest = this.checkWidestBefore(mydlos,
							((DLO) d), maxDLO);

					if (widest) {
						((DLO) d).masterW = true;
						((DLO) d).msx = ((DLO) d).startingX;
						((DLO) d).mex = ((DLO) d).bX2;
						d = this.getAreaofInfluenceW(mydlos, ((DLO) d));
					}
				}

			}
			DLOs.add(d);

		}

		mydlos = DLOs.toArray();

		final Collection masters = new ArrayList();
		for (final Object d : mydlos) {
			if (((DLO) d).masterW) {
				masters.add(d);
			}

		}
		DLOs.clear();

		final Object[] myMastersW = masters.toArray();

		for (final Object d : mydlos) {
			if (!((DLO) d).masterW) {
				for (final Object ms : myMastersW) {
					if ((int) (((DLO) d).startingX * 100) / 100 >= (int) (((DLO) ms).msx * 100) / 100
							&& (int) (((DLO) d).bX2 * 100) / 100 >= (int) (((DLO) ms).mex * 100) / 100) {
						((DLO) d).myMasterW = (DLO) ms;
						break;
					}
				}
				DLOs.add(d);
			} else {
				DLOs.add(d);
			}

		}

		return maxDLO;
	}

	public DLO getMaxH() {

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		DLO maxDLO = new DLO(myFrame2);
		double maxH = 0;
		for (final Object d : mydlos) {

			int myDLOH = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOH = ((DLO) d).heightM;
			} else {
				myDLOH = ((DLO) d).heightI;
			}

			if (myDLOH > maxH) {
				maxH = myDLOH;
				((DLO) d).masterH = false;
			}
			DLOs.add(d);
		}
		mydlos = DLOs.toArray();
		DLOs.clear();
		boolean maxFound = false;
		for (Object d : mydlos) {

			int myDLOH = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOH = ((DLO) d).heightM;
			} else {
				myDLOH = ((DLO) d).heightI;
			}

			if (myDLOH == maxH && !maxFound) {
				((DLO) d).masterH = true;
				maxDLO = (DLO) d;

				((DLO) d).msy = ((DLO) d).highestY;
				((DLO) d).mey = ((DLO) d).lowestY;
				d = this.getAreaofInfluenceH(mydlos, maxDLO);
				maxDLO = (DLO) d;
				maxFound = true;
				DLOs.add(d);
			} else {
				((DLO) d).masterH = false;
				DLOs.add(d);
			}

		}

		mydlos = DLOs.toArray();

		DLOs.clear();
		for (final Object d : mydlos) {
			int myDLOH = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOH = ((DLO) d).heightM;
			} else {
				myDLOH = ((DLO) d).heightI;
			}

			if (!((DLO) d).equals(maxDLO) && myDLOH != maxH) {

				if (((DLO) d).highestY >= maxDLO.msy
						&& ((DLO) d).lowestY <= maxDLO.mey) {

					((DLO) d).myMasterH = maxDLO;

				}
			}
			DLOs.add(d);
		}
		return maxDLO;
	}

	public boolean getMinWOLD() {

		this.mastersW.clear();
		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		DLO minDLO = new DLO(myFrame2);
		double minW = 1000000;
		boolean foundMin = false;

		for (final Object d : mydlos) {
			int myDLOW = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOW = ((DLO) d).widthM;
			} else {
				myDLOW = ((DLO) d).widthI;
			}

			if (myDLOW < minW && myDLOW > 2 * ((DLO) d).minGW) {
				minW = myDLOW;
				foundMin = true;
			}

			// set all DLOs master = false

			((DLO) d).masterW = false;
			((DLO) d).myMasterW = new DLO();

			((DLO) d).myMasterW.liteW = ((DLO) d).idealGW;

			DLOs.add(d);
		}

		if (foundMin) {

			mydlos = DLOs.toArray();
			DLOs.clear();
			boolean minFound = false;
			for (Object d : mydlos) {
				int myDLOW = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOW = ((DLO) d).widthM;
				} else {
					myDLOW = ((DLO) d).widthI;
				}

				if (myDLOW == minW && !minFound) {
					((DLO) d).masterW = true;

					minDLO = (DLO) d;

					((DLO) d).msx = ((DLO) d).startingX;
					((DLO) d).mex = ((DLO) d).bX2;

					d = this.getAreaofInfluenceW(mydlos, minDLO);

					minDLO = (DLO) d;

					minFound = true;

				}

				DLOs.add(d);
			}

			mydlos = DLOs.toArray();

			int narrowestAfter = 1000000;
			int narrowestBefore = 1000000;

			for (final Object ooo : mydlos) {
				if (((DLO) ooo).startingX >= minDLO.bX2) {

					int myDLOW = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOW = ((DLO) ooo).widthM;
					} else {
						myDLOW = ((DLO) ooo).widthI;
					}

					if (myDLOW < narrowestAfter) {
						narrowestAfter = myDLOW;
					}
				}

			}

			for (final Object ooo : mydlos) {
				int myDLOW = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOW = ((DLO) ooo).widthM;
				} else {
					myDLOW = ((DLO) ooo).widthI;
				}

				if (((DLO) ooo).bX2 <= minDLO.startingX) {
					if (myDLOW < narrowestBefore) {
						narrowestBefore = myDLOW;
					}
				}

			}

			mydlos = DLOs.toArray();
			DLOs.clear();

			for (Object d : mydlos) {

				if (!((DLO) d).masterW) {

					if (((DLO) d).startingX >= minDLO.bX2) {

						final boolean narrow = this.checkNarrowestAfter(
								((DLO) d), minDLO, narrowestAfter);

						if (narrow) {
							mastersW.add(d);
							((DLO) d).masterW = true;
							((DLO) d).msx = ((DLO) d).startingX;
							((DLO) d).mex = ((DLO) d).bX2;

							d = this.getAreaofInfluenceW(mydlos, ((DLO) d));

						}
					} else if (((DLO) d).bX2 <= minDLO.startingX) {
						final boolean widest = this.checkNarrowestBefore(
								((DLO) d), minDLO, narrowestBefore);

						if (widest) {
							mastersW.add(d);
							((DLO) d).masterW = true;
							((DLO) d).msx = ((DLO) d).startingX;
							((DLO) d).mex = ((DLO) d).bX2;
							d = this.getAreaofInfluenceW(mydlos, ((DLO) d));
						}
					}

				}
				DLOs.add(d);

			}

			mydlos = DLOs.toArray();
			DLOs.clear();

			Collection masters = new ArrayList();

			for (final Object d : mydlos) {
				if (((DLO) d).masterW) {
					masters.add(d);
				}

			}

			// set The master Pane to all Non-Master DLOs
			mydlos = DLOs.toArray();
			DLOs.clear();

			final Object[] myMastersW = masters.toArray();

			for (final Object d : mydlos) {
				if (!((DLO) d).masterW && ((DLO) d).myMasterW == null) {
					for (final Object ms : myMastersW) {
						// if DLO is within area of Influence of current
						// master, then set its master to current

						if (((DLO) ms).startingX >= ((DLO) d).startingX
								&& ((DLO) ms).bX2 <= ((DLO) d).bX2) {
							((DLO) d).myMasterW = (DLO) ms;
							break;
						}
					}
					DLOs.add(d);
				} else {
					DLOs.add(d);
				}

			}
		}

		return foundMin;
	}

	public boolean getMinHOLD() {

		this.mastersH.clear();
		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		DLO minDLO = new DLO(myFrame2);

		double minH = 1000000;
		boolean foundMin = false;
		for (final Object d : mydlos) {

			int myDLOH = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOH = ((DLO) d).heightM;
			} else {
				myDLOH = ((DLO) d).heightI;
			}

			if (myDLOH < minH && myDLOH > 2 * ((DLO) d).minGH) {
				minH = myDLOH;
				foundMin = true;
			}

			((DLO) d).masterH = false;

			((DLO) d).myMasterH = new DLO();

			((DLO) d).myMasterH.liteH = ((DLO) d).idealGH;

			DLOs.add(d);
		}
		if (foundMin) {
			mydlos = DLOs.toArray();
			DLOs.clear();
			boolean minFound = false;
			for (Object d : mydlos) {

				int myDLOH = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOH = ((DLO) d).heightM;
				} else {
					myDLOH = ((DLO) d).heightI;
				}

				if (myDLOH == minH) {
					((DLO) d).masterH = true;

					minDLO = (DLO) d;

					((DLO) d).msy = ((DLO) d).highestY;
					((DLO) d).mey = ((DLO) d).lowestY;

					d = this.getAreaofInfluenceH(mydlos, minDLO);

					minDLO = (DLO) d;

					minFound = true;

				}

				DLOs.add(d);
			}

			mydlos = DLOs.toArray();
			DLOs.clear();

			int shortestAfter = 1000000;
			int shortestBefore = 1000000;

			for (final Object ooo : mydlos) {

				int myDLOH = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOH = ((DLO) ooo).heightM;
				} else {
					myDLOH = ((DLO) ooo).heightI;
				}

				if (((DLO) ooo).highestY >= minDLO.lowestY) {
					if (myDLOH < shortestAfter) {
						shortestAfter = myDLOH;
					}
				}

			}

			for (final Object ooo : mydlos) {

				int myDLOH = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOH = ((DLO) ooo).heightM;
				} else {
					myDLOH = ((DLO) ooo).heightI;
				}

				if (((DLO) ooo).lowestY <= minDLO.highestY) {
					if (myDLOH < shortestBefore) {
						shortestBefore = myDLOH;
					}
				}

			}

			for (Object d : mydlos) {

				if (!((DLO) d).masterH) {

					if (((DLO) d).highestY >= minDLO.lowestY) {

						final boolean narrow = this.checkShortestAfter(
								((DLO) d), minDLO, shortestAfter);

						if (narrow) {
							mastersH.add(d);
							((DLO) d).masterH = true;
							((DLO) d).msy = ((DLO) d).highestY;
							((DLO) d).mey = ((DLO) d).lowestY;

							d = this.getAreaofInfluenceH(mydlos, ((DLO) d));

						}
					} else if (((DLO) d).lowestY <= minDLO.highestY) {
						final boolean narrow = this.checkShortestBefore(
								((DLO) d), minDLO, shortestBefore);

						if (narrow) {
							mastersH.add(d);
							((DLO) d).masterH = true;
							((DLO) d).msy = ((DLO) d).highestY;
							((DLO) d).mey = ((DLO) d).lowestY;

							d = this.getAreaofInfluenceH(mydlos, ((DLO) d));
						}
					}

				}
				DLOs.add(d);

			}

			mydlos = DLOs.toArray();

			final Collection masters = new ArrayList();

			for (final Object d : mydlos) {
				if (((DLO) d).masterH) {
					masters.add(d);
				}

			}

			// set The master Pane to all Non-Master DLOs

			DLOs.clear();

			final Object[] myMastersH = masters.toArray();

			for (final Object d : mydlos) {
				if (!((DLO) d).masterH) {
					for (final Object ms : myMastersH) {
						// if DLO is within area of Influence of current
						// master, then set its master to current

						if (((DLO) ms).highestY >= ((DLO) d).highestY
								&& ((DLO) ms).lowestY <= ((DLO) d).lowestY) {
							((DLO) d).myMasterH = (DLO) ms;
							break;
						}
					}
					DLOs.add(d);
				} else {
					DLOs.add(d);
				}

			}

			// mydlos = DLOs.toArray();
			//
			// DLOs.clear();
			//
			// for (final Object d : mydlos)
			// {
			// if (!((DLO) d).equals(minDLO) && ((DLO) d).heightI != minH)
			// {
			//
			// if (((DLO) d).highestY >= minDLO.msy && ((DLO) d).lowestY <=
			// minDLO.mey)
			// {
			//
			// ((DLO) d).myMasterH = minDLO;
			//
			// }
			// }
			// DLOs.add(d);
			// }
		}

		return foundMin;
	}

	public void getMinW() {

		this.mastersW.clear();

		DLO minDLO = new DLO(myFrame2);
		double minW = 1000000;

		boolean moreToEvaluate = false;

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object d : mydlos) {
			((DLO) d).eval = 0;

			DLOs.add(d);
		}

		Collection spoints = new ArrayList();
		Collection epoints = new ArrayList();
		do {
			moreToEvaluate = false;

			mydlos = DLOs.toArray();
			DLOs.clear();

			for (final Object d : mydlos) {
				int myDLOW = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOW = ((DLO) d).widthM;
				} else {
					myDLOW = ((DLO) d).widthI;
				}

				if (myDLOW - ((DLO) d).gridRemovalZoneW < 2 * ((DLO) d).minGW
						+ ((DLO) d).gridThick) {
					((DLO) d).eval = 1;

				}
				DLOs.add(d);
			}

			mydlos = DLOs.toArray();
			DLOs.clear();

			for (final Object d : mydlos) {
				if (((DLO) d).eval == 0) {
					moreToEvaluate = true;
					break;
				}

			}

			minW = 1000000;

			if (moreToEvaluate) {

				for (final Object d : mydlos) {

					int myDLOW = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOW = ((DLO) d).widthM;
					} else {
						myDLOW = ((DLO) d).widthI;
					}

					if (((DLO) d).eval == 0) {
						if (myDLOW < minW) {
							minW = myDLOW;

						}

						// set all DLOs master = false

						((DLO) d).masterW = false;
						((DLO) d).myMasterW = new DLO();

						((DLO) d).myMasterW.liteW = ((DLO) d).idealGW;
					}

					DLOs.add(d);
				}

				mydlos = DLOs.toArray();
				DLOs.clear();

				// Get First Master
				boolean minFound = false;
				for (Object d : mydlos) {

					int myDLOW = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOW = ((DLO) d).widthM;
					} else {
						myDLOW = ((DLO) d).widthI;
					}

					if (((DLO) d).eval == 0 && myDLOW == minW && !minFound) {

						((DLO) d).masterW = true;

						((DLO) d).eval = 1;

						minDLO = (DLO) d;
						minFound = true;
						((DLO) d).msx = ((DLO) d).startingX;
						((DLO) d).mex = ((DLO) d).bX2;

					}

					DLOs.add(d);
				}

				mydlos = DLOs.toArray();
				DLOs.clear();

				int narrowestAfter = 1000000;
				int narrowestBefore = 1000000;

				for (final Object ooo : mydlos) {

					int myDLOW = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOW = ((DLO) ooo).widthM;
					} else {
						myDLOW = ((DLO) ooo).widthI;
					}

					if (((DLO) ooo).startingX >= minDLO.bX2
							&& ((DLO) ooo).eval == 0) {
						if (myDLOW < narrowestAfter) {
							narrowestAfter = myDLOW;
						}
					}

				}

				for (final Object ooo : mydlos) {
					int myDLOW = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOW = ((DLO) ooo).widthM;
					} else {
						myDLOW = ((DLO) ooo).widthI;
					}

					if (((DLO) ooo).bX2 <= minDLO.startingX
							&& ((DLO) ooo).eval == 0) {
						if (myDLOW < narrowestBefore) {
							narrowestBefore = myDLOW;
						}
					}

				}

				boolean foundNext = false;

				for (Object d : mydlos) {

					if (((DLO) d).eval == 0 && !foundNext) {
						int myDLOW = 0;
						if (myFrame2.mySeries.getSeriesUom() == 1) {
							myDLOW = ((DLO) d).widthM;
						} else {
							myDLOW = ((DLO) d).widthI;
						}

						if (((DLO) d).startingX >= minDLO.bX2) {

							if (myDLOW == narrowestAfter) {
								mastersW.add(d);
								((DLO) d).masterW = true;
								((DLO) d).msx = ((DLO) d).startingX;
								((DLO) d).mex = ((DLO) d).bX2;
								((DLO) d).eval = 1;
								foundNext = true;

							}
						} else if (((DLO) d).bX2 <= minDLO.startingX) {

							if (myDLOW == narrowestBefore) {
								mastersW.add(d);
								((DLO) d).masterW = true;
								((DLO) d).msx = ((DLO) d).startingX;
								((DLO) d).mex = ((DLO) d).bX2;
								((DLO) d).eval = 1;
								foundNext = true;
							}
						}

					}
					DLOs.add(d);

				}

				mydlos = DLOs.toArray();

				Collection masters = new ArrayList();

				for (final Object d : mydlos) {
					if (((DLO) d).masterW) {
						masters.add(d);
					}

				}

				Object[] ms = masters.toArray();

				// set slaves

				DLOs.clear();

				for (Object d : mydlos) {

					for (Object m : ms) {
						if (((DLO) d).eval == 0) {
							if ((((DLO) d).startingX <= ((DLO) m).startingX && ((DLO) d).bX2 >= ((DLO) m).startingX)
									|| (((DLO) d).startingX >= ((DLO) m).startingX && ((DLO) d).startingX < ((DLO) m).bX2)
									|| (((DLO) d).bX2 > ((DLO) m).startingX && ((DLO) d).bX2 <= ((DLO) m).bX2)) {

								((DLO) d).masterW = false;
								((DLO) d).eval = 1;
								((DLO) d).myMasterW = ((DLO) m);
							}

						}
					}

					DLOs.add(d);
				}

			}//
			else {
				for (final Object d : mydlos) {
					DLOs.add(d);

				}
			}

		} while (moreToEvaluate);

	}

	public void getMinH() {

		this.mastersH.clear();

		DLO minDLO = new DLO(myFrame2);
		double minH = 1000000;

		boolean moreToEvaluate = false;

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object d : mydlos) {
			((DLO) d).eval = 0;

			DLOs.add(d);
		}

		do {
			moreToEvaluate = false;

			mydlos = DLOs.toArray();
			DLOs.clear();

			for (final Object d : mydlos) {
				int myDLOH = 0;
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myDLOH = ((DLO) d).heightM;
				} else {
					myDLOH = ((DLO) d).heightI;
				}

				if (myDLOH - ((DLO) d).gridRemovalZoneH < 2 * ((DLO) d).minGH
						+ ((DLO) d).gridThick) {
					((DLO) d).eval = 1;

				}
				DLOs.add(d);
			}

			mydlos = DLOs.toArray();
			DLOs.clear();

			for (final Object d : mydlos) {
				if (((DLO) d).eval == 0) {
					moreToEvaluate = true;
					break;
				}

			}

			minH = 1000000;

			if (moreToEvaluate) {

				for (final Object d : mydlos) {

					int myDLOH = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOH = ((DLO) d).heightM;
					} else {
						myDLOH = ((DLO) d).heightI;
					}

					if (((DLO) d).eval == 0) {
						if (myDLOH < minH) {
							minH = myDLOH;

						}

						// set all DLOs master = false

						((DLO) d).masterH = false;
						((DLO) d).myMasterH = new DLO();

						((DLO) d).myMasterH.liteH = ((DLO) d).idealGH;
					}

					DLOs.add(d);
				}

				mydlos = DLOs.toArray();
				DLOs.clear();

				// Get First Master
				boolean minFound = false;
				for (Object d : mydlos) {
					int myDLOH = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOH = ((DLO) d).heightM;
					} else {
						myDLOH = ((DLO) d).heightI;
					}

					if (((DLO) d).eval == 0 && myDLOH == minH && !minFound) {

						((DLO) d).masterH = true;

						mastersH.add(d);

						((DLO) d).eval = 1;

						minDLO = (DLO) d;
						minFound = true;
						((DLO) d).msy = ((DLO) d).highestY;
						((DLO) d).mey = ((DLO) d).lowestY;

					}

					DLOs.add(d);
				}

				mydlos = DLOs.toArray();
				DLOs.clear();

				int shortestAfter = 1000000;
				int shortestBefore = 1000000;

				for (final Object ooo : mydlos) {

					int myDLOH = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOH = ((DLO) ooo).heightM;
					} else {
						myDLOH = ((DLO) ooo).heightI;
					}

					if (((DLO) ooo).highestY >= minDLO.lowestY
							&& ((DLO) ooo).eval == 0) {
						if (myDLOH < shortestAfter) {
							shortestAfter = myDLOH;
						}
					}

				}

				for (final Object ooo : mydlos) {
					int myDLOH = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOH = ((DLO) ooo).heightM;
					} else {
						myDLOH = ((DLO) ooo).heightI;
					}

					if (((DLO) ooo).lowestY <= minDLO.highestY
							&& ((DLO) ooo).eval == 0) {
						if (myDLOH < shortestBefore) {
							shortestBefore = myDLOH;
						}
					}

				}

				boolean foundNext = false;

				for (Object d : mydlos) {
					int myDLOH = 0;
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						myDLOH = ((DLO) d).heightM;
					} else {
						myDLOH = ((DLO) d).heightI;
					}
					if (((DLO) d).eval == 0 && !foundNext) {

						if (((DLO) d).highestY >= minDLO.lowestY) {

							if (myDLOH == shortestAfter) {
								mastersH.add(d);
								((DLO) d).masterH = true;
								((DLO) d).msy = ((DLO) d).highestY;
								((DLO) d).mey = ((DLO) d).lowestY;
								((DLO) d).eval = 1;
								foundNext = true;
							}
						} else if (((DLO) d).lowestY <= minDLO.highestY) {

							if (myDLOH == shortestBefore) {
								mastersH.add(d);
								((DLO) d).masterH = true;
								((DLO) d).msy = ((DLO) d).highestY;
								((DLO) d).mey = ((DLO) d).lowestY;
								((DLO) d).eval = 1;
								foundNext = true;
							}
						}

					}
					DLOs.add(d);

				}

				mydlos = DLOs.toArray();

				Collection masters = new ArrayList();

				for (final Object d : mydlos) {
					if (((DLO) d).masterH) {
						masters.add(d);
					}

				}

				Object[] ms = masters.toArray();

				// set slaves

				DLOs.clear();

				for (Object d : mydlos) {

					for (Object m : ms) {
						if (((DLO) d).eval == 0) {
							if ((((DLO) d).highestY <= ((DLO) m).highestY && ((DLO) d).lowestY >= ((DLO) m).highestY)
									|| (((DLO) d).highestY >= ((DLO) m).highestY && ((DLO) d).highestY < ((DLO) m).lowestY)
									|| (((DLO) d).lowestY > ((DLO) m).highestY && ((DLO) d).lowestY <= ((DLO) m).lowestY)) {

								((DLO) d).masterH = false;
								((DLO) d).eval = 1;
								((DLO) d).myMasterH = ((DLO) m);
								break;
							}

						}
					}

					DLOs.add(d);
				}

			}//
			else {
				for (final Object d : mydlos) {
					DLOs.add(d);

				}
			}

		} while (moreToEvaluate);

	}

	public DLO changeInternalDims(final int row, final int col, final int rowo,
			final int colo, final int lite, final Collection leftTexts,
			final int pos, final int VH, final ShapeObject myClickedFrame) {

		frameSeq = myClickedFrame.a_sequenceID;// Integer.parseInt(String.valueOf(row)+String.valueOf(col));

		// op : 1 = Change Master V
		// op : 2 = Change Master H
		// op : 3 = Equalize V
		// op : 4 = Equalise H

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMidInFrame(myClickedFrame);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		// DLO selectedDLO = new DLO(myFrame2);
		final Object[] mydlos = DLOs.toArray();

		boolean found = false;
		for (final Object dlo : mydlos) {
			if (((DLO) dlo).myParentO.startRow == rowo
					&& ((DLO) dlo).myParentO.startCol == colo) {
				
				selectedDLO = (DLO) dlo;
				if(selectedDLO.myMasterH==null){
					selectedDLO.myMasterH = new DLO();
					
				}
				if(selectedDLO.myMasterW==null){
					selectedDLO.myMasterW = new DLO();
					
				}
				found = true;
			}

		}

		if (found) {
			if (VH == 2) {
				this.changeHDim(lite, leftTexts);
			} else {
				this.changeVDim(lite, leftTexts);
			}

		}

		return selectedDLO;

	}

	public void changeMasterW() {

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				((DLO) dlo).masterW = true;
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();

				((DLO) dlo).gridPartsH.clear();
				dlo = this.getAreaofInfluenceW(mydlos, ((DLO) dlo));

			} else if (((DLO) dlo).masterW
					&& ((DLO) dlo).msx <= selectedDLO.startingX
					&& ((DLO) dlo).mex >= selectedDLO.bX2) {

				((DLO) dlo).masterW = false;
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();
				((DLO) dlo).gridPartsH.clear();

			}

			DLOs.add(dlo);
		}
		this.recheckAreaOfInfluenceW();
		this.recheckAreaOfInfluenceH();
		this.setAnchorsWInMaster();
		this.setAnchorsHInMaster();
		this.getMyMasterW();
		this.getMyMasterH();

		mydlos = DLOs.toArray();
		DLOs.clear();

		this.setAnchorsWInSlave(whichPos, mydlos);
		this.setAnchorsHInSlave(whichPos, mydlos);

		for (final Object dlo : mydlos) {
			((DLO) dlo).yRows = 1;
			((DLO) dlo).xCols = 1;
			((DLO) dlo).gridPartsS.clear();

			DLOs.add(this.createGridPartsMid((DLO) dlo));
		}

		this.setAllDLOsMid(false);

	}

	public void equalizeV() {

		final int initNoLites = selectedDLO.noGridsV + 1;
		final double dloW = Math.max(selectedDLO.bX2, selectedDLO.bX3)
				- Math.min(selectedDLO.startingX, selectedDLO.bX4);
		final double myThick = selectedDLO.gridThick * myScale.doubleValue();
		final double totalThick = selectedDLO.noGridsV * myThick;
		final double resultLiteW = (dloW - totalThick) / initNoLites;
		final double anchorW = selectedDLO.startingX;

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				((DLO) dlo).anchorsV = new ArrayList();

				((DLO) dlo).gridPartsV = new ArrayList();

				dlo = this.calcAnchorW(initNoLites, resultLiteW, myThick,
						anchorW, dlo, whichPos, false);

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}

		}

		this.setAllDLOsMid(true);

	}

	public DLO calcAnchorW(final int initNoLites, final double resultLiteW,
			final double myThick, double anchorW, final Object dlo,
			final int pos, boolean followHVs) {

		((DLO) dlo).anchorsV.clear();
		((DLO) dlo).gridPartsV.clear();
		((DLO) dlo).gridMasksV.clear();

		((DLO) dlo).bOpeningObject.mullions.clear();

		for (int i = 0; i < initNoLites - 1; i++) {
			if (i == 0) {
				anchorW = ((DLO) dlo).startingX + resultLiteW + myThick / 2;

			} else {
				anchorW = anchorW + myThick / 2 + resultLiteW + myThick / 2;
			}

			Collections.sort(hardVs);

			Object[] ancW = hardVs.toArray();

			hardVs.clear();
			for (final Object aw3 : ancW) {
				if (Double.parseDouble(aw3.toString()) >= ((DLO) dlo).startingX
						&& Double.parseDouble(aw3.toString()) <= ((DLO) dlo).bX2) {
					if (Double.parseDouble(aw3.toString()) < ((DLO) dlo).startingX
							+ ((DLO) dlo).gridRemovalZoneW
							* myScale.doubleValue()
							|| Double.parseDouble(aw3.toString()) > ((DLO) dlo).bX2
									- ((DLO) dlo).gridRemovalZoneW
									* myScale.doubleValue()) {

					} else {
						addValueToList(hardVs,
								Double.parseDouble(aw3.toString()));
					}
				} else {
					addValueToList(hardVs, Double.parseDouble(aw3.toString()));
				}

			}

			Object[] hVs = hardVs.toArray();
			double minDelta = 1000000;
			for (Object hv : hVs) {
				if (Math.abs(anchorW - Double.parseDouble(hv.toString())) < minDelta) {
					minDelta = Math.abs(anchorW
							- Double.parseDouble(hv.toString()));
				}
			}

			boolean isNewAnchor = true;

			for (Object hv : hVs) {
				if (Math.abs(anchorW - Double.parseDouble(hv.toString())) == minDelta
						&& minDelta < resultLiteW && followHVs) {

					anchorW = Double.parseDouble(hv.toString());
					isNewAnchor = false;

				} else if (!followHVs
						&& anchorW - Double.parseDouble(hv.toString()) == 0) {
					isNewAnchor = false;
				}
			}

			if (anchorW < ((DLO) dlo).startingX + ((DLO) dlo).gridRemovalZoneW
					* myScale.doubleValue()
					|| anchorW > ((DLO) dlo).bX2 - ((DLO) dlo).gridRemovalZoneW
							* myScale.doubleValue()) {
				continue;
			}

			if (isNewAnchor && ((DLO) dlo).anchorsV.size() > 0) {

			}

			Profiles grid = new Profiles();

			grid.endTypeLT = 3;
			grid.endTypeRB = 3;

			grid.myFrame2 = myFrame2;
			grid.partForm = 1;
			grid.orientation = 1;
			grid.partDimB = myThick;
			grid.x1al = grid.x1a = grid.x1 = grid.x4al = grid.x4 = grid.x4a = anchorW
					- myThick / 2;
			grid.x2cl = grid.x2a = grid.x2 = grid.x3cl = grid.x3 = grid.x3a = anchorW
					+ myThick / 2;
			// should bu highestY del Glass + glass_edge_spacer_in
			// How to find glass

			double glassToSpacer = 0;
			if (((DLO) dlo).myFrame2.mySeries.getSeriesUom() == 1) {
				glassToSpacer = UOMConvert.getBigDecimalConversion(
						((DLO) dlo).myParentGlass.glassToSpacer,
						myFrame2.metricscale, 1);
			} else {
				glassToSpacer = UOMConvert.getBigDecimalConversion(
						((DLO) dlo).myParentGlass.glassToSpacerImp,
						myFrame2.imperialscale, 1);
			}

			// grid.y1al = grid.y1a = grid.y1 = grid.y2cl = grid.y2 = grid.y2a =
			// ((DLO) dlo).highestY;
			// grid.y4al = grid.y4a = grid.y4 = grid.y3cl = grid.y3 = grid.y3a =
			// ((DLO) dlo).lowestY ;

			grid.y1al = grid.y1a = grid.y1 = grid.y2cl = grid.y2 = grid.y2a = ((DLO) dlo).myParentGlass.highestY
					+ glassToSpacer;
			grid.y4al = grid.y4a = grid.y4 = grid.y3cl = grid.y3 = grid.y3a = ((DLO) dlo).myParentGlass.lowestY
					- glassToSpacer;

			grid.centerXs = grid.centerXe = anchorW;
			grid.centerYs = ((DLO) dlo).myParentGlass.highestY + glassToSpacer;
			grid.centerYe = ((DLO) dlo).myParentGlass.lowestY - glassToSpacer;
			grid.whichPos = pos;
			grid.exists = 1;
			grid.thickness = myThick;
			grid.exists = 1;
			grid.cOrM = 7;
			grid = doGridsLevels(((DLO) dlo), grid);
			// grid.length = grid.centerYe - grid.centerYs;

			if (grid.partForm == 1) {
				grid.length = Math
						.sqrt(Math.pow(
								(Math.max(grid.centerXe, grid.centerXs) - Math
										.min(grid.centerXe, grid.centerXs)), 2)
								+ Math.pow((Math.max(grid.centerYe,
										grid.centerYs) - Math.min(
										grid.centerYe, grid.centerYs)), 2));
			} else {
				grid.length = 2 * Math.PI * grid.radius1
						* Math.max(grid.endAngle, grid.endAngleA) / 360;
			}

			grid.isNew = true;
			this.doGridPolygon(grid);
			grid.myParent = (DLO) dlo;

			((DLO) dlo).gridPartsV.add(grid);

			grid.rowCol = i + 1;
			grid.startPos = 1;
			grid.endPos = initNoLites;
			grid.myFrame2 = myFrame2;

			((DLO) dlo).bOpeningObject.mullions.add(grid);

			((DLO) dlo).anchorsV.add(anchorW);

			if (isNewAnchor) {
				addValueToList(hardVs, anchorW);
			}

			((DLO) dlo).noGridsV = ((DLO) dlo).anchorsV.size();

			if (((DLO) dlo).myParentO.myGlassMid != null) {

				((DLO) dlo).myParentO.myGlassMid.noGridsV = ((DLO) dlo).anchorsV
						.size();

			}

		}
		return (DLO) dlo;
	}

	public DLO nextMaxW(final Object[] mydlos, final double maxDLOw) {

		DLO maxDLO = new DLO(myFrame2);
		double maxW = maxDLOw;
		for (final Object d : mydlos) {

			int myDLOW = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOW = ((DLO) d).widthM;
			} else {
				myDLOW = ((DLO) d).widthI;
			}

			if (myDLOW < maxDLOw && myDLOW > maxW && !((DLO) d).masterW
					&& ((DLO) d).myMasterW == null) {
				maxDLO = (DLO) d;
				maxW = myDLOW;
			}
		}
		return maxDLO;

	}

	public double nextMinW(final Object[] mydlos, final double minDLO) {

		double minW = minDLO;
		final Collection restDLO = new ArrayList();

		int count = 0;
		for (final Object dlo : mydlos) {
			if (!((DLO) dlo).masterW) {
				restDLO.add(dlo);
				count++;
			}
		}
		final Object[] myrest = restDLO.toArray();

		for (final Object d : myrest) {

			int myDLOW = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOW = ((DLO) d).widthM;
			} else {
				myDLOW = ((DLO) d).widthI;
			}

			if (myDLOW < minW) {
				minW = myDLOW;
			}
		}
		return minW;
	}

	public Collection findHighestDLOsII(final int gridType) {

		Object[] mydlos = null;
		double minDLOh = 0;

		if (gridType % 2 != 0) {
			DLO maxDLO = new DLO(myFrame2);
			maxDLO = this.getMaxH();
			minDLOh = maxDLO.heightPix;
			mydlos = DLOs.toArray();
			DLOs.clear();
			int count = 0;

			do {
				if (((DLO) mydlos[count]).startingX == maxDLO.startingX
						&& ((DLO) mydlos[count]).bX2 == maxDLO.bX2
						&& ((DLO) mydlos[count]).startingY == maxDLO.startingY
						&& ((DLO) mydlos[count]).bY2 == maxDLO.bY2
						&& ((DLO) mydlos[count]).bX3 == maxDLO.bX3
						&& ((DLO) mydlos[count]).bY3 == maxDLO.bY3
						&& ((DLO) mydlos[count]).bX4 == maxDLO.bX4
						&& ((DLO) mydlos[count]).bY4 == maxDLO.bY4) {
					((DLO) mydlos[count]).masterH = true;

					if (((DLO) mydlos[count]).shapeID == 1) {
						((DLO) mydlos[count]).msy = ((DLO) mydlos[count]).highestY;
					} else {
						((DLO) mydlos[count]).msy = ((DLO) mydlos[count]).highestY
								- ((DLO) mydlos[count]).myParent.top1Part.partDimB;
					}

					if (((DLO) mydlos[count]).shapeID == 1) {
						((DLO) mydlos[count]).mey = ((DLO) mydlos[count]).lowestY;
					} else {
						((DLO) mydlos[count]).mey = ((DLO) mydlos[count]).lowestY
								+ ((DLO) mydlos[count]).myParent.bot1Part.partDimB;
					}

					mydlos[count] = this.getAreaofInfluenceH(mydlos,
							((DLO) mydlos[count]));

					final int myCurrentCount = count;
					count += this.checkOverLapH(mydlos, count);

					minDLOh = this.nextMaxH(mydlos, minDLOh);

					if (myCurrentCount == count) {
						count++;
					}

				} else if (((DLO) mydlos[count]).highestY >= maxDLO.highestY
						&& ((DLO) mydlos[count]).lowestY <= maxDLO.lowestY) {

					// ((DLO) mydlos[count]).masterH =
					// false;
					count++;
				} else if (((DLO) mydlos[count]).highestY >= maxDLO.highestY
						&& ((DLO) mydlos[count]).highestY <= maxDLO.lowestY) {

					// ((DLO) mydlos[count]).masterH =
					// false;
					count++;
				} else if (((DLO) mydlos[count]).lowestY <= maxDLO.lowestY
						&& ((DLO) mydlos[count]).lowestY >= maxDLO.highestY) {
					// ((DLO) mydlos[count]).masterH =
					// false;
					count++;
				} else if (((DLO) mydlos[count]).highestY > maxDLO.lowestY) {
					((DLO) mydlos[count]).masterH = true;
					((DLO) mydlos[count]).msy = ((DLO) mydlos[count]).highestY;
					((DLO) mydlos[count]).mey = ((DLO) mydlos[count]).lowestY;
					mydlos[count] = this.getAreaofInfluenceH(mydlos,
							((DLO) mydlos[count]));
					final int myCurrentCount = count;
					count += this.checkOverLapH(mydlos, count);
					minDLOh = this.nextMaxH(mydlos, minDLOh);

					if (myCurrentCount == count) {
						count++;
					}
				} else if (((DLO) mydlos[count]).lowestY < maxDLO.highestY
						&& ((DLO) mydlos[count]).highestY < maxDLO.highestY) {
					((DLO) mydlos[count]).masterH = true;
					((DLO) mydlos[count]).msy = ((DLO) mydlos[count]).highestY;
					((DLO) mydlos[count]).mey = ((DLO) mydlos[count]).lowestY;
					mydlos[count] = this.getAreaofInfluenceH(mydlos,
							((DLO) mydlos[count]));
					final int myCurrentCount = count;
					count += this.checkOverLapH(mydlos, count);
					minDLOh = this.nextMaxH(mydlos, minDLOh);

					if (myCurrentCount == count) {
						count++;
					}
				}

			} while (count < mydlos.length);

			DLOs.clear();

			for (final Object dlo : mydlos) {
				((DLO) dlo).anchorsH.clear();
				((DLO) dlo).gridPartsH.clear();
				DLOs.add(dlo);

			}

			this.recheckAreaOfInfluenceH();
		} else {
			if (mydlos == null) {
				mydlos = DLOs.toArray();
				DLOs.clear();
			}
			for (final Object dlo : mydlos) {
				((DLO) dlo).anchorsH.clear();
				((DLO) dlo).gridPartsH.clear();

				((DLO) dlo).masterH = true;
				DLOs.add(dlo);

			}
		}

		return DLOs;
	}

	public DLO calcAnchorH(final int initNoLites, final double resultLiteH,
			final double myThick, final Object dlo, double anchorH,
			final int pos, boolean followHHs) {

		((DLO) dlo).anchorsH.clear();
		((DLO) dlo).gridPartsH.clear();

		((DLO) dlo).bOpeningObject.mullionsH.clear();

		for (int i = 0; i < initNoLites - 1; i++) {
			if (i == 0) {
				anchorH = ((DLO) dlo).highestY + resultLiteH + myThick / 2;
			} else {
				anchorH = anchorH + myThick / 2 + resultLiteH + myThick / 2;
			}

			Collections.sort(hardHs);

			Object[] ancH = hardHs.toArray();
			hardHs.clear();
			for (final Object aw3 : ancH) {
				if (Double.parseDouble(aw3.toString()) >= ((DLO) dlo).highestY
						&& Double.parseDouble(aw3.toString()) <= ((DLO) dlo).lowestY) {
					if (Double.parseDouble(aw3.toString()) < ((DLO) dlo).highestY
							+ ((DLO) dlo).gridRemovalZoneH
							* myScale.doubleValue()
							|| Double.parseDouble(aw3.toString()) > ((DLO) dlo).lowestY
									- ((DLO) dlo).gridRemovalZoneW
									* myScale.doubleValue()) {
						// do not
						// add
					} else {
						addValueToList(hardHs,
								Double.parseDouble(aw3.toString()));
					}
				} else {
					addValueToList(hardHs, Double.parseDouble(aw3.toString()));
				}

			}

			Object[] hHs = hardHs.toArray();
			double minDelta = 1000000;
			for (Object hv : hHs) {
				if (Math.abs(anchorH - Double.parseDouble(hv.toString())) < minDelta) {
					minDelta = Math.abs(anchorH
							- Double.parseDouble(hv.toString()));
				}
			}

			boolean isNewAnchor = true;
			for (Object hv : hHs) {
				if (Math.abs(anchorH - Double.parseDouble(hv.toString())) == minDelta
						&& minDelta < resultLiteH && followHHs) {
					anchorH = Double.parseDouble(hv.toString());
					isNewAnchor = false;
				} else if (!followHHs
						&& anchorH - Double.parseDouble(hv.toString()) == 0) {
					isNewAnchor = false;
				}
			}

			if (anchorH < ((DLO) dlo).highestY + ((DLO) dlo).gridRemovalZoneH
					* myScale.doubleValue()
					|| anchorH > ((DLO) dlo).lowestY
							- ((DLO) dlo).gridRemovalZoneH
							* myScale.doubleValue()) {
				continue;
			} else {

				Profiles grid = new Profiles();

				grid.endTypeLT = 3;
				grid.endTypeRB = 3;

				grid.myFrame2 = myFrame2;
				grid.partForm = 1;
				grid.orientation = 2;
				grid.whichPos = pos;
				grid.partDimB = myThick;
				grid.y1al = grid.y1a = grid.y1 = anchorH + myThick / 2;
				grid.y4al = grid.y4a = grid.y4 = anchorH + myThick / 2;

				grid.y2cl = grid.y2a = grid.y2 = anchorH - myThick / 2;
				grid.y3cl = grid.y3a = grid.y3 = anchorH - myThick / 2;

				double glassToSpacer = 0;
				if (((DLO) dlo).myFrame2.mySeries.getSeriesUom() == 1) {
					glassToSpacer = UOMConvert.getBigDecimalConversion(
							((DLO) dlo).myParentGlass.glassToSpacer,
							myFrame2.metricscale, 1);
				} else {
					glassToSpacer = UOMConvert.getBigDecimalConversion(
							((DLO) dlo).myParentGlass.glassToSpacerImp,
							myFrame2.imperialscale, 1);
				}

				grid.x1al = grid.x1a = grid.x1 = grid.x2cl = grid.x2 = grid.x2a = ((DLO) dlo).myParentGlass.startingX
						+ glassToSpacer;
				grid.x4al = grid.x4a = grid.x4 = grid.x3cl = grid.x3 = grid.x3a = ((DLO) dlo).myParentGlass.bX2
						- glassToSpacer;

				grid.centerXs = ((DLO) dlo).myParentGlass.startingX
						+ glassToSpacer;
				grid.centerXe = ((DLO) dlo).myParentGlass.bX2 - glassToSpacer;

				grid.centerYs = anchorH;
				grid.centerYe = anchorH;
				// grid.length = grid.centerXe - grid.centerXs;

				if (grid.partForm == 1) {
					grid.length = Math
							.sqrt(Math.pow((Math.max(grid.centerXe,
									grid.centerXs) - Math.min(grid.centerXe,
									grid.centerXs)), 2)
									+ Math.pow((Math.max(grid.centerYe,
											grid.centerYs) - Math.min(
											grid.centerYe, grid.centerYs)), 2));
				} else {
					grid.length = 2 * Math.PI * grid.radius1
							* Math.max(grid.endAngle, grid.endAngleA) / 360;
				}

				grid.cOrM = 7;
				grid = doGridsLevels(((DLO) dlo), grid);
				grid.thickness = myThick;
				grid.exists = 1;
				this.doGridPolygon(grid);
				grid.myParent = (DLO) dlo;
				grid.rowCol = i + 1;
				grid.exists = 1;
				grid.startPos = 1;
				grid.endPos = initNoLites;
				grid.isNew = true;
				((DLO) dlo).gridPartsH.add(grid);
				grid.myFrame2 = myFrame2;

				((DLO) dlo).bOpeningObject.mullionsH.add(grid);
				((DLO) dlo).anchorsH.add(anchorH);

				if (isNewAnchor) {
					addValueToList(hardHs, anchorH);
				}

				((DLO) dlo).noGridsH = ((DLO) dlo).anchorsH.size();

				if (((DLO) dlo).myParentO.myGlassMid != null) {
					((DLO) dlo).myParentO.myGlassMid.noGridsH = ((DLO) dlo).anchorsH
							.size();
				}

			}
		}

		return (DLO) dlo;
	}

	public DLO getMaxHOLD(final Object[] mydlos) {

		DLO maxDLO = new DLO(myFrame2);
		double maxH = 0;
		for (final Object d : mydlos) {
			if (((DLO) d).heightPix > maxH) {
				maxDLO = (DLO) d;
				maxH = ((DLO) d).heightPix;

				maxDLO.masterH = true;

				maxDLO.msy = maxDLO.highestY;
				maxDLO.mey = maxDLO.lowestY;
				maxDLO = this.getAreaofInfluenceH(mydlos, maxDLO);
			} else {
				((DLO) d).myMasterH = maxDLO;
			}
		}
		return maxDLO;
	}

	public double nextMaxH(final Object[] mydlos, final double maxDLO) {

		double maxH = maxDLO;
		final Collection restDLO = new ArrayList();

		int count = 0;
		for (final Object dlo : mydlos) {
			if (!((DLO) dlo).masterH) {
				restDLO.add(dlo);
				count++;
			}
		}
		final Object[] myrest = restDLO.toArray();

		for (final Object d : myrest) {
			int myDLOH = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOH = ((DLO) d).heightM;
			} else {
				myDLOH = ((DLO) d).heightI;
			}

			if (myDLOH > maxH) {
				maxH = myDLOH;
			}
		}
		return maxH;
	}

	public double nextMinH(final Object[] mydlos, final double maxDLO) {

		double minH = maxDLO;
		final Collection restDLO = new ArrayList();

		int count = 0;
		for (final Object dlo : mydlos) {
			if (!((DLO) dlo).masterH) {
				restDLO.add(dlo);
				count++;
			}
		}
		final Object[] myrest = restDLO.toArray();

		for (final Object d : myrest) {
			int myDLOH = 0;
			if (myFrame2.mySeries.getSeriesUom() == 1) {
				myDLOH = ((DLO) d).heightM;
			} else {
				myDLOH = ((DLO) d).heightI;
			}

			if (myDLOH < minH) {
				minH = myDLOH;
			}
		}
		return minH;
	}

	public int checkOverLapH(final Object[] mydlos, final int count) {

		int addtoCount = 0;
		for (final Object ooo : mydlos) {
			if (((DLO) ooo).masterH) {

				if (!((DLO) mydlos[count]).equals(ooo)) {
					if (((DLO) mydlos[count]).highestY >= ((DLO) ooo).msy
							&& ((DLO) mydlos[count]).lowestY <= ((DLO) ooo).mey) {
						((DLO) mydlos[count]).masterH = false;
						((DLO) mydlos[count]).myMasterH = (DLO) ooo;
						((DLO) mydlos[count]).msy = 0;
						((DLO) mydlos[count]).mey = 0;
						addtoCount++;
					}
				}

			}

		}
		return addtoCount;
	}

	public Collection getMyMasterH() {

		int addtoCount = 0;
		final Object[] mydlos = DLOs.toArray();

		for (final Object ooo : mydlos) {
			if (((DLO) ooo).masterH) {
				DLOs.clear();
				for (final Object o : mydlos) {
					if (!((DLO) o).equals(ooo)) {

						if (((DLO) o).highestY >= ((DLO) ooo).msy
								&& ((DLO) o).lowestY <= ((DLO) ooo).mey
								&& ((DLO) ooo).shapeID == 1) {
							((DLO) o).masterH = false;
							((DLO) o).myMasterH = (DLO) ooo;
							((DLO) o).msy = 0;
							((DLO) o).mey = 0;
							addtoCount++;
						} else if (((DLO) o).highestY >= ((DLO) ooo).msy
								- ((DLO) ooo).myParent.top1Part.partDimB
								&& ((DLO) o).lowestY <= ((DLO) ooo).mey
										+ ((DLO) ooo).myParent.bot1Part.partDimB
								&& ((DLO) ooo).shapeID != 1) {
							((DLO) o).masterH = false;
							((DLO) o).myMasterH = (DLO) ooo;
							((DLO) o).msy = 0;
							((DLO) o).mey = 0;
							addtoCount++;
						}

					}
					DLOs.add(o);
				}

			}

		}
		return DLOs;
	}

	public void changeMasterH() {

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				((DLO) dlo).masterH = true;
				((DLO) dlo).anchorsV.clear();
				((DLO) dlo).gridPartsV.clear();

				((DLO) dlo).gridPartsH.clear();
				this.getAreaofInfluenceH(mydlos, ((DLO) dlo));
			} else if (((DLO) dlo).masterH
					&& ((DLO) dlo).msy <= selectedDLO.highestY
					&& ((DLO) dlo).mey >= selectedDLO.lowestY) {
				((DLO) dlo).masterH = false;
				((DLO) dlo).anchorsV.clear();

				((DLO) dlo).gridPartsV.clear();
				((DLO) dlo).gridPartsH.clear();
			}

			DLOs.add(dlo);
		}
		this.setAnchorsWInMaster();
		this.setAnchorsHInMaster();
		this.getMyMasterW();
		this.getMyMasterH();

		mydlos = DLOs.toArray();
		DLOs.clear();

		this.setAnchorsWInSlave(whichPos, mydlos);
		this.setAnchorsHInSlave(whichPos, mydlos);

		for (final Object dlo : mydlos) {
			((DLO) dlo).yRows = 1;
			((DLO) dlo).xCols = 1;
			((DLO) dlo).gridPartsS.clear();

			DLOs.add(this.createGridPartsMid((DLO) dlo));
		}

		this.setAllDLOsMid(false);

	}

	public void equalizeH() {

		final int initNoLites = selectedDLO.noGridsH + 1;

		final double myThick = selectedDLO.gridThick * myScale.doubleValue();
		final double totalThick = selectedDLO.noGridsH * myThick;
		final double resultLiteH = (selectedDLO.heightPix - totalThick)
				/ initNoLites;
		final double anchorH = selectedDLO.highestY;

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				((DLO) dlo).anchorsH = new ArrayList();

				((DLO) dlo).gridPartsH = new ArrayList();

				dlo = this.calcAnchorH(initNoLites, resultLiteH, myThick, dlo,
						anchorH, whichPos, false);

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}

		}

		this.setAllDLOsMid(true);

	}

	public void changeHDimOLD(final int pos, final Collection dim) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				final Object[] s = dim.toArray();
				((DLO) dlo).openings.toArray();
				Object[] ahs = ((DLO) dlo).anchorsH.toArray();
				((DLO) dlo).anchorsH.clear();

				final Object[] ghs = ((DLO) dlo).bOpeningObject.mullionsH
						.toArray();
				((DLO) dlo).bOpeningObject.mullionsH.clear();
				final double myThick = ((DLO) dlo).gridThick
						* myScale.doubleValue();

				for (final Object gh : ghs) {
					if (((Profiles) gh).rowCol == 1) {
						for (final Object ss : s) {
							if (((Profiles) gh).rowCol == ((TextFieldLeft) ss).endRowCol) {

								if (((TextFieldLeft) ss).mod > 0
										&& s.length > 2) {

									((DLO) dlo).anchorsH
											.add(((TextFieldLeft) ss).pos
													+ ((TextFieldLeft) ss).newSize
													+ myThick / 2);
								} else if (s.length == 2) {
									((DLO) dlo).anchorsH
											.add(((TextFieldLeft) ss).pos
													+ ((TextFieldLeft) ss).newSize
													+ myThick / 2);
								} else {
									((DLO) dlo).anchorsH
											.add(((Profiles) gh).centerYs);
								}
								break;
							}
						}
					} else if (((Profiles) gh).rowCol > 1
							&& ((Profiles) gh).rowCol + 1 < ((DLO) dlo).yRows) {
						for (final Object ss : s) {
							if (((Profiles) gh).rowCol == ((TextFieldLeft) ss).endRowCol) {

								if (((TextFieldLeft) ss).mod > 0) {

									((DLO) dlo).anchorsH
											.add(((TextFieldLeft) ss).pos
													+ ((TextFieldLeft) ss).newSize
													+ myThick / 2);
								} else {
									((DLO) dlo).anchorsH
											.add(((Profiles) gh).centerYs);
								}
								break;
							}
						}
					} else if (((Profiles) gh).rowCol + 1 == ((DLO) dlo).yRows) {
						for (final Object ss : s) {
							if (((Profiles) gh).rowCol == ((TextFieldLeft) ss).endRowCol - 1) {

								if (((TextFieldLeft) ss).mod > 0) {

									((DLO) dlo).anchorsH
											.add(((TextFieldLeft) ss).pose
													- ((TextFieldLeft) ss).newSize
													- myThick / 2);
								} else {
									((DLO) dlo).anchorsH
											.add(((Profiles) gh).centerYs);
								}
								break;
							}
						}
					}

				}

				ahs = ((DLO) dlo).anchorsH.toArray();

				((DLO) dlo).gridPartsH.clear();

				for (int i = 0; i < ahs.length; i++) {

					Profiles grid = new Profiles();
					grid.partForm = 1;
					grid.orientation = 2;
					grid.whichPos = whichPos;
					grid.partDimB = myThick;
					grid.y1al = grid.y1 = grid.y4al = grid.y4 = Double
							.parseDouble(ahs[i].toString()) + myThick / 2;
					grid.y2cl = grid.y2 = grid.y3cl = grid.y3 = Double
							.parseDouble(ahs[i].toString()) - myThick / 2;
					grid.x1al = grid.x1 = grid.x2cl = grid.x2 = ((DLO) dlo).startingX;
					grid.x4al = grid.x4 = grid.x3cl = grid.x3 = ((DLO) dlo).bX2;

					grid.centerXs = ((DLO) dlo).startingX;

					grid.centerXe = ((DLO) dlo).bX2;

					grid.centerYs = Double.parseDouble(ahs[i].toString());
					grid.centerYe = Double.parseDouble(ahs[i].toString());
					grid.length = grid.centerXe - grid.centerXs;
					grid.cOrM = 7;
					grid = doGridsLevels(((DLO) dlo), grid);
					grid.thickness = myThick;
					this.doGridPolygon(grid);
					grid.myParent = (DLO) dlo;
					grid.rowCol = i + 1;
					grid.exists = 1;
					grid.startPos = 1;
					grid.endPos = ((DLO) dlo).xCols;
					grid.isNew = true;
					((DLO) dlo).gridPartsH.add(grid);
					grid.myFrame2 = myFrame2;

					((DLO) dlo).bOpeningObject.mullionsH.add(grid);
				}

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}

		}

		this.setAllDLOsMid(true);

	}

	public void changeVDim(final int pos, final Collection dim) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {

				dlo = doChangeVDims(dim, dlo);

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}

		}

		this.setAllDLOsMid(true);

	}

	public DLO doChangeVDims(final Collection dim, final Object dlo) {

		final Object[] s = dim.toArray();

		((DLO) dlo).openings.toArray();
		final int noAnchors = ((DLO) dlo).anchorsV.size();

		// final Object[] ahs =
		// ((DLO) dlo).anchorsV
		// .toArray();

		((DLO) dlo).anchorsV.clear();

		final Object[] gridParts = ((DLO) dlo).bOpeningObject.mullions
				.toArray();
		// ((DLO) dlo).gridPartsV
		// .toArray();

		((DLO) dlo).gridPartsV.clear();

		((DLO) dlo).bOpeningObject.mullions.clear();

		((DLO) dlo).gridPartsH.clear();

		((DLO) dlo).gridPartsH.addAll(((DLO) dlo).bOpeningObject.mullionsH);

		double myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

		Grids myGrid = myFrame2.getApplicationBaseRules().getGrids(
				((DLO) dlo).gridID);
		if (((DLO) dlo).remote) {
			myGrid = ItemFrame.getApplicationRemoteBaseRules().getGrids(
					((DLO) dlo).supplierId, ((DLO) dlo).gridID);
		}

		double thick = 0;
		double mythick = 0;
		if (myFrame2.currentUOM == 1) {
			thick = myGrid.getThickness();
		} else {
			thick = myGrid.getThicknessImp();
		}

		mythick = thick * myFrame2.scale.doubleValue();

		double anchorW = 0;
		for (int i = 0; i < noAnchors; i++) {
			for (final Object ss : s) {
				if (i + 1 == ((TextFieldTop) ss).endRowCol) {
					if (i == 0) {
						anchorW = ((DLO) dlo).startingX
								+ ((TextFieldTop) ss).newSize + myThick / 2;

					} else {
						anchorW = anchorW + myThick / 2
								+ ((TextFieldTop) ss).newSize + myThick / 2;
					}

					if (anchorW < ((DLO) dlo).startingX
							+ ((DLO) dlo).gridRemovalZoneW
							* myScale.doubleValue()
							|| anchorW > ((DLO) dlo).bX2
									- ((DLO) dlo).gridRemovalZoneW
									* myScale.doubleValue()) {
						continue;
					}
				}
			}

			((DLO) dlo).anchorsV.add(anchorW);
			double delta = 0;
			for (final Object gp : gridParts) {
				if (((Profiles) gp).rowCol == i + 1) {

					delta = anchorW - ((Profiles) gp).centerXs;

					((Profiles) gp).centerXs = ((Profiles) gp).centerXs + delta;

					((Profiles) gp).centerXe = ((Profiles) gp).centerXe + delta;

					((Profiles) gp).x1al = ((Profiles) gp).x1a = ((Profiles) gp).x1 = ((Profiles) gp).x1
							+ delta;

					((Profiles) gp).x4al = ((Profiles) gp).x4a = ((Profiles) gp).x4 = ((Profiles) gp).x4
							+ delta;

					((Profiles) gp).x2cl = ((Profiles) gp).x2a = ((Profiles) gp).x2 = ((Profiles) gp).x2
							+ delta;

					((Profiles) gp).x3cl = ((Profiles) gp).x3a = ((Profiles) gp).x3 = ((Profiles) gp).x3
							+ delta;

					((DLO) dlo).gridPartsV.add(gp);

				}

			}

		}

		return (DLO) dlo;
	}

	public void changeHDim(final int pos, final Collection dim) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				dlo = doChangeHDims(dim, dlo);

				DLOs.add(this.createGridPartsMid((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}

		}

		this.setAllDLOsMid(true);

	}

	public DLO doChangeHDims(final Collection dim, final Object dlo) {

		final Object[] s = dim.toArray();

		final int noAnchors = ((DLO) dlo).anchorsH.size();

		((DLO) dlo).anchorsH.clear();

		final Object[] gridParts = ((DLO) dlo).bOpeningObject.mullionsH
				.toArray();

		((DLO) dlo).gridPartsH.clear();

		((DLO) dlo).bOpeningObject.mullionsH.clear();

		((DLO) dlo).gridPartsV.clear();

		((DLO) dlo).gridPartsV.addAll(((DLO) dlo).bOpeningObject.mullions);

		double myThick = ((DLO) dlo).gridThick * myScale.doubleValue();

		Grids myGrid = myFrame2.getApplicationBaseRules().getGrids(
				((DLO) dlo).gridID);
		double thick = 0;
		double mythick = 0;
		if (myFrame2.currentUOM == 1) {
			thick = myGrid.getThickness();
		} else {
			thick = myGrid.getThicknessImp();
		}

		mythick = thick * myFrame2.scale.doubleValue();
		double anchorH = 0;
		for (int i = 0; i < noAnchors; i++) {
			for (final Object ss : s) {
				if (i + 1 == ((TextFieldLeft) ss).endRowCol) {
					if (i == 0) {
						anchorH = ((DLO) dlo).highestY
								+ ((TextFieldLeft) ss).newSize + myThick / 2;

					} else {
						anchorH = anchorH + myThick / 2
								+ ((TextFieldLeft) ss).newSize + myThick / 2;
					}

					if (anchorH < ((DLO) dlo).highestY
							+ ((DLO) dlo).gridRemovalZoneH
							* myScale.doubleValue()
							|| anchorH > ((DLO) dlo).lowestY
									- ((DLO) dlo).gridRemovalZoneH
									* myScale.doubleValue()) {
						continue;
					}
				}
			}

			((DLO) dlo).anchorsH.add(anchorH);
			double delta = 0;
			for (final Object gp : gridParts) {
				if (((Profiles) gp).rowCol == i + 1) {

					delta = anchorH - ((Profiles) gp).centerYs;

					((Profiles) gp).centerYs = ((Profiles) gp).centerYs + delta;

					((Profiles) gp).centerYe = ((Profiles) gp).centerYe + delta;

					((Profiles) gp).y1al = ((Profiles) gp).y1a = ((Profiles) gp).y1 = ((Profiles) gp).y1
							+ delta;

					((Profiles) gp).y4al = ((Profiles) gp).y4a = ((Profiles) gp).y4 = ((Profiles) gp).y4
							+ delta;

					((Profiles) gp).y2cl = ((Profiles) gp).y2a = ((Profiles) gp).y2 = ((Profiles) gp).y2
							+ delta;

					((Profiles) gp).y3cl = ((Profiles) gp).y3a = ((Profiles) gp).y3 = ((Profiles) gp).y3
							+ delta;

					((DLO) dlo).gridPartsH.add(gp);

				}

			}

		}

		return (DLO) dlo;
	}

	public DLO getAreaofInfluenceH(final Object[] mydlos, final DLO myDLO) {

		myDLO.msy = myDLO.highestY;
		myDLO.mey = myDLO.lowestY;

		for (final Object oo : mydlos) {
			if (!((DLO) oo).equals(myDLO)) {
				if (((DLO) oo).lowestY <= myDLO.lowestY
						&& ((DLO) oo).lowestY >= myDLO.highestY
						&& ((DLO) oo).highestY < myDLO.highestY) {
					if (myDLO.shapeID == 1) {
						myDLO.msy = ((DLO) oo).highestY;
					} else {
						myDLO.msy = ((DLO) oo).highestY
								- ((DLO) oo).myParent.top1Part.partDimB;
					}
				}
			}
		}

		for (final Object oo : mydlos) {
			if (!((DLO) oo).equals(myDLO)) {
				if (((DLO) oo).highestY >= myDLO.highestY
						&& ((DLO) oo).highestY < myDLO.lowestY
						&& ((DLO) oo).lowestY > myDLO.lowestY) {
					if (myDLO.shapeID == 1) {

						myDLO.mey = ((DLO) oo).lowestY;
					} else {
						myDLO.mey = ((DLO) oo).lowestY
								+ ((DLO) oo).myParent.bot1Part.partDimB;
					}
				}
			}
		}

		return myDLO;
	}

	public void recheckAreaOfInfluenceH() {

		Object[] mydlos;
		mydlos = DLOs.toArray();
		DLOs.clear();
		for (final Object o : mydlos) {
			if (((DLO) o).masterH) {
				for (final Object oo : mydlos) {
					if (!((DLO) oo).equals(o)) {
						if (((DLO) oo).lowestY < ((DLO) oo).lowestY
								&& ((DLO) oo).lowestY > ((DLO) oo).highestY
								&& ((DLO) oo).highestY < ((DLO) oo).highestY) {
							if (((DLO) o).shapeID == 1) {
								((DLO) o).msy = ((DLO) oo).highestY;
							} else {
								((DLO) o).msy = ((DLO) oo).highestY
										- ((DLO) oo).myParent.top1Part.partDimB;
							}
						}
					}
				}
				for (final Object oo : mydlos) {
					if (!((DLO) oo).equals(o)) {
						if (((DLO) oo).highestY > ((DLO) o).highestY
								&& ((DLO) oo).highestY < ((DLO) o).lowestY
								&& ((DLO) oo).lowestY > ((DLO) o).lowestY) {
							if (((DLO) o).shapeID == 1) {
								((DLO) o).mey = ((DLO) oo).lowestY;
							} else {
								((DLO) o).mey = ((DLO) oo).lowestY
										+ ((DLO) oo).myParent.bot1Part.partDimB;
								;
							}
						}
					}
				}
			}
			DLOs.add(o);
		}

		mydlos = DLOs.toArray();

		DLOs.clear();
		for (final Object o : mydlos) {
			if (((DLO) o).masterH) {
				DLOs.clear();
				for (final Object oo : mydlos) {
					if (!((DLO) oo).equals(o)) {
						if (((DLO) oo).highestY >= ((DLO) o).msy
								&& ((DLO) oo).lowestY <= ((DLO) o).mey) {
							((DLO) oo).masterH = false;
						}
					}
					DLOs.add(oo);
				}

			}

		}
	}

	public void checkMasterInGridsOLD(final int xxx, final int yyy) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		new Point2D.Double(xxx, yyy);
		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				final Object[] ps = ((DLO) dlo).gridPartsV.toArray();
				((DLO) dlo).gridPartsV.clear();

				for (final Object p : ps) {
					if (((Profiles) p).gp.contains(xxx, yyy)) {

						myFrame2.dim.masterSelected.setSelected(true);
						myFrame2.myMaster = p;
						myFrame2.myMasterType = 7;
						myFrame2.jobItem.myCanvas.masterFound = true;

						myFrame2.myMaster = p;
						myFrame2.myMasterType = 7;
						((Profiles) p).profileSelected = 1;
					}
					((DLO) dlo).gridPartsV.add(p);
				}

				((DLO) dlo).bOpeningObject = ((DLO) dlo)
						.doMullions(((DLO) dlo).bOpeningObject);
				DLOs.add(this.createGridPartsMidAlign((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}
		}

		this.setAllDLOsMid(true);
	}

	public void checkMasterInGrids(final int xxx, final int yyy) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		new Point2D.Double(xxx, yyy);
		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				final Object[] ps = ((DLO) dlo).bOpeningObject.mullions
						.toArray();

				((DLO) dlo).bOpeningObject.mullions.clear();

				for (final Object p : ps) {
					if (((Profiles) p).x1a <= xxx && ((Profiles) p).x3a >= xxx
							&& ((Profiles) p).y1a <= yyy
							&& ((Profiles) p).y3a >= yyy) {

						myFrame2.dim.masterSelected.setSelected(true);
						myFrame2.myMaster = p;
						myFrame2.myMasterType = 7;
						myFrame2.jobItem.myCanvas.masterFound = true;

						myFrame2.myMaster = p;
						myFrame2.myMasterType = 7;
						((Profiles) p).profileSelected = 1;
					}

					((DLO) dlo).bOpeningObject.mullions.add(p);
				}

				DLOs.add(dlo);
			} else {
				DLOs.add(dlo);
			}
		}

		this.setAllDLOsMid(true);
	}

	public void checkMasterInGridsHOLD(final int xxx, final int yyy) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		new Point2D.Double(xxx, yyy);
		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				final Object[] ps = ((DLO) dlo).gridPartsH.toArray();
				((DLO) dlo).gridPartsH.clear();

				for (final Object p : ps) {
					if (((Profiles) p).gp.contains(xxx, yyy)) {

						myFrame2.dim.masterSelected.setSelected(true);
						myFrame2.myMaster = p;
						myFrame2.myMasterType = 7;
						myFrame2.jobItem.myCanvas.masterFound = true;

						myFrame2.myMaster = p;
						myFrame2.myMasterType = 7;
						((Profiles) p).profileSelected = 1;
					}
					((DLO) dlo).gridPartsH.add(p);
				}

				// dlo =
				// this
				// .doMullionsFromPartsH(dlo);
				// DLOs.add(dlo);
				DLOs.add(this.createGridPartsMidAlign((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}
		}

		this.setAllDLOsMid(true);
	}

	public void checkMasterInGridsH(final int xxx, final int yyy) {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		new Point2D.Double(xxx, yyy);
		for (final Object dlo : mydlos) {
			if (((DLO) dlo).startingX == selectedDLO.startingX
					&& ((DLO) dlo).bX2 == selectedDLO.bX2
					&& ((DLO) dlo).startingY == selectedDLO.startingY
					&& ((DLO) dlo).bY2 == selectedDLO.bY2
					&& ((DLO) dlo).bX3 == selectedDLO.bX3
					&& ((DLO) dlo).bY3 == selectedDLO.bY3
					&& ((DLO) dlo).bX4 == selectedDLO.bX4
					&& ((DLO) dlo).bY4 == selectedDLO.bY4) {
				final Object[] ps = ((DLO) dlo).bOpeningObject.mullionsH
						.toArray();

				((DLO) dlo).bOpeningObject.mullionsH.clear();

				for (final Object p : ps) {
					if (((Profiles) p).x1a <= xxx && ((Profiles) p).x3a >= xxx
							&& ((Profiles) p).y1a >= yyy
							&& ((Profiles) p).y3a <= yyy) {

						myFrame2.dim.masterSelected.setSelected(true);

						myFrame2.myMasterType = 7;
						myFrame2.jobItem.myCanvas.masterFound = true;

						((Profiles) p).profileSelected = 1;
						myFrame2.myMaster = p;

					}

					((DLO) dlo).bOpeningObject.mullionsH.add(p);
				}

				DLOs.add(dlo);
			} else {
				DLOs.add(dlo);
			}
		}

		this.setAllDLOsMid(true);
	}

	public Collection getPotenitalVGrid(final Profiles myMaster, final int pos) {

		final Collection myGridsV = new ArrayList();

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {

			final Object[] gridsV = ((DLO) dlo).bOpeningObject.mullions
					.toArray();

			for (final Object V : gridsV) {
				if (((Profiles) V).isValid && ((Profiles) V).potentialS) {
					myGridsV.add(V);

				}

			}

			// }
		}

		return myGridsV;

	}

	public Collection getPotenitalHGrid(final Profiles myMaster, final int pos) {

		final Collection myGridsH = new ArrayList();

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {

			final Object[] gridsH = ((DLO) dlo).bOpeningObject.mullionsH
					.toArray();

			for (final Object H : gridsH) {
				if (((Profiles) H).isValid && ((Profiles) H).potentialS) {
					myGridsH.add(H);

				}

			}

		}

		return myGridsH;

	}

	public void findPotentialVGrid(final Profiles myMaster, final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {

			if (((DLO) dlo).startingX < Math.min(myMaster.centerXs,
					myMaster.centerXe)
					&& ((DLO) dlo).bX2 > Math.max(myMaster.centerXs,
							myMaster.centerXe)) {
				Object[] myVGrids = ((DLO) dlo).bOpeningObject.mullions
						.toArray();
				((DLO) dlo).bOpeningObject.mullions.clear();

				for (final Object V : myVGrids) {
					if (((Profiles) V).isValid
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
					((Profiles) V).myFrame2 = myFrame2;

					((DLO) dlo).bOpeningObject.mullions.add(V);
				}

				myVGrids = ((DLO) dlo).bOpeningObject.mullions.toArray();
				((DLO) dlo).bOpeningObject.mullions.clear();

				double myDeltaL = 10000;
				double myDeltaR = 10000;
				for (final Object V2 : myVGrids) {
					// Overall

					if (((Profiles) V2).profileSelected != 1) {
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

						if (((Profiles) V2).centerXs == myMaster.centerXs) {
							myDeltaR = 0;
							myDeltaL = 0;
						}
					}
					((Profiles) V2).myFrame2 = myFrame2;

					((DLO) dlo).bOpeningObject.mullions.add(V2);
				}

				myVGrids = ((DLO) dlo).bOpeningObject.mullions.toArray();
				((DLO) dlo).bOpeningObject.mullions.clear();

				for (final Object V2 : myVGrids) {
					if (((Profiles) V2).centerXe == myMaster.centerXs
							|| ((Profiles) V2).centerXs == myMaster.centerXe) {

						((Profiles) V2).potentialS = false;

					}

					if (((Profiles) V2).centerYe <= myMaster.centerYe
							&& ((Profiles) V2).centerYs >= myMaster.centerYs) {

						((Profiles) V2).potentialS = false;

					}
					if (((Profiles) V2).centerXs < myMaster.centerXs) {

						if (((Profiles) V2).delta != myDeltaL) {
							((Profiles) V2).potentialS = false;
						}

					}

					if (((Profiles) V2).centerXs > myMaster.centerXs) {
						if (((Profiles) V2).delta != myDeltaR) {
							((Profiles) V2).potentialS = false;
						}
					}
					((Profiles) V2).myFrame2 = myFrame2;

					((DLO) dlo).bOpeningObject.mullions.add(V2);
				}

				DLOs.add(dlo);
			}
		}// For DLOs

		mydlos = DLOs.toArray();

		for (Object dlo : mydlos) {

			final Object[] myVGrids = ((DLO) dlo).bOpeningObject.mullions
					.toArray();

			for (final Object V : myVGrids) {
				if (((Profiles) V).potentialS) {
					myFrame2.foundPotential = true;
					break;
				}
			}

		}

		this.setAllDLOsMid(false);

	}

	public void findPotentialHGrid(final Profiles myMaster, final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {

			if (((DLO) dlo).highestY < Math.min(myMaster.centerYs,
					myMaster.centerYe)
					&& ((DLO) dlo).lowestY > Math.max(myMaster.centerYs,
							myMaster.centerYe)) {

				Object[] myVGrids = ((DLO) dlo).bOpeningObject.mullionsH
						.toArray();
				((DLO) dlo).bOpeningObject.mullionsH.clear();

				for (Object V : myVGrids) {

					if (((Profiles) V).isValid
							&& ((Profiles) V).profileSelected != 1
							&& (((Profiles) V).centerXe < myMaster.centerXs || ((Profiles) V).centerXs > myMaster.centerXe)
							&& ((Profiles) V).centerYs == ((Profiles) V).centerYe) {

						((Profiles) V).potentialS = true;

						if (((Profiles) V).centerYs < myMaster.centerYs) {
							((Profiles) V).delta = myMaster.centerYs
									- ((Profiles) V).centerYs;
						}

						if (((Profiles) V).centerYs > myMaster.centerYs) {
							((Profiles) V).delta = ((Profiles) V).centerYs
									- myMaster.centerYs;
						}

					}
					((Profiles) V).myFrame2 = myFrame2;

					((DLO) dlo).bOpeningObject.mullionsH.add(V);
				}

				myVGrids = ((DLO) dlo).bOpeningObject.mullionsH.toArray();
				((DLO) dlo).bOpeningObject.mullionsH.clear();

				double myDeltaL = 10000;
				double myDeltaR = 10000;
				for (final Object V2 : myVGrids) {
					// Overall

					if (((Profiles) V2).profileSelected != 1) {
						if (((Profiles) V2).centerYs < myMaster.centerYs) {

							if (((Profiles) V2).delta < myDeltaL) {
								myDeltaL = ((Profiles) V2).delta;
							}

						}

						if (((Profiles) V2).centerYs > myMaster.centerYs) {
							if (((Profiles) V2).delta < myDeltaR) {
								myDeltaR = ((Profiles) V2).delta;
							}
						}

						if (((Profiles) V2).centerYs == myMaster.centerYs) {
							myDeltaR = 0;
							myDeltaL = 0;
						}
					}
					((Profiles) V2).myFrame2 = myFrame2;
					((DLO) dlo).bOpeningObject.mullionsH.add(V2);
				}

				myVGrids = ((DLO) dlo).bOpeningObject.mullionsH.toArray();
				((DLO) dlo).bOpeningObject.mullionsH.clear();

				for (Object V2 : myVGrids) {

					if (((Profiles) V2).centerYe == myMaster.centerYs
							|| ((Profiles) V2).centerYs == myMaster.centerYe) {
						((Profiles) V2).potentialS = false;
					}

					if (((Profiles) V2).centerYe <= myMaster.centerYe
							&& ((Profiles) V2).centerXe <= myMaster.centerXe
							&& ((Profiles) V2).centerXe >= myMaster.centerXs
							|| ((Profiles) V2).centerXs <= myMaster.centerXe
							&& ((Profiles) V2).centerXs >= myMaster.centerXs) {
						((Profiles) V2).potentialS = false;
					}

					if (((Profiles) V2).centerYs < myMaster.centerYs) {
						if (((Profiles) V2).delta != myDeltaL) {
							((Profiles) V2).potentialS = false;
						}
					}

					if (((Profiles) V2).centerYs > myMaster.centerYs) {
						if (((Profiles) V2).delta != myDeltaR) {
							((Profiles) V2).potentialS = false;
						}
					}

					((Profiles) V2).myFrame2 = myFrame2;

					((DLO) dlo).bOpeningObject.mullionsH.add(V2);
				}

				DLOs.add(dlo);
			}
		}// For DLOs

		mydlos = DLOs.toArray();

		for (final Object dlo : mydlos) {

			final Object[] myVGrids = ((DLO) dlo).bOpeningObject.mullionsH
					.toArray();

			for (final Object V : myVGrids) {
				if (((Profiles) V).potentialS) {
					myFrame2.foundPotential = true;
					break;
				}
			}

		}

		this.setAllDLOsMid(false);

	}

	public void getSelectedVGrid(final int xxx, final int yyy, final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {
			final Object[] myVGrids = ((DLO) dlo).bOpeningObject.mullions
					.toArray();
			((DLO) dlo).bOpeningObject.mullions.clear();

			for (final Object V : myVGrids) {
				if (((Profiles) V).potentialS
						&& ((Profiles) V).poly.contains(xxx, yyy)) {
					myFrame2.alignSeq = 2;
					myFrame2.dim.slaveSelected.setSelected(true);

					myFrame2.mySlave = V;
					myFrame2.mySlaveType = ((Profiles) V).cOrM;

					myFrame2.mySlaveFrame = ((DLO) ((Profiles) V).myParent).myParentO.myParent.a_sequenceID;

					myFrame2.slave = ((DLO) ((Profiles) V).myParent).myParentO.myParent;

					((Profiles) V).profileSelected = 2;

					if (((Profiles) V).centerYs > ((Profiles) myFrame2.myMaster).centerYe) {
						myDesign.myLine.moveTo(
								((Profiles) myFrame2.myMaster).centerXs,
								((Profiles) myFrame2.myMaster).centerYs);
						myDesign.myLine
								.lineTo(((Profiles) myFrame2.myMaster).centerXe,
										((Profiles) myFrame2.myMaster).centerYe
												+ (((Profiles) V).centerYs - ((Profiles) myFrame2.myMaster).centerYe)
												/ 2);
						myDesign.myLine
								.lineTo(((Profiles) V).centerXs,
										((Profiles) myFrame2.myMaster).centerYe
												+ (((Profiles) V).centerYs - ((Profiles) myFrame2.myMaster).centerYe)
												/ 2);
						myDesign.myLine.lineTo(((Profiles) V).centerXs,
								((Profiles) V).centerYs);
						myFrame2.masterAboveLeft = true;

					} else if (((Profiles) V).centerYe < ((Profiles) myFrame2.myMaster).centerYs) {
						myDesign.myLine.moveTo(
								((Profiles) myFrame2.myMaster).centerXe,
								((Profiles) myFrame2.myMaster).centerYe);
						myDesign.myLine
								.lineTo(((Profiles) myFrame2.myMaster).centerXs,
										((Profiles) myFrame2.myMaster).centerYs
												+ (((Profiles) V).centerYe - ((Profiles) myFrame2.myMaster).centerYs)
												/ 2);
						myDesign.myLine
								.lineTo(((Profiles) V).centerXe,
										((Profiles) myFrame2.myMaster).centerYs
												+ (((Profiles) V).centerYe - ((Profiles) myFrame2.myMaster).centerYs)
												/ 2);
						myDesign.myLine.lineTo(((Profiles) V).centerXe,
								((Profiles) V).centerYe);
						myFrame2.masterAboveLeft = false;

					}

				}
				((DLO) dlo).bOpeningObject.mullions.add(V);
			}

			DLOs.add(dlo);

		}

		this.setAllDLOsMid(false);
	}

	public void getSelectedHGrid(final int xxx, final int yyy, final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {
			final Object[] myVGrids = ((DLO) dlo).bOpeningObject.mullionsH
					.toArray();
			((DLO) dlo).bOpeningObject.mullionsH.clear();

			for (final Object M : myVGrids) {
				if (((Profiles) M).potentialS
						&& ((Profiles) M).poly.contains(xxx, yyy)) {
					myFrame2.alignSeq = 2;
					myFrame2.dim.slaveSelected.setSelected(true);
					((Profiles) M).profileSelected = 2;
					myFrame2.mySlave = M;
					myFrame2.mySlaveType = ((Profiles) M).cOrM;

					myFrame2.mySlaveFrame = ((DLO) ((Profiles) M).myParent).myParentO.myParent.a_sequenceID;

					myFrame2.slave = ((DLO) ((Profiles) M).myParent).myParentO.myParent;

					if (((Profiles) M).centerXs > ((Profiles) myFrame2.myMaster).centerXe) {
						myDesign.myLine.moveTo(
								((Profiles) myFrame2.myMaster).centerXs,
								((Profiles) myFrame2.myMaster).centerYs);
						myDesign.myLine
								.lineTo(((Profiles) myFrame2.myMaster).centerXe
										+ (((Profiles) M).centerXs - ((Profiles) myFrame2.myMaster).centerXe)
										/ 2,
										((Profiles) myFrame2.myMaster).centerYe);
						myDesign.myLine
								.lineTo(((Profiles) myFrame2.myMaster).centerXe
										+ (((Profiles) M).centerXs - ((Profiles) myFrame2.myMaster).centerXe)
										/ 2, ((Profiles) M).centerYs);
						myDesign.myLine.lineTo(((Profiles) M).centerXs,
								((Profiles) M).centerYs);
						myFrame2.masterAboveLeft = true;

					} else if (((Profiles) M).centerXe < ((Profiles) myFrame2.myMaster).centerXs) {
						myDesign.myLine.moveTo(
								((Profiles) myFrame2.myMaster).centerXe,
								((Profiles) myFrame2.myMaster).centerYe);
						myDesign.myLine
								.lineTo(((Profiles) myFrame2.myMaster).centerXs
										- (((Profiles) M).centerXe - ((Profiles) myFrame2.myMaster).centerXs)
										/ 2,
										((Profiles) myFrame2.myMaster).centerYs);
						myDesign.myLine
								.lineTo(((Profiles) myFrame2.myMaster).centerXs
										- (((Profiles) M).centerXe - ((Profiles) myFrame2.myMaster).centerXs)
										/ 2, ((Profiles) M).centerYe);
						myDesign.myLine.lineTo(((Profiles) M).centerXe,
								((Profiles) M).centerYe);
						myFrame2.masterAboveLeft = false;

					}

				}
				((DLO) dlo).bOpeningObject.mullionsH.add(M);
			}

			DLOs.add(dlo);

		}

		this.setAllDLOsMid(false);
	}

	public void changeVGridPos(final double newX, final Profiles myGrid,
			final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == myGrid.myParent.startingX
					&& ((DLO) dlo).bX2 == myGrid.myParent.bX2
					&& ((DLO) dlo).startingY == myGrid.myParent.startingY
					&& ((DLO) dlo).bY2 == myGrid.myParent.bY2
					&& ((DLO) dlo).bX3 == myGrid.myParent.bX3
					&& ((DLO) dlo).bY3 == myGrid.myParent.bY3
					&& ((DLO) dlo).bX4 == myGrid.myParent.bX4
					&& ((DLO) dlo).bY4 == myGrid.myParent.bY4) {

				dlo = doChangeVGridPos(newX, myGrid, dlo);
				dlo = this.createGridPartsMid((DLO) dlo);

				DLOs.add(dlo);

				// DLOs.add(this.createGridPartsMidAlign((DLO) dlo));

			} else {
				DLOs.add(dlo);
			}

		}

		if (pos == 1) {
			this.setAllDLOsIn();
		} else if (pos == 2) {
			this.setAllDLOsMid(false);
		} else if (pos == 3) {
			this.setAllDLOsOut();
		}

	}

	public DLO doChangeVGridPos(final double newX, final Profiles myGrid,
			final Object dlo) {

		BigDecimal oX = new BigDecimal(String.valueOf(myGrid.centerXs));

		final Object[] myVAnchors =

		((DLO) dlo).anchorsV.toArray();
		((DLO) dlo).anchorsV.clear();
		final Object[] myVGrids = ((DLO) dlo).gridPartsV.toArray();

		((DLO) dlo).gridPartsV.clear();

		for (final Object V : myVAnchors) {
			BigDecimal mX = new BigDecimal(V.toString());
			if (mX.equals(oX)) {
				((DLO) dlo).anchorsV.add(newX);
			} else {
				((DLO) dlo).anchorsV.add(V);
			}
		}

		Object[] myMasksV = ((DLO) dlo).gridMasksV.toArray();

		((DLO) dlo).gridMasksV.clear();

		for (final Object V : myVGrids) {
			BigDecimal mX = new BigDecimal(
					String.valueOf(((Profiles) V).centerXs));
			if (mX.equals(oX)) {
				((Profiles) V).gp.reset();
				((Profiles) V).poly.reset();

				((Profiles) V).centerXs = newX;
				((Profiles) V).centerXe = newX;

				((Profiles) V).x1 = ((Profiles) V).x1al = ((Profiles) V).x1a = ((Profiles) V).x4 = ((Profiles) V).x4al = ((Profiles) V).x4a = ((Profiles) V).centerXe
						- ((Profiles) V).thickness / 2;
				((Profiles) V).x2 = ((Profiles) V).x2cl = ((Profiles) V).x2a = ((Profiles) V).x3 = ((Profiles) V).x3cl = ((Profiles) V).x3a = ((Profiles) V).centerXe
						+ ((Profiles) V).thickness / 2;

				final Polygon m = new Polygon();

				m.addPoint((int) ((Profiles) V).x1al, (int) ((Profiles) V).y1al);
				m.addPoint((int) ((Profiles) V).x2cl, (int) ((Profiles) V).y2cl);
				m.addPoint((int) ((Profiles) V).x3cl, (int) ((Profiles) V).y3cl);
				m.addPoint((int) ((Profiles) V).x4al, (int) ((Profiles) V).y4al);
				m.addPoint((int) ((Profiles) V).x1al, (int) ((Profiles) V).y1al);

				((Profiles) V).gp.append(m, false);
				((Profiles) V).poly = m;

			}
			((DLO) dlo).gridMasksV.add(V);

			((DLO) dlo).gridPartsV.add(V);

		}

		return (DLO) dlo;
	}

	public void resetSelectedGrids(final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (final Object dlo : mydlos) {

			final Object[] gridsV = ((DLO) dlo).bOpeningObject.mullions
					.toArray();

			((DLO) dlo).bOpeningObject.mullions.clear();

			final Object[] gridsH = ((DLO) dlo).bOpeningObject.mullionsH
					.toArray();

			((DLO) dlo).bOpeningObject.mullionsH.clear();

			for (final Object V : gridsV) {

				((Profiles) V).potentialS = false;
				((Profiles) V).profileSelected = 0;

				((DLO) dlo).bOpeningObject.mullions.add(V);

			}
			for (final Object H : gridsH) {
				((Profiles) H).potentialS = false;
				((Profiles) H).profileSelected = 0;
				((DLO) dlo).bOpeningObject.mullionsH.add(H);

			}

		}

	}

	public void changeHGridPos(final double newX, final Profiles myGrid,
			final int pos) {

		if (pos == 1) {
			this.getDLOsIn();
		} else if (pos == 2) {
			this.getDLOsMid(0);
		} else if (pos == 3) {
			this.getDLOsOut();
		}

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();

		for (Object dlo : mydlos) {
			if (((DLO) dlo).startingX == myGrid.myParent.startingX
					&& ((DLO) dlo).bX2 == myGrid.myParent.bX2
					&& ((DLO) dlo).startingY == myGrid.myParent.startingY
					&& ((DLO) dlo).bY2 == myGrid.myParent.bY2
					&& ((DLO) dlo).bX3 == myGrid.myParent.bX3
					&& ((DLO) dlo).bY3 == myGrid.myParent.bY3
					&& ((DLO) dlo).bX4 == myGrid.myParent.bX4
					&& ((DLO) dlo).bY4 == myGrid.myParent.bY4) {

				dlo = doChangeHGridPos(newX, myGrid, dlo);
				dlo = createGridPartsMid(((DLO) dlo));

				DLOs.add(dlo);

				// DLOs.add(this.createGridPartsMidAlign((DLO) dlo));
			} else {
				DLOs.add(dlo);
			}
		}

		if (pos == 1) {
			this.setAllDLOsIn();
		} else if (pos == 2) {
			this.setAllDLOsMid(false);
		} else if (pos == 3) {
			this.setAllDLOsOut();
		}

	}

	public DLO doChangeHGridPos(final double newX, final Profiles myGrid,
			final Object dlo) {

		final Object[] myVAnchors = ((DLO) dlo).anchorsH.toArray();

		((DLO) dlo).anchorsH.clear();

		final Object[] myVGrids = ((DLO) dlo).gridPartsH.toArray();

		((DLO) dlo).gridPartsH.clear();

		for (final Object V : myVAnchors) {
			if (Double.parseDouble(V.toString()) == myGrid.centerYs) {
				((DLO) dlo).anchorsH.add(newX);
			} else {
				((DLO) dlo).anchorsH.add(V);
			}

		}

		for (final Object V : myVGrids) {
			if (((Profiles) V).centerYs == myGrid.centerYs) {

				((Profiles) V).gp.reset();
				((Profiles) V).poly.reset();

				((Profiles) V).centerYs = newX;
				((Profiles) V).centerYe = newX;

				((Profiles) V).y1 = ((Profiles) V).y1al = ((Profiles) V).y1a = ((Profiles) V).y4 = ((Profiles) V).y4al = ((Profiles) V).y4a = ((Profiles) V).centerYe
						+ ((Profiles) V).thickness / 2;
				((Profiles) V).y2 = ((Profiles) V).y2cl = ((Profiles) V).y2a = ((Profiles) V).y3 = ((Profiles) V).y3cl = ((Profiles) V).y3a = ((Profiles) V).centerYe
						- ((Profiles) V).thickness / 2;

				final Polygon m = new Polygon();

				m.addPoint((int) ((Profiles) V).x1al, (int) ((Profiles) V).y1al);
				m.addPoint((int) ((Profiles) V).x2cl, (int) ((Profiles) V).y2cl);
				m.addPoint((int) ((Profiles) V).x3cl, (int) ((Profiles) V).y3cl);
				m.addPoint((int) ((Profiles) V).x4al, (int) ((Profiles) V).y4al);
				m.addPoint((int) ((Profiles) V).x1al, (int) ((Profiles) V).y1al);

				((Profiles) V).gp.append(m, false);
				((Profiles) V).poly = m;

			}

			((DLO) dlo).gridPartsH.add(V);

		}

		return (DLO) dlo;
	}

	public void cloneParts(final OpeningObject mySashType2,
			final BkgrdOpeningObject original) {

		mySashType2.top1 = (Top1Object) mySashType2.top1
				.cloneProfile(original.top1Part);
		mySashType2.top2 = (Top2Object) mySashType2.top2
				.cloneProfile(original.top2Part);
		mySashType2.top3 = (Top3Object) mySashType2.top3
				.cloneProfile(original.top3Part);

		mySashType2.bot1 = (Bot1Object) mySashType2.bot1
				.cloneProfile(original.bot1Part);
		mySashType2.bot2 = (Bot2Object) mySashType2.bot2
				.cloneProfile(original.bot2Part);
		mySashType2.bot3 = (Bot3Object) mySashType2.bot3
				.cloneProfile(original.bot3Part);

		mySashType2.left = (LeftObject) mySashType2.left
				.cloneProfile(original.leftPart);
		mySashType2.right = (RightObject) mySashType2.right
				.cloneProfile(original.rightPart);

		mySashType2.top1Part = (Profiles) mySashType2.top1Part
				.cloneProfile(original.top1Part);
		mySashType2.top2Part = (Profiles) mySashType2.top2Part
				.cloneProfile(original.top2Part);
		mySashType2.top3Part = (Profiles) mySashType2.top3Part
				.cloneProfile(original.top3Part);
		mySashType2.bot1Part = (Profiles) mySashType2.bot1Part
				.cloneProfile(original.bot1Part);
		mySashType2.bot2Part = (Profiles) mySashType2.bot2Part
				.cloneProfile(original.bot2Part);
		mySashType2.bot3Part = (Profiles) mySashType2.bot3Part
				.cloneProfile(original.bot3Part);
		mySashType2.leftPart = (Profiles) mySashType2.leftPart
				.cloneProfile(original.leftPart);
		mySashType2.rightPart = (Profiles) mySashType2.rightPart
				.cloneProfile(original.rightPart);
	}

	public void executeGridPartRules(DLO dlo) {

		// ************************************************************
		// Execute Rules
		// ************************************************************

		// Verticals
		Object[] gridsV = dlo.bOpeningObject.mullions.toArray();
		for (Object grid : gridsV) {
			calcGridLength((Profiles) grid);

			((Profiles) grid).executeRulesMethod("Grid Profile");
			((Profiles) grid).executePartRules(true);
		}

		Object[] gridsH = dlo.bOpeningObject.mullionsH.toArray();
		for (Object grid : gridsH) {
			calcGridLength((Profiles) grid);

			((Profiles) grid).executeRulesMethod("Grid Profile");
			((Profiles) grid).executePartRules(true);
		}

		Object[] gridsS = dlo.gridPartsS.toArray();
		for (Object grid : gridsS) {
			calcGridLength((Profiles) grid);

			((Profiles) grid).executeRulesMethod("Grid Profile");
			((Profiles) grid).executePartRules(true);
		}

		Object[] gridsHub = dlo.gridPartsH.toArray();
		for (Object grid : gridsHub) {

			calcGridLength((Profiles) grid);

			if (((Profiles) grid).partForm > 1) {
				((Profiles) grid).executeRulesMethod("Grid Profile");
				((Profiles) grid).executePartRules(true);
			}
		}

		this.buildConnectors(dlo);

	}

	public void clearDLOs() {

		final Object[] mydlos = DLOs.toArray();
		DLOs.clear();
		for (final Object dlo : mydlos) {
			((DLO) dlo).anchorsH.clear();
			((DLO) dlo).anchorsV.clear();
			((DLO) dlo).gridPartsH.clear();
			((DLO) dlo).gridPartsV.clear();
			((DLO) dlo).gridPartsS.clear();

			((DLO) dlo).hasGrids = false;

			((DLO) dlo).msx = 0;
			((DLO) dlo).mex = 0;
			((DLO) dlo).msy = 0;
			((DLO) dlo).mey = 0;
			((DLO) dlo).masterW = false;
			((DLO) dlo).masterH = false;

			((DLO) dlo).hasGrids = false;

			((DLO) dlo).gridID = 0;

			((DLO) dlo).gridType = 0;
			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.gridType = 0;
				((DLO) dlo).myParentO.myGlassMid.gridID = 0;
			}

			((DLO) dlo).gridForm = 0;

			((DLO) dlo).anchorsV = new ArrayList();
			((DLO) dlo).anchorsH = new ArrayList();
			((DLO) dlo).anchorsS = new ArrayList();

			((DLO) dlo).gridMasksV = new ArrayList();
			((DLO) dlo).gridMasksH = new ArrayList();
			((DLO) dlo).gridMasksS = new ArrayList();

			((DLO) dlo).gridThick = 0;
			((DLO) dlo).continuity = 0;
			((DLO) dlo).idealGW = 0;
			((DLO) dlo).idealGH = 0;
			((DLO) dlo).maxGW = 0;
			((DLO) dlo).maxGH = 0;
			((DLO) dlo).minGW = 0;
			((DLO) dlo).minGH = 0;
			((DLO) dlo).gridRemovalZoneW = 0;
			((DLO) dlo).gridRemovalZoneH = 0;
			((DLO) dlo).liteW = 0;
			((DLO) dlo).liteH = 0;
			((DLO) dlo).myMasterH = null;
			((DLO) dlo).myMasterW = null;

			((DLO) dlo).perimeterV = 0;
			((DLO) dlo).perimeterH = 0;

			((DLO) dlo).noGridsV = 0;
			((DLO) dlo).noGridsH = 0;

			((DLO) dlo).noGridsS = 0;
			((DLO) dlo).noGridsR = 0;

			if (((DLO) dlo).myParentO.myGlassMid != null) {
				((DLO) dlo).myParentO.myGlassMid.noGridsV = 0;
				((DLO) dlo).myParentO.myGlassMid.noGridsH = 0;

				((DLO) dlo).myParentO.myGlassMid.noGridsS = 0;
				((DLO) dlo).myParentO.myGlassMid.noGridsR = 0;
			}

			DLOs.add(dlo);
		}
	}

	public Profiles doGridPolygon(Profiles myNewMullion) {

		Polygon m = new Polygon();

		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		m.addPoint((int) myNewMullion.x2a, (int) myNewMullion.y2a);
		m.addPoint((int) myNewMullion.x3a, (int) myNewMullion.y3a);
		m.addPoint((int) myNewMullion.x4a, (int) myNewMullion.y4a);
		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);

		myNewMullion.gp.reset();
		myNewMullion.poly.reset();
		myNewMullion.gp.append(m, false);
		myNewMullion.poly = m;
		return myNewMullion;
	}

	public Profiles doGridPolygonInHub(final Profiles myNewMullion) {

		final Polygon m = new Polygon();

		m.addPoint((int) myNewMullion.x1a, (int) myNewMullion.y1a);
		m.addPoint((int) myNewMullion.x2a, (int) myNewMullion.y2a);
		m.addPoint((int) myNewMullion.x4a, (int) myNewMullion.y4a);
		m.addPoint((int) myNewMullion.x3a, (int) myNewMullion.y3a);
		// m.addPoint((int) myNewMullion.x1a,
		// (int) myNewMullion.y1a);

		myNewMullion.gp.reset();
		myNewMullion.poly.reset();
		myNewMullion.gp.append(m, false);
		myNewMullion.poly = m;
		return myNewMullion;
	}

	public void verifyLimitLRV(final Profiles myMullion, final DLO dlo,
			final int start, final int end, final double cX,
			final Object[] myHs, final Object[] myVs, final AddMullionV mV) {

		this.getLimitingObjectsV(dlo,
				start,//
				end, //

				myMullion.x1al + (myMullion.x4al - myMullion.x1al) / 2, myHs,
				myVs, mV);

		myMullion.posCondition = mV.posCondition;
		mV.newAlpha = 0;//
		mV.newAlpha2 = 0;
		mV.newAlpha3 = 0;
		mV.newAlphaA = 0;
		mV.newAlphaC = 0;

		// mV.newAlphaF = 0;
		// mV.newAlpha2F = 0;
		// mV.newAlpha3F = 0;
		// mV.newAlphaAF = 0;
		// mV.newAlphaCF = 0;

		mV.myThetaBot = 0;//
		mV.myThetaBot2 = 0;
		mV.myThetaBot3 = 0;
		mV.myThetaBotA = 0;
		mV.myThetaBotC = 0;

		// mV.myThetaBotF = 0;
		// mV.myThetaBot2F = 0;
		// mV.myThetaBot3F = 0;
		// mV.myThetaBotAF = 0;
		// mV.myThetaBotCF = 0;
		mV.inArchStart = 0;
		mV.inArchEnd = 0;

		final double myMinX = Math.min(dlo.myParentGlass.startingX,
				dlo.myParentGlass.bX4);

		if (dlo.shapeID != 10 || dlo.radius1 > 0 || dlo.noSidesTop > 1
				|| dlo.noSidesBot > 1 && myMullion.posCondition <= 3) {

			if (myMullion.x2cl <= myMinX + dlo.dimA1 && dlo.noSidesTop == 1
					&& dlo.myParentO.lean == 2 && !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.leftPart.startXA;
				mV.limitStartYsA = dlo.myParentGlass.leftPart.startYA;
				mV.limitStartXeA = dlo.myParentGlass.leftPart.endXA;
				mV.limitStartYeA = dlo.myParentGlass.leftPart.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.leftPart.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.leftPart.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.leftPart.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.leftPart.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.leftPart.startXC;
				mV.limitStartYsB = dlo.myParentGlass.leftPart.startYC;
				mV.limitStartXeB = dlo.myParentGlass.leftPart.endXC;
				mV.limitStartYeB = dlo.myParentGlass.leftPart.endYC;

				mV.dimTM = dlo.myParentGlass.leftPart.partDimM;
				mV.dimTA = dlo.myParentGlass.leftPart.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimA1);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimA1);
				mV.limitStart = dlo.myParentGlass.leftPart;

			}

			if (myMullion.x1al < myMinX + dlo.dimA0 && dlo.noSidesTop == 1
					&& dlo.myParentO.lean == 3 && !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.leftPart.startXA;
				mV.limitStartYsA = dlo.myParentGlass.leftPart.startYA;
				mV.limitStartXeA = dlo.myParentGlass.leftPart.endXA;
				mV.limitStartYeA = dlo.myParentGlass.leftPart.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.leftPart.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.leftPart.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.leftPart.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.leftPart.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.leftPart.startXC;
				mV.limitStartYsB = dlo.myParentGlass.leftPart.startYC;
				mV.limitStartXeB = dlo.myParentGlass.leftPart.endXC;
				mV.limitStartYeB = dlo.myParentGlass.leftPart.endYC;

				mV.dimTM = dlo.myParentGlass.leftPart.partDimM;
				mV.dimTA = dlo.myParentGlass.leftPart.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimA0);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimA0);
				mV.limitStart = dlo.myParentGlass.leftPart;

			}
			if (myMullion.x1al > myMinX + dlo.dimA1 + dlo.dimA0
					&& dlo.noSidesTop == 1 && dlo.myParentO.lean == 3
					&& !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.rightPart.startXA;
				mV.limitStartYsA = dlo.myParentGlass.rightPart.startYA;
				mV.limitStartXeA = dlo.myParentGlass.rightPart.endXA;
				mV.limitStartYeA = dlo.myParentGlass.rightPart.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.rightPart.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.rightPart.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.rightPart.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.rightPart.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.rightPart.startXC;
				mV.limitStartYsB = dlo.myParentGlass.rightPart.startYC;
				mV.limitStartXeB = dlo.myParentGlass.rightPart.endXC;
				mV.limitStartYeB = dlo.myParentGlass.rightPart.endYC;

				mV.dimTM = dlo.myParentGlass.rightPart.partDimM;
				mV.dimTA = dlo.myParentGlass.rightPart.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimA2);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimA2);
				mV.limitStart = dlo.myParentGlass.rightPart;

			}
			if (myMullion.x1al > myMinX + dlo.dimA1 && dlo.noSidesTop == 1
					&& dlo.myParentO.lean == 1 && !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.rightPart.startXA;
				mV.limitStartYsA = dlo.myParentGlass.rightPart.startYA;
				mV.limitStartXeA = dlo.myParentGlass.rightPart.endXA;
				mV.limitStartYeA = dlo.myParentGlass.rightPart.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.rightPart.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.rightPart.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.rightPart.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.rightPart.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.rightPart.startXC;
				mV.limitStartYsB = dlo.myParentGlass.rightPart.startYC;
				mV.limitStartXeB = dlo.myParentGlass.rightPart.endXC;
				mV.limitStartYeB = dlo.myParentGlass.rightPart.endYC;

				mV.dimTM = dlo.myParentGlass.rightPart.partDimM;
				mV.dimTA = dlo.myParentGlass.rightPart.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimA2);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimA2);
				mV.limitStart = dlo.myParentGlass.rightPart;

			}

			// ////////
			if (myMullion.x3cl < myMinX + dlo.dimC2 && dlo.noSidesBot == 1
					&& (dlo.myParentO.lean3 == 1 || dlo.myParentO.lean3 == 3)
					&& (!mV.startIn || !mV.endIn)) {
				mV.limitEndXsA = dlo.myParentGlass.leftPart.startXA;
				mV.limitEndYsA = dlo.myParentGlass.leftPart.startYA;
				mV.limitEndXeA = dlo.myParentGlass.leftPart.endXA;
				mV.limitEndYeA = dlo.myParentGlass.leftPart.endYA;
				mV.limitEndXsBA = dlo.myParentGlass.leftPart.startXBA;
				mV.limitEndYsBA = dlo.myParentGlass.leftPart.startYBA;
				mV.limitEndXeBA = dlo.myParentGlass.leftPart.endXBA;
				mV.limitEndYeBA = dlo.myParentGlass.leftPart.endYBA;

				mV.limitEndXsB = dlo.myParentGlass.leftPart.startXC;
				mV.limitEndYsB = dlo.myParentGlass.leftPart.startYC;
				mV.limitEndXeB = dlo.myParentGlass.leftPart.endXC;
				mV.limitEndYeB = dlo.myParentGlass.leftPart.endYC;

				mV.dimBM = dlo.myParentGlass.leftPart.partDimM;
				mV.dimBA = dlo.myParentGlass.leftPart.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimC2);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimC2);
				mV.limitStart = dlo.myParentGlass.leftPart;

			}
			if (myMullion.x4al > myMinX + dlo.dimC2 && dlo.noSidesBot == 1
					&& dlo.myParentO.lean3 == 1 && !mV.endIn) {
				mV.limitEndXsA = dlo.myParentGlass.rightPart.startXA;
				mV.limitEndYsA = dlo.myParentGlass.rightPart.startYA;
				mV.limitEndXeA = dlo.myParentGlass.rightPart.endXA;
				mV.limitEndYeA = dlo.myParentGlass.rightPart.endYA;
				mV.limitEndXsBA = dlo.myParentGlass.rightPart.startXBA;
				mV.limitEndYsBA = dlo.myParentGlass.rightPart.startYBA;
				mV.limitEndXeBA = dlo.myParentGlass.rightPart.endXBA;
				mV.limitEndYeBA = dlo.myParentGlass.rightPart.endYBA;

				mV.limitEndXsB = dlo.myParentGlass.rightPart.startXC;
				mV.limitEndYsB = dlo.myParentGlass.rightPart.startYC;
				mV.limitEndXeB = dlo.myParentGlass.rightPart.endXC;
				mV.limitEndYeB = dlo.myParentGlass.rightPart.endYC;

				mV.dimBM = dlo.myParentGlass.rightPart.partDimM;
				mV.dimBA = dlo.myParentGlass.rightPart.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimC1);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimC1);
				mV.limitStart = dlo.myParentGlass.rightPart;

			}
			if (myMullion.x4al > myMinX + dlo.dimC2 + dlo.dimC1
					&& dlo.noSidesBot == 1 && dlo.myParentO.lean3 == 3
					&& !mV.endIn) {
				mV.limitEndXsA = dlo.myParentGlass.rightPart.startXA;
				mV.limitEndYsA = dlo.myParentGlass.rightPart.startYA;
				mV.limitEndXeA = dlo.myParentGlass.rightPart.endXA;
				mV.limitEndYeA = dlo.myParentGlass.rightPart.endYA;
				mV.limitEndXsBA = dlo.myParentGlass.rightPart.startXBA;
				mV.limitEndYsBA = dlo.myParentGlass.rightPart.startYBA;
				mV.limitEndXeBA = dlo.myParentGlass.rightPart.endXBA;
				mV.limitEndYeBA = dlo.myParentGlass.rightPart.endYBA;

				mV.limitEndXsB = dlo.myParentGlass.rightPart.startXC;
				mV.limitEndYsB = dlo.myParentGlass.rightPart.startYC;
				mV.limitEndXeB = dlo.myParentGlass.rightPart.endXC;
				mV.limitEndYeB = dlo.myParentGlass.rightPart.endYC;

				mV.dimBM = dlo.myParentGlass.rightPart.partDimM;
				mV.dimBA = dlo.myParentGlass.rightPart.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.heightPix
						/ dlo.myParentGlass.dimC0);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.heightPix
				// / dlo.dimC0);
				mV.limitStart = dlo.myParentGlass.rightPart;

			}

			// /////////

			if (myMullion.x2cl < myMinX + dlo.dimA1 && dlo.noSidesTop > 1
					&& !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.top1Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.top1Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.top1Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.top1Part.endYC;

				mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.dimA1
						/ dlo.myParentGlass.dimD2);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.dimA1
				// / dlo.dimD2);
				mV.limitStart = dlo.myParentGlass.top1Part;

			}
			if (myMullion.x1al > myMinX + dlo.dimA1 + dlo.dimA3
					&& dlo.noSidesTop > 1 && !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.top2Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.top2Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.top2Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.top2Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.top2Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.top2Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.top2Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.top2Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.top2Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.top2Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.top2Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.top2Part.endYC;

				mV.dimTM = dlo.myParentGlass.top2Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top2Part.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.dimA2
						/ dlo.myParentGlass.dimB1);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.dimA2
				// / dlo.dimB1);
				mV.limitStart = dlo.myParentGlass.top2Part;

			}
			// /////
			if (myMullion.x3cl < myMinX + dlo.dimC2 && dlo.noSidesBot > 1
					&& !mV.endIn) {
				mV.limitEndXsA = dlo.myParentGlass.bot2Part.endXA;
				mV.limitEndYsA = dlo.myParentGlass.bot2Part.endYA;
				mV.limitEndXeA = dlo.myParentGlass.bot2Part.startXA;
				mV.limitEndYeA = dlo.myParentGlass.bot2Part.startYA;
				mV.limitEndXsBA = dlo.myParentGlass.bot2Part.endXBA;
				mV.limitEndYsBA = dlo.myParentGlass.bot2Part.endYBA;
				mV.limitEndXeBA = dlo.myParentGlass.bot2Part.startXBA;
				mV.limitEndYeBA = dlo.myParentGlass.bot2Part.startYBA;

				mV.limitEndXsB = dlo.myParentGlass.bot2Part.endXC;
				mV.limitEndYsB = dlo.myParentGlass.bot2Part.endYC;
				mV.limitEndXeB = dlo.myParentGlass.bot2Part.startXC;
				mV.limitEndYeB = dlo.myParentGlass.bot2Part.startYC;

				mV.dimBM = dlo.myParentGlass.bot2Part.partDimM;
				mV.dimBA = dlo.myParentGlass.bot2Part.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.dimC2
						/ dlo.myParentGlass.dimD0);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.dimC2
				// / dlo.dimD0);
				mV.limitEnd = dlo.myParentGlass.bot2Part;

			}
			if (myMullion.x4al > myMinX + dlo.dimC2 + dlo.dimC1
					&& dlo.noSidesBot > 1 && !mV.endIn) {
				mV.limitEndXsA = dlo.myParentGlass.bot1Part.endXA;
				mV.limitEndYsA = dlo.myParentGlass.bot1Part.endYA;
				mV.limitEndXeA = dlo.myParentGlass.bot1Part.startXA;
				mV.limitEndYeA = dlo.myParentGlass.bot1Part.startYA;
				mV.limitEndXsBA = dlo.myParentGlass.bot1Part.endXBA;
				mV.limitEndYsBA = dlo.myParentGlass.bot1Part.endYBA;
				mV.limitEndXeBA = dlo.myParentGlass.bot1Part.startXBA;
				mV.limitEndYeBA = dlo.myParentGlass.bot1Part.startYBA;

				mV.limitEndXsB = dlo.myParentGlass.bot1Part.endXC;
				mV.limitEndYsB = dlo.myParentGlass.bot1Part.endYC;
				mV.limitEndXeB = dlo.myParentGlass.bot1Part.startXC;
				mV.limitEndYeB = dlo.myParentGlass.bot1Part.startYC;

				mV.dimBM = dlo.myParentGlass.bot1Part.partDimM;
				mV.dimBA = dlo.myParentGlass.bot1Part.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.dimC0
						/ dlo.myParentGlass.dimB2);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.dimC0
				// / dlo.dimB2);
				mV.limitEnd = dlo.myParentGlass.bot1Part;

			}
			if (myMullion.x4al > myMinX + dlo.dimC2
					&& myMullion.x3cl < myMinX + dlo.dimC2 + dlo.dimC1
					&& dlo.noSidesBot > 1 && !mV.endIn) {
				mV.limitEndXsA = dlo.myParentGlass.bot3Part.endXA;
				mV.limitEndYsA = dlo.myParentGlass.bot3Part.endYA;
				mV.limitEndXeA = dlo.myParentGlass.bot3Part.startXA;
				mV.limitEndYeA = dlo.myParentGlass.bot3Part.startYA;
				mV.limitEndXsBA = dlo.myParentGlass.bot3Part.endXBA;
				mV.limitEndYsBA = dlo.myParentGlass.bot3Part.endYBA;
				mV.limitEndXeBA = dlo.myParentGlass.bot3Part.startXBA;
				mV.limitEndYeBA = dlo.myParentGlass.bot3Part.startYBA;

				mV.limitEndXsB = dlo.myParentGlass.bot3Part.endXC;
				mV.limitEndYsB = dlo.myParentGlass.bot3Part.endYC;
				mV.limitEndXeB = dlo.myParentGlass.bot3Part.startXC;
				mV.limitEndYeB = dlo.myParentGlass.bot3Part.startYC;

				mV.dimBM = dlo.myParentGlass.bot3Part.partDimM;
				mV.dimBA = dlo.myParentGlass.bot3Part.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.dimC0
						/ dlo.myParentGlass.dimB2);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.dimC0
				// / dlo.dimB2);
				mV.limitEnd = dlo.myParentGlass.bot3Part;

			}

			if (myMullion.centerXs == myMinX + dlo.dimA1 && dlo.noSidesTop > 1
					&& !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.top1Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.top1Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.top1Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.top1Part.endYC;

				mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.dimA1
						/ dlo.myParentGlass.dimD2);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.dimA1
				// / dlo.dimD2);

				mV.limitStartXsAm = dlo.myParentGlass.top2Part.startXA;
				mV.limitStartYsAm = dlo.myParentGlass.top2Part.startYA;
				mV.limitStartXeAm = dlo.myParentGlass.top2Part.endXA;
				mV.limitStartYeAm = dlo.myParentGlass.top2Part.endYA;
				mV.limitStartXsBAm = dlo.myParentGlass.top2Part.startXBA;
				mV.limitStartYsBAm = dlo.myParentGlass.top2Part.startYBA;
				mV.limitStartXeBAm = dlo.myParentGlass.top2Part.endXBA;
				mV.limitStartYeBAm = dlo.myParentGlass.top2Part.endYBA;

				mV.limitStartXsBm = dlo.myParentGlass.top2Part.startXC;
				mV.limitStartYsBm = dlo.myParentGlass.top2Part.startYC;
				mV.limitStartXeBm = dlo.myParentGlass.top2Part.endXC;
				mV.limitStartYeBm = dlo.myParentGlass.top2Part.endYC;

				mV.dimTM = dlo.myParentGlass.top2Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top2Part.partDimA;
				mV.newAlpha2 = Math.atan(dlo.myParentGlass.dimA2
						/ dlo.myParentGlass.dimB1);
				// mV.newAlpha2F =
				// Math
				// .atan(dlo.dimA2
				// / dlo.dimB1);
				// inMiddle = true;
				mV.limitStart = dlo.myParentGlass.top1Part;
				mV.limitStart2 = dlo.myParentGlass.top2Part;

			}

			if (myMullion.x2cl < myMinX + dlo.dimA1 + dlo.dimA3
					&& myMullion.x1al > myMinX + dlo.dimA1
					&& dlo.noSidesTop == 3 && !mV.startIn) {
				mV.limitStartXsA = dlo.myParentGlass.top3Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.top3Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.top3Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.top3Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.top3Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.top3Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.top3Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.top3Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.top3Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.top3Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.top3Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.top3Part.endYC;

				mV.dimTM = dlo.myParentGlass.top3Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top3Part.partDimA;
				mV.newAlpha = 0;
				// mV.newAlphaF = 0;
				mV.limitStart = dlo.myParentGlass.top3Part;

			}

			// ///
			if (dlo.shapeID == 700) {
				mV.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.top1Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.top1Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.top1Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.top1Part.endYC;

				mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.widthPix
						/ dlo.myParentGlass.dimD2);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.widthPix
				// / dlo.dimD2);
				mV.limitStart = dlo.myParentGlass.top1Part;

			} else if (dlo.shapeID == 701) {
				mV.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.top1Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.top1Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.top1Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.top1Part.endYC;

				mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
				mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.widthPix
						/ dlo.myParentGlass.dimB1);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.widthPix
				// / dlo.dimB1);
				mV.limitStart = dlo.myParentGlass.top1Part;

			} else if (dlo.shapeID == 702) {
				if (myMullion.x1al < myMinX + dlo.dimD2) {
					mV.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
					mV.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
					mV.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
					mV.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
					mV.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
					mV.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
					mV.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
					mV.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;

					mV.limitStartXsB = dlo.myParentGlass.top1Part.startXC;
					mV.limitStartYsB = dlo.myParentGlass.top1Part.startYC;
					mV.limitStartXeB = dlo.myParentGlass.top1Part.endXC;
					mV.limitStartYeB = dlo.myParentGlass.top1Part.endYC;

					mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
					mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
					mV.newAlpha = Math.atan(dlo.myParentGlass.widthPix
							/ dlo.myParentGlass.dimD2);
					// mV.newAlphaF =
					// Math
					// .atan(dlo.myParentGlass.widthPix
					// / dlo.dimD2);
					mV.limitStart = dlo.myParentGlass.top1Part;

				}
				if (myMullion.x2cl > myMinX + dlo.dimD2) {
					mV.limitStartXsA = dlo.myParentGlass.bot1Part.endXA;
					mV.limitStartYsA = dlo.myParentGlass.bot1Part.endYA;
					mV.limitStartXeA = dlo.myParentGlass.bot1Part.startXA;
					mV.limitStartYeA = dlo.myParentGlass.bot1Part.startYA;
					mV.limitStartXsBA = dlo.myParentGlass.bot1Part.endXBA;
					mV.limitStartYsBA = dlo.myParentGlass.bot1Part.endYBA;
					mV.limitStartXeBA = dlo.myParentGlass.bot1Part.startXBA;
					mV.limitStartYeBA = dlo.myParentGlass.bot1Part.startYBA;

					mV.limitStartXsB = dlo.myParentGlass.bot1Part.endXC;
					mV.limitStartYsB = dlo.myParentGlass.bot1Part.endYC;
					mV.limitStartXeB = dlo.myParentGlass.bot1Part.startXC;
					mV.limitStartYeB = dlo.myParentGlass.bot1Part.startYC;

					mV.dimTM = dlo.myParentGlass.bot1Part.partDimM;
					mV.dimTA = dlo.myParentGlass.bot1Part.partDimA;
					mV.newAlpha = Math.atan(dlo.myParentGlass.widthPix
							/ dlo.myParentGlass.dimD0);
					// mV.newAlphaF =
					// Math
					// .atan(dlo.widthPix
					// / dlo.dimD0);
					mV.limitEnd = dlo.myParentGlass.bot1Part;

				}

			} else if (dlo.shapeID == 703) {
				if (myMullion.x1al < myMinX + dlo.dimB0) {
					mV.limitEndXsA = dlo.myParentGlass.top1Part.startXA;
					mV.limitEndYsA = dlo.myParentGlass.top1Part.startYA;
					mV.limitEndXeA = dlo.myParentGlass.top1Part.endXA;
					mV.limitEndYeA = dlo.myParentGlass.top1Part.endYA;
					mV.limitEndXsBA = dlo.myParentGlass.top1Part.startXBA;
					mV.limitEndYsBA = dlo.myParentGlass.top1Part.startYBA;
					mV.limitEndXeBA = dlo.myParentGlass.top1Part.endXBA;
					mV.limitEndYeBA = dlo.myParentGlass.top1Part.endYBA;

					mV.limitEndXsB = dlo.myParentGlass.top1Part.startXC;
					mV.limitEndYsB = dlo.myParentGlass.top1Part.startYC;
					mV.limitEndXeB = dlo.myParentGlass.top1Part.endXC;
					mV.limitEndYeB = dlo.myParentGlass.top1Part.endYC;

					mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
					mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
					mV.myThetaBot = Math.atan(dlo.myParentGlass.widthPix
							/ dlo.myParentGlass.dimB0);
					// mV.myThetaBotF =
					// Math
					// .atan(dlo.widthPix
					// / dlo.dimB0);
					mV.limitStart = dlo.myParentGlass.top1Part;

				}
				if (myMullion.x2cl > myMinX + dlo.dimB0) {
					mV.limitEndXsA = dlo.myParentGlass.bot1Part.endXA;
					mV.limitEndYsA = dlo.myParentGlass.bot1Part.endYA;
					mV.limitEndXeA = dlo.myParentGlass.bot1Part.startXA;
					mV.limitEndYeA = dlo.myParentGlass.bot1Part.startYA;
					mV.limitEndXsBA = dlo.myParentGlass.bot1Part.endXBA;
					mV.limitEndYsBA = dlo.myParentGlass.bot1Part.endYBA;
					mV.limitEndXeBA = dlo.myParentGlass.bot1Part.startXBA;
					mV.limitEndYeBA = dlo.myParentGlass.bot1Part.startYBA;

					mV.limitEndXsB = dlo.myParentGlass.bot1Part.endXC;
					mV.limitEndYsB = dlo.myParentGlass.bot1Part.endYC;
					mV.limitEndXeB = dlo.myParentGlass.bot1Part.startXC;
					mV.limitEndYeB = dlo.myParentGlass.bot1Part.startYC;

					mV.dimTM = dlo.myParentGlass.bot1Part.partDimM;
					mV.dimTA = dlo.myParentGlass.bot1Part.partDimA;
					mV.myThetaBot = Math.atan(dlo.myParentGlass.widthPix
							/ dlo.myParentGlass.dimB2);
					// mV.myThetaBotF =
					// Math
					// .atan(dlo.widthPix
					// / dlo.dimB2);
					mV.limitEnd = dlo.myParentGlass.bot1Part;

				}

			} else if (dlo.shapeID == 704) {

			} else if (dlo.shapeID == 705) {
				mV.limitStartXsA = dlo.myParentGlass.bot1Part.startXA;
				mV.limitStartYsA = dlo.myParentGlass.bot1Part.startYA;
				mV.limitStartXeA = dlo.myParentGlass.bot1Part.endXA;
				mV.limitStartYeA = dlo.myParentGlass.bot1Part.endYA;
				mV.limitStartXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mV.limitStartYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mV.limitStartXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mV.limitStartYeBA = dlo.myParentGlass.bot1Part.endYBA;

				mV.limitStartXsB = dlo.myParentGlass.bot1Part.startXC;
				mV.limitStartYsB = dlo.myParentGlass.bot1Part.startYC;
				mV.limitStartXeB = dlo.myParentGlass.bot1Part.endXC;
				mV.limitStartYeB = dlo.myParentGlass.bot1Part.endYC;

				mV.dimTM = dlo.myParentGlass.bot1Part.partDimM;
				mV.dimTA = dlo.myParentGlass.bot1Part.partDimA;
				mV.newAlpha = Math.atan(dlo.myParentGlass.widthPix
						/ dlo.myParentGlass.dimD2);
				// mV.newAlphaF =
				// Math
				// .atan(dlo.myParentGlass.widthPix
				// / dlo.dimD2);
				mV.limitEnd = dlo.myParentGlass.bot1Part;

			} else if (dlo.shapeID == 706) {
				mV.limitEndXsA = dlo.myParentGlass.bot1Part.endXA;
				mV.limitEndYsA = dlo.myParentGlass.bot1Part.endYA;
				mV.limitEndXeA = dlo.myParentGlass.bot1Part.startXA;
				mV.limitEndYeA = dlo.myParentGlass.bot1Part.startYA;
				mV.limitEndXsBA = dlo.myParentGlass.bot1Part.endXBA;
				mV.limitEndYsBA = dlo.myParentGlass.bot1Part.endYBA;
				mV.limitEndXeBA = dlo.myParentGlass.bot1Part.startXBA;
				mV.limitEndYeBA = dlo.myParentGlass.bot1Part.startYBA;

				mV.limitEndXsB = dlo.myParentGlass.bot1Part.endXC;
				mV.limitEndYsB = dlo.myParentGlass.bot1Part.endYC;
				mV.limitEndXeB = dlo.myParentGlass.bot1Part.startXC;
				mV.limitEndYeB = dlo.myParentGlass.bot1Part.startYC;

				mV.dimBM = dlo.myParentGlass.bot1Part.partDimM;
				mV.dimBA = dlo.myParentGlass.bot1Part.partDimA;
				mV.myThetaBot = Math.atan(dlo.myParentGlass.widthPix
						/ dlo.myParentGlass.dimB2);
				// mV.myThetaBotF =
				// Math
				// .atan(dlo.widthPix
				// / dlo.dimB2);
				mV.limitEnd = dlo.myParentGlass.bot1Part;

			}
		}
	}

	public void verifyLimitLRH(final Profiles myMullion, final DLO dlo,
			final int start, final int end, final double cY,
			final Object[] myHs, final Object[] myVs, final AddMullionH mH) {

		this.getLimitingObjectsH(dlo,
				start,//
				end, //
				myMullion.y1al + (myMullion.y4al - myMullion.y1al) / 2, myHs,
				myVs, mH);

		myMullion.posCondition = mH.posCondition;
		mH.newAlpha = 0;//
		mH.newAlpha2 = 0;
		mH.newAlpha3 = 0;
		mH.newAlphaA = 0;
		mH.newAlphaC = 0;
		mH.myThetaRight = 0;

		mH.inArchL = 0;
		mH.inArchR = 0;

		if (dlo.shapeID != 10
				&& (dlo.radius1 > 0 || dlo.noSidesTop > 1 || dlo.noSidesBot > 1
						&& myMullion.posCondition <= 3 && !myMullion.isExtra)) {

			if (myMullion.y1al <= dlo.highestY + dlo.dimD2
					&& dlo.noSidesTop == 1 && dlo.dimD1 > 0
					// && !mH.startIn
					&& (dlo.myParentO.lean4 == 1 || dlo.myParentO.lean4 == 3)) {

				mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.top1Part.partDimA;

				mH.limitLTArchCenterX = dlo.myParentGlass.top1Part.x1;
				mH.limitLTArchCenterY = dlo.myParentGlass.top1Part.y1;
				mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD2);
				if (dlo.top1Part.partForm == 2) {
					mH.inArchL = 1;
					mH.limitStart = dlo.myParentGlass.top1Part;
				} else if (dlo.top1Part.partForm == 3) {
					mH.inArchL = 3;
					mH.limitStart = dlo.myParentGlass.top1Part;
				}

			}
			if (myMullion.y1al <= dlo.top1Part.startYA
					&& dlo.myParentO.noSidesTop == 1
					&& dlo.myParentO.top1Part.partForm > 1
					&& (myMullion.posCondition == 1 || myMullion.posCondition == 2)) {

				mH.limitStart = dlo.myParentGlass.top1Part;
				mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
				mH.limitLTArchCenterX = dlo.myParentGlass.top1Part.x1;
				mH.limitLTArchCenterY = dlo.myParentGlass.top1Part.y1;
				mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD2);
				if (dlo.top1Part.partForm == 2) {
					mH.inArchL = 1;
					mH.limitStart = dlo.myParentGlass.top1Part;
				} else if (dlo.top1Part.partForm == 3) {
					mH.inArchL = 3;
					mH.limitStart = dlo.myParentGlass.top1Part;
				}

			}
			if (myMullion.y4al <= dlo.highestY + dlo.dimB1
					&& dlo.noSidesTop == 1 && dlo.dimB0 == 0 && dlo.dimB2 > 0
					// && !mH.endIn
					&& dlo.myParentO.lean2 == 2) {
				mH.limitEndXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.top1Part.partDimA;
				mH.limitEndBArchCenterX = dlo.myParentGlass.top1Part.x1;
				mH.limitEndBArchCenterY = dlo.myParentGlass.top1Part.y1;
				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB1);
				if (dlo.top1Part.partForm == 2) {
					mH.inArchR = 1;
					mH.limitEnd = dlo.myParentGlass.top1Part;
				} else if (dlo.top1Part.partForm == 3) {
					mH.inArchR = 3;
					mH.limitEnd = dlo.myParentGlass.top1Part;
				}

			}

			if (myMullion.y4al <= dlo.top1Part.endYA
					&& dlo.noSidesTop == 1
					&& dlo.top1Part.partForm > 1
					&& (myMullion.posCondition == 1 || myMullion.posCondition == 3)) {
				mH.limitEndXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.top1Part.partDimA;
				mH.limitEndBArchCenterX = dlo.myParentGlass.top1Part.x1;
				mH.limitEndBArchCenterY = dlo.myParentGlass.top1Part.y1;
				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB1);
				if (dlo.top1Part.partForm == 2) {
					mH.inArchR = 1;
					mH.limitEnd = dlo.myParentGlass.top1Part;
				} else if (dlo.top1Part.partForm == 3) {
					mH.inArchR = 3;
					mH.limitEnd = dlo.myParentGlass.top1Part;
				}

			}

			if (myMullion.y4al <= dlo.highestY + dlo.dimB0
					&& dlo.noSidesTop == 1 && dlo.dimB0 > 0
					// && !mH.endIn
					&& dlo.myParentO.lean2 == 3) {
				mH.limitEndXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.top1Part.partDimA;
				// myMullion.mH.limitEndBArchCenterX=this.dlo.top1Part.x1;
				// myMullion.mH.limitEndBArchCenterY=this.dlo.top1Part.y1;
				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB0);

			}

			if (myMullion.y1al <= dlo.highestY + dlo.dimD2
					&& dlo.noSidesTop > 1 && dlo.dimD1 > 0
					// && !mH.startIn
					&& (dlo.myParentO.lean4 == 1 || dlo.myParentO.lean4 == 3)) {
				mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
				mH.limitLTArchCenterX = dlo.myParentGlass.top1Part.x1;
				mH.limitLTArchCenterY = dlo.myParentGlass.top1Part.y1;
				mH.newAlpha = Math.atan(dlo.dimA1 / dlo.dimD2);
				if (dlo.top1Part.partForm == 2) {
					mH.inArchL = 1;
					mH.limitStart = dlo.myParentGlass.top1Part;
				}

			}
			if (myMullion.y4al <= dlo.highestY + dlo.dimB1
					&& dlo.noSidesTop > 1 && dlo.dimB0 == 0 && dlo.dimB2 > 0
					// && !mH.endIn
					&& dlo.myParentO.lean2 == 2) {
				mH.limitEndXsA = dlo.myParentGlass.top2Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.top2Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.top2Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.top2Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.top2Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.top2Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.top2Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.top2Part.endYBA;
				mH.dimRM = dlo.myParentGlass.top2Part.partDimM;
				mH.dimRA = dlo.myParentGlass.top2Part.partDimA;
				mH.limitEndBArchCenterX = dlo.myParentGlass.top2Part.x1;
				mH.limitEndBArchCenterY = dlo.myParentGlass.top2Part.y1;
				mH.myThetaRight = Math.atan(dlo.dimA2 / dlo.dimB1);
				if (dlo.top2Part.partForm == 2) {
					mH.inArchR = 1;
					mH.limitEnd = dlo.myParentGlass.top2Part;
				}

			}
			if (myMullion.y4al <= dlo.highestY + dlo.dimB0
					&& dlo.noSidesTop > 1 && dlo.dimB0 > 0
					// && !mH.endIn
					&& dlo.myParentO.lean2 == 3) {
				mH.limitEndXsA = dlo.myParentGlass.top2Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.top2Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.top2Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.top2Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.top2Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.top2Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.top2Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.top2Part.endYBA;
				mH.dimRM = dlo.myParentGlass.top2Part.partDimM;
				mH.dimRA = dlo.myParentGlass.top2Part.partDimA;
				// myMullion.mH.limitEndBArchCenterX=this.dlo.top2Part.x1;
				// myMullion.mH.limitEndBArchCenterY=this.dlo.top2Part.y1;
				mH.myThetaRight = Math.atan(dlo.dimA2 / dlo.dimB0);

			}
			// ////////////////////////
			if (myMullion.y2cl >= dlo.highestY + dlo.dimD2
					&& dlo.noSidesBot == 1 && dlo.dimD0 == 0 && dlo.dimD2 > 0
					&& dlo.myParentO.lean4 == 2 && dlo.dimD1 > 0) {
				mH.limitStartXsA = dlo.myParentGlass.bot1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.bot1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.bot1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.bot1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.bot1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.bot1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.bot1Part.partDimA;
				mH.limitLTArchCenterX = dlo.myParentGlass.bot1Part.x1;
				mH.limitLTArchCenterY = dlo.myParentGlass.bot1Part.y1;
				mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD1);
				if (dlo.bot1Part.partForm == 2) {
					mH.inArchL = 1;
					mH.limitStart = dlo.myParentGlass.bot1Part;
				}
				if (dlo.bot1Part.partForm == 3) {
					mH.inArchL = 3;
					mH.limitStart = dlo.myParentGlass.bot1Part;
				}

			}
			if (myMullion.y2cl >= dlo.highestY + dlo.dimD2 + dlo.dimD1
					&& dlo.noSidesBot == 1 && dlo.dimD0 > 0) {
				mH.limitStartXsA = dlo.myParentGlass.bot1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.bot1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.bot1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.bot1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.bot1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.bot1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.bot1Part.partDimA;
				// myMullion.mH.limitLTArchCenterX=this.dlo.bot1Part.x1;
				// myMullion.mH.limitLTArchCenterY=this.dlo.bot1Part.y1;
				mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD0);

			}

			if (myMullion.y3cl >= dlo.highestY + dlo.dimB1
					&& dlo.noSidesBot == 1 && dlo.dimB0 == 0 && dlo.dimB1 > 0
					&& dlo.myParentO.lean2 == 1 && dlo.dimB2 > 0) {
				mH.limitEndXsA = dlo.myParentGlass.bot1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.bot1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.bot1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.bot1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.bot1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.bot1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.bot1Part.partDimA;
				mH.limitEndBArchCenterX = dlo.myParentGlass.bot1Part.x1;
				mH.limitEndBArchCenterY = dlo.myParentGlass.bot1Part.y1;
				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB2);
				if (dlo.bot1Part.partForm == 2) {
					mH.inArchR = 1;
					mH.limitEnd = dlo.myParentGlass.bot1Part;
				}
				if (dlo.bot1Part.partForm == 3) {
					mH.inArchR = 3;
					mH.limitStart = dlo.myParentGlass.bot1Part;
				}
			}
			if (myMullion.y3cl >= dlo.highestY + dlo.dimB0 + dlo.dimB1
					&& dlo.noSidesBot == 1 && dlo.dimB0 > 0 && dlo.dimB2 > 0) {
				mH.limitEndXsA = dlo.myParentGlass.bot1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.bot1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.bot1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.bot1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.bot1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.bot1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.bot1Part.partDimA;

				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB2);

			}

			if (myMullion.y2cl > dlo.highestY + dlo.dimD2 + dlo.dimD1
					&& dlo.noSidesBot > 1 && dlo.dimD0 > 0) {
				mH.limitStartXsA = dlo.myParentGlass.bot2Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.bot2Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.bot2Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.bot2Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.bot2Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.bot2Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.bot2Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.bot2Part.endYBA;
				mH.dimLM = dlo.myParentGlass.bot2Part.partDimM;
				mH.dimLA = dlo.myParentGlass.bot2Part.partDimA;
				mH.newAlpha = Math.atan(dlo.dimC2 / dlo.dimD0);

			}

			if (myMullion.y3cl > dlo.highestY + dlo.dimB0 + dlo.dimB1
					&& dlo.noSidesBot > 1 && dlo.dimB0 > 0) {
				mH.limitEndXsA = dlo.myParentGlass.bot3Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.bot3Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.bot3Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.bot3Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.bot3Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.bot3Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.bot3Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.bot3Part.endYBA;
				mH.dimRM = dlo.myParentGlass.bot3Part.partDimM;
				mH.dimRA = dlo.myParentGlass.bot3Part.partDimA;
				mH.myThetaRight = Math.atan(dlo.dimC1 / dlo.dimB2);
			}
			// //////////////////////////////////////
			// //////////////////////////////////////
			if (dlo.noSides >= 8 && mH.posCondition <= 3) {
				if (myMullion.y1al <= dlo.top1Part.startYC
						&& mH.posCondition <= 2) {
					mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
					mH.limitLTArchCenterX = dlo.myParentGlass.top1Part.x1;
					mH.limitLTArchCenterY = dlo.myParentGlass.top1Part.y1;
					mH.newAlpha = Math.atan(dlo.dimA1 / dlo.dimD2);
					if (dlo.top1Part.partForm == 2) {
						mH.inArchL = 1;
						mH.limitStart = dlo.myParentGlass.top1Part;
					}
				}

				if (myMullion.y4al <= dlo.top2Part.endYC
						&& mH.posCondition == 3) {
					mH.limitEndXsA = dlo.myParentGlass.top2Part.startXA;
					mH.limitEndYsA = dlo.myParentGlass.top2Part.startYA;
					mH.limitEndXeA = dlo.myParentGlass.top2Part.endXA;
					mH.limitEndYeA = dlo.myParentGlass.top2Part.endYA;
					mH.limitEndXsBA = dlo.myParentGlass.top2Part.startXBA;
					mH.limitEndYsBA = dlo.myParentGlass.top2Part.startYBA;
					mH.limitEndXeBA = dlo.myParentGlass.top2Part.endXBA;
					mH.limitEndYeBA = dlo.myParentGlass.top2Part.endYBA;
					mH.dimRM = dlo.myParentGlass.top2Part.partDimM;
					mH.dimRA = dlo.myParentGlass.top2Part.partDimA;
					// myMullion.mH.limitEndBArchCenterX=this.dlo.top2Part.x1;
					// myMullion.mH.limitEndBArchCenterY=this.dlo.top2Part.y1;
					mH.myThetaRight = Math.atan(dlo.dimA2 / dlo.dimB0);

				}

				if (myMullion.y1al < dlo.leftPart.startYC
						&& myMullion.y2cl > dlo.leftPart.endYC
						&& mH.posCondition <= 2) {

					mH.limitStartXsA = dlo.myParentGlass.leftPart.startXA;
					mH.limitStartYsA = dlo.myParentGlass.leftPart.startYA;
					mH.limitStartXeA = dlo.myParentGlass.leftPart.endXA;
					mH.limitStartYeA = dlo.myParentGlass.leftPart.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.leftPart.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.leftPart.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.leftPart.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.leftPart.endYBA;

				}

				if (myMullion.y4al < dlo.rightPart.endYC
						&& myMullion.y3cl > dlo.rightPart.startYC
						&& mH.posCondition == 3) {
					mH.limitEndXsA = dlo.myParentGlass.rightPart.startXA;
					mH.limitEndYsA = dlo.myParentGlass.rightPart.startYA;
					mH.limitEndXeA = dlo.myParentGlass.rightPart.endXA;
					mH.limitEndYeA = dlo.myParentGlass.rightPart.endYA;
					mH.limitEndXsBA = dlo.myParentGlass.rightPart.startXBA;
					mH.limitEndYsBA = dlo.myParentGlass.rightPart.startYBA;
					mH.limitEndXeBA = dlo.myParentGlass.rightPart.endXBA;
					mH.limitEndYeBA = dlo.myParentGlass.rightPart.endYBA;
					mH.dimRM = dlo.myParentGlass.rightPart.partDimM;
					mH.dimRA = dlo.myParentGlass.rightPart.partDimA;

				}

				if (myMullion.y1al < dlo.bot2Part.startYC
						&& myMullion.y2cl > dlo.bot2Part.endYC
						&& mH.posCondition <= 2) {

					mH.limitStartXsA = dlo.myParentGlass.bot2Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.bot2Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.bot2Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.bot2Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.bot2Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.bot2Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.bot2Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.bot2Part.endYBA;
					mH.dimLM = dlo.myParentGlass.bot2Part.partDimM;
					mH.dimLA = dlo.myParentGlass.bot2Part.partDimA;

				}

				if (myMullion.y3cl > dlo.bot1Part.startYC
						&& myMullion.y4al < dlo.bot1Part.endYC
						&& mH.posCondition == 3) {

					mH.limitEndXsA = dlo.myParentGlass.bot1Part.startXA;
					mH.limitEndYsA = dlo.myParentGlass.bot1Part.startYA;
					mH.limitEndXeA = dlo.myParentGlass.bot1Part.endXA;
					mH.limitEndYeA = dlo.myParentGlass.bot1Part.endYA;
					mH.limitEndXsBA = dlo.myParentGlass.bot1Part.startXBA;
					mH.limitEndYsBA = dlo.myParentGlass.bot1Part.startYBA;
					mH.limitEndXeBA = dlo.myParentGlass.bot1Part.endXBA;
					mH.limitEndYeBA = dlo.myParentGlass.bot1Part.endYBA;
					mH.dimRM = dlo.myParentGlass.bot1Part.partDimM;
					mH.dimRA = dlo.myParentGlass.bot1Part.partDimA;

					mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB2);

				}
			}

			// //////////////////////////////////////////
			// ////////////////////////////////////////////
			if (dlo.shapeID == 700) {
				mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimD2);

			} else if (dlo.shapeID == 701) {
				mH.limitEndXsA = dlo.myParentGlass.top1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.top1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.top1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.top1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.top1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.top1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.top1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.top1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.top1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.top1Part.partDimA;
				mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimB1);

			} else if (dlo.shapeID == 702) {
				if (mH.newStartingYLBa < dlo.startingY + dlo.dimD2) {
					mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
					mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD2);

				}
				if (myMullion.y2cl > dlo.startingY + dlo.dimD2) {
					mH.limitStartXsA = dlo.myParentGlass.bot1Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.bot1Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.bot1Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.bot1Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.bot1Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.bot1Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.bot1Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.bot1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.bot1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.bot1Part.partDimA;
					mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD0);

				}

			} else if (dlo.shapeID == 703) {
				if (myMullion.y4al < dlo.startingY + dlo.dimB0) {
					mH.limitEndXsA = dlo.myParentGlass.top1Part.startXA;
					mH.limitEndYsA = dlo.myParentGlass.top1Part.startYA;
					mH.limitEndXeA = dlo.myParentGlass.top1Part.endXA;
					mH.limitEndYeA = dlo.myParentGlass.top1Part.endYA;
					mH.limitEndXsBA = dlo.myParentGlass.top1Part.startXBA;
					mH.limitEndYsBA = dlo.myParentGlass.top1Part.startYBA;
					mH.limitEndXeBA = dlo.myParentGlass.top1Part.endXBA;
					mH.limitEndYeBA = dlo.myParentGlass.top1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
					mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB0);

				}
				if (myMullion.y3cl > dlo.startingY + dlo.dimB0) {
					mH.limitEndXsA = dlo.myParentGlass.bot1Part.startXA;
					mH.limitEndYsA = dlo.myParentGlass.bot1Part.startYA;
					mH.limitEndXeA = dlo.myParentGlass.bot1Part.endXA;
					mH.limitEndYeA = dlo.myParentGlass.bot1Part.endYA;
					mH.limitEndXsBA = dlo.myParentGlass.bot1Part.startXBA;
					mH.limitEndYsBA = dlo.myParentGlass.bot1Part.startYBA;
					mH.limitEndXeBA = dlo.myParentGlass.bot1Part.endXBA;
					mH.limitEndYeBA = dlo.myParentGlass.bot1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.bot1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.bot1Part.partDimA;
					mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB2);

				}

			} else if (dlo.shapeID == 704) {

			} else if (dlo.shapeID == 705) {
				mH.limitStartXsA = dlo.myParentGlass.bot1Part.startXA;
				mH.limitStartYsA = dlo.myParentGlass.bot1Part.startYA;
				mH.limitStartXeA = dlo.myParentGlass.bot1Part.endXA;
				mH.limitStartYeA = dlo.myParentGlass.bot1Part.endYA;
				mH.limitStartXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mH.limitStartYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mH.limitStartXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mH.limitStartYeBA = dlo.myParentGlass.bot1Part.endYBA;
				mH.dimLM = dlo.myParentGlass.bot1Part.partDimM;
				mH.dimLA = dlo.myParentGlass.bot1Part.partDimA;
				mH.newAlpha = Math.atan(dlo.widthPix / dlo.dimD2);

			} else if (dlo.shapeID == 706) {
				mH.limitEndXsA = dlo.myParentGlass.bot1Part.startXA;
				mH.limitEndYsA = dlo.myParentGlass.bot1Part.startYA;
				mH.limitEndXeA = dlo.myParentGlass.bot1Part.endXA;
				mH.limitEndYeA = dlo.myParentGlass.bot1Part.endYA;
				mH.limitEndXsBA = dlo.myParentGlass.bot1Part.startXBA;
				mH.limitEndYsBA = dlo.myParentGlass.bot1Part.startYBA;
				mH.limitEndXeBA = dlo.myParentGlass.bot1Part.endXBA;
				mH.limitEndYeBA = dlo.myParentGlass.bot1Part.endYBA;
				mH.dimRM = dlo.myParentGlass.bot1Part.partDimM;
				mH.dimRA = dlo.myParentGlass.bot1Part.partDimA;
				mH.myThetaRight = Math.atan(dlo.widthPix / dlo.dimB2);

			}
		}
	}

	public void getLimitingObjectsV(
			final DLO dlo, // Profiles
			// return
			final int start, final int end, final double cX,
			final Object[] myHs, final Object[] myVs, final AddMullionV mV) {

		if (start == 1) {
			mV.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
			mV.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
			mV.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
			mV.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
			mV.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
			mV.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
			mV.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
			mV.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
			mV.limitStartXsB = dlo.myParentGlass.top1Part.startXC;
			mV.limitStartYsB = dlo.myParentGlass.top1Part.startYC;
			mV.limitStartXeB = dlo.myParentGlass.top1Part.endXC;
			mV.limitStartYeB = dlo.myParentGlass.top1Part.endYC;
			mV.dimTM = dlo.myParentGlass.top1Part.partDimM;
			mV.dimTA = dlo.myParentGlass.top1Part.partDimA;
			mV.limitStart = dlo.myParentGlass.top1Part;
			mV.startIn = false;
		} else if (start > 1) {
			for (final Object myH : myHs) {

				if (((Profiles) myH).rowCol + 1 == start
				// && ((Profiles) myH).x1 < cX
				// && ((Profiles) myH).x4 > cX
				) {

					mV.dimTM = ((Profiles) myH).partDimM;
					mV.dimTA = ((Profiles) myH).partDimC;
					mV.limitStartXsA = ((Profiles) myH).x1al;
					mV.limitStartYsA = ((Profiles) myH).y1al;
					mV.limitStartXeA = ((Profiles) myH).x4al;
					mV.limitStartYeA = ((Profiles) myH).y4al;
					mV.limitStartXsBA = ((Profiles) myH).x1;
					mV.limitStartYsBA = ((Profiles) myH).y1;
					mV.limitStartXeBA = ((Profiles) myH).x4;
					mV.limitStartYeBA = ((Profiles) myH).y4;
					mV.startIn = true;
					mV.limitStart = (Profiles) myH;
					break;
				}

			}

		}

		if (end == dlo.yRows) {

			mV.limitEndXsA = dlo.myParentGlass.bot1Part.endXA;
			mV.limitEndYsA = dlo.myParentGlass.bot1Part.endYA;
			mV.limitEndXeA = dlo.myParentGlass.bot1Part.startXA;
			mV.limitEndYeA = dlo.myParentGlass.bot1Part.startYA;
			mV.limitEndXsBA = dlo.myParentGlass.bot1Part.endXBA;
			mV.limitEndYsBA = dlo.myParentGlass.bot1Part.endYBA;
			mV.limitEndXeBA = dlo.myParentGlass.bot1Part.startXBA;
			mV.limitEndYeBA = dlo.myParentGlass.bot1Part.startYBA;

			mV.limitEndXsB = dlo.myParentGlass.bot1Part.endXC;
			mV.limitEndYsB = dlo.myParentGlass.bot1Part.endYC;
			mV.limitEndXeB = dlo.myParentGlass.bot1Part.startXC;
			mV.limitEndYeB = dlo.myParentGlass.bot1Part.startYC;
			mV.dimBM = dlo.myParentGlass.bot1Part.partDimM;
			mV.dimBA = dlo.myParentGlass.bot1Part.partDimA;

			mV.limitEnd = dlo.bot1Part;
			mV.endIn = false;
		} else if (end < dlo.yRows) {
			for (final Object myH : myHs) {

				if (((Profiles) myH).rowCol >= end
				// &&
				// ((Profiles)
				// myH).centerYs >= mV.limitT.startY
				// && ((Profiles) myH).x1 < cX
				) {

					mV.dimBM = ((Profiles) myH).partDimM;
					mV.dimBA = ((Profiles) myH).partDimA;

					mV.limitEndXsA = ((Profiles) myH).x2cl;
					mV.limitEndYsA = ((Profiles) myH).y2cl;
					mV.limitEndXeA = ((Profiles) myH).x3cl;
					mV.limitEndYeA = ((Profiles) myH).y3cl;
					mV.limitEndXsBA = ((Profiles) myH).x2;
					mV.limitEndYsBA = ((Profiles) myH).y2;
					mV.limitEndXeBA = ((Profiles) myH).x3;
					mV.limitEndYeBA = ((Profiles) myH).y3;
					mV.endIn = true;
					mV.limitEnd = (Profiles) myH;
					break;
				}

			}
		}

		if (!mV.startIn && !mV.endIn) {
			mV.posCondition = 1;
		} else if (!mV.startIn && mV.endIn) {
			mV.posCondition = 2;
		} else if (mV.startIn && !mV.endIn) {
			mV.posCondition = 3;
		} else {
			mV.posCondition = 4;
		}

		// return myMullion;

	}

	public void getLimitingObjectsH(final DLO dlo, final int start,
			final int end, final double cY, final Object[] myHs,
			final Object[] myVs, final AddMullionH mH) {

		if (start == 1) {

			mH.limitStartXsA = dlo.myParentGlass.leftPart.startXA;
			mH.limitStartYsA = dlo.myParentGlass.leftPart.startYA;
			mH.limitStartXeA = dlo.myParentGlass.leftPart.endXA;
			mH.limitStartYeA = dlo.myParentGlass.leftPart.endYA;
			mH.limitStartXsBA = dlo.myParentGlass.leftPart.startXBA;
			mH.limitStartYsBA = dlo.myParentGlass.leftPart.startYBA;
			mH.limitStartXeBA = dlo.myParentGlass.leftPart.endXBA;
			mH.limitStartYeBA = dlo.myParentGlass.leftPart.endYBA;
			mH.dimLM = dlo.myParentGlass.leftPart.partDimM;
			mH.dimLA = dlo.myParentGlass.leftPart.partDimA;

			mH.startIn = false;
		} else if (start > 1) {
			boolean found = false;
			for (final Object myV : myVs) {

				if (((Profiles) myV).rowCol + 1 == start
				// && ((Profiles) myV).y3 > cY
				// && ((Profiles) myV).y2 < cY
				) {

					mH.dimLM = ((Profiles) myV).partDimM;
					mH.dimLA = ((Profiles) myV).partDimC;
					mH.limitStartXsA = ((Profiles) myV).x2cl;
					mH.limitStartYsA = ((Profiles) myV).y2cl;
					mH.limitStartXeA = ((Profiles) myV).x3cl;
					mH.limitStartYeA = ((Profiles) myV).y3cl;
					mH.limitStartXsBA = ((Profiles) myV).x2;
					mH.limitStartYsBA = ((Profiles) myV).y2;
					mH.limitStartXeBA = ((Profiles) myV).x3;
					mH.limitStartYeBA = ((Profiles) myV).y3;
					mH.startIn = true;
					found = true;
					break;
				}

			}
			if (!found) {
				if (dlo.noSidesTop > 1
						&& dlo.top1Part.startYC < dlo.top1Part.endYC) {
					mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
					mH.startIn = false;
				}

			}

		}

		if (end == dlo.xCols) {

			mH.limitEndXsA = dlo.myParentGlass.rightPart.startXA;
			mH.limitEndYsA = dlo.myParentGlass.rightPart.startYA;
			mH.limitEndXeA = dlo.myParentGlass.rightPart.endXA;
			mH.limitEndYeA = dlo.myParentGlass.rightPart.endYA;
			mH.limitEndXsBA = dlo.myParentGlass.rightPart.startXBA;
			mH.limitEndYsBA = dlo.myParentGlass.rightPart.startYBA;
			mH.limitEndXeBA = dlo.myParentGlass.rightPart.endXBA;
			mH.limitEndYeBA = dlo.myParentGlass.rightPart.endYBA;
			mH.dimRM = dlo.myParentGlass.rightPart.partDimM;
			mH.dimRA = dlo.myParentGlass.rightPart.partDimA;
			mH.endIn = false;
		} else if (end < dlo.xCols) {
			boolean found = false;
			for (final Object myV : myVs) {

				if (((Profiles) myV).rowCol == end
				// &&
				// ((Profiles)
				// myVs[c]).y4 > cY
				// && ((Profiles) myV).y1 < cY
				) {

					mH.dimRM = ((Profiles) myV).partDimM;
					mH.dimRA = ((Profiles) myV).partDimA;
					mH.limitEndXsA = ((Profiles) myV).x1al;
					mH.limitEndYsA = ((Profiles) myV).y1al;
					mH.limitEndXeA = ((Profiles) myV).x4al;
					mH.limitEndYeA = ((Profiles) myV).y4al;
					mH.limitEndXsBA = ((Profiles) myV).x1;
					mH.limitEndYsBA = ((Profiles) myV).y1;
					mH.limitEndXeBA = ((Profiles) myV).x4;
					mH.limitEndYeBA = ((Profiles) myV).y4;
					mH.endIn = true;
					found = true;
					break;
				}

			}
			if (!found) {
				if (dlo.noSidesTop > 1
						&& dlo.top2Part.startYC < dlo.top2Part.endYC) {
					mH.limitStartXsA = dlo.myParentGlass.top2Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.top2Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.top2Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.top2Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.top2Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.top2Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.top2Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.top2Part.endYBA;
					mH.dimLM = dlo.myParentGlass.top2Part.partDimM;
					mH.dimLA = dlo.myParentGlass.top2Part.partDimA;
					mH.endIn = false;
				} else if (dlo.noSidesTop == 1
						&& dlo.top1Part.startYC < dlo.top1Part.endYC) {
					mH.limitStartXsA = dlo.myParentGlass.top1Part.startXA;
					mH.limitStartYsA = dlo.myParentGlass.top1Part.startYA;
					mH.limitStartXeA = dlo.myParentGlass.top1Part.endXA;
					mH.limitStartYeA = dlo.myParentGlass.top1Part.endYA;
					mH.limitStartXsBA = dlo.myParentGlass.top1Part.startXBA;
					mH.limitStartYsBA = dlo.myParentGlass.top1Part.startYBA;
					mH.limitStartXeBA = dlo.myParentGlass.top1Part.endXBA;
					mH.limitStartYeBA = dlo.myParentGlass.top1Part.endYBA;
					mH.dimLM = dlo.myParentGlass.top1Part.partDimM;
					mH.dimLA = dlo.myParentGlass.top1Part.partDimA;
					mH.endIn = false;
				}
			}
		}

		if (!mH.startIn && !mH.endIn) {
			mH.posCondition = 1;
		} else if (!mH.startIn && mH.endIn) {
			mH.posCondition = 2;
		} else if (mH.startIn && !mH.endIn) {
			mH.posCondition = 3;
		} else {
			mH.posCondition = 4;
		}

	}

	public Profiles cloneMullion(final Profiles newM, final Profiles original) {

		newM.myFrame2 = original.myFrame2;
		newM.a_levelID = original.a_levelID;
		newM.a_assemblyLevel = original.a_assemblyLevel;
		newM.a_sequenceID = original.rowCol;
		newM.a_1Level = original.a_1Level;
		newM.a_1Sequence = original.a_1Sequence;
		newM.a_2Level = original.a_2Level;
		newM.a_2Sequence = original.a_2Sequence;
		newM.a_3Level = original.a_3Level;
		newM.a_3Sequence = original.a_3Sequence;
		newM.a_4Level = original.a_4Level;
		newM.a_4Sequence = original.a_4Sequence;
		newM.a_5Level = original.a_5Level;
		newM.a_5Sequence = original.a_5Sequence;
		newM.a_6Level = original.a_6Level;
		newM.a_6Sequence = original.a_6Sequence;
		newM.a_7Level = original.a_7Level;
		newM.a_7Sequence = original.a_7Sequence;
		newM.a_8Level = original.a_8Level;
		newM.a_8Sequence = original.a_8Sequence;
		newM.a_9Level = original.a_9Level;
		newM.a_9Sequence = original.a_9Sequence;
		newM.a_10Level = original.a_10Level;
		newM.a_10Sequence = original.a_10Sequence;

		newM.a_11Level = original.a_11Level;
		newM.a_11Sequence = original.a_11Sequence;
		newM.a_12Level = original.a_12Level;
		newM.a_12Sequence = original.a_12Sequence;
		newM.a_13Level = original.a_13Level;
		newM.a_13Sequence = original.a_13Sequence;
		newM.a_14Level = original.a_14Level;
		newM.a_14Sequence = original.a_14Sequence;
		newM.a_15Level = original.a_15Level;
		newM.a_15Sequence = original.a_15Sequence;
		newM.a_16Level = original.a_16Level;
		newM.a_16Sequence = original.a_16Sequence;
		newM.a_17Level = original.a_17Level;
		newM.a_17Sequence = original.a_17Sequence;
		newM.a_18Level = original.a_18Level;
		newM.a_18Sequence = original.a_18Sequence;
		newM.a_19Level = original.a_19Level;
		newM.a_19Sequence = original.a_19Sequence;
		newM.a_20Level = original.a_20Level;
		newM.a_20Sequence = original.a_20Sequence;
		newM.a_21Level = original.a_21Level;
		newM.a_21Sequence = original.a_21Sequence;
		newM.a_22Level = original.a_22Level;
		newM.a_22Sequence = original.a_22Sequence;

		newM.gridID = original.gridID;
		newM.gridTypeID = original.gridTypeID;

		newM.ABClines = original.ABClines;
		newM.bkgrdHeight = original.bkgrdHeight;
		newM.bkgrdHeightA = original.bkgrdHeightA;
		newM.bkgrdHeightBA = original.bkgrdHeightBA;
		newM.bkgrdHeightBC = original.bkgrdHeightBC;
		newM.bkgrdStartX = original.bkgrdStartX;
		newM.bkgrdStartXA = original.bkgrdStartXA;
		newM.bkgrdStartXBA = original.bkgrdStartXBA;
		newM.shapeID = original.shapeID;
		newM.bkgrdStartXBC = original.bkgrdStartXBC;
		newM.bkgrdStartY = original.bkgrdStartY;
		newM.bkgrdStartYA = original.bkgrdStartYA;
		newM.bkgrdStartYBA = original.bkgrdStartYBA;
		newM.bkgrdStartYBC = original.bkgrdStartYBC;
		newM.bkgrdWidth = original.bkgrdWidth;
		newM.bkgrdWidthA = original.bkgrdWidthA;
		newM.bkgrdWidthBA = original.bkgrdWidthBA;
		newM.bkgrdWidthBC = original.bkgrdWidthBC;
		newM.centralAngle = original.centralAngle;
		newM.centralAngleA = original.centralAngleA;
		newM.centralAngleBA = original.centralAngleBA;
		newM.centralAngleBC = original.centralAngleBC;
		newM.dimB1A = original.dimB1A;
		newM.dimB1B = original.dimB1B;
		newM.endAngle = original.endAngle;
		newM.endAngleA = original.endAngleA;
		newM.endAngleBA = original.endAngleBA;
		newM.endAngleBC = original.endAngleBC;
		newM.endXC = original.endXC;
		newM.endXA = original.endXA;
		newM.endXBA = original.endXBA;
		newM.endXBC = original.endXBC;
		newM.endYC = original.endYC;
		newM.endYA = original.endYA;
		newM.endYBA = original.endYBA;
		newM.endYBC = original.endYBC;
		newM.focal1X = original.focal1X;
		newM.focal1XA = original.focal1XA;
		newM.focal1XBA = original.focal1XBA;
		newM.focal1XBC = original.focal1XBC;
		newM.focal1Y = original.focal1Y;
		newM.focal1YA = original.focal1YA;
		newM.focal1YBA = original.focal1YBA;
		newM.focal1YBC = original.focal1YBC;
		newM.focal2X = original.focal2X;
		newM.focal2XA = original.focal2XA;
		newM.focal2XBA = original.focal2XBA;
		newM.focal2XBC = original.focal2XBC;
		newM.focal2Y = original.focal2Y;
		newM.focal2YA = original.focal2YA;
		newM.focal2YBA = original.focal2YBA;
		newM.focal2YBC = original.focal2YBC;
		newM.glazingDepth = original.glazingDepth;
		newM.inLaminateArea = original.inLaminateArea;
		newM.inPaintArea = original.inPaintArea;
		newM.length = original.length;
		newM.lengthA = original.lengthA;
		newM.lengthBA = original.lengthBA;
		newM.lengthBC = original.lengthBC;
		newM.ltAngle = original.ltAngle;
		newM.ltAngleA = original.ltAngleA;
		newM.ltAngleBA = original.ltAngleBA;
		newM.ltAngleBC = original.ltAngleBC;
		newM.mitreLengthLT = original.mitreLengthLT;
		newM.mitreLengthRB = original.mitreLengthRB;
		newM.myParent = original.myParent;
		newM.myWidth = original.myWidth;
		newM.myWidthA = original.myWidthA;
		newM.myWidthBA = original.myWidthBA;
		newM.newX = original.newX;
		newM.newXA = original.newXA;
		newM.newY = original.newY;
		newM.newYA = original.newYA;
		newM.outLaminateArea = original.outLaminateArea;
		newM.outPaintArea = original.outPaintArea;
		newM.partDimA = original.partDimA;
		newM.partDimAi = original.partDimAi;
		newM.partDimB = original.partDimB;
		newM.partDimBi = original.partDimBi;
		newM.partDimC = original.partDimC;
		newM.partDimCi = original.partDimCi;
		newM.partDimM = original.partDimM;
		newM.partForm = original.partForm;
		newM.partID = original.partID;
		newM.partShape = original.partShape;
		newM.position = original.position;
		newM.seq = original.seq;
		newM.radianCentralAngle = original.radianCentralAngle;
		newM.radius1 = original.radius1;
		newM.radius1A = original.radius1A;
		newM.radius1BA = original.radius1BA;
		newM.radius1BC = original.radius1BC;
		newM.radius2 = original.radius2;
		newM.radius2A = original.radius2A;
		newM.radius2BA = original.radius2BA;
		newM.radius2BC = original.radius2BC;
		newM.radsStart = original.radsStart;
		newM.radsStart2 = original.radsStart2;
		newM.radsStart2A = original.radsStart2A;
		newM.radsStart2BA = original.radsStart2BA;
		newM.radsStartA = original.radsStartA;
		newM.radsStartBA = original.radsStartBA;
		newM.rbAngle = original.rbAngle;
		newM.rbAngleA = original.rbAngleA;
		newM.rbAngleBA = original.rbAngleBA;
		newM.rbAngleBC = original.rbAngleBC;
		newM.rID = original.rID;
		newM.rlAngle = original.rlAngle;
		newM.rlAngleA = original.rlAngleA;
		newM.rlAngleBA = original.rlAngleBA;
		newM.rlSlope = original.rlSlope;
		newM.rlSlopeA = original.rlSlopeA;
		newM.rlSlopeBA = original.rlSlopeBA;
		newM.rrAngle = original.rrAngle;
		newM.rrAngleA = original.rrAngleA;
		newM.rrAngleBA = original.rrAngleBA;
		newM.rrSlope = original.rrSlope;
		newM.rrSlopeA = original.rrSlopeA;
		newM.rrSlopeBA = original.rrSlopeBA;
		newM.slope = original.slope;
		newM.slopeA = original.slopeA;
		newM.slopeBA = original.slopeBA;
		newM.slopeBC = original.slopeBC;
		newM.startAngle = original.startAngle;
		newM.startAngleA = original.startAngleA;
		newM.startAngleBA = original.startAngleBA;
		newM.startAngleBC = original.startAngleBC;
		newM.startingX = original.startingX;
		newM.startingXA = original.startingXA;
		newM.startingXBA = original.startingXBA;
		newM.startingXBC = original.startingXBC;
		newM.startingY = original.startingY;
		newM.startingYA = original.startingYA;
		newM.startingYBA = original.startingYBA;
		newM.startingYBC = original.startingYBC;
		newM.startXC = original.startXC;
		newM.startXA = original.startXA;
		newM.startXBA = original.startXBA;
		newM.startXBC = original.startXBC;
		newM.startYC = original.startYC;
		newM.startYA = original.startYA;
		newM.startYBA = original.startYBA;
		newM.startYBC = original.startYBC;
		newM.stockCode = original.stockCode;
		newM.stopAeX = original.stopAeX;
		newM.stopAeY = original.stopAeY;
		newM.stopAsX = original.stopAsX;
		newM.stopAsY = original.stopAsY;
		newM.totalDepth = original.totalDepth;
		newM.totalSurfaceArea = original.totalSurfaceArea;
		newM.wire = original.wire;
		newM.x1 = original.x1;
		newM.x1A = original.x1A;
		newM.x1BA = original.x1BA;
		newM.x1BC = original.x1BC;
		newM.x2 = original.x2;
		newM.x2A = original.x2A;
		newM.x2BA = original.x2BA;
		newM.x2BC = original.x2BC;
		newM.y1 = original.y1;
		newM.y1A = original.y1A;
		newM.y1BA = original.y1BA;
		newM.y1BC = original.y1BC;
		newM.y2 = original.y2;
		newM.y2A = original.y2A;
		newM.y2BA = original.y2BA;
		newM.y2BC = original.y2BC;
		newM.x3 = original.x3;
		newM.x3A = original.x3A;
		newM.x3BA = original.x3BA;
		newM.x3BC = original.x3BC;
		newM.x4 = original.x4;
		newM.x4A = original.x4A;
		newM.x4BA = original.x4BA;
		newM.x4BC = original.x4BC;
		newM.y3 = original.y3;
		newM.y3A = original.y3A;
		newM.y3BA = original.y3BA;
		newM.y3BC = original.y3BC;
		newM.y4 = original.y4;
		newM.y4A = original.y4A;
		newM.y4BA = original.y4BA;
		newM.y4BC = original.y4BC;
		newM.endTypeLT = original.endTypeLT;
		newM.endTypeRB = original.endTypeRB;
		newM.parentW = original.parentW;

		newM.myLean = original.myLean;
		newM.myLean2 = original.myLean2;
		newM.myLean3 = original.myLean3;
		newM.myLean4 = original.myLean4;
		newM.partNotching = original.partNotching;
		newM.myNotchLB = original.myNotchLB;
		newM.myNotchRT = original.myNotchRT;
		newM.myNothcesLB = original.myNothcesLB;
		newM.myNothcesRT = original.myNothcesRT;
		newM.xCoordB = original.xCoordB;
		newM.yCoordB = original.yCoordB;
		newM.xCoordBA = original.xCoordBA;
		newM.yCoordBA = original.yCoordBA;
		newM.xCoordA = original.xCoordA;
		newM.yCoordA = original.yCoordA;
		newM.xCoordBo = original.xCoordBo;
		newM.yCoordBo = original.yCoordBo;
		newM.xCoordBoBA = original.xCoordBoBA;
		newM.yCoordBoBA = original.yCoordBoBA;
		newM.xCoordBoA = original.xCoordBoA;
		newM.yCoordBoA = original.yCoordBoA;
		newM.myX = original.myX;
		newM.myY = original.myY;
		newM.topIn = original.topIn;
		newM.rightIn = original.rightIn;
		newM.botIn = original.botIn;
		newM.leftIn = original.leftIn;
		newM.posInUse = original.posInUse;
		newM.color = original.color;
		newM.colorIn = original.colorIn;
		newM.colorOut = original.colorOut;
		newM.rgb_R = original.rgb_R;
		newM.rgb_G = original.rgb_G;
		newM.rgb_B = original.rgb_B;
		newM.rgb_Rin = original.rgb_Rin;
		newM.rgb_Gin = original.rgb_Gin;
		newM.rgb_Bin = original.rgb_Bin;
		newM.rgb_Rout = original.rgb_Rout;
		newM.rgb_Gout = original.rgb_Gout;
		newM.rgb_Bout = original.rgb_Bout;
		newM.rgb_Rt = original.rgb_Rt;
		newM.rgb_Gt = original.rgb_Gt;
		newM.rgb_Bt = original.rgb_Bt;
		newM.transp = original.transp;
		newM.profileSelected = original.profileSelected;
		newM.mullionLeft = original.mullionLeft;
		newM.mullionRight = original.mullionRight;
		newM.top1Part = original.top1Part;
		newM.top2Part = original.top2Part;
		newM.top3Part = original.top3Part;
		newM.bot1Part = original.bot1Part;
		newM.bot2Part = original.bot2Part;
		newM.bot3Part = original.bot3Part;
		newM.leftPart = original.leftPart;
		newM.rightPart = original.rightPart;
		newM.arc2B = original.arc2B;
		newM.arc2BA = original.arc2BA;
		newM.arc2A = original.arc2A;
		newM.arcB = original.arcB;
		newM.arcBA = original.arcBA;
		newM.arcA = original.arcA;
		newM.endL = original.endL;
		newM.endR = original.endR;
		newM.gp = original.gp;
		newM.polygon = original.polygon;
		newM.gpShapes = original.gpShapes;
		newM.fillShape = original.fillShape;
		newM.curveB = original.curveB;
		newM.curveBA = original.curveBA;
		newM.curveA = original.curveA;
		newM.noPartsTop1 = original.noPartsTop1;
		newM.noPartsTop2 = original.noPartsTop2;
		newM.noPartsTop3 = original.noPartsTop3;
		newM.noPartsBot1 = original.noPartsBot1;
		newM.noPartsBot2 = original.noPartsBot2;
		newM.noPartsBot3 = original.noPartsBot3;
		newM.noPartsLeft = original.noPartsLeft;
		newM.noPartsRight = original.noPartsRight;
		newM.glazedOut = original.glazedOut;
		newM.top1 = original.top1;
		newM.bot1 = original.bot1;
		newM.levelW = original.levelW;
		newM.levelH = original.levelH;
		newM.leftInf = original.leftInf;
		newM.rightInf = original.rightInf;
		newM.poly = original.poly;
		newM.remove = original.remove;
		newM.deltaX = original.deltaX;

		newM.parentid = original.parentid;
		newM.rowCol = original.rowCol;
		newM.continuity = original.continuity;
		newM.partDimBtoC = original.partDimBtoC;
		newM.startPos = original.startPos;
		newM.endPos = original.endPos;
		newM.centerXsa = original.centerXsa;
		newM.centerYsa = original.centerYsa;
		newM.centerXea = original.centerXea;
		newM.centerYea = original.centerYea;
		newM.x1al = original.x1al;
		newM.y1al = original.y1al;
		newM.x2cl = original.x2cl;
		newM.y2cl = original.y2cl;
		newM.x3cl = original.x3cl;
		newM.y3cl = original.y3cl;
		newM.x4al = original.x4al;
		newM.y4al = original.y4al;
		newM.centerXs = original.centerXs;
		newM.centerYs = original.centerYs;
		newM.centerXe = original.centerXe;
		newM.centerYe = original.centerYe;
		newM.scale = original.scale;
		newM.thickness = original.thickness;
		newM.orientation = original.orientation;
		newM.frameLTid = original.frameLTid;
		newM.frameRBid = original.frameRBid;
		newM.centralAnglec = original.centralAnglec;
		newM.centralAnglec1 = original.centralAnglec1;
		newM.centralAnglea1 = original.centralAnglea1;
		newM.centralAnglea = original.centralAnglea;
		newM.radius1c = original.radius1c;
		newM.radius1c1 = original.radius1c1;
		newM.radius1a1 = original.radius1a1;
		newM.radius1a = original.radius1a;
		newM.arcH = original.arcH;
		newM.startAnglec = original.startAnglec;
		newM.endAnglec = original.endAnglec;
		newM.startAnglec1 = original.startAnglec1;
		newM.endAnglec1 = original.endAnglec1;
		newM.startAnglea1 = original.startAnglea1;
		newM.endAnglea1 = original.endAnglea1;
		newM.startAnglea = original.startAnglea;
		newM.endAnglea = original.endAnglea;
		newM.couplerTypeID = original.couplerTypeID;
		newM.openingLT = original.openingLT;
		newM.openingRB = original.openingRB;
		newM.whichPos = original.whichPos;
		newM.baseRT = original.baseRT;
		newM.baseLB = original.baseLB;
		newM.baseCenter = original.baseCenter;
		newM.newAlpha = original.newAlpha;
		newM.newStartingYRT = original.newStartingYRT;
		newM.newStartingXRT = original.newStartingXRT;
		newM.newAlpha2 = original.newAlpha2;
		newM.newStartingYLB = original.newStartingYLB;
		newM.newStartingXLB = original.newStartingXLB;
		newM.newAlpha3 = original.newAlpha3;
		newM.newStartingYCenter = original.newStartingYCenter;
		newM.newStartingXCenter = original.newStartingXCenter;
		newM.newAlphaA = original.newAlphaA;
		newM.newAlphaC = original.newAlphaC;
		newM.baseLBa = original.baseLBa;
		newM.baseRTc = original.baseRTc;
		newM.newStartingXLBa = original.newStartingXLBa;
		newM.newStartingXRTc = original.newStartingXRTc;
		newM.newStartingYLBa = original.newStartingYLBa;
		newM.newStartingYRTc = original.newStartingYRTc;
		newM.newBeta = original.newBeta;
		newM.theta = original.theta;
		newM.alpha = original.alpha;
		newM.newYLeft = original.newYLeft;
		newM.newYRight = original.newYRight;
		newM.newYCenter = original.newYCenter;
		newM.newXcenterStart = original.newXcenterStart;
		newM.tempDelta = original.tempDelta;
		newM.isBefore = original.isBefore;
		newM.endCID = original.endCID;
		newM.startCID = original.startCID;
		newM.isValid = original.isValid;
		newM.isExtra = original.isExtra;
		newM.joinM = original.joinM;
		newM.posCondition = original.posCondition;
		newM.mType = original.mType;
		newM.remove = original.remove;
		newM.exists = original.exists;
		newM.potentialS = original.potentialS;
		newM.delta = original.delta;
		newM.startIn = original.startIn;
		newM.endIn = original.endIn;
		newM.partLeft = original.partLeft;
		newM.partRight = original.partRight;
		newM.cOrM = original.cOrM;
		newM.x1a = original.x1a;
		newM.y1a = original.y1a;
		newM.x2a = original.x2a;
		newM.y2a = original.y2a;
		newM.x3a = original.x3a;
		newM.y3a = original.y3a;
		newM.x4a = original.x4a;
		newM.y4a = original.y4a;
		newM.x1b = original.x1b;
		newM.y1b = original.y1b;
		newM.x2b = original.x2b;
		newM.y2b = original.y2b;
		newM.x3b = original.x3b;
		newM.y3b = original.y3b;
		newM.x4b = original.x4b;
		newM.y4b = original.y4b;
		newM.x1a3 = original.x1a3;
		newM.y1a3 = original.y1a3;
		newM.x2a3 = original.x2a3;
		newM.y2a3 = original.y2a3;
		newM.x3a3 = original.x3a3;
		newM.y3a3 = original.y3a3;
		newM.x4a3 = original.x4a3;
		newM.y4a3 = original.y4a3;
		newM.drawcoupler = original.drawcoupler;
		newM.followFrame = original.followFrame;
		newM.whichFrame = original.whichFrame;
		newM.isNew = original.isNew;
		newM.openingTypeLB = original.openingTypeLB;
		newM.openingIDLB = original.openingIDLB;
		newM.openingTypeRT = original.openingTypeRT;
		newM.openingIDRT = original.openingIDRT;
		newM.manualPos = original.manualPos;

		return newM;
	}

	public double intersectX(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

		double x = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0) {
			return x;
		} else {
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			// if (z == 0 || z == 1) {
			// return x; // intersection at end
			// point!
			// }
			x = px + z * rx;// ,
			// (double)(py+z*ry));
		}
		return x;// , (double)(py+z*ry));

	} // end intersection line-line

	public double intersectY(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

		double y = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0) {
			return y;
		} else {
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			// if (z == 0 || z == 1) {
			// return y; // intersection at end
			// point!
			// }
			y = py + z * ry;
		}
		return y;
	} // end intersection l

	public Point2D getIntersectionLineArc(
			//
			final double bsX,
			final double bsY, //
			final double w,
			final double h, //
			final double sA,
			final double eA, //
			final double cX, final double cY, final double sX, final double sY,
			final double eX, final double eY, final int pos, final boolean isP) {

		Point2D myP = new Point2D.Double();

		// if (pos == 1)
		// {// Top Part

		final Point2D myPs = new Point2D.Double(sX, sY);
		final Point2D myPe = new Point2D.Double(eX, eY);

		myP = this.getLineCircleIntersection(bsX, bsY, w, h, cX, cY, myPs,
				myPe, isP);
		// }

		return myP;

	}

	public Point2D getLineCircleIntersection(final double bsX,
			final double bsY, final double wW, final double hH,
			final double centerX, final double centerY, final Point2D source,
			final Point2D p, final boolean isP) {

		// final Rectangle2D r = view.getBounds2D();

		final double a = wW / 2;// r.getWidth() +
		// 1;/// 2;
		final double b = hH / 2;// r.getHeight() +
		// 1;// / 2;

		// x0,y0 - center of ellipse
		final double x0 = centerX;// view.getCenterX();//x
		// +
		// a;
		final double y0 = centerY;// view.getCenterY();//y
		// +
		// b;

		// x1, y1 - point

		double x1 = 0; // was p
		double y1 = 0;
		if (!isP) {
			x1 = source.getX(); // was p
			y1 = source.getY();
		} else {
			x1 = p.getX();
			y1 = p.getY();
		}

		final double dx = x1 - x0;
		final double dy = y1 - y0;

		if (dx == 0) {
			return new Point2D.Double(x0, (y0 + b * dy / Math.abs(dy)));
		}

		final double d = dy / dx;
		final double h = y0 - d * x0;

		// Calculates intersection
		final double e = a * a * d * d + b * b;
		final double f = -2 * x0 * e;
		final double g = a * a * d * d * x0 * x0 + b * b * x0 * x0 - a * a * b
				* b;

		final double det = Math.sqrt(f * f - 4 * e * g);

		// Two solutions (perimeter points)
		final double xout1 = (-f + det) / (2 * e);
		final double xout2 = (-f - det) / (2 * e);
		final double yout1 = d * xout1 + h;
		final double yout2 = d * xout2 + h;

		final double dist1 = Math.sqrt(Math.pow((xout1 - x1), 2)
				+ Math.pow((yout1 - y1), 2));
		final double dist2 = Math.sqrt(Math.pow((xout2 - x1), 2)
				+ Math.pow((yout2 - y1), 2));

		// Correct solution
		double xout, yout;

		if (dist1 < dist2) {
			xout = xout1;
			yout = yout1;
		} else {
			xout = xout2;
			yout = yout2;
		}

		return new Point2D.Double(xout, yout);
	}

	public double[] getArchesAngles(final double sXp, final double eXp,
			final double sYp, final double eYp, final double radiusp,
			final double x1p, final double y1p, final boolean useYL,
			final boolean useYR) {

		final double sX = (int) (sXp * 1000) / 1000f;
		final double eX = (int) (eXp * 1000) / 1000f;
		final double sY = (int) (sYp * 1000) / 1000f;
		final double eY = (int) (eYp * 1000) / 1000f;
		double radius = (int) (radiusp * 1000) / 1000f;

		final double x1 = (int) (x1p * 1000) / 1000f;
		final double y1 = (int) (y1p * 1000) / 1000f;

		final double[] myAngles = new double[4];
		double startAngle = 0;
		double endAngle = 0;
		double extentAngle = 0;
		double baseR = 0;
		double baseL = 0;
		double hR = 0;
		double hL = 0;
		double yS = 0;
		double yE = 0;
		if (!useYR) {
			if (x1 > sX && x1 <= eX) {
				baseR = (int) ((eX - x1) * 1000) / 1000f;
				if (Math.abs(baseR - radius) <= 0.01) {
					baseR = radius = Math.max(baseR, radius);
				}
				startAngle = Math
						.abs(Math.toDegrees(Math.acos(baseR / radius)));
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}

				hR = radius * Math.sin(Math.toRadians(startAngle));

				yE = y1 - hR;

			} else if (x1 > eX) {
				baseR = (int) ((x1 - eX) * 1000) / 1000f;// x1
				// - eX;
				if (Math.abs(baseR - radius) <= 0.01) {
					baseR = radius = Math.max(baseR, radius);
				}
				startAngle = 180 - Math.abs(Math.toDegrees(Math.acos(baseR
						/ radius)));
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}

				hR = radius * Math.sin(Math.abs(Math.acos(baseR / radius)));

				yE = y1 - hR;

			} else if (x1 <= sX) {
				baseR = (int) ((eX - x1) * 1000) / 1000f;// eX
				// - x1;
				if (Math.abs(baseR - radius) <= 0.01) {
					baseR = radius = Math.max(baseR, radius);
				}
				startAngle = Math
						.abs(Math.toDegrees(Math.acos(baseR / radius)));
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}

				hR = radius * Math.sin(Math.toRadians(startAngle));

				yE = y1 - hR;

			}

		} else {
			if (x1 > sX && x1 <= eX) {
				baseR = (int) ((eX - x1) * 1000) / 1000f;// eX
				// - x1
				if (Math.abs(baseR - radius) <= 0.01) {
					baseR = radius = Math.max(baseR, radius);
				}
				hR = (int) ((y1 - eY) * 1000) / 1000f;// y1
				// - eY;

				startAngle = Math.abs(Math.toDegrees(Math.atan(hR / baseR)));
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}

				yE = eY;

			} else if (x1 > eX) {
				baseR = (int) ((x1 - eX) * 1000) / 1000f;// x1
				// - eX;

				hR = (int) ((y1 - eY) * 1000) / 1000f;// y1
				// - eY;

				startAngle = 180 - Math.abs(Math.toDegrees(Math
						.atan(hR / baseR)));
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}

				yE = eY;

			} else if (x1 <= sX) {
				baseR = (int) ((eX - x1) * 1000) / 1000f;// eX
				// - x1;
				hR = (int) ((y1 - eY) * 1000) / 1000f;// y1
				// - eY;
				startAngle = Math.abs(Math.toDegrees(Math.atan(hR / baseR)));
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}

				yE = eY;

			}

		}

		// endAngles Start Here

		if (!useYL) {
			if (x1 > sX && x1 <= eX) {

				baseL = (int) ((x1 - sX) * 1000) / 1000f;// x1
				// - sX;

				endAngle = Math.abs(Math.toDegrees(Math.acos(baseL / radius)));
				if (Double.isNaN(endAngle)) {
					endAngle = 180;
				}

				hL = radius * Math.sin(Math.toRadians(endAngle));

				yS = y1 - hL;

			} else if (x1 > eX) {

				baseL = (int) ((x1 - sX) * 1000) / 1000f;// x1
				// - sX;
				if (Math.abs(baseR - radius) <= 0.01) {
					baseR = radius = Math.max(baseR, radius);
				}
				endAngle = Math.abs(Math.toDegrees(Math.acos(baseL / radius)));
				if (Double.isNaN(endAngle)) {
					endAngle = 0;
				}

				hL = radius * Math.sin(Math.toRadians(endAngle));

				yS = y1 - hL;

			} else if (x1 <= sX) {

				baseL = (int) ((sX - x1) * 1000) / 1000f;// sX
				// - x1;
				if (Math.abs(baseR - radius) <= 0.01) {
					baseR = radius = Math.max(baseR, radius);
				}
				endAngle = Math.abs(Math.toDegrees(Math.acos(baseL / radius)));
				if (Double.isNaN(endAngle)) {
					endAngle = 0;
				}

				hL = radius * Math.sin(Math.toRadians(endAngle));

				yS = y1 - hL;
			}

		} else {
			if (x1 > sX && x1 <= eX) {

				baseL = (int) ((x1 - sX) * 1000) / 1000f;// x1
				// - sX;

				hL = (int) ((y1 - sY) * 1000) / 1000f;// y1
				// - sY;

				endAngle = Math.abs(Math.toDegrees(Math.atan(hL / baseL)));
				if (Double.isNaN(endAngle)) {
					endAngle = 0;
				}

				yS = sY;

			} else if (x1 > eX) {

				baseL = (int) ((x1 - sX) * 1000) / 1000f;// x1
				// - sX;
				hL = (int) ((y1 - sY) * 1000) / 1000f;// y1
				// - sY;
				endAngle = Math.abs(Math.toDegrees(Math.atan(hL / baseL)));
				if (Double.isNaN(endAngle)) {
					endAngle = 0;
				}

				yS = sY;

			} else if (x1 <= sX) {

				baseL = (int) ((sX - x1) * 1000) / 1000f;// sX
				// - x1;
				hL = (int) ((y1 - sY) * 1000) / 1000f;// y1
				// - sY;

				endAngle = Math.abs(Math.toDegrees(Math.atan(hL / baseL)));
				if (Double.isNaN(endAngle)) {
					endAngle = 0;
				}
				// extentAngle = endAngle -
				// startAngle;

				yS = sY;
			}

		}

		if (x1 > sX && x1 <= eX) {
			extentAngle = 180 - (endAngle + startAngle);
		} else if (x1 > eX) {
			extentAngle = 180 - (endAngle + startAngle);
		} else if (x1 <= sX) {
			extentAngle = endAngle - startAngle;
		}

		myAngles[0] = startAngle;
		myAngles[1] = extentAngle;
		myAngles[2] = yS;
		myAngles[3] = yE;

		return myAngles;

		// top2
	}

	/**
	 * Create Grid Parts Mid Align
	 * 
	 * @param dlo
	 *            , DLO
	 * @return DLO
	 */
	public DLO createGridPartsMidAlign(DLO dlo) {

		dlo.yRows = dlo.anchorsH.size() + 1;
		dlo.xCols = dlo.anchorsV.size() + 1;

		dlo.bOpeningObject.yRows = dlo.yRows;

		dlo.bOpeningObject.xCols = dlo.xCols;

		dlo = this.doMullionsFromPartsV(dlo);
		dlo = this.doMullionsFromPartsH(dlo);

		if (myGrid.getContinuityIn() != 1 && myGrid.getContinuityIn() != 3) {
			dlo = this.doMergeGridParts(dlo);
			dlo = this.doMergeGridPartsH(dlo);
		}

		Object[] myVs = dlo.gridPartsV.toArray();

		dlo.gridPartsH.toArray();
		dlo.gridPartsV.clear();
		dlo.gridPartsH.clear();

		Object[] myVms = dlo.bOpeningObject.mullions.toArray();
		Object[] myHms = dlo.bOpeningObject.mullionsH.toArray();

		Object[] myMasksV = dlo.gridMasksV.toArray();

		dlo.gridMasksV.clear();

		int countv = 0;
		int counth = 0;

		AddMullionV mV = new AddMullionV(dlo.bOpeningObject, myFrame2.jobItem,
				myFrame2, 7);
		AddMullionH mH = new AddMullionH(dlo.bOpeningObject, myFrame2.jobItem,
				myFrame2, 7);

		CalculateGridV calcMullion = new CalculateGridV(mV);
		CalculateMullionHii calcMullionH = new CalculateMullionHii(mH);
		for (Object myV : myVms) {

			counth = 0;
			countv++;
			if (counth == 0 || myHms.length == 0) {
				dlo = this.doFirstV(dlo, mV, calcMullion, myVms, myHms,
						myMasksV, counth, myV);
			}

			for (Object myH : myHms) {
				counth++;
				if (counth + 1 < dlo.yRows) {
					dlo = this.doInMidlleV(dlo, mV, calcMullion, myVms, myHms,
							myMasksV, myV, myH);
				} else if (counth + 1 == dlo.yRows) {
					dlo = this.doLastV(dlo, mV, calcMullion, myVms, myHms,
							myMasksV, myV, myH);

				}
			}

		}

		Object[] returns = new Object[2];

		for (Object myH : myHms) {

			countv = 0;
			counth++;

			if (countv == 0 || myVs.length == 0) {
				returns = this.doFirstH(dlo, mH, calcMullionH, countv, myH,
						myVms, myHms, false);

				Boolean.parseBoolean(returns[0].toString());
				dlo = (DLO) returns[1];
			}

			for (final Object myV : myVms) {
				countv++;
				if (countv + 1 < dlo.xCols) {
					dlo = this.doInMiddleH(dlo, mH, calcMullionH, myVms, myHms,
							myH, myV);
				} else if (countv + 1 == dlo.xCols) {
					dlo = this.doLastH(dlo, mH, calcMullionH, myVms, myHms,
							myH, myV);
				}
			}

		}

		dlo.gridPartsV.toArray();

		if (dlo.gridType % 2 != 0) {
			dlo = this.doMullionsFromPartsV(dlo);
			dlo = this.doMullionsFromPartsH(dlo);
			dlo.bOpeningObject = dlo.doMullions(dlo.bOpeningObject);
		}

		// ************************************************************
		// Execute Rules
		// ************************************************************
		executeGridPartRules(dlo);

		return dlo;
	}

	/**
	 * Add not repeated double values to list
	 * 
	 * @param values
	 *            , List
	 * @param value
	 *            , value to add
	 * @return List
	 */
	public List<Double> addValueToList(List<Double> values, Double value) {

		Collections.sort(values);

		for (Double number : values) {
			if (number.equals(value)) {
				return values;
			}
		}

		// Add value
		values.add(value);

		// Sort collection
		Collections.sort(values);

		return values;
	}

	private DLO doVsBelowHRGridsOLD(DLO dlo) {
		Object[] myHs;
		int oddCol = 0;

		// DLOs
		if (dlo.gridForm >= 1) {

			if (dlo.noSides > 3) {

				Profiles myFirstH = new Profiles();
				Object[] myHG = dlo.bOpeningObject.mullionsH.toArray();

				// myFirstH = dlo.bot1Part;
				boolean countBelow = false;
				if (myFrame2.compareTwoDoubles(dlo.widthPix / 2, dlo.radius1)) {
					for (Object hg : myHG) {
						if (((Profiles) hg).y1 > dlo.startingY) {
							myFirstH = (Profiles) hg;
							countBelow = true;
							break;
						}
					}

					if (dlo.top1Part.startAngle + dlo.top1Part.endAngle <= 90) {
						for (Object hg : myHG) {
							if (((Profiles) hg).y4 > dlo.bY2) {

								myFirstH = (Profiles) hg;
								break;
							}
						}
					}

				} else {
					if (dlo.xCols % 2 == 0) {

						oddCol = (int) Math.ceil(dlo.xCols / 2);

					}
				}

				Object[] myVG = dlo.bOpeningObject.mullions.toArray();
				dlo.bOpeningObject.mullions.clear();

				for (Object vg : myVG) {
					if (((Profiles) vg).rowCol == oddCol && oddCol > 0) {
						((Profiles) vg).startPos = 1;

						((Profiles) vg).y1 = ((Profiles) vg).y1al = dlo.highestY;
						((Profiles) vg).y2 = ((Profiles) vg).y2cl = dlo.highestY;

						((Profiles) vg).orientation = 1;
						dlo.bOpeningObject.mullions.add(vg);
						continue;
					} else if (myFirstH.y1 > 0) {
						((Profiles) vg).startPos = myFirstH.rowCol + 1;
						((Profiles) vg).orientation = 1;
						dlo.bOpeningObject.mullions.add(vg);
					}
				}

				Object[] myModVs = dlo.gridPartsV.toArray();

				dlo.gridPartsV.clear();

				for (Object v : myModVs) {

					if (((Profiles) v).rowCol == oddCol && oddCol > 0) {
						dlo.gridPartsV.add(v);

					} else {

						if ((dlo.top1Part.startAngle < 90
								&& dlo.top1Part.startAngle
										+ dlo.top1Part.endAngle > 90 || dlo.top1Part.startAngle > 90)
								&& (int) (((Profiles) v).y4 * 100) / 100 <= (int) (dlo.startingY * 100) / 100
								|| dlo.top1Part.startAngle
										+ dlo.top1Part.endAngle <= 90
								&& (int) (((Profiles) v).y4 * 100) / 100 <= (int) (dlo.bY2 * 100) / 100) {

						} else {

							for (Object hg : myHG) {

								if (((Profiles) hg).partForm > 1) {

									double myY = myFirstH.y2;
									if (myFirstH.y2 == 0) {
										myY = ((Profiles) hg).bkgrdStartY;
									}

									if (((countBelow && ((Profiles) v).y4 <= myY) || (!countBelow && (((Profiles) v).y4 >= myY && ((Profiles) v).y1 <= myY)))
											&& (((Profiles) v).rowCol == ((Profiles) hg).startPos || ((Profiles) v).rowCol == ((Profiles) hg).endPos)) {

										if (((Profiles) v).rowCol == ((Profiles) hg).startPos) {

											xyIntersectionLeft(v, hg);

											break;

										} else {

											xyIntersectionRight(v, hg);

											break;
										}

									}

								}

							}

							if (myFrame2.compareTwoDoubles(dlo.widthPix / 2,
									dlo.radius1) && myFirstH.y2 > 0) {
								dlo.gridPartsV.add(v);
							} else {
								dlo.gridPartsV.add(v);
							}

						}
					}
				}
			} else {
				dlo.bOpeningObject.mullions.clear();
				dlo.gridPartsV.clear();
			}

		}
		return dlo;
	}

}
