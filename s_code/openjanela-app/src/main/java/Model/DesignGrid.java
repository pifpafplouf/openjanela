package Model;

import Model.ProfileParts.PartsNotching;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;
import openjanela.model.entities.partner.Grids;
import openjanela.model.entities.parts.Parts;
import org.apache.log4j.Logger;
import org.openjanela.commons.util.data.UOMUtility;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;
import util.UOMConvert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 11/28/13
 *          Time: 12:05 AM
 */
public class DesignGrid implements Cloneable {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(BillOfMat.class);

    // Properties Values

    private int a_levelID = 0;
    private int a_sequenceID = 0;
    private int a_assemblyLevel = 0;

    private int a_1Level = 0;
    private int a_1Sequence = 0;
    private int a_2Level = 0;
    private int a_2Sequence = 0;
    private int a_3Level = 0;
    private int a_3Sequence = 0;
    private int a_4Level = 0;
    private int a_4Sequence = 0;
    private int a_5Level = 0;
    private int a_5Sequence = 0;
    private int a_6Level = 0;
    private int a_6Sequence = 0;
    private int a_7Level = 0;
    private int a_7Sequence = 0;
    private int a_8Level = 0;
    private int a_8Sequence = 0;
    private int a_9Level = 0;
    private int a_9Sequence = 0;
    private int a_10Level = 0;
    private int a_10Sequence = 0;
    private int a_11Level = 0;
    private int a_11Sequence = 0;
    private int a_12Level = 0;
    private int a_12Sequence = 0;
    private int a_13Level = 0;
    private int a_13Sequence = 0;
    private int a_14Level = 0;
    private int a_14Sequence = 0;
    private int a_15Level = 0;
    private int a_15Sequence = 0;
    private int a_16Level = 0;
    private int a_16Sequence = 0;
    private int a_17Level = 0;
    private int a_17Sequence = 0;
    private int a_18Level = 0;
    private int a_18Sequence = 0;
    private int a_19Level = 0;
    private int a_19Sequence = 0;
    private int a_20Level = 0;
    private int a_20Sequence = 0;
    private int a_21Level = 0;
    private int a_21Sequence = 0;
    private int a_22Level = 0;
    private int a_22Sequence = 0;

    private BigDecimal cost;
    private BigDecimal price;
    private BigDecimal totalprice;
    private BigDecimal totalcost;
    private BigDecimal priceuser;
    private BigDecimal totalpriceuser;

    private double qtyuser;

    private int leafNo;
    private int cutlength;
    private int cutlengthi;
    private int width;
    private int widthi;
    private int height;
    private int heighti;
    private int level;
    private int position;
    private int orientation = 0;
    private int rowcol = 0;
    private int startpos = 0;
    private int endpos = 0;
    private int openingid;
    private int sash;
    private int radius1;
    private int radius1i;
    private int radius2;
    private int radius2i;

    private int cutlengthuser;
    private int cutlengthiuser;
    private int widthuser;
    private int widthiuser;
    private int heightuser;
    private int heightiuser;
    private int depth;
    private int depthi;
    private int depthuser;
    private int depthiuser;
    private int weld;
    private int weldi;
    private int weldR;
    private int weldRi;
    private int leftcut;
    private int rightcut;

    public double leftangle;
    public double rightangle;

    private double area;
    private double areai;
    private double areauser;
    private double areaiuser;
    private double volume;
    private double volumei;
    private double volumeuser;
    private double volumeiuser;

    private double lengthw2;
    private double lengthh2;
    private double lengthf12;
    private double lengthf22;

    private boolean isWildSize = false;
    private boolean isWildDepth = false;
    private boolean isWildColor = false;

    private boolean leftIn = false;
    private boolean rightIn = false;

    private boolean isUsed = false;
    private boolean isInOut = false;

    private int shapeID = 0;
    private int partFamily = 0;
    private int priceGroup = 0;
    private int priceCat = 0;
    private int partSequence = 0;

    private String notchLT = "";
    private String notchRB = "";
    private String notchLTi = "";
    private String notchRBi = "";

    private int gridID = 0;
    private int gridType = 0;
    private int gridForm = 0;
    private int crossConnectors = 0;
    private int tConnectors = 0;
    private int lConnectors = 0;
    private int spacerConnectors = 0;
    private int hubConnector = 0;
    private int spokeConnectors = 0;

    //Profiles Identification Object
    private Profiles profiles;

    //Parts Identification Object
    private Parts parts;

    //Opening Identification Object
    private OpeningObject opening;

    //DLO Identification Object
    private DLO dlo;

    //Glass Identification Object
    private GlassSU glassSU;

    //Grids Type Object
    private Grids grids;

    //Collection of Notches Values Metric
    private List<String> notchesM;

    //Collection of Notches Values Imperial
    private List<String> notchesI;

    //Collection of Notches Values Imperial Fraction
    private List<String> notchesIY;

    // **************************************************<Getter & Setters>*********************************************

    public int getA_levelID() {
        return a_levelID;
    }

    public void setA_levelID(int a_levelID) {
        this.a_levelID = a_levelID;
    }

    public int getA_sequenceID() {
        return a_sequenceID;
    }

    public void setA_sequenceID(int a_sequenceID) {
        this.a_sequenceID = a_sequenceID;
    }

