/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: Sherif El Dibani
 */
package Model;

import Presentation.DrawCanvas;
import Presentation.ItemFrame;
import openjanela.app.configuration.controller.JobItemModelController;
import openjanela.app.configuration.controller.OrderItemsCartController;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.partner.JobItem;
import openjanela.model.entities.partner.Series;
import org.apache.log4j.Logger;
import util.UOMConvert;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class initialize a new job item model
 */
public class JobItemModel implements Cloneable {

	//Apacha log4j
	private static final Logger logger = Logger.getLogger(JobItemModel.class);

	/* Order Items Cart value */
	private openjanela.model.entities.orderEntry.OrderItemsCart orderItemsCart;
	private JobItem jobItem;

	//Semaphore variable for Open indication
	public boolean isOpen = false;
	public boolean isEdit = false; //This variable should be set true when starting the editing of design
    public boolean samePart = false;

	// 1 = m 2 = impdec 3= impfract 4= Feet & Inch
	public int continuity = 0;

	public int designID = 0; // design number custom if just desgin, serves

	public int stdProdCode = 0; // Std Product Code for Std Sized and Std
	// Design products.

	public int designFamily = 0; // design Family ID From Design

	public int layout = 1;

	// as index
	public int jobid = 0; // assigned if used in a job
	public int itemid = 0; // assigned if used in a job
	public int versionid = 0; // assigned if used in a job

	public boolean isStd = false;

	public ItemFrame myParent;

	public int rID = 0;

	public int shapeID = 1;

	public int parentItemID = 0;

	public double frameDepth = 85;

	// need to add shape descriptor object
	public double haf = 40; // height bove floor only if Overalllevel
	public int roID = 0;

	public boolean viewOut = true; // Viewed from Inside or Outside

	public double _WIDTHpix = 0;
	public double _HEIGHTpix = 0;
	public double design_flat_WIDTHpix = 0;
	public double design_flat_HEIGHTpix = 0;

	public int _WIDTH_Imp = 0;
	public int design_WIDTH_Imp = 0;
	public int design_HEIGHT_Imp = 0;
	public int _HEIGHT_Imp = 0;
	public int _WIDTH_Metric = 0;
	public int design_WIDTH_Metric = 0;
	public int design_HEIGHT_Metric = 0;
	public int _HEIGHT_Metric = 0;
	public int _WIDTH_Imp_O = 0;
	public int design_WIDTH_Imp_O = 0;
	public int design_HEIGHT_Imp_O = 0;
	public int _HEIGHT_Imp_O = 0;
	public int _WIDTH_Metric_O = 0;
	public int design_WIDTH_Metric_O = 0;
	public int design_HEIGHT_Metric_O = 0;
	public int _HEIGHT_Metric_O = 0;

	//Starting X and Y position
	public double startingX = 170;
	public double startingY = 90;

	public BigDecimal originalScaleM = new BigDecimal(0); //Original scale metric
	public BigDecimal originalScaleI = new BigDecimal(0); //Original scale Imperial decimal
	public BigDecimal originalScaleS  = new BigDecimal(0); //Original scale jobItem.
	public BigDecimal newScaleS  = new BigDecimal(0); //New scale calculated

	public double factor = 0;

	public int seriesid = 0;

	public int supplierid = 0;

	public DrawCanvas myCanvas;

	public double canvasW = 0;
	public double canvasH = 0;

	public Graphics2D g2;

	public static HashMap<?, ?> image_Map = null;

	public double nominalW = 0;

	public double nominalH = 0;
	public double actualW = 0;
	public double actualH = 0;
	public double roW = 0;
	public double roH = 0;

	ShapeObject shapeObject;

	/*
	 * int planType = 0 = flat,
	 * 1 = bay
	 * 2 = bow
	 * 3 = custom
	 * public int ns = 0; // no of sides
	 * public boolean fixedA=false;
	 * public double wi = 0; // Internal Width
	 * public double depth=0;// actual wall Depth
	 * public double je=0;// jamb ext. size
	 * public double pi=0;//projection In
	 * public double po=0;//projection In
	 * public double angle =0;
	 * public double center =0;
	 * public double flanker =0;
	 * public double liteS =0; // Bow lite Size
	 * public double cp =0; //cente %
	 * public double fp =0; //flanker %
	 */

	public int planType = 0;

	public int ns = 0; // no of sides

	public double angle = 0;

	public double cp = 0; // cente %

	public double fp = 0; // flanker %boolean fixedA=false;

	public double wi = 0; // Internal Width

	public double depth = 0;// actual wall Depth

	public double je = 0;// jamb ext. size

	public double pi = 0;// projection In

	public double po = 0;// projection In

	public double center = 0;

	public double flanker = 0;

	public double liteS = 0;

	public double flatW = 0;// sum of all facets widths.

	public BigDecimal scale = new BigDecimal(0);

	public Overall design;

	public double odW = 0;

	public double odH = 0;

	public Collection<BillOfMat> bom = new ArrayList<BillOfMat>();
	public Collection<DesignGlass> glassBOM = new ArrayList<DesignGlass>();
    public Collection<DesignGrid> gridsBOM = new ArrayList<DesignGrid>();

	public Collection<DesignOption> designOptionsAll = new ArrayList<DesignOption>();
    public Collection<ShapeNotes> shapeNotes = new ArrayList<ShapeNotes>();

    public Collection<ShapeNotes> frameShapeNotes = new ArrayList<ShapeNotes>();
    public Map<Frame, Collection<ShapeNotes>> frameShapeNotesMap = new HashMap<Frame, Collection<ShapeNotes>>();

	public Collection<ErrorsAndWarnings> designErrors = new ArrayList<ErrorsAndWarnings>();
	public Collection<ErrorsAndWarnings> designWarnings = new ArrayList<ErrorsAndWarnings>();

	public int gridType = 0;
	public int priceChangeReasonID = 0;
	
	
	/**
	 * This class save dimensions options for last design dimensions
	 */
	public DimensionOptions dimensionOptions;

	//Controller
	private final OrderItemsCartController orderItemsCartController;
	private final JobItemModelController jobItemModelController;

	//********************************************************************
	// /* Getters and Setters methods */
	//********************************************************************

	public DimensionOptions getDimensionOptions() {
		return dimensionOptions;
	}

	public void setDimensionOptions(DimensionOptions dimensionOptions) {
		this.dimensionOptions = dimensionOptions;
	}

