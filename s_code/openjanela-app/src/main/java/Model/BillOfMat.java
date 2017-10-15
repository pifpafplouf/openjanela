package Model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

import Model.ProfileParts.PartsNotching;
import Presentation.ItemFrame;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.ProductionLine;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.SeriesValidOpeningShapeMfg;
import openjanela.model.entities.parts.Parts;

import org.apache.log4j.Logger;

import Model.ProfileParts.Profiles;
import Rules.ExecuteRules;

import org.openjanela.commons.util.data.UOMUtility;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;
import org.openjanela.data.ApplicationMainBaseApp;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 *         Date 03-06-12
 *         Time: 11:41 AM
 *         <p/>
 *         This class represents Bill of Material Model representation
 */
public class BillOfMat implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(BillOfMat.class);

    public int a_levelID = 0;
    public int a_sequenceID = 11;
    public int a_assemblyLevel = 0;
    public int a_1Level = 0;
    public int a_1Sequence = 0;
    public int a_2Level = 0;
    public int a_2Sequence = 0;
    public int a_3Level = 0;
    public int a_3Sequence = 0;
    public int a_4Level = 0;
    public int a_4Sequence = 0;
    public int a_5Level = 0;
    public int a_5Sequence = 0;
    public int a_6Level = 0;
    public int a_6Sequence = 0;
    public int a_7Level = 0;
    public int a_7Sequence = 0;
    public int a_8Level = 0;
    public int a_8Sequence = 0;
    public int a_9Level = 0;
    public int a_9Sequence = 0;
    public int a_10Level = 0;
    public int a_10Sequence = 0;
    public int a_11Level = 0;
    public int a_11Sequence = 0;
    public int a_12Level = 0;
    public int a_12Sequence = 0;
    public int a_13Level = 0;
    public int a_13Sequence = 0;
    public int a_14Level = 0;
    public int a_14Sequence = 0;
    public int a_15Level = 0;
    public int a_15Sequence = 0;
    public int a_16Level = 0;
    public int a_16Sequence = 0;
    public int a_17Level = 0;
    public int a_17Sequence = 0;
    public int a_18Level = 0;
    public int a_18Sequence = 0;
    public int a_19Level = 0;
    public int a_19Sequence = 0;
    public int a_20Level = 0;
    public int a_20Sequence = 0;
    public int a_21Level = 0;
    public int a_21Sequence = 0;
    public int a_22Level = 0;
    public int a_22Sequence = 0;

    public int id = 0;
    public int bomId = 0;
    public int orderid = 0;
    public int itemno = 0;
    public int versionid = 0;

    public int partid = 0;
    public int parttype = 0;
    public int seriesid = 0;
    public int leafNo = 0;

    public int cutlength = 0;
    public int cutlengthi = 0;
    public int width = 0;
    public int widthi = 0;
    public int height = 0;
    public int heighti = 0;
    public int level = 0;
    public int position = 0;
    public int orientation = 0;
    public int startpos = 0;
    public int endpos = 0;

    public int openingid = 0;
    public int shapeID = 0;
    public int sash = 0;

    public int radius1 = 0;
    public int radius1i = 0;
    public int radius2 = 0;
    public int radius2i = 0;

    public int row = 0;
    public int col = 0;
    public int parentrow = 0;
    public int parentcol = 0;
    public int prodline = 0;
    public int station = 0;
    public int report = 0;
    public int delivery = 0;

    public int supplierid = 0;
    public int leadtime = 0;

    public int assemblyid = 0;
    public int parentbomid = 0;
    public int parentAssembly = 0;
    public int reqforstage = 0;
    public int sysAssemblyId = 0;
    public int processId = 0;

    public Integer ruleno;

    public BigDecimal cost;
    public BigDecimal price;
    public BigDecimal totalprice;
    public BigDecimal totalcost;
    public BigDecimal priceuser;
    public BigDecimal totalpriceuser;

    public boolean addon;
    public boolean buy;
    public boolean track;
    public boolean glazed;

    public String stockcode;
    public String description;
    public String stockcodeUser;
    public String descriptionuser;

    public double qtyuser;
    public int cutlengthuser;
    public int cutlengthiuser;
    public int widthuser;
    public int widthiuser;
    public int heightuser;
    public int heightiuser;
    public int depth;
    public int depthi;
    public int depthuser;
    public int depthiuser;

    public int weld;
    public int weldi;
    public int weldR;
    public int weldRi;
    public int leftcut;
    public int rightcut;

    public double qty;
    public double leftangle;
    public double rightangle;

    public double area;
    public double areai;
    public double areauser;
    public double areaiuser;
    public double volume;
    public double volumei;
    public double volumeuser;
    public double volumeiuser;

    public double lengthw2;
    public double lengthh2;
    public double lengthf12;
    public double lengthf22;

    public boolean isWildSize = false;
    public boolean isWildDepth = false;
    public boolean isWildColor = false;

    public boolean isWild1 = false;
    public boolean isWild2 = false;
    public boolean isWild3 = false;
    public boolean isWild4 = false;
    public boolean isWild5 = false;
    public boolean isWild6 = false;

    public int parentRule = 0;

    public int partFamily = 0;
    public int priceGroup = 0;
    public int priceCat = 0;
    public int glassBomid = 0;
    public int partSequence = 0;

    public boolean leftIn = false;
    public boolean rightIn = false;
    public boolean assembly = false;

    public String descriptionLevel = "";
    public String sashAbbreviation = "";
    public String shapeAbbreviation = "";

    public String notchLT = "";
    public String notchRB = "";
    public String notchLTi = "";
    public String notchRBi = "";

    public int gridID = 0;
    public int gridTypeID = 0;

    //*******************************************************
    // Shape Object Values
    //*******************************************************
    public int radius1_shape = 0;
    public int radius1_i_shape = 0;
    public int radius2_shape = 0;
    public int radius2_i_shape = 0;

    public int minLeg = 0;
    public int minLeg_i = 0;

    public double dimA1 = 0;
    public double dimA2 = 0;
    public double dimA3 = 0;
    public double dimA4 = 0;
    public double dimA5 = 0;
    public double dimA0 = 0;
    public double dimB1 = 0;
    public double dimB2 = 0;
    public double dimB3 = 0;
    public double dimB4 = 0;
    public double dimB5 = 0;
    public double dimB0 = 0;
    public double dimC1 = 0;
    public double dimC2 = 0;
    public double dimC3 = 0;
    public double dimC4 = 0;
    public double dimC5 = 0;
    public double dimC0 = 0;
    public double dimD1 = 0;
    public double dimD2 = 0;
    public double dimD3 = 0;
    public double dimD4 = 0;
    public double dimD5 = 0;
    public double dimD0 = 0;

    public double dimA1_i = 0;
    public double dimA2_i = 0;
    public double dimA3_i = 0;
    public double dimA4_i = 0;
    public double dimA5_i = 0;
    public double dimA0_i = 0;
    public double dimB1_i = 0;
    public double dimB2_i = 0;
    public double dimB3_i = 0;
    public double dimB4_i = 0;
    public double dimB5_i = 0;
    public double dimB0_i = 0;
    public double dimC1_i = 0;
    public double dimC2_i = 0;
    public double dimC3_i = 0;
    public double dimC4_i = 0;
    public double dimC5_i = 0;
    public double dimC0_i = 0;
    public double dimD1_i = 0;
    public double dimD2_i = 0;
    public double dimD3_i = 0;
    public double dimD4_i = 0;
    public double dimD5_i = 0;
    public double dimD0_i = 0;

    //*******************************************************
    //Supplier Made In Information
    //*******************************************************
    public int supplier_rule_no = 0;
    public int supplier_part_id = 0;
    public boolean glass_made_in = false;
    public boolean bought_glazed = false;

    public int supplierRemoteId = 0;
    public int supplierSeriesId = 0; //Dealer Identification Id
    public boolean remote = false; //Dealer Remote Part

    public int cOrM = 0;

    //Shape Object Identification Object
    public ShapeObject shapeObject;

    //Profiles Identification Object
    public Profiles profiles;

    //Execute Rules
    public ExecuteRules execRules;

    /**
     * Indicate if this boolean is used for assembly view controller
     */
    public boolean isUsed = false;

    /**
     * Indicate if this boolean is loss assembly
     */
    public boolean isLostAssembly = false;

    /**
     * Indicate if this Bill of Material is shipped
     */
    public boolean ships;

    /**
     * List Notches Metric Measure
     */
    public List<String> notchesM = new ArrayList<String>();

    /**
     * List Notches Imperial Measure
     */
    public List<String> notchesI = new ArrayList<String>();

    /**
     * List Notches Imperial Fraction Measure
     */
    public List<String> notchesIY = new ArrayList<String>();

    /**
     * Bill of Material Constructor
     */
    public BillOfMat() {
    }

    /**
     * Bill of Material Constructor
     *
     * @param execrules, Execute Rules
     * @see ExecuteRules
     */
    public BillOfMat(ExecuteRules execrules) {
        this.execRules = execrules;
    }

    /**
     * Set BOM Commons Elements
     *
     * @param profile,    Profiles
     * @param part,       Parts
     * @param shape,      ShapeObject
     * @param myProfile,  Profiles
     * @param cart,       OrderItemsCart
     * @param addOn,      boolean
     * @param rule,       Rules
     * @param quantity,   double
     * @param adjw,       int
     * @param adjwi,      int
     * @param adjh,       int
     * @param adjhi,      int
     * @param parentRule, int
     * @return BillOfMat
     */
    public BillOfMat setBomCommonElements(Profiles profile, Parts part, ShapeObject shape, Profiles myProfile,
                                          OrderItemsCart cart, boolean addOn, Rules rule, double quantity, int adjw,
                                          int adjwi, int adjh, int adjhi, int parentRule) {

        //-----------------------------------------------------
        //Init Shape Identifiers
        //-----------------------------------------------------
        setShapeIdentifires(shape, myProfile, cart);

        this.id = 0;
        this.bomId = 0;
        this.orderid = 0;
        this.itemno = 0;
        this.addon = addOn;

        //---------------------------------------------------
        //Init Rule Number
        //---------------------------------------------------
        if (rule != null && parentRule == 0) {
            this.ruleno = rule.getRulesPK().getId();
            this.supplier_rule_no = rule.getRulesPK().getId();
        } else if (parentRule == -1) {
            this.ruleno = parentRule;
            this.supplier_rule_no = parentRule;
        } else {
            this.ruleno = parentRule;
            this.supplier_rule_no = parentRule;
        }

        //---------------------------------------------------
        //Init Part Object Value
        //---------------------------------------------------
        if (part.getId() != null) {
            this.partid = part.getId();
            this.parttype = part.getParttype();
            this.supplier_part_id = part.getId();
            this.track = part.isTracking();
            this.ships = part.isShips();
        }

        String stockcode = "";
        if (part.isRemote()) {
            stockcode = ItemFrame.getApplicationRemoteBaseRules().getPart(part.getSupplierId(), part.getId()).getStockcode();
        } else {
            stockcode = ItemFrame.getApplicationBase().getOriginalPart(part.getId()).getStockcode();
        }

        part.setStockcode(this.replaceStockCodeWithWildCard(stockcode));

        this.stockcode = part.getStockcode();
        this.description = part.getDescription();

        this.supplierRemoteId = part.getSupplierId();
        this.supplierSeriesId = part.getSeries();
        this.remote = part.isRemote();

        //---------------------------------------------------
        //Init Series Identification
        //---------------------------------------------------
        this.seriesid = 0;
        if (rule != null) {
            this.seriesid = rule.getRulesPK().getSeriesId(); //this.execRules.series.getId();
        }

        this.qty = quantity;

        this.cutlength = 0;
        this.cutlengthi = 0;
        this.width = 0;
        this.widthi = 0;
        this.height = 0;
        this.heighti = 0;

        //---------------------------------------------------
        //Init Profiles Position
        //---------------------------------------------------

        if (rule != null) {
            this.level = rule.getLevel();
//            this.position = rule.getPosition();
        }

        if (profile != null) {
            this.level = profile.a_assemblyLevel;
            this.cOrM = profile.cOrM;

            if (profile.orientation == 1) {
                this.position = 11;
            } else if (profile.orientation == 2) {
                this.position = 12;
            }
        } else if (profile == null && parentRule == -2) {
            this.level = shape.a_assemblyLevel;
            this.position = 19;
        } else if (profile == null && parentRule == -1) {
            this.level = shape.a_assemblyLevel;
            this.position = 18;
        } else if (profile == null && parentRule == -3) {
            this.level = shape.a_assemblyLevel;
            this.position = 20;
        }

        this.radius1 = 0;
        this.radius1i = 0;
        this.radius2 = 0;
        this.radius2i = 0;
        this.leftangle = 0;
        this.rightangle = 0;

        this.cost = new BigDecimal(0);
        this.price = new BigDecimal(0);

        //**************************************************************************************************************
        //Setting Buy properties
        //**************************************************************************************************************
        this.buy = false;

        List<Integer> partTypes = new ArrayList<Integer>();
        partTypes.add(8);
        partTypes.add(9);
        partTypes.add(10);
        partTypes.add(11);
        partTypes.add(12);
        partTypes.add(13);
        partTypes.add(50);
        partTypes.add(51);
        partTypes.add(500);
        partTypes.add(501);
        partTypes.add(502);

        if (!part.isMadein() && !partTypes.contains(part.getParttype())) {
            this.buy = true;
        }

        this.supplierid = 0;
        this.leadtime = 0;
        this.parentbomid = 0;

        this.totalprice = new BigDecimal(0);
        this.totalcost = new BigDecimal(0);
        this.priceuser = new BigDecimal(0);
        this.totalpriceuser = new BigDecimal(0);
        this.stockcodeUser = part.getStockcode();
        this.descriptionuser = part.getDescription();

        this.qtyuser = qty;
        this.cutlengthuser = cutlength;
        this.cutlengthiuser = cutlengthi;
        this.widthuser = width;
        this.widthiuser = widthi;
        this.heightuser = height;
        this.heightiuser = heighti;
        this.depth = depth;
        this.depthi = depthi;
        this.depthuser = depth;
        this.depthiuser = depthi;

        this.area = width / 100000 * height / 100000;
        this.areai = widthi / 64d / 12 * heighti / 64d / 12;

        this.areauser = area;
        this.areaiuser = areai;

        this.volume = width / 100000 * height / 100000 * depth / 100000;
        this.volumei = widthi / 64d / 12 * heighti / 64d / 12 * depthi / 64d / 12;

        this.volumeuser = volume;
        this.volumeiuser = volumei;

//        prodline = rule.prodLine > 0 ? rule.prodLine : shape.myFrame2.executePartRules.setProdLine;
//        station = rule.station > 0 ? rule.station : shape.myFrame2.executePartRules.setStation;
//        report = rule.report > 0 ? rule.report : shape.myFrame2.executePartRules.setReport;
//        delivery = rule.stage > 0 ? rule.stage : shape.myFrame2.executePartRules.setDelivery;
//        assemblyid = rule.assembly > 0 ? rule.assembly : shape.myFrame2.executePartRules.setAssembly;
//        processId = rule.process > 0 ? rule.process : shape.myFrame2.executePartRules.setProcess;
//        parentAssembly = rule.parentAssembly > 0 ? rule.parentAssembly : shape.myFrame2.executePartRules.setParentAssembly;

        // loop on BOM  find last assembly (last RuleNo where ruleNo < this ruleno
        if (shape != null) {

            this.openingid = shape.openingClass;
            this.shapeID = shape.shapeID;
            this.sash = shape.userDefinedOpeningID;
            this.row = shape.startRow;
            this.col = shape.startCol;
            this.parentrow = shape.parentStartRow;
            this.parentcol = shape.parentStartCol;

            if (shape instanceof DLO) {
                this.gridID = ((DLO)shape).gridID;
                this.gridTypeID = ((DLO)shape).gridType;
            }

            if (rule != null && shape != null) {
                this.prodline = rule.prodLine > 0 ? rule.prodLine : shape.myFrame2.executePartRules.setProdLine;
                this.station = rule.station > 0 ? rule.station : shape.myFrame2.executePartRules.setStation;
                this.report = rule.report > 0 ? rule.report : shape.myFrame2.executePartRules.setReport;
                this.delivery = rule.stage > 0 ? rule.stage : shape.myFrame2.executePartRules.setDelivery;
                this.assemblyid = rule.assembly > 0 ? rule.assembly : shape.myFrame2.executePartRules.setAssembly;
                this.processId = rule.process > 0 ? rule.process : shape.myFrame2.executePartRules.setProcess;
                this.parentAssembly = rule.parentAssembly > 0 ? rule.parentAssembly : shape.myFrame2.executePartRules.setParentAssembly;
                this.glazed = rule.glazed;

            } else {
                this.prodline = shape.myFrame2.executePartRules.setProdLine;
                this.station = shape.myFrame2.executePartRules.setStation;
                this.report = shape.myFrame2.executePartRules.setReport;
                this.delivery = shape.myFrame2.executePartRules.setDelivery;
                this.assemblyid = shape.myFrame2.executePartRules.setAssembly;
                this.processId = shape.myFrame2.executePartRules.setProcess;
                this.parentAssembly = shape.myFrame2.executePartRules.setParentAssembly;
                this.glazed = true;
            }

            this.parentRule = 0;// shape.myFrame2.executePartRules.setParentRule;
            this.reqforstage = shape.myFrame2.executePartRules.setStage;
            this.sysAssemblyId = shape.a_assemblyLevel;

            if (part.getParttype() == 2 || part.getParttype() == 15 || part.getParttype() == 4 || part.getParttype() == 502) {
                setBomFromProfileLength(profile, part, shape, myProfile, cart, addOn, rule, quantity, adjw, adjwi, adjh, adjhi,
                        shape.myFrame2.metricscale, shape.myFrame2.imperialscale);
            }

            if (shape.myFrame2.executePartRules.forcedAssembly > 0) {
                this.assemblyid = shape.myFrame2.executePartRules.forcedAssembly;
            }

            if (part.getParttype() == 3 || part.getParttype() == 5 || part.getParttype() == 13 || part.getParttype() == 16) {
                setBomFromArea(profile, part, shape, myProfile, cart, addOn, rule, quantity, adjw, adjwi, adjh, adjhi,
                        shape.myFrame2.metricscale, shape.myFrame2.imperialscale);
            }

            if (part.getParttype() == 14) {
                setBomFromVolume(profile, part, shape, myProfile, cart, addOn, rule, quantity, adjw, adjwi, adjh, adjhi,
                        shape.myFrame2.metricscale, shape.myFrame2.imperialscale);
            }

            //----------------------------------------------------------------------
            // Init Series Valid Opening Shape Manufacturing if shape is bought out
            //----------------------------------------------------------------------
            SeriesValidOpeningShapeMfg seriesValidOpeningShapeMfg = ApplicationBaseRulesApp.getInstance().
                    getSeriesValidOpeningMfg(this.openingid, this.shapeID);

            if (seriesValidOpeningShapeMfg.getId() != null) {

                //Return parts Information
                Parts p = ApplicationBaseApp.getInstance().getPart(seriesValidOpeningShapeMfg.getId().getPartId());

                this.supplier_rule_no = -300;
                this.supplier_part_id = seriesValidOpeningShapeMfg.getId().getPartId();
                this.buy = !seriesValidOpeningShapeMfg.isMadeIn();
                this.glass_made_in = seriesValidOpeningShapeMfg.isGlassMadeIn();
                this.bought_glazed = seriesValidOpeningShapeMfg.isBoughtGlazed();

                this.track = p.isTracking();
                this.ships = p.isShips();
            }

            //----------------------------------------------------------------------
            // Load Shape Dimensions
            //----------------------------------------------------------------------
            this.radius1_shape = (int) (shape.radius1 / shape.myFrame2.metricscale.doubleValue());
            this.radius1_i_shape = (int) (shape.radius1 / shape.myFrame2.imperialscale.doubleValue());

            this.radius2_shape = (int) (shape.radius2 / shape.myFrame2.metricscale.doubleValue());
            this.radius2_i_shape = (int) (shape.radius2 / shape.myFrame2.imperialscale.doubleValue());

            this.minLeg = (int) (shape.minLeg / shape.myFrame2.metricscale.doubleValue());
            this.minLeg_i = (int) (shape.minLeg / shape.myFrame2.imperialscale.doubleValue());

            this.dimA0 = (int) (shape.dimA0 / shape.myFrame2.metricscale.doubleValue());
            this.dimA1 = (int) (shape.dimA1 / shape.myFrame2.metricscale.doubleValue());
            this.dimA2 = (int) (shape.dimA2 / shape.myFrame2.metricscale.doubleValue());
            this.dimA3 = (int) (shape.dimA3 / shape.myFrame2.metricscale.doubleValue());
            this.dimA4 = (int) (shape.dimA4 / shape.myFrame2.metricscale.doubleValue());
            this.dimA5 = (int) (shape.dimA5 / shape.myFrame2.metricscale.doubleValue());
            this.dimB0 = (int) (shape.dimB0 / shape.myFrame2.metricscale.doubleValue());
            this.dimB1 = (int) (shape.dimB1 / shape.myFrame2.metricscale.doubleValue());
            this.dimB2 = (int) (shape.dimB2 / shape.myFrame2.metricscale.doubleValue());
            this.dimB3 = (int) (shape.dimB3 / shape.myFrame2.metricscale.doubleValue());
            this.dimB4 = (int) (shape.dimB4 / shape.myFrame2.metricscale.doubleValue());
            this.dimB5 = (int) (shape.dimB5 / shape.myFrame2.metricscale.doubleValue());
            this.dimC0 = (int) (shape.dimC0 / shape.myFrame2.metricscale.doubleValue());
            this.dimC1 = (int) (shape.dimC1 / shape.myFrame2.metricscale.doubleValue());
            this.dimC2 = (int) (shape.dimC2 / shape.myFrame2.metricscale.doubleValue());
            this.dimC3 = (int) (shape.dimC3 / shape.myFrame2.metricscale.doubleValue());
            this.dimC4 = (int) (shape.dimC4 / shape.myFrame2.metricscale.doubleValue());
            this.dimC5 = (int) (shape.dimC5 / shape.myFrame2.metricscale.doubleValue());
            this.dimD0 = (int) (shape.dimD0 / shape.myFrame2.metricscale.doubleValue());
            this.dimD1 = (int) (shape.dimD1 / shape.myFrame2.metricscale.doubleValue());
            this.dimD2 = (int) (shape.dimD2 / shape.myFrame2.metricscale.doubleValue());
            this.dimD3 = (int) (shape.dimD3 / shape.myFrame2.metricscale.doubleValue());
            this.dimD4 = (int) (shape.dimD4 / shape.myFrame2.metricscale.doubleValue());
            this.dimD5 = (int) (shape.dimD5 / shape.myFrame2.metricscale.doubleValue());

            this.dimA0_i = (int) (shape.dimA0 / shape.myFrame2.imperialscale.doubleValue());
            this.dimA1_i = (int) (shape.dimA1 / shape.myFrame2.imperialscale.doubleValue());
            this.dimA2_i = (int) (shape.dimA2 / shape.myFrame2.imperialscale.doubleValue());
            this.dimA3_i = (int) (shape.dimA3 / shape.myFrame2.imperialscale.doubleValue());
            this.dimA4_i = (int) (shape.dimA4 / shape.myFrame2.imperialscale.doubleValue());
            this.dimA5_i = (int) (shape.dimA5 / shape.myFrame2.imperialscale.doubleValue());
            this.dimB0_i = (int) (shape.dimB0 / shape.myFrame2.imperialscale.doubleValue());
            this.dimB1_i = (int) (shape.dimB1 / shape.myFrame2.imperialscale.doubleValue());
            this.dimB2_i = (int) (shape.dimB2 / shape.myFrame2.imperialscale.doubleValue());
            this.dimB3_i = (int) (shape.dimB3 / shape.myFrame2.imperialscale.doubleValue());
            this.dimB4_i = (int) (shape.dimB4 / shape.myFrame2.imperialscale.doubleValue());
            this.dimB5_i = (int) (shape.dimB5 / shape.myFrame2.imperialscale.doubleValue());
            this.dimC0_i = (int) (shape.dimC0 / shape.myFrame2.imperialscale.doubleValue());
            this.dimC1_i = (int) (shape.dimC1 / shape.myFrame2.imperialscale.doubleValue());
            this.dimC2_i = (int) (shape.dimC2 / shape.myFrame2.imperialscale.doubleValue());
            this.dimC3_i = (int) (shape.dimC3 / shape.myFrame2.imperialscale.doubleValue());
            this.dimC4_i = (int) (shape.dimC4 / shape.myFrame2.imperialscale.doubleValue());
            this.dimC5_i = (int) (shape.dimC5 / shape.myFrame2.imperialscale.doubleValue());
            this.dimD0_i = (int) (shape.dimD0 / shape.myFrame2.imperialscale.doubleValue());
            this.dimD1_i = (int) (shape.dimD1 / shape.myFrame2.imperialscale.doubleValue());
            this.dimD2_i = (int) (shape.dimD2 / shape.myFrame2.imperialscale.doubleValue());
            this.dimD3_i = (int) (shape.dimD3 / shape.myFrame2.imperialscale.doubleValue());
            this.dimD4_i = (int) (shape.dimD4 / shape.myFrame2.imperialscale.doubleValue());
            this.dimD5_i = (int) (shape.dimD5 / shape.myFrame2.imperialscale.doubleValue());

            shape.supplierId = this.supplierRemoteId;
            shape.supplierSeriesId = this.supplierSeriesId;
            shape.remote = this.remote;

        } else if (myProfile != null) {

            this.openingid = myProfile.myParent.openingClass;
            this.shapeID = myProfile.myParent.shapeID;
            this.sash = myProfile.myParent.userDefinedOpeningID;

            this.gridID = myProfile.gridID;
            this.gridTypeID = myProfile.gridTypeID;

            this.startpos = myProfile.startPos;
            this.endpos = myProfile.endPos;

            if (myProfile.orientation == 1) {
                this.row = myProfile.rowCol;
                this.col = 0;
            } else {
                this.row = 0;
                this.col = myProfile.rowCol;
            }

            this.parentrow = 0;
            this.parentcol = 0;

            if (rule != null && shape != null) {

                this.prodline = rule.prodLine > 0 ? rule.prodLine : myProfile.myFrame2.executePartRules.setProdLine;
                this.station = rule.station > 0 ? rule.station : myProfile.myFrame2.executePartRules.setStation;
                this.report = rule.report > 0 ? rule.report : myProfile.myFrame2.executePartRules.setReport;
                this.delivery = rule.stage > 0 ? rule.stage : myProfile.myFrame2.executePartRules.setDelivery;
                this.assemblyid = rule.assembly > 0 ? rule.assembly : myProfile.myFrame2.executePartRules.setAssembly;
                this.processId = rule.process > 0 ? rule.process : myProfile.myFrame2.executePartRules.setProcess;
                this.parentAssembly = rule.parentAssembly > 0 ? rule.parentAssembly : myProfile.myFrame2.executePartRules.setParentAssembly;
                this.glazed = rule.glazed;

                if (rule.assemblyid == 7 && myProfile.myFrame2.executePartRules.forcedAssembly > 0) {
                    this.assemblyid = myProfile.myFrame2.executePartRules.forcedAssembly;
                }

            } else {

                this.prodline = myProfile.myFrame2.executePartRules.setProdLine;
                this.station = myProfile.myFrame2.executePartRules.setStation;
                this.report = myProfile.myFrame2.executePartRules.setReport;
                this.delivery = myProfile.myFrame2.executePartRules.setDelivery;
                this.assemblyid = myProfile.myFrame2.executePartRules.setAssembly;
                this.processId = myProfile.myFrame2.executePartRules.setProcess;
                this.parentAssembly = myProfile.myFrame2.executePartRules.setParentAssembly;
                this.glazed = true;

                if (rule.assemblyid == 7 && myProfile.myFrame2.executePartRules.forcedAssembly > 0) {
                    this.assemblyid = myProfile.myFrame2.executePartRules.forcedAssembly;
                }
            }

//            prodline = rule.prodLine > 0 ? rule.prodLine : myProfile.myFrame2.executePartRules.setProdLine;
//            station = rule.station > 0 ? rule.station : myProfile.myFrame2.executePartRules.setStation;
//            report = rule.report > 0 ? rule.report : myProfile.myFrame2.executePartRules.setReport;
//            delivery = rule.stage > 0 ? rule.stage : myProfile.myFrame2.executePartRules.setDelivery;
//            assemblyid = rule.assembly > 0 ? rule.assembly : myProfile.myFrame2.executePartRules.setAssembly;
//            processId = rule.process > 0 ? rule.process : myProfile.myFrame2.executePartRules.setProcess;

            this.parentbomid = myProfile.myFrame2.executePartRules.setParentAssembly;

            this.reqforstage = myProfile.myFrame2.executePartRules.setStage;
            this.sysAssemblyId = myProfile.a_assemblyLevel;
            this.processId = myProfile.myFrame2.executePartRules.setProcess;

            if (part.getParttype() == 2 || part.getParttype() == 15 || part.getParttype() == 4) {
                setBomFromProfileLength(profile, part, shape, myProfile, cart, addOn, rule, quantity, adjw, adjwi, adjh, adjhi,
                        myProfile.myFrame2.metricscale, myProfile.myFrame2.imperialscale);
            }

            myProfile.supplierId = this.supplierRemoteId;
            myProfile.remote = this.remote;

        } else if (cart != null) {

            this.openingid = 0;
            this.shapeID = 0;
            this.sash = 0;
            this.row = 1;
            this.col = 1;
            this.parentrow = 1;
            this.parentcol = 1;
            this.prodline = 0;
            this.station = 0;
            this.report = 0;
            this.delivery = 0;
            this.assemblyid = 0;
            this.reqforstage = 0;
            this.sysAssemblyId = 0;
        }

        this.partFamily = part.getPartfamily();
        this.priceGroup = part.getPricegroup();

        PricingGroup pg = ItemFrame.getApplicationBase().getPricingGroup(part.getPricegroup());
        this.priceCat = ItemFrame.getApplicationBase().getTypePriceCategory(pg.getPriceCategory()).getId();

        return this;
    }

    /**
     * Set BOM From Profile Length
     *
     * @param profile,     Profiles
     * @param part,        Parts
     * @param shape,       ShapeObject
     * @param myProfile,   Profiles
     * @param cart,        OrderItemsCart
     * @param addOn,       boolean
     * @param rule,        Rules
     * @param quantity,    double
     * @param adjw,        int
     * @param adjwi,       int
     * @param adjh,        int
     * @param adjhi,       int
     * @param metricscale, BigDecimal
     * @param impscale,    BigDecimal
     * @return BillOfMat
     */
    private BillOfMat setBomFromProfileLength(Profiles profile, Parts part, ShapeObject shape, Profiles myProfile,
                                              OrderItemsCart cart, boolean addOn, Rules rule, double quantity, int adjw,
                                              int adjwi, int adjh, int adjhi, BigDecimal metricscale, BigDecimal impscale) {


        if (profile != null) {
            if (rule != null && !rule.isNominal()) {
                cutlength = profile.lengthM;
            } else {
                cutlength = profile.lengthMN;
            }
            if (rule == null) {
                cutlength = profile.lengthM;
            }
        }


        if (rule != null && rule.getWeldedl() && profile.startAngle == 45) {
            cutlength = cutlength + part.getWeldallowance();
        } else if (rule != null && rule.getWeldedl() && profile.startAngle != 45) {
            cutlength = cutlength + part.getWeldallowanceother();
        }

        if (rule != null && rule.getWeldedr() && profile.startAngle == 45) {
            cutlength = cutlength + part.getWeldallowance();
        } else if (rule != null && rule.getWeldedr() && profile.startAngle != 45) {
            cutlength = cutlength + part.getWeldallowanceother();
        }


        cutlength = cutlength + adjw;

        if (profile != null) {
            if (rule != null && !rule.isNominal()) {
                cutlengthi = profile.lengthI;
            } else {
                cutlengthi = profile.lengthIN;
            }
            if (rule == null) {
                cutlengthi = profile.lengthI;
            }
        }


        if (rule != null && rule.getWeldedl() && profile.startAngle == 45) {
            cutlengthi = cutlengthi + part.getWeldallowacei();
        } else if (rule != null && rule.getWeldedl() && profile.startAngle != 45) {
            cutlengthi = cutlengthi + part.getWeldallowanceotheri();
        }


        if (rule != null && rule.getWeldedr() && profile.startAngle == 45) {
            cutlengthi = cutlengthi + part.getWeldallowacei();
        } else if (rule != null && rule.getWeldedr() && profile.startAngle != 45) {
            cutlengthi = cutlengthi + part.getWeldallowanceotheri();
        }

        cutlengthi = cutlengthi + adjwi;

        if (shape != null) {
            if (rule != null && rule.getPosition() == 12) {
                cutlength = shape.widthM + adjw + shape.heightM + adjh;
                cutlengthi = shape.widthI + adjwi + shape.heightI + adjhi;
            }

            if (rule != null && rule.getPosition() == 7 && (part.getParttype() == 4 || part.getParttype() == 18)) {
                cutlength = (2 * shape.widthM + adjw) + (2 * shape.heightM + adjh);
                cutlengthi = (2 * shape.widthI + adjwi) + (2 * shape.heightI + adjhi);
            }
        }

        if (profile != null) {
            partSequence = profile.seq;
            leftIn = profile.leftIn;
            rightIn = profile.rightIn;
            notchLT = profile.notchLT;
            notchRB = profile.notchRB;
            notchLTi = profile.notchLTi;
            notchRBi = profile.notchRBi;
        }

        width = 0;
        widthi = 0;
        height = 0;
        heighti = 0;

        if (profile != null) {
            radius1 = (int) (profile.radius1 / metricscale.doubleValue());
            radius1i = (int) (profile.radius1 / impscale.doubleValue());
            radius2 = (int) (profile.radius2 / metricscale.doubleValue());
            radius2i = (int) (profile.radius2 / impscale.doubleValue());
        }

        if (radius1 < 0) {
            radius1 = 0;
        }
        if (radius2 < 0) {
            radius2 = 0;
        }
        if (radius1i < 0) {
            radius1i = 0;
        }
        if (radius2i < 0) {
            radius2i = 0;
        }

        if (profile != null) {
            leftangle = profile.ltAngle;
            rightangle = profile.rbAngle;
        }

        cutlengthuser = cutlength;
        cutlengthiuser = cutlengthi;

        widthuser = width;
        widthiuser = widthi;
        heightuser = height;
        heightiuser = heighti;

        depth = depth;
        depthi = depthi;
        depthuser = depth;
        depthiuser = depthi;

        area = width / 100000 * height / 100000;
        areai = widthi / 64d / 12 * heighti / 64d / 12;

        areauser = area;
        areaiuser = areai;

        volume = width / 100000 * height / 100000 * depth / 100000;
        volumei = widthi / 64d / 12 * heighti / 64d / 12 * depthi / 64d / 12;

        volumeuser = volume;
        volumeiuser = volumei;

        if (profile != null) {
            leftcut = profile.endTypeLT;
            rightcut = profile.endTypeRB;
        }

        if (profile != null && profile.endTypeLT == 1) {
            if (leftangle == Math.abs(45)) {
                weld = part.getWeldallowance();
                weldi = part.getWeldallowacei();
            } else {
                weld = part.getWeldallowanceother();

                weldi = part.getWeldallowanceotheri();
            }
        }

        if (profile != null && profile.endTypeRB == 1) {
            if (rightangle == Math.abs(45)) {
                weldR = part.getWeldallowance();
                weldRi = part.getWeldallowacei();
            } else {
                weldR = part.getWeldallowanceother();

                weldRi = part.getWeldallowanceotheri();
            }
        }

        if (profile != null ) {
            setProfileNotchesValues(profile);
        }

        return this;
    }

    private BillOfMat setBomFromArea(Profiles profile, Parts part, ShapeObject shape, Profiles myProfile, OrderItemsCart cart,
                                     boolean addOn, Rules rule, double quantity, int adjw, int adjwi, int adjh, int adjhi,
                                     BigDecimal metricscale, BigDecimal impscale) {

        cutlengthi = cutlength = 0;

        if (shape != null) {
            if (rule != null && rule.isNominal()) {
                width = shape.widthMN;
                widthi = shape.widthIN;
                height = shape.heightMN;
                heighti = shape.heightIN;
            } else {
                width = shape.widthM;
                widthi = shape.widthI;
                height = shape.heightM;
                heighti = shape.heightI;
            }

            radius1 = (int) (shape.radius1 * metricscale.doubleValue());
            radius1i = (int) (shape.radius1 * impscale.doubleValue());
            radius2 = (int) (shape.radius2 * metricscale.doubleValue());
            radius2i = (int) (shape.radius2 * impscale.doubleValue());

        } else {

            width = cart.width;
            widthi = cart.widthI;
            height = cart.height;
            heighti = cart.heightI;

            radius1 = (int) (cart.radius1 * metricscale.doubleValue());
            radius1i = (int) (cart.radius1 * impscale.doubleValue());
            radius2 = (int) (cart.radius2 * metricscale.doubleValue());
            radius2i = (int) (cart.radius2 * impscale.doubleValue());
        }

        leftangle = 0;
        rightangle = 0;

        cutlengthuser = cutlength;
        cutlengthiuser = cutlengthi;

        widthuser = width;
        widthiuser = widthi;
        heightuser = height;
        heightiuser = heighti;

        depth = depth;
        depthi = depthi;

        depthuser = depth;
        depthiuser = depthi;

        area = width / 100000 * height / 100000;
        areai = widthi / 64d / 12 * heighti / 64d / 12;

        areauser = area;
        areaiuser = areai;

        volume = width / 100000 * height / 100000 * depth / 100000;
        volumei = widthi / 64d / 12 * heighti / 64d / 12 * depthi / 64d / 12;

        volumeuser = volume;
        volumeiuser = volumei;

        weld = 0;
        weldi = 0;

        return this;
    }

    private BillOfMat setBomFromVolume(Profiles profile, Parts part, ShapeObject shape, Profiles myProfile, OrderItemsCart cart,
                                       boolean addOn, Rules rule, double quantity, int adjw, int adjwi, int adjh, int adjhi,
                                       BigDecimal metricscale, BigDecimal impscale) {

        cutlengthi = cutlength = 0;

        width = cart.width;
        widthi = cart.widthI;
        height = cart.height;
        heighti = cart.heightI;

        depth = cart.depth;
        depthi = cart.depthI;

        radius1 = 0;
        radius1i = 0;
        radius2 = 0;
        radius2i = 0;

        leftangle = 0;
        rightangle = 0;

        cutlengthuser = cutlength;
        cutlengthiuser = cutlengthi;

        widthuser = width;
        widthiuser = widthi;

        heightuser = height;
        heightiuser = heighti;

        depthuser = depth;
        depthiuser = depthi;

        area = width / 100000 * height / 100000;
        areai = widthi / 64d / 12 * heighti / 64d / 12;

        areauser = area;
        areaiuser = areai;

        volume = width / 100000 * height / 100000 * depth / 100000;
        volumei = widthi / 64d / 12 * heighti / 64d / 12 * depthi / 64d / 12;

        volumeuser = volume;
        volumeiuser = volumei;

        weld = 0;
        weldi = 0;

        return this;
    }

    /**
     * Set Profile Notches Values
     *
     * @param profile, Profiles
     * @return BillOfMat
     */
    private void setProfileNotchesValues(Profiles profile) {

        try {

            //Notches Collection Values
            this.notchesM = new ArrayList<String>();
            this.notchesI = new ArrayList<String>();
            this.notchesIY = new ArrayList<String>();

            for (Object object : profile.notches) {

                PartsNotching notching = (PartsNotching) object;

                if (profile.partForm == 1) {

                    double midX = 0;
                    double midY = 0;

                    double maxX = Math.max(notching.x1, Math.max(notching.x2, Math.max(notching.x3, Math.max(notching.x5, Math.max(notching.x6, notching.x7)))));
                    double maxY = Math.max(notching.y1, Math.max(notching.y2, Math.max(notching.y3, Math.max(notching.y5, Math.max(notching.y6, notching.y7)))));
                    double minX = Math.min(notching.x1, Math.min(notching.x2, Math.min(notching.x3, Math.min(notching.x5, Math.min(notching.x6, notching.x7)))));
                    double minY = Math.min(notching.y1, Math.min(notching.y2, Math.min(notching.y3, Math.min(notching.y5, Math.min(notching.y6, notching.y7)))));

                    if (profile.orientation == 1) {
                        midX = (maxX + minX) / 2;
                        midY = (maxY + minY) / 2;
                    } else {
                        midX = (maxX + minX) / 2;
                        midY = (maxY + minY) / 2;
                    }

                    //Calculate Length Value
                    double length = Math.sqrt(Math.pow((Math.max(midX, profile.x2) - Math.min(midX, profile.x2)), 2) +
                            Math.pow((Math.max(midY, profile.y1) - Math.min(midY, profile.y1)), 2));

                    //Calculate Length Metric & Imperial Value
                    int lengthM = new BigDecimal(length + "").divide(profile.myFrame2.metricscale, 1, BigDecimal.ROUND_HALF_EVEN).intValue();
                    int lengthI = new BigDecimal(length + "").divide(profile.myFrame2.imperialscale, 1, BigDecimal.ROUND_HALF_EVEN).intValue();

                    //Adding notches Metric
                    notchesM.add(new BigDecimal(lengthM).divide(new BigDecimal("100"), 6, BigDecimal.ROUND_HALF_EVEN).
                            toString());

                    //Adding notches Imperial
                    notchesI.add(new BigDecimal(lengthI).divide(new BigDecimal("64"), 6, BigDecimal.ROUND_HALF_EVEN).
                            toString());

                    //Adding notches Imperial Fraction
                    notchesIY.add(UOMUtility.imperialToFraction(new BigDecimal(lengthI).
                            divide(new BigDecimal("64"), 6, BigDecimal.ROUND_HALF_EVEN).toString()));

                }
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * This method compare parent assembly levels from startup level
     *
     * @param startup,        Startup level comparison
     * @param parentAssembly, BillOfMaterial comparison level
     * @return boolean indicate that is equals or not
     */
    private boolean compareParentAssemblyLevels(int startup, BillOfMat parentAssembly) throws IllegalAccessException {

        Map<Integer, LevelSequence> levelsChild = new HashMap<Integer, LevelSequence>();
        Map<Integer, LevelSequence> levelsParent = new HashMap<Integer, LevelSequence>();

        int startLevel = 1;
        int position = 1;

        //**************************************************************************
        //Preparing fields for childs assemblies
        //**************************************************************************
        Field[] childFields = this.getClass().getFields();

        for (Field level : childFields) {

            String levelName = level.getName();

            if (levelName.equals("a_" + startLevel + "Level")) {

                for (Field sequence : childFields) {

                    String sequenceName = sequence.getName();

                    if (sequenceName.equals("a_" + startLevel + "Sequence")) {
                        Integer levelID = level.getInt(this);
                        Integer sequenceID = sequence.getInt(this);

                        if (levelID > 0 && sequenceID > 0) {
                            LevelSequence childSequence = new LevelSequence(level.getInt(this), sequence.getInt(this));
                            levelsChild.put(position, childSequence);

                            position++;
                        }
                    }
                }

                startLevel++;
            }
        }

        //************************************************************************
        //Preparing fields for parent assemblies
        //************************************************************************
        startLevel = 1;
        position = 1;

        Field[] parentFields = parentAssembly.getClass().getFields();

        for (Field level : parentFields) {

            String levelName = level.getName();

//            if (levelName.equals("a_levelID")) {
//
//                for (Field sequence : parentFields) {
//                    String sequenceName = sequence.getName();
//
//                    if (sequenceName.equals("a_sequenceID")) {
//                        Integer levelID = level.getInt(parentAssembly);
//                        Integer sequenceID = sequence.getInt(parentAssembly);
//
//                        if (levelID > 0 && sequenceID > 0) {
//                            LevelSequence parentSequence = new LevelSequence(levelID, sequenceID);
//                            levelsParent.put(position, parentSequence);
//
//                            position++;
//                        }
//                    }
//                }
//            }

            if (levelName.equals("a_" + startLevel + "Level")) {

                for (Field sequence : parentFields) {
                    String sequenceName = sequence.getName();

                    if (sequenceName.equals("a_" + startLevel + "Sequence")) {
                        Integer levelID = level.getInt(parentAssembly);
                        Integer sequenceID = sequence.getInt(parentAssembly);

                        if (levelID > 0 && sequenceID > 0) {
                            LevelSequence parentSequence = new LevelSequence(levelID, sequenceID);
                            levelsParent.put(position, parentSequence);

                            position++;
                        }
                    }
                }

                startLevel++;
            }
        }

        //************************************************************************
        //Compare levels for child and Parent
        //************************************************************************
        boolean _level_sequence_equals = true;

        int i = 0;
        int _level_value = 1;

        //Init Startup level
        startup = levelsChild.size() - levelsParent.size();

        for (Map.Entry<Integer, LevelSequence> entry : levelsChild.entrySet()) {

            //Init Entry Value
            LevelSequence childSequence = entry.getValue();

            if (i >= startup) {

                //Get Parent Level Sequence
                LevelSequence parentSequence = levelsParent.get(_level_value);

                if (childSequence.levelID != parentSequence.levelID ||
                        childSequence.sequenceID != parentSequence.sequenceID) {
                    _level_sequence_equals = false;
                }

                _level_value++;
            }

            i++;
        }

        return _level_sequence_equals;
    }

    /**
     * Setting Shape Map Identifiers
     *
     * @param shape,     ShapeObject
     * @param myProfile, Profiles
     * @param cart,      OrderItemsCart
     */
    public void setShapeIdentifires(ShapeObject shape, Profiles myProfile, OrderItemsCart cart) {

        if (shape != null && myProfile == null) {
            this.a_assemblyLevel = shape.a_assemblyLevel;
            this.a_levelID = shape.a_levelID;
            this.a_sequenceID = shape.a_sequenceID;
            this.a_1Level = shape.a_1Level;
            this.a_1Sequence = shape.a_1Sequence;
            this.a_2Level = shape.a_2Level;
            this.a_2Sequence = shape.a_2Sequence;
            this.a_3Level = shape.a_3Level;
            this.a_3Sequence = shape.a_3Sequence;
            this.a_4Level = shape.a_4Level;
            this.a_4Sequence = shape.a_4Sequence;
            this.a_5Level = shape.a_5Level;
            this.a_5Sequence = shape.a_5Sequence;
            this.a_6Level = shape.a_6Level;
            this.a_6Sequence = shape.a_6Sequence;
            this.a_7Level = shape.a_7Level;
            this.a_7Sequence = shape.a_7Sequence;
            this.a_8Level = shape.a_8Level;
            this.a_8Sequence = shape.a_8Sequence;
            this.a_9Level = shape.a_9Level;
            this.a_9Sequence = shape.a_9Sequence;
            this.a_10Level = shape.a_10Level;
            this.a_10Sequence = shape.a_10Sequence;
            this.a_11Level = shape.a_11Level;
            this.a_11Sequence = shape.a_11Sequence;
            this.a_12Level = shape.a_12Level;
            this.a_12Sequence = shape.a_12Sequence;
            this.a_13Level = shape.a_13Level;
            this.a_13Sequence = shape.a_13Sequence;
            this.a_14Level = shape.a_14Level;
            this.a_14Sequence = shape.a_14Sequence;
            this.a_15Level = shape.a_15Level;
            this.a_15Sequence = shape.a_15Sequence;
            this.a_16Level = shape.a_16Level;
            this.a_16Sequence = shape.a_16Sequence;
            this.a_17Level = shape.a_17Level;
            this.a_17Sequence = shape.a_17Sequence;
            this.a_18Level = shape.a_18Level;
            this.a_18Sequence = shape.a_18Sequence;
            this.a_19Level = shape.a_19Level;
            this.a_19Sequence = shape.a_19Sequence;
            this.a_20Level = shape.a_20Level;
            this.a_20Sequence = shape.a_20Sequence;
            this.a_21Level = shape.a_21Level;
            this.a_21Sequence = shape.a_21Sequence;
            this.a_22Level = shape.a_22Level;
            this.a_22Sequence = shape.a_22Sequence;

            //Setting ShapeObject relationship
            shapeObject = shape;

        } else if (myProfile != null) {

            this.a_assemblyLevel = myProfile.a_assemblyLevel;
            this.a_levelID = myProfile.a_levelID;
            this.a_sequenceID = myProfile.rowCol;
            this.orientation = myProfile.orientation;
            this.a_1Level = myProfile.a_1Level;
            this.a_1Sequence = myProfile.a_1Sequence;
            this.a_2Level = myProfile.a_2Level;
            this.a_2Sequence = myProfile.a_2Sequence;
            this.a_3Level = myProfile.a_3Level;
            this.a_3Sequence = myProfile.a_3Sequence;
            this.a_4Level = myProfile.a_4Level;
            this.a_4Sequence = myProfile.a_4Sequence;
            this.a_5Level = myProfile.a_5Level;
            this.a_5Sequence = myProfile.a_5Sequence;
            this.a_6Level = myProfile.a_6Level;
            this.a_6Sequence = myProfile.a_6Sequence;
            this.a_7Level = myProfile.a_7Level;
            this.a_7Sequence = myProfile.a_7Sequence;
            this.a_8Level = myProfile.a_8Level;
            this.a_8Sequence = myProfile.a_8Sequence;
            this.a_9Level = myProfile.a_9Level;
            this.a_9Sequence = myProfile.a_9Sequence;
            this.a_10Level = myProfile.a_10Level;
            this.a_10Sequence = myProfile.a_10Sequence;
            this.a_levelID = myProfile.levelID;
            this.a_11Level = myProfile.a_11Level;
            this.a_11Sequence = myProfile.a_11Sequence;
            this.a_12Level = myProfile.a_12Level;
            this.a_12Sequence = myProfile.a_12Sequence;
            this.a_13Level = myProfile.a_13Level;
            this.a_13Sequence = myProfile.a_13Sequence;
            this.a_14Level = myProfile.a_14Level;
            this.a_14Sequence = myProfile.a_14Sequence;
            this.a_15Level = myProfile.a_15Level;
            this.a_15Sequence = myProfile.a_15Sequence;
            this.a_16Level = myProfile.a_16Level;
            this.a_16Sequence = myProfile.a_16Sequence;
            this.a_17Level = myProfile.a_17Level;
            this.a_17Sequence = myProfile.a_17Sequence;
            this.a_18Level = myProfile.a_18Level;
            this.a_18Sequence = myProfile.a_18Sequence;
            this.a_19Level = myProfile.a_19Level;
            this.a_19Sequence = myProfile.a_19Sequence;
            this.a_20Level = myProfile.a_20Level;
            this.a_20Sequence = myProfile.a_20Sequence;
            this.a_21Level = myProfile.a_21Level;
            this.a_21Sequence = myProfile.a_21Sequence;
            this.a_22Level = myProfile.a_22Level;
            this.a_22Sequence = myProfile.a_22Sequence;

            this.profiles = myProfile;
        }
    }

    public String replaceStockCodeWithWildCard(String stockCode) {

        if (stockCode.startsWith("@")) {
            stockCode = this.execRules.setWild1T + stockCode.substring(1, stockCode.length());
            isWild1 = true;
        } else if (stockCode.indexOf("@") > 0) {
            stockCode = stockCode.substring(0, stockCode.indexOf("@")) + this.execRules.setWild1T
                    + stockCode.substring(stockCode.indexOf("@") + 1, stockCode.length());
            isWild1 = true;
        }

        if (stockCode.startsWith("*")) {
            stockCode = this.execRules.setWild2T + stockCode.substring(1, stockCode.length());
            isWild2 = true;
        } else if (stockCode.indexOf("*") > 0) {
            stockCode = stockCode.substring(0, stockCode.indexOf("*")) + this.execRules.setWild2T
                    + stockCode.substring(stockCode.indexOf("*") + 1, stockCode.length());
            isWild2 = true;
        }

        if (stockCode.startsWith("^")) {
            stockCode = this.execRules.setWild3T + stockCode.substring(1, stockCode.length());
            isWild3 = true;
        } else if (stockCode.indexOf("^") > 0) {
            stockCode = stockCode.substring(0, stockCode.indexOf("^")) + this.execRules.setWild3T
                    + stockCode.substring(stockCode.indexOf("^") + 1, stockCode.length());
            isWild3 = true;
        }

        if (stockCode.startsWith("~")) {
            stockCode = this.execRules.setWild4T + stockCode.substring(1, stockCode.length());
            isWild4 = true;
        } else if (stockCode.indexOf("~") > 0) {
            stockCode = stockCode.substring(0, stockCode.indexOf("~")) + this.execRules.setWild4T
                    + stockCode.substring(stockCode.indexOf("~") + 1, stockCode.length());
            isWild4 = true;
        }

        if (stockCode.startsWith("!")) {
            stockCode = this.execRules.setWild5T + stockCode.substring(1, stockCode.length());
            isWild5 = true;
        } else if (stockCode.indexOf("!") > 0) {
            stockCode = stockCode.substring(0, stockCode.indexOf("!")) + this.execRules.setWild5T
                    + stockCode.substring(stockCode.indexOf("!") + 1, stockCode.length());
            isWild5 = true;
        }

        if (stockCode.startsWith("#")) {
            stockCode = this.execRules.setWild6T + stockCode.substring(1, stockCode.length());
            isWild6 = true;
        } else if (stockCode.indexOf("#") > 0) {
            stockCode = stockCode.substring(0, stockCode.indexOf("#")) + this.execRules.setWild6T
                    + stockCode.substring(stockCode.indexOf("#") + 1, stockCode.length());
            isWild6 = true;
        }

        return stockCode;
    }

    public boolean isMatchingPart(Profiles part) {

        boolean match = false;
        int partPosition = 0;

        if (this.a_assemblyLevel > 30 && this.a_assemblyLevel < 40) {
            partPosition = 10 + part.cOrM;

            if (part.a_assemblyLevel == this.a_assemblyLevel && part.a_1Level == a_1Level && part.a_2Level == a_2Level
                    && part.a_3Level == a_3Level && part.a_4Level == a_4Level && part.a_5Level == a_5Level
                    && part.a_6Level == a_6Level && part.a_7Level == a_7Level && part.a_8Level == a_8Level
                    && part.a_9Level == a_9Level && part.a_10Level == a_10Level && part.a_11Level == a_11Level
                    && part.a_12Level == a_12Level && part.a_13Level == a_13Level && part.a_14Level == a_14Level
                    && part.a_15Level == a_15Level && part.a_16Level == a_16Level && part.a_17Level == a_17Level
                    && part.a_18Level == a_18Level && part.a_19Level == a_19Level && part.a_20Level == a_20Level
                    && part.a_21Level == a_21Level && part.a_22Level == a_22Level
                    && part.a_sequenceID == this.a_sequenceID && part.a_1Sequence == a_1Sequence
                    && part.a_2Sequence == a_2Sequence && part.a_3Sequence == a_3Sequence
                    && part.a_4Sequence == a_4Sequence && part.a_5Sequence == a_5Sequence
                    && part.a_6Sequence == a_6Sequence && part.a_7Sequence == a_7Sequence
                    && part.a_8Sequence == a_8Sequence && part.a_9Sequence == a_9Sequence
                    && part.a_10Sequence == a_10Sequence && part.a_11Sequence == a_11Sequence
                    && part.a_12Sequence == a_12Sequence && part.a_13Sequence == a_13Sequence
                    && part.a_14Sequence == a_14Sequence && part.a_15Sequence == a_15Sequence
                    && part.a_16Sequence == a_16Sequence && part.a_17Sequence == a_17Sequence
                    && part.a_18Sequence == a_18Sequence && part.a_19Sequence == a_19Sequence
                    && part.a_20Sequence == a_20Sequence && part.a_21Sequence == a_21Sequence
                    && part.a_22Sequence == a_22Sequence && this.position == partPosition
                    && this.orientation == part.orientation) {

                match = true;

            }
        } else if (part.cOrM != 7) {

            if (part.a_assemblyLevel == this.a_assemblyLevel && part.a_1Level == a_1Level
                    && part.a_2Level == a_2Level && part.a_3Level == a_3Level && part.a_4Level == a_4Level
                    && part.a_5Level == a_5Level && part.a_6Level == a_6Level && part.a_7Level == a_7Level
                    && part.a_8Level == a_8Level && part.a_9Level == a_9Level && part.a_10Level == a_10Level
                    && part.a_11Level == a_11Level && part.a_12Level == a_12Level && part.a_13Level == a_13Level
                    && part.a_14Level == a_14Level && part.a_15Level == a_15Level && part.a_16Level == a_16Level
                    && part.a_17Level == a_17Level && part.a_18Level == a_18Level && part.a_19Level == a_19Level
                    && part.a_20Level == a_20Level
                    && part.a_21Level == a_21Level && part.a_22Level == a_22Level && part.a_sequenceID == this.a_sequenceID
                    && part.a_1Sequence == a_1Sequence && part.a_2Sequence == a_2Sequence && part.a_3Sequence == a_3Sequence
                    && part.a_4Sequence == a_4Sequence && part.a_5Sequence == a_5Sequence && part.a_6Sequence == a_6Sequence
                    && part.a_7Sequence == a_7Sequence && part.a_8Sequence == a_8Sequence && part.a_9Sequence == a_9Sequence
                    && part.a_10Sequence == a_10Sequence && part.a_11Sequence == a_11Sequence
                    && part.a_12Sequence == a_12Sequence && part.a_13Sequence == a_13Sequence
                    && part.a_14Sequence == a_14Sequence && part.a_15Sequence == a_15Sequence
                    && part.a_16Sequence == a_16Sequence && part.a_17Sequence == a_17Sequence
                    && part.a_18Sequence == a_18Sequence && part.a_19Sequence == a_19Sequence
                    && part.a_20Sequence == a_20Sequence && part.a_21Sequence == a_21Sequence
                    && part.a_22Sequence == a_22Sequence) {

                match = true;

            }

        } else if (part.cOrM == 7) {

            if (part.a_assemblyLevel == this.a_assemblyLevel && part.a_1Level == a_1Level && part.a_2Level == a_2Level
                    && part.a_3Level == a_3Level && part.a_4Level == a_4Level && part.a_5Level == a_5Level
                    && part.a_6Level == a_6Level && part.a_7Level == a_7Level && part.a_8Level == a_8Level
                    && part.a_9Level == a_9Level && part.a_10Level == a_10Level && part.a_11Level == a_11Level
                    && part.a_12Level == a_12Level && part.a_13Level == a_13Level && part.a_14Level == a_14Level
                    && part.a_15Level == a_15Level && part.a_16Level == a_16Level && part.a_17Level == a_17Level
                    && part.a_18Level == a_18Level && part.a_19Level == a_19Level && part.a_20Level == a_20Level
                    && part.a_21Level == a_21Level && part.a_22Level == a_22Level
                    && part.a_sequenceID == this.a_sequenceID && part.a_1Sequence == a_1Sequence
                    && part.a_2Sequence == a_2Sequence && part.a_3Sequence == a_3Sequence
                    && part.a_4Sequence == a_4Sequence && part.a_5Sequence == a_5Sequence
                    && part.a_6Sequence == a_6Sequence && part.a_7Sequence == a_7Sequence
                    && part.a_8Sequence == a_8Sequence && part.a_9Sequence == a_9Sequence
                    && part.a_10Sequence == a_10Sequence && part.a_11Sequence == a_11Sequence
                    && part.a_12Sequence == a_12Sequence && part.a_13Sequence == a_13Sequence
                    && part.a_14Sequence == a_14Sequence && part.a_15Sequence == a_15Sequence
                    && part.a_16Sequence == a_16Sequence && part.a_17Sequence == a_17Sequence
                    && part.a_18Sequence == a_18Sequence && part.a_19Sequence == a_19Sequence
                    && part.a_20Sequence == a_20Sequence && part.a_21Sequence == a_21Sequence
                    && part.a_22Sequence == a_22Sequence && part.orientation == orientation
                    && part.posCondition == position) {

                match = true;

            }

        }

        return match;
    }

    public boolean isForShape(ShapeObject shape) {

        boolean match = false;

        if (shape.a_assemblyLevel == this.a_assemblyLevel && shape.a_1Level == a_1Level && shape.a_2Level == a_2Level
                && shape.a_3Level == a_3Level && shape.a_4Level == a_4Level && shape.a_5Level == a_5Level
                && shape.a_6Level == a_6Level && shape.a_7Level == a_7Level && shape.a_8Level == a_8Level
                && shape.a_9Level == a_9Level && shape.a_10Level == a_10Level && shape.a_11Level == a_11Level
                && shape.a_12Level == a_12Level && shape.a_13Level == a_13Level && shape.a_14Level == a_14Level
                && shape.a_15Level == a_15Level && shape.a_16Level == a_16Level && shape.a_17Level == a_17Level
                && shape.a_18Level == a_18Level && shape.a_19Level == a_19Level && shape.a_20Level == a_20Level
                && shape.a_21Level == a_21Level && shape.a_22Level == a_22Level
                && shape.a_sequenceID == this.a_sequenceID && shape.a_1Sequence == a_1Sequence
                && shape.a_2Sequence == a_2Sequence && shape.a_3Sequence == a_3Sequence
                && shape.a_4Sequence == a_4Sequence && shape.a_5Sequence == a_5Sequence
                && shape.a_6Sequence == a_6Sequence && shape.a_7Sequence == a_7Sequence
                && shape.a_8Sequence == a_8Sequence && shape.a_9Sequence == a_9Sequence
                && shape.a_10Sequence == a_10Sequence && shape.a_11Sequence == a_11Sequence
                && shape.a_12Sequence == a_12Sequence && shape.a_13Sequence == a_13Sequence
                && shape.a_14Sequence == a_14Sequence && shape.a_15Sequence == a_15Sequence
                && shape.a_16Sequence == a_16Sequence && shape.a_17Sequence == a_17Sequence
                && shape.a_18Sequence == a_18Sequence && shape.a_19Sequence == a_19Sequence
                && shape.a_20Sequence == a_20Sequence && shape.a_21Sequence == a_21Sequence
                && shape.a_22Sequence == a_22Sequence) {

            match = true;

        }
        return match;
    }

    /**
     * Reset Price And Cost to ZERO
     */
    public void resetPriceAndCost() {
        this.cost = new BigDecimal("0");
        this.price = new BigDecimal("0");
        this.totalprice = new BigDecimal("0");
        this.totalcost = new BigDecimal("0");
        this.priceuser = new BigDecimal("0");
        this.totalpriceuser = new BigDecimal("0");
    }

    /**
     * This method evaluate if this Bill of Material is a child from parent search BillOfMaterial
     *
     * @param parent, BillOfMat
     * @return boolean
     * @throws IllegalAccessException, Exception
     */
    public boolean isChild(BillOfMat parent) throws IllegalAccessException {

        boolean isChild = false;

        if (this.equals(parent)) {
            return true;
        }

        //Evaluate if bom & assembly bill of materials are for glass line production
        ProductionLine childProdLine = null;
        if (this.remote) {
            childProdLine = ItemFrame.getApplicationRemoteBaseRules().getProductionLine(this.supplierRemoteId,
                    this.prodline);
        } else {
            childProdLine = ApplicationMainBaseApp.getInstance().getProductionLine(this.prodline);
        }

        ProductionLine parentProdLine = null;
        if (parent.remote) {
            parentProdLine = ItemFrame.getApplicationRemoteBaseRules().getProductionLine(parent.supplierRemoteId,
                    parent.prodline);
        } else {
            parentProdLine = ApplicationMainBaseApp.getInstance().getProductionLine(parent.prodline);
        }

        if (childProdLine != null && parentProdLine != null && childProdLine.getGlassLine() && parentProdLine.getGlassLine()) {
            return isChild;
        }

        //----------------------------------------------------------------------------
        //Iterate Child Levels to try to find Level and Sequence of the parent
        //----------------------------------------------------------------------------
        if ((this.assemblyid == parent.assemblyid) && this.parentbomid <= 0) {

            //Get levels from parent and child
            int parentLevels = parent.getParentLevels();
            int childLevels = this.getLevels();

            int levelsDiff = childLevels - parentLevels;

            if (parentLevels <= 0) {
                return true;
            }

            if (levelsDiff >= 0) {
                isChild = compareParentAssemblyLevels(levelsDiff, parent);
            }

        }

        return isChild;
    }

    /**
     * This method evaluate if this Bill of Material is a child from parent sequence BillOfMaterial
     *
     * @param parent, BillOfMat
     * @return boolean
     * @throws IllegalAccessException, Exception
     */
    public boolean isChildSequence(BillOfMat parent) throws IllegalAccessException {

        //Child Sequence found
        boolean childSequence = false;

        //Get Assembly Levels
        Map<Integer, LevelSequence> assemblyLevels = getAssemblylevels();

        for (Map.Entry<Integer, LevelSequence> entry : assemblyLevels.entrySet()) {

            //Get level Sequence
            LevelSequence levelSequence = entry.getValue();
            if (levelSequence.levelID == parent.a_levelID && levelSequence.sequenceID == parent.a_sequenceID) {
                childSequence = true;

                break;
            }
        }

        return childSequence;
    }

    /**
     * Evaluate If This Bill Of Material (Glass BOM) is a Child of Assembly BOM
     *
     * @param parent, BillOfMat
     * @return boolean
     * @throws IllegalAccessException, Exception
     */
    public boolean isChildGlass(BillOfMat parent) throws IllegalAccessException {

        boolean isChild = false;

        if (this.equals(parent)) {
            return true;
        }

        //Get levels from parent and child
        int parentLevels = parent.getLevels();
        int childLevels = this.getLevels();

        int levelsDiff = childLevels - parentLevels;

        if (parentLevels <= 0) {
            return true;
        }

        if (levelsDiff <= (childLevels / 2)) {
            isChild = compareParentAssemblyLevels(levelsDiff, parent);
        }

        return isChild;

//        if (parent.a_sequenceID == this.a_2Sequence && parent.a_assemblyLevel == this.a_2Level && parent.glazed) {
//            return true;
//        }

        //****************************************************************************
        //Evaluate if parent is a Frame Object and sequence is the same
        //****************************************************************************
//        return isChildFrame(parent);

    }

    /**
     * Evaluate If this Bill Of Material is a Child of Frame BOM
     *
     * @param parent, BillOfMat
     * @return boolean
     * @throws IllegalAccessException, Exception
     */
    public boolean isChildFrame(BillOfMat parent) throws IllegalAccessException {

        //If is child object
        boolean isChild = false;

        int startLevel = 1;
        int maxLevels = 22;

        //**************************************************************************
        //Preparing fields for childs assemblies
        //**************************************************************************
        Field[] childFields = this.getClass().getFields();

        for (Field level : childFields) {
            String levelName = level.getName();

            if (startLevel <= maxLevels) {

                if (levelName.equals("a_" + startLevel + "Level")) {

                    for (Field sequence : childFields) {

                        String sequenceName = sequence.getName();

                        if (sequenceName.equals("a_" + startLevel + "Sequence")) {
                            Integer levelID = level.getInt(this);
                            Integer sequenceID = sequence.getInt(this);

                            if (levelID > 0 && sequenceID > 0) {
                                if (parent.a_assemblyLevel == levelID && parent.a_sequenceID == sequenceID) {
                                    isChild = true;
                                }
                            }
                        }
                    }

                    startLevel++;
                }
            }
        }

        return isChild;
    }

    /**
     * Evaluate If This Bill Of Material (Glass BOM) is a Child of Assembly BOM
     *
     * @param parent , BillOfMat
     * @return boolean
     * @throws IllegalAccessException, Exception
     */
    public boolean isChildGlassBom(BillOfMat parent) throws IllegalAccessException {

        boolean isChild = false;

        if (this.equalsGlass(parent)) {
            return true;
        }

        //Get levels from parent and child
        int parentLevels = parent.getLevels();
        int childLevels = this.getLevels();

        int levelsDiff = childLevels - parentLevels;

        if (parentLevels <= 0) {
            return true;
        }

        if (levelsDiff >= 0) {
            isChild = compareParentAssemblyLevels(levelsDiff, parent);
        }

        return isChild;
    }

    /**
     * This method evaluate if this Bill of Materials is an assembly level and if a Bill of Materials search is a parent
     * for this object
     *
     * @param parentAssembly, BillOfMat
     * @return boolean
     */
    public boolean isChildAssembly(BillOfMat parentAssembly) throws IllegalAccessException {

        boolean isChild = false;

        if (this.equals(parentAssembly)) {
            return true;
        }

        if ((parentAssembly.assemblyid == this.parentAssembly) && this.parentbomid <= 0) {

            //Get levels from parent and child
            int parentLevels = parentAssembly.getLevels();
            int childLevels = this.getLevels();

            int levelsDiff = childLevels - parentLevels;

            if (parentLevels <= 0) {
                return true;
            }

            if (levelsDiff == 0) {
                return true;
            }

            if (levelsDiff > 0) {
                isChild = compareParentAssemblyLevels(levelsDiff, parentAssembly);
            }
        }

        return isChild;
    }

    /**
     * This methods return Assembly levels for Bill Of Mat
     *
     * @return List<levelSequence>
     * @throws IllegalAccessException, Exception
     */
    private Map<Integer, LevelSequence> getAssemblylevels() throws IllegalAccessException {

        Map<Integer, LevelSequence> levelsChild = new HashMap<Integer, LevelSequence>();

        //**************************************************************************
        //Preparing fields for childs assemblies
        //**************************************************************************
        int startLevel = 1;

        int position = 1;
        int maxLevels = 22;

        Field[] childFields = this.getClass().getFields();

        for (Field level : childFields) {
            String levelName = level.getName();

            if (startLevel <= maxLevels) {

                if (levelName.equals("a_" + startLevel + "Level")) {

                    for (Field sequence : childFields) {

                        String sequenceName = sequence.getName();

                        if (sequenceName.equals("a_" + startLevel + "Sequence")) {
                            Integer levelID = level.getInt(this);
                            Integer sequenceID = sequence.getInt(this);

                            if (levelID > 0 && sequenceID > 0) {
                                LevelSequence childSequence = new LevelSequence(level.getInt(this), sequence.getInt(this));
                                levelsChild.put(position, childSequence);

                                position++;
                            }
                        }
                    }

                    startLevel++;
                }
            }
        }

        return levelsChild;
    }

    /**
     * This method return the total levels for parent for this Bill Of Material
     *
     * @return int
     */
    public int getParentLevels() {

        int levels = 0; //Total levels found for this object

        if (a_levelID > 0 && a_sequenceID > 0) {
            levels++;
        }

        if (a_1Level > 0 && a_1Sequence > 0) {
            levels++;
        }

        if (a_2Level > 0 && a_2Sequence > 0) {
            levels++;
        }

        if (a_3Level > 0 && a_3Sequence > 0) {
            levels++;
        }

        if (a_4Level > 0 && a_4Sequence > 0) {
            levels++;
        }

        if (a_5Level > 0 && a_5Sequence > 0) {
            levels++;
        }

        if (a_6Level > 0 && a_6Sequence > 0) {
            levels++;
        }

        if (a_7Level > 0 && a_7Sequence > 0) {
            levels++;
        }

        if (a_8Level > 0 && a_8Sequence > 0) {
            levels++;
        }

        if (a_9Level > 0 && a_9Sequence > 0) {
            levels++;
        }

        if (a_10Level > 0 && a_10Sequence > 0) {
            levels++;
        }

        if (a_11Level > 0 && a_11Sequence > 0) {
            levels++;
        }

        if (a_12Level > 0 && a_12Sequence > 0) {
            levels++;
        }

        if (a_13Level > 0 && a_13Sequence > 0) {
            levels++;
        }

        if (a_14Level > 0 && a_14Sequence > 0) {
            levels++;
        }

        if (a_15Level > 0 && a_15Sequence > 0) {
            levels++;
        }

        if (a_16Level > 0 && a_16Sequence > 0) {
            levels++;
        }

        if (a_17Level > 0 && a_17Sequence > 0) {
            levels++;
        }

        if (a_18Level > 0 && a_18Sequence > 0) {
            levels++;
        }

        if (a_19Level > 0 && a_19Sequence > 0) {
            levels++;
        }

        if (a_20Level > 0 && a_20Sequence > 0) {
            levels++;
        }

        if (a_21Level > 0 && a_21Sequence > 0) {
            levels++;
        }

        if (a_22Level > 0 && a_22Sequence > 0) {
            levels++;
        }

        return levels;

    }

    /**
     * This method return the total levels for this Bill Of Material
     *
     * @return int
     */
    public int getLevels() {

        int levels = 0; //Total levels found for this object

        if (a_1Level > 0 && a_1Sequence > 0) {
            levels++;
        }

        if (a_2Level > 0 && a_2Sequence > 0) {
            levels++;
        }

        if (a_3Level > 0 && a_3Sequence > 0) {
            levels++;
        }

        if (a_4Level > 0 && a_4Sequence > 0) {
            levels++;
        }

        if (a_5Level > 0 && a_5Sequence > 0) {
            levels++;
        }

        if (a_6Level > 0 && a_6Sequence > 0) {
            levels++;
        }

        if (a_7Level > 0 && a_7Sequence > 0) {
            levels++;
        }

        if (a_8Level > 0 && a_8Sequence > 0) {
            levels++;
        }

        if (a_9Level > 0 && a_9Sequence > 0) {
            levels++;
        }

        if (a_10Level > 0 && a_10Sequence > 0) {
            levels++;
        }

        if (a_11Level > 0 && a_11Sequence > 0) {
            levels++;
        }

        if (a_12Level > 0 && a_12Sequence > 0) {
            levels++;
        }

        if (a_13Level > 0 && a_13Sequence > 0) {
            levels++;
        }

        if (a_14Level > 0 && a_14Sequence > 0) {
            levels++;
        }

        if (a_15Level > 0 && a_15Sequence > 0) {
            levels++;
        }

        if (a_16Level > 0 && a_16Sequence > 0) {
            levels++;
        }

        if (a_17Level > 0 && a_17Sequence > 0) {
            levels++;
        }

        if (a_18Level > 0 && a_18Sequence > 0) {
            levels++;
        }

        if (a_19Level > 0 && a_19Sequence > 0) {
            levels++;
        }

        if (a_20Level > 0 && a_20Sequence > 0) {
            levels++;
        }

        if (a_21Level > 0 && a_21Sequence > 0) {
            levels++;
        }

        if (a_22Level > 0 && a_22Sequence > 0) {
            levels++;
        }

        return levels;
    }

    /**
     * @param shape
     * @return
     */
    public boolean isForDLO(DLO shape) {

        boolean match = false;

        if (a_assemblyLevel == 29 || isForShape(shape)) {
            match = true;
        }
        return match;
    }

    /**
     * Representes pair level & Sequence Object
     */
    private class LevelSequence {
        Integer levelID;
        Integer sequenceID;

        LevelSequence(Integer levelID, Integer sequenceID) {
            this.levelID = levelID;
            this.sequenceID = sequenceID;
        }
    }

    @Override
    public String toString() {
        return ruleno + " " + stockcode + " " + description;
    }

    /**
     * Evaluate a objects are equals
     *
     * @param obj, Object
     * @return boolean
     */
    public boolean equals(Object obj) {

        //Bill of Materials object
        BillOfMat bom = (BillOfMat) obj;

        boolean equals = true;

        if (this.ruleno == null) {
            equals = false;
        }

        if (this.assemblyid != bom.assemblyid) {
            equals = false;
        }

        if (this.parentAssembly != bom.parentAssembly) {
            equals = false;
        }

        if ((this.a_levelID != bom.a_levelID) || (this.a_sequenceID != bom.a_sequenceID)) {
            equals = false;
        }

        if ((this.a_1Level != bom.a_1Level) || (this.a_1Sequence != bom.a_1Sequence)) {
            equals = false;
        }

        if ((this.a_2Level != bom.a_2Level) || (this.a_2Sequence != bom.a_2Sequence)) {
            equals = false;
        }

        if ((this.a_3Level != bom.a_3Level) || (this.a_3Sequence != bom.a_3Sequence)) {
            equals = false;
        }

        if ((this.a_4Level != bom.a_4Level) || (this.a_4Sequence != bom.a_4Sequence)) {
            equals = false;
        }

        if ((this.a_5Level != bom.a_5Level) || (this.a_5Sequence != bom.a_5Sequence)) {
            equals = false;
        }

        if ((this.a_6Level != bom.a_6Level) || (this.a_6Sequence != bom.a_6Sequence)) {
            equals = false;
        }

        if ((this.a_7Level != bom.a_7Level) || (this.a_7Sequence != bom.a_7Sequence)) {
            equals = false;
        }

        if ((this.a_8Level != bom.a_8Level) || (this.a_8Sequence != bom.a_8Sequence)) {
            equals = false;
        }

        if ((this.a_9Level != bom.a_9Level) || (this.a_9Sequence != bom.a_9Sequence)) {
            equals = false;
        }

        if ((this.a_10Level != bom.a_10Level) || (this.a_10Sequence != bom.a_10Sequence)) {
            equals = false;
        }

        if ((this.a_11Level != bom.a_11Level) || (this.a_11Sequence != bom.a_11Sequence)) {
            equals = false;
        }

        if ((this.a_12Level != bom.a_12Level) || (this.a_12Sequence != bom.a_12Sequence)) {
            equals = false;
        }

        if ((this.a_13Level != bom.a_13Level) || (this.a_13Sequence != bom.a_13Sequence)) {
            equals = false;
        }

        if ((this.a_14Level != bom.a_14Level) || (this.a_14Sequence != bom.a_14Sequence)) {
            equals = false;
        }

        if ((this.a_15Level != bom.a_15Level) || (this.a_15Sequence != bom.a_15Sequence)) {
            equals = false;
        }

        if ((this.a_16Level != bom.a_16Level) || (this.a_16Sequence != bom.a_16Sequence)) {
            equals = false;
        }

        if ((this.a_17Level != bom.a_17Level) || (this.a_17Sequence != bom.a_17Sequence)) {
            equals = false;
        }

        if ((this.a_18Level != bom.a_18Level) || (this.a_18Sequence != bom.a_18Sequence)) {
            equals = false;
        }

        if ((this.a_19Level != bom.a_19Level) || (this.a_19Sequence != bom.a_19Sequence)) {
            equals = false;
        }

        if ((this.a_20Level != bom.a_20Level) || (this.a_20Sequence != bom.a_20Sequence)) {
            equals = false;
        }

        if ((this.a_21Level != bom.a_21Level) || (this.a_21Sequence != bom.a_21Sequence)) {
            equals = false;
        }

        if ((this.a_22Level != bom.a_22Level) || (this.a_22Sequence != bom.a_22Sequence)) {
            equals = false;
        }

        return equals;
    }

    /**
     * Evaluate an object are equals (Glass Assembly)
     *
     * @param obj, Object
     * @return boolean
     */
    public boolean equalsGlass(Object obj) {

        //Bill of Materials object
        BillOfMat bom = (BillOfMat) obj;

        boolean equals = true;

        if (this.ruleno == null) {
            equals = false;
        }

        if ((this.a_levelID != bom.a_levelID) || (this.a_sequenceID != bom.a_sequenceID)) {
            equals = false;
        }

        if ((this.a_1Level != bom.a_1Level) || (this.a_1Sequence != bom.a_1Sequence)) {
            equals = false;
        }

        if ((this.a_2Level != bom.a_2Level) || (this.a_2Sequence != bom.a_2Sequence)) {
            equals = false;
        }

        if ((this.a_3Level != bom.a_3Level) || (this.a_3Sequence != bom.a_3Sequence)) {
            equals = false;
        }

        if ((this.a_4Level != bom.a_4Level) || (this.a_4Sequence != bom.a_4Sequence)) {
            equals = false;
        }

        if ((this.a_5Level != bom.a_5Level) || (this.a_5Sequence != bom.a_5Sequence)) {
            equals = false;
        }

        if ((this.a_6Level != bom.a_6Level) || (this.a_6Sequence != bom.a_6Sequence)) {
            equals = false;
        }

        if ((this.a_7Level != bom.a_7Level) || (this.a_7Sequence != bom.a_7Sequence)) {
            equals = false;
        }

        if ((this.a_8Level != bom.a_8Level) || (this.a_8Sequence != bom.a_8Sequence)) {
            equals = false;
        }

        if ((this.a_9Level != bom.a_9Level) || (this.a_9Sequence != bom.a_9Sequence)) {
            equals = false;
        }

        if ((this.a_10Level != bom.a_10Level) || (this.a_10Sequence != bom.a_10Sequence)) {
            equals = false;
        }

        if ((this.a_11Level != bom.a_11Level) || (this.a_11Sequence != bom.a_11Sequence)) {
            equals = false;
        }

        if ((this.a_12Level != bom.a_12Level) || (this.a_12Sequence != bom.a_12Sequence)) {
            equals = false;
        }

        if ((this.a_13Level != bom.a_13Level) || (this.a_13Sequence != bom.a_13Sequence)) {
            equals = false;
        }

        if ((this.a_14Level != bom.a_14Level) || (this.a_14Sequence != bom.a_14Sequence)) {
            equals = false;
        }

        if ((this.a_15Level != bom.a_15Level) || (this.a_15Sequence != bom.a_15Sequence)) {
            equals = false;
        }

        if ((this.a_16Level != bom.a_16Level) || (this.a_16Sequence != bom.a_16Sequence)) {
            equals = false;
        }

        if ((this.a_17Level != bom.a_17Level) || (this.a_17Sequence != bom.a_17Sequence)) {
            equals = false;
        }

        if ((this.a_18Level != bom.a_18Level) || (this.a_18Sequence != bom.a_18Sequence)) {
            equals = false;
        }

        if ((this.a_19Level != bom.a_19Level) || (this.a_19Sequence != bom.a_19Sequence)) {
            equals = false;
        }

        if ((this.a_20Level != bom.a_20Level) || (this.a_20Sequence != bom.a_20Sequence)) {
            equals = false;
        }

        if ((this.a_21Level != bom.a_21Level) || (this.a_21Sequence != bom.a_21Sequence)) {
            equals = false;
        }

        if ((this.a_22Level != bom.a_22Level) || (this.a_22Sequence != bom.a_22Sequence)) {
            equals = false;
        }

        return equals;
    }

    @Override
    public BillOfMat clone() {
        try {
            //Clone Bill of Materials
            return (BillOfMat) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return null;
    }

}