    public int getA_assemblyLevel() {
        return a_assemblyLevel;
    }

    public void setA_assemblyLevel(int a_assemblyLevel) {
        this.a_assemblyLevel = a_assemblyLevel;
    }

    public int getA_1Level() {
        return a_1Level;
    }

    public void setA_1Level(int a_1Level) {
        this.a_1Level = a_1Level;
    }

    public int getA_1Sequence() {
        return a_1Sequence;
    }

    public void setA_1Sequence(int a_1Sequence) {
        this.a_1Sequence = a_1Sequence;
    }

    public int getA_2Level() {
        return a_2Level;
    }

    public void setA_2Level(int a_2Level) {
        this.a_2Level = a_2Level;
    }

    public int getA_2Sequence() {
        return a_2Sequence;
    }

    public void setA_2Sequence(int a_2Sequence) {
        this.a_2Sequence = a_2Sequence;
    }

    public int getA_3Level() {
        return a_3Level;
    }

    public void setA_3Level(int a_3Level) {
        this.a_3Level = a_3Level;
    }

    public int getA_3Sequence() {
        return a_3Sequence;
    }

    public void setA_3Sequence(int a_3Sequence) {
        this.a_3Sequence = a_3Sequence;
    }

    public int getA_4Level() {
        return a_4Level;
    }

    public void setA_4Level(int a_4Level) {
        this.a_4Level = a_4Level;
    }

    public int getA_4Sequence() {
        return a_4Sequence;
    }

    public void setA_4Sequence(int a_4Sequence) {
        this.a_4Sequence = a_4Sequence;
    }

    public int getA_5Level() {
        return a_5Level;
    }

    public void setA_5Level(int a_5Level) {
        this.a_5Level = a_5Level;
    }

    public int getA_5Sequence() {
        return a_5Sequence;
    }

    public void setA_5Sequence(int a_5Sequence) {
        this.a_5Sequence = a_5Sequence;
    }

    public int getA_6Level() {
        return a_6Level;
    }

    public void setA_6Level(int a_6Level) {
        this.a_6Level = a_6Level;
    }

    public int getA_6Sequence() {
        return a_6Sequence;
    }

    public void setA_6Sequence(int a_6Sequence) {
        this.a_6Sequence = a_6Sequence;
    }

    public int getA_7Level() {
        return a_7Level;
    }

    public void setA_7Level(int a_7Level) {
        this.a_7Level = a_7Level;
    }

    public int getA_7Sequence() {
        return a_7Sequence;
    }

    public void setA_7Sequence(int a_7Sequence) {
        this.a_7Sequence = a_7Sequence;
    }

    public int getA_8Level() {
        return a_8Level;
    }

    public void setA_8Level(int a_8Level) {
        this.a_8Level = a_8Level;
    }

    public int getA_8Sequence() {
        return a_8Sequence;
    }

    public void setA_8Sequence(int a_8Sequence) {
        this.a_8Sequence = a_8Sequence;
    }

    public int getA_9Level() {
        return a_9Level;
    }

    public void setA_9Level(int a_9Level) {
        this.a_9Level = a_9Level;
    }

    public int getA_9Sequence() {
        return a_9Sequence;
    }

    public void setA_9Sequence(int a_9Sequence) {
        this.a_9Sequence = a_9Sequence;
    }

    public int getA_10Level() {
        return a_10Level;
    }

    public void setA_10Level(int a_10Level) {
        this.a_10Level = a_10Level;
    }

    public int getA_10Sequence() {
        return a_10Sequence;
    }

    public void setA_10Sequence(int a_10Sequence) {
        this.a_10Sequence = a_10Sequence;
    }

    public int getA_11Level() {
        return a_11Level;
    }

    public void setA_11Level(int a_11Level) {
        this.a_11Level = a_11Level;
    }

    public int getA_11Sequence() {
        return a_11Sequence;
    }

    public void setA_11Sequence(int a_11Sequence) {
        this.a_11Sequence = a_11Sequence;
    }

    public int getA_12Level() {
        return a_12Level;
    }

    public void setA_12Level(int a_12Level) {
        this.a_12Level = a_12Level;
    }

    public int getA_12Sequence() {
        return a_12Sequence;
    }

    public void setA_12Sequence(int a_12Sequence) {
        this.a_12Sequence = a_12Sequence;
    }

    public int getA_13Level() {
        return a_13Level;
    }

    public void setA_13Level(int a_13Level) {
        this.a_13Level = a_13Level;
    }

    public int getA_13Sequence() {
        return a_13Sequence;
    }

    public void setA_13Sequence(int a_13Sequence) {
        this.a_13Sequence = a_13Sequence;
    }

    public int getA_14Level() {
        return a_14Level;
    }

    public void setA_14Level(int a_14Level) {
        this.a_14Level = a_14Level;
    }

    public int getA_14Sequence() {
        return a_14Sequence;
    }

    public void setA_14Sequence(int a_14Sequence) {
        this.a_14Sequence = a_14Sequence;
    }

    public int getA_15Level() {
        return a_15Level;
    }

    public void setA_15Level(int a_15Level) {
        this.a_15Level = a_15Level;
    }

    public int getA_15Sequence() {
        return a_15Sequence;
    }

    public void setA_15Sequence(int a_15Sequence) {
        this.a_15Sequence = a_15Sequence;
    }

