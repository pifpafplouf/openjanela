package openjanela.model.entities.design;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-12
 *          Time: 11:41 AM
 *          <p/>
 *          This class represents the main class model design for a Shape Object
 */
public abstract class ShapeAbstractObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = -3544276732052433378L;

    private Integer id = 0;

    private int jobId = 0;
    private int itemId = 0;
    private int levelId = 0;
    private int sequenceId = 0;
    private int assemblyLevelId = 0;
    private int widthM = 0;
    private int heightM = 0;
    private int widthI = 0;
    private int heightI = 0;
    private int widthMO = 0;
    private int heightMO = 0;
    private int widthIO = 0;
    private int heightIO = 0;

    private int stdWM = 0;
    private int stdHM = 0;
    private int stdWI = 0;
    private int stdHI = 0;
    private int noPartsTop1 = 0;
    private int noPartsTop2 = 0;
    private int noPartsTop3 = 0;
    private int noPartsBot1 = 0;
    private int noPartsBot2 = 0;
    private int noPartsBot3 = 0;
    private int noPartsLeft = 0;
    private int noPartsRight = 0;
    private int frameStartCol = 0;
    private int frameStartRow = 0;
    private int frameEndCol = 0;
    private int frameEndRow = 0;
    private int xCols = 0;
    private int yRows = 0;
    private int noTracks = 0;
    private int openingType = 0;
    private int outSashTracks = 0;
    private int inSashTracks = 0;
    private int midSashTracks = 0;
    private int shapeID = 0;
    private int lean = 0;
    private int lean2 = 0;
    private int lean3 = 0;
    private int lean4 = 0;
    private int noSides = 0;
    private int noSidesTop = 0;
    private int noSidesBot = 0;
    private int noSidesLeft = 0;
    private int noSidesRight = 0;
    private int topShape = 0;
    private int rightShape = 0;
    private int botShape = 0;
    private int leftShape = 0;
    private int dimA1M = 0;
    private int dimA2M = 0;
    private int dimA3M = 0;
    private int dimA4M = 0;
    private int dimA5M = 0;
    private int dimA0M = 0;
    private int dimB1M = 0;
    private int dimB2M = 0;
    private int dimB3M = 0;
    private int dimB4M = 0;
    private int dimB5M = 0;
    private int dimB0M = 0;
    private int dimC1M = 0;
    private int dimC2M = 0;
    private int dimC3M = 0;
    private int dimC4M = 0;
    private int dimC5M = 0;
    private int dimC0M = 0;
    private int dimD1M = 0;
    private int dimD2M = 0;
    private int dimD3M = 0;
    private int dimD4M = 0;
    private int dimD5M = 0;
    private int dimD0M = 0;
    private int dimA1I = 0;
    private int dimA2I = 0;
    private int dimA3I = 0;
    private int dimA4I = 0;
    private int dimA5I = 0;
    private int dimA0I = 0;
    private int dimB1I = 0;
    private int dimB2I = 0;
    private int dimB3I = 0;
    private int dimB4I = 0;
    private int dimB5I = 0;
    private int dimB0I = 0;
    private int dimC1I = 0;
    private int dimC2I = 0;
    private int dimC3I = 0;
    private int dimC4I = 0;
    private int dimC5I = 0;
    private int dimC0I = 0;
    private int dimD1I = 0;
    private int dimD2I = 0;
    private int dimD3I = 0;
    private int dimD4I = 0;
    private int dimD5I = 0;
    private int dimD0I = 0;
    private int startCol = 0;
    private int endCol = 0;
    private int startRow = 0;
    private int endRow = 0;
    private int baseUOM = 0;
    private int openingID = 0;
    private int parentId = 0;
    private int contentIn = 0;
    private int contentMid = 0;
    private int contentOut = 0;
    private int widthMN = 0;
    private int heightMN = 0;
    private int widthIN = 0;
    private int heightIN = 0;

    private int controlOpeningClassType = 0;
    private int controlOpeningClass = 0;
    private int controlUserDefinedOpeningID = 0;

    private boolean isStdW = false;
    private boolean isStdH = false;
    private boolean newDesign = true;
    private boolean openOut = true;
    private boolean glazedOut = true;
    private boolean hasSash = true;
    private boolean unGlazed = true;
    private boolean openIn = true;
    private boolean topIn = true;
    private boolean rightIn = true;
    private boolean botIn = true;
    private boolean leftIn = true;
    private boolean autoW = true;
    private boolean autoH = true;
    private boolean wire = false;

    private BigDecimal widthPix = new BigDecimal("0");
    private BigDecimal heightPix = new BigDecimal("0");
    private BigDecimal scalepix = new BigDecimal("0");
    private BigDecimal radius1 = new BigDecimal("0");
    private BigDecimal radius2 = new BigDecimal("0");
    private BigDecimal startAngle = new BigDecimal("0");
    private BigDecimal endAngle = new BigDecimal("0");
    private BigDecimal centralAngle = new BigDecimal("0");
    private BigDecimal originalScaleM = new BigDecimal("0");
    private BigDecimal originalScaleI = new BigDecimal("0");
    private BigDecimal radius1A = new BigDecimal("0");
    private BigDecimal radius2A = new BigDecimal("0");
    private BigDecimal startAngleA = new BigDecimal("0");
    private BigDecimal endAngleA = new BigDecimal("0");
    private BigDecimal centralAngleA = new BigDecimal("0");
    private BigDecimal clearanceTop = new BigDecimal("0");
    private BigDecimal clearanceBot = new BigDecimal("0");
    private BigDecimal clearanceLeft = new BigDecimal("0");
    private BigDecimal clearanceRight = new BigDecimal("0");
    private BigDecimal scaleM = new BigDecimal("0");
    private BigDecimal scaleImp = new BigDecimal("0");

    private BigDecimal highestX = new BigDecimal("0");
    private BigDecimal lowestX = new BigDecimal("0");
    private BigDecimal highestY = new BigDecimal("0");
    private BigDecimal lowestY = new BigDecimal("0");
    private BigDecimal highestYC = new BigDecimal("0");
    private BigDecimal lowestYC = new BigDecimal("0");
    private BigDecimal myScale = new BigDecimal("0");

    private BigDecimal bkgrdStartX = new BigDecimal("0");
    private BigDecimal bkgrdStartY = new BigDecimal("0");
    private BigDecimal bkgrdStartXBA = new BigDecimal("0");
    private BigDecimal bkgrdStartYBA = new BigDecimal("0");
    private BigDecimal bkgrdStartXA = new BigDecimal("0");
    private BigDecimal bkgrdStartYA = new BigDecimal("0");

    private BigDecimal centerPointX = new BigDecimal("0");
    private BigDecimal centerPointY = new BigDecimal("0");
    private BigDecimal centerPointX2 = new BigDecimal("0");
    private BigDecimal centerPointY2 = new BigDecimal("0");

    private BigDecimal dimA1 = new BigDecimal("0");
    private BigDecimal dimA2 = new BigDecimal("0");
    private BigDecimal dimA3 = new BigDecimal("0");
    private BigDecimal dimA4 = new BigDecimal("0");
    private BigDecimal dimA5 = new BigDecimal("0");
    private BigDecimal dimA0 = new BigDecimal("0");
    private BigDecimal dimB1 = new BigDecimal("0");
    private BigDecimal dimB2 = new BigDecimal("0");
    private BigDecimal dimB3 = new BigDecimal("0");
    private BigDecimal dimB4 = new BigDecimal("0");
    private BigDecimal dimB5 = new BigDecimal("0");
    private BigDecimal dimB0 = new BigDecimal("0");
    private BigDecimal dimC1 = new BigDecimal("0");
    private BigDecimal dimC2 = new BigDecimal("0");
    private BigDecimal dimC3 = new BigDecimal("0");
    private BigDecimal dimC4 = new BigDecimal("0");
    private BigDecimal dimC5 = new BigDecimal("0");
    private BigDecimal dimC0 = new BigDecimal("0");
    private BigDecimal dimD1 = new BigDecimal("0");
    private BigDecimal dimD2 = new BigDecimal("0");
    private BigDecimal dimD3 = new BigDecimal("0");
    private BigDecimal dimD4 = new BigDecimal("0");
    private BigDecimal dimD5 = new BigDecimal("0");
    private BigDecimal dimD0 = new BigDecimal("0");

    private BigDecimal bX2 = new BigDecimal("0");
    private BigDecimal bY2 = new BigDecimal("0");
    private BigDecimal bX3 = new BigDecimal("0");
    private BigDecimal bY3 = new BigDecimal("0");
    private BigDecimal bX4 = new BigDecimal("0");
    private BigDecimal bY4 = new BigDecimal("0");
    private BigDecimal bX2B = new BigDecimal("0");
    private BigDecimal bY2B = new BigDecimal("0");
    private BigDecimal bX3B = new BigDecimal("0");
    private BigDecimal bY3B = new BigDecimal("0");
    private BigDecimal bX4B = new BigDecimal("0");
    private BigDecimal bY4B = new BigDecimal("0");
    private BigDecimal bX2A = new BigDecimal("0");
    private BigDecimal bY2A = new BigDecimal("0");
    private BigDecimal bX3A = new BigDecimal("0");
    private BigDecimal bY3A = new BigDecimal("0");
    private BigDecimal bX4A = new BigDecimal("0");
    private BigDecimal bY4A = new BigDecimal("0");
    private BigDecimal bCX2 = new BigDecimal("0");
    private BigDecimal bCY2 = new BigDecimal("0");
    private BigDecimal bCX3 = new BigDecimal("0");
    private BigDecimal bCY3 = new BigDecimal("0");
    private BigDecimal bCX4 = new BigDecimal("0");
    private BigDecimal bCY4 = new BigDecimal("0");

    private BigDecimal startingX = new BigDecimal("0");
    private BigDecimal startingY = new BigDecimal("0");
    private BigDecimal startingXBA = new BigDecimal("0");
    private BigDecimal startingYBA = new BigDecimal("0");
    private BigDecimal startingXA = new BigDecimal("0");
    private BigDecimal startingYA = new BigDecimal("0");
    private BigDecimal startingCX = new BigDecimal("0");
    private BigDecimal startingCY = new BigDecimal("0");

    private BigDecimal levelW = new BigDecimal("0");
    private BigDecimal levelH = new BigDecimal("0");

    private BigDecimal dimTM = new BigDecimal("0");
    private BigDecimal dimBM = new BigDecimal("0");
    private BigDecimal dimLM = new BigDecimal("0");
    private BigDecimal dimRM = new BigDecimal("0");
    private BigDecimal dimTA = new BigDecimal("0");
    private BigDecimal dimBA = new BigDecimal("0");
    private BigDecimal dimLA = new BigDecimal("0");
    private BigDecimal dimRA = new BigDecimal("0");

    private BigDecimal openingW = new BigDecimal("0");
    private BigDecimal openingH = new BigDecimal("0");
    private BigDecimal openingWc= new BigDecimal("0");
    private BigDecimal openingHc= new BigDecimal("0");
    private BigDecimal openingWB= new BigDecimal("0");
    private BigDecimal openingHR= new BigDecimal("0");
    private BigDecimal openingWcB= new BigDecimal("0");
    private BigDecimal openingHcR= new BigDecimal("0");
    private BigDecimal openingWA= new BigDecimal("0");
    private BigDecimal openingHA= new BigDecimal("0");
    private BigDecimal openingWBA= new BigDecimal("0");
    private BigDecimal openingHRA= new BigDecimal("0");

    private BigDecimal px1 = new BigDecimal("0");
    private BigDecimal py1 = new BigDecimal("0");
    private BigDecimal px2 = new BigDecimal("0");
    private BigDecimal py2 = new BigDecimal("0");
    private BigDecimal px3 = new BigDecimal("0");
    private BigDecimal py3 = new BigDecimal("0");
    private BigDecimal px4 = new BigDecimal("0");
    private BigDecimal py4 = new BigDecimal("0");
    private BigDecimal px5 = new BigDecimal("0");
    private BigDecimal py5 = new BigDecimal("0");
    private BigDecimal px6 = new BigDecimal("0");
    private BigDecimal py6 = new BigDecimal("0");
    private BigDecimal px7 = new BigDecimal("0");
    private BigDecimal py7 = new BigDecimal("0");
    private BigDecimal px8 = new BigDecimal("0");
    private BigDecimal py8 = new BigDecimal("0");
    private BigDecimal px1A = new BigDecimal("0");
    private BigDecimal py1A = new BigDecimal("0");
    private BigDecimal px2A = new BigDecimal("0");
    private BigDecimal py2A = new BigDecimal("0");
    private BigDecimal px3A = new BigDecimal("0");
    private BigDecimal py3A = new BigDecimal("0");
    private BigDecimal px4A = new BigDecimal("0");
    private BigDecimal py4A = new BigDecimal("0");
    private BigDecimal px5A = new BigDecimal("0");
    private BigDecimal py5A = new BigDecimal("0");
    private BigDecimal px6A = new BigDecimal("0");
    private BigDecimal py6A = new BigDecimal("0");
    private BigDecimal px7A = new BigDecimal("0");
    private BigDecimal py7A = new BigDecimal("0");
    private BigDecimal px8A = new BigDecimal("0");
    private BigDecimal py8A = new BigDecimal("0");
    private BigDecimal px1c = new BigDecimal("0");
    private BigDecimal py1c = new BigDecimal("0");
    private BigDecimal px2c = new BigDecimal("0");
    private BigDecimal py2c = new BigDecimal("0");
    private BigDecimal px3c = new BigDecimal("0");
    private BigDecimal py3c = new BigDecimal("0");
    private BigDecimal px4c = new BigDecimal("0");
    private BigDecimal py4c = new BigDecimal("0");
    private BigDecimal px5c = new BigDecimal("0");
    private BigDecimal py5c = new BigDecimal("0");
    private BigDecimal px6c = new BigDecimal("0");
    private BigDecimal py6c = new BigDecimal("0");
    private BigDecimal px7c = new BigDecimal("0");
    private BigDecimal py7c = new BigDecimal("0");
    private BigDecimal px8c = new BigDecimal("0");
    private BigDecimal py8c = new BigDecimal("0");

    private int supplierRemoteId = 0;
    private int supplierSeriesId = 0;
    private boolean remote = false;

    /**
     * Construction Map levels and sequence
     */
    private ConstructionMap constructionMap;

    /**
     * Profile Collections Objects
     */
    private Set<ProfileCollectionObject> profileCollection;

    /**
     * Profile Bill of Materials
     */
    private Set<ProfileEntityBOM> profileBOMs;

    /**
     * Profile My Mullions collection
     */
    private Set<ProfileMyMullionObject> myMullions;

    /**
     * Shape Options Shape
     */
    private Set<ShapeOptionEntityObject> options;

    /**
     * Bill of Material Collection
     */
    private Set<BillOfMaterialEntityObject> boms;

    /**
     * Shape Notes Collection
     */
    private Set<ShapeNotesEntityObject> notes;

    // ==================================<GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getAssemblyLevelId() {
        return assemblyLevelId;
    }

    public void setAssemblyLevelId(int assemblyLevelId) {
        this.assemblyLevelId = assemblyLevelId;
    }

    public int getWidthM() {
        return widthM;
    }

    public void setWidthM(int widthM) {
        this.widthM = widthM;
    }

    public int getHeightM() {
        return heightM;
    }

    public void setHeightM(int heightM) {
        this.heightM = heightM;
    }

    public int getWidthI() {
        return widthI;
    }

    public void setWidthI(int widthI) {
        this.widthI = widthI;
    }

    public int getHeightI() {
        return heightI;
    }

    public void setHeightI(int heightI) {
        this.heightI = heightI;
    }

    public int getWidthMO() {
        return widthMO;
    }

    public void setWidthMO(int widthMO) {
        this.widthMO = widthMO;
    }

    public int getHeightMO() {
        return heightMO;
    }

    public void setHeightMO(int heightMO) {
        this.heightMO = heightMO;
    }

    public int getWidthIO() {
        return widthIO;
    }

    public void setWidthIO(int widthIO) {
        this.widthIO = widthIO;
    }

    public int getHeightIO() {
        return heightIO;
    }

    public void setHeightIO(int heightIO) {
        this.heightIO = heightIO;
    }

    public BigDecimal getWidthPix() {
        return widthPix;
    }

    public void setWidthPix(BigDecimal widthPix) {
        this.widthPix = widthPix;
    }

    public BigDecimal getHeightPix() {
        return heightPix;
    }

    public void setHeightPix(BigDecimal heightPix) {
        this.heightPix = heightPix;
    }

    public BigDecimal getScalepix() {
        return scalepix;
    }

    public void setScalepix(BigDecimal scalepix) {
        this.scalepix = scalepix;
    }

    public int getStdWM() {
        return stdWM;
    }

    public void setStdWM(int stdWM) {
        this.stdWM = stdWM;
    }

    public int getStdHM() {
        return stdHM;
    }

    public void setStdHM(int stdHM) {
        this.stdHM = stdHM;
    }

    public int getStdWI() {
        return stdWI;
    }

    public void setStdWI(int stdWI) {
        this.stdWI = stdWI;
    }

    public int getStdHI() {
        return stdHI;
    }

    public void setStdHI(int stdHI) {
        this.stdHI = stdHI;
    }

    public int getNoPartsTop1() {
        return noPartsTop1;
    }

    public void setNoPartsTop1(int noPartsTop1) {
        this.noPartsTop1 = noPartsTop1;
    }

    public int getNoPartsTop2() {
        return noPartsTop2;
    }

    public void setNoPartsTop2(int noPartsTop2) {
        this.noPartsTop2 = noPartsTop2;
    }

    public int getNoPartsTop3() {
        return noPartsTop3;
    }

    public void setNoPartsTop3(int noPartsTop3) {
        this.noPartsTop3 = noPartsTop3;
    }

    public int getNoPartsBot1() {
        return noPartsBot1;
    }

    public void setNoPartsBot1(int noPartsBot1) {
        this.noPartsBot1 = noPartsBot1;
    }

    public int getNoPartsBot2() {
        return noPartsBot2;
    }

    public void setNoPartsBot2(int noPartsBot2) {
        this.noPartsBot2 = noPartsBot2;
    }

    public int getNoPartsBot3() {
        return noPartsBot3;
    }

    public void setNoPartsBot3(int noPartsBot3) {
        this.noPartsBot3 = noPartsBot3;
    }

    public int getNoPartsLeft() {
        return noPartsLeft;
    }

    public void setNoPartsLeft(int noPartsLeft) {
        this.noPartsLeft = noPartsLeft;
    }

    public int getNoPartsRight() {
        return noPartsRight;
    }

    public void setNoPartsRight(int noPartsRight) {
        this.noPartsRight = noPartsRight;
    }

    public int getFrameStartCol() {
        return frameStartCol;
    }

    public void setFrameStartCol(int frameStartCol) {
        this.frameStartCol = frameStartCol;
    }

    public int getFrameStartRow() {
        return frameStartRow;
    }

    public void setFrameStartRow(int frameStartRow) {
        this.frameStartRow = frameStartRow;
    }

    public int getFrameEndCol() {
        return frameEndCol;
    }

    public void setFrameEndCol(int frameEndCol) {
        this.frameEndCol = frameEndCol;
    }

    public int getFrameEndRow() {
        return frameEndRow;
    }

    public void setFrameEndRow(int frameEndRow) {
        this.frameEndRow = frameEndRow;
    }

    public int getxCols() {
        return xCols;
    }

    public void setxCols(int xCols) {
        this.xCols = xCols;
    }

    public int getyRows() {
        return yRows;
    }

    public void setyRows(int yRows) {
        this.yRows = yRows;
    }

    public int getNoTracks() {
        return noTracks;
    }

    public void setNoTracks(int noTracks) {
        this.noTracks = noTracks;
    }

    public int getOpeningType() {
        return openingType;
    }

    public void setOpeningType(int openingType) {
        this.openingType = openingType;
    }

    public int getOutSashTracks() {
        return outSashTracks;
    }

    public void setOutSashTracks(int outSashTracks) {
        this.outSashTracks = outSashTracks;
    }

    public int getInSashTracks() {
        return inSashTracks;
    }

    public void setInSashTracks(int inSashTracks) {
        this.inSashTracks = inSashTracks;
    }

    public int getMidSashTracks() {
        return midSashTracks;
    }

    public void setMidSashTracks(int midSashTracks) {
        this.midSashTracks = midSashTracks;
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    public int getLean() {
        return lean;
    }

    public void setLean(int lean) {
        this.lean = lean;
    }

    public int getLean2() {
        return lean2;
    }

    public void setLean2(int lean2) {
        this.lean2 = lean2;
    }

    public int getLean3() {
        return lean3;
    }

    public void setLean3(int lean3) {
        this.lean3 = lean3;
    }

    public int getLean4() {
        return lean4;
    }

    public void setLean4(int lean4) {
        this.lean4 = lean4;
    }

    public int getNoSides() {
        return noSides;
    }

    public void setNoSides(int noSides) {
        this.noSides = noSides;
    }

    public int getNoSidesTop() {
        return noSidesTop;
    }

    public void setNoSidesTop(int noSidesTop) {
        this.noSidesTop = noSidesTop;
    }

    public int getNoSidesBot() {
        return noSidesBot;
    }

    public void setNoSidesBot(int noSidesBot) {
        this.noSidesBot = noSidesBot;
    }

    public int getNoSidesLeft() {
        return noSidesLeft;
    }

    public void setNoSidesLeft(int noSidesLeft) {
        this.noSidesLeft = noSidesLeft;
    }

    public int getNoSidesRight() {
        return noSidesRight;
    }

    public void setNoSidesRight(int noSidesRight) {
        this.noSidesRight = noSidesRight;
    }

    public int getTopShape() {
        return topShape;
    }

    public void setTopShape(int topShape) {
        this.topShape = topShape;
    }

    public int getRightShape() {
        return rightShape;
    }

    public void setRightShape(int rightShape) {
        this.rightShape = rightShape;
    }

    public int getBotShape() {
        return botShape;
    }

    public void setBotShape(int botShape) {
        this.botShape = botShape;
    }

    public int getLeftShape() {
        return leftShape;
    }

    public void setLeftShape(int leftShape) {
        this.leftShape = leftShape;
    }

    public int getDimA1M() {
        return dimA1M;
    }

    public void setDimA1M(int dimA1M) {
        this.dimA1M = dimA1M;
    }

    public int getDimA2M() {
        return dimA2M;
    }

    public void setDimA2M(int dimA2M) {
        this.dimA2M = dimA2M;
    }

    public int getDimA3M() {
        return dimA3M;
    }

    public void setDimA3M(int dimA3M) {
        this.dimA3M = dimA3M;
    }

    public int getDimA4M() {
        return dimA4M;
    }

    public void setDimA4M(int dimA4M) {
        this.dimA4M = dimA4M;
    }

    public int getDimA5M() {
        return dimA5M;
    }

    public void setDimA5M(int dimA5M) {
        this.dimA5M = dimA5M;
    }

    public int getDimA0M() {
        return dimA0M;
    }

    public void setDimA0M(int dimA0M) {
        this.dimA0M = dimA0M;
    }

    public int getDimB1M() {
        return dimB1M;
    }

    public void setDimB1M(int dimB1M) {
        this.dimB1M = dimB1M;
    }

    public int getDimB2M() {
        return dimB2M;
    }

    public void setDimB2M(int dimB2M) {
        this.dimB2M = dimB2M;
    }

    public int getDimB3M() {
        return dimB3M;
    }

    public void setDimB3M(int dimB3M) {
        this.dimB3M = dimB3M;
    }

    public int getDimB4M() {
        return dimB4M;
    }

    public void setDimB4M(int dimB4M) {
        this.dimB4M = dimB4M;
    }

    public int getDimB5M() {
        return dimB5M;
    }

    public void setDimB5M(int dimB5M) {
        this.dimB5M = dimB5M;
    }

    public int getDimB0M() {
        return dimB0M;
    }

    public void setDimB0M(int dimB0M) {
        this.dimB0M = dimB0M;
    }

    public int getDimC1M() {
        return dimC1M;
    }

    public void setDimC1M(int dimC1M) {
        this.dimC1M = dimC1M;
    }

    public int getDimC2M() {
        return dimC2M;
    }

    public void setDimC2M(int dimC2M) {
        this.dimC2M = dimC2M;
    }

    public int getDimC3M() {
        return dimC3M;
    }

    public void setDimC3M(int dimC3M) {
        this.dimC3M = dimC3M;
    }

    public int getDimC4M() {
        return dimC4M;
    }

    public void setDimC4M(int dimC4M) {
        this.dimC4M = dimC4M;
    }

    public int getDimC5M() {
        return dimC5M;
    }

    public void setDimC5M(int dimC5M) {
        this.dimC5M = dimC5M;
    }

    public int getDimC0M() {
        return dimC0M;
    }

    public void setDimC0M(int dimC0M) {
        this.dimC0M = dimC0M;
    }

    public int getDimD1M() {
        return dimD1M;
    }

    public void setDimD1M(int dimD1M) {
        this.dimD1M = dimD1M;
    }

    public int getDimD2M() {
        return dimD2M;
    }

    public void setDimD2M(int dimD2M) {
        this.dimD2M = dimD2M;
    }

    public int getDimD3M() {
        return dimD3M;
    }

    public void setDimD3M(int dimD3M) {
        this.dimD3M = dimD3M;
    }

    public int getDimD4M() {
        return dimD4M;
    }

    public void setDimD4M(int dimD4M) {
        this.dimD4M = dimD4M;
    }

    public int getDimD5M() {
        return dimD5M;
    }

    public void setDimD5M(int dimD5M) {
        this.dimD5M = dimD5M;
    }

    public int getDimD0M() {
        return dimD0M;
    }

    public void setDimD0M(int dimD0M) {
        this.dimD0M = dimD0M;
    }

    public int getDimA1I() {
        return dimA1I;
    }

    public void setDimA1I(int dimA1I) {
        this.dimA1I = dimA1I;
    }

    public int getDimA2I() {
        return dimA2I;
    }

    public void setDimA2I(int dimA2I) {
        this.dimA2I = dimA2I;
    }

    public int getDimA3I() {
        return dimA3I;
    }

    public void setDimA3I(int dimA3I) {
        this.dimA3I = dimA3I;
    }

    public int getDimA4I() {
        return dimA4I;
    }

    public void setDimA4I(int dimA4I) {
        this.dimA4I = dimA4I;
    }

    public int getDimA5I() {
        return dimA5I;
    }

    public void setDimA5I(int dimA5I) {
        this.dimA5I = dimA5I;
    }

    public int getDimA0I() {
        return dimA0I;
    }

    public void setDimA0I(int dimA0I) {
        this.dimA0I = dimA0I;
    }

    public int getDimB1I() {
        return dimB1I;
    }

    public void setDimB1I(int dimB1I) {
        this.dimB1I = dimB1I;
    }

    public int getDimB2I() {
        return dimB2I;
    }

    public void setDimB2I(int dimB2I) {
        this.dimB2I = dimB2I;
    }

    public int getDimB3I() {
        return dimB3I;
    }

    public void setDimB3I(int dimB3I) {
        this.dimB3I = dimB3I;
    }

    public int getDimB4I() {
        return dimB4I;
    }

    public void setDimB4I(int dimB4I) {
        this.dimB4I = dimB4I;
    }

    public int getDimB5I() {
        return dimB5I;
    }

    public void setDimB5I(int dimB5I) {
        this.dimB5I = dimB5I;
    }

    public int getDimB0I() {
        return dimB0I;
    }

    public void setDimB0I(int dimB0I) {
        this.dimB0I = dimB0I;
    }

    public int getDimC1I() {
        return dimC1I;
    }

    public void setDimC1I(int dimC1I) {
        this.dimC1I = dimC1I;
    }

    public int getDimC2I() {
        return dimC2I;
    }

    public void setDimC2I(int dimC2I) {
        this.dimC2I = dimC2I;
    }

    public int getDimC3I() {
        return dimC3I;
    }

    public void setDimC3I(int dimC3I) {
        this.dimC3I = dimC3I;
    }

    public int getDimC4I() {
        return dimC4I;
    }

    public void setDimC4I(int dimC4I) {
        this.dimC4I = dimC4I;
    }

    public int getDimC5I() {
        return dimC5I;
    }

    public void setDimC5I(int dimC5I) {
        this.dimC5I = dimC5I;
    }

    public int getDimC0I() {
        return dimC0I;
    }

    public void setDimC0I(int dimC0I) {
        this.dimC0I = dimC0I;
    }

    public int getDimD1I() {
        return dimD1I;
    }

    public void setDimD1I(int dimD1I) {
        this.dimD1I = dimD1I;
    }

    public int getDimD2I() {
        return dimD2I;
    }

    public void setDimD2I(int dimD2I) {
        this.dimD2I = dimD2I;
    }

    public int getDimD3I() {
        return dimD3I;
    }

    public void setDimD3I(int dimD3I) {
        this.dimD3I = dimD3I;
    }

    public int getDimD4I() {
        return dimD4I;
    }

    public void setDimD4I(int dimD4I) {
        this.dimD4I = dimD4I;
    }

    public int getDimD5I() {
        return dimD5I;
    }

    public void setDimD5I(int dimD5I) {
        this.dimD5I = dimD5I;
    }

    public int getDimD0I() {
        return dimD0I;
    }

    public void setDimD0I(int dimD0I) {
        this.dimD0I = dimD0I;
    }

    public int getStartCol() {
        return startCol;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }

    public int getEndCol() {
        return endCol;
    }

    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getBaseUOM() {
        return baseUOM;
    }

    public void setBaseUOM(int baseUOM) {
        this.baseUOM = baseUOM;
    }

    public BigDecimal getRadius1() {
        return radius1;
    }

    public void setRadius1(BigDecimal radius1) {
        this.radius1 = radius1;
    }

    public BigDecimal getRadius2() {
        return radius2;
    }

    public void setRadius2(BigDecimal radius2) {
        this.radius2 = radius2;
    }

    public BigDecimal getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(BigDecimal startAngle) {
        this.startAngle = startAngle;
    }

    public BigDecimal getEndAngle() {
        return endAngle;
    }

    public void setEndAngle(BigDecimal endAngle) {
        this.endAngle = endAngle;
    }

    public BigDecimal getCentralAngle() {
        return centralAngle;
    }

    public void setCentralAngle(BigDecimal centralAngle) {
        this.centralAngle = centralAngle;
    }

    public BigDecimal getOriginalScaleM() {
        return originalScaleM;
    }

    public void setOriginalScaleM(BigDecimal originalScaleM) {
        this.originalScaleM = originalScaleM;
    }

    public BigDecimal getOriginalScaleI() {
        return originalScaleI;
    }

    public void setOriginalScaleI(BigDecimal originalScaleI) {
        this.originalScaleI = originalScaleI;
    }

    public BigDecimal getRadius1A() {
        return radius1A;
    }

    public void setRadius1A(BigDecimal radius1A) {
        this.radius1A = radius1A;
    }

    public BigDecimal getRadius2A() {
        return radius2A;
    }

    public void setRadius2A(BigDecimal radius2A) {
        this.radius2A = radius2A;
    }

    public BigDecimal getStartAngleA() {
        return startAngleA;
    }

    public void setStartAngleA(BigDecimal startAngleA) {
        this.startAngleA = startAngleA;
    }

    public BigDecimal getEndAngleA() {
        return endAngleA;
    }

    public void setEndAngleA(BigDecimal endAngleA) {
        this.endAngleA = endAngleA;
    }

    public BigDecimal getCentralAngleA() {
        return centralAngleA;
    }

    public void setCentralAngleA(BigDecimal centralAngleA) {
        this.centralAngleA = centralAngleA;
    }

    public BigDecimal getClearanceTop() {
        return clearanceTop;
    }

    public void setClearanceTop(BigDecimal clearanceTop) {
        this.clearanceTop = clearanceTop;
    }

    public BigDecimal getClearanceBot() {
        return clearanceBot;
    }

    public void setClearanceBot(BigDecimal clearanceBot) {
        this.clearanceBot = clearanceBot;
    }

    public BigDecimal getClearanceLeft() {
        return clearanceLeft;
    }

    public void setClearanceLeft(BigDecimal clearanceLeft) {
        this.clearanceLeft = clearanceLeft;
    }

    public BigDecimal getClearanceRight() {
        return clearanceRight;
    }

    public void setClearanceRight(BigDecimal clearanceRight) {
        this.clearanceRight = clearanceRight;
    }

    public BigDecimal getScaleM() {
        return scaleM;
    }

    public void setScaleM(BigDecimal scaleM) {
        this.scaleM = scaleM;
    }

    public BigDecimal getScaleImp() {
        return scaleImp;
    }

    public void setScaleImp(BigDecimal scaleImp) {
        this.scaleImp = scaleImp;
    }

    public int getControlOpeningClassType() {
        return controlOpeningClassType;
    }

    public void setControlOpeningClassType(int controlOpeningClassType) {
        this.controlOpeningClassType = controlOpeningClassType;
    }

    public int getControlOpeningClass() {
        return controlOpeningClass;
    }

    public void setControlOpeningClass(int controlOpeningClass) {
        this.controlOpeningClass = controlOpeningClass;
    }

    public int getControlUserDefinedOpeningID() {
        return controlUserDefinedOpeningID;
    }

    public void setControlUserDefinedOpeningID(int controlUserDefinedOpeningID) {
        this.controlUserDefinedOpeningID = controlUserDefinedOpeningID;
    }

    public boolean isStdW() {
        return isStdW;
    }

    public void setStdW(boolean stdW) {
        isStdW = stdW;
    }

    public boolean isStdH() {
        return isStdH;
    }

    public void setStdH(boolean stdH) {
        isStdH = stdH;
    }

    public boolean isNewDesign() {
        return newDesign;
    }

    public void setNewDesign(boolean newDesign) {
        this.newDesign = newDesign;
    }

    public boolean isOpenOut() {
        return openOut;
    }

    public void setOpenOut(boolean openOut) {
        this.openOut = openOut;
    }

    public boolean isGlazedOut() {
        return glazedOut;
    }

    public void setGlazedOut(boolean glazedOut) {
        this.glazedOut = glazedOut;
    }

    public boolean isHasSash() {
        return hasSash;
    }

    public void setHasSash(boolean hasSash) {
        this.hasSash = hasSash;
    }

    public boolean isUnGlazed() {
        return unGlazed;
    }

    public void setUnGlazed(boolean unGlazed) {
        this.unGlazed = unGlazed;
    }

    public boolean isOpenIn() {
        return openIn;
    }

    public void setOpenIn(boolean openIn) {
        this.openIn = openIn;
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

    public boolean isAutoW() {
        return autoW;
    }

    public void setAutoW(boolean autoW) {
        this.autoW = autoW;
    }

    public boolean isAutoH() {
        return autoH;
    }

    public void setAutoH(boolean autoH) {
        this.autoH = autoH;
    }

    public BigDecimal getHighestX() {
        return highestX;
    }

    public void setHighestX(BigDecimal highestX) {
        this.highestX = highestX;
    }

    public BigDecimal getLowestX() {
        return lowestX;
    }

    public void setLowestX(BigDecimal lowestX) {
        this.lowestX = lowestX;
    }

    public BigDecimal getHighestY() {
        return highestY;
    }

    public void setHighestY(BigDecimal highestY) {
        this.highestY = highestY;
    }

    public BigDecimal getLowestY() {
        return lowestY;
    }

    public void setLowestY(BigDecimal lowestY) {
        this.lowestY = lowestY;
    }

    public BigDecimal getHighestYC() {
        return highestYC;
    }

    public void setHighestYC(BigDecimal highestYC) {
        this.highestYC = highestYC;
    }

    public BigDecimal getLowestYC() {
        return lowestYC;
    }

    public void setLowestYC(BigDecimal lowestYC) {
        this.lowestYC = lowestYC;
    }

    public BigDecimal getMyScale() {
        return myScale;
    }

    public void setMyScale(BigDecimal myScale) {
        this.myScale = myScale;
    }

    public BigDecimal getBkgrdStartX() {
        return bkgrdStartX;
    }

    public void setBkgrdStartX(BigDecimal bkgrdStartX) {
        this.bkgrdStartX = bkgrdStartX;
    }

    public BigDecimal getBkgrdStartY() {
        return bkgrdStartY;
    }

    public void setBkgrdStartY(BigDecimal bkgrdStartY) {
        this.bkgrdStartY = bkgrdStartY;
    }

    public BigDecimal getBkgrdStartXBA() {
        return bkgrdStartXBA;
    }

    public void setBkgrdStartXBA(BigDecimal bkgrdStartXBA) {
        this.bkgrdStartXBA = bkgrdStartXBA;
    }

    public BigDecimal getBkgrdStartYBA() {
        return bkgrdStartYBA;
    }

    public void setBkgrdStartYBA(BigDecimal bkgrdStartYBA) {
        this.bkgrdStartYBA = bkgrdStartYBA;
    }

    public BigDecimal getBkgrdStartXA() {
        return bkgrdStartXA;
    }

    public void setBkgrdStartXA(BigDecimal bkgrdStartXA) {
        this.bkgrdStartXA = bkgrdStartXA;
    }

    public BigDecimal getBkgrdStartYA() {
        return bkgrdStartYA;
    }

    public void setBkgrdStartYA(BigDecimal bkgrdStartYA) {
        this.bkgrdStartYA = bkgrdStartYA;
    }

    public BigDecimal getCenterPointX() {
        return centerPointX;
    }

    public void setCenterPointX(BigDecimal centerPointX) {
        this.centerPointX = centerPointX;
    }

    public BigDecimal getCenterPointY() {
        return centerPointY;
    }

    public void setCenterPointY(BigDecimal centerPointY) {
        this.centerPointY = centerPointY;
    }

    public BigDecimal getCenterPointX2() {
        return centerPointX2;
    }

    public void setCenterPointX2(BigDecimal centerPointX2) {
        this.centerPointX2 = centerPointX2;
    }

    public BigDecimal getCenterPointY2() {
        return centerPointY2;
    }

    public void setCenterPointY2(BigDecimal centerPointY2) {
        this.centerPointY2 = centerPointY2;
    }

    public int getOpeningID() {
        return openingID;
    }

    public void setOpeningID(int openingID) {
        this.openingID = openingID;
    }

    public BigDecimal getDimA1() {
        return dimA1;
    }

    public void setDimA1(BigDecimal dimA1) {
        this.dimA1 = dimA1;
    }

    public BigDecimal getDimA2() {
        return dimA2;
    }

    public void setDimA2(BigDecimal dimA2) {
        this.dimA2 = dimA2;
    }

    public BigDecimal getDimA3() {
        return dimA3;
    }

    public void setDimA3(BigDecimal dimA3) {
        this.dimA3 = dimA3;
    }

    public BigDecimal getDimA4() {
        return dimA4;
    }

    public void setDimA4(BigDecimal dimA4) {
        this.dimA4 = dimA4;
    }

    public BigDecimal getDimA5() {
        return dimA5;
    }

    public void setDimA5(BigDecimal dimA5) {
        this.dimA5 = dimA5;
    }

    public BigDecimal getDimA0() {
        return dimA0;
    }

    public void setDimA0(BigDecimal dimA0) {
        this.dimA0 = dimA0;
    }

    public BigDecimal getDimB1() {
        return dimB1;
    }

    public void setDimB1(BigDecimal dimB1) {
        this.dimB1 = dimB1;
    }

    public BigDecimal getDimB2() {
        return dimB2;
    }

    public void setDimB2(BigDecimal dimB2) {
        this.dimB2 = dimB2;
    }

    public BigDecimal getDimB3() {
        return dimB3;
    }

    public void setDimB3(BigDecimal dimB3) {
        this.dimB3 = dimB3;
    }

    public BigDecimal getDimB4() {
        return dimB4;
    }

    public void setDimB4(BigDecimal dimB4) {
        this.dimB4 = dimB4;
    }

    public BigDecimal getDimB5() {
        return dimB5;
    }

    public void setDimB5(BigDecimal dimB5) {
        this.dimB5 = dimB5;
    }

    public BigDecimal getDimB0() {
        return dimB0;
    }

    public void setDimB0(BigDecimal dimB0) {
        this.dimB0 = dimB0;
    }

    public BigDecimal getDimC1() {
        return dimC1;
    }

    public void setDimC1(BigDecimal dimC1) {
        this.dimC1 = dimC1;
    }

    public BigDecimal getDimC2() {
        return dimC2;
    }

    public void setDimC2(BigDecimal dimC2) {
        this.dimC2 = dimC2;
    }

    public BigDecimal getDimC3() {
        return dimC3;
    }

    public void setDimC3(BigDecimal dimC3) {
        this.dimC3 = dimC3;
    }

    public BigDecimal getDimC4() {
        return dimC4;
    }

    public void setDimC4(BigDecimal dimC4) {
        this.dimC4 = dimC4;
    }

    public BigDecimal getDimC5() {
        return dimC5;
    }

    public void setDimC5(BigDecimal dimC5) {
        this.dimC5 = dimC5;
    }

    public BigDecimal getDimC0() {
        return dimC0;
    }

    public void setDimC0(BigDecimal dimC0) {
        this.dimC0 = dimC0;
    }

    public BigDecimal getDimD1() {
        return dimD1;
    }

    public void setDimD1(BigDecimal dimD1) {
        this.dimD1 = dimD1;
    }

    public BigDecimal getDimD2() {
        return dimD2;
    }

    public void setDimD2(BigDecimal dimD2) {
        this.dimD2 = dimD2;
    }

    public BigDecimal getDimD3() {
        return dimD3;
    }

    public void setDimD3(BigDecimal dimD3) {
        this.dimD3 = dimD3;
    }

    public BigDecimal getDimD4() {
        return dimD4;
    }

    public void setDimD4(BigDecimal dimD4) {
        this.dimD4 = dimD4;
    }

    public BigDecimal getDimD5() {
        return dimD5;
    }

    public void setDimD5(BigDecimal dimD5) {
        this.dimD5 = dimD5;
    }

    public BigDecimal getDimD0() {
        return dimD0;
    }

    public void setDimD0(BigDecimal dimD0) {
        this.dimD0 = dimD0;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getStartingX() {
        return startingX;
    }

    public void setStartingX(BigDecimal startingX) {
        this.startingX = startingX;
    }

    public BigDecimal getStartingY() {
        return startingY;
    }

    public void setStartingY(BigDecimal startingY) {
        this.startingY = startingY;
    }

    public BigDecimal getbX2() {
        return bX2;
    }

    public void setbX2(BigDecimal bX2) {
        this.bX2 = bX2;
    }

    public BigDecimal getbY2() {
        return bY2;
    }

    public void setbY2(BigDecimal bY2) {
        this.bY2 = bY2;
    }

    public BigDecimal getbX3() {
        return bX3;
    }

    public void setbX3(BigDecimal bX3) {
        this.bX3 = bX3;
    }

    public BigDecimal getbY3() {
        return bY3;
    }

    public void setbY3(BigDecimal bY3) {
        this.bY3 = bY3;
    }

    public BigDecimal getbX4() {
        return bX4;
    }

    public void setbX4(BigDecimal bX4) {
        this.bX4 = bX4;
    }

    public BigDecimal getbY4() {
        return bY4;
    }

    public void setbY4(BigDecimal bY4) {
        this.bY4 = bY4;
    }

    public BigDecimal getStartingXBA() {
        return startingXBA;
    }

    public void setStartingXBA(BigDecimal startingXBA) {
        this.startingXBA = startingXBA;
    }

    public BigDecimal getStartingYBA() {
        return startingYBA;
    }

    public void setStartingYBA(BigDecimal startingYBA) {
        this.startingYBA = startingYBA;
    }

    public BigDecimal getbX2B() {
        return bX2B;
    }

    public void setbX2B(BigDecimal bX2B) {
        this.bX2B = bX2B;
    }

    public BigDecimal getbY2B() {
        return bY2B;
    }

    public void setbY2B(BigDecimal bY2B) {
        this.bY2B = bY2B;
    }

    public BigDecimal getbX3B() {
        return bX3B;
    }

    public void setbX3B(BigDecimal bX3B) {
        this.bX3B = bX3B;
    }

    public BigDecimal getbY3B() {
        return bY3B;
    }

    public void setbY3B(BigDecimal bY3B) {
        this.bY3B = bY3B;
    }

    public BigDecimal getbX4B() {
        return bX4B;
    }

    public void setbX4B(BigDecimal bX4B) {
        this.bX4B = bX4B;
    }

    public BigDecimal getbY4B() {
        return bY4B;
    }

    public void setbY4B(BigDecimal bY4B) {
        this.bY4B = bY4B;
    }

    public BigDecimal getStartingXA() {
        return startingXA;
    }

    public void setStartingXA(BigDecimal startingXA) {
        this.startingXA = startingXA;
    }

    public BigDecimal getStartingYA() {
        return startingYA;
    }

    public void setStartingYA(BigDecimal startingYA) {
        this.startingYA = startingYA;
    }

    public BigDecimal getbX2A() {
        return bX2A;
    }

    public void setbX2A(BigDecimal bX2A) {
        this.bX2A = bX2A;
    }

    public BigDecimal getbY2A() {
        return bY2A;
    }

    public void setbY2A(BigDecimal bY2A) {
        this.bY2A = bY2A;
    }

    public BigDecimal getbX3A() {
        return bX3A;
    }

    public void setbX3A(BigDecimal bX3A) {
        this.bX3A = bX3A;
    }

    public BigDecimal getbY3A() {
        return bY3A;
    }

    public void setbY3A(BigDecimal bY3A) {
        this.bY3A = bY3A;
    }

    public BigDecimal getbX4A() {
        return bX4A;
    }

    public void setbX4A(BigDecimal bX4A) {
        this.bX4A = bX4A;
    }

    public BigDecimal getbY4A() {
        return bY4A;
    }

    public void setbY4A(BigDecimal bY4A) {
        this.bY4A = bY4A;
    }

    public BigDecimal getStartingCX() {
        return startingCX;
    }

    public void setStartingCX(BigDecimal startingCX) {
        this.startingCX = startingCX;
    }

    public BigDecimal getStartingCY() {
        return startingCY;
    }

    public void setStartingCY(BigDecimal startingCY) {
        this.startingCY = startingCY;
    }

    public BigDecimal getbCX2() {
        return bCX2;
    }

    public void setbCX2(BigDecimal bCX2) {
        this.bCX2 = bCX2;
    }

    public BigDecimal getbCY2() {
        return bCY2;
    }

    public void setbCY2(BigDecimal bCY2) {
        this.bCY2 = bCY2;
    }

    public BigDecimal getbCX3() {
        return bCX3;
    }

    public void setbCX3(BigDecimal bCX3) {
        this.bCX3 = bCX3;
    }

    public BigDecimal getbCY3() {
        return bCY3;
    }

    public void setbCY3(BigDecimal bCY3) {
        this.bCY3 = bCY3;
    }

    public BigDecimal getbCX4() {
        return bCX4;
    }

    public void setbCX4(BigDecimal bCX4) {
        this.bCX4 = bCX4;
    }

    public BigDecimal getbCY4() {
        return bCY4;
    }

    public void setbCY4(BigDecimal bCY4) {
        this.bCY4 = bCY4;
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

    public boolean isWire() {
        return wire;
    }

    public void setWire(boolean wire) {
        this.wire = wire;
    }

    public int getContentIn() {
        return contentIn;
    }

    public void setContentIn(int contentIn) {
        this.contentIn = contentIn;
    }

    public int getContentMid() {
        return contentMid;
    }

    public void setContentMid(int contentMid) {
        this.contentMid = contentMid;
    }

    public int getContentOut() {
        return contentOut;
    }

    public void setContentOut(int contentOut) {
        this.contentOut = contentOut;
    }

    public BigDecimal getDimTM() {
        return dimTM;
    }

    public void setDimTM(BigDecimal dimTM) {
        this.dimTM = dimTM;
    }

    public BigDecimal getDimBM() {
        return dimBM;
    }

    public void setDimBM(BigDecimal dimBM) {
        this.dimBM = dimBM;
    }

    public BigDecimal getDimLM() {
        return dimLM;
    }

    public void setDimLM(BigDecimal dimLM) {
        this.dimLM = dimLM;
    }

    public BigDecimal getDimRM() {
        return dimRM;
    }

    public void setDimRM(BigDecimal dimRM) {
        this.dimRM = dimRM;
    }

    public BigDecimal getDimTA() {
        return dimTA;
    }

    public void setDimTA(BigDecimal dimTA) {
        this.dimTA = dimTA;
    }

    public BigDecimal getDimBA() {
        return dimBA;
    }

    public void setDimBA(BigDecimal dimBA) {
        this.dimBA = dimBA;
    }

    public BigDecimal getDimLA() {
        return dimLA;
    }

    public void setDimLA(BigDecimal dimLA) {
        this.dimLA = dimLA;
    }

    public BigDecimal getDimRA() {
        return dimRA;
    }

    public void setDimRA(BigDecimal dimRA) {
        this.dimRA = dimRA;
    }

    public BigDecimal getOpeningW() {
        return openingW;
    }

    public void setOpeningW(BigDecimal openingW) {
        this.openingW = openingW;
    }

    public BigDecimal getOpeningH() {
        return openingH;
    }

    public void setOpeningH(BigDecimal openingH) {
        this.openingH = openingH;
    }

    public BigDecimal getOpeningWc() {
        return openingWc;
    }

    public void setOpeningWc(BigDecimal openingWc) {
        this.openingWc = openingWc;
    }

    public BigDecimal getOpeningHc() {
        return openingHc;
    }

    public void setOpeningHc(BigDecimal openingHc) {
        this.openingHc = openingHc;
    }

    public BigDecimal getOpeningWB() {
        return openingWB;
    }

    public void setOpeningWB(BigDecimal openingWB) {
        this.openingWB = openingWB;
    }

    public BigDecimal getOpeningHR() {
        return openingHR;
    }

    public void setOpeningHR(BigDecimal openingHR) {
        this.openingHR = openingHR;
    }

    public BigDecimal getOpeningWcB() {
        return openingWcB;
    }

    public void setOpeningWcB(BigDecimal openingWcB) {
        this.openingWcB = openingWcB;
    }

    public BigDecimal getOpeningHcR() {
        return openingHcR;
    }

    public void setOpeningHcR(BigDecimal openingHcR) {
        this.openingHcR = openingHcR;
    }

    public BigDecimal getOpeningWA() {
        return openingWA;
    }

    public void setOpeningWA(BigDecimal openingWA) {
        this.openingWA = openingWA;
    }

    public BigDecimal getOpeningHA() {
        return openingHA;
    }

    public void setOpeningHA(BigDecimal openingHA) {
        this.openingHA = openingHA;
    }

    public BigDecimal getOpeningWBA() {
        return openingWBA;
    }

    public void setOpeningWBA(BigDecimal openingWBA) {
        this.openingWBA = openingWBA;
    }

    public BigDecimal getOpeningHRA() {
        return openingHRA;
    }

    public void setOpeningHRA(BigDecimal openingHRA) {
        this.openingHRA = openingHRA;
    }

    public int getWidthMN() {
        return widthMN;
    }

    public void setWidthMN(int widthMN) {
        this.widthMN = widthMN;
    }

    public int getHeightMN() {
        return heightMN;
    }

    public void setHeightMN(int heightMN) {
        this.heightMN = heightMN;
    }

    public int getWidthIN() {
        return widthIN;
    }

    public void setWidthIN(int widthIN) {
        this.widthIN = widthIN;
    }

    public int getHeightIN() {
        return heightIN;
    }

    public void setHeightIN(int heightIN) {
        this.heightIN = heightIN;
    }

    public BigDecimal getPx1() {
        return px1;
    }

    public void setPx1(BigDecimal px1) {
        this.px1 = px1;
    }

    public BigDecimal getPy1() {
        return py1;
    }

    public void setPy1(BigDecimal py1) {
        this.py1 = py1;
    }

    public BigDecimal getPx2() {
        return px2;
    }

    public void setPx2(BigDecimal px2) {
        this.px2 = px2;
    }

    public BigDecimal getPy2() {
        return py2;
    }

    public void setPy2(BigDecimal py2) {
        this.py2 = py2;
    }

    public BigDecimal getPx3() {
        return px3;
    }

    public void setPx3(BigDecimal px3) {
        this.px3 = px3;
    }

    public BigDecimal getPy3() {
        return py3;
    }

    public void setPy3(BigDecimal py3) {
        this.py3 = py3;
    }

    public BigDecimal getPx4() {
        return px4;
    }

    public void setPx4(BigDecimal px4) {
        this.px4 = px4;
    }

    public BigDecimal getPy4() {
        return py4;
    }

    public void setPy4(BigDecimal py4) {
        this.py4 = py4;
    }

    public BigDecimal getPx5() {
        return px5;
    }

    public void setPx5(BigDecimal px5) {
        this.px5 = px5;
    }

    public BigDecimal getPy5() {
        return py5;
    }

    public void setPy5(BigDecimal py5) {
        this.py5 = py5;
    }

    public BigDecimal getPx6() {
        return px6;
    }

    public void setPx6(BigDecimal px6) {
        this.px6 = px6;
    }

    public BigDecimal getPy6() {
        return py6;
    }

    public void setPy6(BigDecimal py6) {
        this.py6 = py6;
    }

    public BigDecimal getPx7() {
        return px7;
    }

    public void setPx7(BigDecimal px7) {
        this.px7 = px7;
    }

    public BigDecimal getPy7() {
        return py7;
    }

    public void setPy7(BigDecimal py7) {
        this.py7 = py7;
    }

    public BigDecimal getPx8() {
        return px8;
    }

    public void setPx8(BigDecimal px8) {
        this.px8 = px8;
    }

    public BigDecimal getPy8() {
        return py8;
    }

    public void setPy8(BigDecimal py8) {
        this.py8 = py8;
    }

    public BigDecimal getPx1A() {
        return px1A;
    }

    public void setPx1A(BigDecimal px1A) {
        this.px1A = px1A;
    }

    public BigDecimal getPy1A() {
        return py1A;
    }

    public void setPy1A(BigDecimal py1A) {
        this.py1A = py1A;
    }

    public BigDecimal getPx2A() {
        return px2A;
    }

    public void setPx2A(BigDecimal px2A) {
        this.px2A = px2A;
    }

    public BigDecimal getPy2A() {
        return py2A;
    }

    public void setPy2A(BigDecimal py2A) {
        this.py2A = py2A;
    }

    public BigDecimal getPx3A() {
        return px3A;
    }

    public void setPx3A(BigDecimal px3A) {
        this.px3A = px3A;
    }

    public BigDecimal getPy3A() {
        return py3A;
    }

    public void setPy3A(BigDecimal py3A) {
        this.py3A = py3A;
    }

    public BigDecimal getPx4A() {
        return px4A;
    }

    public void setPx4A(BigDecimal px4A) {
        this.px4A = px4A;
    }

    public BigDecimal getPy4A() {
        return py4A;
    }

    public void setPy4A(BigDecimal py4A) {
        this.py4A = py4A;
    }

    public BigDecimal getPx5A() {
        return px5A;
    }

    public void setPx5A(BigDecimal px5A) {
        this.px5A = px5A;
    }

    public BigDecimal getPy5A() {
        return py5A;
    }

    public void setPy5A(BigDecimal py5A) {
        this.py5A = py5A;
    }

    public BigDecimal getPx6A() {
        return px6A;
    }

    public void setPx6A(BigDecimal px6A) {
        this.px6A = px6A;
    }

    public BigDecimal getPy6A() {
        return py6A;
    }

    public void setPy6A(BigDecimal py6A) {
        this.py6A = py6A;
    }

    public BigDecimal getPx7A() {
        return px7A;
    }

    public void setPx7A(BigDecimal px7A) {
        this.px7A = px7A;
    }

    public BigDecimal getPy7A() {
        return py7A;
    }

    public void setPy7A(BigDecimal py7A) {
        this.py7A = py7A;
    }

    public BigDecimal getPx8A() {
        return px8A;
    }

    public void setPx8A(BigDecimal px8A) {
        this.px8A = px8A;
    }

    public BigDecimal getPy8A() {
        return py8A;
    }

    public void setPy8A(BigDecimal py8A) {
        this.py8A = py8A;
    }

    public BigDecimal getPx1c() {
        return px1c;
    }

    public void setPx1c(BigDecimal px1c) {
        this.px1c = px1c;
    }

    public BigDecimal getPy1c() {
        return py1c;
    }

    public void setPy1c(BigDecimal py1c) {
        this.py1c = py1c;
    }

    public BigDecimal getPx2c() {
        return px2c;
    }

    public void setPx2c(BigDecimal px2c) {
        this.px2c = px2c;
    }

    public BigDecimal getPy2c() {
        return py2c;
    }

    public void setPy2c(BigDecimal py2c) {
        this.py2c = py2c;
    }

    public BigDecimal getPx3c() {
        return px3c;
    }

    public void setPx3c(BigDecimal px3c) {
        this.px3c = px3c;
    }

    public BigDecimal getPy3c() {
        return py3c;
    }

    public void setPy3c(BigDecimal py3c) {
        this.py3c = py3c;
    }

    public BigDecimal getPx4c() {
        return px4c;
    }

    public void setPx4c(BigDecimal px4c) {
        this.px4c = px4c;
    }

    public BigDecimal getPy4c() {
        return py4c;
    }

    public void setPy4c(BigDecimal py4c) {
        this.py4c = py4c;
    }

    public BigDecimal getPx5c() {
        return px5c;
    }

    public void setPx5c(BigDecimal px5c) {
        this.px5c = px5c;
    }

    public BigDecimal getPy5c() {
        return py5c;
    }

    public void setPy5c(BigDecimal py5c) {
        this.py5c = py5c;
    }

    public BigDecimal getPx6c() {
        return px6c;
    }

    public void setPx6c(BigDecimal px6c) {
        this.px6c = px6c;
    }

    public BigDecimal getPy6c() {
        return py6c;
    }

    public void setPy6c(BigDecimal py6c) {
        this.py6c = py6c;
    }

    public BigDecimal getPx7c() {
        return px7c;
    }

    public void setPx7c(BigDecimal px7c) {
        this.px7c = px7c;
    }

    public BigDecimal getPy7c() {
        return py7c;
    }

    public void setPy7c(BigDecimal py7c) {
        this.py7c = py7c;
    }

    public BigDecimal getPx8c() {
        return px8c;
    }

    public void setPx8c(BigDecimal px8c) {
        this.px8c = px8c;
    }

    public BigDecimal getPy8c() {
        return py8c;
    }

    public void setPy8c(BigDecimal py8c) {
        this.py8c = py8c;
    }

    public int getSupplierRemoteId() {
        return supplierRemoteId;
    }

    public void setSupplierRemoteId(int supplierRemoteId) {
        this.supplierRemoteId = supplierRemoteId;
    }

    public int getSupplierSeriesId() {
        return supplierSeriesId;
    }

    public void setSupplierSeriesId(int supplierSeriesId) {
        this.supplierSeriesId = supplierSeriesId;
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

    public Set<ProfileCollectionObject> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Set<ProfileCollectionObject> profileCollection) {
        this.profileCollection = profileCollection;
    }

    public Set<ProfileEntityBOM> getProfileBOMs() {
        return profileBOMs;
    }

    public void setProfileBOMs(Set<ProfileEntityBOM> profileBOMs) {
        this.profileBOMs = profileBOMs;
    }

    public Set<ProfileMyMullionObject> getMyMullions() {
        return myMullions;
    }

    public void setMyMullions(Set<ProfileMyMullionObject> myMullions) {
        this.myMullions = myMullions;
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
