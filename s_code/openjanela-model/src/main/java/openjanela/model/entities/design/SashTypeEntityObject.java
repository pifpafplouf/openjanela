package openjanela.model.entities.design;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-13-12
 *          Time: 12:07 AM
 */
public class SashTypeEntityObject extends ShapeAbstractObject {

    //Serializable version
    private static final long serialVersionUID = -1960643349495426403L;

    private int sashType = 0;
    private int sashID = 0;
    private int stdLouvreSizeM = 0;
    private int stdLouvreSizeI = 0;
    private int louvreOverlapM = 0;
    private int louvreOverlapI = 0;
    private boolean louvrePartial = true;
    private boolean isGlazed = false;
    
    private int noOfLeafs = 0;
    private int whichPos = 0;
    private int opens = 0;
    private int productType = 0;

    private boolean isOriel = false;

    private boolean[] sashGlazedOut;

    private int[] sashOnTrack;
    private int[] paneType;
    private int[] interLocks;

    private BigDecimal split = new BigDecimal("0");
    private BigDecimal percentA = new BigDecimal("0");
    private BigDecimal percentB = new BigDecimal("0");
    private BigDecimal percentC = new BigDecimal("0");
    private BigDecimal extraExtend = new BigDecimal("0");

    /**
     * Bkgrd Opening entity object
     */
    private BkgrdOpeningEntityObject bkgrdOpening;
    /**
     * Opening collection objects
     */
    private Set<OpeningEntityObject> openings;
    /**
     * Sash leafs collection objects
     */
    private Set<SashLeafEntityObject> sashLeafes;

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public int getSashType() {
        return sashType;
    }

    public void setSashType(int sashType) {
        this.sashType = sashType;
    }

    public int getSashID() {
        return sashID;
    }

    public void setSashID(int sashID) {
        this.sashID = sashID;
    }

    public int getStdLouvreSizeM() {
        return stdLouvreSizeM;
    }

    public void setStdLouvreSizeM(int stdLouvreSizeM) {
        this.stdLouvreSizeM = stdLouvreSizeM;
    }

    public int getStdLouvreSizeI() {
        return stdLouvreSizeI;
    }

    public void setStdLouvreSizeI(int stdLouvreSizeI) {
        this.stdLouvreSizeI = stdLouvreSizeI;
    }

    public int getLouvreOverlapM() {
        return louvreOverlapM;
    }

    public void setLouvreOverlapM(int louvreOverlapM) {
        this.louvreOverlapM = louvreOverlapM;
    }

    public int getLouvreOverlapI() {
        return louvreOverlapI;
    }

    public void setLouvreOverlapI(int louvreOverlapI) {
        this.louvreOverlapI = louvreOverlapI;
    }

    public int getNoOfLeafs() {
        return noOfLeafs;
    }

    public void setNoOfLeafs(int noOfLeafs) {
        this.noOfLeafs = noOfLeafs;
    }

    public int getWhichPos() {
        return whichPos;
    }

    public void setWhichPos(int whichPos) {
        this.whichPos = whichPos;
    }

    public int getOpens() {
        return opens;
    }

    public void setOpens(int opens) {
        this.opens = opens;
    }

    public boolean isOriel() {
        return isOriel;
    }

    public void setOriel(boolean oriel) {
        isOriel = oriel;
    }

    public BigDecimal getSplit() {
        return split;
    }

    public void setSplit(BigDecimal split) {
        this.split = split;
    }

    public BigDecimal getPercentA() {
        return percentA;
    }

    public void setPercentA(BigDecimal percentA) {
        this.percentA = percentA;
    }

    public BigDecimal getPercentB() {
        return percentB;
    }

    public void setPercentB(BigDecimal percentB) {
        this.percentB = percentB;
    }

    public BigDecimal getPercentC() {
        return percentC;
    }

    public void setPercentC(BigDecimal percentC) {
        this.percentC = percentC;
    }

    public BigDecimal getExtraExtend() {
        return extraExtend;
    }

    public void setExtraExtend(BigDecimal extraExtend) {
        this.extraExtend = extraExtend;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public boolean[] getSashGlazedOut() {
        return sashGlazedOut;
    }

    public void setSashGlazedOut(boolean[] sashGlazedOut) {
        this.sashGlazedOut = sashGlazedOut;
    }

    public int[] getSashOnTrack() {
        return sashOnTrack;
    }

    public void setSashOnTrack(int[] sashOnTrack) {
        this.sashOnTrack = sashOnTrack;
    }

    public int[] getPaneType() {
        return paneType;
    }

    public void setPaneType(int[] paneType) {
        this.paneType = paneType;
    }

    public int[] getInterLocks() {
        return interLocks;
    }

    public void setInterLocks(int[] interLocks) {
        this.interLocks = interLocks;
    }

    public BkgrdOpeningEntityObject getBkgrdOpening() {
        return bkgrdOpening;
    }

    public void setBkgrdOpening(BkgrdOpeningEntityObject bkgrdOpening) {
        this.bkgrdOpening = bkgrdOpening;
    }

    public Set<OpeningEntityObject> getOpenings() {
        return openings;
    }

    public void setOpenings(Set<OpeningEntityObject> openings) {
        this.openings = openings;
    }

    public Set<SashLeafEntityObject> getSashLeafes() {
        return sashLeafes;
    }

    public void setSashLeafes(Set<SashLeafEntityObject> sashLeafes) {
        this.sashLeafes = sashLeafes;
    }

	public boolean isLouvrePartial() {
		return louvrePartial;
	}

	public void setLouvrePartial(boolean louvrePartial) {
		this.louvrePartial = louvrePartial;
	}

	public boolean isGlazed() {
		return isGlazed;
	}

	public void setGlazed(boolean isGlazed) {
		this.isGlazed = isGlazed;
	}
}