	public openjanela.model.entities.orderEntry.OrderItemsCart getOrderItemsCart() {
		return orderItemsCart;
	}

	public void setOrderItemsCart(openjanela.model.entities.orderEntry.OrderItemsCart orderItemsCart) {
		this.orderItemsCart = orderItemsCart;
	}

	public JobItem getJobItem() {
		return jobItem;
	}

	public void setJobItem(JobItem jobItem) {
		this.jobItem = jobItem;
	}

	/**
	 * This constructor instatiate a JobItemModel class for performing a main operation design
	 * for openjanela configurator door and windows.
	 *
	 * @param frame, ItemFrame
	 * @see Presentation.ItemFrame
	 */
	public JobItemModel(ItemFrame frame) {
		
		/* Setting my frame parent ItemFrame */
		this.myParent = frame;
		
		/* Setting properties for execution */
		this.haf = 40;
		this.viewOut = this.myParent.userPref.isViewOut();

		this.seriesid = this.myParent.mySeries.getId();
		this.supplierid = this.myParent.supplierID;

        //Init Job
        this.myCanvas = new DrawCanvas(this.myParent);
		
		/* Init controllers */
		this.orderItemsCartController = new OrderItemsCartController(this.myParent);
		this.jobItemModelController = new JobItemModelController(this.myParent);
	}

	public void initFacets() {

		Object[] fs = design.frames.toArray();
		design.frames.clear();

		for (Object f : fs) {
			((Facet) f).setOriginalDimsInit(myParent.facetUsed.widthPix, myParent.facetUsed.heightPix);
			myParent.facetUsed = (Facet) f;
			design.frames.add(f);

		}
	}

	public void hasSub() {

		if (myParent.facetUsed != null) {
			final Object[] fs = myParent.facetUsed.frames.toArray();
			myParent.hasSubF = false;
			for (Object f : fs) {
				Object[] ops = ((Frame) f).openings.toArray();
				for (Object o : ops) {
					if (((OpeningObject) o).contentMid == 3) {
						myParent.hasSubF = true;
					}
				}
			}
		}
	}

	public void getOpeningContent(int row, int col, int rowo, int colo) {

		Object[] fs = myParent.facetUsed.frames.toArray();

		myParent.hasSubF = false;
		// if(!myParent.isSash.isSelected()) {
			for (Object f : fs) {
				if (((Frame) f).startRow == row && ((Frame) f).startCol == col) {

					Object[] ops = ((Frame) f).openings.toArray();
					// myParent.isSash.setSelected(false);
					// myParent.sFLevel.setSelected(false);
					for (Object o : ops) {
						if (((OpeningObject) o).startRow == rowo && ((OpeningObject) o).startCol == colo) {
							if (((OpeningObject) o).contentMid == 2) {
								myParent.dim.isSash.setSelected(true);

								final Object[] leafs = ((OpeningObject) o).sashObjectMid.frames.toArray();
								for (final Object l : leafs) {
									if (((SashLeaf) l).startCol == 1 && ((SashLeaf) l).startRow == 1) {
										this.myParent.mySelectedSash = ((OpeningObject) o).sashObjectMid;
										this.myParent.mySelectedSashLeaf = (SashLeaf) l;
									}
								}

							} else if (((OpeningObject) o).contentMid == 1) {
								myParent.dim.isSash.setSelected(false);
								myParent.dim.sFLevel.setSelected(false);
								myParent.subFClicked = false;
							}
						}
					}
				}
			}
	}

	public void hasSubRC(final int row, final int col) {

		Object[] fs = myParent.facetUsed.frames.toArray();

		myParent.hasSubF = false;

		for (Object f : fs) {
			if (((Frame) f).startRow == row && ((Frame) f).startCol == col) {
				Object[] ops = ((Frame) f).openings.toArray();
				
				for (Object o : ops) {
					if (((OpeningObject) o).contentMid == 3 && myParent.dim.sFLevel.isSelected()) {
						myParent.subFClicked = true;
						myParent.facetUsed = ((OpeningObject) o).subFacet;
					} else {
						myParent.subFClicked = true;
					}
				}
			}
		}
	}

