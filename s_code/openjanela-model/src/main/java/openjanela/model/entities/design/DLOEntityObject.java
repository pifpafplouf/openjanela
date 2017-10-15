package openjanela.model.entities.design;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-13-12
 *          Time: 12:12 AM
 */
public class DLOEntityObject extends ShapeAbstractObject {

    //Serializable Version
    private static final long serialVersionUID = -2659659856715439159L;

    private BigDecimal msx = new BigDecimal("0");
    private BigDecimal mex = new BigDecimal("0");
    private BigDecimal msy = new BigDecimal("0");
    private BigDecimal mey = new BigDecimal("0");
    private boolean masterW = false;
    private boolean masterH = false;
    private int gridID = 0;
    private int gridType = 0;
    private int gridForm = 0;
    private BigDecimal gridThick = new BigDecimal("0");
    private int continuity = 0;
    private BigDecimal idealGW = new BigDecimal("0");
    private BigDecimal idealGH = new BigDecimal("0");
    private BigDecimal maxGW = new BigDecimal("0");
    private BigDecimal maxGH = new BigDecimal("0");
    private BigDecimal minGW = new BigDecimal("0");
    private BigDecimal minGH = new BigDecimal("0");
    private BigDecimal gridRemovalZoneW = new BigDecimal("0");
    private BigDecimal gridRemovalZoneH = new BigDecimal("0");
    private BigDecimal liteW = new BigDecimal("0");
    private BigDecimal liteH = new BigDecimal("0");
    private BigDecimal perimeterV = new BigDecimal("0");
    private BigDecimal perimeterH = new BigDecimal("0");
    private int noGridsW = 0;
    private int noGridsH = 0;
    private int noGridsS = 0;
    private int noGridsR = 0;
    private int lastNVGrid = 0;
    private int lastNHGrid = 0;
    private int lastNSGrid = 0;
    private boolean hasGrids = false;

    /**
     * Bkgrd Opening Entity Object relationship
     */
    private BkgrdOpeningEntityObject bkgrdOpening;

    /**
     * Opening Entity Object relationship
     */
    private OpeningEntityObject opening;

    /**
     * Collection Profile Grids construction
     */
    private Set<ProfileGridObject> grids;

    /**
     * Collection Profile Grids spoke construction
     */
    private Set<ProfileGridSpokeObject> gridsSpokes;

    /**
     * Collection Profile Grid mask construction
     */
    private Set<ProfileGridMaskObject> gridsMask;

    /**
     * Collection Opening Entity Object
     */
    private Set<OpeningEntityObject> openings;

    /**
     * Collection Anchors Grid
     */
    private Set<AnchorsGrid> anchorsGrids;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public BigDecimal getMsx() {
        return msx;
    }

    public void setMsx(BigDecimal msx) {
        this.msx = msx;
    }

    public BigDecimal getMex() {
        return mex;
    }

    public void setMex(BigDecimal mex) {
        this.mex = mex;
    }

    public BigDecimal getMsy() {
        return msy;
    }

    public void setMsy(BigDecimal msy) {
        this.msy = msy;
    }

    public BigDecimal getMey() {
        return mey;
    }

    public void setMey(BigDecimal mey) {
        this.mey = mey;
    }

    public boolean isMasterW() {
        return masterW;
    }

    public void setMasterW(boolean masterW) {
        this.masterW = masterW;
    }

    public boolean isMasterH() {
        return masterH;
    }

