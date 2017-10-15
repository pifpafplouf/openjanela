/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;

import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import openjanela.app.configuration.controller.calculation.GlassCalculationController;
import openjanela.model.entities.admin.SystemUOM;
import openjanela.model.entities.partner.Color;
import openjanela.model.entities.partner.PartnerLineDiscount;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.parts.PartsFamily;
import Model.DesignGlass;
import Model.GlassSU;
import Model.OpeningObject;
import Model.ShapeObject;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;
import org.openjanela.data.ApplicationBaseApp;

import javax.swing.*;


public class CreateGlass {

	public OpeningObject myParentFO;

	Collection xCoordB = new ArrayList();

	Collection yCoordB = new ArrayList();

	Object[] xCoordBo = null;

	Object[] yCoordBo = null;

	double myX = 0;

	double myY = 0;

	BigDecimal scale = new BigDecimal(0);

	ItemFrame myFrame2 = null;

	SUType mySUType = null;

	public CreateGlass(OpeningObject frame, ItemFrame frame2) {

		this.myParentFO = frame;
		this.myFrame2 = frame2;
		this.scale = this.myFrame2.scale;

		if (myFrame2.myTopPanel.metric.isSelected()) {
			scale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			scale = myFrame2.scale;
		}

	}

	@SuppressWarnings("unused")
	public GlassSU doGlass(SUType sutype) throws Exception {
		
		GlassSU myGlass = new GlassSU() ;
				
		this.mySUType = null;

		if (sutype != null) {
			this.mySUType = sutype;
		} else if (myFrame2.glassPanel.whichPos == 1 && myFrame2.currentSUIn != null) {
			this.mySUType = myFrame2.currentSUIn;
		} else if (myFrame2.glassPanel.whichPos == 2 && myFrame2.currentSUMid != null) {
			this.mySUType = myFrame2.currentSUMid;
		} else if (myFrame2.glassPanel.whichPos == 23 && myFrame2.currentSUOut != null) {
			this.mySUType = myFrame2.currentSUOut;
		}

        if (this.mySUType == null) {
            this.myFrame2.glassPanel.setDefaultSU();
            this.mySUType = myFrame2.mySelectedSU;
        }
        
        setInitValues(myGlass);

        myGlass = this.initSashLeaf(this.myParentFO.topIn, this.myParentFO.botIn, this.myParentFO.leftIn,
					this.myParentFO.rightIn, mySUType);
        
        setInitValues(myGlass);
		
		myGlass.top1Part.endTypeLTByUser = false;
		myGlass.top2Part.endTypeLTByUser = false;
		myGlass.top3Part.endTypeLTByUser = false;
		myGlass.bot1Part.endTypeLTByUser = false;
		myGlass.bot2Part.endTypeLTByUser = false;
		myGlass.bot3Part.endTypeLTByUser = false;
		myGlass.leftPart.endTypeLTByUser = false;
		myGlass.rightPart.endTypeLTByUser = false;

		myGlass.top1Part.endTypeRBByUser = false;
		myGlass.top2Part.endTypeRBByUser = false;
		myGlass.top3Part.endTypeRBByUser = false;
		myGlass.bot1Part.endTypeRBByUser = false;
		myGlass.bot2Part.endTypeRBByUser = false;
		myGlass.bot3Part.endTypeRBByUser = false;
		myGlass.leftPart.endTypeRBByUser = false;
		myGlass.rightPart.endTypeRBByUser = false;

		CreateShapeMethods createShape = new CreateShapeMethods(this.myParentFO, 2, this.myFrame2);

		Object[] returns = this.setPartDims(myGlass, createShape);

		myGlass = (GlassSU) returns[0];
		createShape = (CreateShapeMethods) returns[1];
		createShape.getClearance(myGlass);
		myGlass = (GlassSU) createShape.doShapeBkgrd(myGlass);

		myGlass = (GlassSU) createShape.makeSides(myGlass);
		myGlass = (GlassSU) createShape.makeSidesStraight(myGlass);
		myGlass = (GlassSU) createShape.doParts(myGlass, true);
		myGlass = (GlassSU) createShape.setBaseInfo(myGlass, 1, true);

		myGlass.setPartObjectsFromProfiles();

		// Recheck and Calculate Nominal Dimensions for Glass
		getNominalDims(myGlass);

        // Recheck Size and Find Next Glass if necessary
        if (mySUType != null) {
            try {
                if (myGlass.widthI > 0 && myGlass.heightI > 0 && myGlass.widthM > 0 && myGlass.heightM > 0) {
                    configSUTypeGlassSU(myGlass, mySUType);
                }
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }

        myGlass.gp = createShape.doGeneralPathOpeningII(myGlass);

		myGlass.bOpeningObject = myGlass.doMainOpening();
		myGlass.bOpeningObject.unGlazed = true;

        //**************************************************************
		// Create DesignGlass and add it to glassBOM for design
        //**************************************************************
        DesignGlass glassBOM = this.setDesignGlass(myGlass, mySUType);
        if (glassBOM != null) {
            //Clear glass Bom collection
            myGlass.getGlassBom().clear();
		    myGlass.getGlassBom().add(glassBOM);
        }

		myGlass.shapeChanged = false;
		
		
		return myGlass;

	}

	private void setInitValues(GlassSU myGlass) {
		myGlass.openingClass = myParentFO.openingClass;
		myGlass.userDefinedOpeningID = myParentFO.userDefinedOpeningID;
	}

	public void getNominalDims(GlassSU myGlass) {
		myGlass.widthIN = this.myParentFO.widthIN;
		myGlass.widthMN = this.myParentFO.widthMN;
		myGlass.heightIN = this.myParentFO.heightIN;
		myGlass.heightMN = this.myParentFO.heightMN;

	}

	public GeneralPath doGeneralPathGlass(final Profiles part) {

		final GeneralPath myOpen = new GeneralPath();

		myOpen.moveTo((int) part.startXC, (int) part.startYC);

		if (part.partForm == 2) {
			Arc2D mytopb = new Arc2D.Double(part.bkgrdStartXBA, part.bkgrdStartYBA, part.bkgrdWidthBA, part.bkgrdHeightBA,
						part.startAngleBA, part.endAngleBA, Arc2D.OPEN);

			this.xCoordB = new ArrayList();
			this.yCoordB = new ArrayList();
			this.getPoints(mytopb, 1, part.startXC);

			this.xCoordBo = this.xCoordB.toArray();
			this.yCoordBo = this.yCoordB.toArray();

			myOpen.moveTo((int) part.startXC, (int) part.startYC);

			for (int i = this.xCoordBo.length; i >= 1; i--) {
				if ((Double) this.xCoordBo[i - 1] >= 0) {
					myOpen.lineTo(((Double) this.xCoordBo[i - 1]), ((Double) this.yCoordBo[i - 1]));
				}
			}

		} else {
			myOpen.lineTo((int) part.endXC, (int) part.endYC);

		}
		myOpen.lineTo((int) part.endXA, (int) part.endYA);

		if (part.partForm == 2) {

			Arc2D mytopa = new Arc2D.Double(part.bkgrdStartXA, part.bkgrdStartYA, part.bkgrdWidthA, part.bkgrdHeightA,
						part.startAngleA, part.endAngleA, Arc2D.OPEN);
			this.xCoordB = new ArrayList();
			this.yCoordB = new ArrayList();
			this.getPoints(mytopa, 1, part.startXA);

			this.xCoordBo = this.xCoordB.toArray();
			this.yCoordBo = this.yCoordB.toArray();

			for (int i = 0; i < this.xCoordBo.length; i++) {
				myOpen.lineTo(((Double) this.xCoordBo[i]), ((Double) this.yCoordBo[i]));
			}

		} else {
			myOpen.lineTo((int) part.startXA, (int) part.startYA);
		}

		myOpen.lineTo((int) part.startXC, (int) part.startYC);

		return myOpen;

	}

	public void getPoints(Arc2D arc, int topBot, double startX) {

		double flatness = 0.0000001f;
		PathIterator pit = arc.getPathIterator(null, flatness);
		double[] coords = new double[6];
		int count = 0;

		while (!pit.isDone()) {
			int type = pit.currentSegment(coords);
			switch (type) {

			case PathIterator.SEG_MOVETO:
				this.myX = coords[0];
				this.myY = coords[1];
				this.xCoordB.add(this.myX);
				this.yCoordB.add(this.myY);
				count++;
				break;

			case PathIterator.SEG_LINETO:
				if (coords[0] > 0) {
					this.myX = coords[0];
					this.myY = coords[1];
					if (topBot == 1) {
						if (this.myX >= startX) {
							this.xCoordB.add(this.myX);
							this.yCoordB.add(this.myY);
						}
					} else {
						if (this.myX <= startX) {

							this.xCoordB.add(this.myX);
							this.yCoordB.add(this.myY);
						}
					}
				}
				count++;
				break;
			default:
				System.out.println("unexpected type: " + type);
			}
			pit.next();
		}
	}

	public GlassSU initSashLeaf(boolean topIn, boolean botIn, boolean leftIn, boolean rightIn, SUType sutype) throws Exception {

		GlassSU myGlass = new GlassSU(this.myParentFO, this.myFrame2);
		myGlass = (GlassSU) myGlass.cloneShapeFromParentOpening(myParentFO);
		if(sutype.getId()!=null && sutype.getId()>0){
            configSUTypeGlassSU(myGlass, sutype);
		}
		
		if (myFrame2.hasGrids) {

			myGlass.gridType = myFrame2.gridsPanel.myGrid.getGridTypeId();
			myGlass.gridID = myFrame2.gridsPanel.myGrid.getId();
			
		}
		
		myGlass.options.clear();
		myGlass.executeOptionRules("createGlass.initSashLeaf.385");
		myGlass.executeClearanceRules();
		
		return myGlass;
	}

	public Object[] setPartDims(GlassSU mySashLeaf, CreateShapeMethods createShape) {

		Object[] myreturns = new Object[2];

		mySashLeaf.executePartRules(false, false, "createGlass.setpartDims.397");


		mySashLeaf.top1Part.lengthMN = (int) (mySashLeaf.top1Part.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.top1Part.lengthIN = (int) (mySashLeaf.top1Part.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.top2Part.lengthMN = (int) (mySashLeaf.top2Part.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.top2Part.lengthIN = (int) (mySashLeaf.top2Part.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.top3Part.lengthMN = (int) (mySashLeaf.top3Part.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.top3Part.lengthIN = (int) (mySashLeaf.top3Part.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.bot1Part.lengthMN = (int) (mySashLeaf.bot1Part.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.bot1Part.lengthIN = (int) (mySashLeaf.bot1Part.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.bot2Part.lengthMN = (int) (mySashLeaf.bot2Part.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.bot2Part.lengthIN = (int) (mySashLeaf.bot2Part.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.bot3Part.lengthMN = (int) (mySashLeaf.bot3Part.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.bot3Part.lengthIN = (int) (mySashLeaf.bot3Part.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.leftPart.lengthMN = (int) (mySashLeaf.leftPart.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.leftPart.lengthIN = (int) (mySashLeaf.leftPart.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf.rightPart.lengthMN = (int) (mySashLeaf.rightPart.length / myFrame2.metricscale.doubleValue());
		mySashLeaf.rightPart.lengthIN = (int) (mySashLeaf.rightPart.length / myFrame2.imperialscale.doubleValue());

		mySashLeaf = (GlassSU) this.myFrame2.shapeColor.setShapeObjectPartColors(mySashLeaf);

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			createShape.top1DimBo = createShape.top1DimB = mySashLeaf.top1Part.partDimB = mySashLeaf.top1Part.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.top1DimAo = createShape.top1DimA = mySashLeaf.top1Part.partDimA = mySashLeaf.top1Part.partDimAi = 0;
			createShape.top1DimCo = createShape.top1DimC = mySashLeaf.top1Part.partDimC = mySashLeaf.top1Part.partDimCi = 0;
			createShape.top1DimMo = createShape.top1DimM = mySashLeaf.top1Part.partDimM = mySashLeaf.top1Part.partDimMi = 0;

			createShape.top2DimBo = createShape.top2DimB = mySashLeaf.top2Part.partDimB = mySashLeaf.top2Part.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.top2DimAo = createShape.top2DimA = mySashLeaf.top2Part.partDimA = mySashLeaf.top2Part.partDimAi = 0;
			createShape.top2DimCo = createShape.top2DimC = mySashLeaf.top2Part.partDimC = mySashLeaf.top2Part.partDimCi = 0;
			createShape.top2DimMo = createShape.top2DimM = mySashLeaf.top2Part.partDimM = mySashLeaf.top2Part.partDimMi = 0;

			createShape.top3DimBo = createShape.top3DimB = mySashLeaf.top3Part.partDimB = mySashLeaf.top3Part.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.top3DimAo = createShape.top3DimA = mySashLeaf.top3Part.partDimA = mySashLeaf.top3Part.partDimAi = 0;
			createShape.top3DimCo = createShape.top3DimC = mySashLeaf.top3Part.partDimC = mySashLeaf.top3Part.partDimCi = 0;
			createShape.top3DimMo = createShape.top3DimM = mySashLeaf.top3Part.partDimM = mySashLeaf.top3Part.partDimMi = 0;

			createShape.bot1DimBo = createShape.bot1DimB = mySashLeaf.bot1Part.partDimB = mySashLeaf.bot1Part.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.bot1DimAo = createShape.bot1DimA = mySashLeaf.bot1Part.partDimA = mySashLeaf.bot1Part.partDimAi = 0;
			createShape.bot1DimCo = createShape.bot1DimC = mySashLeaf.bot1Part.partDimC = mySashLeaf.bot1Part.partDimCi = 0;
			createShape.bot1DimMo = createShape.bot1DimM = mySashLeaf.bot1Part.partDimM = mySashLeaf.bot1Part.partDimMi = 0;

			createShape.bot2DimBo = createShape.bot2DimB = mySashLeaf.bot2Part.partDimB = mySashLeaf.bot2Part.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.bot2DimAo = createShape.bot2DimA = mySashLeaf.bot2Part.partDimA = mySashLeaf.bot2Part.partDimAi = 0;
			createShape.bot2DimCo = createShape.bot2DimC = mySashLeaf.bot2Part.partDimC = mySashLeaf.bot2Part.partDimCi = 0;
			createShape.bot2DimMo = createShape.bot2DimM = mySashLeaf.bot2Part.partDimM = mySashLeaf.bot2Part.partDimMi = 0;

			createShape.bot3DimBo = createShape.bot3DimB = mySashLeaf.bot3Part.partDimB = mySashLeaf.bot3Part.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.bot3DimAo = createShape.bot3DimA = mySashLeaf.bot3Part.partDimA = mySashLeaf.bot3Part.partDimAi = 0;
			createShape.bot3DimCo = createShape.bot3DimC = mySashLeaf.bot3Part.partDimC = mySashLeaf.bot3Part.partDimCi = 0;
			createShape.bot3DimMo = createShape.bot3DimM = mySashLeaf.bot3Part.partDimM = mySashLeaf.bot3Part.partDimMi = 0;

			createShape.leftDimBo = createShape.leftDimB = mySashLeaf.leftPart.partDimB = mySashLeaf.leftPart.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.leftDimAo = createShape.leftDimA = mySashLeaf.leftPart.partDimA = mySashLeaf.leftPart.partDimAi = 0;
			createShape.leftDimCo = createShape.leftDimC = mySashLeaf.leftPart.partDimC = mySashLeaf.leftPart.partDimCi = 0;
			createShape.leftDimMo = createShape.leftDimM = mySashLeaf.leftPart.partDimM = mySashLeaf.leftPart.partDimMi = 0;

			createShape.rightDimBo = createShape.rightDimB = mySashLeaf.rightPart.partDimB = mySashLeaf.rightPart.partDimBi = this.mySUType
						.getGlassEdgeToSpacerIn()
						* myFrame2.metricscale.doubleValue();
			createShape.rightDimAo = createShape.rightDimA = mySashLeaf.rightPart.partDimA = mySashLeaf.rightPart.partDimAi = 0;
			createShape.rightDimCo = createShape.rightDimC = mySashLeaf.rightPart.partDimC = mySashLeaf.rightPart.partDimCi = 0;
			createShape.rightDimMo = createShape.rightDimM = mySashLeaf.rightPart.partDimM = mySashLeaf.rightPart.partDimMi = 0;
		} else {

			createShape.top1DimBo = createShape.top1DimB = mySashLeaf.top1Part.partDimB = mySashLeaf.top1Part.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.top1DimAo = createShape.top1DimA = mySashLeaf.top1Part.partDimA = mySashLeaf.top1Part.partDimAi = 0;
			createShape.top1DimCo = createShape.top1DimC = mySashLeaf.top1Part.partDimC = mySashLeaf.top1Part.partDimCi = 0;
			createShape.top1DimMo = createShape.top1DimM = mySashLeaf.top1Part.partDimM = mySashLeaf.top1Part.partDimMi = 0;

			createShape.top2DimBo = createShape.top2DimB = mySashLeaf.top2Part.partDimB = mySashLeaf.top2Part.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.top2DimAo = createShape.top2DimA = mySashLeaf.top2Part.partDimA = mySashLeaf.top2Part.partDimAi = 0;
			createShape.top2DimCo = createShape.top2DimC = mySashLeaf.top2Part.partDimC = mySashLeaf.top2Part.partDimCi = 0;
			createShape.top2DimMo = createShape.top2DimM = mySashLeaf.top2Part.partDimM = mySashLeaf.top2Part.partDimMi = 0;

			createShape.top3DimBo = createShape.top3DimB = mySashLeaf.top3Part.partDimB = mySashLeaf.top3Part.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.top3DimAo = createShape.top3DimA = mySashLeaf.top3Part.partDimA = mySashLeaf.top3Part.partDimAi = 0;
			createShape.top3DimCo = createShape.top3DimC = mySashLeaf.top3Part.partDimC = mySashLeaf.top3Part.partDimCi = 0;
			createShape.top3DimMo = createShape.top3DimM = mySashLeaf.top3Part.partDimM = mySashLeaf.top3Part.partDimMi = 0;

			createShape.bot1DimBo = createShape.bot1DimB = mySashLeaf.bot1Part.partDimB = mySashLeaf.bot1Part.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.bot1DimAo = createShape.bot1DimA = mySashLeaf.bot1Part.partDimA = mySashLeaf.bot1Part.partDimAi = 0;
			createShape.bot1DimCo = createShape.bot1DimC = mySashLeaf.bot1Part.partDimC = mySashLeaf.bot1Part.partDimCi = 0;
			createShape.bot1DimMo = createShape.bot1DimM = mySashLeaf.bot1Part.partDimM = mySashLeaf.bot1Part.partDimMi = 0;

			createShape.bot2DimBo = createShape.bot2DimB = mySashLeaf.bot2Part.partDimB = mySashLeaf.bot2Part.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.bot2DimAo = createShape.bot2DimA = mySashLeaf.bot2Part.partDimA = mySashLeaf.bot2Part.partDimAi = 0;
			createShape.bot2DimCo = createShape.bot2DimC = mySashLeaf.bot2Part.partDimC = mySashLeaf.bot2Part.partDimCi = 0;
			createShape.bot2DimMo = createShape.bot2DimM = mySashLeaf.bot2Part.partDimM = mySashLeaf.bot2Part.partDimMi = 0;

			createShape.bot3DimBo = createShape.bot3DimB = mySashLeaf.bot3Part.partDimB = mySashLeaf.bot3Part.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.bot3DimAo = createShape.bot3DimA = mySashLeaf.bot3Part.partDimA = mySashLeaf.bot3Part.partDimAi = 0;
			createShape.bot3DimCo = createShape.bot3DimC = mySashLeaf.bot3Part.partDimC = mySashLeaf.bot3Part.partDimCi = 0;
			createShape.bot3DimMo = createShape.bot3DimM = mySashLeaf.bot3Part.partDimM = mySashLeaf.bot3Part.partDimMi = 0;

			createShape.leftDimBo = createShape.leftDimB = mySashLeaf.leftPart.partDimB = mySashLeaf.leftPart.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.leftDimAo = createShape.leftDimA = mySashLeaf.leftPart.partDimA = mySashLeaf.leftPart.partDimAi = 0;
			createShape.leftDimCo = createShape.leftDimC = mySashLeaf.leftPart.partDimC = mySashLeaf.leftPart.partDimCi = 0;
			createShape.leftDimMo = createShape.leftDimM = mySashLeaf.leftPart.partDimM = mySashLeaf.leftPart.partDimMi = 0;

			createShape.rightDimBo = createShape.rightDimB = mySashLeaf.rightPart.partDimB = mySashLeaf.rightPart.partDimBi = mySUType
						.getGlassEdgeToSpacerInImp()
						* myFrame2.imperialscale.doubleValue();
			createShape.rightDimAo = createShape.rightDimA = mySashLeaf.rightPart.partDimA = mySashLeaf.rightPart.partDimAi = 0;
			createShape.rightDimCo = createShape.rightDimC = mySashLeaf.rightPart.partDimC = mySashLeaf.rightPart.partDimCi = 0;
			createShape.rightDimMo = createShape.rightDimM = mySashLeaf.rightPart.partDimM = mySashLeaf.rightPart.partDimMi = 0;
		}

		mySashLeaf.top1Part.endTypeLT  = 1;
		mySashLeaf.top2Part.endTypeLT  = 1;
		mySashLeaf.top3Part.endTypeLT  = 1;
		mySashLeaf.bot1Part.endTypeLT  = 1;
		mySashLeaf.bot2Part.endTypeLT  = 1;
		mySashLeaf.bot3Part.endTypeLT  = 1;
		mySashLeaf.leftPart.endTypeLT  = 1;
		mySashLeaf.rightPart.endTypeLT  = 1;

		mySashLeaf.top1Part.endTypeRB  = 1;
		mySashLeaf.top2Part.endTypeRB  = 1;
		mySashLeaf.top3Part.endTypeRB  = 1;
		mySashLeaf.bot1Part.endTypeRB  = 1;
		mySashLeaf.bot2Part.endTypeRB  = 1;
		mySashLeaf.bot3Part.endTypeRB  = 1;
		mySashLeaf.leftPart.endTypeRB  = 1;
		mySashLeaf.rightPart.endTypeRB  = 1;

		myreturns[0] = mySashLeaf;
		myreturns[1] = createShape;
		return myreturns;
	}

	/**
	 * Config SUType into GlassSU configuration part selected
	 *
	 * @param glassSU, GlassSU
	 * @param suType,  SUType
	 */
	public void configSUTypeGlassSU(GlassSU glassSU, SUType suType) throws Exception {

		//Evaluate if design is open is not id editing form to getting glassSU ID for SUType.
		if (myFrame2.jobItem.isOpen) {
			suType = myFrame2.glassPanel.getGlassController().findSUTypeById(glassSU.supplierId, glassSU.suID, glassSU.remote);
		}

		//Evaluate search next item SUType
		boolean areaComparison = false;
		boolean widthComparison = false;
		boolean heightComparison = false;
		boolean ratioComparison = false;
		
		BigDecimal widthM = new BigDecimal(0);
		BigDecimal widthI = new BigDecimal(0);
		BigDecimal heightM = new BigDecimal(0);
		BigDecimal heightI = new BigDecimal(0);
		BigDecimal area = new BigDecimal(0);
		BigDecimal whRatio = new BigDecimal(0);

		if (myFrame2.currentUOM == 1) {// metric

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Glass Calculation Values
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            //Calculate Width Metric
			 widthM = new BigDecimal(glassSU.widthM + "").divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);

            //Calculate Height Metric
             heightM = new BigDecimal(glassSU.heightM + "").divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);

            //Calculate Glass Area
			 area = (widthM.divide(new BigDecimal("1000"), 20, BigDecimal.ROUND_UP)).
                    multiply(heightM.divide(new BigDecimal("1000"), 20, BigDecimal.ROUND_UP)).
                    setScale(20, BigDecimal.ROUND_UP);

            //Calculate Glass Ratio
			 whRatio = widthM.divide(heightM, 20, BigDecimal.ROUND_UP).setScale(20, BigDecimal.ROUND_UP);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //SUTypes Calculation Values
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            BigDecimal minWidthSUType = new BigDecimal(suType.getMinWidth()).divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);
            BigDecimal maxWidthSUType = new BigDecimal(suType.getMaxWidth()).divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);

            BigDecimal minHeightSUType = new BigDecimal(suType.getMinHeight()).divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);
            BigDecimal maxHeightSUType = new BigDecimal(suType.getMaxHeight()).divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);

            BigDecimal minAreaSUType = new BigDecimal(suType.getMinArea());
            BigDecimal maxAreaSUType = new BigDecimal(suType.getMaxArea());
            BigDecimal whRatioSUType = new BigDecimal(suType.getWhRatio());

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Width with SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((widthM.compareTo(minWidthSUType) == 0 || widthM.compareTo(minWidthSUType) == 1) &&
                    widthM.compareTo(maxWidthSUType) == 0 || widthM.compareTo(maxWidthSUType) == -1) {
                widthComparison = true;
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Height width SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((heightM.compareTo(minHeightSUType) == 0 || heightM.compareTo(minHeightSUType) == 1) &&
                    heightM.compareTo(maxHeightSUType) == 0 || heightM.compareTo(maxHeightSUType) == -1) {
                heightComparison = true;
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Area with SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((area.compareTo(minAreaSUType) == 0 || area.compareTo(minAreaSUType) == 1) &&
                    (area.compareTo(maxAreaSUType) == 0 || area.compareTo(maxAreaSUType) == -1)) {
                areaComparison = true;
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Ratio with SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (whRatio.compareTo(whRatioSUType) == 0 || whRatio.compareTo(whRatioSUType) == -1 ||
                    whRatioSUType.compareTo(new BigDecimal("0")) == 0) {
                ratioComparison = true;
            }

		} else if (myFrame2.currentUOM > 1) {// Imperial

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Glass Calculation Values
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            //Calculate Width Metric
             widthI = new BigDecimal(glassSU.widthI + "").divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

            //Calculate Height Metric
             heightI = new BigDecimal(glassSU.heightI + "").divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

            //Calculate Glass Area
             area = (widthI.divide(new BigDecimal("12"), 20, BigDecimal.ROUND_UP)).
                    multiply(heightI.divide(new BigDecimal("12"), 20, BigDecimal.ROUND_UP)).
                    setScale(20, BigDecimal.ROUND_UP);

            //Calculate Glass Ratio
            if (heightI.compareTo(new BigDecimal("0")) <= 0) {
                whRatio = new BigDecimal("0");
            } else {
                whRatio = widthI.divide(heightI, 20, BigDecimal.ROUND_UP).setScale(20, BigDecimal.ROUND_UP);
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //SUTypes Calculation Values
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            BigDecimal minWidthSUType = new BigDecimal(suType.getMinWidthImp()).divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);
            BigDecimal maxWidthSUType = new BigDecimal(suType.getMaxWidthImp()).divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

            BigDecimal minHeightSUType = new BigDecimal(suType.getMinHeightImp()).divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);
            BigDecimal maxHeightSUType = new BigDecimal(suType.getMaxHeightImp()).divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

            BigDecimal minAreaSUType = new BigDecimal(suType.getMinAreaImp());
            BigDecimal maxAreaSUType = new BigDecimal(suType.getMaxAreaImp());

            BigDecimal whRatioSUType = new BigDecimal(suType.getWhRatio());


            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Width with SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((widthI.compareTo(minWidthSUType) == 0 || widthI.compareTo(minWidthSUType) == 1) &&
                    widthI.compareTo(maxWidthSUType) == 0 || widthI.compareTo(maxWidthSUType) == -1) {
                widthComparison = true;
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Height width SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((heightI.compareTo(minHeightSUType) == 0 || heightI.compareTo(minHeightSUType) == 1) &&
                    heightI.compareTo(maxHeightSUType) == 0 || heightI.compareTo(maxHeightSUType) == -1) {
                heightComparison = true;
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Area with SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ((area.compareTo(minAreaSUType) == 0 || area.compareTo(minAreaSUType) == 1) &&
                    (area.compareTo(maxAreaSUType) == 0 || area.compareTo(maxAreaSUType) == -1)) {
                areaComparison = true;
            }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Compare Glass Ratio with SUType Glass
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (whRatio.compareTo(whRatioSUType) == 0 || whRatio.compareTo(whRatioSUType) == -1 ||
                    whRatioSUType.compareTo(new BigDecimal("0")) == 0) {
                ratioComparison = true;
            }

		}

		//If all validations are true proceed to setting SUType values to Glass.
		if (areaComparison && widthComparison && heightComparison && ratioComparison) {
			//Setting SUType values
			 setSUTypeValues(glassSU, suType);
		} else {

			//Verify that nextItem SUType is not null to process the next search
			if (suType.getNextItem() != null && suType.getNextItem().compareTo(0) > 0) {
				SUType suTypeNext = myFrame2.glassPanel.getGlassController().findSUTypeById(suType.getSupplierRemoteId(),
                        suType.getNextItem(), suType.isRemote());

				if (suTypeNext != null) {
					//Recursive call to this method
					configSUTypeGlassSU(glassSU, suTypeNext);
				}

			} else {
				if(area.doubleValue()>0){
			     JOptionPane.showMessageDialog(this.myFrame2, "Glazing Limits Exceeded!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Cloning glass from Parent opening
	 *
	 * @param myframe, GlassSU
	 * @return GlassSU
	 */
	public GlassSU cloneGlassFromParentOpening(GlassSU myframe) {

		myframe.myFrame2 = myFrame2;
		myframe.myParentO = myParentFO;

		myframe.a_1Level = myParentFO.a_assemblyLevel;
		myframe.a_1Sequence = myParentFO.a_sequenceID;
		myframe.a_2Level = myParentFO.a_1Level;
		myframe.a_2Sequence = myParentFO.a_1Sequence;
		myframe.a_3Level = myParentFO.a_2Level;
		myframe.a_3Sequence = myParentFO.a_2Sequence;
		myframe.a_4Level = myParentFO.a_3Level;
		myframe.a_4Sequence = myParentFO.a_3Sequence;

		myframe.a_5Level = myParentFO.a_4Level;
		myframe.a_5Sequence = myParentFO.a_4Sequence;
		myframe.a_6Level = myParentFO.a_5Level;
		myframe.a_6Sequence = myParentFO.a_5Sequence;
		myframe.a_7Level = myParentFO.a_6Level;
		myframe.a_7Sequence = myParentFO.a_6Sequence;
		myframe.a_8Level = myParentFO.a_7Level;
		myframe.a_8Sequence = myParentFO.a_7Sequence;
		myframe.a_9Level = myParentFO.a_8Level;
		myframe.a_9Sequence = myParentFO.a_8Sequence;
		myframe.a_10Level = myParentFO.a_9Level;
		myframe.a_10Sequence = myParentFO.a_9Sequence;

		myframe.a_11Level = myParentFO.a_assemblyLevel;
		myframe.a_11Sequence = myParentFO.a_sequenceID;
		myframe.a_12Level = myParentFO.a_1Level;
		myframe.a_12Sequence = myParentFO.a_1Sequence;
		myframe.a_13Level = myParentFO.a_2Level;
		myframe.a_13Sequence = myParentFO.a_2Sequence;
		myframe.a_14Level = myParentFO.a_3Level;
		myframe.a_14Sequence = myParentFO.a_3Sequence;

		myframe.a_15Level = myParentFO.a_4Level;
		myframe.a_15Sequence = myParentFO.a_4Sequence;
		myframe.a_16Level = myParentFO.a_5Level;
		myframe.a_16Sequence = myParentFO.a_5Sequence;
		myframe.a_17Level = myParentFO.a_6Level;
		myframe.a_17Sequence = myParentFO.a_6Sequence;
		myframe.a_18Level = myParentFO.a_7Level;
		myframe.a_18Sequence = myParentFO.a_7Sequence;
		myframe.a_19Level = myParentFO.a_8Level;
		myframe.a_19Sequence = myParentFO.a_8Sequence;
		myframe.a_20Level = myParentFO.a_9Level;
		myframe.a_20Sequence = myParentFO.a_9Sequence;
		myframe.a_21Level = myParentFO.a_9Level;
		myframe.a_21Sequence = myParentFO.a_9Sequence;
		myframe.a_22Level = myParentFO.a_9Level;
		myframe.a_22Sequence = myParentFO.a_9Sequence;

		myframe.widthMN = myParentFO.widthMN;
		myframe.widthIN = myParentFO.widthIN;

		myframe.heightMN = myParentFO.heightMN;
		myframe.heightIN = myParentFO.heightIN;

		myframe.shapeID = myParentFO.shapeID;

		myframe.highestY = myParentFO.highestY;
		myframe.highestYC = myParentFO.highestYC;

		myframe.lowestY = myParentFO.lowestY;
		myframe.lowestYC = myParentFO.lowestYC;

		myframe.startingX = myParentFO.startingX;
		myframe.startingY = myParentFO.startingY;

		myframe.startCol = myParentFO.startCol;
		myframe.endCol = myParentFO.endCol;
		myframe.startRow = myParentFO.startRow;
		myframe.endRow = myParentFO.endRow;

		myframe.rID = myParentFO.rID;

		myframe.widthPix = myParentFO.widthPix;
		myframe.heightPix = myParentFO.heightPix;

		myframe.shapeID = myParentFO.shapeID;

		myframe.startingX = myParentFO.startingX;
		myframe.startingY = myParentFO.startingY;

		myframe.a_sequenceID = myParentFO.a_sequenceID;

		myframe.radius1 = myParentFO.radius1;
		myframe.radius2 = myParentFO.radius2;

		myframe.myParent = myframe.myOverall = myframe.myFacet = myParentFO.myParent;

		myframe.shapeChanged = myParentFO.shapeChanged;

		myframe.bkgrdStartX = myParentFO.bkgrdStartX;
		myframe.bkgrdStartY = myParentFO.bkgrdStartY;

		myframe.noSides = myParentFO.noSides;
		myframe.noSidesTop = myParentFO.noSidesTop;
		myframe.noSidesBot = myParentFO.noSidesBot;
		myframe.noSidesLeft = myParentFO.noSidesLeft;
		myframe.noSidesRight = myParentFO.noSidesRight;

		myframe.centerPointX = myParentFO.centerPointX;
		myframe.centerPointX2 = myParentFO.centerPointX2;
		myframe.centerPointY = myParentFO.centerPointY;
		myframe.centerPointY2 = myParentFO.centerPointY2;

		myframe.bX2 = myParentFO.bX2;
		myframe.bY2 = myParentFO.bY2;
		myframe.bX3 = myParentFO.bX3;
		myframe.bY3 = myParentFO.bY3;
		myframe.bX4 = myParentFO.bX4;
		myframe.bY4 = myParentFO.bY4;

		myframe.startingCX = myParentFO.startingCX;
		myframe.startingCY = myParentFO.startingCY;

		myframe.bCX2 = myParentFO.bCX2;
		myframe.bCY2 = myParentFO.bCY2;
		myframe.bCX3 = myParentFO.bCX3;
		myframe.bCY3 = myParentFO.bCY3;
		myframe.bCX4 = myParentFO.bCX4;
		myframe.bCY4 = myParentFO.bCY4;
		myframe.dimA1 = myParentFO.dimA1;
		myframe.dimA2 = myParentFO.dimA2;
		myframe.dimA3 = myParentFO.dimA3;
		myframe.dimA4 = myParentFO.dimA4;
		myframe.dimA5 = myParentFO.dimA5;
		myframe.dimA0 = myParentFO.dimA0;
		myframe.dimB1 = myParentFO.dimB1;
		myframe.dimB2 = myParentFO.dimB2;
		myframe.dimB3 = myParentFO.dimB3;
		myframe.dimB4 = myParentFO.dimB4;
		myframe.dimB5 = myParentFO.dimB5;
		myframe.dimB0 = myParentFO.dimB0;
		myframe.dimC1 = myParentFO.dimC1;
		myframe.dimC2 = myParentFO.dimC2;
		myframe.dimC3 = myParentFO.dimC3;
		myframe.dimC4 = myParentFO.dimC4;
		myframe.dimC5 = myParentFO.dimC5;
		myframe.dimC0 = myParentFO.dimC0;
		myframe.dimD1 = myParentFO.dimD1;
		myframe.dimD2 = myParentFO.dimD2;
		myframe.dimD3 = myParentFO.dimD3;
		myframe.dimD4 = myParentFO.dimD4;
		myframe.dimD5 = myParentFO.dimD5;
		myframe.dimD0 = myParentFO.dimD0;

		myframe.dimTM = myParentFO.dimTM;
		myframe.dimBM = myParentFO.dimBM;
		myframe.dimLM = myParentFO.dimLM;
		myframe.dimRM = myParentFO.dimRM;
		myframe.dimTA = myParentFO.dimTA;
		myframe.dimBA = myParentFO.dimBA;
		myframe.dimLA = myParentFO.dimLA;
		myframe.dimRA = myParentFO.dimRA;

		myframe.topIn = myParentFO.topIn;
		myframe.botIn = myParentFO.botIn;
		myframe.leftIn = myParentFO.leftIn;
		myframe.rightIn = myParentFO.rightIn;

		myframe.lean = myParentFO.lean;
		myframe.lean2 = myParentFO.lean2;
		myframe.lean3 = myParentFO.lean3;
		myframe.lean4 = myParentFO.lean4;

		myframe.parentH = myParentFO.parentH;
		myframe.parentW = myParentFO.parentW;

		myframe.parentStartY = myParentFO.parentStartY;
		myframe.parentStartX = myParentFO.parentStartX;
		myframe.parentRadius1 = myParentFO.parentRadius1;// 2;

		myframe.parentCX = myParentFO.parentCX;
		myframe.parentCY = myParentFO.parentCY;
		myframe.parentCX2 = myParentFO.parentCX2;
		myframe.parentCY2 = myParentFO.parentCY2;
		myframe.parentShape = myParentFO.parentShape;

		myframe.px1 = myParentFO.px1;
		myframe.py1 = myParentFO.py1;
		myframe.px2 = myParentFO.px2;
		myframe.py2 = myParentFO.py2;
		myframe.px3 = myParentFO.px3;
		myframe.py3 = myParentFO.py3;
		myframe.px4 = myParentFO.px4;
		myframe.py4 = myParentFO.py4;
		myframe.px5 = myParentFO.px5;
		myframe.py5 = myParentFO.py5;
		myframe.px6 = myParentFO.px6;
		myframe.py6 = myParentFO.py6;
		myframe.px7 = myParentFO.px7;
		myframe.py7 = myParentFO.py7;
		myframe.px8 = myParentFO.px8;
		myframe.py8 = myParentFO.py8;

		myframe.startingCX = myParentFO.startingCX;
		myframe.startingCY = myParentFO.startingCY;

		myframe.px1c = myParentFO.px1c;
		myframe.py1c = myParentFO.py1c;
		myframe.px2c = myParentFO.px2c;
		myframe.py2c = myParentFO.py2c;
		myframe.px3c = myParentFO.px3c;
		myframe.py3c = myParentFO.py3c;
		myframe.px4c = myParentFO.px4c;
		myframe.py4c = myParentFO.py4c;
		myframe.px5c = myParentFO.px5c;
		myframe.py5c = myParentFO.py5c;
		myframe.px6c = myParentFO.px6c;
		myframe.py6c = myParentFO.py6c;
		myframe.px7c = myParentFO.px7c;
		myframe.py7c = myParentFO.py7c;
		myframe.px8c = myParentFO.px8c;
		myframe.py8c = myParentFO.py8c;

		myframe.bCX2 = myParentFO.bCX2;
		myframe.bCY2 = myParentFO.bCY2;
		myframe.bCX3 = myParentFO.bCX3;
		myframe.bCY3 = myParentFO.bCY3;
		myframe.bCX4 = myParentFO.bCX4;
		myframe.bCY4 = myParentFO.bCY4;

		// myframe.top1Part =
		// myframe.top1Part.cloneProfile(myParentFO.top1Part);
		// myframe.top2Part =
		// myframe.top2Part.cloneProfile(myParentFO.top2Part);
		// myframe.top3Part =
		// myframe.top3Part.cloneProfile(myParentFO.top3Part);
		// myframe.bot1Part =
		// myframe.bot1Part.cloneProfile(myParentFO.bot1Part);
		// myframe.bot2Part =
		// myframe.bot2Part.cloneProfile(myParentFO.bot2Part);
		// myframe.bot3Part =
		// myframe.bot3Part.cloneProfile(myParentFO.bot3Part);
		// myframe.leftPart =
		// myframe.leftPart.cloneProfile(myParentFO.leftPart);
		// myframe.rightPart =
		// myframe.rightPart.cloneProfile(myParentFO.rightPart);

		myframe.top1Part = (Profiles) myframe.top1Part.cloneProfile(myParentFO.top1Part);
		myframe.top2Part = (Profiles) myframe.top2Part.cloneProfile(myParentFO.top2Part);
		myframe.top3Part = (Profiles) myframe.top3Part.cloneProfile(myParentFO.top3Part);
		myframe.rightPart = (Profiles) myframe.rightPart.cloneProfile(myParentFO.rightPart);
		myframe.leftPart = (Profiles) myframe.leftPart.cloneProfile(myParentFO.leftPart);
		myframe.bot1Part = (Profiles) myframe.bot1Part.cloneProfile(myParentFO.bot1Part);
		myframe.bot2Part = (Profiles) myframe.bot2Part.cloneProfile(myParentFO.bot2Part);
		myframe.bot3Part = (Profiles) myframe.bot3Part.cloneProfile(myParentFO.bot3Part);

		return myframe;
	}

	//***************************************************************
	// Private methods internal
	//***************************************************************
	private GlassSU setSUTypeValues(GlassSU glassSU, SUType suType) {

		glassSU.suID = suType.getId();
		glassSU.stockCode = suType.getStockCode();
		glassSU.description = suType.getDescription();
		glassSU.abbrev = suType.getAbbrev();
		glassSU.minArea = suType.getMinArea();
		glassSU.minAreaImp = suType.getMinAreaImp();
		glassSU.maxArea = suType.getMaxArea();
		glassSU.maxAreaImp = suType.getMaxAreaImp();
		glassSU.minWidth = suType.getMinWidth();
		glassSU.minWidthImp = suType.getMinWidthImp();
		glassSU.maxWidth = suType.getMaxWidth();
		glassSU.maxWidthImp = suType.getMaxWidthImp();
		glassSU.minHeight = suType.getMinHeight();
		glassSU.minHeightImp = suType.getMinHeightImp();
		glassSU.whRatio = suType.getWhRatio();
		glassSU.pricingUOMId = suType.getPricingUOMId();
		glassSU.priceActualSize = suType.getPriceActualSize();
		glassSU.cost = new BigDecimal(0);
		glassSU.costActualSize = suType.getCostActualSize();
		glassSU.priceMatrixId = suType.getPriceMatrixId();
		glassSU.price = new BigDecimal(0);
		glassSU.minPricingArea = suType.getMinPricingArea();
		glassSU.minPricingAreaImp = suType.getMinPricingAreaImp();
		glassSU.minPrice = suType.getMinPrice();
		glassSU.costGroupId = suType.getCostGroupId();
		glassSU.priceGroupId = suType.getPriceGroupId();
		glassSU.startDate = suType.getStartDate();
		glassSU.endDate = suType.getEndDate();
		glassSU.partnerGroupId = suType.getPartnerGroupId();
		glassSU.nextItem = suType.getNextItem();
		glassSU.display = suType.getDisplay();
		glassSU.waste = suType.getWaste();
		glassSU.madeIn = suType.getMadeIn();
		glassSU.supplierId = suType.getSupplierId();
		glassSU.leadTime = suType.getLeadTime();
		glassSU.minCostArea = suType.getMinCostArea();
		glassSU.minCostAreaImp = suType.getMinCostAreaImp();
		glassSU.productionLine = suType.getProductionLine();
		glassSU.sortSeq = suType.getSortSeq();
		glassSU.glazingType = suType.getGlazingType();
		glassSU.isCustom = suType.getCustom();
		glassSU.numOfLeaves = suType.getNumOfLeaves();
		glassSU.thickness = suType.getThickness();
		glassSU.thicknessImp = suType.getThicknessImp();
		glassSU.leaf1 = suType.getLeaf1Id() != null ? suType.getLeaf1Id() : 0;
		glassSU.leaf2 = suType.getLeaf2Id() != null ? suType.getLeaf2Id() : 0;
		glassSU.leaf3 = suType.getLeaf3Id() != null ? suType.getLeaf3Id() : 0;
		glassSU.leaf4 = suType.getLeaf4Id() != null ? suType.getLeaf4Id() : 0;
		glassSU.spacer1 = suType.getSpacer1PartId() != null ? suType.getSpacer1PartId() : 0;
		glassSU.spacer2 = suType.getSpacer2PartId() != null ? suType.getSpacer2PartId() : 0;
		glassSU.spacer3 = suType.getSpacer3PartId() != null ? suType.getSpacer3PartId() : 0;
		glassSU.glassToSpacer = suType.getGlassEdgeToSpacerIn() != null ? suType.getGlassEdgeToSpacerIn() : 0;
		glassSU.glassToSpacerImp = suType.getGlassEdgeToSpacerInImp() != null ? suType.getGlassEdgeToSpacerInImp() : 0;
		glassSU.gas1 = suType.getGas1PartId() != null ? suType.getGas1PartId() : 0;
		glassSU.gas2 = suType.getGas2PartId() != null ? suType.getGas2PartId() : 0;
		glassSU.gas3 = suType.getGas3PartId() != null ? suType.getGas3PartId() : 0;
		glassSU.film1 = suType.getGlass1FilmPartId() != null ? suType.getGlass1FilmPartId() : 0;
		glassSU.film2 = suType.getGlass2FilmPartId() != null ? suType.getGlass2FilmPartId() : 0;
		glassSU.film3 = suType.getGlass3FilmPartId() != null ? suType.getGlass3FilmPartId() : 0;
		glassSU.film4 = suType.getGlass4FilmPartId() != null ? suType.getGlass4FilmPartId() : 0;
		glassSU.process1 = suType.getGlass1ProcessId() != null ? suType.getGlass1ProcessId() : 0;
		glassSU.process2 = suType.getGlass2ProcessId() != null ? suType.getGlass2ProcessId() : 0;
		glassSU.process3 = suType.getGlass3ProcessId() != null ? suType.getGlass3ProcessId() : 0;
		glassSU.process4 = suType.getGlass4ProcessId() != null ? suType.getGlass4ProcessId() : 0;
		glassSU.cavityProcess1 = suType.getCavity1ProcessId() != null ? suType.getCavity1ProcessId() : 0;
		glassSU.cavityProcess2 = suType.getCavity2ProcessId() != null ? suType.getCavity2ProcessId() : 0;
		glassSU.cavityProcess3 = suType.getCavity3ProcessId() != null ? suType.getCavity3ProcessId() : 0;
		glassSU.cavity1Process2 = suType.getCavity1Process2Id() != null ? suType.getCavity1Process2Id() : 0;
		glassSU.cavity2Process2 = suType.getCavity2Process2Id() != null ? suType.getCavity2Process2Id() : 0;
		glassSU.cavity3Process2 = suType.getCavity3Process2Id() != null ? suType.getCavity3Process2Id() : 0;
		glassSU.cavity1Process3 = suType.getCavity1Process3Id() != null ? suType.getCavity1Process3Id() : 0;
		glassSU.cavity2Process3 = suType.getCavity2Process3Id() != null ? suType.getCavity2Process3Id() : 0;
		glassSU.cavity3Process3 = suType.getCavity3Process3Id() != null ? suType.getCavity3Process3Id() : 0;
		glassSU.externalProcess1 = suType.getExternal1ProcessId() != null ? suType.getExternal1ProcessId() : 0;
		glassSU.externalProcess2 = suType.getExternal2ProcessId() != null ? suType.getExternal2ProcessId() : 0;
		glassSU.externalProcess3 = suType.getExternal3ProcessId() != null ? suType.getExternal3ProcessId() : 0;
		glassSU.externalProcess4 = suType.getExternal4ProcessId() != null ? suType.getExternal4ProcessId() : 0;
		glassSU.external1Process2 = suType.getExternal1Process2Id() != null ? suType.getExternal1Process2Id() : 0;
		glassSU.external2Process2 = suType.getExternal2Process2Id() != null ? suType.getExternal2Process2Id() : 0;
		glassSU.external3Process2 = suType.getExternal3Process2Id() != null ? suType.getExternal3Process2Id() : 0;
		glassSU.external4Process2 = suType.getExternal4Process2Id() != null ? suType.getExternal4Process2Id() : 0;
		glassSU.external1Process3 = suType.getExternal1Process3Id() != null ? suType.getExternal1Process3Id() : 0;
		glassSU.external2Process3 = suType.getExternal2Process3Id() != null ? suType.getExternal2Process3Id() : 0;
		glassSU.external3Process3 = suType.getExternal3Process3Id() != null ? suType.getExternal3Process3Id() : 0;
		glassSU.external4Process3 = suType.getExternal4Process3Id() != null ? suType.getExternal4Process3Id() : 0;
		glassSU.glass1 = suType.getGlass1ProcessId() != null ? suType.getGlass1ProcessId() : 0;
		glassSU.glass2 = suType.getGlass2ProcessId() != null ? suType.getGlass2ProcessId() : 0;
		glassSU.glass3 = suType.getGlass3ProcessId() != null ? suType.getGlass3ProcessId() : 0;
		glassSU.glass4 = suType.getGlass4ProcessId() != null ? suType.getGlass4ProcessId() : 0;
		glassSU.glass1Process2 = suType.getGlass1Process2Id() != null ? suType.getGlass1Process2Id() : 0;
		glassSU.glass2Process2 = suType.getGlass2Process2Id() != null ? suType.getGlass2Process2Id() : 0;
		glassSU.glass3Process2 = suType.getGlass3Process2Id() != null ? suType.getGlass3ProcessId() : 0;
		glassSU.glass4Process2 = suType.getGlass4Process2Id() != null ? suType.getGlass4Process2Id() : 0;
		glassSU.glass1Process3 = suType.getGlass1Process3Id() != null ? suType.getGlass1Process3Id() : 0;
		glassSU.glass2Process3 = suType.getGlass2Process3Id() != null ? suType.getGlass2Process3Id() : 0;
		glassSU.glass3Process3 = suType.getGlass3Process3Id() != null ? suType.getGlass3Process3Id() : 0;
		glassSU.glass4Process3 = suType.getGlass4Process3Id() != null ? suType.getGlass4Process3Id() : 0;
		glassSU.sealantPartId = suType.getSealantPartId() != null ? suType.getSealantPartId() : -1;
		glassSU.familyId = suType.getFamilyId() != null ? suType.getFamilyId() : -1;
		glassSU.insert1Id = suType.getInsert1Id() != null ? suType.getInsert1Id() : -1;
		glassSU.insert2Id = suType.getInsert2Id() != null ? suType.getInsert2Id() : -1;
		glassSU.insert3Id = suType.getInsert3Id() != null ? suType.getInsert3Id() : -1;
		glassSU.measure = suType.getMeasure() != null ? suType.getMeasure() : -1;
        glassSU.inHouse = suType.isInHouse();
        glassSU.assemblyID = suType.getAssemblyId() != null ? suType.getAssemblyId() : -1;
        glassSU.airSpace1 = suType.getAirSpace1() != null ? suType.getAirSpace1() : -1;
        glassSU.airSpace1i = suType.getAirSpace1i() != null ? suType.getAirSpace1i() : -1;
        glassSU.airSpace2 = suType.getAirSpace2() != null ? suType.getAirSpace2() : -1;
        glassSU.airSpace2i = suType.getAirSpace2i() != null ? suType.getAirSpace2i() : -1;
        glassSU.airSpace3 = suType.getAirSpace3() != null ? suType.getAirSpace3() : -1;
        glassSU.airSpace3i = suType.getAirSpace3i() != null ? suType.getAirSpace3i() : -1;
        glassSU.partFamily = suType.getPartFamily();

        glassSU.supplierId = suType.getSupplierRemoteId();
        glassSU.supplierSeriesId = suType.getSupplierSeriesId();
        glassSU.remote = suType.isRemote();

        Color color = null;
        if (suType.isRemote()) {
            color = ItemFrame.getApplicationRemoteBaseRules().getColor(glassSU.supplierId, suType.getFlagColor());
        } else {
            color = ItemFrame.getApplicationBaseRules().getColor(suType.getFlagColor());
        }

        if (color != null) {
            glassSU.r_rgb = color.getR();
            glassSU.g_rgb = color.getG();
            glassSU.b_rgb = color.getB();
            glassSU.a_rgb = color.getA();
        }

		//Calculating price for Glass Seal Unit
        this.mySUType = suType;
        
		//Setting Glass SU to selected Glass List - GlassSelectorPanel
		this.myFrame2.glassPanel.setSelectedGlassList(glassSU);

		return glassSU;
	}

    /**
     * Create a Glass Bill of Materials component from glass setting
     *
     * @param myGlass, GlassSU
     * @param suType,  Seal Unit Type
     * @return DesignGlass
     * @throws Exception, Exception
     */
    public DesignGlass setDesignGlass(GlassSU myGlass, SUType suType) throws Exception {

        /********************************************************/
        /* Execute if glass has an appropiate Seal Unit setting */
        /********************************************************/
        if (myGlass.suID == suType.getId()) {

            //Create Glass Bill of Materials
            DesignGlass glassBOM = new DesignGlass();

            glassBOM.a_assemblyLevel = myGlass.a_assemblyLevel;

            glassBOM.a_levelID = myGlass.a_levelID;
            glassBOM.a_sequenceID = myGlass.a_sequenceID;

            glassBOM.a_1Level = myGlass.a_1Level;
            glassBOM.a_1Sequence = myGlass.a_1Sequence;
            glassBOM.a_2Level = myGlass.a_2Level;
            glassBOM.a_2Sequence = myGlass.a_2Sequence;
            glassBOM.a_3Level = myGlass.a_3Level;
            glassBOM.a_3Sequence = myGlass.a_3Sequence;
            glassBOM.a_4Level = myGlass.a_4Level;
            glassBOM.a_4Sequence = myGlass.a_4Sequence;
            glassBOM.a_5Level = myGlass.a_5Level;
            glassBOM.a_5Sequence = myGlass.a_5Sequence;
            glassBOM.a_6Level = myGlass.a_6Level;
            glassBOM.a_6Sequence = myGlass.a_6Sequence;
            glassBOM.a_7Level = myGlass.a_7Level;
            glassBOM.a_7Sequence = myGlass.a_7Sequence;
            glassBOM.a_8Level = myGlass.a_8Level;
            glassBOM.a_8Sequence = myGlass.a_8Sequence;
            glassBOM.a_9Level = myGlass.a_9Level;
            glassBOM.a_9Sequence = myGlass.a_9Sequence;
            glassBOM.a_10Level = myGlass.a_10Level;
            glassBOM.a_10Sequence = myGlass.a_10Sequence;
            glassBOM.a_11Level = myGlass.a_11Level;
            glassBOM.a_11Sequence = myGlass.a_11Sequence;
            glassBOM.a_12Level = myGlass.a_12Level;
            glassBOM.a_12Sequence = myGlass.a_12Sequence;
            glassBOM.a_13Level = myGlass.a_13Level;
            glassBOM.a_13Sequence = myGlass.a_13Sequence;
            glassBOM.a_14Level = myGlass.a_14Level;
            glassBOM.a_14Sequence = myGlass.a_14Sequence;
            glassBOM.a_15Level = myGlass.a_15Level;
            glassBOM.a_15Sequence = myGlass.a_15Sequence;
            glassBOM.a_16Level = myGlass.a_16Level;
            glassBOM.a_16Sequence = myGlass.a_16Sequence;
            glassBOM.a_17Level = myGlass.a_17Level;
            glassBOM.a_17Sequence = myGlass.a_17Sequence;
            glassBOM.a_18Level = myGlass.a_18Level;
            glassBOM.a_18Sequence = myGlass.a_18Sequence;
            glassBOM.a_19Level = myGlass.a_19Level;
            glassBOM.a_19Sequence = myGlass.a_19Sequence;
            glassBOM.a_20Level = myGlass.a_20Level;
            glassBOM.a_20Sequence = myGlass.a_20Sequence;
            glassBOM.a_21Level = myGlass.a_21Level;
            glassBOM.a_21Sequence = myGlass.a_21Sequence;
            glassBOM.a_22Level = myGlass.a_22Level;
            glassBOM.a_22Sequence = myGlass.a_22Sequence;

            glassBOM.suID = myGlass.suID;
            glassBOM.stockCode = myGlass.stockCode;
            glassBOM.description = myGlass.description;
            glassBOM.abbrev = myGlass.abbrev;
            glassBOM.prodline = myGlass.productionLine;
            glassBOM.productionLine = myGlass.productionLine;
            glassBOM.station = 1; //TODO; Need to change to production_line_station for make consistent evaluation.
            glassBOM.minArea = myGlass.minArea;
            glassBOM.minAreaImp = myGlass.minAreaImp;
            glassBOM.maxArea = myGlass.maxArea;
            glassBOM.maxAreaImp = myGlass.maxAreaImp;
            glassBOM.minWidth = myGlass.minWidth;
            glassBOM.minWidthImp = myGlass.minWidthImp;
            glassBOM.maxWidth = myGlass.maxWidth;
            glassBOM.maxWidthImp = myGlass.maxWidthImp;
            glassBOM.minHeight = myGlass.minHeight;
            glassBOM.minHeightImp = myGlass.minHeightImp;
            glassBOM.whRatio = myGlass.whRatio;
            glassBOM.pricingUOMId = myGlass.pricingUOMId;
            glassBOM.priceActualSize = myGlass.priceActualSize;
            glassBOM.cost = myGlass.cost;
            glassBOM.costActualSize = myGlass.costActualSize;
            glassBOM.priceMatrixId = myGlass.priceMatrixId;
            glassBOM.price = myGlass.price;
            glassBOM.minPricingArea = myGlass.minPricingArea;
            glassBOM.minPricingAreaImp = myGlass.minPricingAreaImp;
            glassBOM.minPrice = myGlass.minPrice;
            glassBOM.costGroupId = myGlass.costGroupId;
            glassBOM.priceGroupId = myGlass.priceGroupId;
            glassBOM.startDate = myGlass.startDate;
            glassBOM.endDate = myGlass.endDate;
            glassBOM.partnerGroupId = myGlass.partnerGroupId;
            glassBOM.nextItem = myGlass.nextItem;
            glassBOM.display = myGlass.display;
            glassBOM.waste = myGlass.waste;
            glassBOM.madeIn = myGlass.madeIn;
            glassBOM.supplierId = myGlass.supplierId;
            glassBOM.leadTime = myGlass.leadTime;
            glassBOM.minCostArea = myGlass.minCostArea;
            glassBOM.minCostAreaImp = myGlass.minCostAreaImp;
            glassBOM.productionLine = myGlass.productionLine;

            glassBOM.sortSeq = myGlass.sortSeq;
            glassBOM.glazingType = myGlass.glazingType;
            glassBOM.isCustom = myGlass.isCustom;
            glassBOM.numOfLeaves = myGlass.numOfLeaves;
            glassBOM.thickness = myGlass.thickness;
            glassBOM.thicknessImp = myGlass.thicknessImp;

            glassBOM.leaf1 = myGlass.leaf1;
            glassBOM.leaf2 = myGlass.leaf2;
            glassBOM.leaf3 = myGlass.leaf3;
            glassBOM.leaf4 = myGlass.leaf4;

            glassBOM.spacer1 = myGlass.spacer1;
            glassBOM.spacer2 = myGlass.spacer2;
            glassBOM.spacer3 = myGlass.spacer3;

            glassBOM.glassToSpacer = myGlass.glassToSpacer;
            glassBOM.glassToSpacerImp = myGlass.glassToSpacerImp;

            glassBOM.gas1 = myGlass.gas1;
            glassBOM.gas2 = myGlass.gas2;
            glassBOM.gas3 = myGlass.gas3;

            glassBOM.film1 = myGlass.film1;
            glassBOM.film2 = myGlass.film2;
            glassBOM.film3 = myGlass.film3;
            glassBOM.film4 = myGlass.film4;

            glassBOM.process1 = myGlass.process1;
            glassBOM.process2 = myGlass.process2;
            glassBOM.process3 = myGlass.process3;
            glassBOM.process4 = myGlass.process4;

            glassBOM.cavityProcess1 = myGlass.cavityProcess1;
            glassBOM.cavityProcess2 = myGlass.cavityProcess2;
            glassBOM.cavityProcess3 = myGlass.cavityProcess3;
            glassBOM.cavity1Process2 = myGlass.cavity1Process2;
            glassBOM.cavity2Process2 = myGlass.cavity2Process2;
            glassBOM.cavity3Process2 = myGlass.cavity3Process2;
            glassBOM.cavity1Process3 = myGlass.cavity1Process3;
            glassBOM.cavity2Process3 = myGlass.cavity2Process3;
            glassBOM.cavity3Process3 = myGlass.cavity3Process3;

            glassBOM.externalProcess1 = myGlass.externalProcess1;
            glassBOM.externalProcess2 = myGlass.externalProcess2;
            glassBOM.externalProcess3 = myGlass.externalProcess3;
            glassBOM.externalProcess4 = myGlass.externalProcess3;
            glassBOM.external1Process2 = myGlass.external1Process2;
            glassBOM.external2Process2 = myGlass.external2Process2;
            glassBOM.external3Process2 = myGlass.external3Process2;
            glassBOM.external4Process2 = myGlass.external4Process2;
            glassBOM.external1Process3 = myGlass.external1Process3;
            glassBOM.external2Process3 = myGlass.external2Process3;
            glassBOM.external3Process3 = myGlass.external3Process3;
            glassBOM.external4Process3 = myGlass.external4Process3;

            glassBOM.glass1 = myGlass.glass1;
            glassBOM.glass2 = myGlass.glass2;
            glassBOM.glass3 = myGlass.glass3;
            glassBOM.glass4 = myGlass.glass4;

            glassBOM.airSpace1 = myGlass.airSpace1;
            glassBOM.airSpace1i = myGlass.airSpace1i;
            glassBOM.airSpace2 = myGlass.airSpace2;
            glassBOM.airSpace2i = myGlass.airSpace2i;
            glassBOM.airSpace3 = myGlass.airSpace3;
            glassBOM.airSpace3i = myGlass.airSpace3i;

            glassBOM.glass1Process2 = myGlass.glass1Process2;
            glassBOM.glass2Process2 = myGlass.glass2Process2;
            glassBOM.glass3Process2 = myGlass.glass3Process2;
            glassBOM.glass4Process2 = myGlass.glass4Process2;
            glassBOM.glass1Process3 = myGlass.glass1Process3;
            glassBOM.glass2Process3 = myGlass.glass2Process3;
            glassBOM.glass3Process3 = myGlass.glass3Process3;
            glassBOM.glass4Process3 = myGlass.glass4Process3;

            glassBOM.sealantPartId = myGlass.sealantPartId;
            glassBOM.familyId = myGlass.familyId;

            glassBOM.insert1Id = myGlass.insert1Id;
            glassBOM.insert2Id = myGlass.insert2Id;
            glassBOM.insert3Id = myGlass.insert3Id;

            glassBOM.measure = myGlass.measure;

            glassBOM.shapeID = myGlass.shapeID;
            glassBOM.udOpeningID = myGlass.userDefinedOpeningID;

            glassBOM.widthM = myGlass.widthM;
            glassBOM.heightM = myGlass.heightM;
            glassBOM.widthI = myGlass.widthI;
            glassBOM.heightI = myGlass.heightI;
            glassBOM.widthMN = myGlass.widthMN;
            glassBOM.heightMN = myGlass.heightMN;
            glassBOM.widthIN = myGlass.widthIN;
            glassBOM.heightIN = myGlass.heightIN;

            glassBOM.inHouse = myGlass.inHouse;
            glassBOM.assemblyID = myGlass.assemblyID;
            glassBOM.leafNo = myGlass.leafNo;

            glassBOM.shapeObject = myGlass;

            glassBOM.supplierRemoteId = suType.getSupplierRemoteId();
            glassBOM.seriesSupplierId = suType.getSupplierSeriesId();
            glassBOM.remote = suType.isRemote();

            //*******************************************************************************************
            //Prepare calculation for cost
            //*******************************************************************************************

            //Call to Glass Calculation controller
            GlassCalculationController glassCalculation = new GlassCalculationController();

            //Get Parts Family from application execution
            PartsFamily partFamily;
            if (suType.isRemote()) {
                partFamily = ItemFrame.getApplicationRemoteBaseRules().getPartFamily(suType.getSupplierRemoteId(), suType.getPartFamily());
            } else {
                partFamily = ItemFrame.getApplicationBase().getPartsFamily(suType.getPartFamily());
            }

            //Get System Unit of Metric from application execution
            SystemUOM systemUOM = ItemFrame.getApplicationBase().getSystemUOM(myGlass.pricingUOMId);

            //Calculate Cost
            glassBOM.cost = glassCalculation.calculateCost(myGlass, systemUOM, suType.getPrice(), suType.getCost(),
                    suType.getWaste());

            //Calculate area
            BigDecimal area = glassCalculation.getSize(myGlass, myGlass.priceActualSize);

            //PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

            //Calculate price Glass bill of materials
            if (partFamily.getMarkedupCost()) {
                glassBOM.price = glassBOM.cost.multiply(new BigDecimal((partFamily.getPriceMarkup()) + 1));
                glassBOM.priceUser = glassBOM.price;
            } else {
                glassBOM.price = myGlass.price.multiply(area);
                glassBOM.priceUser = glassBOM.price;
            }

            if (!partFamily.getIncludeInCost()) {
                glassBOM.cost = new BigDecimal("0");
            }

            if (!partFamily.getIncludeInPrice()) {
                glassBOM.price = new BigDecimal("0");
                glassBOM.priceUser = new BigDecimal("0");
            }

            glassBOM.partFamily = myGlass.costGroupId;
            glassBOM.priceGroup = myGlass.priceGroupId;
            glassBOM.priceCat = 3;

            //Calculate Discount
            double disc = 0.0;

            if (suType.isRemote()) {
                List<PartnerLineDiscount> partnerDiscounts = ItemFrame.getApplicationRemoteBaseRules().getInstance().
                        getPartnerLineDiscounts(suType.getSupplierRemoteId());
                for (PartnerLineDiscount discount : partnerDiscounts) {
                    if (discount.getId().getPriceCategoryId() == glassBOM.priceCat) {
                        disc = discount.getDiscount();
                    }
                }

            } else {

                List<PartnerLineDiscount> partnerDiscounts = ApplicationBaseApp.getInstance().getPartnerLineDiscounts();
                for (PartnerLineDiscount discount : partnerDiscounts) {
                    if (discount.getId().getPriceCategoryId() == glassBOM.priceCat) {
                        disc = discount.getDiscount();
                    }
                }
            }

            double discFactor = 1 - disc;

            glassBOM.price = glassBOM.price.multiply(new BigDecimal(discFactor));
            glassBOM.priceUser = glassBOM.price;

            return glassBOM;
        }

        return null;
    }

}