	/**
	 * This method create a new base design and perform operation over this.
	 */
	public void newJobItemInfo() throws Exception {

		this.jobid = myParent.jobID;
		this.itemid = myParent.itemID;
		this.seriesid = myParent.seriesID;
		this.designID = myParent.designID;
		this.designFamily = myParent.designFamilyID;
		this.continuity = 1;

		//**********************************************************
		//Configuring unit of metric for design
		//**********************************************************

		//Config options and lock unit of metric
		if (myParent.baseUOM == Metrics.METRIC.getValue()) {
			myParent.myTopPanel.metric.setSelected(true);
			myParent.myTopPanel.impDec.setSelected(false);
			myParent.myTopPanel.impFrac.setSelected(false);
			myParent.myTopPanel.feet.setSelected(false);
		} else if (myParent.baseUOM == Metrics.IMPERIAL_DECIMAL.getValue()) {
			myParent.myTopPanel.metric.setSelected(false);
			myParent.myTopPanel.impDec.setSelected(true);
			myParent.myTopPanel.impFrac.setSelected(false);
			myParent.myTopPanel.feet.setSelected(false);
		} else if (myParent.baseUOM == Metrics.IMPERIAL_FRACTION.getValue()) {
			myParent.myTopPanel.metric.setSelected(false);
			myParent.myTopPanel.impDec.setSelected(false);
			myParent.myTopPanel.impFrac.setSelected(true);
			myParent.myTopPanel.feet.setSelected(false);
		} else if (myParent.baseUOM == Metrics.FEET.getValue()) {
			myParent.myTopPanel.metric.setSelected(false);
			myParent.myTopPanel.impDec.setSelected(false);
			myParent.myTopPanel.impFrac.setSelected(false);
			myParent.myTopPanel.feet.setSelected(true);
		}

		//Config unit of scale for Width and Height

		double nominalWr = 0;
		double nominalHr = 0;

		if (myParent.myTopPanel.metric.isSelected()) {

			nominalW = myParent.userPref.getWidth();
			nominalH = myParent.userPref.getHeight();

			nominalWr = (int) (((int) (nominalW / myParent.metricRound)) * myParent.metricRound);
			nominalHr = (int) (((int) (nominalH / myParent.metricRound)) * myParent.metricRound);

		} else if (myParent.myTopPanel.impDec.isSelected()) {

			nominalW = myParent.userPref.getWidth();
			nominalH = myParent.userPref.getHeight();

			nominalWr = (( (nominalW * 64d / myParent.impRound)) * myParent.impRound) / 64d;
			nominalHr =  (( (nominalH * 64d / myParent.impRound)) * myParent.impRound) / 64d;

		} else if (myParent.myTopPanel.impFrac.isSelected()) {

			nominalW = myParent.userPref.getWidth();
			nominalH = myParent.userPref.getHeight();

			nominalWr = (((nominalW * 64d / myParent.impRound)) * myParent.impRound) / 64d;
			nominalHr =  (( (nominalH * 64d / myParent.impRound)) * myParent.impRound) / 64d;

		}

		if (nominalWr != nominalW) {
			JOptionPane.showMessageDialog(null, "Width entered will be rounded to: " + nominalWr
						+ " \nto match series limitations!", "Fractional Size Limitation - WARNING!",
						JOptionPane.WARNING_MESSAGE);

			nominalW = nominalWr;
		}

		if (nominalHr != nominalH) {
			JOptionPane.showMessageDialog(null, "Height entered will be rounded to: " + nominalHr
						+ " \nto match series limitations!", "Fractional Size Limitation - WARNING!",
						JOptionPane.WARNING_MESSAGE);

			nominalH = nominalHr;
		}

        //**********************************************************
        //Setting Top Panel Configuration
        //**********************************************************
        /* Evaluate nominalW and nominalH */
        if (this.myParent.openingSize) {
            this.myParent.myTopPanel.setOpeningSizeUI(true, this.myParent.standardRoID, this.myParent.seriesID,
                    nominalW, nominalH);
        } else {
            this.myParent.myTopPanel.setActualSizeUI(true, this.myParent.standardRoID, this.myParent.seriesID,
                    nominalW, nominalH);
        }

        //**********************************************************
		//Init openjanela main configurator with a custom design
		//**********************************************************
		if (this.seriesid > 0 && this.designID > 0) {
			try {

				/* Open default job item design */
				this.jobItemModelController.openJobItemDefaultDesign();

              	//Reset canvas size
				this.myParent.myTopPanel.resetSize(nominalW, nominalH, this.myParent.baseUOM);
				
				/* Reset graphics */
				this.resetGraphics();

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		} else {
			//Setting selected dimension for scale selected
			setWHDimChangeInit(nominalW, nominalH, true);
			
			//Init new design levels
			this.getDesignLevelsNew();
		}
		
	}
	
	/**
	 * This method open a JobItem design and perform operation over this.
	 */
	public void openJobItemInfo() {
		
		try {
			
			/* Setting JobItem Information */
			this.jobid = myParent.jobID;
			this.itemid = myParent.itemID;
			this.versionid = myParent.versionID;
			this.seriesid = myParent.seriesID;
			this.designID = myParent.designID;
			this.designFamily = myParent.designFamilyID;
			
			//Open and init Order items cart values
			this.orderItemsCartController.openOrderItemsCart();

            //Setting Order Items Cart
            this.orderItemsCart = this.orderItemsCartController.getOrderItemsCart();
			
			//Open job item design
			jobItemModelController.openJobItemDesign();
			
			//Reset graphics
			this.resetGraphics();
			
			//Init facet selected for design
//			this.initFacetSelectedForDesign();
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

    /**
     * This method select a default facet for design
     */
	public void initFacetSelectedForDesign() {

		if(design!=null){
			/**
			 * Evaluate canvas design and item frame main panel has a default facet selected
			 */
			if (this.myCanvas.mySelectedFacet == null || this.myParent.facetUsed == null) {

				Object[] facets = this.design.frames.toArray();
				this.design.frames.clear();

				for (Object f : facets) {
					Facet facet = (Facet) f;

					/**
					 * Iterate facet collection from overall to obtain a facet
					 * sequence (11) and set into myCanvas design and myParent
					 * ItemFrame as a default facet used.
					 */
					if (facet.a_sequenceID == 11) {
						facet.inUse = true;
						this.myCanvas.mySelectedFacet = facet;
						this.myParent.facetUsed = facet;
					} else {
						facet.inUse = false;
					}

					/**
					 * Construct collection of facets for design
					 */
					this.design.frames.add(f);
				}
			}
		}
	}

    /**
     * This method init design options from JobItem Model
     */
    public void initDesignOptions() {

        for (DesignOption designOption : this.designOptionsAll) {

            if (designOption.remote) {
                designOption.myoption = ItemFrame.getApplicationRemoteBaseRules().getOptionDefinitions(
                        designOption.supplierID, designOption.optionid);
                designOption.myanswer = ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(
                        designOption.supplierID, designOption.optionid, designOption.answerid);
                designOption.optionsAllowedAnswers = ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(
                        designOption.supplierID, designOption.optionid);
            } else {
                designOption.myoption = ItemFrame.getApplicationBaseRules().getOptionDefinitions(designOption.optionid);
                designOption.myanswer = ItemFrame.getApplicationBaseRules().getOptionAnswers(designOption.optionid, designOption.answerid);
                designOption.optionsAllowedAnswers = ItemFrame.getApplicationBaseRules().getOptionAnswers(designOption.optionid);
            }
        }

        //Setting collection to ItemFrame designOptionsAll
        this.myParent.designOptionsAll = this.designOptionsAll;

        buildErrorList();

        //Reset Values to UI Component
        this.myParent.createNetDesignOption();
        this.myParent.options.initValues();
    }

    public void buildErrorList() {
		
		this.myParent.errorMessages = this.designErrors;
		this.myParent.warningMessages = this.designWarnings;
		
		myParent.buildErrorList();
		
		
		if(myParent.errorMessages.size()>0 || myParent.warningMessages.size()>0){	
			
			myParent.collapsemenu.add(myParent.errorWarningTask);
			myParent.errorWarningTask.setCollapsed(false);
			myParent.collapsemenu.validate();
			myParent.collapsemenu.repaint();
		}
		
		if(myParent.errorMessages.size()==0 && myParent.warningMessages.size()==0){
			
			myParent.collapsemenu.remove(myParent.errorWarningTask);
			myParent.designTask.setCollapsed(false);
			myParent.collapsemenu.validate();
			myParent.collapsemenu.repaint();
		}
		
		myParent.initInfoList();
		
	}
	
	/**
	 * This method create a new design level for JobItem
	 */
	private void getDesignLevelsNew() throws Exception{

		//Init overall design
		this.design = new Overall(this.myParent, this, 1, this.rID, 0);
		
		//Setting flat width flax pixels
		this.design_flat_WIDTHpix = this._WIDTHpix;
		this.design_flat_HEIGHTpix = this._HEIGHTpix;
		
		//Init Overall design for metric system
		if (this.myParent.myTopPanel.metric.isSelected()){
			this.design.initOverall(this.design_flat_WIDTHpix, this.design_flat_HEIGHTpix, this.myParent.baseUOM);
		}
		else if (myParent.myTopPanel.impDec.isSelected() || this.myParent.myTopPanel.impFrac.isSelected()){
			this.design.initOverall(this.design_flat_WIDTHpix, this.design_flat_HEIGHTpix, this.myParent.baseUOM);
		}
		
		
		//Setting width values for Imperial and metric
		this.design.widthI = this.design_WIDTH_Imp;
		this.design.widthM = this.design_WIDTH_Metric;
		this.design.widthIO = this.design_WIDTH_Imp_O;
		this.design.widthMO = this.design_WIDTH_Metric_O;
		//Setting height values for Imperial and metric
		this.design.heightI = this.design_HEIGHT_Imp;
		this.design.heightM = this.design_HEIGHT_Metric;
		this.design.heightIO = this.design_HEIGHT_Imp_O;
		this.design.heightMO = this.design_HEIGHT_Metric_O;
		
		//Reset graphic
		this.resetGraphics();

	}
	
	public int getShapeID() {
		return shapeID;
	}
	
	public void setShapeID(final int shape) {
		shapeID = shape;
	}
	
	/**
	 * Setting Width and Height Dimension change
	 *
	 * @param wOverall, Width overall
	 * @param hOverall, Height overall
	 * @param setTexts, Boolean
	 */
	public void setWHDimChangeInit(double wOverall, double hOverall, boolean setTexts) {
		
		if (myParent.myTopPanel.metric.isSelected()) { //Execute for metric unit of metric
			
			
			//Setting dimension for metric unit of metric
			_WIDTH_Metric = (int) (wOverall * 100);
			_WIDTH_Metric_O = this._WIDTH_Metric;
			design_WIDTH_Metric = this._WIDTH_Metric;
			design_WIDTH_Metric_O = this._WIDTH_Metric;
			
			_HEIGHT_Metric = (int) (hOverall * 100);
			_HEIGHT_Metric_O = this._HEIGHT_Metric;
			design_HEIGHT_Metric = this._HEIGHT_Metric;
			design_HEIGHT_Metric_O = this._HEIGHT_Metric;
			
			//Calculate metric scale
			this.myParent.metricscale = calcScale(this._WIDTH_Metric, this._HEIGHT_Metric);
			
			//Imperial dimension calculation
			int impw = 0;
			int imph = 0;
			
			if (this.myParent.mySeries != null) {
				impw = Integer.parseInt(UOMConvert.metricToSixtyFourth(wOverall + ""));
				imph = Integer.parseInt(UOMConvert.metricToSixtyFourth(wOverall + ""));
				impw = (int) (((int) (impw / myParent.impRound)) * myParent.impRound);
				imph = (int) (((int) (imph / myParent.impRound)) * myParent.impRound);
				
			} else {
				this.myParent.mySeries = new Series();
				impw = Integer.parseInt(UOMConvert.metricToSixtyFourth(wOverall + ""));
				imph = Integer.parseInt(UOMConvert.metricToSixtyFourth(wOverall + ""));
				impw = (int) (((int) (impw / myParent.impRound)) * myParent.impRound);
				imph = (int) (((int) (imph / myParent.impRound)) * myParent.impRound);
			}
			
			//Setting dimension for imperial unit of metric
			_WIDTH_Imp_O = impw;
			_WIDTH_Imp = impw;
			design_WIDTH_Imp = impw;
			design_WIDTH_Imp_O = impw;
			_HEIGHT_Imp = imph;
			_HEIGHT_Imp_O = imph;
			design_HEIGHT_Imp = imph;
			design_HEIGHT_Imp_O = imph;
			//Calculate imperial scale
			this.myParent.imperialscale = calcScale(_WIDTH_Imp, _HEIGHT_Imp);
			
			//Setting pixels dimension from metric values
			_WIDTHpix = (new BigDecimal(_WIDTH_Metric).multiply(myParent.metricscale).setScale(20,
						BigDecimal.ROUND_UP).doubleValue());
			
			_HEIGHTpix = (new BigDecimal(_HEIGHT_Metric).multiply(myParent.metricscale).setScale(20,
						BigDecimal.ROUND_UP).doubleValue());
			
			design_flat_WIDTHpix = _WIDTHpix;
			design_flat_HEIGHTpix = _HEIGHTpix;
			
			//Setting to myParent scale value
			this.myParent.scale = myParent.metricscale;
			
		} else if (myParent.myTopPanel.impDec.isSelected()) { //Execute for imperial unit of metric
			
			//Converting for metric unit of metric
			int mw = 0;
			int mh = 0;
			try {
				mw = (int) Double.parseDouble(UOMConvert.imperialTometric(wOverall + ""));
				mh = (int) Double.parseDouble(UOMConvert.imperialTometric(hOverall + ""));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mw = (int) (((int) (mw / myParent.metricRound)) * myParent.metricRound) * 100;
			mh = (int) (((int) (mh / myParent.metricRound)) * myParent.metricRound) * 100;
			
			//Setting dimension for metric unit of measure
			_WIDTH_Metric = mw;
			_WIDTH_Metric_O = mw;
			this.
			design_WIDTH_Metric = mw;
			
			_HEIGHT_Metric = mh;
			_HEIGHT_Metric_O = mh;
			design_HEIGHT_Metric = mh;
			
			//Calculate metric unit of metric
			this.myParent.metricscale = calcScale(_WIDTH_Metric, _HEIGHT_Metric);
			
			//Setting dimension for imperial decimal unit of measure
			_WIDTH_Imp = (int) (wOverall * 64d);
			_WIDTH_Imp = (int) (((int) (_WIDTH_Imp / myParent.impRound)) * myParent.impRound);
			
			_WIDTH_Imp_O = _WIDTH_Imp;
			design_WIDTH_Imp = _WIDTH_Imp;
			
			_HEIGHT_Imp = (int) (hOverall * 64d);
			_HEIGHT_Imp = (int) (((int) (_HEIGHT_Imp / myParent.impRound)) * myParent.impRound);
			
			_HEIGHT_Imp_O = _HEIGHT_Imp;
			design_HEIGHT_Imp = _HEIGHT_Imp;
			
			//Calculate imperial scale unit of measure
			this.myParent.imperialscale = calcScale(_WIDTH_Imp, _HEIGHT_Imp);
			
			//Setting pixels dimension from metric values
			_WIDTHpix = (new BigDecimal(_WIDTH_Imp).multiply(myParent.imperialscale).setScale(20,
						BigDecimal.ROUND_UP).doubleValue());
			
			_HEIGHTpix = (new BigDecimal(_HEIGHT_Imp).multiply(myParent.imperialscale).setScale(20,
						BigDecimal.ROUND_UP).doubleValue());
			
			design_flat_WIDTHpix = _WIDTHpix;
			design_flat_HEIGHTpix = _HEIGHTpix;
			
			//Setting to myParent scale value
			this.myParent.scale = this.myParent.imperialscale;
			
		} else if (myParent.myTopPanel.impFrac.isSelected()) { //Execute for Imperial fraction
			
			//Converting for metric unit of metric
			// int mw = (int) (myParent.roundDim(wOverall * 25.4, 1,
			// myParent.metricRound, 1) * 100);
			// int mh = (int) (myParent.roundDim(hOverall * 25.4, 1,
			// myParent.metricRound, 1) * 100);
			
			int mw = 0;
			int mh = 0;
			try {
				mw = Integer.parseInt(UOMConvert.imperialTometric(wOverall + ""));
				mh = Integer.parseInt(UOMConvert.imperialTometric(wOverall + ""));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mw = (int) (((int) (mw / myParent.metricRound)) * myParent.metricRound) * 100;
			mh = (int) (((int) (mh / myParent.metricRound)) * myParent.metricRound) * 100;
			
			//Setting dimension for metric unit of measure
			_WIDTH_Metric = mw;
			_WIDTH_Metric_O = mw;
			design_WIDTH_Metric = mw;
			
			_HEIGHT_Metric = mh;
			_HEIGHT_Metric_O = mh;
			design_HEIGHT_Metric = mh;
			
			//Calculate metric unit of measure
			this.myParent.metricscale = calcScale(_WIDTH_Metric, _WIDTH_Metric);
			
			//Setting dimension for imperial decimal unit of measure
			_WIDTH_Imp = (int) (wOverall * 64);
			_WIDTH_Imp = (int) (((int) (_WIDTH_Imp / myParent.impRound)) * myParent.impRound);
			
			_WIDTH_Imp_O = _WIDTH_Imp;
			design_WIDTH_Imp = _WIDTH_Imp;
			
			_HEIGHT_Imp = (int) (hOverall * 64);
			_HEIGHT_Imp = (int) (((int) (_HEIGHT_Imp / myParent.impRound)) * myParent.impRound);
			
			_HEIGHT_Imp_O = _HEIGHT_Imp;
			design_HEIGHT_Imp = _HEIGHT_Imp;
			
			//Calculate imperial fraction unit of measure
			this.myParent.imperialscale = calcScale(_WIDTH_Imp, _HEIGHT_Imp);
			
			//Setting pixels dimension from imperial fraction
			_WIDTHpix = (new BigDecimal(_WIDTH_Imp).multiply(myParent.imperialscale).setScale(20,
						BigDecimal.ROUND_UP).doubleValue());
			
			design_flat_WIDTHpix = _WIDTHpix;
			
			_HEIGHTpix = (new BigDecimal(_HEIGHT_Imp).multiply(myParent.imperialscale).setScale(20,
						BigDecimal.ROUND_UP).doubleValue());
			
			design_flat_HEIGHTpix = _HEIGHTpix;
			
			//Setting to myParent scale value
			this.myParent.scale = this.myParent.imperialscale;
		}
		
		//Update width and height dimension for UI
		setWHTexts(wOverall, hOverall, setTexts);
		
		//Update Job model scale value selected
		this.scale = this.myParent.scale;
	}
	
	/**
	 * Before calculate new dimensions changes we need to make sure that we have save the actual dimensions
	 * for future use in calculations options.
	 */
	public void setDimensionOptions() {
		
		if (this.dimensionOptions == null) {
			this.dimensionOptions = new DimensionOptions();
		}
		
		this.dimensionOptions = new DimensionOptions();
		
		this.dimensionOptions.set_WIDTH_Pix(this._WIDTHpix);
		this.dimensionOptions.set_HEIGHT_Pix(this._HEIGHTpix);
		this.dimensionOptions.set_WIDTH_Metric(this._WIDTH_Metric);
		this.dimensionOptions.set_HEIGHT_Metric(this._HEIGHT_Metric);
		this.dimensionOptions.set_WIDTH_Imp(this._WIDTH_Imp);
		this.dimensionOptions.set_HEIGHT_Imp(this._HEIGHT_Imp);
		this.dimensionOptions.set_WIDTH_Metric_O(this._WIDTH_Metric_O);
		this.dimensionOptions.set_HEIGHT_Metric_O(this._HEIGHT_Metric_O);
		this.dimensionOptions.set_WIDTH_Imp_O(this._WIDTH_Imp_O);
		this.dimensionOptions.set_HEIGHT_Imp_O(this._HEIGHT_Imp_O);
		
		this.dimensionOptions.set_metric_scale(this.myParent.metricscale);
		this.dimensionOptions.set_imperial_scale(this.myParent.imperialscale);
		this.dimensionOptions.set_scale(this.myParent.scale);
		
		this.dimensionOptions.set_starting_X(this.startingX);
		this.dimensionOptions.set_starting_Y(this.startingY);
	}
	
	/**
	 * This method calculate change dimension in Width & Height for design. Calculate a scale draw
	 * from canvas dimensions and type unit of metrics.
	 *
	 * @param wOverall, Width Overall design
	 * @param hOverall, Height Overall design
	 * @param setTexts, Setting text
	 */
	public void setWHDimChange(double wOverall, double hOverall, boolean setTexts) {
		
		//Save current dimension parameters before process new dimensions
		this.setDimensionOptions();
		
		/**
		 * Calculate scale for metric unit of metric selected
		 */
		if (myParent.myTopPanel.metric.isSelected()) {
			
			doChangeDimMetric(wOverall, hOverall);
			
		} else if (myParent.myTopPanel.impDec.isSelected()) {
			
			doChangeDimImperial(wOverall, hOverall);
			
		} else if (myParent.myTopPanel.impFrac.isSelected()) {
			
			doChangeDimImperial(wOverall, hOverall);
			
		}
		
		//Updating widthMO and widthIO for width size entered
		if (myParent.wEntered) {
			design.widthMO = _WIDTH_Metric_O;
			design.widthIO = _WIDTH_Imp_O;
		}
		
		//Updating width metrics calculation
		this.design.widthM = this._WIDTH_Metric;
		this.design.widthI = this._WIDTH_Imp;
		this.design.widthPix = this._WIDTHpix;
		
		//Updating heightMO and heightIO for height size entered
		if (myParent.hEntered) {
			design.heightMO = _HEIGHT_Metric_O;
			design.heightIO = _HEIGHT_Imp_O;
		}
		
		//Updating height metrics calculation
		this.design.heightM = this._HEIGHT_Metric;
		this.design.heightI = this._HEIGHT_Imp;
		this.design.heightPix = this._HEIGHTpix;
		
		//Updating text values for top panel values
		setWHTexts(wOverall, hOverall, setTexts);
		
		//Update scale for this job item design
		this.scale = myParent.scale;
	}
	
	public void doChangeDimMetric(double wOverall, double hOverall) {
		
		// Width dimension entered for UI
		if (myParent.wEntered) {
			_WIDTH_Metric_O = (int) (wOverall * 100); // Parsing to metric
			// unit of metric
			_WIDTH_Imp_O = (int) (wOverall / 25.4 * 64d); // Parsing to
			// imperial unit of
			// metric
		}
		
		// Height dimension entered for UI
		if (myParent.hEntered) {
			_HEIGHT_Metric_O = (int) (hOverall * 100); // Parsing to metric
			// unit of metric
			_HEIGHT_Imp_O = (int) (hOverall / 25.4 * 64d); // Parsing to
			// imperial
			// unit of
			// metric
		}
		
		int impw = 0;// wOverall*25.4;
		int imph = 0;// hOverall*25.4;
		
		if (_WIDTH_Imp_O != 0) {
			impw = _WIDTH_Imp_O;// wOverall*25.4;
			imph = _HEIGHT_Imp_O;// hOverall*25.4;
		} else if (_WIDTH_Metric_O != 0) {
			impw = (int) (wOverall / 25.4 * 64d);
			imph = (int) (hOverall / 25.4 * 64d);
		}
		
		// ************************************************************
		// Preparing new dimension values
		// ************************************************************
		
		// ******************************************************
		// Metric dimensions
		// ******************************************************
		this._WIDTH_Metric = (int) (wOverall * 100);
		this.design_WIDTH_Metric = this._WIDTH_Metric;
		
		this._HEIGHT_Metric = (int) (hOverall * 100);
		this.design_HEIGHT_Metric = this._HEIGHT_Metric;
		
		// Calculate metric scale from WIDTH & HEIGHT
		this.myParent.metricscale = calcScale(_WIDTH_Metric, _HEIGHT_Metric);
		
		// *****************************************************
		// Imperial dimensions
		// *****************************************************
		this._WIDTH_Imp = impw;
		this.design_WIDTH_Imp = impw;
		
		this._HEIGHT_Imp = imph;
		this.design_HEIGHT_Imp = imph;
		
		// Calculate imperial scale from WIDTH & HEIGHT
		this.myParent.imperialscale = calcScale(_WIDTH_Imp, _HEIGHT_Imp);
		
		// ****************************************************
		// Pixels dimensions
		// ****************************************************
		this.odW = this.design.widthPix;
		this.odH = this.design.heightPix;
		
		this._WIDTHpix = (new BigDecimal(_WIDTH_Metric).multiply(myParent.metricscale).setScale(20,
					BigDecimal.ROUND_UP).doubleValue());
		
		this.design_flat_WIDTHpix = this._WIDTHpix;
		
		this._HEIGHTpix = (new BigDecimal(_HEIGHT_Metric).multiply(myParent.metricscale).setScale(20,
					BigDecimal.ROUND_UP).doubleValue());
		
		this.design_flat_HEIGHTpix = this._HEIGHTpix;
		
		// Setting to ItemFrame scale selected.
		this.myParent.scale = myParent.metricscale;
	}
	
	public void doChangeDimImperial(double wOverall, double hOverall) {
		
		// Width dimension entered for UI
		if (myParent.wEntered) {
			_WIDTH_Imp_O = (int) (wOverall * 64d); // Parsing to metric unit
			// of metric
			_WIDTH_Metric_O = (int) (wOverall * 25.4 * 100); // Parsing to
			// imperial
			// unit of
			// metric
		}
		
		// Height dimension entered for UI
		if (myParent.hEntered) {
			_HEIGHT_Imp_O = (int) (hOverall * 64d); // Parsing to metric unit
			// of metric
			_HEIGHT_Metric_O = (int) (hOverall * 25.4 * 100); // Parsing to
			// imperial
			// unit of
			// metric
			
		}
		
		int impw = 0;// wOverall*25.4;
		int imph = 0;// hOverall*25.4;
		
		if (_WIDTH_Imp_O != 0) {
			impw = _WIDTH_Imp_O;// wOverall*25.4;
			imph = _HEIGHT_Imp_O;// hOverall*25.4;
		} else if (_WIDTH_Metric_O != 0) {
			impw = (int) (wOverall / 25.4 * 64d);
			imph = (int) (hOverall / 25.4 * 64d);
		}
		
		// ************************************************************
		// Preparing new dimension values
		// ************************************************************
		
		// ******************************************************
		// Metric dimensions
		// ******************************************************
		this._WIDTH_Metric = _WIDTH_Metric_O;
		this.design_WIDTH_Metric = this._WIDTH_Metric;
		
		this._HEIGHT_Metric = _HEIGHT_Metric_O;
		this.design_HEIGHT_Metric = this._HEIGHT_Metric;
		
		// Calculate metric scale from WIDTH & HEIGHT
		this.myParent.metricscale = calcScale(_WIDTH_Metric, _HEIGHT_Metric);
		
		// *****************************************************
		// Imperial dimensions
		// *****************************************************
		this._WIDTH_Imp = impw;
		this.design_WIDTH_Imp = impw;
		
		this._HEIGHT_Imp = imph;
		this.design_HEIGHT_Imp = imph;
		
		// Calculate imperial scale from WIDTH & HEIGHT
		this.myParent.imperialscale = calcScale(_WIDTH_Imp, _HEIGHT_Imp);
		
		// ****************************************************
		// Pixels dimensions
		// ****************************************************
		this.odW = this.design.widthPix;
		this.odH = this.design.heightPix;
		
		this._WIDTHpix = (new BigDecimal(_WIDTH_Imp).multiply(myParent.imperialscale).setScale(20,
					BigDecimal.ROUND_UP).doubleValue());
		
		this.design_flat_WIDTHpix = this._WIDTHpix;
		
		this._HEIGHTpix = (new BigDecimal(_HEIGHT_Imp).multiply(myParent.imperialscale).setScale(20,
					BigDecimal.ROUND_UP).doubleValue());
		
		this.design_flat_HEIGHTpix = this._HEIGHTpix;
		
		// Setting to ItemFrame scale selected.
		this.myParent.scale = myParent.imperialscale;
	}
	
	public void setWH(double wOverall, double hOverall, boolean setTexts) {
		
		if (myParent.myTopPanel.metric.isSelected()) {
			
			myParent.metricscale = calcScale((int) (wOverall * 100), (int) (hOverall * 100));
			
			odW = design.widthPix;
			odH = design.heightPix;
			
			_WIDTHpix = design.widthPix = design_flat_WIDTHpix = (new BigDecimal((wOverall * 100)).multiply(
						myParent.metricscale).setScale(20, BigDecimal.ROUND_UP).doubleValue());
			
			_HEIGHTpix = design.heightPix = design_flat_HEIGHTpix = (new BigDecimal((hOverall * 100)).multiply(
						myParent.metricscale).setScale(20, BigDecimal.ROUND_UP).doubleValue());
			
			myParent.scale = myParent.metricscale;
		}
		
		if (myParent.myTopPanel.impDec.isSelected()) {
			odW = design.widthPix;
			odH = design.heightPix;
			
			myParent.imperialscale = calcScale((int) (wOverall * 64d), (int) (hOverall * 64d));
			// Math.max(wOverall,hOverall) / myParent.scaleSizeMax;
			
			_WIDTHpix = design.widthPix = design_flat_WIDTHpix = (new BigDecimal((wOverall * 64d)).multiply(
						myParent.imperialscale).setScale(20, BigDecimal.ROUND_UP).doubleValue());
			
			_HEIGHTpix = design.heightPix = design_flat_HEIGHTpix = (new BigDecimal((hOverall * 64d)).multiply(
						myParent.imperialscale).setScale(20, BigDecimal.ROUND_UP).doubleValue());
			
			myParent.scale = myParent.imperialscale;
		}
		if (myParent.myTopPanel.impFrac.isSelected()) {
			
			odW = design.widthPix;
			odH = design.heightPix;
			myParent.imperialscale = calcScale((int) (wOverall * 64d), (int) (hOverall * 64d));
			
			// myParent.imperialscale =
			// Math.max(wOverall, hOverall)
			// / myParent.scaleSizeMax;
			_WIDTHpix = design.widthPix = design_flat_WIDTHpix = (new BigDecimal((wOverall * 64d)).multiply(
						myParent.imperialscale).setScale(20, BigDecimal.ROUND_UP).doubleValue());
			
			_HEIGHTpix = design.heightPix = design_flat_HEIGHTpix = (new BigDecimal((hOverall * 64d)).multiply(
						myParent.imperialscale).setScale(20, BigDecimal.ROUND_UP).doubleValue());
			
			
			myParent.scale = myParent.imperialscale;
		}
		
		setWHTexts(wOverall, hOverall, setTexts);
	}
	
	/**
	 * Setting Width and Height Texts
	 *
	 * @param wOverall, double
	 * @param hOverall, double
	 * @param setTexts, boolean
	 */
	public void setWHTexts(final double wOverall, final double hOverall, final boolean setTexts) {
		
		String w = "";
		String h = "";
		
		String wo = "";
		String ho = "";
		
		if (myParent.myTopPanel.metric.isSelected()) {
			
			w = myParent.oneDecimal.format(wOverall);
			h = myParent.oneDecimal.format(hOverall);
			
			wo = myParent.oneDecimal.format(wOverall + myParent.myTopPanel.getOAW() / 100d);
			ho = myParent.oneDecimal.format(hOverall + myParent.myTopPanel.getOAH() / 100d);
			
		} else if (myParent.myTopPanel.impDec.isSelected() || myParent.myTopPanel.feet.isSelected()) {
			
			w = myParent.sixDecimal.format(wOverall);
			h = myParent.sixDecimal.format(hOverall);
			
			wo = myParent.sixDecimal.format(wOverall + myParent.myTopPanel.getOAW() / 64d);
			ho = myParent.sixDecimal.format(hOverall + myParent.myTopPanel.getOAH() / 64d);
			
		} else if (myParent.myTopPanel.impFrac.isSelected()) {
			
			try {
				w = UOMConvert.imperialToFraction("".concat(String.valueOf(String.valueOf(wOverall))));
				h = UOMConvert.imperialToFraction("".concat(String.valueOf(String.valueOf(hOverall))));
				
				wo = UOMConvert.imperialToFraction("".concat(String.valueOf(String.valueOf(wOverall + myParent.myTopPanel.getOAW() / 64d))));
				ho = UOMConvert.imperialToFraction("".concat(String.valueOf(String.valueOf(hOverall + myParent.myTopPanel.getOAH() / 64d))));
				
			} catch (final Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (setTexts) {
			myParent.myTopPanel.fW.setText(w);
			myParent.myTopPanel.fH.setText(h);
			myParent.myTopPanel.oW.setText(wo);
			myParent.myTopPanel.oH.setText(ho);
		}
	}

    /**
     * Reset Graphics design
     */
    public void resetGraphics() {

        //Remove canvas design
        if (myCanvas != null) {
            myParent.mainFramePanel.removeAll();
        }

        //Setting values config
        if (myParent.lastRR == 0) {
            myParent.lastRR = 1;
        }
        if (myParent.lastRC == 0) {
            myParent.lastRC = 1;
        }
        if (myParent.lastRCo == 0) {
            myParent.lastRCo = 1;
        }
        if (myParent.lastRRo == 0) {
            myParent.lastRRo = 1;
        }

        //Draw a new canvas
        myCanvas = new DrawCanvas(myParent, myParent.lastRR, myParent.lastRC, myParent.lastRRo, myParent.lastRCo);
    	
        myParent.mainFramePanel.add(myParent.topChecks,BorderLayout.NORTH);
        myParent.mainFramePanel.add(myParent.leftChecks,BorderLayout.WEST);
        myParent.mainFramePanel.add(myCanvas, BorderLayout.CENTER);

        //Init Facet selected
        initFacetSelectedForDesign();

        myCanvas.drawTextTop = true;

        // Clear draw canvas components
        myCanvas.clearDrawCanvasComponents();

        myCanvas.createTextFieldsTop();
        myCanvas.createTextFieldsLeft();
        myCanvas.createTextFieldsFacet();
        myCanvas.createTextFieldsCoupler();

        myCanvas.redrawTextForColRow(false);

        myParent.validate();
        myParent.repaint();
    }
	
	/**
	 * This method calculate scale from width & height dimensions
	 *
	 * @param w, double width
	 * @param h, double height
	 * @return double
	 */
	public BigDecimal calcScale(double w, double h) {
		
		//Represents scale value calculation
		BigDecimal scale = new BigDecimal("0");
		
		/**
		 * Maximum width screen equals 1024 pixels. More than this size substract
		 * 500 - starting X position - 100
		 */
		if (myParent.myDim.width <= 1024) {
			this.canvasW = 400;
		} else {
			this.canvasW = (int) (myParent.myDim.width - 500 - startingX - 100);
		}
		
		/**
		 * Maximum height screen 900 pixels. More than this size substract 500.
		 */
		if (myParent.myDim.height <= 900) {
			this.canvasH = 400;
		} else {
			this.canvasH = myParent.myDim.height - 500;
		}
		
		//Setting minimun & maximum scale size
		this.myParent.scaleSizeMin = Math.min(canvasW, canvasH);
		this.myParent.scaleSizeMax = Math.max(canvasW, canvasH);
		
		//Evaluate metric scale when width & height are equals
		if (w == h) {
			canvasH = canvasW = Math.min(canvasH, canvasW);
			scale = new BigDecimal(canvasH).divide(new BigDecimal(Math.max(w, h)), 20, BigDecimal.ROUND_UP);
		}

		//Evaluate metric scale when height is grater than width
		if (h > w) {

			scale = new BigDecimal(canvasH).divide(new BigDecimal(h + ""), 20, BigDecimal.ROUND_UP);

			BigDecimal width = new BigDecimal(w + "");
			width = width.multiply(scale).setScale(20, BigDecimal.ROUND_UP);

			if (width.compareTo(new BigDecimal(canvasW + "")) > 1) {
				BigDecimal diff = width.multiply(scale).subtract(new BigDecimal(canvasW + ""));
				canvasH = new BigDecimal(canvasH + "").subtract(diff).doubleValue();

				scale = new BigDecimal(canvasH + "").divide(new BigDecimal(h + ""), 20, BigDecimal.ROUND_UP);

//				do {
//					scale = new BigDecimal(canvasH--).divide(new BigDecimal(h), 20, BigDecimal.ROUND_UP);
//				} while (new BigDecimal(w + "").multiply(scale).compareTo(new BigDecimal(canvasW + "")) > 1);
			}

		}

		//Evaluate metric scale when width is grater than height
		if (w > h) {

			scale = new BigDecimal(canvasW).divide(new BigDecimal(w + ""), 20, BigDecimal.ROUND_UP);

			BigDecimal height = new BigDecimal(w + "");
			height = height.multiply(scale).setScale(20, BigDecimal.ROUND_UP);

			if (height.compareTo(new BigDecimal(canvasH + "")) > 1) {
				BigDecimal diff = height.subtract(new BigDecimal(canvasH + ""));
				canvasH = new BigDecimal(canvasW + "").subtract(diff).doubleValue();

				scale = new BigDecimal(canvasW + "").divide(new BigDecimal(w + ""),20, BigDecimal.ROUND_UP);

//				do {
//					scale = new BigDecimal(canvasW--).divide(new BigDecimal(w), 20, BigDecimal.ROUND_UP);
//				} while (new BigDecimal(h + "").multiply(scale).compareTo(new BigDecimal(canvasH + "")) > 1);
			}
			
		}
		
		
		return scale;
	}
	
	/**
	 * This method save JobItem and Order Items Cart Model Object
	 *
	 * @throws Exception , Exception
	 */
	public void saveObjectModel() throws Exception {

		if (myParent.isNewItem) {
			orderItemsCartController.createOrderItemsCart();
		} else {
			orderItemsCartController.updateOrderItemsCart();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("********************************************");
			logger.debug("JOB ITEM ENTITY OBJECT SAVED");
			logger.debug("JOB ITEM ID: " + jobItem.getOrderId());
			logger.debug("********************************************");
			
			logger.debug("********************************************");
			logger.debug("ORDER ITEMS CART SAVED");
			logger.debug("ORDER ITEMS CART ID: " + orderItemsCart.getId().getId());
			logger.debug("********************************************");
		}
	}
	
	@Override
	public JobItemModel clone() {
		
		try {
			
			//Clone JobItem Model
			JobItemModel newJobItem = (JobItemModel) super.clone();
			
			//Clone Dimension option
			newJobItem.dimensionOptions = null;
			
			//Clone Overall design
			newJobItem.design = newJobItem.design.clone();
			
			//Clone Bom collection
			Collection<BillOfMat> bom = new ArrayList<BillOfMat>();
			for (BillOfMat billOfMat : newJobItem.bom) {
				bom.add(billOfMat.clone());
			}
			newJobItem.bom = bom;
			
			//Clone Glass Bom collection
			Collection<DesignGlass> glassBom = new ArrayList<DesignGlass>();
			for (DesignGlass designGlass : newJobItem.glassBOM) {
				glassBom.add(designGlass.clone());
			}
			newJobItem.glassBOM = glassBom;
			
			//Clone design options
			Collection<DesignOption> options = new ArrayList<DesignOption>();
			for (DesignOption designOption : newJobItem.myParent.designOptionsAll) {
				options.add(designOption.clone());
			}
			newJobItem.designOptionsAll = options;


			return newJobItem;
			
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(), e);
		}
		
		return null;
	}
	
}