    public void setMasterH(boolean masterH) {
        this.masterH = masterH;
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

    public BigDecimal getGridThick() {
        return gridThick;
    }

    public void setGridThick(BigDecimal gridThick) {
        this.gridThick = gridThick;
    }

    public int getContinuity() {
        return continuity;
    }

    public void setContinuity(int continuity) {
        this.continuity = continuity;
    }

    public BigDecimal getIdealGW() {
        return idealGW;
    }

    public void setIdealGW(BigDecimal idealGW) {
        this.idealGW = idealGW;
    }

    public BigDecimal getIdealGH() {
        return idealGH;
    }

    public void setIdealGH(BigDecimal idealGH) {
        this.idealGH = idealGH;
    }

    public BigDecimal getMaxGW() {
        return maxGW;
    }

    public void setMaxGW(BigDecimal maxGW) {
        this.maxGW = maxGW;
    }

    public BigDecimal getMaxGH() {
        return maxGH;
    }

    public void setMaxGH(BigDecimal maxGH) {
        this.maxGH = maxGH;
    }

    public BigDecimal getMinGW() {
        return minGW;
    }

    public void setMinGW(BigDecimal minGW) {
        this.minGW = minGW;
    }

    public BigDecimal getMinGH() {
        return minGH;
    }

    public void setMinGH(BigDecimal minGH) {
        this.minGH = minGH;
    }

    public BigDecimal getGridRemovalZoneW() {
        return gridRemovalZoneW;
    }

    public void setGridRemovalZoneW(BigDecimal gridRemovalZoneW) {
        this.gridRemovalZoneW = gridRemovalZoneW;
    }

    public BigDecimal getGridRemovalZoneH() {
        return gridRemovalZoneH;
    }

    public void setGridRemovalZoneH(BigDecimal gridRemovalZoneH) {
        this.gridRemovalZoneH = gridRemovalZoneH;
    }

    public BigDecimal getLiteW() {
        return liteW;
    }

    public void setLiteW(BigDecimal liteW) {
        this.liteW = liteW;
    }

    public BigDecimal getLiteH() {
        return liteH;
    }

    public void setLiteH(BigDecimal liteH) {
        this.liteH = liteH;
    }

    public BigDecimal getPerimeterV() {
        return perimeterV;
    }

    public void setPerimeterV(BigDecimal perimeterV) {
        this.perimeterV = perimeterV;
    }

    public BigDecimal getPerimeterH() {
        return perimeterH;
    }

    public void setPerimeterH(BigDecimal perimeterH) {
        this.perimeterH = perimeterH;
    }

    public int getNoGridsW() {
        return noGridsW;
    }

    public void setNoGridsW(int noGridsW) {
        this.noGridsW = noGridsW;
    }

    public int getNoGridsH() {
        return noGridsH;
    }

    public void setNoGridsH(int noGridsH) {
        this.noGridsH = noGridsH;
    }

    public int getNoGridsS() {
        return noGridsS;
    }

    public void setNoGridsS(int noGridsS) {
        this.noGridsS = noGridsS;
    }

    public int getNoGridsR() {
        return noGridsR;
    }

    public void setNoGridsR(int noGridsR) {
        this.noGridsR = noGridsR;
    }

    public int getLastNVGrid() {
        return lastNVGrid;
    }

    public void setLastNVGrid(int lastNVGrid) {
        this.lastNVGrid = lastNVGrid;
    }

    public int getLastNHGrid() {
        return lastNHGrid;
    }

    public void setLastNHGrid(int lastNHGrid) {
        this.lastNHGrid = lastNHGrid;
    }

    public int getLastNSGrid() {
        return lastNSGrid;
    }

    public void setLastNSGrid(int lastNSGrid) {
        this.lastNSGrid = lastNSGrid;
    }

    public boolean isHasGrids() {
        return hasGrids;
    }

    public void setHasGrids(boolean hasGrids) {
        this.hasGrids = hasGrids;
    }

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public OpeningEntityObject getOpening() {
        return opening;
    }

    public void setOpening(OpeningEntityObject opening) {
        this.opening = opening;
    }

    public Set<ProfileGridObject> getGrids() {
        return grids;
    }

    public void setGrids(Set<ProfileGridObject> grids) {
        this.grids = grids;
    }

    public Set<ProfileGridMaskObject> getGridsMask() {
        return gridsMask;
    }

    public void setGridsMask(Set<ProfileGridMaskObject> gridsMask) {
        this.gridsMask = gridsMask;
    }

    public Set<ProfileGridSpokeObject> getGridsSpokes() {
        return gridsSpokes;
    }

    public void setGridsSpokes(Set<ProfileGridSpokeObject> gridsSpokes) {
        this.gridsSpokes = gridsSpokes;
    }

    public Set<OpeningEntityObject> getOpenings() {
        return openings;
    }

    public void setOpenings(Set<OpeningEntityObject> openings) {
        this.openings = openings;
    }

    public Set<AnchorsGrid> getAnchorsGrids() {
        return anchorsGrids;
    }

    public void setAnchorsGrids(Set<AnchorsGrid> anchorsGrids) {
        this.anchorsGrids = anchorsGrids;
    }

}