    public int getA_16Level() {
        return a_16Level;
    }

    public void setA_16Level(int a_16Level) {
        this.a_16Level = a_16Level;
    }

    public int getA_16Sequence() {
        return a_16Sequence;
    }

    public void setA_16Sequence(int a_16Sequence) {
        this.a_16Sequence = a_16Sequence;
    }

    public int getA_17Level() {
        return a_17Level;
    }

    public void setA_17Level(int a_17Level) {
        this.a_17Level = a_17Level;
    }

    public int getA_17Sequence() {
        return a_17Sequence;
    }

    public void setA_17Sequence(int a_17Sequence) {
        this.a_17Sequence = a_17Sequence;
    }

    public int getA_18Level() {
        return a_18Level;
    }

    public void setA_18Level(int a_18Level) {
        this.a_18Level = a_18Level;
    }

    public int getA_18Sequence() {
        return a_18Sequence;
    }

    public void setA_18Sequence(int a_18Sequence) {
        this.a_18Sequence = a_18Sequence;
    }

    public int getA_19Level() {
        return a_19Level;
    }

    public void setA_19Level(int a_19Level) {
        this.a_19Level = a_19Level;
    }

    public int getA_19Sequence() {
        return a_19Sequence;
    }

    public void setA_19Sequence(int a_19Sequence) {
        this.a_19Sequence = a_19Sequence;
    }

    public int getA_20Level() {
        return a_20Level;
    }

    public void setA_20Level(int a_20Level) {
        this.a_20Level = a_20Level;
    }

    public int getA_20Sequence() {
        return a_20Sequence;
    }

    public void setA_20Sequence(int a_20Sequence) {
        this.a_20Sequence = a_20Sequence;
    }

    public int getA_21Level() {
        return a_21Level;
    }

    public void setA_21Level(int a_21Level) {
        this.a_21Level = a_21Level;
    }

    public int getA_21Sequence() {
        return a_21Sequence;
    }

    public void setA_21Sequence(int a_21Sequence) {
        this.a_21Sequence = a_21Sequence;
    }

    public int getA_22Level() {
        return a_22Level;
    }

    public void setA_22Level(int a_22Level) {
        this.a_22Level = a_22Level;
    }

    public int getA_22Sequence() {
        return a_22Sequence;
    }

