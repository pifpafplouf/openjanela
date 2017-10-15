package openjanela.model.entities.design;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-12-12
 *          Time: 10:45 PM
 */
public abstract class ProfileAbstractObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 666375333192794934L;

    private Integer id = 0;

    private int orderId = 0;
    private int itemNo = 0;
    private int versionId = 0;
    private int shapeId = 0;
    private int levelId = 0;
    private int parentId = 0;
    private int sequenceId = 0;
    private int assemblyLevel = 0;
    private int exist = 0;
    private int abcLines = 0;
    private int partForm = 0;
    private int partID = 0;
    private int partShape = 0;
    private int position = 0;
    private int seq = 0;
    private int endTypeLT = 0;
    private int endTypeRB = 0;
    private int myLean = 0;
    private int myLean2 = 0;
    private int myLean3 = 0;
    private int myLean4 = 0;

    private int rID = 0;

    private int rowCol = 0;
    private int continuity = 0;
    private int order = 0;
    private int startPos = 0;
    private int endPos = 0;

    private int orientation = 0;
    private int couplerShapeId = 0;
    private int couplerTypeId = 0;
    private int posCondition = 0;
    private int mType = 0;
    private int whichPos = 0;
    private int typeId = 0;

    private int openingTypeLB = 0;
    private int openingIDLB = 0;
    private int openingTypeRT = 0;
    private int openingIDRT = 0;

    private int color = 0;
    private int colorIn = 0;
    private int colorOut = 0;
    private int rgb_R = 0;
    private int rgb_G = 0;
    private int rgb_B = 0;
    private int rgb_Rin = 0;
    private int rgb_Gin = 0;
    private int rgb_Bin = 0;
    private int rgb_Rout = 0;
    private int rgb_Gout = 0;
    private int rgb_Bout = 0;
    private int rgb_Rt = 0;
    private int rgb_Gt = 0;
    private int rgb_Bt = 0;
    private int transp = 0;
    private int cOrM = 0;
    private int lengthM = 0;
    private int lengthI = 0;
    private int lengthMN = 0;
    private int lengthIN = 0;

    private boolean wire = false;
    private boolean topIn = false;
    private boolean rightIn = false;
    private boolean botIn = false;
    private boolean leftIn = false;
    private boolean posInUse = true;
    private boolean startIn = false;
    private boolean endIn = false;
    private boolean partLeft = false;
    private boolean partRight = false;
    private boolean fixedAngle = false;
    private boolean divideFacet = false;
    private boolean glazedOut = false;
    private boolean removed = false;
    private boolean isValid = false;
    private boolean leftInf = false;
    private boolean rightInf = false;
    private boolean phantom = false;

    private String stockCode = "";

    private BigDecimal bkgrdHeight = new BigDecimal("0");
    private BigDecimal bkgrdHeightA = new BigDecimal("0");
    private BigDecimal bkgrdHeightBA = new BigDecimal("0");
    private BigDecimal bkgrdHeightBC = new BigDecimal("0");
    private BigDecimal bkgrdStartX = new BigDecimal("0");
    private BigDecimal bkgrdStartXA = new BigDecimal("0");
    private BigDecimal bkgrdStartXBA = new BigDecimal("0");
    private BigDecimal bkgrdStartXBC = new BigDecimal("0");
    private BigDecimal bkgrdStartY = new BigDecimal("0");
    private BigDecimal bkgrdStartYA = new BigDecimal("0");
    private BigDecimal bkgrdStartYBA = new BigDecimal("0");
    private BigDecimal bkgrdStartYBC = new BigDecimal("0");
    private BigDecimal bkgrdWidth = new BigDecimal("0");
    private BigDecimal bkgrdWidthA = new BigDecimal("0");
    private BigDecimal bkgrdWidthBA = new BigDecimal("0");
    private BigDecimal bkgrdWidthBC = new BigDecimal("0");
    private BigDecimal centralAngle = new BigDecimal("0");
    private BigDecimal centralAngleA = new BigDecimal("0");
    private BigDecimal centralAngleBA = new BigDecimal("0");
    private BigDecimal centralAngleBC = new BigDecimal("0");
    private BigDecimal dimB1A = new BigDecimal("0");
    private BigDecimal dimB1B = new BigDecimal("0");
    private BigDecimal endAngle = new BigDecimal("0");
    private BigDecimal endAngleA = new BigDecimal("0");
    private BigDecimal endAngleBA = new BigDecimal("0");
    private BigDecimal endAngleBC = new BigDecimal("0");
    private BigDecimal endX = new BigDecimal("0");
    private BigDecimal endXA = new BigDecimal("0");
    private BigDecimal endXC = new BigDecimal("0");
    private BigDecimal endXBA = new BigDecimal("0");
    private BigDecimal endXBC = new BigDecimal("0");
    private BigDecimal endY = new BigDecimal("0");
    private BigDecimal endYA = new BigDecimal("0");
    private BigDecimal endYC = new BigDecimal("0");
    private BigDecimal endYBA = new BigDecimal("0");
    private BigDecimal endYBC = new BigDecimal("0");
    private BigDecimal focal1X = new BigDecimal("0");
    private BigDecimal focal1XA = new BigDecimal("0");
    private BigDecimal focal1XBA = new BigDecimal("0");
    private BigDecimal focal1XBC = new BigDecimal("0");
    private BigDecimal focal1Y = new BigDecimal("0");
    private BigDecimal focal1YA = new BigDecimal("0");
    private BigDecimal focal1YBA = new BigDecimal("0");
    private BigDecimal focal1YBC = new BigDecimal("0");
    private BigDecimal focal2X = new BigDecimal("0");
    private BigDecimal focal2XA = new BigDecimal("0");
    private BigDecimal focal2XBA = new BigDecimal("0");
    private BigDecimal focal2XBC = new BigDecimal("0");
    private BigDecimal focal2Y = new BigDecimal("0");
    private BigDecimal focal2YA = new BigDecimal("0");
    private BigDecimal focal2YBA = new BigDecimal("0");
    private BigDecimal focal2YBC = new BigDecimal("0");
    private BigDecimal glazingDepth = new BigDecimal("0");
    private BigDecimal inLaminateArea = new BigDecimal("0");
    private BigDecimal inPaintArea = new BigDecimal("0");
    private BigDecimal length = new BigDecimal("0");
    private BigDecimal lengthA = new BigDecimal("0");
    private BigDecimal lengthBA = new BigDecimal("0");
    private BigDecimal lengthBC = new BigDecimal("0");
    private BigDecimal ltAngle = new BigDecimal("0");
    private BigDecimal ltAngleA = new BigDecimal("0");
    private BigDecimal ltAngleBA = new BigDecimal("0");
    private BigDecimal ltAngleBC = new BigDecimal("0");
    private BigDecimal mitreLengthLT = new BigDecimal("0");
    private BigDecimal mitreLengthRB = new BigDecimal("0");
    private BigDecimal myWidth = new BigDecimal("0");
    private BigDecimal myWidthA = new BigDecimal("0");
    private BigDecimal myWidthBA = new BigDecimal("0");
    private BigDecimal newX = new BigDecimal("0");
    private BigDecimal newXA = new BigDecimal("0");
    private BigDecimal newY = new BigDecimal("0");
    private BigDecimal newYA = new BigDecimal("0");
    private BigDecimal outLaminateArea = new BigDecimal("0");
    private BigDecimal outPaintArea = new BigDecimal("0");
    private BigDecimal partDimA = new BigDecimal("0");
    private BigDecimal partDimA2 = new BigDecimal("0");
    private BigDecimal partDimAi = new BigDecimal("0");
    private BigDecimal partDimB = new BigDecimal("0");
    private BigDecimal partDimB2 = new BigDecimal("0");
    private BigDecimal partDimBi = new BigDecimal("0");
    private BigDecimal partDimC = new BigDecimal("0");
    private BigDecimal partDimC2 = new BigDecimal("0");
    private BigDecimal partDimCi = new BigDecimal("0");
    private BigDecimal partDimD = new BigDecimal("0");
    private BigDecimal partDimDi = new BigDecimal("0");
    private BigDecimal partDimM = new BigDecimal("0");
    private BigDecimal partDimMi = new BigDecimal("0");
    private BigDecimal partDimBtoC = new BigDecimal("0");
    private BigDecimal partDimBtoCI = new BigDecimal("0");
    private BigDecimal radianCentralAngle = new BigDecimal("0");
    private BigDecimal radius1 = new BigDecimal("0");
    private BigDecimal radius1A = new BigDecimal("0");
    private BigDecimal radius1BA = new BigDecimal("0");
    private BigDecimal radius1BC = new BigDecimal("0");
    private BigDecimal radius2 = new BigDecimal("0");
    private BigDecimal radius2A = new BigDecimal("0");
    private BigDecimal radius2BA = new BigDecimal("0");
    private BigDecimal radius2BC = new BigDecimal("0");
    private BigDecimal radsStart = new BigDecimal("0");
    private BigDecimal radsStart2 = new BigDecimal("0");
    private BigDecimal radsStart2A = new BigDecimal("0");
    private BigDecimal radsStart2BA = new BigDecimal("0");
    private BigDecimal radsStartA = new BigDecimal("0");
    private BigDecimal radsStartBA = new BigDecimal("0");
    private BigDecimal rbAngle = new BigDecimal("0");
    private BigDecimal rbAngleA = new BigDecimal("0");
    private BigDecimal rbAngleBA = new BigDecimal("0");
    private BigDecimal rbAngleBC = new BigDecimal("0");
    private BigDecimal rlAngle = new BigDecimal("0");
    private BigDecimal rlAngleA = new BigDecimal("0");
    private BigDecimal rlAngleBA = new BigDecimal("0");
    private BigDecimal rlSlope = new BigDecimal("0");
    private BigDecimal rlSlopeA = new BigDecimal("0");
    private BigDecimal rlSlopeBA = new BigDecimal("0");
    private BigDecimal rrAngle = new BigDecimal("0");
    private BigDecimal rrAngleA = new BigDecimal("0");
    private BigDecimal rrAngleBA = new BigDecimal("0");
    private BigDecimal rrSlope = new BigDecimal("0");
    private BigDecimal rrSlopeA = new BigDecimal("0");
    private BigDecimal rrSlopeBA = new BigDecimal("0");
    private BigDecimal slope = new BigDecimal("0");
    private BigDecimal slopeA = new BigDecimal("0");
    private BigDecimal slopeBA = new BigDecimal("0");
    private BigDecimal slopeBC = new BigDecimal("0");
    private BigDecimal startAngle = new BigDecimal("0");
    private BigDecimal startAngleA = new BigDecimal("0");
    private BigDecimal startAngleBA = new BigDecimal("0");
    private BigDecimal startAngleBC = new BigDecimal("0");
    private BigDecimal startingX = new BigDecimal("0");
    private BigDecimal startingXA = new BigDecimal("0");
    private BigDecimal startingXBA = new BigDecimal("0");
    private BigDecimal startingXBC = new BigDecimal("0");
    private BigDecimal startingY = new BigDecimal("0");
    private BigDecimal startingYA = new BigDecimal("0");
    private BigDecimal startingYBA = new BigDecimal("0");
    private BigDecimal startingYBC = new BigDecimal("0");
    private BigDecimal startX = new BigDecimal("0");
    private BigDecimal startXC = new BigDecimal("0");
    private BigDecimal startXA = new BigDecimal("0");
    private BigDecimal startXBA = new BigDecimal("0");
    private BigDecimal startXBC = new BigDecimal("0");
    private BigDecimal startY = new BigDecimal("0");
    private BigDecimal startYC = new BigDecimal("0");
    private BigDecimal startYA = new BigDecimal("0");
    private BigDecimal startYBA = new BigDecimal("0");
    private BigDecimal startYBC = new BigDecimal("0");
    private BigDecimal stopAeX = new BigDecimal("0");
    private BigDecimal stopAeY = new BigDecimal("0");
    private BigDecimal stopAsX = new BigDecimal("0");
    private BigDecimal stopAsY = new BigDecimal("0");
    private BigDecimal totalDepth = new BigDecimal("0");
    private BigDecimal totalSurfaceArea = new BigDecimal("0");
    private BigDecimal x1 = new BigDecimal("0");
    private BigDecimal x1A = new BigDecimal("0");
    private BigDecimal x1BA = new BigDecimal("0");
    private BigDecimal x1BC = new BigDecimal("0");
    private BigDecimal x2 = new BigDecimal("0");
    private BigDecimal x2A = new BigDecimal("0");
    private BigDecimal x2BA = new BigDecimal("0");
    private BigDecimal x2BC = new BigDecimal("0");
    private BigDecimal y1 = new BigDecimal("0");
    private BigDecimal y1A = new BigDecimal("0");
    private BigDecimal y1BA = new BigDecimal("0");
    private BigDecimal y1BC = new BigDecimal("0");
    private BigDecimal y2 = new BigDecimal("0");
    private BigDecimal y2A = new BigDecimal("0");
    private BigDecimal y2BA = new BigDecimal("0");
    private BigDecimal y2BC = new BigDecimal("0");
    private BigDecimal x3 = new BigDecimal("0");
    private BigDecimal x3A = new BigDecimal("0");
    private BigDecimal x3BA = new BigDecimal("0");
    private BigDecimal x3BC = new BigDecimal("0");
    private BigDecimal x4 = new BigDecimal("0");
    private BigDecimal x4A = new BigDecimal("0");
    private BigDecimal x4BA = new BigDecimal("0");
    private BigDecimal x4BC = new BigDecimal("0");
    private BigDecimal y3 = new BigDecimal("0");
    private BigDecimal y3A = new BigDecimal("0");
    private BigDecimal y3BA = new BigDecimal("0");
    private BigDecimal y3BC = new BigDecimal("0");
    private BigDecimal y4 = new BigDecimal("0");
    private BigDecimal y4A = new BigDecimal("0");
    private BigDecimal y4BA = new BigDecimal("0");
    private BigDecimal y4BC = new BigDecimal("0");
    private BigDecimal parentW = new BigDecimal("0");
    private BigDecimal centerStartX = new BigDecimal("0");
    private BigDecimal centerStartY = new BigDecimal("0");
    private BigDecimal centerEndX = new BigDecimal("0");
    private BigDecimal centerEndY = new BigDecimal("0");
    private BigDecimal centerXsa = new BigDecimal("0");
    private BigDecimal centerYsa = new BigDecimal("0");
    private BigDecimal centerXea = new BigDecimal("0");
    private BigDecimal centerYea = new BigDecimal("0");
    private BigDecimal x1a = new BigDecimal("0");
    private BigDecimal x1b = new BigDecimal("0");
    private BigDecimal x1a3 = new BigDecimal("0");
    private BigDecimal y1a = new BigDecimal("0");
    private BigDecimal y1b = new BigDecimal("0");
    private BigDecimal y1a3 = new BigDecimal("0");
    private BigDecimal x2a = new BigDecimal("0");
    private BigDecimal x2b = new BigDecimal("0");
    private BigDecimal x2a3 = new BigDecimal("0");
    private BigDecimal y2a = new BigDecimal("0");
    private BigDecimal y2b = new BigDecimal("0");
    private BigDecimal y2a3 = new BigDecimal("0");
    private BigDecimal x3a = new BigDecimal("0");
    private BigDecimal x3b = new BigDecimal("0");
    private BigDecimal x3a3 = new BigDecimal("0");
    private BigDecimal y3a = new BigDecimal("0");
    private BigDecimal y3b = new BigDecimal("0");
    private BigDecimal y3a3 = new BigDecimal("0");
    private BigDecimal x4a = new BigDecimal("0");
    private BigDecimal x4b = new BigDecimal("0");
    private BigDecimal x4a3 = new BigDecimal("0");
    private BigDecimal y4a = new BigDecimal("0");
    private BigDecimal y4b = new BigDecimal("0");
    private BigDecimal y4a3 = new BigDecimal("0");
    private BigDecimal ycs = new BigDecimal("0");
    private BigDecimal yce = new BigDecimal("0");
    private BigDecimal xcs = new BigDecimal("0");
    private BigDecimal xce = new BigDecimal("0");
    private BigDecimal x1al = new BigDecimal("0");
    private BigDecimal y1al = new BigDecimal("0");
    private BigDecimal x2cl = new BigDecimal("0");
    private BigDecimal y2cl = new BigDecimal("0");
    private BigDecimal x3cl = new BigDecimal("0");
    private BigDecimal y3cl = new BigDecimal("0");
    private BigDecimal x4al = new BigDecimal("0");
    private BigDecimal y4al = new BigDecimal("0");
    private BigDecimal centerXs = new BigDecimal("0");
    private BigDecimal centerYs = new BigDecimal("0");
    private BigDecimal centerXe = new BigDecimal("0");
    private BigDecimal centerYe = new BigDecimal("0");
    private BigDecimal thickness = new BigDecimal("0");
    private BigDecimal angle = new BigDecimal("0");
    private BigDecimal minAngle = new BigDecimal("0");
    private BigDecimal maxAngle = new BigDecimal("0");
    private BigDecimal centralAnglec = new BigDecimal("0");
    private BigDecimal centralAnglec1 = new BigDecimal("0");
    private BigDecimal centralAnglea1 = new BigDecimal("0");
    private BigDecimal centralAnglea = new BigDecimal("0");
    private BigDecimal radius1c = new BigDecimal("0");
    private BigDecimal radius1c1 = new BigDecimal("0");
    private BigDecimal radius1a1 = new BigDecimal("0");
    private BigDecimal radius1a = new BigDecimal("0");
    private BigDecimal arcH = new BigDecimal("0");
    private BigDecimal startAnglec = new BigDecimal("0");
    private BigDecimal endAnglec = new BigDecimal("0");
    private BigDecimal startAnglec1 = new BigDecimal("0");
    private BigDecimal endAnglec1 = new BigDecimal("0");
    private BigDecimal startAnglea1 = new BigDecimal("0");
    private BigDecimal endAnglea1 = new BigDecimal("0");
    private BigDecimal startAnglea = new BigDecimal("0");
    private BigDecimal endAnglea = new BigDecimal("0");
    private BigDecimal angleTLa = new BigDecimal("0");
    private BigDecimal angleBLa = new BigDecimal("0");
    private BigDecimal angleTRc = new BigDecimal("0");
    private BigDecimal angleBRc = new BigDecimal("0");
    private BigDecimal offsetTL = new BigDecimal("0");
    private BigDecimal offsetRB = new BigDecimal("0");
    private BigDecimal deltaTL = new BigDecimal("0");
    private BigDecimal deltaRB = new BigDecimal("0");
    private BigDecimal curveCenterTL = new BigDecimal("0");
    private BigDecimal curveCenterRB = new BigDecimal("0");
    private BigDecimal levelW = new BigDecimal("0");
    private BigDecimal levelH = new BigDecimal("0");

    private int supplierId;
    private boolean remote;

    /**
     * Represents a sequence collection save
     */
    private int _sequence = 0;

    /**
     * Construction Map levels and sequence
     */
    private ConstructionMap constructionMap;

    /**
     * Collection parts notching
     */
    private Set<PartsNotchingEntityObject> partsNotching;

    /**
     * Collection shape options
     */
    private Set<ShapeOptionEntityObject> options;

    /**
     * Collection bill of materials
     */
    private Set<BillOfMaterialEntityObject> boms;

    /**
     * Collection Shape Notes
     */
    private Set<ShapeNotesEntityObject> notes;

    // ==================================<METODOS GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getAssemblyLevel() {
        return assemblyLevel;
    }

    public void setAssemblyLevel(int assemblyLevel) {
        this.assemblyLevel = assemblyLevel;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public int getAbcLines() {
        return abcLines;
    }

    public void setAbcLines(int abcLines) {
        this.abcLines = abcLines;
    }

    public int getPartForm() {
        return partForm;
    }

    public void setPartForm(int partForm) {
        this.partForm = partForm;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getPartShape() {
        return partShape;
    }

    public void setPartShape(int partShape) {
        this.partShape = partShape;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getEndTypeLT() {
        return endTypeLT;
    }

    public void setEndTypeLT(int endTypeLT) {
        this.endTypeLT = endTypeLT;
    }

    public int getEndTypeRB() {
        return endTypeRB;
    }

    public void setEndTypeRB(int endTypeRB) {
        this.endTypeRB = endTypeRB;
    }

    public int getMyLean() {
        return myLean;
    }

    public void setMyLean(int myLean) {
        this.myLean = myLean;
    }

    public int getMyLean2() {
        return myLean2;
    }

    public void setMyLean2(int myLean2) {
        this.myLean2 = myLean2;
    }

    public int getMyLean3() {
        return myLean3;
    }

    public void setMyLean3(int myLean3) {
        this.myLean3 = myLean3;
    }

    public int getMyLean4() {
        return myLean4;
    }

    public void setMyLean4(int myLean4) {
        this.myLean4 = myLean4;
    }

    public BigDecimal getBkgrdHeight() {
        return bkgrdHeight;
    }

    public void setBkgrdHeight(BigDecimal bkgrdHeight) {
        this.bkgrdHeight = bkgrdHeight;
    }

    public BigDecimal getBkgrdHeightA() {
        return bkgrdHeightA;
    }

    public void setBkgrdHeightA(BigDecimal bkgrdHeightA) {
        this.bkgrdHeightA = bkgrdHeightA;
    }

    public BigDecimal getBkgrdHeightBA() {
        return bkgrdHeightBA;
    }

    public void setBkgrdHeightBA(BigDecimal bkgrdHeightBA) {
        this.bkgrdHeightBA = bkgrdHeightBA;
    }

    public BigDecimal getBkgrdHeightBC() {
        return bkgrdHeightBC;
    }

    public void setBkgrdHeightBC(BigDecimal bkgrdHeightBC) {
        this.bkgrdHeightBC = bkgrdHeightBC;
    }

    public BigDecimal getBkgrdStartX() {
        return bkgrdStartX;
    }

    public void setBkgrdStartX(BigDecimal bkgrdStartX) {
        this.bkgrdStartX = bkgrdStartX;
    }

    public BigDecimal getBkgrdStartXA() {
        return bkgrdStartXA;
    }

    public void setBkgrdStartXA(BigDecimal bkgrdStartXA) {
        this.bkgrdStartXA = bkgrdStartXA;
    }

    public BigDecimal getBkgrdStartXBA() {
        return bkgrdStartXBA;
    }

    public void setBkgrdStartXBA(BigDecimal bkgrdStartXBA) {
        this.bkgrdStartXBA = bkgrdStartXBA;
    }

    public BigDecimal getBkgrdStartXBC() {
        return bkgrdStartXBC;
    }

    public void setBkgrdStartXBC(BigDecimal bkgrdStartXBC) {
        this.bkgrdStartXBC = bkgrdStartXBC;
    }

    public BigDecimal getBkgrdStartY() {
        return bkgrdStartY;
    }

    public void setBkgrdStartY(BigDecimal bkgrdStartY) {
        this.bkgrdStartY = bkgrdStartY;
    }

    public BigDecimal getBkgrdStartYA() {
        return bkgrdStartYA;
    }

    public void setBkgrdStartYA(BigDecimal bkgrdStartYA) {
        this.bkgrdStartYA = bkgrdStartYA;
    }

    public BigDecimal getBkgrdStartYBA() {
        return bkgrdStartYBA;
    }

    public void setBkgrdStartYBA(BigDecimal bkgrdStartYBA) {
        this.bkgrdStartYBA = bkgrdStartYBA;
    }

    public BigDecimal getBkgrdStartYBC() {
        return bkgrdStartYBC;
    }

    public void setBkgrdStartYBC(BigDecimal bkgrdStartYBC) {
        this.bkgrdStartYBC = bkgrdStartYBC;
    }

    public BigDecimal getBkgrdWidth() {
        return bkgrdWidth;
    }

    public void setBkgrdWidth(BigDecimal bkgrdWidth) {
        this.bkgrdWidth = bkgrdWidth;
    }

    public BigDecimal getBkgrdWidthA() {
        return bkgrdWidthA;
    }

    public void setBkgrdWidthA(BigDecimal bkgrdWidthA) {
        this.bkgrdWidthA = bkgrdWidthA;
    }

    public BigDecimal getBkgrdWidthBA() {
        return bkgrdWidthBA;
    }

    public void setBkgrdWidthBA(BigDecimal bkgrdWidthBA) {
        this.bkgrdWidthBA = bkgrdWidthBA;
    }

    public BigDecimal getBkgrdWidthBC() {
        return bkgrdWidthBC;
    }

    public void setBkgrdWidthBC(BigDecimal bkgrdWidthBC) {
        this.bkgrdWidthBC = bkgrdWidthBC;
    }

    public BigDecimal getCentralAngle() {
        return centralAngle;
    }

    public void setCentralAngle(BigDecimal centralAngle) {
        this.centralAngle = centralAngle;
    }

    public BigDecimal getCentralAngleA() {
        return centralAngleA;
    }

    public void setCentralAngleA(BigDecimal centralAngleA) {
        this.centralAngleA = centralAngleA;
    }

    public BigDecimal getCentralAngleBA() {
        return centralAngleBA;
    }

    public void setCentralAngleBA(BigDecimal centralAngleBA) {
        this.centralAngleBA = centralAngleBA;
    }

    public BigDecimal getCentralAngleBC() {
        return centralAngleBC;
    }

    public void setCentralAngleBC(BigDecimal centralAngleBC) {
        this.centralAngleBC = centralAngleBC;
    }

    public BigDecimal getDimB1A() {
        return dimB1A;
    }

    public void setDimB1A(BigDecimal dimB1A) {
        this.dimB1A = dimB1A;
    }

    public BigDecimal getDimB1B() {
        return dimB1B;
    }

    public void setDimB1B(BigDecimal dimB1B) {
        this.dimB1B = dimB1B;
    }

    public BigDecimal getEndAngle() {
        return endAngle;
    }

    public void setEndAngle(BigDecimal endAngle) {
        this.endAngle = endAngle;
    }

    public BigDecimal getEndAngleA() {
        return endAngleA;
    }

    public void setEndAngleA(BigDecimal endAngleA) {
        this.endAngleA = endAngleA;
    }

    public BigDecimal getEndAngleBA() {
        return endAngleBA;
    }

    public void setEndAngleBA(BigDecimal endAngleBA) {
        this.endAngleBA = endAngleBA;
    }

    public BigDecimal getEndAngleBC() {
        return endAngleBC;
    }

    public void setEndAngleBC(BigDecimal endAngleBC) {
        this.endAngleBC = endAngleBC;
    }

    public BigDecimal getEndX() {
        return endX;
    }

    public void setEndX(BigDecimal endX) {
        this.endX = endX;
    }

    public BigDecimal getEndXA() {
        return endXA;
    }

    public void setEndXA(BigDecimal endXA) {
        this.endXA = endXA;
    }

    public BigDecimal getEndXC() {
        return endXC;
    }

    public void setEndXC(BigDecimal endXC) {
        this.endXC = endXC;
    }

    public BigDecimal getEndXBA() {
        return endXBA;
    }

    public void setEndXBA(BigDecimal endXBA) {
        this.endXBA = endXBA;
    }

    public BigDecimal getEndXBC() {
        return endXBC;
    }

    public void setEndXBC(BigDecimal endXBC) {
        this.endXBC = endXBC;
    }

    public BigDecimal getEndY() {
        return endY;
    }

    public void setEndY(BigDecimal endY) {
        this.endY = endY;
    }

    public BigDecimal getEndYA() {
        return endYA;
    }

    public void setEndYA(BigDecimal endYA) {
        this.endYA = endYA;
    }

    public BigDecimal getEndYC() {
        return endYC;
    }

    public void setEndYC(BigDecimal endYC) {
        this.endYC = endYC;
    }

    public BigDecimal getEndYBA() {
        return endYBA;
    }

    public void setEndYBA(BigDecimal endYBA) {
        this.endYBA = endYBA;
    }

    public BigDecimal getEndYBC() {
        return endYBC;
    }

    public void setEndYBC(BigDecimal endYBC) {
        this.endYBC = endYBC;
    }

    public BigDecimal getFocal1X() {
        return focal1X;
    }

    public void setFocal1X(BigDecimal focal1X) {
        this.focal1X = focal1X;
    }

    public BigDecimal getFocal1XA() {
        return focal1XA;
    }

    public void setFocal1XA(BigDecimal focal1XA) {
        this.focal1XA = focal1XA;
    }

    public BigDecimal getFocal1XBA() {
        return focal1XBA;
    }

    public void setFocal1XBA(BigDecimal focal1XBA) {
        this.focal1XBA = focal1XBA;
    }

    public BigDecimal getFocal1XBC() {
        return focal1XBC;
    }

    public void setFocal1XBC(BigDecimal focal1XBC) {
        this.focal1XBC = focal1XBC;
    }

    public BigDecimal getFocal1Y() {
        return focal1Y;
    }

    public void setFocal1Y(BigDecimal focal1Y) {
        this.focal1Y = focal1Y;
    }

    public BigDecimal getFocal1YA() {
        return focal1YA;
    }

    public void setFocal1YA(BigDecimal focal1YA) {
        this.focal1YA = focal1YA;
    }

    public BigDecimal getFocal1YBA() {
        return focal1YBA;
    }

    public void setFocal1YBA(BigDecimal focal1YBA) {
        this.focal1YBA = focal1YBA;
    }

    public BigDecimal getFocal1YBC() {
        return focal1YBC;
    }

    public void setFocal1YBC(BigDecimal focal1YBC) {
        this.focal1YBC = focal1YBC;
    }

    public BigDecimal getFocal2X() {
        return focal2X;
    }

    public void setFocal2X(BigDecimal focal2X) {
        this.focal2X = focal2X;
    }

    public BigDecimal getFocal2XA() {
        return focal2XA;
    }

    public void setFocal2XA(BigDecimal focal2XA) {
        this.focal2XA = focal2XA;
    }

    public BigDecimal getFocal2XBA() {
        return focal2XBA;
    }

    public void setFocal2XBA(BigDecimal focal2XBA) {
        this.focal2XBA = focal2XBA;
    }

    public BigDecimal getFocal2XBC() {
        return focal2XBC;
    }

    public void setFocal2XBC(BigDecimal focal2XBC) {
        this.focal2XBC = focal2XBC;
    }

    public BigDecimal getFocal2Y() {
        return focal2Y;
    }

    public void setFocal2Y(BigDecimal focal2Y) {
        this.focal2Y = focal2Y;
    }

    public BigDecimal getFocal2YA() {
        return focal2YA;
    }

    public void setFocal2YA(BigDecimal focal2YA) {
        this.focal2YA = focal2YA;
    }

    public BigDecimal getFocal2YBA() {
        return focal2YBA;
    }

    public void setFocal2YBA(BigDecimal focal2YBA) {
        this.focal2YBA = focal2YBA;
    }

    public BigDecimal getFocal2YBC() {
        return focal2YBC;
    }

    public void setFocal2YBC(BigDecimal focal2YBC) {
        this.focal2YBC = focal2YBC;
    }

    public BigDecimal getGlazingDepth() {
        return glazingDepth;
    }

    public void setGlazingDepth(BigDecimal glazingDepth) {
        this.glazingDepth = glazingDepth;
    }

    public BigDecimal getInLaminateArea() {
        return inLaminateArea;
    }

    public void setInLaminateArea(BigDecimal inLaminateArea) {
        this.inLaminateArea = inLaminateArea;
    }

    public BigDecimal getInPaintArea() {
        return inPaintArea;
    }

    public void setInPaintArea(BigDecimal inPaintArea) {
        this.inPaintArea = inPaintArea;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getLengthA() {
        return lengthA;
    }

    public void setLengthA(BigDecimal lengthA) {
        this.lengthA = lengthA;
    }

    public BigDecimal getLengthBA() {
        return lengthBA;
    }

    public void setLengthBA(BigDecimal lengthBA) {
        this.lengthBA = lengthBA;
    }

    public BigDecimal getLengthBC() {
        return lengthBC;
    }

    public void setLengthBC(BigDecimal lengthBC) {
        this.lengthBC = lengthBC;
    }

    public BigDecimal getLtAngle() {
        return ltAngle;
    }

    public void setLtAngle(BigDecimal ltAngle) {
        this.ltAngle = ltAngle;
    }

    public BigDecimal getLtAngleA() {
        return ltAngleA;
    }

    public void setLtAngleA(BigDecimal ltAngleA) {
        this.ltAngleA = ltAngleA;
    }

    public BigDecimal getLtAngleBA() {
        return ltAngleBA;
    }

    public void setLtAngleBA(BigDecimal ltAngleBA) {
        this.ltAngleBA = ltAngleBA;
    }

    public BigDecimal getLtAngleBC() {
        return ltAngleBC;
    }

    public void setLtAngleBC(BigDecimal ltAngleBC) {
        this.ltAngleBC = ltAngleBC;
    }

    public BigDecimal getMitreLengthLT() {
        return mitreLengthLT;
    }

    public void setMitreLengthLT(BigDecimal mitreLengthLT) {
        this.mitreLengthLT = mitreLengthLT;
    }

    public BigDecimal getMitreLengthRB() {
        return mitreLengthRB;
    }

    public void setMitreLengthRB(BigDecimal mitreLengthRB) {
        this.mitreLengthRB = mitreLengthRB;
    }

    public BigDecimal getMyWidth() {
        return myWidth;
    }

    public void setMyWidth(BigDecimal myWidth) {
        this.myWidth = myWidth;
    }

    public BigDecimal getMyWidthA() {
        return myWidthA;
    }

    public void setMyWidthA(BigDecimal myWidthA) {
        this.myWidthA = myWidthA;
    }

    public BigDecimal getMyWidthBA() {
        return myWidthBA;
    }

    public void setMyWidthBA(BigDecimal myWidthBA) {
        this.myWidthBA = myWidthBA;
    }

    public BigDecimal getNewX() {
        return newX;
    }

    public void setNewX(BigDecimal newX) {
        this.newX = newX;
    }

    public BigDecimal getNewXA() {
        return newXA;
    }

    public void setNewXA(BigDecimal newXA) {
        this.newXA = newXA;
    }

    public BigDecimal getNewY() {
        return newY;
    }

    public void setNewY(BigDecimal newY) {
        this.newY = newY;
    }

    public BigDecimal getNewYA() {
        return newYA;
    }

    public void setNewYA(BigDecimal newYA) {
        this.newYA = newYA;
    }

    public BigDecimal getOutLaminateArea() {
        return outLaminateArea;
    }

    public void setOutLaminateArea(BigDecimal outLaminateArea) {
        this.outLaminateArea = outLaminateArea;
    }

    public BigDecimal getOutPaintArea() {
        return outPaintArea;
    }

    public void setOutPaintArea(BigDecimal outPaintArea) {
        this.outPaintArea = outPaintArea;
    }

    public BigDecimal getPartDimA() {
        return partDimA;
    }

    public void setPartDimA(BigDecimal partDimA) {
        this.partDimA = partDimA;
    }

    public BigDecimal getPartDimA2() {
        return partDimA2;
    }

    public void setPartDimA2(BigDecimal partDimA2) {
        this.partDimA2 = partDimA2;
    }

    public BigDecimal getPartDimAi() {
        return partDimAi;
    }

    public void setPartDimAi(BigDecimal partDimAi) {
        this.partDimAi = partDimAi;
    }

    public BigDecimal getPartDimB() {
        return partDimB;
    }

    public void setPartDimB(BigDecimal partDimB) {
        this.partDimB = partDimB;
    }

    public BigDecimal getPartDimB2() {
        return partDimB2;
    }

    public void setPartDimB2(BigDecimal partDimB2) {
        this.partDimB2 = partDimB2;
    }

    public BigDecimal getPartDimBi() {
        return partDimBi;
    }

    public void setPartDimBi(BigDecimal partDimBi) {
        this.partDimBi = partDimBi;
    }

    public BigDecimal getPartDimC() {
        return partDimC;
    }

    public void setPartDimC(BigDecimal partDimC) {
        this.partDimC = partDimC;
    }

    public BigDecimal getPartDimC2() {
        return partDimC2;
    }

    public void setPartDimC2(BigDecimal partDimC2) {
        this.partDimC2 = partDimC2;
    }

    public BigDecimal getPartDimCi() {
        return partDimCi;
    }

    public void setPartDimCi(BigDecimal partDimCi) {
        this.partDimCi = partDimCi;
    }

    public BigDecimal getPartDimD() {
        return partDimD;
    }

    public void setPartDimD(BigDecimal partDimD) {
        this.partDimD = partDimD;
    }

    public BigDecimal getPartDimDi() {
        return partDimDi;
    }

    public void setPartDimDi(BigDecimal partDimDi) {
        this.partDimDi = partDimDi;
    }

    public BigDecimal getPartDimM() {
        return partDimM;
    }

    public void setPartDimM(BigDecimal partDimM) {
        this.partDimM = partDimM;
    }

    public BigDecimal getPartDimMi() {
        return partDimMi;
    }

    public void setPartDimMi(BigDecimal partDimMi) {
        this.partDimMi = partDimMi;
    }

    public BigDecimal getPartDimBtoC() {
        return partDimBtoC;
    }

    public void setPartDimBtoC(BigDecimal partDimBtoC) {
        this.partDimBtoC = partDimBtoC;
    }

    public BigDecimal getPartDimBtoCI() {
        return partDimBtoCI;
    }

    public void setPartDimBtoCI(BigDecimal partDimBtoCI) {
        this.partDimBtoCI = partDimBtoCI;
    }

    public BigDecimal getRadianCentralAngle() {
        return radianCentralAngle;
    }

    public void setRadianCentralAngle(BigDecimal radianCentralAngle) {
        this.radianCentralAngle = radianCentralAngle;
    }

    public BigDecimal getRadius1() {
        return radius1;
    }

    public void setRadius1(BigDecimal radius1) {
        this.radius1 = radius1;
    }

    public BigDecimal getRadius1A() {
        return radius1A;
    }

    public void setRadius1A(BigDecimal radius1A) {
        this.radius1A = radius1A;
    }

    public BigDecimal getRadius1BA() {
        return radius1BA;
    }

    public void setRadius1BA(BigDecimal radius1BA) {
        this.radius1BA = radius1BA;
    }

    public BigDecimal getRadius1BC() {
        return radius1BC;
    }

    public void setRadius1BC(BigDecimal radius1BC) {
        this.radius1BC = radius1BC;
    }

    public BigDecimal getRadius2() {
        return radius2;
    }

    public void setRadius2(BigDecimal radius2) {
        this.radius2 = radius2;
    }

    public BigDecimal getRadius2A() {
        return radius2A;
    }

    public void setRadius2A(BigDecimal radius2A) {
        this.radius2A = radius2A;
    }

    public BigDecimal getRadius2BA() {
        return radius2BA;
    }

    public void setRadius2BA(BigDecimal radius2BA) {
        this.radius2BA = radius2BA;
    }

    public BigDecimal getRadius2BC() {
        return radius2BC;
    }

    public void setRadius2BC(BigDecimal radius2BC) {
        this.radius2BC = radius2BC;
    }

    public BigDecimal getRadsStart() {
        return radsStart;
    }

    public void setRadsStart(BigDecimal radsStart) {
        this.radsStart = radsStart;
    }

    public BigDecimal getRadsStart2() {
        return radsStart2;
    }

    public void setRadsStart2(BigDecimal radsStart2) {
        this.radsStart2 = radsStart2;
    }

    public BigDecimal getRadsStart2A() {
        return radsStart2A;
    }

    public void setRadsStart2A(BigDecimal radsStart2A) {
        this.radsStart2A = radsStart2A;
    }

    public BigDecimal getRadsStart2BA() {
        return radsStart2BA;
    }

    public void setRadsStart2BA(BigDecimal radsStart2BA) {
        this.radsStart2BA = radsStart2BA;
    }

    public BigDecimal getRadsStartA() {
        return radsStartA;
    }

    public void setRadsStartA(BigDecimal radsStartA) {
        this.radsStartA = radsStartA;
    }

    public BigDecimal getRadsStartBA() {
        return radsStartBA;
    }

    public void setRadsStartBA(BigDecimal radsStartBA) {
        this.radsStartBA = radsStartBA;
    }

    public BigDecimal getRbAngle() {
        return rbAngle;
    }

    public void setRbAngle(BigDecimal rbAngle) {
        this.rbAngle = rbAngle;
    }

    public BigDecimal getRbAngleA() {
        return rbAngleA;
    }

    public void setRbAngleA(BigDecimal rbAngleA) {
        this.rbAngleA = rbAngleA;
    }

    public BigDecimal getRbAngleBA() {
        return rbAngleBA;
    }

    public void setRbAngleBA(BigDecimal rbAngleBA) {
        this.rbAngleBA = rbAngleBA;
    }

    public BigDecimal getRbAngleBC() {
        return rbAngleBC;
    }

    public void setRbAngleBC(BigDecimal rbAngleBC) {
        this.rbAngleBC = rbAngleBC;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public BigDecimal getRlAngle() {
        return rlAngle;
    }

    public void setRlAngle(BigDecimal rlAngle) {
        this.rlAngle = rlAngle;
    }

    public BigDecimal getRlAngleA() {
        return rlAngleA;
    }

    public void setRlAngleA(BigDecimal rlAngleA) {
        this.rlAngleA = rlAngleA;
    }

    public BigDecimal getRlAngleBA() {
        return rlAngleBA;
    }

    public void setRlAngleBA(BigDecimal rlAngleBA) {
        this.rlAngleBA = rlAngleBA;
    }

    public BigDecimal getRlSlope() {
        return rlSlope;
    }

    public void setRlSlope(BigDecimal rlSlope) {
        this.rlSlope = rlSlope;
    }

    public BigDecimal getRlSlopeA() {
        return rlSlopeA;
    }

    public void setRlSlopeA(BigDecimal rlSlopeA) {
        this.rlSlopeA = rlSlopeA;
    }

    public BigDecimal getRlSlopeBA() {
        return rlSlopeBA;
    }

    public void setRlSlopeBA(BigDecimal rlSlopeBA) {
        this.rlSlopeBA = rlSlopeBA;
    }

    public BigDecimal getRrAngle() {
        return rrAngle;
    }

    public void setRrAngle(BigDecimal rrAngle) {
        this.rrAngle = rrAngle;
    }

    public BigDecimal getRrAngleA() {
        return rrAngleA;
    }

    public void setRrAngleA(BigDecimal rrAngleA) {
        this.rrAngleA = rrAngleA;
    }

    public BigDecimal getRrAngleBA() {
        return rrAngleBA;
    }

    public void setRrAngleBA(BigDecimal rrAngleBA) {
        this.rrAngleBA = rrAngleBA;
    }

    public BigDecimal getRrSlope() {
        return rrSlope;
    }

    public void setRrSlope(BigDecimal rrSlope) {
        this.rrSlope = rrSlope;
    }

    public BigDecimal getRrSlopeA() {
        return rrSlopeA;
    }

    public void setRrSlopeA(BigDecimal rrSlopeA) {
        this.rrSlopeA = rrSlopeA;
    }

    public BigDecimal getRrSlopeBA() {
        return rrSlopeBA;
    }

    public void setRrSlopeBA(BigDecimal rrSlopeBA) {
        this.rrSlopeBA = rrSlopeBA;
    }

    public BigDecimal getSlope() {
        return slope;
    }

    public void setSlope(BigDecimal slope) {
        this.slope = slope;
    }

    public BigDecimal getSlopeA() {
        return slopeA;
    }

    public void setSlopeA(BigDecimal slopeA) {
        this.slopeA = slopeA;
    }

    public BigDecimal getSlopeBA() {
        return slopeBA;
    }

    public void setSlopeBA(BigDecimal slopeBA) {
        this.slopeBA = slopeBA;
    }

    public BigDecimal getSlopeBC() {
        return slopeBC;
    }

    public void setSlopeBC(BigDecimal slopeBC) {
        this.slopeBC = slopeBC;
    }

    public BigDecimal getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(BigDecimal startAngle) {
        this.startAngle = startAngle;
    }

    public BigDecimal getStartAngleA() {
        return startAngleA;
    }

    public void setStartAngleA(BigDecimal startAngleA) {
        this.startAngleA = startAngleA;
    }

    public BigDecimal getStartAngleBA() {
        return startAngleBA;
    }

    public void setStartAngleBA(BigDecimal startAngleBA) {
        this.startAngleBA = startAngleBA;
    }

    public BigDecimal getStartAngleBC() {
        return startAngleBC;
    }

    public void setStartAngleBC(BigDecimal startAngleBC) {
        this.startAngleBC = startAngleBC;
    }

    public BigDecimal getStartingX() {
        return startingX;
    }

    public void setStartingX(BigDecimal startingX) {
        this.startingX = startingX;
    }

    public BigDecimal getStartingXA() {
        return startingXA;
    }

    public void setStartingXA(BigDecimal startingXA) {
        this.startingXA = startingXA;
    }

    public BigDecimal getStartingXBA() {
        return startingXBA;
    }

    public void setStartingXBA(BigDecimal startingXBA) {
        this.startingXBA = startingXBA;
    }

    public BigDecimal getStartingXBC() {
        return startingXBC;
    }

    public void setStartingXBC(BigDecimal startingXBC) {
        this.startingXBC = startingXBC;
    }

    public BigDecimal getStartingY() {
        return startingY;
    }

    public void setStartingY(BigDecimal startingY) {
        this.startingY = startingY;
    }

    public BigDecimal getStartingYA() {
        return startingYA;
    }

    public void setStartingYA(BigDecimal startingYA) {
        this.startingYA = startingYA;
    }

    public BigDecimal getStartingYBA() {
        return startingYBA;
    }

    public void setStartingYBA(BigDecimal startingYBA) {
        this.startingYBA = startingYBA;
    }

    public BigDecimal getStartingYBC() {
        return startingYBC;
    }

    public void setStartingYBC(BigDecimal startingYBC) {
        this.startingYBC = startingYBC;
    }

    public BigDecimal getStartX() {
        return startX;
    }

    public void setStartX(BigDecimal startX) {
        this.startX = startX;
    }

    public BigDecimal getStartXC() {
        return startXC;
    }

    public void setStartXC(BigDecimal startXC) {
        this.startXC = startXC;
    }

    public BigDecimal getStartXA() {
        return startXA;
    }

    public void setStartXA(BigDecimal startXA) {
        this.startXA = startXA;
    }

    public BigDecimal getStartXBA() {
        return startXBA;
    }

    public void setStartXBA(BigDecimal startXBA) {
        this.startXBA = startXBA;
    }

    public BigDecimal getStartXBC() {
        return startXBC;
    }

    public void setStartXBC(BigDecimal startXBC) {
        this.startXBC = startXBC;
    }

    public BigDecimal getStartY() {
        return startY;
    }

    public void setStartY(BigDecimal startY) {
        this.startY = startY;
    }

    public BigDecimal getStartYC() {
        return startYC;
    }

    public void setStartYC(BigDecimal startYC) {
        this.startYC = startYC;
    }

    public BigDecimal getStartYA() {
        return startYA;
    }

    public void setStartYA(BigDecimal startYA) {
        this.startYA = startYA;
    }

    public BigDecimal getStartYBA() {
        return startYBA;
    }

    public void setStartYBA(BigDecimal startYBA) {
        this.startYBA = startYBA;
    }

    public BigDecimal getStartYBC() {
        return startYBC;
    }

    public void setStartYBC(BigDecimal startYBC) {
        this.startYBC = startYBC;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public BigDecimal getStopAeX() {
        return stopAeX;
    }

    public void setStopAeX(BigDecimal stopAeX) {
        this.stopAeX = stopAeX;
    }

    public BigDecimal getStopAeY() {
        return stopAeY;
    }

    public void setStopAeY(BigDecimal stopAeY) {
        this.stopAeY = stopAeY;
    }

    public BigDecimal getStopAsX() {
        return stopAsX;
    }

    public void setStopAsX(BigDecimal stopAsX) {
        this.stopAsX = stopAsX;
    }

    public BigDecimal getStopAsY() {
        return stopAsY;
    }

    public void setStopAsY(BigDecimal stopAsY) {
        this.stopAsY = stopAsY;
    }

    public BigDecimal getTotalDepth() {
        return totalDepth;
    }

    public void setTotalDepth(BigDecimal totalDepth) {
        this.totalDepth = totalDepth;
    }

    public BigDecimal getTotalSurfaceArea() {
        return totalSurfaceArea;
    }

    public void setTotalSurfaceArea(BigDecimal totalSurfaceArea) {
        this.totalSurfaceArea = totalSurfaceArea;
    }

    public boolean isWire() {
        return wire;
    }

    public void setWire(boolean wire) {
        this.wire = wire;
    }

    public BigDecimal getX1() {
        return x1;
    }

    public void setX1(BigDecimal x1) {
        this.x1 = x1;
    }

    public BigDecimal getX1A() {
        return x1A;
    }

    public void setX1A(BigDecimal x1A) {
        this.x1A = x1A;
    }

    public BigDecimal getX1BA() {
        return x1BA;
    }

    public void setX1BA(BigDecimal x1BA) {
        this.x1BA = x1BA;
    }

    public BigDecimal getX1BC() {
        return x1BC;
    }

    public void setX1BC(BigDecimal x1BC) {
        this.x1BC = x1BC;
    }

    public BigDecimal getX2() {
        return x2;
    }

    public void setX2(BigDecimal x2) {
        this.x2 = x2;
    }

    public BigDecimal getX2A() {
        return x2A;
    }

    public void setX2A(BigDecimal x2A) {
        this.x2A = x2A;
    }

    public BigDecimal getX2BA() {
        return x2BA;
    }

    public void setX2BA(BigDecimal x2BA) {
        this.x2BA = x2BA;
    }

    public BigDecimal getX2BC() {
        return x2BC;
    }

    public void setX2BC(BigDecimal x2BC) {
        this.x2BC = x2BC;
    }

    public BigDecimal getY1() {
        return y1;
    }

    public void setY1(BigDecimal y1) {
        this.y1 = y1;
    }

    public BigDecimal getY1A() {
        return y1A;
    }

    public void setY1A(BigDecimal y1A) {
        this.y1A = y1A;
    }

    public BigDecimal getY1BA() {
        return y1BA;
    }

    public void setY1BA(BigDecimal y1BA) {
        this.y1BA = y1BA;
    }

    public BigDecimal getY1BC() {
        return y1BC;
    }

    public void setY1BC(BigDecimal y1BC) {
        this.y1BC = y1BC;
    }

    public BigDecimal getY2() {
        return y2;
    }

    public void setY2(BigDecimal y2) {
        this.y2 = y2;
    }

    public BigDecimal getY2A() {
        return y2A;
    }

    public void setY2A(BigDecimal y2A) {
        this.y2A = y2A;
    }

    public BigDecimal getY2BA() {
        return y2BA;
    }

    public void setY2BA(BigDecimal y2BA) {
        this.y2BA = y2BA;
    }

    public BigDecimal getY2BC() {
        return y2BC;
    }

    public void setY2BC(BigDecimal y2BC) {
        this.y2BC = y2BC;
    }

    public BigDecimal getX3() {
        return x3;
    }

    public void setX3(BigDecimal x3) {
        this.x3 = x3;
    }

    public BigDecimal getX3A() {
        return x3A;
    }

    public void setX3A(BigDecimal x3A) {
        this.x3A = x3A;
    }

    public BigDecimal getX3BA() {
        return x3BA;
    }

    public void setX3BA(BigDecimal x3BA) {
        this.x3BA = x3BA;
    }

    public BigDecimal getX3BC() {
        return x3BC;
    }

    public void setX3BC(BigDecimal x3BC) {
        this.x3BC = x3BC;
    }

    public BigDecimal getX4() {
        return x4;
    }

    public void setX4(BigDecimal x4) {
        this.x4 = x4;
    }

    public BigDecimal getX4A() {
        return x4A;
    }

    public void setX4A(BigDecimal x4A) {
        this.x4A = x4A;
    }

    public BigDecimal getX4BA() {
        return x4BA;
    }

    public void setX4BA(BigDecimal x4BA) {
        this.x4BA = x4BA;
    }

    public BigDecimal getX4BC() {
        return x4BC;
    }

    public void setX4BC(BigDecimal x4BC) {
        this.x4BC = x4BC;
    }

    public BigDecimal getY3() {
        return y3;
    }

    public void setY3(BigDecimal y3) {
        this.y3 = y3;
    }

    public BigDecimal getY3A() {
        return y3A;
    }

    public void setY3A(BigDecimal y3A) {
        this.y3A = y3A;
    }

    public BigDecimal getY3BA() {
        return y3BA;
    }

    public void setY3BA(BigDecimal y3BA) {
        this.y3BA = y3BA;
    }

    public BigDecimal getY3BC() {
        return y3BC;
    }

    public void setY3BC(BigDecimal y3BC) {
        this.y3BC = y3BC;
    }

    public BigDecimal getY4() {
        return y4;
    }

    public void setY4(BigDecimal y4) {
        this.y4 = y4;
    }

    public BigDecimal getY4A() {
        return y4A;
    }

    public void setY4A(BigDecimal y4A) {
        this.y4A = y4A;
    }

    public BigDecimal getY4BA() {
        return y4BA;
    }

    public void setY4BA(BigDecimal y4BA) {
        this.y4BA = y4BA;
    }

    public BigDecimal getY4BC() {
        return y4BC;
    }

    public void setY4BC(BigDecimal y4BC) {
        this.y4BC = y4BC;
    }

    public BigDecimal getParentW() {
        return parentW;
    }

    public void setParentW(BigDecimal parentW) {
        this.parentW = parentW;
    }

    public BigDecimal getCenterStartX() {
        return centerStartX;
    }

    public void setCenterStartX(BigDecimal centerStartX) {
        this.centerStartX = centerStartX;
    }

    public BigDecimal getCenterStartY() {
        return centerStartY;
    }

    public void setCenterStartY(BigDecimal centerStartY) {
        this.centerStartY = centerStartY;
    }

    public BigDecimal getCenterEndX() {
        return centerEndX;
    }

    public void setCenterEndX(BigDecimal centerEndX) {
        this.centerEndX = centerEndX;
    }

    public BigDecimal getCenterEndY() {
        return centerEndY;
    }

    public void setCenterEndY(BigDecimal centerEndY) {
        this.centerEndY = centerEndY;
    }

    public boolean isTopIn() {
        return topIn;
    }

    public void setTopIn(boolean topIn) {
        this.topIn = topIn;
    }

    public boolean isRightIn() {
        return rightIn;
    }

    public void setRightIn(boolean rightIn) {
        this.rightIn = rightIn;
    }

    public boolean isBotIn() {
        return botIn;
    }

    public void setBotIn(boolean botIn) {
        this.botIn = botIn;
    }

    public boolean isLeftIn() {
        return leftIn;
    }

    public void setLeftIn(boolean leftIn) {
        this.leftIn = leftIn;
    }

    public boolean isPosInUse() {
        return posInUse;
    }

    public void setPosInUse(boolean posInUse) {
        this.posInUse = posInUse;
    }

    public int getRowCol() {
        return rowCol;
    }

    public void setRowCol(int rowCol) {
        this.rowCol = rowCol;
    }

    public int getContinuity() {
        return continuity;
    }

    public void setContinuity(int continuity) {
        this.continuity = continuity;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public BigDecimal getCenterXsa() {
        return centerXsa;
    }

    public void setCenterXsa(BigDecimal centerXsa) {
        this.centerXsa = centerXsa;
    }

    public BigDecimal getCenterYsa() {
        return centerYsa;
    }

    public void setCenterYsa(BigDecimal centerYsa) {
        this.centerYsa = centerYsa;
    }

    public BigDecimal getCenterXea() {
        return centerXea;
    }

    public void setCenterXea(BigDecimal centerXea) {
        this.centerXea = centerXea;
    }

    public BigDecimal getCenterYea() {
        return centerYea;
    }

    public void setCenterYea(BigDecimal centerYea) {
        this.centerYea = centerYea;
    }

    public BigDecimal getX1a() {
        return x1a;
    }

    public void setX1a(BigDecimal x1a) {
        this.x1a = x1a;
    }

    public BigDecimal getX1b() {
        return x1b;
    }

    public void setX1b(BigDecimal x1b) {
        this.x1b = x1b;
    }

    public BigDecimal getX1a3() {
        return x1a3;
    }

    public void setX1a3(BigDecimal x1a3) {
        this.x1a3 = x1a3;
    }

    public BigDecimal getY1a() {
        return y1a;
    }

    public void setY1a(BigDecimal y1a) {
        this.y1a = y1a;
    }

    public BigDecimal getY1b() {
        return y1b;
    }

    public void setY1b(BigDecimal y1b) {
        this.y1b = y1b;
    }

    public BigDecimal getY1a3() {
        return y1a3;
    }

    public void setY1a3(BigDecimal y1a3) {
        this.y1a3 = y1a3;
    }

    public BigDecimal getX2a() {
        return x2a;
    }

    public void setX2a(BigDecimal x2a) {
        this.x2a = x2a;
    }

    public BigDecimal getX2b() {
        return x2b;
    }

    public void setX2b(BigDecimal x2b) {
        this.x2b = x2b;
    }

    public BigDecimal getX2a3() {
        return x2a3;
    }

    public void setX2a3(BigDecimal x2a3) {
        this.x2a3 = x2a3;
    }

    public BigDecimal getY2a() {
        return y2a;
    }

    public void setY2a(BigDecimal y2a) {
        this.y2a = y2a;
    }

    public BigDecimal getY2b() {
        return y2b;
    }

    public void setY2b(BigDecimal y2b) {
        this.y2b = y2b;
    }

    public BigDecimal getY2a3() {
        return y2a3;
    }

    public void setY2a3(BigDecimal y2a3) {
        this.y2a3 = y2a3;
    }

    public BigDecimal getX3a() {
        return x3a;
    }

    public void setX3a(BigDecimal x3a) {
        this.x3a = x3a;
    }

    public BigDecimal getX3b() {
        return x3b;
    }

    public void setX3b(BigDecimal x3b) {
        this.x3b = x3b;
    }

    public BigDecimal getX3a3() {
        return x3a3;
    }

    public void setX3a3(BigDecimal x3a3) {
        this.x3a3 = x3a3;
    }

    public BigDecimal getY3a() {
        return y3a;
    }

    public void setY3a(BigDecimal y3a) {
        this.y3a = y3a;
    }

    public BigDecimal getY3b() {
        return y3b;
    }

    public void setY3b(BigDecimal y3b) {
        this.y3b = y3b;
    }

    public BigDecimal getY3a3() {
        return y3a3;
    }

    public void setY3a3(BigDecimal y3a3) {
        this.y3a3 = y3a3;
    }

    public BigDecimal getX4a() {
        return x4a;
    }

    public void setX4a(BigDecimal x4a) {
        this.x4a = x4a;
    }

    public BigDecimal getX4b() {
        return x4b;
    }

    public void setX4b(BigDecimal x4b) {
        this.x4b = x4b;
    }

    public BigDecimal getX4a3() {
        return x4a3;
    }

    public void setX4a3(BigDecimal x4a3) {
        this.x4a3 = x4a3;
    }

    public BigDecimal getY4a() {
        return y4a;
    }

    public void setY4a(BigDecimal y4a) {
        this.y4a = y4a;
    }

    public BigDecimal getY4b() {
        return y4b;
    }

    public void setY4b(BigDecimal y4b) {
        this.y4b = y4b;
    }

    public BigDecimal getY4a3() {
        return y4a3;
    }

    public void setY4a3(BigDecimal y4a3) {
        this.y4a3 = y4a3;
    }

    public BigDecimal getYcs() {
        return ycs;
    }

    public void setYcs(BigDecimal ycs) {
        this.ycs = ycs;
    }

    public BigDecimal getYce() {
        return yce;
    }

    public void setYce(BigDecimal yce) {
        this.yce = yce;
    }

    public BigDecimal getXcs() {
        return xcs;
    }

    public void setXcs(BigDecimal xcs) {
        this.xcs = xcs;
    }

    public BigDecimal getXce() {
        return xce;
    }

    public void setXce(BigDecimal xce) {
        this.xce = xce;
    }

    public BigDecimal getX1al() {
        return x1al;
    }

    public void setX1al(BigDecimal x1al) {
        this.x1al = x1al;
    }

    public BigDecimal getY1al() {
        return y1al;
    }

    public void setY1al(BigDecimal y1al) {
        this.y1al = y1al;
    }

    public BigDecimal getX2cl() {
        return x2cl;
    }

    public void setX2cl(BigDecimal x2cl) {
        this.x2cl = x2cl;
    }

    public BigDecimal getY2cl() {
        return y2cl;
    }

    public void setY2cl(BigDecimal y2cl) {
        this.y2cl = y2cl;
    }

    public BigDecimal getX3cl() {
        return x3cl;
    }

    public void setX3cl(BigDecimal x3cl) {
        this.x3cl = x3cl;
    }

    public BigDecimal getY3cl() {
        return y3cl;
    }

    public void setY3cl(BigDecimal y3cl) {
        this.y3cl = y3cl;
    }

    public BigDecimal getX4al() {
        return x4al;
    }

    public void setX4al(BigDecimal x4al) {
        this.x4al = x4al;
    }

    public BigDecimal getY4al() {
        return y4al;
    }

    public void setY4al(BigDecimal y4al) {
        this.y4al = y4al;
    }

    public BigDecimal getCenterXs() {
        return centerXs;
    }

    public void setCenterXs(BigDecimal centerXs) {
        this.centerXs = centerXs;
    }

    public BigDecimal getCenterYs() {
        return centerYs;
    }

    public void setCenterYs(BigDecimal centerYs) {
        this.centerYs = centerYs;
    }

    public BigDecimal getCenterXe() {
        return centerXe;
    }

    public void setCenterXe(BigDecimal centerXe) {
        this.centerXe = centerXe;
    }

    public BigDecimal getCenterYe() {
        return centerYe;
    }

    public void setCenterYe(BigDecimal centerYe) {
        this.centerYe = centerYe;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getCouplerShapeId() {
        return couplerShapeId;
    }

    public void setCouplerShapeId(int couplerShapeId) {
        this.couplerShapeId = couplerShapeId;
    }

    public int getCouplerTypeId() {
        return couplerTypeId;
    }

    public void setCouplerTypeId(int couplerTypeId) {
        this.couplerTypeId = couplerTypeId;
    }

    public int getPosCondition() {
        return posCondition;
    }

    public void setPosCondition(int posCondition) {
        this.posCondition = posCondition;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public boolean isStartIn() {
        return startIn;
    }

    public void setStartIn(boolean startIn) {
        this.startIn = startIn;
    }

    public boolean isEndIn() {
        return endIn;
    }

    public void setEndIn(boolean endIn) {
        this.endIn = endIn;
    }

    public boolean isPartLeft() {
        return partLeft;
    }

    public void setPartLeft(boolean partLeft) {
        this.partLeft = partLeft;
    }

    public boolean isPartRight() {
        return partRight;
    }

    public void setPartRight(boolean partRight) {
        this.partRight = partRight;
    }

    public int getOpeningTypeLB() {
        return openingTypeLB;
    }

    public void setOpeningTypeLB(int openingTypeLB) {
        this.openingTypeLB = openingTypeLB;
    }

    public int getOpeningIDLB() {
        return openingIDLB;
    }

    public void setOpeningIDLB(int openingIDLB) {
        this.openingIDLB = openingIDLB;
    }

    public int getOpeningTypeRT() {
        return openingTypeRT;
    }

    public void setOpeningTypeRT(int openingTypeRT) {
        this.openingTypeRT = openingTypeRT;
    }

    public int getOpeningIDRT() {
        return openingIDRT;
    }

    public void setOpeningIDRT(int openingIDRT) {
        this.openingIDRT = openingIDRT;
    }

    public boolean isFixedAngle() {
        return fixedAngle;
    }

    public void setFixedAngle(boolean fixedAngle) {
        this.fixedAngle = fixedAngle;
    }

    public BigDecimal getAngle() {
        return angle;
    }

    public void setAngle(BigDecimal angle) {
        this.angle = angle;
    }

    public BigDecimal getMinAngle() {
        return minAngle;
    }

    public void setMinAngle(BigDecimal minAngle) {
        this.minAngle = minAngle;
    }

    public BigDecimal getMaxAngle() {
        return maxAngle;
    }

    public void setMaxAngle(BigDecimal maxAngle) {
        this.maxAngle = maxAngle;
    }

    public boolean isDivideFacet() {
        return divideFacet;
    }

    public void setDivideFacet(boolean divideFacet) {
        this.divideFacet = divideFacet;
    }

    public BigDecimal getCentralAnglec() {
        return centralAnglec;
    }

    public void setCentralAnglec(BigDecimal centralAnglec) {
        this.centralAnglec = centralAnglec;
    }

    public BigDecimal getCentralAnglec1() {
        return centralAnglec1;
    }

    public void setCentralAnglec1(BigDecimal centralAnglec1) {
        this.centralAnglec1 = centralAnglec1;
    }

    public BigDecimal getCentralAnglea1() {
        return centralAnglea1;
    }

    public void setCentralAnglea1(BigDecimal centralAnglea1) {
        this.centralAnglea1 = centralAnglea1;
    }

    public BigDecimal getCentralAnglea() {
        return centralAnglea;
    }

    public void setCentralAnglea(BigDecimal centralAnglea) {
        this.centralAnglea = centralAnglea;
    }

    public BigDecimal getRadius1c() {
        return radius1c;
    }

    public void setRadius1c(BigDecimal radius1c) {
        this.radius1c = radius1c;
    }

    public BigDecimal getRadius1c1() {
        return radius1c1;
    }

    public void setRadius1c1(BigDecimal radius1c1) {
        this.radius1c1 = radius1c1;
    }

    public BigDecimal getRadius1a1() {
        return radius1a1;
    }

    public void setRadius1a1(BigDecimal radius1a1) {
        this.radius1a1 = radius1a1;
    }

    public BigDecimal getRadius1a() {
        return radius1a;
    }

    public void setRadius1a(BigDecimal radius1a) {
        this.radius1a = radius1a;
    }

    public BigDecimal getArcH() {
        return arcH;
    }

    public void setArcH(BigDecimal arcH) {
        this.arcH = arcH;
    }

    public BigDecimal getStartAnglec() {
        return startAnglec;
    }

    public void setStartAnglec(BigDecimal startAnglec) {
        this.startAnglec = startAnglec;
    }

    public BigDecimal getEndAnglec() {
        return endAnglec;
    }

    public void setEndAnglec(BigDecimal endAnglec) {
        this.endAnglec = endAnglec;
    }

    public BigDecimal getStartAnglec1() {
        return startAnglec1;
    }

    public void setStartAnglec1(BigDecimal startAnglec1) {
        this.startAnglec1 = startAnglec1;
    }

    public BigDecimal getEndAnglec1() {
        return endAnglec1;
    }

    public void setEndAnglec1(BigDecimal endAnglec1) {
        this.endAnglec1 = endAnglec1;
    }

    public BigDecimal getStartAnglea1() {
        return startAnglea1;
    }

    public void setStartAnglea1(BigDecimal startAnglea1) {
        this.startAnglea1 = startAnglea1;
    }

    public BigDecimal getEndAnglea1() {
        return endAnglea1;
    }

    public void setEndAnglea1(BigDecimal endAnglea1) {
        this.endAnglea1 = endAnglea1;
    }

    public BigDecimal getStartAnglea() {
        return startAnglea;
    }

    public void setStartAnglea(BigDecimal startAnglea) {
        this.startAnglea = startAnglea;
    }

    public BigDecimal getEndAnglea() {
        return endAnglea;
    }

    public void setEndAnglea(BigDecimal endAnglea) {
        this.endAnglea = endAnglea;
    }

    public BigDecimal getAngleTLa() {
        return angleTLa;
    }

    public void setAngleTLa(BigDecimal angleTLa) {
        this.angleTLa = angleTLa;
    }

    public BigDecimal getAngleBLa() {
        return angleBLa;
    }

    public void setAngleBLa(BigDecimal angleBLa) {
        this.angleBLa = angleBLa;
    }

    public BigDecimal getAngleTRc() {
        return angleTRc;
    }

    public void setAngleTRc(BigDecimal angleTRc) {
        this.angleTRc = angleTRc;
    }

    public BigDecimal getAngleBRc() {
        return angleBRc;
    }

    public void setAngleBRc(BigDecimal angleBRc) {
        this.angleBRc = angleBRc;
    }

    public BigDecimal getOffsetTL() {
        return offsetTL;
    }

    public void setOffsetTL(BigDecimal offsetTL) {
        this.offsetTL = offsetTL;
    }

    public BigDecimal getOffsetRB() {
        return offsetRB;
    }

    public void setOffsetRB(BigDecimal offsetRB) {
        this.offsetRB = offsetRB;
    }

    public BigDecimal getDeltaTL() {
        return deltaTL;
    }

    public void setDeltaTL(BigDecimal deltaTL) {
        this.deltaTL = deltaTL;
    }

    public BigDecimal getDeltaRB() {
        return deltaRB;
    }

    public void setDeltaRB(BigDecimal deltaRB) {
        this.deltaRB = deltaRB;
    }

    public BigDecimal getCurveCenterTL() {
        return curveCenterTL;
    }

    public void setCurveCenterTL(BigDecimal curveCenterTL) {
        this.curveCenterTL = curveCenterTL;
    }

    public BigDecimal getCurveCenterRB() {
        return curveCenterRB;
    }

    public void setCurveCenterRB(BigDecimal curveCenterRB) {
        this.curveCenterRB = curveCenterRB;
    }

    public boolean isGlazedOut() {
        return glazedOut;
    }

    public void setGlazedOut(boolean glazedOut) {
        this.glazedOut = glazedOut;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getWhichPos() {
        return whichPos;
    }

    public void setWhichPos(int whichPos) {
        this.whichPos = whichPos;
    }

    public BigDecimal getLevelW() {
        return levelW;
    }

    public void setLevelW(BigDecimal levelW) {
        this.levelW = levelW;
    }

    public BigDecimal getLevelH() {
        return levelH;
    }

    public void setLevelH(BigDecimal levelH) {
        this.levelH = levelH;
    }

    public boolean isLeftInf() {
        return leftInf;
    }

    public void setLeftInf(boolean leftInf) {
        this.leftInf = leftInf;
    }

    public boolean isRightInf() {
        return rightInf;
    }

    public void setRightInf(boolean rightInf) {
        this.rightInf = rightInf;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColorIn() {
        return colorIn;
    }

    public void setColorIn(int colorIn) {
        this.colorIn = colorIn;
    }

    public int getColorOut() {
        return colorOut;
    }

    public void setColorOut(int colorOut) {
        this.colorOut = colorOut;
    }

    public int getRgb_R() {
        return rgb_R;
    }

    public void setRgb_R(int rgb_R) {
        this.rgb_R = rgb_R;
    }

    public int getRgb_G() {
        return rgb_G;
    }

    public void setRgb_G(int rgb_G) {
        this.rgb_G = rgb_G;
    }

    public int getRgb_B() {
        return rgb_B;
    }

    public void setRgb_B(int rgb_B) {
        this.rgb_B = rgb_B;
    }

    public int getRgb_Rin() {
        return rgb_Rin;
    }

    public void setRgb_Rin(int rgb_Rin) {
        this.rgb_Rin = rgb_Rin;
    }

    public int getRgb_Gin() {
        return rgb_Gin;
    }

    public void setRgb_Gin(int rgb_Gin) {
        this.rgb_Gin = rgb_Gin;
    }

    public int getRgb_Bin() {
        return rgb_Bin;
    }

    public void setRgb_Bin(int rgb_Bin) {
        this.rgb_Bin = rgb_Bin;
    }

    public int getRgb_Rout() {
        return rgb_Rout;
    }

    public void setRgb_Rout(int rgb_Rout) {
        this.rgb_Rout = rgb_Rout;
    }

    public int getRgb_Gout() {
        return rgb_Gout;
    }

    public void setRgb_Gout(int rgb_Gout) {
        this.rgb_Gout = rgb_Gout;
    }

    public int getRgb_Bout() {
        return rgb_Bout;
    }

    public void setRgb_Bout(int rgb_Bout) {
        this.rgb_Bout = rgb_Bout;
    }

    public int getRgb_Rt() {
        return rgb_Rt;
    }

    public void setRgb_Rt(int rgb_Rt) {
        this.rgb_Rt = rgb_Rt;
    }

    public int getRgb_Gt() {
        return rgb_Gt;
    }

    public void setRgb_Gt(int rgb_Gt) {
        this.rgb_Gt = rgb_Gt;
    }

    public int getRgb_Bt() {
        return rgb_Bt;
    }

    public void setRgb_Bt(int rgb_Bt) {
        this.rgb_Bt = rgb_Bt;
    }

    public int getTransp() {
        return transp;
    }

    public void setTransp(int transp) {
        this.transp = transp;
    }

    public int getcOrM() {
        return cOrM;
    }

    public void setcOrM(int cOrM) {
        this.cOrM = cOrM;
    }

    public int getLengthM() {
        return lengthM;
    }

    public void setLengthM(int lengthM) {
        this.lengthM = lengthM;
    }

    public int getLengthI() {
        return lengthI;
    }

    public void setLengthI(int lengthI) {
        this.lengthI = lengthI;
    }

    public int getLengthMN() {
        return lengthMN;
    }

    public void setLengthMN(int lengthMN) {
        this.lengthMN = lengthMN;
    }

    public int getLengthIN() {
        return lengthIN;
    }

    public void setLengthIN(int lengthIN) {
        this.lengthIN = lengthIN;
    }

    public boolean isPhantom() {
        return phantom;
    }

    public void setPhantom(boolean phantom) {
        this.phantom = phantom;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int get_sequence() {
        return _sequence;
    }

    public void set_sequence(int _sequence) {
        this._sequence = _sequence;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public ConstructionMap getConstructionMap() {
        return constructionMap;
    }

    public void setConstructionMap(ConstructionMap constructionMap) {
        this.constructionMap = constructionMap;
    }

    public Set<PartsNotchingEntityObject> getPartsNotching() {
        return partsNotching;
    }

    public void setPartsNotching(Set<PartsNotchingEntityObject> partsNotching) {
        this.partsNotching = partsNotching;
    }

    public Set<ShapeOptionEntityObject> getOptions() {
        return options;
    }

    public void setOptions(Set<ShapeOptionEntityObject> options) {
        this.options = options;
    }

    public Set<BillOfMaterialEntityObject> getBoms() {
        return boms;
    }

    public void setBoms(Set<BillOfMaterialEntityObject> boms) {
        this.boms = boms;
    }

    public Set<ShapeNotesEntityObject> getNotes() {
        return notes;
    }

    public void setNotes(Set<ShapeNotesEntityObject> notes) {
        this.notes = notes;
    }
}