    public void setA_22Sequence(int a_22Sequence) {
        this.a_22Sequence = a_22Sequence;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    public BigDecimal getPriceuser() {
        return priceuser;
    }

    public void setPriceuser(BigDecimal priceuser) {
        this.priceuser = priceuser;
    }

    public BigDecimal getTotalpriceuser() {
        return totalpriceuser;
    }

    public void setTotalpriceuser(BigDecimal totalpriceuser) {
        this.totalpriceuser = totalpriceuser;
    }

    public double getQtyuser() {
        return qtyuser;
    }

    public void setQtyuser(double qtyuser) {
        this.qtyuser = qtyuser;
    }

    public int getLeafNo() {
        return leafNo;
    }

    public void setLeafNo(int leafNo) {
        this.leafNo = leafNo;
    }

    public int getCutlength() {
        return cutlength;
    }

    public void setCutlength(int cutlength) {
        this.cutlength = cutlength;
    }

    public int getCutlengthi() {
        return cutlengthi;
    }

    public void setCutlengthi(int cutlengthi) {
        this.cutlengthi = cutlengthi;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidthi() {
        return widthi;
    }

    public void setWidthi(int widthi) {
        this.widthi = widthi;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeighti() {
        return heighti;
    }

    public void setHeighti(int heighti) {
        this.heighti = heighti;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getRowcol() {
        return rowcol;
    }

    public void setRowcol(int rowcol) {
        this.rowcol = rowcol;
    }

    public int getStartpos() {
        return startpos;
    }

    public void setStartpos(int starpos) {
        this.startpos = starpos;
    }

    public int getEndpos() {
        return endpos;
    }

    public void setEndpos(int endpos) {
        this.endpos = endpos;
    }

    public int getOpeningid() {
        return openingid;
    }

    public void setOpeningid(int openingid) {
        this.openingid = openingid;
    }

    public int getSash() {
        return sash;
    }

    public void setSash(int sash) {
        this.sash = sash;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getRadius1i() {
        return radius1i;
    }

    public void setRadius1i(int radius1i) {
        this.radius1i = radius1i;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius2i() {
        return radius2i;
    }

    public void setRadius2i(int radius2i) {
        this.radius2i = radius2i;
    }

    public int getCutlengthuser() {
        return cutlengthuser;
    }

    public void setCutlengthuser(int cutlengthuser) {
        this.cutlengthuser = cutlengthuser;
    }

    public int getCutlengthiuser() {
        return cutlengthiuser;
    }

    public void setCutlengthiuser(int cutlengthiuser) {
        this.cutlengthiuser = cutlengthiuser;
    }

    public int getWidthuser() {
        return widthuser;
    }

    public void setWidthuser(int widthuser) {
        this.widthuser = widthuser;
    }

    public int getWidthiuser() {
        return widthiuser;
    }

    public void setWidthiuser(int widthiuser) {
        this.widthiuser = widthiuser;
    }

    public int getHeightuser() {
        return heightuser;
    }

    public void setHeightuser(int heightuser) {
        this.heightuser = heightuser;
    }

    public int getHeightiuser() {
        return heightiuser;
    }

    public void setHeightiuser(int heightiuser) {
        this.heightiuser = heightiuser;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepthi() {
        return depthi;
    }

    public void setDepthi(int depthi) {
        this.depthi = depthi;
    }

    public int getDepthuser() {
        return depthuser;
    }

    public void setDepthuser(int depthuser) {
        this.depthuser = depthuser;
    }

    public int getDepthiuser() {
        return depthiuser;
    }

    public void setDepthiuser(int depthiuser) {
        this.depthiuser = depthiuser;
    }

    public int getWeld() {
        return weld;
    }

    public void setWeld(int weld) {
        this.weld = weld;
    }

    public int getWeldi() {
        return weldi;
    }

    public void setWeldi(int weldi) {
        this.weldi = weldi;
    }

    public int getWeldR() {
        return weldR;
    }

    public void setWeldR(int weldR) {
        this.weldR = weldR;
    }

    public int getWeldRi() {
        return weldRi;
    }

    public void setWeldRi(int weldRi) {
        this.weldRi = weldRi;
    }

    public int getLeftcut() {
        return leftcut;
    }

    public void setLeftcut(int leftcut) {
        this.leftcut = leftcut;
    }

    public int getRightcut() {
        return rightcut;
    }

    public void setRightcut(int rightcut) {
        this.rightcut = rightcut;
    }

    public double getLeftangle() {
        return leftangle;
    }

    public void setLeftangle(double leftangle) {
        this.leftangle = leftangle;
    }

    public double getRightangle() {
        return rightangle;
    }

    public void setRightangle(double rightangle) {
        this.rightangle = rightangle;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getAreai() {
        return areai;
    }

    public void setAreai(double areai) {
        this.areai = areai;
    }

    public double getAreauser() {
        return areauser;
    }

    public void setAreauser(double areauser) {
        this.areauser = areauser;
    }

    public double getAreaiuser() {
        return areaiuser;
    }

    public void setAreaiuser(double areaiuser) {
        this.areaiuser = areaiuser;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolumei() {
        return volumei;
    }

    public void setVolumei(double volumei) {
        this.volumei = volumei;
    }

    public double getVolumeuser() {
        return volumeuser;
    }

    public void setVolumeuser(double volumeuser) {
        this.volumeuser = volumeuser;
    }

    public double getVolumeiuser() {
        return volumeiuser;
    }

    public void setVolumeiuser(double volumeiuser) {
        this.volumeiuser = volumeiuser;
    }

    public double getLengthw2() {
        return lengthw2;
    }

    public void setLengthw2(double lengthw2) {
        this.lengthw2 = lengthw2;
    }

    public double getLengthh2() {
        return lengthh2;
    }

    public void setLengthh2(double lengthh2) {
        this.lengthh2 = lengthh2;
    }

    public double getLengthf12() {
        return lengthf12;
    }

    public void setLengthf12(double lengthf12) {
        this.lengthf12 = lengthf12;
    }

    public double getLengthf22() {
        return lengthf22;
    }

    public void setLengthf22(double lengthf22) {
        this.lengthf22 = lengthf22;
    }

    public boolean isInOut() {
        return isInOut;
    }

    public void setInOut(boolean inOut) {
        isInOut = inOut;
    }

    public boolean isWildSize() {
        return isWildSize;
    }

    public void setWildSize(boolean wildSize) {
        isWildSize = wildSize;
    }

    public boolean isWildDepth() {
        return isWildDepth;
    }

    public void setWildDepth(boolean wildDepth) {
        isWildDepth = wildDepth;
    }

    public boolean isWildColor() {
        return isWildColor;
    }

    public void setWildColor(boolean wildColor) {
        isWildColor = wildColor;
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    public int getPartFamily() {
        return partFamily;
    }

    public void setPartFamily(int partFamily) {
        this.partFamily = partFamily;
    }

    public int getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(int priceGroup) {
        this.priceGroup = priceGroup;
    }

    public int getPriceCat() {
        return priceCat;
    }

    public void setPriceCat(int priceCat) {
        this.priceCat = priceCat;
    }

    public int getPartSequence() {
        return partSequence;
    }

    public void setPartSequence(int partSequence) {
        this.partSequence = partSequence;
    }

    public String getNotchLT() {
        return notchLT;
    }

    public void setNotchLT(String notchLT) {
        this.notchLT = notchLT;
    }

    public String getNotchRB() {
        return notchRB;
    }

    public void setNotchRB(String notchRB) {
        this.notchRB = notchRB;
    }

    public String getNotchLTi() {
        return notchLTi;
    }

    public void setNotchLTi(String notchLTi) {
        this.notchLTi = notchLTi;
    }

    public String getNotchRBi() {
        return notchRBi;
    }

    public void setNotchRBi(String notchRBi) {
        this.notchRBi = notchRBi;
    }

    public int getGridID() {
        return gridID;
    }

    public void setGridID(int gridID) {
        this.gridID = gridID;
    }

    public int getGridType() {
        return gridType;
    }

    public void setGridType(int gridType) {
        this.gridType = gridType;
    }

    public int getGridForm() {
        return gridForm;
    }

    public void setGridForm(int gridForm) {
        this.gridForm = gridForm;
    }

    public int getCrossConnectors() {
        return crossConnectors;
    }

    public void setCrossConnectors(int crossConnectors) {
        this.crossConnectors = crossConnectors;
    }

    public int gettConnectors() {
        return tConnectors;
    }

    public void settConnectors(int tConnectors) {
        this.tConnectors = tConnectors;
    }

    public int getlConnectors() {
        return lConnectors;
    }

    public void setlConnectors(int lConnectors) {
        this.lConnectors = lConnectors;
    }

    public int getSpacerConnectors() {
        return spacerConnectors;
    }

    public void setSpacerConnectors(int spacerConnectors) {
        this.spacerConnectors = spacerConnectors;
    }

    public int getHubConnector() {
        return hubConnector;
    }

    public void setHubConnector(int hubConnector) {
        this.hubConnector = hubConnector;
    }

    public int getSpokeConnectors() {
        return spokeConnectors;
    }

    public void setSpokeConnectors(int spokeConnectors) {
        this.spokeConnectors = spokeConnectors;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isLeftIn() {
        return leftIn;
    }

    public void setLeftIn(boolean leftIn) {
        this.leftIn = leftIn;
    }

    public boolean isRightIn() {
        return rightIn;
    }

    public void setRightIn(boolean rightIn) {
        this.rightIn = rightIn;
    }

    public Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public OpeningObject getOpening() {
        return opening;
    }

    public void setOpening(OpeningObject opening) {
        this.opening = opening;
    }

    public DLO getDlo() {
        return dlo;
    }

    public void setDlo(DLO dlo) {
        this.dlo = dlo;
    }

    public GlassSU getGlassSU() {
        return glassSU;
    }

    public void setGlassSU(GlassSU glassSU) {
        this.glassSU = glassSU;
    }

    public Grids getGrids() {
        return grids;
    }

    public void setGrids(Grids grids) {
        this.grids = grids;
    }

    public List<String> getNotchesM() {
        return notchesM;
    }

    public void setNotchesM(List<String> notchesM) {
        this.notchesM = notchesM;
    }

    public List<String> getNotchesI() {
        return notchesI;
    }

    public void setNotchesI(List<String> notchesI) {
        this.notchesI = notchesI;
    }

    public List<String> getNotchesIY() {
        return notchesIY;
    }

    public void setNotchesIY(List<String> notchesIY) {
        this.notchesIY = notchesIY;
    }

    /**
     * Design Glass Object
     *
     * @param opening, OpeningObject
     * @param dlo,     DLO
     * @param glassSU, GlassSU
     * @param profile, Profiles
     * @param qty,     Quantity
     * @param gridID,  Grid Identification Id
     * @param partID,  Part Identification Id
     * @param inout,   Leaf External
     */
    public DesignGrid(OpeningObject opening, DLO dlo, GlassSU glassSU, Profiles profile, Integer qty, Integer gridID,
                      Integer partID, boolean inout) {

        //*************************************************************************************
        // 1. Setting Glass Level & Sequence Values
        //*************************************************************************************
        this.a_levelID = glassSU.a_levelID;
        this.a_sequenceID = glassSU.a_sequenceID;
        this.a_assemblyLevel = glassSU.a_assemblyLevel;

        this.a_1Level = glassSU.a_1Level;
        this.a_1Sequence = glassSU.a_1Sequence;
        this.a_2Level = glassSU.a_2Level;
        this.a_2Sequence = glassSU.a_2Sequence;
        this.a_3Level = glassSU.a_3Level;
        this.a_3Sequence = glassSU.a_3Sequence;
        this.a_4Level = glassSU.a_4Level;
        this.a_4Sequence = glassSU.a_4Sequence;
        this.a_5Level = glassSU.a_5Level;
        this.a_5Sequence = glassSU.a_5Sequence;
        this.a_6Level = glassSU.a_6Level;
        this.a_6Sequence = glassSU.a_6Sequence;
        this.a_7Level = glassSU.a_7Level;
        this.a_7Sequence = glassSU.a_7Sequence;
        this.a_8Level = glassSU.a_8Level;
        this.a_8Sequence = glassSU.a_8Sequence;
        this.a_9Level = glassSU.a_9Level;
        this.a_9Sequence = glassSU.a_9Sequence;
        this.a_10Level = glassSU.a_10Level;
        this.a_10Sequence = glassSU.a_10Sequence;
        this.a_11Level = glassSU.a_11Level;
        this.a_11Sequence = glassSU.a_11Sequence;
        this.a_12Level = glassSU.a_12Level;
        this.a_12Sequence = glassSU.a_12Sequence;
        this.a_13Level = glassSU.a_13Level;
        this.a_13Sequence = glassSU.a_13Sequence;
        this.a_14Level = glassSU.a_14Level;
        this.a_14Sequence = glassSU.a_14Sequence;
        this.a_15Level = glassSU.a_15Level;
        this.a_15Sequence = glassSU.a_15Sequence;
        this.a_16Level = glassSU.a_16Level;
        this.a_16Sequence = glassSU.a_16Sequence;
        this.a_17Level = glassSU.a_17Level;
        this.a_17Sequence = glassSU.a_17Sequence;
        this.a_18Level = glassSU.a_18Level;
        this.a_18Sequence = glassSU.a_18Sequence;
        this.a_19Level = glassSU.a_19Level;
        this.a_19Sequence = glassSU.a_19Sequence;
        this.a_20Level = glassSU.a_20Level;
        this.a_20Sequence = glassSU.a_20Sequence;
        this.a_21Level = glassSU.a_21Level;
        this.a_21Sequence = glassSU.a_21Sequence;
        this.a_22Level = glassSU.a_22Level;
        this.a_22Sequence = glassSU.a_22Sequence;

        //Setting Grids Level Identification
        if (profile != null) {
            this.level = profile.a_levelID;
            this.orientation = profile.orientation;
            this.rowcol = profile.rowCol;
            this.startpos = profile.startPos;
            this.endpos = profile.endPos;
        }

        //Setting Quantity User
        this.qtyuser = qty;

        //*************************************************************************************
        // 2. Setting DLO Values
        //*************************************************************************************
        this.isInOut = inout;
        this.gridID = dlo.gridID;
        this.gridType = dlo.gridType;
        this.gridForm = dlo.gridForm;
        this.crossConnectors = dlo.crossConnectors;
        this.tConnectors = dlo.tConnectors;
        this.lConnectors = dlo.lConnectors;
        this.spacerConnectors = dlo.spacerConnectors;
        this.hubConnector = dlo.hubConnector;
        this.spokeConnectors = dlo.spokeConnectors;

        //*************************************************************************************
        // 3. Setting BOM Profile Values
        //*************************************************************************************
        Grids grid = null;
        Parts parts = null;

        if (dlo.remote) {
            grid = ItemFrame.getApplicationRemoteBaseRules().getGrids(dlo.supplierId, gridID);
            parts = ItemFrame.getApplicationRemoteBaseRules().getPart(dlo.supplierId, partID);
        } else {
            grid = ApplicationBaseRulesApp.getInstance().getGrids(gridID);
            parts = ApplicationBaseApp.getInstance().getPart(partID);
        }

        this.profiles = profile;
        this.parts = parts;
        this.opening = opening;
        this.dlo = dlo;
        this.glassSU = glassSU;

        // Set profile Length
        if (parts != null) {
            if (parts.getParttype() == 2 || parts.getParttype() == 15 || parts.getParttype() == 4 ||
                    parts.getParttype() == 502) {
                setProfileLength(profile, parts);
            }
        }

        //Setting Grid Value Object
        this.grids = grid;

        //*************************************************************************************
        // 4. Setting Cost & Price
        //*************************************************************************************
        this.priceCat = 4; //Grids Price Category

        this.cost = new BigDecimal("0");
        this.price = new BigDecimal("0");
        this.totalprice = new BigDecimal("0");
        this.totalcost = new BigDecimal("0");
        this.priceuser = new BigDecimal("0");
        this.totalpriceuser = new BigDecimal("0");
    }

    /**
     * Setting Profile Length
     *
     * @param profile, Profiles
     * @param parts,   Parts
     */
    private void setProfileLength(Profiles profile, Parts parts) {

        try {

            if (profile != null) {

                //***************************************************************************************
                // 1. Setting CutLength Profile Value
                //***************************************************************************************
                this.cutlength = profile.lengthM;
                this.cutlengthi = profile.lengthI;

                double spacerToDLO = 0;
                double spacerToDLOImp = 0;

                if (dlo.myFrame2.mySeries.getSeriesUom() == 1) {
                    double glassToSpacerM = UOMConvert.getBigDecimalConversion(glassSU.glassToSpacer, dlo.myFrame2.metricscale, 1);
                    spacerToDLO = UOMConvert.getBigDecimalConversion(dlo.startingX - glassSU.startingX - glassToSpacerM, dlo.myFrame2.metricscale, 2);
                } else {
                    double glassToSpacerI = UOMConvert.getBigDecimalConversion(glassSU.glassToSpacer, dlo.myFrame2.imperialscale, 1);
                    spacerToDLOImp = UOMConvert.getBigDecimalConversion(dlo.startingX - glassSU.startingX - glassToSpacerI, dlo.myFrame2.imperialscale, 2);
                }

                if (isInOut) {

                    if (profile.posCondition == 1) {      //  |--  --|
                        this.cutlength = (int) (this.cutlength - (2 * spacerToDLO));
                        this.cutlengthi = (int) (this.cutlengthi - (2 * spacerToDLOImp));
                    } else if (profile.posCondition == 2 || profile.posCondition == 3) {      //  |--*   or *--|
                        this.cutlength = (int) (this.cutlength - (1 * spacerToDLO));
                        this.cutlengthi = (int) (this.cutlengthi - (1 * spacerToDLOImp));
                    }
                }

                if (profile.startAngle == 45) {
                    this.cutlength = this.cutlength + parts.getWeldallowance();
                    this.cutlengthi = this.cutlengthi + parts.getWeldallowacei();
                } else if (profile.startAngle != 45) {
                    this.cutlength = this.cutlength + parts.getWeldallowanceother();
                    this.cutlengthi = this.cutlengthi + parts.getWeldallowanceotheri();
                }

                this.cutlengthuser = cutlength;
                this.cutlengthiuser = cutlengthi;


                //x2**************************************************************************************x3
                // 2. Setting noching values
                //x1***************************************************************************************x4
                this.partSequence = profile.seq;
                this.leftIn = profile.leftIn;
                this.rightIn = profile.rightIn;
                this.notchLT = profile.notchLT;
                this.notchRB = profile.notchRB;
                this.notchLTi = profile.notchLTi;
                this.notchRBi = profile.notchRBi;

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
                            midX = (maxX + minX)/2;
                            midY = (maxY + minY)/2;
                        } else {
//                            midX = (notching.x1 + notching.x2) / 2;
//                            midY = (notching.y1 + notching.y2) / 2;
                        	 midX = (maxX + minX)/2;
                             midY = (maxY + minY)/2;
                        }

                        //Calculate Length Value
                        double length = Math.sqrt(Math.pow((Math.max(midX, profile.x2) - Math.min(midX, profile.x2)), 2) +
                                Math.pow((Math.max(midY, profile.y1) - Math.min(midY, profile.y1)), 2));
                        
                        //Calculate Length Metric & Imperial Value
                        int lengthM = new BigDecimal(length + "").divide(profile.myFrame2.metricscale, 1, BigDecimal.ROUND_HALF_EVEN).intValue();
                        int lengthI = new BigDecimal(length + "").divide(profile.myFrame2.imperialscale, 1, BigDecimal.ROUND_HALF_EVEN).intValue();

                        if (isInOut) {
                            lengthM = (int) (lengthM - spacerToDLO);
                            lengthI = (int) (lengthI - spacerToDLO);
                        }

                        //Adding notches Metric
                        notchesM.add(new BigDecimal(lengthM).divide(new BigDecimal("100"), 6, BigDecimal.ROUND_HALF_EVEN).
                                toString());

                        //Adding notches Imperial
                        notchesI.add(new BigDecimal(lengthI).divide(new BigDecimal("64"), 6, BigDecimal.ROUND_HALF_EVEN).
                                toString());

                        //Adding notches Imperial Fraction
                        notchesIY.add(UOMUtility.imperialToFraction(new BigDecimal(lengthI).
                                divide(new BigDecimal("64"), 6,  BigDecimal.ROUND_HALF_EVEN).toString()));

                    } else {

                        //Calculate Length Value
                        this.lengthw2 = Math.sqrt(Math.pow((Math.max(glassSU.bkgrdStartX, profile.x1) - Math.min(glassSU.bkgrdStartX, profile.x1)), 2) +
                                Math.pow((Math.max(glassSU.bkgrdStartY, profile.y1) - Math.min(glassSU.bkgrdStartY, profile.y1)), 2));

                        this.lengthh2 = Math.sqrt(Math.pow((Math.max(glassSU.bkgrdStartX, profile.bkgrdStartX) - Math.min(glassSU.bkgrdStartX, profile.bkgrdStartX)), 2) +
                                Math.pow((Math.max(glassSU.bkgrdStartY, profile.bkgrdStartY) - Math.min(glassSU.bkgrdStartY, profile.bkgrdStartY)), 2));

                        this.lengthf12 = Math.sqrt(Math.pow((Math.max(glassSU.bkgrdStartX, profile.focal1X) - Math.min(glassSU.bkgrdStartX, profile.focal1X)), 2) +
                                Math.pow((Math.max(glassSU.bkgrdStartY, profile.focal1Y) - Math.min(glassSU.bkgrdStartY, profile.focal1Y)), 2));

                        this.lengthf22 = Math.sqrt(Math.pow((Math.max(glassSU.bkgrdStartX, profile.focal2X) - Math.min(glassSU.bkgrdStartX, profile.focal2X)), 2) +
                                Math.pow((Math.max(glassSU.bkgrdStartY, profile.focal2Y) - Math.min(glassSU.bkgrdStartY, profile.focal2Y)), 2));
                    }
                }

                //***************************************************************************************
                // 3. Setting Radius values
                //***************************************************************************************
                this.radius1 = (int) (profile.radius1 / profile.myFrame2.metricscale.doubleValue());
                this.radius1i = (int) (profile.radius1 / profile.myFrame2.imperialscale.doubleValue());
                this.radius2 = (int) (profile.radius2 / profile.myFrame2.metricscale.doubleValue());
                this.radius2i = (int) (profile.radius2 / profile.myFrame2.imperialscale.doubleValue());

                if (this.radius1 < 0) {
                    this.radius1 = 0;
                }

                if (this.radius1i < 0) {
                    this.radius1i = 0;
                }

                if (this.radius2 < 0) {
                    this.radius2 = 0;
                }

                if (this.radius2i < 0) {
                    this.radius2i = 0;
                }

                //***************************************************************************************
                // 4. Setting Angles values
                //***************************************************************************************
                this.leftangle = profile.ltAngle;
                this.rightangle = profile.rbAngle;

                this.leftcut = profile.endTypeLT;
                this.rightcut = profile.endTypeRB;

                if (profile.endTypeLT == 1) {
                    if (this.leftangle == Math.abs(45)) {
                        this.weld = parts.getWeldallowance();
                        this.weldi = parts.getWeldallowacei();
                    } else {
                        this.weld = parts.getWeldallowanceother();
                        this.weldi = parts.getWeldallowanceotheri();
                    }
                }

                if (profile.endTypeRB == 1) {
                    if (this.rightangle == Math.abs(45)) {
                        this.weldR = parts.getWeldallowance();
                        this.weldRi = parts.getWeldallowacei();
                    } else {
                        this.weldR = parts.getWeldallowanceother();
                        this.weldRi = parts.getWeldallowanceotheri();
                    }
                }

                //***************************************************************************************
                // 5. Setting Width & Heights & Area & Volume & Depth
                //***************************************************************************************
                this.width = 0;
                this.widthi = 0;
                this.height = 0;
                this.heighti = 0;

                this.widthuser = this.width;
                this.widthiuser = this.widthi;
                this.heightuser = this.height;
                this.heightiuser = this.heighti;

                this.depth = 0;
                this.depthi = 0;
                this.depthuser = this.depth;
                this.depthiuser = this.depthi;

                this.area = this.width / 100000 * this.height / 100000;
                this.areai = this.widthi / 64d / 12 * this.heighti / 64d / 12;

                this.areauser = this.area;
                this.areaiuser = this.areai;

                this.volume = this.width / 100000 * this.height / 100000 * this.depth / 100000;
                this.volumei = this.widthi / 64d / 12 * this.heighti / 64d / 12 * this.depthi / 64d / 12;

                this.volumeuser = this.volume;
                this.volumeiuser = this.volumei;
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Evaluate if grids belongs to Glass BOM
     *
     * @param billOfMat, BillOfMat
     * @return boolean
     */
    public boolean isChildGlass(BillOfMat billOfMat) {

        if (this.a_levelID != billOfMat.a_levelID) {
            return false;
        }

        if (a_sequenceID != billOfMat.a_sequenceID) {
            return false;
        }

        if (a_assemblyLevel != billOfMat.a_assemblyLevel) {
            return false;
        }

        if (a_1Level != billOfMat.a_1Level) {
            return false;
        }

        if (a_2Level != billOfMat.a_2Level) {
            return false;
        }

        if (a_3Level != billOfMat.a_3Level) {
            return false;
        }

        if (a_4Level != billOfMat.a_4Level) {
            return false;
        }

        if (a_5Level != billOfMat.a_5Level) {
            return false;
        }

        if (a_6Level != billOfMat.a_6Level) {
            return false;
        }

        if (a_7Level != billOfMat.a_7Level) {
            return false;
        }

        if (a_8Level != billOfMat.a_8Level) {
            return false;
        }

        if (a_9Level != billOfMat.a_9Level) {
            return false;
        }

        if (a_10Level != billOfMat.a_10Level) {
            return false;
        }

        if (a_11Level != billOfMat.a_11Level) {
            return false;
        }

        if (a_12Level != billOfMat.a_12Level) {
            return false;
        }

        if (a_13Level != billOfMat.a_13Level) {
            return false;
        }

        if (a_14Level != billOfMat.a_14Level) {
            return false;
        }

        if (a_15Level != billOfMat.a_15Level) {
            return false;
        }

        if (a_16Level != billOfMat.a_16Level) {
            return false;
        }

        if (a_17Level != billOfMat.a_17Level) {
            return false;
        }

        if (a_18Level != billOfMat.a_18Level) {
            return false;
        }

        if (a_19Level != billOfMat.a_19Level) {
            return false;
        }

        if (a_20Level != billOfMat.a_20Level) {
            return false;
        }

        if (a_21Level != billOfMat.a_21Level) {
            return false;
        }

        if (a_22Level != billOfMat.a_22Level) {
            return false;
        }

        if (a_1Sequence != billOfMat.a_1Sequence) {
            return false;
        }

        if (a_2Sequence != billOfMat.a_2Sequence) {
            return false;
        }

        if (a_3Sequence != billOfMat.a_3Sequence) {
            return false;
        }

        if (a_4Sequence != billOfMat.a_4Sequence) {
            return false;
        }

        if (a_5Sequence != billOfMat.a_5Sequence) {
            return false;
        }

        if (a_6Sequence != billOfMat.a_6Sequence) {
            return false;
        }

        if (a_7Sequence != billOfMat.a_7Sequence) {
            return false;
        }

        if (a_8Sequence != billOfMat.a_8Sequence) {
            return false;
        }

        if (a_9Sequence != billOfMat.a_9Sequence) {
            return false;
        }

        if (a_10Sequence != billOfMat.a_10Sequence) {
            return false;
        }

        if (a_11Sequence != billOfMat.a_11Sequence) {
            return false;
        }

        if (a_12Sequence != billOfMat.a_12Sequence) {
            return false;
        }

        if (a_13Sequence != billOfMat.a_13Sequence) {
            return false;
        }

        if (a_14Sequence != billOfMat.a_14Sequence) {
            return false;
        }

        if (a_15Sequence != billOfMat.a_15Sequence) {
            return false;
        }

        if (a_16Sequence != billOfMat.a_16Sequence) {
            return false;
        }

        if (a_17Sequence != billOfMat.a_17Sequence) {
            return false;
        }

        if (a_18Sequence != billOfMat.a_18Sequence) {
            return false;
        }

        if (a_19Sequence != billOfMat.a_19Sequence) {
            return false;
        }

        if (a_20Sequence != billOfMat.a_20Sequence) {
            return false;
        }

        if (a_21Sequence != billOfMat.a_21Sequence) {
            return false;
        }

        if (a_22Sequence != billOfMat.a_22Sequence) {
            return false;
        }

        return true;

    }

}
